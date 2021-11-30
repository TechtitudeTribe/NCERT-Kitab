package com.techtitudetribe.ncertkitab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView about, contactUs, share;
    private LinearLayout cbseLayout, upLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        about = (TextView) findViewById(R.id.about);
        contactUs = (TextView) findViewById(R.id.contact);
        share = (TextView) findViewById(R.id.share);
        cbseLayout = (LinearLayout) findViewById(R.id.cbse_layout);
        upLayout = (LinearLayout) findViewById(R.id.up_layout);


        cbseLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cbseActivity = new Intent(MainActivity.this, CBSEActivity.class);
                cbseActivity.putExtra("board","cbse");
                startActivity(cbseActivity);
            }
        });

        upLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent upActivity = new Intent(MainActivity.this,UPActivity.class);
                upActivity.putExtra("board","up");
                startActivity(upActivity);
            }
        });

        contactUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent contactActivity = new Intent(MainActivity.this, ContactActivity.class);
                startActivity(contactActivity);
            }
        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sharei = new Intent(Intent.ACTION_SEND);
                sharei.setType("plain/text");
                sharei.putExtra(Intent.EXTRA_SUBJECT, "Application Name");
                String shareMessage = "/n Try this application of NCERT  books with Solution as per the latest Syllabus \n\n";
                shareMessage = shareMessage + "url of the app" + "\n\n";
                sharei.putExtra(Intent.EXTRA_TEXT, shareMessage);
                startActivity(Intent.createChooser(sharei, "choose this"));

            }
        });
    }
}