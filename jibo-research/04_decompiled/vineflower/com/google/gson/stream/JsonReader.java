package com.google.gson.stream;

import com.google.gson.internal.JsonReaderInternalAccess;
import com.google.gson.internal.bind.JsonTreeReader;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;

public class JsonReader implements Closeable {
   private static final char[] b = ")]}'\n".toCharArray();
   int a;
   private final Reader c;
   private boolean d = false;
   private final char[] e = new char[1024];
   private int f = 0;
   private int g = 0;
   private int h = 0;
   private int i = 0;
   private long j;
   private int k;
   private String l;
   private int[] m;
   private int n;
   private String[] o;
   private int[] p;

   static {
      JsonReaderInternalAccess.a = new JsonReaderInternalAccess() {
         @Override
         public void a(JsonReader var1) throws IOException {
            if (var1 instanceof JsonTreeReader) {
               ((JsonTreeReader)var1).o();
            } else {
               int var3 = var1.a;
               int var2 = var3;
               if (var3 == 0) {
                  var2 = var1.r();
               }

               if (var2 == 13) {
                  var1.a = 9;
               } else if (var2 == 12) {
                  var1.a = 8;
               } else {
                  if (var2 != 14) {
                     throw new IllegalStateException("Expected a name but was " + var1.f() + var1.s());
                  }

                  var1.a = 10;
               }
            }
         }
      };
   }

   public JsonReader(Reader var1) {
      this.a = 0;
      this.m = new int[32];
      this.n = 0;
      int[] var3 = this.m;
      int var2 = this.n++;
      var3[var2] = 6;
      this.o = new String[32];
      this.p = new int[32];
      if (var1 == null) {
         throw new NullPointerException("in == null");
      }

      this.c = var1;
   }

   private void a(int var1) {
      if (this.n == this.m.length) {
         int[] var4 = new int[this.n * 2];
         int[] var5 = new int[this.n * 2];
         String[] var3 = new String[this.n * 2];
         System.arraycopy(this.m, 0, var4, 0, this.n);
         System.arraycopy(this.p, 0, var5, 0, this.n);
         System.arraycopy(this.o, 0, var3, 0, this.n);
         this.m = var4;
         this.p = var5;
         this.o = var3;
      }

      int[] var6 = this.m;
      int var2 = this.n++;
      var6[var2] = var1;
   }

   private boolean a(char var1) throws IOException {
      boolean var2;
      switch (var1) {
         case '#':
         case '/':
         case ';':
         case '=':
         case '\\':
            this.w();
         case '\t':
         case '\n':
         case '\f':
         case '\r':
         case ' ':
         case ',':
         case ':':
         case '[':
         case ']':
         case '{':
         case '}':
            var2 = false;
            break;
         default:
            var2 = true;
      }

      return var2;
   }

   private boolean a(String var1) throws IOException {
      boolean var5 = false;
      int var3 = var1.length();

      while (true) {
         if (this.f + var3 > this.g) {
            boolean var4 = var5;
            if (!this.b(var3)) {
               return var4;
            }
         }

         if (this.e[this.f] == '\n') {
            this.h++;
            this.i = this.f + 1;
         } else {
            int var2 = 0;

            while (true) {
               if (var2 >= var3) {
                  boolean var6 = true;
                  return var6;
               }

               if (this.e[this.f + var2] != var1.charAt(var2)) {
                  break;
               }

               var2++;
            }
         }

         this.f++;
      }
   }

