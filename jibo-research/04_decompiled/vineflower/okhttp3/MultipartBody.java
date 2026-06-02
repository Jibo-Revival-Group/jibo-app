package okhttp3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;

public final class MultipartBody extends RequestBody {
   public static final MediaType a = MediaType.a("multipart/mixed");
   public static final MediaType b = MediaType.a("multipart/alternative");
   public static final MediaType c = MediaType.a("multipart/digest");
   public static final MediaType d = MediaType.a("multipart/parallel");
   public static final MediaType e = MediaType.a("multipart/form-data");
   private static final byte[] f = new byte[]{58, 32};
   private static final byte[] g = new byte[]{13, 10};
   private static final byte[] h = new byte[]{45, 45};
   private final ByteString i;
   private final MediaType j;
   private final MediaType k;
   private final List<MultipartBody.Part> l;
   private long m = -1L;

   MultipartBody(ByteString var1, MediaType var2, List<MultipartBody.Part> var3) {
      this.i = var1;
      this.j = var2;
      this.k = MediaType.a(var2 + "; boundary=" + var1.a());
      this.l = Util.a(var3);
   }

   private long a(BufferedSink var1, boolean var2) throws IOException {
      long var7 = 0L;
      BufferedSink var11;
      if (var2) {
         var1 = new Buffer();
         var11 = var1;
      } else {
         var11 = null;
      }

      int var5 = this.l.size();
      int var3 = 0;

      long var14;
      while (true) {
         if (var3 >= var5) {
            var1.c(h);
            var1.b(this.i);
            var1.c(h);
            var1.c(g);
            var14 = var7;
            if (var2) {
               var14 = var7 + var11.b();
               var11.u();
            }
            break;
         }

         MultipartBody.Part var13 = this.l.get(var3);
         Headers var12 = var13.a;
         RequestBody var16 = var13.b;
         var1.c(h);
         var1.b(this.i);
         var1.c(g);
         if (var12 != null) {
            int var4 = 0;

            for (int var6 = var12.a(); var4 < var6; var4++) {
               var1.b(var12.a(var4)).c(f).b(var12.b(var4)).c(g);
            }
         }

         MediaType var15 = var16.a();
         if (var15 != null) {
            var1.b("Content-Type: ").b(var15.toString()).c(g);
         }

         var14 = var16.b();
         if (var14 != -1L) {
            var1.b("Content-Length: ").m(var14).c(g);
         } else if (var2) {
            var11.u();
            var14 = -1L;
            break;
         }

         var1.c(g);
         if (var2) {
            var7 += var14;
         } else {
            var16.a(var1);
         }

         var1.c(g);
         var3++;
      }

      return var14;
   }

   @Override
   public MediaType a() {
      return this.k;
   }

   @Override
   public void a(BufferedSink var1) throws IOException {
      this.a(var1, false);
   }

   @Override
   public long b() throws IOException {
      long var1 = this.m;
      if (var1 == -1L) {
         var1 = this.a(null, true);
         this.m = var1;
      }

      return var1;
   }

   public static final class Builder {
      private final ByteString a;
      private MediaType b = MultipartBody.a;
      private final List<MultipartBody.Part> c = new ArrayList<>();

      public Builder() {
         this(UUID.randomUUID().toString());
      }

      public Builder(String var1) {
         this.a = ByteString.a(var1);
      }

      public MultipartBody.Builder a(Headers var1, RequestBody var2) {
         return this.a(MultipartBody.Part.a(var1, var2));
      }

      public MultipartBody.Builder a(MediaType var1) {
         if (var1 == null) {
            throw new NullPointerException("type == null");
         }

         if (!var1.a().equals("multipart")) {
            throw new IllegalArgumentException("multipart != " + var1);
         }

         this.b = var1;
         return this;
      }

      public MultipartBody.Builder a(MultipartBody.Part var1) {
         if (var1 == null) {
            throw new NullPointerException("part == null");
         }

         this.c.add(var1);
         return this;
      }

      public MultipartBody a() {
         if (this.c.isEmpty()) {
            throw new IllegalStateException("Multipart body must have at least one part.");
         } else {
            return new MultipartBody(this.a, this.b, this.c);
         }
      }
   }

   public static final class Part {
      final Headers a;
      final RequestBody b;

      private Part(Headers var1, RequestBody var2) {
         this.a = var1;
         this.b = var2;
      }

      public static MultipartBody.Part a(Headers var0, RequestBody var1) {
         if (var1 == null) {
            throw new NullPointerException("body == null");
         } else if (var0 != null && var0.a("Content-Type") != null) {
            throw new IllegalArgumentException("Unexpected header: Content-Type");
         } else if (var0 != null && var0.a("Content-Length") != null) {
            throw new IllegalArgumentException("Unexpected header: Content-Length");
         } else {
            return new MultipartBody.Part(var0, var1);
         }
      }
   }
}
