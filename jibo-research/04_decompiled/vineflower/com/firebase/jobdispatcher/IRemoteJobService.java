package com.firebase.jobdispatcher;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IRemoteJobService extends IInterface {
   void a(Bundle var1, IJobCallback var2) throws RemoteException;

   void a(Bundle var1, boolean var2) throws RemoteException;

   abstract class Stub extends Binder implements IRemoteJobService {
      public Stub() {
         this.attachInterface(this, "com.firebase.jobdispatcher.IRemoteJobService");
      }

      public static IRemoteJobService a(IBinder var0) {
         IRemoteJobService var2;
         if (var0 == null) {
            var2 = null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.firebase.jobdispatcher.IRemoteJobService");
            if (var1 != null && var1 instanceof IRemoteJobService) {
               var2 = (IRemoteJobService)var1;
            } else {
               var2 = new IRemoteJobService.Stub.Proxy(var0);
            }
         }

         return var2;
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         Object var8 = null;
         Object var7 = null;
         boolean var6 = true;
         boolean var5;
         switch (var1) {
            case 1:
               var2.enforceInterface("com.firebase.jobdispatcher.IRemoteJobService");
               Bundle var10 = (Bundle)var7;
               if (var2.readInt() != 0) {
                  var10 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
               }

               this.a(var10, IJobCallback.Stub.a(var2.readStrongBinder()));
               var5 = var6;
               break;
            case 2:
               var2.enforceInterface("com.firebase.jobdispatcher.IRemoteJobService");
               Bundle var9 = (Bundle)var8;
               if (var2.readInt() != 0) {
                  var9 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
               }

               if (var2.readInt() != 0) {
                  var5 = true;
               } else {
                  var5 = false;
               }

               this.a(var9, var5);
               var5 = var6;
               break;
            case 1598968902:
               var3.writeString("com.firebase.jobdispatcher.IRemoteJobService");
               var5 = var6;
               break;
            default:
               var5 = super.onTransact(var1, var2, var3, var4);
         }

         return var5;
      }

      private static class Proxy implements IRemoteJobService {
         private IBinder a;

         Proxy(IBinder var1) {
            this.a = var1;
         }

         @Override
         public void a(Bundle param1, IJobCallback param2) throws RemoteException {
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
            // 00: aconst_null
            // 01: astore 3
            // 02: invokestatic android/os/Parcel.obtain ()Landroid/os/Parcel;
            // 05: astore 4
            // 07: aload 4
            // 09: ldc "com.firebase.jobdispatcher.IRemoteJobService"
            // 0b: invokevirtual android/os/Parcel.writeInterfaceToken (Ljava/lang/String;)V
            // 0e: aload 1
            // 0f: ifnull 47
            // 12: aload 4
            // 14: bipush 1
            // 15: invokevirtual android/os/Parcel.writeInt (I)V
            // 18: aload 1
            // 19: aload 4
            // 1b: bipush 0
            // 1c: invokevirtual android/os/Bundle.writeToParcel (Landroid/os/Parcel;I)V
            // 1f: aload 3
            // 20: astore 1
            // 21: aload 2
            // 22: ifnull 2c
            // 25: aload 2
            // 26: invokeinterface com/firebase/jobdispatcher/IJobCallback.asBinder ()Landroid/os/IBinder; 1
            // 2b: astore 1
            // 2c: aload 4
            // 2e: aload 1
            // 2f: invokevirtual android/os/Parcel.writeStrongBinder (Landroid/os/IBinder;)V
            // 32: aload 0
            // 33: getfield com/firebase/jobdispatcher/IRemoteJobService$Stub$Proxy.a Landroid/os/IBinder;
            // 36: bipush 1
            // 37: aload 4
            // 39: aconst_null
            // 3a: bipush 1
            // 3b: invokeinterface android/os/IBinder.transact (ILandroid/os/Parcel;Landroid/os/Parcel;I)Z 5
            // 40: pop
            // 41: aload 4
            // 43: invokevirtual android/os/Parcel.recycle ()V
            // 46: return
            // 47: aload 4
            // 49: bipush 0
            // 4a: invokevirtual android/os/Parcel.writeInt (I)V
            // 4d: goto 1f
            // 50: astore 1
            // 51: aload 4
            // 53: invokevirtual android/os/Parcel.recycle ()V
            // 56: aload 1
            // 57: athrow
            // try (4 -> 7): 41 null
            // try (9 -> 16): 41 null
            // try (20 -> 23): 41 null
            // try (23 -> 34): 41 null
            // try (37 -> 40): 41 null
         }

         @Override
         public void a(Bundle param1, boolean param2) throws RemoteException {
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
            // 00: bipush 1
            // 01: istore 3
            // 02: invokestatic android/os/Parcel.obtain ()Landroid/os/Parcel;
            // 05: astore 4
            // 07: aload 4
            // 09: ldc "com.firebase.jobdispatcher.IRemoteJobService"
            // 0b: invokevirtual android/os/Parcel.writeInterfaceToken (Ljava/lang/String;)V
            // 0e: aload 1
            // 0f: ifnull 3e
            // 12: aload 4
            // 14: bipush 1
            // 15: invokevirtual android/os/Parcel.writeInt (I)V
            // 18: aload 1
            // 19: aload 4
            // 1b: bipush 0
            // 1c: invokevirtual android/os/Bundle.writeToParcel (Landroid/os/Parcel;I)V
            // 1f: iload 2
            // 20: ifeq 4f
            // 23: aload 4
            // 25: iload 3
            // 26: invokevirtual android/os/Parcel.writeInt (I)V
            // 29: aload 0
            // 2a: getfield com/firebase/jobdispatcher/IRemoteJobService$Stub$Proxy.a Landroid/os/IBinder;
            // 2d: bipush 2
            // 2e: aload 4
            // 30: aconst_null
            // 31: bipush 1
            // 32: invokeinterface android/os/IBinder.transact (ILandroid/os/Parcel;Landroid/os/Parcel;I)Z 5
            // 37: pop
            // 38: aload 4
            // 3a: invokevirtual android/os/Parcel.recycle ()V
            // 3d: return
            // 3e: aload 4
            // 40: bipush 0
            // 41: invokevirtual android/os/Parcel.writeInt (I)V
            // 44: goto 1f
            // 47: astore 1
            // 48: aload 4
            // 4a: invokevirtual android/os/Parcel.recycle ()V
            // 4d: aload 1
            // 4e: athrow
            // 4f: bipush 0
            // 50: istore 3
            // 51: goto 23
            // try (4 -> 7): 36 null
            // try (9 -> 16): 36 null
            // try (18 -> 29): 36 null
            // try (32 -> 35): 36 null
         }

         public IBinder asBinder() {
            return this.a;
         }
      }
   }
}
