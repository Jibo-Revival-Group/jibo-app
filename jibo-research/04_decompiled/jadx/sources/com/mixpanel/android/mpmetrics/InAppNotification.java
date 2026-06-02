package com.mixpanel.android.mpmetrics;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.applinks.AppLinkData;
import com.facebook.share.internal.ShareConstants;
import com.mixpanel.android.util.JSONUtils;
import com.mixpanel.android.util.MPLog;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class InAppNotification implements Parcelable {

    /* JADX INFO: renamed from: e */
    private static final Pattern f11898e = Pattern.compile("(\\.[^./]+$)");

    /* JADX INFO: renamed from: a */
    protected final JSONObject f11899a;

    /* JADX INFO: renamed from: b */
    protected final JSONObject f11900b;

    /* JADX INFO: renamed from: c */
    protected final int f11901c;

    /* JADX INFO: renamed from: d */
    protected final int f11902d;

    /* JADX INFO: renamed from: f */
    private final int f11903f;

    /* JADX INFO: renamed from: g */
    private final String f11904g;

    /* JADX INFO: renamed from: h */
    private final int f11905h;

    /* JADX INFO: renamed from: i */
    private final String f11906i;

    /* JADX INFO: renamed from: j */
    private Bitmap f11907j;

    public enum Type {
        UNKNOWN { // from class: com.mixpanel.android.mpmetrics.InAppNotification.Type.1
            @Override // java.lang.Enum
            public String toString() {
                return "*unknown_type*";
            }
        },
        MINI { // from class: com.mixpanel.android.mpmetrics.InAppNotification.Type.2
            @Override // java.lang.Enum
            public String toString() {
                return "mini";
            }
        },
        TAKEOVER { // from class: com.mixpanel.android.mpmetrics.InAppNotification.Type.3
            @Override // java.lang.Enum
            public String toString() {
                return "takeover";
            }
        }
    }

    /* JADX INFO: renamed from: d */
    public abstract Type mo11751d();

    public InAppNotification() {
        this.f11899a = null;
        this.f11900b = null;
        this.f11901c = 0;
        this.f11902d = 0;
        this.f11903f = 0;
        this.f11904g = null;
        this.f11905h = 0;
        this.f11906i = null;
    }

    public InAppNotification(Parcel parcel) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        JSONObject jSONObject3 = new JSONObject();
        JSONObject jSONObject4 = new JSONObject();
        try {
            JSONObject jSONObject5 = new JSONObject(parcel.readString());
            try {
                jSONObject2 = new JSONObject(parcel.readString());
                jSONObject = jSONObject5;
            } catch (JSONException e) {
                jSONObject3 = jSONObject5;
                MPLog.m12030e("MixpanelAPI.InAppNotif", "Error reading JSON when creating InAppNotification from Parcel");
                jSONObject = jSONObject3;
                jSONObject2 = jSONObject4;
            }
        } catch (JSONException e2) {
        }
        this.f11899a = jSONObject;
        this.f11900b = jSONObject2;
        this.f11901c = parcel.readInt();
        this.f11902d = parcel.readInt();
        this.f11903f = parcel.readInt();
        this.f11904g = parcel.readString();
        this.f11905h = parcel.readInt();
        this.f11906i = parcel.readString();
        this.f11907j = (Bitmap) parcel.readParcelable(Bitmap.class.getClassLoader());
    }

    InAppNotification(JSONObject jSONObject) throws BadDecideObjectException {
        try {
            this.f11899a = jSONObject;
            this.f11900b = jSONObject.getJSONObject(AppLinkData.ARGUMENTS_EXTRAS_KEY);
            this.f11901c = jSONObject.getInt(ShareConstants.WEB_DIALOG_PARAM_ID);
            this.f11902d = jSONObject.getInt("message_id");
            this.f11903f = jSONObject.getInt("bg_color");
            this.f11904g = JSONUtils.m12019a(jSONObject, "body");
            this.f11905h = jSONObject.optInt("body_color");
            this.f11906i = jSONObject.getString("image_url");
            this.f11907j = Bitmap.createBitmap(500, 500, Bitmap.Config.ARGB_8888);
        } catch (JSONException e) {
            throw new BadDecideObjectException("Notification JSON was unexpected or bad", e);
        }
    }

    /* JADX INFO: renamed from: a */
    JSONObject m11747a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("campaign_id", m11749b());
            jSONObject.put("message_id", m11750c());
            jSONObject.put("message_type", "inapp");
            jSONObject.put("message_subtype", mo11751d().toString());
        } catch (JSONException e) {
            MPLog.m12031e("MixpanelAPI.InAppNotif", "Impossible JSON Exception", e);
        }
        return jSONObject;
    }

    /* JADX INFO: renamed from: b */
    public int m11749b() {
        return this.f11901c;
    }

    /* JADX INFO: renamed from: c */
    public int m11750c() {
        return this.f11902d;
    }

    /* JADX INFO: renamed from: e */
    public int m11752e() {
        return this.f11903f;
    }

    /* JADX INFO: renamed from: f */
    public boolean m11753f() {
        return this.f11904g != null;
    }

    /* JADX INFO: renamed from: g */
    public String m11754g() {
        return this.f11904g;
    }

    /* JADX INFO: renamed from: h */
    public int m11755h() {
        return this.f11905h;
    }

    /* JADX INFO: renamed from: i */
    public String m11756i() {
        return this.f11906i;
    }

    /* JADX INFO: renamed from: j */
    public String m11757j() {
        return m11746a(this.f11906i, "@2x");
    }

    /* JADX INFO: renamed from: k */
    public String m11758k() {
        return m11746a(this.f11906i, "@4x");
    }

    /* JADX INFO: renamed from: a */
    void m11748a(Bitmap bitmap) {
        this.f11907j = bitmap;
    }

    /* JADX INFO: renamed from: l */
    public Bitmap m11759l() {
        return this.f11907j;
    }

    /* JADX INFO: renamed from: a */
    static String m11746a(String str, String str2) {
        Matcher matcher = f11898e.matcher(str);
        if (matcher.find()) {
            return matcher.replaceFirst(str2 + "$1");
        }
        return str;
    }

    /* JADX INFO: renamed from: m */
    protected JSONObject m11760m() {
        return this.f11900b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f11899a.toString());
        parcel.writeString(this.f11900b.toString());
        parcel.writeInt(this.f11901c);
        parcel.writeInt(this.f11902d);
        parcel.writeInt(this.f11903f);
        parcel.writeString(this.f11904g);
        parcel.writeInt(this.f11905h);
        parcel.writeString(this.f11906i);
        parcel.writeParcelable(this.f11907j, i);
    }

    public String toString() {
        return this.f11899a.toString();
    }
}
