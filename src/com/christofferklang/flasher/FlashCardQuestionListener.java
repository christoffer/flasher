package com.christofferklang.flasher;

public interface FlashCardQuestionListener {
  /**
   * Called when the user want the answer revealed
   */
  public void onRevealAnswer();

  /**
   * Called when the user did not know the answer
   */
  public void onWrongAnswer();

  /**
   * Called when the user did know the answer
   */
  public void onCorrectAnswer();
}
