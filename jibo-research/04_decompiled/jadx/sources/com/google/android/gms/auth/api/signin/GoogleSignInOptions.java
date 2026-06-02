package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.internal.zzn;
import com.google.android.gms.auth.api.signin.internal.zzp;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import com.google.api.client.googleapis.extensions.android.accounts.GoogleAccountManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class GoogleSignInOptions extends zzbfm implements Api.ApiOptions.Optional, ReflectedParcelable {

    /* JADX INFO: renamed from: h */
    private int f6003h;

    /* JADX INFO: renamed from: i */
    private final ArrayList<Scope> f6004i;

    /* JADX INFO: renamed from: j */
    private Account f6005j;

    /* JADX INFO: renamed from: k */
    private boolean f6006k;

    /* JADX INFO: renamed from: l */
    private final boolean f6007l;

    /* JADX INFO: renamed from: m */
    private final boolean f6008m;

    /* JADX INFO: renamed from: n */
    private String f6009n;

    /* JADX INFO: renamed from: o */
    private String f6010o;

    /* JADX INFO: renamed from: p */
    private ArrayList<zzn> f6011p;

    /* JADX INFO: renamed from: q */
    private Map<Integer, zzn> f6012q;

    /* JADX INFO: renamed from: a */
    public static final Scope f5995a = new Scope("profile");

    /* JADX INFO: renamed from: b */
    public static final Scope f5996b = new Scope("email");

    /* JADX INFO: renamed from: c */
    public static final Scope f5997c = new Scope("openid");

    /* JADX INFO: renamed from: d */
    public static final Scope f5998d = new Scope("https://www.googleapis.com/auth/games_lite");

    /* JADX INFO: renamed from: e */
    public static final Scope f5999e = new Scope("https://www.googleapis.com/auth/games");

    /* JADX INFO: renamed from: f */
    public static final GoogleSignInOptions f6000f = new Builder().m6753a().m6755b().m6756c();

    /* JADX INFO: renamed from: g */
    public static final GoogleSignInOptions f6001g = new Builder().m6754a(f5998d, new Scope[0]).m6756c();
    public static final Parcelable.Creator<GoogleSignInOptions> CREATOR = new zze();

    /* JADX INFO: renamed from: r */
    private static Comparator<Scope> f6002r = new zzd();

    public static final class Builder {

        /* JADX INFO: renamed from: a */
        private Set<Scope> f6013a;

        /* JADX INFO: renamed from: b */
        private boolean f6014b;

        /* JADX INFO: renamed from: c */
        private boolean f6015c;

        /* JADX INFO: renamed from: d */
        private boolean f6016d;

        /* JADX INFO: renamed from: e */
        private String f6017e;

        /* JADX INFO: renamed from: f */
        private Account f6018f;

        /* JADX INFO: renamed from: g */
        private String f6019g;

        /* JADX INFO: renamed from: h */
        private Map<Integer, zzn> f6020h;

        public Builder() {
            this.f6013a = new HashSet();
            this.f6020h = new HashMap();
        }

        public Builder(GoogleSignInOptions googleSignInOptions) {
            this.f6013a = new HashSet();
            this.f6020h = new HashMap();
            zzbq.m7373a(googleSignInOptions);
            this.f6013a = new HashSet(googleSignInOptions.f6004i);
            this.f6014b = googleSignInOptions.f6007l;
            this.f6015c = googleSignInOptions.f6008m;
            this.f6016d = googleSignInOptions.f6006k;
            this.f6017e = googleSignInOptions.f6009n;
            this.f6018f = googleSignInOptions.f6005j;
            this.f6019g = googleSignInOptions.f6010o;
            this.f6020h = GoogleSignInOptions.m6742b(googleSignInOptions.f6011p);
        }

        /* JADX INFO: renamed from: a */
        public final Builder m6753a() {
            this.f6013a.add(GoogleSignInOptions.f5997c);
            return this;
        }

        /* JADX INFO: renamed from: a */
        public final Builder m6754a(Scope scope, Scope... scopeArr) {
            this.f6013a.add(scope);
            this.f6013a.addAll(Arrays.asList(scopeArr));
            return this;
        }

        /* JADX INFO: renamed from: b */
        public final Builder m6755b() {
            this.f6013a.add(GoogleSignInOptions.f5995a);
            return this;
        }

        /* JADX INFO: renamed from: c */
        public final GoogleSignInOptions m6756c() {
            if (this.f6013a.contains(GoogleSignInOptions.f5999e) && this.f6013a.contains(GoogleSignInOptions.f5998d)) {
                this.f6013a.remove(GoogleSignInOptions.f5998d);
            }
            if (this.f6016d && (this.f6018f == null || !this.f6013a.isEmpty())) {
                m6753a();
            }
            return new GoogleSignInOptions(3, new ArrayList(this.f6013a), this.f6018f, this.f6016d, this.f6014b, this.f6015c, this.f6017e, this.f6019g, this.f6020h, null);
        }
    }

    GoogleSignInOptions(int i, ArrayList<Scope> arrayList, Account account, boolean z, boolean z2, boolean z3, String str, String str2, ArrayList<zzn> arrayList2) {
        this(i, arrayList, account, z, z2, z3, str, str2, m6742b(arrayList2));
    }

    private GoogleSignInOptions(int i, ArrayList<Scope> arrayList, Account account, boolean z, boolean z2, boolean z3, String str, String str2, Map<Integer, zzn> map) {
        this.f6003h = i;
        this.f6004i = arrayList;
        this.f6005j = account;
        this.f6006k = z;
        this.f6007l = z2;
        this.f6008m = z3;
        this.f6009n = str;
        this.f6010o = str2;
        this.f6011p = new ArrayList<>(map.values());
        this.f6012q = map;
    }

    /* synthetic */ GoogleSignInOptions(int i, ArrayList arrayList, Account account, boolean z, boolean z2, boolean z3, String str, String str2, Map map, zzd zzdVar) {
        this(3, (ArrayList<Scope>) arrayList, account, z, z2, z3, str, str2, (Map<Integer, zzn>) map);
    }

    /* JADX INFO: renamed from: a */
    public static GoogleSignInOptions m6739a(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("scopes");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            hashSet.add(new Scope(jSONArray.getString(i)));
        }
        String strOptString = jSONObject.optString("accountName", null);
        return new GoogleSignInOptions(3, (ArrayList<Scope>) new ArrayList(hashSet), !TextUtils.isEmpty(strOptString) ? new Account(strOptString, GoogleAccountManager.ACCOUNT_TYPE) : null, jSONObject.getBoolean("idTokenRequested"), jSONObject.getBoolean("serverAuthRequested"), jSONObject.getBoolean("forceCodeForRefreshToken"), jSONObject.optString("serverClientId", null), jSONObject.optString("hostedDomain", null), new HashMap());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public static Map<Integer, zzn> m6742b(List<zzn> list) {
        HashMap map = new HashMap();
        if (list == null) {
            return map;
        }
        for (zzn zznVar : list) {
            map.put(Integer.valueOf(zznVar.m6780a()), zznVar);
        }
        return map;
    }

    /* JADX INFO: renamed from: c */
    private final JSONObject m6744c() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            Collections.sort(this.f6004i, f6002r);
            ArrayList<Scope> arrayList = this.f6004i;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Scope scope = arrayList.get(i);
                i++;
                jSONArray.put(scope.m6933a());
            }
            jSONObject.put("scopes", jSONArray);
            if (this.f6005j != null) {
                jSONObject.put("accountName", this.f6005j.name);
            }
            jSONObject.put("idTokenRequested", this.f6006k);
            jSONObject.put("forceCodeForRefreshToken", this.f6008m);
            jSONObject.put("serverAuthRequested", this.f6007l);
            if (!TextUtils.isEmpty(this.f6009n)) {
                jSONObject.put("serverClientId", this.f6009n);
            }
            if (!TextUtils.isEmpty(this.f6010o)) {
                jSONObject.put("hostedDomain", this.f6010o);
            }
            return jSONObject;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: renamed from: a */
    public final ArrayList<Scope> m6751a() {
        return new ArrayList<>(this.f6004i);
    }

    /* JADX INFO: renamed from: b */
    public final String m6752b() {
        return m6744c().toString();
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            GoogleSignInOptions googleSignInOptions = (GoogleSignInOptions) obj;
            if (this.f6011p.size() > 0 || googleSignInOptions.f6011p.size() > 0 || this.f6004i.size() != googleSignInOptions.m6751a().size() || !this.f6004i.containsAll(googleSignInOptions.m6751a())) {
                return false;
            }
            if (this.f6005j == null) {
                if (googleSignInOptions.f6005j != null) {
                    return false;
                }
            } else if (!this.f6005j.equals(googleSignInOptions.f6005j)) {
                return false;
            }
            if (TextUtils.isEmpty(this.f6009n)) {
                if (!TextUtils.isEmpty(googleSignInOptions.f6009n)) {
                    return false;
                }
            } else if (!this.f6009n.equals(googleSignInOptions.f6009n)) {
                return false;
            }
            if (this.f6008m == googleSignInOptions.f6008m && this.f6006k == googleSignInOptions.f6006k) {
                return this.f6007l == googleSignInOptions.f6007l;
            }
            return false;
        } catch (ClassCastException e) {
            return false;
        }
    }

    public int hashCode() {
        ArrayList arrayList = new ArrayList();
        ArrayList<Scope> arrayList2 = this.f6004i;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Scope scope = arrayList2.get(i);
            i++;
            arrayList.add(scope.m6933a());
        }
        Collections.sort(arrayList);
        return new zzp().m6786a(arrayList).m6786a(this.f6005j).m6786a(this.f6009n).m6787a(this.f6008m).m6787a(this.f6006k).m6787a(this.f6007l).m6785a();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7738a(parcel, 1, this.f6003h);
        zzbfp.m7762c(parcel, 2, m6751a(), false);
        zzbfp.m7743a(parcel, 3, (Parcelable) this.f6005j, i, false);
        zzbfp.m7751a(parcel, 4, this.f6006k);
        zzbfp.m7751a(parcel, 5, this.f6007l);
        zzbfp.m7751a(parcel, 6, this.f6008m);
        zzbfp.m7748a(parcel, 7, this.f6009n, false);
        zzbfp.m7748a(parcel, 8, this.f6010o, false);
        zzbfp.m7762c(parcel, 9, this.f6011p, false);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
