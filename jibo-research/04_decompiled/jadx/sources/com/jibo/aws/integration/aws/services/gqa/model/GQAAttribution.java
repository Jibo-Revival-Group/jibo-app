package com.jibo.aws.integration.aws.services.gqa.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class GQAAttribution implements Parcelable, Serializable {
    public static final Parcelable.Creator<GQAAttribution> CREATOR = new Parcelable.Creator<GQAAttribution>() { // from class: com.jibo.aws.integration.aws.services.gqa.model.GQAAttribution.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GQAAttribution createFromParcel(Parcel parcel) {
            return new GQAAttribution(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GQAAttribution[] newArray(int i) {
            return new GQAAttribution[i];
        }
    };
    private String answer;
    private String source;
    private boolean success;

    public GQAAttribution() {
    }

    protected GQAAttribution(Parcel parcel) {
        this.success = parcel.readByte() != 0;
        this.source = parcel.readString();
        this.answer = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean zEquals = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GQAAttribution)) {
            return false;
        }
        GQAAttribution gQAAttribution = (GQAAttribution) obj;
        if (isSuccess() != gQAAttribution.isSuccess()) {
            return false;
        }
        if (getSource() != null) {
            if (!getSource().equals(gQAAttribution.getSource())) {
                return false;
            }
        } else if (gQAAttribution.getSource() != null) {
            return false;
        }
        if (getAnswer() != null) {
            zEquals = getAnswer().equals(gQAAttribution.getAnswer());
        } else if (gQAAttribution.getAnswer() != null) {
            zEquals = false;
        }
        return zEquals;
    }

    public String getAnswer() {
        return this.answer;
    }

    public String getSource() {
        return this.source;
    }

    public int hashCode() {
        return (((getSource() != null ? getSource().hashCode() : 0) + ((isSuccess() ? 1 : 0) * 31)) * 31) + (getAnswer() != null ? getAnswer().hashCode() : 0);
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setAnswer(String str) {
        this.answer = str;
    }

    public void setSource(String str) {
        this.source = str;
    }

    public void setSuccess(boolean z) {
        this.success = z;
    }

    public String toString() {
        return "GQAAttribution{success=" + this.success + ", source='" + this.source + "', answer='" + this.answer + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte((byte) (this.success ? 1 : 0));
        parcel.writeString(this.source);
        parcel.writeString(this.answer);
    }
}
