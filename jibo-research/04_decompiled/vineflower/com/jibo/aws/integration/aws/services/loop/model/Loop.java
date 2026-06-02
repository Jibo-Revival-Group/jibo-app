package com.jibo.aws.integration.aws.services.loop.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.Serializable;
import java.util.List;

public class Loop implements Parcelable, Serializable {
   public static final Creator<Loop> CREATOR = new Creator<Loop>() {
      public Loop createFromParcel(Parcel var1) {
         return new Loop(var1);
      }

      public Loop[] newArray(int var1) {
         return new Loop[var1];
      }
   };
   private Long created;
   private String id;
   private Boolean isSuspended;
   private List<Member> members;
   private String name;
   private String owner;
   private String robot;
   private String robotFriendlyId;
   private Long updated;

   public Loop() {
   }

   protected Loop(Parcel var1) {
      this.id = var1.readString();
      this.name = var1.readString();
      this.owner = var1.readString();
      this.robot = var1.readString();
      this.robotFriendlyId = var1.readString();
      this.members = var1.createTypedArrayList(Member.CREATOR);
      this.created = var1.readLong();
      this.updated = var1.readLong();
      boolean var2;
      if (var1.readByte() != 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      this.isSuspended = var2;
   }

   public int describeContents() {
      return 0;
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
            if (var1 instanceof Loop) {
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

                  if (var1.getName() == null) {
                     var2 = true;
                  } else {
                     var2 = false;
                  }

                  if (this.getName() == null) {
                     var3 = true;
                  } else {
                     var3 = false;
                  }

                  var4 = var5;
                  if (!(var2 ^ var3)) {
                     if (var1.getName() != null) {
                        var4 = var5;
                        if (!var1.getName().equals(this.getName())) {
                           return var4;
                        }
                     }

                     if (var1.getOwner() == null) {
                        var2 = true;
                     } else {
                        var2 = false;
                     }

                     if (this.getOwner() == null) {
                        var3 = true;
                     } else {
                        var3 = false;
                     }

                     var4 = var5;
                     if (!(var2 ^ var3)) {
                        if (var1.getOwner() != null) {
                           var4 = var5;
                           if (!var1.getOwner().equals(this.getOwner())) {
                              return var4;
                           }
                        }

                        if (var1.getRobot() == null) {
                           var2 = true;
                        } else {
                           var2 = false;
                        }

                        if (this.getRobot() == null) {
                           var3 = true;
                        } else {
                           var3 = false;
                        }

                        var4 = var5;
                        if (!(var2 ^ var3)) {
                           if (var1.getRobot() != null) {
                              var4 = var5;
                              if (!var1.getRobot().equals(this.getRobot())) {
                                 return var4;
                              }
                           }

                           if (var1.getRobotFriendlyId() == null) {
                              var2 = true;
                           } else {
                              var2 = false;
                           }

                           if (this.getRobotFriendlyId() == null) {
                              var3 = true;
                           } else {
                              var3 = false;
                           }

                           var4 = var5;
                           if (!(var2 ^ var3)) {
                              if (var1.getRobotFriendlyId() != null) {
                                 var4 = var5;
                                 if (!var1.getRobotFriendlyId().equals(this.getRobotFriendlyId())) {
                                    return var4;
                                 }
                              }

                              if (var1.isSuspended() == null) {
                                 var2 = true;
                              } else {
                                 var2 = false;
                              }

                              if (this.isSuspended() == null) {
                                 var3 = true;
                              } else {
                                 var3 = false;
                              }

                              var4 = var5;
                              if (!(var2 ^ var3)) {
                                 if (var1.isSuspended() != null) {
                                    var4 = var5;
                                    if (!var1.isSuspended().equals(this.isSuspended())) {
                                       return var4;
                                    }
                                 }

                                 if (var1.getMembers() == null) {
                                    var2 = true;
                                 } else {
                                    var2 = false;
                                 }

                                 if (this.getMembers() == null) {
                                    var3 = true;
                                 } else {
                                    var3 = false;
                                 }

                                 var4 = var5;
                                 if (!(var2 ^ var3)) {
                                    if (var1.getMembers() != null) {
                                       var4 = var5;
                                       if (!var1.getMembers().equals(this.getMembers())) {
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
            }
         }
      }

      return var4;
   }

   public Long getCreated() {
      return this.created;
   }

   public String getId() {
      return this.id;
   }

   public List<Member> getMembers() {
      return this.members;
   }

   public String getName() {
      return this.name;
   }

   public String getOwner() {
      return this.owner;
   }

   public String getRobot() {
      return this.robot;
   }

   public String getRobotFriendlyId() {
      return this.robotFriendlyId;
   }

   public Long getUpdated() {
      return this.updated;
   }

   @Override
   public int hashCode() {
      int var9 = 0;
      int var1;
      if (this.getId() == null) {
         var1 = 0;
      } else {
         var1 = this.getId().hashCode();
      }

      int var2;
      if (this.getName() == null) {
         var2 = 0;
      } else {
         var2 = this.getName().hashCode();
      }

      int var3;
      if (this.getOwner() == null) {
         var3 = 0;
      } else {
         var3 = this.getOwner().hashCode();
      }

      int var4;
      if (this.getRobot() == null) {
         var4 = 0;
      } else {
         var4 = this.getRobot().hashCode();
      }

      int var5;
      if (this.getRobotFriendlyId() == null) {
         var5 = 0;
      } else {
         var5 = this.getRobotFriendlyId().hashCode();
      }

      int var6;
      if (this.getMembers() == null) {
         var6 = 0;
      } else {
         var6 = this.getMembers().hashCode();
      }

      int var7;
      if (this.getCreated() == null) {
         var7 = 0;
      } else {
         var7 = this.getCreated().hashCode();
      }

      int var8;
      if (this.getUpdated() == null) {
         var8 = 0;
      } else {
         var8 = this.getUpdated().hashCode();
      }

      if (this.isSuspended() != null) {
         var9 = this.isSuspended().hashCode();
      }

      return (var8 + (var7 + (var6 + (var5 + (var4 + (var3 + (var2 + (var1 + 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + var9;
   }

   public Boolean isSuspended() {
      boolean var1;
      if (this.isSuspended == null) {
         var1 = false;
      } else {
         var1 = this.isSuspended;
      }

      return var1;
   }

   public void setCreated(Long var1) {
      this.created = var1;
   }

   public void setId(String var1) {
      this.id = var1;
   }

   public void setMembers(List<Member> var1) {
      this.members = var1;
   }

   public void setName(String var1) {
      this.name = var1;
   }

   public void setOwner(String var1) {
      this.owner = var1;
   }

   public void setRobot(String var1) {
      this.robot = var1;
   }

   public void setRobotFriendlyId(String var1) {
      this.robotFriendlyId = var1;
   }

   public void setSuspended(Boolean var1) {
      this.isSuspended = var1;
   }

   public void setUpdated(Long var1) {
      this.updated = var1;
   }

   @Override
   public String toString() {
      return "Loop {id='"
         + this.id
         + '\''
         + "name='"
         + this.name
         + '\''
         + "owner='"
         + this.owner
         + '\''
         + "robot='"
         + this.robot
         + '\''
         + "robotFriendlyId='"
         + this.robotFriendlyId
         + '\''
         + "members='"
         + this.members
         + '\''
         + "isSuspended='"
         + this.isSuspended
         + '\''
         + '}';
   }

   public void writeToParcel(Parcel var1, int var2) {
      byte var3 = 0;
      var1.writeString(this.id);
      var1.writeString(this.name);
      var1.writeString(this.owner);
      var1.writeString(this.robot);
      var1.writeString(this.robotFriendlyId);
      var1.writeTypedList(this.members);
      var1.writeLong(this.created);
      var1.writeLong(this.updated);
      if (this.isSuspended != null && this.isSuspended) {
         var3 = 1;
      }

      var1.writeByte((byte)var3);
   }
}
