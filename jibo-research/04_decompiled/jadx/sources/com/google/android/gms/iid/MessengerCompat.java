package com.google.android.gms.iid;

import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.common.internal.ReflectedParcelable;

/* JADX INFO: loaded from: classes.dex */
public class MessengerCompat implements ReflectedParcelable {
    public static final Parcelable.Creator<MessengerCompat> CREATOR = new zzk();

    /* JADX INFO: renamed from: a */
    private Messenger f6793a;

    /* JADX INFO: renamed from: b */
    private zzi f6794b;

    public MessengerCompat(IBinder iBinder) {
        zzi zzjVar;
        if (Build.VERSION.SDK_INT >= 21) {
            this.f6793a = new Messenger(iBinder);
            return;
        }
        if (iBinder == null) {
            zzjVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.iid.IMessengerCompat");
            zzjVar = iInterfaceQueryLocalInterface instanceof zzi ? (zzi) iInterfaceQueryLocalInterface : new zzj(iBinder);
        }
        this.f6794b = zzjVar;
    }

    /* JADX INFO: renamed from: a */
    private final IBinder m7614a() {
        return this.f6793a != null ? this.f6793a.getBinder() : this.f6794b.asBinder();
    }

    /* JADX INFO: renamed from: a */
    public final void m7615a(Message message) throws RemoteException {
        if (this.f6793a != null) {
            this.f6793a.send(message);
        } else {
            this.f6794b.mo7624a(message);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            return m7614a().equals(((MessengerCompat) obj).m7614a());
        } catch (ClassCastException e) {
            return false;
        }
    }

    public int hashCode() {
        return m7614a().hashCode();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (this.f6793a != null) {
            parcel.writeStrongBinder(this.f6793a.getBinder());
        } else {
            parcel.writeStrongBinder(this.f6794b.asBinder());
        }
    }
}
