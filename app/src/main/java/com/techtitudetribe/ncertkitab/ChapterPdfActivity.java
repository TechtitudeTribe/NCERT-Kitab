package com.techtitudetribe.ncertkitab;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.storage.FirebaseStorage;

public class ChapterPdfActivity extends AppCompatActivity {

    private RecyclerView chapPdfList;
    private DatabaseReference chapterRef;
    private String category, board;
    private long  count = '0';

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_pdf);

        chapPdfList = (RecyclerView) findViewById(R.id.chap_pdf_list);
        chapterRef = FirebaseDatabase.getInstance().getReference().child(board).child(category);

        category = getIntent().getStringExtra("category");
        board = getIntent().getStringExtra("board");

        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        chapPdfList.setLayoutManager(layoutManager);

        viewpdflist();
    }

    private void viewpdflist() {

        Query pdf_list = chapterRef.orderByChild("count");

        FirebaseRecyclerAdapter<ChapterPdfAdapter, ChapterViewholder> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<ChapterPdfAdapter, ChapterViewholder>(

                        ChapterPdfAdapter.class,
                        R.layout.pdf_list,
                        ChapterViewholder.class,
                        pdf_list
                ) {
                    @Override
                    protected void populateViewHolder(ChapterViewholder chapterViewholder, ChapterPdfAdapter chapterPdfAdapter, int i) {

                        String key = getRef(i).getKey();

                        chapterViewholder.setname(chapterPdfAdapter.name);
                        chapterViewholder.setclass_name(chapterPdfAdapter.class_name);
                        chapterViewholder.setsub_pdf(chapterPdfAdapter.sub_pdf);
                        chapterViewholder.setchapter_name(chapterPdfAdapter.chapter_name);
                        chapterViewholder.setchap_number(chapterPdfAdapter.chapter_no);


                        chapterViewholder.mView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                Intent chapterIntent = new Intent(ChapterPdfActivity.this, ShowPdfActivity.class);
                                chapterIntent.putExtra("category", category);
                                startActivity(chapterIntent);
                            }
                        });


                    }
                };
        chapPdfList.setAdapter(firebaseRecyclerAdapter);





    }

    private class ChapterViewholder extends RecyclerView.ViewHolder {

        View mView;
        public ChapterViewholder(@NonNull View itemView) {
            super(itemView);

            mView = itemView;
        }

        public void setname(String name) {

            TextView sub_name = (TextView) mView.findViewById(R.id.subject_name);
            sub_name.setText(name);
        }

        public void setchap_number(String chapter_no) {

            TextView chapter_number = (TextView) mView.findViewById(R.id.subject_name);
            chapter_number.setText(chapter_no);
        }

        public void setchapter_name(String chapter_name) {
            TextView chap_name = (TextView) mView.findViewById(R.id.subject_name);
            chap_name.setText(chapter_name);
        }

        public void setclass_name(String class_name) {
            TextView class_no = (TextView) mView.findViewById(R.id.subject_name);
            class_no.setText(class_name);
        }

        public void setsub_pdf(String sub_pdf) {

            TextView subject_pdf = (TextView) mView.findViewById(R.id.subject_name);
            subject_pdf.setText(sub_pdf);
        }
    }
}