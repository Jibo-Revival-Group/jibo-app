package com.jibo.aws.integration.aws.services.loop.model;

import com.jibo.aws.integration.aws.services.account.model.Account;

public class InviteMemberRequest extends JiboLoopRequest {
   private Boolean asLegalGuardian;
   private Long birthday;
   private String email;
   private String firstName;
   private Account.Gender gender;
   private Boolean isChild;
   private String lastName;

   public InviteMemberRequest(String var1, String var2, String var3, String var4, Account.Gender var5, Long var6, Boolean var7, Boolean var8) {
      super(var1);
      this.email = var2;
      this.firstName = var3;
      this.lastName = var4;
      this.gender = var5;
      this.birthday = var6;
      this.asLegalGuardian = var7;
      this.isChild = var8;
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
            if (var1 instanceof InviteMemberRequest) {
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

                  if (var1.getEmail() == null) {
                     var2 = true;
                  } else {
                     var2 = false;
                  }

                  if (this.getEmail() == null) {
                     var3 = true;
                  } else {
                     var3 = false;
                  }

                  var4 = var5;
                  if (!(var2 ^ var3)) {
                     if (var1.getEmail() != null) {
                        var4 = var5;
                        if (!var1.getEmail().equals(this.getEmail())) {
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

                                 if (var1.getAsLegalGuardian() == null) {
                                    var2 = true;
                                 } else {
                                    var2 = false;
                                 }

                                 if (this.getAsLegalGuardian() == null) {
                                    var3 = true;
                                 } else {
                                    var3 = false;
                                 }

                                 var4 = var5;
                                 if (!(var2 ^ var3)) {
                                    if (var1.getAsLegalGuardian() != null) {
                                       var4 = var5;
                                       if (!var1.getAsLegalGuardian().equals(this.getAsLegalGuardian())) {
                                          return var4;
                                       }
                                    }

                                    if (var1.isChild() == null) {
                                       var2 = true;
                                    } else {
                                       var2 = false;
                                    }

                                    if (this.isChild() == null) {
                                       var3 = true;
                                    } else {
                                       var3 = false;
                                    }

                                    var4 = var5;
                                    if (!(var2 ^ var3)) {
                                       if (var1.isChild() != null) {
                                          var4 = var5;
                                          if (!var1.isChild().equals(this.isChild())) {
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
      }

      return var4;
   }

   public Boolean getAsLegalGuardian() {
      return this.asLegalGuardian;
   }

   public Long getBirthday() {
      return this.birthday;
   }

   public String getEmail() {
      return this.email;
   }

   public String getFirstName() {
      return this.firstName;
   }

   public Account.Gender getGender() {
      return this.gender;
   }

   public String getLastName() {
      return this.lastName;
   }

   @Override
   public String getServiceMethodName() {
      return "InviteLoopMember";
   }

   @Override
   public int hashCode() {
      int var8 = 0;
      int var1;
      if (this.getLoopId() == null) {
         var1 = 0;
      } else {
         var1 = this.getLoopId().hashCode();
      }

      int var2;
      if (this.getEmail() == null) {
         var2 = 0;
      } else {
         var2 = this.getEmail().hashCode();
      }

      int var3;
      if (this.getAsLegalGuardian() == null) {
         var3 = 0;
      } else {
         var3 = this.getAsLegalGuardian().hashCode();
      }

      int var4;
      if (this.isChild() == null) {
         var4 = 0;
      } else {
         var4 = this.isChild().hashCode();
      }

      int var5;
      if (this.getFirstName() == null) {
         var5 = 0;
      } else {
         var5 = this.getFirstName().hashCode();
      }

      int var6;
      if (this.getLastName() == null) {
         var6 = 0;
      } else {
         var6 = this.getLastName().hashCode();
      }

      int var7;
      if (this.getGender() == null) {
         var7 = 0;
      } else {
         var7 = this.getGender().hashCode();
      }

      if (this.getBirthday() != null) {
         var8 = this.getBirthday().hashCode();
      }

      return (var7 + (var6 + (var5 + (var4 + (var3 + (var2 + (var1 + 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + var8;
   }

   public Boolean isChild() {
      return this.isChild;
   }

   public void setAsLegalGuardian(Boolean var1) {
      this.asLegalGuardian = var1;
   }

   public void setBirthday(Long var1) {
      this.birthday = var1;
   }

   public void setChild(Boolean var1) {
      this.isChild = var1;
   }

   public void setEmail(String var1) {
      this.email = var1;
   }

   public void setFirstName(String var1) {
      this.firstName = var1;
   }

   public void setGender(Account.Gender var1) {
      this.gender = var1;
   }

   public void setLastName(String var1) {
      this.lastName = var1;
   }

   @Override
   public String toString() {
      return "InviteMemberRequest {loopId='"
         + this.loopId
         + '\''
         + "email='"
         + this.email
         + '\''
         + "firstName='"
         + this.firstName
         + '\''
         + "lastName='"
         + this.lastName
         + '\''
         + "gender='"
         + this.gender
         + '\''
         + "isChild='"
         + this.isChild
         + '\''
         + "asLegalGuardian='"
         + this.asLegalGuardian
         + '\''
         + '}';
   }
}
