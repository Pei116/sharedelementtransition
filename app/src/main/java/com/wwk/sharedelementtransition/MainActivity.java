package com.wwk.sharedelementtransition;

import android.content.Intent;
import android.icu.util.ValueIterator;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;

import com.wwk.sharedelementtransition.data.DataItem;
import com.wwk.sharedelementtransition.data.DataSet;
import com.wwk.sharedelementtransition.data.MyListAdapter;

public class MainActivity extends AppCompatActivity {

    MyListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        ListView listView = (ListView) findViewById(R.id.list_view);

        adapter = new MyListAdapter(this, DataSet.get());

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view, final int position, long id) {
                startTransition(view, (DataItem)adapter.getItem(position));
            }
        });
    }

    private void startTransition(View view, DataItem item) {
        Intent i = new Intent(MainActivity.this, DetailActivity.class);
        i.putExtra("ITEM_ID", item.getId());

        Pair<View, String>[] transitionPairs = new Pair[6];
        transitionPairs[0] = Pair.create(findViewById(R.id.toolbar), "toolbar"); // Transition the Toolbar
        transitionPairs[1] = Pair.create(view, "content_view");
        transitionPairs[2] = Pair.create(view.findViewById(R.id.title), "transition_title");
        transitionPairs[3] = Pair.create(view.findViewById(R.id.description), "transition_descrioption");

        // We also want to transition the status and navigation bar barckground. Otherwise they will flicker
        transitionPairs[4] = Pair.create(findViewById(android.R.id.statusBarBackground), Window.STATUS_BAR_BACKGROUND_TRANSITION_NAME);
        transitionPairs[5] = Pair.create(findViewById(android.R.id.navigationBarBackground), Window.NAVIGATION_BAR_BACKGROUND_TRANSITION_NAME);
        Bundle b = ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this, transitionPairs).toBundle();

        ActivityCompat.startActivity(MainActivity.this, i, b);
    }
}
