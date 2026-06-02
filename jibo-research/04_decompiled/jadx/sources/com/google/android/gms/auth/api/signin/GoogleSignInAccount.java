package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.util.zzh;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import com.google.api.client.googleapis.extensions.android.accounts.GoogleAccountManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class GoogleSignInAccount extends zzbfm implements ReflectedParcelable {
    public static final Parcelable.Creator<GoogleSignInAccount> CREATOR = new zzb();

    /* JADX INFO: renamed from: a */
    private static com.google.android.gms.common.util.zzd f5981a = zzh.m7501d();

    /* JADX INFO: renamed from: b */
    private int f5982b;

    /* JADX INFO: renamed from: c */
    private String f5983c;

    /* JADX INFO: renamed from: d */
    private String f5984d;

    /* JADX INFO: renamed from: e */
    private String f5985e;

    /* JADX INFO: renamed from: f */
    private String f5986f;

    /* JADX INFO: renamed from: g */
    private Uri f5987g;

    /* JADX INFO: renamed from: h */
    private String f5988h;

    /* JADX INFO: renamed from: i */
    private long f5989i;

    /* JADX INFO: renamed from: j */
    private String f5990j;

    /* JADX INFO: renamed from: k */
    private List<Scope> f5991k;

    /* JADX INFO: renamed from: l */
    private String f5992l;

    /* JADX INFO: renamed from: m */
    private String f5993m;

    /* JADX INFO: renamed from: n */
    private Set<Scope> f5994n = new HashSet();

    GoogleSignInAccount(int i, String str, String str2, String str3, String str4, Uri uri, String str5, long j, String str6, List<Scope> list, String str7, String str8) {
        this.f5982b = i;
        this.f5983c = str;
        this.f5984d = str2;
        this.f5985e = str3;
        this.f5986f = str4;
        this.f5987g = uri;
        this.f5988h = str5;
        this.f5989i = j;
        this.f5990j = str6;
        this.f5991k = list;
        this.f5992l = str7;
        this.f5993m = str8;
    }

    /* JADX INFO: renamed from: a */
    public static GoogleSignInAccount m6723a(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        String strOptString = jSONObject.optString("photoUrl", null);
        Uri uri = !TextUtils.isEmpty(strOptString) ? Uri.parse(strOptString) : null;
        long j = Long.parseLong(jSONObject.getString("expirationTime"));
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            hashSet.add(new Scope(jSONArray.getString(i)));
        }
        GoogleSignInAccount googleSignInAccountM6724a = m6724a(jSONObject.optString(ShareConstants.WEB_DIALOG_PARAM_ID), jSONObject.optString("tokenId", null), jSONObject.optString("email", null), jSONObject.optString("displayName", null), jSONObject.optString("givenName", null), jSONObject.optString("familyName", null), uri, Long.valueOf(j), jSONObject.getString("obfuscatedIdentifier"), hashSet);
        googleSignInAccountM6724a.f5988h = jSONObject.optString("serverAuthCode", null);
        return googleSignInAccountM6724a;
    }

    /* JADX INFO: renamed from: a */
    private static GoogleSignInAccount m6724a(String str, String str2, String str3, String str4, String str5, String str6, Uri uri, Long l, String str7, Set<Scope> set) {
        if (l == null) {
            l = Long.valueOf(f5981a.mo7496a() / 1000);
        }
        return new GoogleSignInAccount(3, str, str2, str3, str4, uri, null, l.longValue(), zzbq.m7375a(str7), new ArrayList((Collection) zzbq.m7373a(set)), str5, str6);
    }

    /* JADX INFO: renamed from: m */
    private final JSONObject m6725m() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (m6726a() != null) {
                jSONObject.put(ShareConstants.WEB_DIALOG_PARAM_ID, m6726a());
            }
            if (m6727b() != null) {
                jSONObject.put("tokenId", m6727b());
            }
            if (m6728c() != null) {
                jSONObject.put("email", m6728c());
            }
            if (m6730e() != null) {
                jSONObject.put("displayName", m6730e());
            }
            if (m6731f() != null) {
                jSONObject.put("givenName", m6731f());
            }
            if (m6732g() != null) {
                jSONObject.put("familyName", m6732g());
            }
            if (m6733h() != null) {
                jSONObject.put("photoUrl", m6733h().toString());
            }
            if (m6734i() != null) {
                jSONObject.put("serverAuthCode", m6734i());
            }
            jSONObject.put("expirationTime", this.f5989i);
            jSONObject.put("obfuscatedIdentifier", this.f5990j);
            JSONArray jSONArray = new JSONArray();
            Scope[] scopeArr = (Scope[]) this.f5991k.toArray(new Scope[this.f5991k.size()]);
            Arrays.sort(scopeArr, zza.f6052a);
            for (Scope scope : scopeArr) {
                jSONArray.put(scope.m6933a());
            }
            jSONObject.put("grantedScopes", jSONArray);
            return jSONObject;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: renamed from: a */
    public String m6726a() {
        return this.f5983c;
    }

    /* JADX INFO: renamed from: b */
    public String m6727b() {
        return this.f5984d;
    }

    /* JADX INFO: renamed from: c */
    public String m6728c() {
        return this.f5985e;
    }

    /* JADX INFO: renamed from: d */
    public Account m6729d() {
        if (this.f5985e == null) {
            return null;
        }
        return new Account(this.f5985e, GoogleAccountManager.ACCOUNT_TYPE);
    }

    /* JADX INFO: renamed from: e */
    public String m6730e() {
        return this.f5986f;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GoogleSignInAccount)) {
            return false;
        }
        GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) obj;
        return googleSignInAccount.f5990j.equals(this.f5990j) && googleSignInAccount.m6736k().equals(m6736k());
    }

    /* JADX INFO: renamed from: f */
    public String m6731f() {
        return this.f5992l;
    }

    /* JADX INFO: renamed from: g */
    public String m6732g() {
        return this.f5993m;
    }

    /* JADX INFO: renamed from: h */
    public Uri m6733h() {
        return this.f5987g;
    }

    public int hashCode() {
        return ((this.f5990j.hashCode() + 527) * 31) + m6736k().hashCode();
    }

    /* JADX INFO: renamed from: i */
    public String m6734i() {
        return this.f5988h;
    }

    /* JADX INFO: renamed from: j */
    public final String m6735j() {
        return this.f5990j;
    }

    /* JADX INFO: renamed from: k */
    public final Set<Scope> m6736k() {
        HashSet hashSet = new HashSet(this.f5991k);
        hashSet.addAll(this.f5994n);
        return hashSet;
    }

    /* JADX INFO: renamed from: l */
    public final String m6737l() {
        JSONObject jSONObjectM6725m = m6725m();
        jSONObjectM6725m.remove("serverAuthCode");
        return jSONObjectM6725m.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7738a(parcel, 1, this.f5982b);
        zzbfp.m7748a(parcel, 2, m6726a(), false);
        zzbfp.m7748a(parcel, 3, m6727b(), false);
        zzbfp.m7748a(parcel, 4, m6728c(), false);
        zzbfp.m7748a(parcel, 5, m6730e(), false);
        zzbfp.m7743a(parcel, 6, (Parcelable) m6733h(), i, false);
        zzbfp.m7748a(parcel, 7, m6734i(), false);
        zzbfp.m7739a(parcel, 8, this.f5989i);
        zzbfp.m7748a(parcel, 9, this.f5990j, false);
        zzbfp.m7762c(parcel, 10, this.f5991k, false);
        zzbfp.m7748a(parcel, 11, m6731f(), false);
        zzbfp.m7748a(parcel, 12, m6732g(), false);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
