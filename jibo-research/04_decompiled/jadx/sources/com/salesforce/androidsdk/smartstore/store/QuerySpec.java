package com.salesforce.androidsdk.smartstore.store;

import android.text.TextUtils;
import com.salesforce.androidsdk.smartstore.store.SmartStore;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class QuerySpec {

    /* JADX INFO: renamed from: a */
    public final QueryType f14311a;

    /* JADX INFO: renamed from: b */
    public final int f14312b;

    /* JADX INFO: renamed from: c */
    public final String f14313c;

    /* JADX INFO: renamed from: d */
    public final String f14314d;

    /* JADX INFO: renamed from: e */
    public final String f14315e;

    /* JADX INFO: renamed from: f */
    public final String f14316f;

    /* JADX INFO: renamed from: g */
    public final String[] f14317g;

    /* JADX INFO: renamed from: h */
    public final String f14318h;

    /* JADX INFO: renamed from: i */
    public final String f14319i;

    /* JADX INFO: renamed from: j */
    public final Order f14320j;

    /* JADX INFO: renamed from: k */
    public final String f14321k;

    /* JADX INFO: renamed from: l */
    public final String f14322l;

    /* JADX INFO: renamed from: m */
    public final String f14323m;

    /* JADX INFO: renamed from: n */
    public final String f14324n;

    public enum QueryType {
        exact,
        range,
        like,
        match,
        smart
    }

    private QuerySpec(String str, String[] strArr, QueryType queryType, String str2, String str3, String str4, String str5, String str6, Order order, int i, String str7) {
        this.f14316f = str;
        this.f14317g = strArr;
        this.f14318h = str7;
        this.f14311a = queryType;
        this.f14321k = str2;
        this.f14322l = str3;
        this.f14323m = str4;
        this.f14324n = str5;
        this.f14319i = str6;
        this.f14320j = order;
        this.f14312b = i;
        this.f14313c = m14751b();
        this.f14314d = m14753c();
        this.f14315e = m14755d();
    }

    private QuerySpec(String str, int i) {
        this.f14313c = str;
        this.f14314d = m14749a(str);
        this.f14315e = m14752b(str);
        this.f14312b = i;
        this.f14311a = QueryType.smart;
        this.f14316f = null;
        this.f14317g = null;
        this.f14318h = null;
        this.f14321k = null;
        this.f14322l = null;
        this.f14323m = null;
        this.f14324n = null;
        this.f14319i = null;
        this.f14320j = null;
    }

    /* JADX INFO: renamed from: a */
    public static QuerySpec m14745a(String str, String str2, Order order, int i) {
        return m14747a(str, null, str2, order, i);
    }

    /* JADX INFO: renamed from: a */
    public static QuerySpec m14747a(String str, String[] strArr, String str2, Order order, int i) {
        return new QuerySpec(str, strArr, QueryType.range, null, null, null, null, str2, order, i, null);
    }

    /* JADX INFO: renamed from: a */
    public static QuerySpec m14746a(String str, String str2, String str3, String str4, Order order, int i) {
        return m14748a(str, null, str2, str3, str4, order, i);
    }

    /* JADX INFO: renamed from: a */
    public static QuerySpec m14748a(String str, String[] strArr, String str2, String str3, String str4, Order order, int i) {
        return new QuerySpec(str, strArr, QueryType.exact, str3, null, null, null, str4, order, i, str2);
    }

    /* JADX INFO: renamed from: a */
    public static QuerySpec m14744a(String str, int i) {
        return new QuerySpec(str, i);
    }

    /* JADX INFO: renamed from: b */
    private String m14751b() {
        return m14756e() + m14757f() + m14758g() + m14759h();
    }

    /* JADX INFO: renamed from: c */
    private String m14753c() {
        return "SELECT count(*) " + m14757f() + m14758g();
    }

    /* JADX INFO: renamed from: a */
    private String m14749a(String str) {
        return String.format("SELECT count(*) FROM (%s)", str);
    }

    /* JADX INFO: renamed from: d */
    private String m14755d() {
        return "SELECT id " + m14757f() + m14758g() + m14759h();
    }

    /* JADX INFO: renamed from: b */
    private String m14752b(String str) {
        return String.format("SELECT id FROM (%s)", str);
    }

    /* JADX INFO: renamed from: e */
    private String m14756e() {
        ArrayList arrayList = new ArrayList();
        for (String str : this.f14317g != null ? this.f14317g : new String[]{"_soup"}) {
            arrayList.add(m14754c(str));
        }
        return "SELECT " + TextUtils.join(", ", arrayList) + " ";
    }

    /* JADX INFO: renamed from: f */
    private String m14757f() {
        return "FROM " + m14760i() + " ";
    }

    /* JADX INFO: renamed from: g */
    private String m14758g() {
        String str;
        if (this.f14318h == null && this.f14311a != QueryType.match) {
            return "";
        }
        String strM14754c = null;
        if (this.f14318h != null) {
            strM14754c = m14754c(this.f14318h);
        }
        switch (this.f14311a) {
            case exact:
                str = strM14754c + " = ? ";
                break;
            case like:
                str = strM14754c + " LIKE ? ";
                break;
            case range:
                if (this.f14322l == null && this.f14323m == null) {
                    str = "";
                } else if (this.f14323m == null) {
                    str = strM14754c + " >= ? ";
                } else if (this.f14322l == null) {
                    str = strM14754c + " <= ? ";
                } else {
                    str = strM14754c + " >= ? AND " + strM14754c + " <= ? ";
                }
                break;
            case match:
                str = m14754c("_soupEntryId") + " IN (SELECT rowid FROM " + m14761j() + " WHERE " + m14761j() + " MATCH '" + m14750a(strM14754c, this.f14321k) + "') ";
                break;
            default:
                throw new SmartStore.SmartStoreException("Fell through switch: " + this.f14311a);
        }
        return str.equals("") ? "" : "WHERE " + str;
    }

    /* JADX INFO: renamed from: a */
    public static String m14750a(String str, String str2) {
        if (str != null) {
            StringBuffer stringBuffer = new StringBuffer();
            Matcher matcher = Pattern.compile("[^\\(\\) ]+").matcher(str2);
            while (matcher.find()) {
                String strGroup = matcher.group();
                String lowerCase = strGroup.toLowerCase();
                if (lowerCase.equals("and") || lowerCase.equals("or") || lowerCase.equals("not") || strGroup.startsWith("{")) {
                    matcher.appendReplacement(stringBuffer, strGroup);
                } else {
                    matcher.appendReplacement(stringBuffer, str + ":" + strGroup);
                }
            }
            matcher.appendTail(stringBuffer);
            return stringBuffer.toString();
        }
        return str2;
    }

    /* JADX INFO: renamed from: h */
    private String m14759h() {
        return (this.f14319i == null || this.f14320j == null) ? "" : "ORDER BY " + m14754c(this.f14319i) + " " + this.f14320j.sql + " ";
    }

    /* JADX INFO: renamed from: i */
    private String m14760i() {
        return "{" + this.f14316f + "}";
    }

    /* JADX INFO: renamed from: j */
    private String m14761j() {
        return m14760i() + "_fts";
    }

    /* JADX INFO: renamed from: c */
    private String m14754c(String str) {
        return "{" + this.f14316f + ":" + str + "}";
    }

    /* JADX INFO: renamed from: a */
    public String[] m14762a() {
        switch (this.f14311a) {
            case exact:
                return new String[]{this.f14321k};
            case like:
                return new String[]{this.f14324n};
            case range:
                if (this.f14322l == null && this.f14323m == null) {
                    return null;
                }
                if (this.f14323m == null) {
                    return new String[]{this.f14322l};
                }
                if (this.f14322l == null) {
                    return new String[]{this.f14323m};
                }
                return new String[]{this.f14322l, this.f14323m};
            case match:
            case smart:
                return null;
            default:
                throw new SmartStore.SmartStoreException("Fell through switch: " + this.f14311a);
        }
    }

    public enum Order {
        ascending("ASC"),
        descending("DESC");

        public final String sql;

        Order(String str) {
            this.sql = str;
        }
    }
}
