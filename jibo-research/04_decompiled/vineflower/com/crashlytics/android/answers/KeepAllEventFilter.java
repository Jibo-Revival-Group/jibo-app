package com.crashlytics.android.answers;

class KeepAllEventFilter implements EventFilter {
   @Override
   public boolean a(SessionEvent var1) {
      return false;
   }
}
