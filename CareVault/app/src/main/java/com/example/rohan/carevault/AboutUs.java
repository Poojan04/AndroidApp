package com.example.rohan.carevault;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by pooja_000 on 5/25/2016.
 */
public class AboutUs extends AppCompatActivity {
    ImageButton backButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_us);

        Toolbar tb = (Toolbar) findViewById(R.id.toolbar);
        backButton = (ImageButton) findViewById(R.id.back);
        // title = (TextView) findViewById(R.id.toolbar_title);

        //  title.setText(R.string.welcome);
        backButton.setVisibility(View.VISIBLE);
        backButton.setImageResource(R.drawable.ic_keyboard_arrow_left_24dp);
//    notificationIcon.setImageResource(R.drawable.notification);
//    notificationIcon.setVisibility(View.VISIBLE);

        setSupportActionBar(tb);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.title);
        //  getSupportActionBar().setTitle("Help");
        TextView tv= (TextView) findViewById(R.id.ab);
        tv.setText(R.string.about);

    }

    public void back(View v) {

        Intent i = new Intent(getApplicationContext(), NavigationAlert.class);
        startActivity(i);


    }


}
