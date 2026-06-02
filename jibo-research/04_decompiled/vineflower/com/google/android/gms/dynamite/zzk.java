package com.google.android.gms.dynamite;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public interface zzk extends IInterface {
   int a(IObjectWrapper var1, String var2, boolean var3) throws RemoteException;

   IObjectWrapper a(IObjectWrapper var1, String var2, int var3) throws RemoteException;
}
