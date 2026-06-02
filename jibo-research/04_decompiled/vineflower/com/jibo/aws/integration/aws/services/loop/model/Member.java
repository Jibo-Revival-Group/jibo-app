package com.jibo.aws.integration.aws.services.loop.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import java.io.Serializable;

public class Member implements Parcelable, Serializable {
   public static final Creator<Member> CREATOR = new Creator<Member>() {
      public Member createFromParcel(Parcel var1) {
         return new Member(var1);
      }

      public Member[] newArray(int var1) {
         return new Member[var1];
      }
   };
   @Expose
   private MemberAccount account;
   @Expose
   private String accountId;
   @Expose
   private String agreementId;
   @Expose
   private Long created;
   @Expose
   private Enrolled enrolled;
   @Expose
   private String id;
   @Expose
   private String legalGuardianId;
   @Expose
   private String loopId;
   @Expose
   private String nickname;
   @Expose
   private String phoneticName;
   @Expose
   private Member.InvitationStatus status;
   @Expose
   private Member.InvitationType type;

   public Member() {
   }

   protected Member(Parcel var1) {
      Object var4 = null;
      super();
      this.id = var1.readString();
      this.loopId = var1.readString();
      this.accountId = var1.readString();
      this.account = (MemberAccount)var1.readParcelable(MemberAccount.class.getClassLoader());
      this.enrolled = (Enrolled)var1.readParcelable(Enrolled.class.getClassLoader());
      int var2 = var1.readInt();
      Member.InvitationStatus var3;
      if (var2 != -1) {
         var3 = Member.InvitationStatus.values()[var2];
      } else {
         var3 = null;
      }

      this.status = var3;
      var2 = var1.readInt();
      Member.InvitationType var6 = (Member.InvitationType)var4;
      if (var2 != -1) {
         var6 = Member.InvitationType.values()[var2];
      }

      this.type = var6;
      this.nickname = var1.readString();
      this.phoneticName = var1.readString();
      this.legalGuardianId = var1.readString();
      this.created = var1.readLong();
      this.agreementId = var1.readString();
   }

