package com.vogella.android.minim2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import retrofit2.Call;

public class GithubUserActivity extends AppCompatActivity {
    SharedPreferences mySharedPreferences;
    String user;
    APIInterface APIInterface;
    EditText usernameContainer;

    //Funció per a agafar l'usuari del textview
    public String getUser(View v){
        EditText usernameContainer;
        usernameContainer = (EditText)findViewById(R.id.PutUserText);
        return usernameContainer.getText().toString();
    }

    //Quan s'inicia el login guarda les sharedpreferences, a no ser que estiguin plenes que llavors obre la MainActivity directament
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_GithubUser);
        mySharedPreferences = getSharedPreferences("mySharedPreferences", MODE_PRIVATE);
    }

    // Funció de login
    public void onSaveUserClick(View v){
        user = getUser(v);
        SharedPreferences.Editor preferences = getSharedPreferences("mySharedPreferences", MODE_PRIVATE).edit();
        preferences.putString("User", user);
        preferences.apply();
        Call<GithubUser> githubUserCall = APIInterface.getUser(user);
        Call<List< GithubRepositories>> githubRepositoriesCall = APIInterface.getRepositories(user);
        openMainActivity();
    }

    public  void openMainActivity(){
        Intent mainActvity = new Intent(this, MainActivity.class);
        startActivity(mainActvity);
    }

}