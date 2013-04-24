package com.christofferklang.flasher;

import android.app.Activity;
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
  private static Animation mAnimShow;
  private static Animation mAnimHideAsCorrect;
  private static Animation mAnimHideAsWrong;

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.answer_fragment, container, false);

    mTextAnswer = (TextView) view.findViewById(R.id.textAnswer);
    mTextAnswer.setText("");

    setupAnimation();

    return view;
  }

  private void setupAnimation() {
    Activity context = getActivity();
    mAnimShow = AnimationUtils.loadAnimation(context, R.anim.show_answer);
    mAnimHideAsCorrect = AnimationUtils.loadAnimation(context, R.anim.hide_answer_as_correct);
    mAnimHideAsWrong = AnimationUtils.loadAnimation(context, R.anim.hide_answer_as_wrong);

    final SimpleAnimationListener animationEndListener = new SimpleAnimationListener() {
      @Override
      public void onAnimationEnd(Animation animation) {
        mTextAnswer.setText("");
      }
    };

    mAnimHideAsCorrect.setAnimationListener(animationEndListener);
    mAnimHideAsWrong.setAnimationListener(animationEndListener);
  }

  @Override
  public void showAnswer(String answer) {
    // Ensure that the currently playing animation finishes and invokes
    // the animation listener to avoid a race on who determines what the
    // text box says
    Animation currentAnimation = mTextAnswer.getAnimation();
    if(currentAnimation != null && !currentAnimation.hasEnded()) {
      currentAnimation.cancel();
      currentAnimation.reset();
    }

    mTextAnswer.setText(answer);
    mTextAnswer.startAnimation(mAnimShow);
  }

  @Override
  public void onCorrectAnswer() {
    mTextAnswer.startAnimation(mAnimHideAsCorrect);
  }

  @Override
  public void onWrongAnswer() {
    mTextAnswer.startAnimation(mAnimHideAsWrong);
  }
}
