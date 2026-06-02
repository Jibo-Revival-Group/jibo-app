package com.salesforce.androidsdk.config;

public class AdminSettingsManager extends AbstractPrefsManager {
   @Override
   protected String a() {
      return "admin_prefs";
   }

   @Override
   protected boolean b() {
      return true;
   }
}
