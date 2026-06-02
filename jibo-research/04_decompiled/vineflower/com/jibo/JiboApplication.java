package com.jibo;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginManager;
import com.segment.analytics.Analytics;

public class JiboApplication extends BasicJiboApplication {
   static {
      System.loadLibrary("utils-jni");
   }

   private void c() {
      FacebookSdk.setApplicationId(this.getThirPartyKey1());
      FacebookSdk.sdkInitialize(this.getApplicationContext());
      AppEventsLogger.activateApp(this);
   }

   private void d() {
      Analytics.setSingletonInstance(new Analytics.Builder(this, this.getThirPartyKey4()).trackApplicationLifecycleEvents().build());
   }

   private void e() {
      JiboSupport.a(this);
   }

   @Override
   protected void a() {
      this.c();
      this.d();
      this.e();
   }

   @Override
   public void b() {
      LoginManager.getInstance().logOut();
      super.b();
   }

   public native String getThirPartyKey1();

   public native String getThirPartyKey4();
}
