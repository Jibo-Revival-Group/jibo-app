package com.salesforce.androidsdk.app;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.salesforce.androidsdk.accounts.UserAccount;
import com.salesforce.androidsdk.accounts.UserAccountManager;
import com.salesforce.androidsdk.analytics.EventBuilderHelper;
import com.salesforce.androidsdk.analytics.SalesforceAnalyticsManager;
import com.salesforce.androidsdk.analytics.security.Encryptor;
import com.salesforce.androidsdk.auth.HttpAccess;
import com.salesforce.androidsdk.auth.OAuth2;
import com.salesforce.androidsdk.config.AdminPermsManager;
import com.salesforce.androidsdk.config.AdminSettingsManager;
import com.salesforce.androidsdk.config.BootConfig;
import com.salesforce.androidsdk.config.LoginServerManager;
import com.salesforce.androidsdk.p025ui.AccountSwitcherActivity;
import com.salesforce.androidsdk.p025ui.LoginActivity;
import com.salesforce.androidsdk.p025ui.PasscodeActivity;
import com.salesforce.androidsdk.p025ui.SalesforceR;
import com.salesforce.androidsdk.push.PushMessaging;
import com.salesforce.androidsdk.push.PushNotificationInterface;
import com.salesforce.androidsdk.rest.ClientManager;
import com.salesforce.androidsdk.rest.RestClient;
import com.salesforce.androidsdk.security.PasscodeManager;
import com.salesforce.androidsdk.util.EventsObservable;
import com.salesforce.androidsdk.util.SalesforceSDKLogger;
import com.yalantis.ucrop.util.FileUtils;
import java.net.URI;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.UUID;
import net.sqlcipher.database.SQLiteDatabase;

/* JADX INFO: loaded from: classes.dex */
public class SalesforceSDKManager {

    /* JADX INFO: renamed from: a */
    protected static String f14085a;

    /* JADX INFO: renamed from: b */
    protected static SalesforceSDKManager f14086b;

    /* JADX INFO: renamed from: k */
    private static final String f14087k = UUID.randomUUID().toString();

    /* JADX INFO: renamed from: c */
    protected Context f14088c;

    /* JADX INFO: renamed from: d */
    protected KeyInterface f14089d;

    /* JADX INFO: renamed from: e */
    protected ClientManager.LoginOptions f14090e;

    /* JADX INFO: renamed from: f */
    protected Class<? extends Activity> f14091f;

    /* JADX INFO: renamed from: g */
    protected Class<? extends Activity> f14092g;

    /* JADX INFO: renamed from: j */
    private CleanupReceiver f14095j;

    /* JADX INFO: renamed from: l */
    private String f14096l;

    /* JADX INFO: renamed from: n */
    private PasscodeManager f14098n;

    /* JADX INFO: renamed from: o */
    private LoginServerManager f14099o;

    /* JADX INFO: renamed from: r */
    private AdminSettingsManager f14102r;

    /* JADX INFO: renamed from: s */
    private AdminPermsManager f14103s;

    /* JADX INFO: renamed from: t */
    private PushNotificationInterface f14104t;

    /* JADX INFO: renamed from: u */
    private String f14105u;

    /* JADX INFO: renamed from: w */
    private SortedSet<String> f14107w;

    /* JADX INFO: renamed from: x */
    private List<String> f14108x;

    /* JADX INFO: renamed from: y */
    private String f14109y;

    /* JADX INFO: renamed from: h */
    protected Class<? extends PasscodeActivity> f14093h = PasscodeActivity.class;

    /* JADX INFO: renamed from: i */
    protected Class<? extends AccountSwitcherActivity> f14094i = AccountSwitcherActivity.class;

    /* JADX INFO: renamed from: m */
    private SalesforceR f14097m = new SalesforceR();

    /* JADX INFO: renamed from: p */
    private boolean f14100p = false;

    /* JADX INFO: renamed from: q */
    private boolean f14101q = false;

    /* JADX INFO: renamed from: v */
    private volatile boolean f14106v = false;

