package com.jibo.aws.integration.aws.services.account.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class FacebookPrepareLogin implements Parcelable, Serializable {
   public static final Creator<FacebookPrepareLogin> CREATOR = new Creator<FacebookPrepareLogin>() {
      public FacebookPrepareLogin createFromParcel(Parcel var1) {
         return new FacebookPrepareLogin(var1);
      }

      public FacebookPrepareLogin[] newArray(int var1) {
         return new FacebookPrepareLogin[var1];
      }
   };
   @Expose
   @SerializedName(a = "client_id")
   private String clientId;
   @Expose
   @SerializedName(a = "redirect_uri")
   private String redirectUri;
   @Expose
   @SerializedName(a = "response_type")
   private String responseType;
   @Expose
   private String scope;
   @Expose
   private String state;
   @Expose
   private String url;

   public FacebookPrepareLogin() {
   }

   protected FacebookPrepareLogin(Parcel var1) {
      this.url = var1.readString();
      this.clientId = var1.readString();
      this.scope = var1.readString();
      this.responseType = var1.readString();
      this.state = var1.readString();
      this.redirectUri = var1.readString();
   }

   public FacebookPrepareLogin(String var1, String var2, String var3, String var4, String var5, String var6) {
      this.url = var1;
      this.clientId = var2;
      this.scope = var3;
      this.responseType = var4;
      this.state = var5;
      this.redirectUri = var6;
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
            if (var1 instanceof FacebookPrepareLogin) {
               var1 = var1;
               boolean var2;
               if (var1.getUrl() == null) {
                  var2 = true;
               } else {
                  var2 = false;
               }

               boolean var3;
               if (this.getUrl() == null) {
                  var3 = true;
               } else {
                  var3 = false;
               }

               var4 = var5;
               if (!(var2 ^ var3)) {
                  if (var1.getUrl() != null) {
                     var4 = var5;
                     if (!var1.getUrl().equals(this.getUrl())) {
                        return var4;
                     }
                  }

                  if (var1.getClientId() == null) {
                     var2 = true;
                  } else {
                     var2 = false;
                  }

                  if (this.getClientId() == null) {
                     var3 = true;
                  } else {
                     var3 = false;
                  }

                  var4 = var5;
                  if (!(var2 ^ var3)) {
                     if (var1.getClientId() != null) {
                        var4 = var5;
                        if (!var1.getClientId().equals(this.getClientId())) {
                           return var4;
                        }
                     }

                     if (var1.getScope() == null) {
                        var2 = true;
                     } else {
                        var2 = false;
                     }

                     if (this.getScope() == null) {
                        var3 = true;
                     } else {
                        var3 = false;
                     }

                     var4 = var5;
                     if (!(var2 ^ var3)) {
                        if (var1.getScope() != null) {
                           var4 = var5;
                           if (!var1.getScope().equals(this.getScope())) {
                              return var4;
                           }
                        }

                        if (var1.getResponseType() == null) {
                           var2 = true;
                        } else {
                           var2 = false;
                        }

                        if (this.getResponseType() == null) {
                           var3 = true;
                        } else {
                           var3 = false;
                        }

                        var4 = var5;
                        if (!(var2 ^ var3)) {
                           if (var1.getResponseType() != null) {
                              var4 = var5;
                              if (!var1.getResponseType().equals(this.getResponseType())) {
                                 return var4;
                              }
                           }

                           if (var1.getState() == null) {
                              var2 = true;
                           } else {
                              var2 = false;
                           }

                           if (this.getState() == null) {
                              var3 = true;
                           } else {
                              var3 = false;
                           }

                           var4 = var5;
                           if (!(var2 ^ var3)) {
                              if (var1.getState() != null) {
                                 var4 = var5;
                                 if (!var1.getState().equals(this.getState())) {
                                    return var4;
                                 }
                              }

                              if (var1.getRedirectUri() == null) {
                                 var2 = true;
                              } else {
                                 var2 = false;
                              }

                              if (this.getRedirectUri() == null) {
                                 var3 = true;
                              } else {
                                 var3 = false;
                              }

                              var4 = var5;
                              if (!(var2 ^ var3)) {
                                 if (var1.getRedirectUri() != null) {
                                    var4 = var5;
                                    if (!var1.getRedirectUri().equals(this.getRedirectUri())) {
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

      return var4;
   }

   public String getClientId() {
      return this.clientId;
   }

   public String getRedirectUri() {
      return this.redirectUri;
   }

   public String getResponseType() {
      return this.responseType;
   }

   public String getScope() {
      return this.scope;
   }

   public String getState() {
      return this.state;
   }

   public String getUrl() {
      return this.url;
   }

   @Override
   public int hashCode() {
      int var6 = 0;
      int var1;
      if (this.getUrl() == null) {
         var1 = 0;
      } else {
         var1 = this.getUrl().hashCode();
      }

      int var2;
      if (this.getClientId() == null) {
         var2 = 0;
      } else {
         var2 = this.getClientId().hashCode();
      }

      int var3;
      if (this.getScope() == null) {
         var3 = 0;
      } else {
         var3 = this.getScope().hashCode();
      }

      int var4;
      if (this.getResponseType() == null) {
         var4 = 0;
      } else {
         var4 = this.getResponseType().hashCode();
      }

      int var5;
      if (this.getState() == null) {
         var5 = 0;
      } else {
         var5 = this.getState().hashCode();
      }

      if (this.getRedirectUri() != null) {
         var6 = this.getRedirectUri().hashCode();
      }

      return (var5 + (var4 + (var3 + (var2 + (var1 + 31) * 31) * 31) * 31) * 31) * 31 + var6;
   }

   public void setClientId(String var1) {
      this.clientId = var1;
   }

   public void setRedirectUri(String var1) {
      this.redirectUri = var1;
   }

   public void setResponseType(String var1) {
      this.responseType = var1;
   }

   public void setScope(String var1) {
      this.scope = var1;
   }

   public void setState(String var1) {
      this.state = var1;
   }

   public void setUrl(String var1) {
      this.url = var1;
   }

   @Override
   public String toString() {
      return "FacebookPrepareLogin {url='"
         + this.url
         + '\''
         + ", clientId='"
         + this.clientId
         + '\''
         + ", scope='"
         + this.scope
         + '\''
         + ", responseType='"
         + this.responseType
         + '\''
         + ", state='"
         + this.state
         + '\''
         + ", redirectUri='"
         + this.redirectUri
         + '\''
         + '}';
   }

   public void writeToParcel(Parcel var1, int var2) {
      var1.writeString(this.url);
      var1.writeString(this.clientId);
      var1.writeString(this.scope);
      var1.writeString(this.responseType);
      var1.writeString(this.state);
      var1.writeString(this.redirectUri);
   }
}
