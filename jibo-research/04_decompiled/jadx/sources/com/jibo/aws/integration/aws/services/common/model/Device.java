package com.jibo.aws.integration.aws.services.common.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class Device extends AmazonWebServiceRequest implements Parcelable, Serializable {
    public static final Parcelable.Creator<Device> CREATOR = new Parcelable.Creator<Device>() { // from class: com.jibo.aws.integration.aws.services.common.model.Device.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Device createFromParcel(Parcel parcel) {
            return new Device(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Device[] newArray(int i) {
            return new Device[i];
        }
    };
    private String name;
    private String pushToken;
    private Type type;

    public enum Type {
        ios,
        android
    }

    private Device(Parcel parcel) {
        this.name = parcel.readString();
        this.pushToken = parcel.readString();
        this.type = Type.values()[parcel.readInt()];
    }

    public Device(String str, String str2, Type type) {
        this.name = str;
        this.pushToken = str2;
        this.type = type;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Device)) {
            return false;
        }
        Device device = (Device) obj;
        if ((device.getName() == null) ^ (getName() == null)) {
            return false;
        }
        if (device.getName() != null && !device.getName().equals(getName())) {
            return false;
        }
        if ((device.getPushToken() == null) ^ (getPushToken() == null)) {
            return false;
        }
        if (device.getPushToken() != null && !device.getPushToken().equals(getPushToken())) {
            return false;
        }
        if ((device.getType() == null) ^ (getType() == null)) {
            return false;
        }
        return device.getType() == null || device.getType().equals(getType());
    }

    public String getName() {
        return this.name;
    }

    public String getPushToken() {
        return this.pushToken;
    }

    public Type getType() {
        return this.type;
    }

    public int hashCode() {
        return (((getPushToken() == null ? 0 : getPushToken().hashCode()) + (((getName() == null ? 0 : getName().hashCode()) + 31) * 31)) * 31) + (getType() != null ? getType().hashCode() : 0);
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPushToken(String str) {
        this.pushToken = str;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String toString() {
        return "Device {name='" + this.name + "', pushToken='" + this.pushToken + "', type=" + this.type + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeString(this.pushToken);
        parcel.writeInt(this.type == null ? Type.android.ordinal() : this.type.ordinal());
    }
}
