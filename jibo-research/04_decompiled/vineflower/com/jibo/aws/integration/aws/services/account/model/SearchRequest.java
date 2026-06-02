package com.jibo.aws.integration.aws.services.account.model;

import com.google.gson.annotations.Expose;

public class SearchRequest extends JiboAccountRequest {
   @Expose
   private String query;

   public SearchRequest(String var1) {
      this.query = var1;
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
            if (var1 instanceof SearchRequest) {
               var1 = var1;
               boolean var2;
               if (var1.getQuery() == null) {
                  var2 = true;
               } else {
                  var2 = false;
               }

               boolean var3;
               if (this.getQuery() == null) {
                  var3 = true;
               } else {
                  var3 = false;
               }

               var4 = var5;
               if (!(var2 ^ var3)) {
                  if (var1.getQuery() != null) {
                     var4 = var5;
                     if (!var1.getQuery().equals(this.getQuery())) {
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

   public String getQuery() {
      return this.query;
   }

   @Override
   public int hashCode() {
      int var1;
      if (this.getQuery() == null) {
         var1 = 0;
      } else {
         var1 = this.getQuery().hashCode();
      }

      return var1 + 31;
   }

   public void setQuery(String var1) {
      this.query = var1;
   }

   @Override
   public String toString() {
      return "SearchRequest {query='" + this.query + '\'' + '}';
   }
}
