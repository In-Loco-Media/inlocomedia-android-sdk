package com.inlocomedia.maps.sample;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

import in.ubee.api.Ubee;
import in.ubee.api.UbeeOptions;
import in.ubee.api.communication.listeners.RetailsRequestListener;
import in.ubee.api.exception.UbeeAPIException;
import in.ubee.api.location.LocationError;
import in.ubee.api.location.OnLocationListener;
import in.ubee.api.maps.MapViewLoadListener;
import in.ubee.api.maps.views.IndoorMapView;
import in.ubee.models.Retail;
import in.ubee.models.RetailMap;

public class MainActivity extends Activity implements View.OnClickListener {
    static final String TAG = "InLocoMedia";
    private IndoorMapView mIndoorMapView;
    private ImageButton mNextFloorButton;
    private ImageButton mPreviousFloorButton;
    private OnLocationListener mLocationListener;
    private TextView mLabel;

    /**
     * Set your key and secret if you want to test your maps on this project
     */
    private final static String MAPS_KEY = "4dbf36ace426cec4353900630b06c572d7b416bd23f7ba4aae0f2842e8ea1e38";
    private final static String MAPS_SECRET = "795931ff8c1344c2656416f157f99c858391fe8d003bf1e994f4176537f79af9";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * Initializating InLocoMedia SDK
         */

        UbeeOptions options = UbeeOptions.getInstance(this);
        options.setLogEnabled(true);
        options.setMapsKey(MAPS_KEY, MAPS_SECRET);
        Ubee.init(this, options);


        /**
         * Instantiating the layout's views
         */
        mIndoorMapView = (IndoorMapView) findViewById(R.id.indoor_map_view);

        /**
         * This options aren't required. By default all values are true.
         */
        IndoorMapView.Options mapOptions = IndoorMapView.Options.defaultOptions();

        mapOptions.setRouteEnabled(true);
        mapOptions.setUserInteractionEnabled(true);
        mapOptions.setZoomEnabled(true);
        mapOptions.setTranslationEnabled(true);
        mIndoorMapView.setOptions(new IndoorMapView.Options());

        mLabel = (TextView) findViewById(R.id.label);
        mPreviousFloorButton = (ImageButton) this.findViewById(R.id.previous_floor);
        mNextFloorButton = (ImageButton) this.findViewById(R.id.next_floor);
        mNextFloorButton.setEnabled(mIndoorMapView.hasNextFloor());
        mPreviousFloorButton.setEnabled(mIndoorMapView.hasPreviousFloor());

        /**
         * Instantiating the listener to receive the location updates
         */
        mLocationListener = new OnLocationListener() {

            @Override
            public void onLocationChanged(in.ubee.api.models.Location location) {
                mIndoorMapView.setUserLocation(location);
            }

            @Override
            public void onError(LocationError locationError) {
                Log.w(TAG, "Location Received error: " + locationError.getValue());
            }

        };

        /**
         * Requests the list of available retails for the current application
         */
        Ubee.requestRetails(this, new RetailsRequestListener() {

            @Override
            public void onRequestFinished(List<Retail> retails) {

                if (retails.size() > 0) {

                    /**
                     * Loads the IndoorMapView with the retail id
                     */
                    mIndoorMapView.setRetailById(retails.get(0).getId(), new MapViewLoadListener() {

                        @Override
                        public void onRetailLoadFinished(Retail retail, List<RetailMap> retailMaps) {

                            /**
                             * The IndoorMapView is ready to show the maps. You can choose a retail map to be shown or just show the next floor
                             */
                            mIndoorMapView.setNextFloor();

                            mPreviousFloorButton.setOnClickListener(MainActivity.this);
                            mNextFloorButton.setOnClickListener(MainActivity.this);
                        }

                        @Override
                        public void onRetailMapLoadFinished(RetailMap retailMap) {

                            /**
                             * The map is already ready to be shown
                             */
                            mLabel.setVisibility(View.GONE);
                            mNextFloorButton.setEnabled(mIndoorMapView.hasNextFloor());
                            mPreviousFloorButton.setEnabled(mIndoorMapView.hasPreviousFloor());
                        }

                        @Override
                        public void onLoadError(UbeeAPIException e) {
                            mLabel.setVisibility(View.VISIBLE);
                            mLabel.setError("Error: " + e.getMessage());
                            Log.w(TAG, "Error: " + e.getMessage(), e);
                        }
                    });

                } else {
                    Log.w(TAG, "No retail available for this account");
                    mLabel.setText("No retail available for this account");
                }

            }

            @Override
            public void onRequestFailed(UbeeAPIException e) {
                mLabel.setText("No retail available for this account");
                Log.w(TAG, "Retails request has failed with error: " + e.getMessage(), e);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        /**
         * Registering the context to start receiving location updates
         */
        Ubee.registerLocationCallback(this, mLocationListener);
    }

    @Override
    protected void onPause() {
        super.onPause();
        /**
         * Unregistering the context to stop receiving location updates
         */
        Ubee.unregisterLocationCallback(this, mLocationListener);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.next_floor) {
            mIndoorMapView.setNextFloor();
        } else if (v.getId() == R.id.previous_floor) {
            mIndoorMapView.setPreviousFloor();
        }
    }
}
