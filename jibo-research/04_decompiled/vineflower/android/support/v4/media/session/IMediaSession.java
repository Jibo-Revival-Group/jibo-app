package android.support.v4.media.session;

import android.app.PendingIntent;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.text.TextUtils;
import android.view.KeyEvent;
import java.util.List;

public interface IMediaSession extends IInterface {
   void a(int var1) throws RemoteException;

   void a(int var1, int var2, String var3) throws RemoteException;

   void a(long var1) throws RemoteException;

   void a(Uri var1, Bundle var2) throws RemoteException;

   void a(MediaDescriptionCompat var1) throws RemoteException;

   void a(MediaDescriptionCompat var1, int var2) throws RemoteException;

   void a(RatingCompat var1) throws RemoteException;

   void a(RatingCompat var1, Bundle var2) throws RemoteException;

   void a(IMediaControllerCallback var1) throws RemoteException;

   void a(String var1, Bundle var2) throws RemoteException;

   void a(String var1, Bundle var2, MediaSessionCompat.ResultReceiverWrapper var3) throws RemoteException;

   void a(boolean var1) throws RemoteException;

   boolean a() throws RemoteException;

   boolean a(KeyEvent var1) throws RemoteException;

   String b() throws RemoteException;

   void b(int var1) throws RemoteException;

   void b(int var1, int var2, String var3) throws RemoteException;

   void b(long var1) throws RemoteException;

   void b(Uri var1, Bundle var2) throws RemoteException;

   void b(MediaDescriptionCompat var1) throws RemoteException;

   void b(IMediaControllerCallback var1) throws RemoteException;

   void b(String var1, Bundle var2) throws RemoteException;

   void b(boolean var1) throws RemoteException;

   String c() throws RemoteException;

   void c(int var1) throws RemoteException;

   void c(String var1, Bundle var2) throws RemoteException;

   PendingIntent d() throws RemoteException;

   void d(String var1, Bundle var2) throws RemoteException;

   long e() throws RemoteException;

   void e(String var1, Bundle var2) throws RemoteException;

   ParcelableVolumeInfo f() throws RemoteException;

   MediaMetadataCompat g() throws RemoteException;

   PlaybackStateCompat h() throws RemoteException;

   List<MediaSessionCompat.QueueItem> i() throws RemoteException;

   CharSequence j() throws RemoteException;

   Bundle k() throws RemoteException;

   int l() throws RemoteException;

   boolean m() throws RemoteException;

   int n() throws RemoteException;

   boolean o() throws RemoteException;

   int p() throws RemoteException;

   void q() throws RemoteException;

   void r() throws RemoteException;

   void s() throws RemoteException;

   void t() throws RemoteException;

   void u() throws RemoteException;

   void v() throws RemoteException;

   void w() throws RemoteException;

   void x() throws RemoteException;

