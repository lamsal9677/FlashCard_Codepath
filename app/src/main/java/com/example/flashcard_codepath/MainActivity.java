package com.example.flashcard_codepath;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    FlashcardDatabase flashcardDatabase;
    List<Flashcard> allFlashcards;
    int currentCardDisplayedIndex = 0;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        allFlashcards = flashcardDatabase.getAllCards();
        flashcardDatabase = new FlashcardDatabase(getApplicationContext());

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        allFlashcards = flashcardDatabase.getAllCards();

        Intent i = getIntent();

        String Que = i.getStringExtra("EditQue");
        TextView Q = (TextView) findViewById(R.id.Que);
        Q.setText(Que);

        String Ans1 = i.getStringExtra("EditAnswerIncorrect1");
        TextView A1 = (TextView) findViewById(R.id.Ans1);
        A1.setText(Ans1);

        String Ans2 = i.getStringExtra("EditAnsCorrect");
        TextView A2 = (TextView) findViewById(R.id.Ans2);
        A2.setText(Ans2);

        String Ans3 = i.getStringExtra("EditAnswerIncorrect2");
        TextView A3 = (TextView) findViewById(R.id.Ans3);
        A3.setText(Ans3);

        String Ans4 = i.getStringExtra("EditAnswerIncorrect3");
        TextView A4 = (TextView) findViewById(R.id.Ans4);
        A4.setText(Ans4);

        flashcardDatabase.insertCard(new Flashcard(Que, Ans1));

        findViewById(R.id.hide).setVisibility(View.VISIBLE);
        findViewById(R.id.see).setVisibility(View.INVISIBLE);

        TextView text = (TextView) findViewById(R.id.Result);

        if (allFlashcards != null && allFlashcards.size() > 0) {
            ((TextView) findViewById(R.id.Que)).setText(allFlashcards.get(0).getQuestion());
            ((TextView) findViewById(R.id.Ans1)).setText(allFlashcards.get(0).getAnswer());
        }


     text.setText("Select one");

        findViewById(R.id.hide).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//display none when hide is clicked
                findViewById(R.id.Ans1).setVisibility(View.INVISIBLE);
                findViewById(R.id.Ans2).setVisibility(View.INVISIBLE);
                findViewById(R.id.Ans3).setVisibility(View.INVISIBLE);
                findViewById(R.id.Ans4).setVisibility(View.INVISIBLE);
                findViewById(R.id.Result).setVisibility(View.INVISIBLE);
                findViewById(R.id.hide).setVisibility(View.INVISIBLE);
                findViewById(R.id.see).setVisibility(View.VISIBLE);
            }
        });

        findViewById(R.id.refresh).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.Ans1).setBackgroundResource(R.drawable.shape);
                findViewById(R.id.Ans2).setBackgroundResource(R.drawable.shape);
                findViewById(R.id.Ans3).setBackgroundResource(R.drawable.shape);
                findViewById(R.id.Ans4).setBackgroundResource(R.drawable.shape);

                TextView textView = (TextView) findViewById(R.id.Result);
                textView.setText("Select One");
            }
        });

        findViewById(R.id.see).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//display all when show is clicked
                findViewById(R.id.Ans1).setVisibility(View.VISIBLE);
                findViewById(R.id.Ans2).setVisibility(View.VISIBLE);
                findViewById(R.id.Ans3).setVisibility(View.VISIBLE);
                findViewById(R.id.Ans4).setVisibility(View.VISIBLE);
                findViewById(R.id.hide).setVisibility(View.VISIBLE);
                findViewById(R.id.see).setVisibility(View.INVISIBLE);
                findViewById(R.id.Result).setVisibility(View.VISIBLE);
            }
        });

        findViewById(R.id.Ans1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.Ans1).setBackgroundResource(R.drawable.incorrect);
                TextView result = (TextView) findViewById(R.id.Result);
                result.setText("Incorrect:(");
            }
        });

        findViewById(R.id.Ans2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.Ans2).setBackgroundResource(R.drawable.correct);
                TextView textView = (TextView) findViewById(R.id.Result);
                textView.setText("Correct!!");
            }
        });

        findViewById(R.id.Ans3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.Ans3).setBackgroundResource(R.drawable.incorrect);
                TextView textView = (TextView) findViewById(R.id.Result);
                textView.setText("Incorrect:(");
            }
        });

        findViewById(R.id.Ans4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.Ans4).setBackgroundResource(R.drawable.incorrect);
                TextView textView = (TextView) findViewById(R.id.Result);
                textView.setText("Incorrect:(");
            }
        });

        findViewById(R.id.next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Edit.class);
                MainActivity.this.startActivityForResult(i, 100);
            }
        });

        findViewById(R.id.nextt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentCardDisplayedIndex++;

                // make sure we don't get an IndexOutOfBoundsError if we are viewing the last indexed card in our list
                if (currentCardDisplayedIndex > allFlashcards.size() - 1) {
                    currentCardDisplayedIndex = 0;
                }

                // set the question and answer TextViews with data from the database
                ((TextView) findViewById(R.id.Que)).setText(allFlashcards.get(currentCardDisplayedIndex).getQuestion());
                ((TextView) findViewById(R.id.Ans1)).setText(allFlashcards.get(currentCardDisplayedIndex).getAnswer());
            }
        });

        findViewById(R.id.trash).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flashcardDatabase.deleteCard(((TextView) findViewById(R.id.Que)).getText().toString());
                allFlashcards = flashcardDatabase.getAllCards();
            }
        });

    }

}
