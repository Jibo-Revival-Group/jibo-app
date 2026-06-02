package com.jibo.aws.integration.aws.services.account.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.jibo.aws.integration.R;
import com.jibo.aws.integration.aws.services.common.model.Device;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Account implements Parcelable, Serializable {
   public static final Creator<Account> CREATOR = new Creator<Account>() {
      public Account createFromParcel(Parcel var1) {
         return new Account(var1);
      }

      public Account[] newArray(int var1) {
         return new Account[var1];
      }
   };
   private String accessKeyId;
   private Long birthday;
   private List<Device> devices;
   private String email;
   private String firstName;
   private Account.Gender gender;
   private String id;
   private Boolean isActive;
   private String lastName;
   private Boolean messagingAllowed;
   private transient long modified;
   private String phoneNumber;
   private String photoUrl;
   private transient long retrieved;
   private String secretAccessKey;

   public Account() {
   }

   private Account(Parcel var1) {
      boolean var3 = true;
      super();
      this.id = var1.readString();
      this.email = var1.readString();
      this.accessKeyId = var1.readString();
      this.secretAccessKey = var1.readString();
      this.devices = new ArrayList<>();
      var1.readTypedList(this.devices, Device.CREATOR);
      this.lastName = var1.readString();
      this.firstName = var1.readString();
      this.gender = Account.Gender.values()[var1.readInt()];
      this.birthday = var1.readLong();
      boolean var2;
      if (var1.readInt() > 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      this.isActive = var2;
      this.photoUrl = var1.readString();
      this.phoneNumber = var1.readString();
      if (var1.readInt() > 0) {
         var2 = var3;
      } else {
         var2 = false;
      }

      this.messagingAllowed = var2;
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
            if (var1 instanceof Account) {
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

                     if (var1.getAccessKeyId() == null) {
                        var2 = true;
                     } else {
                        var2 = false;
                     }

                     if (this.getAccessKeyId() == null) {
                        var3 = true;
                     } else {
                        var3 = false;
                     }

                     var4 = var5;
                     if (!(var2 ^ var3)) {
                        if (var1.getAccessKeyId() != null) {
                           var4 = var5;
                           if (!var1.getAccessKeyId().equals(this.getAccessKeyId())) {
                              return var4;
                           }
                        }

                        if (var1.getSecretAccessKey() == null) {
                           var2 = true;
                        } else {
                           var2 = false;
                        }

                        if (this.getSecretAccessKey() == null) {
                           var3 = true;
                        } else {
                           var3 = false;
                        }

                        var4 = var5;
                        if (!(var2 ^ var3)) {
                           if (var1.getSecretAccessKey() != null) {
                              var4 = var5;
                              if (!var1.getSecretAccessKey().equals(this.getSecretAccessKey())) {
                                 return var4;
                              }
                           }

                           if (var1.getDevices() == null) {
                              var2 = true;
                           } else {
                              var2 = false;
                           }

                           if (this.getDevices() == null) {
                              var3 = true;
                           } else {
                              var3 = false;
                           }

                           var4 = var5;
                           if (!(var2 ^ var3)) {
                              if (var1.getDevices() != null) {
                                 var4 = var5;
                                 if (!var1.getDevices().equals(this.getDevices())) {
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

                                          if (var1.isActive() == null) {
                                             var2 = true;
                                          } else {
                                             var2 = false;
                                          }

                                          if (this.isActive() == null) {
                                             var3 = true;
                                          } else {
                                             var3 = false;
                                          }

                                          var4 = var5;
                                          if (!(var2 ^ var3)) {
                                             if (var1.isActive() != null) {
                                                var4 = var5;
                                                if (!var1.isActive().equals(this.isActive())) {
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
               }
            }
         }
      }

      return var4;
   }

   public String getAccessKeyId() {
      return this.accessKeyId;
   }

   public Long getBirthday() {
      return this.birthday;
   }

   public List<Device> getDevices() {
      return this.devices;
   }

   public String getEmail() {
      return this.email;
   }

   public String getFirstName() {
      return this.firstName;
   }

   public String getFullName() {
      String var2 = this.getFirstName();
      String var1 = this.getLastName();
      if (Locale.getDefault().getLanguage().equals(Locale.CHINESE.getLanguage())) {
         var2 = this.getLastName();
         var1 = this.getFirstName();
      }

      StringBuilder var3 = new StringBuilder();
      if (!TextUtils.isEmpty(var2)) {
         var3.append(var2);
      }

      if (!TextUtils.isEmpty(var1)) {
         if (var3.length() > 0) {
            var3.append(' ');
         }

         var3.append(var1);
      }

      return var3.toString();
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

   public long getModified() {
      return this.modified;
   }

   public String getPhoneNumber() {
      return this.phoneNumber;
   }

   public String getPhotoUrl() {
      return this.photoUrl;
   }

   public long getRetrieved() {
      return this.retrieved;
   }

   public String getSecretAccessKey() {
      return this.secretAccessKey;
   }

   public UpdateRequest getUpdateRequest(Account var1) {
      boolean var4 = true;
      UpdateRequest var5 = new UpdateRequest(this.getId());
      if (this.getId().equals(var1.getId())) {
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

         if (var2 ^ var3
            || var1.getEmail() != null && !var1.getEmail().equals(this.getEmail())
            || this.getEmail() != null && !this.getEmail().equals(var1.getEmail())) {
            var5.setEmail(this.getEmail());
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

         if (var2 ^ var3
            || var1.getLastName() != null && !var1.getLastName().equals(this.getLastName())
            || this.getLastName() != null && !this.getLastName().equals(var1.getLastName())) {
            var5.setLastName(this.getLastName());
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

         if (var2 ^ var3
            || var1.getFirstName() != null && !var1.getFirstName().equals(this.getFirstName())
            || this.getFirstName() != null && !this.getFirstName().equals(var1.getFirstName())) {
            var5.setFirstName(this.getFirstName());
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

         if (var2 ^ var3
            || var1.getGender() != null && !var1.getGender().equals(this.getGender())
            || this.getGender() != null && !this.getGender().equals(var1.getGender())) {
            var5.setGender(this.getGender());
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

         if (var2 ^ var3
            || var1.getBirthday() != null && !var1.getBirthday().equals(this.getBirthday())
            || this.getBirthday() != null && !this.getBirthday().equals(var1.getBirthday())) {
            var5.setBirthday(this.getBirthday());
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

         if (var2 ^ var3
            || var1.getPhoneNumber() != null && !var1.getPhoneNumber().equals(this.getPhoneNumber())
            || this.getPhoneNumber() != null && !this.getPhoneNumber().equals(var1.getPhoneNumber())) {
            var5.setPhoneNumber(this.getPhoneNumber());
         }

         if (var1.isMessagingAllowed() == null) {
            var2 = true;
         } else {
            var2 = false;
         }

         if (this.isMessagingAllowed() == null) {
            var3 = var4;
         } else {
            var3 = false;
         }

         if (var2 ^ var3
            || var1.isMessagingAllowed() != null && !var1.isMessagingAllowed().equals(this.isMessagingAllowed())
            || this.isMessagingAllowed() != null && !this.isMessagingAllowed().equals(var1.isMessagingAllowed())) {
            var5.setMessagingAllowed(this.isMessagingAllowed());
         }
      }

      return var5;
   }

   @Override
   public int hashCode() {
      int var12 = 0;
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
      if (this.getAccessKeyId() == null) {
         var3 = 0;
      } else {
         var3 = this.getAccessKeyId().hashCode();
      }

      int var4;
      if (this.getSecretAccessKey() == null) {
         var4 = 0;
      } else {
         var4 = this.getSecretAccessKey().hashCode();
      }

      int var5;
      if (this.getDevices() == null) {
         var5 = 0;
      } else {
         var5 = this.getDevices().hashCode();
      }

      int var6;
      if (this.getLastName() == null) {
         var6 = 0;
      } else {
         var6 = this.getLastName().hashCode();
      }

      int var7;
      if (this.getFirstName() == null) {
         var7 = 0;
      } else {
         var7 = this.getFirstName().hashCode();
      }

      int var8;
      if (this.getGender() == null) {
         var8 = 0;
      } else {
         var8 = this.getGender().hashCode();
      }

      int var13 = this.getBirthday().hashCode();
      int var9;
      if (this.isActive() == null) {
         var9 = 0;
      } else {
         var9 = this.isActive().hashCode();
      }

      int var10;
      if (this.getPhotoUrl() == null) {
         var10 = 0;
      } else {
         var10 = this.getPhotoUrl().hashCode();
      }

      int var11;
      if (this.getPhoneNumber() == null) {
         var11 = 0;
      } else {
         var11 = this.getPhoneNumber().hashCode();
      }

      if (this.isMessagingAllowed() != null) {
         var12 = this.isMessagingAllowed().hashCode();
      }

      return (
               var11
                  + (
                        var10
                           + (
                                 var9
                                    + (
                                          (var8 + (var7 + (var6 + (var5 + (var4 + (var3 + (var2 + (var1 + 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31
                                             + var13
                                       )
                                       * 31
                              )
                              * 31
                     )
                     * 31
            )
            * 31
         + var12;
   }

   public Boolean isActive() {
      return this.isActive;
   }

   public boolean isIncomplete() {
      boolean var1;
      if (!TextUtils.isEmpty(this.getFirstName()) && !TextUtils.isEmpty(this.getLastName()) && this.getGender() != null) {
         var1 = false;
      } else {
         var1 = true;
      }

      return var1;
   }

   public Boolean isMessagingAllowed() {
      return this.messagingAllowed;
   }

   public void setAccessKeyId(String var1) {
      this.accessKeyId = var1;
   }

   public void setBirthday(Long var1) {
      this.birthday = var1;
   }

   public void setDevices(List<Device> var1) {
      this.devices = var1;
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

   public void setIsActive(Boolean var1) {
      this.isActive = var1;
   }

   public void setLastName(String var1) {
      this.lastName = var1;
   }

   public void setMessagingAllowed(Boolean var1) {
      this.messagingAllowed = var1;
   }

   public void setModified(long var1) {
      this.modified = var1;
   }

   public void setPhoneNumber(String var1) {
      this.phoneNumber = var1;
   }

   public void setPhotoUrl(String var1) {
      this.photoUrl = var1;
   }

   public void setRetrieved(long var1) {
      this.retrieved = var1;
   }

   public void setSecretAccessKey(String var1) {
      this.secretAccessKey = var1;
   }

   @Override
   public String toString() {
      return this.getClass().getSimpleName()
         + " {"
         + "id='"
         + this.id
         + '\''
         + ", email='"
         + this.email
         + '\''
         + ", accessKeyId='"
         + this.accessKeyId
         + '\''
         + ", secretAccessKey='"
         + this.secretAccessKey
         + '\''
         + ", devices='["
         + this.devices
         + "]'"
         + ", lastName='"
         + this.lastName
         + '\''
         + ", firstName='"
         + this.firstName
         + '\''
         + ", birthday='"
         + this.birthday
         + '\''
         + ", isActive='"
         + this.isActive
         + '\''
         + ", photoUrl='"
         + this.photoUrl
         + '\''
         + ", phoneNumber='"
         + this.phoneNumber
         + '\''
         + ", messagingAllowed='"
         + this.messagingAllowed
         + '\''
         + '}';
   }

   public void update(Account var1) {
      if (var1.email != null) {
         this.email = var1.email;
      }

      if (var1.accessKeyId != null) {
         this.accessKeyId = var1.accessKeyId;
      }

      if (var1.secretAccessKey != null) {
         this.secretAccessKey = var1.secretAccessKey;
      }

      if (var1.devices != null) {
         this.devices = var1.devices;
      }

      if (var1.lastName != null) {
         this.lastName = var1.lastName;
      }

      if (var1.firstName != null) {
         this.firstName = var1.firstName;
      }

      if (var1.gender != null) {
         this.gender = var1.gender;
      }

      if (var1.birthday != null) {
         this.birthday = var1.birthday;
      }

      if (var1.isActive != null) {
         this.isActive = var1.isActive;
      }

      if (var1.photoUrl != null) {
         this.photoUrl = var1.photoUrl;
      }

      if (var1.phoneNumber != null) {
         this.phoneNumber = var1.phoneNumber;
      }

      if (var1.messagingAllowed != null) {
         this.messagingAllowed = var1.messagingAllowed;
      }
   }

   public void update(UpdateRequest var1) {
      if (var1.getEmail() != null) {
         this.email = var1.getEmail();
      }

      if (var1.getLastName() != null) {
         this.lastName = var1.getLastName();
      }

      if (var1.getFirstName() != null) {
         this.firstName = var1.getFirstName();
      }

      if (var1.getGender() != null) {
         this.gender = var1.getGender();
      }

      if (var1.getBirthday() != null) {
         this.birthday = var1.getBirthday();
      }
   }

   public void writeToParcel(Parcel var1, int var2) {
      byte var3 = 1;
      var1.writeString(this.id);
      var1.writeString(this.email);
      var1.writeString(this.accessKeyId);
      var1.writeString(this.secretAccessKey);
      var1.writeTypedList(this.devices);
      var1.writeString(this.lastName);
      var1.writeString(this.firstName);
      if (this.gender == null) {
         var2 = Account.Gender.other.ordinal();
      } else {
         var2 = this.gender.ordinal();
      }

      var1.writeInt(var2);
      long var4;
      if (this.birthday == null) {
         var4 = 0L;
      } else {
         var4 = this.birthday;
      }

      var1.writeLong(var4);
      byte var7;
      if (this.isActive != null && this.isActive) {
         var7 = 1;
      } else {
         var7 = 0;
      }

      label24: {
         var1.writeInt(var7);
         var1.writeString(this.photoUrl);
         var1.writeString(this.phoneNumber);
         if (this.messagingAllowed != null) {
            var7 = var3;
            if (this.messagingAllowed) {
               break label24;
            }
         }

         var7 = 0;
      }

      var1.writeInt(var7);
   }

   public enum Gender {
      female(R.string.jbaws_Female),
      male(R.string.jbaws_Male),
      other(R.string.jbaws_Other),
      they(R.string.jbaws_They);

      private static final Account.Gender[] $VALUES = new Account.Gender[]{
         Account.Gender.male, Account.Gender.female, Account.Gender.other, Account.Gender.they
      };
      private final int nameId;

      Gender(int var3) {
         this.nameId = var3;
      }

      public int getNameId() {
         return this.nameId;
      }
   }
}
