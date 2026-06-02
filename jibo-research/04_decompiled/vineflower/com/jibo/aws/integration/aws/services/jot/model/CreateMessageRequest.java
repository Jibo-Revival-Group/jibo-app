package com.jibo.aws.integration.aws.services.jot.model;

import com.google.gson.annotations.Expose;
import java.util.List;

public class CreateMessageRequest extends JiboJotRequest {
   @Expose
   private String content;
   @Expose
   private String loopId;
   @Expose
   private List<MessagePart> parts;
   @Expose
   private List<String> tags;

   public CreateMessageRequest() {
   }

   public CreateMessageRequest(String var1, String var2, List<MessagePart> var3, List<String> var4) {
      this.loopId = var1;
      this.content = var2;
      this.parts = var3;
      this.tags = var4;
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
            if (var1 instanceof CreateMessageRequest) {
               var1 = var1;
               boolean var2;
               if (var1.getContent() == null) {
                  var2 = true;
               } else {
                  var2 = false;
               }

               boolean var3;
               if (this.getContent() == null) {
                  var3 = true;
               } else {
                  var3 = false;
               }

               var4 = var5;
               if (!(var2 ^ var3)) {
                  if (var1.getContent() != null) {
                     var4 = var5;
                     if (!var1.getContent().equals(this.getContent())) {
                        return var4;
                     }
                  }

                  if (var1.getParts() == null) {
                     var2 = true;
                  } else {
                     var2 = false;
                  }

                  if (this.getParts() == null) {
                     var3 = true;
                  } else {
                     var3 = false;
                  }

                  var4 = var5;
                  if (!(var2 ^ var3)) {
                     if (var1.getParts() != null) {
                        var4 = var5;
                        if (!var1.getParts().equals(this.getParts())) {
                           return var4;
                        }
                     }

                     if (var1.getTags() == null) {
                        var2 = true;
                     } else {
                        var2 = false;
                     }

                     if (this.getTags() == null) {
                        var3 = true;
                     } else {
                        var3 = false;
                     }

                     var4 = var5;
                     if (!(var2 ^ var3)) {
                        if (var1.getTags() != null) {
                           var4 = var5;
                           if (!var1.getTags().equals(this.getTags())) {
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
      }

      return var4;
   }

   public String getContent() {
      return this.content;
   }

   public String getLoopId() {
      return this.loopId;
   }

   public List<MessagePart> getParts() {
      return this.parts;
   }

   public List<String> getTags() {
      return this.tags;
   }

   @Override
   public int hashCode() {
      int var4 = 0;
      int var1;
      if (this.getContent() == null) {
         var1 = 0;
      } else {
         var1 = this.getContent().hashCode();
      }

      int var2;
      if (this.getLoopId() == null) {
         var2 = 0;
      } else {
         var2 = this.getLoopId().hashCode();
      }

      int var3;
      if (this.getParts() == null) {
         var3 = 0;
      } else {
         var3 = this.getParts().hashCode();
      }

      if (this.getTags() != null) {
         var4 = this.getTags().hashCode();
      }

      return (var3 + (var2 + (var1 + 31) * 31) * 31) * 31 + var4;
   }

   public void setContent(String var1) {
      this.content = var1;
   }

   public void setLoopId(String var1) {
      this.loopId = var1;
   }

   public void setParts(List<MessagePart> var1) {
      this.parts = var1;
   }

   public void setTags(List<String> var1) {
      this.tags = var1;
   }

   @Override
   public String toString() {
      return "CreateMessageRequest {content='" + this.content + '\'' + "loopId='" + this.loopId + '\'' + '}';
   }
}
