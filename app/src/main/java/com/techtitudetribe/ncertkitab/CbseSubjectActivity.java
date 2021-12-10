package com.techtitudetribe.ncertkitab;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.squareup.picasso.Picasso;

public class CbseSubjectActivity extends AppCompatActivity {

    private RecyclerView cbseSubject;
    private DatabaseReference cbsesubref;
    private String category, board;
    private long  count = '0';

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cbse_subject);

        cbseSubject = (RecyclerView) findViewById(R.id.cbse_sub_recycler);
        category = getIntent().getStringExtra("category");
        board = getIntent().getStringExtra("board");

        cbsesubref = FirebaseDatabase.getInstance().getReference().child(board).child(category);


        GridLayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 2);
        cbseSubject.setLayoutManager(layoutManager);

        viewSubjectList();

    }

    private void viewSubjectList() {

        Query sub_list = cbsesubref.orderByChild("count");

        FirebaseRecyclerAdapter<SubjectAdapter, SubjectViewHolder> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<SubjectAdapter, SubjectViewHolder>(
                        SubjectAdapter.class,
                        R.layout.cbse_subject_layout,
                        SubjectViewHolder.class,
                        sub_list

                ) {
                    @Override
                    protected void populateViewHolder(SubjectViewHolder subjectViewHolder, SubjectAdapter subjectAdapter, int i) {

                        String key = getRef(i).getKey();

                        subjectViewHolder.setImage(subjectAdapter.getImage(), getApplicationContext());
                        subjectViewHolder.setname(subjectAdapter.name);


                        subjectViewHolder.mView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                Intent chapterIntent = new Intent(CbseSubjectActivity.this, ChapterPdfActivity.class);
                                chapterIntent.putExtra("key", key);
                                chapterIntent.putExtra("category", category);
                                startActivity(chapterIntent);

                            }
                        });


                    }
                };
        cbseSubject.setAdapter(firebaseRecyclerAdapter);
    }


    private class SubjectViewHolder extends RecyclerView.ViewHolder {

        View mView;

        public SubjectViewHolder(@NonNull View itemView) {

            super(itemView);
            mView = itemView;
        }

        public void setImage(String image, Context context) {
            ImageView sub_image = (ImageView) mView.findViewById(R.id.subject_picture);
            Picasso.with(context).load(image).into(sub_image);

        }

        public void setname(String name) {

            TextView sub_text = (TextView) mView.findViewById(R.id.subject_name);
            sub_text.setText(name);

        }
    }
}