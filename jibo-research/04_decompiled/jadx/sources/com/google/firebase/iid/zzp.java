package com.google.firebase.iid;

import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.iid.MessengerCompat;

/* JADX INFO: loaded from: classes.dex */
final class zzp {

    /* JADX INFO: renamed from: a */
    private final Messenger f8675a;

    /* JADX INFO: renamed from: b */
    private final MessengerCompat f8676b;

    zzp(IBinder iBinder) throws RemoteException {
        String interfaceDescriptor = iBinder.getInterfaceDescriptor();
        if ("android.os.IMessenger".equals(interfaceDescriptor)) {
            this.f8675a = new Messenger(iBinder);
            this.f8676b = null;
        } else if ("com.google.android.gms.iid.IMessengerCompat".equals(interfaceDescriptor)) {
            this.f8676b = new MessengerCompat(iBinder);
            this.f8675a = null;
        } else {
            String strValueOf = String.valueOf(interfaceDescriptor);
            Log.w("MessengerIpcClient", strValueOf.length() != 0 ? "Invalid interface descriptor: ".concat(strValueOf) : new String("Invalid interface descriptor: "));
            throw new RemoteException();
        }
    }

    /* JADX INFO: renamed from: a */
    final void m9148a(Message message) throws RemoteException {
        if (this.f8675a != null) {
            this.f8675a.send(message);
        } else {
            if (this.f8676b == null) {
                throw new IllegalStateException("Both messengers are null");
            }
            this.f8676b.m7615a(message);
        }
    }
}
