package com.avidesousa.gridlayoutactividad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GridLayout g=findViewById(R.id.gridBotones);
        Random r=new Random();
        int colorInicial[]=new int[18];
        View.OnClickListener listener=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn=(Button)v;
                btn.setBackgroundColor(Color.WHITE);
            }
        };
        View.OnClickListener listenerReset=new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for(int i=0;i<g.getChildCount();i++){
                    Button btn=(Button)g.getChildAt(i);
                    btn.setBackgroundColor(colorInicial[i]);

                }
            }
        };

        for(int i=0;i<18;i++){
            Button b=new Button(this);

            if(i==17){
                b.setText("Reset");
                b.setOnClickListener(listenerReset);
            }else{
                b.setText("btn"+i);
                b.setOnClickListener(listener);
            }
            colorInicial[i]=Color.argb(128,r.nextInt(),r.nextInt(),r.nextInt());
            b.setBackgroundColor(colorInicial[i]);
            g.addView(b);
        }



    }
}