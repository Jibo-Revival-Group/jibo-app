package android.support.v4.media.session;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.v4.media.MediaMetadataCompat;
import android.text.TextUtils;
import java.util.List;

public interface IMediaControllerCallback extends IInterface {
   void a() throws RemoteException;

   void a(int var1) throws RemoteException;

   void a(Bundle var1) throws RemoteException;

   void a(MediaMetadataCompat var1) throws RemoteException;

   void a(ParcelableVolumeInfo var1) throws RemoteException;

   void a(PlaybackStateCompat var1) throws RemoteException;

   void a(CharSequence var1) throws RemoteException;

   void a(String var1, Bundle var2) throws RemoteException;

   void a(List<MediaSessionCompat.QueueItem> var1) throws RemoteException;

   void a(boolean var1) throws RemoteException;

   void b() throws RemoteException;

   void b(int var1) throws RemoteException;

   void b(boolean var1) throws RemoteException;

   abstract class Stub extends Binder implements IMediaControllerCallback {
      public Stub() {
         this.attachInterface(this, "android.support.v4.media.session.IMediaControllerCallback");
      }

      public static IMediaControllerCallback a(IBinder var0) {
         IMediaControllerCallback var2;
         if (var0 == null) {
            var2 = null;
         } else {
            IInterface var1 = var0.queryLocalInterface("android.support.v4.media.session.IMediaControllerCallback");
            if (var1 != null && var1 instanceof IMediaControllerCallback) {
               var2 = (IMediaControllerCallback)var1;
            } else {
               var2 = new IMediaControllerCallback.Stub.Proxy(var0);
            }
         }

         return var2;
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         boolean var5 = false;
         String var8 = null;
         Object var9 = null;
         Object var10 = null;
         Object var11 = null;
         Object var12 = null;
         Object var7 = null;
         boolean var6 = true;
         switch (var1) {
            case 1:
               var2.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
               var8 = var2.readString();
               Bundle var18 = (Bundle)var7;
               if (var2.readInt() != 0) {
                  var18 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
               }

               this.a(var8, var18);
               var5 = var6;
               break;
            case 2:
               var2.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
               this.a();
               var5 = var6;
               break;
            case 3:
               var2.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
               PlaybackStateCompat var17 = var8;
               if (var2.readInt() != 0) {
                  var17 = (PlaybackStateCompat)PlaybackStateCompat.CREATOR.createFromParcel(var2);
               }

               this.a(var17);
               var5 = var6;
               break;
            case 4:
               var2.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
               MediaMetadataCompat var16 = (MediaMetadataCompat)var9;
               if (var2.readInt() != 0) {
                  var16 = (MediaMetadataCompat)MediaMetadataCompat.CREATOR.createFromParcel(var2);
               }

               this.a(var16);
               var5 = var6;
               break;
            case 5:
               var2.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
               this.a(var2.createTypedArrayList(MediaSessionCompat.QueueItem.CREATOR));
               var5 = var6;
               break;
            case 6:
               var2.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
               CharSequence var15 = (CharSequence)var10;
               if (var2.readInt() != 0) {
                  var15 = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(var2);
               }

               this.a(var15);
               var5 = var6;
               break;
            case 7:
               var2.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
               Bundle var14 = (Bundle)var11;
               if (var2.readInt() != 0) {
                  var14 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
               }

               this.a(var14);
               var5 = var6;
               break;
            case 8:
               var2.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
               ParcelableVolumeInfo var13 = (ParcelableVolumeInfo)var12;
               if (var2.readInt() != 0) {
                  var13 = (ParcelableVolumeInfo)ParcelableVolumeInfo.CREATOR.createFromParcel(var2);
               }

               this.a(var13);
               var5 = var6;
               break;
            case 9:
               var2.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
               this.a(var2.readInt());
               var5 = var6;
               break;
            case 10:
               var2.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
               if (var2.readInt() != 0) {
                  var5 = true;
               } else {
                  var5 = false;
               }

               this.a(var5);
               var5 = var6;
               break;
            case 11:
               var2.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
               if (var2.readInt() != 0) {
                  var5 = true;
               }

               this.b(var5);
               var5 = var6;
               break;
            case 12:
               var2.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
               this.b(var2.readInt());
               var5 = var6;
               break;
            case 13:
               var2.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
               this.b();
               var5 = var6;
               break;
            case 1598968902:
               var3.writeString("android.support.v4.media.session.IMediaControllerCallback");
               var5 = var6;
               break;
            default:
               var5 = super.onTransact(var1, var2, var3, var4);
         }

         return var5;
      }

