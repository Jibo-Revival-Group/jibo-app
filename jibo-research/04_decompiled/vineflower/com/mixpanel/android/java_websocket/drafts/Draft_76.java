package com.mixpanel.android.java_websocket.drafts;

import android.annotation.SuppressLint;
import com.mixpanel.android.java_websocket.WebSocket;
import com.mixpanel.android.java_websocket.exceptions.IncompleteHandshakeException;
import com.mixpanel.android.java_websocket.exceptions.InvalidDataException;
import com.mixpanel.android.java_websocket.exceptions.InvalidFrameException;
import com.mixpanel.android.java_websocket.exceptions.InvalidHandshakeException;
import com.mixpanel.android.java_websocket.framing.CloseFrameBuilder;
import com.mixpanel.android.java_websocket.framing.Framedata;
import com.mixpanel.android.java_websocket.handshake.ClientHandshake;
import com.mixpanel.android.java_websocket.handshake.ClientHandshakeBuilder;
import com.mixpanel.android.java_websocket.handshake.HandshakeBuilder;
import com.mixpanel.android.java_websocket.handshake.Handshakedata;
import com.mixpanel.android.java_websocket.handshake.ServerHandshake;
import com.mixpanel.android.java_websocket.handshake.ServerHandshakeBuilder;
import java.nio.Buffer;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@SuppressLint("UseValueOf")
public class Draft_76 extends Draft_75 {
   private static final byte[] j = new byte[]{-1, 0};
   private boolean i = false;
   private final Random k = new Random();

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private static byte[] a(String var0) throws InvalidHandshakeException {
      long var5;
      long var7;
      try {
         var7 = Long.parseLong(var0.replaceAll("[^0-9]", ""));
         var5 = var0.split(" ").length - 1;
      } catch (NumberFormatException var11) {
         throw new InvalidHandshakeException("invalid Sec-WebSocket-Key (/key1/ or /key2/)");
      }

      if (var5 == 0L) {
         try {
            InvalidHandshakeException var13 = new InvalidHandshakeException("invalid Sec-WebSocket-Key (/key2/)");
            throw var13;
         } catch (NumberFormatException var9) {
            throw new InvalidHandshakeException("invalid Sec-WebSocket-Key (/key1/ or /key2/)");
         }
      } else {
         try {
            Long var12 = new Long(var7 / var5);
            var5 = var12;
         } catch (NumberFormatException var10) {
            throw new InvalidHandshakeException("invalid Sec-WebSocket-Key (/key1/ or /key2/)");
         }

         byte var2 = (byte)(var5 >> 24);
         byte var3 = (byte)(var5 << 8 >> 24);
         byte var4 = (byte)(var5 << 16 >> 24);
         byte var1 = (byte)(var5 << 24 >> 24);
         return new byte[]{var2, var3, var4, var1};
      }
   }

   public static byte[] a(String var0, String var1, byte[] var2) throws InvalidHandshakeException {
      byte[] var20 = a(var0);
      byte[] var22 = a(var1);
      byte var11 = var20[0];
      byte var16 = var20[1];
      byte var3 = var20[2];
      byte var12 = var20[3];
      byte var6 = var22[0];
      byte var7 = var22[1];
      byte var8 = var22[2];
      byte var13 = var22[3];
      byte var14 = var2[0];
      byte var10 = var2[1];
      byte var15 = var2[2];
      byte var18 = var2[3];
      byte var17 = var2[4];
      byte var9 = var2[5];
      byte var4 = var2[6];
      byte var5 = var2[7];

      try {
         var21 = MessageDigest.getInstance("MD5");
      } catch (NoSuchAlgorithmException var19) {
         throw new RuntimeException(var19);
      }

      return var21.digest(new byte[]{var11, var16, var3, var12, var6, var7, var8, var13, var14, var10, var15, var18, var17, var9, var4, var5});
   }

   private static String e() {
      Random var8 = new Random();
      long var5 = var8.nextInt(12) + 1;
      String var7 = Long.toString((var8.nextInt(Math.abs(new Long(4294967295L / var5).intValue())) + 1) * var5);
      int var3 = var8.nextInt(12);

      for (int var2 = 0; var2 < var3 + 1; var2++) {
         int var4 = Math.abs(var8.nextInt(var7.length()));
         char var1 = (char)(var8.nextInt(95) + 33);
         char var0 = var1;
         if (var1 >= '0') {
            var0 = var1;
            if (var1 <= '9') {
               var0 = (char)(var1 - 15);
            }
         }

         var7 = new StringBuilder(var7).insert(var4, var0).toString();
      }

      for (int var9 = 0; var9 < var5; var9++) {
         var3 = Math.abs(var8.nextInt(var7.length() - 1) + 1);
         var7 = new StringBuilder(var7).insert(var3, " ").toString();
      }

      return var7;
   }

