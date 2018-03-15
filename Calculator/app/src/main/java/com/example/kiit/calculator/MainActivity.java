package com.example.kiit.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.textView3) TextView textView3;
    @BindView(R.id.textView4) TextView textView4;
    @BindView(R.id.textView6) TextView textView6;
    @BindView(R.id.editText)EditText editText;
    String amt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        amt = editText.getText().toString();
    }

    public void click(View view) {
                    textView3.setText();
                    textView4.setText("Hello!");
                    textView6.setText("Hi!!");
        }
    }