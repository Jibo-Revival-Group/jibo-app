package android.support.customtabs;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

public interface ICustomTabsService extends IInterface {
   Bundle a(String var1, Bundle var2) throws RemoteException;

   boolean a(long var1) throws RemoteException;

   boolean a(ICustomTabsCallback var1) throws RemoteException;

   boolean a(ICustomTabsCallback var1, Uri var2, Bundle var3, List<Bundle> var4) throws RemoteException;

   boolean a(ICustomTabsCallback var1, Bundle var2) throws RemoteException;

   abstract class Stub extends Binder implements ICustomTabsService {
      public Stub() {
         this.attachInterface(this, "android.support.customtabs.ICustomTabsService");
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         byte var7 = 0;
         byte var5 = 0;
         byte var6 = 0;
         boolean var8 = true;
         switch (var1) {
            case 2:
               var2.enforceInterface("android.support.customtabs.ICustomTabsService");
               boolean var22 = this.a(var2.readLong());
               var3.writeNoException();
               byte var16;
               if (var22) {
                  var16 = 1;
               } else {
                  var16 = 0;
               }

               var3.writeInt(var16);
               break;
            case 3:
               var2.enforceInterface("android.support.customtabs.ICustomTabsService");
               boolean var21 = this.a(ICustomTabsCallback.Stub.a(var2.readStrongBinder()));
               var3.writeNoException();
               byte var15 = var6;
               if (var21) {
                  var15 = 1;
               }

               var3.writeInt(var15);
               break;
            case 4:
               var2.enforceInterface("android.support.customtabs.ICustomTabsService");
               ICustomTabsCallback var12 = ICustomTabsCallback.Stub.a(var2.readStrongBinder());
               Uri var24;
               if (var2.readInt() != 0) {
                  var24 = (Uri)Uri.CREATOR.createFromParcel(var2);
               } else {
                  var24 = null;
               }

               Bundle var11;
               if (var2.readInt() != 0) {
                  var11 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
               } else {
                  var11 = null;
               }

               boolean var20 = this.a(var12, var24, var11, var2.createTypedArrayList(Bundle.CREATOR));
               var3.writeNoException();
               byte var14 = var7;
               if (var20) {
                  var14 = 1;
               }

               var3.writeInt(var14);
               break;
            case 5:
               var2.enforceInterface("android.support.customtabs.ICustomTabsService");
               String var23 = var2.readString();
               Bundle var18;
               if (var2.readInt() != 0) {
                  var18 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
               } else {
                  var18 = null;
               }

               Bundle var19 = this.a(var23, var18);
               var3.writeNoException();
               if (var19 != null) {
                  var3.writeInt(1);
                  var19.writeToParcel(var3, 1);
               } else {
                  var3.writeInt(0);
               }
               break;
            case 6:
               var2.enforceInterface("android.support.customtabs.ICustomTabsService");
               ICustomTabsCallback var10 = ICustomTabsCallback.Stub.a(var2.readStrongBinder());
               Bundle var17;
               if (var2.readInt() != 0) {
                  var17 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
               } else {
                  var17 = null;
               }

               boolean var9 = this.a(var10, var17);
               var3.writeNoException();
               byte var13 = var5;
               if (var9) {
                  var13 = 1;
               }

               var3.writeInt(var13);
               break;
            case 1598968902:
               var3.writeString("android.support.customtabs.ICustomTabsService");
               break;
            default:
               var8 = super.onTransact(var1, var2, var3, var4);
         }

         return var8;
      }
   }
}
