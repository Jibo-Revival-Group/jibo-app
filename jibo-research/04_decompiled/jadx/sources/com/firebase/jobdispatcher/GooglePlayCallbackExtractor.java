package com.firebase.jobdispatcher;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.util.Pair;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
final class GooglePlayCallbackExtractor {

    /* JADX INFO: renamed from: a */
    private static Boolean f5701a = null;

    GooglePlayCallbackExtractor() {
    }

    /* JADX INFO: renamed from: a */
    public Pair<JobCallback, Bundle> m6529a(Bundle bundle) {
        if (bundle != null) {
            return m6527b(bundle);
        }
        Log.e("FJD.GooglePlayReceiver", "No callback received, terminating");
        return null;
    }

    @SuppressLint({"ParcelClassLoader"})
    /* JADX INFO: renamed from: b */
    private static Pair<JobCallback, Bundle> m6527b(Bundle bundle) {
        GooglePlayJobCallback googlePlayJobCallback;
        Bundle bundle2 = new Bundle();
        Parcel parcelM6528c = m6528c(bundle);
        try {
            if (parcelM6528c.readInt() <= 0) {
                Log.w("FJD.GooglePlayReceiver", "No callback received, terminating");
                return null;
            }
            if (parcelM6528c.readInt() != 1279544898) {
                Log.w("FJD.GooglePlayReceiver", "No callback received, terminating");
                return null;
            }
            int i = parcelM6528c.readInt();
            int i2 = 0;
            GooglePlayJobCallback googlePlayJobCallback2 = null;
            while (i2 < i) {
                String strM6524a = m6524a(parcelM6528c);
                if (strM6524a == null) {
                    googlePlayJobCallback = googlePlayJobCallback2;
                } else if (googlePlayJobCallback2 != null || !"callback".equals(strM6524a)) {
                    Object value = parcelM6528c.readValue(null);
                    if (value instanceof String) {
                        bundle2.putString(strM6524a, (String) value);
                        googlePlayJobCallback = googlePlayJobCallback2;
                    } else if (value instanceof Boolean) {
                        bundle2.putBoolean(strM6524a, ((Boolean) value).booleanValue());
                        googlePlayJobCallback = googlePlayJobCallback2;
                    } else if (value instanceof Integer) {
                        bundle2.putInt(strM6524a, ((Integer) value).intValue());
                        googlePlayJobCallback = googlePlayJobCallback2;
                    } else if (value instanceof ArrayList) {
                        bundle2.putParcelableArrayList(strM6524a, (ArrayList) value);
                        googlePlayJobCallback = googlePlayJobCallback2;
                    } else if (value instanceof Bundle) {
                        bundle2.putBundle(strM6524a, (Bundle) value);
                        googlePlayJobCallback = googlePlayJobCallback2;
                    } else if (value instanceof Parcelable) {
                        bundle2.putParcelable(strM6524a, (Parcelable) value);
                        googlePlayJobCallback = googlePlayJobCallback2;
                    } else {
                        googlePlayJobCallback = googlePlayJobCallback2;
                    }
                } else {
                    if (parcelM6528c.readInt() != 4) {
                        Log.w("FJD.GooglePlayReceiver", "Bad callback received, terminating");
                        return null;
                    }
                    if (!"com.google.android.gms.gcm.PendingCallback".equals(parcelM6528c.readString())) {
                        Log.w("FJD.GooglePlayReceiver", "Bad callback received, terminating");
                        return null;
                    }
                    googlePlayJobCallback = new GooglePlayJobCallback(parcelM6528c.readStrongBinder());
                }
                i2++;
                googlePlayJobCallback2 = googlePlayJobCallback;
            }
            if (googlePlayJobCallback2 != null) {
                return Pair.create(googlePlayJobCallback2, bundle2);
            }
            Log.w("FJD.GooglePlayReceiver", "No callback received, terminating");
            return null;
        } finally {
            parcelM6528c.recycle();
        }
    }

    /* JADX INFO: renamed from: c */
    private static Parcel m6528c(Bundle bundle) {
        Parcel parcelObtain = Parcel.obtain();
        bundle.writeToParcel(parcelObtain, 0);
        parcelObtain.setDataPosition(0);
        return parcelObtain;
    }

    /* JADX INFO: renamed from: a */
    private static String m6524a(Parcel parcel) {
        if (m6526a()) {
            return parcel.readString();
        }
        Object value = parcel.readValue(null);
        if (!(value instanceof String)) {
            Log.w("FJD.GooglePlayReceiver", "Bad callback received, terminating");
            return null;
        }
        return (String) value;
    }

    /* JADX INFO: renamed from: a */
    private static synchronized boolean m6526a() {
        boolean zBooleanValue;
        synchronized (GooglePlayCallbackExtractor.class) {
            if (f5701a == null) {
                Bundle bundle = new Bundle();
                bundle.putString("key", "value");
                Parcel parcelM6528c = m6528c(bundle);
                try {
                    try {
                        m6525a(parcelM6528c.readInt() > 0);
                        m6525a(parcelM6528c.readInt() == 1279544898);
                        m6525a(parcelM6528c.readInt() == 1);
                        f5701a = Boolean.valueOf("key".equals(parcelM6528c.readString()));
                    } finally {
                        parcelM6528c.recycle();
                    }
                } catch (RuntimeException e) {
                    f5701a = Boolean.FALSE;
                }
            }
            zBooleanValue = f5701a.booleanValue();
        }
        return zBooleanValue;
    }

    /* JADX INFO: renamed from: a */
    private static void m6525a(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }
}
