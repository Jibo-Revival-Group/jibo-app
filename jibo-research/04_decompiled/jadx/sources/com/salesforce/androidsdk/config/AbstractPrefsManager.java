package com.salesforce.androidsdk.config;

import android.content.SharedPreferences;
import com.salesforce.androidsdk.accounts.UserAccount;
import com.salesforce.androidsdk.app.SalesforceSDKManager;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractPrefsManager {
    /* JADX INFO: renamed from: a */
    protected abstract String mo14495a();

    /* JADX INFO: renamed from: b */
    protected abstract boolean mo14500b();

    /* JADX INFO: renamed from: a */
    public void m14499a(JSONObject jSONObject, UserAccount userAccount) {
        if (jSONObject != null) {
            SharedPreferences.Editor editorEdit = m14494b(userAccount).edit();
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                editorEdit.putString(next, jSONObject.optString(next));
            }
            editorEdit.commit();
        }
    }

    /* JADX INFO: renamed from: a */
    public void m14498a(Map<String, String> map, UserAccount userAccount) {
        m14499a(new JSONObject(map), userAccount);
    }

    /* JADX INFO: renamed from: b */
    private SharedPreferences m14494b(UserAccount userAccount) {
        String strMo14495a = mo14495a();
        if (userAccount != null) {
            strMo14495a = mo14495a() + (mo14500b() ? userAccount.m14260t() : userAccount.m14261u());
        }
        return SalesforceSDKManager.m14403a().m14446k().getSharedPreferences(strMo14495a, 0);
    }

    /* JADX INFO: renamed from: a */
    public String m14496a(String str, UserAccount userAccount) {
        Map<String, ?> all = m14494b(userAccount).getAll();
        if (all != null) {
            return (String) all.get(str);
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    public Map<String, String> m14497a(UserAccount userAccount) {
        return m14494b(userAccount).getAll();
    }

    /* JADX INFO: renamed from: c */
    public void m14501c() {
        File file = new File(SalesforceSDKManager.m14403a().m14446k().getApplicationInfo().dataDir + "/shared_prefs");
        FilenameFilter filenameFilter = new FilenameFilter() { // from class: com.salesforce.androidsdk.config.AbstractPrefsManager.1
            @Override // java.io.FilenameFilter
            public boolean accept(File file2, String str) {
                return str != null && str.startsWith(AbstractPrefsManager.this.mo14495a());
            }
        };
        for (File file2 : file.listFiles()) {
            if (file2 != null && filenameFilter.accept(file, file2.getName())) {
                file2.delete();
            }
        }
    }
}
