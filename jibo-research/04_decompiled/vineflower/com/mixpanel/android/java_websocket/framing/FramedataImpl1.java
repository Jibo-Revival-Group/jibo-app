package com.mixpanel.android.java_websocket.framing;

import com.mixpanel.android.java_websocket.exceptions.InvalidDataException;
import com.mixpanel.android.java_websocket.util.Charsetfunctions;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class FramedataImpl1 implements FrameBuilder {
   protected static byte[] b = new byte[0];
   private ByteBuffer a;
   protected boolean c;
   protected Framedata.Opcode d;
   protected boolean e;

   public FramedataImpl1() {
   }

   public FramedataImpl1(Framedata.Opcode var1) {
      this.d = var1;
      this.a = ByteBuffer.wrap(b);
   }

   public FramedataImpl1(Framedata var1) {
      this.c = var1.d();
      this.d = var1.f();
      this.a = var1.c();
      this.e = var1.e();
   }

   @Override
   public void a(Framedata.Opcode var1) {
      this.d = var1;
   }

   @Override
   public void a(ByteBuffer var1) throws InvalidDataException {
      this.a = var1;
   }

   @Override
   public void a(boolean var1) {
      this.c = var1;
   }

   @Override
   public ByteBuffer c() {
      return this.a;
   }

   @Override
   public boolean d() {
      return this.c;
   }

   @Override
   public boolean e() {
      return this.e;
   }

   @Override
   public Framedata.Opcode f() {
      return this.d;
   }

   @Override
   public String toString() {
      return "Framedata{ optcode:"
         + this.f()
         + ", fin:"
         + this.d()
         + ", payloadlength:[pos:"
         + this.a.position()
         + ", len:"
         + this.a.remaining()
         + "], payload:"
         + Arrays.toString(Charsetfunctions.a(new String(this.a.array())))
         + "}";
   }
}
