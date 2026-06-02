package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.zzbq;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;

/* JADX INFO: loaded from: classes.dex */
public final class zzz {

    /* JADX INFO: renamed from: a */
    private static final Lock f6048a = new ReentrantLock();

    /* JADX INFO: renamed from: b */
    private static zzz f6049b;

    /* JADX INFO: renamed from: c */
    private final Lock f6050c = new ReentrantLock();

    /* JADX INFO: renamed from: d */
    private final SharedPreferences f6051d;

    private zzz(Context context) {
        this.f6051d = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    /* JADX INFO: renamed from: a */
    private final GoogleSignInAccount m6792a(String str) {
        String strM6796c;
        if (TextUtils.isEmpty(str) || (strM6796c = m6796c(m6795b("googleSignInAccount", str))) == null) {
            return null;
        }
        try {
            return GoogleSignInAccount.m6723a(strM6796c);
        } catch (JSONException e) {
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    public static zzz m6793a(Context context) {
        zzbq.m7373a(context);
        f6048a.lock();
        try {
            if (f6049b == null) {
                f6049b = new zzz(context.getApplicationContext());
            }
            return f6049b;
        } finally {
            f6048a.unlock();
        }
    }

    /* JADX INFO: renamed from: b */
    private final GoogleSignInOptions m6794b(String str) {
        String strM6796c;
        if (TextUtils.isEmpty(str) || (strM6796c = m6796c(m6795b("googleSignInOptions", str))) == null) {
            return null;
        }
        try {
            return GoogleSignInOptions.m6739a(strM6796c);
        } catch (JSONException e) {
            return null;
        }
    }

    /* JADX INFO: renamed from: b */
    private static String m6795b(String str, String str2) {
        return new StringBuilder(String.valueOf(str).length() + String.valueOf(":").length() + String.valueOf(str2).length()).append(str).append(":").append(str2).toString();
    }

    /* JADX INFO: renamed from: c */
    private final String m6796c(String str) {
        this.f6050c.lock();
        try {
            return this.f6051d.getString(str, null);
        } finally {
            this.f6050c.unlock();
        }
    }

    /* JADX INFO: renamed from: d */
    private final void m6797d(String str) {
        this.f6050c.lock();
        try {
            this.f6051d.edit().remove(str).apply();
        } finally {
            this.f6050c.unlock();
        }
    }

    /* JADX INFO: renamed from: a */
    public final GoogleSignInAccount m6798a() {
        return m6792a(m6796c("defaultGoogleSignInAccount"));
    }

    /* JADX INFO: renamed from: a */
    final void m6799a(GoogleSignInAccount googleSignInAccount, GoogleSignInOptions googleSignInOptions) {
        zzbq.m7373a(googleSignInAccount);
        zzbq.m7373a(googleSignInOptions);
        String strM6735j = googleSignInAccount.m6735j();
        m6800a(m6795b("googleSignInAccount", strM6735j), googleSignInAccount.m6737l());
        m6800a(m6795b("googleSignInOptions", strM6735j), googleSignInOptions.m6752b());
    }

    /* JADX INFO: renamed from: a */
    protected final void m6800a(String str, String str2) {
        this.f6050c.lock();
        try {
            this.f6051d.edit().putString(str, str2).apply();
        } finally {
            this.f6050c.unlock();
        }
    }

    /* JADX INFO: renamed from: b */
    public final GoogleSignInOptions m6801b() {
        return m6794b(m6796c("defaultGoogleSignInAccount"));
    }

    /* JADX INFO: renamed from: c */
    public final void m6802c() {
        String strM6796c = m6796c("defaultGoogleSignInAccount");
        m6797d("defaultGoogleSignInAccount");
        if (TextUtils.isEmpty(strM6796c)) {
            return;
        }
        m6797d(m6795b("googleSignInAccount", strM6796c));
        m6797d(m6795b("googleSignInOptions", strM6796c));
    }

    /* JADX INFO: renamed from: d */
    public final void m6803d() {
        this.f6050c.lock();
        try {
            this.f6051d.edit().clear().apply();
        } finally {
            this.f6050c.unlock();
        }
    }
}
