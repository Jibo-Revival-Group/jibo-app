package com.google.api.client.http;

import com.google.api.client.util.BackOff;
import com.google.api.client.util.BackOffUtils;
import com.google.api.client.util.Beta;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.Sleeper;
import java.io.IOException;

@Beta
public class HttpBackOffUnsuccessfulResponseHandler implements HttpUnsuccessfulResponseHandler {
   private final BackOff backOff;
   private HttpBackOffUnsuccessfulResponseHandler.BackOffRequired backOffRequired = HttpBackOffUnsuccessfulResponseHandler.BackOffRequired.ON_SERVER_ERROR;
   private Sleeper sleeper = Sleeper.DEFAULT;

   public HttpBackOffUnsuccessfulResponseHandler(BackOff var1) {
      this.backOff = Preconditions.checkNotNull(var1);
   }

   public final BackOff getBackOff() {
      return this.backOff;
   }

   public final HttpBackOffUnsuccessfulResponseHandler.BackOffRequired getBackOffRequired() {
      return this.backOffRequired;
   }

   public final Sleeper getSleeper() {
      return this.sleeper;
   }

   @Override
   public final boolean handleResponse(HttpRequest var1, HttpResponse var2, boolean var3) throws IOException {
      boolean var4 = false;
      if (!var3) {
         var3 = var4;
      } else {
         var3 = var4;
         if (this.backOffRequired.isRequired(var2)) {
            try {
               var3 = BackOffUtils.next(this.sleeper, this.backOff);
            } catch (InterruptedException var5) {
               var3 = var4;
            }
         }
      }

      return var3;
   }

   public HttpBackOffUnsuccessfulResponseHandler setBackOffRequired(HttpBackOffUnsuccessfulResponseHandler.BackOffRequired var1) {
      this.backOffRequired = Preconditions.checkNotNull(var1);
      return this;
   }

   public HttpBackOffUnsuccessfulResponseHandler setSleeper(Sleeper var1) {
      this.sleeper = Preconditions.checkNotNull(var1);
      return this;
   }

   @Beta
   public interface BackOffRequired {
      HttpBackOffUnsuccessfulResponseHandler.BackOffRequired ALWAYS = new HttpBackOffUnsuccessfulResponseHandler.BackOffRequired() {
         @Override
         public boolean isRequired(HttpResponse var1) {
            return true;
         }
      };
      HttpBackOffUnsuccessfulResponseHandler.BackOffRequired ON_SERVER_ERROR = new HttpBackOffUnsuccessfulResponseHandler.BackOffRequired() {
         @Override
         public boolean isRequired(HttpResponse var1) {
            boolean var2;
            if (var1.getStatusCode() / 100 == 5) {
               var2 = true;
            } else {
               var2 = false;
            }

            return var2;
         }
      };

      boolean isRequired(HttpResponse var1);
   }
}
