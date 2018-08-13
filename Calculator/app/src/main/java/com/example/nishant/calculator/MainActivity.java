package com.example.nishant.calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.nishnat.calculator.R;

public class MainActivity extends AppCompatActivity {

    Button login ;
    Button C;
    Button Div;
    Button Mul;
    Button Del;
    Button seven;
    Button eight;
    Button nine ;
    Button Min ;
    Button four;
    Button five;
    Button six ;
    Button Plus;
    Button one ;
    Button two ;
    Button three;
    Button Point;
    Button b_open ;
    Button zero ;
    Button b_close;
    Button Equal ;

    TextView text;

    String textfield=null ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //in on create we do findViewby id no outside

       login = (Button)findViewById(R.id.Login);
        C = (Button)findViewById(R.id.Clear);
        Div = (Button)findViewById(R.id.Div);
        Mul = (Button)findViewById(R.id.Mul);
        Del = (Button)findViewById(R.id.Del);
        seven = (Button)findViewById(R.id.seven);
        eight = (Button)findViewById(R.id.eight);
        nine = (Button)findViewById(R.id.nine);
        Min = (Button)findViewById(R.id.Min);
        four = (Button)findViewById(R.id.four);
        five = (Button)findViewById(R.id.five);
        six = (Button)findViewById(R.id.six);
        Plus = (Button)findViewById(R.id.Plus);
        one  = (Button)findViewById(R.id.one);
        two = (Button)findViewById(R.id.two);
        three = (Button)findViewById(R.id.three);
        Point = (Button)findViewById(R.id.point);
        b_open = (Button)findViewById(R.id.b_open);
        zero = (Button)findViewById(R.id.zero);
        b_close = (Button)findViewById(R.id.b_close);
        Equal = (Button)findViewById(R.id.equal);

        text = (TextView)findViewById(R.id.text);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });

        C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setText("");
            }
        });

        Div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setText(text.getText()+"/");
                textfield = (String) text.getText();
            }
        });

        Mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setText(text.getText()+"X");
                textfield = (String) text.getText();
            }
        });

        Del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = textfield;
                if (s.length()== 0){
                    text.setText("");
                }
                else {
                    s = s.substring(0, s.length() - 1);
                    text.setText(s);
                    textfield = s;
                }
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setText(text.getText()+"7");
                textfield = (String) text.getText();
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setText(text.getText()+"8");
                textfield = (String) text.getText();;
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setText(text.getText()+"9");
                textfield = (String) text.getText();
            }
        });

        Min.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setText(text.getText()+"-");
                textfield = (String) text.getText();
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setText(text.getText()+"4");
                textfield = (String) text.getText();
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setText(text.getText()+"5");
                textfield = (String) text.getText();
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setText(text.getText()+"6");
                textfield = (String) text.getText();
            }
        });

        Plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setText(text.getText()+"+");
                textfield = (String) text.getText();
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setText(text.getText()+"1");
                textfield = (String) text.getText();
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setText(text.getText()+"2");
                textfield = (String) text.getText();
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setText(text.getText()+"3");
                textfield = (String) text.getText();
            }
        });

        Point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setText(text.getText()+".");
                textfield = (String) text.getText();
            }
        });

        b_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setText(text.getText()+"(");
                textfield = (String) text.getText();
            }
        });

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setText(text.getText()+"0");
                textfield = (String) text.getText();
            }
        });

        b_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setText(text.getText()+")");
                textfield = (String) text.getText();
            }
        });
    }
}
