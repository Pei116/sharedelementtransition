package com.wwk.sharedelementtransition;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.wwk.sharedelementtransition.data.DataItem;
import com.wwk.sharedelementtransition.data.DataSet;
import com.wwk.sharedelementtransition.transition.TransitionHelper;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));

        long itemId = getIntent().getLongExtra("ITEM_ID", -1);
        DataItem item = DataSet.find(itemId);

        ((TextView) findViewById(R.id.title)).setText(item.getTitle());
        ((TextView) findViewById(R.id.description)).setText(item.getDescription());

        // if we transition the status and navigation bar we have to wait till everything is available
        TransitionHelper.fixSharedElementTransitionForStatusAndNavigationBar(this);
        // set a custom shared element enter transition
        TransitionHelper.setSharedElementEnterTransition(this, R.transition.detail_activity_transition);
    }
}
