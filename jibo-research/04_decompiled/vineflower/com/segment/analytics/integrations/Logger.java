package com.segment.analytics.integrations;

import android.util.Log;
import com.segment.analytics.Analytics;

public final class Logger {
   private static final String DEFAULT_TAG = "Analytics";
   public final Analytics.LogLevel logLevel;
   private final String tag;

   public Logger(String var1, Analytics.LogLevel var2) {
      this.tag = var1;
      this.logLevel = var2;
   }

   private boolean shouldLog(Analytics.LogLevel var1) {
      boolean var2;
      if (this.logLevel.ordinal() >= var1.ordinal()) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   public static Logger with(Analytics.LogLevel var0) {
      return new Logger("Analytics", var0);
   }

   public void debug(String var1, Object... var2) {
      if (this.shouldLog(Analytics.LogLevel.DEBUG)) {
         Log.d(this.tag, String.format(var1, var2));
      }
   }

   public void error(Throwable var1, String var2, Object... var3) {
      if (this.shouldLog(Analytics.LogLevel.INFO)) {
         Log.e(this.tag, String.format(var2, var3), var1);
      }
   }

   public void info(String var1, Object... var2) {
      if (this.shouldLog(Analytics.LogLevel.INFO)) {
         Log.i(this.tag, String.format(var1, var2));
      }
   }

   public Logger subLog(String var1) {
      return new Logger("Analytics-" + var1, this.logLevel);
   }

   public void verbose(String var1, Object... var2) {
      if (this.shouldLog(Analytics.LogLevel.VERBOSE)) {
         Log.v(this.tag, String.format(var1, var2));
      }
   }
}