   private int b(boolean var1) throws IOException {
      char[] var7 = this.e;
      int var2 = this.f;
      int var3 = this.g;

      while (true) {
         int var4 = var3;
         int var5 = var2;
         if (var2 == var3) {
            this.f = var2;
            if (!this.b(1)) {
               if (var1) {
                  throw new EOFException("End of input" + this.s());
               }

               var2 = -1;
               break;
            }

            var5 = this.f;
            var4 = this.g;
         }

         var2 = var5 + 1;
         char var9 = var7[var5];
         if (var9 == '\n') {
            this.h++;
            this.i = var2;
            var3 = var4;
         } else if (var9 != ' ' && var9 != '\r') {
            if (var9 == '\t') {
               var3 = var4;
            } else if (var9 == '/') {
               this.f = var2;
               if (var2 == var4) {
                  this.f--;
                  boolean var6 = this.b(2);
                  this.f++;
                  if (!var6) {
                     var2 = var9;
                     break;
                  }
               }

               this.w();
               switch (var7[this.f]) {
                  case '*':
                     this.f++;
                     if (!this.a("*/")) {
                        throw this.b("Unterminated comment");
                     }

                     var2 = this.f + 2;
                     var3 = this.g;
                     break;
                  case '/':
                     this.f++;
                     this.x();
                     var2 = this.f;
                     var3 = this.g;
                     break;
                  default:
                     char var10 = var9;
                     return var10;
               }
            } else {
               if (var9 != '#') {
                  this.f = var2;
                  var2 = var9;
                  break;
               }

               this.f = var2;
               this.w();
               this.x();
               var2 = this.f;
               var3 = this.g;
            }
         } else {
            var3 = var4;
         }
      }

      return var2;
   }

   private IOException b(String var1) throws IOException {
      throw new MalformedJsonException(var1 + this.s());
   }

   private String b(char var1) throws IOException {
      char[] var8 = this.e;
      StringBuilder var6 = null;

      do {
         int var2 = this.f;
         int var3 = this.g;
         int var4 = var2;

         while (var4 < var3) {
            int var5 = var4 + 1;
            char var11 = var8[var4];
            if (var11 == var1) {
               this.f = var5;
               var1 = var5 - var2 - 1;
               String var12;
               if (var6 == null) {
                  var12 = new String(var8, var2, var1);
               } else {
                  var6.append(var8, var2, var1);
                  var12 = var6.toString();
               }

               return var12;
            }

            if (var11 == '\\') {
               this.f = var5;
               var3 = var5 - var2 - 1;
               StringBuilder var7 = var6;
               if (var6 == null) {
                  var7 = new StringBuilder(Math.max((var3 + 1) * 2, 16));
               }

               var7.append(var8, var2, var3);
               var7.append(this.y());
               var4 = this.f;
               var3 = this.g;
               var6 = var7;
               var2 = var4;
            } else {
               if (var11 == '\n') {
                  this.h++;
                  this.i = var5;
               }

               var4 = var5;
            }
         }

         StringBuilder var13 = var6;
         if (var6 == null) {
            var13 = new StringBuilder(Math.max((var4 - var2) * 2, 16));
         }

         var13.append(var8, var2, var4 - var2);
         this.f = var4;
         var6 = var13;
      } while (this.b(1));

      throw this.b("Unterminated string");
   }

   private boolean b(int var1) throws IOException {
      boolean var4 = false;
      char[] var5 = this.e;
      this.i = this.i - this.f;
      if (this.g != this.f) {
         this.g = this.g - this.f;
         System.arraycopy(var5, this.f, var5, 0, this.g);
      } else {
         this.g = 0;
      }

      this.f = 0;

      boolean var3;
      while (true) {
         int var2 = this.c.read(var5, this.g, var5.length - this.g);
         var3 = var4;
         if (var2 == -1) {
            break;
         }

         this.g += var2;
         var2 = var1;
         if (this.h == 0) {
            var2 = var1;
            if (this.i == 0) {
               var2 = var1;
               if (this.g > 0) {
                  var2 = var1;
                  if (var5[0] == '\ufeff') {
                     this.f++;
                     this.i++;
                     var2 = var1 + 1;
                  }
               }
            }
         }

         var1 = var2;
         if (this.g >= var2) {
            var3 = true;
            break;
         }
      }

      return var3;
   }

   private void c(char var1) throws IOException {
      char[] var7 = this.e;

      do {
         int var2 = this.f;
         int var3 = this.g;

         while (var2 < var3) {
            int var5 = var2 + 1;
            char var6 = var7[var2];
            if (var6 == var1) {
               this.f = var5;
               return;
            }

            int var4;
            if (var6 == '\\') {
               this.f = var5;
               this.y();
               var2 = this.f;
               var4 = this.g;
            } else {
               var4 = var3;
               var2 = var5;
               if (var6 == '\n') {
                  this.h++;
                  this.i = var5;
                  var4 = var3;
                  var2 = var5;
               }
            }

            var3 = var4;
         }

         this.f = var2;
      } while (this.b(1));

      throw this.b("Unterminated string");
   }

