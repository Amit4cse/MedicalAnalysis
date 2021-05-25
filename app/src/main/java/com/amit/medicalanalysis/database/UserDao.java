package com.amit.medicalanalysis.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface UserDao {

    @Insert
    void addUser(Users users);

    @Query("SELECT EXISTS (SELECT 1 FROM Users WHERE mobile_no=:mobile_no)")
    public int isRegistered(String mobile_no);


}
