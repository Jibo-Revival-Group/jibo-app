package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.base.ParserBase;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
import com.fasterxml.jackson.core.util.TextBuffer;
import java.io.IOException;
import java.io.Reader;

public class ReaderBasedJsonParser extends ParserBase {
   protected static final int[] L = CharTypes.a();
   protected Reader M;
   protected char[] N;
   protected boolean O;
   protected ObjectCodec P;
   protected final CharsToNameCanonicalizer Q;
   protected final int R;
   protected boolean S = false;

   public ReaderBasedJsonParser(IOContext var1, int var2, Reader var3, ObjectCodec var4, CharsToNameCanonicalizer var5) {
      super(var1, var2);
      this.M = var3;
      this.N = var1.g();
      this.d = 0;
      this.e = 0;
      this.P = var4;
      this.Q = var5;
      this.R = var5.e();
      this.O = true;
   }

   public ReaderBasedJsonParser(
      IOContext var1, int var2, Reader var3, ObjectCodec var4, CharsToNameCanonicalizer var5, char[] var6, int var7, int var8, boolean var9
   ) {
      super(var1, var2);
      this.M = var3;
      this.N = var6;
      this.d = var7;
      this.e = var8;
      this.P = var4;
      this.Q = var5;
      this.R = var5.e();
      this.O = var9;
   }

   private final JsonToken O() {
      this.p = false;
      JsonToken var1 = this.m;
      this.m = null;
      if (var1 == JsonToken.START_ARRAY) {
         this.l = this.l.a(this.j, this.k);
      } else if (var1 == JsonToken.START_OBJECT) {
         this.l = this.l.b(this.j, this.k);
      }

      this.K = var1;
      return var1;
   }

   private final char P() throws IOException {
      byte var2 = 48;
      if (this.d < this.e) {
         char var3 = this.N[this.d];
         char var1 = (char)var2;
         if (var3 < '0') {
            return var1;
         }

         if (var3 > '9') {
            var1 = (char)var2;
            return var1;
         }
      }

      return this.Q();
   }

   private char Q() throws IOException {
      char var1;
      if (this.d >= this.e && !this.p()) {
         var1 = '0';
      } else {
         char var2 = this.N[this.d];
         if (var2 >= '0' && var2 <= '9') {
            if (!this.a(JsonParser.Feature.ALLOW_NUMERIC_LEADING_ZEROS)) {
               this.b("Leading zeroes not allowed");
            }

            this.d++;
            var1 = var2;
            if (var2 == '0') {
               var1 = var2;

               while (this.d < this.e || this.p()) {
                  var2 = this.N[this.d];
                  if (var2 < '0' || var2 > '9') {
                     var1 = '0';
                     break;
                  }

                  this.d++;
                  var1 = var2;
                  if (var2 != '0') {
                     var1 = var2;
                     break;
                  }
               }
            }
         } else {
            var1 = '0';
         }
      }

      return var1;
   }

   private final int R() throws IOException {
      int var1;
      if (this.d + 4 >= this.e) {
         var1 = this.a(false);
      } else {
         char var2 = this.N[this.d];
         if (var2 == ':') {
            char[] var3 = this.N;
            var1 = this.d + 1;
            this.d = var1;
            var1 = var3[var1];
            if (var1 > 32) {
               if (var1 != 47 && var1 != 35) {
                  this.d++;
               } else {
                  var1 = this.a(true);
               }
            } else {
               if (var1 == 32 || var1 == 9) {
                  var3 = this.N;
                  var1 = this.d + 1;
                  this.d = var1;
                  var1 = var3[var1];
                  if (var1 > 32) {
                     if (var1 != 47 && var1 != 35) {
                        this.d++;
                     } else {
                        var1 = this.a(true);
                     }

                     return var1;
                  }
               }

               var1 = this.a(true);
            }
         } else {
            label59: {
               if (var2 != ' ') {
                  var6 = var2;
                  if (var2 != '\t') {
                     break label59;
                  }
               }

               char[] var11 = this.N;
               var1 = this.d + 1;
               this.d = var1;
               var6 = var11[var1];
            }

            if (var6 == ':') {
               char[] var12 = this.N;
               var1 = this.d + 1;
               this.d = var1;
               var1 = var12[var1];
               if (var1 > 32) {
                  if (var1 != 47 && var1 != 35) {
                     this.d++;
                  } else {
                     var1 = this.a(true);
                  }
               } else {
                  if (var1 == 32 || var1 == 9) {
                     var12 = this.N;
                     var1 = this.d + 1;
                     this.d = var1;
                     var1 = var12[var1];
                     if (var1 > 32) {
                        if (var1 != 47 && var1 != 35) {
                           this.d++;
                        } else {
                           var1 = this.a(true);
                        }

                        return var1;
                     }
                  }

                  var1 = this.a(true);
               }
            } else {
               var1 = this.a(false);
            }
         }
      }

      return var1;
   }