   private int o() throws IOException {
      char var1 = this.e[this.f];
      String var5;
      String var6;
      byte var7;
      if (var1 == 't' || var1 == 'T') {
         var6 = "true";
         var5 = "TRUE";
         var7 = 5;
      } else if (var1 != 'f' && var1 != 'F') {
         if (var1 != 'n' && var1 != 'N') {
            byte var8 = 0;
            return var8;
         }

         var6 = "null";
         var5 = "NULL";
         var7 = 7;
      } else {
         var6 = "false";
         var5 = "FALSE";
         var7 = 6;
      }

      int var3 = var6.length();
      int var2 = 1;

      while (true) {
         if (var2 >= var3) {
            if ((this.f + var3 < this.g || this.b(var3 + 1)) && this.a(this.e[this.f + var3])) {
               var7 = 0;
            } else {
               this.f += var3;
               this.a = var7;
            }
            break;
         }

         if (this.f + var2 >= this.g && !this.b(var2 + 1)) {
            var7 = 0;
            break;
         }

         char var4 = this.e[this.f + var2];
         if (var4 != var6.charAt(var2) && var4 != var5.charAt(var2)) {
            var7 = 0;
            break;
         }

         var2++;
      }

      return var7;
   }

   private int t() throws IOException {
      char[] var15 = this.e;
      int var8 = this.f;
      int var9 = this.g;
      long var11 = 0L;
      byte var2 = 0;
      boolean var3 = true;
      byte var4 = 0;
      int var5 = 0;

      while (true) {
         int var6;
         int var7;
         label150: {
            label130: {
               var7 = var9;
               var6 = var8;
               if (var8 + var5 == var9) {
                  if (var5 == var15.length) {
                     var2 = 0;
                     break;
                  }

                  if (!this.b(var5 + 1)) {
                     break label130;
                  }

                  var6 = this.f;
                  var7 = this.g;
               }

               char var1 = var15[var6 + var5];
               switch (var1) {
                  case '+':
                     if (var4 != 5) {
                        return 0;
                     }

                     byte var28 = 6;
                     var18 = (boolean)var2;
                     var2 = var28;
                     break label150;
                  case '-':
                     if (var4 == 0) {
                        var2 = 1;
                        var18 = true;
                     } else {
                        if (var4 != 5) {
                           return 0;
                        }

                        byte var27 = 6;
                        var18 = (boolean)var2;
                        var2 = var27;
                     }
                     break label150;
                  case '.':
                     if (var4 != 2) {
                        return 0;
                     }

                     byte var26 = 3;
                     var18 = (boolean)var2;
                     var2 = var26;
                     break label150;
                  case 'E':
                  case 'e':
                     if (var4 != 2 && var4 != 4) {
                        return 0;
                     }

                     byte var25 = 5;
                     var18 = (boolean)var2;
                     var2 = var25;
                     break label150;
                  default:
                     if (var1 >= '0' && var1 <= '9') {
                        if (var4 == 1 || var4 == 0) {
                           var11 = -(var1 - '0');
                           byte var24 = 2;
                           var18 = (boolean)var2;
                           var2 = var24;
                        } else if (var4 == 2) {
                           if (var11 == 0L) {
                              return 0;
                           }

                           long var13 = 10L * var11 - (var1 - '0');
                           boolean var29;
                           if (var11 <= -922337203685477580L && (var11 != -922337203685477580L || var13 >= var11)) {
                              var29 = false;
                           } else {
                              var29 = true;
                           }

                           boolean var20 = (boolean)var2;
                           var11 = var13;
                           var3 &= var29;
                           var2 = var4;
                           var18 = var20;
                        } else if (var4 == 3) {
                           byte var21 = 4;
                           var18 = (boolean)var2;
                           var2 = var21;
                        } else if (var4 != 5 && var4 != 6) {
                           boolean var23 = (boolean)var2;
                           var2 = var4;
                           var18 = var23;
                        } else {
                           byte var22 = 7;
                           var18 = (boolean)var2;
                           var2 = var22;
                        }
                        break label150;
                     }

                     if (this.a(var1)) {
                        return 0;
                     }
               }
            }

            if (var4 != 2 || !var3 || var11 == Long.MIN_VALUE && !var2 || var11 == 0L && var2) {
               if (var4 != 2 && var4 != 4 && var4 != 7) {
                  var2 = 0;
                  break;
               }

               this.k = var5;
               var2 = 16;
               this.a = 16;
               break;
            }

            if (!var2) {
               var11 = -var11;
            }

            this.j = var11;
            this.f += var5;
            var2 = 15;
            this.a = 15;
            break;
         }

         int var10 = var5 + 1;
         boolean var19 = var18;
         var9 = var7;
         var8 = var6;
         var4 = var2;
         var2 = var19;
         var5 = var10;
      }

      return var2;
   }

