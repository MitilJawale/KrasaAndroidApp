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

public class Register extends AppCompatActivity {

    EditText txtEmail,txtpassword,txtconform;
    Button btn_register;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        txtEmail =(EditText)findViewById(R.id.Emailtxt);
        txtpassword=(EditText)findViewById(R.id.Password1);
        txtconform=(EditText)findViewById(R.id.Password2);
        btn_register=(Button)findViewById(R.id.registerButton);

        firebaseAuth = FirebaseAuth.getInstance();

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = txtEmail.getText().toString().trim();
                String password = txtpassword.getText().toString().trim();
                String conformpassword = txtconform.getText().toString().trim();
                if(TextUtils.isEmpty(email)){
                    Toast.makeText(getApplicationContext(),"login failed ",Toast.LENGTH_LONG).show();
                    return;}
                if(TextUtils.isEmpty(password)){
                    Toast.makeText(getApplicationContext(),"login failed ",Toast.LENGTH_LONG).show();
                    return;}
                if(TextUtils.isEmpty(conformpassword)){
                    Toast.makeText(getApplicationContext(),"login failed ",Toast.LENGTH_LONG).show();
                    return;}

                if(password.length()<6){
                    Toast.makeText(getApplicationContext(),"login failed ",Toast.LENGTH_LONG).show();
                    return;}
                if(password.equals(conformpassword)){
                    firebaseAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(Register.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        startActivity(new Intent(getApplicationContext(),Login.class));
                                        Toast.makeText(getApplicationContext(),"Registration completed ",Toast.LENGTH_LONG).show();
                                        // Sign in success, update UI with the signed-in user's information

                                    } else {
                                        Toast.makeText(getApplicationContext(),"login failed ",Toast.LENGTH_LONG).show();

                                    }

                                    // ...
                                }
                            });



                }




            }
        });
    }
}