   abstract class Stub extends Binder implements IMediaSession {
      public static IMediaSession a(IBinder var0) {
         IMediaSession var2;
         if (var0 == null) {
            var2 = null;
         } else {
            IInterface var1 = var0.queryLocalInterface("android.support.v4.media.session.IMediaSession");
            if (var1 != null && var1 instanceof IMediaSession) {
               var2 = (IMediaSession)var1;
            } else {
               var2 = new IMediaSession.Stub.Proxy(var0);
            }
         }

         return var2;
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         byte var5 = 0;
         byte var6 = 0;
         boolean var10 = false;
         boolean var8 = false;
         byte var7 = 0;
         boolean var9 = true;
         switch (var1) {
            case 1:
               var2.enforceInterface("android.support.v4.media.session.IMediaSession");
               String var14 = var2.readString();
               Bundle var58;
               if (var2.readInt() != 0) {
                  var58 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
               } else {
                  var58 = null;
               }

               MediaSessionCompat.ResultReceiverWrapper var43;
               if (var2.readInt() != 0) {
                  var43 = (MediaSessionCompat.ResultReceiverWrapper)MediaSessionCompat.ResultReceiverWrapper.CREATOR.createFromParcel(var2);
               } else {
                  var43 = null;
               }

               this.a(var14, var58, var43);
               var3.writeNoException();
               var8 = var9;
               break;
            case 2:
               var2.enforceInterface("android.support.v4.media.session.IMediaSession");
               KeyEvent var42;
               if (var2.readInt() != 0) {
                  var42 = (KeyEvent)KeyEvent.CREATOR.createFromParcel(var2);
               } else {
                  var42 = null;
               }

               var8 = this.a(var42);
               var3.writeNoException();
               byte var21;
               if (var8) {
                  var21 = 1;
               } else {
                  var21 = 0;
               }

               var3.writeInt(var21);
               var8 = var9;
               break;
            case 3:
               var2.enforceInterface("android.support.v4.media.session.IMediaSession");
               this.a(IMediaControllerCallback.Stub.a(var2.readStrongBinder()));
               var3.writeNoException();
               var8 = var9;
               break;
            case 4:
               var2.enforceInterface("android.support.v4.media.session.IMediaSession");
               this.b(IMediaControllerCallback.Stub.a(var2.readStrongBinder()));
               var3.writeNoException();
               var8 = var9;
               break;
            case 5:
               var2.enforceInterface("android.support.v4.media.session.IMediaSession");
               var8 = this.a();
               var3.writeNoException();
               byte var20 = var7;
               if (var8) {
                  var20 = 1;
               }

               var3.writeInt(var20);
               var8 = var9;
               break;
            case 6:
               var2.enforceInterface("android.support.v4.media.session.IMediaSession");
               String var41 = this.b();
               var3.writeNoException();
               var3.writeString(var41);
               var8 = var9;
               break;
            case 7:
               var2.enforceInterface("android.support.v4.media.session.IMediaSession");
               String var40 = this.c();
               var3.writeNoException();
               var3.writeString(var40);
               var8 = var9;
               break;
            case 8:
               var2.enforceInterface("android.support.v4.media.session.IMediaSession");
               PendingIntent var39 = this.d();
               var3.writeNoException();
               if (var39 != null) {
                  var3.writeInt(1);
                  var39.writeToParcel(var3, 1);
                  var8 = var9;
               } else {
                  var3.writeInt(0);
                  var8 = var9;
               }
               break;
            case 9:
               var2.enforceInterface("android.support.v4.media.session.IMediaSession");
               long var11 = this.e();
               var3.writeNoException();
               var3.writeLong(var11);
               var8 = var9;
               break;
            case 10:
               var2.enforceInterface("android.support.v4.media.session.IMediaSession");
               ParcelableVolumeInfo var38 = this.f();
               var3.writeNoException();
               if (var38 != null) {
                  var3.writeInt(1);
                  var38.writeToParcel(var3, 1);
                  var8 = var9;
               } else {
                  var3.writeInt(0);
                  var8 = var9;
               }
               break;
            case 11:
               var2.enforceInterface("android.support.v4.media.session.IMediaSession");
               this.a(var2.readInt(), var2.readInt(), var2.readString());
               var3.writeNoException();
               var8 = var9;
               break;
            case 12:
               var2.enforceInterface("android.support.v4.media.session.IMediaSession");
               this.b(var2.readInt(), var2.readInt(), var2.readString());
               var3.writeNoException();
               var8 = var9;
               break;
            case 13:
               var2.enforceInterface("android.support.v4.media.session.IMediaSession");
               this.r();
               var3.writeNoException();
               var8 = var9;
               break;
            case 14:
               var2.enforceInterface("android.support.v4.media.session.IMediaSession");
               String var57 = var2.readString();
               Bundle var37;
               if (var2.readInt() != 0) {
                  var37 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
               } else {
                  var37 = null;
               }

               this.c(var57, var37);
               var3.writeNoException();
               var8 = var9;
               break;
            case 15:
               var2.enforceInterface("android.support.v4.media.session.IMediaSession");
               String var56 = var2.readString();
               Bundle var36;
               if (var2.readInt() != 0) {
                  var36 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
               } else {
                  var36 = null;
               }

               this.d(var56, var36);
               var3.writeNoException();
               var8 = var9;
               break;
            case 16:
               var2.enforceInterface("android.support.v4.media.session.IMediaSession");
               Uri var55;
               if (var2.readInt() != 0) {
                  var55 = (Uri)Uri.CREATOR.createFromParcel(var2);
               } else {
                  var55 = null;
               }

               Bundle var35;
               if (var2.readInt() != 0) {
                  var35 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
               } else {
                  var35 = null;
               }

               this.b(var55, var35);
               var3.writeNoException();
               var8 = var9;
               break;
            case 17:
               var2.enforceInterface("android.support.v4.media.session.IMediaSession");
               this.a(var2.readLong());
               var3.writeNoException();
               var8 = var9;
               break;
            case 18:
               var2.enforceInterface("android.support.v4.media.session.IMediaSession");
               this.s();
               var3.writeNoException();
               var8 = var9;
               break;
            case 19:
               var2.enforceInterface("android.support.v4.media.session.IMediaSession");
               this.t();
               var3.writeNoException();
               var8 = var9;
               break;
            case 20:
               var2.enforceInterface("android.support.v4.media.session.IMediaSession");
               this.u();
               var3.writeNoException();
               var8 = var9;
               break;
            case 21:
               var2.enforceInterface("android.support.v4.media.session.IMediaSession");
               this.v();
               var3.writeNoException();
               var8 = var9;
               break;
            case 22:
               var2.enforceInterface("android.support.v4.media.session.IMediaSession");
               this.w();
               var3.writeNoException();
               var8 = var9;
               break;
            case 23:
               var2.enforceInterface("android.support.v4.media.session.IMediaSession");
               this.x();
               var3.writeNoException();
               var8 = var9;
               break;
            case 24:
               var2.enforceInterface("android.support.v4.media.session.IMediaSession");
               this.b(var2.readLong());
               var3.writeNoException();
               var8 = var9;
               break;
            case 25:
               var2.enforceInterface("android.support.v4.media.session.IMediaSession");
               RatingCompat var34;
               if (var2.readInt() != 0) {
                  var34 = (RatingCompat)RatingCompat.CREATOR.createFromParcel(var2);
               } else {
                  var34 = null;
               }

               this.a(var34);
               var3.writeNoException();
               var8 = var9;
               break;
            case 26:
               var2.enforceInterface("android.support.v4.media.session.IMediaSession");
               String var54 = var2.readString();
               Bundle var33;
               if (var2.readInt() != 0) {
                  var33 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
               } else {
                  var33 = null;
               }

               this.e(var54, var33);
               var3.writeNoException();
               var8 = var9;
               break;
            case 27:
               var2.enforceInterface("android.support.v4.media.session.IMediaSession");
               MediaMetadataCompat var32 = this.g();
               var3.writeNoException();
               if (var32 != null) {
                  var3.writeInt(1);
                  var32.writeToParcel(var3, 1);
                  var8 = var9;
               } else {
                  var3.writeInt(0);
                  var8 = var9;
               }
               break;
            case 28:
               var2.enforceInterface("android.support.v4.media.session.IMediaSession");
               PlaybackStateCompat var31 = this.h();
               var3.writeNoException();
               if (var31 != null) {
                  var3.writeInt(1);
                  var31.writeToParcel(var3, 1);
                  var8 = var9;
               } else {
                  var3.writeInt(0);
                  var8 = var9;
               }
               break;
            case 29:
               var2.enforceInterface("android.support.v4.media.session.IMediaSession");
               List var30 = this.i();
               var3.writeNoException();
               var3.writeTypedList(var30);
               var8 = var9;
               break;
            case 30:
               var2.enforceInterface("android.support.v4.media.session.IMediaSession");
               CharSequence var29 = this.j();
               var3.writeNoException();
               if (var29 != null) {
                  var3.writeInt(1);
                  TextUtils.writeToParcel(var29, var3, 1);
                  var8 = var9;
               } else {
                  var3.writeInt(0);
                  var8 = var9;
               }
               break;
            case 31:
               var2.enforceInterface("android.support.v4.media.session.IMediaSession");
               Bundle var28 = this.k();
               var3.writeNoException();
               if (var28 != null) {
                  var3.writeInt(1);
                  var28.writeToParcel(var3, 1);
                  var8 = var9;
               } else {
                  var3.writeInt(0);
                  var8 = var9;
               }
               break;
            case 32:
               var2.enforceInterface("android.support.v4.media.session.IMediaSession");
               var1 = this.l();
               var3.writeNoException();
               var3.writeInt(var1);
               var8 = var9;
               break;
            case 33:
               var2.enforceInterface("android.support.v4.media.session.IMediaSession");
               this.q();
               var3.writeNoException();
               var8 = var9;
               break;
            case 34:
               var2.enforceInterface("android.support.v4.media.session.IMediaSession");
               String var53 = var2.readString();
               Bundle var27;
               if (var2.readInt() != 0) {
                  var27 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
               } else {
                  var27 = null;
               }

               this.a(var53, var27);
               var3.writeNoException();
               var8 = var9;
               break;
            case 35:
               var2.enforceInterface("android.support.v4.media.session.IMediaSession");
               String var52 = var2.readString();
               Bundle var26;
               if (var2.readInt() != 0) {
                  var26 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
               } else {
                  var26 = null;
               }

               this.b(var52, var26);
               var3.writeNoException();
               var8 = var9;
               break;
            case 36:
               var2.enforceInterface("android.support.v4.media.session.IMediaSession");
               Uri var51;
               if (var2.readInt() != 0) {
                  var51 = (Uri)Uri.CREATOR.createFromParcel(var2);
               } else {
                  var51 = null;
               }

               Bundle var25;
               if (var2.readInt() != 0) {
                  var25 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
               } else {
                  var25 = null;
               }

               this.a(var51, var25);
               var3.writeNoException();
               var8 = var9;
               break;
            case 37:
               var2.enforceInterface("android.support.v4.media.session.IMediaSession");
               var1 = this.n();
               var3.writeNoException();
               var3.writeInt(var1);
               var8 = var9;
               break;
            case 38:
               var2.enforceInterface("android.support.v4.media.session.IMediaSession");
               var8 = this.o();
               var3.writeNoException();
               byte var17 = var6;
               if (var8) {
                  var17 = 1;
               }

               var3.writeInt(var17);
               var8 = var9;
               break;
            case 39:
               var2.enforceInterface("android.support.v4.media.session.IMediaSession");
               this.b(var2.readInt());
               var3.writeNoException();
               var8 = var9;
               break;
            case 40:
               var2.enforceInterface("android.support.v4.media.session.IMediaSession");
               if (var2.readInt() != 0) {
                  var8 = true;
               }

               this.b(var8);
               var3.writeNoException();
               var8 = var9;
               break;
            case 41:
               var2.enforceInterface("android.support.v4.media.session.IMediaSession");
               MediaDescriptionCompat var24;
               if (var2.readInt() != 0) {
                  var24 = (MediaDescriptionCompat)MediaDescriptionCompat.CREATOR.createFromParcel(var2);
               } else {
                  var24 = null;
               }

               this.a(var24);
               var3.writeNoException();
               var8 = var9;
               break;
            case 42:
               var2.enforceInterface("android.support.v4.media.session.IMediaSession");
               MediaDescriptionCompat var50;
               if (var2.readInt() != 0) {
                  var50 = (MediaDescriptionCompat)MediaDescriptionCompat.CREATOR.createFromParcel(var2);
               } else {
                  var50 = null;
               }

               this.a(var50, var2.readInt());
               var3.writeNoException();
               var8 = var9;
               break;
            case 43:
               var2.enforceInterface("android.support.v4.media.session.IMediaSession");
               MediaDescriptionCompat var23;
               if (var2.readInt() != 0) {
                  var23 = (MediaDescriptionCompat)MediaDescriptionCompat.CREATOR.createFromParcel(var2);
               } else {
                  var23 = null;
               }

               this.b(var23);
               var3.writeNoException();
               var8 = var9;
               break;
            case 44:
               var2.enforceInterface("android.support.v4.media.session.IMediaSession");
               this.a(var2.readInt());
               var3.writeNoException();
               var8 = var9;
               break;
            case 45:
               var2.enforceInterface("android.support.v4.media.session.IMediaSession");
               var8 = this.m();
               var3.writeNoException();
               byte var16 = var5;
               if (var8) {
                  var16 = 1;
               }

               var3.writeInt(var16);
               var8 = var9;
               break;
            case 46:
               var2.enforceInterface("android.support.v4.media.session.IMediaSession");
               var8 = var10;
               if (var2.readInt() != 0) {
                  var8 = true;
               }

               this.a(var8);
               var3.writeNoException();
               var8 = var9;
               break;
            case 47:
               var2.enforceInterface("android.support.v4.media.session.IMediaSession");
               var1 = this.p();
               var3.writeNoException();
               var3.writeInt(var1);
               var8 = var9;
               break;
            case 48:
               var2.enforceInterface("android.support.v4.media.session.IMediaSession");
               this.c(var2.readInt());
               var3.writeNoException();
               var8 = var9;
               break;
            case 51:
               var2.enforceInterface("android.support.v4.media.session.IMediaSession");
               RatingCompat var13;
               if (var2.readInt() != 0) {
                  var13 = (RatingCompat)RatingCompat.CREATOR.createFromParcel(var2);
               } else {
                  var13 = null;
               }

               Bundle var22;
               if (var2.readInt() != 0) {
                  var22 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
               } else {
                  var22 = null;
               }

               this.a(var13, var22);
               var3.writeNoException();
               var8 = var9;
               break;
            case 1598968902:
               var3.writeString("android.support.v4.media.session.IMediaSession");
               var8 = var9;
               break;
            default:
               var8 = super.onTransact(var1, var2, var3, var4);
         }

         return var8;
      }

      private static class Proxy implements IMediaSession {
         private IBinder a;

         Proxy(IBinder var1) {
            this.a = var1;
         }

