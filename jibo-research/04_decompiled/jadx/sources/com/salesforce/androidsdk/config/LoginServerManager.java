package com.salesforce.androidsdk.config;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.XmlResourceParser;
import android.text.TextUtils;
import com.salesforce.androidsdk.app.SalesforceSDKManager;
import com.salesforce.androidsdk.config.RuntimeConfig;
import com.salesforce.androidsdk.p025ui.SalesforceR;
import com.salesforce.androidsdk.util.SalesforceSDKLogger;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class LoginServerManager {

    /* JADX INFO: renamed from: a */
    private Context f14185a;

    /* JADX INFO: renamed from: b */
    private LoginServer f14186b;

    /* JADX INFO: renamed from: c */
    private SharedPreferences f14187c;

    /* JADX INFO: renamed from: d */
    private SharedPreferences f14188d;

    public LoginServerManager(Context context) {
        this.f14185a = context;
        this.f14187c = context.getSharedPreferences("server_url_file", 0);
        this.f14188d = context.getSharedPreferences("runtime_prefs_file", 0);
        m14516h();
        this.f14186b = m14517a();
    }

    /* JADX INFO: renamed from: a */
    public LoginServer m14517a() {
        LoginServer loginServer;
        SharedPreferences sharedPreferences = this.f14185a.getSharedPreferences("server_selection_file", 0);
        String string = sharedPreferences.getString("server_name_%d", null);
        String string2 = sharedPreferences.getString("server_url_%d", null);
        boolean z = sharedPreferences.getBoolean("is_custom_%d", false);
        if (string != null && string2 != null) {
            this.f14186b = new LoginServer(string, string2, z);
        } else {
            List<LoginServer> listM14521c = m14521c();
            if (listM14521c != null && (loginServer = listM14521c.get(0)) != null) {
                this.f14186b = loginServer;
            }
            if (this.f14186b == null) {
                this.f14186b = new LoginServer("Production", "https://login.salesforce.com", false);
            }
            m14518a(this.f14186b);
        }
        return this.f14186b;
    }

    /* JADX INFO: renamed from: a */
    public void m14518a(LoginServer loginServer) {
        if (loginServer != null) {
            SharedPreferences.Editor editorEdit = this.f14185a.getSharedPreferences("server_selection_file", 0).edit();
            editorEdit.clear();
            editorEdit.putString("server_name_%d", loginServer.f14189a);
            editorEdit.putString("server_url_%d", loginServer.f14190b);
            editorEdit.putBoolean("is_custom_%d", loginServer.f14191c);
            editorEdit.commit();
            this.f14186b = loginServer;
        }
    }

    /* JADX INFO: renamed from: a */
    public void m14519a(String str, String str2) {
        if (m14522d() == null) {
            m14513a(str, str2, true, this.f14187c);
        } else {
            m14513a(str, str2, true, this.f14188d);
        }
        m14518a(new LoginServer(str, str2, true));
    }

    /* JADX INFO: renamed from: b */
    public void m14520b() {
        SharedPreferences.Editor editorEdit = this.f14187c.edit();
        editorEdit.clear();
        editorEdit.commit();
        SharedPreferences.Editor editorEdit2 = this.f14188d.edit();
        editorEdit2.clear();
        editorEdit2.commit();
        SharedPreferences.Editor editorEdit3 = this.f14185a.getSharedPreferences("server_selection_file", 0).edit();
        editorEdit3.clear();
        editorEdit3.commit();
        m14516h();
    }

    /* JADX INFO: renamed from: c */
    public List<LoginServer> m14521c() {
        if (m14522d() == null) {
            return m14523e();
        }
        return m14512a(this.f14188d);
    }

    /* JADX INFO: renamed from: d */
    public List<LoginServer> m14522d() {
        String[] strArrM14531b;
        String[] strArrM14531b2;
        RuntimeConfig runtimeConfigM14524a = RuntimeConfig.m14524a(this.f14185a);
        try {
            strArrM14531b = runtimeConfigM14524a.m14531b(RuntimeConfig.ConfigKey.AppServiceHosts);
        } catch (Exception e) {
            SalesforceSDKLogger.m15018b("LoginServerManager", "Exception thrown while attempting to read array, attempting to read string value instead", e);
            strArrM14531b = null;
        }
        if (strArrM14531b == null) {
            String strM14529a = runtimeConfigM14524a.m14529a(RuntimeConfig.ConfigKey.AppServiceHosts);
            if (!TextUtils.isEmpty(strM14529a)) {
                strArrM14531b = new String[]{strM14529a};
            }
        }
        ArrayList arrayList = new ArrayList();
        if (strArrM14531b != null) {
            try {
                strArrM14531b2 = runtimeConfigM14524a.m14531b(RuntimeConfig.ConfigKey.AppServiceHostLabels);
            } catch (Exception e2) {
                SalesforceSDKLogger.m15018b("LoginServerManager", "Exception thrown while attempting to read array, attempting to read string value instead", e2);
                strArrM14531b2 = null;
            }
            if (strArrM14531b2 == null) {
                String strM14529a2 = runtimeConfigM14524a.m14529a(RuntimeConfig.ConfigKey.AppServiceHostLabels);
                if (!TextUtils.isEmpty(strM14529a2)) {
                    strArrM14531b2 = new String[]{strM14529a2};
                }
            }
            if (strArrM14531b2 == null || strArrM14531b2.length != strArrM14531b.length) {
                SalesforceSDKLogger.m15017b("LoginServerManager", "No login servers labels provided or wrong number of login servers labels provided - Using URLs for the labels");
                strArrM14531b2 = strArrM14531b;
            }
            List<LoginServer> listM14512a = m14512a(this.f14188d);
            for (int i = 0; i < strArrM14531b.length; i++) {
                String str = strArrM14531b2[i];
                String str2 = strArrM14531b[i];
                LoginServer loginServer = new LoginServer(str, str2, false);
                if (listM14512a == null || !listM14512a.contains(loginServer)) {
                    m14513a(str, str2, false, this.f14188d);
                }
                arrayList.add(loginServer);
            }
        }
        if (arrayList.size() > 0) {
            return arrayList;
        }
        return null;
    }

    /* JADX INFO: renamed from: e */
    public List<LoginServer> m14523e() {
        return m14512a(this.f14187c);
    }

    /* JADX INFO: renamed from: f */
    private List<LoginServer> m14514f() {
        SalesforceR salesforceRM14438e = SalesforceSDKManager.m14403a().m14438e();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new LoginServer(this.f14185a.getString(salesforceRM14438e.m14959Y()), "https://login.salesforce.com", false));
        arrayList.add(new LoginServer(this.f14185a.getString(salesforceRM14438e.m14960Z()), "https://test.salesforce.com", false));
        return arrayList;
    }

    /* JADX INFO: renamed from: g */
    private List<LoginServer> m14515g() {
        int identifier = this.f14185a.getResources().getIdentifier("servers", "xml", this.f14185a.getPackageName());
        if (identifier == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        XmlResourceParser xml = this.f14185a.getResources().getXml(identifier);
        int next = -1;
        while (next != 1) {
            if (next == 2 && xml.getName().equals("server")) {
                arrayList.add(new LoginServer(xml.getAttributeValue(null, "name"), xml.getAttributeValue(null, "url"), false));
            }
            try {
                next = xml.next();
            } catch (IOException e) {
                SalesforceSDKLogger.m15018b("LoginServerManager", "Exception thrown while parsing XML", e);
            } catch (XmlPullParserException e2) {
                SalesforceSDKLogger.m15018b("LoginServerManager", "Exception thrown while parsing XML", e2);
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: h */
    private void m14516h() {
        Map<String, ?> all = this.f14187c.getAll();
        if (all == null || all.isEmpty()) {
            List<LoginServer> listM14515g = m14515g();
            List<LoginServer> listM14514f = (listM14515g == null || listM14515g.isEmpty()) ? m14514f() : listM14515g;
            int size = listM14514f.size();
            SharedPreferences.Editor editorEdit = this.f14187c.edit();
            for (int i = 0; i < size; i++) {
                LoginServer loginServer = listM14514f.get(i);
                editorEdit.putString(String.format("server_name_%d", Integer.valueOf(i)), loginServer.f14189a);
                editorEdit.putString(String.format("server_url_%d", Integer.valueOf(i)), loginServer.f14190b);
                editorEdit.putBoolean(String.format("is_custom_%d", Integer.valueOf(i)), loginServer.f14191c);
                if (i == 0) {
                    m14518a(loginServer);
                }
            }
            editorEdit.putInt("number_of_entries", size);
            editorEdit.commit();
        }
    }

    /* JADX INFO: renamed from: a */
    private void m14513a(String str, String str2, boolean z, SharedPreferences sharedPreferences) {
        if (str != null && str2 != null) {
            int i = sharedPreferences.getInt("number_of_entries", 0);
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putString(String.format("server_name_%d", Integer.valueOf(i)), str);
            editorEdit.putString(String.format("server_url_%d", Integer.valueOf(i)), str2);
            editorEdit.putBoolean(String.format("is_custom_%d", Integer.valueOf(i)), z);
            editorEdit.putInt("number_of_entries", i + 1);
            editorEdit.commit();
        }
    }

    /* JADX INFO: renamed from: a */
    private List<LoginServer> m14512a(SharedPreferences sharedPreferences) {
        int i = sharedPreferences.getInt("number_of_entries", 0);
        if (i == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < i; i2++) {
            String string = sharedPreferences.getString(String.format("server_name_%d", Integer.valueOf(i2)), null);
            String string2 = sharedPreferences.getString(String.format("server_url_%d", Integer.valueOf(i2)), null);
            boolean z = sharedPreferences.getBoolean(String.format("is_custom_%d", Integer.valueOf(i2)), false);
            if (string != null && string2 != null) {
                arrayList.add(new LoginServer(string, string2, z));
            }
        }
        if (arrayList.size() <= 0) {
            arrayList = null;
        }
        return arrayList;
    }

    public static class LoginServer {

        /* JADX INFO: renamed from: a */
        public final String f14189a;

        /* JADX INFO: renamed from: b */
        public final String f14190b;

        /* JADX INFO: renamed from: c */
        public final boolean f14191c;

        public LoginServer(String str, String str2, boolean z) {
            this.f14189a = str;
            this.f14190b = str2;
            this.f14191c = z;
        }

        public String toString() {
            return "Name: " + this.f14189a + ", URL: " + this.f14190b + ", Custom URL: " + this.f14191c;
        }

        public boolean equals(Object obj) {
            if (obj == null || obj.getClass() != getClass()) {
                return false;
            }
            LoginServer loginServer = (LoginServer) obj;
            return this.f14189a.trim().equals(loginServer.f14189a.trim()) && this.f14190b.trim().equals(loginServer.f14190b.trim()) && this.f14191c == loginServer.f14191c;
        }
    }
}
