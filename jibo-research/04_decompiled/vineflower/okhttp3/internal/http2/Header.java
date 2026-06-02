package okhttp3.internal.http2;

import okhttp3.internal.Util;
import okio.ByteString;

public final class Header {
   public static final ByteString a = ByteString.a(":");
   public static final ByteString b = ByteString.a(":status");
   public static final ByteString c = ByteString.a(":method");
   public static final ByteString d = ByteString.a(":path");
   public static final ByteString e = ByteString.a(":scheme");
   public static final ByteString f = ByteString.a(":authority");
   public final ByteString g;
   public final ByteString h;
   final int i;

   public Header(String var1, String var2) {
      this(ByteString.a(var1), ByteString.a(var2));
   }

   public Header(ByteString var1, String var2) {
      this(var1, ByteString.a(var2));
   }

   public Header(ByteString var1, ByteString var2) {
      this.g = var1;
      this.h = var2;
      this.i = var1.h() + 32 + var2.h();
   }

   @Override
   public boolean equals(Object var1) {
      boolean var3 = false;
      boolean var2 = var3;
      if (var1 instanceof Header) {
         var1 = var1;
         var2 = var3;
         if (this.g.equals(var1.g)) {
            var2 = var3;
            if (this.h.equals(var1.h)) {
               var2 = true;
            }
         }
      }

      return var2;
   }

   @Override
   public int hashCode() {
      return (this.g.hashCode() + 527) * 31 + this.h.hashCode();
   }

   @Override
   public String toString() {
      return Util.a("%s: %s", this.g.a(), this.h.a());
   }
}
