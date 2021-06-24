package com.controlefrota;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ProgressBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth autenticacao;
    FirebaseDatabase banco = FirebaseDatabase.getInstance();
    private TextInputLayout textInputLayoutLogin;
    private TextInputLayout textInputLayoutSenha;
    private Intent intentIrTelaLista;
    private Intent getIntentIrTelaCadastro;
    Button buttonLogar;
    Button buttonCadastrar;

    public MainActivity(FirebaseAuth autenticacao, Intent intentIrTelaLista) {
        this.autenticacao = autenticacao;
        this.intentIrTelaLista = intentIrTelaLista;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textInputLayoutLogin = findViewById(R.id.textFieldLogin);
        textInputLayoutSenha = findViewById(R.id.textFieldSenha);
        buttonLogar = findViewById(R.id.buttonLogar);
        buttonCadastrar = findViewById(R.id.buttonCadastrar);



        buttonLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonLogar.setEnabled(false);
                buttonLogar.setText("LOGANDO...");

                String email = textInputLayoutLogin.getEditText().getText().toString();
                String senha = textInputLayoutSenha.getEditText().getText().toString();

                logar(email, senha);


                buttonLogar.setText("LOGAR");
                buttonLogar.setEnabled(true);


            }
        });
    }
        public void logar (String email, String senha){

            autenticacao.signInWithEmailAndPassword(email,senha).
                    addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                //usuario logado
                                textInputLayoutSenha.setError("");
                                startActivity(intentIrTelaLista);
                            }else{
                                textInputLayoutSenha.setError("Login ou senha inválido");

                            }
                        }
                    });
    }
}