         @Override
         public void a(int var1) throws RemoteException {
            Parcel var2 = Parcel.obtain();
            Parcel var3 = Parcel.obtain();

            try {
               var2.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
               var2.writeInt(var1);
               this.a.transact(44, var2, var3, 0);
               var3.readException();
            } finally {
               var3.recycle();
               var2.recycle();
            }
         }

         @Override
         public void a(int var1, int var2, String var3) throws RemoteException {
            Parcel var4 = Parcel.obtain();
            Parcel var5 = Parcel.obtain();

            try {
               var4.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
               var4.writeInt(var1);
               var4.writeInt(var2);
               var4.writeString(var3);
               this.a.transact(11, var4, var5, 0);
               var5.readException();
            } finally {
               var5.recycle();
               var4.recycle();
            }
         }

         @Override
         public void a(long var1) throws RemoteException {
            Parcel var5 = Parcel.obtain();
            Parcel var4 = Parcel.obtain();

            try {
               var5.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
               var5.writeLong(var1);
               this.a.transact(17, var5, var4, 0);
               var4.readException();
            } finally {
               var4.recycle();
               var5.recycle();
            }
         }

         @Override
         public void a(Uri param1, Bundle param2) throws RemoteException {
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
            // 04: invokestatic android/os/Parcel.obtain ()Landroid/os/Parcel;
            // 07: astore 4
            // 09: aload 3
            // 0a: ldc "android.support.v4.media.session.IMediaSession"
            // 0c: invokevirtual android/os/Parcel.writeInterfaceToken (Ljava/lang/String;)V
            // 0f: aload 1
            // 10: ifnull 4c
            // 13: aload 3
            // 14: bipush 1
            // 15: invokevirtual android/os/Parcel.writeInt (I)V
            // 18: aload 1
            // 19: aload 3
            // 1a: bipush 0
            // 1b: invokevirtual android/net/Uri.writeToParcel (Landroid/os/Parcel;I)V
            // 1e: aload 2
            // 1f: ifnull 60
            // 22: aload 3
            // 23: bipush 1
            // 24: invokevirtual android/os/Parcel.writeInt (I)V
            // 27: aload 2
            // 28: aload 3
            // 29: bipush 0
            // 2a: invokevirtual android/os/Bundle.writeToParcel (Landroid/os/Parcel;I)V
            // 2d: aload 0
            // 2e: getfield android/support/v4/media/session/IMediaSession$Stub$Proxy.a Landroid/os/IBinder;
            // 31: bipush 36
            // 33: aload 3
            // 34: aload 4
            // 36: bipush 0
            // 37: invokeinterface android/os/IBinder.transact (ILandroid/os/Parcel;Landroid/os/Parcel;I)Z 5
            // 3c: pop
            // 3d: aload 4
            // 3f: invokevirtual android/os/Parcel.readException ()V
            // 42: aload 4
            // 44: invokevirtual android/os/Parcel.recycle ()V
            // 47: aload 3
            // 48: invokevirtual android/os/Parcel.recycle ()V
            // 4b: return
            // 4c: aload 3
            // 4d: bipush 0
            // 4e: invokevirtual android/os/Parcel.writeInt (I)V
            // 51: goto 1e
            // 54: astore 1
            // 55: aload 4
            // 57: invokevirtual android/os/Parcel.recycle ()V
            // 5a: aload 3
            // 5b: invokevirtual android/os/Parcel.recycle ()V
            // 5e: aload 1
            // 5f: athrow
            // 60: aload 3
            // 61: bipush 0
            // 62: invokevirtual android/os/Parcel.writeInt (I)V
            // 65: goto 2d
            // try (4 -> 7): 44 null
            // try (9 -> 16): 44 null
            // try (18 -> 25): 44 null
            // try (25 -> 35): 44 null
            // try (40 -> 43): 44 null
            // try (51 -> 54): 44 null
         }

         @Override
         public void a(MediaDescriptionCompat param1) throws RemoteException {
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
            // 04: invokestatic android/os/Parcel.obtain ()Landroid/os/Parcel;
            // 07: astore 2
            // 08: aload 3
            // 09: ldc "android.support.v4.media.session.IMediaSession"
            // 0b: invokevirtual android/os/Parcel.writeInterfaceToken (Ljava/lang/String;)V
            // 0e: aload 1
            // 0f: ifnull 39
            // 12: aload 3
            // 13: bipush 1
            // 14: invokevirtual android/os/Parcel.writeInt (I)V
            // 17: aload 1
            // 18: aload 3
            // 19: bipush 0
            // 1a: invokevirtual android/support/v4/media/MediaDescriptionCompat.writeToParcel (Landroid/os/Parcel;I)V
            // 1d: aload 0
            // 1e: getfield android/support/v4/media/session/IMediaSession$Stub$Proxy.a Landroid/os/IBinder;
            // 21: bipush 41
            // 23: aload 3
            // 24: aload 2
            // 25: bipush 0
            // 26: invokeinterface android/os/IBinder.transact (ILandroid/os/Parcel;Landroid/os/Parcel;I)Z 5
            // 2b: pop
            // 2c: aload 2
            // 2d: invokevirtual android/os/Parcel.readException ()V
            // 30: aload 2
            // 31: invokevirtual android/os/Parcel.recycle ()V
            // 34: aload 3
            // 35: invokevirtual android/os/Parcel.recycle ()V
            // 38: return
            // 39: aload 3
            // 3a: bipush 0
            // 3b: invokevirtual android/os/Parcel.writeInt (I)V
            // 3e: goto 1d
            // 41: astore 1
            // 42: aload 2
            // 43: invokevirtual android/os/Parcel.recycle ()V
            // 46: aload 3
            // 47: invokevirtual android/os/Parcel.recycle ()V
            // 4a: aload 1
            // 4b: athrow
            // try (4 -> 7): 35 null
            // try (9 -> 16): 35 null
            // try (16 -> 26): 35 null
            // try (31 -> 34): 35 null
         }

         @Override
         public void a(MediaDescriptionCompat param1, int param2) throws RemoteException {
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
            // 04: invokestatic android/os/Parcel.obtain ()Landroid/os/Parcel;
            // 07: astore 4
            // 09: aload 3
            // 0a: ldc "android.support.v4.media.session.IMediaSession"
            // 0c: invokevirtual android/os/Parcel.writeInterfaceToken (Ljava/lang/String;)V
            // 0f: aload 1
            // 10: ifnull 42
            // 13: aload 3
            // 14: bipush 1
            // 15: invokevirtual android/os/Parcel.writeInt (I)V
            // 18: aload 1
            // 19: aload 3
            // 1a: bipush 0
            // 1b: invokevirtual android/support/v4/media/MediaDescriptionCompat.writeToParcel (Landroid/os/Parcel;I)V
            // 1e: aload 3
            // 1f: iload 2
            // 20: invokevirtual android/os/Parcel.writeInt (I)V
            // 23: aload 0
            // 24: getfield android/support/v4/media/session/IMediaSession$Stub$Proxy.a Landroid/os/IBinder;
            // 27: bipush 42
            // 29: aload 3
            // 2a: aload 4
            // 2c: bipush 0
            // 2d: invokeinterface android/os/IBinder.transact (ILandroid/os/Parcel;Landroid/os/Parcel;I)Z 5
            // 32: pop
            // 33: aload 4
            // 35: invokevirtual android/os/Parcel.readException ()V
            // 38: aload 4
            // 3a: invokevirtual android/os/Parcel.recycle ()V
            // 3d: aload 3
            // 3e: invokevirtual android/os/Parcel.recycle ()V
            // 41: return
            // 42: aload 3
            // 43: bipush 0
            // 44: invokevirtual android/os/Parcel.writeInt (I)V
            // 47: goto 1e
            // 4a: astore 1
            // 4b: aload 4
            // 4d: invokevirtual android/os/Parcel.recycle ()V
            // 50: aload 3
            // 51: invokevirtual android/os/Parcel.recycle ()V
            // 54: aload 1
            // 55: athrow
            // try (4 -> 7): 38 null
            // try (9 -> 16): 38 null
            // try (16 -> 29): 38 null
            // try (34 -> 37): 38 null
         }

