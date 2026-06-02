package android.support.customtabs;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface ICustomTabsCallback extends IInterface {
   void a(int var1, Bundle var2) throws RemoteException;

   void a(String var1, Bundle var2) throws RemoteException;

   abstract class Stub extends Binder implements ICustomTabsCallback {
      public static ICustomTabsCallback a(IBinder var0) {
         ICustomTabsCallback var2;
         if (var0 == null) {
            var2 = null;
         } else {
            IInterface var1 = var0.queryLocalInterface("android.support.customtabs.ICustomTabsCallback");
            if (var1 != null && var1 instanceof ICustomTabsCallback) {
               var2 = (ICustomTabsCallback)var1;
            } else {
               var2 = new ICustomTabsCallback.Stub.Proxy(var0);
            }
         }

         return var2;
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         Object var6 = null;
         String var7 = null;
         boolean var5;
         switch (var1) {
            case 2:
               var2.enforceInterface("android.support.customtabs.ICustomTabsCallback");
               var1 = var2.readInt();
               Bundle var10 = var7;
               if (var2.readInt() != 0) {
                  var10 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
               }

               this.a(var1, var10);
               var5 = true;
               break;
            case 3:
               var2.enforceInterface("android.support.customtabs.ICustomTabsCallback");
               var7 = var2.readString();
               Bundle var9 = (Bundle)var6;
               if (var2.readInt() != 0) {
                  var9 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
               }

               this.a(var7, var9);
               var5 = true;
               break;
            case 1598968902:
               var3.writeString("android.support.customtabs.ICustomTabsCallback");
               var5 = true;
               break;
            default:
               var5 = super.onTransact(var1, var2, var3, var4);
         }

         return var5;
      }

      private static class Proxy implements ICustomTabsCallback {
         private IBinder a;

         Proxy(IBinder var1) {
            this.a = var1;
         }

         @Override
         public void a(int param1, Bundle param2) throws RemoteException {
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
            // 00: invokestatic android/os/Parcel.obtain ()Landroid/os/Parcel;
            // 03: astore 3
            // 04: aload 3
            // 05: ldc "android.support.customtabs.ICustomTabsCallback"
            // 07: invokevirtual android/os/Parcel.writeInterfaceToken (Ljava/lang/String;)V
            // 0a: aload 3
            // 0b: iload 1
            // 0c: invokevirtual android/os/Parcel.writeInt (I)V
            // 0f: aload 2
            // 10: ifnull 31
            // 13: aload 3
            // 14: bipush 1
            // 15: invokevirtual android/os/Parcel.writeInt (I)V
            // 18: aload 2
            // 19: aload 3
            // 1a: bipush 0
            // 1b: invokevirtual android/os/Bundle.writeToParcel (Landroid/os/Parcel;I)V
            // 1e: aload 0
            // 1f: getfield android/support/customtabs/ICustomTabsCallback$Stub$Proxy.a Landroid/os/IBinder;
            // 22: bipush 2
            // 23: aload 3
            // 24: aconst_null
            // 25: bipush 1
            // 26: invokeinterface android/os/IBinder.transact (ILandroid/os/Parcel;Landroid/os/Parcel;I)Z 5
            // 2b: pop
            // 2c: aload 3
            // 2d: invokevirtual android/os/Parcel.recycle ()V
            // 30: return
            // 31: aload 3
            // 32: bipush 0
            // 33: invokevirtual android/os/Parcel.writeInt (I)V
            // 36: goto 1e
            // 39: astore 2
            // 3a: aload 3
            // 3b: invokevirtual android/os/Parcel.recycle ()V
            // 3e: aload 2
            // 3f: athrow
            // try (2 -> 8): 32 null
            // try (10 -> 17): 32 null
            // try (17 -> 25): 32 null
            // try (28 -> 31): 32 null
         }

         @Override
         public void a(String param1, Bundle param2) throws RemoteException {
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
            // 00: invokestatic android/os/Parcel.obtain ()Landroid/os/Parcel;
            // 03: astore 3
            // 04: aload 3
            // 05: ldc "android.support.customtabs.ICustomTabsCallback"
            // 07: invokevirtual android/os/Parcel.writeInterfaceToken (Ljava/lang/String;)V
            // 0a: aload 3
            // 0b: aload 1
            // 0c: invokevirtual android/os/Parcel.writeString (Ljava/lang/String;)V
            // 0f: aload 2
            // 10: ifnull 31
            // 13: aload 3
            // 14: bipush 1
            // 15: invokevirtual android/os/Parcel.writeInt (I)V
            // 18: aload 2
            // 19: aload 3
            // 1a: bipush 0
            // 1b: invokevirtual android/os/Bundle.writeToParcel (Landroid/os/Parcel;I)V
            // 1e: aload 0
            // 1f: getfield android/support/customtabs/ICustomTabsCallback$Stub$Proxy.a Landroid/os/IBinder;
            // 22: bipush 3
            // 23: aload 3
            // 24: aconst_null
            // 25: bipush 1
            // 26: invokeinterface android/os/IBinder.transact (ILandroid/os/Parcel;Landroid/os/Parcel;I)Z 5
            // 2b: pop
            // 2c: aload 3
            // 2d: invokevirtual android/os/Parcel.recycle ()V
            // 30: return
            // 31: aload 3
            // 32: bipush 0
            // 33: invokevirtual android/os/Parcel.writeInt (I)V
            // 36: goto 1e
            // 39: astore 1
            // 3a: aload 3
            // 3b: invokevirtual android/os/Parcel.recycle ()V
            // 3e: aload 1
            // 3f: athrow
            // try (2 -> 8): 32 null
            // try (10 -> 17): 32 null
            // try (17 -> 25): 32 null
            // try (28 -> 31): 32 null
         }

         public IBinder asBinder() {
            return this.a;
         }
      }
   }
}
