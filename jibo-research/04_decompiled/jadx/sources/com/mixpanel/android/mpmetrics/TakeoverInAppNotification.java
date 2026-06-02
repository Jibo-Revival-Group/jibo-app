package com.mixpanel.android.mpmetrics;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.internal.ShareConstants;
import com.mixpanel.android.mpmetrics.InAppNotification;
import com.mixpanel.android.util.JSONUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class TakeoverInAppNotification extends InAppNotification {
    public static final Parcelable.Creator<TakeoverInAppNotification> CREATOR = new Parcelable.Creator<TakeoverInAppNotification>() { // from class: com.mixpanel.android.mpmetrics.TakeoverInAppNotification.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public TakeoverInAppNotification createFromParcel(Parcel parcel) {
            return new TakeoverInAppNotification(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public TakeoverInAppNotification[] newArray(int i) {
            return new TakeoverInAppNotification[i];
        }
    };

    /* JADX INFO: renamed from: e */
    private final ArrayList<InAppButton> f12029e;

    /* JADX INFO: renamed from: f */
    private final int f12030f;

    /* JADX INFO: renamed from: g */
    private final String f12031g;

    /* JADX INFO: renamed from: h */
    private final int f12032h;

    /* JADX INFO: renamed from: i */
    private final boolean f12033i;

    public TakeoverInAppNotification(Parcel parcel) {
        super(parcel);
        this.f12029e = parcel.createTypedArrayList(InAppButton.CREATOR);
        this.f12030f = parcel.readInt();
        this.f12031g = parcel.readString();
        this.f12032h = parcel.readInt();
        this.f12033i = parcel.readByte() != 0;
    }

    TakeoverInAppNotification(JSONObject jSONObject) throws BadDecideObjectException {
        super(jSONObject);
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("buttons");
            this.f12029e = new ArrayList<>();
            for (int i = 0; i < jSONArray.length(); i++) {
                this.f12029e.add(new InAppButton((JSONObject) jSONArray.get(i)));
            }
            this.f12030f = jSONObject.getInt("close_color");
            this.f12031g = JSONUtils.m12019a(jSONObject, ShareConstants.WEB_DIALOG_PARAM_TITLE);
            this.f12032h = jSONObject.optInt("title_color");
            this.f12033i = m11760m().getBoolean("image_fade");
        } catch (JSONException e) {
            throw new BadDecideObjectException("Notification JSON was unexpected or bad", e);
        }
    }

    /* JADX INFO: renamed from: n */
    public boolean m11945n() {
        return this.f12031g != null;
    }

    /* JADX INFO: renamed from: o */
    public String m11946o() {
        return this.f12031g;
    }

    /* JADX INFO: renamed from: p */
    public int m11947p() {
        return this.f12032h;
    }

    /* JADX INFO: renamed from: q */
    public int m11948q() {
        return this.f12030f;
    }

    /* JADX INFO: renamed from: a */
    public InAppButton m11944a(int i) {
        if (this.f12029e.size() > i) {
            return this.f12029e.get(i);
        }
        return null;
    }

    /* JADX INFO: renamed from: r */
    public int m11949r() {
        return this.f12029e.size();
    }

    /* JADX INFO: renamed from: s */
    public boolean m11950s() {
        return this.f12033i;
    }

    @Override // com.mixpanel.android.mpmetrics.InAppNotification, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeTypedList(this.f12029e);
        parcel.writeInt(this.f12030f);
        parcel.writeString(this.f12031g);
        parcel.writeInt(this.f12032h);
        parcel.writeByte((byte) (this.f12033i ? 1 : 0));
    }

    @Override // com.mixpanel.android.mpmetrics.InAppNotification
    /* JADX INFO: renamed from: d */
    public InAppNotification.Type mo11751d() {
        return InAppNotification.Type.TAKEOVER;
    }
}