         @Override
         public void a(RatingCompat param1) throws RemoteException {
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
            // 04: invokestatic android/os/Parcel.obtain ()Landroid/os/Parcel;
            // 07: astore 2
            // 08: aload 3
            // 09: ldc "android.support.v4.media.session.IMediaSession"
            // 0b: invokevirtual android/os/Parcel.writeInterfaceToken (Ljava/lang/String;)V
            // 0e: aload 1
            // 0f: ifnull 39
            // 12: aload 3
            // 13: bipush 1
            // 14: invokevirtual android/os/Parcel.writeInt (I)V
            // 17: aload 1
            // 18: aload 3
            // 19: bipush 0
            // 1a: invokevirtual android/support/v4/media/RatingCompat.writeToParcel (Landroid/os/Parcel;I)V
            // 1d: aload 0
            // 1e: getfield android/support/v4/media/session/IMediaSession$Stub$Proxy.a Landroid/os/IBinder;
            // 21: bipush 25
            // 23: aload 3
            // 24: aload 2
            // 25: bipush 0
            // 26: invokeinterface android/os/IBinder.transact (ILandroid/os/Parcel;Landroid/os/Parcel;I)Z 5
            // 2b: pop
            // 2c: aload 2
            // 2d: invokevirtual android/os/Parcel.readException ()V
            // 30: aload 2
            // 31: invokevirtual android/os/Parcel.recycle ()V
            // 34: aload 3
            // 35: invokevirtual android/os/Parcel.recycle ()V
            // 38: return
            // 39: aload 3
            // 3a: bipush 0
            // 3b: invokevirtual android/os/Parcel.writeInt (I)V
            // 3e: goto 1d
            // 41: astore 1
            // 42: aload 2
            // 43: invokevirtual android/os/Parcel.recycle ()V
            // 46: aload 3
            // 47: invokevirtual android/os/Parcel.recycle ()V
            // 4a: aload 1
            // 4b: athrow
            // try (4 -> 7): 35 null
            // try (9 -> 16): 35 null
            // try (16 -> 26): 35 null
            // try (31 -> 34): 35 null
         }

         @Override
         public void a(RatingCompat param1, Bundle param2) throws RemoteException {
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
            // 03: astore 4
            // 05: invokestatic android/os/Parcel.obtain ()Landroid/os/Parcel;
            // 08: astore 3
            // 09: aload 4
            // 0b: ldc "android.support.v4.media.session.IMediaSession"
            // 0d: invokevirtual android/os/Parcel.writeInterfaceToken (Ljava/lang/String;)V
            // 10: aload 1
            // 11: ifnull 50
            // 14: aload 4
            // 16: bipush 1
            // 17: invokevirtual android/os/Parcel.writeInt (I)V
            // 1a: aload 1
            // 1b: aload 4
            // 1d: bipush 0
            // 1e: invokevirtual android/support/v4/media/RatingCompat.writeToParcel (Landroid/os/Parcel;I)V
            // 21: aload 2
            // 22: ifnull 65
            // 25: aload 4
            // 27: bipush 1
            // 28: invokevirtual android/os/Parcel.writeInt (I)V
            // 2b: aload 2
            // 2c: aload 4
            // 2e: bipush 0
            // 2f: invokevirtual android/os/Bundle.writeToParcel (Landroid/os/Parcel;I)V
            // 32: aload 0
            // 33: getfield android/support/v4/media/session/IMediaSession$Stub$Proxy.a Landroid/os/IBinder;
            // 36: bipush 51
            // 38: aload 4
            // 3a: aload 3
            // 3b: bipush 0
            // 3c: invokeinterface android/os/IBinder.transact (ILandroid/os/Parcel;Landroid/os/Parcel;I)Z 5
            // 41: pop
            // 42: aload 3
            // 43: invokevirtual android/os/Parcel.readException ()V
            // 46: aload 3
            // 47: invokevirtual android/os/Parcel.recycle ()V
            // 4a: aload 4
            // 4c: invokevirtual android/os/Parcel.recycle ()V
            // 4f: return
            // 50: aload 4
            // 52: bipush 0
            // 53: invokevirtual android/os/Parcel.writeInt (I)V
            // 56: goto 21
            // 59: astore 1
            // 5a: aload 3
            // 5b: invokevirtual android/os/Parcel.recycle ()V
            // 5e: aload 4
            // 60: invokevirtual android/os/Parcel.recycle ()V
            // 63: aload 1
            // 64: athrow
            // 65: aload 4
            // 67: bipush 0
            // 68: invokevirtual android/os/Parcel.writeInt (I)V
            // 6b: goto 32
            // try (4 -> 7): 44 null
            // try (9 -> 16): 44 null
            // try (18 -> 25): 44 null
            // try (25 -> 35): 44 null
            // try (40 -> 43): 44 null
            // try (51 -> 54): 44 null
         }

         @Override
         public void a(IMediaControllerCallback param1) throws RemoteException {
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
            // 04: invokestatic android/os/Parcel.obtain ()Landroid/os/Parcel;
            // 07: astore 3
            // 08: aload 2
            // 09: ldc "android.support.v4.media.session.IMediaSession"
            // 0b: invokevirtual android/os/Parcel.writeInterfaceToken (Ljava/lang/String;)V
            // 0e: aload 1
            // 0f: ifnull 39
            // 12: aload 1
            // 13: invokeinterface android/support/v4/media/session/IMediaControllerCallback.asBinder ()Landroid/os/IBinder; 1
            // 18: astore 1
            // 19: aload 2
            // 1a: aload 1
            // 1b: invokevirtual android/os/Parcel.writeStrongBinder (Landroid/os/IBinder;)V
            // 1e: aload 0
            // 1f: getfield android/support/v4/media/session/IMediaSession$Stub$Proxy.a Landroid/os/IBinder;
            // 22: bipush 3
            // 23: aload 2
            // 24: aload 3
            // 25: bipush 0
            // 26: invokeinterface android/os/IBinder.transact (ILandroid/os/Parcel;Landroid/os/Parcel;I)Z 5
            // 2b: pop
            // 2c: aload 3
            // 2d: invokevirtual android/os/Parcel.readException ()V
            // 30: aload 3
            // 31: invokevirtual android/os/Parcel.recycle ()V
            // 34: aload 2
            // 35: invokevirtual android/os/Parcel.recycle ()V
            // 38: return
            // 39: aconst_null
            // 3a: astore 1
            // 3b: goto 19
            // 3e: astore 1
            // 3f: aload 3
            // 40: invokevirtual android/os/Parcel.recycle ()V
            // 43: aload 2
            // 44: invokevirtual android/os/Parcel.recycle ()V
            // 47: aload 1
            // 48: athrow
            // try (4 -> 7): 33 null
            // try (9 -> 12): 33 null
            // try (12 -> 25): 33 null
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
            // 04: invokestatic android/os/Parcel.obtain ()Landroid/os/Parcel;
            // 07: astore 4
            // 09: aload 3
            // 0a: ldc "android.support.v4.media.session.IMediaSession"
            // 0c: invokevirtual android/os/Parcel.writeInterfaceToken (Ljava/lang/String;)V
            // 0f: aload 3
            // 10: aload 1
            // 11: invokevirtual android/os/Parcel.writeString (Ljava/lang/String;)V
            // 14: aload 2
            // 15: ifnull 42
            // 18: aload 3
            // 19: bipush 1
            // 1a: invokevirtual android/os/Parcel.writeInt (I)V
            // 1d: aload 2
            // 1e: aload 3
            // 1f: bipush 0
            // 20: invokevirtual android/os/Bundle.writeToParcel (Landroid/os/Parcel;I)V
            // 23: aload 0
            // 24: getfield android/support/v4/media/session/IMediaSession$Stub$Proxy.a Landroid/os/IBinder;
            // 27: bipush 34
            // 29: aload 3
            // 2a: aload 4
            // 2c: bipush 0
            // 2d: invokeinterface android/os/IBinder.transact (ILandroid/os/Parcel;Landroid/os/Parcel;I)Z 5
            // 32: pop
            // 33: aload 4
            // 35: invokevirtual android/os/Parcel.readException ()V
            // 38: aload 4
            // 3a: invokevirtual android/os/Parcel.recycle ()V
            // 3d: aload 3
            // 3e: invokevirtual android/os/Parcel.recycle ()V
            // 41: return
            // 42: aload 3
            // 43: bipush 0
            // 44: invokevirtual android/os/Parcel.writeInt (I)V
            // 47: goto 23
            // 4a: astore 1
            // 4b: aload 4
            // 4d: invokevirtual android/os/Parcel.recycle ()V
            // 50: aload 3
            // 51: invokevirtual android/os/Parcel.recycle ()V
            // 54: aload 1
            // 55: athrow
            // try (4 -> 10): 38 null
            // try (12 -> 19): 38 null
            // try (19 -> 29): 38 null
            // try (34 -> 37): 38 null
         }

