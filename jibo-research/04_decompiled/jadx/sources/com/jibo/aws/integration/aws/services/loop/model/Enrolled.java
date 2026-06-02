package com.jibo.aws.integration.aws.services.loop.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class Enrolled implements Parcelable, Serializable {
    public static final Parcelable.Creator<Enrolled> CREATOR = new Parcelable.Creator<Enrolled>() { // from class: com.jibo.aws.integration.aws.services.loop.model.Enrolled.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Enrolled createFromParcel(Parcel parcel) {
            return new Enrolled(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Enrolled[] newArray(int i) {
            return new Enrolled[i];
        }
    };

    @Expose
    private Boolean face;

    @Expose
    private Boolean voice;

    public Enrolled() {
    }

    protected Enrolled(Parcel parcel) {
        this.face = Boolean.valueOf(parcel.readInt() > 0);
        this.voice = Boolean.valueOf(parcel.readInt() > 0);
    }

    public Enrolled(Boolean bool, Boolean bool2) {
        this.face = bool;
        this.voice = bool2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Enrolled)) {
            return false;
        }
        Enrolled enrolled = (Enrolled) obj;
        if ((enrolled.getFace() == null) ^ (getFace() == null)) {
            return false;
        }
        if (enrolled.getFace() != null && !enrolled.getFace().equals(getFace())) {
            return false;
        }
        if ((enrolled.getVoice() == null) ^ (getVoice() == null)) {
            return false;
        }
        return enrolled.getVoice() == null || enrolled.getVoice().equals(getVoice());
    }

    public Boolean getFace() {
        return this.face;
    }

    public Boolean getVoice() {
        return this.voice;
    }

    public int hashCode() {
        return (((getFace() == null ? 0 : getFace().hashCode()) + 31) * 31) + (getVoice() != null ? getVoice().hashCode() : 0);
    }

    public void setFace(boolean z) {
        this.face = Boolean.valueOf(z);
    }

    public void setVoice(boolean z) {
        this.voice = Boolean.valueOf(z);
    }

    public String toString() {
        return "Enrolled {face='" + this.face + "', voice='" + this.voice + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt((this.face == null || !this.face.booleanValue()) ? 0 : 1);
        parcel.writeInt((this.voice == null || !this.voice.booleanValue()) ? 0 : 1);
    }
}
