package com.example.learntable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int p=1;
    public void table(int TimesTable)
    {

        ArrayList<String> content = new ArrayList<>();
        for(int i=1;i<=10;i++)
        {
            content.add(TimesTable+"*" +Integer.toString(i)+"=" +Integer.toString(i*TimesTable));


        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,content);
        tt.setAdapter(arrayAdapter);


    }
    ListView tt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        new CountDownTimer(10000,1000)
//        {
//            public void onTick(long milli)
//            {
//
//            }
//            public void onFinish()
//            {
//
//            }.start();
//        }
       final SeekBar s= (SeekBar)findViewById(R.id.seekBar);
         tt= (ListView)findViewById(R.id.table);
        s.setMax(20);
        s.setProgress(1);
s.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
        int min=1;
        int TimesTable;
        if(progress<min)
        {
          TimesTable=min;
          s.setProgress(min);
        }
        else
        {
            TimesTable=progress;

        }
        table(TimesTable);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
});
table(1);

    }
}