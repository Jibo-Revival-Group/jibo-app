package com.salesforce.androidsdk.security;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import com.salesforce.androidsdk.accounts.UserAccount;
import com.salesforce.androidsdk.analytics.EventBuilderHelper;
import com.salesforce.androidsdk.analytics.security.Encryptor;
import com.salesforce.androidsdk.app.SalesforceSDKManager;
import com.salesforce.androidsdk.app.UUIDManager;
import com.salesforce.androidsdk.util.EventsObservable;
import java.io.File;
import java.io.FilenameFilter;
import net.sqlcipher.database.SQLiteDatabase;

/* JADX INFO: loaded from: classes.dex */
public class PasscodeManager {

    /* JADX INFO: renamed from: a */
    boolean f14266a;

    /* JADX INFO: renamed from: b */
    private String f14267b;

    /* JADX INFO: renamed from: c */
    private HashConfig f14268c;

    /* JADX INFO: renamed from: d */
    private HashConfig f14269d;

    /* JADX INFO: renamed from: e */
    private Activity f14270e;

    /* JADX INFO: renamed from: f */
    private Handler f14271f;

    /* JADX INFO: renamed from: g */
    private long f14272g;

    /* JADX INFO: renamed from: h */
    private int f14273h;

    /* JADX INFO: renamed from: i */
    private int f14274i;

    /* JADX INFO: renamed from: j */
    private LockChecker f14275j;

    public PasscodeManager(Context context) {
        this(context, new HashConfig(UUIDManager.m14470a("vprefix"), UUIDManager.m14470a("vsuffix"), UUIDManager.m14470a("vkey")), new HashConfig(UUIDManager.m14470a("eprefix"), UUIDManager.m14470a("esuffix"), UUIDManager.m14470a("ekey")));
    }

    public PasscodeManager(Context context, HashConfig hashConfig, HashConfig hashConfig2) {
        this.f14274i = 4;
        this.f14272g = m14660k();
        this.f14268c = hashConfig;
        this.f14269d = hashConfig2;
        m14632e(context);
        this.f14266a = true;
        this.f14275j = new LockChecker();
    }

    /* JADX INFO: renamed from: a */
    public void m14638a(UserAccount userAccount, int i, int i2) {
        if (userAccount != null) {
            SharedPreferences.Editor editorEdit = SalesforceSDKManager.m14403a().m14446k().getSharedPreferences("mobile_policy" + userAccount.m14260t(), 0).edit();
            editorEdit.putInt("access_timeout", i);
            editorEdit.putInt("passcode_length", i2);
            editorEdit.commit();
        }
    }

    /* JADX INFO: renamed from: d */
    private void m14631d(Context context) {
        if (context != null) {
            SharedPreferences.Editor editorEdit = context.getSharedPreferences("mobile_policy", 0).edit();
            editorEdit.putInt("access_timeout", this.f14273h);
            editorEdit.putInt("passcode_length", this.f14274i);
            editorEdit.commit();
        }
    }

