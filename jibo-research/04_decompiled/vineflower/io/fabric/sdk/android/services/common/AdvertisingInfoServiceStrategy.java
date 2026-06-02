package io.fabric.sdk.android.services.common;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import io.fabric.sdk.android.Fabric;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

class AdvertisingInfoServiceStrategy implements AdvertisingInfoStrategy {
   private final Context a;

   public AdvertisingInfoServiceStrategy(Context var1) {
      this.a = var1.getApplicationContext();
   }

   @Override
   public AdvertisingInfo a() {
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
      // 00: aconst_null
      // 01: astore 2
      // 02: invokestatic android/os/Looper.myLooper ()Landroid/os/Looper;
      // 05: invokestatic android/os/Looper.getMainLooper ()Landroid/os/Looper;
      // 08: if_acmpne 19
      // 0b: invokestatic io/fabric/sdk/android/Fabric.h ()Lio/fabric/sdk/android/Logger;
      // 0e: ldc "Fabric"
      // 10: ldc "AdvertisingInfoServiceStrategy cannot be called on the main thread"
      // 12: invokeinterface io/fabric/sdk/android/Logger.a (Ljava/lang/String;Ljava/lang/String;)V 3
      // 17: aload 2
      // 18: areturn
      // 19: aload 0
      // 1a: getfield io/fabric/sdk/android/services/common/AdvertisingInfoServiceStrategy.a Landroid/content/Context;
      // 1d: invokevirtual android/content/Context.getPackageManager ()Landroid/content/pm/PackageManager;
      // 20: ldc "com.android.vending"
      // 22: bipush 0
      // 23: invokevirtual android/content/pm/PackageManager.getPackageInfo (Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
      // 26: pop
      // 27: new io/fabric/sdk/android/services/common/AdvertisingInfoServiceStrategy$AdvertisingConnection
      // 2a: dup
      // 2b: aconst_null
      // 2c: invokespecial io/fabric/sdk/android/services/common/AdvertisingInfoServiceStrategy$AdvertisingConnection.<init> (Lio/fabric/sdk/android/services/common/AdvertisingInfoServiceStrategy$1;)V
      // 2f: astore 4
      // 31: new android/content/Intent
      // 34: dup
      // 35: ldc "com.google.android.gms.ads.identifier.service.START"
      // 37: invokespecial android/content/Intent.<init> (Ljava/lang/String;)V
      // 3a: astore 3
      // 3b: aload 3
      // 3c: ldc "com.google.android.gms"
      // 3e: invokevirtual android/content/Intent.setPackage (Ljava/lang/String;)Landroid/content/Intent;
      // 41: pop
      // 42: aload 0
      // 43: getfield io/fabric/sdk/android/services/common/AdvertisingInfoServiceStrategy.a Landroid/content/Context;
      // 46: aload 3
      // 47: aload 4
      // 49: bipush 1
      // 4a: invokevirtual android/content/Context.bindService (Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
      // 4d: istore 1
      // 4e: iload 1
      // 4f: ifeq d9
      // 52: new io/fabric/sdk/android/services/common/AdvertisingInfoServiceStrategy$AdvertisingInterface
      // 55: astore 5
      // 57: aload 5
      // 59: aload 4
      // 5b: invokevirtual io/fabric/sdk/android/services/common/AdvertisingInfoServiceStrategy$AdvertisingConnection.a ()Landroid/os/IBinder;
      // 5e: invokespecial io/fabric/sdk/android/services/common/AdvertisingInfoServiceStrategy$AdvertisingInterface.<init> (Landroid/os/IBinder;)V
      // 61: new io/fabric/sdk/android/services/common/AdvertisingInfo
      // 64: astore 3
      // 65: aload 3
      // 66: aload 5
      // 68: invokevirtual io/fabric/sdk/android/services/common/AdvertisingInfoServiceStrategy$AdvertisingInterface.a ()Ljava/lang/String;
      // 6b: aload 5
      // 6d: invokevirtual io/fabric/sdk/android/services/common/AdvertisingInfoServiceStrategy$AdvertisingInterface.b ()Z
      // 70: invokespecial io/fabric/sdk/android/services/common/AdvertisingInfo.<init> (Ljava/lang/String;Z)V
      // 73: aload 0
      // 74: getfield io/fabric/sdk/android/services/common/AdvertisingInfoServiceStrategy.a Landroid/content/Context;
      // 77: aload 4
      // 79: invokevirtual android/content/Context.unbindService (Landroid/content/ServiceConnection;)V
      // 7c: aload 3
      // 7d: astore 2
      // 7e: goto 17
      // 81: astore 3
      // 82: invokestatic io/fabric/sdk/android/Fabric.h ()Lio/fabric/sdk/android/Logger;
      // 85: ldc "Fabric"
      // 87: ldc "Unable to find Google Play Services package name"
      // 89: invokeinterface io/fabric/sdk/android/Logger.a (Ljava/lang/String;Ljava/lang/String;)V 3
      // 8e: goto 17
      // 91: astore 3
      // 92: invokestatic io/fabric/sdk/android/Fabric.h ()Lio/fabric/sdk/android/Logger;
      // 95: ldc "Fabric"
      // 97: ldc "Unable to determine if Google Play Services is available"
      // 99: aload 3
      // 9a: invokeinterface io/fabric/sdk/android/Logger.a (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V 4
      // 9f: goto 17
      // a2: astore 3
      // a3: invokestatic io/fabric/sdk/android/Fabric.h ()Lio/fabric/sdk/android/Logger;
      // a6: ldc "Fabric"
      // a8: ldc "Exception in binding to Google Play Service to capture AdvertisingId"
      // aa: aload 3
      // ab: invokeinterface io/fabric/sdk/android/Logger.d (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V 4
      // b0: aload 0
      // b1: getfield io/fabric/sdk/android/services/common/AdvertisingInfoServiceStrategy.a Landroid/content/Context;
      // b4: aload 4
      // b6: invokevirtual android/content/Context.unbindService (Landroid/content/ServiceConnection;)V
      // b9: goto 17
      // bc: astore 3
      // bd: invokestatic io/fabric/sdk/android/Fabric.h ()Lio/fabric/sdk/android/Logger;
      // c0: ldc "Fabric"
      // c2: ldc "Could not bind to Google Play Service to capture AdvertisingId"
      // c4: aload 3
      // c5: invokeinterface io/fabric/sdk/android/Logger.a (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V 4
      // ca: goto 17
      // cd: astore 3
      // ce: aload 0
      // cf: getfield io/fabric/sdk/android/services/common/AdvertisingInfoServiceStrategy.a Landroid/content/Context;
      // d2: aload 4
      // d4: invokevirtual android/content/Context.unbindService (Landroid/content/ServiceConnection;)V
      // d7: aload 3
      // d8: athrow
      // d9: invokestatic io/fabric/sdk/android/Fabric.h ()Lio/fabric/sdk/android/Logger;
      // dc: ldc "Fabric"
      // de: ldc "Could not bind to Google Play Service to capture AdvertisingId"
      // e0: invokeinterface io/fabric/sdk/android/Logger.a (Ljava/lang/String;Ljava/lang/String;)V 3
      // e5: goto 17
      // try (11 -> 18): 62 android/content/pm/PackageManager$NameNotFoundException
      // try (11 -> 18): 68 java/lang/Exception
      // try (32 -> 39): 86 java/lang/Throwable
      // try (41 -> 55): 75 java/lang/Exception
      // try (41 -> 55): 93 null
      // try (55 -> 59): 86 java/lang/Throwable
      // try (76 -> 81): 93 null
      // try (81 -> 85): 86 java/lang/Throwable
      // try (94 -> 100): 86 java/lang/Throwable
      // try (100 -> 104): 86 java/lang/Throwable
   }