   private final int S() throws IOException {
      while (this.d < this.e || this.p()) {
         char[] var2 = this.N;
         int var1 = this.d++;
         char var3 = var2[var1];
         if (var3 > ' ') {
            if (var3 == '/') {
               this.V();
            } else if (var3 != '#' || !this.X()) {
               return var3;
            }
         } else if (var3 < ' ') {
            if (var3 == '\n') {
               this.g++;
               this.h = this.d;
            } else if (var3 == '\r') {
               this.N();
            } else if (var3 != '\t') {
               this.c(var3);
            }
         }
      }

      throw this.a("Unexpected end-of-input within/between " + this.l.d() + " entries");
   }

   private final int T() throws IOException {
      int var8;
      if (this.d >= this.e && !this.p()) {
         var8 = this.u();
      } else {
         char[] var3 = this.N;
         var8 = this.d++;
         char var2 = var3[var8];
         if (var2 > ' ') {
            if (var2 != '/') {
               char var4 = var2;
               if (var2 != '#') {
                  return var4;
               }
            }

            this.d--;
            var8 = this.U();
         } else {
            if (var2 != ' ') {
               if (var2 == '\n') {
                  this.g++;
                  this.h = this.d;
               } else if (var2 == '\r') {
                  this.N();
               } else if (var2 != '\t') {
                  this.c(var2);
               }
            }

            while (true) {
               if (this.d >= this.e) {
                  var8 = this.U();
                  break;
               }

               var3 = this.N;
               var8 = this.d++;
               var2 = var3[var8];
               if (var2 > ' ') {
                  if (var2 != '/') {
                     var8 = var2;
                     if (var2 != '#') {
                        break;
                     }
                  }

                  this.d--;
                  var8 = this.U();
                  break;
               }

               if (var2 != ' ') {
                  if (var2 == '\n') {
                     this.g++;
                     this.h = this.d;
                  } else if (var2 == '\r') {
                     this.N();
                  } else if (var2 != '\t') {
                     this.c(var2);
                  }
               }
            }
         }
      }

      return var8;
   }

   private int U() throws IOException {
      int var4;
      while (true) {
         if (this.d >= this.e && !this.p()) {
            var4 = this.u();
            break;
         }

         char[] var3 = this.N;
         var4 = this.d++;
         char var2 = var3[var4];
         if (var2 <= ' ') {
            if (var2 != ' ') {
               if (var2 == '\n') {
                  this.g++;
                  this.h = this.d;
               } else if (var2 == '\r') {
                  this.N();
               } else if (var2 != '\t') {
                  this.c(var2);
               }
            }
         } else if (var2 == '/') {
            this.V();
         } else {
            var4 = var2;
            if (var2 == '#') {
               var4 = var2;
               if (this.X()) {
                  continue;
               }
            }
            break;
         }
      }

      return var4;
   }

   private void V() throws IOException {
      if (!this.a(JsonParser.Feature.ALLOW_COMMENTS)) {
         this.b(47, "maybe a (non-standard) comment? (not recognized as one since Feature 'ALLOW_COMMENTS' not enabled for parser)");
      }

      if (this.d >= this.e && !this.p()) {
         this.c(" in a comment");
      }

      char[] var2 = this.N;
      int var1 = this.d++;
      char var3 = var2[var1];
      if (var3 == '/') {
         this.Y();
      } else if (var3 == '*') {
         this.W();
      } else {
         this.b(var3, "was expecting either '*' or '/' for a comment");
      }
   }

   private void W() throws IOException {
      while (this.d < this.e || this.p()) {
         char[] var2 = this.N;
         int var1 = this.d++;
         char var3 = var2[var1];
         if (var3 <= '*') {
            if (var3 != '*') {
               if (var3 < ' ') {
                  if (var3 == '\n') {
                     this.g++;
                     this.h = this.d;
                  } else if (var3 == '\r') {
                     this.N();
                  } else if (var3 != '\t') {
                     this.c(var3);
                  }
               }
            } else {
               if (this.d >= this.e && !this.p()) {
                  break;
               }

               if (this.N[this.d] == '/') {
                  this.d++;
                  return;
               }
            }
         }
      }

      this.c(" in a comment");
   }

   private boolean X() throws IOException {
      boolean var1;
      if (!this.a(JsonParser.Feature.ALLOW_YAML_COMMENTS)) {
         var1 = false;
      } else {
         this.Y();
         var1 = true;
      }

      return var1;
   }

   private void Y() throws IOException {
      while (this.d < this.e || this.p()) {
         char[] var2 = this.N;
         int var1 = this.d++;
         char var3 = var2[var1];
         if (var3 < ' ') {
            if (var3 == '\n') {
               this.g++;
               this.h = this.d;
               break;
            } else if (var3 != '\r') {
               if (var3 != '\t') {
                  this.c(var3);
               }
            } else {
               this.N();
               break;
            }
         }
      }
   }

   private final void Z() throws IOException {
      int var1 = this.d;
      if (var1 + 3 < this.e) {
         char[] var3 = this.N;
         if (var3[var1] == 'r') {
            if (var3[++var1] == 'u') {
               if (var3[++var1] == 'e') {
                  int var2 = var1 + 1;
                  char var6 = var3[var2];
                  if (var6 < '0' || var6 == ']' || var6 == '}') {
                     this.d = var2;
                     return;
                  }
               }
            }
         }
      }

      this.a("true", 1);
   }

