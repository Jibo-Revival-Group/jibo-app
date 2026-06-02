package com.google.android.gms.iid;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.util.zzq;
import com.google.api.client.googleapis.notifications.ResourceStates;
import com.jibo.aws.integration.util.KeyManager;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import org.apache.http.HttpHeaders;
import org.apache.http.protocol.HTTP;

/* JADX INFO: loaded from: classes.dex */
public final class zzl {

    /* JADX INFO: renamed from: a */
    private static String f6818a = null;

    /* JADX INFO: renamed from: b */
    private static boolean f6819b = false;

    /* JADX INFO: renamed from: c */
    private static int f6820c = 0;

    /* JADX INFO: renamed from: d */
    private static int f6821d = 0;

    /* JADX INFO: renamed from: e */
    private static int f6822e = 0;

    /* JADX INFO: renamed from: f */
    private static BroadcastReceiver f6823f = null;

    /* JADX INFO: renamed from: g */
    private Context f6824g;

    /* JADX INFO: renamed from: h */
    private Map<String, Object> f6825h = new HashMap();

    /* JADX INFO: renamed from: i */
    private Messenger f6826i;

    /* JADX INFO: renamed from: j */
    private Messenger f6827j;

    /* JADX INFO: renamed from: k */
    private MessengerCompat f6828k;

    /* JADX INFO: renamed from: l */
    private PendingIntent f6829l;

    /* JADX INFO: renamed from: m */
    private long f6830m;

    /* JADX INFO: renamed from: n */
    private long f6831n;

    /* JADX INFO: renamed from: o */
    private int f6832o;

    /* JADX INFO: renamed from: p */
    private int f6833p;

    /* JADX INFO: renamed from: q */
    private long f6834q;

    public zzl(Context context) {
        this.f6824g = context;
    }

