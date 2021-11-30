package com.techtitudetribe.ncertkitab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ContactActivity extends AppCompatActivity {
    private TextView helpMessage;
    private ImageView call, facebook, instagram, mail, twitter;
    private static String number = "91 7217281579";
    private  static final int REQUEST_CALL = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        call = findViewById(R.id.call_help);
        facebook = findViewById(R.id.fb_help);
        //instagram = findViewById(R.id.insta_help);
        mail = findViewById(R.id.mail_help);
        //twitter = findViewById(R.id.twitter_help);
        helpMessage = findViewById(R.id.help_message);

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              makePhoneCall();
            }
        });

        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
                Intent facebookIntent = openFacebook(ContactActivity.this);
                startActivity(facebookIntent);
            }
        });
        
        mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mailIntent = openMail(ContactActivity.this);
                startActivity(mailIntent);
            }
        });

        helpMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent whtsupIntent = openWhatsup(ContactActivity.this);
                startActivity(whtsupIntent);
            }
        });

    }

    private Intent openWhatsup(Context context) {
        try {
            context.getPackageManager()
                    .getPackageInfo("com.whatsapp",0);
            return new Intent(Intent.ACTION_VIEW, Uri.parse("https://api.whatsapp.com/send?phone="+ number));
        } catch (Exception ex) {
            return new Intent(Intent.ACTION_VIEW, Uri.parse("https://api.whatsapp.com/send?phone=" + number));
        }
    }

    private Intent openMail(Context context) {

        try {
            context.getPackageManager()
                    .getPackageInfo("com.google.android.gm",0);
            return new Intent(Intent.ACTION_VIEW, Uri.parse("mailto:techtitudetribe@gmail.com"));

        } catch (Exception ex ) {
            return new Intent(Intent.ACTION_VIEW, Uri.parse("https://mail.google.com/mail/u/2/#inbox?compose=new"));

        }

    }

    public static Intent openFacebook(Context context) {
        try
        {
            context.getPackageManager()
                    .getPackageInfo("com.facebook.katana", 0);
            return new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/101911428711055"));
        } catch (PackageManager.NameNotFoundException e) {
            Toast.makeText(context, "Ple" +
                    "+ase install facebook...", Toast.LENGTH_SHORT).show();
            return new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/profile.php?id=100027918345946"));

        }
        }



    private void makePhoneCall() {

        String number = "7217281579";
        if (ContextCompat.checkSelfPermission(ContactActivity.this,
                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(ContactActivity.this,
                    new String[] {Manifest.permission.CALL_PHONE}, REQUEST_CALL);
        }else
        {
            String diel = "tel:"+ number;
            startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(diel)));
        }

    }
}