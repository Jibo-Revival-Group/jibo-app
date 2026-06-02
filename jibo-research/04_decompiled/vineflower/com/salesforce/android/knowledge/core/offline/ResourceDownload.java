package com.salesforce.android.knowledge.core.offline;

import com.salesforce.android.service.common.http.HttpClient;
import com.salesforce.android.service.common.http.HttpFactory;
import com.salesforce.android.service.common.http.HttpRequest;
import com.salesforce.android.service.common.http.HttpResponse;
import com.salesforce.android.service.common.http.HttpResponseBody;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import java.io.IOException;
import okhttp3.HttpUrl;

class ResourceDownload {
   private static final ServiceLogger a = ServiceLogging.a(ResourceDownload.class);
   private final String b;
   private final HttpClient c;

   ResourceDownload(String var1, HttpClient var2) {
      this.b = var1;
      this.c = var2;
   }

   boolean a(OfflineResourceCache var1) throws IOException {
      HttpUrl var3 = HttpUrl.e(this.b);
      if (var3 == null) {
         throw new IOException("Invalid url");
      }

      a.a("Starting download of resource at {}", this.b);
      HttpRequest var5 = HttpFactory.b().a(var3).c();
      HttpResponse var4 = this.c.a(var5).a();
      HttpResponseBody var6 = var4.c();
      boolean var2 = var4.b();
      if (var2) {
         var2 = var1.a(this.b, var6.a());
      } else {
         a.d("Error downloading {}. Code {}", this.b, var4.a());
      }

      var6.close();
      return var2;
   }

   static class Factory {
      private final HttpClient a;

      Factory(HttpClient var1) {
         this.a = var1;
      }

      ResourceDownload a(String var1) {
         return new ResourceDownload(var1, this.a);
      }
   }
}
