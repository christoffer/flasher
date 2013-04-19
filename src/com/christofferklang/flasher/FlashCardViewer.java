package com.christofferklang.flasher;

import android.app.FragmentManager;
import android.os.Bundle;

public class FlashCardViewer extends BaseActivity implements FlashCardQuestionListener {
  private static AnswerCardUI mAnswerCard;
  private static QuestionCardUI mQuestionCard;

  private String mCurrentQuestion;
  private String mCurrentAnswer;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    _verbose("onCreate");
    setContentView(R.layout.card_viewer);

    FragmentManager fragmentManager = getFragmentManager();
    mAnswerCard = (AnswerCardUI) fragmentManager.findFragmentById(R.id.fragmentAnswer);
    mQuestionCard = (QuestionCardUI) fragmentManager.findFragmentById(R.id.fragmentQuestion);

    // Sample word pair
    changeCurrentCard("Das Boot", "the boat");
  }

  @Override
  public void onRevealAnswer() {
    _verbose("onRevealAnswer");
    if(mCurrentAnswer != null) {
      mAnswerCard.revealAnswer(mCurrentAnswer);
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
    mQuestionCard.setQuestion(question);
  }
}
