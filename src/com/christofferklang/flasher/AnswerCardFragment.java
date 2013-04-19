package com.christofferklang.flasher;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

/**
 * Fragment responsible for showing the answer to the current flash card.
 */
public class AnswerCardFragment extends Fragment implements AnswerCardUI {
  private static TextView mTextAnswer;
  private static DeckStatusBar mDeckStatusBar;

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.answer_fragment, container, false);

    mTextAnswer = (TextView) view.findViewById(R.id.textAnswer);
    mDeckStatusBar = (DeckStatusBar) view.findViewById(R.id.deckStatusBar);

    mDeckStatusBar.resetDeckSize(0);
    mTextAnswer.setText("");
    return view;
  }

  @Override
  public void revealAnswer(String answer) {
    Animation revealAnswer = AnimationUtils.loadAnimation(getActivity(), R.anim.reveal_answer);
    mTextAnswer.setText(answer);
    mTextAnswer.startAnimation(revealAnswer);
  }

  @Override
  public void onCorrectAnswer() {
  }

  @Override
  public void onWrongAnswer() {
  }
}
