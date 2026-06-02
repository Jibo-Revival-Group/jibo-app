package com.mixpanel.android.java_websocket.drafts;

import android.annotation.SuppressLint;
import com.mixpanel.android.java_websocket.WebSocket;
import com.mixpanel.android.java_websocket.exceptions.InvalidDataException;
import com.mixpanel.android.java_websocket.exceptions.InvalidFrameException;
import com.mixpanel.android.java_websocket.exceptions.InvalidHandshakeException;
import com.mixpanel.android.java_websocket.exceptions.LimitExedeedException;
import com.mixpanel.android.java_websocket.framing.CloseFrameBuilder;
import com.mixpanel.android.java_websocket.framing.Framedata;
import com.mixpanel.android.java_websocket.framing.FramedataImpl1;
import com.mixpanel.android.java_websocket.handshake.ClientHandshake;
import com.mixpanel.android.java_websocket.handshake.ClientHandshakeBuilder;
import com.mixpanel.android.java_websocket.handshake.HandshakeBuilder;
import com.mixpanel.android.java_websocket.handshake.Handshakedata;
import com.mixpanel.android.java_websocket.handshake.ServerHandshake;
import com.mixpanel.android.java_websocket.handshake.ServerHandshakeBuilder;
import com.mixpanel.android.java_websocket.util.Base64;
import java.math.BigInteger;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@SuppressLint({"Assert", "UseValueOf"})
public class Draft_10 extends Draft {
   static final boolean f;
   private ByteBuffer g;
   private Framedata h = null;
   private final Random i = new Random();

   static {
      boolean var0;
      if (!Draft_10.class.desiredAssertionStatus()) {
         var0 = true;
      } else {
         var0 = false;
      }

      f = var0;
   }

   private byte a(Framedata.Opcode var1) {
      byte var2;
      if (var1 == Framedata.Opcode.CONTINUOUS) {
         var2 = 0;
      } else if (var1 == Framedata.Opcode.TEXT) {
         var2 = 1;
      } else if (var1 == Framedata.Opcode.BINARY) {
         var2 = 2;
      } else if (var1 == Framedata.Opcode.CLOSING) {
         var2 = 8;
      } else if (var1 == Framedata.Opcode.PING) {
         var2 = 9;
      } else {
         if (var1 != Framedata.Opcode.PONG) {
            throw new RuntimeException("Don't know how to handle " + var1.toString());
         }

         var2 = 10;
      }

      return var2;
   }

   private Framedata.Opcode a(byte var1) throws InvalidFrameException {
      Framedata.Opcode var2;
      switch (var1) {
         case 0:
            var2 = Framedata.Opcode.CONTINUOUS;
            break;
         case 1:
            var2 = Framedata.Opcode.TEXT;
            break;
         case 2:
            var2 = Framedata.Opcode.BINARY;
            break;
         case 3:
         case 4:
         case 5:
         case 6:
         case 7:
         default:
            throw new InvalidFrameException("unknow optcode " + var1);
         case 8:
            var2 = Framedata.Opcode.CLOSING;
            break;
         case 9:
            var2 = Framedata.Opcode.PING;
            break;
         case 10:
            var2 = Framedata.Opcode.PONG;
      }

      return var2;
   }

   private String a(String var1) {
      var1 = var1.trim();
      var1 = var1 + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";

      MessageDigest var2;
      try {
         var2 = MessageDigest.getInstance("SHA1");
      } catch (NoSuchAlgorithmException var3) {
         throw new RuntimeException(var3);
      }

      return Base64.a(var2.digest(var1.getBytes()));
   }

   private byte[] a(long var1, int var3) {
      byte[] var5 = new byte[var3];

      for (int var4 = 0; var4 < var3; var4++) {
         var5[var4] = (byte)(var1 >>> var3 * 8 - 8 - var4 * 8);
      }

      return var5;
   }

   public static int b(Handshakedata var0) {
      byte var2 = -1;
      String var3 = var0.b("Sec-WebSocket-Version");
      int var1 = var2;
      if (var3.length() > 0) {
         try {
            Integer var5 = new Integer(var3.trim());
            var1 = var5;
         } catch (NumberFormatException var4) {
            var1 = var2;
         }
      }

      return var1;
   }

   @Override
   public Draft.HandshakeState a(ClientHandshake var1) throws InvalidHandshakeException {
      int var2 = b(var1);
      Draft.HandshakeState var3;
      if (var2 != 7 && var2 != 8) {
         var3 = Draft.HandshakeState.NOT_MATCHED;
      } else if (this.a(var1)) {
         var3 = Draft.HandshakeState.MATCHED;
      } else {
         var3 = Draft.HandshakeState.NOT_MATCHED;
      }

      return var3;
   }

