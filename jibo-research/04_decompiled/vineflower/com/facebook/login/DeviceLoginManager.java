package com.facebook.login;

import android.net.Uri;
import java.util.Collection;

public class DeviceLoginManager extends LoginManager {
   private static volatile DeviceLoginManager instance;
   private Uri deviceRedirectUri;

   public static DeviceLoginManager getInstance() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1058)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.verifyFinallyEx(FinallyProcessor.java:573)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:90)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: getstatic com/facebook/login/DeviceLoginManager.instance Lcom/facebook/login/DeviceLoginManager;
      // 03: ifnonnull 1e
      // 06: ldc com/facebook/login/DeviceLoginManager
      // 08: monitorenter
      // 09: getstatic com/facebook/login/DeviceLoginManager.instance Lcom/facebook/login/DeviceLoginManager;
      // 0c: ifnonnull 1b
      // 0f: new com/facebook/login/DeviceLoginManager
      // 12: astore 0
      // 13: aload 0
      // 14: invokespecial com/facebook/login/DeviceLoginManager.<init> ()V
      // 17: aload 0
      // 18: putstatic com/facebook/login/DeviceLoginManager.instance Lcom/facebook/login/DeviceLoginManager;
      // 1b: ldc com/facebook/login/DeviceLoginManager
      // 1d: monitorexit
      // 1e: getstatic com/facebook/login/DeviceLoginManager.instance Lcom/facebook/login/DeviceLoginManager;
      // 21: areturn
      // 22: astore 0
      // 23: ldc com/facebook/login/DeviceLoginManager
      // 25: monitorexit
      // 26: aload 0
      // 27: athrow
      // try (4 -> 12): 16 null
      // try (12 -> 14): 16 null
      // try (17 -> 19): 16 null
   }

   @Override
   protected LoginClient.Request createLoginRequest(Collection<String> var1) {
      LoginClient.Request var2 = super.createLoginRequest(var1);
      Uri var3 = this.getDeviceRedirectUri();
      if (var3 != null) {
         var2.setDeviceRedirectUriString(var3.toString());
      }

      return var2;
   }

   public Uri getDeviceRedirectUri() {
      return this.deviceRedirectUri;
   }

   public void setDeviceRedirectUri(Uri var1) {
      this.deviceRedirectUri = var1;
   }
}