   public Member(String var1, String var2, Enrolled var3, Member.InvitationStatus var4, Member.InvitationType var5, String var6, String var7, String var8) {
      this.loopId = var1;
      this.accountId = var2;
      this.enrolled = var3;
      this.status = var4;
      this.type = var5;
      this.nickname = var6;
      this.phoneticName = var7;
      this.legalGuardianId = var8;
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
            if (var1 instanceof Member) {
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

                     if (var1.getAccountId() == null) {
                        var2 = true;
                     } else {
                        var2 = false;
                     }

                     if (this.getAccountId() == null) {
                        var3 = true;
                     } else {
                        var3 = false;
                     }

                     var4 = var5;
                     if (!(var2 ^ var3)) {
                        if (var1.getAccountId() != null) {
                           var4 = var5;
                           if (!var1.getAccountId().equals(this.getAccountId())) {
                              return var4;
                           }
                        }

                        if (var1.getAccount() == null) {
                           var2 = true;
                        } else {
                           var2 = false;
                        }

                        if (this.getAccount() == null) {
                           var3 = true;
                        } else {
                           var3 = false;
                        }

                        var4 = var5;
                        if (!(var2 ^ var3)) {
                           if (var1.getAccount() != null) {
                              var4 = var5;
                              if (!var1.getAccount().equals(this.getAccount())) {
                                 return var4;
                              }
                           }

                           if (var1.getEnrolled() == null) {
                              var2 = true;
                           } else {
                              var2 = false;
                           }

                           if (this.getEnrolled() == null) {
                              var3 = true;
                           } else {
                              var3 = false;
                           }

                           var4 = var5;
                           if (!(var2 ^ var3)) {
                              if (var1.getEnrolled() != null) {
                                 var4 = var5;
                                 if (!var1.getEnrolled().equals(this.getEnrolled())) {
                                    return var4;
                                 }
                              }

                              if (var1.getStatus() == null) {
                                 var2 = true;
                              } else {
                                 var2 = false;
                              }

                              if (this.getStatus() == null) {
                                 var3 = true;
                              } else {
                                 var3 = false;
                              }

                              var4 = var5;
                              if (!(var2 ^ var3)) {
                                 if (var1.getStatus() != null) {
                                    var4 = var5;
                                    if (!var1.getStatus().equals(this.getStatus())) {
                                       return var4;
                                    }
                                 }

                                 if (var1.getType() == null) {
                                    var2 = true;
                                 } else {
                                    var2 = false;
                                 }

                                 if (this.getType() == null) {
                                    var3 = true;
                                 } else {
                                    var3 = false;
                                 }

                                 var4 = var5;
                                 if (!(var2 ^ var3)) {
                                    if (var1.getType() != null) {
                                       var4 = var5;
                                       if (!var1.getType().equals(this.getType())) {
                                          return var4;
                                       }
                                    }

                                    if (var1.getPhoneticName() == null) {
                                       var2 = true;
                                    } else {
                                       var2 = false;
                                    }

                                    if (this.getPhoneticName() == null) {
                                       var3 = true;
                                    } else {
                                       var3 = false;
                                    }

                                    var4 = var5;
                                    if (!(var2 ^ var3)) {
                                       if (var1.getPhoneticName() != null) {
                                          var4 = var5;
                                          if (!var1.getPhoneticName().equals(this.getPhoneticName())) {
                                             return var4;
                                          }
                                       }

                                       if (var1.getLegalGuardianId() == null) {
                                          var2 = true;
                                       } else {
                                          var2 = false;
                                       }

                                       if (this.getLegalGuardianId() == null) {
                                          var3 = true;
                                       } else {
                                          var3 = false;
                                       }

                                       var4 = var5;
                                       if (!(var2 ^ var3)) {
                                          if (var1.getLegalGuardianId() != null) {
                                             var4 = var5;
                                             if (!var1.getLegalGuardianId().equals(this.getLegalGuardianId())) {
                                                return var4;
                                             }
                                          }

                                          if (var1.getCreated() == null) {
                                             var2 = true;
                                          } else {
                                             var2 = false;
                                          }

                                          if (this.getCreated() == null) {
                                             var3 = true;
                                          } else {
                                             var3 = false;
                                          }

                                          var4 = var5;
                                          if (!(var2 ^ var3)) {
                                             if (var1.getCreated() != null) {
                                                var4 = var5;
                                                if (!var1.getCreated().equals(this.getCreated())) {
                                                   return var4;
                                                }
                                             }

                                             if (var1.getAgreementId() == null) {
                                                var2 = true;
                                             } else {
                                                var2 = false;
                                             }

                                             if (this.getAgreementId() == null) {
                                                var3 = true;
                                             } else {
                                                var3 = false;
                                             }

                                             var4 = var5;
                                             if (!(var2 ^ var3)) {
                                                if (var1.getAgreementId() != null) {
                                                   var4 = var5;
                                                   if (!var1.getAgreementId().equals(this.getAgreementId())) {
                                                      return var4;
                                                   }
                                                }

                                                if (var1.getNickname() == null) {
                                                   var2 = true;
                                                } else {
                                                   var2 = false;
                                                }

                                                if (this.getNickname() == null) {
                                                   var3 = true;
                                                } else {
                                                   var3 = false;
                                                }

                                                var4 = var5;
                                                if (!(var2 ^ var3)) {
                                                   if (var1.getNickname() != null) {
                                                      var4 = var5;
                                                      if (!var1.getNickname().equals(this.getNickname())) {
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

      return var4;
   }

   public MemberAccount getAccount() {
      return this.account;
   }

   public String getAccountId() {
      return this.accountId;
   }

   public String getAgreementId() {
      return this.agreementId;
   }

   public Long getCreated() {
      return this.created;
   }

   public Enrolled getEnrolled() {
      return this.enrolled;
   }

   public String getId() {
      return this.id;
   }

   public String getLegalGuardianId() {
      return this.legalGuardianId;
   }

   public String getLoopId() {
      return this.loopId;
   }

   public String getNickname() {
      return this.nickname;
   }

   public String getPhoneticName() {
      return this.phoneticName;
   }

   public Member.InvitationStatus getStatus() {
      return this.status;
   }

   public Member.InvitationType getType() {
      return this.type;
   }

   @Override
   public int hashCode() {
      int var11 = 0;
      int var1;
      if (this.getId() == null) {
         var1 = 0;
      } else {
         var1 = this.getId().hashCode();
      }

      int var2;
      if (this.getLoopId() == null) {
         var2 = 0;
      } else {
         var2 = this.getLoopId().hashCode();
      }

      int var3;
      if (this.getAccountId() == null) {
         var3 = 0;
      } else {
         var3 = this.getAccountId().hashCode();
      }

      int var4;
      if (this.getEnrolled() == null) {
         var4 = 0;
      } else {
         var4 = this.getEnrolled().hashCode();
      }

      int var5;
      if (this.getStatus() == null) {
         var5 = 0;
      } else {
         var5 = this.getStatus().hashCode();
      }

      int var6;
      if (this.getType() == null) {
         var6 = 0;
      } else {
         var6 = this.getType().hashCode();
      }

      int var7;
      if (this.getNickname() == null) {
         var7 = 0;
      } else {
         var7 = this.getNickname().hashCode();
      }

      int var8;
      if (this.getPhoneticName() == null) {
         var8 = 0;
      } else {
         var8 = this.getPhoneticName().hashCode();
      }

      int var9;
      if (this.getLegalGuardianId() == null) {
         var9 = 0;
      } else {
         var9 = this.getLegalGuardianId().hashCode();
      }

      int var10;
      if (this.getCreated() == null) {
         var10 = 0;
      } else {
         var10 = this.getCreated().hashCode();
      }

      if (this.getAgreementId() != null) {
         var11 = this.getAgreementId().hashCode();
      }

      return (var10 + (var9 + (var8 + (var7 + (var6 + (var5 + (var4 + (var3 + (var2 + (var1 + 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31
         + var11;
   }

   public boolean isEnrolled() {
      boolean var2 = true;
      if (this.enrolled != null) {
         boolean var1 = var2;
         if (this.enrolled.getVoice()) {
            return var1;
         }
      }

      boolean var3;
      if (this.enrolled.getFace()) {
         var3 = var2;
      } else {
         var3 = false;
      }

      return var3;
   }

   public void setAccount(MemberAccount var1) {
      this.account = var1;
   }

   public void setAccountId(String var1) {
      this.accountId = var1;
   }

   public void setAgreementId(String var1) {
      this.agreementId = var1;
   }

   public void setCreated(Long var1) {
      this.created = var1;
   }

   public void setEnrolled(Enrolled var1) {
      this.enrolled = var1;
   }

   public void setId(String var1) {
      this.id = var1;
   }

   public void setLegalGuardianId(String var1) {
      this.legalGuardianId = var1;
   }

   public void setLoopId(String var1) {
      this.loopId = var1;
   }

   public void setNickname(String var1) {
      this.nickname = var1;
   }

   public void setPhoneticName(String var1) {
      this.phoneticName = var1;
   }

   public void setStatus(Member.InvitationStatus var1) {
      this.status = var1;
   }

   public void setType(Member.InvitationType var1) {
      this.type = var1;
   }

   @Override
   public String toString() {
      return "Member {id='"
         + this.id
         + '\''
         + ", loopId='"
         + this.loopId
         + '\''
         + ", accountId='"
         + this.accountId
         + '\''
         + ", enrolled='"
         + this.enrolled
         + '\''
         + ", status='"
         + this.status
         + '\''
         + ", type='"
         + this.type
         + '\''
         + ", nickname='"
         + this.nickname
         + '\''
         + ", phoneticName='"
         + this.phoneticName
         + '\''
         + ", legalGuardianId='"
         + this.legalGuardianId
         + '\''
         + ", created='"
         + this.created
         + '\''
         + '}';
   }

   public void writeToParcel(Parcel var1, int var2) {
      byte var3 = -1;
      var1.writeString(this.id);
      var1.writeString(this.loopId);
      var1.writeString(this.accountId);
      var1.writeParcelable(this.account, var2);
      var1.writeParcelable(this.enrolled, var2);
      if (this.status != null) {
         var2 = this.status.ordinal();
      } else {
         var2 = -1;
      }

      var1.writeInt(var2);
      var2 = var3;
      if (this.type != null) {
         var2 = this.type.ordinal();
      }

      var1.writeInt(var2);
      var1.writeString(this.nickname);
      var1.writeString(this.phoneticName);
      var1.writeString(this.legalGuardianId);
      long var4;
      if (this.created == null) {
         var4 = -1L;
      } else {
         var4 = this.created;
      }

      var1.writeLong(var4);
      var1.writeString(this.agreementId);
   }

   public enum InvitationStatus {
      accepted,
      declined,
      invited,
      removed;

      private static final Member.InvitationStatus[] $VALUES = new Member.InvitationStatus[]{
         Member.InvitationStatus.invited, Member.InvitationStatus.accepted, Member.InvitationStatus.declined, Member.InvitationStatus.removed
      };
   }

   public enum InvitationType {
      incoming,
      outgoing;

      private static final Member.InvitationType[] $VALUES = new Member.InvitationType[]{Member.InvitationType.incoming, Member.InvitationType.outgoing};
   }
}
