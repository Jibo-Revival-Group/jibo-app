package com.jibo.aws.integration.helpers;

import com.jibo.aws.integration.aws.services.loop.model.MemberAccount;

public class AccountHelper {
   public static String getName(MemberAccount var0) {
      String var1;
      if (var0.getNickName() == null) {
         var1 = var0.getFirstName();
      } else {
         var1 = var0.getNickName();
      }

      return var1;
   }
}
