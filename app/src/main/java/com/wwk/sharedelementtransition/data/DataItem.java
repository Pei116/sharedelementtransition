package com.wwk.sharedelementtransition.data;

/**
 * Created by wwk on 8/7/17.
 */

public class DataItem {
    private long id;
    private String title;
    private String description;

    public DataItem(long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
