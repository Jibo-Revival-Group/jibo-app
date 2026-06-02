package com.salesforce.android.cases.core.internal.local;

import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import com.salesforce.androidsdk.accounts.UserAccount;
import com.salesforce.androidsdk.smartstore.app.SmartStoreSDKManager;
import com.salesforce.androidsdk.smartstore.store.IndexSpec;
import com.salesforce.androidsdk.smartstore.store.QuerySpec;
import com.salesforce.androidsdk.smartstore.store.SmartStore;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class KeyValueSmartstore {

    /* JADX INFO: renamed from: a */
    private static final IndexSpec[] f12334a = {new IndexSpec("key", SmartStore.Type.string)};

    /* JADX INFO: renamed from: b */
    private final ServiceLogger f12335b = ServiceLogging.m14203a((Class<?>) KeyValueSmartstore.class);

    /* JADX INFO: renamed from: c */
    private final String f12336c;

    /* JADX INFO: renamed from: d */
    private SmartStore f12337d;

    public KeyValueSmartstore(String str, UserAccount userAccount) {
        this.f12336c = str;
        if (DbUtils.m12369a(userAccount)) {
            this.f12337d = SmartStoreSDKManager.m14661H().m14667b(userAccount);
            this.f12337d.m14795a(this.f12336c, f12334a);
        }
    }

    /* JADX INFO: renamed from: a */
    public String m12370a(String str) {
        try {
            JSONArray jSONArrayM14786a = this.f12337d.m14786a(QuerySpec.m14746a(this.f12336c, "key", str, "key", QuerySpec.Order.descending, 1), 0);
            if (jSONArrayM14786a != null && jSONArrayM14786a.length() > 0) {
                return ((JSONObject) jSONArrayM14786a.get(0)).getString("value");
            }
        } catch (JSONException e) {
            this.f12335b.mo14195e("JSONException: Error reading mapped value for {} due to {}.", str, e.getMessage());
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    public void m12372a(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArrayM14787a = this.f12337d.m14787a(this.f12336c, Long.valueOf(this.f12337d.m14784a(this.f12336c, "key", str)));
            if (jSONArrayM14787a != null && jSONArrayM14787a.length() != 0) {
                jSONObject = jSONArrayM14787a.getJSONObject(0);
            }
            jSONObject.put("key", str);
            jSONObject.put("value", str2);
            this.f12337d.m14788a(this.f12336c, jSONObject);
        } catch (JSONException e) {
            this.f12335b.mo14195e("JSONException writing to {}. {} ", this.f12336c, e.getMessage());
        }
    }

    /* JADX INFO: renamed from: a */
    public Map<String, String> m12371a() {
        HashMap map;
        JSONException e;
        try {
            JSONArray jSONArrayM14786a = this.f12337d.m14786a(QuerySpec.m14745a(this.f12336c, "key", QuerySpec.Order.descending, Integer.MAX_VALUE), 0);
            map = new HashMap(jSONArrayM14786a.length() + 1, 1.0f);
            for (int i = 0; i < jSONArrayM14786a.length(); i++) {
                try {
                    map.put(jSONArrayM14786a.getJSONObject(i).getString("key"), jSONArrayM14786a.getJSONObject(i).getString("value"));
                } catch (JSONException e2) {
                    e = e2;
                    this.f12335b.mo14195e("JSONException: Error reading all mapped values due to {}.", e.getMessage());
                }
            }
        } catch (JSONException e3) {
            map = null;
            e = e3;
        }
        return map;
    }
}