   private String u() throws IOException {
      StringBuilder var3 = null;
      int var1 = 0;

      int var2;
      StringBuilder var4;
      label35:
      while (true) {
         if (this.f + var1 < this.g) {
            var4 = var3;
            var2 = var1;
            switch (this.e[this.f + var1]) {
               case '\t':
               case '\n':
               case '\f':
               case '\r':
               case ' ':
               case ',':
               case ':':
               case '[':
               case ']':
               case '{':
               case '}':
                  break label35;
               case '#':
               case '/':
               case ';':
               case '=':
               case '\\':
                  this.w();
                  var2 = var1;
                  var4 = var3;
                  break label35;
               default:
                  var1++;
            }
         } else if (var1 < this.e.length) {
            var4 = var3;
            var2 = var1;
            if (this.b(var1 + 1)) {
               continue;
            }
            break;
         } else {
            var4 = var3;
            if (var3 == null) {
               var4 = new StringBuilder(Math.max(var1, 16));
            }

            var4.append(this.e, this.f, var1);
            this.f += var1;
            if (!this.b(1)) {
               var2 = 0;
               break;
            }

            var1 = 0;
            var3 = var4;
         }
      }

      String var5;
      if (var4 == null) {
         var5 = new String(this.e, this.f, var2);
      } else {
         var5 = var4.append(this.e, this.f, var2).toString();
      }

      this.f += var2;
      return var5;
   }

   private void v() throws IOException {
      do {
         int var1 = 0;

         while (this.f + var1 < this.g) {
            switch (this.e[this.f + var1]) {
               case '#':
               case '/':
               case ';':
               case '=':
               case '\\':
                  this.w();
               case '\t':
               case '\n':
               case '\f':
               case '\r':
               case ' ':
               case ',':
               case ':':
               case '[':
               case ']':
               case '{':
               case '}':
                  this.f += var1;
                  return;
               default:
                  var1++;
            }
         }

         this.f += var1;
      } while (this.b(1));
   }

   private void w() throws IOException {
      if (!this.d) {
         throw this.b("Use JsonReader.setLenient(true) to accept malformed JSON");
      }
   }

   private void x() throws IOException {
      while (this.f < this.g || this.b(1)) {
         char[] var2 = this.e;
         int var1 = this.f++;
         char var3 = var2[var1];
         if (var3 == '\n') {
            this.h++;
            this.i = this.f;
         } else if (var3 != '\r') {
            continue;
         }
         break;
      }
   }

   private char y() throws IOException {
      if (this.f == this.g && !this.b(1)) {
         throw this.b("Unterminated escape sequence");
      }

      char[] var7 = this.e;
      int var3 = this.f++;
      char var2 = var7[var3];
      char var1 = var2;
      switch (var2) {
         case '\n':
            this.h++;
            this.i = this.f;
            var1 = var2;
         case '"':
         case '\'':
         case '/':
         case '\\':
            break;
         case 'b':
            var1 = '\b';
            break;
         case 'f':
            var1 = '\f';
            break;
         case 'n':
            var1 = '\n';
            break;
         case 'r':
            var1 = '\r';
            break;
         case 't':
            var1 = '\t';
            break;
         case 'u':
            if (this.f + 4 > this.g && !this.b(4)) {
               throw this.b("Unterminated escape sequence");
            }

            int var4 = this.f;
            var1 = 0;

            for (int var8 = var4; var8 < var4 + 4; var8++) {
               char var5 = this.e[var8];
               char var6 = (char)(var1 << 4);
               if (var5 >= '0' && var5 <= '9') {
                  var1 = (char)(var6 + (var5 - '0'));
               } else if (var5 >= 'a' && var5 <= 'f') {
                  var1 = (char)(var6 + var5 - 'a' + 10);
               } else {
                  if (var5 < 'A' || var5 > 'F') {
                     throw new NumberFormatException("\\u" + new String(this.e, this.f, 4));
                  }

                  var1 = (char)(var6 + var5 - 'A' + 10);
               }
            }

            this.f += 4;
            break;
         default:
            throw this.b("Invalid escape sequence");
      }

      return var1;
   }

