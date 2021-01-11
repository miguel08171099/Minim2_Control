package com.vogella.android.minim2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    SharedPreferences mySharedPreferences;
    String user;

    //Funció per a agafar l'usuari del textview
    public String getUser(View v){
        EditText usernameContainer;
        usernameContainer = (EditText)findViewById(R.id.editTextTextPersonName);
        return usernameContainer.getText().toString();
    }

    //Funció per a agafar la contrasenya del textview
    public String getPassword(View v){
        EditText usernameContainer;
        usernameContainer = (EditText)findViewById(R.id.editTextTextPassword);
        return usernameContainer.getText().toString();
    }

    //Quan s'inicia el login guarda les sharedpreferences, a no ser que estiguin plenes que llavors obre la MainActivity directament
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mySharedPreferences = getSharedPreferences("mySharedPreferences", MODE_PRIVATE);

        if(mySharedPreferences.getAll().size()!=0){
            user = (String)mySharedPreferences.getAll().get("User");
            Toast.makeText(getApplicationContext(), "Welcome back, " + user + "!", Toast.LENGTH_SHORT).show();
            openMainActivity();
        }
    }
    // Funció de login
    public void onLoginClick(View v){
        user = getUser(v);
        String password = getPassword(v);
        if(user.equals("user")&& password.equals("dsamola")){
            SharedPreferences.Editor edito = getSharedPreferences("mySharedPreferences", MODE_PRIVATE).edit();
            edito.putString("User", user);
            edito.apply();
            openMainActivity();
        } else{
            Toast.makeText(getApplicationContext(), "Wrong credentials!", Toast.LENGTH_SHORT).show();
        }
    }

    public  void openMainActivity(){
        Intent mainActvity = new Intent(this, MainActivity.class);
        startActivity(mainActvity);
    }

}