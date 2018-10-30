package com.zhwykj.greendaodemo.app;

import android.app.Application;

import com.zhwykj.greendaodemo.greendao.DaoMaster;
import com.zhwykj.greendaodemo.greendao.DaoSession;

import org.greenrobot.greendao.database.Database;

/**
 * Created by gouplee on 2017/12/12.
 */

public class MyApplication extends Application {
    /** A flag to show how easily you can switch from standard SQLite to the encrypted SQLCipher. */
    public static final boolean ENCRYPTED = true;

    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();

        setupDatabase();

    }

    private void setupDatabase() {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, ENCRYPTED ? "bookstore-db-encrypted" : "bookstore-db");
        Database db = ENCRYPTED ? helper.getEncryptedWritableDb("123456") : helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }
}
