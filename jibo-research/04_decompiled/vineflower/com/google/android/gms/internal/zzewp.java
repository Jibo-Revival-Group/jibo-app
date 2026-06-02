package com.google.android.gms.internal;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public final class zzewp {
   private final URL a;

   public zzewp(URL var1) {
      this.a = var1;
   }

   public final URLConnection a() throws IOException {
      return this.a.openConnection();
   }

   @Override
   public final String toString() {
      return this.a.toString();
   }
}
