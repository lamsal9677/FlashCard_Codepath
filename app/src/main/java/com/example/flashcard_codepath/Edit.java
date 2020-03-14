package com.example.flashcard_codepath;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Edit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Edit.this, MainActivity.class);
                startActivity(i);
            }
        });

    }

    public void onSubmit(View v) {
        Intent i = new Intent();

        String EditQue = ((EditText) findViewById(R.id.EditQue)).getText().toString();
        String EditAnsCorrect = ((EditText) findViewById(R.id.EditAnsCorrect)).getText().toString();
        String EditAnswerIncorrect1 = ((EditText) findViewById(R.id.EditAnswerIncorrect1)).getText().toString();
        String EditAnswerIncorrect2 = ((EditText) findViewById(R.id.EditAnswerIncorrect2)).getText().toString();
        String EditAnswerIncorrect3 = ((EditText) findViewById(R.id.EditAnswerIncorrect3)).getText().toString();


        i.putExtra("EditQue",EditQue );
        i.putExtra("EditAnsCorrect", EditAnsCorrect);
        i.putExtra("EditAnswerIncorrect1", EditAnswerIncorrect1);
        i.putExtra("EditAnswerIncorrect2", EditAnswerIncorrect2);
        i.putExtra("EditAnswerIncorrect3", EditAnswerIncorrect3);

        setResult(RESULT_OK, i);
        finish();
    }
}
