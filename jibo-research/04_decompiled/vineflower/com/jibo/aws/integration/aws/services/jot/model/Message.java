package com.jibo.aws.integration.aws.services.jot.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Message implements Parcelable, Serializable {
   public static final Creator<Message> CREATOR = new Creator<Message>() {
      public Message createFromParcel(Parcel var1) {
         return new Message(var1);
      }

      public Message[] newArray(int var1) {
         return new Message[var1];
      }
   };
   @Expose
   private String content;
   @Expose
   private Long created;
   @Expose
   private String id;
   @Expose
   private Boolean isEncrypted;
   @Expose
   private Boolean isRead;
   @Expose
   private String loopId;
   @Expose
   private List<MessagePart> parts;
   @Expose
   private String sender;
   @Expose
   private List<String> tags;

   public Message() {
   }

   protected Message(Parcel var1) {
      boolean var3 = true;
      super();
      this.id = var1.readString();
      this.loopId = var1.readString();
      this.content = var1.readString();
      this.sender = var1.readString();
      this.parts = new ArrayList<>();
      var1.readTypedList(this.parts, MessagePart.CREATOR);
      this.tags = new ArrayList<>();
      var1.readStringList(this.tags);
      this.created = var1.readLong();
      boolean var2;
      if (var1.readByte() != 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      this.isRead = var2;
      if (var1.readByte() != 0) {
         var2 = var3;
      } else {
         var2 = false;
      }

      this.isEncrypted = var2;
   }

   public Message(String var1, String var2, String var3, List<MessagePart> var4, List<String> var5, Long var6, boolean var7, boolean var8) {
      this.loopId = var1;
      this.content = var2;
      this.sender = var3;
      this.parts = var4;
      this.tags = var5;
      this.created = var6;
      this.isRead = var7;
      this.isEncrypted = var8;
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
            if (var1 instanceof Message) {
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

                     if (var1.getContent() == null) {
                        var2 = true;
                     } else {
                        var2 = false;
                     }

                     if (this.getContent() == null) {
                        var3 = true;
                     } else {
                        var3 = false;
                     }

                     var4 = var5;
                     if (!(var2 ^ var3)) {
                        if (var1.getContent() != null) {
                           var4 = var5;
                           if (!var1.getContent().equals(this.getContent())) {
                              return var4;
                           }
                        }

                        if (var1.getSender() == null) {
                           var2 = true;
                        } else {
                           var2 = false;
                        }

                        if (this.getSender() == null) {
                           var3 = true;
                        } else {
                           var3 = false;
                        }

                        var4 = var5;
                        if (!(var2 ^ var3)) {
                           if (var1.getSender() != null) {
                              var4 = var5;
                              if (!var1.getSender().equals(this.getSender())) {
                                 return var4;
                              }
                           }

                           if (var1.getParts() == null) {
                              var2 = true;
                           } else {
                              var2 = false;
                           }

                           if (this.getParts() == null) {
                              var3 = true;
                           } else {
                              var3 = false;
                           }

                           var4 = var5;
                           if (!(var2 ^ var3)) {
                              if (var1.getParts() != null) {
                                 var4 = var5;
                                 if (!var1.getParts().equals(this.getParts())) {
                                    return var4;
                                 }
                              }

                              if (var1.getTags() == null) {
                                 var2 = true;
                              } else {
                                 var2 = false;
                              }

                              if (this.getTags() == null) {
                                 var3 = true;
                              } else {
                                 var3 = false;
                              }

                              var4 = var5;
                              if (!(var2 ^ var3)) {
                                 if (var1.getTags() != null) {
                                    var4 = var5;
                                    if (!var1.getTags().equals(this.getTags())) {
                                       return var4;
                                    }
                                 }

                                 if (var1.isRead() == null) {
                                    var2 = true;
                                 } else {
                                    var2 = false;
                                 }

                                 if (this.isRead() == null) {
                                    var3 = true;
                                 } else {
                                    var3 = false;
                                 }

                                 var4 = var5;
                                 if (!(var2 ^ var3)) {
                                    if (var1.isRead() != null) {
                                       var4 = var5;
                                       if (!var1.isRead().equals(this.isRead())) {
                                          return var4;
                                       }
                                    }

                                    if (var1.isEncrypted() == null) {
                                       var2 = true;
                                    } else {
                                       var2 = false;
                                    }

                                    if (this.isEncrypted() == null) {
                                       var3 = true;
                                    } else {
                                       var3 = false;
                                    }

                                    var4 = var5;
                                    if (!(var2 ^ var3)) {
                                       if (var1.isEncrypted() != null) {
                                          var4 = var5;
                                          if (!var1.isEncrypted().equals(this.isEncrypted())) {
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

   public String getContent() {
      return this.content;
   }

   public Long getCreated() {
      return this.created;
   }

   public String getId() {
      return this.id;
   }

   public String getLoopId() {
      return this.loopId;
   }

   public List<MessagePart> getParts() {
      return this.parts;
   }

   public String getSender() {
      return this.sender;
   }

   public List<String> getTags() {
      return this.tags;
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
      if (this.getLoopId() == null) {
         var2 = 0;
      } else {
         var2 = this.getLoopId().hashCode();
      }

      int var3;
      if (this.getContent() == null) {
         var3 = 0;
      } else {
         var3 = this.getContent().hashCode();
      }

      int var4;
      if (this.getSender() == null) {
         var4 = 0;
      } else {
         var4 = this.getSender().hashCode();
      }

      int var5;
      if (this.getParts() == null) {
         var5 = 0;
      } else {
         var5 = this.getParts().hashCode();
      }

      int var6;
      if (this.getTags() == null) {
         var6 = 0;
      } else {
         var6 = this.getTags().hashCode();
      }

      int var7;
      if (this.getCreated() == null) {
         var7 = 0;
      } else {
         var7 = this.getCreated().hashCode();
      }

      int var8;
      if (this.isRead() == null) {
         var8 = 0;
      } else {
         var8 = this.isRead().hashCode();
      }

      if (this.isEncrypted() != null) {
         var9 = this.isEncrypted().hashCode();
      }

      return (var8 + (var7 + (var6 + (var5 + (var4 + (var3 + (var2 + (var1 + 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + var9;
   }

   public Boolean isEncrypted() {
      return this.isEncrypted;
   }

   public Boolean isRead() {
      return this.isRead;
   }

   public void setContent(String var1) {
      this.content = var1;
   }

   public void setCreated(Long var1) {
      this.created = var1;
   }

   public void setEncrypted(Boolean var1) {
      this.isEncrypted = var1;
   }

   public void setId(String var1) {
      this.id = var1;
   }

   public void setLoopId(String var1) {
      this.loopId = var1;
   }

   public void setParts(List<MessagePart> var1) {
      this.parts = var1;
   }

   public void setRead(boolean var1) {
      this.isRead = var1;
   }

   public void setSender(String var1) {
      this.sender = var1;
   }

   public void setTags(List<String> var1) {
      this.tags = var1;
   }

   @Override
   public String toString() {
      return "Message {id='"
         + this.id
         + '\''
         + "loopId='"
         + this.loopId
         + '\''
         + "created='"
         + this.created
         + '\''
         + "sender='"
         + this.sender
         + '\''
         + "tags='"
         + this.tags
         + '\''
         + "content='"
         + this.content
         + '\''
         + "isEncrypted='"
         + this.isEncrypted
         + '\''
         + '}';
   }

   public void writeToParcel(Parcel var1, int var2) {
      byte var3 = 1;
      var1.writeString(this.id);
      var1.writeString(this.loopId);
      var1.writeString(this.content);
      var1.writeString(this.sender);
      var1.writeTypedList(this.parts);
      var1.writeStringList(this.tags);
      var1.writeLong(this.created);
      byte var4;
      if (this.isRead != null && this.isRead) {
         var4 = 1;
      } else {
         var4 = 0;
      }

      var1.writeByte((byte)var4);
      if (this.isEncrypted != null && this.isEncrypted) {
         var4 = var3;
      } else {
         var4 = 0;
      }

      var1.writeByte((byte)var4);
   }
}
