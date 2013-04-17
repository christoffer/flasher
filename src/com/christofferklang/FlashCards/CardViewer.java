package com.christofferklang.FlashCards;

import android.app.Activity;
import android.os.Bundle;

public class CardViewer extends Activity {
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.card_viewer);
  }
}
