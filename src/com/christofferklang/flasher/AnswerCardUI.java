package com.christofferklang.flasher;

/**
 * Interface for ui interaction with an answer card
 */
public interface AnswerCardUI {
  /**
   * Reveal the answer
   */
  public void revealAnswer(String answer);

  /**
   * Called when the user answered the question correctly
   */
  public void onCorrectAnswer();

  /**
   * Called when the user answered the question incorrectly
   */
  public void onWrongAnswer();
}
