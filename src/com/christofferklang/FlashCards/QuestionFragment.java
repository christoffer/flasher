package com.christofferklang.FlashCards;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Fragment responsible for showing the flash card question and handling
 * user interactions such as showing the answer or marking it at as correct
 * or incorrect.
 */
public class QuestionFragment extends Fragment implements FlashCardQuestion {
  private static TextView mTextQuestion;
  private FlashCardQuestionListener mListener;

  @Override
  public void onAttach(Activity activity) {
    super.onAttach(activity);
    try {
      mListener = (FlashCardQuestionListener) getActivity();
    } catch(ClassCastException ignored) {
      throw new RuntimeException("Parent activity must implement " + FlashCardQuestionListener.class.getName());
    }
  }

  @Override
  public void onDetach() {
    super.onDetach();
    mListener = null;
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.question_fragment, container, false);
    mTextQuestion = (TextView) view.findViewById(R.id.textQuestion);
    mTextQuestion.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        mListener.onRevealAnswer();
      }
    });
    return view;
  }

  @Override
  public void setQuestion(String question) {
    mTextQuestion.setText(question);
  }
}
