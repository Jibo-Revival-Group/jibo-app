package com.salesforce.androidsdk.smartstore.app;

import android.text.TextUtils;
import com.salesforce.androidsdk.accounts.UserAccount;
import com.salesforce.androidsdk.app.SalesforceSDKUpgradeManager;
import java.io.File;

public class SmartStoreUpgradeManager extends SalesforceSDKUpgradeManager {
   private static SmartStoreUpgradeManager a = null;

   public static SmartStoreUpgradeManager f() {
      synchronized (SmartStoreUpgradeManager.class) {
         if (a == null) {
            SmartStoreUpgradeManager var0 = new SmartStoreUpgradeManager();
            a = var0;
         }

         return a;
      }
   }

   @Override
   public void b() {
      super.b();
      this.g();
   }

   @Override
   protected void e() {
      super.e();
      String var1 = String.format("smartstore%s.db", "");
      if (SmartStoreSDKManager.H().k().getDatabasePath(var1).exists()) {
         UserAccount var2 = SmartStoreSDKManager.H().o().b();
         if (var2 != null) {
            String var4 = var2.a(null);
            if (!TextUtils.isEmpty(var4)) {
               String var3 = String.format("smartstore%s.db", var4);
               String var5 = SmartStoreSDKManager.H().k().getApplicationInfo().dataDir + "/databases";
               new File(var5, var1).renameTo(new File(var5, var3));
            }
         }
      }
   }

   protected void g() {
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
      // 03: invokevirtual com/salesforce/androidsdk/smartstore/app/SmartStoreUpgradeManager.h ()Ljava/lang/String;
      // 06: astore 2
      // 07: aload 2
      // 08: ldc "5.3.0"
      // 0a: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 0d: istore 1
      // 0e: iload 1
      // 0f: ifeq 15
      // 12: aload 0
      // 13: monitorexit
      // 14: return
      // 15: aload 0
      // 16: ldc "smart_store_version"
      // 18: ldc "5.3.0"
      // 1a: invokevirtual com/salesforce/androidsdk/smartstore/app/SmartStoreUpgradeManager.a (Ljava/lang/String;Ljava/lang/String;)V
      // 1d: aload 2
      // 1e: invokestatic android/text/TextUtils.isEmpty (Ljava/lang/CharSequence;)Z
      // 21: ifeq 12
      // 24: aload 0
      // 25: invokevirtual com/salesforce/androidsdk/smartstore/app/SmartStoreUpgradeManager.h ()Ljava/lang/String;
      // 28: pop
      // 29: goto 12
      // 2c: astore 2
      // 2d: aload 0
      // 2e: monitorexit
      // 2f: aload 2
      // 30: athrow
      // try (2 -> 9): 25 null
      // try (14 -> 24): 25 null
   }

   public String h() {
      return this.a("smart_store_version");
   }
}
