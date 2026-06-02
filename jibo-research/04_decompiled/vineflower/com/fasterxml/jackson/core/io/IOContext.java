package com.fasterxml.jackson.core.io;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.util.BufferRecycler;
import com.fasterxml.jackson.core.util.TextBuffer;

public class IOContext {
   protected final Object a;
   protected JsonEncoding b;
   protected final boolean c;
   protected final BufferRecycler d;
   protected byte[] e = null;
   protected byte[] f = null;
   protected byte[] g = null;
   protected char[] h = null;
   protected char[] i = null;
   protected char[] j = null;

   public IOContext(BufferRecycler var1, Object var2, boolean var3) {
      this.d = var1;
      this.a = var2;
      this.c = var3;
   }

   private IllegalArgumentException i() {
      return new IllegalArgumentException("Trying to release buffer not owned by the context");
   }

   public Object a() {
      return this.a;
   }

   public void a(JsonEncoding var1) {
      this.b = var1;
   }

   protected final void a(Object var1) {
      if (var1 != null) {
         throw new IllegalStateException("Trying to call same allocXxx() method second time");
      }
   }

   public void a(byte[] var1) {
      if (var1 != null) {
         this.a(var1, this.e);
         this.e = null;
         this.d.a(0, var1);
      }
   }

   protected final void a(byte[] var1, byte[] var2) {
      if (var1 != var2 && var1.length <= var2.length) {
         throw this.i();
      }
   }

   public void a(char[] var1) {
      if (var1 != null) {
         this.a(var1, this.h);
         this.h = null;
         this.d.a(0, var1);
      }
   }

   protected final void a(char[] var1, char[] var2) {
      if (var1 != var2 && var1.length <= var2.length) {
         throw this.i();
      }
   }

   public char[] a(int var1) {
      this.a(this.h);
      char[] var2 = this.d.b(0, var1);
      this.h = var2;
      return var2;
   }

   public JsonEncoding b() {
      return this.b;
   }

   public void b(byte[] var1) {
      if (var1 != null) {
         this.a(var1, this.f);
         this.f = null;
         this.d.a(1, var1);
      }
   }

   public void b(char[] var1) {
      if (var1 != null) {
         this.a(var1, this.i);
         this.i = null;
         this.d.a(1, var1);
      }
   }

   public void c(char[] var1) {
      if (var1 != null) {
         this.a(var1, this.j);
         this.j = null;
         this.d.a(3, var1);
      }
   }

   public boolean c() {
      return this.c;
   }

   public TextBuffer d() {
      return new TextBuffer(this.d);
   }

   public byte[] e() {
      this.a(this.e);
      byte[] var1 = this.d.a(0);
      this.e = var1;
      return var1;
   }

   public byte[] f() {
      this.a(this.f);
      byte[] var1 = this.d.a(1);
      this.f = var1;
      return var1;
   }

   public char[] g() {
      this.a(this.h);
      char[] var1 = this.d.b(0);
      this.h = var1;
      return var1;
   }

   public char[] h() {
      this.a(this.i);
      char[] var1 = this.d.b(1);
      this.i = var1;
      return var1;
   }
}
