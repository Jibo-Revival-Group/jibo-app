package com.salesforce.androidsdk.smartstore.app;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.salesforce.androidsdk.accounts.UserAccount;
import com.salesforce.androidsdk.app.SalesforceSDKManager;
import com.salesforce.androidsdk.p025ui.LoginActivity;
import com.salesforce.androidsdk.smartstore.store.DBOpenHelper;
import com.salesforce.androidsdk.smartstore.store.SmartStore;
import com.salesforce.androidsdk.util.EventsObservable;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class SmartStoreSDKManager extends SalesforceSDKManager {
    protected SmartStoreSDKManager(Context context, SalesforceSDKManager.KeyInterface keyInterface, Class<? extends Activity> cls, Class<? extends Activity> cls2) {
        super(context, keyInterface, cls, cls2);
    }

    /* JADX INFO: renamed from: a */
    private static void m14663a(Context context, SalesforceSDKManager.KeyInterface keyInterface, Class<? extends Activity> cls, Class<? extends Activity> cls2) {
        if (f14086b == null) {
            f14086b = new SmartStoreSDKManager(context, keyInterface, cls, cls2);
        }
        m14406a(context);
        SmartStoreUpgradeManager.m14673f().mo14466b();
        EventsObservable.m15006a().m15008a(EventsObservable.EventType.AppCreateComplete);
    }

    /* JADX INFO: renamed from: a */
    public static void m14662a(Context context, SalesforceSDKManager.KeyInterface keyInterface, Class<? extends Activity> cls) {
        m14663a(context, keyInterface, cls, LoginActivity.class);
    }

    /* JADX INFO: renamed from: H */
    public static SmartStoreSDKManager m14661H() {
        if (f14086b != null) {
            return (SmartStoreSDKManager) f14086b;
        }
        throw new RuntimeException("Applications need to call SalesforceSDKManagerWithSmartStore.init() first.");
    }

    @Override // com.salesforce.androidsdk.app.SalesforceSDKManager
    /* JADX INFO: renamed from: a */
    protected void mo14430a(UserAccount userAccount) {
        if (userAccount != null) {
            DBOpenHelper.m14719a(m14446k(), userAccount);
        } else {
            DBOpenHelper.m14724b(m14446k());
        }
        super.mo14430a(userAccount);
    }

    @Override // com.salesforce.androidsdk.app.SalesforceSDKManager
    /* JADX INFO: renamed from: b */
    public synchronized void mo14433b(String str, String str2) {
        Collection<DBOpenHelper> collectionValues;
        if (m14435c(str, str2)) {
            Map<String, DBOpenHelper> mapM14718a = DBOpenHelper.m14718a();
            if (mapM14718a != null && (collectionValues = mapM14718a.values()) != null) {
                for (DBOpenHelper dBOpenHelper : collectionValues) {
                    if (dBOpenHelper != null) {
                        SmartStore.m14776a(dBOpenHelper.getWritableDatabase(m14434c(str)), m14434c(str), m14434c(str2));
                    }
                }
            }
            super.mo14433b(str, str2);
        }
    }

    /* JADX INFO: renamed from: g */
    public SmartStore m14671g(String str) {
        SalesforceSDKManager.m14403a().m14439e("GS");
        if (TextUtils.isEmpty(str)) {
            str = "smartstore";
        }
        String strT = m14455t();
        if (strT == null) {
            strT = m14434c((String) null);
        }
        return new SmartStore(DBOpenHelper.m14716a(this.f14088c, str, (UserAccount) null, (String) null), strT);
    }

    /* JADX INFO: renamed from: b */
    public SmartStore m14667b(UserAccount userAccount) {
        return m14665a(userAccount, (String) null);
    }

    /* JADX INFO: renamed from: a */
    public SmartStore m14665a(UserAccount userAccount, String str) {
        return m14666a("smartstore", userAccount, str);
    }

    /* JADX INFO: renamed from: a */
    public SmartStore m14666a(String str, UserAccount userAccount, String str2) {
        if (TextUtils.isEmpty(str)) {
            str = "smartstore";
        }
        SalesforceSDKManager.m14403a().m14439e("US");
        String strT = m14455t();
        if (strT == null) {
            strT = m14434c((String) null);
        }
        return new SmartStore(DBOpenHelper.m14716a(this.f14088c, str, userAccount, str2), strT);
    }

    /* JADX INFO: renamed from: h */
    public void m14672h(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "smartstore";
        }
        DBOpenHelper.m14725b(this.f14088c, str, null, null);
    }

    /* JADX INFO: renamed from: I */
    public void m14664I() {
        m14670c(m14450o().m14275b());
    }

    /* JADX INFO: renamed from: c */
    public void m14670c(UserAccount userAccount) {
        m14668b(userAccount, (String) null);
    }

    /* JADX INFO: renamed from: b */
    public void m14668b(UserAccount userAccount, String str) {
        m14669b("smartstore", userAccount, str);
    }

    /* JADX INFO: renamed from: b */
    public void m14669b(String str, UserAccount userAccount, String str2) {
        if (TextUtils.isEmpty(str)) {
            str = "smartstore";
        }
        DBOpenHelper.m14725b(this.f14088c, str, userAccount, str2);
    }
}
