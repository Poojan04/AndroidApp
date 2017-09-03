package com.example.rohan.carevault;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rohan.carevault.PeopleSecond;
import com.example.rohan.carevault.R;

import java.util.HashMap;

/**
 * Created by Rohan on 4/13/2016.
 */
public class People extends AppCompatActivity {
    EditText editText1, editText2, editText3;
    ImageButton backButton;

    // Session Manager Class
    SessionManager session;

    // Button Logout
    Button btnNxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.people);

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
        tv.setText(R.string.people);
        //session manager
        // Session class instance
        session = new SessionManager(getApplicationContext());

        editText1 = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText2 = (EditText) findViewById(R.id.editText3);
        // Button logout
       // btnNxt = (Button) findViewById(R.id.button2);


        // Toast.makeText(getApplicationContext(), "User Login Status: " + session.isLoggedIn(), Toast.LENGTH_LONG).show();


        /**
         * Call this function whenever you want to check user login
         * This will redirect user to LoginActivity is he is not
         * logged in
         * */
        //session.checkLogin();
/*
        // get user data from session
        HashMap<String, String> user = session.getUserDetails();

        // name
        String name = user.get(SessionManager.KEY_NAME);

        // email
        String email = user.get(SessionManager.KEY_EMAIL);

        // displaying user data
        lblName.setText(Html.fromHtml("Name: <b>" + name + "</b>"));
        lblEmail.setText(Html.fromHtml("Email: <b>" + email + "</b>"));

*/
        /**
         * Logout button click event
         * */
        //btnNxt.setOnClickListener(new View.OnClickListener() {





        // location and message
        editText1 = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);

        editText1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openContact();
                //dialog.dismiss();
            }

            private void openContact() {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType(ContactsContract.Contacts.CONTENT_TYPE);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(intent, 101);
                }
            }
        });
        editText2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openContact();
                //dialog.dismiss();
            }

            private void openContact() {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType(ContactsContract.Contacts.CONTENT_TYPE);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(intent, 102);
                }
            }
        });
        editText3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openContact();
                //dialog.dismiss();
            }

            private void openContact() {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType(ContactsContract.Contacts.CONTENT_TYPE);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(intent, 103);
                }
            }
        });
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == (101) && resultCode == RESULT_OK && null != data) {
            Uri contactData = data.getData();
            //String[] projection = { Phone.NUMBER, Phone.DISPLAY_NAME };

            Cursor c = managedQuery(contactData, null, null, null, null);
            if (c.moveToFirst()) {
                String id =
                        c.getString(c.getColumnIndexOrThrow(ContactsContract.Contacts._ID));

                String hasPhone =
                        c.getString(c.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER));

                if (hasPhone.equalsIgnoreCase("1")) {
                    Cursor phones = getContentResolver().query(
                            ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,
                            ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = " + id,
                            null, null);
                    phones.moveToFirst();
                    String phn_no1 = phones.getString(phones.getColumnIndex("data1"));
                    //String phn_no2 = phones.getString(phones.getColumnIndex("data2"));
                    //String phn_no3 = phones.getString(phones.getColumnIndex("data3"));
                    //String name = c.getString(c.getColumnIndex(ContactsContract.CommonDataKinds.StructuredPostal.DISPLAY_NAME));
                    //Toast.makeText(this, "contact info : " + phn_no + "\n" + name, Toast.LENGTH_LONG).show();

                    editText1.setText(phn_no1);
                    //editText2.setText(phn_no2);
                    //editText3.setText(phn_no3);
                }
            }
        } else if (requestCode == (102) && resultCode == RESULT_OK && null != data) {
            Uri contactData = data.getData();
            //String[] projection = { Phone.NUMBER, Phone.DISPLAY_NAME };

            Cursor c = managedQuery(contactData, null, null, null, null);
            if (c.moveToFirst()) {
                String id =
                        c.getString(c.getColumnIndexOrThrow(ContactsContract.Contacts._ID));

                String hasPhone =
                        c.getString(c.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER));

                if (hasPhone.equalsIgnoreCase("1")) {
                    Cursor phones = getContentResolver().query(
                            ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,
                            ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = " + id,
                            null, null);
                    phones.moveToFirst();
                    //String phn_no1 = phones.getString(phones.getColumnIndex("data1"));
                    String phn_no2 = phones.getString(phones.getColumnIndex("data1"));
                    //String phn_no3 = phones.getString(phones.getColumnIndex("data1"));
                    //String name = c.getString(c.getColumnIndex(ContactsContract.CommonDataKinds.StructuredPostal.DISPLAY_NAME));
                    //Toast.makeText(this, "contact info : " + phn_no + "\n" + name, Toast.LENGTH_LONG).show();

                    //editText1.setText(phn_no1);
                    editText2.setText(phn_no2);
                    //editText3.setText(phn_no3);
                }
            }
        } else //(requestCode == (101) && resultCode == RESULT_OK && null != data)
        {
            Uri contactData = data.getData();
            //String[] projection = { Phone.NUMBER, Phone.DISPLAY_NAME };

            Cursor c = managedQuery(contactData, null, null, null, null);
            if (c.moveToFirst()) {
                String id =
                        c.getString(c.getColumnIndexOrThrow(ContactsContract.Contacts._ID));

                String hasPhone =
                        c.getString(c.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER));

                if (hasPhone.equalsIgnoreCase("1")) {
                    Cursor phones = getContentResolver().query(
                            ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,
                            ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = " + id,
                            null, null);
                    phones.moveToFirst();
                    //String phn_no1 = phones.getString(phones.getColumnIndex("data1"));
                    //String phn_no2 = phones.getString(phones.getColumnIndex("data1"));
                    String phn_no3 = phones.getString(phones.getColumnIndex("data1"));
                    //String name = c.getString(c.getColumnIndex(ContactsContract.CommonDataKinds.StructuredPostal.DISPLAY_NAME));
                    //Toast.makeText(this, "contact info : " + phn_no + "\n" + name, Toast.LENGTH_LONG).show();

                    //editText1.setText(phn_no1);
                    //editText2.setText(phn_no2);
                    editText3.setText(phn_no3);
                }
            }
        }

    }

    public void save(View v){



        //Shared Preference

        SharedPreferences sharedPreferences=getSharedPreferences("IU",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("Contact1",editText1.getText().toString());
        editor.putString("Contact2", editText2.getText().toString());
        editor.putString("Contact3", editText3.getText().toString());
        editor.commit();



        String cn1 = editText1.getText().toString();
        String cn2 = editText2.getText().toString();
        String cn3 = editText3.getText().toString();
        // Check if username, password is filled
        if (cn1.trim().length() > 0 && cn2.trim().length() > 0 && cn3.trim().length() > 0) {
            //       session.createLoginSession();
            session.createLoginSession(cn1,cn2,cn3);
            Intent i = new Intent(getApplicationContext(), PeopleSecond.class);
            startActivity(i);
            Toast.makeText(this,"Contacts Saved Successfully",Toast.LENGTH_LONG).show();
            finish();
        } else {
            // username / password doesn't match
            Toast.makeText(getApplicationContext(), "Please Add all 3 Contacts", Toast.LENGTH_LONG).show();

        }


    }

//    public void next(View view){
//         Intent i=new Intent (this,Second.class);
//
//            startActivity(i);
//
//    }



//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }
public void back(View v) {

    Intent i = new Intent(getApplicationContext(), NavigationAlert.class);
    startActivity(i);


}
}

