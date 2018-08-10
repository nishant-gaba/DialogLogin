package com.example.nishant.myapplication;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    public void toastmsg(String msg,int a,int b){
      Toast t = Toast.makeText(this,msg,Toast.LENGTH_SHORT);
      t.setGravity(Gravity.CENTER,a,b);
      t.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toastmsg("onCreate",0,0);
    }

    protected void onStart(){
        super.onStart();
        toastmsg("onStart",400,400);

    }

    protected void onResume(){
        super.onResume();
       toastmsg("onResume",-400,400);
    }

    protected void onPause(){
        super.onPause();
        toastmsg("onPause",800,800);
    }

    protected void onDestroy(){
        super.onDestroy();
        toastmsg("onDestroy",800,-800);

    }
}
