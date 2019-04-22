package com.softwarearch.shoppingapplication.bridge;

public abstract class ProductView {

    IproductResource iproductResource;

    public ProductView(IproductResource iproductResource) {
        this.iproductResource = iproductResource;
    }

}
