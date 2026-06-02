package com.facebook;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class AccessToken implements Parcelable {
   public static final String ACCESS_TOKEN_KEY = "access_token";
   private static final String APPLICATION_ID_KEY = "application_id";
   public static final Creator<AccessToken> CREATOR = new Creator() {
      public AccessToken createFromParcel(Parcel var1) {
         return new AccessToken(var1);
      }

      public AccessToken[] newArray(int var1) {
         return new AccessToken[var1];
      }
   };
   private static final int CURRENT_JSON_FORMAT = 1;
   private static final String DECLINED_PERMISSIONS_KEY = "declined_permissions";
   private static final AccessTokenSource DEFAULT_ACCESS_TOKEN_SOURCE = AccessTokenSource.FACEBOOK_APPLICATION_WEB;
   private static final Date DEFAULT_EXPIRATION_TIME = AccessToken.MAX_DATE;
   private static final Date DEFAULT_LAST_REFRESH_TIME = new Date();
   private static final String EXPIRES_AT_KEY = "expires_at";
   public static final String EXPIRES_IN_KEY = "expires_in";
   private static final String LAST_REFRESH_KEY = "last_refresh";
   private static final Date MAX_DATE = new Date(Long.MAX_VALUE);
   private static final String PERMISSIONS_KEY = "permissions";
   private static final String SOURCE_KEY = "source";
   private static final String TOKEN_KEY = "token";
   public static final String USER_ID_KEY = "user_id";
   private static final String VERSION_KEY = "version";
   private final String applicationId;
   private final Set<String> declinedPermissions;
   private final Date expires;
   private final Date lastRefresh;
   private final Set<String> permissions;
   private final AccessTokenSource source;
   private final String token;
   private final String userId;

   AccessToken(Parcel var1) {
      this.expires = new Date(var1.readLong());
      ArrayList var2 = new ArrayList();
      var1.readStringList(var2);
      this.permissions = Collections.unmodifiableSet(new HashSet<>(var2));
      var2.clear();
      var1.readStringList(var2);
      this.declinedPermissions = Collections.unmodifiableSet(new HashSet<>(var2));
      this.token = var1.readString();
      this.source = AccessTokenSource.valueOf(var1.readString());
      this.lastRefresh = new Date(var1.readLong());
      this.applicationId = var1.readString();
      this.userId = var1.readString();
   }

   public AccessToken(String var1, String var2, String var3, Collection<String> var4, Collection<String> var5, AccessTokenSource var6, Date var7, Date var8) {
      Validate.notNullOrEmpty(var1, "accessToken");
      Validate.notNullOrEmpty(var2, "applicationId");
      Validate.notNullOrEmpty(var3, "userId");
      if (var7 == null) {
         var7 = DEFAULT_EXPIRATION_TIME;
      }

      this.expires = var7;
      if (var4 != null) {
         var4 = new HashSet(var4);
      } else {
         var4 = new HashSet();
      }

      this.permissions = Collections.unmodifiableSet(var4);
      if (var5 != null) {
         var4 = new HashSet(var5);
      } else {
         var4 = new HashSet();
      }

      this.declinedPermissions = Collections.unmodifiableSet(var4);
      this.token = var1;
      if (var6 == null) {
         var6 = DEFAULT_ACCESS_TOKEN_SOURCE;
      }

      this.source = var6;
      if (var8 == null) {
         var8 = DEFAULT_LAST_REFRESH_TIME;
      }

      this.lastRefresh = var8;
      this.applicationId = var2;
      this.userId = var3;
   }

   private void appendPermissions(StringBuilder var1) {
      var1.append(" permissions:");
      if (this.permissions == null) {
         var1.append("null");
      } else {
         var1.append("[");
         var1.append(TextUtils.join(", ", this.permissions));
         var1.append("]");
      }
   }

   private static AccessToken createFromBundle(List<String> var0, Bundle var1, AccessTokenSource var2, Date var3, String var4) {
      String var5 = var1.getString("access_token");
      var3 = Utility.getBundleLongAsDate(var1, "expires_in", var3);
      String var7 = var1.getString("user_id");
      AccessToken var6;
      if (!Utility.isNullOrEmpty(var5) && var3 != null) {
         var6 = new AccessToken(var5, var4, var7, var0, null, var2, var3, new Date());
      } else {
         var6 = null;
      }

      return var6;
   }

   static AccessToken createFromJSONObject(JSONObject var0) throws JSONException {
      if (var0.getInt("version") > 1) {
         throw new FacebookException("Unknown AccessToken serialization format.");
      }

      String var3 = var0.getString("token");
      Date var5 = new Date(var0.getLong("expires_at"));
      JSONArray var2 = var0.getJSONArray("permissions");
      JSONArray var6 = var0.getJSONArray("declined_permissions");
      Date var1 = new Date(var0.getLong("last_refresh"));
      AccessTokenSource var4 = AccessTokenSource.valueOf(var0.getString("source"));
      return new AccessToken(
         var3,
         var0.getString("application_id"),
         var0.getString("user_id"),
         Utility.jsonArrayToStringList(var2),
         Utility.jsonArrayToStringList(var6),
         var4,
         var5,
         var1
      );
   }

   static AccessToken createFromLegacyCache(Bundle var0) {
      List var4 = getPermissionsFromBundle(var0, "com.facebook.TokenCachingStrategy.Permissions");
      List var3 = getPermissionsFromBundle(var0, "com.facebook.TokenCachingStrategy.DeclinedPermissions");
      String var2 = LegacyTokenHelper.getApplicationId(var0);
      String var1 = var2;
      if (Utility.isNullOrEmpty(var2)) {
         var1 = FacebookSdk.getApplicationId();
      }

      var2 = LegacyTokenHelper.getToken(var0);
      JSONObject var5 = Utility.awaitGetGraphMeRequestWithCache(var2);

      try {
         var9 = var5.getString("id");
      } catch (JSONException var6) {
         return null;
      }

      return new AccessToken(
         var2,
         var1,
         var9,
         var4,
         var3,
         LegacyTokenHelper.getSource(var0),
         LegacyTokenHelper.getDate(var0, "com.facebook.TokenCachingStrategy.ExpirationDate"),
         LegacyTokenHelper.getDate(var0, "com.facebook.TokenCachingStrategy.LastRefreshDate")
      );
   }

   public static void createFromNativeLinkingIntent(Intent var0, String var1, AccessToken.AccessTokenCreationCallback var2) {
      Validate.notNull(var0, "intent");
      if (var0.getExtras() == null) {
         var2.onError(new FacebookException("No extras found on intent"));
      } else {
         Bundle var3 = new Bundle(var0.getExtras());
         String var4 = var3.getString("access_token");
         if (var4 != null && !var4.isEmpty()) {
            String var5 = var3.getString("user_id");
            if (var5 != null && !var5.isEmpty()) {
               var2.onSuccess(createFromBundle(null, var3, AccessTokenSource.FACEBOOK_APPLICATION_WEB, new Date(), var1));
            } else {
               Utility.getGraphMeRequestWithCacheAsync(var4, new Utility.GraphMeRequestWithCacheCallback(var3, var2, var1) {
                  final AccessToken.AccessTokenCreationCallback val$accessTokenCallback;
                  final String val$applicationId;
                  final Bundle val$extras;

                  {
                     this.val$extras = var1;
                     this.val$accessTokenCallback = var2x;
                     this.val$applicationId = var3x;
                  }

                  @Override
                  public void onFailure(FacebookException var1) {
                     this.val$accessTokenCallback.onError(var1);
                  }

                  @Override
                  public void onSuccess(JSONObject var1) {
                     try {
                        String var6 = var1.getString("id");
                        this.val$extras.putString("user_id", var6);
                        AccessToken.AccessTokenCreationCallback var7 = this.val$accessTokenCallback;
                        Bundle var2x = this.val$extras;
                        AccessTokenSource var3x = AccessTokenSource.FACEBOOK_APPLICATION_WEB;
                        Date var4x = new Date();
                        var7.onSuccess(AccessToken.createFromBundle(null, var2x, var3x, var4x, this.val$applicationId));
                     } catch (JSONException var5x) {
                        this.val$accessTokenCallback.onError(new FacebookException("Unable to generate access token due to missing user id"));
                     }
                  }
               });
            }
         } else {
            var2.onError(new FacebookException("No access token found on intent"));
         }
      }
   }

   @SuppressLint("FieldGetter")
   static AccessToken createFromRefresh(AccessToken var0, Bundle var1) {
      if (var0.source != AccessTokenSource.FACEBOOK_APPLICATION_WEB
         && var0.source != AccessTokenSource.FACEBOOK_APPLICATION_NATIVE
         && var0.source != AccessTokenSource.FACEBOOK_APPLICATION_SERVICE) {
         throw new FacebookException("Invalid token source: " + var0.source);
      }

      Date var2 = Utility.getBundleLongAsDate(var1, "expires_in", new Date(0L));
      String var4 = var1.getString("access_token");
      if (Utility.isNullOrEmpty(var4)) {
         var0 = null;
      } else {
         var0 = new AccessToken(var4, var0.applicationId, var0.getUserId(), var0.getPermissions(), var0.getDeclinedPermissions(), var0.source, var2, new Date());
      }

      return var0;
   }

   public static AccessToken getCurrentAccessToken() {
      return AccessTokenManager.getInstance().getCurrentAccessToken();
   }

   static List<String> getPermissionsFromBundle(Bundle var0, String var1) {
      ArrayList var2 = var0.getStringArrayList(var1);
      List var3;
      if (var2 == null) {
         var3 = Collections.emptyList();
      } else {
         var3 = Collections.unmodifiableList(new ArrayList(var2));
      }

      return var3;
   }

   public static void refreshCurrentAccessTokenAsync() {
      AccessTokenManager.getInstance().refreshCurrentAccessToken(null);
   }

   public static void refreshCurrentAccessTokenAsync(AccessToken.AccessTokenRefreshCallback var0) {
      AccessTokenManager.getInstance().refreshCurrentAccessToken(var0);
   }

   public static void setCurrentAccessToken(AccessToken var0) {
      AccessTokenManager.getInstance().setCurrentAccessToken(var0);
   }

   private String tokenToString() {
      String var1;
      if (this.token == null) {
         var1 = "null";
      } else if (FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.INCLUDE_ACCESS_TOKENS)) {
         var1 = this.token;
      } else {
         var1 = "ACCESS_TOKEN_REMOVED";
      }

      return var1;
   }

   public int describeContents() {
      return 0;
   }

   @Override
   public boolean equals(Object var1) {
      boolean var2 = true;
      if (this != var1) {
         if (!(var1 instanceof AccessToken)) {
            var2 = false;
         } else {
            var1 = var1;
            if (!this.expires.equals(var1.expires)
               || !this.permissions.equals(var1.permissions)
               || !this.declinedPermissions.equals(var1.declinedPermissions)
               || !this.token.equals(var1.token)
               || this.source != var1.source
               || !this.lastRefresh.equals(var1.lastRefresh)
               || (this.applicationId == null ? var1.applicationId != null : !this.applicationId.equals(var1.applicationId))
               || !this.userId.equals(var1.userId)) {
               var2 = false;
            }
         }
      }

      return var2;
   }

   public String getApplicationId() {
      return this.applicationId;
   }

   public Set<String> getDeclinedPermissions() {
      return this.declinedPermissions;
   }

   public Date getExpires() {
      return this.expires;
   }

   public Date getLastRefresh() {
      return this.lastRefresh;
   }

   public Set<String> getPermissions() {
      return this.permissions;
   }

   public AccessTokenSource getSource() {
      return this.source;
   }

   public String getToken() {
      return this.token;
   }

   public String getUserId() {
      return this.userId;
   }

   @Override
   public int hashCode() {
      int var7 = this.expires.hashCode();
      int var2 = this.permissions.hashCode();
      int var4 = this.declinedPermissions.hashCode();
      int var3 = this.token.hashCode();
      int var5 = this.source.hashCode();
      int var6 = this.lastRefresh.hashCode();
      int var1;
      if (this.applicationId == null) {
         var1 = 0;
      } else {
         var1 = this.applicationId.hashCode();
      }

      return (var1 + ((((((var7 + 527) * 31 + var2) * 31 + var4) * 31 + var3) * 31 + var5) * 31 + var6) * 31) * 31 + this.userId.hashCode();
   }

   public boolean isExpired() {
      return new Date().after(this.expires);
   }

   JSONObject toJSONObject() throws JSONException {
      JSONObject var1 = new JSONObject();
      var1.put("version", 1);
      var1.put("token", this.token);
      var1.put("expires_at", this.expires.getTime());
      var1.put("permissions", new JSONArray(this.permissions));
      var1.put("declined_permissions", new JSONArray(this.declinedPermissions));
      var1.put("last_refresh", this.lastRefresh.getTime());
      var1.put("source", this.source.name());
      var1.put("application_id", this.applicationId);
      var1.put("user_id", this.userId);
      return var1;
   }

   @Override
   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("{AccessToken");
      var1.append(" token:").append(this.tokenToString());
      this.appendPermissions(var1);
      var1.append("}");
      return var1.toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      var1.writeLong(this.expires.getTime());
      var1.writeStringList(new ArrayList<>(this.permissions));
      var1.writeStringList(new ArrayList<>(this.declinedPermissions));
      var1.writeString(this.token);
      var1.writeString(this.source.name());
      var1.writeLong(this.lastRefresh.getTime());
      var1.writeString(this.applicationId);
      var1.writeString(this.userId);
   }

   public interface AccessTokenCreationCallback {
      void onError(FacebookException var1);

      void onSuccess(AccessToken var1);
   }

   public interface AccessTokenRefreshCallback {
      void OnTokenRefreshFailed(FacebookException var1);

      void OnTokenRefreshed(AccessToken var1);
   }
}
