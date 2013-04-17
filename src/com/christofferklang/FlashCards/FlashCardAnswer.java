package com.christofferklang.FlashCards;

public interface FlashCardAnswer {
  /**
   * Reveal the answer
   */
  public void revealAnswer();

  /**
   * Set the current answer
   */
  public void setAnswer(String answer);
}
