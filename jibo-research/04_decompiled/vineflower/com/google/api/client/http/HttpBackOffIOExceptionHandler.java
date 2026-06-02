package com.google.api.client.http;

import com.google.api.client.util.BackOff;
import com.google.api.client.util.BackOffUtils;
import com.google.api.client.util.Beta;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.Sleeper;
import java.io.IOException;

@Beta
public class HttpBackOffIOExceptionHandler implements HttpIOExceptionHandler {
   private final BackOff backOff;
   private Sleeper sleeper = Sleeper.DEFAULT;

   public HttpBackOffIOExceptionHandler(BackOff var1) {
      this.backOff = Preconditions.checkNotNull(var1);
   }

   public final BackOff getBackOff() {
      return this.backOff;
   }

   public final Sleeper getSleeper() {
      return this.sleeper;
   }

   @Override
   public boolean handleIOException(HttpRequest var1, boolean var2) throws IOException {
      boolean var3 = false;
      if (!var2) {
         var2 = var3;
      } else {
         try {
            var2 = BackOffUtils.next(this.sleeper, this.backOff);
         } catch (InterruptedException var4) {
            var2 = var3;
         }
      }

      return var2;
   }

   public HttpBackOffIOExceptionHandler setSleeper(Sleeper var1) {
      this.sleeper = Preconditions.checkNotNull(var1);
      return this;
   }
}
