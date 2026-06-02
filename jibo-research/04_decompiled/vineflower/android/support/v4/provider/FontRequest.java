package android.support.v4.provider;

import android.support.v4.util.Preconditions;
import android.util.Base64;
import java.util.List;

public final class FontRequest {
   private final String a;
   private final String b;
   private final String c;
   private final List<List<byte[]>> d;
   private final int e;
   private final String f;

   public FontRequest(String var1, String var2, String var3, List<List<byte[]>> var4) {
      this.a = Preconditions.a(var1);
      this.b = Preconditions.a(var2);
      this.c = Preconditions.a(var3);
      this.d = Preconditions.a(var4);
      this.e = 0;
      this.f = this.a + "-" + this.b + "-" + this.c;
   }

   public String a() {
      return this.a;
   }

   public String b() {
      return this.b;
   }

   public String c() {
      return this.c;
   }

   public List<List<byte[]>> d() {
      return this.d;
   }

   public int e() {
      return this.e;
   }

   public String f() {
      return this.f;
   }

   @Override
   public String toString() {
      StringBuilder var4 = new StringBuilder();
      var4.append("FontRequest {mProviderAuthority: " + this.a + ", mProviderPackage: " + this.b + ", mQuery: " + this.c + ", mCertificates:");

      for (int var1 = 0; var1 < this.d.size(); var1++) {
         var4.append(" [");
         List var3 = this.d.get(var1);

         for (int var2 = 0; var2 < var3.size(); var2++) {
            var4.append(" \"");
            var4.append(Base64.encodeToString((byte[])var3.get(var2), 0));
            var4.append("\"");
         }

         var4.append(" ]");
      }

      var4.append("}");
      var4.append("mCertificatesArray: " + this.e);
      return var4.toString();
   }
}
