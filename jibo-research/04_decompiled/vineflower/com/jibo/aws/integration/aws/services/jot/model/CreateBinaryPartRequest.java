package com.jibo.aws.integration.aws.services.jot.model;

import com.google.gson.annotations.Expose;
import java.io.File;

public class CreateBinaryPartRequest extends JiboJotRequest {
   @Expose
   protected File body;

   public CreateBinaryPartRequest(File var1) {
      this.body = var1;
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
            if (super.equals(var1)) {
               var4 = var5;
               if (var1 instanceof CreateBinaryPartRequest) {
                  var1 = var1;
                  boolean var2;
                  if (var1.getBody() == null) {
                     var2 = true;
                  } else {
                     var2 = false;
                  }

                  boolean var3;
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

   @Override
   public int hashCode() {
      int var2 = super.hashCode();
      int var1;
      if (this.getBody() == null) {
         var1 = 0;
      } else {
         var1 = this.getBody().hashCode();
      }

      return var1 + var2 * 31;
   }

   public void setBody(File var1) {
      this.body = var1;
   }

   @Override
   public String toString() {
      return "CreatePartRequest {, body='" + this.body + '\'' + '}';
   }
}
