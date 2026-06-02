package com.jibo.aws.integration.aws.services.robotProperties.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/* JADX INFO: loaded from: classes.dex */
public class Robot implements Parcelable {
    public static final Parcelable.Creator<Robot> CREATOR = new Parcelable.Creator<Robot>() { // from class: com.jibo.aws.integration.aws.services.robotProperties.model.Robot.1
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
    private Long created;
    private String guid;

    /* JADX INFO: renamed from: id */
    private String f9667id;
    private JsonObject payload;
    private Long updated;

    protected Robot(Parcel parcel) {
        this.f9667id = parcel.readString();
        this.guid = parcel.readString();
        try {
            this.payload = (JsonObject) new JsonParser().m9413a(parcel.readString());
        } catch (Exception e) {
            this.payload = new JsonObject();
        }
        this.created = Long.valueOf(parcel.readLong());
        this.updated = Long.valueOf(parcel.readLong());
    }

    public Robot(Robot robot) {
        this.f9667id = robot.f9667id;
        this.guid = robot.guid;
        this.payload = robot.payload;
        this.created = robot.created;
        this.updated = robot.updated;
    }

    public Robot(String str, String str2, JsonObject jsonObject, long j, long j2) {
        this.f9667id = str;
        this.guid = str2;
        this.payload = jsonObject == null ? new JsonObject() : jsonObject;
        this.created = j == 0 ? null : Long.valueOf(j);
        this.updated = j2 != 0 ? Long.valueOf(j2) : null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Robot)) {
            return false;
        }
        Robot robot = (Robot) obj;
        if ((robot.getId() == null) ^ (getId() == null)) {
            return false;
        }
        if (robot.getId() != null && !robot.getId().equals(getId())) {
            return false;
        }
        if ((robot.getGuid() == null) ^ (getGuid() == null)) {
            return false;
        }
        if (robot.getGuid() != null && !robot.getGuid().equals(getGuid())) {
            return false;
        }
        if ((robot.getPayload() == null) ^ (getPayload() == null)) {
            return false;
        }
        if (robot.getPayload() != null && !robot.getPayload().equals(getPayload())) {
            return false;
        }
        if ((robot.getUpdatedMilliseconds() == null) ^ (getUpdatedMilliseconds() == null)) {
            return false;
        }
        if (robot.getUpdatedMilliseconds() != null && !robot.getUpdatedMilliseconds().equals(getUpdatedMilliseconds())) {
            return false;
        }
        if ((robot.getCreatedMilliseconds() == null) ^ (getCreatedMilliseconds() == null)) {
            return false;
        }
        return robot.getCreatedMilliseconds() == null || robot.getCreatedMilliseconds().equals(getCreatedMilliseconds());
    }

    public Long getCreatedMilliseconds() {
        return this.created;
    }

    public String getGuid() {
        return this.guid;
    }

    public String getId() {
        return this.f9667id;
    }

    public JsonObject getPayload() {
        return this.payload;
    }

    public Long getUpdatedMilliseconds() {
        return this.updated;
    }

    public int hashCode() {
        return (((getUpdatedMilliseconds() == null ? 0 : getUpdatedMilliseconds().hashCode()) + (((getPayload() == null ? 0 : getPayload().hashCode()) + (((getGuid() == null ? 0 : getGuid().hashCode()) + (((getId() == null ? 0 : getId().hashCode()) + 31) * 31)) * 31)) * 31)) * 31) + (getCreatedMilliseconds() != null ? getCreatedMilliseconds().hashCode() : 0);
    }

    public void setCreatedMilliseconds(Long l) {
        this.created = l;
    }

    public void setGuid(String str) {
        this.guid = str;
    }

    public void setId(String str) {
        this.f9667id = str;
    }

    public void setPayload(JsonObject jsonObject) {
        this.payload = jsonObject;
    }

    public void setUpdatedMilliseconds(Long l) {
        this.updated = l;
    }

    public String toString() {
        return "Robot {id='" + this.f9667id + "'guid='" + this.guid + "', payload='" + this.payload + "', updated=" + this.updated + ", created=" + this.created + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f9667id);
        parcel.writeString(this.guid);
        parcel.writeString(this.payload != null ? this.payload.toString() : new JsonObject().toString());
        parcel.writeLong(this.created == null ? 0L : this.created.longValue());
        parcel.writeLong(this.updated != null ? this.updated.longValue() : 0L);
    }
}
