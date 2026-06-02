package com.firebase.jobdispatcher;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.firebase.jobdispatcher.IJobCallback;

/* JADX INFO: loaded from: classes.dex */
public interface IRemoteJobService extends IInterface {
    /* JADX INFO: renamed from: a */
    void mo6559a(Bundle bundle, IJobCallback iJobCallback) throws RemoteException;

    /* JADX INFO: renamed from: a */
    void mo6560a(Bundle bundle, boolean z) throws RemoteException;

    public static abstract class Stub extends Binder implements IRemoteJobService {
        public Stub() {
            attachInterface(this, "com.firebase.jobdispatcher.IRemoteJobService");
        }

        /* JADX INFO: renamed from: a */
        public static IRemoteJobService m6561a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.firebase.jobdispatcher.IRemoteJobService");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IRemoteJobService)) {
                return (IRemoteJobService) iInterfaceQueryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.firebase.jobdispatcher.IRemoteJobService");
                    mo6559a(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, IJobCallback.Stub.m6558a(parcel.readStrongBinder()));
                    return true;
                case 2:
                    parcel.enforceInterface("com.firebase.jobdispatcher.IRemoteJobService");
                    mo6560a(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.firebase.jobdispatcher.IRemoteJobService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        private static class Proxy implements IRemoteJobService {

            /* JADX INFO: renamed from: a */
            private IBinder f5721a;

            Proxy(IBinder iBinder) {
                this.f5721a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f5721a;
            }

            @Override // com.firebase.jobdispatcher.IRemoteJobService
            /* JADX INFO: renamed from: a */
            public void mo6559a(Bundle bundle, IJobCallback iJobCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.firebase.jobdispatcher.IRemoteJobService");
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iJobCallback != null ? iJobCallback.asBinder() : null);
                    this.f5721a.transact(1, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // com.firebase.jobdispatcher.IRemoteJobService
            /* JADX INFO: renamed from: a */
            public void mo6560a(Bundle bundle, boolean z) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.firebase.jobdispatcher.IRemoteJobService");
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeInt(z ? 1 : 0);
                    this.f5721a.transact(2, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }
    }
}
