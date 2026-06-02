package okhttp3.internal.tls;

import javax.security.auth.x500.X500Principal;

final class DistinguishedNameParser {
   private final String a;
   private final int b;
   private int c;
   private int d;
   private int e;
   private int f;
   private char[] g;

   DistinguishedNameParser(X500Principal var1) {
      this.a = var1.getName("RFC2253");
      this.b = this.a.length();
   }

   private int a(int var1) {
      if (var1 + 1 >= this.b) {
         throw new IllegalStateException("Malformed DN: " + this.a);
      }

      int var2 = this.g[var1];
      if (var2 >= 48 && var2 <= 57) {
         var2 -= 48;
      } else if (var2 >= 97 && var2 <= 102) {
         var2 -= 87;
      } else {
         if (var2 < 65 || var2 > 70) {
            throw new IllegalStateException("Malformed DN: " + this.a);
         }

         var2 -= 55;
      }

      int var3 = this.g[var1 + 1];
      if (var3 >= 48 && var3 <= 57) {
         var3 -= 48;
      } else if (var3 >= 97 && var3 <= 102) {
         var3 -= 87;
      } else {
         if (var3 < 65 || var3 > 70) {
            throw new IllegalStateException("Malformed DN: " + this.a);
         }

         var3 -= 55;
      }

      return (var2 << 4) + var3;
   }

   private String a() {
      while (this.c < this.b && this.g[this.c] == ' ') {
         this.c++;
      }

      String var1;
      if (this.c == this.b) {
         var1 = null;
      } else {
         this.d = this.c++;

         while (this.c < this.b && this.g[this.c] != '=' && this.g[this.c] != ' ') {
            this.c++;
         }

         if (this.c >= this.b) {
            throw new IllegalStateException("Unexpected end of DN: " + this.a);
         }

         this.e = this.c;
         if (this.g[this.c] == ' ') {
            while (this.c < this.b && this.g[this.c] != '=' && this.g[this.c] == ' ') {
               this.c++;
            }

            if (this.g[this.c] != '=' || this.c == this.b) {
               throw new IllegalStateException("Unexpected end of DN: " + this.a);
            }
         }

         this.c++;

         while (this.c < this.b && this.g[this.c] == ' ') {
            this.c++;
         }

         if (this.e - this.d > 4
            && this.g[this.d + 3] == '.'
            && (this.g[this.d] == 'O' || this.g[this.d] == 'o')
            && (this.g[this.d + 1] == 'I' || this.g[this.d + 1] == 'i')
            && (this.g[this.d + 2] == 'D' || this.g[this.d + 2] == 'd')) {
            this.d += 4;
         }

         var1 = new String(this.g, this.d, this.e - this.d);
      }

      return var1;
   }

   private String b() {
      this.c++;
      this.d = this.c;

      for (this.e = this.d; this.c != this.b; this.e++) {
         if (this.g[this.c] == '"') {
            this.c++;

            while (this.c < this.b && this.g[this.c] == ' ') {
               this.c++;
            }

            return new String(this.g, this.d, this.e - this.d);
         }

         if (this.g[this.c] == '\\') {
            this.g[this.e] = this.e();
         } else {
            this.g[this.e] = this.g[this.c];
         }

         this.c++;
      }

      throw new IllegalStateException("Unexpected end of DN: " + this.a);
   }

   private String c() {
      if (this.c + 4 >= this.b) {
         throw new IllegalStateException("Unexpected end of DN: " + this.a);
      }

      this.d = this.c++;

      label57:
      while (true) {
         if (this.c == this.b || this.g[this.c] == '+' || this.g[this.c] == ',' || this.g[this.c] == ';') {
            this.e = this.c;
            break;
         }

         if (this.g[this.c] == ' ') {
            this.e = this.c++;

            while (true) {
               if (this.c >= this.b || this.g[this.c] != ' ') {
                  break label57;
               }

               this.c++;
            }
         }

         if (this.g[this.c] >= 'A' && this.g[this.c] <= 'F') {
            char[] var4 = this.g;
            int var1 = this.c;
            var4[var1] = (char)(var4[var1] + ' ');
         }

         this.c++;
      }

      int var3 = this.e - this.d;
      if (var3 >= 5 && (var3 & 1) != 0) {
         byte[] var6 = new byte[var3 / 2];
         int var5 = 0;
         int var2 = this.d + 1;

         while (var5 < var6.length) {
            var6[var5] = (byte)this.a(var2);
            var2 += 2;
            var5++;
         }

         return new String(this.g, this.d, var3);
      } else {
         throw new IllegalStateException("Unexpected end of DN: " + this.a);
      }
   }

