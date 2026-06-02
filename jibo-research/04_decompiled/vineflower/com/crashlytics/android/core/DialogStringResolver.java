package com.crashlytics.android.core;

import android.content.Context;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.settings.PromptSettingsData;

class DialogStringResolver {
   private final Context a;
   private final PromptSettingsData b;

   public DialogStringResolver(Context var1, PromptSettingsData var2) {
      this.a = var1;
      this.b = var2;
   }

   private String a(String var1, String var2) {
      return this.b(CommonUtils.b(this.a, var1), var2);
   }

   private boolean a(String var1) {
      boolean var2;
      if (var1 != null && var1.length() != 0) {
         var2 = false;
      } else {
         var2 = true;
      }

      return var2;
   }

   private String b(String var1, String var2) {
      if (!this.a(var1)) {
         var2 = var1;
      }

      return var2;
   }

   public String a() {
      return this.a("com.crashlytics.CrashSubmissionPromptTitle", this.b.a);
   }

   public String b() {
      return this.a("com.crashlytics.CrashSubmissionPromptMessage", this.b.b);
   }

   public String c() {
      return this.a("com.crashlytics.CrashSubmissionSendTitle", this.b.c);
   }

   public String d() {
      return this.a("com.crashlytics.CrashSubmissionAlwaysSendTitle", this.b.g);
   }

   public String e() {
      return this.a("com.crashlytics.CrashSubmissionCancelTitle", this.b.e);
   }
}
