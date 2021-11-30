package com.techtitudetribe.ncertkitab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class CBSEActivity extends AppCompatActivity {

    private LinearLayout cbseClass1, cbseClass2, cbseClass3, cbseClass4, cbseClass5,
            cbseClass6, cbseClass7, cbseClass8
            , cbseClass9, cbseClass10, cbseClass11, cbseClass12;
    private String board;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cbseactivity);

        board = getIntent().getStringExtra("board");

        cbseClass1 = (LinearLayout) findViewById(R.id.cbse_class1);
        cbseClass2 = (LinearLayout) findViewById(R.id.cbse_class2);
        cbseClass3 = (LinearLayout) findViewById(R.id.cbse_class3);
        cbseClass4 = (LinearLayout) findViewById(R.id.cbse_class4);
        cbseClass5 = (LinearLayout) findViewById(R.id.cbse_class5);
        cbseClass6 = (LinearLayout) findViewById(R.id.cbse_class6);
        cbseClass7 = (LinearLayout) findViewById(R.id.cbse_class7);
        cbseClass8 = (LinearLayout) findViewById(R.id.cbse_class8);
        cbseClass9 = (LinearLayout) findViewById(R.id.cbse_class9);
        cbseClass10 = (LinearLayout) findViewById(R.id.cbse_class10);
        cbseClass11 = (LinearLayout) findViewById(R.id.cbse_class11);
        cbseClass12 = (LinearLayout) findViewById(R.id.cbse_class12);




        cbseClass1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cbse_class_1 = new Intent(CBSEActivity.this, CbseSubjectActivity.class);
                cbse_class_1.putExtra("category", "Class1");
                cbse_class_1.putExtra("board",board);
                startActivity(cbse_class_1);
            }
        });

        cbseClass2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cbse_class_2 = new Intent(CBSEActivity.this, CbseSubjectActivity.class);
                cbse_class_2.putExtra("category", "class2");
                cbse_class_2.putExtra("board",board);
                startActivity(cbse_class_2);
            }
        });

        cbseClass3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cbse_class_3 = new Intent(CBSEActivity.this, CbseSubjectActivity.class);
                cbse_class_3.putExtra("category", "class3");
                cbse_class_3.putExtra("board",board);
                startActivity(cbse_class_3);
            }
        });

        cbseClass4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cbse_class_4 = new Intent(CBSEActivity.this, CbseSubjectActivity.class);
                cbse_class_4.putExtra("category", "Class4");
                cbse_class_4.putExtra("board",board);
                startActivity(cbse_class_4);
            }
        });

        cbseClass5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cbse_class_5 = new Intent(CBSEActivity.this, CbseSubjectActivity.class);
                cbse_class_5.putExtra("category", "Class5");
                cbse_class_5.putExtra("board",board);
                startActivity(cbse_class_5);
            }
        });
        cbseClass6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cbse_class_6 = new Intent(CBSEActivity.this, CbseSubjectActivity.class);
                cbse_class_6.putExtra("category", "Class6");
                cbse_class_6.putExtra("board",board);
                startActivity(cbse_class_6);
            }
        });

        cbseClass7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cbse_class_7 = new Intent(CBSEActivity.this, CbseSubjectActivity.class);
                cbse_class_7.putExtra("category", "Class7");
                cbse_class_7.putExtra("board",board);
                startActivity(cbse_class_7);
            }
        });

        cbseClass8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cbse_class_8 = new Intent(CBSEActivity.this, CbseSubjectActivity.class);
                cbse_class_8.putExtra("category", "Class8");
                cbse_class_8.putExtra("board",board);
                startActivity(cbse_class_8);
            }
        });

        cbseClass9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cbse_class_9 = new Intent(CBSEActivity.this, CbseSubjectActivity.class);
                cbse_class_9.putExtra("category", "Class9");
                cbse_class_9.putExtra("board",board);
                startActivity(cbse_class_9);
            }
        });

        cbseClass10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cbse_class_10 = new Intent(CBSEActivity.this, CbseSubjectActivity.class);
                cbse_class_10.putExtra("category", "Class10");
                cbse_class_10.putExtra("board",board);
                startActivity(cbse_class_10);
            }
        });

        cbseClass11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cbse_class_11 = new Intent(CBSEActivity.this, CbseSubjectActivity.class);
                cbse_class_11.putExtra("category", "Class11");
                cbse_class_11.putExtra("board",board);
                startActivity(cbse_class_11);
            }
        });

        cbseClass12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cbse_class_12 = new Intent(CBSEActivity.this, CbseSubjectActivity.class);
                cbse_class_12.putExtra("category", "Class12");
                cbse_class_12.putExtra("board",board);
                startActivity(cbse_class_12);
            }
        });

    }
}