package com.jibo.aws.integration.aws.services.account.model;

import com.google.gson.annotations.Expose;

public class CreateManagedRequest extends JiboAccountRequest {
   @Expose
   private Long birthday;
   @Expose
   private String firstName;
   @Expose
   private Account.Gender gender;
   @Expose
   private Boolean isChild;
   @Expose
   private String lastName;
   @Expose
   private String loopId;
   @Expose
   private String nickName;

   public CreateManagedRequest(String var1, String var2, String var3, String var4, Account.Gender var5, Long var6, Boolean var7) {
      this.loopId = var1;
      this.firstName = var2;
      this.lastName = var3;
      this.nickName = var4;
      this.gender = var5;
      this.birthday = var6;
      this.isChild = var7;
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
            if (var1 instanceof CreateManagedRequest) {
               var1 = var1;
               boolean var2;
               if (var1.getLoopId() == null) {
                  var2 = true;
               } else {
                  var2 = false;
               }

               boolean var3;
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

                  if (var1.getFirstName() == null) {
                     var2 = true;
                  } else {
                     var2 = false;
                  }

                  if (this.getFirstName() == null) {
                     var3 = true;
                  } else {
                     var3 = false;
                  }

                  var4 = var5;
                  if (!(var2 ^ var3)) {
                     if (var1.getFirstName() != null) {
                        var4 = var5;
                        if (!var1.getFirstName().equals(this.getFirstName())) {
                           return var4;
                        }
                     }

                     if (var1.getLastName() == null) {
                        var2 = true;
                     } else {
                        var2 = false;
                     }

                     if (this.getLastName() == null) {
                        var3 = true;
                     } else {
                        var3 = false;
                     }

                     var4 = var5;
                     if (!(var2 ^ var3)) {
                        if (var1.getLastName() != null) {
                           var4 = var5;
                           if (!var1.getLastName().equals(this.getLastName())) {
                              return var4;
                           }
                        }

                        if (var1.getNickName() == null) {
                           var2 = true;
                        } else {
                           var2 = false;
                        }

                        if (this.getNickName() == null) {
                           var3 = true;
                        } else {
                           var3 = false;
                        }

                        var4 = var5;
                        if (!(var2 ^ var3)) {
                           if (var1.getNickName() != null) {
                              var4 = var5;
                              if (!var1.getNickName().equals(this.getNickName())) {
                                 return var4;
                              }
                           }

                           if (var1.getGender() == null) {
                              var2 = true;
                           } else {
                              var2 = false;
                           }

                           if (this.getGender() == null) {
                              var3 = true;
                           } else {
                              var3 = false;
                           }

                           var4 = var5;
                           if (!(var2 ^ var3)) {
                              if (var1.getGender() != null) {
                                 var4 = var5;
                                 if (!var1.getGender().equals(this.getGender())) {
                                    return var4;
                                 }
                              }

                              if (var1.getBirthday() == null) {
                                 var2 = true;
                              } else {
                                 var2 = false;
                              }

                              if (this.getBirthday() == null) {
                                 var3 = true;
                              } else {
                                 var3 = false;
                              }

                              var4 = var5;
                              if (!(var2 ^ var3)) {
                                 if (var1.getBirthday() != null) {
                                    var4 = var5;
                                    if (!var1.getBirthday().equals(this.getBirthday())) {
                                       return var4;
                                    }
                                 }

                                 if (var1.getIsChild() == null) {
                                    var2 = true;
                                 } else {
                                    var2 = false;
                                 }

                                 if (this.getIsChild() == null) {
                                    var3 = true;
                                 } else {
                                    var3 = false;
                                 }

                                 var4 = var5;
                                 if (!(var2 ^ var3)) {
                                    if (var1.getIsChild() != null) {
                                       var4 = var5;
                                       if (!var1.getIsChild().equals(this.getIsChild())) {
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

   public Long getBirthday() {
      return this.birthday;
   }

   public String getFirstName() {
      return this.firstName;
   }

   public Account.Gender getGender() {
      return this.gender;
   }

   public Boolean getIsChild() {
      return this.isChild;
   }

   public String getLastName() {
      return this.lastName;
   }

   public String getLoopId() {
      return this.loopId;
   }

   public String getNickName() {
      return this.nickName;
   }

   @Override
   public int hashCode() {
      int var7 = 0;
      int var1;
      if (this.getLoopId() == null) {
         var1 = 0;
      } else {
         var1 = this.getLoopId().hashCode();
      }

      int var2;
      if (this.getFirstName() == null) {
         var2 = 0;
      } else {
         var2 = this.getFirstName().hashCode();
      }

      int var3;
      if (this.getLastName() == null) {
         var3 = 0;
      } else {
         var3 = this.getLastName().hashCode();
      }

      int var4;
      if (this.getNickName() == null) {
         var4 = 0;
      } else {
         var4 = this.getNickName().hashCode();
      }

      int var5;
      if (this.getGender() == null) {
         var5 = 0;
      } else {
         var5 = this.getGender().hashCode();
      }

      int var6;
      if (this.getBirthday() == null) {
         var6 = 0;
      } else {
         var6 = this.getBirthday().hashCode();
      }

      if (this.getIsChild() != null) {
         var7 = this.getIsChild().hashCode();
      }

      return (var6 + (var5 + (var4 + (var3 + (var2 + (var1 + 31) * 31) * 31) * 31) * 31) * 31) * 31 + var7;
   }

   public void setBirthday(Long var1) {
      this.birthday = var1;
   }

   public void setFirstName(String var1) {
      this.firstName = var1;
   }

   public void setGender(Account.Gender var1) {
      this.gender = var1;
   }

   public void setIsChild(Boolean var1) {
      this.isChild = var1;
   }

   public void setLastName(String var1) {
      this.lastName = var1;
   }

   public void setLoopId(String var1) {
      this.loopId = var1;
   }

   public void setNickName(String var1) {
      this.nickName = var1;
   }

   @Override
   public String toString() {
      return "CreateManagedRequest {loopId='"
         + this.loopId
         + '\''
         + ", firstName='"
         + this.firstName
         + '\''
         + ", lastName='"
         + this.lastName
         + '\''
         + ", nickName='"
         + this.nickName
         + '\''
         + ", gender='"
         + this.gender
         + '\''
         + ", birthday='"
         + this.birthday
         + '\''
         + ", isChild='"
         + this.isChild
         + '\''
         + '}';
   }
}
