package com.jibo.aws.integration.aws.services.file.model;

import com.amazonaws.AmazonWebServiceRequest;
import com.google.gson.annotations.Expose;
import java.io.File;
import java.io.Serializable;

public class UploadFileRequest extends AmazonWebServiceRequest implements Serializable {
   @Expose
   private File body;
   @Expose
   private String key;

   public UploadFileRequest(String var1, File var2) {
      this.key = var1;
      this.body = var2;
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
            if (var1 instanceof UploadFileRequest) {
               var1 = var1;
               boolean var2;
               if (var1.getKey() == null) {
                  var2 = true;
               } else {
                  var2 = false;
               }

               boolean var3;
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

      return var4;
   }

   public File getBody() {
      return this.body;
   }

   public String getKey() {
      return this.key;
   }

   @Override
   public int hashCode() {
      int var2 = 0;
      int var1;
      if (this.getKey() == null) {
         var1 = 0;
      } else {
         var1 = this.getKey().hashCode();
      }

      if (this.getBody() != null) {
         var2 = this.getBody().hashCode();
      }

      return (var1 + 31) * 31 + var2;
   }

   public void setBody(File var1) {
      this.body = var1;
   }

   public void setKey(String var1) {
      this.key = var1;
   }

   @Override
   public String toString() {
      return "UploadVoiceTrainingRequest {key='" + this.key + '\'' + ", body='" + this.body + '\'' + '}';
   }
}