      private static class Proxy implements IMediaControllerCallback {
         private IBinder a;

         Proxy(IBinder var1) {
            this.a = var1;
         }

         @Override
         public void a() throws RemoteException {
            Parcel var2 = Parcel.obtain();

            try {
               var2.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
               this.a.transact(2, var2, null, 1);
            } finally {
               var2.recycle();
            }
         }

         @Override
         public void a(int var1) throws RemoteException {
            Parcel var2 = Parcel.obtain();

            try {
               var2.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
               var2.writeInt(var1);
               this.a.transact(9, var2, null, 1);
            } finally {
               var2.recycle();
            }
         }

         @Override
         public void a(Bundle param1) throws RemoteException {
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
            // 03: astore 2
            // 04: aload 2
            // 05: ldc "android.support.v4.media.session.IMediaControllerCallback"
            // 07: invokevirtual android/os/Parcel.writeInterfaceToken (Ljava/lang/String;)V
            // 0a: aload 1
            // 0b: ifnull 2d
            // 0e: aload 2
            // 0f: bipush 1
            // 10: invokevirtual android/os/Parcel.writeInt (I)V
            // 13: aload 1
            // 14: aload 2
            // 15: bipush 0
            // 16: invokevirtual android/os/Bundle.writeToParcel (Landroid/os/Parcel;I)V
            // 19: aload 0
            // 1a: getfield android/support/v4/media/session/IMediaControllerCallback$Stub$Proxy.a Landroid/os/IBinder;
            // 1d: bipush 7
            // 1f: aload 2
            // 20: aconst_null
            // 21: bipush 1
            // 22: invokeinterface android/os/IBinder.transact (ILandroid/os/Parcel;Landroid/os/Parcel;I)Z 5
            // 27: pop
            // 28: aload 2
            // 29: invokevirtual android/os/Parcel.recycle ()V
            // 2c: return
            // 2d: aload 2
            // 2e: bipush 0
            // 2f: invokevirtual android/os/Parcel.writeInt (I)V
            // 32: goto 19
            // 35: astore 1
            // 36: aload 2
            // 37: invokevirtual android/os/Parcel.recycle ()V
            // 3a: aload 1
            // 3b: athrow
            // try (2 -> 5): 29 null
            // try (7 -> 14): 29 null
            // try (14 -> 22): 29 null
            // try (25 -> 28): 29 null
         }

         @Override
         public void a(MediaMetadataCompat param1) throws RemoteException {
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
            // 03: astore 2
            // 04: aload 2
            // 05: ldc "android.support.v4.media.session.IMediaControllerCallback"
            // 07: invokevirtual android/os/Parcel.writeInterfaceToken (Ljava/lang/String;)V
            // 0a: aload 1
            // 0b: ifnull 2c
            // 0e: aload 2
            // 0f: bipush 1
            // 10: invokevirtual android/os/Parcel.writeInt (I)V
            // 13: aload 1
            // 14: aload 2
            // 15: bipush 0
            // 16: invokevirtual android/support/v4/media/MediaMetadataCompat.writeToParcel (Landroid/os/Parcel;I)V
            // 19: aload 0
            // 1a: getfield android/support/v4/media/session/IMediaControllerCallback$Stub$Proxy.a Landroid/os/IBinder;
            // 1d: bipush 4
            // 1e: aload 2
            // 1f: aconst_null
            // 20: bipush 1
            // 21: invokeinterface android/os/IBinder.transact (ILandroid/os/Parcel;Landroid/os/Parcel;I)Z 5
            // 26: pop
            // 27: aload 2
            // 28: invokevirtual android/os/Parcel.recycle ()V
            // 2b: return
            // 2c: aload 2
            // 2d: bipush 0
            // 2e: invokevirtual android/os/Parcel.writeInt (I)V
            // 31: goto 19
            // 34: astore 1
            // 35: aload 2
            // 36: invokevirtual android/os/Parcel.recycle ()V
            // 39: aload 1
            // 3a: athrow
            // try (2 -> 5): 29 null
            // try (7 -> 14): 29 null
            // try (14 -> 22): 29 null
            // try (25 -> 28): 29 null
         }

