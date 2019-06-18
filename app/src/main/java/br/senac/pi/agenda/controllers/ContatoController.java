package br.senac.pi.agenda.controllers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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

        resultado = db.insert("contatos", null, valores);
        db.close();

        if (resultado == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Cursor listarContatos() {
        Cursor listaDados;
        db = agendaDB.getReadableDatabase();
        String[] campos = {"_id", "nome", "email"};
        listaDados = db.query("contatos", campos, null, null, null, null, null);

        if (listaDados != null) {
            listaDados.moveToFirst();
        }

        db.close();
        return listaDados;
    }

    public Cursor pegarContatoPorId(int id) {
        Cursor contato;

        String[] campos = {"_id", "nome", "email"};
        String where = "_id" + "=" + id;
        db = agendaDB.getReadableDatabase();
        contato = db.query("contatos", campos, where, null, null, null,
                null);

        if (contato != null) {
            contato.moveToFirst();
        }
        db.close();
        return contato;
    }

    public void atualizarContato(int id, String nome, String email) {
        ContentValues valores = new ContentValues();
        String where = "_id" + "=" + id;

        db = agendaDB.getWritableDatabase();

        valores.put("nome", nome);
        valores.put("email", email);

        db.update("contatos", valores, where, null);
        db.close();
    }

    public void deleteContato(int id) {
        String where = "_id" + "=" + id;
        db = agendaDB.getWritableDatabase();
        db.delete("contatos", where, null);
        db.close();
    }
}