   private void z() throws IOException {
      this.b(true);
      this.f--;
      if (this.f + b.length <= this.g || this.b(b.length)) {
         int var1 = 0;

         while (true) {
            if (var1 >= b.length) {
               this.f = this.f + b.length;
               break;
            }

            if (this.e[this.f + var1] != b[var1]) {
               break;
            }

            var1++;
         }
      }
   }

   public void a() throws IOException {
      int var2 = this.a;
      int var1 = var2;
      if (var2 == 0) {
         var1 = this.r();
      }

      if (var1 == 3) {
         this.a(1);
         this.p[this.n - 1] = 0;
         this.a = 0;
      } else {
         throw new IllegalStateException("Expected BEGIN_ARRAY but was " + this.f() + this.s());
      }
   }

   public final void a(boolean var1) {
      this.d = var1;
   }

   public void b() throws IOException {
      int var2 = this.a;
      int var1 = var2;
      if (var2 == 0) {
         var1 = this.r();
      }

      if (var1 == 4) {
         this.n--;
         int[] var3 = this.p;
         var1 = this.n - 1;
         var3[var1]++;
         this.a = 0;
      } else {
         throw new IllegalStateException("Expected END_ARRAY but was " + this.f() + this.s());
      }
   }

   public void c() throws IOException {
      int var2 = this.a;
      int var1 = var2;
      if (var2 == 0) {
         var1 = this.r();
      }

      if (var1 == 1) {
         this.a(3);
         this.a = 0;
      } else {
         throw new IllegalStateException("Expected BEGIN_OBJECT but was " + this.f() + this.s());
      }
   }

   @Override
   public void close() throws IOException {
      this.a = 0;
      this.m[0] = 8;
      this.n = 1;
      this.c.close();
   }

   public void d() throws IOException {
      int var2 = this.a;
      int var1 = var2;
      if (var2 == 0) {
         var1 = this.r();
      }

      if (var1 == 2) {
         this.n--;
         this.o[this.n] = null;
         int[] var3 = this.p;
         var1 = this.n - 1;
         var3[var1]++;
         this.a = 0;
      } else {
         throw new IllegalStateException("Expected END_OBJECT but was " + this.f() + this.s());
      }
   }

   public boolean e() throws IOException {
      int var2 = this.a;
      int var1 = var2;
      if (var2 == 0) {
         var1 = this.r();
      }

      boolean var3;
      if (var1 != 2 && var1 != 4) {
         var3 = true;
      } else {
         var3 = false;
      }

      return var3;
   }

   public JsonToken f() throws IOException {
      int var2 = this.a;
      int var1 = var2;
      if (var2 == 0) {
         var1 = this.r();
      }

      JsonToken var3;
      switch (var1) {
         case 1:
            var3 = JsonToken.BEGIN_OBJECT;
            break;
         case 2:
            var3 = JsonToken.END_OBJECT;
            break;
         case 3:
            var3 = JsonToken.BEGIN_ARRAY;
            break;
         case 4:
            var3 = JsonToken.END_ARRAY;
            break;
         case 5:
         case 6:
            var3 = JsonToken.BOOLEAN;
            break;
         case 7:
            var3 = JsonToken.NULL;
            break;
         case 8:
         case 9:
         case 10:
         case 11:
            var3 = JsonToken.STRING;
            break;
         case 12:
         case 13:
         case 14:
            var3 = JsonToken.NAME;
            break;
         case 15:
         case 16:
            var3 = JsonToken.NUMBER;
            break;
         case 17:
            var3 = JsonToken.END_DOCUMENT;
            break;
         default:
            throw new AssertionError();
      }

      return var3;
   }

