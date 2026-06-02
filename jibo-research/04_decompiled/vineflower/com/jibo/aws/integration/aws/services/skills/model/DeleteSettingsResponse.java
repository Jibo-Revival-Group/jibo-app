package com.jibo.aws.integration.aws.services.skills.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.Serializable;

public class DeleteSettingsResponse implements Parcelable, Serializable {
   public static final Creator<DeleteSettingsResponse> CREATOR = new Creator<DeleteSettingsResponse>() {
      public DeleteSettingsResponse createFromParcel(Parcel var1) {
         return new DeleteSettingsResponse(var1);
      }

      public DeleteSettingsResponse[] newArray(int var1) {
         return new DeleteSettingsResponse[var1];
      }
   };

   public DeleteSettingsResponse() {
   }

   protected DeleteSettingsResponse(Parcel var1) {
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
   }
}
