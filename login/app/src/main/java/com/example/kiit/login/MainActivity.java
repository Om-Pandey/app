package com.example.kiit.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private EditText username;
    private EditText password;
    private TextView info;
    Intent inten;
    private Button login;
    private Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = (EditText)findViewById(R.id.username);
        password=(EditText)findViewById(R.id.password);
        info = (TextView)findViewById(R.id.info);
        login = (Button)findViewById(R.id.Login);
        signup = (Button)findViewById(R.id.signup);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(username.getText().toString(),password.getText().toString());
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intents = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intents);
            }
        });
        GridView gridView = (GridView)findViewById(R.id.grid);


    }
    private void validate(String User,String Password)
    {
        if(User != "wizardoz_355" && Password != "wizardoz") {
            inten = new Intent(this, Welcome.class);
            startActivity(inten);
            Toast toast = Toast.makeText(getApplicationContext(),"Correct!!",Toast.LENGTH_SHORT);
            toast.show();
        }
        else {
            Toast toast1 = Toast.makeText(getApplicationContext(), "Forgot Password ?", Toast.LENGTH_LONG);
            toast1.show();
        }
    }
}
