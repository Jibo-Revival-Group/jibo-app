package com.jibo.aws.integration.aws.services.media.model;

import com.google.gson.annotations.Expose;
import java.util.List;

public class RemoveRequest extends JiboMediaRequest {
   @Expose
   private List<String> paths;

   public RemoveRequest(List<String> var1) {
      this.paths = var1;
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
            if (var1 instanceof RemoveRequest) {
               var1 = var1;
               boolean var2;
               if (var1.getPaths() == null) {
                  var2 = true;
               } else {
                  var2 = false;
               }

               boolean var3;
               if (this.getPaths() == null) {
                  var3 = true;
               } else {
                  var3 = false;
               }

               var4 = var5;
               if (!(var2 ^ var3)) {
                  if (var1.getPaths() != null) {
                     var4 = var5;
                     if (!var1.getPaths().equals(this.getPaths())) {
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

   public List<String> getPaths() {
      return this.paths;
   }

   @Override
   public int hashCode() {
      int var1;
      if (this.getPaths() == null) {
         var1 = 0;
      } else {
         var1 = this.getPaths().hashCode();
      }

      return var1 + 31;
   }

   public void setPaths(List<String> var1) {
      this.paths = var1;
   }

   @Override
   public String toString() {
      return "RemoveRequest {paths='" + this.paths + '\'' + '}';
   }
}
