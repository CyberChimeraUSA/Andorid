package com.example.isaac.flashcards;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivityController extends AppCompatActivity {
    //create Buttons and TextView for UI communcation
    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton;
    private TextView mQuestionTextView;

    //create the question bank
    private QuestionsModel[] mQuestionBank = new QuestionsModel[]{
            new QuestionsModel(R.string.question_java, true),
            new QuestionsModel(R.string.question_c, false),
            new QuestionsModel(R.string.question_python, true),
            new QuestionsModel(R.string.question_java2, false)
    };
    private int mCurrentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_controller);

        //calls to the UI (TextView)
        //displays the text
        mQuestionTextView = (TextView) findViewById(R.id.questions);
        //calls to the UI (Button)
        mTrueButton = (Button) findViewById(R.id.true_button);
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //will define method in a moment
                checkAnswer(true);
            }
        });
        mFalseButton = (Button) findViewById(R.id.false_button);
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
            }
        });

        mNextButton = (Button) findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                updateQuestion();
            }
        });
        //method declaration
        updateQuestion();
    }
    //method updateQuestion
    //void so no return
    private void updateQuestion(){
        int question = mQuestionBank[mCurrentIndex].getTextId();
        mQuestionTextView.setText(question);
    }
    private void checkAnswer(boolean userPress){
        boolean answerTrue = mQuestionBank[mCurrentIndex].isAnswer();
        int messageResId = 0;
        if (userPress == answerTrue){
            messageResId = R.string.correct_toast;
        }else{
            messageResId = R.string.incorrect_toast;
        }
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show();
    }
}
