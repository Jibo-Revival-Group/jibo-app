package com.jibo.aws.integration.aws.services.loop.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.jibo.aws.integration.aws.services.account.model.Account;
import java.io.Serializable;
import java.util.Locale;

public class MemberAccount implements Parcelable, Serializable {
   public static final Creator<MemberAccount> CREATOR = new Creator<MemberAccount>() {
      public MemberAccount createFromParcel(Parcel var1) {
         return new MemberAccount(var1);
      }

      public MemberAccount[] newArray(int var1) {
         return new MemberAccount[var1];
      }
   };
   private Long birthday;
   private String email;
   private String firstName;
   private Account.Gender gender;
   private String lastName;
   private String nickName;
   private String photoUrl;
   private String relationFrom;
   private String relationTo;

   public MemberAccount() {
   }

   private MemberAccount(Parcel var1) {
      this.email = var1.readString();
      this.relationTo = var1.readString();
      this.relationFrom = var1.readString();
      this.nickName = var1.readString();
      this.lastName = var1.readString();
      this.firstName = var1.readString();
      this.gender = Account.Gender.values()[var1.readInt()];
      this.birthday = var1.readLong();
      this.photoUrl = var1.readString();
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
            if (var1 instanceof MemberAccount) {
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

                  if (var1.getRelationTo() == null) {
                     var2 = true;
                  } else {
                     var2 = false;
                  }

                  if (this.getRelationTo() == null) {
                     var3 = true;
                  } else {
                     var3 = false;
                  }

                  var4 = var5;
                  if (!(var2 ^ var3)) {
                     if (var1.getRelationTo() != null) {
                        var4 = var5;
                        if (!var1.getRelationTo().equals(this.getRelationTo())) {
                           return var4;
                        }
                     }

                     if (var1.getRelationFrom() == null) {
                        var2 = true;
                     } else {
                        var2 = false;
                     }

                     if (this.getRelationFrom() == null) {
                        var3 = true;
                     } else {
                        var3 = false;
                     }

                     var4 = var5;
                     if (!(var2 ^ var3)) {
                        if (var1.getRelationFrom() != null) {
                           var4 = var5;
                           if (!var1.getRelationFrom().equals(this.getRelationFrom())) {
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

                                    if (var1.getPhotoUrl() == null) {
                                       var2 = true;
                                    } else {
                                       var2 = false;
                                    }

                                    if (this.getPhotoUrl() == null) {
                                       var3 = true;
                                    } else {
                                       var3 = false;
                                    }

                                    var4 = var5;
                                    if (!(var2 ^ var3)) {
                                       if (var1.getPhotoUrl() != null) {
                                          var4 = var5;
                                          if (!var1.getPhotoUrl().equals(this.getPhotoUrl())) {
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

   public String getFullName() {
      String var1 = this.getFirstName();
      String var2 = this.getLastName();
      if (Locale.getDefault().getLanguage().equals(Locale.CHINESE.getLanguage())) {
         var1 = this.getLastName();
         var2 = this.getFirstName();
      }

      StringBuilder var3 = new StringBuilder();
      if (!TextUtils.isEmpty(var1)) {
         var3.append(var1);
      }

      if (!TextUtils.isEmpty(var2)) {
         if (var3.length() > 0) {
            var3.append(' ');
         }

         var3.append(var2);
      }

      if (var3.length() == 0 && !TextUtils.isEmpty(this.getNickName())) {
         var3.append(this.getNickName());
      }

      return var3.toString();
   }

   public Account.Gender getGender() {
      return this.gender;
   }

   public String getLastName() {
      return this.lastName;
   }

   public String getNickName() {
      return this.nickName;
   }

   public String getPhotoUrl() {
      return this.photoUrl;
   }

   public String getRelationFrom() {
      return this.relationFrom;
   }

   public String getRelationTo() {
      return this.relationTo;
   }

   @Override
   public int hashCode() {
      int var9 = 0;
      int var1;
      if (this.getEmail() == null) {
         var1 = 0;
      } else {
         var1 = this.getEmail().hashCode();
      }

      int var2;
      if (this.getRelationTo() == null) {
         var2 = 0;
      } else {
         var2 = this.getRelationTo().hashCode();
      }

      int var3;
      if (this.getRelationFrom() == null) {
         var3 = 0;
      } else {
         var3 = this.getRelationFrom().hashCode();
      }

      int var4;
      if (this.getNickName() == null) {
         var4 = 0;
      } else {
         var4 = this.getNickName().hashCode();
      }

      int var5;
      if (this.getLastName() == null) {
         var5 = 0;
      } else {
         var5 = this.getLastName().hashCode();
      }

      int var6;
      if (this.getFirstName() == null) {
         var6 = 0;
      } else {
         var6 = this.getFirstName().hashCode();
      }

      int var7;
      if (this.getGender() == null) {
         var7 = 0;
      } else {
         var7 = this.getGender().hashCode();
      }

      int var8;
      if (this.getBirthday() == null) {
         var8 = 0;
      } else {
         var8 = this.getBirthday().hashCode();
      }

      if (this.getPhotoUrl() != null) {
         var9 = this.getPhotoUrl().hashCode();
      }

      return (var8 + (var7 + (var6 + (var5 + (var4 + (var3 + (var2 + (var1 + 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + var9;
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

   public void setLastName(String var1) {
      this.lastName = var1;
   }

   public void setNickName(String var1) {
      this.nickName = var1;
   }

   public void setPhotoUrl(String var1) {
      this.photoUrl = var1;
   }

   public void setRelationFrom(String var1) {
      this.relationFrom = var1;
   }

   public void setRelationTo(String var1) {
      this.relationTo = var1;
   }

   @Override
   public String toString() {
      return this.getClass().getSimpleName()
         + " {"
         + ", email='"
         + this.email
         + '\''
         + ", relationTo='"
         + this.relationTo
         + '\''
         + ", relationFrom='"
         + this.relationFrom
         + '\''
         + ", nickName='"
         + this.nickName
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
         + ", photoUrl='"
         + this.photoUrl
         + '\''
         + '}';
   }

   public void writeToParcel(Parcel var1, int var2) {
      var1.writeString(this.email);
      var1.writeString(this.relationTo);
      var1.writeString(this.relationFrom);
      var1.writeString(this.nickName);
      var1.writeString(this.lastName);
      var1.writeString(this.firstName);
      if (this.gender == null) {
         var2 = Account.Gender.other.ordinal();
      } else {
         var2 = this.gender.ordinal();
      }

      var1.writeInt(var2);
      long var3;
      if (this.birthday == null) {
         var3 = 0L;
      } else {
         var3 = this.birthday;
      }

      var1.writeLong(var3);
      var1.writeString(this.photoUrl);
   }
}
