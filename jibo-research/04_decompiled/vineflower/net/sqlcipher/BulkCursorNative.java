package net.sqlcipher;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class BulkCursorNative extends Binder implements IBulkCursor {
   public BulkCursorNative() {
      this.attachInterface(this, "android.content.IBulkCursor");
   }

   public static IBulkCursor asInterface(IBinder var0) {
      IBulkCursor var1;
      if (var0 == null) {
         var1 = null;
      } else {
         IBulkCursor var2 = (IBulkCursor)var0.queryLocalInterface("android.content.IBulkCursor");
         var1 = var2;
         if (var2 == null) {
            var1 = new BulkCursorProxy(var0);
         }
      }

      return var1;
   }

   public IBinder asBinder() {
      return this;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
      byte var7 = 0;
      byte var6 = 0;
      byte var8 = 0;
      byte var5 = 0;
      boolean var9;
      switch (var1) {
         case 1:
            try {
               var2.enforceInterface("android.content.IBulkCursor");
               var37 = this.getWindow(var2.readInt());
            } catch (Exception var27) {
               DatabaseUtils.writeExceptionToParcel(var3, var27);
               var9 = true;
               break;
            }

            if (var37 == null) {
               try {
                  var3.writeInt(0);
               } catch (Exception var26) {
                  DatabaseUtils.writeExceptionToParcel(var3, var26);
                  var9 = true;
                  break;
               }

               var9 = true;
            } else {
               try {
                  var3.writeNoException();
                  var3.writeInt(1);
                  var37.writeToParcel(var3, 0);
               } catch (Exception var25) {
                  DatabaseUtils.writeExceptionToParcel(var3, var25);
                  var9 = true;
                  break;
               }

               var9 = true;
            }
            break;
         case 2:
            try {
               var2.enforceInterface("android.content.IBulkCursor");
               var1 = this.count();
               var3.writeNoException();
               var3.writeInt(var1);
            } catch (Exception var24) {
               DatabaseUtils.writeExceptionToParcel(var3, var24);
               var9 = true;
               break;
            }

            var9 = true;
            break;
         case 3:
            try {
               var2.enforceInterface("android.content.IBulkCursor");
               var36 = this.getColumnNames();
               var3.writeNoException();
               var3.writeInt(var36.length);
               var4 = var36.length;
            } catch (Exception var23) {
               DatabaseUtils.writeExceptionToParcel(var3, var23);
               var9 = true;
               break;
            }

            for (int var32 = var5; var32 < var4; var32++) {
               try {
                  var3.writeString(var36[var32]);
               } catch (Exception var22) {
                  DatabaseUtils.writeExceptionToParcel(var3, var22);
                  var9 = true;
                  return var9;
               }
            }

            var9 = true;
            break;
         case 4:
            try {
               var2.enforceInterface("android.content.IBulkCursor");
               var9 = this.updateRows(var2.readHashMap(null));
               var3.writeNoException();
            } catch (Exception var18) {
               DatabaseUtils.writeExceptionToParcel(var3, var18);
               var9 = true;
               break;
            }

            byte var31 = var7;
            if (var9) {
               var31 = 1;
            }

            try {
               var3.writeInt(var31);
            } catch (Exception var17) {
               DatabaseUtils.writeExceptionToParcel(var3, var17);
               var9 = true;
               break;
            }

            var9 = true;
            break;
         case 5:
            try {
               var2.enforceInterface("android.content.IBulkCursor");
               var9 = this.deleteRow(var2.readInt());
               var3.writeNoException();
            } catch (Exception var16) {
               DatabaseUtils.writeExceptionToParcel(var3, var16);
               var9 = true;
               break;
            }

            byte var30 = var6;
            if (var9) {
               var30 = 1;
            }

            try {
               var3.writeInt(var30);
            } catch (Exception var15) {
               DatabaseUtils.writeExceptionToParcel(var3, var15);
               var9 = true;
               break;
            }

            var9 = true;
            break;
         case 6:
            try {
               var2.enforceInterface("android.content.IBulkCursor");
               this.deactivate();
               var3.writeNoException();
            } catch (Exception var21) {
               DatabaseUtils.writeExceptionToParcel(var3, var21);
               var9 = true;
               break;
            }

            var9 = true;
            break;
         case 7:
            try {
               var2.enforceInterface("android.content.IBulkCursor");
               var1 = this.requery(IContentObserver.Stub.asInterface(var2.readStrongBinder()), (CursorWindow)CursorWindow.CREATOR.createFromParcel(var2));
               var3.writeNoException();
               var3.writeInt(var1);
               var3.writeBundle(this.getExtras());
            } catch (Exception var19) {
               DatabaseUtils.writeExceptionToParcel(var3, var19);
               var9 = true;
               break;
            }

            var9 = true;
            break;
         case 8:
            try {
               var2.enforceInterface("android.content.IBulkCursor");
               this.onMove(var2.readInt());
               var3.writeNoException();
            } catch (Exception var14) {
               DatabaseUtils.writeExceptionToParcel(var3, var14);
               var9 = true;
               break;
            }

            var9 = true;
            break;
         case 9:
            try {
               var2.enforceInterface("android.content.IBulkCursor");
               var9 = this.getWantsAllOnMoveCalls();
               var3.writeNoException();
            } catch (Exception var13) {
               DatabaseUtils.writeExceptionToParcel(var3, var13);
               var9 = true;
               break;
            }

            byte var28 = var8;
            if (var9) {
               var28 = 1;
            }

            try {
               var3.writeInt(var28);
            } catch (Exception var12) {
               DatabaseUtils.writeExceptionToParcel(var3, var12);
               var9 = true;
               break;
            }

            var9 = true;
            break;
         case 10:
            try {
               var2.enforceInterface("android.content.IBulkCursor");
               Bundle var35 = this.getExtras();
               var3.writeNoException();
               var3.writeBundle(var35);
            } catch (Exception var11) {
               DatabaseUtils.writeExceptionToParcel(var3, var11);
               var9 = true;
               break;
            }

            var9 = true;
            break;
         case 11:
            try {
               var2.enforceInterface("android.content.IBulkCursor");
               Bundle var34 = this.respond(var2.readBundle(this.getClass().getClassLoader()));
               var3.writeNoException();
               var3.writeBundle(var34);
            } catch (Exception var10) {
               DatabaseUtils.writeExceptionToParcel(var3, var10);
               var9 = true;
               break;
            }

            var9 = true;
            break;
         case 12:
            try {
               var2.enforceInterface("android.content.IBulkCursor");
               this.close();
               var3.writeNoException();
            } catch (Exception var20) {
               DatabaseUtils.writeExceptionToParcel(var3, var20);
               var9 = true;
               break;
            }

            var9 = true;
            break;
         default:
            var9 = super.onTransact(var1, var2, var3, var4);
      }

      return var9;
   }
}
