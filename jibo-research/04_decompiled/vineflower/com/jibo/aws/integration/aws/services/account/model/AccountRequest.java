package com.jibo.aws.integration.aws.services.account.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AccountRequest extends JiboAccountRequest {
   @Expose
   @SerializedName(a = "birthday")
   private Long birthdayMilliseconds;
   @Expose
   private String email;
   @Expose
   private String firstName;
   @Expose
   private Account.Gender gender;
   @Expose
   private String invitationCode;
   @Expose
   private String lastName;
   private transient String operation;
   @Expose
   private String password;

   public AccountRequest(Account var1) {
      this.email = var1.getEmail();
      this.lastName = var1.getLastName();
      this.firstName = var1.getFirstName();
      this.gender = var1.getGender();
      this.birthdayMilliseconds = var1.getBirthday();
   }

   public AccountRequest(String var1, String var2, String var3) {
      this.email = var1;
      this.password = var2;
      this.operation = var3;
   }

   public AccountRequest(String var1, String var2, String var3, String var4) {
      this.email = var1;
      this.password = var2;
      this.invitationCode = var3;
      this.operation = var4;
   }

   public AccountRequest(String var1, String var2, String var3, String var4, String var5, Account.Gender var6, Long var7) {
      this.email = var1;
      this.password = var2;
      this.firstName = var3;
      this.lastName = var4;
      this.gender = var6;
      this.birthdayMilliseconds = var7;
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
            if (var1 instanceof AccountRequest) {
               var1 = var1;
               boolean var2;
               if (var1.getEmail() == null) {
                  var2 = true;
               } else {
                  var2 = false;
               }

               boolean var3;
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

                  if (var1.getInvitationCode() == null) {
                     var2 = true;
                  } else {
                     var2 = false;
                  }

                  if (this.getInvitationCode() == null) {
                     var3 = true;
                  } else {
                     var3 = false;
                  }

                  var4 = var5;
                  if (!(var2 ^ var3)) {
                     if (var1.getInvitationCode() != null) {
                        var4 = var5;
                        if (!var1.getInvitationCode().equals(this.getInvitationCode())) {
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

                                 if (var1.getBirthdayMilliseconds() == null) {
                                    var2 = true;
                                 } else {
                                    var2 = false;
                                 }

                                 if (this.getBirthdayMilliseconds() == null) {
                                    var3 = true;
                                 } else {
                                    var3 = false;
                                 }

                                 var4 = var5;
                                 if (!(var2 ^ var3)) {
                                    if (var1.getBirthdayMilliseconds() != null) {
                                       var4 = var5;
                                       if (!var1.getBirthdayMilliseconds().equals(this.getBirthdayMilliseconds())) {
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

   public Long getBirthdayMilliseconds() {
      return this.birthdayMilliseconds;
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

   public String getInvitationCode() {
      return this.invitationCode;
   }

   public String getLastName() {
      return this.lastName;
   }

   public String getOperation() {
      return this.operation;
   }

   public String getPassword() {
      return this.password;
   }

   @Override
   public String getServiceMethodName() {
      return this.getOperation();
   }

   @Override
   public int hashCode() {
      int var7 = 0;
      int var1;
      if (this.getEmail() == null) {
         var1 = 0;
      } else {
         var1 = this.getEmail().hashCode();
      }

      int var2;
      if (this.getInvitationCode() == null) {
         var2 = 0;
      } else {
         var2 = this.getInvitationCode().hashCode();
      }

      int var3;
      if (this.getPassword() == null) {
         var3 = 0;
      } else {
         var3 = this.getPassword().hashCode();
      }

      int var4;
      if (this.getFirstName() == null) {
         var4 = 0;
      } else {
         var4 = this.getFirstName().hashCode();
      }

      int var5;
      if (this.getLastName() == null) {
         var5 = 0;
      } else {
         var5 = this.getLastName().hashCode();
      }

      int var6;
      if (this.getGender() == null) {
         var6 = 0;
      } else {
         var6 = this.getGender().hashCode();
      }

      if (this.getBirthdayMilliseconds() != null) {
         var7 = this.getBirthdayMilliseconds().hashCode();
      }

      return (var6 + (var5 + (var4 + (var3 + (var2 + (var1 + 31) * 31) * 31) * 31) * 31) * 31) * 31 + var7;
   }

   public void setBirthdayMilliseconds(Long var1) {
      this.birthdayMilliseconds = var1;
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

   public void setInvitationCode(String var1) {
      this.invitationCode = var1;
   }

   public void setLastName(String var1) {
      this.lastName = var1;
   }

   public void setOperation(String var1) {
      this.operation = var1;
   }

   public void setPassword(String var1) {
      this.password = var1;
   }

   @Override
   public String toString() {
      return "AccountRequest {email='"
         + this.email
         + '\''
         + "invitationCode='"
         + this.invitationCode
         + '\''
         + ", password='"
         + "********"
         + '\''
         + ", operation='"
         + this.operation
         + '\''
         + ", firstName='"
         + this.firstName
         + '\''
         + ", lastName='"
         + this.lastName
         + '\''
         + ", gender='"
         + this.gender
         + '\''
         + ", birthdayMilliseconds='"
         + this.birthdayMilliseconds
         + '\''
         + '}';
   }
}
