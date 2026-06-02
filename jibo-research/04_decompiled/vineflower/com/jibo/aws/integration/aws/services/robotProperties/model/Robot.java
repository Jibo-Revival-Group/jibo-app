package com.jibo.aws.integration.aws.services.robotProperties.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Robot implements Parcelable {
   public static final Creator<Robot> CREATOR = new Creator<Robot>() {
      public Robot createFromParcel(Parcel var1) {
         return new Robot(var1);
      }

      public Robot[] newArray(int var1) {
         return new Robot[var1];
      }
   };
   private Long created;
   private String guid;
   private String id;
   private JsonObject payload;
   private Long updated;

   protected Robot(Parcel var1) {
      this.id = var1.readString();
      this.guid = var1.readString();
      String var2 = var1.readString();

      try {
         JsonParser var3 = new JsonParser();
         this.payload = (JsonObject)var3.a(var2);
      } catch (Exception var4) {
         this.payload = new JsonObject();
      }

      this.created = var1.readLong();
      this.updated = var1.readLong();
   }

   public Robot(Robot var1) {
      this.id = var1.id;
      this.guid = var1.guid;
      this.payload = var1.payload;
      this.created = var1.created;
      this.updated = var1.updated;
   }

   public Robot(String var1, String var2, JsonObject var3, long var4, long var6) {
      Object var8 = null;
      super();
      this.id = var1;
      this.guid = var2;
      JsonObject var9 = var3;
      if (var3 == null) {
         var9 = new JsonObject();
      }

      this.payload = var9;
      Long var10;
      if (var4 == 0L) {
         var10 = null;
      } else {
         var10 = var4;
      }

      this.created = var10;
      Long var11;
      if (var6 == 0L) {
         var11 = (Long)var8;
      } else {
         var11 = var6;
      }

      this.updated = var11;
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
            if (var1 instanceof Robot) {
               var1 = var1;
               boolean var2;
               if (var1.getId() == null) {
                  var2 = true;
               } else {
                  var2 = false;
               }

               boolean var3;
               if (this.getId() == null) {
                  var3 = true;
               } else {
                  var3 = false;
               }

               var4 = var5;
               if (!(var2 ^ var3)) {
                  if (var1.getId() != null) {
                     var4 = var5;
                     if (!var1.getId().equals(this.getId())) {
                        return var4;
                     }
                  }

                  if (var1.getGuid() == null) {
                     var2 = true;
                  } else {
                     var2 = false;
                  }

                  if (this.getGuid() == null) {
                     var3 = true;
                  } else {
                     var3 = false;
                  }

                  var4 = var5;
                  if (!(var2 ^ var3)) {
                     if (var1.getGuid() != null) {
                        var4 = var5;
                        if (!var1.getGuid().equals(this.getGuid())) {
                           return var4;
                        }
                     }

                     if (var1.getPayload() == null) {
                        var2 = true;
                     } else {
                        var2 = false;
                     }

                     if (this.getPayload() == null) {
                        var3 = true;
                     } else {
                        var3 = false;
                     }

                     var4 = var5;
                     if (!(var2 ^ var3)) {
                        if (var1.getPayload() != null) {
                           var4 = var5;
                           if (!var1.getPayload().equals(this.getPayload())) {
                              return var4;
                           }
                        }

                        if (var1.getUpdatedMilliseconds() == null) {
                           var2 = true;
                        } else {
                           var2 = false;
                        }

                        if (this.getUpdatedMilliseconds() == null) {
                           var3 = true;
                        } else {
                           var3 = false;
                        }

                        var4 = var5;
                        if (!(var2 ^ var3)) {
                           if (var1.getUpdatedMilliseconds() != null) {
                              var4 = var5;
                              if (!var1.getUpdatedMilliseconds().equals(this.getUpdatedMilliseconds())) {
                                 return var4;
                              }
                           }

                           if (var1.getCreatedMilliseconds() == null) {
                              var2 = true;
                           } else {
                              var2 = false;
                           }

                           if (this.getCreatedMilliseconds() == null) {
                              var3 = true;
                           } else {
                              var3 = false;
                           }

                           var4 = var5;
                           if (!(var2 ^ var3)) {
                              if (var1.getCreatedMilliseconds() != null) {
                                 var4 = var5;
                                 if (!var1.getCreatedMilliseconds().equals(this.getCreatedMilliseconds())) {
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
      }

      return var4;
   }

   public Long getCreatedMilliseconds() {
      return this.created;
   }

   public String getGuid() {
      return this.guid;
   }

   public String getId() {
      return this.id;
   }

   public JsonObject getPayload() {
      return this.payload;
   }

   public Long getUpdatedMilliseconds() {
      return this.updated;
   }

   @Override
   public int hashCode() {
      int var5 = 0;
      int var1;
      if (this.getId() == null) {
         var1 = 0;
      } else {
         var1 = this.getId().hashCode();
      }

      int var2;
      if (this.getGuid() == null) {
         var2 = 0;
      } else {
         var2 = this.getGuid().hashCode();
      }

      int var3;
      if (this.getPayload() == null) {
         var3 = 0;
      } else {
         var3 = this.getPayload().hashCode();
      }

      int var4;
      if (this.getUpdatedMilliseconds() == null) {
         var4 = 0;
      } else {
         var4 = this.getUpdatedMilliseconds().hashCode();
      }

      if (this.getCreatedMilliseconds() != null) {
         var5 = this.getCreatedMilliseconds().hashCode();
      }

      return (var4 + (var3 + (var2 + (var1 + 31) * 31) * 31) * 31) * 31 + var5;
   }

   public void setCreatedMilliseconds(Long var1) {
      this.created = var1;
   }

   public void setGuid(String var1) {
      this.guid = var1;
   }

   public void setId(String var1) {
      this.id = var1;
   }

   public void setPayload(JsonObject var1) {
      this.payload = var1;
   }

   public void setUpdatedMilliseconds(Long var1) {
      this.updated = var1;
   }

   @Override
   public String toString() {
      return "Robot {id='"
         + this.id
         + '\''
         + "guid='"
         + this.guid
         + '\''
         + ", payload='"
         + this.payload
         + '\''
         + ", updated="
         + this.updated
         + ", created="
         + this.created
         + '}';
   }

   public void writeToParcel(Parcel var1, int var2) {
      long var5 = 0L;
      var1.writeString(this.id);
      var1.writeString(this.guid);
      String var7;
      if (this.payload != null) {
         var7 = this.payload.toString();
      } else {
         var7 = new JsonObject().toString();
      }

      var1.writeString(var7);
      long var3;
      if (this.created == null) {
         var3 = 0L;
      } else {
         var3 = this.created;
      }

      var1.writeLong(var3);
      if (this.updated == null) {
         var3 = var5;
      } else {
         var3 = this.updated;
      }

      var1.writeLong(var3);
   }
}
