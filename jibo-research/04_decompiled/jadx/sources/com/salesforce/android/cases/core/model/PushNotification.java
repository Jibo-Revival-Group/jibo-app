package com.salesforce.android.cases.core.model;

import android.os.Bundle;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class PushNotification {

    /* JADX INFO: renamed from: a */
    private static final ServiceLogger f12564a = ServiceLogging.m14203a((Class<?>) PushNotification.class);

    /* JADX INFO: renamed from: b */
    private String f12565b;

    /* JADX INFO: renamed from: c */
    private String f12566c;

    public PushNotification(Bundle bundle) {
        try {
            this.f12565b = m12620a(bundle, "caseId");
            String string = bundle.getString("aps");
            if (string != null) {
                this.f12566c = new JSONObject(string).getString("alert");
            }
        } catch (Exception e) {
            f12564a.mo14193d("Unable to parse the push notification bundle", e);
        }
    }

    /* JADX INFO: renamed from: a */
    public String m12621a() {
        return this.f12565b;
    }

    /* JADX INFO: renamed from: b */
    public String m12622b() {
        return this.f12566c;
    }

    /* JADX INFO: renamed from: a */
    private String m12620a(Bundle bundle, String str) {
        for (String str2 : bundle.keySet()) {
            if (str.equalsIgnoreCase(str2)) {
                return bundle.getString(str2);
            }
        }
        return null;
    }
}
