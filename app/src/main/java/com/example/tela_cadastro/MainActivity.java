package com.example.tela_cadastro;
import com.example.tela_cadastro.entities.Usuario;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText Name;
    private EditText Senha;
    private EditText E_mail;
    private EditText Celular;
    private EditText Endereço;
    private EditText Complemento;
    private EditText Fale;
    private Button Cadastro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Name = (EditText)findViewById(R.id.editText6);
        E_mail = (EditText)findViewById(R.id.editText7);
        Celular = (EditText)findViewById(R.id.editText8);
        Endereço = (EditText)findViewById(R.id.editText9);
        Senha = (EditText)findViewById(R.id.editText10);
        Complemento = (EditText)findViewById(R.id.editText11);
        Fale = (EditText)findViewById(R.id.editText12);
        Cadastro = (Button)findViewById(R.id.bntCadastro);
        Cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Usuario user = new Usuario(Name.getText().toString(),E_mail.getText().toString(),Celular.getText().toString(),Endereço.getText().toString(),Senha.getText().toString(),Complemento.getText().toString(),Fale.getText().toString());

            }
        });




    }
}
