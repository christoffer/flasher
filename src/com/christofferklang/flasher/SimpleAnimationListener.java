package com.christofferklang.flasher;

import android.view.animation.Animation;

/**
 * Simple animation listener that overrides all callbacks with default (noop)
 * handling.
 */
public class SimpleAnimationListener implements Animation.AnimationListener {
  @Override
  public void onAnimationStart(Animation animation) {}

  @Override
  public void onAnimationEnd(Animation animation) {}

  @Override
  public void onAnimationRepeat(Animation animation) {}
}
