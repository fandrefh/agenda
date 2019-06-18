package br.senac.pi.agenda.activities;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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

        findViewById(R.id.btnAtualizarContato).setOnClickListener(atualizarContato());
        findViewById(R.id.btnDeletarContato).setOnClickListener(deletarContato());
    }

    private View.OnClickListener deletarContato() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contatoController.deleteContato(Integer.parseInt(idContato));
                Toast.makeText(EditarContatoActivity.this, R.string.deletar_sucesso,
                        Toast.LENGTH_SHORT).show();
                Intent listaContatoActivity = new Intent(EditarContatoActivity.this,
                        ListaContatosActivity.class);
                startActivity(listaContatoActivity);
                finish();
            }
        };
    }

    private View.OnClickListener atualizarContato() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = edtEditarNome.getText().toString();
                String email = edtEditarEmail.getText().toString();
                contatoController.atualizarContato(Integer.parseInt(idContato), nome, email);
                Toast.makeText(EditarContatoActivity.this, R.string.atualizar_sucesso,
                        Toast.LENGTH_SHORT).show();
                Intent listaContatosActivity = new Intent(EditarContatoActivity.this,
                        ListaContatosActivity.class);
                startActivity(listaContatosActivity);
                finish();
            }
        };
    }

    private void preencherFormulario() {
        edtEditarNome = findViewById(R.id.edtEditarNome);
        edtEditarEmail = findViewById(R.id.edtEditarEmail);
        contato = contatoController.pegarContatoPorId(Integer.parseInt(idContato));
        edtEditarNome.setText(contato.getString(contato.getColumnIndexOrThrow("nome")));
        edtEditarEmail.setText(contato.getString(contato.getColumnIndexOrThrow("email")));
    }
}
