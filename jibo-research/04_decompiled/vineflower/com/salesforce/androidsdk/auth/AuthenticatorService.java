package com.salesforce.androidsdk.auth;

import android.accounts.AbstractAccountAuthenticator;
import android.accounts.Account;
import android.accounts.AccountAuthenticatorResponse;
import android.accounts.AccountManager;
import android.accounts.NetworkErrorException;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import com.salesforce.androidsdk.app.SalesforceSDKManager;
import com.salesforce.androidsdk.util.SalesforceSDKLogger;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AuthenticatorService extends Service {
   private static AuthenticatorService.Authenticator a;

   private AuthenticatorService.Authenticator a() {
      if (a == null) {
         a = new AuthenticatorService.Authenticator(this);
      }

      return a;
   }

   public IBinder onBind(Intent var1) {
      IBinder var2;
      if ("android.accounts.AccountAuthenticator".equals(var1.getAction())) {
         var2 = this.a().getIBinder();
      } else {
         var2 = null;
      }

      return var2;
   }

   private static class Authenticator extends AbstractAccountAuthenticator {
      private final Context a;

      Authenticator(Context var1) {
         super(var1);
         this.a = var1;
      }

      private Bundle a(AccountAuthenticatorResponse var1, Bundle var2) {
         Bundle var4 = new Bundle();
         Intent var3 = new Intent(this.a, SalesforceSDKManager.a().f());
         var3.setPackage(this.a.getPackageName());
         var3.setFlags(536870912);
         var3.putExtra("accountAuthenticatorResponse", var1);
         if (var2 != null) {
            var3.putExtras(var2);
         }

         var4.putParcelable("intent", var3);
         return var4;
      }

      private boolean a(Bundle var1) {
         boolean var2;
         if (var1.containsKey("androidPackageName") && "com.android.settings".equals(var1.getString("androidPackageName"))) {
            var2 = true;
         } else {
            var2 = false;
         }

         return var2;
      }

      public Bundle addAccount(AccountAuthenticatorResponse var1, String var2, String var3, String[] var4, Bundle var5) throws NetworkErrorException {
         if (this.a(var5)) {
            var5.putAll(SalesforceSDKManager.a().h().i());
         }

         return this.a(var1, var5);
      }

      public Bundle confirmCredentials(AccountAuthenticatorResponse var1, Account var2, Bundle var3) throws NetworkErrorException {
         return null;
      }

      public Bundle editProperties(AccountAuthenticatorResponse var1, String var2) {
         return null;
      }

      // $VF: Duplicated exception handlers to handle obfuscated exceptions
      public Bundle getAuthToken(AccountAuthenticatorResponse var1, Account var2, String var3, Bundle var4) throws NetworkErrorException {
         AccountManager var15 = AccountManager.get(this.a);
         String var14 = SalesforceSDKManager.a().t();
         String var23 = SalesforceSDKManager.e(var15.getPassword(var2), var14);
         String var19 = SalesforceSDKManager.e(var15.getUserData(var2, "loginUrl"), var14);
         String var16 = SalesforceSDKManager.e(var15.getUserData(var2, "clientId"), var14);
         String var12 = SalesforceSDKManager.e(var15.getUserData(var2, "instanceUrl"), var14);
         String var20 = SalesforceSDKManager.e(var15.getUserData(var2, "userId"), var14);
         String var18 = SalesforceSDKManager.e(var15.getUserData(var2, "orgId"), var14);
         String var22 = SalesforceSDKManager.e(var15.getUserData(var2, "username"), var14);
         String var21 = SalesforceSDKManager.e(var15.getUserData(var2, "last_name"), var14);
         String var17 = SalesforceSDKManager.e(var15.getUserData(var2, "email"), var14);
         var3 = var15.getUserData(var2, "first_name");
         String var5;
         if (var3 != null) {
            var5 = SalesforceSDKManager.e(var3, var14);
         } else {
            var5 = null;
         }

         var3 = var15.getUserData(var2, "display_name");
         String var6;
         if (var3 != null) {
            var6 = SalesforceSDKManager.e(var3, var14);
         } else {
            var6 = null;
         }

         var3 = var15.getUserData(var2, "photoUrl");
         String var7;
         if (var3 != null) {
            var7 = SalesforceSDKManager.e(var3, var14);
         } else {
            var7 = null;
         }

         var3 = var15.getUserData(var2, "thumbnailUrl");
         String var10;
         if (var3 != null) {
            var10 = SalesforceSDKManager.e(var3, var14);
         } else {
            var10 = null;
         }

         String var8 = var15.getUserData(var2, "clientSecret");
         var3 = null;
         if (var8 != null) {
            var3 = SalesforceSDKManager.e(var8, var14);
         }

         List var24 = SalesforceSDKManager.a().v();
         HashMap var11;
         if (var24 != null && !var24.isEmpty()) {
            var11 = new HashMap();

            for (String var85 : var24) {
               String var13 = var15.getUserData(var2, var85);
               if (var13 != null) {
                  var11.put(var85, SalesforceSDKManager.e(var13, SalesforceSDKManager.a().t()));
               }
            }
         } else {
            var11 = null;
         }

         Map var25 = SalesforceSDKManager.a().h().h();
         var8 = var15.getUserData(var2, "communityId");
         if (var8 != null) {
            var8 = SalesforceSDKManager.e(var8, SalesforceSDKManager.a().t());
         } else {
            var8 = null;
         }

         String var88 = var15.getUserData(var2, "communityUrl");
         if (var88 != null) {
            var88 = SalesforceSDKManager.e(var88, SalesforceSDKManager.a().t());
         } else {
            var88 = null;
         }

         Bundle var94 = new Bundle();

         label318: {
            label306: {
               try {
                  HttpAccess var27 = HttpAccess.a;
                  URI var26 = new URI(var19);
                  var95 = OAuth2.a(var27, var26, var16, var23, var3, var25);
                  if (!var12.equalsIgnoreCase(var95.c)) {
                     var15.setUserData(var2, "instanceUrl", SalesforceSDKManager.d(var95.c, var14));
                  }
               } catch (OAuth2.OAuthFailedException var68) {
                  var71 = var68;
                  if (var68.a()) {
                     break label318;
                  }
                  break label306;
               } catch (Exception var69) {
                  SalesforceSDKLogger.b("AuthenticatorService", "Exception thrown while getting new auth token", var69);
                  throw new NetworkErrorException(var69);
               }

               try {
                  var15.setUserData(var2, "authtoken", SalesforceSDKManager.d(var95.a, var14));
                  var94.putString("authAccount", var2.name);
                  var94.putString("accountType", var2.type);
                  var94.putString("authtoken", SalesforceSDKManager.d(var95.a, var14));
                  var94.putString("loginUrl", SalesforceSDKManager.d(var19, var14));
                  var94.putString("instanceUrl", SalesforceSDKManager.d(var95.c, var14));
                  var94.putString("clientId", SalesforceSDKManager.d(var16, var14));
                  var94.putString("username", SalesforceSDKManager.d(var22, var14));
                  var94.putString("userId", SalesforceSDKManager.d(var20, var14));
                  var94.putString("orgId", SalesforceSDKManager.d(var18, var14));
                  var94.putString("last_name", SalesforceSDKManager.d(var21, var14));
                  var94.putString("email", SalesforceSDKManager.d(var17, var14));
               } catch (OAuth2.OAuthFailedException var66) {
                  var71 = var66;
                  if (var66.a()) {
                     break label318;
                  }
                  break label306;
               } catch (Exception var67) {
                  SalesforceSDKLogger.b("AuthenticatorService", "Exception thrown while getting new auth token", var67);
                  throw new NetworkErrorException(var67);
               }

               var12 = null;
               if (var5 != null) {
                  try {
                     var12 = SalesforceSDKManager.d(var5, var14);
                  } catch (OAuth2.OAuthFailedException var64) {
                     var71 = var64;
                     if (var64.a()) {
                        break label318;
                     }
                     break label306;
                  } catch (Exception var65) {
                     SalesforceSDKLogger.b("AuthenticatorService", "Exception thrown while getting new auth token", var65);
                     throw new NetworkErrorException(var65);
                  }
               }

               try {
                  var94.putString("first_name", var12);
               } catch (OAuth2.OAuthFailedException var62) {
                  var71 = var62;
                  if (var62.a()) {
                     break label318;
                  }
                  break label306;
               } catch (Exception var63) {
                  SalesforceSDKLogger.b("AuthenticatorService", "Exception thrown while getting new auth token", var63);
                  throw new NetworkErrorException(var63);
               }

               var5 = null;
               if (var6 != null) {
                  try {
                     var5 = SalesforceSDKManager.d(var6, var14);
                  } catch (OAuth2.OAuthFailedException var60) {
                     var71 = var60;
                     if (var60.a()) {
                        break label318;
                     }
                     break label306;
                  } catch (Exception var61) {
                     SalesforceSDKLogger.b("AuthenticatorService", "Exception thrown while getting new auth token", var61);
                     throw new NetworkErrorException(var61);
                  }
               }

               try {
                  var94.putString("display_name", var5);
               } catch (OAuth2.OAuthFailedException var58) {
                  var71 = var58;
                  if (var58.a()) {
                     break label318;
                  }
                  break label306;
               } catch (Exception var59) {
                  SalesforceSDKLogger.b("AuthenticatorService", "Exception thrown while getting new auth token", var59);
                  throw new NetworkErrorException(var59);
               }

               var5 = null;
               if (var7 != null) {
                  try {
                     var5 = SalesforceSDKManager.d(var7, var14);
                  } catch (OAuth2.OAuthFailedException var56) {
                     var71 = var56;
                     if (var56.a()) {
                        break label318;
                     }
                     break label306;
                  } catch (Exception var57) {
                     SalesforceSDKLogger.b("AuthenticatorService", "Exception thrown while getting new auth token", var57);
                     throw new NetworkErrorException(var57);
                  }
               }

               try {
                  var94.putString("photoUrl", var5);
               } catch (OAuth2.OAuthFailedException var54) {
                  var71 = var54;
                  if (var54.a()) {
                     break label318;
                  }
                  break label306;
               } catch (Exception var55) {
                  SalesforceSDKLogger.b("AuthenticatorService", "Exception thrown while getting new auth token", var55);
                  throw new NetworkErrorException(var55);
               }

               if (var10 != null) {
                  try {
                     var5 = SalesforceSDKManager.d(var10, var14);
                  } catch (OAuth2.OAuthFailedException var52) {
                     var71 = var52;
                     if (var52.a()) {
                        break label318;
                     }
                     break label306;
                  } catch (Exception var53) {
                     SalesforceSDKLogger.b("AuthenticatorService", "Exception thrown while getting new auth token", var53);
                     throw new NetworkErrorException(var53);
                  }
               } else {
                  var5 = null;
               }

               label256:
               if (var24 != null) {
                  try {
                     if (var24.isEmpty()) {
                        break label256;
                     }

                     var83 = var24.iterator();
                  } catch (OAuth2.OAuthFailedException var48) {
                     var71 = var48;
                     if (var48.a()) {
                        break label318;
                     }
                     break label306;
                  } catch (Exception var49) {
                     SalesforceSDKLogger.b("AuthenticatorService", "Exception thrown while getting new auth token", var49);
                     throw new NetworkErrorException(var49);
                  }

                  label254:
                  while (true) {
                     while (true) {
                        try {
                           if (!var83.hasNext()) {
                              break label254;
                           }

                           var7 = (String)var83.next();
                           if (var95.k != null && var95.k.containsKey(var7)) {
                              var10 = var95.k.get(var7);
                              break;
                           }
                        } catch (OAuth2.OAuthFailedException var50) {
                           var71 = var50;
                           if (var50.a()) {
                              break label318;
                           }
                           break label306;
                        } catch (Exception var51) {
                           SalesforceSDKLogger.b("AuthenticatorService", "Exception thrown while getting new auth token", var51);
                           throw new NetworkErrorException(var51);
                        }

                        if (var11 != null) {
                           try {
                              if (!var11.containsKey(var7)) {
                                 continue;
                              }

                              var10 = (String)var11.get(var7);
                           } catch (OAuth2.OAuthFailedException var46) {
                              var71 = var46;
                              if (var46.a()) {
                                 break label318;
                              }
                              break label306;
                           } catch (Exception var47) {
                              SalesforceSDKLogger.b("AuthenticatorService", "Exception thrown while getting new auth token", var47);
                              throw new NetworkErrorException(var47);
                           }

                           if (var10 != null) {
                              try {
                                 var94.putString(var7, SalesforceSDKManager.d(var10, var14));
                              } catch (OAuth2.OAuthFailedException var42) {
                                 var71 = var42;
                                 if (var42.a()) {
                                    break label318;
                                 }
                                 break label306;
                              } catch (Exception var43) {
                                 SalesforceSDKLogger.b("AuthenticatorService", "Exception thrown while getting new auth token", var43);
                                 throw new NetworkErrorException(var43);
                              }
                           }
                        }
                     }

                     if (var10 != null) {
                        try {
                           var10 = SalesforceSDKManager.d(var10, var14);
                           var94.putString(var7, var10);
                           var15.setUserData(var2, var7, var10);
                        } catch (OAuth2.OAuthFailedException var44) {
                           var71 = var44;
                           if (var44.a()) {
                              break label318;
                           }
                           break label306;
                        } catch (Exception var45) {
                           SalesforceSDKLogger.b("AuthenticatorService", "Exception thrown while getting new auth token", var45);
                           throw new NetworkErrorException(var45);
                        }
                     }
                  }
               }

               try {
                  var94.putString("thumbnailUrl", var5);
               } catch (OAuth2.OAuthFailedException var40) {
                  var71 = var40;
                  if (var40.a()) {
                     break label318;
                  }
                  break label306;
               } catch (Exception var41) {
                  SalesforceSDKLogger.b("AuthenticatorService", "Exception thrown while getting new auth token", var41);
                  throw new NetworkErrorException(var41);
               }

               String var72 = null;
               if (var3 != null) {
                  try {
                     var72 = SalesforceSDKManager.d(var3, var14);
                  } catch (OAuth2.OAuthFailedException var38) {
                     var71 = var38;
                     if (var38.a()) {
                        break label318;
                     }
                     break label306;
                  } catch (Exception var39) {
                     SalesforceSDKLogger.b("AuthenticatorService", "Exception thrown while getting new auth token", var39);
                     throw new NetworkErrorException(var39);
                  }
               }

               try {
                  var94.putString("clientSecret", var72);
               } catch (OAuth2.OAuthFailedException var36) {
                  var71 = var36;
                  if (var36.a()) {
                     break label318;
                  }
                  break label306;
               } catch (Exception var37) {
                  SalesforceSDKLogger.b("AuthenticatorService", "Exception thrown while getting new auth token", var37);
                  throw new NetworkErrorException(var37);
               }

               String var73 = null;
               if (var8 != null) {
                  try {
                     var73 = SalesforceSDKManager.d(var8, var14);
                  } catch (OAuth2.OAuthFailedException var34) {
                     var71 = var34;
                     if (var34.a()) {
                        break label318;
                     }
                     break label306;
                  } catch (Exception var35) {
                     SalesforceSDKLogger.b("AuthenticatorService", "Exception thrown while getting new auth token", var35);
                     throw new NetworkErrorException(var35);
                  }
               }

               try {
                  var94.putString("communityId", var73);
               } catch (OAuth2.OAuthFailedException var32) {
                  var71 = var32;
                  if (var32.a()) {
                     break label318;
                  }
                  break label306;
               } catch (Exception var33) {
                  SalesforceSDKLogger.b("AuthenticatorService", "Exception thrown while getting new auth token", var33);
                  throw new NetworkErrorException(var33);
               }

               String var74 = null;
               if (var88 != null) {
                  try {
                     var74 = SalesforceSDKManager.d(var88, var14);
                  } catch (OAuth2.OAuthFailedException var30) {
                     var71 = var30;
                     if (var30.a()) {
                        break label318;
                     }
                     break label306;
                  } catch (Exception var31) {
                     SalesforceSDKLogger.b("AuthenticatorService", "Exception thrown while getting new auth token", var31);
                     throw new NetworkErrorException(var31);
                  }
               }

               try {
                  var94.putString("communityUrl", var74);
                  return var94;
               } catch (OAuth2.OAuthFailedException var28) {
                  var71 = var28;
                  if (var28.a()) {
                     break label318;
                  }
               } catch (Exception var29) {
                  SalesforceSDKLogger.b("AuthenticatorService", "Exception thrown while getting new auth token", var29);
                  throw new NetworkErrorException(var29);
               }
            }

            var94.putString("errorCode", var71.a.a);
            var94.putString("errorMessage", var71.a.b);
            return var94;
         }

         SalesforceSDKLogger.c("AuthenticatorService", "Invalid Refresh Token: (Error: " + var71.a.a + ", Status Code: " + var71.b + ")", var71);
         return this.a(var1, var4);
      }

      public String getAuthTokenLabel(String var1) {
         return null;
      }

      public Bundle hasFeatures(AccountAuthenticatorResponse var1, Account var2, String[] var3) throws NetworkErrorException {
         return null;
      }

      public Bundle updateCredentials(AccountAuthenticatorResponse var1, Account var2, String var3, Bundle var4) throws NetworkErrorException {
         return null;
      }
   }
}
