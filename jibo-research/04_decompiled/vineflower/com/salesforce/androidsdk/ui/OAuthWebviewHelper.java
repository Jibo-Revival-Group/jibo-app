package com.salesforce.androidsdk.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.http.SslError;
import android.os.AsyncTask;
import android.os.Bundle;
import android.security.KeyChain;
import android.security.KeyChainAliasCallback;
import android.security.KeyChainException;
import android.text.TextUtils;
import android.webkit.ClientCertRequest;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import com.salesforce.androidsdk.R;
import com.salesforce.androidsdk.accounts.UserAccount;
import com.salesforce.androidsdk.accounts.UserAccountManager;
import com.salesforce.androidsdk.analytics.EventBuilderHelper;
import com.salesforce.androidsdk.app.SalesforceSDKManager;
import com.salesforce.androidsdk.auth.HttpAccess;
import com.salesforce.androidsdk.auth.OAuth2;
import com.salesforce.androidsdk.config.BootConfig;
import com.salesforce.androidsdk.config.LoginServerManager;
import com.salesforce.androidsdk.config.RuntimeConfig;
import com.salesforce.androidsdk.push.PushMessaging;
import com.salesforce.androidsdk.rest.ClientManager;
import com.salesforce.androidsdk.security.PasscodeManager;
import com.salesforce.androidsdk.util.EventsObservable;
import com.salesforce.androidsdk.util.MapUtil;
import com.salesforce.androidsdk.util.SalesforceSDKLogger;
import com.salesforce.androidsdk.util.UriFragmentParser;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class OAuthWebviewHelper implements KeyChainAliasCallback {
   static final boolean b;
   protected final ClientManager.LoginOptions a;
   private final ExecutorService c = Executors.newFixedThreadPool(1);
   private final OAuthWebviewHelper.OAuthWebviewHelperEvents d;
   private final WebView e;
   private OAuthWebviewHelper.AccountOptions f;
   private Activity g;
   private PrivateKey h;
   private X509Certificate[] i;

   static {
      boolean var0;
      if (!OAuthWebviewHelper.class.desiredAssertionStatus()) {
         var0 = true;
      } else {
         var0 = false;
      }

      b = var0;
   }

   public OAuthWebviewHelper(Activity var1, OAuthWebviewHelper.OAuthWebviewHelperEvents var2, ClientManager.LoginOptions var3, WebView var4, Bundle var5) {
      if (b || var3 != null && var2 != null && var4 != null && var1 != null) {
         this.g = var1;
         this.d = var2;
         this.a = var3;
         this.e = var4;
         WebSettings var6 = var4.getSettings();
         var6.setJavaScriptEnabled(true);
         var6.setUserAgentString(SalesforceSDKManager.a().y());
         var4.setWebViewClient(this.d());
         var4.setWebChromeClient(this.e());
         if (var5 != null) {
            var4.restoreState(var5);
            this.f = OAuthWebviewHelper.AccountOptions.a(var5.getBundle("accountOptions"));
         } else {
            this.a();
         }
      } else {
         throw new AssertionError();
      }
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private void a(UserAccount var1) {
      JSONObject var4 = new JSONObject();

      List var5;
      try {
         var5 = SalesforceSDKManager.a().l().c();
      } catch (JSONException var14) {
         SalesforceSDKLogger.a("OAuthWebViewHelper", "Exception thrown while creating JSON", var14);
         return;
      }

      int var2;
      if (var5 == null) {
         var2 = 0;
      } else {
         try {
            var2 = var5.size();
         } catch (JSONException var13) {
            SalesforceSDKLogger.a("OAuthWebViewHelper", "Exception thrown while creating JSON", var13);
            return;
         }
      }

      try {
         var4.put("numLoginServers", var2);
      } catch (JSONException var12) {
         SalesforceSDKLogger.a("OAuthWebViewHelper", "Exception thrown while creating JSON", var12);
         return;
      }

      if (var5 != null) {
         JSONArray var3;
         Iterator var6;
         try {
            var3 = new JSONArray();
            var6 = var5.iterator();
         } catch (JSONException var10) {
            SalesforceSDKLogger.a("OAuthWebViewHelper", "Exception thrown while creating JSON", var10);
            return;
         }

         while (true) {
            try {
               if (!var6.hasNext()) {
                  break;
               }

               var15 = (LoginServerManager.LoginServer)var6.next();
            } catch (JSONException var11) {
               SalesforceSDKLogger.a("OAuthWebViewHelper", "Exception thrown while creating JSON", var11);
               return;
            }

            if (var15 != null) {
               try {
                  var3.put(var15.b);
               } catch (JSONException var9) {
                  SalesforceSDKLogger.a("OAuthWebViewHelper", "Exception thrown while creating JSON", var9);
                  return;
               }
            }
         }

         try {
            var4.put("loginServers", var3);
         } catch (JSONException var8) {
            SalesforceSDKLogger.a("OAuthWebViewHelper", "Exception thrown while creating JSON", var8);
            return;
         }
      }

      try {
         EventBuilderHelper.b("addUser", var1, "OAuthWebViewHelper", var4);
      } catch (JSONException var7) {
         SalesforceSDKLogger.a("OAuthWebViewHelper", "Exception thrown while creating JSON", var7);
      }
   }

   private void a(boolean var1) {
      try {
         URI var2 = this.a(Boolean.valueOf(var1));
         this.d.a(this.a.a());
         this.e.loadUrl(var2.toString());
      } catch (URISyntaxException var3) {
         this.a(var3);
      }
   }

   protected String a(String var1, String var2) {
      return String.format("%s (%s) (%s)", var1, var2, SalesforceSDKManager.a().u());
   }

   protected URI a(Boolean var1) throws URISyntaxException {
      URI var2;
      if (var1) {
         var2 = OAuth2.a(new URI(this.a.a()), this.h(), this.a.c(), this.a.e(), null, this.i(), this.a.g(), this.a.a(), this.a.h());
      } else {
         var2 = OAuth2.a(new URI(this.a.a()), this.h(), this.a.c(), this.a.e(), null, this.i(), this.a.h());
      }

      return var2;
   }

   public void a() {
      SalesforceSDKManager.a().F();
   }

   public void a(Bundle var1) {
      this.e.saveState(var1);
      if (this.f != null) {
         var1.putBundle("accountOptions", this.f.a());
      }
   }

   protected void a(OAuth2.TokenEndpointResponse var1) {
      new OAuthWebviewHelper.FinishAuthTask(this).execute(new OAuth2.TokenEndpointResponse[]{var1});
   }

   protected void a(Exception var1) {
      Toast.makeText(this.f(), this.f().getString(SalesforceSDKManager.a().e().d(), new Object[]{var1.toString()}), 1).show();
   }

   protected void a(String var1, String var2, Exception var3) {
      SalesforceSDKLogger.b("OAuthWebViewHelper", var1 + ": " + var2, var3);
      if ("access_denied".equals(var1) && "end-user denied authorization".equals(var2)) {
         this.e.post(new Runnable(this) {
            final OAuthWebviewHelper a;

            {
               this.a = var1;
            }

            @Override
            public void run() {
               this.a.a();
               this.a.g();
            }
         });
      } else {
         Toast var4 = Toast.makeText(this.e.getContext(), var1 + " : " + var2, 1);
         this.e.postDelayed(new Runnable(this) {
            final OAuthWebviewHelper a;

            {
               this.a = var1;
            }

            @Override
            public void run() {
               this.a.d.finish();
            }
         }, var4.getDuration());
         var4.show();
      }

      Intent var5 = new Intent("com.salesforce.auth.intent.AUTHENTICATION_ERROR");
      if (var3 != null && var3 instanceof OAuth2.OAuthFailedException) {
         OAuth2.OAuthFailedException var6 = (OAuth2.OAuthFailedException)var3;
         var5.putExtra("com.salesforce.auth.intent.HTTP_RESPONSE_CODE", var6.c());
         OAuth2.TokenErrorResponse var8 = var6.b();
         if (var8 != null) {
            var2 = var8.a;
            String var9 = var8.b;
            var5.putExtra("com.salesforce.auth.intent.RESPONSE_ERROR", var2);
            var5.putExtra("com.salesforce.auth.intent.RESPONSE_ERROR_DESCRIPTION", var9);
         }
      }

      SalesforceSDKManager.a().k().sendBroadcast(var5);
   }

   public void alias(String var1) {
      try {
         this.i = KeyChain.getCertificateChain(this.g, var1);
         this.h = KeyChain.getPrivateKey(this.g, var1);
         Activity var2 = this.g;
         Runnable var5 = new Runnable(this) {
            final OAuthWebviewHelper a;

            {
               this.a = var1;
            }

            @Override
            public void run() {
               this.a.g();
            }
         };
         var2.runOnUiThread(var5);
      } catch (KeyChainException var3) {
         SalesforceSDKLogger.a("OAuthWebViewHelper", "Exception thrown while retrieving X.509 certificate", var3);
      } catch (InterruptedException var4) {
         SalesforceSDKLogger.a("OAuthWebViewHelper", "Exception thrown while retrieving X.509 certificate", var4);
      }
   }

   public void b() {
      this.e.loadUrl("about:blank");
   }

   public void c() {
      if (this.f != null) {
         this.a.d(SalesforceSDKManager.a().t());
         this.k();
         this.d.finish();
      }
   }

   protected WebViewClient d() {
      return new OAuthWebviewHelper.AuthWebViewClient(this);
   }

   protected WebChromeClient e() {
      return new OAuthWebviewHelper.AuthWebChromeClient(this);
   }

   protected Context f() {
      return this.e.getContext();
   }

   public void g() {
      if (TextUtils.isEmpty(this.a.g())) {
         this.a.c(this.j());
         this.a(false);
      } else {
         new OAuthWebviewHelper.SwapJWTForAccessTokenTask(this).execute(new ClientManager.LoginOptions[]{this.a});
      }
   }

   protected String h() {
      return this.a.d();
   }

   protected String i() {
      return this.f().getString(R.string.oauth_display_type);
   }

   protected String j() {
      return SalesforceSDKManager.a().l().a().b.trim();
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   protected void k() {
      ClientManager var2 = new ClientManager(this.f(), SalesforceSDKManager.a().B(), this.a, SalesforceSDKManager.a().j());
      String var3 = this.a(this.f.a, this.f.e);
      Bundle var9 = var2.a(
         var3,
         this.f.a,
         this.f.b,
         this.f.c,
         this.f.e,
         this.a.a(),
         this.f.d,
         this.h(),
         this.f.f,
         this.f.g,
         this.a.b(),
         this.a.f(),
         this.f.h,
         this.f.i,
         this.f.j,
         this.f.k,
         this.f.l,
         this.f.m,
         this.f.n,
         this.f.o,
         this.f.p
      );
      Context var4 = SalesforceSDKManager.a().k();
      String var5 = BootConfig.a(var4).d();
      UserAccount var10 = new UserAccount(
         this.f.c,
         this.f.b,
         this.a.a(),
         this.f.d,
         this.f.e,
         this.f.f,
         this.f.g,
         this.f.a,
         var3,
         this.a.f(),
         this.f.h,
         this.f.i,
         this.f.j,
         this.f.k,
         this.f.l,
         this.f.m,
         this.f.n,
         this.f.o,
         this.f.p
      );
      if (!TextUtils.isEmpty(var5)) {
         PushMessaging.a(var4, var10);
      }

      JSONObject var12 = new JSONObject();

      label40: {
         try {
            var11 = UserAccountManager.a().d();
         } catch (JSONException var8) {
            SalesforceSDKLogger.a("OAuthWebViewHelper", "Exception thrown while creating JSON", var8);
            break label40;
         }

         int var1;
         if (var11 == null) {
            var1 = 0;
         } else {
            try {
               var1 = var11.size();
            } catch (JSONException var7) {
               SalesforceSDKLogger.a("OAuthWebViewHelper", "Exception thrown while creating JSON", var7);
               break label40;
            }
         }

         try {
            var12.put("numUsers", var1);
         } catch (JSONException var6) {
            SalesforceSDKLogger.a("OAuthWebViewHelper", "Exception thrown while creating JSON", var6);
         }
      }

      this.d.a(var9);
      if (SalesforceSDKManager.a().C()) {
         this.a(var10);
      } else {
         this.c.execute(new Runnable(this, var10) {
            final UserAccount a;
            final OAuthWebviewHelper b;

            {
               this.b = var1;
               this.a = var2x;
            }

            @Override
            public void run() {
               this.b.a(this.a);
            }
         });
      }
   }

   public static class AccountOptions {
      public final String a;
      public final String b;
      public final String c;
      public final String d;
      public final String e;
      public final String f;
      public final String g;
      public final String h;
      public final String i;
      public final String j;
      public final String k;
      public final String l;
      public final String m;
      public final String n;
      public final String o;
      public final Map<String, String> p;
      private Bundle q;

      public AccountOptions(
         String var1,
         String var2,
         String var3,
         String var4,
         String var5,
         String var6,
         String var7,
         String var8,
         String var9,
         String var10,
         String var11,
         String var12,
         String var13,
         String var14,
         String var15,
         Map<String, String> var16
      ) {
         this.a = var1;
         this.b = var2;
         this.c = var3;
         this.d = var4;
         this.e = var5;
         this.f = var6;
         this.g = var7;
         this.h = var8;
         this.i = var9;
         this.j = var10;
         this.k = var11;
         this.l = var12;
         this.m = var13;
         this.n = var14;
         this.o = var15;
         this.p = var16;
         this.q = new Bundle();
         this.q.putString("username", var1);
         this.q.putString("refreshToken", var2);
         this.q.putString("authToken", var3);
         this.q.putString("identityUrl", var4);
         this.q.putString("instanceUrl", var5);
         this.q.putString("orgId", var6);
         this.q.putString("userId", var7);
         this.q.putString("communityId", var8);
         this.q.putString("communityUrl", var9);
         this.q.putString("firstName", var10);
         this.q.putString("lastName", var11);
         this.q.putString("displayName", var12);
         this.q.putString("email", var13);
         this.q.putString("photoUrl", var14);
         this.q.putString("thumbnailUrl", var15);
         this.q = MapUtil.a(var16, SalesforceSDKManager.a().v(), this.q);
      }

      public static OAuthWebviewHelper.AccountOptions a(Bundle var0) {
         OAuthWebviewHelper.AccountOptions var1;
         if (var0 == null) {
            var1 = null;
         } else {
            var1 = new OAuthWebviewHelper.AccountOptions(
               var0.getString("username"),
               var0.getString("refreshToken"),
               var0.getString("authToken"),
               var0.getString("identityUrl"),
               var0.getString("instanceUrl"),
               var0.getString("orgId"),
               var0.getString("userId"),
               var0.getString("communityId"),
               var0.getString("communityUrl"),
               var0.getString("firstName"),
               var0.getString("lastName"),
               var0.getString("displayName"),
               var0.getString("email"),
               var0.getString("photoUrl"),
               var0.getString("thumbnailUrl"),
               b(var0)
            );
         }

         return var1;
      }

      private static Map<String, String> b(Bundle var0) {
         return MapUtil.a(var0, SalesforceSDKManager.a().v(), null);
      }

      public Bundle a() {
         return this.q;
      }
   }

   protected class AuthWebChromeClient extends WebChromeClient {
      final OAuthWebviewHelper a;

      protected AuthWebChromeClient(OAuthWebviewHelper var1) {
         this.a = var1;
      }

      public void onProgressChanged(WebView var1, int var2) {
         this.a.d.b(var2 * 100);
      }
   }

   protected class AuthWebViewClient extends WebViewClient {
      final OAuthWebviewHelper a;

      protected AuthWebViewClient(OAuthWebviewHelper var1) {
         this.a = var1;
      }

      public void onPageFinished(WebView var1, String var2) {
         EventsObservable.a().a(EventsObservable.EventType.AuthWebViewPageFinished, var2);
         super.onPageFinished(var1, var2);
      }

      @TargetApi(21)
      public void onReceivedClientCertRequest(WebView var1, ClientCertRequest var2) {
         var2.proceed(this.a.h, this.a.i);
      }

      public void onReceivedSslError(WebView var1, SslErrorHandler var2, SslError var3) {
         int var5 = var3.getPrimaryError();
         SalesforceR var6 = SalesforceSDKManager.a().e();
         int var4 = var6.ah();
         switch (var5) {
            case 0:
               var4 = var6.af();
               break;
            case 1:
               var4 = var6.ad();
               break;
            case 2:
               var4 = var6.ae();
               break;
            case 3:
               var4 = var6.ag();
         }

         String var7 = this.a.f().getString(var6.ac(), new Object[]{this.a.f().getString(var4)});
         Toast.makeText(this.a.f(), var7, 1).show();
         var2.cancel();
      }

      public boolean shouldOverrideUrlLoading(WebView var1, String var2) {
         boolean var3 = var2.replace("///", "/").toLowerCase(Locale.US).startsWith(this.a.a.c().replace("///", "/").toLowerCase(Locale.US));
         if (var3) {
            Map var6 = UriFragmentParser.a(Uri.parse(var2));
            String var4 = (String)var6.get("error");
            if (var4 != null) {
               var2 = (String)var6.get("error_description");
               this.a.a(var4, var2, null);
            } else {
               OAuth2.TokenEndpointResponse var5 = new OAuth2.TokenEndpointResponse(var6);
               this.a.a(var5);
            }
         }

         return var3;
      }
   }

   protected abstract class BaseFinishAuthFlowTask<RequestType> extends AsyncTask<RequestType, Boolean, OAuth2.TokenEndpointResponse> {
      protected volatile Exception a;
      protected volatile OAuth2.IdServiceResponse b;
      final OAuthWebviewHelper c;

      public BaseFinishAuthFlowTask(OAuthWebviewHelper var1) {
         this.c = var1;
         this.b = null;
      }

      protected abstract OAuth2.TokenEndpointResponse a(RequestType var1) throws Exception;

      @SafeVarargs
      protected final OAuth2.TokenEndpointResponse a(RequestType... var1) {
         try {
            this.publishProgress(new Boolean[]{true});
            var1 = this.a((RequestType)((Object[])var1)[0]);
         } catch (Exception var2) {
            this.a(var2);
            var1 = null;
         }

         return var1;
      }

      protected void a(OAuth2.TokenEndpointResponse var1) {
         SalesforceSDKManager var3 = SalesforceSDKManager.a();
         if (this.a != null) {
            SalesforceSDKLogger.b("OAuthWebViewHelper", "Exception thrown while retrieving token response", this.a);
            this.c.a(this.c.f().getString(var3.e().e()), this.c.f().getString(var3.e().f()), this.a);
            this.c.d.finish();
         } else if (this.b.k != null && this.b.k.optBoolean("must_be_managed_app") && !RuntimeConfig.a(this.c.f()).a()) {
            this.c.a(this.c.f().getString(var3.e().e()), this.c.f().getString(var3.e().h()), this.a);
            this.c.d.finish();
         } else {
            this.c.f = new OAuthWebviewHelper.AccountOptions(
               this.b.a, var1.b, var1.a, var1.d, var1.c, var1.f, var1.g, var1.i, var1.j, this.b.c, this.b.d, this.b.e, this.b.b, this.b.f, this.b.g, var1.k
            );
            UserAccount var4 = new UserAccount(
               this.c.f.c,
               this.c.f.b,
               this.c.a.a(),
               this.c.f.d,
               this.c.f.e,
               this.c.f.f,
               this.c.f.g,
               this.c.f.a,
               this.c.a(this.c.f.a, this.c.f.e),
               this.c.a.f(),
               this.c.f.h,
               this.c.f.i,
               this.c.f.j,
               this.c.f.k,
               this.c.f.l,
               this.c.f.m,
               this.c.f.n,
               this.c.f.o,
               this.c.f.p
            );
            if (this.b.j != null) {
               var3.p().a(this.b.j, var4);
            }

            if (this.b.k != null) {
               var3.q().a(this.b.k, var4);
            }

            if (this.b.i > 0) {
               PasscodeManager var5 = var3.n();
               var5.a(var4, this.b.i * 1000 * 60, this.b.h);
               var5.a(this.b.i * 1000 * 60);
               boolean var2 = var5.a((Activity)this.c.f(), this.b.h);
               if (!var5.b(var3.k())) {
                  var5.a(true);
                  var5.a((Activity)this.c.f(), true);
               } else if (!var2) {
                  this.c.a.d(var3.t());
                  this.c.k();
                  this.c.d.finish();
               }
            } else {
               var3.n().a(var4, 0, 4);
               this.c.a.d(var3.t());
               this.c.k();
               this.c.d.finish();
            }
         }
      }

      protected void a(Exception var1) {
         if (var1.getMessage() != null) {
            SalesforceSDKLogger.b("OAuthWebViewHelper", "Exception thrown", var1);
         }

         this.a = var1;
      }

      protected void a(Boolean... var1) {
         this.c.d.a(var1[0]);
      }
   }

   private class FinishAuthTask extends OAuthWebviewHelper.BaseFinishAuthFlowTask<OAuth2.TokenEndpointResponse> {
      final OAuthWebviewHelper d;

      private FinishAuthTask(OAuthWebviewHelper var1) {
         super(var1);
         this.d = var1;
      }

      protected OAuth2.TokenEndpointResponse b(OAuth2.TokenEndpointResponse var1) throws Exception {
         try {
            this.b = OAuth2.a(HttpAccess.a, var1.e, var1.a);
         } catch (Exception var3) {
            this.a = var3;
         }

         return var1;
      }
   }

   public interface OAuthWebviewHelperEvents {
      void a(Bundle var1);

      void a(String var1);

      void a(boolean var1);

      void b(int var1);

      void finish();
   }

   private class SwapJWTForAccessTokenTask extends OAuthWebviewHelper.BaseFinishAuthFlowTask<ClientManager.LoginOptions> {
      final OAuthWebviewHelper d;

      private SwapJWTForAccessTokenTask(OAuthWebviewHelper var1) {
         super(var1);
         this.d = var1;
      }

      private void a() {
         SalesforceSDKManager var1 = SalesforceSDKManager.a();
         this.d.a(this.d.f().getString(var1.e().e()), this.d.f().getString(var1.e().g()), this.a);
      }

      protected OAuth2.TokenEndpointResponse a(ClientManager.LoginOptions var1) {
         try {
            HttpAccess var2 = HttpAccess.a;
            URI var3 = new URI(var1.a());
            var5 = OAuth2.b(var2, var3, var1.g());
         } catch (Exception var4) {
            this.a = var4;
            var5 = null;
         }

         return var5;
      }

      @Override
      protected void a(OAuth2.TokenEndpointResponse var1) {
         if (this.a != null) {
            this.a();
            this.d.a.a((String)null);
         } else {
            if (var1 != null && var1.a != null) {
               this.d.a.a(var1.a);
               this.d.a(true);
            } else {
               this.d.a(false);
               this.a();
            }

            this.d.a.a((String)null);
         }
      }
   }
}
