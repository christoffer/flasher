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
  private static Animation mAnimReveal;
  private static Animation mAnimConcealCorrect;
  private static Animation mAnimConcealWrong;

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
    mAnimReveal = AnimationUtils.loadAnimation(context, R.anim.reveal_answer);
    mAnimConcealCorrect = AnimationUtils.loadAnimation(context, R.anim.conceal_correct);
    mAnimConcealWrong = AnimationUtils.loadAnimation(context, R.anim.conceal_wrong);

    final SimpleAnimationListener animationEndListener = new SimpleAnimationListener() {
      @Override
      public void onAnimationEnd(Animation animation) {
        mTextAnswer.setText("");
      }
    };

    mAnimConcealCorrect.setAnimationListener(animationEndListener);
    mAnimConcealWrong.setAnimationListener(animationEndListener);
  }

  @Override
  public void revealAnswer(String answer) {
    // Ensure that the currently playing animation finishes and invokes
    // the animation listener to avoid a race on who determines what the
    // text box says
    Animation currentAnimation = mTextAnswer.getAnimation();
    if(currentAnimation != null && !currentAnimation.hasEnded()) {
      currentAnimation.cancel();
      currentAnimation.reset();
    }

    mTextAnswer.setText(answer);
    mTextAnswer.startAnimation(mAnimReveal);
  }

  @Override
  public void onCorrectAnswer() {
    mTextAnswer.startAnimation(mAnimConcealCorrect);
  }

  @Override
  public void onWrongAnswer() {
    mTextAnswer.startAnimation(mAnimConcealWrong);
  }
}
