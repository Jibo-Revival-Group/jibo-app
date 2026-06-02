package com.jibo.aws.integration.aws.services.loop.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class Loop implements Parcelable, Serializable {
    public static final Parcelable.Creator<Loop> CREATOR = new Parcelable.Creator<Loop>() { // from class: com.jibo.aws.integration.aws.services.loop.model.Loop.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Loop createFromParcel(Parcel parcel) {
            return new Loop(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Loop[] newArray(int i) {
            return new Loop[i];
        }
    };
    private Long created;

    /* JADX INFO: renamed from: id */
    private String f9566id;
    private Boolean isSuspended;
    private List<Member> members;
    private String name;
    private String owner;
    private String robot;
    private String robotFriendlyId;
    private Long updated;

    public Loop() {
    }

    protected Loop(Parcel parcel) {
        this.f9566id = parcel.readString();
        this.name = parcel.readString();
        this.owner = parcel.readString();
        this.robot = parcel.readString();
        this.robotFriendlyId = parcel.readString();
        this.members = parcel.createTypedArrayList(Member.CREATOR);
        this.created = Long.valueOf(parcel.readLong());
        this.updated = Long.valueOf(parcel.readLong());
        this.isSuspended = Boolean.valueOf(parcel.readByte() != 0);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Loop)) {
            return false;
        }
        Loop loop = (Loop) obj;
        if ((loop.getId() == null) ^ (getId() == null)) {
            return false;
        }
        if (loop.getId() != null && !loop.getId().equals(getId())) {
            return false;
        }
        if ((loop.getName() == null) ^ (getName() == null)) {
            return false;
        }
        if (loop.getName() != null && !loop.getName().equals(getName())) {
            return false;
        }
        if ((loop.getOwner() == null) ^ (getOwner() == null)) {
            return false;
        }
        if (loop.getOwner() != null && !loop.getOwner().equals(getOwner())) {
            return false;
        }
        if ((loop.getRobot() == null) ^ (getRobot() == null)) {
            return false;
        }
        if (loop.getRobot() != null && !loop.getRobot().equals(getRobot())) {
            return false;
        }
        if ((loop.getRobotFriendlyId() == null) ^ (getRobotFriendlyId() == null)) {
            return false;
        }
        if (loop.getRobotFriendlyId() != null && !loop.getRobotFriendlyId().equals(getRobotFriendlyId())) {
            return false;
        }
        if ((loop.isSuspended() == null) ^ (isSuspended() == null)) {
            return false;
        }
        if (loop.isSuspended() != null && !loop.isSuspended().equals(isSuspended())) {
            return false;
        }
        if ((loop.getMembers() == null) ^ (getMembers() == null)) {
            return false;
        }
        return loop.getMembers() == null || loop.getMembers().equals(getMembers());
    }

    public Long getCreated() {
        return this.created;
    }

    public String getId() {
        return this.f9566id;
    }

    public List<Member> getMembers() {
        return this.members;
    }

    public String getName() {
        return this.name;
    }

    public String getOwner() {
        return this.owner;
    }

    public String getRobot() {
        return this.robot;
    }

    public String getRobotFriendlyId() {
        return this.robotFriendlyId;
    }

    public Long getUpdated() {
        return this.updated;
    }

    public int hashCode() {
        return (((getUpdated() == null ? 0 : getUpdated().hashCode()) + (((getCreated() == null ? 0 : getCreated().hashCode()) + (((getMembers() == null ? 0 : getMembers().hashCode()) + (((getRobotFriendlyId() == null ? 0 : getRobotFriendlyId().hashCode()) + (((getRobot() == null ? 0 : getRobot().hashCode()) + (((getOwner() == null ? 0 : getOwner().hashCode()) + (((getName() == null ? 0 : getName().hashCode()) + (((getId() == null ? 0 : getId().hashCode()) + 31) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31) + (isSuspended() != null ? isSuspended().hashCode() : 0);
    }

    public Boolean isSuspended() {
        return Boolean.valueOf(this.isSuspended == null ? false : this.isSuspended.booleanValue());
    }

    public void setCreated(Long l) {
        this.created = l;
    }

    public void setId(String str) {
        this.f9566id = str;
    }

    public void setMembers(List<Member> list) {
        this.members = list;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setOwner(String str) {
        this.owner = str;
    }

    public void setRobot(String str) {
        this.robot = str;
    }

    public void setRobotFriendlyId(String str) {
        this.robotFriendlyId = str;
    }

    public void setSuspended(Boolean bool) {
        this.isSuspended = bool;
    }

    public void setUpdated(Long l) {
        this.updated = l;
    }

    public String toString() {
        return "Loop {id='" + this.f9566id + "'name='" + this.name + "'owner='" + this.owner + "'robot='" + this.robot + "'robotFriendlyId='" + this.robotFriendlyId + "'members='" + this.members + "'isSuspended='" + this.isSuspended + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 0;
        parcel.writeString(this.f9566id);
        parcel.writeString(this.name);
        parcel.writeString(this.owner);
        parcel.writeString(this.robot);
        parcel.writeString(this.robotFriendlyId);
        parcel.writeTypedList(this.members);
        parcel.writeLong(this.created.longValue());
        parcel.writeLong(this.updated.longValue());
        if (this.isSuspended != null && this.isSuspended.booleanValue()) {
            i2 = 1;
        }
        parcel.writeByte((byte) i2);
    }
}
