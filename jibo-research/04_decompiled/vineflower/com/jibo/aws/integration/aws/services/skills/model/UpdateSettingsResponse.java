package com.jibo.aws.integration.aws.services.skills.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.Serializable;

public class UpdateSettingsResponse implements Parcelable, Serializable {
   public static final Creator<UpdateSettingsResponse> CREATOR = new Creator<UpdateSettingsResponse>() {
      public UpdateSettingsResponse createFromParcel(Parcel var1) {
         return new UpdateSettingsResponse(var1);
      }

      public UpdateSettingsResponse[] newArray(int var1) {
         return new UpdateSettingsResponse[var1];
      }
   };

   public UpdateSettingsResponse() {
   }

   protected UpdateSettingsResponse(Parcel var1) {
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
   }
}
