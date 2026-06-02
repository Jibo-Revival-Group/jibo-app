package com.salesforce.android.knowledge.core.internal.p021db;

import com.salesforce.android.knowledge.core.LogoutListener;
import com.salesforce.android.knowledge.core.internal.p021db.DbContract;
import com.salesforce.android.knowledge.core.internal.utils.MobileSdkUserManager;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import com.salesforce.androidsdk.smartstore.store.QuerySpec;
import com.salesforce.androidsdk.smartstore.store.SmartStore;
import net.sqlcipher.database.SQLiteDatabase;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class DbHelper implements LogoutListener {

    /* JADX INFO: renamed from: a */
    private static final ServiceLogger f12911a = ServiceLogging.m14203a((Class<?>) DbHelper.class);

    /* JADX INFO: renamed from: b */
    private final MobileSdkUserManager f12912b;

    /* JADX INFO: renamed from: c */
    private final String f12913c;

    DbHelper(String str, MobileSdkUserManager mobileSdkUserManager) {
        this.f12912b = mobileSdkUserManager;
        this.f12912b.mo13274a(this);
        this.f12913c = str;
        m13122a(this.f12912b.mo13273a(), str);
    }

    /* JADX INFO: renamed from: a */
    public void m13123a(SQLiteDatabase sQLiteDatabase) {
        synchronized (sQLiteDatabase) {
            DataCategoryGroupOperation.m13113a(sQLiteDatabase);
            DataCategoryOperation.m13118a(sQLiteDatabase);
            ArticleOperation.m13098a(sQLiteDatabase);
            ArticleMappingOperation.m13088a(sQLiteDatabase);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m13124a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        synchronized (sQLiteDatabase) {
            ArticleMappingOperation.m13089b(sQLiteDatabase);
            ArticleOperation.m13102b(sQLiteDatabase);
            DataCategoryOperation.m13119b(sQLiteDatabase);
            DataCategoryGroupOperation.m13114b(sQLiteDatabase);
        }
        m13123a(sQLiteDatabase);
    }

    /* JADX INFO: renamed from: b */
    public void m13126b(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        synchronized (sQLiteDatabase) {
            ArticleMappingOperation.m13089b(sQLiteDatabase);
            ArticleOperation.m13102b(sQLiteDatabase);
            DataCategoryOperation.m13119b(sQLiteDatabase);
            DataCategoryGroupOperation.m13114b(sQLiteDatabase);
        }
        m13123a(sQLiteDatabase);
    }

    /* JADX INFO: renamed from: b */
    public SQLiteDatabase m13125b() {
        return this.f12912b.mo13273a().m14785a();
    }

    /* JADX INFO: renamed from: a */
    private void m13122a(SmartStore smartStore, String str) {
        try {
            smartStore.m14795a("DbVersionInfo", DbContract.DbMeta.f12910a);
        } catch (Exception e) {
            f12911a.mo14195e("Error setting up db, deleting any cached data. {}", e.getMessage());
            this.f12912b.mo13276c();
            smartStore.m14795a("DbVersionInfo", DbContract.DbMeta.f12910a);
        }
        try {
            JSONArray jSONArrayM14786a = smartStore.m14786a(QuerySpec.m14745a("DbVersionInfo", "InstalledVersion", QuerySpec.Order.ascending, 1), 0);
            m13121a(9, str, smartStore);
            if (jSONArrayM14786a.length() == 0) {
                m13123a(smartStore.m14785a());
                return;
            }
            JSONObject jSONObject = jSONArrayM14786a.getJSONObject(0);
            int i = jSONObject.getInt("InstalledVersion");
            String string = jSONObject.getString("Locale");
            if (i < 9 || !string.equals(str)) {
                m13124a(smartStore.m14785a(), i, 9);
            } else if (i > 9) {
                m13126b(smartStore.m14785a(), i, 9);
            } else {
                m13123a(smartStore.m14785a());
            }
        } catch (JSONException e2) {
            m13124a(smartStore.m14785a(), 0, 9);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m13121a(int i, String str, SmartStore smartStore) {
        smartStore.m14799b("DbVersionInfo");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("Locale", str);
            jSONObject.put("InstalledVersion", i);
            smartStore.m14790a("DbVersionInfo", jSONObject, "InstalledVersion");
        } catch (JSONException e) {
            f12911a.mo14193d("Error writing DB meta data. Upgrade/Downgrade of DB will not be supported, {}", e.getMessage());
        }
    }

    @Override // com.salesforce.android.knowledge.core.LogoutListener
    /* JADX INFO: renamed from: a */
    public void mo13084a() {
        m13122a(this.f12912b.mo13273a(), this.f12913c);
    }
}
