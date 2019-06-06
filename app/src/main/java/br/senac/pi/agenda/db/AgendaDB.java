package br.senac.pi.agenda.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AgendaDB extends SQLiteOpenHelper {

    private static final String DBNAME = "agenda.db";
    private static final int DBVERSION = 1;

    public AgendaDB(Context context) {
        super(context, DBNAME, null, DBVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE contato (id integer primary key autoincrement," +
                "nome text," +
                "email text)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int dbVersaoAnterior, int dbNovaVersao) {

    }
}
