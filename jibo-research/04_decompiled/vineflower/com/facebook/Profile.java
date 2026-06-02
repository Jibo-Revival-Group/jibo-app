package com.facebook;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.internal.ImageRequest;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import org.json.JSONException;
import org.json.JSONObject;

public final class Profile implements Parcelable {
   public static final Creator<Profile> CREATOR = new Creator() {
      public Profile createFromParcel(Parcel var1) {
         return new Profile(var1);
      }

      public Profile[] newArray(int var1) {
         return new Profile[var1];
      }
   };
   private static final String FIRST_NAME_KEY = "first_name";
   private static final String ID_KEY = "id";
   private static final String LAST_NAME_KEY = "last_name";
   private static final String LINK_URI_KEY = "link_uri";
   private static final String MIDDLE_NAME_KEY = "middle_name";
   private static final String NAME_KEY = "name";
   private final String firstName;
   private final String id;
   private final String lastName;
   private final Uri linkUri;
   private final String middleName;
   private final String name;

   private Profile(Parcel var1) {
      this.id = var1.readString();
      this.firstName = var1.readString();
      this.middleName = var1.readString();
      this.lastName = var1.readString();
      this.name = var1.readString();
      String var2 = var1.readString();
      Uri var3;
      if (var2 == null) {
         var3 = null;
      } else {
         var3 = Uri.parse(var2);
      }

      this.linkUri = var3;
   }

   public Profile(String var1, String var2, String var3, String var4, String var5, Uri var6) {
      Validate.notNullOrEmpty(var1, "id");
      this.id = var1;
      this.firstName = var2;
      this.middleName = var3;
      this.lastName = var4;
      this.name = var5;
      this.linkUri = var6;
   }

   Profile(JSONObject var1) {
      Object var2 = null;
      super();
      this.id = var1.optString("id", null);
      this.firstName = var1.optString("first_name", null);
      this.middleName = var1.optString("middle_name", null);
      this.lastName = var1.optString("last_name", null);
      this.name = var1.optString("name", null);
      String var3 = var1.optString("link_uri", null);
      Uri var4;
      if (var3 == null) {
         var4 = (Uri)var2;
      } else {
         var4 = Uri.parse(var3);
      }

      this.linkUri = var4;
   }

   public static void fetchProfileForCurrentAccessToken() {
      AccessToken var0 = AccessToken.getCurrentAccessToken();
      if (var0 == null) {
         setCurrentProfile(null);
      } else {
         Utility.getGraphMeRequestWithCacheAsync(var0.getToken(), new Utility.GraphMeRequestWithCacheCallback() {
            @Override
            public void onFailure(FacebookException var1) {
            }

            @Override
            public void onSuccess(JSONObject var1) {
               String var2 = var1.optString("id");
               if (var2 != null) {
                  String var7 = var1.optString("link");
                  String var4 = var1.optString("first_name");
                  String var3 = var1.optString("middle_name");
                  String var5 = var1.optString("last_name");
                  String var6 = var1.optString("name");
                  Uri var8;
                  if (var7 != null) {
                     var8 = Uri.parse(var7);
                  } else {
                     var8 = null;
                  }

                  Profile.setCurrentProfile(new Profile(var2, var4, var3, var5, var6, var8));
               }
            }
         });
      }
   }

   public static Profile getCurrentProfile() {
      return ProfileManager.getInstance().getCurrentProfile();
   }

   public static void setCurrentProfile(Profile var0) {
      ProfileManager.getInstance().setCurrentProfile(var0);
   }

   public int describeContents() {
      return 0;
   }

   @Override
   public boolean equals(Object var1) {
      boolean var2 = true;
      if (this != var1) {
         if (!(var1 instanceof Profile)) {
            var2 = false;
         } else {
            var1 = var1;
            if (this.id.equals(var1.id) && this.firstName == null) {
               if (var1.firstName != null) {
                  var2 = false;
               }
            } else if (this.firstName.equals(var1.firstName) && this.middleName == null) {
               if (var1.middleName != null) {
                  var2 = false;
               }
            } else if (this.middleName.equals(var1.middleName) && this.lastName == null) {
               if (var1.lastName != null) {
                  var2 = false;
               }
            } else if (this.lastName.equals(var1.lastName) && this.name == null) {
               if (var1.name != null) {
                  var2 = false;
               }
            } else if (!this.name.equals(var1.name) || this.linkUri != null) {
               var2 = this.linkUri.equals(var1.linkUri);
            } else if (var1.linkUri != null) {
               var2 = false;
            }
         }
      }

      return var2;
   }

   public String getFirstName() {
      return this.firstName;
   }

   public String getId() {
      return this.id;
   }

   public String getLastName() {
      return this.lastName;
   }

   public Uri getLinkUri() {
      return this.linkUri;
   }

   public String getMiddleName() {
      return this.middleName;
   }

   public String getName() {
      return this.name;
   }

   public Uri getProfilePictureUri(int var1, int var2) {
      return ImageRequest.getProfilePictureUri(this.id, var1, var2);
   }

   @Override
   public int hashCode() {
      int var2 = this.id.hashCode() + 527;
      int var1 = var2;
      if (this.firstName != null) {
         var1 = var2 * 31 + this.firstName.hashCode();
      }

      var2 = var1;
      if (this.middleName != null) {
         var2 = var1 * 31 + this.middleName.hashCode();
      }

      var1 = var2;
      if (this.lastName != null) {
         var1 = var2 * 31 + this.lastName.hashCode();
      }

      var2 = var1;
      if (this.name != null) {
         var2 = var1 * 31 + this.name.hashCode();
      }

      var1 = var2;
      if (this.linkUri != null) {
         var1 = var2 * 31 + this.linkUri.hashCode();
      }

      return var1;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   JSONObject toJSONObject() {
      JSONObject var2 = new JSONObject();

      try {
         var2.put("id", this.id);
         var2.put("first_name", this.firstName);
         var2.put("middle_name", this.middleName);
         var2.put("last_name", this.lastName);
         var2.put("name", this.name);
      } catch (JSONException var4) {
         return null;
      }

      JSONObject var1 = var2;

      try {
         if (this.linkUri == null) {
            return var1;
         }

         var2.put("link_uri", this.linkUri.toString());
      } catch (JSONException var3) {
         var1 = null;
         return var1;
      }

      return var2;
   }

   public void writeToParcel(Parcel var1, int var2) {
      var1.writeString(this.id);
      var1.writeString(this.firstName);
      var1.writeString(this.middleName);
      var1.writeString(this.lastName);
      var1.writeString(this.name);
      String var3;
      if (this.linkUri == null) {
         var3 = null;
      } else {
         var3 = this.linkUri.toString();
      }

      var1.writeString(var3);
   }
}
