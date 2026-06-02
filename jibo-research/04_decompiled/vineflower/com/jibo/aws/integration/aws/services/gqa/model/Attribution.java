package com.jibo.aws.integration.aws.services.gqa.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.Serializable;

public class Attribution implements Parcelable, Serializable {
   public static final Creator<Attribution> CREATOR = new Creator<Attribution>() {
      public Attribution createFromParcel(Parcel var1) {
         return new Attribution(var1);
      }

      public Attribution[] newArray(int var1) {
         return new Attribution[var1];
      }
   };
   private String image_url;
   private String query;
   private String robot_id;
   private String service;
   private long timestamp;
   private String url;

   public Attribution() {
   }

   protected Attribution(Parcel var1) {
      this.service = var1.readString();
      this.query = var1.readString();
      this.url = var1.readString();
      this.robot_id = var1.readString();
      this.timestamp = var1.readLong();
      this.image_url = var1.readString();
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
         if (var1 instanceof Attribution) {
            var1 = var1;
            var2 = var3;
            if (this.getTimestamp() == var1.getTimestamp()) {
               if (this.getService() != null) {
                  var2 = var3;
                  if (!this.getService().equals(var1.getService())) {
                     return var2;
                  }
               } else if (var1.getService() != null) {
                  var2 = var3;
                  return var2;
               }

               if (this.getQuery() != null) {
                  var2 = var3;
                  if (!this.getQuery().equals(var1.getQuery())) {
                     return var2;
                  }
               } else if (var1.getQuery() != null) {
                  var2 = var3;
                  return var2;
               }

               if (this.getUrl() != null) {
                  var2 = var3;
                  if (!this.getUrl().equals(var1.getUrl())) {
                     return var2;
                  }
               } else if (var1.getUrl() != null) {
                  var2 = var3;
                  return var2;
               }

               if (this.getRobot_id() != null) {
                  var2 = var3;
                  if (!this.getRobot_id().equals(var1.getRobot_id())) {
                     return var2;
                  }
               } else if (var1.getRobot_id() != null) {
                  var2 = var3;
                  return var2;
               }

               if (this.getImage_url() != null) {
                  var2 = this.getImage_url().equals(var1.getImage_url());
               } else {
                  var2 = var4;
                  if (var1.getImage_url() != null) {
                     var2 = false;
                  }
               }
            }
         }
      }

      return var2;
   }

   public String getImage_url() {
      return this.image_url;
   }

   public String getQuery() {
      return this.query;
   }

   public String getRobot_id() {
      return this.robot_id;
   }

   public String getService() {
      return this.service;
   }

   public long getTimestamp() {
      return this.timestamp;
   }

   public String getUrl() {
      return this.url;
   }

   @Override
   public int hashCode() {
      int var5 = 0;
      int var1;
      if (this.getService() != null) {
         var1 = this.getService().hashCode();
      } else {
         var1 = 0;
      }

      int var2;
      if (this.getQuery() != null) {
         var2 = this.getQuery().hashCode();
      } else {
         var2 = 0;
      }

      int var3;
      if (this.getUrl() != null) {
         var3 = this.getUrl().hashCode();
      } else {
         var3 = 0;
      }

      int var4;
      if (this.getRobot_id() != null) {
         var4 = this.getRobot_id().hashCode();
      } else {
         var4 = 0;
      }

      if (this.getImage_url() != null) {
         var5 = this.getImage_url().hashCode();
      }

      return ((var4 + (var3 + (var2 + var1 * 31) * 31) * 31) * 31 + var5) * 31 + (int)(this.getTimestamp() ^ this.getTimestamp() >>> 32);
   }

   public void setImage_url(String var1) {
      this.image_url = var1;
   }

   public void setQuery(String var1) {
      this.query = var1;
   }

   public void setRobot_id(String var1) {
      this.robot_id = var1;
   }

   public void setService(String var1) {
      this.service = var1;
   }

   public void setTimestamp(long var1) {
      this.timestamp = var1;
   }

   public void setUrl(String var1) {
      this.url = var1;
   }

   @Override
   public String toString() {
      return "Attribution{service='"
         + this.service
         + '\''
         + ", query='"
         + this.query
         + '\''
         + ", url='"
         + this.url
         + '\''
         + ", robot_id='"
         + this.robot_id
         + '\''
         + ", image_url='"
         + this.image_url
         + '\''
         + ", timestamp="
         + this.timestamp
         + '}';
   }

   public void writeToParcel(Parcel var1, int var2) {
      var1.writeString(this.service);
      var1.writeString(this.query);
      var1.writeString(this.url);
      var1.writeString(this.robot_id);
      var1.writeLong(this.timestamp);
      var1.writeString(this.image_url);
   }
}
