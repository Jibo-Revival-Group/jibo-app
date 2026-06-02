package com.salesforce.androidsdk.accounts;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.salesforce.androidsdk.app.SalesforceSDKManager;
import com.salesforce.androidsdk.rest.ClientManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class UserAccountManager {
   private static UserAccountManager a;
   private Context b = SalesforceSDKManager.a().k();
   private AccountManager c = AccountManager.get(this.b);
   private String d = SalesforceSDKManager.a().B();

   protected UserAccountManager() {
   }

   public static UserAccountManager a() {
      if (a == null) {
         a = new UserAccountManager();
      }

      return a;
   }

   private void a(Bundle var1) {
      Bundle var2 = new Bundle();
      Intent var3 = new Intent(this.b, SalesforceSDKManager.a().f());
      var3.setFlags(268435456);
      var3.putExtras(var1);
      var2.putParcelable("intent", var3);
      this.b.startActivity(var3);
   }

   public UserAccount a(Account var1) {
      UserAccount var24;
      if (var1 == null) {
         var24 = null;
      } else {
         String var20 = SalesforceSDKManager.a().t();
         String var15 = SalesforceSDKManager.e(this.c.getUserData(var1, "authtoken"), var20);
         String var19 = SalesforceSDKManager.e(this.c.getPassword(var1), var20);
         String var11 = SalesforceSDKManager.e(this.c.getUserData(var1, "loginUrl"), var20);
         String var17 = SalesforceSDKManager.e(this.c.getUserData(var1, "id"), var20);
         String var12 = SalesforceSDKManager.e(this.c.getUserData(var1, "instanceUrl"), var20);
         String var9 = SalesforceSDKManager.e(this.c.getUserData(var1, "orgId"), var20);
         String var16 = SalesforceSDKManager.e(this.c.getUserData(var1, "userId"), var20);
         String var18 = SalesforceSDKManager.e(this.c.getUserData(var1, "username"), var20);
         String var14 = this.c.getUserData(var1, "authAccount");
         String var13 = SalesforceSDKManager.e(this.c.getUserData(var1, "clientId"), var20);
         String var10 = SalesforceSDKManager.e(this.c.getUserData(var1, "last_name"), var20);
         String var8 = SalesforceSDKManager.e(this.c.getUserData(var1, "email"), var20);
         String var3 = this.c.getUserData(var1, "first_name");
         String var2 = null;
         if (var3 != null) {
            var2 = SalesforceSDKManager.e(var3, var20);
         }

         String var4 = this.c.getUserData(var1, "display_name");
         var3 = null;
         if (var4 != null) {
            var3 = SalesforceSDKManager.e(this.c.getUserData(var1, "display_name"), var20);
         }

         String var5 = this.c.getUserData(var1, "photoUrl");
         var4 = null;
         if (var5 != null) {
            var4 = SalesforceSDKManager.e(var5, var20);
         }

         String var6 = this.c.getUserData(var1, "thumbnailUrl");
         var5 = null;
         if (var6 != null) {
            var5 = SalesforceSDKManager.e(var6, var20);
         }

         HashMap var7 = null;
         List var21 = SalesforceSDKManager.a().v();
         HashMap var29 = var7;
         if (var21 != null) {
            var29 = var7;
            if (!var21.isEmpty()) {
               var7 = new HashMap();
               Iterator var33 = var21.iterator();

               while (true) {
                  var29 = var7;
                  if (!var33.hasNext()) {
                     break;
                  }

                  String var22 = (String)var33.next();
                  if (!TextUtils.isEmpty(var22)) {
                     String var23 = this.c.getUserData(var1, var22);
                     var6 = null;
                     if (var23 != null) {
                        var6 = SalesforceSDKManager.e(var23, var20);
                     }

                     var7.put(var22, var6);
                  }
               }
            }
         }

         String var34 = this.c.getUserData(var1, "communityId");
         String var32 = null;
         if (var34 != null) {
            var32 = SalesforceSDKManager.e(var34, var20);
         }

         String var35 = this.c.getUserData(var1, "communityUrl");
         String var25 = null;
         if (var35 != null) {
            var25 = SalesforceSDKManager.e(var35, var20);
         }

         if (var15 != null && var12 != null && var16 != null && var9 != null) {
            var24 = new UserAccount(
               var15, var19, var11, var17, var12, var9, var16, var18, var14, var13, var32, var25, var2, var10, var3, var8, var4, var5, var29
            );
         } else {
            var24 = null;
         }
      }

      return var24;
   }

   public final void a(int var1, Bundle var2) {
      Intent var3 = new Intent("com.salesforce.USERSWITCHED");
      var3.setPackage(this.b.getPackageName());
      var3.putExtra("com.salesforce.USER_SWITCH_TYPE", var1);
      if (var2 != null) {
         var3.putExtras(var2);
      }

      SalesforceSDKManager.a().k().sendBroadcast(var3);
   }

   public void a(Activity var1) {
      SalesforceSDKManager.a().a(var1);
   }

   public void a(UserAccount var1, int var2, Bundle var3) {
      if (var1 == null || !this.a(var1)) {
         this.e();
      } else if (!var1.equals(this.b())) {
         ClientManager var4 = new ClientManager(this.b, this.d, SalesforceSDKManager.a().h(), true);
         Account var5 = var4.b(var1.i());
         this.a(var1.g(), var1.f());
         var4.a(var5);
         this.a(var2, var3);
      }
   }

   public void a(UserAccount var1, Activity var2) {
      Account var3 = this.b(var1);
      SalesforceSDKManager.a().a(var3, var2);
   }

   public void a(UserAccount var1, Activity var2, boolean var3) {
      Account var4 = this.b(var1);
      SalesforceSDKManager.a().a(var4, var2, var3);
   }

   public void a(String var1, String var2) {
      Editor var3 = this.b.getSharedPreferences("current_user_info", 0).edit();
      var3.putString("user_id", var1);
      var3.putString("org_id", var2);
      var3.commit();
   }

   public boolean a(UserAccount var1) {
      boolean var2;
      if (var1 == null) {
         var2 = false;
      } else {
         List var3 = this.d();
         if (var3 != null && var3.size() != 0) {
            Iterator var4 = var3.iterator();

            while (true) {
               if (!var4.hasNext()) {
                  var2 = false;
                  break;
               }

               if (var1.equals((UserAccount)var4.next())) {
                  var2 = true;
                  break;
               }
            }
         } else {
            var2 = false;
         }
      }

      return var2;
   }

   public Account b(UserAccount var1) {
      Account[] var6 = this.c.getAccountsByType(this.d);
      Account var9;
      if (var1 == null) {
         var9 = null;
      } else if (var6 != null && var6.length != 0) {
         String var4;
         if (var1.g() == null) {
            var4 = "";
         } else {
            var4 = var1.g();
         }

         String var10;
         if (var1.f() == null) {
            var10 = "";
         } else {
            var10 = var1.f();
         }

         int var3 = var6.length;
         int var2 = 0;

         while (true) {
            if (var2 >= var3) {
               var9 = null;
               break;
            }

            Account var5 = var6[var2];
            if (var5 != null) {
               String var8 = SalesforceSDKManager.a().t();
               String var7 = SalesforceSDKManager.e(this.c.getUserData(var5, "orgId"), var8);
               var8 = SalesforceSDKManager.e(this.c.getUserData(var5, "userId"), var8);
               if (var4.trim().equals(var8.trim()) && var10.trim().equals(var7.trim())) {
                  var9 = var5;
                  break;
               }
            }

            var2++;
         }
      } else {
         var9 = null;
      }

      return var9;
   }

   public UserAccount b() {
      return this.a(this.c());
   }

   public Account c() {
      Account[] var4 = this.c.getAccountsByType(this.d);
      Account var3;
      if (var4 != null && var4.length != 0) {
         SharedPreferences var9 = this.b.getSharedPreferences("current_user_info", 0);
         String var5 = var9.getString("user_id", "");
         String var6 = var9.getString("org_id", "");
         int var2 = var4.length;
         int var1 = 0;

         while (true) {
            if (var1 >= var2) {
               var3 = null;
               break;
            }

            var3 = var4[var1];
            if (var3 != null) {
               String var8 = SalesforceSDKManager.a().t();
               String var7 = SalesforceSDKManager.e(this.c.getUserData(var3, "orgId"), var8);
               var8 = SalesforceSDKManager.e(this.c.getUserData(var3, "userId"), var8);
               if (var5.trim().equals(var8) && var6.trim().equals(var7)) {
                  break;
               }
            }

            var1++;
         }
      } else {
         var3 = null;
      }

      return var3;
   }

   public List<UserAccount> d() {
      Object var5 = null;
      Account[] var6 = this.c.getAccountsByType(this.d);
      ArrayList var3 = (ArrayList)var5;
      if (var6 != null) {
         if (var6.length == 0) {
            var3 = (ArrayList)var5;
         } else {
            ArrayList var4 = new ArrayList();
            int var2 = var6.length;

            for (int var1 = 0; var1 < var2; var1++) {
               UserAccount var7 = this.a(var6[var1]);
               if (var7 != null) {
                  var4.add(var7);
               }
            }

            var3 = (ArrayList)var5;
            if (var4.size() != 0) {
               var3 = var4;
            }
         }
      }

      return var3;
   }

   public void e() {
      this.a(SalesforceSDKManager.a().h().i());
   }
}
