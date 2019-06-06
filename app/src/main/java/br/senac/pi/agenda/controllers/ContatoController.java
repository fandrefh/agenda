package br.senac.pi.agenda.controllers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import br.senac.pi.agenda.db.AgendaDB;

public class ContatoController {

    private SQLiteDatabase db;
    private AgendaDB agendaDB;

    public ContatoController(Context context) {
        agendaDB = new AgendaDB(context);
    }
}