   @Override
   public Draft.HandshakeState a(ClientHandshake var1, ServerHandshake var2) throws InvalidHandshakeException {
      Draft.HandshakeState var3;
      if (var1.c("Sec-WebSocket-Key") && var2.c("Sec-WebSocket-Accept")) {
         String var4 = var2.b("Sec-WebSocket-Accept");
         if (this.a(var1.b("Sec-WebSocket-Key")).equals(var4)) {
            var3 = Draft.HandshakeState.MATCHED;
         } else {
            var3 = Draft.HandshakeState.NOT_MATCHED;
         }
      } else {
         var3 = Draft.HandshakeState.NOT_MATCHED;
      }

      return var3;
   }

   @Override
   public ClientHandshakeBuilder a(ClientHandshakeBuilder var1) {
      var1.a("Upgrade", "websocket");
      var1.a("Connection", "Upgrade");
      var1.a("Sec-WebSocket-Version", "8");
      byte[] var2 = new byte[16];
      this.i.nextBytes(var2);
      var1.a("Sec-WebSocket-Key", Base64.a(var2));
      return var1;
   }

   @Override
   public HandshakeBuilder a(ClientHandshake var1, ServerHandshakeBuilder var2) throws InvalidHandshakeException {
      var2.a("Upgrade", "websocket");
      var2.a("Connection", var1.b("Connection"));
      var2.a("Switching Protocols");
      String var3 = var1.b("Sec-WebSocket-Key");
      if (var3 == null) {
         throw new InvalidHandshakeException("missing Sec-WebSocket-Key");
      }

      var2.a("Sec-WebSocket-Accept", this.a(var3));
      return var2;
   }

   @Override
   public ByteBuffer a(Framedata var1) {
      byte var3 = -128;
      byte var7 = 0;
      ByteBuffer var9 = var1.c();
      boolean var4;
      if (this.d == WebSocket.Role.CLIENT) {
         var4 = true;
      } else {
         var4 = false;
      }

      byte var2;
      if (var9.remaining() <= 125) {
         var2 = 1;
      } else if (var9.remaining() <= 65535) {
         var2 = 2;
      } else {
         var2 = 8;
      }

      int var5;
      if (var2 > 1) {
         var5 = var2 + 1;
      } else {
         var5 = var2;
      }

      byte var6;
      if (var4) {
         var6 = 4;
      } else {
         var6 = 0;
      }

      ByteBuffer var8 = ByteBuffer.allocate(var6 + var5 + 1 + var9.remaining());
      var6 = this.a(var1.f());
      byte var14;
      if (var1.d()) {
         var14 = -128;
      } else {
         var14 = 0;
      }

      var8.put((byte)((byte)var14 | var6));
      byte[] var10 = this.a(var9.remaining(), var2);
      if (!f && var10.length != var2) {
         throw new AssertionError();
      }

      if (var2 == 1) {
         var2 = var10[0];
         if (!var4) {
            var3 = 0;
         }

         var8.put((byte)(var2 | var3));
      } else if (var2 == 2) {
         if (!var4) {
            var3 = 0;
         }

         var8.put((byte)(var3 | 126));
         var8.put(var10);
      } else {
         if (var2 != 8) {
            throw new RuntimeException("Size representation not supported/specified");
         }

         if (!var4) {
            var3 = 0;
         }

         var8.put((byte)(var3 | 127));
         var8.put(var10);
      }

      if (var4) {
         ByteBuffer var11 = ByteBuffer.allocate(4);
         var11.putInt(this.i.nextInt());
         var8.put(var11.array());

         for (int var13 = var7; var9.hasRemaining(); var13++) {
            var8.put((byte)(var9.get() ^ var11.get(var13 % 4)));
         }
      } else {
         var8.put(var9);
      }

      if (!f && var8.remaining() != 0) {
         throw new AssertionError(var8.remaining());
      }

      ((Buffer)var8).flip();
      return var8;
   }

   @Override
   public void a() {
      this.g = null;
   }

   @Override
   public Draft.CloseHandshakeType b() {
      return Draft.CloseHandshakeType.TWOWAY;
   }

