package br.senac.pi.agenda.controllers;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import br.senac.pi.agenda.db.AgendaDB;

public class ContatoController {

    private SQLiteDatabase db;
    private AgendaDB agendaDB;

    public ContatoController(Context context) {
        agendaDB = new AgendaDB(context);
    }

    public Boolean inserirContato(String nome, String email) {
        // insert into contato (nome, email) values ('Francisco André', 'fandrefh@gmail.com');
        ContentValues valores;
        long resultado;

        db = agendaDB.getWritableDatabase();

        valores = new ContentValues();
        valores.put("nome", nome);
        valores.put("email", email);

        resultado = db.insert("contato", null, valores);
        db.close();

        if (resultado == -1) {
            return false;
        } else {
            return true;
        }
    }
}
