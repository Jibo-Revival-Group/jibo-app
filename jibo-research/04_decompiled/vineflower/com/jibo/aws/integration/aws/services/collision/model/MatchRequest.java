package com.jibo.aws.integration.aws.services.collision.model;

import com.google.gson.annotations.Expose;
import java.util.List;

public class MatchRequest extends JiboCollisionRequest {
   @Expose
   private List<String> existingNames;
   @Expose
   private String name;

   public MatchRequest(List<String> var1, String var2) {
      this.existingNames = var1;
      this.name = var2;
   }

   public List<String> getExistingNames() {
      return this.existingNames;
   }

   public String getName() {
      return this.name;
   }

   @Override
   public int hashCode() {
      int var2 = 0;
      int var1;
      if (this.getExistingNames() == null) {
         var1 = 0;
      } else {
         var1 = this.getExistingNames().hashCode();
      }

      if (this.getName() != null) {
         var2 = this.getName().hashCode();
      }

      return (var1 + 31) * 31 + var2;
   }

   public void setExistingNames(List<String> var1) {
      this.existingNames = var1;
   }

   public void setName(String var1) {
      this.name = var1;
   }

   @Override
   public String toString() {
      return "MatchRequest {name='" + this.name + '\'' + '}';
   }
}
