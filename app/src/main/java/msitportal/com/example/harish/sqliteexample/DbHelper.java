package msitportal.com.example.harish.sqliteexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;
import android.util.Log;

/**
 * Created by Harish on 7/20/2015.
 */
public class DbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "login_info";
    private static final int DATABASE_VERSION = 1;

    public DbHelper(Context context)
    {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }
    public String CREATE_LOGIN_TABLE_QUERY = "CREATE TABLE LOGIN_DETAILS"+
            "(USERNAME VARCHAR PRIMARY KEY, PASSWORD VARCHAR)";
    public String INSERT_QUERY = "INSERT INTO LOGIN_DETAILS VALUES('harry','alpha')";

    /*public DbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }*/

    @Override
    public void onCreate(SQLiteDatabase db)
    {
         db.execSQL("CREATE_LOGIN_TABLE_QUERY");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("DROP TABLE IF EXISTS");
        onCreate(db);
    }

    public void saveLoginInfo(DbHelper dbHelper, String username, String password)
    {
        SQLiteDatabase sq = dbHelper.getWritableDatabase();
        /*sq.execSQL("INSERT_QUERY");*/
        ContentValues cv= new ContentValues();
        cv.put("USERNAME",username);
        cv.put("PASSWORD",password);
        sq.insert("LOGIN_DETAILS",null,cv);
        sq.close();
      /*  sq.query();*/
    }

    public Cursor getLoginInfo(DbHelper db, String username)
    {
        SQLiteDatabase sq = db.getReadableDatabase();
        String columns[]={"USERNAME","PASSWORD"};
        String selectionArgs[] = {username};
        return sq.query("LOGIN_DETAILS",columns,"USERNAME = ?",selectionArgs,null,null,null);
    }

    /*public List<username> getMulLoginInfo()
    {

    }*/
}