   @Override
   public Draft.HandshakeState a(ClientHandshake var1) {
      Draft.HandshakeState var2;
      if (var1.b("Upgrade").equals("WebSocket")
         && var1.b("Connection").contains("Upgrade")
         && var1.b("Sec-WebSocket-Key1").length() > 0
         && !var1.b("Sec-WebSocket-Key2").isEmpty()
         && var1.c("Origin")) {
         var2 = Draft.HandshakeState.MATCHED;
      } else {
         var2 = Draft.HandshakeState.NOT_MATCHED;
      }

      return var2;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   @Override
   public Draft.HandshakeState a(ClientHandshake var1, ServerHandshake var2) {
      Draft.HandshakeState var10;
      if (this.i) {
         var10 = Draft.HandshakeState.NOT_MATCHED;
      } else {
         label72: {
            try {
               if (!var2.b("Sec-WebSocket-Origin").equals(var1.b("Origin")) || !this.a(var2)) {
                  break label72;
               }
            } catch (InvalidHandshakeException var9) {
               throw new RuntimeException("bad handshakerequest", var9);
            }

            try {
               var12 = var2.c();
            } catch (InvalidHandshakeException var5) {
               throw new RuntimeException("bad handshakerequest", var5);
            }

            label52:
            if (var12 != null) {
               try {
                  if (var12.length == 0) {
                     break label52;
                  }
               } catch (InvalidHandshakeException var8) {
                  throw new RuntimeException("bad handshakerequest", var8);
               }

               try {
                  if (Arrays.equals(var12, a(var1.b("Sec-WebSocket-Key1"), var1.b("Sec-WebSocket-Key2"), var1.c()))) {
                     return Draft.HandshakeState.MATCHED;
                  }
               } catch (InvalidHandshakeException var7) {
                  throw new RuntimeException("bad handshakerequest", var7);
               }

               try {
                  return Draft.HandshakeState.NOT_MATCHED;
               } catch (InvalidHandshakeException var4) {
                  throw new RuntimeException("bad handshakerequest", var4);
               }
            }

            try {
               IncompleteHandshakeException var11 = new IncompleteHandshakeException();
               throw var11;
            } catch (InvalidHandshakeException var3) {
               throw new RuntimeException("bad handshakerequest", var3);
            }
         }

         try {
            var10 = Draft.HandshakeState.NOT_MATCHED;
         } catch (InvalidHandshakeException var6) {
            throw new RuntimeException("bad handshakerequest", var6);
         }
      }

      return var10;
   }

   @Override
   public ClientHandshakeBuilder a(ClientHandshakeBuilder var1) {
      var1.a("Upgrade", "WebSocket");
      var1.a("Connection", "Upgrade");
      var1.a("Sec-WebSocket-Key1", e());
      var1.a("Sec-WebSocket-Key2", e());
      if (!var1.c("Origin")) {
         var1.a("Origin", "random" + this.k.nextInt());
      }

      byte[] var2 = new byte[8];
      this.k.nextBytes(var2);
      var1.a(var2);
      return var1;
   }

   @Override
   public HandshakeBuilder a(ClientHandshake var1, ServerHandshakeBuilder var2) throws InvalidHandshakeException {
      var2.a("WebSocket Protocol Handshake");
      var2.a("Upgrade", "WebSocket");
      var2.a("Connection", var1.b("Connection"));
      var2.a("Sec-WebSocket-Origin", var1.b("Origin"));
      var2.a("Sec-WebSocket-Location", "ws://" + var1.b("Host") + var1.a());
      String var3 = var1.b("Sec-WebSocket-Key1");
      String var4 = var1.b("Sec-WebSocket-Key2");
      byte[] var5 = var1.c();
      if (var3 != null && var4 != null && var5 != null && var5.length == 8) {
         var2.a(a(var3, var4, var5));
         return var2;
      } else {
         throw new InvalidHandshakeException("Bad keys");
      }
   }

   @Override
   public ByteBuffer a(Framedata var1) {
      ByteBuffer var2;
      if (var1.f() == Framedata.Opcode.CLOSING) {
         var2 = ByteBuffer.wrap(j);
      } else {
         var2 = super.a(var1);
      }

      return var2;
   }

   @Override
   public Draft.CloseHandshakeType b() {
      return Draft.CloseHandshakeType.ONEWAY;
   }

   @Override
   public Draft c() {
      return new Draft_76();
   }

   @Override
   public List<Framedata> c(ByteBuffer var1) throws InvalidDataException {
      ((Buffer)var1).mark();
      List var3 = super.e(var1);
      List var2 = var3;
      if (var3 == null) {
         ((Buffer)var1).reset();
         var2 = this.g;
         this.f = true;
         if (this.h != null) {
            throw new InvalidFrameException();
         }

         this.h = ByteBuffer.allocate(2);
         if (var1.remaining() > this.h.remaining()) {
            throw new InvalidFrameException();
         }

         this.h.put(var1);
         if (!this.h.hasRemaining()) {
            if (!Arrays.equals(this.h.array(), j)) {
               throw new InvalidFrameException();
            }

            var2.add(new CloseFrameBuilder(1000));
         } else {
            this.g = new LinkedList<>();
         }
      }

      return var2;
   }

   @Override
   public Handshakedata d(ByteBuffer var1) throws InvalidHandshakeException {
      HandshakeBuilder var3 = a(var1, this.d);
      if ((var3.c("Sec-WebSocket-Key1") || this.d == WebSocket.Role.CLIENT) && !var3.c("Sec-WebSocket-Version")) {
         byte var2;
         if (this.d == WebSocket.Role.SERVER) {
            var2 = 8;
         } else {
            var2 = 16;
         }

         byte[] var4 = new byte[var2];

         try {
            var1.get(var4);
         } catch (BufferUnderflowException var5) {
            throw new IncompleteHandshakeException(var1.capacity() + 16);
         }

         var3.a(var4);
      }

      return var3;
   }
}
