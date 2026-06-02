package io.fabric.sdk.android.services.common;

import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequest;
import io.fabric.sdk.android.services.network.HttpRequestFactory;
import java.util.Collections;
import java.util.Map;
import java.util.regex.Pattern;

public abstract class AbstractSpiCall {
   private static final Pattern b = Pattern.compile("http(s?)://[^\\/]+", 2);
   protected final Kit a;
   private final String c;
   private final HttpRequestFactory d;
   private final HttpMethod e;
   private final String f;

   public AbstractSpiCall(Kit var1, String var2, String var3, HttpRequestFactory var4, HttpMethod var5) {
      if (var3 == null) {
         throw new IllegalArgumentException("url must not be null.");
      }

      if (var4 == null) {
         throw new IllegalArgumentException("requestFactory must not be null.");
      }

      this.a = var1;
      this.f = var2;
      this.c = this.a(var3);
      this.d = var4;
      this.e = var5;
   }

   private String a(String var1) {
      String var2 = var1;
      if (!CommonUtils.c(this.f)) {
         var2 = b.matcher(var1).replaceFirst(this.f);
      }

      return var2;
   }

   protected HttpRequest a(Map<String, String> var1) {
      return this.d
         .a(this.e, this.a(), var1)
         .a(false)
         .a(10000)
         .a("User-Agent", "Crashlytics Android SDK/" + this.a.a())
         .a("X-CRASHLYTICS-DEVELOPER-TOKEN", "470fa2b4ae81cd56ecbcda9735803434cec591fa");
   }

   protected String a() {
      return this.c;
   }

   protected HttpRequest b() {
      return this.a(Collections.emptyMap());
   }
}
