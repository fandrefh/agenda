package br.senac.pi.agenda.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import br.senac.pi.agenda.R;
import br.senac.pi.agenda.controllers.ContatoController;

public class MainActivity extends AppCompatActivity {

    private EditText edtNome;
    private EditText edtEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNome = findViewById(R.id.edtNome);
        edtEmail = findViewById(R.id.edtEmail);

        findViewById(R.id.btnCadastrar).setOnClickListener(cadastrar());
        findViewById(R.id.btnListarContatos).setOnClickListener(listarContatos());
    }

    public View.OnClickListener listarContatos() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent activityListaContatos = new Intent(MainActivity.this,
                        ListaContatosActivity.class);
                startActivity(activityListaContatos);
            }
        };
    }

    private View.OnClickListener cadastrar() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContatoController contatoController = new ContatoController(MainActivity.this);
                String nomeTela = edtNome.getText().toString();
                String emailTela = edtEmail.getText().toString();

                if (contatoController.inserirContato(nomeTela, emailTela)) {
                    mostrarMensagem(getString(R.string.cadastro_sucesso));
                    edtNome.setText("");
                    edtEmail.setText("");
                    edtNome.requestFocus();
                } else {
                    mostrarMensagem(getString(R.string.cadastro_erro));
                }
            }
        };
    }

    private void mostrarMensagem(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
}
