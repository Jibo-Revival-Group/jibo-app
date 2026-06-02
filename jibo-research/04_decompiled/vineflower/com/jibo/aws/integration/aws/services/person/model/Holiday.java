package com.jibo.aws.integration.aws.services.person.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import java.io.Serializable;

public class Holiday implements Parcelable, Serializable {
   public static final String CATEGORY_BIRTHDAY = "birthday";
   public static final String CATEGORY_CULTURAL = "cultural";
   public static final String CATEGORY_NATIONAL = "national";
   public static final String CATEGORY_PUBLIC = "public";
   public static final Creator<Holiday> CREATOR = new Creator<Holiday>() {
      public Holiday createFromParcel(Parcel var1) {
         return new Holiday(var1);
      }

      public Holiday[] newArray(int var1) {
         return new Holiday[var1];
      }
   };
   @Expose
   private String category;
   @Expose
   private Long created;
   @Expose
   private String date;
   @Expose
   private String endDate;
   @Expose
   private String id;
   @Expose
   private Boolean isEnabled;
   @Expose
   private String loopId;
   @Expose
   private String memberId;
   @Expose
   private String name;
   @Expose
   private String subcategory;

   public Holiday() {
   }

   private Holiday(Parcel var1) {
      this.id = var1.readString();
      this.name = var1.readString();
      this.loopId = var1.readString();
      this.category = var1.readString();
      this.subcategory = var1.readString();
      this.memberId = var1.readString();
      this.date = var1.readString();
      this.endDate = var1.readString();
      this.created = var1.readLong();
      boolean var2;
      if (var1.readInt() > 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      this.isEnabled = var2;
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
            if (var1 instanceof Holiday) {
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

                           if (var1.getSubcategory() == null) {
                              var2 = true;
                           } else {
                              var2 = false;
                           }

                           if (this.getSubcategory() == null) {
                              var3 = true;
                           } else {
                              var3 = false;
                           }

                           var4 = var5;
                           if (!(var2 ^ var3)) {
                              if (var1.getSubcategory() != null) {
                                 var4 = var5;
                                 if (!var1.getSubcategory().equals(this.getSubcategory())) {
                                    return var4;
                                 }
                              }

                              if (var1.getMemberId() == null) {
                                 var2 = true;
                              } else {
                                 var2 = false;
                              }

                              if (this.getMemberId() == null) {
                                 var3 = true;
                              } else {
                                 var3 = false;
                              }

                              var4 = var5;
                              if (!(var2 ^ var3)) {
                                 if (var1.getMemberId() != null) {
                                    var4 = var5;
                                    if (!var1.getMemberId().equals(this.getMemberId())) {
                                       return var4;
                                    }
                                 }

                                 if (var1.getEnabled() == null) {
                                    var2 = true;
                                 } else {
                                    var2 = false;
                                 }

                                 if (this.getEnabled() == null) {
                                    var3 = true;
                                 } else {
                                    var3 = false;
                                 }

                                 var4 = var5;
                                 if (!(var2 ^ var3)) {
                                    if (var1.getEnabled() != null) {
                                       var4 = var5;
                                       if (!var1.getEnabled().equals(this.getEnabled())) {
                                          return var4;
                                       }
                                    }

                                    if (var1.getDate() == null) {
                                       var2 = true;
                                    } else {
                                       var2 = false;
                                    }

                                    if (this.getDate() == null) {
                                       var3 = true;
                                    } else {
                                       var3 = false;
                                    }

                                    var4 = var5;
                                    if (!(var2 ^ var3)) {
                                       if (var1.getDate() != null) {
                                          var4 = var5;
                                          if (!var1.getDate().equals(this.getDate())) {
                                             return var4;
                                          }
                                       }

                                       if (var1.getEndDate() == null) {
                                          var2 = true;
                                       } else {
                                          var2 = false;
                                       }

                                       if (this.getEndDate() == null) {
                                          var3 = true;
                                       } else {
                                          var3 = false;
                                       }

                                       var4 = var5;
                                       if (!(var2 ^ var3)) {
                                          if (var1.getEndDate() != null) {
                                             var4 = var5;
                                             if (!var1.getEndDate().equals(this.getEndDate())) {
                                                return var4;
                                             }
                                          }

                                          if (var1.getCategory() == null) {
                                             var2 = true;
                                          } else {
                                             var2 = false;
                                          }

                                          if (this.getCategory() == null) {
                                             var3 = true;
                                          } else {
                                             var3 = false;
                                          }

                                          var4 = var5;
                                          if (!(var2 ^ var3)) {
                                             if (var1.getCategory() != null) {
                                                var4 = var5;
                                                if (!var1.getCategory().equals(this.getCategory())) {
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

      return var4;
   }

   public String getCategory() {
      return this.category;
   }

   public Long getCreated() {
      return this.created;
   }

   public String getDate() {
      return this.date;
   }

   public Boolean getEnabled() {
      return this.isEnabled;
   }

   public String getEndDate() {
      return this.endDate;
   }

   public String getId() {
      return this.id;
   }

   public String getLoopId() {
      return this.loopId;
   }

   public String getMemberId() {
      return this.memberId;
   }

   public String getName() {
      return this.name;
   }

   public String getSubcategory() {
      return this.subcategory;
   }

   @Override
   public int hashCode() {
      int var10 = 0;
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
      if (this.getLoopId() == null) {
         var3 = 0;
      } else {
         var3 = this.getLoopId().hashCode();
      }

      int var4;
      if (this.getCategory() == null) {
         var4 = 0;
      } else {
         var4 = this.getCategory().hashCode();
      }

      int var5;
      if (this.getCreated() == null) {
         var5 = 0;
      } else {
         var5 = this.getCreated().hashCode();
      }

      int var6;
      if (this.getSubcategory() == null) {
         var6 = 0;
      } else {
         var6 = this.getSubcategory().hashCode();
      }

      int var7;
      if (this.getMemberId() == null) {
         var7 = 0;
      } else {
         var7 = this.getMemberId().hashCode();
      }

      int var8;
      if (this.getEnabled() == null) {
         var8 = 0;
      } else {
         var8 = this.getEnabled().hashCode();
      }

      int var9;
      if (this.getDate() == null) {
         var9 = 0;
      } else {
         var9 = this.getDate().hashCode();
      }

      if (this.getEndDate() != null) {
         var10 = this.getEndDate().hashCode();
      }

      return (var9 + (var8 + (var7 + (var6 + (var5 + (var4 + (var3 + (var2 + (var1 + 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + var10;
   }

   public void setCategory(String var1) {
      this.category = var1;
   }

   public void setCreated(Long var1) {
      this.created = var1;
   }

   public void setDate(String var1) {
      this.date = var1;
   }

   public void setEnabled(Boolean var1) {
      this.isEnabled = var1;
   }

   public void setEndDate(String var1) {
      this.endDate = var1;
   }

   public void setId(String var1) {
      this.id = var1;
   }

   public void setLoopId(String var1) {
      this.loopId = var1;
   }

   public void setMemberId(String var1) {
      this.memberId = var1;
   }

   public void setName(String var1) {
      this.name = var1;
   }

   public void setSubcategory(String var1) {
      this.subcategory = var1;
   }

   @Override
   public String toString() {
      return "Holiday {id='"
         + this.id
         + '\''
         + "category='"
         + this.category
         + '\''
         + "name='"
         + this.name
         + '\''
         + "loopId='"
         + this.loopId
         + '\''
         + "created='"
         + this.created
         + '\''
         + "subcategory='"
         + this.subcategory
         + '\''
         + "memberId='"
         + this.memberId
         + '\''
         + "isEnabled='"
         + this.isEnabled
         + '\''
         + "date='"
         + this.date
         + '\''
         + "endDate='"
         + this.endDate
         + '\''
         + '}';
   }

   public void writeToParcel(Parcel var1, int var2) {
      var1.writeString(this.id);
      var1.writeString(this.name);
      var1.writeString(this.loopId);
      var1.writeString(this.category);
      var1.writeString(this.subcategory);
      var1.writeString(this.memberId);
      var1.writeString(this.date);
      var1.writeString(this.endDate);
      long var3;
      if (this.created == null) {
         var3 = -1L;
      } else {
         var3 = this.created;
      }

      var1.writeLong(var3);
      byte var5;
      if (this.isEnabled != null && this.isEnabled) {
         var5 = 1;
      } else {
         var5 = 0;
      }

      var1.writeInt(var5);
   }
}
