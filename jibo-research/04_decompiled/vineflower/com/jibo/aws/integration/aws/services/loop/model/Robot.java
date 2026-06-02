package com.jibo.aws.integration.aws.services.loop.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import java.io.Serializable;

public class Robot implements Parcelable, Serializable {
   public static final Creator<Robot> CREATOR = new Creator<Robot>() {
      public Robot createFromParcel(Parcel var1) {
         return new Robot(var1);
      }

      public Robot[] newArray(int var1) {
         return new Robot[var1];
      }
   };
   @Expose
   private String id;

   protected Robot(Parcel var1) {
      this.id = var1.readString();
   }

   public Robot(String var1) {
      this.id = var1;
   }

   public int describeContents() {
      return 0;
   }

   public String getId() {
      return this.id;
   }

   public void setId(String var1) {
      this.id = var1;
   }

   @Override
   public String toString() {
      return "Robot {id='" + this.id + '\'' + '}';
   }

   public void writeToParcel(Parcel var1, int var2) {
      var1.writeString(this.id);
   }
}
