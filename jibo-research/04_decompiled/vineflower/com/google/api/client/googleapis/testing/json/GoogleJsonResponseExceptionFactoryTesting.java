package com.google.api.client.googleapis.testing.json;

import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.testing.http.HttpTesting;
import com.google.api.client.testing.http.MockHttpTransport;
import com.google.api.client.testing.http.MockLowLevelHttpResponse;
import com.google.api.client.util.Beta;
import java.io.IOException;

@Beta
public final class GoogleJsonResponseExceptionFactoryTesting {
   public static GoogleJsonResponseException newMock(JsonFactory var0, int var1, String var2) throws IOException {
      MockLowLevelHttpResponse var3 = new MockLowLevelHttpResponse().setStatusCode(var1).setReasonPhrase(var2);
      HttpRequest var4 = new MockHttpTransport.Builder()
         .setLowLevelHttpResponse(var3)
         .build()
         .createRequestFactory()
         .buildGetRequest(HttpTesting.SIMPLE_GENERIC_URL);
      var4.setThrowExceptionOnExecuteError(false);
      return GoogleJsonResponseException.from(var0, var4.execute());
   }
}
