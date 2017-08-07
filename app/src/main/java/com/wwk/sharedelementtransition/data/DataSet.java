package com.wwk.sharedelementtransition.data;

import android.support.annotation.Nullable;

import java.util.ArrayList;

/**
 * Created by wwk on 8/7/17.
 */

public class DataSet {
    private static ArrayList<DataItem> items;

    public static ArrayList<DataItem> get() {
        if (items == null) {
            items = new ArrayList<>();
            items.add(new DataItem(0, "API 25 (Android 7.1)", "Nougat, released December 2016.\nBuild version code: Android.OS.BuildVersionCodes.NMr1"));
            items.add(new DataItem(1, "API 24 (Android 7.0)", "Nougat, released August 2016.\nBuild version code: Android.OS.BuildVersionCodes.N"));
            items.add(new DataItem(2, "API 23 (Android 6.0)", "Marshmallow, released August 2015.\nBuild version code: Android.OS.BuildVersionCodes.M"));
            items.add(new DataItem(3, "API 22 (Android 5.1)", "Lollipop, released March 2015.\nBuild version code: Android.OS.BuildVersionCodes.LollipopMr1"));
            items.add(new DataItem(4, "API 21 (Android 5.0)", "Lollipop, released November 2014.\nBuild version code Android.OS.BuildVersionCodes.Lollipop"));
        }
        return items;
    }

    @Nullable
    public static DataItem find(long itemId) {
        for (DataItem item: items) {
            if (item.getId() == itemId)
                return item;
        }
        return null;
    }
}
