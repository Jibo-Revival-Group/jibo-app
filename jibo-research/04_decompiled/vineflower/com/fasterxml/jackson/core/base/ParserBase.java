package com.fasterxml.jackson.core.base;

import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.io.NumberInput;
import com.fasterxml.jackson.core.json.DupDetector;
import com.fasterxml.jackson.core.json.JsonReadContext;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import com.fasterxml.jackson.core.util.TextBuffer;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

public abstract class ParserBase extends ParserMinimalBase {
   static final BigInteger s = BigInteger.valueOf(-2147483648L);
   static final BigInteger t = BigInteger.valueOf(2147483647L);
   static final BigInteger u = BigInteger.valueOf(Long.MIN_VALUE);
   static final BigInteger v = BigInteger.valueOf(Long.MAX_VALUE);
   static final BigDecimal w = new BigDecimal(u);
   static final BigDecimal x = new BigDecimal(v);
   static final BigDecimal y = new BigDecimal(s);
   static final BigDecimal z = new BigDecimal(t);
   protected int A;
   protected int B;
   protected long C;
   protected double D;
   protected BigInteger E;
   protected BigDecimal F;
   protected boolean G;
   protected int H;
   protected int I;
   protected int J;
   protected final IOContext b;
   protected boolean c;
   protected int d;
   protected int e;
   protected long f;
   protected int g;
   protected int h;
   protected long i;
   protected int j;
   protected int k;
   protected JsonReadContext l;
   protected JsonToken m;
   protected final TextBuffer n;
   protected char[] o;
   protected boolean p;
   protected ByteArrayBuilder q;
   protected byte[] r;

   protected ParserBase(IOContext var1, int var2) {
      Object var3 = null;
      super(var2);
      this.d = 0;
      this.e = 0;
      this.f = 0L;
      this.g = 1;
      this.h = 0;
      this.i = 0L;
      this.j = 1;
      this.k = 0;
      this.o = null;
      this.p = false;
      this.q = null;
      this.A = 0;
      this.b = var1;
      this.n = var1.d();
      DupDetector var4 = (DupDetector)var3;
      if (JsonParser.Feature.STRICT_DUPLICATE_DETECTION.enabledIn(var2)) {
         var4 = DupDetector.a(this);
      }

      this.l = JsonReadContext.a(var4);
   }

