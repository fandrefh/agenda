package br.senac.pi.agenda.activities;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import br.senac.pi.agenda.R;
import br.senac.pi.agenda.controllers.ContatoController;

public class EditarContatoActivity extends AppCompatActivity {

    private String idContato;
    private Cursor contato;

    private EditText edtEditarNome;
    private EditText edtEditarEmail;

    private ContatoController contatoController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_contato);

        idContato = this.getIntent().getStringExtra("idContato");

        contatoController = new ContatoController(this);

        preencherFormulario();
    }

    private void preencherFormulario() {
        edtEditarNome = findViewById(R.id.edtEditarNome);
        edtEditarEmail = findViewById(R.id.edtEditarEmail);
        contato = contatoController.pegarContatoPorId(Integer.parseInt(idContato));
        edtEditarNome.setText(contato.getString(contato.getColumnIndexOrThrow("nome")));
        edtEditarEmail.setText(contato.getString(contato.getColumnIndexOrThrow("email")));
    }
}
