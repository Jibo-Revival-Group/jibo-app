package com.jibo.aws.integration.aws.services.gqa.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.Serializable;

public class GQAAttribution implements Parcelable, Serializable {
   public static final Creator<GQAAttribution> CREATOR = new Creator<GQAAttribution>() {
      public GQAAttribution createFromParcel(Parcel var1) {
         return new GQAAttribution(var1);
      }

      public GQAAttribution[] newArray(int var1) {
         return new GQAAttribution[var1];
      }
   };
   private String answer;
   private String source;
   private boolean success;

   public GQAAttribution() {
   }

   protected GQAAttribution(Parcel var1) {
      boolean var2;
      if (var1.readByte() != 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      this.success = var2;
      this.source = var1.readString();
      this.answer = var1.readString();
   }

   public int describeContents() {
      return 0;
   }

   @Override
   public boolean equals(Object var1) {
      boolean var4 = true;
      boolean var3 = false;
      boolean var2;
      if (this == var1) {
         var2 = true;
      } else {
         var2 = var3;
         if (var1 instanceof GQAAttribution) {
            var1 = var1;
            var2 = var3;
            if (this.isSuccess() == var1.isSuccess()) {
               if (this.getSource() != null) {
                  var2 = var3;
                  if (!this.getSource().equals(var1.getSource())) {
                     return var2;
                  }
               } else if (var1.getSource() != null) {
                  var2 = var3;
                  return var2;
               }

               if (this.getAnswer() != null) {
                  var2 = this.getAnswer().equals(var1.getAnswer());
               } else {
                  var2 = var4;
                  if (var1.getAnswer() != null) {
                     var2 = false;
                  }
               }
            }
         }
      }

      return var2;
   }

   public String getAnswer() {
      return this.answer;
   }

   public String getSource() {
      return this.source;
   }

   @Override
   public int hashCode() {
      int var3 = 0;
      byte var1;
      if (this.isSuccess()) {
         var1 = 1;
      } else {
         var1 = 0;
      }

      int var2;
      if (this.getSource() != null) {
         var2 = this.getSource().hashCode();
      } else {
         var2 = 0;
      }

      if (this.getAnswer() != null) {
         var3 = this.getAnswer().hashCode();
      }

      return (var2 + var1 * 31) * 31 + var3;
   }

   public boolean isSuccess() {
      return this.success;
   }

   public void setAnswer(String var1) {
      this.answer = var1;
   }

   public void setSource(String var1) {
      this.source = var1;
   }

   public void setSuccess(boolean var1) {
      this.success = var1;
   }

   @Override
   public String toString() {
      return "GQAAttribution{success=" + this.success + ", source='" + this.source + '\'' + ", answer='" + this.answer + '\'' + '}';
   }

   public void writeToParcel(Parcel var1, int var2) {
      byte var3;
      if (this.success) {
         var3 = 1;
      } else {
         var3 = 0;
      }

      var1.writeByte((byte)var3);
      var1.writeString(this.source);
      var1.writeString(this.answer);
   }
}