         @Override
         public void a(ParcelableVolumeInfo param1) throws RemoteException {
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
            // 03: astore 2
            // 04: aload 2
            // 05: ldc "android.support.v4.media.session.IMediaControllerCallback"
            // 07: invokevirtual android/os/Parcel.writeInterfaceToken (Ljava/lang/String;)V
            // 0a: aload 1
            // 0b: ifnull 2d
            // 0e: aload 2
            // 0f: bipush 1
            // 10: invokevirtual android/os/Parcel.writeInt (I)V
            // 13: aload 1
            // 14: aload 2
            // 15: bipush 0
            // 16: invokevirtual android/support/v4/media/session/ParcelableVolumeInfo.writeToParcel (Landroid/os/Parcel;I)V
            // 19: aload 0
            // 1a: getfield android/support/v4/media/session/IMediaControllerCallback$Stub$Proxy.a Landroid/os/IBinder;
            // 1d: bipush 8
            // 1f: aload 2
            // 20: aconst_null
            // 21: bipush 1
            // 22: invokeinterface android/os/IBinder.transact (ILandroid/os/Parcel;Landroid/os/Parcel;I)Z 5
            // 27: pop
            // 28: aload 2
            // 29: invokevirtual android/os/Parcel.recycle ()V
            // 2c: return
            // 2d: aload 2
            // 2e: bipush 0
            // 2f: invokevirtual android/os/Parcel.writeInt (I)V
            // 32: goto 19
            // 35: astore 1
            // 36: aload 2
            // 37: invokevirtual android/os/Parcel.recycle ()V
            // 3a: aload 1
            // 3b: athrow
            // try (2 -> 5): 29 null
            // try (7 -> 14): 29 null
            // try (14 -> 22): 29 null
            // try (25 -> 28): 29 null
         }

         @Override
         public void a(PlaybackStateCompat param1) throws RemoteException {
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
            // 03: astore 2
            // 04: aload 2
            // 05: ldc "android.support.v4.media.session.IMediaControllerCallback"
            // 07: invokevirtual android/os/Parcel.writeInterfaceToken (Ljava/lang/String;)V
            // 0a: aload 1
            // 0b: ifnull 2c
            // 0e: aload 2
            // 0f: bipush 1
            // 10: invokevirtual android/os/Parcel.writeInt (I)V
            // 13: aload 1
            // 14: aload 2
            // 15: bipush 0
            // 16: invokevirtual android/support/v4/media/session/PlaybackStateCompat.writeToParcel (Landroid/os/Parcel;I)V
            // 19: aload 0
            // 1a: getfield android/support/v4/media/session/IMediaControllerCallback$Stub$Proxy.a Landroid/os/IBinder;
            // 1d: bipush 3
            // 1e: aload 2
            // 1f: aconst_null
            // 20: bipush 1
            // 21: invokeinterface android/os/IBinder.transact (ILandroid/os/Parcel;Landroid/os/Parcel;I)Z 5
            // 26: pop
            // 27: aload 2
            // 28: invokevirtual android/os/Parcel.recycle ()V
            // 2b: return
            // 2c: aload 2
            // 2d: bipush 0
            // 2e: invokevirtual android/os/Parcel.writeInt (I)V
            // 31: goto 19
            // 34: astore 1
            // 35: aload 2
            // 36: invokevirtual android/os/Parcel.recycle ()V
            // 39: aload 1
            // 3a: athrow
            // try (2 -> 5): 29 null
            // try (7 -> 14): 29 null
            // try (14 -> 22): 29 null
            // try (25 -> 28): 29 null
         }

