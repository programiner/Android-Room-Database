package com.programiner.roomdatabase;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "user_db")
public class User {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "uid")
    public int id;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "age")
    public String age;

    @ColumnInfo(name = "verified")
    public boolean verified;

    public User(String name, String age,boolean verified) {
        this.name = name;
        this.age = age;
        this.verified = verified;
    }

    @Override
    public String toString() {
        return "\nUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", verified=" + verified +
                '}';
    }
}
