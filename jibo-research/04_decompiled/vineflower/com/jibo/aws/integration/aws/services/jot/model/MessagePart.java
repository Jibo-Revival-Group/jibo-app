package com.jibo.aws.integration.aws.services.jot.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.annotations.Expose;
import java.io.Serializable;

public class MessagePart implements Parcelable, Serializable {
   public static final Creator<MessagePart> CREATOR = new Creator<MessagePart>() {
      public MessagePart createFromParcel(Parcel var1) {
         return new MessagePart(var1);
      }

      public MessagePart[] newArray(int var1) {
         return new MessagePart[var1];
      }
   };
   @Expose
   private JsonObject meta;
   @Expose
   private String path;
   @Expose
   private String type;
   @Expose
   private String url;

   public MessagePart() {
   }

   protected MessagePart(Parcel var1) {
      this.path = var1.readString();
      this.url = var1.readString();
      String var3 = var1.readString();

      try {
         JsonParser var2 = new JsonParser();
         this.meta = (JsonObject)var2.a(var3);
      } catch (Exception var4) {
         this.meta = new JsonObject();
      }

      this.type = var1.readString();
   }

   public MessagePart(String var1, String var2, JsonObject var3, String var4) {
      this.path = var1;
      this.url = var2;
      this.meta = var3;
      this.type = var4;
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
            if (var1 instanceof MessagePart) {
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

                  if (var1.getMeta() == null) {
                     var2 = true;
                  } else {
                     var2 = false;
                  }

                  if (this.getMeta() == null) {
                     var3 = true;
                  } else {
                     var3 = false;
                  }

                  var4 = var5;
                  if (!(var2 ^ var3)) {
                     if (var1.getMeta() != null) {
                        var4 = var5;
                        if (!var1.getMeta().equals(this.getMeta())) {
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
         }
      }

      return var4;
   }

   public JsonObject getMeta() {
      return this.meta;
   }

   public String getPath() {
      return this.path;
   }

   public String getType() {
      return this.type;
   }

   public String getUrl() {
      return this.url;
   }

   @Override
   public int hashCode() {
      int var4 = 0;
      int var1;
      if (this.getPath() == null) {
         var1 = 0;
      } else {
         var1 = this.getPath().hashCode();
      }

      int var2;
      if (this.getUrl() == null) {
         var2 = 0;
      } else {
         var2 = this.getUrl().hashCode();
      }

      int var3;
      if (this.getMeta() == null) {
         var3 = 0;
      } else {
         var3 = this.getMeta().hashCode();
      }

      if (this.getType() != null) {
         var4 = this.getType().hashCode();
      }

      return (var3 + (var2 + (var1 + 31) * 31) * 31) * 31 + var4;
   }

   public void setMeta(JsonObject var1) {
      this.meta = var1;
   }

   public void setPath(String var1) {
      this.path = var1;
   }

   public void setType(String var1) {
      this.type = var1;
   }

   public void setUrl(String var1) {
      this.url = var1;
   }

   @Override
   public String toString() {
      return "MessagePart {path='" + this.path + '\'' + "url='" + this.url + '\'' + "meta='" + this.meta + '\'' + "type='" + this.type + '\'' + '}';
   }

   public void writeToParcel(Parcel var1, int var2) {
      var1.writeString(this.path);
      var1.writeString(this.url);
      String var3;
      if (this.meta != null) {
         var3 = this.meta.toString();
      } else {
         var3 = new JsonObject().toString();
      }

      var1.writeString(var3);
      var1.writeString(this.type);
   }
}