   private final int a(boolean var1) throws IOException {
      while (true) {
         if (this.d >= this.e) {
            this.o();
         }

         char[] var3 = this.N;
         int var2 = this.d++;
         char var4 = var3[var2];
         if (var4 > ' ') {
            if (var4 == '/') {
               this.V();
            } else if (var4 != '#' || !this.X()) {
               if (var1) {
                  return var4;
               }

               if (var4 != ':') {
                  if (var4 < ' ') {
                     this.c(var4);
                  }

                  this.b(var4, "was expecting a colon to separate field name and value");
               }

               var1 = true;
            }
         } else if (var4 < ' ') {
            if (var4 == '\n') {
               this.g++;
               this.h = this.d;
            } else if (var4 == '\r') {
               this.N();
            } else if (var4 != '\t') {
               this.c(var4);
            }
         }
      }
   }

   private final JsonToken a(int var1, int var2, int var3, boolean var4, int var5) throws IOException {
      int var8 = 0;
      byte var11 = 0;
      int var12 = this.e;
      int var7;
      if (var1 == 46) {
         var1 = 0;
         int var6 = var3;

         while (true) {
            if (var6 >= var12) {
               return this.b(var4, var2);
            }

            char[] var13 = this.N;
            var3 = var6 + 1;
            char var21 = var13[var6];
            if (var21 < '0' || var21 > '9') {
               if (var1 == 0) {
                  this.a(var21, "Decimal point not followed by a digit");
               }

               var7 = var1;
               var1 = var3;
               var3 = var21;
               break;
            }

            var1++;
            var6 = var3;
         }
      } else {
         var7 = 0;
         int var22 = var1;
         var1 = var3;
         var3 = var22;
      }

      int var9;
      int var10;
      label86: {
         if (var3 != 101) {
            var10 = var1;
            var9 = var3;
            if (var3 != 69) {
               break label86;
            }
         }

         if (var1 >= var12) {
            this.d = var2;
            return this.b(var4, var2);
         }

         char[] var26 = this.N;
         int var23 = var1 + 1;
         char var20 = var26[var1];
         if (var20 != '-' && var20 != '+') {
            var1 = var23;
            var23 = var11;
         } else {
            if (var23 >= var12) {
               this.d = var2;
               return this.b(var4, var2);
            }

            var26 = this.N;
            var1 = var23 + 1;
            var20 = var26[var23];
            var23 = var11;
         }

         while (var20 <= '9' && var20 >= '0') {
            var23++;
            if (var1 >= var12) {
               this.d = var2;
               return this.b(var4, var2);
            }

            var20 = this.N[var1];
            var1++;
         }

         var8 = var23;
         var10 = var1;
         var9 = var20;
         if (var23 == 0) {
            this.a(var20, "Exponent indicator not followed by a digit");
            var9 = var20;
            var10 = var1;
            var8 = var23;
         }
      }

      var1 = var10 - 1;
      this.d = var1;
      if (this.l.b()) {
         this.h(var9);
      }

      this.n.a(this.N, var2, var1 - var2);
      return this.b(var4, var5, var7, var8);
   }

   private String a(int var1, int var2, int var3) throws IOException {
      this.n.a(this.N, var1, this.d - var1);
      char[] var7 = this.n.j();
      var1 = this.n.l();

      while (true) {
         if (this.d >= this.e && !this.p()) {
            this.c(": was expecting closing '" + (char)var3 + "' for name");
         }

         char[] var8 = this.N;
         int var6 = this.d++;
         char var5 = var8[var6];
         char var4 = var5;
         if (var5 <= '\\') {
            if (var5 == '\\') {
               var4 = this.D();
            } else {
               var4 = var5;
               if (var5 <= var3) {
                  if (var5 == var3) {
                     this.n.a(var1);
                     TextBuffer var13 = this.n;
                     var8 = var13.e();
                     var1 = var13.d();
                     var3 = var13.c();
                     return this.Q.a(var8, var1, var3, var2);
                  }

                  var4 = var5;
                  if (var5 < ' ') {
                     this.c(var5, "name");
                     var4 = var5;
                  }
               }
            }
         }

         var2 = var2 * 33 + var4;
         var6 = var1 + 1;
         var7[var1] = var4;
         if (var6 >= var7.length) {
            var7 = this.n.m();
            var1 = 0;
         } else {
            var1 = var6;
         }
      }
   }

   private String a(int var1, int var2, int[] var3) throws IOException {
      this.n.a(this.N, var1, this.d - var1);
      char[] var7 = this.n.j();
      var1 = this.n.l();
      int var6 = var3.length;

      while (this.d < this.e || this.p()) {
         char var4 = this.N[this.d];
         if (var4 <= var6 ? var3[var4] != 0 : !Character.isJavaIdentifierPart(var4)) {
            break;
         }

         this.d++;
         var2 = var2 * 33 + var4;
         int var5 = var1 + 1;
         var7[var1] = var4;
         if (var5 >= var7.length) {
            var7 = this.n.m();
            var1 = 0;
         } else {
            var1 = var5;
         }
      }

      this.n.a(var1);
      TextBuffer var10 = this.n;
      var7 = var10.e();
      var1 = var10.d();
      int var11 = var10.c();
      return this.Q.a(var7, var1, var11, var2);
   }

