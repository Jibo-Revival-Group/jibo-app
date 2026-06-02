package com.facebook.internal;

import android.content.Intent;
import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;
import java.util.HashMap;
import java.util.Map;

public final class CallbackManagerImpl implements CallbackManager {
   private static Map<Integer, CallbackManagerImpl.Callback> staticCallbacks = new HashMap<>();
   private Map<Integer, CallbackManagerImpl.Callback> callbacks = new HashMap<>();

   private static CallbackManagerImpl.Callback getStaticCallback(Integer var0) {
      synchronized (CallbackManagerImpl.class) {
         return staticCallbacks.get(var0);
      }
   }

   public static void registerStaticCallback(int param0, CallbackManagerImpl.Callback param1) {
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
      // 00: ldc com/facebook/internal/CallbackManagerImpl
      // 02: monitorenter
      // 03: aload 1
      // 04: ldc "callback"
      // 06: invokestatic com/facebook/internal/Validate.notNull (Ljava/lang/Object;Ljava/lang/String;)V
      // 09: getstatic com/facebook/internal/CallbackManagerImpl.staticCallbacks Ljava/util/Map;
      // 0c: iload 0
      // 0d: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 10: invokeinterface java/util/Map.containsKey (Ljava/lang/Object;)Z 2
      // 15: istore 2
      // 16: iload 2
      // 17: ifeq 1e
      // 1a: ldc com/facebook/internal/CallbackManagerImpl
      // 1c: monitorexit
      // 1d: return
      // 1e: getstatic com/facebook/internal/CallbackManagerImpl.staticCallbacks Ljava/util/Map;
      // 21: iload 0
      // 22: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 25: aload 1
      // 26: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 2b: pop
      // 2c: goto 1a
      // 2f: astore 1
      // 30: ldc com/facebook/internal/CallbackManagerImpl
      // 32: monitorexit
      // 33: aload 1
      // 34: athrow
      // try (2 -> 10): 22 null
      // try (15 -> 21): 22 null
   }

   private static boolean runStaticCallback(int var0, int var1, Intent var2) {
      CallbackManagerImpl.Callback var4 = getStaticCallback(var0);
      boolean var3;
      if (var4 != null) {
         var3 = var4.onActivityResult(var1, var2);
      } else {
         var3 = false;
      }

      return var3;
   }

   @Override
   public boolean onActivityResult(int var1, int var2, Intent var3) {
      CallbackManagerImpl.Callback var5 = this.callbacks.get(var1);
      boolean var4;
      if (var5 != null) {
         var4 = var5.onActivityResult(var2, var3);
      } else {
         var4 = runStaticCallback(var1, var2, var3);
      }

      return var4;
   }

   public void registerCallback(int var1, CallbackManagerImpl.Callback var2) {
      Validate.notNull(var2, "callback");
      this.callbacks.put(var1, var2);
   }

   public interface Callback {
      boolean onActivityResult(int var1, Intent var2);
   }

   public enum RequestCodeOffset {
      AppGroupCreate(5),
      AppGroupJoin(6),
      AppInvite(7),
      DeviceShare(8),
      GameRequest(4),
      Like(3),
      Login(0),
      Message(2),
      Share(1);

      private static final CallbackManagerImpl.RequestCodeOffset[] $VALUES = new CallbackManagerImpl.RequestCodeOffset[]{
         CallbackManagerImpl.RequestCodeOffset.Login,
         CallbackManagerImpl.RequestCodeOffset.Share,
         CallbackManagerImpl.RequestCodeOffset.Message,
         CallbackManagerImpl.RequestCodeOffset.Like,
         CallbackManagerImpl.RequestCodeOffset.GameRequest,
         CallbackManagerImpl.RequestCodeOffset.AppGroupCreate,
         CallbackManagerImpl.RequestCodeOffset.AppGroupJoin,
         CallbackManagerImpl.RequestCodeOffset.AppInvite,
         CallbackManagerImpl.RequestCodeOffset.DeviceShare
      };
      private final int offset;

      RequestCodeOffset(int var3) {
         this.offset = var3;
      }

      public int toRequestCode() {
         return FacebookSdk.getCallbackRequestCodeOffset() + this.offset;
      }
   }
}
