package com.christofferklang.FlashCards;

import android.app.Activity;
import android.util.Log;

public class BaseActivity extends Activity {
  protected final String TAG = getClass().getSimpleName();

  /**
   * Log a message with debug level
   *
   * @param message Message to log
   */
  protected final void _debug(String message) {
    Log.d(TAG, message);
  }

  /**
   * Log a message with information level
   *
   * @param message Message to log
   */
  protected final void _info(String message) {
    Log.i(TAG, message);
  }

  /**
   * Log a message with verbose level
   *
   * @param message Message to log
   */
  protected final void _verbose(String message) {
    Log.v(TAG, message);
  }
}
