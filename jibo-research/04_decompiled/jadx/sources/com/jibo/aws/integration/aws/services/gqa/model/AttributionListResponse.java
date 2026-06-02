package com.jibo.aws.integration.aws.services.gqa.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class AttributionListResponse implements Parcelable, Serializable {
    public static final Parcelable.Creator<AttributionListResponse> CREATOR = new Parcelable.Creator<AttributionListResponse>() { // from class: com.jibo.aws.integration.aws.services.gqa.model.AttributionListResponse.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AttributionListResponse createFromParcel(Parcel parcel) {
            return new AttributionListResponse(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AttributionListResponse[] newArray(int i) {
            return new AttributionListResponse[i];
        }
    };
    private List<Attribution> data;

    public AttributionListResponse() {
    }

    protected AttributionListResponse(Parcel parcel) {
        this.data = parcel.createTypedArrayList(Attribution.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AttributionListResponse) {
            return getData().equals(((AttributionListResponse) obj).getData());
        }
        return false;
    }

    public List<Attribution> getData() {
        return this.data;
    }

    public int hashCode() {
        return getData().hashCode();
    }

    public void setData(List<Attribution> list) {
        this.data = list;
    }

    public String toString() {
        return "AttributionListResponse{data=" + this.data + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.data);
    }
}