   private final void aa() throws IOException {
      int var1 = this.d;
      if (var1 + 4 < this.e) {
         char[] var3 = this.N;
         if (var3[var1] == 'a') {
            if (var3[++var1] == 'l') {
               if (var3[++var1] == 's') {
                  if (var3[++var1] == 'e') {
                     int var2 = var1 + 1;
                     char var7 = var3[var2];
                     if (var7 < '0' || var7 == ']' || var7 == '}') {
                        this.d = var2;
                        return;
                     }
                  }
               }
            }
         }
      }

      this.a("false", 1);
   }

   private final void ab() throws IOException {
      int var1 = this.d;
      if (var1 + 3 < this.e) {
         char[] var3 = this.N;
         if (var3[var1] == 'u') {
            if (var3[++var1] == 'l') {
               if (var3[++var1] == 'l') {
                  char var2 = var3[++var1];
                  if (var2 < '0' || var2 == ']' || var2 == '}') {
                     this.d = var1;
                     return;
                  }
               }
            }
         }
      }

      this.a("null", 1);
   }

   private final JsonToken b(boolean var1, int var2) throws IOException {
      int var5 = var2;
      if (var1) {
         var5 = var2 + 1;
      }

      this.d = var5;
      char[] var14 = this.n.k();
      if (var1) {
         var2 = 1;
         var14[0] = '-';
      } else {
         var2 = 0;
      }

      var5 = 0;
      char var3;
      if (this.d < this.e) {
         char[] var13 = this.N;
         int var6 = this.d++;
         var3 = var13[var6];
      } else {
         var3 = this.e("No digit following minus sign");
      }

      char var4 = var3;
      if (var3 == '0') {
         var4 = this.P();
      }

      int var8 = 0;
      var3 = var4;

      int var36;
      char[] var46;
      while (true) {
         if (var3 < '0' || var3 > '9') {
            var36 = var5;
            var46 = var14;
            var5 = var2;
            var17 = (boolean)var8;
            break;
         }

         int var27 = var5 + 1;
         var36 = var2;
         var46 = var14;
         if (var2 >= var14.length) {
            var46 = this.n.m();
            var36 = 0;
         }

         var5 = var36 + 1;
         var46[var36] = var3;
         if (this.d >= this.e && !this.p()) {
            var17 = true;
            var3 = '\u0000';
            var36 = var27;
            break;
         }

         var14 = this.N;
         var2 = this.d++;
         var3 = var14[var2];
         var2 = var5;
         var14 = var46;
         var5 = var27;
      }

      JsonToken var47;
      if (var36 == 0) {
         var47 = this.a(var3, var1);
      } else {
         int var28 = 0;
         boolean var26;
         if (var3 != '.') {
            var8 = 0;
            boolean var30 = var17;
            var2 = var5;
            var14 = var46;
            var26 = var30;
         } else {
            var8 = var5 + 1;
            var46[var5] = var3;
            var26 = var8;

            while (true) {
               if (this.d >= this.e && !this.p()) {
                  var17 = true;
                  break;
               }

               var14 = this.N;
               var8 = this.d++;
               var3 = var14[var8];
               if (var3 < '0' || var3 > '9') {
                  break;
               }

               var28++;
               if (var26 >= var46.length) {
                  var46 = this.n.m();
                  var26 = 0;
               }

               var8 = var26 + 1;
               var46[var26] = var3;
               var26 = var8;
            }

            if (var28 == 0) {
               this.a(var3, "Decimal point not followed by a digit");
            }

            var8 = var28;
            var28 = var26;
            var26 = var17;
            var14 = var46;
            var2 = var28;
         }

         int var9 = 0;
         boolean var10;
         int var11;
         char var12;
         if (var3 != 'e' && var3 != 'E') {
            var12 = var3;
            var9 = 0;
            var10 = (boolean)var26;
            var11 = var2;
         } else {
            var28 = var2;
            var46 = var14;
            if (var2 >= var14.length) {
               var46 = this.n.m();
               var28 = 0;
            }

            var2 = var28 + 1;
            var46[var28] = var3;
            if (this.d < this.e) {
               var14 = this.N;
               var28 = this.d++;
               var3 = var14[var28];
            } else {
               var3 = this.e("expected a digit for number exponent");
            }

            if (var3 != '-' && var3 != '+') {
               var28 = var9;
            } else {
               if (var2 >= var46.length) {
                  var46 = this.n.m();
                  var2 = 0;
               }

               var46[var2] = var3;
               if (this.d < this.e) {
                  var14 = this.N;
                  var28 = this.d++;
                  var3 = var14[var28];
               } else {
                  var3 = this.e("expected a digit for number exponent");
               }

               var2++;
               var28 = var9;
            }

            while (true) {
               if (var3 > '9' || var3 < '0') {
                  var9 = var2;
                  var2 = var28;
                  var28 = var9;
                  break;
               }

               var28++;
               var9 = var2;
               var14 = var46;
               if (var2 >= var46.length) {
                  var14 = this.n.m();
                  var9 = 0;
               }

               var2 = var9 + 1;
               var14[var9] = var3;
               if (this.d >= this.e && !this.p()) {
                  var9 = var28;
                  var26 = 1;
                  var28 = var2;
                  var2 = var9;
                  break;
               }

               var46 = this.N;
               var9 = this.d++;
               var3 = var46[var9];
               var46 = var14;
            }

            var9 = var2;
            var10 = (boolean)var26;
            var12 = var3;
            var11 = var28;
            if (var2 == 0) {
               this.a(var3, "Exponent indicator not followed by a digit");
               var11 = var28;
               var12 = var3;
               var10 = (boolean)var26;
               var9 = var2;
            }
         }

         if (!var10) {
            this.d--;
            if (this.l.b()) {
               this.h(var12);
            }
         }

         this.n.a(var11);
         var47 = this.a(var1, var36, var8, var9);
      }

      return var47;
   }

