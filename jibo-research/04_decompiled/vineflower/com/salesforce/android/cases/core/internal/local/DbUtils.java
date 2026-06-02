package com.salesforce.android.cases.core.internal.local;

import com.salesforce.androidsdk.accounts.UserAccount;
import com.salesforce.androidsdk.app.SalesforceSDKManager;
import java.util.List;

public final class DbUtils {
   public static boolean a(UserAccount var0) {
      List var2 = SalesforceSDKManager.a().o().d();
      boolean var1;
      if (var2 != null && var2.contains(var0)) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }
}
