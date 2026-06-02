package com.jibo.aws.integration.aws.services.file.model;

import com.amazonaws.AmazonWebServiceRequest;
import com.google.gson.annotations.Expose;
import java.io.Serializable;

public class FileLink extends AmazonWebServiceRequest implements Serializable {
   @Expose
   private String accountId;
   @Expose
   private String id;
   @Expose
   private String key;
   @Expose
   private String url;

   public FileLink(String var1, String var2, String var3, String var4) {
      this.key = var1;
      this.url = var2;
      this.id = var3;
      this.accountId = var4;
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
            if (var1 instanceof FileLink) {
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

                  if (var1.getKey() == null) {
                     var2 = true;
                  } else {
                     var2 = false;
                  }

                  if (this.getKey() == null) {
                     var3 = true;
                  } else {
                     var3 = false;
                  }

                  var4 = var5;
                  if (!(var2 ^ var3)) {
                     if (var1.getKey() != null) {
                        var4 = var5;
                        if (!var1.getKey().equals(this.getKey())) {
                           return var4;
                        }
                     }

                     if (var1.getId() == null) {
                        var2 = true;
                     } else {
                        var2 = false;
                     }

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

      return var4;
   }

   public String getAccountId() {
      return this.accountId;
   }

   public String getId() {
      return this.id;
   }

   public String getKey() {
      return this.key;
   }

   public String getUrl() {
      return this.url;
   }

   @Override
   public int hashCode() {
      int var4 = 0;
      int var1;
      if (this.getUrl() == null) {
         var1 = 0;
      } else {
         var1 = this.getUrl().hashCode();
      }

      int var2;
      if (this.getKey() == null) {
         var2 = 0;
      } else {
         var2 = this.getKey().hashCode();
      }

      int var3;
      if (this.getId() == null) {
         var3 = 0;
      } else {
         var3 = this.getId().hashCode();
      }

      if (this.getAccountId() != null) {
         var4 = this.getAccountId().hashCode();
      }

      return (var3 + (var2 + (var1 + 31) * 31) * 31) * 31 + var4;
   }

   public void setAccountId(String var1) {
      this.accountId = var1;
   }

   public void setId(String var1) {
      this.id = var1;
   }

   public void setKey(String var1) {
      this.key = var1;
   }

   public void setUrl(String var1) {
      this.url = var1;
   }

   @Override
   public String toString() {
      return "FileLink {url='" + this.url + '\'' + ", key='" + this.key + '\'' + ", id='" + this.id + '\'' + ", accountId='" + this.accountId + '\'' + '}';
   }
}
