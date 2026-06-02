package com.google.android.gms.auth.api.signin.internal;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Status;

public interface zzs extends IInterface {
   void a(GoogleSignInAccount var1, Status var2) throws RemoteException;

   void a(Status var1) throws RemoteException;

   void b(Status var1) throws RemoteException;
}