   public String g() throws IOException {
      int var2 = this.a;
      int var1 = var2;
      if (var2 == 0) {
         var1 = this.r();
      }

      String var3;
      if (var1 == 14) {
         var3 = this.u();
      } else if (var1 == 12) {
         var3 = this.b('\'');
      } else {
         if (var1 != 13) {
            throw new IllegalStateException("Expected a name but was " + this.f() + this.s());
         }

         var3 = this.b('"');
      }

      this.a = 0;
      this.o[this.n - 1] = var3;
      return var3;
   }

   public String h() throws IOException {
      int var2 = this.a;
      int var1 = var2;
      if (var2 == 0) {
         var1 = this.r();
      }

      String var3;
      if (var1 == 10) {
         var3 = this.u();
      } else if (var1 == 8) {
         var3 = this.b('\'');
      } else if (var1 == 9) {
         var3 = this.b('"');
      } else if (var1 == 11) {
         var3 = this.l;
         this.l = null;
      } else if (var1 == 15) {
         var3 = Long.toString(this.j);
      } else {
         if (var1 != 16) {
            throw new IllegalStateException("Expected a string but was " + this.f() + this.s());
         }

         var3 = new String(this.e, this.f, this.k);
         this.f = this.f + this.k;
      }

      this.a = 0;
      int[] var4 = this.p;
      var1 = this.n - 1;
      var4[var1]++;
      return var3;
   }

   public boolean i() throws IOException {
      boolean var3 = false;
      int var2 = this.a;
      int var1 = var2;
      if (var2 == 0) {
         var1 = this.r();
      }

      if (var1 == 5) {
         this.a = 0;
         int[] var4 = this.p;
         var1 = this.n - 1;
         var4[var1]++;
         var3 = true;
      } else {
         if (var1 != 6) {
            throw new IllegalStateException("Expected a boolean but was " + this.f() + this.s());
         }

         this.a = 0;
         int[] var7 = this.p;
         var1 = this.n - 1;
         var7[var1]++;
      }

      return var3;
   }

   public void j() throws IOException {
      int var2 = this.a;
      int var1 = var2;
      if (var2 == 0) {
         var1 = this.r();
      }

      if (var1 == 7) {
         this.a = 0;
         int[] var3 = this.p;
         var1 = this.n - 1;
         var3[var1]++;
      } else {
         throw new IllegalStateException("Expected null but was " + this.f() + this.s());
      }
   }

   public double k() throws IOException {
      int var5 = this.a;
      int var4 = var5;
      if (var5 == 0) {
         var4 = this.r();
      }

      double var2;
      if (var4 == 15) {
         this.a = 0;
         int[] var9 = this.p;
         var4 = this.n - 1;
         var9[var4]++;
         var2 = this.j;
      } else {
         if (var4 == 16) {
            this.l = new String(this.e, this.f, this.k);
            this.f = this.f + this.k;
         } else if (var4 != 8 && var4 != 9) {
            if (var4 == 10) {
               this.l = this.u();
            } else if (var4 != 11) {
               throw new IllegalStateException("Expected a double but was " + this.f() + this.s());
            }
         } else {
            char var1;
            if (var4 == 8) {
               var1 = '\'';
            } else {
               var1 = '"';
            }

            this.l = this.b(var1);
         }

         this.a = 11;
         var2 = Double.parseDouble(this.l);
         if (!this.d && (Double.isNaN(var2) || Double.isInfinite(var2))) {
            throw new MalformedJsonException("JSON forbids NaN and infinities: " + var2 + this.s());
         }

         this.l = null;
         this.a = 0;
         int[] var6 = this.p;
         var4 = this.n - 1;
         var6[var4]++;
      }

      return var2;
   }

