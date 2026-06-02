package android.support.v4.os;

import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.v4.os.IResultReceiver;

/* JADX INFO: loaded from: classes.dex */
public class ResultReceiver implements Parcelable {
    public static final Parcelable.Creator<ResultReceiver> CREATOR = new Parcelable.Creator<ResultReceiver>() { // from class: android.support.v4.os.ResultReceiver.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ResultReceiver createFromParcel(Parcel parcel) {
            return new ResultReceiver(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ResultReceiver[] newArray(int i) {
            return new ResultReceiver[i];
        }
    };

    /* JADX INFO: renamed from: a */
    final boolean f2111a = false;

    /* JADX INFO: renamed from: b */
    final Handler f2112b = null;

    /* JADX INFO: renamed from: c */
    IResultReceiver f2113c;

    class MyRunnable implements Runnable {

        /* JADX INFO: renamed from: a */
        final int f2115a;

        /* JADX INFO: renamed from: b */
        final Bundle f2116b;

        MyRunnable(int i, Bundle bundle) {
            this.f2115a = i;
            this.f2116b = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            ResultReceiver.this.mo2043a(this.f2115a, this.f2116b);
        }
    }

    class MyResultReceiver extends IResultReceiver.Stub {
        MyResultReceiver() {
        }

        @Override // android.support.v4.os.IResultReceiver
        /* JADX INFO: renamed from: a */
        public void mo2319a(int i, Bundle bundle) {
            if (ResultReceiver.this.f2112b != null) {
                ResultReceiver.this.f2112b.post(ResultReceiver.this.new MyRunnable(i, bundle));
            } else {
                ResultReceiver.this.mo2043a(i, bundle);
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public void m2321b(int i, Bundle bundle) {
        if (this.f2111a) {
            if (this.f2112b != null) {
                this.f2112b.post(new MyRunnable(i, bundle));
                return;
            } else {
                mo2043a(i, bundle);
                return;
            }
        }
        if (this.f2113c != null) {
            try {
                this.f2113c.mo2319a(i, bundle);
            } catch (RemoteException e) {
            }
        }
    }

    /* JADX INFO: renamed from: a */
    protected void mo2043a(int i, Bundle bundle) {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        synchronized (this) {
            if (this.f2113c == null) {
                this.f2113c = new MyResultReceiver();
            }
            parcel.writeStrongBinder(this.f2113c.asBinder());
        }
    }

    ResultReceiver(Parcel parcel) {
        this.f2113c = IResultReceiver.Stub.m2320a(parcel.readStrongBinder());
    }
}
