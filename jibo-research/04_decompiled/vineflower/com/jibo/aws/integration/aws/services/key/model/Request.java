package com.jibo.aws.integration.aws.services.key.model;

import com.google.gson.annotations.Expose;
import java.io.Serializable;

public class Request implements Serializable {
   @Expose
   private String accountId;
   @Expose
   private String encryptedKey;
   @Expose
   private String id;
   @Expose
   private String loopId;
   @Expose
   private String publicKey;

   public Request() {
   }

   public Request(String var1, String var2, String var3, String var4, String var5) {
      this.id = var1;
      this.accountId = var2;
      this.loopId = var3;
      this.publicKey = var4;
      this.encryptedKey = var5;
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
            if (var1 instanceof Request) {
               var1 = var1;
               boolean var2;
               if (var1.getAccountId() == null) {
                  var2 = true;
               } else {
                  var2 = false;
               }

               boolean var3;
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

                     if (var1.getEncryptedKey() == null) {
                        var2 = true;
                     } else {
                        var2 = false;
                     }

                     if (this.getEncryptedKey() == null) {
                        var3 = true;
                     } else {
                        var3 = false;
                     }

                     var4 = var5;
                     if (!(var2 ^ var3)) {
                        if (var1.getEncryptedKey() != null) {
                           var4 = var5;
                           if (!var1.getEncryptedKey().equals(this.getEncryptedKey())) {
                              return var4;
                           }
                        }

                        if (var1.getPublicKey() == null) {
                           var2 = true;
                        } else {
                           var2 = false;
                        }

                        if (this.getPublicKey() == null) {
                           var3 = true;
                        } else {
                           var3 = false;
                        }

                        var4 = var5;
                        if (!(var2 ^ var3)) {
                           if (var1.getPublicKey() != null) {
                              var4 = var5;
                              if (!var1.getPublicKey().equals(this.getPublicKey())) {
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

   public String getEncryptedKey() {
      return this.encryptedKey;
   }

   public String getId() {
      return this.id;
   }

   public String getLoopId() {
      return this.loopId;
   }

   public String getPublicKey() {
      return this.publicKey;
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
      if (this.getPublicKey() == null) {
         var4 = 0;
      } else {
         var4 = this.getPublicKey().hashCode();
      }

      if (this.getEncryptedKey() != null) {
         var5 = this.getEncryptedKey().hashCode();
      }

      return (var4 + (var3 + (var2 + (var1 + 31) * 31) * 31) * 31) * 31 + var5;
   }

   public void setAccountId(String var1) {
      this.accountId = var1;
   }

   public void setEncryptedKey(String var1) {
      this.encryptedKey = var1;
   }

   public void setId(String var1) {
      this.id = var1;
   }

   public void setLoopId(String var1) {
      this.loopId = var1;
   }

   public void setPublicKey(String var1) {
      this.publicKey = var1;
   }

   @Override
   public String toString() {
      return "Request {id='"
         + this.id
         + '\''
         + "accountId='"
         + this.accountId
         + '\''
         + "loopId='"
         + this.loopId
         + '\''
         + "publicKey='"
         + this.publicKey
         + '\''
         + "\"publicKey='\" + publicKey + '\\'' +='"
         + this.encryptedKey
         + '\''
         + '}';
   }
}
