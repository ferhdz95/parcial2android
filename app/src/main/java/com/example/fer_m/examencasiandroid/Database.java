package com.example.fer_m.examencasiandroid;

/**
 * Created by fer_m on 08/11/2017.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper{
    private	static final int DATABASE_VERSION =	5;
    private	static final String	DATABASE_NAME = "producto";
    private	static final String TABLE_PRODUCTS = "productos";

    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_PRODUCTNAME = "nombre";
    private static final String COLUMN_DESCRIPTION = "descripcion";
    private static final String COLUMN_QUANTITY = "cantidad";

    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String	CREATE_PRODUCTS_TABLE = "CREATE	TABLE " + TABLE_PRODUCTS + "(" + COLUMN_ID + " INTEGER PRIMARY KEY," + COLUMN_PRODUCTNAME + " TEXT," + COLUMN_DESCRIPTION + " TEXT," + COLUMN_QUANTITY + " INTEGER" + ")";
        db.execSQL(CREATE_PRODUCTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCTS);
        onCreate(db);
    }

    public ArrayList<Producto> listProducts(){
        String sql = "select * from " + TABLE_PRODUCTS;
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<Producto> storeProducts = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql, null);
        if(cursor.moveToFirst()){
            do{
                int id = Integer.parseInt(cursor.getString(0));
                String name = cursor.getString(1);
                String description = cursor.getString(2);
                int quantity = Integer.parseInt(cursor.getString(3));
                storeProducts.add(new Producto(id, name, description, quantity));
            }while (cursor.moveToNext());
        }
        cursor.close();
        return storeProducts;
    }

    public void addProduct(Producto product){
        ContentValues values = new ContentValues();
        values.put(COLUMN_PRODUCTNAME, product.getNombre());
        values.put(COLUMN_DESCRIPTION, product.getDescripcion());
        values.put(COLUMN_QUANTITY, product.getCantidad());
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_PRODUCTS, null, values);
    }

    public void updateProduct(Producto product){
        ContentValues values = new ContentValues();
        values.put(COLUMN_PRODUCTNAME, product.getNombre());
        values.put(COLUMN_DESCRIPTION, product.getDescripcion());
        values.put(COLUMN_QUANTITY, product.getCantidad());
        SQLiteDatabase db = this.getWritableDatabase();
        db.update(TABLE_PRODUCTS, values, COLUMN_ID	+ "	= ?", new String[] { String.valueOf(product.getId())});
    }

    public ArrayList<Producto> findProduct(String nombre){
        String query = "Select * FROM "	+ TABLE_PRODUCTS + " WHERE " + COLUMN_PRODUCTNAME + " = " + "'"+nombre+"'";
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<Producto> storeProducts = new ArrayList<>();
        Cursor cursor = db.rawQuery(query, null);
        if(cursor.moveToFirst()){
            do{
                int id = Integer.parseInt(cursor.getString(0));
                String name = cursor.getString(1);
                String description = cursor.getString(2);
                int quantity = Integer.parseInt(cursor.getString(3));
                storeProducts.add(new Producto(id, name, description, quantity));
            }while (cursor.moveToNext());
        }
        cursor.close();
        return storeProducts;
    }

    public void deleteProduct(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_PRODUCTS, COLUMN_ID	+ "	= ?", new String[] { String.valueOf(id)});
    }
}
