package com.christofferklang.FlashCards;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class AnswerFragment extends Fragment implements FlashCardAnswer {
  private static TextView mTextAnswer;
  private String mAnswer = "";

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_answer, container, false);
    mTextAnswer = (TextView) view.findViewById(R.id.textAnswer);
    return view;
  }

  @Override
  public void revealAnswer() {
    mTextAnswer.setText(mAnswer);
    mTextAnswer.setVisibility(View.VISIBLE);
  }

  @Override
  public void setAnswer(String answer) {
    hideAnswer();
    mAnswer = answer == null ? "" : answer;
  }

  private void hideAnswer() {
    mTextAnswer.setText("");
  }
}
