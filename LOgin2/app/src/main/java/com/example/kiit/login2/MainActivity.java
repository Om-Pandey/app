package com.example.kiit.login2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.kiit.login2.LOgin.loginview;
import com.example.kiit.login2.Presenter.presenter;
import com.example.kiit.login2.model.presenterImpl;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,loginview {
      EditText username,password;
      Button login;
      presenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText)findViewById(R.id.editText);
        password = (EditText)findViewById(R.id.editText2);
        login = (Button)findViewById(R.id.button);
        login.setOnClickListener(this);
        presenter = new presenterImpl(MainActivity.this);
    }

    @Override
    public void onClick(View view) {
        presenter.validate(username.getText().toString(),password.getText().toString());
    }

    @Override
    public void LoginValidate() {
        Toast.makeText(getApplicationContext(),"Please Enter",Toast.LENGTH_LONG).show();

    }

    @Override
    public void LoginSuccess() {
        Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_LONG).show();
    }

    @Override
    public void LoginFail() {
        Toast.makeText(getApplicationContext(),"Fail",Toast.LENGTH_LONG).show();
    }
}
