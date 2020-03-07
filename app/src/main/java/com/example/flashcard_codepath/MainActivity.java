package com.example.flashcard_codepath;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.hide).setVisibility(View.VISIBLE);
        findViewById(R.id.see).setVisibility(View.INVISIBLE);

        TextView textView = (TextView) findViewById(R.id.Result);
        textView.setText("Select one");

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

    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent i) {
//        if (requestCode == 100) { // this 100 needs to match the 100 we used when we called startActivityForResult!
//            String EditQue = i.getExtras().getString("EditQue");
//            String EditAnsCorrect = i.getExtras().getString("EditAnsCorrect");
//            String EditAnswerIncorrect1 = i.getExtras().getString("EditAnswerIncorrect1");
//            String EditAnswerIncorrect2 = i.getExtras().getString("EditAnswerIncorrect2");
//            String EditAnswerIncorrect3 = i.getExtras().getString("EditAnswerIncorrect3");
//        }
//    }
}