   public long l() throws IOException {
      int var5 = this.a;
      int var4 = var5;
      if (var5 == 0) {
         var4 = this.r();
      }

      long var6;
      if (var4 == 15) {
         this.a = 0;
         int[] var8 = this.p;
         var4 = this.n - 1;
         var8[var4]++;
         var6 = this.j;
      } else {
         if (var4 == 16) {
            this.l = new String(this.e, this.f, this.k);
            this.f = this.f + this.k;
         } else {
            label57: {
               if (var4 != 8 && var4 != 9 && var4 != 10) {
                  throw new IllegalStateException("Expected a long but was " + this.f() + this.s());
               }

               if (var4 == 10) {
                  this.l = this.u();
               } else {
                  char var1;
                  if (var4 == 8) {
                     var1 = '\'';
                  } else {
                     var1 = '"';
                  }

                  this.l = this.b(var1);
               }

               int[] var14;
               try {
                  var6 = Long.parseLong(this.l);
                  this.a = 0;
                  var14 = this.p;
                  var4 = this.n - 1;
               } catch (NumberFormatException var9) {
                  break label57;
               }

               var14[var4]++;
               return var6;
            }
         }

         this.a = 11;
         double var2 = Double.parseDouble(this.l);
         var6 = (long)var2;
         if (var6 != var2) {
            throw new NumberFormatException("Expected a long but was " + this.l + this.s());
         }

         this.l = null;
         this.a = 0;
         int[] var13 = this.p;
         var4 = this.n - 1;
         var13[var4]++;
      }

      return var6;
   }

   public int m() throws IOException {
      int var5 = this.a;
      int var4 = var5;
      if (var5 == 0) {
         var4 = this.r();
      }

      if (var4 == 15) {
         var4 = (int)this.j;
         if (this.j != var4) {
            throw new NumberFormatException("Expected an int but was " + this.j + this.s());
         }

         this.a = 0;
         int[] var6 = this.p;
         var5 = this.n - 1;
         var6[var5]++;
      } else {
         if (var4 == 16) {
            this.l = new String(this.e, this.f, this.k);
            this.f = this.f + this.k;
         } else {
            label61: {
               if (var4 != 8 && var4 != 9 && var4 != 10) {
                  throw new IllegalStateException("Expected an int but was " + this.f() + this.s());
               }

               if (var4 == 10) {
                  this.l = this.u();
               } else {
                  char var1;
                  if (var4 == 8) {
                     var1 = '\'';
                  } else {
                     var1 = '"';
                  }

                  this.l = this.b(var1);
               }

               int[] var13;
               try {
                  var4 = Integer.parseInt(this.l);
                  this.a = 0;
                  var13 = this.p;
                  var5 = this.n - 1;
               } catch (NumberFormatException var7) {
                  break label61;
               }

               var13[var5]++;
               return var4;
            }
         }

         this.a = 11;
         double var2 = Double.parseDouble(this.l);
         var4 = (int)var2;
         if (var4 != var2) {
            throw new NumberFormatException("Expected an int but was " + this.l + this.s());
         }

         this.l = null;
         this.a = 0;
         int[] var12 = this.p;
         var5 = this.n - 1;
         var12[var5]++;
      }

      return var4;
   }

   public void n() throws IOException {
      int var2 = 0;

      int var5;
      do {
         var5 = this.a;
         int var3 = var5;
         if (var5 == 0) {
            var3 = this.r();
         }

         if (var3 == 3) {
            this.a(1);
            var5 = var2 + 1;
         } else if (var3 == 1) {
            this.a(3);
            var5 = var2 + 1;
         } else if (var3 == 4) {
            this.n--;
            var5 = var2 - 1;
         } else if (var3 == 2) {
            this.n--;
            var5 = var2 - 1;
         } else if (var3 == 14 || var3 == 10) {
            this.v();
            var5 = var2;
         } else if (var3 == 8 || var3 == 12) {
            this.c('\'');
            var5 = var2;
         } else if (var3 != 9 && var3 != 13) {
            var5 = var2;
            if (var3 == 16) {
               this.f = this.f + this.k;
               var5 = var2;
            }
         } else {
            this.c('"');
            var5 = var2;
         }

         this.a = 0;
         var2 = var5;
      } while (var5 != 0);

      int[] var4 = this.p;
      var5 = this.n - 1;
      var4[var5]++;
      this.o[this.n - 1] = "null";
   }

