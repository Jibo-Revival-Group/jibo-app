package com.salesforce.android.service.common.utilities.validation;

import android.content.Context;
import com.salesforce.android.service.common.utilities.R;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class Arguments {

    /* JADX INFO: renamed from: a */
    private static final Pattern f13964a = Pattern.compile(".{15}");

    /* JADX INFO: renamed from: b */
    private static final Pattern f13965b = Pattern.compile("[-\\w+\\.]+salesforceliveagent\\.com$|[-\\w+\\.]+sfm\\.ops\\.sfdc\\.net$|[-\\w+\\.]+salesforce\\.com$|^localhost(:[0-9]+)?|^laemulator.herokuapp.com$");

    /* JADX INFO: renamed from: a */
    public static <T> T m14235a(T t) {
        if (t == null) {
            throw new NullPointerException();
        }
        return t;
    }

    /* JADX INFO: renamed from: a */
    public static <T> T m14236a(T t, String str) {
        if (t == null) {
            throw new NullPointerException(str);
        }
        return t;
    }

    /* JADX INFO: renamed from: a */
    public static void m14239a(boolean z, String str) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m14238a(String str) {
        m14239a(f13965b.matcher(str).matches(), "Invalid LiveAgent Pod name. Please confirm that you are using the FQDN of the pod and not the entire HTTP URL. Example: mypod.salesforceliveagent.com");
    }

    /* JADX INFO: renamed from: a */
    public static void m14237a(Context context) {
        String string = context.getResources().getString(R.string.account_type);
        String string2 = context.getResources().getString(R.string.default_account_type);
        if (string == null || string.equals(string2)) {
            throw new IllegalStateException("account_type string not set. This string resource must be set to prevent conflicts with other apps.");
        }
    }
}
