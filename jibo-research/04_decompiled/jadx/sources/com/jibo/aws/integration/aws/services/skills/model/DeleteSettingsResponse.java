package com.jibo.aws.integration.aws.services.skills.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class DeleteSettingsResponse implements Parcelable, Serializable {
    public static final Parcelable.Creator<DeleteSettingsResponse> CREATOR = new Parcelable.Creator<DeleteSettingsResponse>() { // from class: com.jibo.aws.integration.aws.services.skills.model.DeleteSettingsResponse.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DeleteSettingsResponse createFromParcel(Parcel parcel) {
            return new DeleteSettingsResponse(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DeleteSettingsResponse[] newArray(int i) {
            return new DeleteSettingsResponse[i];
        }
    };

    public DeleteSettingsResponse() {
    }

    protected DeleteSettingsResponse(Parcel parcel) {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
    }
}
