package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.base.ParserBase;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class UTF8StreamJsonParser extends ParserBase {
   protected static final int[] L = CharTypes.a();
   private static final int[] T = CharTypes.b();
   protected ObjectCodec M;
   protected final ByteQuadsCanonicalizer N;
   protected int[] O = new int[16];
   protected boolean P = false;
   protected InputStream Q;
   protected byte[] R;
   protected boolean S;
   private int U;

   public UTF8StreamJsonParser(
      IOContext var1, int var2, InputStream var3, ObjectCodec var4, ByteQuadsCanonicalizer var5, byte[] var6, int var7, int var8, boolean var9
   ) {
      super(var1, var2);
      this.Q = var3;
      this.M = var4;
      this.N = var5;
      this.R = var6;
      this.d = var7;
      this.e = var8;
      this.h = var7;
      this.f = -var7;
      this.S = var9;
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

   private final int P() throws IOException {
      int var1;
      if (this.d >= this.e && !this.p()) {
         var1 = 48;
      } else {
         int var2 = this.R[this.d] & 255;
         if (var2 >= 48 && var2 <= 57) {
            if (!this.a(JsonParser.Feature.ALLOW_NUMERIC_LEADING_ZEROS)) {
               this.b("Leading zeroes not allowed");
            }

            this.d++;
            var1 = var2;
            if (var2 == 48) {
               var1 = var2;

               while (this.d < this.e || this.p()) {
                  var2 = this.R[this.d] & 255;
                  if (var2 < 48 || var2 > 57) {
                     var1 = 48;
                     break;
                  }

                  this.d++;
                  var1 = var2;
                  if (var2 != 48) {
                     var1 = var2;
                     break;
                  }
               }
            }
         } else {
            var1 = 48;
         }
      }

      return var1;
   }

   private final int Q() throws IOException {
      while (true) {
         int var5;
         if (this.d < this.e) {
            byte[] var3 = this.R;
            var5 = this.d++;
            int var2 = var3[var5] & 255;
            if (var2 <= 32) {
               if (var2 == 32) {
                  continue;
               }

               if (var2 == 10) {
                  this.g++;
                  this.h = this.d;
                  continue;
               }

               if (var2 == 13) {
                  this.N();
                  continue;
               }

               if (var2 != 9) {
                  this.c(var2);
               }
               continue;
            }

            if (var2 != 47) {
               var5 = var2;
               if (var2 != 35) {
                  return var5;
               }
            }

            this.d--;
            var5 = this.R();
         } else {
            var5 = this.R();
         }

         return var5;
      }
   }

   private final int R() throws IOException {
      while (this.d < this.e || this.p()) {
         byte[] var2 = this.R;
         int var1 = this.d++;
         var1 = var2[var1] & 255;
         if (var1 > 32) {
            if (var1 == 47) {
               this.V();
            } else if (var1 != 35 || !this.X()) {
               return var1;
            }
         } else if (var1 != 32) {
            if (var1 == 10) {
               this.g++;
               this.h = this.d;
            } else if (var1 == 13) {
               this.N();
            } else if (var1 != 9) {
               this.c(var1);
            }
         }
      }

      throw this.a("Unexpected end-of-input within/between " + this.l.d() + " entries");
   }

   private final int S() throws IOException {
      int var8;
      if (this.d >= this.e && !this.p()) {
         var8 = this.u();
      } else {
         byte[] var3 = this.R;
         var8 = this.d++;
         int var2 = var3[var8] & 255;
         if (var2 > 32) {
            if (var2 != 47) {
               var8 = var2;
               if (var2 != 35) {
                  return var8;
               }
            }

            this.d--;
            var8 = this.T();
         } else {
            if (var2 != 32) {
               if (var2 == 10) {
                  this.g++;
                  this.h = this.d;
               } else if (var2 == 13) {
                  this.N();
               } else if (var2 != 9) {
                  this.c(var2);
               }
            }

            while (true) {
               if (this.d >= this.e) {
                  var8 = this.T();
                  break;
               }

               var3 = this.R;
               var8 = this.d++;
               var2 = var3[var8] & 255;
               if (var2 > 32) {
                  if (var2 != 47) {
                     var8 = var2;
                     if (var2 != 35) {
                        break;
                     }
                  }

                  this.d--;
                  var8 = this.T();
                  break;
               }

               if (var2 != 32) {
                  if (var2 == 10) {
                     this.g++;
                     this.h = this.d;
                  } else if (var2 == 13) {
                     this.N();
                  } else if (var2 != 9) {
                     this.c(var2);
                  }
               }
            }
         }
      }

      return var8;
   }

   private final int T() throws IOException {
      int var4;
      while (true) {
         if (this.d >= this.e && !this.p()) {
            var4 = this.u();
            break;
         }

         byte[] var3 = this.R;
         var4 = this.d++;
         int var2 = var3[var4] & 255;
         if (var2 <= 32) {
            if (var2 != 32) {
               if (var2 == 10) {
                  this.g++;
                  this.h = this.d;
               } else if (var2 == 13) {
                  this.N();
               } else if (var2 != 9) {
                  this.c(var2);
               }
            }
         } else if (var2 == 47) {
            this.V();
         } else {
            var4 = var2;
            if (var2 == 35) {
               if (this.X()) {
                  continue;
               }

               var4 = var2;
            }
            break;
         }
      }

      return var4;
   }

   private final int U() throws IOException {
      int var1;
      if (this.d + 4 >= this.e) {
         var1 = this.a(false);
      } else {
         byte var2 = this.R[this.d];
         if (var2 == 58) {
            byte[] var3 = this.R;
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
                  var3 = this.R;
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
               if (var2 != 32) {
                  var6 = var2;
                  if (var2 != 9) {
                     break label59;
                  }
               }

               byte[] var11 = this.R;
               var1 = this.d + 1;
               this.d = var1;
               var6 = var11[var1];
            }

            if (var6 == 58) {
               byte[] var12 = this.R;
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
                     var12 = this.R;
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

   private final void V() throws IOException {
      if (!this.a(JsonParser.Feature.ALLOW_COMMENTS)) {
         this.b(47, "maybe a (non-standard) comment? (not recognized as one since Feature 'ALLOW_COMMENTS' not enabled for parser)");
      }

      if (this.d >= this.e && !this.p()) {
         this.c(" in a comment");
      }

      byte[] var2 = this.R;
      int var1 = this.d++;
      var1 = var2[var1] & 255;
      if (var1 == 47) {
         this.Y();
      } else if (var1 == 42) {
         this.W();
      } else {
         this.b(var1, "was expecting either '*' or '/' for a comment");
      }
   }

   private final void W() throws IOException {
      int[] var3 = CharTypes.e();

      label36:
      while (this.d < this.e || this.p()) {
         byte[] var4 = this.R;
         int var1 = this.d++;
         var1 = var4[var1] & 255;
         int var2 = var3[var1];
         if (var2 != 0) {
            switch (var2) {
               case 2:
                  this.t(var1);
                  break;
               case 3:
                  this.u(var1);
                  break;
               case 4:
                  this.v(var1);
                  break;
               case 10:
                  this.g++;
                  this.h = this.d;
                  break;
               case 13:
                  this.N();
                  break;
               case 42:
                  if (this.d >= this.e && !this.p()) {
                     break label36;
                  }

                  if (this.R[this.d] == 47) {
                     this.d++;
                     return;
                  }
                  break;
               default:
                  this.k(var1);
            }
         }
      }

      this.c(" in a comment");
   }

   private final boolean X() throws IOException {
      boolean var1;
      if (!this.a(JsonParser.Feature.ALLOW_YAML_COMMENTS)) {
         var1 = false;
      } else {
         this.Y();
         var1 = true;
      }

      return var1;
   }

   private final void Y() throws IOException {
      int[] var4 = CharTypes.e();

      while (this.d < this.e || this.p()) {
         byte[] var3 = this.R;
         int var1 = this.d++;
         var1 = var3[var1] & 255;
         int var2 = var4[var1];
         if (var2 != 0) {
            switch (var2) {
               case 2:
                  this.t(var1);
                  break;
               case 3:
                  this.u(var1);
                  break;
               case 4:
                  this.v(var1);
                  break;
               case 10:
                  this.g++;
                  this.h = this.d;
                  return;
               case 13:
                  this.N();
                  return;
               case 42:
                  break;
               default:
                  if (var2 < 0) {
                     this.k(var1);
                  }
            }
         }
      }
   }

   private int Z() throws IOException {
      if (this.d >= this.e) {
         this.o();
      }

      byte[] var2 = this.R;
      int var1 = this.d++;
      return var2[var1] & 0xFF;
   }

   private final int a(boolean var1) throws IOException {
      while (this.d < this.e || this.p()) {
         byte[] var3 = this.R;
         int var2 = this.d++;
         var2 = var3[var2] & 255;
         if (var2 > 32) {
            if (var2 == 47) {
               this.V();
            } else if (var2 != 35 || !this.X()) {
               if (var1) {
                  return var2;
               }

               if (var2 != 58) {
                  if (var2 < 32) {
                     this.c(var2);
                  }

                  this.b(var2, "was expecting a colon to separate field name and value");
               }

               var1 = true;
            }
         } else if (var2 != 32) {
            if (var2 == 10) {
               this.g++;
               this.h = this.d;
            } else if (var2 == 13) {
               this.N();
            } else if (var2 != 9) {
               this.c(var2);
            }
         }
      }

      throw this.a("Unexpected end-of-input within/between " + this.l.d() + " entries");
   }

   private final JsonToken a(char[] var1, int var2, int var3, boolean var4, int var5) throws IOException {
      int var6 = 0;
      int var9 = 0;
      int var7 = 0;
      boolean var19;
      int var30;
      char[] var36;
      if (var3 == 46) {
         var30 = var2 + 1;
         var1[var2] = (char)var3;
         var2 = var30;

         while (true) {
            if (this.d >= this.e && !this.p()) {
               var7 = 1;
               break;
            }

            byte[] var13 = this.R;
            var19 = this.d++;
            var3 = var13[var19] & 255;
            if (var3 < 48 || var3 > 57) {
               break;
            }

            var6++;
            if (var2 >= var1.length) {
               var1 = this.n.m();
               var2 = 0;
            }

            var30 = var2 + 1;
            var1[var2] = (char)var3;
            var2 = var30;
         }

         if (var6 == 0) {
            this.a(var3, "Decimal point not followed by a digit");
         }

         var30 = var6;
         var6 = var3;
         var19 = var7;
         var36 = var1;
      } else {
         var30 = 0;
         var6 = var3;
         var36 = var1;
         var19 = var9;
      }

      var9 = (byte)0;
      boolean var10;
      int var11;
      int var12;
      if (var6 != 101 && var6 != 69) {
         var9 = 0;
         var10 = (boolean)var19;
         var11 = var6;
         var12 = var2;
      } else {
         var7 = var2;
         var1 = var36;
         if (var2 >= var36.length) {
            var1 = this.n.m();
            var7 = 0;
         }

         var2 = var7 + 1;
         var1[var7] = (char)var6;
         if (this.d >= this.e) {
            this.o();
         }

         byte[] var37 = this.R;
         var6 = this.d++;
         var6 = var37[var6] & 255;
         if (var6 != 45 && var6 != 43) {
            var7 = var9;
         } else {
            if (var2 >= var1.length) {
               var1 = this.n.m();
               var2 = 0;
            }

            var1[var2] = (char)var6;
            if (this.d >= this.e) {
               this.o();
            }

            byte[] var38 = this.R;
            var6 = this.d++;
            var6 = var38[var6] & 255;
            var2++;
            var7 = var9;
         }

         label84: {
            while (var6 <= 57 && var6 >= 48) {
               var7++;
               var9 = var2;
               var36 = var1;
               if (var2 >= var1.length) {
                  var36 = this.n.m();
                  var9 = 0;
               }

               var2 = var9 + 1;
               var36[var9] = (char)var6;
               if (this.d >= this.e && !this.p()) {
                  var9 = var7;
                  var28 = true;
                  var19 = var2;
                  var2 = var9;
                  break label84;
               }

               byte[] var15 = this.R;
               var6 = this.d++;
               var6 = var15[var6] & 255;
               var1 = var36;
            }

            var9 = var2;
            var2 = var7;
            var28 = (boolean)var19;
            var19 = var9;
         }

         var9 = var2;
         var10 = var28;
         var11 = var6;
         var12 = var19;
         if (var2 == 0) {
            this.a(var6, "Exponent indicator not followed by a digit");
            var12 = var19;
            var11 = var6;
            var10 = var28;
            var9 = var2;
         }
      }

      if (!var10) {
         this.d--;
         if (this.l.b()) {
            this.o(var11);
         }
      }

      this.n.a(var12);
      return this.b(var4, var5, var30, var9);
   }

   private final JsonToken a(char[] var1, int var2, boolean var3, int var4) throws IOException {
      while (true) {
         if (this.d >= this.e && !this.p()) {
            this.n.a(var2);
            var8 = this.a(var3, var4);
            break;
         }

         byte[] var7 = this.R;
         int var5 = this.d++;
         int var6 = var7[var5] & 255;
         if (var6 > 57 || var6 < 48) {
            if (var6 != 46 && var6 != 101 && var6 != 69) {
               this.d--;
               this.n.a(var2);
               if (this.l.b()) {
                  byte[] var9 = this.R;
                  var2 = this.d++;
                  this.o(var9[var2] & 255);
               }

               var8 = this.a(var3, var4);
               break;
            }

            var8 = this.a(var1, var2, var6, var3, var4);
            break;
         }

         if (var2 >= var1.length) {
            var1 = this.n.m();
            var2 = 0;
         }

         var5 = var2 + 1;
         var1[var2] = (char)var6;
         var4++;
         var2 = var5;
      }

      return var8;
   }

   private final String a(int var1, int var2, int var3, int var4) throws IOException {
      this.O[0] = var1;
      return this.a(this.O, 1, var2, var3, var4);
   }

   private final String a(int var1, int var2, int var3, int var4, int var5) throws IOException {
      this.O[0] = var1;
      this.O[1] = var2;
      return this.a(this.O, 2, var3, var4, var5);
   }

   private final String a(int[] var1, int var2, int var3) throws JsonParseException {
      int var11 = (var2 << 2) - 4 + var3;
      int var10;
      if (var3 < 4) {
         var10 = var1[var2 - 1];
         var1[var2 - 1] = var10 << (4 - var3 << 3);
      } else {
         var10 = 0;
      }

      char[] var12 = this.n.k();
      int var7 = 0;
      int var4 = 0;

      while (var4 < var11) {
         char[] var13;
         int var17;
         int var21;
         label67: {
            var17 = var1[var4 >> 2] >> (3 - (var4 & 3) << 3) & 0xFF;
            var21 = var4 + 1;
            int var9 = var17;
            int var8 = var21;
            if (var17 > 127) {
               byte var16;
               if ((var17 & 224) == 192) {
                  var4 = var17 & 31;
                  var16 = 1;
               } else if ((var17 & 240) == 224) {
                  var4 = var17 & 15;
                  var16 = 2;
               } else if ((var17 & 248) == 240) {
                  var4 = var17 & 7;
                  var16 = 3;
               } else {
                  this.l(var17);
                  var4 = 1;
                  var16 = 1;
               }

               if (var21 + var16 > var11) {
                  this.c(" in field name");
               }

               var9 = var1[var21 >> 2] >> (3 - (var21 & 3) << 3);
               var8 = var21 + 1;
               if ((var9 & 192) != 128) {
                  this.m(var9);
               }

               var9 = var4 << 6 | var9 & 63;
               var21 = var9;
               var4 = var8;
               if (var16 > 1) {
                  var4 = var1[var8 >> 2] >> (3 - (var8 & 3) << 3);
                  var8++;
                  if ((var4 & 192) != 128) {
                     this.m(var4);
                  }

                  var9 = var9 << 6 | var4 & 63;
                  var21 = var9;
                  var4 = var8;
                  if (var16 > 2) {
                     var21 = var1[var8 >> 2] >> (3 - (var8 & 3) << 3);
                     var4 = var8 + 1;
                     if ((var21 & 192) != 128) {
                        this.m(var21 & 0xFF);
                     }

                     var21 = var9 << 6 | var21 & 63;
                  }
               }

               var9 = var21;
               var8 = var4;
               if (var16 > 2) {
                  var16 = var21 - 65536;
                  var13 = var12;
                  if (var7 >= var12.length) {
                     var13 = this.n.n();
                  }

                  var13[var7] = (char)(55296 + (var16 >> 10));
                  var21 = var7 + 1;
                  var17 = var16 & 1023 | 56320;
                  break label67;
               }
            }

            var17 = var9;
            var4 = var8;
            var21 = var7;
            var13 = var12;
         }

         var12 = var13;
         if (var21 >= var13.length) {
            var12 = this.n.n();
         }

         var7 = var21 + 1;
         var12[var21] = (char)var17;
      }

      String var27 = new String(var12, 0, var7);
      if (var3 < 4) {
         var1[var2 - 1] = var10;
      }

      return this.N.a(var27, var1, var2);
   }

   private final String a(int[] var1, int var2, int var3, int var4) throws JsonParseException {
      int[] var6 = var1;
      if (var2 >= var1.length) {
         var6 = a(var1, var1.length);
         this.O = var6;
      }

      int var5 = var2 + 1;
      var6[var2] = d(var3, var4);
      String var7 = this.N.a(var6, var5);
      String var8 = var7;
      if (var7 == null) {
         var8 = this.a(var6, var5, var4);
      }

      return var8;
   }

   private final void a(String var1, int var2, int var3) throws IOException {
      if (Character.isJavaIdentifierPart((char)this.j(var3))) {
         this.e(var1.substring(0, var2));
      }
   }

   private final void a(char[] var1, int var2) throws IOException {
      int[] var8 = T;
      byte[] var7 = this.R;
      char[] var6 = var1;

      label55:
      while (true) {
         int var3 = this.d;
         int var4 = var3;
         if (var3 >= this.e) {
            this.o();
            var4 = this.d;
         }

         var1 = var6;
         var3 = var2;
         if (var2 >= var6.length) {
            var1 = this.n.m();
            var3 = 0;
         }

         for (int var5 = Math.min(this.e, var1.length - var3 + var4); var4 < var5; var3++) {
            var2 = var4 + 1;
            var4 = var7[var4] & 255;
            if (var8[var4] != 0) {
               this.d = var2;
               if (var4 == 34) {
                  this.n.a(var3);
                  return;
               }

               switch (var8[var4]) {
                  case 1:
                     var2 = this.D();
                     break;
                  case 2:
                     var2 = this.p(var4);
                     break;
                  case 3:
                     if (this.e - this.d >= 2) {
                        var2 = this.r(var4);
                     } else {
                        var2 = this.q(var4);
                     }
                     break;
                  case 4:
                     var5 = this.s(var4);
                     var4 = var3 + 1;
                     var1[var3] = (char)(55296 | var5 >> 10);
                     var2 = var4;
                     var6 = var1;
                     if (var4 >= var1.length) {
                        var6 = this.n.m();
                        var2 = 0;
                     }

                     var3 = var2;
                     var2 = var5 & 1023 | 56320;
                     var1 = var6;
                     break;
                  default:
                     if (var4 < 32) {
                        this.c(var4, "string value");
                        var2 = var4;
                     } else {
                        this.k(var4);
                        var2 = var4;
                     }
               }

               if (var3 >= var1.length) {
                  var6 = this.n.m();
                  var3 = 0;
               } else {
                  var6 = var1;
               }

               var4 = var3 + 1;
               var6[var3] = (char)var2;
               var2 = var4;
               continue label55;
            }

            var1[var3] = (char)var4;
            var4 = var2;
         }

         this.d = var4;
         var6 = var1;
         var2 = var3;
      }
   }

   public static int[] a(int[] var0, int var1) {
      if (var0 == null) {
         var0 = new int[var1];
      } else {
         var0 = Arrays.copyOf(var0, var0.length + var1);
      }

      return var0;
   }

   private final String b(int var1, int var2, int var3) throws IOException {
      return this.a(this.O, 0, var1, var2, var3);
   }

   private final String b(int var1, int var2, int var3, int var4) throws JsonParseException {
      var3 = d(var3, var4);
      String var5 = this.N.a(var1, var2, var3);
      if (var5 == null) {
         int[] var7 = this.O;
         var7[0] = var1;
         var7[1] = var2;
         var7[2] = d(var3, var4);
         var5 = this.a(var7, 3, var4);
      }

      return var5;
   }

   private final void b(String var1, int var2) throws IOException {
      int var4 = var1.length();

      int var3;
      do {
         if (this.d >= this.e && !this.p() || this.R[this.d] != var1.charAt(var2)) {
            this.e(var1.substring(0, var2));
         }

         this.d++;
         var3 = var2 + 1;
         var2 = var3;
      } while (var3 < var4);

      if (this.d < this.e || this.p()) {
         var2 = this.R[this.d] & 255;
         if (var2 >= 48 && var2 != 93 && var2 != 125) {
            this.a(var1, var3, var2);
         }
      }
   }

   private final String c(int var1, int var2) throws JsonParseException {
      var1 = d(var1, var2);
      String var3 = this.N.c(var1);
      if (var3 == null) {
         this.O[0] = var1;
         var3 = this.a(this.O, 1, var2);
      }

      return var3;
   }

   private final String c(int var1, int var2, int var3) throws JsonParseException {
      var2 = d(var2, var3);
      String var4 = this.N.a(var1, var2);
      if (var4 == null) {
         this.O[0] = var1;
         this.O[1] = var2;
         var4 = this.a(this.O, 2, var3);
      }

      return var4;
   }

   private static final int d(int var0, int var1) {
      if (var1 != 4) {
         var0 |= -1 << (var1 << 3);
      }

      return var0;
   }

   private final JsonToken n(int var1) throws IOException {
      JsonToken var2;
      if (var1 == 34) {
         this.P = true;
         var2 = JsonToken.VALUE_STRING;
         this.K = var2;
      } else {
         switch (var1) {
            case 45:
               var2 = this.H();
               this.K = var2;
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
               var2 = this.e(var1);
               this.K = var2;
               break;
            case 91:
               this.l = this.l.a(this.j, this.k);
               var2 = JsonToken.START_ARRAY;
               this.K = var2;
               break;
            case 102:
               this.a("false", 1);
               var2 = JsonToken.VALUE_FALSE;
               this.K = var2;
               break;
            case 110:
               this.a("null", 1);
               var2 = JsonToken.VALUE_NULL;
               this.K = var2;
               break;
            case 116:
               this.a("true", 1);
               var2 = JsonToken.VALUE_TRUE;
               this.K = var2;
               break;
            case 123:
               this.l = this.l.b(this.j, this.k);
               var2 = JsonToken.START_OBJECT;
               this.K = var2;
               break;
            default:
               var2 = this.i(var1);
               this.K = var2;
         }
      }

      return var2;
   }

   private final void o(int var1) throws IOException {
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

   private final int p(int var1) throws IOException {
      if (this.d >= this.e) {
         this.o();
      }

      byte[] var3 = this.R;
      int var2 = this.d++;
      byte var4 = var3[var2];
      if ((var4 & 192) != 128) {
         this.b(var4 & 255, this.d);
      }

      return var4 & 63 | (var1 & 31) << 6;
   }

   private final int q(int var1) throws IOException {
      if (this.d >= this.e) {
         this.o();
      }

      byte[] var4 = this.R;
      int var2 = this.d++;
      byte var5 = var4[var2];
      if ((var5 & 192) != 128) {
         this.b(var5 & 255, this.d);
      }

      if (this.d >= this.e) {
         this.o();
      }

      var4 = this.R;
      int var3 = this.d++;
      byte var6 = var4[var3];
      if ((var6 & 192) != 128) {
         this.b(var6 & 255, this.d);
      }

      return ((var1 & 15) << 6 | var5 & 63) << 6 | var6 & 63;
   }

   private final int r(int var1) throws IOException {
      byte[] var4 = this.R;
      int var2 = this.d++;
      byte var5 = var4[var2];
      if ((var5 & 192) != 128) {
         this.b(var5 & 255, this.d);
      }

      var4 = this.R;
      int var3 = this.d++;
      byte var6 = var4[var3];
      if ((var6 & 192) != 128) {
         this.b(var6 & 255, this.d);
      }

      return ((var1 & 15) << 6 | var5 & 63) << 6 | var6 & 63;
   }

   private final int s(int var1) throws IOException {
      if (this.d >= this.e) {
         this.o();
      }

      byte[] var5 = this.R;
      int var2 = this.d++;
      byte var6 = var5[var2];
      if ((var6 & 192) != 128) {
         this.b(var6 & 255, this.d);
      }

      if (this.d >= this.e) {
         this.o();
      }

      var5 = this.R;
      int var3 = this.d++;
      byte var7 = var5[var3];
      if ((var7 & 192) != 128) {
         this.b(var7 & 255, this.d);
      }

      if (this.d >= this.e) {
         this.o();
      }

      var5 = this.R;
      int var4 = this.d++;
      byte var8 = var5[var4];
      if ((var8 & 192) != 128) {
         this.b(var8 & 255, this.d);
      }

      return (((var6 & 63 | (var1 & 7) << 6) << 6 | var7 & 63) << 6 | var8 & 63) - 65536;
   }

   private final void t(int var1) throws IOException {
      if (this.d >= this.e) {
         this.o();
      }

      byte[] var2 = this.R;
      var1 = this.d++;
      byte var4 = var2[var1];
      if ((var4 & 192) != 128) {
         this.b(var4 & 255, this.d);
      }
   }

   private final void u(int var1) throws IOException {
      if (this.d >= this.e) {
         this.o();
      }

      byte[] var2 = this.R;
      var1 = this.d++;
      int var4 = var2[var1];
      if ((var4 & 192) != 128) {
         this.b(var4 & 0xFF, this.d);
      }

      if (this.d >= this.e) {
         this.o();
      }

      var2 = this.R;
      var4 = this.d++;
      byte var6 = var2[var4];
      if ((var6 & 192) != 128) {
         this.b(var6 & 255, this.d);
      }
   }

   private final void v(int var1) throws IOException {
      if (this.d >= this.e) {
         this.o();
      }

      byte[] var2 = this.R;
      var1 = this.d++;
      int var4 = var2[var1];
      if ((var4 & 192) != 128) {
         this.b(var4 & 0xFF, this.d);
      }

      if (this.d >= this.e) {
         this.o();
      }

      var2 = this.R;
      var4 = this.d++;
      int var6 = var2[var4];
      if ((var6 & 192) != 128) {
         this.b(var6 & 0xFF, this.d);
      }

      if (this.d >= this.e) {
         this.o();
      }

      var2 = this.R;
      var6 = this.d++;
      byte var8 = var2[var6];
      if ((var8 & 192) != 128) {
         this.b(var8 & 255, this.d);
      }
   }

   @Override
   protected char D() throws IOException {
      int var2 = 0;
      if (this.d >= this.e && !this.p()) {
         this.c(" in character escape sequence");
      }

      byte[] var6 = this.R;
      int var3 = this.d++;
      int var7 = var6[var3];
      char var1;
      switch (var7) {
         case 34:
         case 47:
         case 92:
            var1 = (char)var7;
            break;
         case 98:
            var1 = '\b';
            break;
         case 102:
            var1 = '\f';
            break;
         case 110:
            var1 = '\n';
            break;
         case 114:
            var1 = '\r';
            break;
         case 116:
            var1 = '\t';
            break;
         case 117:
            var7 = 0;

            while (var2 < 4) {
               if (this.d >= this.e && !this.p()) {
                  this.c(" in character escape sequence");
               }

               var6 = this.R;
               int var4 = this.d++;
               byte var5 = var6[var4];
               var4 = CharTypes.a(var5);
               if (var4 < 0) {
                  this.b(var5, "expected a hex-digit for character escape sequence");
               }

               var7 = var7 << 4 | var4;
               var2++;
            }

            var1 = (char)var7;
            break;
         default:
            var1 = this.a((char)this.j(var7));
      }

      return var1;
   }

   protected JsonToken H() throws IOException {
      char[] var5 = this.n.k();
      var5[0] = '-';
      if (this.d >= this.e) {
         this.o();
      }

      byte[] var6 = this.R;
      int var1 = this.d++;
      int var2 = var6[var1] & 255;
      JsonToken var11;
      if (var2 >= 48 && var2 <= 57) {
         var1 = var2;
         if (var2 == 48) {
            var1 = this.P();
         }

         int var3 = 2;
         var5[1] = (char)var1;
         var2 = this.d + var5.length - 2;
         if (var2 > this.e) {
            var2 = this.e;
            var1 = 1;
         } else {
            var1 = 1;
         }

         while (true) {
            if (this.d >= var2) {
               var11 = this.a(var5, var3, true, var1);
               break;
            }

            var6 = this.R;
            int var4 = this.d++;
            var4 = var6[var4] & 255;
            if (var4 < 48 || var4 > 57) {
               if (var4 != 46 && var4 != 101 && var4 != 69) {
                  this.d--;
                  this.n.a(var3);
                  if (this.l.b()) {
                     this.o(var4);
                  }

                  var11 = this.a(true, var1);
               } else {
                  var11 = this.a(var5, var3, var4, true, var1);
               }
               break;
            }

            var1++;
            var5[var3] = (char)var4;
            var3++;
         }
      } else {
         var11 = this.a(var2, true);
      }

      return var11;
   }

   protected String I() throws IOException {
      if (this.d >= this.e && !this.p()) {
         this.c(": was expecting closing '\"' for name");
      }

      byte[] var2 = this.R;
      int var1 = this.d++;
      var1 = var2[var1] & 255;
      String var4;
      if (var1 == 34) {
         var4 = "";
      } else {
         var4 = this.a(this.O, 0, 0, var1, 0);
      }

      return var4;
   }

   protected String J() throws IOException {
      if (this.d >= this.e && !this.p()) {
         this.c(": was expecting closing ''' for name");
      }

      int[] var6 = this.R;
      int var1 = this.d++;
      int var4 = var6[var1] & 0xFF;
      String var26;
      if (var4 == 39) {
         var26 = "";
      } else {
         var6 = this.O;
         int[] var8 = L;
         int var2 = 0;
         int var3 = 0;
         var1 = 0;

         while (var4 != 39) {
            int var24;
            label81: {
               var24 = var4;
               if (var4 != 34) {
                  var24 = var4;
                  if (var8[var4] != 0) {
                     if (var4 != 92) {
                        this.c(var4, "name");
                     } else {
                        var4 = this.D();
                     }

                     var24 = var4;
                     if (var4 > 127) {
                        if (var2 >= 4) {
                           int[] var7 = var6;
                           if (var1 >= var6.length) {
                              var7 = a(var6, var6.length);
                              this.O = var7;
                           }

                           var7[var1] = var3;
                           var2 = 0;
                           var1++;
                           var3 = 0;
                           var6 = var7;
                        }

                        if (var4 < 2048) {
                           var3 = var3 << 8 | var4 >> 6 | 192;
                           var2++;
                        } else {
                           var3 = var3 << 8 | var4 >> 12 | 224;
                           if (++var2 >= 4) {
                              int[] var28 = var6;
                              if (var1 >= var6.length) {
                                 var28 = a(var6, var6.length);
                                 this.O = var28;
                              }

                              var28[var1] = var3;
                              var1++;
                              var6 = var28;
                              var2 = 0;
                              var3 = 0;
                           }

                           var3 = var3 << 8 | var4 >> 6 & 63 | 128;
                           var2++;
                        }

                        var24 = var3;
                        var3 = var2;
                        var2 = var4 & 63 | 128;
                        var4 = var3;
                        break label81;
                     }
                  }
               }

               var4 = var2;
               var2 = var24;
               var24 = var3;
            }

            if (var4 < 4) {
               var3 = var2 | var24 << 8;
               var4++;
               var2 = var1;
               var1 = var4;
            } else {
               int[] var29 = var6;
               if (var1 >= var6.length) {
                  var29 = a(var6, var6.length);
                  this.O = var29;
               }

               var29[var1] = var24;
               var6 = var29;
               byte var18 = 1;
               var4 = var1 + 1;
               var1 = var18;
               var3 = var2;
               var2 = var4;
            }

            if (this.d >= this.e && !this.p()) {
               this.c(" in field name");
            }

            byte[] var30 = this.R;
            var4 = this.d++;
            var24 = var30[var4] & 255;
            var4 = var2;
            var2 = var1;
            var1 = var4;
            var4 = var24;
         }

         if (var2 > 0) {
            int[] var31 = var6;
            if (var1 >= var6.length) {
               var31 = a(var6, var6.length);
               this.O = var31;
            }

            var31[var1] = d(var3, var2);
            var6 = var31;
            var1++;
         }

         String var32 = this.N.a(var6, var1);
         if (var32 == null) {
            var26 = this.a(var6, var1, var2);
         } else {
            var26 = var32;
         }
      }

      return var26;
   }

   protected String K() throws IOException {
      int var2 = this.d;
      int var1 = var2;
      if (var2 >= this.e) {
         this.o();
         var1 = this.d;
      }

      char[] var5 = this.n.k();
      int[] var7 = T;
      int var3 = Math.min(this.e, var5.length + var1);
      byte[] var6 = this.R;
      var2 = 0;

      while (true) {
         if (var1 < var3) {
            int var4 = var6[var1] & 255;
            if (var7[var4] == 0) {
               var5[var2] = (char)var4;
               var2++;
               var1++;
               continue;
            }

            if (var4 == 34) {
               this.d = var1 + 1;
               var9 = this.n.b(var2);
               break;
            }
         }

         this.d = var1;
         this.a(var5, var2);
         var9 = this.n.f();
         break;
      }

      return var9;
   }

   protected void L() throws IOException {
      this.P = false;
      int[] var5 = T;
      byte[] var6 = this.R;

      label35:
      while (true) {
         int var3 = this.d;
         int var4 = this.e;
         int var2 = var4;
         int var1 = var3;
         if (var3 >= var4) {
            this.o();
            var1 = this.d;
            var2 = this.e;
         }

         while (var1 < var2) {
            var3 = var1 + 1;
            var1 = var6[var1] & 255;
            if (var5[var1] != 0) {
               this.d = var3;
               if (var1 == 34) {
                  return;
               }

               switch (var5[var1]) {
                  case 1:
                     this.D();
                     continue label35;
                  case 2:
                     this.t(var1);
                     continue label35;
                  case 3:
                     this.u(var1);
                     continue label35;
                  case 4:
                     this.v(var1);
                     continue label35;
                  default:
                     if (var1 < 32) {
                        this.c(var1, "string value");
                     } else {
                        this.k(var1);
                     }
                     continue label35;
               }
            }

            var1 = var3;
         }

         this.d = var1;
      }
   }

   protected JsonToken M() throws IOException {
      char[] var5 = this.n.k();
      int[] var6 = T;
      byte[] var7 = this.R;
      int var1 = 0;

      while (true) {
         if (this.d >= this.e) {
            this.o();
         }

         char[] var4 = var5;
         int var2 = var1;
         if (var1 >= var5.length) {
            var4 = this.n.m();
            var2 = 0;
         }

         int var3 = this.e;
         var1 = this.d + (var4.length - var2);
         if (var1 < var3) {
            var3 = var1;
         }

         while (true) {
            var5 = var4;
            var1 = var2;
            if (this.d >= var3) {
               break;
            }

            var1 = this.d++;
            var1 = var7[var1] & 255;
            if (var1 == 39 || var6[var1] != 0) {
               if (var1 == 39) {
                  this.n.a(var2);
                  return JsonToken.VALUE_STRING;
               }

               switch (var6[var1]) {
                  case 1:
                     if (var1 != 39) {
                        var1 = this.D();
                     }
                     break;
                  case 2:
                     var1 = this.p(var1);
                     break;
                  case 3:
                     if (this.e - this.d >= 2) {
                        var1 = this.r(var1);
                     } else {
                        var1 = this.q(var1);
                     }
                     break;
                  case 4:
                     var3 = this.s(var1);
                     var1 = var2 + 1;
                     var4[var2] = (char)(55296 | var3 >> 10);
                     if (var1 >= var4.length) {
                        var4 = this.n.m();
                        var2 = 0;
                     } else {
                        var2 = var1;
                     }

                     var1 = 56320 | var3 & 1023;
                     break;
                  default:
                     if (var1 < 32) {
                        this.c(var1, "string value");
                     }

                     this.k(var1);
               }

               if (var2 >= var4.length) {
                  var4 = this.n.m();
                  var2 = 0;
               }

               var3 = var2 + 1;
               var4[var2] = (char)var1;
               var5 = var4;
               var1 = var3;
               break;
            }

            var4[var2] = (char)var1;
            var2++;
         }
      }
   }

   protected final void N() throws IOException {
      if ((this.d < this.e || this.p()) && this.R[this.d] == 10) {
         this.d++;
      }

      this.g++;
      this.h = this.d;
   }

   @Override
   public JsonToken a() throws IOException {
      this.A = 0;
      JsonToken var3;
      if (this.K == JsonToken.FIELD_NAME) {
         var3 = this.O();
      } else {
         if (this.P) {
            this.L();
         }

         int var2 = this.S();
         if (var2 < 0) {
            this.close();
            this.K = null;
            var3 = null;
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
               var3 = JsonToken.END_ARRAY;
               this.K = var3;
            } else if (var2 == 125) {
               if (!this.l.c()) {
                  this.a(var2, ']');
               }

               this.l = this.l.h();
               var3 = JsonToken.END_OBJECT;
               this.K = var3;
            } else {
               int var1 = var2;
               if (this.l.i()) {
                  if (var2 != 44) {
                     this.b(var2, "was expecting comma to separate " + this.l.d() + " entries");
                  }

                  var1 = this.Q();
               }

               if (!this.l.c()) {
                  var3 = this.n(var1);
               } else {
                  String var5 = this.f(var1);
                  this.l.a(var5);
                  this.K = JsonToken.FIELD_NAME;
                  var1 = this.U();
                  if (var1 == 34) {
                     this.P = true;
                     this.m = JsonToken.VALUE_STRING;
                     var3 = this.K;
                  } else {
                     switch (var1) {
                        case 45:
                           var3 = this.H();
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
                           var3 = this.e(var1);
                           break;
                        case 91:
                           var3 = JsonToken.START_ARRAY;
                           break;
                        case 102:
                           this.a("false", 1);
                           var3 = JsonToken.VALUE_FALSE;
                           break;
                        case 110:
                           this.a("null", 1);
                           var3 = JsonToken.VALUE_NULL;
                           break;
                        case 116:
                           this.a("true", 1);
                           var3 = JsonToken.VALUE_TRUE;
                           break;
                        case 123:
                           var3 = JsonToken.START_OBJECT;
                           break;
                        default:
                           var3 = this.i(var1);
                     }

                     this.m = var3;
                     var3 = this.K;
                  }
               }
            }
         }
      }

      return var3;
   }

   protected JsonToken a(int var1, boolean var2) throws IOException {
      int var5;
      while (true) {
         var5 = var1;
         if (var1 != 73) {
            break;
         }

         if (this.d >= this.e && !this.p()) {
            this.F();
         }

         byte[] var6 = this.R;
         var1 = this.d++;
         var1 = var6[var1];
         String var8;
         if (var1 == 78) {
            if (var2) {
               var8 = "-INF";
            } else {
               var8 = "+INF";
            }
         } else {
            if (var1 != 110) {
               var5 = var1;
               break;
            }

            if (var2) {
               var8 = "-Infinity";
            } else {
               var8 = "+Infinity";
            }
         }

         this.a(var8, 3);
         if (this.a(JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS)) {
            double var3;
            if (var2) {
               var3 = Double.NEGATIVE_INFINITY;
            } else {
               var3 = Double.POSITIVE_INFINITY;
            }

            return this.a(var8, var3);
         }

         this.d("Non-standard token '" + var8 + "': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
      }

      this.a(var5, "expected digit (0-9) to follow minus sign, for valid numeric value");
      return null;
   }

   protected final String a(int var1, int var2) throws IOException {
      byte[] var4 = this.R;
      int[] var5 = L;
      int var3 = this.d++;
      var3 = var4[var3] & 255;
      String var16;
      if (var5[var3] != 0) {
         if (var3 == 34) {
            var16 = this.b(this.U, var2, var1, 1);
         } else {
            var16 = this.a(this.U, var2, var1, var3, 1);
         }
      } else {
         var1 = var1 << 8 | var3;
         var3 = this.d++;
         var3 = var4[var3] & 255;
         if (var5[var3] != 0) {
            if (var3 == 34) {
               var16 = this.b(this.U, var2, var1, 2);
            } else {
               var16 = this.a(this.U, var2, var1, var3, 2);
            }
         } else {
            var1 = var1 << 8 | var3;
            var3 = this.d++;
            var3 = var4[var3] & 255;
            if (var5[var3] != 0) {
               if (var3 == 34) {
                  var16 = this.b(this.U, var2, var1, 3);
               } else {
                  var16 = this.a(this.U, var2, var1, var3, 3);
               }
            } else {
               var1 = var1 << 8 | var3;
               var3 = this.d++;
               var3 = var4[var3] & 255;
               if (var5[var3] != 0) {
                  if (var3 == 34) {
                     var16 = this.b(this.U, var2, var1, 4);
                  } else {
                     var16 = this.a(this.U, var2, var1, var3, 4);
                  }
               } else {
                  var16 = this.a(var3, var2, var1);
               }
            }
         }
      }

      return var16;
   }

   protected final String a(int var1, int var2, int var3) throws IOException {
      this.O[0] = this.U;
      this.O[1] = var2;
      this.O[2] = var3;
      byte[] var4 = this.R;
      int[] var5 = L;
      int var11 = 3;
      var2 = var1;
      var1 = var11;

      while (true) {
         if (this.d + 4 > this.e) {
            var19 = this.a(this.O, var1, 0, var2, 0);
            break;
         }

         var11 = this.d++;
         var11 = var4[var11] & 255;
         if (var5[var11] != 0) {
            if (var11 == 34) {
               var19 = this.a(this.O, var1, var2, 1);
            } else {
               var19 = this.a(this.O, var1, var2, var11, 1);
            }
            break;
         }

         var2 = var2 << 8 | var11;
         var11 = this.d++;
         var11 = var4[var11] & 255;
         if (var5[var11] != 0) {
            if (var11 == 34) {
               var19 = this.a(this.O, var1, var2, 2);
            } else {
               var19 = this.a(this.O, var1, var2, var11, 2);
            }
            break;
         }

         var2 = var2 << 8 | var11;
         var11 = this.d++;
         var11 = var4[var11] & 255;
         if (var5[var11] != 0) {
            if (var11 == 34) {
               var19 = this.a(this.O, var1, var2, 3);
            } else {
               var19 = this.a(this.O, var1, var2, var11, 3);
            }
            break;
         }

         var11 = var2 << 8 | var11;
         var2 = this.d++;
         var2 = var4[var2] & 255;
         if (var5[var2] != 0) {
            if (var2 == 34) {
               var19 = this.a(this.O, var1, var11, 4);
            } else {
               var19 = this.a(this.O, var1, var11, var2, 4);
            }
            break;
         }

         if (var1 >= this.O.length) {
            this.O = a(this.O, var1);
         }

         this.O[var1] = var11;
         var1++;
      }

      return var19;
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

   protected final String a(int[] var1, int var2, int var3, int var4, int var5) throws IOException {
      int[] var9 = L;

      while (true) {
         label72: {
            int var6 = var4;
            if (var9[var4] != 0) {
               if (var4 == 34) {
                  int[] var26 = var1;
                  var4 = var2;
                  if (var5 > 0) {
                     var26 = var1;
                     if (var2 >= var1.length) {
                        var26 = a(var1, var1.length);
                        this.O = var26;
                     }

                     var26[var2] = d(var3, var5);
                     var4 = var2 + 1;
                  }

                  String var27 = this.N.a(var26, var4);
                  String var10 = var27;
                  if (var27 == null) {
                     var10 = this.a(var26, var4, var5);
                  }

                  return var10;
               }

               if (var4 != 92) {
                  this.c(var4, "name");
               } else {
                  var4 = this.D();
               }

               var6 = var4;
               if (var4 > 127) {
                  if (var5 >= 4) {
                     int[] var8 = var1;
                     if (var2 >= var1.length) {
                        var8 = a(var1, var1.length);
                        this.O = var8;
                     }

                     var6 = var2 + 1;
                     var8[var2] = var3;
                     var5 = 0;
                     var3 = 0;
                     var1 = var8;
                     var2 = var6;
                  }

                  if (var4 < 2048) {
                     var6 = var4 >> 6 | 192 | var3 << 8;
                     var5++;
                     var3 = var2;
                     var2 = var6;
                  } else {
                     var3 = var4 >> 12 | 224 | var3 << 8;
                     if (++var5 >= 4) {
                        int[] var23 = var1;
                        if (var2 >= var1.length) {
                           var23 = a(var1, var1.length);
                           this.O = var23;
                        }

                        var23[var2] = var3;
                        var2++;
                        var1 = var23;
                        var5 = 0;
                        var3 = 0;
                     }

                     var6 = var3 << 8 | var4 >> 6 & 63 | 128;
                     var5++;
                     var3 = var2;
                     var2 = var6;
                  }

                  int var7 = var4 & 63 | 128;
                  var4 = var3;
                  var6 = var2;
                  var3 = var7;
                  var2 = var4;
                  var4 = var6;
                  break label72;
               }
            }

            var4 = var3;
            var3 = var6;
         }

         if (var5 < 4) {
            var5++;
            var3 |= var4 << 8;
         } else {
            int[] var24 = var1;
            if (var2 >= var1.length) {
               var24 = a(var1, var1.length);
               this.O = var24;
            }

            var24[var2] = var4;
            var5 = 1;
            var2++;
            var1 = var24;
         }

         if (this.d >= this.e && !this.p()) {
            this.c(" in field name");
         }

         byte[] var25 = this.R;
         var4 = this.d++;
         var4 = var25[var4] & 255;
      }
   }

   protected final void a(String var1, int var2) throws IOException {
      int var4 = var1.length();
      int var3 = var2;
      if (this.d + var4 >= this.e) {
         this.b(var1, var2);
      } else {
         do {
            if (this.R[this.d] != var1.charAt(var3)) {
               this.e(var1.substring(0, var3));
            }

            this.d++;
            var2 = var3 + 1;
            var3 = var2;
         } while (var2 < var4);

         var3 = this.R[this.d] & 255;
         if (var3 >= 48 && var3 != 93 && var3 != 125) {
            this.a(var1, var2, var3);
         }
      }
   }

   protected void a(String var1, String var2) throws IOException {
      StringBuilder var6 = new StringBuilder(var1);

      while (this.d < this.e || this.p()) {
         byte[] var5 = this.R;
         int var4 = this.d++;
         char var3 = (char)this.j(var5[var4]);
         if (!Character.isJavaIdentifierPart(var3)) {
            break;
         }

         var6.append(var3);
      }

      this.d("Unrecognized token '" + var6.toString() + "': was expecting " + var2);
   }

   protected void b(int var1, int var2) throws JsonParseException {
      this.d = var2;
      this.m(var1);
   }

   @Override
   public JsonLocation e() {
      int var2 = this.d;
      int var1 = this.h;
      return new JsonLocation(this.b.a(), this.f + this.d, -1L, this.g, var2 - var1 + 1);
   }

   protected JsonToken e(int var1) throws IOException {
      int var3 = 1;
      char[] var6 = this.n.k();
      int var2 = var1;
      if (var1 == 48) {
         var2 = this.P();
      }

      var6[0] = (char)var2;
      var2 = this.d + var6.length - 1;
      if (var2 > this.e) {
         var2 = this.e;
         var1 = 1;
      } else {
         var1 = 1;
      }

      JsonToken var10;
      while (true) {
         if (this.d >= var2) {
            var10 = this.a(var6, var3, false, var1);
            break;
         }

         byte[] var5 = this.R;
         int var4 = this.d++;
         var4 = var5[var4] & 255;
         if (var4 < 48 || var4 > 57) {
            if (var4 != 46 && var4 != 101 && var4 != 69) {
               this.d--;
               this.n.a(var3);
               if (this.l.b()) {
                  this.o(var4);
               }

               var10 = this.a(false, var1);
               break;
            }

            var10 = this.a(var6, var3, var4, false, var1);
            break;
         }

         var6[var3] = (char)var4;
         var3++;
         var1++;
      }

      return var10;
   }

   protected void e(String var1) throws IOException {
      this.a(var1, "'null', 'true', 'false' or NaN");
   }

   @Override
   public String f() throws IOException {
      String var1;
      if (this.K == JsonToken.VALUE_STRING) {
         if (this.P) {
            this.P = false;
            var1 = this.K();
         } else {
            var1 = this.n.f();
         }
      } else {
         var1 = this.a(this.K);
      }

      return var1;
   }

   protected final String f(int var1) throws IOException {
      String var3;
      if (var1 != 34) {
         var3 = this.h(var1);
      } else if (this.d + 13 > this.e) {
         var3 = this.I();
      } else {
         byte[] var4 = this.R;
         int[] var17 = L;
         var1 = this.d++;
         var1 = var4[var1] & 255;
         if (var17[var1] == 0) {
            int var2 = this.d++;
            var2 = var4[var2] & 255;
            if (var17[var2] == 0) {
               var1 = var1 << 8 | var2;
               var2 = this.d++;
               var2 = var4[var2] & 255;
               if (var17[var2] == 0) {
                  var1 = var1 << 8 | var2;
                  var2 = this.d++;
                  var2 = var4[var2] & 255;
                  if (var17[var2] == 0) {
                     var1 = var1 << 8 | var2;
                     var2 = this.d++;
                     var2 = var4[var2] & 255;
                     if (var17[var2] == 0) {
                        this.U = var1;
                        var3 = this.g(var2);
                     } else if (var2 == 34) {
                        var3 = this.c(var1, 4);
                     } else {
                        var3 = this.b(var1, var2, 4);
                     }
                  } else if (var2 == 34) {
                     var3 = this.c(var1, 3);
                  } else {
                     var3 = this.b(var1, var2, 3);
                  }
               } else if (var2 == 34) {
                  var3 = this.c(var1, 2);
               } else {
                  var3 = this.b(var1, var2, 2);
               }
            } else if (var2 == 34) {
               var3 = this.c(var1, 1);
            } else {
               var3 = this.b(var1, var2, 1);
            }
         } else if (var1 == 34) {
            var3 = "";
         } else {
            var3 = this.b(0, var1, 0);
         }
      }

      return var3;
   }

   protected final String g(int var1) throws IOException {
      byte[] var4 = this.R;
      int[] var3 = L;
      int var2 = this.d++;
      var2 = var4[var2] & 255;
      String var15;
      if (var3[var2] != 0) {
         if (var2 == 34) {
            var15 = this.c(this.U, var1, 1);
         } else {
            var15 = this.a(this.U, var1, var2, 1);
         }
      } else {
         var1 = var2 | var1 << 8;
         var2 = this.d++;
         var2 = var4[var2] & 255;
         if (var3[var2] != 0) {
            if (var2 == 34) {
               var15 = this.c(this.U, var1, 2);
            } else {
               var15 = this.a(this.U, var1, var2, 2);
            }
         } else {
            var1 = var1 << 8 | var2;
            var2 = this.d++;
            var2 = var4[var2] & 255;
            if (var3[var2] != 0) {
               if (var2 == 34) {
                  var15 = this.c(this.U, var1, 3);
               } else {
                  var15 = this.a(this.U, var1, var2, 3);
               }
            } else {
               var1 = var1 << 8 | var2;
               var2 = this.d++;
               var2 = var4[var2] & 255;
               if (var3[var2] != 0) {
                  if (var2 == 34) {
                     var15 = this.c(this.U, var1, 4);
                  } else {
                     var15 = this.a(this.U, var1, var2, 4);
                  }
               } else {
                  var15 = this.a(var2, var1);
               }
            }
         }
      }

      return var15;
   }

   protected String h(int var1) throws IOException {
      String var13;
      if (var1 == 39 && this.a(JsonParser.Feature.ALLOW_SINGLE_QUOTES)) {
         var13 = this.J();
      } else {
         if (!this.a(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES)) {
            this.b((char)this.j(var1), "was expecting double-quote to start field name");
         }

         int[] var8 = CharTypes.d();
         if (var8[var1] != 0) {
            this.b(var1, "was expecting either valid name character (for unquoted name) or double-quote (for quoted) to start field name");
         }

         int[] var6 = this.O;
         int var4 = 0;
         int var3 = 0;
         int var2 = var1;
         var1 = 0;

         while (true) {
            if (var4 < 4) {
               var3 = var2 | var3 << 8;
               var2 = var4 + 1;
            } else {
               int[] var7 = var6;
               if (var1 >= var6.length) {
                  var7 = a(var6, var6.length);
                  this.O = var7;
               }

               var7[var1] = var3;
               var6 = var7;
               byte var11 = 1;
               var3 = var2;
               var1++;
               var2 = var11;
            }

            if (this.d >= this.e && !this.p()) {
               this.c(" in field name");
            }

            int var5 = this.R[this.d] & 255;
            if (var8[var5] != 0) {
               var4 = var1;
               int[] var14 = var6;
               if (var2 > 0) {
                  var14 = var6;
                  if (var1 >= var6.length) {
                     var14 = a(var6, var6.length);
                     this.O = var14;
                  }

                  var14[var1] = var3;
                  var4 = var1 + 1;
               }

               var13 = this.N.a(var14, var4);
               if (var13 == null) {
                  var13 = this.a(var14, var4, var2);
               }
               break;
            }

            this.d++;
            var4 = var2;
            var2 = var5;
         }
      }

      return var13;
   }

   protected JsonToken i(int var1) throws IOException {
      switch (var1) {
         case 43:
            if (this.d >= this.e && !this.p()) {
               this.F();
            }

            byte[] var4 = this.R;
            var1 = this.d++;
            return this.a(var4[var1] & 255, false);
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
            break;
         case 93:
         case 125:
            this.b(var1, "expected a value");
         case 39:
            if (this.a(JsonParser.Feature.ALLOW_SINGLE_QUOTES)) {
               return this.M();
            }
      }

      if (Character.isJavaIdentifierStart(var1)) {
         this.a("" + (char)var1, "('true', 'false' or 'null')");
      }

      this.b(var1, "expected a valid value (number, String, array, object, 'true', 'false' or 'null')");
      return null;
   }

   protected int j(int var1) throws IOException {
      int var2 = var1 & 0xFF;
      var1 = var2;
      if (var2 > 127) {
         byte var5;
         if ((var2 & 224) == 192) {
            var2 &= 31;
            var5 = 1;
         } else if ((var2 & 240) == 224) {
            var2 &= 15;
            var5 = 2;
         } else if ((var2 & 248) == 240) {
            var2 &= 7;
            var5 = 3;
         } else {
            this.l(var2 & 0xFF);
            var5 = 1;
         }

         int var3 = this.Z();
         if ((var3 & 192) != 128) {
            this.m(var3 & 0xFF);
         }

         var2 = var2 << 6 | var3 & 63;
         if (var5 > 1) {
            var3 = this.Z();
            if ((var3 & 192) != 128) {
               this.m(var3 & 0xFF);
            }

            var2 = var3 & 63 | var2 << 6;
            if (var5 > 2) {
               var5 = this.Z();
               if ((var5 & 192) != 128) {
                  this.m(var5 & 0xFF);
               }

               var1 = var5 & 63 | var2 << 6;
            } else {
               var1 = var2;
            }
         } else {
            var1 = var2;
         }
      }

      return var1;
   }

   protected void k(int var1) throws JsonParseException {
      if (var1 < 32) {
         this.c(var1);
      }

      this.l(var1);
   }

   protected void l(int var1) throws JsonParseException {
      this.d("Invalid UTF-8 start byte 0x" + Integer.toHexString(var1));
   }

   protected void m(int var1) throws JsonParseException {
      this.d("Invalid UTF-8 middle byte 0x" + Integer.toHexString(var1));
   }

   @Override
   protected final boolean p() throws IOException {
      boolean var3 = false;
      this.f = this.f + this.e;
      this.h = this.h - this.e;
      boolean var2 = var3;
      if (this.Q != null) {
         int var1 = this.R.length;
         if (var1 == 0) {
            var2 = var3;
         } else {
            var1 = this.Q.read(this.R, 0, var1);
            if (var1 > 0) {
               this.d = 0;
               this.e = var1;
               var2 = true;
            } else {
               this.r();
               var2 = var3;
               if (var1 == 0) {
                  throw new IOException("InputStream.read() returned 0 characters when trying to read " + this.R.length + " bytes");
               }
            }
         }
      }

      return var2;
   }

   @Override
   protected void q() throws IOException {
      int var2 = this.d;
      int var1 = var2;
      if (var2 >= this.e) {
         this.o();
         var1 = this.d;
      }

      char[] var6 = this.n.k();
      int[] var7 = T;
      int var3 = Math.min(this.e, var6.length + var1);
      byte[] var5 = this.R;
      var2 = 0;

      while (true) {
         if (var1 < var3) {
            int var4 = var5[var1] & 255;
            if (var7[var4] == 0) {
               var6[var2] = (char)var4;
               var2++;
               var1++;
               continue;
            }

            if (var4 == 34) {
               this.d = var1 + 1;
               this.n.a(var2);
               break;
            }
         }

         this.d = var1;
         this.a(var6, var2);
         break;
      }
   }

   @Override
   protected void r() throws IOException {
      if (this.Q != null) {
         if (this.b.c() || this.a(JsonParser.Feature.AUTO_CLOSE_SOURCE)) {
            this.Q.close();
         }

         this.Q = null;
      }
   }

   @Override
   protected void s() throws IOException {
      super.s();
      this.N.b();
      if (this.S) {
         byte[] var1 = this.R;
         if (var1 != null) {
            this.R = ByteArrayBuilder.a;
            this.b.a(var1);
         }
      }
   }
}
