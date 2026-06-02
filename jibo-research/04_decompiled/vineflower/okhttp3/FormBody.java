package okhttp3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSink;

public final class FormBody extends RequestBody {
   private static final MediaType a = MediaType.a("application/x-www-form-urlencoded");
   private final List<String> b;
   private final List<String> c;

   FormBody(List<String> var1, List<String> var2) {
      this.b = Util.a(var1);
      this.c = Util.a(var2);
   }

   private long a(BufferedSink var1, boolean var2) {
      long var5 = 0L;
      if (var2) {
         var1 = new Buffer();
      } else {
         var1 = var1.c();
      }

      int var4 = this.b.size();

      for (int var3 = 0; var3 < var4; var3++) {
         if (var3 > 0) {
            var1.b(38);
         }

         var1.a(this.b.get(var3));
         var1.b(61);
         var1.a(this.c.get(var3));
      }

      if (var2) {
         var5 = var1.b();
         var1.u();
      }

      return var5;
   }

   @Override
   public MediaType a() {
      return a;
   }

   @Override
   public void a(BufferedSink var1) throws IOException {
      this.a(var1, false);
   }

   @Override
   public long b() {
      return this.a(null, true);
   }

   public static final class Builder {
      private final List<String> a = new ArrayList<>();
      private final List<String> b = new ArrayList<>();

      public FormBody.Builder a(String var1, String var2) {
         this.a.add(HttpUrl.a(var1, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true));
         this.b.add(HttpUrl.a(var2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true));
         return this;
      }

      public FormBody a() {
         return new FormBody(this.a, this.b);
      }

      public FormBody.Builder b(String var1, String var2) {
         this.a.add(HttpUrl.a(var1, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true));
         this.b.add(HttpUrl.a(var2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true));
         return this;
      }
   }
}
