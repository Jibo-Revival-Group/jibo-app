package com.mixpanel.android.mpmetrics;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class InAppButton implements Parcelable {
    public static final Parcelable.Creator<InAppButton> CREATOR = new Parcelable.Creator<InAppButton>() { // from class: com.mixpanel.android.mpmetrics.InAppButton.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public InAppButton createFromParcel(Parcel parcel) {
            return new InAppButton(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public InAppButton[] newArray(int i) {
            return new InAppButton[i];
        }
    };

    /* JADX INFO: renamed from: a */
    private JSONObject f11877a;

    /* JADX INFO: renamed from: b */
    private String f11878b;

    /* JADX INFO: renamed from: c */
    private int f11879c;

    /* JADX INFO: renamed from: d */
    private int f11880d;

    /* JADX INFO: renamed from: e */
    private int f11881e;

    /* JADX INFO: renamed from: f */
    private String f11882f;

    public InAppButton(Parcel parcel) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject = new JSONObject(parcel.readString());
        } catch (JSONException e) {
            Log.e("MixpanelAPI.InAppButton", "Error reading JSON when creating InAppButton from Parcel");
            jSONObject = jSONObject2;
        }
        this.f11877a = jSONObject;
        this.f11878b = parcel.readString();
        this.f11879c = parcel.readInt();
        this.f11880d = parcel.readInt();
        this.f11881e = parcel.readInt();
        this.f11882f = parcel.readString();
    }

    InAppButton(JSONObject jSONObject) throws JSONException {
        this.f11877a = jSONObject;
        this.f11878b = jSONObject.getString("text");
        this.f11879c = jSONObject.getInt("text_color");
        this.f11880d = jSONObject.getInt("bg_color");
        this.f11881e = jSONObject.getInt("border_color");
        this.f11882f = jSONObject.getString("cta_url");
    }

    /* JADX INFO: renamed from: a */
    public String m11730a() {
        return this.f11878b;
    }

    /* JADX INFO: renamed from: b */
    public int m11731b() {
        return this.f11879c;
    }

    /* JADX INFO: renamed from: c */
    public int m11732c() {
        return this.f11880d;
    }

    /* JADX INFO: renamed from: d */
    public int m11733d() {
        return this.f11881e;
    }

    /* JADX INFO: renamed from: e */
    public String m11734e() {
        return this.f11882f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f11877a.toString());
        parcel.writeString(this.f11878b);
        parcel.writeInt(this.f11879c);
        parcel.writeInt(this.f11880d);
        parcel.writeInt(this.f11881e);
        parcel.writeString(this.f11882f);
    }

    public String toString() {
        return this.f11877a.toString();
    }
}
