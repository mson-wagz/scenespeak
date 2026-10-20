package com.anonymous.MultiTVSample
import expo.modules.splashscreen.SplashScreenManager
// @generated begin react-native-keyevent-import - expo prebuild (DO NOT MODIFY) sync-623c552ef74f8e382965ed2451e2658312c33112
import android.view.KeyEvent
import com.github.kevinejohn.keyevent.KeyEventModule
// @generated end react-native-keyevent-import

import android.os.Build
import android.os.Bundle

import com.facebook.react.ReactActivity
import com.facebook.react.ReactActivityDelegate
import com.facebook.react.defaults.DefaultNewArchitectureEntryPoint.fabricEnabled
import com.facebook.react.defaults.DefaultReactActivityDelegate

import expo.modules.ReactActivityDelegateWrapper

class MainActivity : ReactActivity() {
// @generated begin react-native-keyevent-body - expo prebuild (DO NOT MODIFY) sync-a52e712f828fc51c64cea2889e95c7696d9cd3f1
override fun dispatchKeyEvent(event: KeyEvent): Boolean {
  when (event.action) {
    KeyEvent.ACTION_DOWN -> KeyEventModule.getInstance().onKeyDownEvent(event.keyCode, event)
    KeyEvent.ACTION_UP -> KeyEventModule.getInstance().onKeyUpEvent(event.keyCode, event)
  }
  return super.dispatchKeyEvent(event)
}

override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
  super.onKeyDown(keyCode, event)
  return true
}

override fun onKeyUp(keyCode: Int, event: KeyEvent): Boolean {
  super.onKeyUp(keyCode, event)
  return true
}

override fun onKeyMultiple(keyCode: Int, repeatCount: Int, event: KeyEvent): Boolean {
  KeyEventModule.getInstance().onKeyMultipleEvent(keyCode, repeatCount, event)
  return super.onKeyMultiple(keyCode, repeatCount, event)
}
// @generated end react-native-keyevent-body
  override fun onCreate(savedInstanceState: Bundle?) {
    // Set the theme to AppTheme BEFORE onCreate to support
    // coloring the background, status bar, and navigation bar.
    // This is required for expo-splash-screen.
    // setTheme(R.style.AppTheme);
    // @generated begin expo-splashscreen - expo prebuild (DO NOT MODIFY) sync-f3ff59a738c56c9a6119210cb55f0b613eb8b6af
    SplashScreenManager.registerOnActivity(this)
    // @generated end expo-splashscreen
    super.onCreate(null)
  }

  /**
   * Returns the name of the main component registered from JavaScript. This is used to schedule
   * rendering of the component.
   */
  override fun getMainComponentName(): String = "main"

  /**
   * Returns the instance of the [ReactActivityDelegate]. We use [DefaultReactActivityDelegate]
   * which allows you to enable New Architecture with a single boolean flags [fabricEnabled]
   */
  override fun createReactActivityDelegate(): ReactActivityDelegate {
    return ReactActivityDelegateWrapper(
          this,
          BuildConfig.IS_NEW_ARCHITECTURE_ENABLED,
          object : DefaultReactActivityDelegate(
              this,
              mainComponentName,
              fabricEnabled
          ){})
  }

  /**
    * Align the back button behavior with Android S
    * where moving root activities to background instead of finishing activities.
    * @see <a href="https://developer.android.com/reference/android/app/Activity#onBackPressed()">onBackPressed</a>
    */
  override fun invokeDefaultOnBackPressed() {
      if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.R) {
          if (!moveTaskToBack(false)) {
              // For non-root activities, use the default implementation to finish them.
              super.invokeDefaultOnBackPressed()
          }
          return
      }

      // Use the default back button implementation on Android S
      // because it's doing more than [Activity.moveTaskToBack] in fact.
      super.invokeDefaultOnBackPressed()
  }
}
