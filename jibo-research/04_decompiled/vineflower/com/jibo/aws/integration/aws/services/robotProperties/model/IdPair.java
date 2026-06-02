package com.jibo.aws.integration.aws.services.robotProperties.model;

import com.google.gson.annotations.Expose;
import java.io.Serializable;

public class IdPair implements Serializable {
   @Expose
   private String guid;
   @Expose
   private String id;

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
            if (var1 instanceof IdPair) {
               var1 = var1;
               boolean var2;
               if (var1.getId() == null) {
                  var2 = true;
               } else {
                  var2 = false;
               }

               boolean var3;
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

                  if (var1.getGuid() == null) {
                     var2 = true;
                  } else {
                     var2 = false;
                  }

                  if (this.getGuid() == null) {
                     var3 = true;
                  } else {
                     var3 = false;
                  }

                  var4 = var5;
                  if (!(var2 ^ var3)) {
                     if (var1.getGuid() != null) {
                        var4 = var5;
                        if (!var1.getGuid().equals(this.getGuid())) {
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

   public String getGuid() {
      return this.guid;
   }

   public String getId() {
      return this.id;
   }

   @Override
   public int hashCode() {
      int var2 = 0;
      int var1;
      if (this.getId() == null) {
         var1 = 0;
      } else {
         var1 = this.getId().hashCode();
      }

      if (this.getGuid() != null) {
         var2 = this.getGuid().hashCode();
      }

      return (var1 + 31) * 31 + var2;
   }

   public void setGuid(String var1) {
      this.guid = var1;
   }

   public void setId(String var1) {
      this.id = var1;
   }

   @Override
   public String toString() {
      return "CommandResponse {id='" + this.id + '\'' + "guid='" + this.guid + '\'' + '}';
   }
}
