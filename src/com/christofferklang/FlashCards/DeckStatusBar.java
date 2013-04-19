package com.christofferklang.FlashCards;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DeckStatusBar extends LinearLayout {
  private TextView mTextCompleted;
  private TextView mTextRemaining;

  private int mCompleted = 0;
  private int mRemaining = 0;

  @SuppressWarnings("UnusedDeclaration")
  public DeckStatusBar(Context context) {
    this(context, null);
  }

  @SuppressWarnings("UnusedDeclaration")
  public DeckStatusBar(Context context, AttributeSet attrs) {
    this(context, attrs, 0);
  }

  @SuppressWarnings("UnusedDeclaration")
  public DeckStatusBar(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
    View.inflate(getContext(), R.layout._deck_status_bar, this);
    mTextRemaining = (TextView) findViewById(R.id.textRemaining);
    mTextCompleted = (TextView) findViewById(R.id.textCompleted);

    resetDeckSize(0);
  }

  /**
   * Resets remaining cards to the given deck size, and clears the
   * number of completed cards.
   *
   * @param deckSize Total number of cards in deck
   */
  public void resetDeckSize(int deckSize) {
    mRemaining = deckSize;
    mCompleted = 0;
    updateStatus();
  }

  /**
   * Tick a card off as completed
   */
  public void incrementComplete() {
    if(mRemaining > 0) {
      mCompleted++;
      mRemaining--;
    }
  }

  private void updateStatus() {
    mTextCompleted.setText(String.valueOf(mCompleted));
    mTextRemaining.setText(String.valueOf(mRemaining));
  }
}
