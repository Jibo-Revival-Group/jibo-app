package com.jibo.aws.integration.aws.services.jot.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import java.io.Serializable;

public class MessagePartResponse implements Parcelable, Serializable {
   public static final Creator<MessagePartResponse> CREATOR = new Creator<MessagePartResponse>() {
      public MessagePartResponse createFromParcel(Parcel var1) {
         return new MessagePartResponse(var1);
      }

      public MessagePartResponse[] newArray(int var1) {
         return new MessagePartResponse[var1];
      }
   };
   @Expose
   private String path;
   @Expose
   private String url;

   public MessagePartResponse() {
   }

   protected MessagePartResponse(Parcel var1) {
      this.path = var1.readString();
      this.url = var1.readString();
   }

   public MessagePartResponse(String var1, String var2) {
      this.path = var1;
      this.url = var2;
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
            if (var1 instanceof MessagePartResponse) {
               var1 = var1;
               boolean var2;
               if (var1.getPath() == null) {
                  var2 = true;
               } else {
                  var2 = false;
               }

               boolean var3;
               if (this.getPath() == null) {
                  var3 = true;
               } else {
                  var3 = false;
               }

               var4 = var5;
               if (!(var2 ^ var3)) {
                  if (var1.getPath() != null) {
                     var4 = var5;
                     if (!var1.getPath().equals(this.getPath())) {
                        return var4;
                     }
                  }

                  if (var1.getUrl() == null) {
                     var2 = true;
                  } else {
                     var2 = false;
                  }

                  if (this.getUrl() == null) {
                     var3 = true;
                  } else {
                     var3 = false;
                  }

                  var4 = var5;
                  if (!(var2 ^ var3)) {
                     if (var1.getUrl() != null) {
                        var4 = var5;
                        if (!var1.getUrl().equals(this.getUrl())) {
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

   public String getPath() {
      return this.path;
   }

   public String getUrl() {
      return this.url;
   }

   @Override
   public int hashCode() {
      int var2 = 0;
      int var1;
      if (this.getPath() == null) {
         var1 = 0;
      } else {
         var1 = this.getPath().hashCode();
      }

      if (this.getUrl() != null) {
         var2 = this.getUrl().hashCode();
      }

      return (var1 + 31) * 31 + var2;
   }

   public void setPath(String var1) {
      this.path = var1;
   }

   public void setUrl(String var1) {
      this.url = var1;
   }

   @Override
   public String toString() {
      return "Message {path='" + this.path + '\'' + "url='" + this.url + '\'' + '}';
   }

   public void writeToParcel(Parcel var1, int var2) {
      var1.writeString(this.path);
      var1.writeString(this.url);
   }
}
