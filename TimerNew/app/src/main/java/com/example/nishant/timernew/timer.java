package com.example.nishant.timernew;

import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.os.Bundle;
import android.text.Editable;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class timer extends AppCompatActivity {
    Button b1,b2,b3 ;
   EditText a,b,c ,name;
   String x,y,z,ax,by,cz,Date;
   int totalseconds ,h,m,s ;
   Calendar calendar ;
   SimpleDateFormat simpleDateFormat ;
   CountDownTimer countDownTimer ;
    String hms ;
    MediaPlayer ring ;
    public void toastMsg(String msg) {

        Toast toast = Toast.makeText(this, msg, Toast.LENGTH_LONG);
        toast.show();

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        a=(EditText)findViewById(R.id.H);
        b=(EditText)findViewById(R.id.M);
        c=(EditText)findViewById(R.id.S);
        name = (EditText)findViewById(R.id.editText4);

        final TextView t = (TextView)findViewById(R.id.textView2);

        b1=(Button)findViewById(R.id.Start);
        b2=(Button)findViewById(R.id.pause);
        b3=(Button)findViewById(R.id.Stop);
        b1.setEnabled(true);
        b2.setEnabled(false);
        b3.setEnabled(false);
        ring = MediaPlayer.create(timer.this,R.raw.ring);

        b1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint({"SimpleDateFormat", "DefaultLocale"})
            @Override
            public void onClick(View view) {
               x=a.getText().toString();
                y=b.getText().toString();
                z=c.getText().toString();

                h=Integer.parseInt(x);
                m=Integer.parseInt(y);
                s=Integer.parseInt(z);

                totalseconds = s + m*60 + h*3600 ;

                       hms = String.format("%02d : %02d %02d",h,m,s);

                if(totalseconds==0){
                    toastMsg("SET TIMER FIRST");
                }
                else{
                   b2.setEnabled(true);
                  b1.setEnabled(false);
                  b3.setEnabled(true);
                   calendar= Calendar.getInstance();
                    simpleDateFormat =new SimpleDateFormat("dd-MM-yyyy hh : mm a");
                    Date = simpleDateFormat.format(calendar.getTime());
                    countDownTimer = new CountDownTimer(totalseconds*1000,1000) {
                        @SuppressLint("DefaultLocale")
                        @Override
                        public void onTick(long l) {
                            ax=String.format("%02d",TimeUnit.MILLISECONDS.toHours(l));
                            by=String.format("%02d",TimeUnit.MILLISECONDS.toMinutes(l) -
                                    TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(l)));
                            cz=String.format("%02d",TimeUnit.MILLISECONDS.toSeconds(l) -
                                    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(l)));

                            a.setText(ax);
                            b.setText(by);
                            c.setText(cz);

                        }

                        public void onFinish() {
                            c.setText("00");
                            toastMsg("FINISHED");
                            b1.setEnabled(true);
                            b2.setEnabled(false);
                            b3.setEnabled(false);
                           notes(Date,name.getText(),hms);
                           ring.start();

                        }
                    }.start();


                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDownTimer.cancel();
                b2.setEnabled(false);
                b1.setEnabled(true);
                b3.setEnabled(false);
                toastMsg("Paused");

            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDownTimer.cancel();
                b2.setEnabled(false);
                b1.setEnabled(true);
                b3.setEnabled(false);
                a.setText("00");
                b.setText("00");
                c.setText("00");
                name.setText("");
                toastMsg("Stopped");
            }
        });

    }
   void notes(String date, Editable name, String time ){
        try{

            SQLiteDatabase db = this.openOrCreateDatabase("timing",MODE_PRIVATE,null);
            db.execSQL("CREATE TABLE IF NOT EXISTS data(DATE VARCHAR,NAME VARCHAR,TIME VARCHAR)");
            db.execSQL("INSERT INTO data(DATE,NAME,TIME) VALUES('"+date+"','"+name+"','"+time+"')");

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
