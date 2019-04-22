package com.softwarearch.shoppingapplication.bridge;

public class BookResource implements IproductResource {

    private String mTitle;
    private String desc;
    private String name;



    @Override
    public String getTitle() {
        return mTitle;
    }

    @Override
    public String getDesc() {
        return desc;
    }

    @Override
    public String getName() {
        return name;
    }
}
