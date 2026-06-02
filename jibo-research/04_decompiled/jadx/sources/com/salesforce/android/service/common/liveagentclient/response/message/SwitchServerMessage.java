package com.salesforce.android.service.common.liveagentclient.response.message;

import com.google.gson.annotations.SerializedName;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class SwitchServerMessage {

    @SerializedName(m9428a = "newUrl")
    private String mNewServerUrl;

    /* JADX INFO: renamed from: a */
    public String m13876a() {
        return this.mNewServerUrl;
    }

    /* JADX INFO: renamed from: b */
    public String m13877b() {
        if (this.mNewServerUrl == null) {
            return null;
        }
        Matcher matcher = Pattern.compile("https://(.*)/chat").matcher(this.mNewServerUrl);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }
}
