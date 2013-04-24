package com.christofferklang.flasher;

/**
 * Interface for ui interaction with an answer card
 */
public interface AnswerCardUI {
  /**
   * Show the answer to the user
   */
  public void showAnswer(String answer);

  /**
   * Called when the user answered the question correctly
   */
  public void onCorrectAnswer();

  /**
   * Called when the user answered the question incorrectly
   */
  public void onWrongAnswer();
}
