package com.christofferklang.flasher;

import com.christofferklang.flasher.data.FlashCard;

/**
 * Interface for ui interaction with a question card
 */
public interface QuestionCardUI {

  /**
   * Change the question
   */
  public void setQuestion(FlashCard card);
}