   private String d() {
      this.d = this.c;
      this.e = this.c;

      while (this.c < this.b) {
         switch (this.g[this.c]) {
            case ' ':
               this.f = this.e;
               this.c++;
               char[] var8 = this.g;
               int var4 = this.e++;

               for (var8[var4] = ' '; this.c < this.b && this.g[this.c] == ' '; this.c++) {
                  var8 = this.g;
                  var4 = this.e++;
                  var8[var4] = ' ';
               }

               if (this.c == this.b || this.g[this.c] == ',' || this.g[this.c] == '+' || this.g[this.c] == ';') {
                  return new String(this.g, this.d, this.f - this.d);
               }
               break;
            case '+':
            case ',':
            case ';':
               return new String(this.g, this.d, this.e - this.d);
            case '\\':
               char[] var6 = this.g;
               int var3 = this.e++;
               var6[var3] = this.e();
               this.c++;
               break;
            default:
               char[] var2 = this.g;
               int var1 = this.e++;
               var2[var1] = this.g[this.c];
               this.c++;
         }
      }

      return new String(this.g, this.d, this.e - this.d);
   }

   private char e() {
      this.c++;
      if (this.c == this.b) {
         throw new IllegalStateException("Unexpected end of DN: " + this.a);
      }

      char var1;
      switch (this.g[this.c]) {
         case ' ':
         case '"':
         case '#':
         case '%':
         case '*':
         case '+':
         case ',':
         case ';':
         case '<':
         case '=':
         case '>':
         case '\\':
         case '_':
            var1 = this.g[this.c];
            break;
         default:
            var1 = this.f();
      }

      return var1;
   }

   private char f() {
      int var2 = this.a(this.c);
      this.c++;
      char var1;
      if (var2 < 128) {
         var1 = (char)var2;
      } else if (var2 >= 192 && var2 <= 247) {
         byte var3;
         if (var2 <= 223) {
            var3 = 1;
            var2 &= 31;
         } else if (var2 <= 239) {
            var3 = 2;
            var2 &= 15;
         } else {
            var3 = 3;
            var2 &= 7;
         }

         int var4 = 0;

         while (true) {
            if (var4 >= var3) {
               var1 = (char)var2;
               break;
            }

            this.c++;
            if (this.c == this.b || this.g[this.c] != '\\') {
               var1 = '?';
               break;
            }

            this.c++;
            int var5 = this.a(this.c);
            this.c++;
            if ((var5 & 192) != 128) {
               var1 = '?';
               break;
            }

            var2 = (var2 << 6) + (var5 & 63);
            var4++;
         }
      } else {
         var1 = '?';
      }

      return var1;
   }

   public String a(String var1) {
      this.c = 0;
      this.d = 0;
      this.e = 0;
      this.f = 0;
      this.g = this.a.toCharArray();
      String var2 = this.a();
      String var3 = var2;
      if (var2 == null) {
         var2 = null;
      } else {
         while (true) {
            var2 = "";
            if (this.c == this.b) {
               var2 = null;
               break;
            }

            switch (this.g[this.c]) {
               case '"':
                  var2 = this.b();
                  break;
               case '#':
                  var2 = this.c();
               case '+':
               case ',':
               case ';':
                  break;
               default:
                  var2 = this.d();
            }

            if (var1.equalsIgnoreCase(var3)) {
               break;
            }

            if (this.c >= this.b) {
               var2 = null;
               break;
            }

            if (this.g[this.c] != ',' && this.g[this.c] != ';' && this.g[this.c] != '+') {
               throw new IllegalStateException("Malformed DN: " + this.a);
            }

            this.c++;
            var2 = this.a();
            var3 = var2;
            if (var2 == null) {
               throw new IllegalStateException("Malformed DN: " + this.a);
            }
         }
      }

      return var2;
   }
}