   private final void h(int var1) throws IOException {
      this.d++;
      switch (var1) {
         case 9:
         case 32:
            break;
         case 10:
            this.g++;
            this.h = this.d;
            break;
         case 13:
            this.N();
            break;
         default:
            this.b(var1);
      }
   }

   private final int i(int var1) throws IOException {
      if (var1 != 44) {
         this.b(var1, "was expecting comma to separate " + this.l.d() + " entries");
      }

      while (true) {
         if (this.d >= this.e) {
            var1 = this.S();
            break;
         }

         char[] var3 = this.N;
         var1 = this.d++;
         char var2 = var3[var1];
         if (var2 > ' ') {
            if (var2 != '/') {
               var1 = var2;
               if (var2 != '#') {
                  break;
               }
            }

            this.d--;
            var1 = this.S();
            break;
         }

         if (var2 < ' ') {
            if (var2 == '\n') {
               this.g++;
               this.h = this.d;
            } else if (var2 == '\r') {
               this.N();
            } else if (var2 != '\t') {
               this.c(var2);
            }
         }
      }

      return var1;
   }

   @Override
   protected char D() throws IOException {
      int var4 = 0;
      if (this.d >= this.e && !this.p()) {
         this.c(" in character escape sequence");
      }

      char[] var7 = this.N;
      int var3 = this.d++;
      char var2 = var7[var3];
      char var1 = var2;
      switch (var2) {
         case '"':
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
            for (int var8 = 0; var8 < 4; var8++) {
               if (this.d >= this.e && !this.p()) {
                  this.c(" in character escape sequence");
               }

               var7 = this.N;
               int var5 = this.d++;
               char var6 = var7[var5];
               var5 = CharTypes.a(var6);
               if (var5 < 0) {
                  this.b(var6, "expected a hex-digit for character escape sequence");
               }

               var4 = var4 << 4 | var5;
            }

            var1 = (char)var4;
            break;
         default:
            var1 = this.a(var2);
      }

      return var1;
   }

   protected final JsonToken H() throws IOException {
      int var1 = this.d;
      int var4 = var1 - 1;
      int var5 = this.e;
      JsonToken var6;
      if (var1 >= var5) {
         var6 = this.b(true, var4);
      } else {
         char[] var11 = this.N;
         int var2 = var1 + 1;
         int var7 = var11[var1];
         if (var7 > 57 || var7 < 48) {
            this.d = var2;
            var6 = this.a(var7, true);
         } else if (var7 == 48) {
            var6 = this.b(true, var4);
         } else {
            var7 = 1;

            while (true) {
               if (var2 >= var5) {
                  var6 = this.b(true, var4);
                  break;
               }

               char[] var12 = this.N;
               int var3 = var2 + 1;
               char var9 = var12[var2];
               if (var9 < '0' || var9 > '9') {
                  if (var9 != '.' && var9 != 'e' && var9 != 'E') {
                     this.d = --var3;
                     if (this.l.b()) {
                        this.h(var9);
                     }

                     this.n.a(this.N, var4, var3 - var4);
                     var6 = this.a(true, var7);
                  } else {
                     this.d = var3;
                     var6 = this.a(var9, var4, var3, true, var7);
                  }
                  break;
               }

               var7++;
               var2 = var3;
            }
         }
      }

      return var6;
   }

   protected final String I() throws IOException {
      int var1 = this.d;
      int var2 = this.R;
      int[] var4 = L;

      while (true) {
         if (var1 < this.e) {
            int var3 = this.N[var1];
            if (var3 >= var4.length || var4[var3] == 0) {
               var2 = var2 * 33 + var3;
               var1++;
               continue;
            }

            if (var3 == 34) {
               var3 = this.d;
               this.d = var1 + 1;
               var7 = this.Q.a(this.N, var3, var1 - var3, var2);
               break;
            }
         }

         int var5 = this.d;
         this.d = var1;
         var7 = this.a(var5, var2, 34);
         break;
      }

      return var7;
   }

