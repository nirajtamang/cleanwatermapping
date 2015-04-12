package org.csitan.thirkha;

/**
 * Created by lenovo on 4/11/15.
 */


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class Databss2 extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "resourcesManager";

    // Resources table name
    private static final String TABLE_RESOURCES = "resources2";

    // Resources Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_NAME2 = "name2";
    private static final String KEY_NAME3 = "name3";
    private static final String KEY_NAME4 = "name4";
    private static final String KEY_NAME5 = "name5";
    private static final String KEY_NAME6 = "name6";
    private static final String KEY_NAME7 = "name7";
    private static final String KEY_NAME8 = "type";
    private static final String KEY_NAME9 = "lat";
    private static final String KEY_NAME10 = "lon";


    public Databss2(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_RESOURCES_TABLE = "CREATE TABLE " + TABLE_RESOURCES + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_NAME + " TEXT,"
                + KEY_NAME2 + " TEXT,"
                + KEY_NAME3 + " TEXT,"
                + KEY_NAME4 + " TEXT,"
                + KEY_NAME5 + " TEXT,"
                + KEY_NAME6 + " TEXT,"
                + KEY_NAME7 + " TEXT,"
                + KEY_NAME8 + " TEXT,"
                + KEY_NAME9 + " TEXT,"
                + KEY_NAME10+ " TEXT"
                + ")";
        db.execSQL(CREATE_RESOURCES_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RESOURCES);

        // Create tables again
        onCreate(db);
    }

    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */

    // Adding new resource
    void addResource(ResourceDetail resource) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, resource.getPopnDepend());
        values.put(KEY_NAME2, resource.getSustan());
        values.put(KEY_NAME3, resource.getEffects());

        values.put(KEY_NAME4, resource.getPurpose());
        values.put(KEY_NAME5, resource.getVerne());
        values.put(KEY_NAME6, resource.getDate());
        values.put(KEY_NAME7, resource.getOrgn_name());
        values.put(KEY_NAME8, resource.getType());
        values.put(KEY_NAME9, resource.getLat());
        values.put(KEY_NAME10, resource.getLon());


        // Inserting Row
        db.insert(TABLE_RESOURCES, null, values);
        db.close(); // Closing database connection
    }

    // Getting single resource


    // Getting All Resources
    public List<ResourceDetail> getAllResources() {
        List<ResourceDetail> resourceList = new ArrayList<ResourceDetail>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_RESOURCES;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                ResourceDetail resource = new ResourceDetail();
                resource.setId(Integer.parseInt(cursor.getString(0)));
                resource.setPopnDepend(cursor.getString(1));
                resource.setSustan(cursor.getString(2));
                resource.setEffects(cursor.getString(3));
                resource.setPurpose(cursor.getString(4));
                resource.setVerne(cursor.getString(5));
                resource.setDate(cursor.getString(6));
                resource.setOrgn_name(cursor.getString(7));
                resource.setType(cursor.getString(8));
                resource.setLat(cursor.getDouble(9));
                resource.setLon(cursor.getDouble(10));
                // Adding resource to list
                resourceList.add(resource);
            } while (cursor.moveToNext());
        }

        // return resource list
        return resourceList;
    }




      }