   private static final class AdvertisingConnection implements ServiceConnection {
      private boolean a = false;
      private final LinkedBlockingQueue<IBinder> b = new LinkedBlockingQueue<>(1);

      private AdvertisingConnection() {
      }

      public IBinder a() {
         if (this.a) {
            Fabric.h().e("Fabric", "getBinder already called");
         }

         this.a = true;

         IBinder var1;
         try {
            var1 = this.b.poll(200L, TimeUnit.MILLISECONDS);
         } catch (InterruptedException var2) {
            var1 = null;
         }

         return var1;
      }

      public void onServiceConnected(ComponentName var1, IBinder var2) {
         try {
            this.b.put(var2);
         } catch (InterruptedException var3) {
         }
      }

      public void onServiceDisconnected(ComponentName var1) {
         this.b.clear();
      }
   }

   private static final class AdvertisingInterface implements IInterface {
      private final IBinder a;

      public AdvertisingInterface(IBinder var1) {
         this.a = var1;
      }

      // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      public String a() throws RemoteException {
         Parcel var4 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();
         String var1 = null;
         boolean var7 = false /* VF: Semaphore variable */;

         String var2;
         label44: {
            try {
               var7 = true;
               var4.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
               this.a.transact(1, var4, var3, 0);
               var3.readException();
               var2 = var3.readString();
               var7 = false;
               break label44;
            } catch (Exception var8) {
               Fabric.h().a("Fabric", "Could not get parcel from Google Play Service to capture AdvertisingId");
               var7 = false;
            } finally {
               if (var7) {
                  var3.recycle();
                  var4.recycle();
               }
            }

            var3.recycle();
            var4.recycle();
            return var1;
         }

         var1 = var2;
         var3.recycle();
         var4.recycle();
         return var1;
      }

      public IBinder asBinder() {
         return this.a;
      }

      // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      public boolean b() throws RemoteException {
         boolean var2 = true;
         Parcel var4 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();
         boolean var8 = false /* VF: Semaphore variable */;

         int var1;
         label52: {
            try {
               var8 = true;
               var4.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
               var4.writeInt(1);
               this.a.transact(2, var4, var3, 0);
               var3.readException();
               var1 = var3.readInt();
               var8 = false;
               break label52;
            } catch (Exception var9) {
               Fabric.h().a("Fabric", "Could not get parcel from Google Play Service to capture Advertising limitAdTracking");
               var8 = false;
            } finally {
               if (var8) {
                  var3.recycle();
                  var4.recycle();
               }
            }

            var3.recycle();
            var4.recycle();
            var2 = false;
            return var2;
         }

         if (var1 == 0) {
            var2 = false;
         }

         var3.recycle();
         var4.recycle();
         return var2;
      }
   }
}
