package com.google.android.gms.location.places.internal;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

public interface zzw extends IInterface {
   void a(Status var1) throws RemoteException;

   void a(DataHolder var1) throws RemoteException;

   void b(DataHolder var1) throws RemoteException;

   void c(DataHolder var1) throws RemoteException;

   void d(DataHolder var1) throws RemoteException;
}
