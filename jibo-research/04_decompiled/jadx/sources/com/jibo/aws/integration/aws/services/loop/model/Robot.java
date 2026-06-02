package com.jibo.aws.integration.aws.services.loop.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class Robot implements Parcelable, Serializable {
    public static final Parcelable.Creator<Robot> CREATOR = new Parcelable.Creator<Robot>() { // from class: com.jibo.aws.integration.aws.services.loop.model.Robot.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Robot createFromParcel(Parcel parcel) {
            return new Robot(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Robot[] newArray(int i) {
            return new Robot[i];
        }
    };

    /* JADX INFO: renamed from: id */
    @Expose
    private String f9570id;

    protected Robot(Parcel parcel) {
        this.f9570id = parcel.readString();
    }

    public Robot(String str) {
        this.f9570id = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getId() {
        return this.f9570id;
    }

    public void setId(String str) {
        this.f9570id = str;
    }

    public String toString() {
        return "Robot {id='" + this.f9570id + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f9570id);
    }
}