    /* JADX INFO: renamed from: a */
    public static String m7625a(Context context) {
        boolean z;
        if (f6818a != null) {
            return f6818a;
        }
        f6820c = Process.myUid();
        PackageManager packageManager = context.getPackageManager();
        if (!zzq.m7517h()) {
            Iterator<ResolveInfo> it = packageManager.queryIntentServices(new Intent("com.google.android.c2dm.intent.REGISTER"), 0).iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                if (m7634a(packageManager, it.next().serviceInfo.packageName, "com.google.android.c2dm.intent.REGISTER")) {
                    f6819b = false;
                    z = true;
                    break;
                }
            }
            if (z) {
                return f6818a;
            }
        }
        if (m7632a(packageManager)) {
            return f6818a;
        }
        Log.w("InstanceID/Rpc", "Failed to resolve IID implementation package, falling back");
        if (m7633a(packageManager, "com.google.android.gms")) {
            f6819b = zzq.m7517h();
            return f6818a;
        }
        if (zzq.m7515f() || !m7633a(packageManager, "com.google.android.gsf")) {
            Log.w("InstanceID/Rpc", "Google Play services is missing, unable to get tokens");
            return null;
        }
        f6819b = false;
        return f6818a;
    }

    /* JADX INFO: renamed from: a */
    static String m7626a(Intent intent) throws IOException {
        if (intent == null) {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
        String stringExtra = intent.getStringExtra("registration_id");
        if (stringExtra == null) {
            stringExtra = intent.getStringExtra("unregistered");
        }
        intent.getLongExtra(HttpHeaders.RETRY_AFTER, 0L);
        if (stringExtra != null) {
            return stringExtra;
        }
        String stringExtra2 = intent.getStringExtra("error");
        if (stringExtra2 != null) {
            throw new IOException(stringExtra2);
        }
        String strValueOf = String.valueOf(intent.getExtras());
        Log.w("InstanceID/Rpc", new StringBuilder(String.valueOf(strValueOf).length() + 29).append("Unexpected response from GCM ").append(strValueOf).toString(), new Throwable());
        throw new IOException("SERVICE_NOT_AVAILABLE");
    }

    /* JADX INFO: renamed from: a */
    private static String m7627a(KeyPair keyPair, String... strArr) {
        try {
            byte[] bytes = TextUtils.join("\n", strArr).getBytes(HTTP.UTF_8);
            try {
                PrivateKey privateKey = keyPair.getPrivate();
                Signature signature = Signature.getInstance(privateKey instanceof RSAPrivateKey ? KeyManager.SIGNATURE_ALGORITHM : "SHA256withECDSA");
                signature.initSign(privateKey);
                signature.update(bytes);
                return InstanceID.m7602a(signature.sign());
            } catch (GeneralSecurityException e) {
                Log.e("InstanceID/Rpc", "Unable to sign registration request", e);
                return null;
            }
        } catch (UnsupportedEncodingException e2) {
            Log.e("InstanceID/Rpc", "Unable to encode string", e2);
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    private final void m7628a() {
        if (this.f6826i != null) {
            return;
        }
        m7625a(this.f6824g);
        this.f6826i = new Messenger(new zzm(this, Looper.getMainLooper()));
    }

    /* JADX INFO: renamed from: a */
    private final void m7629a(Object obj) {
        synchronized (getClass()) {
            for (String str : this.f6825h.keySet()) {
                Object obj2 = this.f6825h.get(str);
                this.f6825h.put(str, obj);
                m7630a(obj2, obj);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m7630a(Object obj, Object obj2) {
        if (obj instanceof ConditionVariable) {
            ((ConditionVariable) obj).open();
        }
        if (obj instanceof Messenger) {
            Messenger messenger = (Messenger) obj;
            Message messageObtain = Message.obtain();
            messageObtain.obj = obj2;
            try {
                messenger.send(messageObtain);
            } catch (RemoteException e) {
                String strValueOf = String.valueOf(e);
                Log.w("InstanceID/Rpc", new StringBuilder(String.valueOf(strValueOf).length() + 24).append("Failed to send response ").append(strValueOf).toString());
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private final void m7631a(String str, Object obj) {
        synchronized (getClass()) {
            Object obj2 = this.f6825h.get(str);
            this.f6825h.put(str, obj);
            m7630a(obj2, obj);
        }
    }

    /* JADX INFO: renamed from: a */
    private static boolean m7632a(PackageManager packageManager) {
        Iterator<ResolveInfo> it = packageManager.queryBroadcastReceivers(new Intent("com.google.iid.TOKEN_REQUEST"), 0).iterator();
        while (it.hasNext()) {
            if (m7634a(packageManager, it.next().activityInfo.packageName, "com.google.iid.TOKEN_REQUEST")) {
                f6819b = true;
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    private static boolean m7633a(PackageManager packageManager, String str) {
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, 0);
            f6818a = applicationInfo.packageName;
            f6821d = applicationInfo.uid;
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    /* JADX INFO: renamed from: a */
    private static boolean m7634a(PackageManager packageManager, String str, String str2) {
        if (packageManager.checkPermission("com.google.android.c2dm.permission.SEND", str) == 0) {
            return m7633a(packageManager, str);
        }
        Log.w("InstanceID/Rpc", new StringBuilder(String.valueOf(str).length() + 56 + String.valueOf(str2).length()).append("Possible malicious package ").append(str).append(" declares ").append(str2).append(" without permission").toString());
        return false;
    }

    /* JADX INFO: renamed from: b */
    private static int m7635b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(m7625a(context), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            return -1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x024f  */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final android.content.Intent m7636b(android.os.Bundle r12, java.security.KeyPair r13) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 659
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.iid.zzl.m7636b(android.os.Bundle, java.security.KeyPair):android.content.Intent");
    }

    /* JADX INFO: renamed from: b */
    private static synchronized String m7637b() {
        int i;
        i = f6822e;
        f6822e = i + 1;
        return Integer.toString(i);
    }

    /* JADX INFO: renamed from: c */
    private final synchronized void m7638c(Intent intent) {
        if (this.f6829l == null) {
            Intent intent2 = new Intent();
            intent2.setPackage("com.google.example.invalidpackage");
            this.f6829l = PendingIntent.getBroadcast(this.f6824g, 0, intent2, 0);
        }
        intent.putExtra("app", this.f6829l);
    }

    /* JADX INFO: renamed from: a */
    final Intent m7639a(Bundle bundle, KeyPair keyPair) throws IOException {
        Intent intentM7636b = m7636b(bundle, keyPair);
        if (intentM7636b == null || !intentM7636b.hasExtra("google.messenger")) {
            return intentM7636b;
        }
        Intent intentM7636b2 = m7636b(bundle, keyPair);
        if (intentM7636b2 == null || !intentM7636b2.hasExtra("google.messenger")) {
            return intentM7636b2;
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    public final void m7640a(Message message) {
        if (message == null) {
            return;
        }
        if (!(message.obj instanceof Intent)) {
            Log.w("InstanceID/Rpc", "Dropping invalid message");
            return;
        }
        Intent intent = (Intent) message.obj;
        intent.setExtrasClassLoader(MessengerCompat.class.getClassLoader());
        if (intent.hasExtra("google.messenger")) {
            Parcelable parcelableExtra = intent.getParcelableExtra("google.messenger");
            if (parcelableExtra instanceof MessengerCompat) {
                this.f6828k = (MessengerCompat) parcelableExtra;
            }
            if (parcelableExtra instanceof Messenger) {
                this.f6827j = (Messenger) parcelableExtra;
            }
        }
        m7641b((Intent) message.obj);
    }

    /* JADX INFO: renamed from: b */
    public final void m7641b(Intent intent) {
        String str;
        String strSubstring;
        if (intent == null) {
            if (Log.isLoggable("InstanceID/Rpc", 3)) {
                Log.d("InstanceID/Rpc", "Unexpected response: null");
                return;
            }
            return;
        }
        String action = intent.getAction();
        if (!"com.google.android.c2dm.intent.REGISTRATION".equals(action) && !"com.google.android.gms.iid.InstanceID".equals(action)) {
            if (Log.isLoggable("InstanceID/Rpc", 3)) {
                String strValueOf = String.valueOf(intent.getAction());
                Log.d("InstanceID/Rpc", strValueOf.length() != 0 ? "Unexpected response ".concat(strValueOf) : new String("Unexpected response "));
                return;
            }
            return;
        }
        String stringExtra = intent.getStringExtra("registration_id");
        String stringExtra2 = stringExtra == null ? intent.getStringExtra("unregistered") : stringExtra;
        if (stringExtra2 != null) {
            this.f6830m = SystemClock.elapsedRealtime();
            this.f6834q = 0L;
            this.f6832o = 0;
            this.f6833p = 0;
            String str2 = null;
            if (stringExtra2.startsWith("|")) {
                String[] strArrSplit = stringExtra2.split("\\|");
                if (!"ID".equals(strArrSplit[1])) {
                    String strValueOf2 = String.valueOf(stringExtra2);
                    Log.w("InstanceID/Rpc", strValueOf2.length() != 0 ? "Unexpected structured response ".concat(strValueOf2) : new String("Unexpected structured response "));
                }
                String str3 = strArrSplit[2];
                if (strArrSplit.length > 4) {
                    if (ResourceStates.SYNC.equals(strArrSplit[3])) {
                        Context context = this.f6824g;
                        Intent intent2 = new Intent("com.google.android.gms.iid.InstanceID");
                        intent2.putExtra("CMD", ResourceStates.SYNC);
                        intent2.setClassName(context, "com.google.android.gms.gcm.GcmReceiver");
                        context.sendBroadcast(intent2);
                    } else if ("RST".equals(strArrSplit[3])) {
                        Context context2 = this.f6824g;
                        InstanceID.m7604c(this.f6824g);
                        InstanceIDListenerService.m7612a(context2, InstanceID.m7605c());
                        intent.removeExtra("registration_id");
                        m7631a(str3, (Object) intent);
                        return;
                    }
                }
                String strSubstring2 = strArrSplit[strArrSplit.length - 1];
                if (strSubstring2.startsWith(":")) {
                    strSubstring2 = strSubstring2.substring(1);
                }
                intent.putExtra("registration_id", strSubstring2);
                str2 = str3;
            }
            if (str2 == null) {
                m7629a((Object) intent);
                return;
            } else {
                m7631a(str2, (Object) intent);
                return;
            }
        }
        String stringExtra3 = intent.getStringExtra("error");
        if (stringExtra3 == null) {
            String strValueOf3 = String.valueOf(intent.getExtras());
            Log.w("InstanceID/Rpc", new StringBuilder(String.valueOf(strValueOf3).length() + 49).append("Unexpected response, no error or registration id ").append(strValueOf3).toString());
            return;
        }
        if (Log.isLoggable("InstanceID/Rpc", 3)) {
            String strValueOf4 = String.valueOf(stringExtra3);
            Log.d("InstanceID/Rpc", strValueOf4.length() != 0 ? "Received InstanceID error ".concat(strValueOf4) : new String("Received InstanceID error "));
        }
        if (stringExtra3.startsWith("|")) {
            String[] strArrSplit2 = stringExtra3.split("\\|");
            if (!"ID".equals(strArrSplit2[1])) {
                String strValueOf5 = String.valueOf(stringExtra3);
                Log.w("InstanceID/Rpc", strValueOf5.length() != 0 ? "Unexpected structured response ".concat(strValueOf5) : new String("Unexpected structured response "));
            }
            if (strArrSplit2.length > 2) {
                str = strArrSplit2[2];
                strSubstring = strArrSplit2[3];
                if (strSubstring.startsWith(":")) {
                    strSubstring = strSubstring.substring(1);
                }
            } else {
                strSubstring = "UNKNOWN";
                str = null;
            }
            intent.putExtra("error", strSubstring);
        } else {
            str = null;
            strSubstring = stringExtra3;
        }
        if (str == null) {
            m7629a(strSubstring);
        } else {
            m7631a(str, (Object) strSubstring);
        }
        long longExtra = intent.getLongExtra(HttpHeaders.RETRY_AFTER, 0L);
        if (longExtra > 0) {
            this.f6831n = SystemClock.elapsedRealtime();
            this.f6833p = ((int) longExtra) * 1000;
            this.f6834q = SystemClock.elapsedRealtime() + ((long) this.f6833p);
            Log.w("InstanceID/Rpc", new StringBuilder(52).append("Explicit request from server to backoff: ").append(this.f6833p).toString());
            return;
        }
        if (("SERVICE_NOT_AVAILABLE".equals(strSubstring) || "AUTHENTICATION_FAILED".equals(strSubstring)) && "com.google.android.gsf".equals(f6818a)) {
            this.f6832o++;
            if (this.f6832o >= 3) {
                if (this.f6832o == 3) {
                    this.f6833p = new Random().nextInt(1000) + 1000;
                }
                this.f6833p <<= 1;
                this.f6834q = SystemClock.elapsedRealtime() + ((long) this.f6833p);
                Log.w("InstanceID/Rpc", new StringBuilder(String.valueOf(strSubstring).length() + 31).append("Backoff due to ").append(strSubstring).append(" for ").append(this.f6833p).toString());
            }
        }
    }
}
