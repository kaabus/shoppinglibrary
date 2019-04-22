package com.softwarearch.shoppingapplication.models.reponse_models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginResponseModel {
    @SerializedName("status")
    @Expose
    public int status;

    @SerializedName("token")
    @Expose
    public String statusMsg;
}
