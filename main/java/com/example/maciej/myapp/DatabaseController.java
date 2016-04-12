package com.example.maciej.myapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.lang.ref.SoftReference;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Maciej on 2015-11-29.
 */
public class DatabaseController extends SQLiteOpenHelper
{
    public DatabaseController(Context context) {
        super(context, "products.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "create table products(" +
                        "nr integer primary key autoincrement," +
                        "name text," +
                        "calories real," +
                        "carbo real," +
                        "protein real," +
                        "fat real);" +
                        "");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addProduct(Product product) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", product.getName());
        values.put("calories", product.getCalories());
        values.put("carbo", product.getCarbo());
        values.put("protein", product.getProtein());
        values.put("fat", product.getFat());
        db.insertOrThrow("products", null, values);
    }

    public void deleteProduct(int id) {
        SQLiteDatabase db = getWritableDatabase();
        String[] args = {"" + id};
        db.delete("products", "nr=?", args);
    }

    public void updateProduct(Product product) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", product.getName());
        values.put("calories", product.getCalories());
        values.put("carbo", product.getCarbo());
        values.put("protein", product.getProtein());
        values.put("fat", product.getFat());
        String args[]={product.getNr()+""};
        db.update("products", values, "nr=?", args);
    }

    public List<Product> getAllProducts() {
        List<Product> products = new LinkedList<Product>();
        String[] columns = {"nr", "name", "calories", "carbo", "protein", "fat"};
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query("products", columns, " nr=?", null, null, null, null, null);
        while(cursor.moveToNext()) {
            Product product = new Product();
            product.setNr(cursor.getLong(0));
            product.setName(cursor.getString(1));
            product.setCalories(cursor.getLong(2));
            product.setCarbo(cursor.getLong(3));
            product.setProtein(cursor.getLong(4));
            product.setFat(cursor.getLong(5));
            products.add(product);
        }
        return products;

    }

    public Product getProduct(int nr) {
        Product product = new Product();
        SQLiteDatabase db = getReadableDatabase();
        String[] columns = {"nr", "name", "calories", "carbo", "protein", "fat"};
        String args[] = { nr + ""};
        Cursor cursor = db.query("products", columns, " nr=?", args, null, null, null, null);
        if(cursor != null) {
            cursor.moveToFirst();
            product.setNr(cursor.getLong(0));
            product.setName(cursor.getString(1));
            product.setCalories(cursor.getLong(2));
            product.setCarbo(cursor.getLong(3));
            product.setProtein(cursor.getLong(4));
            product.setFat(cursor.getLong(5));
        }
        return  product;
    }

    public List<Product> getByName(String name)
    {
        List<Product> products = new LinkedList<Product>();
        String[] columns = {"nr", "name", "calories", "carbo", "protein", "fat"};
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("select nr, name, calories, carbo, protein, fat from products" +
                "where name ='" + name + "' order by name asc", null);

        while(cursor.moveToNext()) {
            Product product = new Product();
            product.setNr(cursor.getLong(0));
            product.setName(cursor.getString(1));
            product.setCalories(cursor.getLong(2));
            product.setCarbo(cursor.getLong(3));
            product.setProtein(cursor.getLong(4));
            product.setFat(cursor.getLong(5));
            products.add(product);
        }
        return products;
    }
}
