package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    private Button Regist;
    private Button login;
    EditText txtEmail,txtpassword;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Regist = (Button)findViewById(R.id.register);
        txtEmail= (EditText)findViewById(R.id.Emailtxt);
        txtpassword= (EditText)findViewById(R.id.txtpass);
        login=(Button)findViewById(R.id.loginBtn);
        Regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Register.class));
            }
        });
        firebaseAuth=FirebaseAuth.getInstance();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = txtEmail.getText().toString().trim();
                String password = txtpassword.getText().toString().trim();
                if(TextUtils.isEmpty(email)){

                    Toast.makeText(getApplicationContext(),"login failed ",Toast.LENGTH_LONG).show();
                    return;}
                if(TextUtils.isEmpty(password)){
                    Toast.makeText(getApplicationContext(),"login failed ",Toast.LENGTH_LONG).show();
                    return;}


                firebaseAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    startActivity(new Intent(getApplicationContext(),MainActivity.class));

                                } else {
                                    Toast.makeText(getApplicationContext(),"login failed ",Toast.LENGTH_LONG).show();

                                }

                                // ...
                            }
                        });
            }
        });

    }
}
