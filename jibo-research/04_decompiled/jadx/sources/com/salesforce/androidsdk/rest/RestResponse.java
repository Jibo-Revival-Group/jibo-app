package com.salesforce.androidsdk.rest;

import com.salesforce.androidsdk.util.SalesforceSDKLogger;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import okhttp3.MediaType;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class RestResponse {

    /* JADX INFO: renamed from: a */
    private final Response f14260a;

    /* JADX INFO: renamed from: b */
    private boolean f14261b;

    /* JADX INFO: renamed from: c */
    private byte[] f14262c;

    /* JADX INFO: renamed from: d */
    private Charset f14263d;

    /* JADX INFO: renamed from: e */
    private String f14264e;

    /* JADX INFO: renamed from: f */
    private JSONObject f14265f;

    public RestResponse(Response response) {
        this.f14260a = response;
    }

    /* JADX INFO: renamed from: a */
    public int m14621a() {
        return this.f14260a.m15793c();
    }

    /* JADX INFO: renamed from: b */
    public boolean m14622b() {
        return this.f14260a.m15794d();
    }

    /* JADX INFO: renamed from: c */
    public void m14623c() throws IOException {
        if (!this.f14261b && this.f14260a != null) {
            try {
                ResponseBody responseBodyM15798h = this.f14260a.m15798h();
                if (responseBodyM15798h != null) {
                    MediaType mediaTypeMo15511a = responseBodyM15798h.mo15511a();
                    this.f14262c = responseBodyM15798h.m15824d();
                    this.f14263d = (mediaTypeMo15511a == null || mediaTypeMo15511a.m15698b() == null) ? StandardCharsets.UTF_8 : mediaTypeMo15511a.m15698b();
                    if (this.f14262c != null && this.f14262c.length > 0) {
                        this.f14264e = new String(this.f14262c, this.f14263d);
                    }
                } else {
                    this.f14262c = new byte[0];
                    this.f14263d = StandardCharsets.UTF_8;
                }
                this.f14261b = true;
            } finally {
                this.f14260a.close();
            }
        }
    }

    /* JADX INFO: renamed from: d */
    public byte[] m14624d() throws IOException {
        if (this.f14262c == null) {
            m14623c();
        }
        return this.f14262c;
    }

    /* JADX INFO: renamed from: e */
    public String m14625e() throws IOException {
        if (this.f14264e == null) {
            this.f14264e = new String(m14624d(), this.f14263d);
        }
        return this.f14264e;
    }

    /* JADX INFO: renamed from: f */
    public JSONObject m14626f() throws JSONException, IOException {
        if (this.f14265f == null) {
            this.f14265f = new JSONObject(m14625e());
        }
        return this.f14265f;
    }

    public String toString() {
        try {
            return m14625e();
        } catch (Exception e) {
            SalesforceSDKLogger.m15016a("RestResponse", "Exception thrown while converting to string", e);
            return this.f14260a == null ? "" : this.f14260a.toString();
        }
    }
}
