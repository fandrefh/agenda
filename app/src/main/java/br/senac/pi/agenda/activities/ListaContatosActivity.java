package br.senac.pi.agenda.activities;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import br.senac.pi.agenda.R;
import br.senac.pi.agenda.controllers.ContatoController;

public class ListaContatosActivity extends AppCompatActivity {

    private ListView lvContatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_contatos);

        lvContatos = findViewById(R.id.lvContatos);

        carregaContatos();
    }

    private void carregaContatos() {
        ContatoController contatoController = new ContatoController(this);
        Cursor contatos = contatoController.listarContatos();
        String[] campos = {"nome", "email"};
        int[] txtViews = {R.id.txtNome, R.id.txtEmail};
        SimpleCursorAdapter adaptador = new SimpleCursorAdapter(
                this, // Contexto da Activity
                R.layout.item_lista_contatos, // Arquivo de layout que contém os itens da lista
                contatos, // A listagem dos contatos do banco de dados
                campos, // Campos/Valores que serão exibidos na tela
                txtViews // Views/TextViews que serão usadas para exibir a lista na tela
        );
        lvContatos.setAdapter(adaptador);
    }
}
