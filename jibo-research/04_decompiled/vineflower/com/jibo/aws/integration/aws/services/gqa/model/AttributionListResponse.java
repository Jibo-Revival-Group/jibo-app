package com.jibo.aws.integration.aws.services.gqa.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.Serializable;
import java.util.List;

public class AttributionListResponse implements Parcelable, Serializable {
   public static final Creator<AttributionListResponse> CREATOR = new Creator<AttributionListResponse>() {
      public AttributionListResponse createFromParcel(Parcel var1) {
         return new AttributionListResponse(var1);
      }

      public AttributionListResponse[] newArray(int var1) {
         return new AttributionListResponse[var1];
      }
   };
   private List<Attribution> data;

   public AttributionListResponse() {
   }

   protected AttributionListResponse(Parcel var1) {
      this.data = var1.createTypedArrayList(Attribution.CREATOR);
   }

   public int describeContents() {
      return 0;
   }

   @Override
   public boolean equals(Object var1) {
      boolean var2;
      if (this == var1) {
         var2 = true;
      } else if (!(var1 instanceof AttributionListResponse)) {
         var2 = false;
      } else {
         var1 = var1;
         var2 = this.getData().equals(var1.getData());
      }

      return var2;
   }

   public List<Attribution> getData() {
      return this.data;
   }

   @Override
   public int hashCode() {
      return this.getData().hashCode();
   }

   public void setData(List<Attribution> var1) {
      this.data = var1;
   }

   @Override
   public String toString() {
      return "AttributionListResponse{data=" + this.data + '}';
   }

   public void writeToParcel(Parcel var1, int var2) {
      var1.writeTypedList(this.data);
   }
}
