package android.support.customtabs;

import android.app.Service;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.support.v4.util.ArrayMap;
import java.util.List;
import java.util.Map;

public abstract class CustomTabsService extends Service {
   private final Map<IBinder, DeathRecipient> a = new ArrayMap<>();
   private ICustomTabsService.Stub b = new ICustomTabsService.Stub(this) {
      final CustomTabsService a;

      {
         this.a = var1;
      }

      @Override
      public Bundle a(String var1, Bundle var2) {
         return this.a.a(var1, var2);
      }

      @Override
      public boolean a(long var1) {
         return this.a.a(var1);
      }

      @Override
      public boolean a(ICustomTabsCallback param1) {
         // $VF: Couldn't be decompiled
         // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
         // java.lang.RuntimeException: parsing failure!
         //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
         //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
         //
         // Bytecode:
         // 00: bipush 0
         // 01: istore 2
         // 02: new android/support/customtabs/CustomTabsSessionToken
         // 05: dup
         // 06: aload 1
         // 07: invokespecial android/support/customtabs/CustomTabsSessionToken.<init> (Landroid/support/customtabs/ICustomTabsCallback;)V
         // 0a: astore 5
         // 0c: new android/support/customtabs/CustomTabsService$1$1
         // 0f: astore 6
         // 11: aload 6
         // 13: aload 0
         // 14: aload 5
         // 16: invokespecial android/support/customtabs/CustomTabsService$1$1.<init> (Landroid/support/customtabs/CustomTabsService$1;Landroid/support/customtabs/CustomTabsSessionToken;)V
         // 19: aload 0
         // 1a: getfield android/support/customtabs/CustomTabsService$1.a Landroid/support/customtabs/CustomTabsService;
         // 1d: invokestatic android/support/customtabs/CustomTabsService.a (Landroid/support/customtabs/CustomTabsService;)Ljava/util/Map;
         // 20: astore 4
         // 22: aload 4
         // 24: monitorenter
         // 25: aload 1
         // 26: invokeinterface android/support/customtabs/ICustomTabsCallback.asBinder ()Landroid/os/IBinder; 1
         // 2b: aload 6
         // 2d: bipush 0
         // 2e: invokeinterface android/os/IBinder.linkToDeath (Landroid/os/IBinder$DeathRecipient;I)V 3
         // 33: aload 0
         // 34: getfield android/support/customtabs/CustomTabsService$1.a Landroid/support/customtabs/CustomTabsService;
         // 37: invokestatic android/support/customtabs/CustomTabsService.a (Landroid/support/customtabs/CustomTabsService;)Ljava/util/Map;
         // 3a: aload 1
         // 3b: invokeinterface android/support/customtabs/ICustomTabsCallback.asBinder ()Landroid/os/IBinder; 1
         // 40: aload 6
         // 42: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
         // 47: pop
         // 48: aload 4
         // 4a: monitorexit
         // 4b: aload 0
         // 4c: getfield android/support/customtabs/CustomTabsService$1.a Landroid/support/customtabs/CustomTabsService;
         // 4f: aload 5
         // 51: invokevirtual android/support/customtabs/CustomTabsService.b (Landroid/support/customtabs/CustomTabsSessionToken;)Z
         // 54: istore 3
         // 55: iload 3
         // 56: istore 2
         // 57: iload 2
         // 58: ireturn
         // 59: astore 1
         // 5a: aload 4
         // 5c: monitorexit
         // 5d: aload 1
         // 5e: athrow
         // 5f: astore 1
         // 60: goto 57
         // try (7 -> 19): 48 android/os/RemoteException
         // try (19 -> 34): 43 null
         // try (34 -> 39): 48 android/os/RemoteException
         // try (44 -> 46): 43 null
         // try (46 -> 48): 48 android/os/RemoteException
      }

      @Override
      public boolean a(ICustomTabsCallback var1, Uri var2, Bundle var3, List<Bundle> var4) {
         return this.a.a(new CustomTabsSessionToken(var1), var2, var3, var4);
      }

      @Override
      public boolean a(ICustomTabsCallback var1, Bundle var2) {
         return this.a.a(new CustomTabsSessionToken(var1), var2);
      }
   };

   protected abstract Bundle a(String var1, Bundle var2);

   protected abstract boolean a(long var1);

   protected boolean a(CustomTabsSessionToken param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: aload 0
      // 01: getfield android/support/customtabs/CustomTabsService.a Ljava/util/Map;
      // 04: astore 3
      // 05: aload 3
      // 06: monitorenter
      // 07: aload 1
      // 08: invokevirtual android/support/customtabs/CustomTabsSessionToken.a ()Landroid/os/IBinder;
      // 0b: astore 1
      // 0c: aload 1
      // 0d: aload 0
      // 0e: getfield android/support/customtabs/CustomTabsService.a Ljava/util/Map;
      // 11: aload 1
      // 12: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 17: checkcast android/os/IBinder$DeathRecipient
      // 1a: bipush 0
      // 1b: invokeinterface android/os/IBinder.unlinkToDeath (Landroid/os/IBinder$DeathRecipient;I)Z 3
      // 20: pop
      // 21: aload 0
      // 22: getfield android/support/customtabs/CustomTabsService.a Ljava/util/Map;
      // 25: aload 1
      // 26: invokeinterface java/util/Map.remove (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 2b: pop
      // 2c: aload 3
      // 2d: monitorexit
      // 2e: bipush 1
      // 2f: istore 2
      // 30: iload 2
      // 31: ireturn
      // 32: astore 1
      // 33: aload 3
      // 34: monitorexit
      // 35: aload 1
      // 36: athrow
      // 37: astore 1
      // 38: bipush 0
      // 39: istore 2
      // 3a: goto 30
      // try (0 -> 5): 33 java/util/NoSuchElementException
      // try (5 -> 24): 28 null
      // try (29 -> 31): 28 null
      // try (31 -> 33): 33 java/util/NoSuchElementException
   }

   protected abstract boolean a(CustomTabsSessionToken var1, Uri var2, Bundle var3, List<Bundle> var4);

   protected abstract boolean a(CustomTabsSessionToken var1, Bundle var2);

   protected abstract boolean b(CustomTabsSessionToken var1);
}
