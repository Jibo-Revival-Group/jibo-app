package com.salesforce.androidsdk.smartstore.app;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.salesforce.androidsdk.accounts.UserAccount;
import com.salesforce.androidsdk.app.SalesforceSDKManager;
import com.salesforce.androidsdk.smartstore.store.DBOpenHelper;
import com.salesforce.androidsdk.smartstore.store.SmartStore;
import com.salesforce.androidsdk.ui.LoginActivity;
import com.salesforce.androidsdk.util.EventsObservable;

public class SmartStoreSDKManager extends SalesforceSDKManager {
   protected SmartStoreSDKManager(Context var1, SalesforceSDKManager.KeyInterface var2, Class<? extends Activity> var3, Class<? extends Activity> var4) {
      super(var1, var2, var3, var4);
   }

   public static SmartStoreSDKManager H() {
      if (b != null) {
         return (SmartStoreSDKManager)b;
      } else {
         throw new RuntimeException("Applications need to call SalesforceSDKManagerWithSmartStore.init() first.");
      }
   }

   public static void a(Context var0, SalesforceSDKManager.KeyInterface var1, Class<? extends Activity> var2) {
      a(var0, var1, var2, LoginActivity.class);
   }

   private static void a(Context var0, SalesforceSDKManager.KeyInterface var1, Class<? extends Activity> var2, Class<? extends Activity> var3) {
      if (b == null) {
         b = new SmartStoreSDKManager(var0, var1, var2, var3);
      }

      a(var0);
      SmartStoreUpgradeManager.f().b();
      EventsObservable.a().a(EventsObservable.EventType.AppCreateComplete);
   }

   public void I() {
      this.c(this.o().b());
   }

   public SmartStore a(UserAccount var1, String var2) {
      return this.a("smartstore", var1, var2);
   }

   public SmartStore a(String var1, UserAccount var2, String var3) {
      String var4 = var1;
      if (TextUtils.isEmpty(var1)) {
         var4 = "smartstore";
      }

      SalesforceSDKManager.a().e("US");
      String var5 = this.t();
      var1 = var5;
      if (var5 == null) {
         var1 = this.c(null);
      }

      return new SmartStore(DBOpenHelper.a(this.c, var4, var2, var3), var1);
   }

   @Override
   protected void a(UserAccount var1) {
      if (var1 != null) {
         DBOpenHelper.a(this.k(), var1);
      } else {
         DBOpenHelper.b(this.k());
      }

      super.a(var1);
   }

   public SmartStore b(UserAccount var1) {
      return this.a(var1, null);
   }

   public void b(UserAccount var1, String var2) {
      this.b("smartstore", var1, var2);
   }

   public void b(String var1, UserAccount var2, String var3) {
      String var4 = var1;
      if (TextUtils.isEmpty(var1)) {
         var4 = "smartstore";
      }

      DBOpenHelper.b(this.c, var4, var2, var3);
   }

   @Override
   public void b(String param1, String param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index -1 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1065)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.verifyFinallyEx(FinallyProcessor.java:566)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:90)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: aload 0
      // 01: monitorenter
      // 02: aload 0
      // 03: aload 1
      // 04: aload 2
      // 05: invokevirtual com/salesforce/androidsdk/smartstore/app/SmartStoreSDKManager.c (Ljava/lang/String;Ljava/lang/String;)Z
      // 08: ifeq 63
      // 0b: invokestatic com/salesforce/androidsdk/smartstore/store/DBOpenHelper.a ()Ljava/util/Map;
      // 0e: astore 3
      // 0f: aload 3
      // 10: ifnull 5d
      // 13: aload 3
      // 14: invokeinterface java/util/Map.values ()Ljava/util/Collection; 1
      // 19: astore 3
      // 1a: aload 3
      // 1b: ifnull 5d
      // 1e: aload 3
      // 1f: invokeinterface java/util/Collection.iterator ()Ljava/util/Iterator; 1
      // 24: astore 3
      // 25: aload 3
      // 26: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 2b: ifeq 5d
      // 2e: aload 3
      // 2f: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 34: checkcast com/salesforce/androidsdk/smartstore/store/DBOpenHelper
      // 37: astore 4
      // 39: aload 4
      // 3b: ifnull 25
      // 3e: aload 4
      // 40: aload 0
      // 41: aload 1
      // 42: invokevirtual com/salesforce/androidsdk/smartstore/app/SmartStoreSDKManager.c (Ljava/lang/String;)Ljava/lang/String;
      // 45: invokevirtual com/salesforce/androidsdk/smartstore/store/DBOpenHelper.getWritableDatabase (Ljava/lang/String;)Lnet/sqlcipher/database/SQLiteDatabase;
      // 48: aload 0
      // 49: aload 1
      // 4a: invokevirtual com/salesforce/androidsdk/smartstore/app/SmartStoreSDKManager.c (Ljava/lang/String;)Ljava/lang/String;
      // 4d: aload 0
      // 4e: aload 2
      // 4f: invokevirtual com/salesforce/androidsdk/smartstore/app/SmartStoreSDKManager.c (Ljava/lang/String;)Ljava/lang/String;
      // 52: invokestatic com/salesforce/androidsdk/smartstore/store/SmartStore.a (Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;)V
      // 55: goto 25
      // 58: astore 1
      // 59: aload 0
      // 5a: monitorexit
      // 5b: aload 1
      // 5c: athrow
      // 5d: aload 0
      // 5e: aload 1
      // 5f: aload 2
      // 60: invokespecial com/salesforce/androidsdk/app/SalesforceSDKManager.b (Ljava/lang/String;Ljava/lang/String;)V
      // 63: aload 0
      // 64: monitorexit
      // 65: return
      // try (2 -> 9): 41 null
      // try (11 -> 14): 41 null
      // try (16 -> 19): 41 null
      // try (19 -> 26): 41 null
      // try (28 -> 40): 41 null
      // try (46 -> 50): 41 null
   }

   public void c(UserAccount var1) {
      this.b(var1, null);
   }

   public SmartStore g(String var1) {
      SalesforceSDKManager.a().e("GS");
      String var2 = var1;
      if (TextUtils.isEmpty(var1)) {
         var2 = "smartstore";
      }

      String var3 = this.t();
      var1 = var3;
      if (var3 == null) {
         var1 = this.c(null);
      }

      return new SmartStore(DBOpenHelper.a(this.c, var2, null, null), var1);
   }

   public void h(String var1) {
      String var2 = var1;
      if (TextUtils.isEmpty(var1)) {
         var2 = "smartstore";
      }

      DBOpenHelper.b(this.c, var2, null, null);
   }
}
