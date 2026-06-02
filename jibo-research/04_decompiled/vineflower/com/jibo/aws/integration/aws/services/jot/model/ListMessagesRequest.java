package com.jibo.aws.integration.aws.services.jot.model;

import com.google.gson.annotations.Expose;

public class ListMessagesRequest extends JiboJotRequest {
   @Expose
   private Long after;
   @Expose
   private Long before;
   @Expose
   private String loopId;

   public ListMessagesRequest() {
   }

   public ListMessagesRequest(String var1, Long var2, Long var3) {
      this.loopId = var1;
      this.after = var2;
      this.before = var3;
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
            if (var1 instanceof ListMessagesRequest) {
               var1 = var1;
               boolean var2;
               if (var1.getAfter() == null) {
                  var2 = true;
               } else {
                  var2 = false;
               }

               boolean var3;
               if (this.getAfter() == null) {
                  var3 = true;
               } else {
                  var3 = false;
               }

               var4 = var5;
               if (!(var2 ^ var3)) {
                  if (var1.getAfter() != null) {
                     var4 = var5;
                     if (!var1.getAfter().equals(this.getAfter())) {
                        return var4;
                     }
                  }

                  if (var1.getBefore() == null) {
                     var2 = true;
                  } else {
                     var2 = false;
                  }

                  if (this.getBefore() == null) {
                     var3 = true;
                  } else {
                     var3 = false;
                  }

                  var4 = var5;
                  if (!(var2 ^ var3)) {
                     if (var1.getBefore() != null) {
                        var4 = var5;
                        if (!var1.getBefore().equals(this.getBefore())) {
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

                        var4 = true;
                     }
                  }
               }
            }
         }
      }

      return var4;
   }

   public Long getAfter() {
      return this.after;
   }

   public Long getBefore() {
      return this.before;
   }

   public String getLoopId() {
      return this.loopId;
   }

   @Override
   public int hashCode() {
      int var3 = 0;
      int var1;
      if (this.getLoopId() == null) {
         var1 = 0;
      } else {
         var1 = this.getLoopId().hashCode();
      }

      int var2;
      if (this.getAfter() == null) {
         var2 = 0;
      } else {
         var2 = this.getAfter().hashCode();
      }

      if (this.getBefore() != null) {
         var3 = this.getBefore().hashCode();
      }

      return (var2 + (var1 + 31) * 31) * 31 + var3;
   }

   public void setAfter(Long var1) {
      this.after = var1;
   }

   public void setBefore(Long var1) {
      this.before = var1;
   }

   public void setLoopId(String var1) {
      this.loopId = var1;
   }

   @Override
   public String toString() {
      return "ListMessagesRequest {loopId='" + this.loopId + '\'' + "after='" + this.after + '\'' + "before='" + this.before + '\'' + '}';
   }
}
