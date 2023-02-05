package com.programiner.roomdatabase;


import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "Room Db";
    ExecutorService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void insertauser(View view) {
        service = Executors.newSingleThreadExecutor();
        service.execute(new Runnable() {
            @Override
            public void run() {
                User user = new User("Programiner", "24", true);
                UserDatabase.getInstance(MainActivity.this).userDao().insert(user);
                Log.d(TAG, "run: Inserted Successfully!!");
            }
        });
    }

    public void updateauser(View view) {
        service = Executors.newSingleThreadExecutor();
        service.execute(new Runnable() {
            @Override
            public void run() {
                User user = UserDatabase.getInstance(MainActivity.this)
                        .userDao().findbyid(1);

                user.name = "Java";
                user.age = "8";

                UserDatabase.getInstance(MainActivity.this)
                        .userDao().Update(user);

                Log.d(TAG, "run: Updated Successfully!!");

            }
        });
    }

    public void deleteuser(View view) {
        service = Executors.newSingleThreadExecutor();
        service.execute(new Runnable() {
            @Override
            public void run() {
                User user = UserDatabase.getInstance(MainActivity.this)
                        .userDao().findbyid(4);
                UserDatabase.getInstance(MainActivity.this)
                        .userDao().Delete(user);

                Log.d(TAG, "run: Deleted Successfully!!");

            }
        });
    }

    public void readaauser(View view) {
        service = Executors.newSingleThreadExecutor();
        service.execute(new Runnable() {
            @Override
            public void run() {
                User user = UserDatabase.getInstance(MainActivity.this)
                        .userDao().findbyid(2);
                Log.d(TAG, user.toString());
            }
        });
    }

    public void readalluser(View view) {
        service = Executors.newSingleThreadExecutor();
        service.execute(new Runnable() {
            @Override
            public void run() {
                List<User> list = UserDatabase.getInstance(MainActivity.this)
                        .userDao().getAllUsers();
                Log.d(TAG, list.toString());

            }
        });

    }

    public void deletealluser(View view) {
        service = Executors.newSingleThreadExecutor();
        service.execute(new Runnable() {
            @Override
            public void run() {
                UserDatabase.getInstance(MainActivity.this)
                        .userDao().DeleteAll();
            }
        });
    }

    public void readverifeduser(View view) {
        service = Executors.newSingleThreadExecutor();
        service.execute(new Runnable() {
            @Override
            public void run() {
                List<User> list = UserDatabase.getInstance(MainActivity.this)
                        .userDao().getverifieduser();
                Log.d(TAG, list.toString());
            }
        });
    }

    public void addmultipleuser(View view) {
        service = Executors.newSingleThreadExecutor();
        service.execute(new Runnable() {
            @Override
            public void run() {
                List<User> list = new ArrayList<>();
                list.add(new User("Artorean", "15", true));
                list.add(new User("Google", "85", false));
                list.add(new User("Youtube", "5", false));
                list.add(new User("Instagram", "8", false));
                list.add(new User("Github", "58", true));
                UserDatabase.getInstance(MainActivity.this)
                        .userDao().addmultipleusers(list);

                Log.d(TAG, "run: Multiple Users Added!!");
            }
        });
    }
}