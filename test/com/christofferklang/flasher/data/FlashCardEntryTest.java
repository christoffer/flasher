package com.christofferklang.flasher.data;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FlashCardEntryTest {

  @Test
  public void emptyConstructor() {
    FlashCardEntry entry = new FlashCardEntry();
    assertEquals("", entry.getText());
    assertEquals(FlashCardEntry.NONE, entry.getPrimaryGroup());
    assertEquals(FlashCardEntry.NONE, entry.getSecondaryGroup());
  }

  @Test
  public void textOnlyConstructor() {
    FlashCardEntry entry = new FlashCardEntry("Unicorn");
    assertEquals("Unicorn", entry.getText());
    assertEquals(FlashCardEntry.NONE, entry.getPrimaryGroup());
    assertEquals(FlashCardEntry.NONE, entry.getSecondaryGroup());
  }

  @Test
  public void languageCodeConstructor() {
    FlashCardEntry entry = new FlashCardEntry("Unicorn", 123);
    assertEquals("Unicorn", entry.getText());
    assertEquals(123, entry.getLanguageCode());
    assertEquals(FlashCardEntry.NONE, entry.getPrimaryGroup());
    assertEquals(FlashCardEntry.NONE, entry.getSecondaryGroup());
  }

  @Test
  public void primaryGroupConstructor() {
    FlashCardEntry entry = new FlashCardEntry("Unicorn", 123, 42);
    assertEquals("Unicorn", entry.getText());
    assertEquals(123, entry.getLanguageCode());
    assertEquals(42, entry.getPrimaryGroup());
    assertEquals(FlashCardEntry.NONE, entry.getSecondaryGroup());
  }

  @Test
  public void fullConstructor() {
    FlashCardEntry entry = new FlashCardEntry("Unicorn", 123, 42, 67);
    assertEquals("Unicorn", entry.getText());
    assertEquals(123, entry.getLanguageCode());
    assertEquals(42, entry.getPrimaryGroup());
    assertEquals(67, entry.getSecondaryGroup());
  }
}
