package com.jibo.aws.integration.aws.services.loop.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import java.io.Serializable;

public class Enrolled implements Parcelable, Serializable {
   public static final Creator<Enrolled> CREATOR = new Creator<Enrolled>() {
      public Enrolled createFromParcel(Parcel var1) {
         return new Enrolled(var1);
      }

      public Enrolled[] newArray(int var1) {
         return new Enrolled[var1];
      }
   };
   @Expose
   private Boolean face;
   @Expose
   private Boolean voice;

   public Enrolled() {
   }

   protected Enrolled(Parcel var1) {
      boolean var3 = true;
      super();
      boolean var2;
      if (var1.readInt() > 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      this.face = var2;
      if (var1.readInt() > 0) {
         var2 = var3;
      } else {
         var2 = false;
      }

      this.voice = var2;
   }

   public Enrolled(Boolean var1, Boolean var2) {
      this.face = var1;
      this.voice = var2;
   }

   public int describeContents() {
      return 0;
   }

   @Override
   public boolean equals(Object var1) {
      boolean var5 = false;
      boolean var4;
      if (this == var1) {
         var4 = true;
      } else {
         var4 = var5;
         if (var1 != null) {
            var4 = var5;
            if (var1 instanceof Enrolled) {
               var1 = var1;
               boolean var2;
               if (var1.getFace() == null) {
                  var2 = true;
               } else {
                  var2 = false;
               }

               boolean var3;
               if (this.getFace() == null) {
                  var3 = true;
               } else {
                  var3 = false;
               }

               var4 = var5;
               if (!(var2 ^ var3)) {
                  if (var1.getFace() != null) {
                     var4 = var5;
                     if (!var1.getFace().equals(this.getFace())) {
                        return var4;
                     }
                  }

                  if (var1.getVoice() == null) {
                     var2 = true;
                  } else {
                     var2 = false;
                  }

                  if (this.getVoice() == null) {
                     var3 = true;
                  } else {
                     var3 = false;
                  }

                  var4 = var5;
                  if (!(var2 ^ var3)) {
                     if (var1.getVoice() != null) {
                        var4 = var5;
                        if (!var1.getVoice().equals(this.getVoice())) {
                           return var4;
                        }
                     }

                     var4 = true;
                  }
               }
            }
         }
      }

      return var4;
   }

   public Boolean getFace() {
      return this.face;
   }

   public Boolean getVoice() {
      return this.voice;
   }

   @Override
   public int hashCode() {
      int var2 = 0;
      int var1;
      if (this.getFace() == null) {
         var1 = 0;
      } else {
         var1 = this.getFace().hashCode();
      }

      if (this.getVoice() != null) {
         var2 = this.getVoice().hashCode();
      }

      return (var1 + 31) * 31 + var2;
   }

   public void setFace(boolean var1) {
      this.face = var1;
   }

   public void setVoice(boolean var1) {
      this.voice = var1;
   }

   @Override
   public String toString() {
      return "Enrolled {face='" + this.face + '\'' + ", voice='" + this.voice + '\'' + '}';
   }

   public void writeToParcel(Parcel var1, int var2) {
      byte var3 = 1;
      byte var4;
      if (this.face != null && this.face) {
         var4 = 1;
      } else {
         var4 = 0;
      }

      label15: {
         var1.writeInt(var4);
         if (this.voice != null) {
            var4 = var3;
            if (this.voice) {
               break label15;
            }
         }

         var4 = 0;
      }

      var1.writeInt(var4);
   }
}
