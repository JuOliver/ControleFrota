package com.controlefrota;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.controlefrota.model.Usuario;
import com.controlefrota.model.ValidaCampos;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class CadastroActivity extends AppCompatActivity {

    private FirebaseAuth autenticacao;

    FirebaseDatabase banco = FirebaseDatabase.getInstance();
    DatabaseReference usuarios;

    public TextInputLayout textInputLayoutEmail;
    public TextInputLayout textInputLayoutSenhacad;
    public TextInputLayout textInputLayoutConfirmarSenha;
    Button buttonCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        usuarios = banco.getReference("usuarios");


        buttonCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean emailValido = ValidaCampos.Email(textInputLayoutEmail.getEditText().getText().toString());
                if (emailValido) {
                    textInputLayoutEmail.setError("");
                }else{
                    textInputLayoutEmail.setError("Email necessário");
                }

                Usuario novoUsuario = new Usuario();
                novoUsuario.setEmail(textInputLayoutEmail.getEditText().getText().toString());
                novoUsuario.setSenha(textInputLayoutSenhacad.getEditText().getText().toString());

                autenticacao = FirebaseAuth.getInstance();

                //Cria o usuario
                autenticacao
                        .createUserWithEmailAndPassword(novoUsuario.getEmail(),novoUsuario.getSenha()).
                        addOnCompleteListener(CadastroActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    usuarios.push().setValue(novoUsuario);
                                    Toast.makeText(CadastroActivity.this, "Usuario cadastrado com sucesso", Toast.LENGTH_SHORT).show();
                                }else{
                                    Toast.makeText(CadastroActivity.this, "Falha ao cadastrar", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

            }
        });

    }

    public void inicializaComponentes(){
        textInputLayoutEmail = findViewById(R.id.textFielEmail);
        textInputLayoutSenhacad = findViewById(R.id.textFieldSenhacad);
        textInputLayoutConfirmarSenha = findViewById(R.id.textFieldConfirmarSenha);
        buttonCadastrar = findViewById(R.id.buttonCadastrar);

    }}