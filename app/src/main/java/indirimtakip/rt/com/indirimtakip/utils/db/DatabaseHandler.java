package indirimtakip.rt.com.indirimtakip.utils.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Appledore on 03/10/2017.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "indirimTakip";

    // Contacts table name
    private static final String TABLE_FIYAT = "FIYAT_BILGILERI";

    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String markaWeb = "MARKA_WEB";
    private static final String fiyat = "FIYAT";
    private static final String req_date = "REQUEST_DATE";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE =
                "CREATE TABLE " + TABLE_FIYAT + "("
                        + KEY_ID + " INTEGER PRIMARY KEY,"
                        + markaWeb + " TEXT,"
                        + fiyat + " REAL"
                        + req_date + " NUMERIC"
                        + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FIYAT);

        // Create tables again
        onCreate(db);
    }
}
