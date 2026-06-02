package android.support.v4.app;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface INotificationSideChannel extends IInterface {
   void a(String var1) throws RemoteException;

   void a(String var1, int var2, String var3) throws RemoteException;

   void a(String var1, int var2, String var3, Notification var4) throws RemoteException;

   abstract class Stub extends Binder implements INotificationSideChannel {
      public static INotificationSideChannel a(IBinder var0) {
         INotificationSideChannel var2;
         if (var0 == null) {
            var2 = null;
         } else {
            IInterface var1 = var0.queryLocalInterface("android.support.v4.app.INotificationSideChannel");
            if (var1 != null && var1 instanceof INotificationSideChannel) {
               var2 = (INotificationSideChannel)var1;
            } else {
               var2 = new INotificationSideChannel.Stub.Proxy(var0);
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
               var2.enforceInterface("android.support.v4.app.INotificationSideChannel");
               String var6 = var2.readString();
               var1 = var2.readInt();
               String var9 = var2.readString();
               Notification var8;
               if (var2.readInt() != 0) {
                  var8 = (Notification)Notification.CREATOR.createFromParcel(var2);
               } else {
                  var8 = null;
               }

               this.a(var6, var1, var9, var8);
               var5 = true;
               break;
            case 2:
               var2.enforceInterface("android.support.v4.app.INotificationSideChannel");
               this.a(var2.readString(), var2.readInt(), var2.readString());
               var5 = true;
               break;
            case 3:
               var2.enforceInterface("android.support.v4.app.INotificationSideChannel");
               this.a(var2.readString());
               var5 = true;
               break;
            case 1598968902:
               var3.writeString("android.support.v4.app.INotificationSideChannel");
               var5 = true;
               break;
            default:
               var5 = super.onTransact(var1, var2, var3, var4);
         }

         return var5;
      }

      private static class Proxy implements INotificationSideChannel {
         private IBinder a;

         Proxy(IBinder var1) {
            this.a = var1;
         }

         @Override
         public void a(String var1) throws RemoteException {
            Parcel var2 = Parcel.obtain();

            try {
               var2.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");
               var2.writeString(var1);
               this.a.transact(3, var2, null, 1);
            } finally {
               var2.recycle();
            }
         }

         @Override
         public void a(String var1, int var2, String var3) throws RemoteException {
            Parcel var4 = Parcel.obtain();

            try {
               var4.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");
               var4.writeString(var1);
               var4.writeInt(var2);
               var4.writeString(var3);
               this.a.transact(2, var4, null, 1);
            } finally {
               var4.recycle();
            }
         }

         @Override
         public void a(String param1, int param2, String param3, Notification param4) throws RemoteException {
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
            // 03: astore 5
            // 05: aload 5
            // 07: ldc "android.support.v4.app.INotificationSideChannel"
            // 09: invokevirtual android/os/Parcel.writeInterfaceToken (Ljava/lang/String;)V
            // 0c: aload 5
            // 0e: aload 1
            // 0f: invokevirtual android/os/Parcel.writeString (Ljava/lang/String;)V
            // 12: aload 5
            // 14: iload 2
            // 15: invokevirtual android/os/Parcel.writeInt (I)V
            // 18: aload 5
            // 1a: aload 3
            // 1b: invokevirtual android/os/Parcel.writeString (Ljava/lang/String;)V
            // 1e: aload 4
            // 20: ifnull 46
            // 23: aload 5
            // 25: bipush 1
            // 26: invokevirtual android/os/Parcel.writeInt (I)V
            // 29: aload 4
            // 2b: aload 5
            // 2d: bipush 0
            // 2e: invokevirtual android/app/Notification.writeToParcel (Landroid/os/Parcel;I)V
            // 31: aload 0
            // 32: getfield android/support/v4/app/INotificationSideChannel$Stub$Proxy.a Landroid/os/IBinder;
            // 35: bipush 1
            // 36: aload 5
            // 38: aconst_null
            // 39: bipush 1
            // 3a: invokeinterface android/os/IBinder.transact (ILandroid/os/Parcel;Landroid/os/Parcel;I)Z 5
            // 3f: pop
            // 40: aload 5
            // 42: invokevirtual android/os/Parcel.recycle ()V
            // 45: return
            // 46: aload 5
            // 48: bipush 0
            // 49: invokevirtual android/os/Parcel.writeInt (I)V
            // 4c: goto 31
            // 4f: astore 1
            // 50: aload 5
            // 52: invokevirtual android/os/Parcel.recycle ()V
            // 55: aload 1
            // 56: athrow
            // try (2 -> 14): 38 null
            // try (16 -> 23): 38 null
            // try (23 -> 31): 38 null
            // try (34 -> 37): 38 null
         }

         public IBinder asBinder() {
            return this.a;
         }
      }
   }
}