   public String p() {
      StringBuilder var3 = new StringBuilder().append('$');
      int var1 = 0;

      for (int var2 = this.n; var1 < var2; var1++) {
         switch (this.m[var1]) {
            case 1:
            case 2:
               var3.append('[').append(this.p[var1]).append(']');
               break;
            case 3:
            case 4:
            case 5:
               var3.append('.');
               if (this.o[var1] != null) {
                  var3.append(this.o[var1]);
               }
         }
      }

      return var3.toString();
   }

   public final boolean q() {
      return this.d;
   }

   int r() throws IOException {
      int var1 = 4;
      int var2 = this.m[this.n - 1];
      if (var2 == 1) {
         this.m[this.n - 1] = 2;
      } else if (var2 == 2) {
         switch (this.b(true)) {
            case 44:
               break;
            case 59:
               this.w();
               break;
            case 93:
               this.a = 4;
               return var1;
            default:
               throw this.b("Unterminated array");
         }
      } else {
         if (var2 == 3 || var2 == 5) {
            this.m[this.n - 1] = 4;
            if (var2 == 5) {
               switch (this.b(true)) {
                  case 44:
                     break;
                  case 59:
                     this.w();
                     break;
                  case 125:
                     this.a = 2;
                     byte var6 = 2;
                     return var6;
                  default:
                     throw this.b("Unterminated object");
               }
            }

            var1 = this.b(true);
            switch (var1) {
               case 34:
                  byte var10 = 13;
                  this.a = 13;
                  return var10;
               case 39:
                  this.w();
                  byte var9 = 12;
                  this.a = 12;
                  return var9;
               case 125:
                  if (var2 == 5) {
                     throw this.b("Expected name");
                  }

                  this.a = 2;
                  byte var8 = 2;
                  return var8;
               default:
                  this.w();
                  this.f--;
                  if (!this.a((char)var1)) {
                     throw this.b("Expected name");
                  }

                  byte var7 = 14;
                  this.a = 14;
                  return var7;
            }
         }

         if (var2 == 4) {
            this.m[this.n - 1] = 5;
            switch (this.b(true)) {
               case 58:
                  break;
               case 59:
               case 60:
               default:
                  throw this.b("Expected ':'");
               case 61:
                  this.w();
                  if ((this.f < this.g || this.b(1)) && this.e[this.f] == '>') {
                     this.f++;
                  }
            }
         } else if (var2 == 6) {
            if (this.d) {
               this.z();
            }

            this.m[this.n - 1] = 7;
         } else if (var2 == 7) {
            if (this.b(false) == -1) {
               byte var5 = 17;
               this.a = 17;
               return var5;
            }

            this.w();
            this.f--;
         } else if (var2 == 8) {
            throw new IllegalStateException("JsonReader is closed");
         }
      }

      switch (this.b(true)) {
         case 34:
            var1 = 9;
            this.a = 9;
            break;
         case 39:
            this.w();
            var1 = 8;
            this.a = 8;
            break;
         case 91:
            var1 = 3;
            this.a = 3;
            break;
         case 93:
            if (var2 == 1) {
               this.a = 4;
               break;
            }
         case 44:
         case 59:
            if (var2 != 1 && var2 != 2) {
               throw this.b("Unexpected value");
            }

            this.w();
            this.f--;
            this.a = 7;
            var1 = 7;
            break;
         case 123:
            this.a = 1;
            var1 = 1;
            break;
         default:
            this.f--;
            var1 = this.o();
            if (var1 == 0) {
               var2 = this.t();
               var1 = var2;
               if (var2 == 0) {
                  if (!this.a(this.e[this.f])) {
                     throw this.b("Expected value");
                  }

                  this.w();
                  var1 = 10;
                  this.a = 10;
               }
            }
      }

      return var1;
   }

   String s() {
      int var2 = this.h;
      int var3 = this.f;
      int var1 = this.i;
      return " at line " + (var2 + 1) + " column " + (var3 - var1 + 1) + " path " + this.p();
   }

   @Override
   public String toString() {
      return this.getClass().getSimpleName() + this.s();
   }
}
