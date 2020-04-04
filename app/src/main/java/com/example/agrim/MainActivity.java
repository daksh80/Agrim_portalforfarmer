package com.example.agrim;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.ShowableListMenu;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
     EditText emailId,password;
     Button btnSignUn;
     TextView tvSignIn;
     FirebaseAuth mFirebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFirebaseAuth = FirebaseAuth.getInstance();
        emailId=findViewById(R.id.editText);
        password=findViewById(R.id.editText2);
        btnSignUn=findViewById(R.id.button);
        tvSignIn=findViewById(R.id.textView);
        btnSignUn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=emailId.getText().toString();
                String pwd=password.getText().toString();
                if(email.isEmpty())
                {
                    emailId.setError("please enter Email id");
                    emailId.requestFocus();
                }
                else if(pwd.isEmpty())
                {
                    password.setError("please enter password");
                    password.requestFocus();
                }
                else if(email.isEmpty() && pwd.isEmpty())
                {
                    Toast.makeText(MainActivity.this, "FIel are empty!",Toast.LENGTH_SHORT).show();
                }
                else if (!(email.isEmpty() && pwd.isEmpty()))
                {
                    mFirebaseAuth.createUserWithEmailAndPassword(email,pwd).addOnCompleteListener(MainActivity.this, new OnCompleteListener<com.google.firebase.auth.AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<com.google.firebase.auth.AuthResult> task) {
                            if(!task.isSuccessful())
                            {
                                Toast.makeText(MainActivity.this, "Signup is uncessfull",Toast.LENGTH_SHORT).show();
                            }
                            else
                                startActivity(new Intent(MainActivity.this, HomeActivity.class));
                        }
                    });
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Error Occured",Toast.LENGTH_SHORT).show();
                }

            }
        });
                    tvSignIn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent i= new Intent(MainActivity.this,LoginActivity.class);
                            startActivity(i);
                        }
                    });
    }
}
