package com.example.nishant.signin_login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void toast(String msg){
        Toast t = Toast.makeText(this,msg,Toast.LENGTH_SHORT);
        t.show();
    }

    Button done ;
    ImageButton cancel ;
    EditText name,mob,pass,cpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    done = (Button)findViewById(R.id.Done);
    cancel = (ImageButton)findViewById(R.id.cancel);

    name= (EditText)findViewById(R.id.username);
    mob = (EditText)findViewById(R.id.mob);
    pass =(EditText)findViewById(R.id.pass);
    cpass=(EditText)findViewById(R.id.cpass);

    cancel.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    });
    done.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            String n = name.getText().toString();
            if (n.length() == 0){
                toast("Enter Name");
            }

            String m=mob.getText().toString();
            if(m.length()==0) {
                toast("Enter Mobile No.");
            }
            if(m.length()!=10){
                toast("Enter correct mobile no.");
            }
            String p=pass.getText().toString();
            if(p.length()==0){
                toast("Enter Password");
            }
            if(p.length()<4){
                toast("Password too short");
            }
            String cp=cpass.getText().toString();
            if(cp.length()==0){
                toast("Confirm Password Field empty");
            }

            {
                if (p.equals(cp) && n.length()!=0 && m.length()!=0) {
                    toast("Succesfull sign_up");

                    Intent i1 = new Intent(MainActivity.this,Main2Activity.class);
                    i1.putExtra("userName",n);
                    i1.putExtra("passWord",p);
                    startActivityForResult(i1,1);


                } else {
                  toast("Password and Confirm Password did not match");
                }
            }
        }
    });
    }
}
