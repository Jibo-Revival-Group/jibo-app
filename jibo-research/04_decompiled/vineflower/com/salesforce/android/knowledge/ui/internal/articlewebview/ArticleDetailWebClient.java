package com.salesforce.android.knowledge.ui.internal.articlewebview;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.net.Uri;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.salesforce.android.knowledge.core.offline.OfflineResourceCache;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import java.io.IOException;
import java.io.InputStream;

public class ArticleDetailWebClient extends WebViewClient {
   private static final ServiceLogger b = ServiceLogging.a(ArticleDetailWebClient.class);
   ArticleDetailWebClient.Listener a;
   private final OfflineResourceCache c;
   private final ArticleDetailWebClient.IntentFactory d;

   ArticleDetailWebClient(OfflineResourceCache var1, ArticleDetailWebClient.IntentFactory var2) {
      this.c = var1;
      this.d = var2;
   }

   public static ArticleDetailWebClient a(OfflineResourceCache var0) {
      return new ArticleDetailWebClient(var0, new ArticleDetailWebClient.IntentFactory());
   }

   private void a(int var1, String var2, Uri var3) {
      if (this.a != null) {
         this.a.a(var3, var1, var2);
      }
   }

   WebResourceResponse a(Context var1) {
      AssetManager var2 = var1.getAssets();

      try {
         var4 = new WebResourceResponse("text/css", "utf-8", var2.open("knowledge_article_details.css"));
      } catch (IOException var3) {
         b.e("Unable to load CSS asset file {}: {}", "knowledge_article_details.css", var3.getMessage());
         var4 = null;
      }

      return var4;
   }

   public void a(ArticleDetailWebClient.Listener var1) {
      this.a = var1;
   }

   boolean a(Uri var1) {
      String var3 = var1.getLastPathSegment();
      boolean var2;
      if (var3 != null && var3.equals("CSS_FILE_PLACEHOLDER")) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   public void onPageFinished(WebView var1, String var2) {
      if (this.a != null) {
         this.a.a();
      }
   }

   public void onReceivedError(WebView var1, int var2, String var3, String var4) {
      super.onReceivedError(var1, var2, var3, var4);
      this.a(var2, var3, Uri.parse(var4));
   }

   @TargetApi(23)
   public void onReceivedError(WebView var1, WebResourceRequest var2, WebResourceError var3) {
      super.onReceivedError(var1, var2, var3);
      Uri var4 = var2.getUrl();
      this.a(var3.getErrorCode(), var3.getDescription().toString(), var4);
   }

   @TargetApi(21)
   public WebResourceResponse shouldInterceptRequest(WebView var1, WebResourceRequest var2) {
      WebResourceResponse var4;
      if (this.a(var2.getUrl())) {
         var4 = this.a(var1.getContext());
      } else {
         String var3 = var2.getUrl().toString();
         InputStream var5 = this.c.a(var3);
         if (var5 != null) {
            var4 = new WebResourceResponse(null, null, var5);
         } else {
            var4 = super.shouldInterceptRequest(var1, var2);
         }
      }

      return var4;
   }

   @TargetApi(19)
   public WebResourceResponse shouldInterceptRequest(WebView var1, String var2) {
      WebResourceResponse var4;
      if (this.a(Uri.parse(var2))) {
         var4 = this.a(var1.getContext());
      } else {
         InputStream var3 = this.c.a(var2);
         if (var3 != null) {
            var4 = new WebResourceResponse(null, null, var3);
         } else {
            var4 = super.shouldInterceptRequest(var1, var2);
         }
      }

      return var4;
   }

   public boolean shouldOverrideUrlLoading(WebView var1, WebResourceRequest var2) {
      Intent var3 = this.d.a("android.intent.action.VIEW", var2.getUrl());
      var1.getContext().startActivity(var3);
      return true;
   }

   public boolean shouldOverrideUrlLoading(WebView var1, String var2) {
      Intent var3 = this.d.a("android.intent.action.VIEW", Uri.parse(var2));
      var1.getContext().startActivity(var3);
      return true;
   }

   static class IntentFactory {
      Intent a(String var1, Uri var2) {
         return new Intent(var1, var2);
      }
   }

   public interface Listener {
      void a();

      void a(Uri var1, int var2, String var3);
   }
}
