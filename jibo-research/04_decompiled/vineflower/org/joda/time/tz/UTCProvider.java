package org.joda.time.tz;

import java.util.Collections;
import java.util.Set;
import org.joda.time.DateTimeZone;

public final class UTCProvider implements Provider {
   private static final Set<String> a = Collections.singleton("UTC");

   @Override
   public Set<String> a() {
      return a;
   }

   @Override
   public DateTimeZone a(String var1) {
      DateTimeZone var2;
      if ("UTC".equalsIgnoreCase(var1)) {
         var2 = DateTimeZone.a;
      } else {
         var2 = null;
      }

      return var2;
   }
}