   protected String J() throws IOException {
      int var4 = this.d;
      int var3 = this.R;
      int var5 = this.e;
      int var2 = var3;
      int var1 = var4;
      if (var4 < var5) {
         int[] var7 = L;
         int var6 = var7.length;
         var1 = var4;
         var2 = var3;

         while (true) {
            int var8 = this.N[var1];
            if (var8 == 39) {
               var8 = this.d;
               this.d = var1 + 1;
               return this.Q.a(this.N, var8, var1 - var8, var2);
            }

            if (var8 < var6 && var7[var8] != 0) {
               break;
            }

            var4 = var2 * 33 + var8;
            var8 = var1 + 1;
            var2 = var4;
            var1 = var8;
            if (var8 >= var5) {
               var2 = var4;
               var1 = var8;
               break;
            }
         }
      }

      var3 = this.d;
      this.d = var1;
      return this.a(var3, var2, 39);
   }

   protected JsonToken K() throws IOException {
      char[] var5 = this.n.k();
      int var3 = this.n.l();

      while (true) {
         if (this.d >= this.e && !this.p()) {
            this.c(": was expecting closing quote for a string value");
         }

         char[] var6 = this.N;
         int var4 = this.d++;
         char var2 = var6[var4];
         char var1 = var2;
         if (var2 <= '\\') {
            if (var2 == '\\') {
               var1 = this.D();
            } else {
               var1 = var2;
               if (var2 <= '\'') {
                  if (var2 == '\'') {
                     this.n.a(var3);
                     return JsonToken.VALUE_STRING;
                  }

                  var1 = var2;
                  if (var2 < ' ') {
                     this.c(var2, "string value");
                     var1 = var2;
                  }
               }
            }
         }

         if (var3 >= var5.length) {
            var5 = this.n.m();
            var3 = 0;
         }

         var4 = var3 + 1;
         var5[var3] = var1;
         var3 = var4;
      }
   }

   protected void L() throws IOException {
      char[] var6 = this.n.j();
      int var3 = this.n.l();
      int[] var7 = L;
      int var5 = var7.length;

      while (true) {
         if (this.d >= this.e && !this.p()) {
            this.c(": was expecting closing quote for a string value");
         }

         char[] var8 = this.N;
         int var4 = this.d++;
         char var2 = var8[var4];
         char var1 = var2;
         if (var2 < var5) {
            var1 = var2;
            if (var7[var2] != 0) {
               if (var2 == '"') {
                  this.n.a(var3);
                  return;
               }

               if (var2 == '\\') {
                  var1 = this.D();
               } else {
                  var1 = var2;
                  if (var2 < ' ') {
                     this.c(var2, "string value");
                     var1 = var2;
                  }
               }
            }
         }

         if (var3 >= var6.length) {
            var6 = this.n.m();
            var3 = 0;
         }

         var4 = var3 + 1;
         var6[var3] = var1;
         var3 = var4;
      }
   }

   protected final void M() throws IOException {
      this.S = false;
      int var1 = this.d;
      int var2 = this.e;
      char[] var5 = this.N;

      while (true) {
         int var3 = var2;
         int var4 = var1;
         if (var1 >= var2) {
            this.d = var1;
            if (!this.p()) {
               this.c(": was expecting closing quote for a string value");
            }

            var4 = this.d;
            var3 = this.e;
         }

         var1 = var4 + 1;
         char var6 = var5[var4];
         if (var6 <= '\\') {
            if (var6 == '\\') {
               this.d = var1;
               this.D();
               var1 = this.d;
               var2 = this.e;
               continue;
            }

            if (var6 <= '"') {
               if (var6 == '"') {
                  this.d = var1;
                  return;
               }

               if (var6 < ' ') {
                  this.d = var1;
                  this.c(var6, "string value");
               }
            }
         }

         var2 = var3;
      }
   }

   protected final void N() throws IOException {
      if ((this.d < this.e || this.p()) && this.N[this.d] == '\n') {
         this.d++;
      }

      this.g++;
      this.h = this.d;
   }

   @Override
   public final JsonToken a() throws IOException {
      this.A = 0;
      JsonToken var4;
      if (this.K == JsonToken.FIELD_NAME) {
         var4 = this.O();
      } else {
         if (this.S) {
            this.M();
         }

         int var2 = this.T();
         if (var2 < 0) {
            this.close();
            this.K = null;
            var4 = null;
         } else {
            this.i = this.f + this.d - 1L;
            this.j = this.g;
            this.k = this.d - this.h - 1;
            this.r = null;
            if (var2 == 93) {
               if (!this.l.a()) {
                  this.a(var2, '}');
               }

               this.l = this.l.h();
               var4 = JsonToken.END_ARRAY;
               this.K = var4;
            } else if (var2 == 125) {
               if (!this.l.c()) {
                  this.a(var2, ']');
               }

               this.l = this.l.h();
               var4 = JsonToken.END_OBJECT;
               this.K = var4;
            } else {
               int var1 = var2;
               if (this.l.i()) {
                  var1 = this.i(var2);
               }

               boolean var3 = this.l.c();
               var2 = var1;
               if (var3) {
                  String var6;
                  if (var1 == 34) {
                     var6 = this.I();
                  } else {
                     var6 = this.f(var1);
                  }

                  this.l.a(var6);
                  this.K = JsonToken.FIELD_NAME;
                  var2 = this.R();
               }

               switch (var2) {
                  case 34:
                     this.S = true;
                     var4 = JsonToken.VALUE_STRING;
                     break;
                  case 45:
                     var4 = this.H();
                     break;
                  case 48:
                  case 49:
                  case 50:
                  case 51:
                  case 52:
                  case 53:
                  case 54:
                  case 55:
                  case 56:
                  case 57:
                     var4 = this.e(var2);
                     break;
                  case 91:
                     if (!var3) {
                        this.l = this.l.a(this.j, this.k);
                     }

                     var4 = JsonToken.START_ARRAY;
                     break;
                  case 93:
                  case 125:
                     this.b(var2, "expected a value");
                  case 116:
                     this.Z();
                     var4 = JsonToken.VALUE_TRUE;
                     break;
                  case 102:
                     this.aa();
                     var4 = JsonToken.VALUE_FALSE;
                     break;
                  case 110:
                     this.ab();
                     var4 = JsonToken.VALUE_NULL;
                     break;
                  case 123:
                     if (!var3) {
                        this.l = this.l.b(this.j, this.k);
                     }

                     var4 = JsonToken.START_OBJECT;
                     break;
                  default:
                     var4 = this.g(var2);
               }

               if (var3) {
                  this.m = var4;
                  var4 = this.K;
               } else {
                  this.K = var4;
               }
            }
         }
      }

      return var4;
   }

