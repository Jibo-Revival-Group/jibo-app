package io.fabric.sdk.android.services.network;

import java.util.Map;

public interface HttpRequestFactory {
   HttpRequest a(HttpMethod var1, String var2, Map<String, String> var3);

   void a(PinningInfoProvider var1);
}