   private void a(int var1, char[] var2, int var3, int var4) throws IOException {
      String var5 = this.n.f();

      try {
         if (NumberInput.a(var2, var3, var4, this.G)) {
            this.C = Long.parseLong(var5);
            this.A = 2;
         } else {
            BigInteger var7 = new BigInteger(var5);
            this.E = var7;
            this.A = 4;
         }
      } catch (NumberFormatException var6) {
         this.a("Malformed numeric value '" + var5 + "'", var6);
      }
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private void e(int var1) throws IOException {
      if (var1 == 16) {
         try {
            this.F = this.n.h();
            this.A = 16;
         } catch (NumberFormatException var4) {
            this.a("Malformed numeric value '" + this.n.f() + "'", var4);
         }
      } else {
         try {
            this.D = this.n.i();
            this.A = 8;
         } catch (NumberFormatException var3) {
            this.a("Malformed numeric value '" + this.n.f() + "'", var3);
         }
      }
   }

   protected void A() throws IOException {
      if ((this.A & 8) != 0) {
         this.F = NumberInput.b(this.f());
      } else if ((this.A & 4) != 0) {
         this.F = new BigDecimal(this.E);
      } else if ((this.A & 2) != 0) {
         this.F = BigDecimal.valueOf(this.C);
      } else if ((this.A & 1) != 0) {
         this.F = BigDecimal.valueOf(this.B);
      } else {
         this.G();
      }

      this.A |= 16;
   }

   protected void B() throws IOException {
      this.d("Numeric value (" + this.f() + ") out of range of int (" + Integer.MIN_VALUE + " - " + Integer.MAX_VALUE + ")");
   }

   protected void C() throws IOException {
      this.d("Numeric value (" + this.f() + ") out of range of long (" + Long.MIN_VALUE + " - " + Long.MAX_VALUE + ")");
   }

   protected char D() throws IOException {
      throw new UnsupportedOperationException();
   }

   protected final JsonToken a(String var1, double var2) {
      this.n.a(var1);
      this.D = var2;
      this.A = 8;
      return JsonToken.VALUE_NUMBER_FLOAT;
   }

   protected final JsonToken a(boolean var1, int var2) {
      this.G = var1;
      this.H = var2;
      this.I = 0;
      this.J = 0;
      this.A = 0;
      return JsonToken.VALUE_NUMBER_INT;
   }

   protected final JsonToken a(boolean var1, int var2, int var3, int var4) {
      JsonToken var5;
      if (var3 < 1 && var4 < 1) {
         var5 = this.a(var1, var2);
      } else {
         var5 = this.b(var1, var2, var3, var4);
      }

      return var5;
   }

   protected void a(int var1) throws IOException {
      if (this.K == JsonToken.VALUE_NUMBER_INT) {
         char[] var9 = this.n.e();
         int var3 = this.n.d();
         int var4 = this.H;
         int var2 = var3;
         if (this.G) {
            var2 = var3 + 1;
         }

         if (var4 <= 9) {
            var2 = NumberInput.a(var9, var2, var4);
            var1 = var2;
            if (this.G) {
               var1 = -var2;
            }

            this.B = var1;
            this.A = 1;
         } else if (var4 <= 18) {
            long var7 = NumberInput.b(var9, var2, var4);
            long var5 = var7;
            if (this.G) {
               var5 = -var7;
            }

            if (var4 == 10) {
               if (this.G) {
                  if (var5 >= -2147483648L) {
                     this.B = (int)var5;
                     this.A = 1;
                     return;
                  }
               } else if (var5 <= 2147483647L) {
                  this.B = (int)var5;
                  this.A = 1;
                  return;
               }
            }

            this.C = var5;
            this.A = 2;
         } else {
            this.a(var1, var9, var2, var4);
         }
      } else if (this.K == JsonToken.VALUE_NUMBER_FLOAT) {
         this.e(var1);
      } else {
         this.d("Current token (" + this.K + ") not numeric, can not use numeric value accessors");
      }
   }

   protected void a(int var1, char var2) throws JsonParseException {
      String var3 = "" + this.l.a(this.b.a());
      this.d("Unexpected close marker '" + (char)var1 + "': expected '" + var2 + "' (for " + this.l.d() + " starting at " + var3 + ")");
   }

   protected void a(int var1, String var2) throws JsonParseException {
      String var4 = "Unexpected character (" + d(var1) + ") in numeric value";
      String var3 = var4;
      if (var2 != null) {
         var3 = var4 + ": " + var2;
      }

      this.d(var3);
   }

   protected final JsonToken b(boolean var1, int var2, int var3, int var4) {
      this.G = var1;
      this.H = var2;
      this.I = var3;
      this.J = var4;
      this.A = 0;
      return JsonToken.VALUE_NUMBER_FLOAT;
   }

   protected void b(String var1) throws JsonParseException {
      this.d("Invalid numeric value: " + var1);
   }

   @Override
   public void close() throws IOException {
      if (!this.c) {
         this.c = true;

         try {
            this.r();
         } finally {
            this.s();
         }
      }
   }

   @Override
   public String d() throws IOException {
      String var1;
      if (this.K != JsonToken.START_OBJECT && this.K != JsonToken.START_ARRAY) {
         var1 = this.l.g();
      } else {
         var1 = this.l.h().g();
      }

      return var1;
   }

   @Override
   public JsonLocation e() {
      int var2 = this.d;
      int var1 = this.h;
      return new JsonLocation(this.b.a(), -1L, this.f + this.d, this.g, var2 - var1 + 1);
   }

   @Override
   public int i() throws IOException {
      if ((this.A & 1) == 0) {
         if (this.A == 0) {
            return this.v();
         }

         if ((this.A & 1) == 0) {
            this.w();
         }
      }

      return this.B;
   }

   @Override
   public long j() throws IOException {
      if ((this.A & 2) == 0) {
         if (this.A == 0) {
            this.a(2);
         }

         if ((this.A & 2) == 0) {
            this.x();
         }
      }

      return this.C;
   }

   @Override
   public BigInteger k() throws IOException {
      if ((this.A & 4) == 0) {
         if (this.A == 0) {
            this.a(4);
         }

         if ((this.A & 4) == 0) {
            this.y();
         }
      }

      return this.E;
   }

   @Override
   public float l() throws IOException {
      return (float)this.m();
   }

   @Override
   public double m() throws IOException {
      if ((this.A & 8) == 0) {
         if (this.A == 0) {
            this.a(8);
         }

         if ((this.A & 8) == 0) {
            this.z();
         }
      }

      return this.D;
   }

   @Override
   public BigDecimal n() throws IOException {
      if ((this.A & 16) == 0) {
         if (this.A == 0) {
            this.a(16);
         }

         if ((this.A & 16) == 0) {
            this.A();
         }
      }

      return this.F;
   }

   protected final void o() throws IOException {
      if (!this.p()) {
         this.E();
      }
   }

   protected abstract boolean p() throws IOException;

   protected abstract void q() throws IOException;

   protected abstract void r() throws IOException;

   protected void s() throws IOException {
      this.n.a();
      char[] var1 = this.o;
      if (var1 != null) {
         this.o = null;
         this.b.c(var1);
      }
   }

   @Override
   protected void t() throws JsonParseException {
      if (!this.l.b()) {
         this.c(": expected close marker for " + this.l.d() + " (from " + this.l.a(this.b.a()) + ")");
      }
   }

   protected final int u() throws JsonParseException {
      this.t();
      return -1;
   }

   protected int v() throws IOException {
      if (this.K == JsonToken.VALUE_NUMBER_INT) {
         char[] var4 = this.n.e();
         int var2 = this.n.d();
         int var3 = this.H;
         int var1 = var2;
         if (this.G) {
            var1 = var2 + 1;
         }

         if (var3 <= 9) {
            var2 = NumberInput.a(var4, var1, var3);
            var1 = var2;
            if (this.G) {
               var1 = -var2;
            }

            this.B = var1;
            this.A = 1;
            return var1;
         }
      }

      this.a(1);
      if ((this.A & 1) == 0) {
         this.w();
      }

      return this.B;
   }

   protected void w() throws IOException {
      if ((this.A & 2) != 0) {
         int var1 = (int)this.C;
         if (var1 != this.C) {
            this.d("Numeric value (" + this.f() + ") out of range of int");
         }

         this.B = var1;
      } else if ((this.A & 4) != 0) {
         if (s.compareTo(this.E) > 0 || t.compareTo(this.E) < 0) {
            this.B();
         }

         this.B = this.E.intValue();
      } else if ((this.A & 8) != 0) {
         if (this.D < -2.1474836E9F || this.D > 2.147483647E9) {
            this.B();
         }

         this.B = (int)this.D;
      } else if ((this.A & 16) != 0) {
         if (y.compareTo(this.F) > 0 || z.compareTo(this.F) < 0) {
            this.B();
         }

         this.B = this.F.intValue();
      } else {
         this.G();
      }

      this.A |= 1;
   }

   protected void x() throws IOException {
      if ((this.A & 1) != 0) {
         this.C = this.B;
      } else if ((this.A & 4) != 0) {
         if (u.compareTo(this.E) > 0 || v.compareTo(this.E) < 0) {
            this.C();
         }

         this.C = this.E.longValue();
      } else if ((this.A & 8) != 0) {
         if (this.D < -9.223372E18F || this.D > 9.223372E18F) {
            this.C();
         }

         this.C = (long)this.D;
      } else if ((this.A & 16) != 0) {
         if (w.compareTo(this.F) > 0 || x.compareTo(this.F) < 0) {
            this.C();
         }

         this.C = this.F.longValue();
      } else {
         this.G();
      }

      this.A |= 2;
   }

   protected void y() throws IOException {
      if ((this.A & 16) != 0) {
         this.E = this.F.toBigInteger();
      } else if ((this.A & 2) != 0) {
         this.E = BigInteger.valueOf(this.C);
      } else if ((this.A & 1) != 0) {
         this.E = BigInteger.valueOf(this.B);
      } else if ((this.A & 8) != 0) {
         this.E = BigDecimal.valueOf(this.D).toBigInteger();
      } else {
         this.G();
      }

      this.A |= 4;
   }

   protected void z() throws IOException {
      if ((this.A & 16) != 0) {
         this.D = this.F.doubleValue();
      } else if ((this.A & 4) != 0) {
         this.D = this.E.doubleValue();
      } else if ((this.A & 2) != 0) {
         this.D = this.C;
      } else if ((this.A & 1) != 0) {
         this.D = this.B;
      } else {
         this.G();
      }

      this.A |= 8;
   }
}
