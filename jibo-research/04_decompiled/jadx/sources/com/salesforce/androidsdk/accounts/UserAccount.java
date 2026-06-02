package com.salesforce.androidsdk.accounts;

import android.os.Bundle;
import android.text.TextUtils;
import com.salesforce.androidsdk.app.SalesforceSDKManager;
import com.salesforce.androidsdk.util.MapUtil;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class UserAccount {

    /* JADX INFO: renamed from: a */
    private String f13966a;

    /* JADX INFO: renamed from: b */
    private String f13967b;

    /* JADX INFO: renamed from: c */
    private String f13968c;

    /* JADX INFO: renamed from: d */
    private String f13969d;

    /* JADX INFO: renamed from: e */
    private String f13970e;

    /* JADX INFO: renamed from: f */
    private String f13971f;

    /* JADX INFO: renamed from: g */
    private String f13972g;

    /* JADX INFO: renamed from: h */
    private String f13973h;

    /* JADX INFO: renamed from: i */
    private String f13974i;

    /* JADX INFO: renamed from: j */
    private String f13975j;

    /* JADX INFO: renamed from: k */
    private String f13976k;

    /* JADX INFO: renamed from: l */
    private String f13977l;

    /* JADX INFO: renamed from: m */
    private String f13978m;

    /* JADX INFO: renamed from: n */
    private String f13979n;

    /* JADX INFO: renamed from: o */
    private String f13980o;

    /* JADX INFO: renamed from: p */
    private String f13981p;

    /* JADX INFO: renamed from: q */
    private String f13982q;

    /* JADX INFO: renamed from: r */
    private String f13983r;

    /* JADX INFO: renamed from: s */
    private Map<String, String> f13984s;

    public UserAccount(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, Map<String, String> map) {
        this.f13966a = str;
        this.f13967b = str2;
        this.f13968c = str3;
        this.f13969d = str4;
        this.f13970e = str5;
        this.f13971f = str6;
        this.f13972g = str7;
        this.f13973h = str8;
        this.f13974i = str9;
        this.f13975j = str10;
        this.f13976k = str11;
        this.f13977l = str12;
        this.f13978m = str13;
        this.f13979n = str14;
        this.f13980o = str15;
        this.f13981p = str16;
        this.f13982q = str17;
        this.f13983r = str18;
        this.f13984s = map;
        SalesforceSDKManager.m14403a().m14439e("UA");
    }

    public UserAccount(Bundle bundle) {
        if (bundle != null) {
            this.f13966a = bundle.getString("authToken");
            this.f13967b = bundle.getString("refreshToken");
            this.f13968c = bundle.getString("loginServer");
            this.f13969d = bundle.getString("idUrl");
            this.f13970e = bundle.getString("instanceServer");
            this.f13971f = bundle.getString("orgId");
            this.f13972g = bundle.getString("userId");
            this.f13973h = bundle.getString("username");
            this.f13975j = bundle.getString("clientId");
            this.f13974i = bundle.getString("accountName");
            this.f13976k = bundle.getString("communityId");
            this.f13977l = bundle.getString("communityUrl");
            this.f13978m = bundle.getString("first_name");
            this.f13979n = bundle.getString("last_name");
            this.f13980o = bundle.getString("display_name");
            this.f13981p = bundle.getString("email");
            this.f13982q = bundle.getString("photoUrl");
            this.f13983r = bundle.getString("thumbnailUrl");
            this.f13984s = MapUtil.m15013a(bundle, SalesforceSDKManager.m14403a().m14457v(), this.f13984s);
        }
    }

    /* JADX INFO: renamed from: a */
    public String m14240a() {
        return this.f13966a;
    }

    /* JADX INFO: renamed from: b */
    public String m14242b() {
        return this.f13967b;
    }

    /* JADX INFO: renamed from: c */
    public String m14243c() {
        return this.f13968c;
    }

    /* JADX INFO: renamed from: d */
    public String m14244d() {
        return this.f13969d;
    }

    /* JADX INFO: renamed from: e */
    public String m14245e() {
        return this.f13970e;
    }

    /* JADX INFO: renamed from: f */
    public String m14246f() {
        return this.f13971f;
    }

    /* JADX INFO: renamed from: g */
    public String m14247g() {
        return this.f13972g;
    }

    /* JADX INFO: renamed from: h */
    public String m14248h() {
        return this.f13973h;
    }

    /* JADX INFO: renamed from: i */
    public String m14249i() {
        return this.f13974i;
    }

    /* JADX INFO: renamed from: j */
    public String m14250j() {
        return this.f13975j;
    }

    /* JADX INFO: renamed from: k */
    public String m14251k() {
        return this.f13976k;
    }

    /* JADX INFO: renamed from: l */
    public String m14252l() {
        return this.f13977l;
    }

    /* JADX INFO: renamed from: m */
    public String m14253m() {
        return this.f13978m;
    }

    /* JADX INFO: renamed from: n */
    public String m14254n() {
        return this.f13980o;
    }

    /* JADX INFO: renamed from: o */
    public String m14255o() {
        return this.f13979n;
    }

    /* JADX INFO: renamed from: p */
    public String m14256p() {
        return this.f13981p;
    }

    /* JADX INFO: renamed from: q */
    public String m14257q() {
        return this.f13982q;
    }

    /* JADX INFO: renamed from: r */
    public String m14258r() {
        return this.f13983r;
    }

    /* JADX INFO: renamed from: s */
    public Map<String, String> m14259s() {
        return this.f13984s;
    }

    /* JADX INFO: renamed from: t */
    public String m14260t() {
        StringBuffer stringBuffer = new StringBuffer("_");
        stringBuffer.append(this.f13971f);
        return stringBuffer.toString();
    }

    /* JADX INFO: renamed from: u */
    public String m14261u() {
        StringBuffer stringBuffer = new StringBuffer("_");
        stringBuffer.append(this.f13971f);
        stringBuffer.append("_");
        stringBuffer.append(this.f13972g);
        return stringBuffer.toString();
    }

    /* JADX INFO: renamed from: v */
    public String m14262v() {
        String str = "internal";
        if (!TextUtils.isEmpty(this.f13976k) && !this.f13976k.equals("000000000000000AAA")) {
            str = this.f13976k;
        }
        return m14241a(str);
    }

    /* JADX INFO: renamed from: a */
    public String m14241a(String str) {
        StringBuffer stringBuffer = new StringBuffer("_");
        stringBuffer.append(this.f13971f);
        stringBuffer.append("_");
        stringBuffer.append(this.f13972g);
        stringBuffer.append("_");
        if (TextUtils.isEmpty(str) || str.equals("000000000000000AAA")) {
            str = "internal";
        }
        stringBuffer.append(str);
        return stringBuffer.toString();
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof UserAccount)) {
            return false;
        }
        UserAccount userAccount = (UserAccount) obj;
        return (this.f13972g == null || this.f13971f == null || userAccount.m14247g() == null || userAccount.m14246f() == null || !userAccount.m14247g().equals(this.f13972g) || !userAccount.m14246f().equals(this.f13971f)) ? false : true;
    }

    public int hashCode() {
        int iHashCode = this.f13972g.hashCode();
        return iHashCode ^ (this.f13971f.hashCode() + (iHashCode * 37));
    }

    /* JADX INFO: renamed from: w */
    public Bundle m14263w() {
        Bundle bundle = new Bundle();
        bundle.putString("authToken", this.f13966a);
        bundle.putString("refreshToken", this.f13967b);
        bundle.putString("loginServer", this.f13968c);
        bundle.putString("idUrl", this.f13969d);
        bundle.putString("instanceServer", this.f13970e);
        bundle.putString("orgId", this.f13971f);
        bundle.putString("userId", this.f13972g);
        bundle.putString("username", this.f13973h);
        bundle.putString("clientId", this.f13975j);
        bundle.putString("accountName", this.f13974i);
        bundle.putString("communityId", this.f13976k);
        bundle.putString("communityUrl", this.f13977l);
        bundle.putString("first_name", this.f13978m);
        bundle.putString("last_name", this.f13979n);
        bundle.putString("display_name", this.f13980o);
        bundle.putString("email", this.f13981p);
        bundle.putString("photoUrl", this.f13982q);
        bundle.putString("thumbnailUrl", this.f13983r);
        return MapUtil.m15012a(this.f13984s, SalesforceSDKManager.m14403a().m14457v(), bundle);
    }
}
