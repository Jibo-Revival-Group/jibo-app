package com.firebase.jobdispatcher;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
final class GooglePlayJobCallback implements JobCallback {

    /* JADX INFO: renamed from: a */
    private final IBinder f5707a;

    public GooglePlayJobCallback(IBinder iBinder) {
        this.f5707a = iBinder;
    }

    @Override // com.firebase.jobdispatcher.JobCallback
    /* JADX INFO: renamed from: a */
    public void mo6534a(int i) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            try {
                parcelObtain.writeInterfaceToken("com.google.android.gms.gcm.INetworkTaskCallback");
                parcelObtain.writeInt(i);
                this.f5707a.transact(2, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        } finally {
            parcelObtain.recycle();
            parcelObtain2.recycle();
        }
    }
}