         @Override
         public void a(String param1, Bundle param2, MediaSessionCompat.ResultReceiverWrapper param3) throws RemoteException {
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
            // 03: astore 4
            // 05: invokestatic android/os/Parcel.obtain ()Landroid/os/Parcel;
            // 08: astore 5
            // 0a: aload 4
            // 0c: ldc "android.support.v4.media.session.IMediaSession"
            // 0e: invokevirtual android/os/Parcel.writeInterfaceToken (Ljava/lang/String;)V
            // 11: aload 4
            // 13: aload 1
            // 14: invokevirtual android/os/Parcel.writeString (Ljava/lang/String;)V
            // 17: aload 2
            // 18: ifnull 59
            // 1b: aload 4
            // 1d: bipush 1
            // 1e: invokevirtual android/os/Parcel.writeInt (I)V
            // 21: aload 2
            // 22: aload 4
            // 24: bipush 0
            // 25: invokevirtual android/os/Bundle.writeToParcel (Landroid/os/Parcel;I)V
            // 28: aload 3
            // 29: ifnull 6f
            // 2c: aload 4
            // 2e: bipush 1
            // 2f: invokevirtual android/os/Parcel.writeInt (I)V
            // 32: aload 3
            // 33: aload 4
            // 35: bipush 0
            // 36: invokevirtual android/support/v4/media/session/MediaSessionCompat$ResultReceiverWrapper.writeToParcel (Landroid/os/Parcel;I)V
            // 39: aload 0
            // 3a: getfield android/support/v4/media/session/IMediaSession$Stub$Proxy.a Landroid/os/IBinder;
            // 3d: bipush 1
            // 3e: aload 4
            // 40: aload 5
            // 42: bipush 0
            // 43: invokeinterface android/os/IBinder.transact (ILandroid/os/Parcel;Landroid/os/Parcel;I)Z 5
            // 48: pop
            // 49: aload 5
            // 4b: invokevirtual android/os/Parcel.readException ()V
            // 4e: aload 5
            // 50: invokevirtual android/os/Parcel.recycle ()V
            // 53: aload 4
            // 55: invokevirtual android/os/Parcel.recycle ()V
            // 58: return
            // 59: aload 4
            // 5b: bipush 0
            // 5c: invokevirtual android/os/Parcel.writeInt (I)V
            // 5f: goto 28
            // 62: astore 1
            // 63: aload 5
            // 65: invokevirtual android/os/Parcel.recycle ()V
            // 68: aload 4
            // 6a: invokevirtual android/os/Parcel.recycle ()V
            // 6d: aload 1
            // 6e: athrow
            // 6f: aload 4
            // 71: bipush 0
            // 72: invokevirtual android/os/Parcel.writeInt (I)V
            // 75: goto 39
            // try (4 -> 10): 47 null
            // try (12 -> 19): 47 null
            // try (21 -> 28): 47 null
            // try (28 -> 38): 47 null
            // try (43 -> 46): 47 null
            // try (54 -> 57): 47 null
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
            // 00: bipush 0
            // 01: istore 2
            // 02: invokestatic android/os/Parcel.obtain ()Landroid/os/Parcel;
            // 05: astore 4
            // 07: invokestatic android/os/Parcel.obtain ()Landroid/os/Parcel;
            // 0a: astore 3
            // 0b: aload 4
            // 0d: ldc "android.support.v4.media.session.IMediaSession"
            // 0f: invokevirtual android/os/Parcel.writeInterfaceToken (Ljava/lang/String;)V
            // 12: iload 1
            // 13: ifeq 18
            // 16: bipush 1
            // 17: istore 2
            // 18: aload 4
            // 1a: iload 2
            // 1b: invokevirtual android/os/Parcel.writeInt (I)V
            // 1e: aload 0
            // 1f: getfield android/support/v4/media/session/IMediaSession$Stub$Proxy.a Landroid/os/IBinder;
            // 22: bipush 46
            // 24: aload 4
            // 26: aload 3
            // 27: bipush 0
            // 28: invokeinterface android/os/IBinder.transact (ILandroid/os/Parcel;Landroid/os/Parcel;I)Z 5
            // 2d: pop
            // 2e: aload 3
            // 2f: invokevirtual android/os/Parcel.readException ()V
            // 32: aload 3
            // 33: invokevirtual android/os/Parcel.recycle ()V
            // 36: aload 4
            // 38: invokevirtual android/os/Parcel.recycle ()V
            // 3b: return
            // 3c: astore 5
            // 3e: aload 3
            // 3f: invokevirtual android/os/Parcel.recycle ()V
            // 42: aload 4
            // 44: invokevirtual android/os/Parcel.recycle ()V
            // 47: aload 5
            // 49: athrow
            // try (6 -> 9): 31 null
            // try (13 -> 26): 31 null
         }

         // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
         // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
         @Override
         public boolean a() throws RemoteException {
            boolean var2 = false;
            Parcel var5 = Parcel.obtain();
            Parcel var3 = Parcel.obtain();
            boolean var7 = false /* VF: Semaphore variable */;

            int var1;
            try {
               var7 = true;
               var5.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
               this.a.transact(5, var5, var3, 0);
               var3.readException();
               var1 = var3.readInt();
               var7 = false;
            } finally {
               if (var7) {
                  var3.recycle();
                  var5.recycle();
               }
            }

            if (var1 != 0) {
               var2 = true;
            }

            var3.recycle();
            var5.recycle();
            return var2;
         }

         @Override
         public boolean a(KeyEvent param1) throws RemoteException {
            // $VF: Couldn't be decompiled
            // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
            // java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
            //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
            //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
            //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
            //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
            //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1058)
            //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.insertSemaphore(FinallyProcessor.java:351)
            //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:98)
            //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
            //
            // Bytecode:
            // 00: bipush 1
            // 01: istore 3
            // 02: invokestatic android/os/Parcel.obtain ()Landroid/os/Parcel;
            // 05: astore 4
            // 07: invokestatic android/os/Parcel.obtain ()Landroid/os/Parcel;
            // 0a: astore 5
            // 0c: aload 4
            // 0e: ldc "android.support.v4.media.session.IMediaSession"
            // 10: invokevirtual android/os/Parcel.writeInterfaceToken (Ljava/lang/String;)V
            // 13: aload 1
            // 14: ifnull 4f
            // 17: aload 4
            // 19: bipush 1
            // 1a: invokevirtual android/os/Parcel.writeInt (I)V
            // 1d: aload 1
            // 1e: aload 4
            // 20: bipush 0
            // 21: invokevirtual android/view/KeyEvent.writeToParcel (Landroid/os/Parcel;I)V
            // 24: aload 0
            // 25: getfield android/support/v4/media/session/IMediaSession$Stub$Proxy.a Landroid/os/IBinder;
            // 28: bipush 2
            // 29: aload 4
            // 2b: aload 5
            // 2d: bipush 0
            // 2e: invokeinterface android/os/IBinder.transact (ILandroid/os/Parcel;Landroid/os/Parcel;I)Z 5
            // 33: pop
            // 34: aload 5
            // 36: invokevirtual android/os/Parcel.readException ()V
            // 39: aload 5
            // 3b: invokevirtual android/os/Parcel.readInt ()I
            // 3e: istore 2
            // 3f: iload 2
            // 40: ifeq 65
            // 43: aload 5
            // 45: invokevirtual android/os/Parcel.recycle ()V
            // 48: aload 4
            // 4a: invokevirtual android/os/Parcel.recycle ()V
            // 4d: iload 3
            // 4e: ireturn
            // 4f: aload 4
            // 51: bipush 0
            // 52: invokevirtual android/os/Parcel.writeInt (I)V
            // 55: goto 24
            // 58: astore 1
            // 59: aload 5
            // 5b: invokevirtual android/os/Parcel.recycle ()V
            // 5e: aload 4
            // 60: invokevirtual android/os/Parcel.recycle ()V
            // 63: aload 1
            // 64: athrow
            // 65: bipush 0
            // 66: istore 3
            // 67: goto 43
            // try (6 -> 9): 43 null
            // try (11 -> 18): 43 null
            // try (18 -> 31): 43 null
            // try (39 -> 42): 43 null
         }

         public IBinder asBinder() {
            return this.a;
         }

         @Override
         public String b() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();

            try {
               var1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
               this.a.transact(6, var1, var2, 0);
               var2.readException();
               return var2.readString();
            } finally {
               var2.recycle();
               var1.recycle();
            }
         }

         @Override
         public void b(int var1) throws RemoteException {
            Parcel var3 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();

            try {
               var3.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
               var3.writeInt(var1);
               this.a.transact(39, var3, var2, 0);
               var2.readException();
            } finally {
               var2.recycle();
               var3.recycle();
            }
         }

         @Override
         public void b(int var1, int var2, String var3) throws RemoteException {
            Parcel var5 = Parcel.obtain();
            Parcel var4 = Parcel.obtain();

            try {
               var5.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
               var5.writeInt(var1);
               var5.writeInt(var2);
               var5.writeString(var3);
               this.a.transact(12, var5, var4, 0);
               var4.readException();
            } finally {
               var4.recycle();
               var5.recycle();
            }
         }

         @Override
         public void b(long var1) throws RemoteException {
            Parcel var5 = Parcel.obtain();
            Parcel var3 = Parcel.obtain();

            try {
               var5.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
               var5.writeLong(var1);
               this.a.transact(24, var5, var3, 0);
               var3.readException();
            } finally {
               var3.recycle();
               var5.recycle();
            }
         }

