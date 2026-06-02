package com.mixpanel.android.mpmetrics;

import android.os.Parcel;
import android.os.Parcelable;
import com.mixpanel.android.mpmetrics.InAppNotification;
import com.mixpanel.android.util.JSONUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class MiniInAppNotification extends InAppNotification {
    public static final Parcelable.Creator<MiniInAppNotification> CREATOR = new Parcelable.Creator<MiniInAppNotification>() { // from class: com.mixpanel.android.mpmetrics.MiniInAppNotification.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public MiniInAppNotification createFromParcel(Parcel parcel) {
            return new MiniInAppNotification(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public MiniInAppNotification[] newArray(int i) {
            return new MiniInAppNotification[i];
        }
    };

    /* JADX INFO: renamed from: e */
    private final String f11952e;

    /* JADX INFO: renamed from: f */
    private final int f11953f;

    /* JADX INFO: renamed from: g */
    private final int f11954g;

    public MiniInAppNotification(Parcel parcel) {
        super(parcel);
        this.f11952e = parcel.readString();
        this.f11953f = parcel.readInt();
        this.f11954g = parcel.readInt();
    }

    MiniInAppNotification(JSONObject jSONObject) throws BadDecideObjectException {
        super(jSONObject);
        try {
            this.f11952e = JSONUtils.m12019a(jSONObject, "cta_url");
            this.f11953f = jSONObject.getInt("image_tint_color");
            this.f11954g = jSONObject.getInt("border_color");
        } catch (JSONException e) {
            throw new BadDecideObjectException("Notification JSON was unexpected or bad", e);
        }
    }

    /* JADX INFO: renamed from: n */
    public String m11809n() {
        return this.f11952e;
    }

    /* JADX INFO: renamed from: o */
    public int m11810o() {
        return this.f11953f;
    }

    /* JADX INFO: renamed from: p */
    public int m11811p() {
        return this.f11954g;
    }

    @Override // com.mixpanel.android.mpmetrics.InAppNotification, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.f11952e);
        parcel.writeInt(this.f11953f);
        parcel.writeInt(this.f11954g);
    }

    @Override // com.mixpanel.android.mpmetrics.InAppNotification
    /* JADX INFO: renamed from: d */
    public InAppNotification.Type mo11751d() {
        return InAppNotification.Type.MINI;
    }
}
