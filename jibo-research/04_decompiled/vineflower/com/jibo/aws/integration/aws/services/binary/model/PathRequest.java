package com.jibo.aws.integration.aws.services.binary.model;

import com.amazonaws.AmazonWebServiceRequest;
import com.google.gson.annotations.Expose;
import java.io.Serializable;

public abstract class PathRequest extends AmazonWebServiceRequest implements Serializable {
   @Expose
   private String path;

   public PathRequest(String var1) {
      this.path = var1;
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
            if (var1 instanceof PathRequest) {
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

                  var4 = true;
               }
            }
         }
      }

      return var4;
   }

   public String getPath() {
      return this.path;
   }

   public abstract String getServicePrefix();

   @Override
   public int hashCode() {
      int var1;
      if (this.getPath() == null) {
         var1 = 0;
      } else {
         var1 = this.getPath().hashCode();
      }

      return var1 + 31;
   }

   public void setPath(String var1) {
      this.path = var1;
   }

   @Override
   public String toString() {
      return "PathRequest {path='" + this.path + '\'' + '}';
   }
}
