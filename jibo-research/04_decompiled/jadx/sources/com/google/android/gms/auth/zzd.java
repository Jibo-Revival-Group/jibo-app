package com.google.android.gms.auth;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.internal.zzag;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.zzp;
import com.google.android.gms.internal.zzbgg;
import com.google.api.client.googleapis.extensions.android.accounts.GoogleAccountManager;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class zzd {

    /* JADX INFO: renamed from: c */
    private static String[] f6058c = {GoogleAccountManager.ACCOUNT_TYPE, "com.google.work", "cn.google"};

    /* JADX INFO: renamed from: a */
    @SuppressLint({"InlinedApi"})
    public static final String f6056a = "callerUid";

    /* JADX INFO: renamed from: b */
    @SuppressLint({"InlinedApi"})
    public static final String f6057b = "androidPackageName";

    /* JADX INFO: renamed from: d */
    private static final ComponentName f6059d = new ComponentName("com.google.android.gms", "com.google.android.gms.auth.GetToken");

    /* JADX INFO: renamed from: e */
    private static final zzbgg f6060e = new zzbgg("Auth", "GoogleAuthUtil");

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX INFO: renamed from: a */
    private static <T> T m6807a(Context context, ComponentName componentName, zzj<T> zzjVar) throws IOException, GoogleAuthException {
        com.google.android.gms.common.zza zzaVar = new com.google.android.gms.common.zza();
        zzag zzagVarM7326a = zzag.m7326a(context);
        try {
            if (!zzagVarM7326a.m7328a(componentName, zzaVar, "GoogleAuthUtil")) {
                throw new IOException("Could not bind to service.");
            }
            try {
                return zzjVar.mo6817a(zzaVar.m7526a());
            } catch (RemoteException | InterruptedException e) {
                f6060e.m7773b("GoogleAuthUtil", "Error on service connection.", e);
                throw new IOException("Error on service connection.", e);
            }
        } finally {
            zzagVarM7326a.m7330b(componentName, zzaVar, "GoogleAuthUtil");
        }
    }

    /* JADX INFO: renamed from: a */
    public static String m6809a(Context context, Account account, String str) throws IOException, GoogleAuthException {
        return m6810a(context, account, str, new Bundle());
    }

    /* JADX INFO: renamed from: a */
    public static String m6810a(Context context, Account account, String str, Bundle bundle) throws IOException, GoogleAuthException {
        m6811a(account);
        return m6813b(context, account, str, bundle).m6672a();
    }

    /* JADX INFO: renamed from: a */
    private static void m6811a(Account account) {
        if (account == null) {
            throw new IllegalArgumentException("Account cannot be null");
        }
        if (TextUtils.isEmpty(account.name)) {
            throw new IllegalArgumentException("Account name cannot be empty!");
        }
        for (String str : f6058c) {
            if (str.equals(account.type)) {
                return;
            }
        }
        throw new IllegalArgumentException("Account type not supported");
    }

    /* JADX INFO: renamed from: a */
    private static void m6812a(Context context) throws GoogleAuthException {
        try {
            zzp.zzbp(context.getApplicationContext());
        } catch (GooglePlayServicesNotAvailableException e) {
            throw new GoogleAuthException(e.getMessage());
        } catch (GooglePlayServicesRepairableException e2) {
            throw new GooglePlayServicesAvailabilityException(e2.m6846a(), e2.getMessage(), e2.m6849b());
        }
    }

    /* JADX INFO: renamed from: b */
    public static TokenData m6813b(Context context, Account account, String str, Bundle bundle) throws GoogleAuthException, IOException {
        zzbq.m7385c("Calling this from your main thread can lead to deadlock");
        zzbq.m7376a(str, (Object) "Scope cannot be empty or null.");
        m6811a(account);
        m6812a(context);
        Bundle bundle2 = bundle == null ? new Bundle() : new Bundle(bundle);
        String str2 = context.getApplicationInfo().packageName;
        bundle2.putString("clientPackageName", str2);
        if (TextUtils.isEmpty(bundle2.getString(f6057b))) {
            bundle2.putString(f6057b, str2);
        }
        bundle2.putLong("service_connection_start_time_millis", SystemClock.elapsedRealtime());
        return (TokenData) m6807a(context, f6059d, new zze(account, str, bundle2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public static <T> T m6814b(T t) throws IOException {
        if (t != null) {
            return t;
        }
        f6060e.m7774c("GoogleAuthUtil", "Binder call returned null.");
        throw new IOException("Service unavailable.");
    }

    @Deprecated
    /* JADX INFO: renamed from: b */
    public static String m6815b(Context context, String str, String str2) throws IOException, GoogleAuthException {
        return m6809a(context, new Account(str, GoogleAccountManager.ACCOUNT_TYPE), str2);
    }

    @Deprecated
    /* JADX INFO: renamed from: b */
    public static void m6816b(Context context, String str) {
        AccountManager.get(context).invalidateAuthToken(GoogleAccountManager.ACCOUNT_TYPE, str);
    }
}
