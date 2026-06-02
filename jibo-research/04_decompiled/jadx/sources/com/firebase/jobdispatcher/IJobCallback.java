package com.firebase.jobdispatcher;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface IJobCallback extends IInterface {
    /* JADX INFO: renamed from: a */
    void mo6519a(Bundle bundle, int i) throws RemoteException;

    public static abstract class Stub extends Binder implements IJobCallback {
        public Stub() {
            attachInterface(this, "com.firebase.jobdispatcher.IJobCallback");
        }

        /* JADX INFO: renamed from: a */
        public static IJobCallback m6558a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.firebase.jobdispatcher.IJobCallback");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IJobCallback)) {
                return (IJobCallback) iInterfaceQueryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            Bundle bundle;
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.firebase.jobdispatcher.IJobCallback");
                    if (parcel.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    } else {
                        bundle = null;
                    }
                    mo6519a(bundle, parcel.readInt());
                    return true;
                case 1598968902:
                    parcel2.writeString("com.firebase.jobdispatcher.IJobCallback");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        private static class Proxy implements IJobCallback {

            /* JADX INFO: renamed from: a */
            private IBinder f5720a;

            Proxy(IBinder iBinder) {
                this.f5720a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f5720a;
            }

            @Override // com.firebase.jobdispatcher.IJobCallback
            /* JADX INFO: renamed from: a */
            public void mo6519a(Bundle bundle, int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.firebase.jobdispatcher.IJobCallback");
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeInt(i);
                    this.f5720a.transact(1, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }
    }
}
