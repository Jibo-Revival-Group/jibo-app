package com.salesforce.androidsdk.smartstore.store;

import com.facebook.share.internal.ShareConstants;
import com.salesforce.androidsdk.smartstore.store.SmartStore;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class IndexSpec {

    /* JADX INFO: renamed from: a */
    public final String f14308a;

    /* JADX INFO: renamed from: b */
    public final SmartStore.Type f14309b;

    /* JADX INFO: renamed from: c */
    public final String f14310c;

    public IndexSpec(String str, SmartStore.Type type) {
        this.f14308a = str;
        this.f14309b = type;
        this.f14310c = null;
    }

    public IndexSpec(String str, SmartStore.Type type, String str2) {
        this.f14308a = str;
        this.f14309b = type;
        this.f14310c = str2;
    }

    public int hashCode() {
        int iHashCode = ((this.f14308a.hashCode() + 527) * 31) + this.f14309b.hashCode();
        if (this.f14310c != null) {
            return (iHashCode * 31) + this.f14310c.hashCode();
        }
        return iHashCode;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof IndexSpec)) {
            return false;
        }
        IndexSpec indexSpec = (IndexSpec) obj;
        boolean z2 = (this.f14308a.equals(indexSpec.f14308a)) && this.f14309b.equals(indexSpec.f14309b);
        if (this.f14310c == null) {
            if (!z2 || this.f14310c != indexSpec.f14310c) {
                z = false;
            }
        } else if (!z2 || !this.f14310c.equals(indexSpec.f14310c)) {
            z = false;
        }
        return z;
    }

    /* JADX INFO: renamed from: a */
    public String m14743a() {
        return this.f14308a + "|" + this.f14309b;
    }

    /* JADX INFO: renamed from: a */
    public static IndexSpec[] m14740a(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(m14738a(jSONArray.getJSONObject(i)));
        }
        return (IndexSpec[]) arrayList.toArray(new IndexSpec[0]);
    }

    /* JADX INFO: renamed from: a */
    public static IndexSpec m14738a(JSONObject jSONObject) throws JSONException {
        return new IndexSpec(jSONObject.getString("path"), SmartStore.Type.valueOf(jSONObject.getString(ShareConstants.MEDIA_TYPE)), jSONObject.optString("columnName"));
    }

    /* JADX INFO: renamed from: a */
    public static Map<String, IndexSpec> m14739a(IndexSpec[] indexSpecArr) {
        HashMap map = new HashMap();
        for (IndexSpec indexSpec : indexSpecArr) {
            map.put(indexSpec.f14308a, indexSpec);
        }
        return map;
    }

    /* JADX INFO: renamed from: b */
    public static boolean m14741b(IndexSpec[] indexSpecArr) {
        for (IndexSpec indexSpec : indexSpecArr) {
            if (indexSpec.f14309b == SmartStore.Type.full_text) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: c */
    public static boolean m14742c(IndexSpec[] indexSpecArr) {
        for (IndexSpec indexSpec : indexSpecArr) {
            if (indexSpec.f14309b == SmartStore.Type.json1) {
                return true;
            }
        }
        return false;
    }
}
