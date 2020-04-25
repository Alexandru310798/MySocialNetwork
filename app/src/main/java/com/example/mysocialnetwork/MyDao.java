package com.example.mysocialnetwork;

import androidx.room.Dao;
import androidx.room.Insert;

@Dao
public interface MyDao {

    @Insert
    public void addUser(User user);

}