    /* JADX INFO: renamed from: z */
    private Object f14110z = new Object();

    public interface KeyInterface {
        /* JADX INFO: renamed from: a */
        String mo9871a(String str);
    }

    /* JADX INFO: renamed from: a */
    public static SalesforceSDKManager m14403a() {
        if (f14086b != null) {
            return f14086b;
        }
        throw new RuntimeException("Applications need to call SalesforceSDKManager.init() first.");
    }

    /* JADX INFO: renamed from: b */
    public static boolean m14415b() {
        return f14086b != null;
    }

    /* JADX INFO: renamed from: a */
    public static void m14410a(String str) {
        if (!TextUtils.isEmpty(str)) {
            f14085a = str;
        }
    }

    /* JADX INFO: renamed from: c */
    public static String m14416c() {
        return f14085a;
    }

    protected SalesforceSDKManager(Context context, KeyInterface keyInterface, Class<? extends Activity> cls, Class<? extends Activity> cls2) {
        String string;
        this.f14092g = LoginActivity.class;
        this.f14105u = Settings.Secure.getString(context.getContentResolver(), "android_id");
        this.f14088c = context;
        this.f14089d = keyInterface;
        this.f14091f = cls;
        if (cls2 != null) {
            this.f14092g = cls2;
        }
        this.f14107w = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        if (TextUtils.isEmpty(m14416c())) {
            try {
                string = context.getString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.labelRes);
            } catch (PackageManager.NameNotFoundException e) {
                SalesforceSDKLogger.m15016a("SalesforceSDKManager", "Package not found", e);
                string = null;
            }
            if (!TextUtils.isEmpty(string)) {
                m14410a(string);
            }
        }
        this.f14095j = new CleanupReceiver();
        context.registerReceiver(this.f14095j, new IntentFilter("com.salesforce.CLEANUP"));
    }

    /* JADX INFO: renamed from: d */
    public Class<? extends Activity> m14436d() {
        return this.f14091f;
    }

    /* JADX INFO: renamed from: b */
    public String m14432b(String str) {
        if (this.f14089d == null) {
            return null;
        }
        return this.f14089d.mo9871a(str);
    }

    /* JADX INFO: renamed from: e */
    public SalesforceR m14438e() {
        return this.f14097m;
    }

    /* JADX INFO: renamed from: f */
    public Class<? extends Activity> m14440f() {
        return this.f14092g;
    }

    /* JADX INFO: renamed from: g */
    public String m14442g() {
        return this.f14105u;
    }

    /* JADX INFO: renamed from: h */
    public ClientManager.LoginOptions m14443h() {
        return m14425a((String) null, (String) null);
    }

    /* JADX INFO: renamed from: a */
    public ClientManager.LoginOptions m14425a(String str, String str2) {
        if (this.f14090e == null) {
            BootConfig bootConfigM14502a = BootConfig.m14502a(this.f14088c);
            if (TextUtils.isEmpty(str)) {
                this.f14090e = new ClientManager.LoginOptions(str2, m14455t(), bootConfigM14502a.m14509b(), bootConfigM14502a.m14508a(), bootConfigM14502a.m14510c(), null);
            } else {
                this.f14090e = new ClientManager.LoginOptions(str2, m14455t(), bootConfigM14502a.m14509b(), bootConfigM14502a.m14508a(), bootConfigM14502a.m14510c(), null, str);
            }
        } else {
            this.f14090e.m14578a(str);
            this.f14090e.m14580b(str2);
        }
        return this.f14090e;
    }

    /* JADX INFO: renamed from: a */
    public static void m14406a(Context context) {
        Encryptor.m14368a(context);
        HttpAccess.m14475a(context, f14086b.m14460y());
        SalesforceSDKUpgradeManager.m14463a().mo14466b();
    }

    /* JADX INFO: renamed from: i */
    public Class<? extends PasscodeActivity> m14444i() {
        return this.f14093h;
    }

    /* JADX INFO: renamed from: j */
    public boolean m14445j() {
        return true;
    }

    /* JADX INFO: renamed from: k */
    public Context m14446k() {
        return this.f14088c;
    }

    /* JADX INFO: renamed from: l */
    public synchronized LoginServerManager m14447l() {
        if (this.f14099o == null) {
            this.f14099o = new LoginServerManager(this.f14088c);
        }
        return this.f14099o;
    }

    /* JADX INFO: renamed from: a */
    public synchronized void m14431a(PushNotificationInterface pushNotificationInterface) {
        this.f14104t = pushNotificationInterface;
    }

    /* JADX INFO: renamed from: m */
    public synchronized PushNotificationInterface m14448m() {
        return this.f14104t;
    }

    /* JADX INFO: renamed from: n */
    public PasscodeManager m14449n() {
        PasscodeManager passcodeManager;
        synchronized (this.f14110z) {
            if (this.f14098n == null) {
                this.f14098n = new PasscodeManager(this.f14088c);
            }
            passcodeManager = this.f14098n;
        }
        return passcodeManager;
    }

    /* JADX INFO: renamed from: o */
    public UserAccountManager m14450o() {
        return UserAccountManager.m14264a();
    }

    /* JADX INFO: renamed from: p */
    public synchronized AdminSettingsManager m14451p() {
        if (this.f14102r == null) {
            this.f14102r = new AdminSettingsManager();
        }
        return this.f14102r;
    }

    /* JADX INFO: renamed from: q */
    public synchronized AdminPermsManager m14452q() {
        if (this.f14103s == null) {
            this.f14103s = new AdminPermsManager();
        }
        return this.f14103s;
    }

    /* JADX INFO: renamed from: b */
    public synchronized void mo14433b(String str, String str2) {
        if (m14435c(str, str2)) {
            this.f14096l = null;
            SalesforceAnalyticsManager.m14294a(str, str2);
            ClientManager.m14556a(str, str2);
        }
    }

    /* JADX INFO: renamed from: c */
    protected boolean m14435c(String str, String str2) {
        return !(str == null && str2 == null) && (str == null || str2 == null || !str.trim().equals(str2.trim()));
    }

    /* JADX INFO: renamed from: c */
    public synchronized String m14434c(String str) {
        if (str != null) {
            if (str.trim().equals("")) {
            }
        }
        if (this.f14096l == null) {
            this.f14096l = m14449n().m14651c("");
        }
        str = this.f14096l;
        return str;
    }

    /* JADX INFO: renamed from: r */
    public String m14453r() {
        return this.f14109y;
    }

    /* JADX INFO: renamed from: s */
    public String m14454s() {
        return "Salesforce";
    }

    /* JADX INFO: renamed from: t */
    public String m14455t() {
        return m14449n().m14653d();
    }

    /* JADX INFO: renamed from: u */
    public String m14456u() {
        return this.f14088c.getPackageManager().getApplicationLabel(this.f14088c.getApplicationInfo()).toString();
    }

    /* JADX INFO: renamed from: v */
    public List<String> m14457v() {
        return this.f14108x;
    }

    /* JADX INFO: renamed from: a */
    private void m14404a(Activity activity, Account account) {
        UserAccount userAccountM14266a = UserAccountManager.m14264a().m14266a(account);
        mo14430a(userAccountM14266a);
        m14413b(userAccountM14266a);
        List<UserAccount> listM14277d = m14450o().m14277d();
        if (activity != null && (listM14277d == null || listM14277d.size() <= 1)) {
            activity.finish();
        }
        if (listM14277d == null || listM14277d.size() <= 1) {
            m14451p().m14501c();
            m14452q().m14501c();
            this.f14102r = null;
            this.f14103s = null;
            m14449n().m14636a(this.f14088c);
            this.f14098n = null;
            this.f14096l = null;
            UUIDManager.m14471a();
        }
    }

    /* JADX INFO: renamed from: a */
    protected void mo14430a(UserAccount userAccount) {
        SalesforceAnalyticsManager.m14295b(userAccount);
        RestClient.m14592a(userAccount);
    }

    /* JADX INFO: renamed from: w */
    protected void m14458w() {
        m14424F();
        Intent intent = new Intent(this.f14088c, m14436d());
        intent.setPackage(m14446k().getPackageName());
        intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        this.f14088c.startActivity(intent);
    }

    /* JADX INFO: renamed from: x */
    public void m14459x() {
        m14424F();
        UserAccountManager userAccountManagerM14450o = m14450o();
        List<UserAccount> listM14277d = userAccountManagerM14450o.m14277d();
        if (listM14277d == null || listM14277d.size() == 0) {
            m14458w();
        } else {
            if (listM14277d.size() == 1) {
                userAccountManagerM14450o.m14269a(listM14277d.get(0), 2, (Bundle) null);
                return;
            }
            Intent intent = new Intent(this.f14088c, this.f14094i);
            intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            this.f14088c.startActivity(intent);
        }
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [com.salesforce.androidsdk.app.SalesforceSDKManager$2] */
    /* JADX INFO: renamed from: a */
    private void m14409a(final ClientManager clientManager, final boolean z, final String str, final String str2, final String str3, final Account account, final Activity activity) {
        IntentFilter intentFilter = new IntentFilter("com.salesfore.mobilesdk.c2dm.UNREGISTERED");
        final BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.salesforce.androidsdk.app.SalesforceSDKManager.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                if (intent.getAction().equals("com.salesfore.mobilesdk.c2dm.UNREGISTERED")) {
                    SalesforceSDKManager.this.m14405a(this, clientManager, z, str, str2, str3, account, activity);
                }
            }
        };
        m14446k().registerReceiver(broadcastReceiver, intentFilter);
        PushMessaging.m14540b(this.f14088c, m14450o().m14266a(account));
        new Thread() { // from class: com.salesforce.androidsdk.app.SalesforceSDKManager.2
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                long jCurrentTimeMillis = System.currentTimeMillis();
                while (System.currentTimeMillis() - jCurrentTimeMillis < 30000 && !SalesforceSDKManager.this.f14106v) {
                    SystemClock.sleep(500L);
                }
                SalesforceSDKManager.this.m14405a(broadcastReceiver, clientManager, z, str, str2, str3, account, activity);
            }
        }.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public synchronized void m14405a(BroadcastReceiver broadcastReceiver, ClientManager clientManager, boolean z, String str, String str2, String str3, Account account, Activity activity) {
        if (!this.f14106v) {
            try {
                this.f14088c.unregisterReceiver(broadcastReceiver);
            } catch (Exception e) {
                SalesforceSDKLogger.m15016a("SalesforceSDKManager", "Exception occurred while unregistering", e);
            }
            m14414b(clientManager, z, str, str2, str3, account, activity);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m14428a(Activity activity) {
        m14429a(activity, true);
    }

    /* JADX INFO: renamed from: a */
    public void m14426a(Account account, Activity activity) {
        m14427a(account, activity, true);
    }

    /* JADX INFO: renamed from: a */
    public void m14429a(Activity activity, boolean z) {
        m14427a(new ClientManager(this.f14088c, m14420B(), null, m14445j()).m14568c(), activity, z);
    }

    /* JADX INFO: renamed from: a */
    public void m14427a(Account account, Activity activity, boolean z) {
        String strM14418e;
        String strM14418e2;
        String strM14418e3 = null;
        EventBuilderHelper.m14288a("userLogout", null, "SalesforceSDKManager", null);
        ClientManager clientManager = new ClientManager(this.f14088c, m14420B(), null, m14445j());
        this.f14101q = true;
        AccountManager accountManager = AccountManager.get(this.f14088c);
        if (account != null) {
            String strM14455t = m14455t();
            strM14418e2 = m14418e(accountManager.getPassword(account), strM14455t);
            strM14418e = m14418e(accountManager.getUserData(account, "clientId"), strM14455t);
            strM14418e3 = m14418e(accountManager.getUserData(account, "instanceUrl"), strM14455t);
        } else {
            strM14418e = null;
            strM14418e2 = null;
        }
        if (PushMessaging.m14544f(this.f14088c, m14450o().m14266a(account)) && strM14418e2 != null) {
            this.f14106v = false;
            m14409a(clientManager, z, strM14418e2, strM14418e, strM14418e3, account, activity);
        } else {
            m14414b(clientManager, z, strM14418e2, strM14418e, strM14418e3, account, activity);
        }
    }

    /* JADX INFO: renamed from: b */
    private void m14414b(ClientManager clientManager, final boolean z, String str, String str2, String str3, Account account, Activity activity) {
        this.f14106v = true;
        m14404a(activity, account);
        if (account == null) {
            AccountManager accountManager = AccountManager.get(this.f14088c);
            if (accountManager != null) {
                Account[] accountsByType = accountManager.getAccountsByType(m14420B());
                if (accountsByType.length > 0) {
                    for (int i = 0; i < accountsByType.length - 1; i++) {
                        clientManager.m14565a(accountsByType);
                    }
                    clientManager.m14562a(accountsByType[accountsByType.length - 1], new AccountManagerCallback<Boolean>() { // from class: com.salesforce.androidsdk.app.SalesforceSDKManager.3
                        @Override // android.accounts.AccountManagerCallback
                        public void run(AccountManagerFuture<Boolean> accountManagerFuture) {
                            SalesforceSDKManager.this.m14411a(z);
                        }
                    });
                } else {
                    m14411a(z);
                }
            } else {
                m14411a(z);
            }
        } else {
            clientManager.m14562a(account, new AccountManagerCallback<Boolean>() { // from class: com.salesforce.androidsdk.app.SalesforceSDKManager.4
                @Override // android.accounts.AccountManagerCallback
                public void run(AccountManagerFuture<Boolean> accountManagerFuture) {
                    SalesforceSDKManager.this.m14411a(z);
                }
            });
        }
        this.f14101q = false;
        if (m14445j() && account != null && str != null) {
            new RevokeTokenTask(str, str2, str3).execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m14411a(boolean z) {
        EventsObservable.m15006a().m15008a(EventsObservable.EventType.LogoutComplete);
        m14402H();
        if (z) {
            m14459x();
        }
    }

    /* JADX INFO: renamed from: y */
    public final String m14460y() {
        return m14437d("");
    }

    /* JADX INFO: renamed from: d */
    public String m14437d(String str) {
        String string;
        Resources.NotFoundException e;
        PackageManager.NameNotFoundException e2;
        PackageInfo packageInfo;
        String str2 = "";
        try {
            packageInfo = this.f14088c.getPackageManager().getPackageInfo(this.f14088c.getPackageName(), 0);
            string = this.f14088c.getString(packageInfo.applicationInfo.labelRes);
        } catch (PackageManager.NameNotFoundException e3) {
            string = "";
            e2 = e3;
        } catch (Resources.NotFoundException e4) {
            string = "";
            e = e4;
        }
        try {
            str2 = packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e5) {
            e2 = e5;
            SalesforceSDKLogger.m15018b("SalesforceSDKManager", "Package info could not be retrieved", e2);
        } catch (Resources.NotFoundException e6) {
            e = e6;
            SalesforceSDKLogger.m15018b("SalesforceSDKManager", "Package info could not be retrieved", e);
        }
        return String.format("SalesforceMobileSDK/%s android mobile/%s (%s) %s/%s %s uid_%s ftr_%s", "5.3.0", Build.VERSION.RELEASE, Build.MODEL, string, str2, m14461z() + str, this.f14105u, TextUtils.join(FileUtils.HIDDEN_PREFIX, this.f14107w));
    }

    /* JADX INFO: renamed from: e */
    public void m14439e(String str) {
        this.f14107w.add(str);
    }

    /* JADX INFO: renamed from: f */
    public void m14441f(String str) {
        this.f14107w.remove(str);
    }

    /* JADX INFO: renamed from: z */
    public String m14461z() {
        return "Native";
    }

    /* JADX INFO: renamed from: A */
    public boolean m14419A() {
        return false;
    }

    /* JADX INFO: renamed from: B */
    public String m14420B() {
        return this.f14088c.getString(m14438e().m14961a());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass()).append(": {\n").append("   accountType: ").append(m14420B()).append("\n").append("   userAgent: ").append(m14460y()).append("\n").append("   mainActivityClass: ").append(m14436d()).append("\n").append("   isFileSystemEncrypted: ").append(Encryptor.m14372b()).append("\n");
        if (this.f14098n != null) {
            sb.append("   hasStoredPasscode: ").append(this.f14098n.m14649b(this.f14088c)).append("\n");
        }
        sb.append("}\n");
        return sb.toString();
    }

    /* JADX INFO: renamed from: d */
    public static String m14417d(String str, String str2) {
        return Encryptor.m14371b(str, f14086b.m14434c(str2));
    }

    /* JADX INFO: renamed from: e */
    public static String m14418e(String str, String str2) {
        return Encryptor.m14365a(str, f14086b.m14434c(str2));
    }

    private class RevokeTokenTask extends AsyncTask<Void, Void, Void> {

        /* JADX INFO: renamed from: b */
        private String f14134b;

        /* JADX INFO: renamed from: c */
        private String f14135c;

        /* JADX INFO: renamed from: d */
        private String f14136d;

        public RevokeTokenTask(String str, String str2, String str3) {
            this.f14134b = str;
            this.f14135c = str2;
            this.f14136d = str3;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(Void... voidArr) {
            try {
                OAuth2.m14488a(HttpAccess.f14141a, new URI(this.f14136d), this.f14134b);
                return null;
            } catch (Exception e) {
                SalesforceSDKLogger.m15018b("SalesforceSDKManager", "Revoking token failed", e);
                return null;
            }
        }
    }

    /* JADX INFO: renamed from: C */
    public boolean m14421C() {
        return f14086b.f14100p;
    }

    /* JADX INFO: renamed from: D */
    public boolean m14422D() {
        return this.f14101q;
    }

    /* JADX INFO: renamed from: E */
    public ClientManager m14423E() {
        return new ClientManager(m14446k(), m14420B(), m14443h(), true);
    }

    @TargetApi(21)
    /* JADX INFO: renamed from: F */
    public void m14424F() {
        if (Build.VERSION.SDK_INT >= 21) {
            CookieManager.getInstance().removeAllCookies(null);
        } else {
            CookieSyncManager.createInstance(this.f14088c);
            CookieManager.getInstance().removeAllCookie();
        }
    }

    /* JADX INFO: renamed from: H */
    private void m14402H() {
        Intent intent = new Intent("com.salesforce.LOGOUT_COMPLETE");
        intent.setPackage(this.f14088c.getPackageName());
        this.f14088c.sendBroadcast(intent);
    }

    /* JADX INFO: renamed from: b */
    private void m14413b(UserAccount userAccount) {
        Intent intent = new Intent("com.salesforce.CLEANUP");
        intent.setPackage(this.f14088c.getPackageName());
        intent.putExtra("processId", f14087k);
        if (userAccount != null) {
            intent.putExtra("userAccount", userAccount.m14263w());
        }
        this.f14088c.sendBroadcast(intent);
    }

    private class CleanupReceiver extends BroadcastReceiver {
        private CleanupReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null && intent.getAction().equals("com.salesforce.CLEANUP") && !intent.getStringExtra("processId").equals(SalesforceSDKManager.f14087k)) {
                UserAccount userAccount = null;
                if (intent.hasExtra("userAccount")) {
                    userAccount = new UserAccount(intent.getBundleExtra("userAccount"));
                }
                SalesforceSDKManager.this.mo14430a(userAccount);
            }
        }
    }
}
