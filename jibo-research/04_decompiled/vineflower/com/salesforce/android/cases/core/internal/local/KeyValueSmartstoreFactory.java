package com.salesforce.android.cases.core.internal.local;

import com.salesforce.androidsdk.accounts.UserAccount;

public class KeyValueSmartstoreFactory {
   private final UserAccount a;

   public KeyValueSmartstoreFactory(UserAccount var1) {
      this.a = var1;
   }

   public KeyValueSmartstore a(String var1) {
      return new KeyValueSmartstore(var1, this.a);
   }
}
