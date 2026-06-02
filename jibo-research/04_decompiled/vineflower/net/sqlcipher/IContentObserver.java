package net.sqlcipher;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IContentObserver extends IInterface {
   void onChange(boolean var1) throws RemoteException;

   abstract class Stub extends Binder implements IContentObserver {
      private static final String DESCRIPTOR = "net.sqlcipher.IContentObserver";
      static final int TRANSACTION_onChange = 1;

      public Stub() {
         this.attachInterface(this, "net.sqlcipher.IContentObserver");
      }

      public static IContentObserver asInterface(IBinder var0) {
         IContentObserver var2;
         if (var0 == null) {
            var2 = null;
         } else {
            IInterface var1 = var0.queryLocalInterface("net.sqlcipher.IContentObserver");
            if (var1 != null && var1 instanceof IContentObserver) {
               var2 = (IContentObserver)var1;
            } else {
               var2 = new IContentObserver.Stub.Proxy(var0);
            }
         }

         return var2;
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         boolean var6 = true;
         boolean var5;
         switch (var1) {
            case 1:
               var2.enforceInterface("net.sqlcipher.IContentObserver");
               if (var2.readInt() != 0) {
                  var5 = true;
               } else {
                  var5 = false;
               }

               this.onChange(var5);
               var5 = var6;
               break;
            case 1598968902:
               var3.writeString("net.sqlcipher.IContentObserver");
               var5 = var6;
               break;
            default:
               var5 = super.onTransact(var1, var2, var3, var4);
         }

         return var5;
      }

      private static class Proxy implements IContentObserver {
         private IBinder mRemote;

         Proxy(IBinder var1) {
            this.mRemote = var1;
         }

         public IBinder asBinder() {
            return this.mRemote;
         }

         public String getInterfaceDescriptor() {
            return "net.sqlcipher.IContentObserver";
         }

         @Override
         public void onChange(boolean param1) throws RemoteException {
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
            // 01: istore 2
            // 02: invokestatic android/os/Parcel.obtain ()Landroid/os/Parcel;
            // 05: astore 3
            // 06: aload 3
            // 07: ldc "net.sqlcipher.IContentObserver"
            // 09: invokevirtual android/os/Parcel.writeInterfaceToken (Ljava/lang/String;)V
            // 0c: iload 1
            // 0d: ifeq 28
            // 10: aload 3
            // 11: iload 2
            // 12: invokevirtual android/os/Parcel.writeInt (I)V
            // 15: aload 0
            // 16: getfield net/sqlcipher/IContentObserver$Stub$Proxy.mRemote Landroid/os/IBinder;
            // 19: bipush 1
            // 1a: aload 3
            // 1b: aconst_null
            // 1c: bipush 1
            // 1d: invokeinterface android/os/IBinder.transact (ILandroid/os/Parcel;Landroid/os/Parcel;I)Z 5
            // 22: pop
            // 23: aload 3
            // 24: invokevirtual android/os/Parcel.recycle ()V
            // 27: return
            // 28: bipush 0
            // 29: istore 2
            // 2a: goto 10
            // 2d: astore 4
            // 2f: aload 3
            // 30: invokevirtual android/os/Parcel.recycle ()V
            // 33: aload 4
            // 35: athrow
            // try (4 -> 7): 26 null
            // try (9 -> 20): 26 null
         }
      }
   }
}
