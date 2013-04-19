package com.christofferklang.FlashCards;

public interface FlashCardAnswer {
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
