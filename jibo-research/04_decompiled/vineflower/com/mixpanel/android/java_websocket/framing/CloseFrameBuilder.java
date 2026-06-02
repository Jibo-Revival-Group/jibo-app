package com.mixpanel.android.java_websocket.framing;

import com.mixpanel.android.java_websocket.exceptions.InvalidDataException;
import com.mixpanel.android.java_websocket.exceptions.InvalidFrameException;
import com.mixpanel.android.java_websocket.util.Charsetfunctions;
import java.nio.Buffer;
import java.nio.ByteBuffer;

public class CloseFrameBuilder extends FramedataImpl1 implements CloseFrame {
   static final ByteBuffer a = ByteBuffer.allocate(0);
   private int f;
   private String g;

   public CloseFrameBuilder() {
      super(Framedata.Opcode.CLOSING);
      this.a(true);
   }

   public CloseFrameBuilder(int var1) throws InvalidDataException {
      super(Framedata.Opcode.CLOSING);
      this.a(true);
      this.a(var1, "");
   }

   public CloseFrameBuilder(int var1, String var2) throws InvalidDataException {
      super(Framedata.Opcode.CLOSING);
      this.a(true);
      this.a(var1, var2);
   }

   private void a(int var1, String var2) throws InvalidDataException {
      if (var2 == null) {
         var2 = "";
      }

      int var3 = var1;
      if (var1 == 1015) {
         var2 = "";
         var3 = 1005;
      }

      if (var3 == 1005) {
         if (var2.length() > 0) {
            throw new InvalidDataException(1002, "A close frame must have a closecode if it has a reason");
         }
      } else {
         byte[] var5 = Charsetfunctions.a(var2);
         ByteBuffer var4 = ByteBuffer.allocate(4);
         var4.putInt(var3);
         ((Buffer)var4).position(2);
         ByteBuffer var6 = ByteBuffer.allocate(var5.length + 2);
         var6.put(var4);
         var6.put(var5);
         ((Buffer)var6).rewind();
         this.a(var6);
      }
   }

   private void g() throws InvalidFrameException {
      this.f = 1005;
      ByteBuffer var1 = super.c();
      ((Buffer)var1).mark();
      if (var1.remaining() >= 2) {
         ByteBuffer var2 = ByteBuffer.allocate(4);
         ((Buffer)var2).position(2);
         var2.putShort(var1.getShort());
         ((Buffer)var2).position(0);
         this.f = var2.getInt();
         if (this.f == 1006 || this.f == 1015 || this.f == 1005 || this.f > 4999 || this.f < 1000 || this.f == 1004) {
            throw new InvalidFrameException("closecode must not be sent over the wire: " + this.f);
         }
      }

      ((Buffer)var1).reset();
   }

   private void h() throws InvalidDataException {
      if (this.f == 1005) {
         this.g = Charsetfunctions.a(super.c());
      } else {
         ByteBuffer var2 = super.c();
         int var1 = var2.position();

         try {
            ((Buffer)var2).position(var2.position() + 2);
            this.g = Charsetfunctions.a(var2);
         } catch (IllegalArgumentException var7) {
            InvalidFrameException var3 = new InvalidFrameException(var7);
            throw var3;
         } finally {
            ((Buffer)var2).position(var1);
         }
      }
   }

   @Override
   public int a() {
      return this.f;
   }

   @Override
   public void a(ByteBuffer var1) throws InvalidDataException {
      super.a(var1);
      this.g();
      this.h();
   }

   @Override
   public String b() {
      return this.g;
   }

   @Override
   public ByteBuffer c() {
      ByteBuffer var1;
      if (this.f == 1005) {
         var1 = a;
      } else {
         var1 = super.c();
      }

      return var1;
   }

   @Override
   public String toString() {
      return super.toString() + "code: " + this.f;
   }
}
