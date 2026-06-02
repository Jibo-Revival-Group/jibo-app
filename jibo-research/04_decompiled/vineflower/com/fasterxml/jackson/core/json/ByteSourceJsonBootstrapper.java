package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.base.ParserBase;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.io.MergedStream;
import com.fasterxml.jackson.core.io.UTF32Reader;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
import java.io.ByteArrayInputStream;
import java.io.CharConversionException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public final class ByteSourceJsonBootstrapper {
   protected final IOContext a;
   protected final InputStream b;
   protected final byte[] c;
   protected int d;
   protected boolean e = true;
   protected int f = 0;
   private int g;
   private int h;
   private final boolean i;

   public ByteSourceJsonBootstrapper(IOContext var1, InputStream var2) {
      this.a = var1;
      this.b = var2;
      this.c = var1.e();
      this.g = 0;
      this.h = 0;
      this.d = 0;
      this.i = true;
   }

   private void a(String var1) throws IOException {
      throw new CharConversionException("Unsupported UCS-4 endianness (" + var1 + ") detected");
   }

   private boolean b(int var1) throws IOException {
      boolean var3 = true;
      switch (var1) {
         case -131072:
            this.g += 4;
            this.f = 4;
            this.e = false;
            break;
         case 65279:
            this.e = true;
            this.g += 4;
            this.f = 4;
            break;
         case 65534:
            this.a("2143");
         case -16842752:
            this.a("3412");
         default:
            int var2 = var1 >>> 16;
            if (var2 == 65279) {
               this.g += 2;
               this.f = 2;
               this.e = true;
            } else if (var2 == 65534) {
               this.g += 2;
               this.f = 2;
               this.e = false;
            } else if (var1 >>> 8 == 15711167) {
               this.g += 3;
               this.f = 1;
               this.e = true;
            } else {
               var3 = false;
            }
      }

      return var3;
   }

   private boolean c(int var1) throws IOException {
      boolean var2 = false;
      if (var1 >> 8 == 0) {
         this.e = true;
      } else if ((16777215 & var1) == 0) {
         this.e = false;
      } else if ((-16711681 & var1) == 0) {
         this.a("3412");
      } else {
         if ((-65281 & var1) != 0) {
            return var2;
         }

         this.a("2143");
      }

      this.f = 4;
      return true;
   }

   private boolean d(int var1) {
      boolean var2 = false;
      if ((0xFF00 & var1) == 0) {
         this.e = true;
      } else {
         if ((var1 & 0xFF) != 0) {
            return var2;
         }

         this.e = false;
      }

      this.f = 2;
      return true;
   }

   public JsonEncoding a() throws IOException {
      boolean var1;
      label39: {
         boolean var2 = true;
         if (this.a(4)) {
            int var3 = this.c[this.g] << 24 | (this.c[this.g + 1] & 255) << 16 | (this.c[this.g + 2] & 255) << 8 | this.c[this.g + 3] & 255;
            if (this.b(var3)) {
               var1 = var2;
               break label39;
            }

            var1 = var2;
            if (this.c(var3)) {
               break label39;
            }

            var1 = var2;
            if (this.d(var3 >>> 16)) {
               break label39;
            }
         } else if (this.a(2) && this.d((this.c[this.g] & 255) << 8 | this.c[this.g + 1] & 255)) {
            var1 = var2;
            break label39;
         }

         var1 = false;
      }

      JsonEncoding var4;
      if (!var1) {
         var4 = JsonEncoding.UTF8;
      } else {
         switch (this.f) {
            case 1:
               var4 = JsonEncoding.UTF8;
               break;
            case 2:
               if (this.e) {
                  var4 = JsonEncoding.UTF16_BE;
               } else {
                  var4 = JsonEncoding.UTF16_LE;
               }
               break;
            case 3:
            default:
               throw new RuntimeException("Internal error");
            case 4:
               if (this.e) {
                  var4 = JsonEncoding.UTF32_BE;
               } else {
                  var4 = JsonEncoding.UTF32_LE;
               }
         }
      }

      this.a.a(var4);
      return var4;
   }

   public JsonParser a(int var1, ObjectCodec var2, ByteQuadsCanonicalizer var3, CharsToNameCanonicalizer var4, int var5) throws IOException {
      ParserBase var6;
      if (this.a() == JsonEncoding.UTF8 && JsonFactory.Feature.CANONICALIZE_FIELD_NAMES.enabledIn(var5)) {
         var3 = var3.b(var5);
         var6 = new UTF8StreamJsonParser(this.a, var1, this.b, var2, var3, this.c, this.g, this.h, this.i);
      } else {
         var6 = new ReaderBasedJsonParser(this.a, var1, this.b(), var2, var4.b(var5));
      }

      return var6;
   }

   protected boolean a(int var1) throws IOException {
      boolean var5 = true;
      int var2 = this.h - this.g;

      boolean var4;
      while (true) {
         var4 = var5;
         if (var2 >= var1) {
            break;
         }

         int var3;
         if (this.b == null) {
            var3 = -1;
         } else {
            var3 = this.b.read(this.c, this.h, this.c.length - this.h);
         }

         if (var3 < 1) {
            var4 = false;
            break;
         }

         this.h += var3;
         var2 += var3;
      }

      return var4;
   }

   public Reader b() throws IOException {
      JsonEncoding var2 = this.a.b();
      Reader var1;
      switch (var2.bits()) {
         case 8:
         case 16:
            InputStream var3 = this.b;
            if (var3 == null) {
               var3 = new ByteArrayInputStream(this.c, this.g, this.h);
            } else if (this.g < this.h) {
               var3 = new MergedStream(this.a, var3, this.c, this.g, this.h);
            }

            var1 = new InputStreamReader(var3, var2.getJavaName());
            break;
         case 32:
            var1 = new UTF32Reader(this.a, this.b, this.c, this.g, this.h, this.a.b().isBigEndian());
            break;
         default:
            throw new RuntimeException("Internal error");
      }

      return var1;
   }
}