   protected JsonToken a(int var1, boolean var2) throws IOException {
      double var3 = Double.NEGATIVE_INFINITY;
      int var5 = var1;
      if (var1 == 73) {
         if (this.d >= this.e && !this.p()) {
            this.F();
         }

         char[] var6 = this.N;
         var1 = this.d++;
         char var8 = var6[var1];
         if (var8 == 'N') {
            String var9;
            if (var2) {
               var9 = "-INF";
            } else {
               var9 = "+INF";
            }

            this.a(var9, 3);
            if (this.a(JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS)) {
               if (!var2) {
                  var3 = Double.POSITIVE_INFINITY;
               }

               return this.a(var9, var3);
            }

            this.d("Non-standard token '" + var9 + "': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
            var5 = var8;
         } else {
            var5 = var8;
            if (var8 == 'n') {
               String var11;
               if (var2) {
                  var11 = "-Infinity";
               } else {
                  var11 = "+Infinity";
               }

               this.a(var11, 3);
               if (this.a(JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS)) {
                  if (!var2) {
                     var3 = Double.POSITIVE_INFINITY;
                  }

                  return this.a(var11, var3);
               }

               this.d("Non-standard token '" + var11 + "': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
               var5 = var8;
            }
         }
      }

      this.a(var5, "expected digit (0-9) to follow minus sign, for valid numeric value");
      return null;
   }

   protected final String a(JsonToken var1) {
      String var2;
      if (var1 == null) {
         var2 = null;
      } else {
         switch (var1.id()) {
            case 5:
               var2 = this.l.g();
               break;
            case 6:
            case 7:
            case 8:
               var2 = this.n.f();
               break;
            default:
               var2 = var1.asString();
         }
      }

      return var2;
   }

   protected final void a(String var1, int var2) throws IOException {
      int var5 = var1.length();

      int var4;
      do {
         if (this.d >= this.e && !this.p()) {
            this.f(var1.substring(0, var2));
         }

         if (this.N[this.d] != var1.charAt(var2)) {
            this.f(var1.substring(0, var2));
         }

         this.d++;
         var4 = var2 + 1;
         var2 = var4;
      } while (var4 < var5);

      if (this.d < this.e || this.p()) {
         char var3 = this.N[this.d];
         if (var3 >= '0' && var3 != ']' && var3 != '}' && Character.isJavaIdentifierPart(var3)) {
            this.f(var1.substring(0, var4));
         }
      }
   }

   protected void a(String var1, String var2) throws IOException {
      StringBuilder var4 = new StringBuilder(var1);

      while (this.d < this.e || this.p()) {
         char var3 = this.N[this.d];
         if (!Character.isJavaIdentifierPart(var3)) {
            break;
         }

         this.d++;
         var4.append(var3);
      }

      this.d("Unrecognized token '" + var4.toString() + "': was expecting " + var2);
   }

   protected char e(String var1) throws IOException {
      if (this.d >= this.e && !this.p()) {
         this.c(var1);
      }

      char[] var3 = this.N;
      int var2 = this.d++;
      return var3[var2];
   }

   protected final JsonToken e(int var1) throws IOException {
      int var2 = this.d;
      int var4 = var2 - 1;
      int var5 = this.e;
      JsonToken var6;
      if (var1 == 48) {
         var6 = this.b(false, var4);
      } else {
         var1 = 1;

         while (true) {
            if (var2 >= var5) {
               this.d = var4;
               var6 = this.b(false, var4);
               break;
            }

            char[] var10 = this.N;
            int var3 = var2 + 1;
            char var8 = var10[var2];
            if (var8 < '0' || var8 > '9') {
               if (var8 != '.' && var8 != 'e' && var8 != 'E') {
                  this.d = --var3;
                  if (this.l.b()) {
                     this.h(var8);
                  }

                  this.n.a(this.N, var4, var3 - var4);
                  var6 = this.a(false, var1);
               } else {
                  this.d = var3;
                  var6 = this.a(var8, var4, var3, false, var1);
               }
               break;
            }

            var1++;
            var2 = var3;
         }
      }

      return var6;
   }

   @Override
   public final String f() throws IOException {
      JsonToken var1 = this.K;
      String var2;
      if (var1 == JsonToken.VALUE_STRING) {
         if (this.S) {
            this.S = false;
            this.q();
         }

         var2 = this.n.f();
      } else {
         var2 = this.a(var1);
      }

      return var2;
   }

   protected String f(int var1) throws IOException {
      String var18;
      if (var1 == 39 && this.a(JsonParser.Feature.ALLOW_SINGLE_QUOTES)) {
         var18 = this.J();
      } else {
         if (!this.a(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES)) {
            this.b(var1, "was expecting double-quote to start field name");
         }

         int[] var8 = CharTypes.c();
         int var5 = var8.length;
         boolean var7;
         if (var1 < var5) {
            if (var8[var1] == 0) {
               var7 = true;
            } else {
               var7 = false;
            }
         } else {
            var7 = Character.isJavaIdentifierPart((char)var1);
         }

         if (!var7) {
            this.b(var1, "was expecting either valid name character (for unquoted name) or double-quote (for quoted) to start field name");
         }

         int var4 = this.d;
         int var3 = this.R;
         int var6 = this.e;
         int var2 = var3;
         var1 = var4;
         if (var4 < var6) {
            var1 = var4;
            var2 = var3;

            do {
               int var12 = this.N[var1];
               if (var12 < var5) {
                  if (var8[var12] != 0) {
                     var12 = this.d - 1;
                     this.d = var1;
                     return this.Q.a(this.N, var12, var1 - var12, var2);
                  }
               } else if (!Character.isJavaIdentifierPart((char)var12)) {
                  var12 = this.d - 1;
                  this.d = var1;
                  var18 = this.Q.a(this.N, var12, var1 - var12, var2);
                  return var18;
               }

               var3 = var2 * 33 + var12;
               var4 = var1 + 1;
               var2 = var3;
               var1 = var4;
            } while (var4 < var6);

            var1 = var4;
            var2 = var3;
         }

         var3 = this.d;
         this.d = var1;
         var18 = this.a(var3 - 1, var2, var8);
      }

      return var18;
   }

   protected void f(String var1) throws IOException {
      this.a(var1, "'null', 'true', 'false' or NaN");
   }

   protected JsonToken g(int var1) throws IOException {
      switch (var1) {
         case 39:
            if (this.a(JsonParser.Feature.ALLOW_SINGLE_QUOTES)) {
               return this.K();
            }
            break;
         case 43:
            if (this.d >= this.e && !this.p()) {
               this.F();
            }

            char[] var4 = this.N;
            var1 = this.d++;
            return this.a(var4[var1], false);
         case 73:
            this.a("Infinity", 1);
            if (this.a(JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS)) {
               return this.a("Infinity", Double.POSITIVE_INFINITY);
            }

            this.d("Non-standard token 'Infinity': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
            break;
         case 78:
            this.a("NaN", 1);
            if (this.a(JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS)) {
               return this.a("NaN", Double.NaN);
            }

            this.d("Non-standard token 'NaN': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
      }

      if (Character.isJavaIdentifierStart(var1)) {
         this.a("" + (char)var1, "('true', 'false' or 'null')");
      }

      this.b(var1, "expected a valid value (number, String, array, object, 'true', 'false' or 'null')");
      return null;
   }

   @Override
   protected boolean p() throws IOException {
      boolean var3 = false;
      this.f = this.f + this.e;
      this.h = this.h - this.e;
      boolean var2 = var3;
      if (this.M != null) {
         int var1 = this.M.read(this.N, 0, this.N.length);
         if (var1 > 0) {
            this.d = 0;
            this.e = var1;
            var2 = true;
         } else {
            this.r();
            var2 = var3;
            if (var1 == 0) {
               throw new IOException("Reader returned 0 characters when trying to read " + this.e);
            }
         }
      }

      return var2;
   }

   @Override
   protected final void q() throws IOException {
      int var1 = this.d;
      int var3 = this.e;
      int var2 = var1;
      if (var1 < var3) {
         int[] var6 = L;
         int var4 = var6.length;

         do {
            char var5 = this.N[var1];
            if (var5 < var4 && var6[var5] != 0) {
               var2 = var1;
               if (var5 == '"') {
                  this.n.a(this.N, this.d, var1 - this.d);
                  this.d = var1 + 1;
                  return;
               }
               break;
            }

            var2 = var1 + 1;
            var1 = var2;
         } while (var2 < var3);
      }

      this.n.b(this.N, this.d, var2 - this.d);
      this.d = var2;
      this.L();
   }

   @Override
   protected void r() throws IOException {
      if (this.M != null) {
         if (this.b.c() || this.a(JsonParser.Feature.AUTO_CLOSE_SOURCE)) {
            this.M.close();
         }

         this.M = null;
      }
   }

   @Override
   protected void s() throws IOException {
      super.s();
      this.Q.b();
      if (this.O) {
         char[] var1 = this.N;
         if (var1 != null) {
            this.N = null;
            this.b.a(var1);
         }
      }
   }
}
