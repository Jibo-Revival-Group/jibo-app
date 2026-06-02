package com.google.android.gms.internal;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

public interface zzbeq extends IInterface {
   void a(Status var1) throws RemoteException;

   void a(Status var1, long var2) throws RemoteException;

   void a(Status var1, zzbef var2) throws RemoteException;

   void a(Status var1, zzbeh[] var2) throws RemoteException;

   void a(DataHolder var1) throws RemoteException;

   void b(Status var1) throws RemoteException;

   void b(Status var1, long var2) throws RemoteException;

   void b(Status var1, zzbef var2) throws RemoteException;

   void c(Status var1) throws RemoteException;
}
