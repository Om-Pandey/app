package com.example.kiit.exp4;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import javax.xml.transform.Templates;

public class Activity_b extends AppCompatActivity {
    TextView name;
    TextView password;
    public static final String DEFAULT ="N/A";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        name =(TextView) findViewById(R.id.editText3);
        password=(TextView)findViewById(R.id.editText4);
    }

    public void load(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("Mydata",MODE_PRIVATE);
        String username = sharedPreferences.getString("username",DEFAULT);
        String paassword = sharedPreferences.getString("password",DEFAULT);
        if (username==DEFAULT|| paassword==DEFAULT)
        {
            Toast.makeText(this,"NO DATA",Toast.LENGTH_LONG).show();
        }
        else
        {
            name.setText(username);
            password.setText(paassword);
            Toast.makeText(this,"We are happy to help",Toast.LENGTH_LONG).show();
        }
    }

    public void previous(View view) {
        Toast.makeText(this,"Previous",Toast.LENGTH_LONG);
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
