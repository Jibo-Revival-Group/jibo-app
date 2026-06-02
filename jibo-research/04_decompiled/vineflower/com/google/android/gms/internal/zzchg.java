package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.List;

public final class zzchg extends zzeu implements zzche {
   zzchg(IBinder var1) {
      super(var1, "com.google.android.gms.measurement.internal.IMeasurementService");
   }

   @Override
   public final List<zzcln> a(zzcgi var1, boolean var2) throws RemoteException {
      Parcel var3 = this.c();
      zzew.a(var3, var1);
      zzew.a(var3, var2);
      var3 = this.a(7, var3);
      ArrayList var4 = var3.createTypedArrayList(zzcln.CREATOR);
      var3.recycle();
      return var4;
   }

   @Override
   public final List<zzcgl> a(String var1, String var2, zzcgi var3) throws RemoteException {
      Parcel var4 = this.c();
      var4.writeString(var1);
      var4.writeString(var2);
      zzew.a(var4, var3);
      Parcel var5 = this.a(16, var4);
      ArrayList var6 = var5.createTypedArrayList(zzcgl.CREATOR);
      var5.recycle();
      return var6;
   }

   @Override
   public final List<zzcgl> a(String var1, String var2, String var3) throws RemoteException {
      Parcel var4 = this.c();
      var4.writeString(var1);
      var4.writeString(var2);
      var4.writeString(var3);
      Parcel var5 = this.a(17, var4);
      ArrayList var6 = var5.createTypedArrayList(zzcgl.CREATOR);
      var5.recycle();
      return var6;
   }

   @Override
   public final List<zzcln> a(String var1, String var2, String var3, boolean var4) throws RemoteException {
      Parcel var5 = this.c();
      var5.writeString(var1);
      var5.writeString(var2);
      var5.writeString(var3);
      zzew.a(var5, var4);
      Parcel var6 = this.a(15, var5);
      ArrayList var7 = var6.createTypedArrayList(zzcln.CREATOR);
      var6.recycle();
      return var7;
   }

   @Override
   public final List<zzcln> a(String var1, String var2, boolean var3, zzcgi var4) throws RemoteException {
      Parcel var5 = this.c();
      var5.writeString(var1);
      var5.writeString(var2);
      zzew.a(var5, var3);
      zzew.a(var5, var4);
      Parcel var6 = this.a(14, var5);
      ArrayList var7 = var6.createTypedArrayList(zzcln.CREATOR);
      var6.recycle();
      return var7;
   }

   @Override
   public final void a(long var1, String var3, String var4, String var5) throws RemoteException {
      Parcel var6 = this.c();
      var6.writeLong(var1);
      var6.writeString(var3);
      var6.writeString(var4);
      var6.writeString(var5);
      this.b(10, var6);
   }

   @Override
   public final void a(zzcgi var1) throws RemoteException {
      Parcel var2 = this.c();
      zzew.a(var2, var1);
      this.b(4, var2);
   }

   @Override
   public final void a(zzcgl var1) throws RemoteException {
      Parcel var2 = this.c();
      zzew.a(var2, var1);
      this.b(13, var2);
   }

   @Override
   public final void a(zzcgl var1, zzcgi var2) throws RemoteException {
      Parcel var3 = this.c();
      zzew.a(var3, var1);
      zzew.a(var3, var2);
      this.b(12, var3);
   }

   @Override
   public final void a(zzcha var1, zzcgi var2) throws RemoteException {
      Parcel var3 = this.c();
      zzew.a(var3, var1);
      zzew.a(var3, var2);
      this.b(1, var3);
   }

   @Override
   public final void a(zzcha var1, String var2, String var3) throws RemoteException {
      Parcel var4 = this.c();
      zzew.a(var4, var1);
      var4.writeString(var2);
      var4.writeString(var3);
      this.b(5, var4);
   }

   @Override
   public final void a(zzcln var1, zzcgi var2) throws RemoteException {
      Parcel var3 = this.c();
      zzew.a(var3, var1);
      zzew.a(var3, var2);
      this.b(2, var3);
   }

   @Override
   public final byte[] a(zzcha var1, String var2) throws RemoteException {
      Parcel var3 = this.c();
      zzew.a(var3, var1);
      var3.writeString(var2);
      Parcel var4 = this.a(9, var3);
      byte[] var5 = var4.createByteArray();
      var4.recycle();
      return var5;
   }

   @Override
   public final void b(zzcgi var1) throws RemoteException {
      Parcel var2 = this.c();
      zzew.a(var2, var1);
      this.b(6, var2);
   }

   @Override
   public final String c(zzcgi var1) throws RemoteException {
      Parcel var2 = this.c();
      zzew.a(var2, var1);
      Parcel var3 = this.a(11, var2);
      String var4 = var3.readString();
      var3.recycle();
      return var4;
   }

   @Override
   public final void d(zzcgi var1) throws RemoteException {
      Parcel var2 = this.c();
      zzew.a(var2, var1);
      this.b(18, var2);
   }
}
