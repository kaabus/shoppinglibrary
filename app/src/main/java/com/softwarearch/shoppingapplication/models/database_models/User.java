package com.softwarearch.shoppingapplication.models.database_models;

import java.util.Date;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {
    @PrimaryKey(autoGenerate = true)
    private int uid;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "image_url")
    private String imageUrl;

    @ColumnInfo(name = "birth_date")
    private String birthDate;

    @ColumnInfo(name = "email")
    private String email;

    @ColumnInfo(name = "mobile")
    private String mobile;

    @ColumnInfo(name = "first_launch")
    private boolean firstLaunch;


    public User(UserBuilder userBuilder) {
        this.name=userBuilder.name;
        this.imageUrl=userBuilder.imageUrl;
        this.birthDate=userBuilder.birthDate;
        this.email=userBuilder.email;
        this.mobile=userBuilder.mobile;
        this.firstLaunch=userBuilder.firstLaunch;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public boolean isFirstLaunch() {
        return firstLaunch;
    }

    public void setFirstLaunch(boolean firstLaunch) {
        this.firstLaunch = firstLaunch;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", firstLaunch=" + firstLaunch +
                '}';
    }

    public static class UserBuilder{
        private String name;
        private String imageUrl;
        private String birthDate;
        private String email;
        private String mobile;
        private boolean firstLaunch;

        public UserBuilder withOptionalName(String name){
            this.name=name;
            return this;
        }

        public UserBuilder withOptionalImageURL(String url){
            this.imageUrl=url;
            return this;
        }
        public UserBuilder withOptionalBirthDate(String birthDate){
            this.birthDate=birthDate;
            return this;
        }

        public UserBuilder withOptionalEmail(String email){
            this.email=email;
            return this;
        }
        public UserBuilder withOptionalMobile(String mobile){
            this.mobile=mobile;
            return this;
        }
        public UserBuilder withOptionalFirstLaunch(boolean isFirstLaunch){
            this.firstLaunch=isFirstLaunch;
            return this;
        }

        public User buildUser(){
            return new User(this);
        }
    }
}
