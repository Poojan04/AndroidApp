package com.example.rohan.carevault;

import android.app.FragmentManager;
import android.content.Intent;

import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {



Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1= (Button)findViewById(R.id.Button);
        b2= (Button) findViewById(R.id.Button1);

//        IntentFilter filter = new IntentFilter(Intent.ACTION_SCREEN_ON);
//        filter.addAction(Intent.ACTION_SCREEN_OFF);
//        MyReceiver mReceiver = new MyReceiver (this);
//        registerReceiver(mReceiver, filter);

        //Fragment
        FragHome frag=new FragHome();
        FragmentManager fragmentManager=getFragmentManager();
        android.app.FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.add(R.id.activity_home,frag);
        transaction.commit();


    }
    public void Alert(View v){
        Intent i=new Intent(this,NavigationAlert.class);
        startActivity(i);
    }
    public void Complaint(View v){
        Intent i=new Intent(this,NavigationComplaint.class);
        startActivity(i);
    }
}
