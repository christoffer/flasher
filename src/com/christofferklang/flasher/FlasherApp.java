package com.christofferklang.flasher;

import android.app.Application;

public class FlasherApp extends Application {
  private static FlasherApp mInstance;

  @Override
  public void onCreate() {
    super.onCreate();
    mInstance = this;
  }

  public static FlasherApp getInstance() {
    return mInstance;
  }
}
