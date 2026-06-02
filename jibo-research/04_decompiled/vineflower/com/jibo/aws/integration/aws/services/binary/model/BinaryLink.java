package com.jibo.aws.integration.aws.services.binary.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.amazonaws.AmazonWebServiceRequest;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class BinaryLink extends AmazonWebServiceRequest implements Parcelable, Serializable {
   public static final Creator<BinaryLink> CREATOR = new Creator<BinaryLink>() {
      public BinaryLink createFromParcel(Parcel var1) {
         return new BinaryLink(var1);
      }

      public BinaryLink[] newArray(int var1) {
         return new BinaryLink[var1];
      }
   };
   @Expose
   protected String accountId;
   @Expose
   @SerializedName(a = "created")
   protected Long createdMilliseconds;
   protected transient File file;
   @Expose
   protected Map<String, String> meta;
   @Expose
   protected String path;
   @Expose
   protected String url;

   protected BinaryLink(Parcel var1) {
      this.createdMilliseconds = var1.readLong();
      this.accountId = var1.readString();
      this.path = var1.readString();
      this.url = var1.readString();
      this.meta = new HashMap<>();
      var1.readMap(this.meta, this.meta.getClass().getClassLoader());
      String var2 = var1.readString();
      if (!TextUtils.isEmpty(var2)) {
         this.file = new File(var2);
      }
   }

   public BinaryLink(String var1, String var2, String var3, Long var4, Map<String, String> var5) {
      this.path = var1;
      this.url = var2;
      this.createdMilliseconds = var4;
      this.accountId = var3;
      this.meta = var5;
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
            if (var1 instanceof BinaryLink) {
               var1 = var1;
               boolean var2;
               if (var1.getUrl() == null) {
                  var2 = true;
               } else {
                  var2 = false;
               }

               boolean var3;
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

                  if (var1.getPath() == null) {
                     var2 = true;
                  } else {
                     var2 = false;
                  }

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

                           if (var1.getFile() == null) {
                              var2 = true;
                           } else {
                              var2 = false;
                           }

                           if (this.getFile() == null) {
                              var3 = true;
                           } else {
                              var3 = false;
                           }

                           var4 = var5;
                           if (!(var2 ^ var3)) {
                              if (var1.getFile() != null) {
                                 var4 = var5;
                                 if (!var1.getFile().equals(this.getFile())) {
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

      return var4;
   }

   public String getAccountId() {
      return this.accountId;
   }

   public Long getCreatedMilliseconds() {
      return this.createdMilliseconds;
   }

   public File getFile() {
      return this.file;
   }

   public Map<String, String> getMeta() {
      return this.meta;
   }

   public String getPath() {
      return this.path;
   }

   public String getUrl() {
      return this.url;
   }

   @Override
   public int hashCode() {
      int var6 = 0;
      int var1;
      if (this.getUrl() == null) {
         var1 = 0;
      } else {
         var1 = this.getUrl().hashCode();
      }

      int var2;
      if (this.getPath() == null) {
         var2 = 0;
      } else {
         var2 = this.getPath().hashCode();
      }

      int var3;
      if (this.getCreatedMilliseconds() == null) {
         var3 = 0;
      } else {
         var3 = this.getCreatedMilliseconds().hashCode();
      }

      int var4;
      if (this.getAccountId() == null) {
         var4 = 0;
      } else {
         var4 = this.getAccountId().hashCode();
      }

      int var5;
      if (this.getMeta() == null) {
         var5 = 0;
      } else {
         var5 = this.getMeta().hashCode();
      }

      if (this.getFile() != null) {
         var6 = this.getFile().hashCode();
      }

      return (var5 + (var4 + (var3 + (var2 + (var1 + 31) * 31) * 31) * 31) * 31) * 31 + var6;
   }

   public void setAccountId(String var1) {
      this.accountId = var1;
   }

   public void setCreatedMilliseconds(Long var1) {
      this.createdMilliseconds = var1;
   }

   public void setFile(File var1) {
      this.file = var1;
   }

   public void setMeta(Map<String, String> var1) {
      this.meta = var1;
   }

   public void setPath(String var1) {
      this.path = var1;
   }

   public void setUrl(String var1) {
      this.url = var1;
   }

   @Override
   public String toString() {
      return "BinaryLink {url='"
         + this.url
         + '\''
         + ", path='"
         + this.path
         + '\''
         + ", createdMilliseconds='"
         + this.createdMilliseconds
         + '\''
         + ", accountId='"
         + this.accountId
         + '\''
         + ", meta='"
         + this.meta
         + '\''
         + ", file='"
         + this.file
         + '\''
         + '}';
   }

   public void writeToParcel(Parcel var1, int var2) {
      long var3;
      if (this.createdMilliseconds == null) {
         var3 = 0L;
      } else {
         var3 = this.createdMilliseconds;
      }

      var1.writeLong(var3);
      var1.writeString(this.accountId);
      var1.writeString(this.path);
      var1.writeString(this.url);
      var1.writeMap(this.meta);
      String var5;
      if (this.file == null) {
         var5 = null;
      } else {
         var5 = this.file.getAbsolutePath();
      }

      var1.writeString(var5);
   }
}
