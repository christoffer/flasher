package com.christofferklang.flasher;

import android.app.FragmentManager;
import android.os.Bundle;
import com.christofferklang.flasher.data.FlashCard;
import com.christofferklang.flasher.data.FlashCardEntry;

import java.util.Stack;

import static com.christofferklang.flasher.data.FlashCardEntry.MASCULINE;
import static com.christofferklang.flasher.data.FlashCardEntry.NEUTER;
import static com.christofferklang.flasher.data.FlashCardEntry.NOUN;

public class FlashCardViewer extends BaseActivity implements FlashCardQuestionListener {
  private static AnswerCardUI mAnswerCard;
  private static QuestionCardUI mQuestionCard;
  private static DeckStatusBar mDeckStatusBar;

  private static final FlashCard EmptyFlashCard = new FlashCard();

  // TODO replace this with a persisted Deck class (with metadata)
  private Stack<FlashCard> mDeck = new Stack<FlashCard>();
  private FlashCard mCurrentCard;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    _verbose("onCreate");
    setContentView(R.layout.card_viewer);

    FragmentManager fragmentManager = getFragmentManager();
    mAnswerCard = (AnswerCardUI) fragmentManager.findFragmentById(R.id.fragmentAnswer);
    mQuestionCard = (QuestionCardUI) fragmentManager.findFragmentById(R.id.fragmentQuestion);
    mDeckStatusBar = (DeckStatusBar) findViewById(R.id.deckStatusBar);

    Stack<FlashCard> sampleDeck = createSampleDeck();
    setDeck(sampleDeck);
  }

  @Override
  public void onRevealAnswer() {
    _verbose("onRevealAnswer");
    mAnswerCard.revealAnswer(mCurrentCard.getAnswer());
  }

  @Override
  public void onWrongAnswer() {
    _verbose("onWrongAnswer");
    mDeck.push(mCurrentCard);
    popDeck();
  }

  @Override
  public void onCorrectAnswer() {
    _verbose("onCorrectAnswer");
    mDeckStatusBar.incrementComplete();
    popDeck();
  }

  /**
   * Reset the card viewer to display the given deck of flash cards
   */
  private void setDeck(Stack<FlashCard> deck) {
    mDeck = deck;
    mCurrentCard = null;
    // TODO Handle setting to empty decks
    mDeckStatusBar.resetDeckSize(mDeck.size());
    popDeck();
  }

  /**
   * Changes the current card to the next card in the deck and updates he UI.
   */
  private void popDeck() {
    if(mDeck.isEmpty()) {
      mCurrentCard = EmptyFlashCard;
    } else {
      mCurrentCard = mDeck.pop();
    }
    mQuestionCard.setQuestion(mCurrentCard);
  }

  /**
   * Helper to create a sample deck used during development.
   */
  private Stack<FlashCard> createSampleDeck() {
    Stack<FlashCard> sampleDeck = new Stack<FlashCard>();

    FlashCard boat_EN_DE = new FlashCard(
      new FlashCardEntry("Boat", NOUN),
      new FlashCardEntry("Boot", NOUN, NEUTER)
    );

    FlashCard dog_EN_DE = new FlashCard(
      new FlashCardEntry("Dog", NOUN),
      new FlashCardEntry("Hund", NOUN, MASCULINE)
    );

    sampleDeck.push(boat_EN_DE);
    sampleDeck.push(dog_EN_DE);

    return sampleDeck;
  }
}
