package android.support.v7.view;

import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window.Callback;
import android.view.WindowManager.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

public class WindowCallbackWrapper implements Callback {
   final Callback e;

   public WindowCallbackWrapper(Callback var1) {
      if (var1 == null) {
         throw new IllegalArgumentException("Window callback may not be null");
      }

      this.e = var1;
   }

   public boolean dispatchGenericMotionEvent(MotionEvent var1) {
      return this.e.dispatchGenericMotionEvent(var1);
   }

   public boolean dispatchKeyEvent(KeyEvent var1) {
      return this.e.dispatchKeyEvent(var1);
   }

   public boolean dispatchKeyShortcutEvent(KeyEvent var1) {
      return this.e.dispatchKeyShortcutEvent(var1);
   }

   public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent var1) {
      return this.e.dispatchPopulateAccessibilityEvent(var1);
   }

   public boolean dispatchTouchEvent(MotionEvent var1) {
      return this.e.dispatchTouchEvent(var1);
   }

   public boolean dispatchTrackballEvent(MotionEvent var1) {
      return this.e.dispatchTrackballEvent(var1);
   }

   public void onActionModeFinished(android.view.ActionMode var1) {
      this.e.onActionModeFinished(var1);
   }

   public void onActionModeStarted(android.view.ActionMode var1) {
      this.e.onActionModeStarted(var1);
   }

   public void onAttachedToWindow() {
      this.e.onAttachedToWindow();
   }

   public void onContentChanged() {
      this.e.onContentChanged();
   }

   public boolean onCreatePanelMenu(int var1, Menu var2) {
      return this.e.onCreatePanelMenu(var1, var2);
   }

   public View onCreatePanelView(int var1) {
      return this.e.onCreatePanelView(var1);
   }

   public void onDetachedFromWindow() {
      this.e.onDetachedFromWindow();
   }

   public boolean onMenuItemSelected(int var1, MenuItem var2) {
      return this.e.onMenuItemSelected(var1, var2);
   }

   public boolean onMenuOpened(int var1, Menu var2) {
      return this.e.onMenuOpened(var1, var2);
   }

   public void onPanelClosed(int var1, Menu var2) {
      this.e.onPanelClosed(var1, var2);
   }

   public void onPointerCaptureChanged(boolean var1) {
      this.e.onPointerCaptureChanged(var1);
   }

   public boolean onPreparePanel(int var1, View var2, Menu var3) {
      return this.e.onPreparePanel(var1, var2, var3);
   }

   public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> var1, Menu var2, int var3) {
      this.e.onProvideKeyboardShortcuts(var1, var2, var3);
   }

   public boolean onSearchRequested() {
      return this.e.onSearchRequested();
   }

   public boolean onSearchRequested(SearchEvent var1) {
      return this.e.onSearchRequested(var1);
   }

   public void onWindowAttributesChanged(LayoutParams var1) {
      this.e.onWindowAttributesChanged(var1);
   }

   public void onWindowFocusChanged(boolean var1) {
      this.e.onWindowFocusChanged(var1);
   }

   public android.view.ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback var1) {
      return this.e.onWindowStartingActionMode(var1);
   }

   public android.view.ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback var1, int var2) {
      return this.e.onWindowStartingActionMode(var1, var2);
   }
}
