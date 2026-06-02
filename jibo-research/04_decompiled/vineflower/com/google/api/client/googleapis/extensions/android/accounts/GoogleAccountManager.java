package com.google.api.client.googleapis.extensions.android.accounts;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import com.google.api.client.util.Beta;
import com.google.api.client.util.Preconditions;

@Beta
public final class GoogleAccountManager {
   public static final String ACCOUNT_TYPE = "com.google";
   private final AccountManager manager;

   public GoogleAccountManager(AccountManager var1) {
      this.manager = Preconditions.checkNotNull(var1);
   }

   public GoogleAccountManager(Context var1) {
      this(AccountManager.get(var1));
   }

   public Account getAccountByName(String var1) {
      if (var1 != null) {
         for (Account var4 : this.getAccounts()) {
            if (var1.equals(var4.name)) {
               return var4;
            }
         }
      }

      return null;
   }

   public AccountManager getAccountManager() {
      return this.manager;
   }

   public Account[] getAccounts() {
      return this.manager.getAccountsByType("com.google");
   }

   public void invalidateAuthToken(String var1) {
      this.manager.invalidateAuthToken("com.google", var1);
   }
}
