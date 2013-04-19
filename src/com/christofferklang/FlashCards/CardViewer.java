package com.christofferklang.FlashCards;

import android.app.FragmentManager;
import android.os.Bundle;

public class CardViewer extends BaseActivity implements FlashCardQuestionListener {
  private static FlashCardAnswer mAnswer;
  private static FlashCardQuestion mQuestion;
  private String mCurrentQuestion;
  private String mCurrentAnswer;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    _verbose("onCreate");
    setContentView(R.layout.card_viewer);

    FragmentManager fragmentManager = getFragmentManager();
    mAnswer = (FlashCardAnswer) fragmentManager.findFragmentById(R.id.fragmentAnswer);
    mQuestion = (FlashCardQuestion) fragmentManager.findFragmentById(R.id.fragmentQuestion);

    changeCurrentCard("Das Boot", "the boat");
  }

  @Override
  public void onRevealAnswer() {
    _verbose("onRevealAnswer");
    if(mCurrentAnswer != null) {
      mAnswer.revealAnswer(mCurrentAnswer);
    }
  }

  @Override
  public void onWrongAnswer() {
    _verbose("onWrongAnswer");
  }

  @Override
  public void onCorrectAnswer() {
    _verbose("onCorrectAnswer");
  }

  private void changeCurrentCard(String question, String answer) {
    mCurrentQuestion = question;
    mCurrentAnswer = answer;
    mQuestion.setQuestion(question);
  }
}
