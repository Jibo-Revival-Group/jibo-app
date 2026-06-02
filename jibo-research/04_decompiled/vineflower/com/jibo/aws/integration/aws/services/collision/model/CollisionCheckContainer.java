package com.jibo.aws.integration.aws.services.collision.model;

import com.google.gson.annotations.Expose;
import java.io.Serializable;

public class CollisionCheckContainer implements Serializable {
   @Expose
   private String closest_pair;
   @Expose
   private Boolean collision;
   @Expose
   private Integer distance;
   @Expose
   private Boolean success;

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
            if (var1 instanceof CollisionCheckContainer) {
               var1 = var1;
               boolean var2;
               if (var1.getSuccess() == null) {
                  var2 = true;
               } else {
                  var2 = false;
               }

               boolean var3;
               if (this.getSuccess() == null) {
                  var3 = true;
               } else {
                  var3 = false;
               }

               var4 = var5;
               if (!(var2 ^ var3)) {
                  if (var1.getSuccess() != null) {
                     var4 = var5;
                     if (!var1.getSuccess().equals(this.getSuccess())) {
                        return var4;
                     }
                  }

                  if (var1.getCollision() == null) {
                     var2 = true;
                  } else {
                     var2 = false;
                  }

                  if (this.getCollision() == null) {
                     var3 = true;
                  } else {
                     var3 = false;
                  }

                  var4 = var5;
                  if (!(var2 ^ var3)) {
                     if (var1.getCollision() != null) {
                        var4 = var5;
                        if (!var1.getCollision().equals(this.getCollision())) {
                           return var4;
                        }
                     }

                     if (var1.getClosestPair() == null) {
                        var2 = true;
                     } else {
                        var2 = false;
                     }

                     if (this.getClosestPair() == null) {
                        var3 = true;
                     } else {
                        var3 = false;
                     }

                     var4 = var5;
                     if (!(var2 ^ var3)) {
                        if (var1.getClosestPair() != null) {
                           var4 = var5;
                           if (!var1.getClosestPair().equals(this.getClosestPair())) {
                              return var4;
                           }
                        }

                        if (var1.getDistance() == null) {
                           var2 = true;
                        } else {
                           var2 = false;
                        }

                        if (this.getDistance() == null) {
                           var3 = true;
                        } else {
                           var3 = false;
                        }

                        var4 = var5;
                        if (!(var2 ^ var3)) {
                           if (var1.getDistance() != null) {
                              var4 = var5;
                              if (!var1.getDistance().equals(this.getDistance())) {
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

   public String getClosestPair() {
      return this.closest_pair;
   }

   public Boolean getCollision() {
      return this.collision;
   }

   public Integer getDistance() {
      return this.distance;
   }

   public Boolean getSuccess() {
      return this.success;
   }

   @Override
   public int hashCode() {
      int var4 = 0;
      int var1;
      if (this.getSuccess() == null) {
         var1 = 0;
      } else {
         var1 = this.getSuccess().hashCode();
      }

      int var2;
      if (this.getCollision() == null) {
         var2 = 0;
      } else {
         var2 = this.getCollision().hashCode();
      }

      int var3;
      if (this.getClosestPair() == null) {
         var3 = 0;
      } else {
         var3 = this.getClosestPair().hashCode();
      }

      if (this.getDistance() != null) {
         var4 = this.getDistance().hashCode();
      }

      return (var3 + (var2 + (var1 + 31) * 31) * 31) * 31 + var4;
   }

   public void setClosestPair(String var1) {
      this.closest_pair = var1;
   }

   public void setCollision(Boolean var1) {
      this.collision = var1;
   }

   public void setDistance(Integer var1) {
      this.distance = var1;
   }

   public void setSuccess(Boolean var1) {
      this.success = var1;
   }

   @Override
   public String toString() {
      return "CollisionCheckContainer {success='"
         + this.success
         + '\''
         + "collision='"
         + this.collision
         + '\''
         + "closestPair='"
         + this.closest_pair
         + '\''
         + "distance='"
         + this.distance
         + '\''
         + '}';
   }
}
