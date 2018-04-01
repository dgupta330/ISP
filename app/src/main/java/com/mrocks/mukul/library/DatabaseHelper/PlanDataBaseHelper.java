package com.mrocks.mukul.library.DatabaseHelper;

/**
 * Created by Er.Deepak_kumar on 19-01-2018.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.mrocks.mukul.library.Models.Plan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PlanDataBaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "company.db";
    private static final String TABLE_CONTACTS = "Plans";
    private static final String KEY_ID= "planid";
    private static final String KEY_NAME= "companyname";
    private static final String KEY_DETAIL = "plandetail";
    private static final String KEY_PH_NO = "customercare";
    private static final String KEY_TYPE= "type";
    private static final String KEY_PATH= "path";

    public PlanDataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        //3rd argument to be passed is CursorFactory instance
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "("
                + KEY_NAME + " TEXT," + KEY_ID + " TEXT,"
                + KEY_DETAIL + " TEXT,"+ KEY_PH_NO + " TEXT,"
                + KEY_TYPE + " TEXT," +
                KEY_PATH+ " TEXT)";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);

        // Create tables again
        onCreate(db);
    }
    public Map<String, Object> toMap(Plan plan) {
        HashMap<String, Object> values = new HashMap<>();

        values.put(KEY_ID, plan.getPlanid());
        values.put(KEY_NAME, plan.getCompany());
        values.put(KEY_PH_NO, plan.getCustomercare());
        values.put(KEY_TYPE, plan.getType());
        values.put(KEY_DETAIL, plan.getPlandetail());
        values.put(KEY_PATH, plan.getImagepath());

        return values;
    }
    // code to add the new plan
    public boolean addPlan(Plan plan) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(KEY_ID, plan.getPlanid());
        values.put(KEY_NAME, plan.getCompany());
        values.put(KEY_PH_NO, plan.getCustomercare());
        values.put(KEY_TYPE, plan.getType());
        values.put(KEY_DETAIL, plan.getPlandetail());
        values.put(KEY_PATH, plan.getImagepath());


        // Inserting Row
        long res=db.insert(TABLE_CONTACTS, null, values);
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
        if (res!=-1)
            return  true;
        else return false;
    }

    // code to get the single plan
    Plan getPlan(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_CONTACTS, new String[] { KEY_ID,
                        KEY_NAME, KEY_PH_NO ,KEY_DETAIL,KEY_TYPE,KEY_PATH}, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Plan plan = new Plan(cursor.getString(0),
                cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4),cursor.getString(5));
        // return plan
        return plan;
    }

    // code to get all plans in a list view
    public ArrayList<Plan> getAllPlans() {
        ArrayList<Plan> planList = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Plan plan = new Plan();
                plan.setCompany(cursor.getString(0));
                plan.setPlanid(cursor.getString(1));
                plan.setPlandetail(cursor.getString(2));
                plan.setCustomercare(cursor.getString(3));
                plan.setType(cursor.getString(4));
                plan.setImagepath(cursor.getString(5));
                // Adding plan to list
                planList.add(plan);
            } while (cursor.moveToNext());
        }

        // return plan list
        return planList;
    }

    // code to update the single plan
    public int updatePlan(Plan plan) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(KEY_ID, plan.getPlanid());
        values.put(KEY_NAME, plan.getCompany());
        values.put(KEY_PH_NO, plan.getCustomercare());
        values.put(KEY_TYPE, plan.getType());
        values.put(KEY_DETAIL, plan.getPlandetail());
        values.put(KEY_PATH, plan.getImagepath());


        // updating row
        return db.update(TABLE_CONTACTS, values, KEY_ID + " = ?",
                new String[] { String.valueOf(plan.getPlanid()) });
    }

    // Deleting single plan
    public void deletePlan(Plan plan) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CONTACTS, KEY_ID + " = ?",
                new String[] { String.valueOf(plan.getPlanid()) });
        db.close();
    }

    // Getting plans Count
    public int getPlansCount() {
        String countQuery = "SELECT  * FROM " + TABLE_CONTACTS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }

}
