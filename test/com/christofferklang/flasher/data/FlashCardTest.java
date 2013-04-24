package com.christofferklang.flasher.data;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FlashCardTest {

  @Test
  public void emptyConstructor() {
    FlashCard card = new FlashCard();
    assertEquals("", card.getQuestion());
    assertEquals("", card.getAnswer());
  }

  @Test
  public void getQA() throws Exception {
    FlashCardEntry question = new FlashCardEntry("Dog");
    FlashCardEntry answer = new FlashCardEntry("Hund");

    FlashCard card = new FlashCard(question, answer);
    assertEquals("Dog", card.getQuestion());
    assertEquals("Hund", card.getAnswer());
  }
}
