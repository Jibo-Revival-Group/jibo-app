package com.jibo.aws.integration.aws.services.person.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class Holiday implements Parcelable, Serializable {
    public static final String CATEGORY_BIRTHDAY = "birthday";
    public static final String CATEGORY_CULTURAL = "cultural";
    public static final String CATEGORY_NATIONAL = "national";
    public static final String CATEGORY_PUBLIC = "public";
    public static final Parcelable.Creator<Holiday> CREATOR = new Parcelable.Creator<Holiday>() { // from class: com.jibo.aws.integration.aws.services.person.model.Holiday.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Holiday createFromParcel(Parcel parcel) {
            return new Holiday(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Holiday[] newArray(int i) {
            return new Holiday[i];
        }
    };

    @Expose
    private String category;

    @Expose
    private Long created;

    @Expose
    private String date;

    @Expose
    private String endDate;

    /* JADX INFO: renamed from: id */
    @Expose
    private String f9636id;

    @Expose
    private Boolean isEnabled;

    @Expose
    private String loopId;

    @Expose
    private String memberId;

    @Expose
    private String name;

    @Expose
    private String subcategory;

    public Holiday() {
    }

    private Holiday(Parcel parcel) {
        this.f9636id = parcel.readString();
        this.name = parcel.readString();
        this.loopId = parcel.readString();
        this.category = parcel.readString();
        this.subcategory = parcel.readString();
        this.memberId = parcel.readString();
        this.date = parcel.readString();
        this.endDate = parcel.readString();
        this.created = Long.valueOf(parcel.readLong());
        this.isEnabled = Boolean.valueOf(parcel.readInt() > 0);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Holiday)) {
            return false;
        }
        Holiday holiday = (Holiday) obj;
        if ((holiday.getId() == null) ^ (getId() == null)) {
            return false;
        }
        if (holiday.getId() != null && !holiday.getId().equals(getId())) {
            return false;
        }
        if ((holiday.getName() == null) ^ (getName() == null)) {
            return false;
        }
        if (holiday.getName() != null && !holiday.getName().equals(getName())) {
            return false;
        }
        if ((holiday.getLoopId() == null) ^ (getLoopId() == null)) {
            return false;
        }
        if (holiday.getLoopId() != null && !holiday.getLoopId().equals(getLoopId())) {
            return false;
        }
        if ((holiday.getCreated() == null) ^ (getCreated() == null)) {
            return false;
        }
        if (holiday.getCreated() != null && !holiday.getCreated().equals(getCreated())) {
            return false;
        }
        if ((holiday.getSubcategory() == null) ^ (getSubcategory() == null)) {
            return false;
        }
        if (holiday.getSubcategory() != null && !holiday.getSubcategory().equals(getSubcategory())) {
            return false;
        }
        if ((holiday.getMemberId() == null) ^ (getMemberId() == null)) {
            return false;
        }
        if (holiday.getMemberId() != null && !holiday.getMemberId().equals(getMemberId())) {
            return false;
        }
        if ((holiday.getEnabled() == null) ^ (getEnabled() == null)) {
            return false;
        }
        if (holiday.getEnabled() != null && !holiday.getEnabled().equals(getEnabled())) {
            return false;
        }
        if ((holiday.getDate() == null) ^ (getDate() == null)) {
            return false;
        }
        if (holiday.getDate() != null && !holiday.getDate().equals(getDate())) {
            return false;
        }
        if ((holiday.getEndDate() == null) ^ (getEndDate() == null)) {
            return false;
        }
        if (holiday.getEndDate() != null && !holiday.getEndDate().equals(getEndDate())) {
            return false;
        }
        if ((holiday.getCategory() == null) ^ (getCategory() == null)) {
            return false;
        }
        return holiday.getCategory() == null || holiday.getCategory().equals(getCategory());
    }

    public String getCategory() {
        return this.category;
    }

    public Long getCreated() {
        return this.created;
    }

    public String getDate() {
        return this.date;
    }

    public Boolean getEnabled() {
        return this.isEnabled;
    }

    public String getEndDate() {
        return this.endDate;
    }

    public String getId() {
        return this.f9636id;
    }

    public String getLoopId() {
        return this.loopId;
    }

    public String getMemberId() {
        return this.memberId;
    }

    public String getName() {
        return this.name;
    }

    public String getSubcategory() {
        return this.subcategory;
    }

    public int hashCode() {
        return (((getDate() == null ? 0 : getDate().hashCode()) + (((getEnabled() == null ? 0 : getEnabled().hashCode()) + (((getMemberId() == null ? 0 : getMemberId().hashCode()) + (((getSubcategory() == null ? 0 : getSubcategory().hashCode()) + (((getCreated() == null ? 0 : getCreated().hashCode()) + (((getCategory() == null ? 0 : getCategory().hashCode()) + (((getLoopId() == null ? 0 : getLoopId().hashCode()) + (((getName() == null ? 0 : getName().hashCode()) + (((getId() == null ? 0 : getId().hashCode()) + 31) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31) + (getEndDate() != null ? getEndDate().hashCode() : 0);
    }

    public void setCategory(String str) {
        this.category = str;
    }

    public void setCreated(Long l) {
        this.created = l;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public void setEnabled(Boolean bool) {
        this.isEnabled = bool;
    }

    public void setEndDate(String str) {
        this.endDate = str;
    }

    public void setId(String str) {
        this.f9636id = str;
    }

    public void setLoopId(String str) {
        this.loopId = str;
    }

    public void setMemberId(String str) {
        this.memberId = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setSubcategory(String str) {
        this.subcategory = str;
    }

    public String toString() {
        return "Holiday {id='" + this.f9636id + "'category='" + this.category + "'name='" + this.name + "'loopId='" + this.loopId + "'created='" + this.created + "'subcategory='" + this.subcategory + "'memberId='" + this.memberId + "'isEnabled='" + this.isEnabled + "'date='" + this.date + "'endDate='" + this.endDate + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f9636id);
        parcel.writeString(this.name);
        parcel.writeString(this.loopId);
        parcel.writeString(this.category);
        parcel.writeString(this.subcategory);
        parcel.writeString(this.memberId);
        parcel.writeString(this.date);
        parcel.writeString(this.endDate);
        parcel.writeLong(this.created == null ? -1L : this.created.longValue());
        parcel.writeInt((this.isEnabled == null || !this.isEnabled.booleanValue()) ? 0 : 1);
    }
}
