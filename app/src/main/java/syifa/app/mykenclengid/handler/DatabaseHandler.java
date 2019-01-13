package syifa.app.mykenclengid.handler;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;

import static syifa.app.mykenclengid.R.id.catatan;
import static syifa.app.mykenclengid.R.id.nominal;
import static syifa.app.mykenclengid.R.id.radio;
import static syifa.app.mykenclengid.R.id.tanggal;
import static syifa.app.mykenclengid.R.id.txt_nominal;

/**
 * Created by USER on 11/01/2019.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    // static variable
    private static final int DATABASE_VERSION = 2;

    // Database name
    private static final String DATABASE_NAME = "db_kencleng";

    // table name
    private static final String TABLE_TAMBAH_DATA = "tambahData";

    // column tables
    private static final String KEY_ID = "id";
    private static final String KEY_RADIOBUTTON = "radio";
    private static final String KEY_NOMINAL = "nominal";
    private static final String KEY_CATATAN = "catatan";
    private static final String KEY_TANGGAL = "tanggal";


    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL_CREATE_MOVIE_TABLE = "CREATE TABLE " + TABLE_TAMBAH_DATA + " (" +
                KEY_ID + " INTEGER PRIMARY  KEY autoincrement, " +
                KEY_RADIOBUTTON + "TEXT NOT NULL, " +
                KEY_NOMINAL + " TEXT NOT NULL " +
                KEY_CATATAN + " TEXT NOT NULL " +
                KEY_TANGGAL + " DATE PICKER " + " )";
        db.execSQL(SQL_CREATE_MOVIE_TABLE);

//        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_TAMBAH_DATA + "("
//                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_RADIOBUTTON + " TEXT," + KEY_NOMINAL + " TEXT," + KEY_CATATAN + " TEXT,"
//                + KEY_TANGGAL + " TEXT" + ")";
//        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
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
                map.put(KEY_RADIOBUTTON, cursor.getString(1));
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


    public void insert(String radio, String trim, String s, String trim1) {
        SQLiteDatabase database = this.getWritableDatabase();

        String queryValues = " INSERT INTO " + TABLE_TAMBAH_DATA + " (radio, nominal, catatan, tanggal) " +
                "VALUES (' " + radio + "', '" + nominal + "', '" + catatan + "', '" + tanggal + "' )";

        Log.e("insert sqlite ", "" + queryValues);
        database.close();
    }

    public void update(int id, String radio) {
        SQLiteDatabase database = this.getWritableDatabase();

        String updateQuery = "UPDATE " + TABLE_TAMBAH_DATA + " SET " + KEY_RADIOBUTTON + "='" + radio + "',"
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
