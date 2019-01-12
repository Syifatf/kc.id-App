package syifa.app.mykenclengid.handler;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;

import syifa.app.mykenclengid.model.KenclengModels;

/**
 * Created by USER on 11/01/2019.
 */

public class DatabaseHandler extends SQLiteOpenHelper {


    private String queryValues;
    private SQLiteDatabase db;

    // static variable
    private static final int DATABASE_VERSION = 2;

    // Database name
    private static final String DATABASE_NAME = "db_kencleng";

    // table name
    private static final String TABLE_TAMBAH_DATA = "tambahData";

    // column tables
    private static final String KEY_ID = "id";
    private static final String KEY_STATUS = "status";
    private static final String KEY_NOMINAL = "nominal";
    private static final String KEY_CATATAN = "catatan";
    private static final String KEY_TANGGAL = "tanggal";


    public DatabaseHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        final String SQL_CREATE_MOVIE_TABLE = "CREATE TABLE " + TABLE_TAMBAH_DATA + " (" +
                KEY_ID + " INTEGER PRIMARY  KEY autoincrement, " +
                KEY_STATUS + "TEXT NOT NULL, " +
                KEY_NOMINAL + " TEXT NOT NULL " +
                KEY_CATATAN + " TEXT NOT NULL " +
                KEY_TANGGAL + " DATE PICKER " + " )";
        db.execSQL(SQL_CREATE_MOVIE_TABLE);

//        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_TAMBAH_DATA + "("
//                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_STATUS + " TEXT," + KEY_NOMINAL + " TEXT," + KEY_CATATAN + " TEXT,"
//                + KEY_TANGGAL + " TEXT" + ")";
//        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TAMBAH_DATA);
        onCreate(db);
    }

    public ArrayList<HashMap<String, String>> getAllData() {
        ArrayList<HashMap<String, String>> wordList;
        wordList = new ArrayList<HashMap<String, String>>();
        String selectQuery = "SELECT * FROM " + TABLE_TAMBAH_DATA;
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> map = new HashMap<String, String>();
                map.put(KEY_ID, cursor.getString(0));
                map.put(KEY_STATUS, cursor.getString(1));
                map.put(KEY_NOMINAL, cursor.getString(2));
                map.put(KEY_CATATAN, cursor.getString(3));
                map.put(KEY_TANGGAL, cursor.getString(4));
                wordList.add(map);
            } while (cursor.moveToNext());
        }

        Log.e("select sqlite ", "" + wordList);

        database.close();
        return wordList;
    }


    public void insert(String status, String nominal, String catatan, String tanggal) {
        SQLiteDatabase database = this.getWritableDatabase();

        String queryValues = " INSERT INTO " + TABLE_TAMBAH_DATA + " (status, nominal, catatan, tanggal) " +
                "VALUES (' " + status + "', '" + nominal + "', '" + catatan + "', '" + tanggal + "' )";

        Log.e("insert sqlite ", "" + queryValues);
        database.close();
    }

    public void update(int id, String status, String nominal, String catatan, String tanggal) {
        SQLiteDatabase database = this.getWritableDatabase();

        String updateQuery = "UPDATE " + TABLE_TAMBAH_DATA + " SET " + KEY_STATUS + "='" + status + "',"
                + KEY_NOMINAL + "='" + nominal + "',"
                + KEY_CATATAN + "='" + catatan + "',"
                + KEY_TANGGAL + "='" + tanggal + "',"
                + " WHERE " + KEY_ID + "='" + id + "',";
        Log.e(" update sqlite ", updateQuery);
        database.execSQL(updateQuery);
        database.close();
    }

    public void delete(int id) {
        SQLiteDatabase database = this.getWritableDatabase();

        String updateQuery = "DELETE FROM " + TABLE_TAMBAH_DATA + "WHERE " + KEY_ID + "=" + "'" + id + "'";
        Log.e("update sqlite ", updateQuery);
        database.execSQL(updateQuery);
        database.close();
    }
}