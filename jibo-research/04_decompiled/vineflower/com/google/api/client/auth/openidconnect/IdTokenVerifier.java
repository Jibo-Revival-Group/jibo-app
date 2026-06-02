package com.google.api.client.auth.openidconnect;

import com.google.api.client.util.Beta;
import com.google.api.client.util.Clock;
import com.google.api.client.util.Preconditions;
import java.util.Collection;
import java.util.Collections;

@Beta
public class IdTokenVerifier {
   public static final long DEFAULT_TIME_SKEW_SECONDS = 300L;
   private final long acceptableTimeSkewSeconds;
   private final Collection<String> audience;
   private final Clock clock;
   private final Collection<String> issuers;

   public IdTokenVerifier() {
      this(new IdTokenVerifier.Builder());
   }

   protected IdTokenVerifier(IdTokenVerifier.Builder var1) {
      Object var3 = null;
      super();
      this.clock = var1.clock;
      this.acceptableTimeSkewSeconds = var1.acceptableTimeSkewSeconds;
      Collection var2;
      if (var1.issuers == null) {
         var2 = null;
      } else {
         var2 = Collections.unmodifiableCollection(var1.issuers);
      }

      this.issuers = var2;
      Collection var4;
      if (var1.audience == null) {
         var4 = (Collection)var3;
      } else {
         var4 = Collections.unmodifiableCollection(var1.audience);
      }

      this.audience = var4;
   }

   public final long getAcceptableTimeSkewSeconds() {
      return this.acceptableTimeSkewSeconds;
   }

   public final Collection<String> getAudience() {
      return this.audience;
   }

   public final Clock getClock() {
      return this.clock;
   }

   public final String getIssuer() {
      String var1;
      if (this.issuers == null) {
         var1 = null;
      } else {
         var1 = this.issuers.iterator().next();
      }

      return var1;
   }

   public final Collection<String> getIssuers() {
      return this.issuers;
   }

   public boolean verify(IdToken var1) {
      boolean var2;
      if ((this.issuers == null || var1.verifyIssuer(this.issuers))
         && (this.audience == null || var1.verifyAudience(this.audience))
         && var1.verifyTime(this.clock.currentTimeMillis(), this.acceptableTimeSkewSeconds)) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   @Beta
   public static class Builder {
      long acceptableTimeSkewSeconds;
      Collection<String> audience;
      Clock clock = Clock.SYSTEM;
      Collection<String> issuers;

      public Builder() {
         this.acceptableTimeSkewSeconds = 300L;
      }

      public IdTokenVerifier build() {
         return new IdTokenVerifier(this);
      }

      public final long getAcceptableTimeSkewSeconds() {
         return this.acceptableTimeSkewSeconds;
      }

      public final Collection<String> getAudience() {
         return this.audience;
      }

      public final Clock getClock() {
         return this.clock;
      }

      public final String getIssuer() {
         String var1;
         if (this.issuers == null) {
            var1 = null;
         } else {
            var1 = this.issuers.iterator().next();
         }

         return var1;
      }

      public final Collection<String> getIssuers() {
         return this.issuers;
      }

      public IdTokenVerifier.Builder setAcceptableTimeSkewSeconds(long var1) {
         boolean var3;
         if (var1 >= 0L) {
            var3 = true;
         } else {
            var3 = false;
         }

         Preconditions.checkArgument(var3);
         this.acceptableTimeSkewSeconds = var1;
         return this;
      }

      public IdTokenVerifier.Builder setAudience(Collection<String> var1) {
         this.audience = var1;
         return this;
      }

      public IdTokenVerifier.Builder setClock(Clock var1) {
         this.clock = Preconditions.checkNotNull(var1);
         return this;
      }

      public IdTokenVerifier.Builder setIssuer(String var1) {
         IdTokenVerifier.Builder var2;
         if (var1 == null) {
            var2 = this.setIssuers(null);
         } else {
            var2 = this.setIssuers(Collections.singleton(var1));
         }

         return var2;
      }

      public IdTokenVerifier.Builder setIssuers(Collection<String> var1) {
         boolean var2;
         if (var1 != null && var1.isEmpty()) {
            var2 = false;
         } else {
            var2 = true;
         }

         Preconditions.checkArgument(var2, "Issuers must not be empty");
         this.issuers = var1;
         return this;
      }
   }
}
