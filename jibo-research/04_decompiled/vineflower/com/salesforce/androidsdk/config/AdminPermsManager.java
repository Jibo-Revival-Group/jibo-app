package com.salesforce.androidsdk.config;

public class AdminPermsManager extends AbstractPrefsManager {
   @Override
   protected String a() {
      return "admin_perms";
   }

   @Override
   protected boolean b() {
      return false;
   }
}
