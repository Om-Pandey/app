package com.example.kiit.exp4;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText username;
    EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username=(EditText)findViewById(R.id.editText);
        password=(EditText)findViewById(R.id.editText2);
    }

    public void save(View view) {
        SharedPreferences sharedPreferences=getSharedPreferences("Mydata",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("username", username.toString());
        editor.putString("password",password.toString());
        editor.apply();
        Toast.makeText(this,"Thank you for saving",Toast.LENGTH_LONG).show();
    }

    public void change(View view) {
        Intent intent = new Intent(MainActivity.this,Activity_b.class);
        Toast.makeText(this,"Credentials :",Toast.LENGTH_LONG).show();
        startActivity(intent);
    }
}
