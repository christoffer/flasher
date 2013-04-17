package com.christofferklang.FlashCards;

import android.app.Application;

public class FlashCardsApp extends Application {
  private static FlashCardsApp mInstance;

  @Override
  public void onCreate() {
    super.onCreate();
    mInstance = this;
  }

  public static FlashCardsApp getInstance() {
    return mInstance;
  }
}