   @Override
   public Draft c() {
      return new Draft_10();
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   @Override
   public List<Framedata> c(ByteBuffer var1) throws LimitExedeedException, InvalidDataException {
      ByteBuffer var11;
      label52: {
         label65: {
            LinkedList var4 = new LinkedList();
            if (this.g != null) {
               int var2;
               int var3;
               try {
                  ((Buffer)var1).mark();
                  var2 = var1.remaining();
                  var3 = this.g.remaining();
               } catch (Draft_10.IncompleteException var9) {
                  this.g.limit();
                  var11 = ByteBuffer.allocate(this.a(var9.a()));
                  if (f) {
                     break label52;
                  }
                  break label65;
               }

               if (var3 > var2) {
                  try {
                     this.g.put(var1.array(), var1.position(), var2);
                     ((Buffer)var1).position(var2 + var1.position());
                     return Collections.emptyList();
                  } catch (Draft_10.IncompleteException var7) {
                     this.g.limit();
                     var11 = ByteBuffer.allocate(this.a(var7.a()));
                     if (f) {
                        break label52;
                     }
                     break label65;
                  }
               }

               try {
                  this.g.put(var1.array(), var1.position(), var3);
                  ((Buffer)var1).position(var1.position() + var3);
                  var4.add(this.e((ByteBuffer)((Buffer)this.g.duplicate()).position(0)));
                  this.g = null;
               } catch (Draft_10.IncompleteException var8) {
                  this.g.limit();
                  var11 = ByteBuffer.allocate(this.a(var8.a()));
                  if (f) {
                     break label52;
                  }
                  break label65;
               }
            }

            while (var1.hasRemaining()) {
               ((Buffer)var1).mark();

               try {
                  var4.add(this.e(var1));
               } catch (Draft_10.IncompleteException var6) {
                  ((Buffer)var1).reset();
                  this.g = ByteBuffer.allocate(this.a(var6.a()));
                  this.g.put(var1);
                  break;
               }
            }

            return var4;
         }

         if (var11.limit() <= this.g.limit()) {
            throw new AssertionError();
         }
      }

      ((Buffer)this.g).rewind();
      var11.put(this.g);
      this.g = var11;
      return this.c(var1);
   }

   public Framedata e(ByteBuffer var1) throws Draft_10.IncompleteException, InvalidDataException {
      int var3 = 2;
      byte var6 = 0;
      int var7 = var1.remaining();
      if (var7 < 2) {
         throw new Draft_10.IncompleteException(this, 2);
      }

      byte var5 = var1.get();
      boolean var8;
      if (var5 >> 8 != 0) {
         var8 = true;
      } else {
         var8 = false;
      }

      int var2 = (byte)((var5 & 127) >> 4);
      if (var2 != 0) {
         throw new InvalidFrameException("bad rsv " + var2);
      }

      var2 = var1.get();
      boolean var4;
      if ((var2 & -128) != 0) {
         var4 = true;
      } else {
         var4 = false;
      }

      var2 = (byte)(var2 & 127);
      Framedata.Opcode var11 = this.a((byte)(var5 & 15));
      if (var8 || var11 != Framedata.Opcode.PING && var11 != Framedata.Opcode.PONG && var11 != Framedata.Opcode.CLOSING) {
         if (var2 < 0 || var2 > 125) {
            if (var11 == Framedata.Opcode.PING || var11 == Framedata.Opcode.PONG || var11 == Framedata.Opcode.CLOSING) {
               throw new InvalidFrameException("more than 125 octets");
            }

            if (var2 == 126) {
               if (var7 < 4) {
                  throw new Draft_10.IncompleteException(this, 4);
               }

               byte[] var12 = new byte[]{0, var1.get(), var1.get()};
               var2 = new BigInteger(var12).intValue();
               var3 = 4;
            } else {
               if (var7 < 10) {
                  throw new Draft_10.IncompleteException(this, 10);
               }

               byte[] var21 = new byte[8];

               for (int var17 = 0; var17 < 8; var17++) {
                  var21[var17] = var1.get();
               }

               long var9 = new BigInteger(var21).longValue();
               if (var9 > 2147483647L) {
                  throw new LimitExedeedException("Payloadsize is to big...");
               }

               var2 = (int)var9;
               var3 = 10;
            }
         }

         if (var4) {
            var5 = 4;
         } else {
            var5 = 0;
         }

         var3 = var5 + var3 + var2;
         if (var7 < var3) {
            throw new Draft_10.IncompleteException(this, var3);
         }

         ByteBuffer var22 = ByteBuffer.allocate(this.a(var2));
         if (var4) {
            byte[] var13 = new byte[4];
            var1.get(var13);

            for (int var19 = var6; var19 < var2; var19++) {
               var22.put((byte)(var1.get() ^ var13[var19 % 4]));
            }
         } else {
            var22.put(var1.array(), var1.position(), var22.limit());
            ((Buffer)var1).position(var1.position() + var22.limit());
         }

         FramedataImpl1 var14;
         if (var11 == Framedata.Opcode.CLOSING) {
            var14 = new CloseFrameBuilder();
         } else {
            var14 = new FramedataImpl1();
            var14.a(var8);
            var14.a(var11);
         }

         ((Buffer)var22).flip();
         var14.a(var22);
         return var14;
      } else {
         throw new InvalidFrameException("control frames may no be fragmented");
      }
   }

   private class IncompleteException extends Throwable {
      final Draft_10 a;
      private int b;

      public IncompleteException(Draft_10 var1, int var2) {
         this.a = var1;
         this.b = var2;
      }

      public int a() {
         return this.b;
      }
   }
}
