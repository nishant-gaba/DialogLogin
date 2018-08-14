package com.example.nishant.signin_login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    Button login;
    ImageButton cancel;
    EditText username,pass;

    public void toast(String msg){
        Toast t = Toast.makeText(this,msg,Toast.LENGTH_SHORT);
        t.show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        login=(Button)findViewById(R.id.login_button);
        cancel=(ImageButton)findViewById(R.id.imageButton);

        username=(EditText)findViewById(R.id.user_login);
        pass=(EditText)findViewById(R.id.pass_login);

        Intent i2 = getIntent();
        username.setText(i2.getStringExtra("userName"));
        pass.setText(i2.getStringExtra("passWord"));

        final String us = username.getText().toString();
        final String ps = pass.getText().toString();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              if(us.equals(username.getText().toString()) && ps.equals(pass.getText().toString()))
              {
                toast("Successful login");
              }else {
                  toast("Username or Password Incorrect");
              }
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toast("cancelled");
                finish();
            }
        });
    }
}