         @Override
         public void a(CharSequence param1) throws RemoteException {
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
            // 03: astore 2
            // 04: aload 2
            // 05: ldc "android.support.v4.media.session.IMediaControllerCallback"
            // 07: invokevirtual android/os/Parcel.writeInterfaceToken (Ljava/lang/String;)V
            // 0a: aload 1
            // 0b: ifnull 2d
            // 0e: aload 2
            // 0f: bipush 1
            // 10: invokevirtual android/os/Parcel.writeInt (I)V
            // 13: aload 1
            // 14: aload 2
            // 15: bipush 0
            // 16: invokestatic android/text/TextUtils.writeToParcel (Ljava/lang/CharSequence;Landroid/os/Parcel;I)V
            // 19: aload 0
            // 1a: getfield android/support/v4/media/session/IMediaControllerCallback$Stub$Proxy.a Landroid/os/IBinder;
            // 1d: bipush 6
            // 1f: aload 2
            // 20: aconst_null
            // 21: bipush 1
            // 22: invokeinterface android/os/IBinder.transact (ILandroid/os/Parcel;Landroid/os/Parcel;I)Z 5
            // 27: pop
            // 28: aload 2
            // 29: invokevirtual android/os/Parcel.recycle ()V
            // 2c: return
            // 2d: aload 2
            // 2e: bipush 0
            // 2f: invokevirtual android/os/Parcel.writeInt (I)V
            // 32: goto 19
            // 35: astore 1
            // 36: aload 2
            // 37: invokevirtual android/os/Parcel.recycle ()V
            // 3a: aload 1
            // 3b: athrow
            // try (2 -> 5): 29 null
            // try (7 -> 14): 29 null
            // try (14 -> 22): 29 null
            // try (25 -> 28): 29 null
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
            // 05: ldc "android.support.v4.media.session.IMediaControllerCallback"
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
            // 1f: getfield android/support/v4/media/session/IMediaControllerCallback$Stub$Proxy.a Landroid/os/IBinder;
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

         @Override
         public void a(List<MediaSessionCompat.QueueItem> var1) throws RemoteException {
            Parcel var2 = Parcel.obtain();

            try {
               var2.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
               var2.writeTypedList(var1);
               this.a.transact(5, var2, null, 1);
            } finally {
               var2.recycle();
            }
         }

         @Override
         public void a(boolean param1) throws RemoteException {
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
            // 05: astore 4
            // 07: aload 4
            // 09: ldc "android.support.v4.media.session.IMediaControllerCallback"
            // 0b: invokevirtual android/os/Parcel.writeInterfaceToken (Ljava/lang/String;)V
            // 0e: iload 1
            // 0f: ifeq 2e
            // 12: aload 4
            // 14: iload 2
            // 15: invokevirtual android/os/Parcel.writeInt (I)V
            // 18: aload 0
            // 19: getfield android/support/v4/media/session/IMediaControllerCallback$Stub$Proxy.a Landroid/os/IBinder;
            // 1c: bipush 10
            // 1e: aload 4
            // 20: aconst_null
            // 21: bipush 1
            // 22: invokeinterface android/os/IBinder.transact (ILandroid/os/Parcel;Landroid/os/Parcel;I)Z 5
            // 27: pop
            // 28: aload 4
            // 2a: invokevirtual android/os/Parcel.recycle ()V
            // 2d: return
            // 2e: bipush 0
            // 2f: istore 2
            // 30: goto 12
            // 33: astore 3
            // 34: aload 4
            // 36: invokevirtual android/os/Parcel.recycle ()V
            // 39: aload 3
            // 3a: athrow
            // try (4 -> 7): 26 null
            // try (9 -> 20): 26 null
         }

         public IBinder asBinder() {
            return this.a;
         }

         @Override
         public void b() throws RemoteException {
            Parcel var1 = Parcel.obtain();

            try {
               var1.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
               this.a.transact(13, var1, null, 1);
            } finally {
               var1.recycle();
            }
         }

         @Override
         public void b(int var1) throws RemoteException {
            Parcel var3 = Parcel.obtain();

            try {
               var3.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
               var3.writeInt(var1);
               this.a.transact(12, var3, null, 1);
            } finally {
               var3.recycle();
            }
         }

         @Override
         public void b(boolean param1) throws RemoteException {
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
            // 07: ldc "android.support.v4.media.session.IMediaControllerCallback"
            // 09: invokevirtual android/os/Parcel.writeInterfaceToken (Ljava/lang/String;)V
            // 0c: iload 1
            // 0d: ifeq 29
            // 10: aload 3
            // 11: iload 2
            // 12: invokevirtual android/os/Parcel.writeInt (I)V
            // 15: aload 0
            // 16: getfield android/support/v4/media/session/IMediaControllerCallback$Stub$Proxy.a Landroid/os/IBinder;
            // 19: bipush 11
            // 1b: aload 3
            // 1c: aconst_null
            // 1d: bipush 1
            // 1e: invokeinterface android/os/IBinder.transact (ILandroid/os/Parcel;Landroid/os/Parcel;I)Z 5
            // 23: pop
            // 24: aload 3
            // 25: invokevirtual android/os/Parcel.recycle ()V
            // 28: return
            // 29: bipush 0
            // 2a: istore 2
            // 2b: goto 10
            // 2e: astore 4
            // 30: aload 3
            // 31: invokevirtual android/os/Parcel.recycle ()V
            // 34: aload 4
            // 36: athrow
            // try (4 -> 7): 26 null
            // try (9 -> 20): 26 null
         }
      }
   }
}
