package com.jibo.aws.integration.aws.services.binary.model;

import com.google.gson.annotations.Expose;
import com.jibo.aws.integration.aws.services.common.model.JiboRequestAbstract;
import java.io.File;
import java.util.Map;

public class CreateBinaryRequest extends JiboRequestAbstract {
   @Expose
   protected File body;
   @Expose
   protected Map<String, String> meta;
   @Expose
   protected String path;

   public CreateBinaryRequest(String var1, File var2, Map<String, String> var3) {
      String var4 = var1;
      if (var1 == null) {
         var4 = "";
      }

      this.path = var4;
      this.body = var2;
      this.meta = var3;
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
            if (var1 instanceof CreateBinaryRequest) {
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
                        if (!var1.getMeta().equals(this.getPath())) {
                           return var4;
                        }
                     }

                     if (var1.getBody() == null) {
                        var2 = true;
                     } else {
                        var2 = false;
                     }

                     if (this.getBody() == null) {
                        var3 = true;
                     } else {
                        var3 = false;
                     }

                     var4 = var5;
                     if (!(var2 ^ var3)) {
                        if (var1.getBody() != null) {
                           var4 = var5;
                           if (!var1.getBody().equals(this.getBody())) {
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

   public File getBody() {
      return this.body;
   }

   public Map<String, String> getMeta() {
      return this.meta;
   }

   public String getPath() {
      return this.path;
   }

   @Override
   public String getServiceAbbr() {
      return "binary";
   }

   @Override
   public String getServicePrefix() {
      return "Binary_20151201.";
   }

   @Override
   public int hashCode() {
      int var3 = 0;
      int var1;
      if (this.getPath() == null) {
         var1 = 0;
      } else {
         var1 = this.getPath().hashCode();
      }

      int var2;
      if (this.getBody() == null) {
         var2 = 0;
      } else {
         var2 = this.getBody().hashCode();
      }

      if (this.getMeta() != null) {
         var3 = this.getMeta().hashCode();
      }

      return (var2 + (var1 + 31) * 31) * 31 + var3;
   }

   public void setBody(File var1) {
      this.body = var1;
   }

   public void setMeta(Map<String, String> var1) {
      this.meta = var1;
   }

   public void setPath(String var1) {
      this.path = var1;
   }

   @Override
   public String toString() {
      return "CreateBinaryRequest {path='" + this.path + '\'' + ", meta='" + this.meta + '\'' + ", body='" + this.body + '\'' + '}';
   }
}