         @Override
         public void b(Uri param1, Bundle param2) throws RemoteException {
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
            // 03: astore 4
            // 05: invokestatic android/os/Parcel.obtain ()Landroid/os/Parcel;
            // 08: astore 3
            // 09: aload 4
            // 0b: ldc "android.support.v4.media.session.IMediaSession"
            // 0d: invokevirtual android/os/Parcel.writeInterfaceToken (Ljava/lang/String;)V
            // 10: aload 1
            // 11: ifnull 50
            // 14: aload 4
            // 16: bipush 1
            // 17: invokevirtual android/os/Parcel.writeInt (I)V
            // 1a: aload 1
            // 1b: aload 4
            // 1d: bipush 0
            // 1e: invokevirtual android/net/Uri.writeToParcel (Landroid/os/Parcel;I)V
            // 21: aload 2
            // 22: ifnull 65
            // 25: aload 4
            // 27: bipush 1
            // 28: invokevirtual android/os/Parcel.writeInt (I)V
            // 2b: aload 2
            // 2c: aload 4
            // 2e: bipush 0
            // 2f: invokevirtual android/os/Bundle.writeToParcel (Landroid/os/Parcel;I)V
            // 32: aload 0
            // 33: getfield android/support/v4/media/session/IMediaSession$Stub$Proxy.a Landroid/os/IBinder;
            // 36: bipush 16
            // 38: aload 4
            // 3a: aload 3
            // 3b: bipush 0
            // 3c: invokeinterface android/os/IBinder.transact (ILandroid/os/Parcel;Landroid/os/Parcel;I)Z 5
            // 41: pop
            // 42: aload 3
            // 43: invokevirtual android/os/Parcel.readException ()V
            // 46: aload 3
            // 47: invokevirtual android/os/Parcel.recycle ()V
            // 4a: aload 4
            // 4c: invokevirtual android/os/Parcel.recycle ()V
            // 4f: return
            // 50: aload 4
            // 52: bipush 0
            // 53: invokevirtual android/os/Parcel.writeInt (I)V
            // 56: goto 21
            // 59: astore 1
            // 5a: aload 3
            // 5b: invokevirtual android/os/Parcel.recycle ()V
            // 5e: aload 4
            // 60: invokevirtual android/os/Parcel.recycle ()V
            // 63: aload 1
            // 64: athrow
            // 65: aload 4
            // 67: bipush 0
            // 68: invokevirtual android/os/Parcel.writeInt (I)V
            // 6b: goto 32
            // try (4 -> 7): 44 null
            // try (9 -> 16): 44 null
            // try (18 -> 25): 44 null
            // try (25 -> 35): 44 null
            // try (40 -> 43): 44 null
            // try (51 -> 54): 44 null
         }

         @Override
         public void b(MediaDescriptionCompat param1) throws RemoteException {
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
            // 04: invokestatic android/os/Parcel.obtain ()Landroid/os/Parcel;
            // 07: astore 3
            // 08: aload 2
            // 09: ldc "android.support.v4.media.session.IMediaSession"
            // 0b: invokevirtual android/os/Parcel.writeInterfaceToken (Ljava/lang/String;)V
            // 0e: aload 1
            // 0f: ifnull 39
            // 12: aload 2
            // 13: bipush 1
            // 14: invokevirtual android/os/Parcel.writeInt (I)V
            // 17: aload 1
            // 18: aload 2
            // 19: bipush 0
            // 1a: invokevirtual android/support/v4/media/MediaDescriptionCompat.writeToParcel (Landroid/os/Parcel;I)V
            // 1d: aload 0
            // 1e: getfield android/support/v4/media/session/IMediaSession$Stub$Proxy.a Landroid/os/IBinder;
            // 21: bipush 43
            // 23: aload 2
            // 24: aload 3
            // 25: bipush 0
            // 26: invokeinterface android/os/IBinder.transact (ILandroid/os/Parcel;Landroid/os/Parcel;I)Z 5
            // 2b: pop
            // 2c: aload 3
            // 2d: invokevirtual android/os/Parcel.readException ()V
            // 30: aload 3
            // 31: invokevirtual android/os/Parcel.recycle ()V
            // 34: aload 2
            // 35: invokevirtual android/os/Parcel.recycle ()V
            // 38: return
            // 39: aload 2
            // 3a: bipush 0
            // 3b: invokevirtual android/os/Parcel.writeInt (I)V
            // 3e: goto 1d
            // 41: astore 1
            // 42: aload 3
            // 43: invokevirtual android/os/Parcel.recycle ()V
            // 46: aload 2
            // 47: invokevirtual android/os/Parcel.recycle ()V
            // 4a: aload 1
            // 4b: athrow
            // try (4 -> 7): 35 null
            // try (9 -> 16): 35 null
            // try (16 -> 26): 35 null
            // try (31 -> 34): 35 null
         }

         @Override
         public void b(IMediaControllerCallback param1) throws RemoteException {
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
            // 04: invokestatic android/os/Parcel.obtain ()Landroid/os/Parcel;
            // 07: astore 3
            // 08: aload 2
            // 09: ldc "android.support.v4.media.session.IMediaSession"
            // 0b: invokevirtual android/os/Parcel.writeInterfaceToken (Ljava/lang/String;)V
            // 0e: aload 1
            // 0f: ifnull 39
            // 12: aload 1
            // 13: invokeinterface android/support/v4/media/session/IMediaControllerCallback.asBinder ()Landroid/os/IBinder; 1
            // 18: astore 1
            // 19: aload 2
            // 1a: aload 1
            // 1b: invokevirtual android/os/Parcel.writeStrongBinder (Landroid/os/IBinder;)V
            // 1e: aload 0
            // 1f: getfield android/support/v4/media/session/IMediaSession$Stub$Proxy.a Landroid/os/IBinder;
            // 22: bipush 4
            // 23: aload 2
            // 24: aload 3
            // 25: bipush 0
            // 26: invokeinterface android/os/IBinder.transact (ILandroid/os/Parcel;Landroid/os/Parcel;I)Z 5
            // 2b: pop
            // 2c: aload 3
            // 2d: invokevirtual android/os/Parcel.readException ()V
            // 30: aload 3
            // 31: invokevirtual android/os/Parcel.recycle ()V
            // 34: aload 2
            // 35: invokevirtual android/os/Parcel.recycle ()V
            // 38: return
            // 39: aconst_null
            // 3a: astore 1
            // 3b: goto 19
            // 3e: astore 1
            // 3f: aload 3
            // 40: invokevirtual android/os/Parcel.recycle ()V
            // 43: aload 2
            // 44: invokevirtual android/os/Parcel.recycle ()V
            // 47: aload 1
            // 48: athrow
            // try (4 -> 7): 33 null
            // try (9 -> 12): 33 null
            // try (12 -> 25): 33 null
         }

         @Override
         public void b(String param1, Bundle param2) throws RemoteException {
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
            // 04: invokestatic android/os/Parcel.obtain ()Landroid/os/Parcel;
            // 07: astore 4
            // 09: aload 3
            // 0a: ldc "android.support.v4.media.session.IMediaSession"
            // 0c: invokevirtual android/os/Parcel.writeInterfaceToken (Ljava/lang/String;)V
            // 0f: aload 3
            // 10: aload 1
            // 11: invokevirtual android/os/Parcel.writeString (Ljava/lang/String;)V
            // 14: aload 2
            // 15: ifnull 42
            // 18: aload 3
            // 19: bipush 1
            // 1a: invokevirtual android/os/Parcel.writeInt (I)V
            // 1d: aload 2
            // 1e: aload 3
            // 1f: bipush 0
            // 20: invokevirtual android/os/Bundle.writeToParcel (Landroid/os/Parcel;I)V
            // 23: aload 0
            // 24: getfield android/support/v4/media/session/IMediaSession$Stub$Proxy.a Landroid/os/IBinder;
            // 27: bipush 35
            // 29: aload 3
            // 2a: aload 4
            // 2c: bipush 0
            // 2d: invokeinterface android/os/IBinder.transact (ILandroid/os/Parcel;Landroid/os/Parcel;I)Z 5
            // 32: pop
            // 33: aload 4
            // 35: invokevirtual android/os/Parcel.readException ()V
            // 38: aload 4
            // 3a: invokevirtual android/os/Parcel.recycle ()V
            // 3d: aload 3
            // 3e: invokevirtual android/os/Parcel.recycle ()V
            // 41: return
            // 42: aload 3
            // 43: bipush 0
            // 44: invokevirtual android/os/Parcel.writeInt (I)V
            // 47: goto 23
            // 4a: astore 1
            // 4b: aload 4
            // 4d: invokevirtual android/os/Parcel.recycle ()V
            // 50: aload 3
            // 51: invokevirtual android/os/Parcel.recycle ()V
            // 54: aload 1
            // 55: athrow
            // try (4 -> 10): 38 null
            // try (12 -> 19): 38 null
            // try (19 -> 29): 38 null
            // try (34 -> 37): 38 null
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
            // 00: bipush 0
            // 01: istore 2
            // 02: invokestatic android/os/Parcel.obtain ()Landroid/os/Parcel;
            // 05: astore 3
            // 06: invokestatic android/os/Parcel.obtain ()Landroid/os/Parcel;
            // 09: astore 4
            // 0b: aload 3
            // 0c: ldc "android.support.v4.media.session.IMediaSession"
            // 0e: invokevirtual android/os/Parcel.writeInterfaceToken (Ljava/lang/String;)V
            // 11: iload 1
            // 12: ifeq 17
            // 15: bipush 1
            // 16: istore 2
            // 17: aload 3
            // 18: iload 2
            // 19: invokevirtual android/os/Parcel.writeInt (I)V
            // 1c: aload 0
            // 1d: getfield android/support/v4/media/session/IMediaSession$Stub$Proxy.a Landroid/os/IBinder;
            // 20: bipush 40
            // 22: aload 3
            // 23: aload 4
            // 25: bipush 0
            // 26: invokeinterface android/os/IBinder.transact (ILandroid/os/Parcel;Landroid/os/Parcel;I)Z 5
            // 2b: pop
            // 2c: aload 4
            // 2e: invokevirtual android/os/Parcel.readException ()V
            // 31: aload 4
            // 33: invokevirtual android/os/Parcel.recycle ()V
            // 36: aload 3
            // 37: invokevirtual android/os/Parcel.recycle ()V
            // 3a: return
            // 3b: astore 5
            // 3d: aload 4
            // 3f: invokevirtual android/os/Parcel.recycle ()V
            // 42: aload 3
            // 43: invokevirtual android/os/Parcel.recycle ()V
            // 46: aload 5
            // 48: athrow
            // try (6 -> 9): 31 null
            // try (13 -> 26): 31 null
         }

