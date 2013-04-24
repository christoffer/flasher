package com.christofferklang.flasher;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import com.christofferklang.flasher.data.FlashCard;

/**
 * Fragment responsible for showing the flash card question and handling
 * user interactions such as showing the answer or marking it at as correct
 * or incorrect.
 */
public class QuestionCardFragment extends Fragment implements QuestionCardUI {
  private static TextView mTextQuestion;
  private static Button mButtonCorrect;
  private static Button mButtonWrong;

  private static FlashCardQuestionListener mListener;
  private static Animation hideAnswerAnimation;

  @Override
  public void onAttach(Activity activity) {
    super.onAttach(activity);
    try {
      mListener = (FlashCardQuestionListener) getActivity();
    } catch(ClassCastException ignored) {
      throw new RuntimeException("Parent activity must implement " +
        FlashCardQuestionListener.class.getName());
    }
  }

  @Override
  public void onDetach() {
    super.onDetach();
    mListener = null;
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.question_fragment, container, false);

    mTextQuestion = (TextView) view.findViewById(R.id.textQuestion);
    mButtonCorrect = (Button) view.findViewById(R.id.buttonCorrect);
    mButtonWrong = (Button) view.findViewById(R.id.buttonWrong);

    bindEvents();
    setupAnimations();

    mTextQuestion.setText("");
    hideResultButtons();

    return view;
  }

  @Override
  public void setQuestion(FlashCard flashCard) {
    mTextQuestion.setText(flashCard.getQuestion());
  }

  private void bindEvents() {
    mTextQuestion.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        onRevealAnswer();
      }
    });

    mButtonCorrect.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        onCorrect();
      }
    });

    mButtonWrong.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        onWrong();
      }
    });
  }

  /**
   * Do the heavy XML inflating up front
   */
  private void setupAnimations() {
    hideAnswerAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.hide_answer);
  }

  private void onRevealAnswer() {
    mTextQuestion.startAnimation(hideAnswerAnimation);
    mListener.onRevealAnswer();
    showResultButtons();
  }

  private void onCorrect() {
    mListener.onCorrectAnswer();
    hideResultButtons();
  }

  private void onWrong() {
    mListener.onWrongAnswer();
    hideResultButtons();
  }

  private void showResultButtons() {
    mButtonCorrect.setVisibility(View.VISIBLE);
    mButtonWrong.setVisibility(View.VISIBLE);
  }

  private void hideResultButtons() {
    mButtonCorrect.setVisibility(View.INVISIBLE);
    mButtonWrong.setVisibility(View.INVISIBLE);
  }
}
