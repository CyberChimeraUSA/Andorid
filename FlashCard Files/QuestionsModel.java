package com.example.isaac.flashcards;

/**
 * Created by Isaac on 4/28/2017.
 */

public class QuestionsModel {
    private int mTextId;
    private boolean mAnswer;

    //create a construtor
    public QuestionsModel(int textId, boolean answer){
        mTextId = textId;
        mAnswer = answer;
    }
    //create the getter and setters for the constructor
    //these can be autogenerate as well
    public void setTextId(int textId) {
        mTextId = textId;
    }

    public void setAnswer(boolean answer) {
        mAnswer = answer;
    }


    public int getTextId() {
        return mTextId;
    }

    public boolean isAnswer() {
        return mAnswer;
    }

}