         @Override
         public String c() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();

            try {
               var1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
               this.a.transact(7, var1, var2, 0);
               var2.readException();
               return var2.readString();
            } finally {
               var2.recycle();
               var1.recycle();
            }
         }

         @Override
         public void c(int var1) throws RemoteException {
            Parcel var2 = Parcel.obtain();
            Parcel var4 = Parcel.obtain();

            try {
               var2.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
               var2.writeInt(var1);
               this.a.transact(48, var2, var4, 0);
               var4.readException();
            } finally {
               var4.recycle();
               var2.recycle();
            }
         }

         @Override
         public void c(String param1, Bundle param2) throws RemoteException {
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
            // 03: astore 4
            // 05: invokestatic android/os/Parcel.obtain ()Landroid/os/Parcel;
            // 08: astore 3
            // 09: aload 4
            // 0b: ldc "android.support.v4.media.session.IMediaSession"
            // 0d: invokevirtual android/os/Parcel.writeInterfaceToken (Ljava/lang/String;)V
            // 10: aload 4
            // 12: aload 1
            // 13: invokevirtual android/os/Parcel.writeString (Ljava/lang/String;)V
            // 16: aload 2
            // 17: ifnull 45
            // 1a: aload 4
            // 1c: bipush 1
            // 1d: invokevirtual android/os/Parcel.writeInt (I)V
            // 20: aload 2
            // 21: aload 4
            // 23: bipush 0
            // 24: invokevirtual android/os/Bundle.writeToParcel (Landroid/os/Parcel;I)V
            // 27: aload 0
            // 28: getfield android/support/v4/media/session/IMediaSession$Stub$Proxy.a Landroid/os/IBinder;
            // 2b: bipush 14
            // 2d: aload 4
            // 2f: aload 3
            // 30: bipush 0
            // 31: invokeinterface android/os/IBinder.transact (ILandroid/os/Parcel;Landroid/os/Parcel;I)Z 5
            // 36: pop
            // 37: aload 3
            // 38: invokevirtual android/os/Parcel.readException ()V
            // 3b: aload 3
            // 3c: invokevirtual android/os/Parcel.recycle ()V
            // 3f: aload 4
            // 41: invokevirtual android/os/Parcel.recycle ()V
            // 44: return
            // 45: aload 4
            // 47: bipush 0
            // 48: invokevirtual android/os/Parcel.writeInt (I)V
            // 4b: goto 27
            // 4e: astore 1
            // 4f: aload 3
            // 50: invokevirtual android/os/Parcel.recycle ()V
            // 53: aload 4
            // 55: invokevirtual android/os/Parcel.recycle ()V
            // 58: aload 1
            // 59: athrow
            // try (4 -> 10): 38 null
            // try (12 -> 19): 38 null
            // try (19 -> 29): 38 null
            // try (34 -> 37): 38 null
         }

         // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
         // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
         @Override
         public PendingIntent d() throws RemoteException {
            Parcel var3 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();
            boolean var5 = false /* VF: Semaphore variable */;

            PendingIntent var1;
            label29: {
               try {
                  var5 = true;
                  var3.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                  this.a.transact(8, var3, var2, 0);
                  var2.readException();
                  if (var2.readInt() != 0) {
                     var1 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(var2);
                     var5 = false;
                     break label29;
                  }

                  var5 = false;
               } finally {
                  if (var5) {
                     var2.recycle();
                     var3.recycle();
                  }
               }

               var1 = null;
            }

            var2.recycle();
            var3.recycle();
            return var1;
         }

         @Override
         public void d(String param1, Bundle param2) throws RemoteException {
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
            // 03: astore 4
            // 05: invokestatic android/os/Parcel.obtain ()Landroid/os/Parcel;
            // 08: astore 3
            // 09: aload 4
            // 0b: ldc "android.support.v4.media.session.IMediaSession"
            // 0d: invokevirtual android/os/Parcel.writeInterfaceToken (Ljava/lang/String;)V
            // 10: aload 4
            // 12: aload 1
            // 13: invokevirtual android/os/Parcel.writeString (Ljava/lang/String;)V
            // 16: aload 2
            // 17: ifnull 45
            // 1a: aload 4
            // 1c: bipush 1
            // 1d: invokevirtual android/os/Parcel.writeInt (I)V
            // 20: aload 2
            // 21: aload 4
            // 23: bipush 0
            // 24: invokevirtual android/os/Bundle.writeToParcel (Landroid/os/Parcel;I)V
            // 27: aload 0
            // 28: getfield android/support/v4/media/session/IMediaSession$Stub$Proxy.a Landroid/os/IBinder;
            // 2b: bipush 15
            // 2d: aload 4
            // 2f: aload 3
            // 30: bipush 0
            // 31: invokeinterface android/os/IBinder.transact (ILandroid/os/Parcel;Landroid/os/Parcel;I)Z 5
            // 36: pop
            // 37: aload 3
            // 38: invokevirtual android/os/Parcel.readException ()V
            // 3b: aload 3
            // 3c: invokevirtual android/os/Parcel.recycle ()V
            // 3f: aload 4
            // 41: invokevirtual android/os/Parcel.recycle ()V
            // 44: return
            // 45: aload 4
            // 47: bipush 0
            // 48: invokevirtual android/os/Parcel.writeInt (I)V
            // 4b: goto 27
            // 4e: astore 1
            // 4f: aload 3
            // 50: invokevirtual android/os/Parcel.recycle ()V
            // 53: aload 4
            // 55: invokevirtual android/os/Parcel.recycle ()V
            // 58: aload 1
            // 59: athrow
            // try (4 -> 10): 38 null
            // try (12 -> 19): 38 null
            // try (19 -> 29): 38 null
            // try (34 -> 37): 38 null
         }

         @Override
         public long e() throws RemoteException {
            Parcel var4 = Parcel.obtain();
            Parcel var5 = Parcel.obtain();

            try {
               var4.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
               this.a.transact(9, var4, var5, 0);
               var5.readException();
               return var5.readLong();
            } finally {
               var5.recycle();
               var4.recycle();
            }
         }

         @Override
         public void e(String param1, Bundle param2) throws RemoteException {
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
            // 03: astore 4
            // 05: invokestatic android/os/Parcel.obtain ()Landroid/os/Parcel;
            // 08: astore 3
            // 09: aload 4
            // 0b: ldc "android.support.v4.media.session.IMediaSession"
            // 0d: invokevirtual android/os/Parcel.writeInterfaceToken (Ljava/lang/String;)V
            // 10: aload 4
            // 12: aload 1
            // 13: invokevirtual android/os/Parcel.writeString (Ljava/lang/String;)V
            // 16: aload 2
            // 17: ifnull 45
            // 1a: aload 4
            // 1c: bipush 1
            // 1d: invokevirtual android/os/Parcel.writeInt (I)V
            // 20: aload 2
            // 21: aload 4
            // 23: bipush 0
            // 24: invokevirtual android/os/Bundle.writeToParcel (Landroid/os/Parcel;I)V
            // 27: aload 0
            // 28: getfield android/support/v4/media/session/IMediaSession$Stub$Proxy.a Landroid/os/IBinder;
            // 2b: bipush 26
            // 2d: aload 4
            // 2f: aload 3
            // 30: bipush 0
            // 31: invokeinterface android/os/IBinder.transact (ILandroid/os/Parcel;Landroid/os/Parcel;I)Z 5
            // 36: pop
            // 37: aload 3
            // 38: invokevirtual android/os/Parcel.readException ()V
            // 3b: aload 3
            // 3c: invokevirtual android/os/Parcel.recycle ()V
            // 3f: aload 4
            // 41: invokevirtual android/os/Parcel.recycle ()V
            // 44: return
            // 45: aload 4
            // 47: bipush 0
            // 48: invokevirtual android/os/Parcel.writeInt (I)V
            // 4b: goto 27
            // 4e: astore 1
            // 4f: aload 3
            // 50: invokevirtual android/os/Parcel.recycle ()V
            // 53: aload 4
            // 55: invokevirtual android/os/Parcel.recycle ()V
            // 58: aload 1
            // 59: athrow
            // try (4 -> 10): 38 null
            // try (12 -> 19): 38 null
            // try (19 -> 29): 38 null
            // try (34 -> 37): 38 null
         }

         // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
         // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
         @Override
         public ParcelableVolumeInfo f() throws RemoteException {
            Parcel var2 = Parcel.obtain();
            Parcel var3 = Parcel.obtain();
            boolean var5 = false /* VF: Semaphore variable */;

            ParcelableVolumeInfo var1;
            label29: {
               try {
                  var5 = true;
                  var2.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                  this.a.transact(10, var2, var3, 0);
                  var3.readException();
                  if (var3.readInt() != 0) {
                     var1 = (ParcelableVolumeInfo)ParcelableVolumeInfo.CREATOR.createFromParcel(var3);
                     var5 = false;
                     break label29;
                  }

                  var5 = false;
               } finally {
                  if (var5) {
                     var3.recycle();
                     var2.recycle();
                  }
               }

               var1 = null;
            }

            var3.recycle();
            var2.recycle();
            return var1;
         }

         // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
         // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
         @Override
         public MediaMetadataCompat g() throws RemoteException {
            Parcel var2 = Parcel.obtain();
            Parcel var3 = Parcel.obtain();
            boolean var5 = false /* VF: Semaphore variable */;

            MediaMetadataCompat var1;
            label29: {
               try {
                  var5 = true;
                  var2.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                  this.a.transact(27, var2, var3, 0);
                  var3.readException();
                  if (var3.readInt() != 0) {
                     var1 = (MediaMetadataCompat)MediaMetadataCompat.CREATOR.createFromParcel(var3);
                     var5 = false;
                     break label29;
                  }

                  var5 = false;
               } finally {
                  if (var5) {
                     var3.recycle();
                     var2.recycle();
                  }
               }

               var1 = null;
            }

            var3.recycle();
            var2.recycle();
            return var1;
         }

         // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
         // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
         @Override
         public PlaybackStateCompat h() throws RemoteException {
            Parcel var2 = Parcel.obtain();
            Parcel var3 = Parcel.obtain();
            boolean var5 = false /* VF: Semaphore variable */;

            PlaybackStateCompat var1;
            label29: {
               try {
                  var5 = true;
                  var2.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                  this.a.transact(28, var2, var3, 0);
                  var3.readException();
                  if (var3.readInt() != 0) {
                     var1 = (PlaybackStateCompat)PlaybackStateCompat.CREATOR.createFromParcel(var3);
                     var5 = false;
                     break label29;
                  }

                  var5 = false;
               } finally {
                  if (var5) {
                     var3.recycle();
                     var2.recycle();
                  }
               }

               var1 = null;
            }

            var3.recycle();
            var2.recycle();
            return var1;
         }

         @Override
         public List<MediaSessionCompat.QueueItem> i() throws RemoteException {
            Parcel var2 = Parcel.obtain();
            Parcel var1 = Parcel.obtain();

            try {
               var2.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
               this.a.transact(29, var2, var1, 0);
               var1.readException();
               return var1.createTypedArrayList(MediaSessionCompat.QueueItem.CREATOR);
            } finally {
               var1.recycle();
               var2.recycle();
            }
         }

         // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
         // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
         @Override
         public CharSequence j() throws RemoteException {
            Parcel var2 = Parcel.obtain();
            Parcel var3 = Parcel.obtain();
            boolean var5 = false /* VF: Semaphore variable */;

            CharSequence var1;
            label29: {
               try {
                  var5 = true;
                  var2.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                  this.a.transact(30, var2, var3, 0);
                  var3.readException();
                  if (var3.readInt() != 0) {
                     var1 = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(var3);
                     var5 = false;
                     break label29;
                  }

                  var5 = false;
               } finally {
                  if (var5) {
                     var3.recycle();
                     var2.recycle();
                  }
               }

               var1 = null;
            }

            var3.recycle();
            var2.recycle();
            return var1;
         }

         // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
         // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
         @Override
         public Bundle k() throws RemoteException {
            Parcel var3 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();
            boolean var5 = false /* VF: Semaphore variable */;

            Bundle var1;
            label29: {
               try {
                  var5 = true;
                  var3.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                  this.a.transact(31, var3, var2, 0);
                  var2.readException();
                  if (var2.readInt() != 0) {
                     var1 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
                     var5 = false;
                     break label29;
                  }

                  var5 = false;
               } finally {
                  if (var5) {
                     var2.recycle();
                     var3.recycle();
                  }
               }

               var1 = null;
            }

            var2.recycle();
            var3.recycle();
            return var1;
         }

         @Override
         public int l() throws RemoteException {
            Parcel var3 = Parcel.obtain();
            Parcel var4 = Parcel.obtain();

            try {
               var3.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
               this.a.transact(32, var3, var4, 0);
               var4.readException();
               return var4.readInt();
            } finally {
               var4.recycle();
               var3.recycle();
            }
         }

         // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
         // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
         @Override
         public boolean m() throws RemoteException {
            boolean var2 = false;
            Parcel var3 = Parcel.obtain();
            Parcel var5 = Parcel.obtain();
            boolean var7 = false /* VF: Semaphore variable */;

            int var1;
            try {
               var7 = true;
               var3.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
               this.a.transact(45, var3, var5, 0);
               var5.readException();
               var1 = var5.readInt();
               var7 = false;
            } finally {
               if (var7) {
                  var5.recycle();
                  var3.recycle();
               }
            }

            if (var1 != 0) {
               var2 = true;
            }

            var5.recycle();
            var3.recycle();
            return var2;
         }

         @Override
         public int n() throws RemoteException {
            Parcel var4 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();

            try {
               var4.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
               this.a.transact(37, var4, var2, 0);
               var2.readException();
               return var2.readInt();
            } finally {
               var2.recycle();
               var4.recycle();
            }
         }

         // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
         // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
         @Override
         public boolean o() throws RemoteException {
            boolean var2 = false;
            Parcel var3 = Parcel.obtain();
            Parcel var4 = Parcel.obtain();
            boolean var7 = false /* VF: Semaphore variable */;

            int var1;
            try {
               var7 = true;
               var3.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
               this.a.transact(38, var3, var4, 0);
               var4.readException();
               var1 = var4.readInt();
               var7 = false;
            } finally {
               if (var7) {
                  var4.recycle();
                  var3.recycle();
               }
            }

            if (var1 != 0) {
               var2 = true;
            }

            var4.recycle();
            var3.recycle();
            return var2;
         }

         @Override
         public int p() throws RemoteException {
            Parcel var2 = Parcel.obtain();
            Parcel var3 = Parcel.obtain();

            try {
               var2.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
               this.a.transact(47, var2, var3, 0);
               var3.readException();
               return var3.readInt();
            } finally {
               var3.recycle();
               var2.recycle();
            }
         }

         @Override
         public void q() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();

            try {
               var1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
               this.a.transact(33, var1, var2, 0);
               var2.readException();
            } finally {
               var2.recycle();
               var1.recycle();
            }
         }

         @Override
         public void r() throws RemoteException {
            Parcel var2 = Parcel.obtain();
            Parcel var1 = Parcel.obtain();

            try {
               var2.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
               this.a.transact(13, var2, var1, 0);
               var1.readException();
            } finally {
               var1.recycle();
               var2.recycle();
            }
         }

         @Override
         public void s() throws RemoteException {
            Parcel var2 = Parcel.obtain();
            Parcel var3 = Parcel.obtain();

            try {
               var2.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
               this.a.transact(18, var2, var3, 0);
               var3.readException();
            } finally {
               var3.recycle();
               var2.recycle();
            }
         }

         @Override
         public void t() throws RemoteException {
            Parcel var3 = Parcel.obtain();
            Parcel var1 = Parcel.obtain();

            try {
               var3.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
               this.a.transact(19, var3, var1, 0);
               var1.readException();
            } finally {
               var1.recycle();
               var3.recycle();
            }
         }

         @Override
         public void u() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();

            try {
               var1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
               this.a.transact(20, var1, var2, 0);
               var2.readException();
            } finally {
               var2.recycle();
               var1.recycle();
            }
         }

         @Override
         public void v() throws RemoteException {
            Parcel var2 = Parcel.obtain();
            Parcel var1 = Parcel.obtain();

            try {
               var2.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
               this.a.transact(21, var2, var1, 0);
               var1.readException();
            } finally {
               var1.recycle();
               var2.recycle();
            }
         }

         @Override
         public void w() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();

            try {
               var1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
               this.a.transact(22, var1, var2, 0);
               var2.readException();
            } finally {
               var2.recycle();
               var1.recycle();
            }
         }

         @Override
         public void x() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var3 = Parcel.obtain();

            try {
               var1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
               this.a.transact(23, var1, var3, 0);
               var3.readException();
            } finally {
               var3.recycle();
               var1.recycle();
            }
         }
      }
   }
}
