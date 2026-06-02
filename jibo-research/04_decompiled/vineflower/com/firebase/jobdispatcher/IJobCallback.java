package com.firebase.jobdispatcher;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IJobCallback extends IInterface {
   void a(Bundle var1, int var2) throws RemoteException;

   abstract class Stub extends Binder implements IJobCallback {
      public Stub() {
         this.attachInterface(this, "com.firebase.jobdispatcher.IJobCallback");
      }

      public static IJobCallback a(IBinder var0) {
         IJobCallback var2;
         if (var0 == null) {
            var2 = null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.firebase.jobdispatcher.IJobCallback");
            if (var1 != null && var1 instanceof IJobCallback) {
               var2 = (IJobCallback)var1;
            } else {
               var2 = new IJobCallback.Stub.Proxy(var0);
            }
         }

         return var2;
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         boolean var5;
         switch (var1) {
            case 1:
               var2.enforceInterface("com.firebase.jobdispatcher.IJobCallback");
               Bundle var6;
               if (var2.readInt() != 0) {
                  var6 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
               } else {
                  var6 = null;
               }

               this.a(var6, var2.readInt());
               var5 = true;
               break;
            case 1598968902:
               var3.writeString("com.firebase.jobdispatcher.IJobCallback");
               var5 = true;
               break;
            default:
               var5 = super.onTransact(var1, var2, var3, var4);
         }

         return var5;
      }

      private static class Proxy implements IJobCallback {
         private IBinder a;

         Proxy(IBinder var1) {
            this.a = var1;
         }

         @Override
         public void a(Bundle param1, int param2) throws RemoteException {
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
            // 05: ldc "com.firebase.jobdispatcher.IJobCallback"
            // 07: invokevirtual android/os/Parcel.writeInterfaceToken (Ljava/lang/String;)V
            // 0a: aload 1
            // 0b: ifnull 31
            // 0e: aload 3
            // 0f: bipush 1
            // 10: invokevirtual android/os/Parcel.writeInt (I)V
            // 13: aload 1
            // 14: aload 3
            // 15: bipush 0
            // 16: invokevirtual android/os/Bundle.writeToParcel (Landroid/os/Parcel;I)V
            // 19: aload 3
            // 1a: iload 2
            // 1b: invokevirtual android/os/Parcel.writeInt (I)V
            // 1e: aload 0
            // 1f: getfield com/firebase/jobdispatcher/IJobCallback$Stub$Proxy.a Landroid/os/IBinder;
            // 22: bipush 1
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
            // 36: goto 19
            // 39: astore 1
            // 3a: aload 3
            // 3b: invokevirtual android/os/Parcel.recycle ()V
            // 3e: aload 1
            // 3f: athrow
            // try (2 -> 5): 32 null
            // try (7 -> 14): 32 null
            // try (14 -> 25): 32 null
            // try (28 -> 31): 32 null
         }

         public IBinder asBinder() {
            return this.a;
         }
      }
   }
}
