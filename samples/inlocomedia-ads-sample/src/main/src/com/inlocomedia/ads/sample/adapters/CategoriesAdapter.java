package com.inlocomedia.ads.sample.adapters;

import com.inlocomedia.ads.sample.R;
import in.ubee.api.ads.AdRequest;
import in.ubee.models.Category;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class CategoriesAdapter extends ArrayAdapter<Category> {

    private HashMap<Category, Boolean> mCategoriesState;
    
    public CategoriesAdapter(Context context, int resource, int textViewId) {
        super(context, resource);
        mCategoriesState = new HashMap<Category, Boolean>();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.categories_list_item, parent, false);
        }

        final Category category = getItem(position);

        CheckBox categoryCheckbox = (CheckBox) convertView.findViewById(android.R.id.checkbox);
        
        categoryCheckbox.setText(category.getName());
        categoryCheckbox.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mCategoriesState.put(category, isChecked);
            }
        });
        categoryCheckbox.setChecked(mCategoriesState.get(category));
        
        return convertView;
    }

    @Override
    public void addAll(Collection<? extends Category> categories) {
        mCategoriesState.clear();
        List<Category> currentlySelectedCategories = AdRequest.defaultRequest(getContext()).getCategories();
        
        for (Category category : categories) {
            boolean isCategorySelected = currentlySelectedCategories != null ? currentlySelectedCategories.contains(category) : false;
            mCategoriesState.put(category, isCategorySelected);
        }
       
        super.addAll(categories);

    }
     
    public List<Category> getSelectedCategories() {
        List<Category> categories = new ArrayList<Category>();
        
        for (Category category : mCategoriesState.keySet()) {
            if (mCategoriesState.get(category)) {
                categories.add(category);
            }
        }
        
        return categories;
    }
}
