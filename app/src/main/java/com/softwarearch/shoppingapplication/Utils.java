package com.softwarearch.shoppingapplication;

import android.content.Context;
import android.widget.Toast;

public class Utils {
    public static String baseURL = "https://reqres.in/api/";
    public static String databaseName = "ShoppingApplication_db";
    static Toast mToast;
    public static void showToast(Context context, String statusMsg){
        if(mToast != null) mToast.cancel();
        mToast = Toast.makeText(context,statusMsg, Toast.LENGTH_SHORT);
        mToast.show();
    }
}
