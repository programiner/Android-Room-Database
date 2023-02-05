package com.programiner.roomdatabase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDao {

    @Insert
    void insert(User user);

    @Query("SELECT * FROM user_db")
    List<User> getAllUsers();

    @Query("SELECT * FROM user_db WHERE uid LIKE :id")
    User findbyid(int id);

    @Update
    void Update(User user);

    @Delete
    void Delete(User user);

    @Insert
    void addmultipleusers(List<User> users);

    @Query("SELECT * FROM user_db WHERE verified LIKE 1")
    List<User> getverifieduser();

    @Query("DELETE FROM user_db")
    void DeleteAll();
}
