package com.softwarearch.shoppingapplication.database;

import com.softwarearch.shoppingapplication.models.database_models.User;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import io.reactivex.Observable;
@Dao
public interface UserDao {

    @Query("SELECT * FROM User WHERE uid = :userId")
    Observable<User> getUserById(String userId);
    //TODO uncomment this once the application is ready, for login and logout functionality
    /*@Query("SELECT * FROM User WHERE uid = :userId")
    Observable<Boolean> isUserLoggedIn(String userId);*/

    @Query("SELECT * FROM User")
    Observable<User> getUser();

    @Insert
    void insert(User user);

    @Update
    void update(User user);

    @Delete
    void delete(User user);
}
