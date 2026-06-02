package net.sqlcipher;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.Map;

final class BulkCursorProxy implements IBulkCursor {
   private Bundle mExtras;
   private IBinder mRemote;

   public BulkCursorProxy(IBinder var1) {
      this.mRemote = var1;
      this.mExtras = null;
   }

   public IBinder asBinder() {
      return this.mRemote;
   }

   @Override
   public void close() throws RemoteException {
      Parcel var2 = Parcel.obtain();
      Parcel var1 = Parcel.obtain();
      var2.writeInterfaceToken("android.content.IBulkCursor");
      this.mRemote.transact(12, var2, var1, 0);
      DatabaseUtils.readExceptionFromParcel(var1);
      var2.recycle();
      var1.recycle();
   }

   @Override
   public int count() throws RemoteException {
      Parcel var3 = Parcel.obtain();
      Parcel var4 = Parcel.obtain();
      var3.writeInterfaceToken("android.content.IBulkCursor");
      boolean var2 = this.mRemote.transact(2, var3, var4, 0);
      DatabaseUtils.readExceptionFromParcel(var4);
      int var1;
      if (!var2) {
         var1 = -1;
      } else {
         var1 = var4.readInt();
      }

      var3.recycle();
      var4.recycle();
      return var1;
   }

   @Override
   public void deactivate() throws RemoteException {
      Parcel var2 = Parcel.obtain();
      Parcel var1 = Parcel.obtain();
      var2.writeInterfaceToken("android.content.IBulkCursor");
      this.mRemote.transact(6, var2, var1, 0);
      DatabaseUtils.readExceptionFromParcel(var1);
      var2.recycle();
      var1.recycle();
   }

   @Override
   public boolean deleteRow(int var1) throws RemoteException {
      boolean var2 = true;
      Parcel var3 = Parcel.obtain();
      Parcel var4 = Parcel.obtain();
      var3.writeInterfaceToken("android.content.IBulkCursor");
      var3.writeInt(var1);
      this.mRemote.transact(5, var3, var4, 0);
      DatabaseUtils.readExceptionFromParcel(var4);
      if (var4.readInt() != 1) {
         var2 = false;
      }

      var3.recycle();
      var4.recycle();
      return var2;
   }

   @Override
   public String[] getColumnNames() throws RemoteException {
      int var1 = 0;
      Parcel var4 = Parcel.obtain();
      Parcel var3 = Parcel.obtain();
      var4.writeInterfaceToken("android.content.IBulkCursor");
      this.mRemote.transact(3, var4, var3, 0);
      DatabaseUtils.readExceptionFromParcel(var3);
      int var2 = var3.readInt();
      String[] var5 = new String[var2];

      while (var1 < var2) {
         var5[var1] = var3.readString();
         var1++;
      }

      var4.recycle();
      var3.recycle();
      return var5;
   }

   @Override
   public Bundle getExtras() throws RemoteException {
      if (this.mExtras == null) {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();
         var1.writeInterfaceToken("android.content.IBulkCursor");
         this.mRemote.transact(10, var1, var2, 0);
         DatabaseUtils.readExceptionFromParcel(var2);
         this.mExtras = var2.readBundle(this.getClass().getClassLoader());
         var1.recycle();
         var2.recycle();
      }

      return this.mExtras;
   }

   @Override
   public boolean getWantsAllOnMoveCalls() throws RemoteException {
      boolean var2 = false;
      Parcel var4 = Parcel.obtain();
      Parcel var3 = Parcel.obtain();
      var4.writeInterfaceToken("android.content.IBulkCursor");
      this.mRemote.transact(9, var4, var3, 0);
      DatabaseUtils.readExceptionFromParcel(var3);
      int var1 = var3.readInt();
      var4.recycle();
      var3.recycle();
      if (var1 != 0) {
         var2 = true;
      }

      return var2;
   }

   @Override
   public CursorWindow getWindow(int var1) throws RemoteException {
      Parcel var3 = Parcel.obtain();
      Parcel var4 = Parcel.obtain();
      var3.writeInterfaceToken("android.content.IBulkCursor");
      var3.writeInt(var1);
      this.mRemote.transact(1, var3, var4, 0);
      DatabaseUtils.readExceptionFromParcel(var4);
      CursorWindow var2 = null;
      if (var4.readInt() == 1) {
         var2 = CursorWindow.newFromParcel(var4);
      }

      var3.recycle();
      var4.recycle();
      return var2;
   }

   @Override
   public void onMove(int var1) throws RemoteException {
      Parcel var2 = Parcel.obtain();
      Parcel var3 = Parcel.obtain();
      var2.writeInterfaceToken("android.content.IBulkCursor");
      var2.writeInt(var1);
      this.mRemote.transact(8, var2, var3, 0);
      DatabaseUtils.readExceptionFromParcel(var3);
      var2.recycle();
      var3.recycle();
   }

   @Override
   public int requery(IContentObserver var1, CursorWindow var2) throws RemoteException {
      Parcel var5 = Parcel.obtain();
      Parcel var6 = Parcel.obtain();
      var5.writeInterfaceToken("android.content.IBulkCursor");
      var5.writeStrongInterface(var1);
      var2.writeToParcel(var5, 0);
      boolean var4 = this.mRemote.transact(7, var5, var6, 0);
      DatabaseUtils.readExceptionFromParcel(var6);
      int var3;
      if (!var4) {
         var3 = -1;
      } else {
         var3 = var6.readInt();
         this.mExtras = var6.readBundle(this.getClass().getClassLoader());
      }

      var5.recycle();
      var6.recycle();
      return var3;
   }

   @Override
   public Bundle respond(Bundle var1) throws RemoteException {
      Parcel var3 = Parcel.obtain();
      Parcel var2 = Parcel.obtain();
      var3.writeInterfaceToken("android.content.IBulkCursor");
      var3.writeBundle(var1);
      this.mRemote.transact(11, var3, var2, 0);
      DatabaseUtils.readExceptionFromParcel(var2);
      var1 = var2.readBundle(this.getClass().getClassLoader());
      var3.recycle();
      var2.recycle();
      return var1;
   }

   @Override
   public boolean updateRows(Map var1) throws RemoteException {
      boolean var2 = true;
      Parcel var3 = Parcel.obtain();
      Parcel var4 = Parcel.obtain();
      var3.writeInterfaceToken("android.content.IBulkCursor");
      var3.writeMap(var1);
      this.mRemote.transact(4, var3, var4, 0);
      DatabaseUtils.readExceptionFromParcel(var4);
      if (var4.readInt() != 1) {
         var2 = false;
      }

      var3.recycle();
      var4.recycle();
      return var2;
   }
}
