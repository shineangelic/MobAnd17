package it.eng.moband2017.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by academy on 01/06/2017.
 */

public abstract class MobAnd17Db extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "moband17.db";
    public static final String TABLE_INOUT = "inouttable";

    /*
      * NODES TABLE
      */
     public static final String COLUMN_ID = "_id";
     public static final String COLUMN_NODE_ID = "intnodeid";
     public static final String COLUMN_NODE_HEALTH = "inthlt";
     public static final String COLUMN_NODE_ICON = "intnodeico";
     public static final String COLUMN_NODE_NAME = "strnodename";
     public static final String COLUMN_NODE_LASTMOD = "cldnodemod";
     public static final String[] ALLCOLUMNS_NODES = {COLUMN_ID, COLUMN_NODE_ID, COLUMN_NODE_HEALTH, COLUMN_NODE_ICON,
                         COLUMN_NODE_NAME, COLUMN_NODE_LASTMOD};


    public MobAnd17Db(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
}
