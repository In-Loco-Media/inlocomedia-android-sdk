package in.ubee.ads.example.activities;

import in.ubee.ads.example.R;
import in.ubee.ads.example.adapters.CategoriesAdapter;
import in.ubee.api.Ubee;
import in.ubee.api.ads.AdRequest;
import in.ubee.api.communication.listeners.CategoriesRequestListener;
import in.ubee.api.exception.UbeeAPIException;
import in.ubee.models.Category;

import java.util.List;
import java.util.Locale;

import android.app.ActionBar;
import android.app.Activity;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

public class CategoriesActivity extends Activity {

    private CategoriesAdapter mAdapter;

    protected void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        this.setContentView(R.layout.categories_activity);

        ListView listView = (ListView) findViewById(android.R.id.list);

        mAdapter = new CategoriesAdapter(this, R.layout.categories_list_item, android.R.id.checkbox);
        listView.setAdapter(mAdapter);

        Ubee.requestAdsCategories(this, Locale.getDefault(), new CategoriesRequestListener() {

            @Override
            public void onRequestFinished(List<Category> response) {
                mAdapter.addAll(response);
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onRequestFailed(UbeeAPIException error) {
                Toast.makeText(CategoriesActivity.this, "Categories request has failed", Toast.LENGTH_SHORT).show();
            }

        });
    }

    @Override
    protected void onStop() {
        super.onStop();

        List<Category> categories = mAdapter.getSelectedCategories();

        if (categories.size() > 0) {
            AdRequest adRequest = AdRequest.defaultRequest(this);
            adRequest.setCategories(categories);
            adRequest.saveAsDefaultRequest(this);
        }
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
