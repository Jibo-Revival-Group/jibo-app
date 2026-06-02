package com.salesforce.androidsdk.app;

import android.content.SharedPreferences;
import com.salesforce.androidsdk.analytics.security.Encryptor;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public class UUIDManager {

    /* JADX INFO: renamed from: a */
    private static Map<String, String> f14138a = new HashMap();

    /* JADX INFO: renamed from: a */
    public static synchronized String m14470a(String str) {
        String strM14365a;
        strM14365a = f14138a.get(str);
        if (strM14365a == null) {
            SharedPreferences sharedPreferences = SalesforceSDKManager.m14403a().m14446k().getSharedPreferences("uuids2", 0);
            String strM14432b = SalesforceSDKManager.m14403a().m14432b(str);
            if (!sharedPreferences.contains(str)) {
                String string = UUID.randomUUID().toString();
                SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                editorEdit.putString(str, Encryptor.m14371b(string, strM14432b));
                editorEdit.commit();
            }
            strM14365a = Encryptor.m14365a(sharedPreferences.getString(str, null), strM14432b);
            if (strM14365a != null) {
                f14138a.put(str, strM14365a);
            }
        }
        return strM14365a;
    }

    /* JADX INFO: renamed from: a */
    public static synchronized void m14471a() {
        f14138a.clear();
        SharedPreferences sharedPreferences = SalesforceSDKManager.m14403a().m14446k().getSharedPreferences("uuids2", 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().clear().commit();
        }
    }
}