    /* JADX INFO: renamed from: e */
    private void m14632e(Context context) {
        if (context != null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("mobile_policy", 0);
            if (!sharedPreferences.contains("access_timeout") || !sharedPreferences.contains("passcode_length")) {
                this.f14273h = 0;
                this.f14274i = 4;
                m14631d(context);
            } else {
                this.f14273h = sharedPreferences.getInt("access_timeout", 0);
                this.f14274i = sharedPreferences.getInt("passcode_length", 4);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public void m14636a(Context context) {
        File file = new File(context.getApplicationInfo().dataDir + "/shared_prefs");
        PasscodeFileFilter passcodeFileFilter = new PasscodeFileFilter();
        for (File file2 : file.listFiles()) {
            if (file2 != null && passcodeFileFilter.accept(file, file2.getName())) {
                file2.delete();
            }
        }
        this.f14272g = m14660k();
        this.f14266a = true;
        this.f14267b = null;
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("user", 0).edit();
        editorEdit.remove("passcode");
        editorEdit.remove("failed_attempts");
        editorEdit.commit();
        this.f14273h = 0;
        this.f14274i = 4;
        m14631d(context);
        this.f14271f = null;
    }

    /* JADX INFO: renamed from: a */
    public void m14640a(boolean z) {
        if (z) {
            this.f14271f = new Handler();
            this.f14271f.postDelayed(this.f14275j, 20000L);
        } else {
            if (this.f14271f != null) {
                this.f14271f.removeCallbacks(this.f14275j);
            }
            this.f14271f = null;
        }
    }

    /* JADX INFO: renamed from: a */
    public boolean m14641a() {
        return this.f14271f != null;
    }

    /* JADX INFO: renamed from: b */
    public int m14645b() {
        int iM14650c = m14650c() + 1;
        m14629b(iM14650c);
        return iM14650c;
    }

    /* JADX INFO: renamed from: a */
    public boolean m14644a(Context context, String str) {
        String strM14630d = m14630d(context.getSharedPreferences("user", 0).getString("passcode", null));
        if (strM14630d != null) {
            return strM14630d.equals(m14646b(str));
        }
        return true;
    }

    /* JADX INFO: renamed from: d */
    private String m14630d(String str) {
        int length = str == null ? 0 : str.length();
        if (length > 0 && str.endsWith("\n")) {
            return str.substring(0, length - 1);
        }
        return str;
    }

    /* JADX INFO: renamed from: b */
    public void m14647b(Context context, String str) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("user", 0).edit();
        editorEdit.putString("passcode", m14646b(str));
        editorEdit.commit();
    }

    /* JADX INFO: renamed from: b */
    public boolean m14649b(Context context) {
        return context.getSharedPreferences("user", 0).contains("passcode");
    }

    /* JADX INFO: renamed from: c */
    public int m14650c() {
        return SalesforceSDKManager.m14403a().m14446k().getSharedPreferences("user", 0).getInt("failed_attempts", 0);
    }

    /* JADX INFO: renamed from: b */
    private void m14629b(int i) {
        SharedPreferences.Editor editorEdit = SalesforceSDKManager.m14403a().m14446k().getSharedPreferences("user", 0).edit();
        editorEdit.putInt("failed_attempts", i);
        editorEdit.commit();
    }

    /* JADX INFO: renamed from: d */
    public String m14653d() {
        return this.f14267b;
    }

    /* JADX INFO: renamed from: e */
    public boolean m14654e() {
        return this.f14273h > 0 && this.f14266a;
    }

    /* JADX INFO: renamed from: c */
    public void m14652c(Context context) {
        m14637a(context, false);
    }

    /* JADX INFO: renamed from: a */
    public boolean m14642a(Activity activity, boolean z) {
        if (activity != null) {
            this.f14270e = activity;
        }
        if (m14641a() && (m14654e() || m14658i())) {
            m14652c(this.f14270e);
            return true;
        }
        if (z) {
            m14633l();
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    public void m14635a(Activity activity) {
        m14640a(false);
    }

    /* JADX INFO: renamed from: b */
    public boolean m14648b(Activity activity) {
        m14640a(true);
        m14642a(activity, true);
        return !m14654e();
    }

    /* JADX INFO: renamed from: f */
    public void m14655f() {
        m14633l();
    }

    /* JADX INFO: renamed from: a */
    public void m14634a(int i) {
        if (this.f14273h != i) {
            if (this.f14273h == 0 || (this.f14273h > 0 && i > 0)) {
                this.f14273h = i;
                m14631d(SalesforceSDKManager.m14403a().m14446k());
            } else {
                this.f14273h = i;
                SalesforceSDKManager.m14403a().mo14433b(this.f14267b, null);
                m14636a(SalesforceSDKManager.m14403a().m14446k());
            }
        }
    }

    /* JADX INFO: renamed from: g */
    public int m14656g() {
        return this.f14273h;
    }

    /* JADX INFO: renamed from: h */
    public int m14657h() {
        return this.f14274i;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0017  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean m14643a(android.content.Context r4, int r5) {
        /*
            r3 = this;
            r0 = 1
            r1 = 0
            int r2 = r3.f14274i
            if (r5 <= r2) goto L17
            r3.f14274i = r5
            boolean r2 = r3.m14649b(r4)
            if (r2 == 0) goto L17
            r3.m14637a(r4, r0)
        L11:
            r3.f14274i = r5
            r3.m14631d(r4)
            return r0
        L17:
            r0 = r1
            goto L11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.androidsdk.security.PasscodeManager.m14643a(android.content.Context, int):boolean");
    }

    /* JADX INFO: renamed from: i */
    public boolean m14658i() {
        return this.f14273h > 0 && m14660k() >= this.f14272g + ((long) this.f14273h);
    }

    /* JADX INFO: renamed from: a */
    public void m14637a(Context context, boolean z) {
        this.f14266a = true;
        if (context != null) {
            Intent intent = new Intent(context, SalesforceSDKManager.m14403a().m14444i());
            intent.addFlags(536870912);
            intent.addFlags(1073741824);
            intent.addFlags(131072);
            if (context == SalesforceSDKManager.m14403a().m14446k()) {
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            }
            intent.putExtra("change_passcode", z);
            if (context instanceof Activity) {
                ((Activity) context).startActivityForResult(intent, 777);
            } else {
                context.startActivity(intent);
            }
        }
        EventsObservable.m15006a().m15008a(EventsObservable.EventType.AppLocked);
    }

    /* JADX INFO: renamed from: a */
    public void m14639a(String str) {
        this.f14267b = m14651c(str);
        m14659j();
    }

    /* JADX INFO: renamed from: j */
    public void m14659j() {
        EventBuilderHelper.m14288a("passcodeUnlock", null, "PasscodeManager", null);
        this.f14266a = false;
        m14629b(0);
        m14633l();
        EventsObservable.m15006a().m15008a(EventsObservable.EventType.AppUnlocked);
    }

    /* JADX INFO: renamed from: k */
    protected long m14660k() {
        return System.currentTimeMillis();
    }

    /* JADX INFO: renamed from: l */
    private void m14633l() {
        this.f14272g = m14660k();
    }

    /* JADX INFO: renamed from: b */
    public String m14646b(String str) {
        return m14628a(str, this.f14268c);
    }

    /* JADX INFO: renamed from: c */
    public String m14651c(String str) {
        return m14628a(str, this.f14269d);
    }

    /* JADX INFO: renamed from: a */
    private String m14628a(String str, HashConfig hashConfig) {
        return Encryptor.m14375d(hashConfig.f14276a + str + hashConfig.f14277b, hashConfig.f14278c);
    }

    private class LockChecker implements Runnable {
        private LockChecker() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (!PasscodeManager.this.f14266a) {
                    PasscodeManager.this.m14642a((Activity) null, false);
                }
            } finally {
                if (PasscodeManager.this.f14271f != null) {
                    PasscodeManager.this.f14271f.postDelayed(this, 20000L);
                }
            }
        }
    }

    public static class HashConfig {

        /* JADX INFO: renamed from: a */
        public final String f14276a;

        /* JADX INFO: renamed from: b */
        public final String f14277b;

        /* JADX INFO: renamed from: c */
        public final String f14278c;

        public HashConfig(String str, String str2, String str3) {
            this.f14276a = str;
            this.f14277b = str2;
            this.f14278c = str3;
        }
    }

    private static class PasscodeFileFilter implements FilenameFilter {
        private PasscodeFileFilter() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str != null && str.startsWith("mobile_policy_");
        }
    }
}
