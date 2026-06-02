package com.jibo.aws.integration.aws.services.account.model;

public class UpdateRequest extends JiboAccountRequest {
   private Long birthday;
   private String email;
   private String firstName;
   private Account.Gender gender;
   private String id;
   private String lastName;
   private Boolean messagingAllowed;
   private String password;
   private String phoneNumber;

   public UpdateRequest(Account var1) {
      this.id = var1.getId();
      this.email = var1.getEmail();
      this.lastName = var1.getLastName();
      this.firstName = var1.getFirstName();
      this.gender = var1.getGender();
      this.birthday = var1.getBirthday();
      this.phoneNumber = var1.getPhoneNumber();
      this.messagingAllowed = var1.isMessagingAllowed();
   }

   public UpdateRequest(String var1) {
      this.id = var1;
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
            if (var1 instanceof UpdateRequest) {
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

                     if (var1.getPassword() == null) {
                        var2 = true;
                     } else {
                        var2 = false;
                     }

                     if (this.getPassword() == null) {
                        var3 = true;
                     } else {
                        var3 = false;
                     }

                     var4 = var5;
                     if (!(var2 ^ var3)) {
                        if (var1.getPassword() != null) {
                           var4 = var5;
                           if (!var1.getPassword().equals(this.getPassword())) {
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

                                 if (var1.getPhoneNumber() == null) {
                                    var2 = true;
                                 } else {
                                    var2 = false;
                                 }

                                 if (this.getPhoneNumber() == null) {
                                    var3 = true;
                                 } else {
                                    var3 = false;
                                 }

                                 var4 = var5;
                                 if (!(var2 ^ var3)) {
                                    if (var1.getPhoneNumber() != null) {
                                       var4 = var5;
                                       if (!var1.getPhoneNumber().equals(this.getPhoneNumber())) {
                                          return var4;
                                       }
                                    }

                                    if (var1.isMessagingAllowed() == null) {
                                       var2 = true;
                                    } else {
                                       var2 = false;
                                    }

                                    if (this.isMessagingAllowed() == null) {
                                       var3 = true;
                                    } else {
                                       var3 = false;
                                    }

                                    var4 = var5;
                                    if (!(var2 ^ var3)) {
                                       if (var1.isMessagingAllowed() != null) {
                                          var4 = var5;
                                          if (!var1.isMessagingAllowed().equals(this.isMessagingAllowed())) {
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
      }

      return var4;
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

   public String getId() {
      return this.id;
   }

   public String getLastName() {
      return this.lastName;
   }

   public String getPassword() {
      return this.password;
   }

   public String getPhoneNumber() {
      return this.phoneNumber;
   }

   @Override
   public int hashCode() {
      int var8 = 0;
      int var1;
      if (this.getId() == null) {
         var1 = 0;
      } else {
         var1 = this.getId().hashCode();
      }

      int var2;
      if (this.getEmail() == null) {
         var2 = 0;
      } else {
         var2 = this.getEmail().hashCode();
      }

      int var3;
      if (this.getPassword() == null) {
         var3 = 0;
      } else {
         var3 = this.getPassword().hashCode();
      }

      int var4;
      if (this.getLastName() == null) {
         var4 = 0;
      } else {
         var4 = this.getLastName().hashCode();
      }

      int var5;
      if (this.getFirstName() == null) {
         var5 = 0;
      } else {
         var5 = this.getFirstName().hashCode();
      }

      int var6;
      if (this.getGender() == null) {
         var6 = 0;
      } else {
         var6 = this.getGender().hashCode();
      }

      int var9 = this.getBirthday().hashCode();
      int var7;
      if (this.getPhoneNumber() == null) {
         var7 = 0;
      } else {
         var7 = this.getPhoneNumber().hashCode();
      }

      if (this.isMessagingAllowed() != null) {
         var8 = this.isMessagingAllowed().hashCode();
      }

      return (var7 + ((var6 + (var5 + (var4 + (var3 + (var2 + (var1 + 31) * 31) * 31) * 31) * 31) * 31) * 31 + var9) * 31) * 31 + var8;
   }

   public boolean isEmpty() {
      boolean var1;
      if (this.email == null
         && this.password == null
         && this.lastName == null
         && this.firstName == null
         && this.gender == null
         && this.birthday == null
         && this.phoneNumber == null
         && this.messagingAllowed == null) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public Boolean isMessagingAllowed() {
      return this.messagingAllowed;
   }

   public void setBirthday(Long var1) {
      this.birthday = var1;
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

   public void setId(String var1) {
      this.id = var1;
   }

   public void setLastName(String var1) {
      this.lastName = var1;
   }

   public void setMessagingAllowed(Boolean var1) {
      this.messagingAllowed = var1;
   }

   public void setPassword(String var1) {
      this.password = var1;
   }

   public void setPhoneNumber(String var1) {
      this.phoneNumber = var1;
   }

   @Override
   public String toString() {
      return "UpdateRequest {id='"
         + this.id
         + '\''
         + ", email='"
         + this.email
         + '\''
         + ", password='"
         + "********"
         + '\''
         + ", lastName='"
         + this.lastName
         + '\''
         + ", firstName='"
         + this.firstName
         + '\''
         + ", birthday='"
         + this.birthday
         + '\''
         + ", phoneNumber='"
         + this.phoneNumber
         + '\''
         + ", messagingAllowed='"
         + this.messagingAllowed
         + '\''
         + '}';
   }
}
