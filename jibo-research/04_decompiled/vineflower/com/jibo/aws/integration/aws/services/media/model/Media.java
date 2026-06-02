package com.jibo.aws.integration.aws.services.media.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import java.io.Serializable;

public class Media implements Parcelable, Serializable {
   public static final Creator<Media> CREATOR = new Creator<Media>() {
      public Media createFromParcel(Parcel var1) {
         return new Media(var1);
      }

      public Media[] newArray(int var1) {
         return new Media[var1];
      }
   };
   public static final String TYPE_AUDIO = "audio";
   public static final String TYPE_IMAGE = "image";
   public static final String TYPE_RECORDING = "recording";
   public static final String TYPE_THUMBNAIL = "thumb";
   public static final String TYPE_THUMBNAIL_ROBOT = "thumb_robot";
   @Expose
   private String accountId;
   @Expose
   private Long created;
   @Expose
   private Boolean isEncrypted;
   @Expose
   private String loopId;
   @Expose
   private String path;
   @Expose
   private String reference;
   @Expose
   private String type;
   @Expose
   private String url;

   public Media() {
   }

   protected Media(Parcel var1) {
      this.path = var1.readString();
      this.accountId = var1.readString();
      this.loopId = var1.readString();
      this.url = var1.readString();
      this.created = var1.readLong();
      this.type = var1.readString();
      this.reference = var1.readString();
      boolean var2;
      if (var1.readByte() != 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      this.isEncrypted = var2;
   }

   public Media(String var1, String var2, String var3, String var4, String var5, String var6, Long var7, boolean var8) {
      this.path = var1;
      this.accountId = var2;
      this.loopId = var3;
      this.url = var4;
      this.type = var5;
      this.reference = var6;
      this.created = var7;
      this.isEncrypted = var8;
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
            if (var1 instanceof Media) {
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

                  if (var1.getAccountId() == null) {
                     var2 = true;
                  } else {
                     var2 = false;
                  }

                  if (this.getAccountId() == null) {
                     var3 = true;
                  } else {
                     var3 = false;
                  }

                  var4 = var5;
                  if (!(var2 ^ var3)) {
                     if (var1.getAccountId() != null) {
                        var4 = var5;
                        if (!var1.getAccountId().equals(this.getAccountId())) {
                           return var4;
                        }
                     }

                     if (var1.getLoopId() == null) {
                        var2 = true;
                     } else {
                        var2 = false;
                     }

                     if (this.getLoopId() == null) {
                        var3 = true;
                     } else {
                        var3 = false;
                     }

                     var4 = var5;
                     if (!(var2 ^ var3)) {
                        if (var1.getLoopId() != null) {
                           var4 = var5;
                           if (!var1.getLoopId().equals(this.getLoopId())) {
                              return var4;
                           }
                        }

                        if (var1.getCreated() == null) {
                           var2 = true;
                        } else {
                           var2 = false;
                        }

                        if (this.getCreated() == null) {
                           var3 = true;
                        } else {
                           var3 = false;
                        }

                        var4 = var5;
                        if (!(var2 ^ var3)) {
                           if (var1.getCreated() != null) {
                              var4 = var5;
                              if (!var1.getCreated().equals(this.getCreated())) {
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

                              if (var1.getReference() == null) {
                                 var2 = true;
                              } else {
                                 var2 = false;
                              }

                              if (this.getReference() == null) {
                                 var3 = true;
                              } else {
                                 var3 = false;
                              }

                              var4 = var5;
                              if (!(var2 ^ var3)) {
                                 if (var1.getReference() != null) {
                                    var4 = var5;
                                    if (!var1.getReference().equals(this.getReference())) {
                                       return var4;
                                    }
                                 }

                                 if (var1.isEncrypted() == null) {
                                    var2 = true;
                                 } else {
                                    var2 = false;
                                 }

                                 if (this.isEncrypted() == null) {
                                    var3 = true;
                                 } else {
                                    var3 = false;
                                 }

                                 var4 = var5;
                                 if (!(var2 ^ var3)) {
                                    if (var1.isEncrypted() != null) {
                                       var4 = var5;
                                       if (!var1.isEncrypted().equals(this.isEncrypted())) {
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
               }
            }
         }
      }

      return var4;
   }

   public String getAccountId() {
      return this.accountId;
   }

   public Long getCreated() {
      return this.created;
   }

   public String getLoopId() {
      return this.loopId;
   }

   public String getPath() {
      return this.path;
   }

   public String getReference() {
      return this.reference;
   }

   public String getType() {
      return this.type;
   }

   public String getUrl() {
      return this.url;
   }

   @Override
   public int hashCode() {
      int var8 = 0;
      int var1;
      if (this.getPath() == null) {
         var1 = 0;
      } else {
         var1 = this.getPath().hashCode();
      }

      int var2;
      if (this.getAccountId() == null) {
         var2 = 0;
      } else {
         var2 = this.getAccountId().hashCode();
      }

      int var3;
      if (this.getLoopId() == null) {
         var3 = 0;
      } else {
         var3 = this.getLoopId().hashCode();
      }

      int var4;
      if (this.getUrl() == null) {
         var4 = 0;
      } else {
         var4 = this.getUrl().hashCode();
      }

      int var5;
      if (this.getCreated() == null) {
         var5 = 0;
      } else {
         var5 = this.getCreated().hashCode();
      }

      int var6;
      if (this.getType() == null) {
         var6 = 0;
      } else {
         var6 = this.getType().hashCode();
      }

      int var7;
      if (this.getReference() == null) {
         var7 = 0;
      } else {
         var7 = this.getReference().hashCode();
      }

      if (this.isEncrypted() != null) {
         var8 = this.isEncrypted().hashCode();
      }

      return (var7 + (var6 + (var5 + (var4 + (var3 + (var2 + (var1 + 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + var8;
   }

   public Boolean isEncrypted() {
      return this.isEncrypted;
   }

   public void setAccountId(String var1) {
      this.accountId = var1;
   }

   public void setCreated(Long var1) {
      this.created = var1;
   }

   public void setEncrypted(Boolean var1) {
      this.isEncrypted = var1;
   }

   public void setLoopId(String var1) {
      this.loopId = var1;
   }

   public void setPath(String var1) {
      this.path = var1;
   }

   public void setReference(String var1) {
      this.reference = var1;
   }

   public void setType(String var1) {
      this.type = var1;
   }

   public void setUrl(String var1) {
      this.url = var1;
   }

   @Override
   public String toString() {
      return "Media {path='"
         + this.path
         + '\''
         + "url='"
         + this.url
         + '\''
         + "accountId='"
         + this.accountId
         + '\''
         + "loopId='"
         + this.loopId
         + '\''
         + "created='"
         + this.created
         + '\''
         + "type='"
         + this.type
         + '\''
         + "reference='"
         + this.reference
         + '\''
         + "isEncrypted='"
         + this.isEncrypted
         + '\''
         + '}';
   }

   public void writeToParcel(Parcel var1, int var2) {
      var1.writeString(this.path);
      var1.writeString(this.accountId);
      var1.writeString(this.loopId);
      var1.writeString(this.url);
      var1.writeLong(this.created);
      var1.writeString(this.type);
      var1.writeString(this.reference);
      byte var3;
      if (this.isEncrypted != null && this.isEncrypted) {
         var3 = 1;
      } else {
         var3 = 0;
      }

      var1.writeByte((byte)var3);
   }
}
