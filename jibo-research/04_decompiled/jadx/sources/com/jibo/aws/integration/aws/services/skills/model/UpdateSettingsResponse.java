package com.jibo.aws.integration.aws.services.skills.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class UpdateSettingsResponse implements Parcelable, Serializable {
    public static final Parcelable.Creator<UpdateSettingsResponse> CREATOR = new Parcelable.Creator<UpdateSettingsResponse>() { // from class: com.jibo.aws.integration.aws.services.skills.model.UpdateSettingsResponse.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UpdateSettingsResponse createFromParcel(Parcel parcel) {
            return new UpdateSettingsResponse(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UpdateSettingsResponse[] newArray(int i) {
            return new UpdateSettingsResponse[i];
        }
    };

    public UpdateSettingsResponse() {
    }

    protected UpdateSettingsResponse(Parcel parcel) {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
    }
}
