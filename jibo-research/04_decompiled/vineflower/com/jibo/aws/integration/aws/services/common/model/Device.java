package com.jibo.aws.integration.aws.services.common.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class Device extends AmazonWebServiceRequest implements Parcelable, Serializable {
   public static final Creator<Device> CREATOR = new Creator<Device>() {
      public Device createFromParcel(Parcel var1) {
         return new Device(var1);
      }

      public Device[] newArray(int var1) {
         return new Device[var1];
      }
   };
   private String name;
   private String pushToken;
   private Device.Type type;

   private Device(Parcel var1) {
      this.name = var1.readString();
      this.pushToken = var1.readString();
      this.type = Device.Type.values()[var1.readInt()];
   }

   public Device(String var1, String var2, Device.Type var3) {
      this.name = var1;
      this.pushToken = var2;
      this.type = var3;
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
            if (var1 instanceof Device) {
               var1 = var1;
               boolean var2;
               if (var1.getName() == null) {
                  var2 = true;
               } else {
                  var2 = false;
               }

               boolean var3;
               if (this.getName() == null) {
                  var3 = true;
               } else {
                  var3 = false;
               }

               var4 = var5;
               if (!(var2 ^ var3)) {
                  if (var1.getName() != null) {
                     var4 = var5;
                     if (!var1.getName().equals(this.getName())) {
                        return var4;
                     }
                  }

                  if (var1.getPushToken() == null) {
                     var2 = true;
                  } else {
                     var2 = false;
                  }

                  if (this.getPushToken() == null) {
                     var3 = true;
                  } else {
                     var3 = false;
                  }

                  var4 = var5;
                  if (!(var2 ^ var3)) {
                     if (var1.getPushToken() != null) {
                        var4 = var5;
                        if (!var1.getPushToken().equals(this.getPushToken())) {
                           return var4;
                        }
                     }

                     if (var1.getType() == null) {
                        var2 = true;
                     } else {
                        var2 = false;
                     }

                     if (this.getType() == null) {
                        var3 = true;
                     } else {
                        var3 = false;
                     }

                     var4 = var5;
                     if (!(var2 ^ var3)) {
                        if (var1.getType() != null) {
                           var4 = var5;
                           if (!var1.getType().equals(this.getType())) {
                              return var4;
                           }
                        }

                        var4 = true;
                     }
                  }
               }
            }
         }
      }

      return var4;
   }

   public String getName() {
      return this.name;
   }

   public String getPushToken() {
      return this.pushToken;
   }

   public Device.Type getType() {
      return this.type;
   }

   @Override
   public int hashCode() {
      int var3 = 0;
      int var1;
      if (this.getName() == null) {
         var1 = 0;
      } else {
         var1 = this.getName().hashCode();
      }

      int var2;
      if (this.getPushToken() == null) {
         var2 = 0;
      } else {
         var2 = this.getPushToken().hashCode();
      }

      if (this.getType() != null) {
         var3 = this.getType().hashCode();
      }

      return (var2 + (var1 + 31) * 31) * 31 + var3;
   }

   public void setName(String var1) {
      this.name = var1;
   }

   public void setPushToken(String var1) {
      this.pushToken = var1;
   }

   public void setType(Device.Type var1) {
      this.type = var1;
   }

   @Override
   public String toString() {
      return "Device {name='" + this.name + '\'' + ", pushToken='" + this.pushToken + '\'' + ", type=" + this.type + '}';
   }

   public void writeToParcel(Parcel var1, int var2) {
      var1.writeString(this.name);
      var1.writeString(this.pushToken);
      if (this.type == null) {
         var2 = Device.Type.android.ordinal();
      } else {
         var2 = this.type.ordinal();
      }

      var1.writeInt(var2);
   }

   public enum Type {
      android,
      ios;

      private static final Device.Type[] $VALUES = new Device.Type[]{Device.Type.ios, Device.Type.android};
   }
}
