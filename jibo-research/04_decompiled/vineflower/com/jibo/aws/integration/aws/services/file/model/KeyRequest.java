package com.jibo.aws.integration.aws.services.file.model;

import com.amazonaws.AmazonWebServiceRequest;
import com.google.gson.annotations.Expose;
import java.io.Serializable;

public abstract class KeyRequest extends AmazonWebServiceRequest implements Serializable {
   @Expose
   private String key;

   public KeyRequest(String var1) {
      this.key = var1;
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
            if (var1 instanceof KeyRequest) {
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

                  var4 = true;
               }
            }
         }
      }

      return var4;
   }

   public String getKey() {
      return this.key;
   }

   public abstract String getServicePrefix();

   @Override
   public int hashCode() {
      int var1;
      if (this.getKey() == null) {
         var1 = 0;
      } else {
         var1 = this.getKey().hashCode();
      }

      return var1 + 31;
   }

   public void setKey(String var1) {
      this.key = var1;
   }

   @Override
   public String toString() {
      return "KeyRequest {key='" + this.key + '\'' + '}';
   }
}
