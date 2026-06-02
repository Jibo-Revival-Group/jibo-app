package com.mixpanel.android.java_websocket.drafts;

import com.mixpanel.android.java_websocket.WebSocket;
import com.mixpanel.android.java_websocket.exceptions.IncompleteHandshakeException;
import com.mixpanel.android.java_websocket.exceptions.InvalidDataException;
import com.mixpanel.android.java_websocket.exceptions.InvalidHandshakeException;
import com.mixpanel.android.java_websocket.exceptions.LimitExedeedException;
import com.mixpanel.android.java_websocket.framing.Framedata;
import com.mixpanel.android.java_websocket.framing.FramedataImpl1;
import com.mixpanel.android.java_websocket.handshake.ClientHandshake;
import com.mixpanel.android.java_websocket.handshake.ClientHandshakeBuilder;
import com.mixpanel.android.java_websocket.handshake.HandshakeBuilder;
import com.mixpanel.android.java_websocket.handshake.HandshakeImpl1Client;
import com.mixpanel.android.java_websocket.handshake.HandshakeImpl1Server;
import com.mixpanel.android.java_websocket.handshake.Handshakedata;
import com.mixpanel.android.java_websocket.handshake.HandshakedataImpl1;
import com.mixpanel.android.java_websocket.handshake.ServerHandshake;
import com.mixpanel.android.java_websocket.handshake.ServerHandshakeBuilder;
import com.mixpanel.android.java_websocket.util.Charsetfunctions;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public abstract class Draft {
   public static int a = 1000;
   public static int b = 64;
   public static final byte[] c = Charsetfunctions.a("<policy-file-request/>\u0000");
   protected WebSocket.Role d = null;
   protected Framedata.Opcode e = null;

   public static HandshakeBuilder a(ByteBuffer var0, WebSocket.Role var1) throws InvalidHandshakeException, IncompleteHandshakeException {
      String var2 = b(var0);
      if (var2 == null) {
         throw new IncompleteHandshakeException(var0.capacity() + 128);
      }

      String[] var5 = var2.split(" ", 3);
      if (var5.length != 3) {
         throw new InvalidHandshakeException();
      }

      HandshakedataImpl1 var4;
      if (var1 == WebSocket.Role.CLIENT) {
         var4 = new HandshakeImpl1Server();
         ServerHandshakeBuilder var3 = (ServerHandshakeBuilder)var4;
         var3.a(Short.parseShort(var5[1]));
         var3.a(var5[2]);
      } else {
         var4 = new HandshakeImpl1Client();
         var4.a(var5[1]);
      }

      for (var2 = b(var0); var2 != null && var2.length() > 0; var2 = b(var0)) {
         String[] var7 = var2.split(":", 2);
         if (var7.length != 2) {
            throw new InvalidHandshakeException("not an http header");
         }

         var4.a(var7[0], var7[1].replaceFirst("^ +", ""));
      }

      if (var2 == null) {
         throw new IncompleteHandshakeException();
      } else {
         return var4;
      }
   }

   public static ByteBuffer a(ByteBuffer var0) {
      ByteBuffer var3 = ByteBuffer.allocate(var0.remaining());
      byte var2 = 48;

      while (true) {
         if (!var0.hasRemaining()) {
            ((Buffer)var0).position(var0.position() - var3.position());
            var0 = null;
            break;
         }

         byte var1 = var0.get();
         var3.put(var1);
         if (var2 == 13 && var1 == 10) {
            ((Buffer)var3).limit(var3.position() - 2);
            ((Buffer)var3).position(0);
            var0 = var3;
            break;
         }

         var2 = var1;
      }

      return var0;
   }

   public static String b(ByteBuffer var0) {
      var0 = a(var0);
      String var2;
      if (var0 == null) {
         var2 = null;
      } else {
         var2 = Charsetfunctions.a(var0.array(), 0, var0.limit());
      }

      return var2;
   }

   public int a(int var1) throws LimitExedeedException, InvalidDataException {
      if (var1 < 0) {
         throw new InvalidDataException(1002, "Negative count");
      } else {
         return var1;
      }
   }

   public abstract Draft.HandshakeState a(ClientHandshake var1) throws InvalidHandshakeException;

   public abstract Draft.HandshakeState a(ClientHandshake var1, ServerHandshake var2) throws InvalidHandshakeException;

   public abstract ClientHandshakeBuilder a(ClientHandshakeBuilder var1) throws InvalidHandshakeException;

   public abstract HandshakeBuilder a(ClientHandshake var1, ServerHandshakeBuilder var2) throws InvalidHandshakeException;

   public abstract ByteBuffer a(Framedata var1);

   public List<Framedata> a(Framedata.Opcode var1, ByteBuffer var2, boolean var3) {
      if (var1 != Framedata.Opcode.BINARY && var1 != Framedata.Opcode.TEXT && var1 != Framedata.Opcode.TEXT) {
         throw new IllegalArgumentException("Only Opcode.BINARY or  Opcode.TEXT are allowed");
      }

      if (this.e != null) {
         this.e = Framedata.Opcode.CONTINUOUS;
      } else {
         this.e = var1;
      }

      FramedataImpl1 var4 = new FramedataImpl1(this.e);

      try {
         var4.a(var2);
      } catch (InvalidDataException var5) {
         throw new RuntimeException(var5);
      }

      var4.a(var3);
      if (var3) {
         this.e = null;
      } else {
         this.e = var1;
      }

      return Collections.singletonList(var4);
   }

   public List<ByteBuffer> a(Handshakedata var1, WebSocket.Role var2) {
      return this.a(var1, var2, true);
   }

   public List<ByteBuffer> a(Handshakedata var1, WebSocket.Role var2, boolean var3) {
      StringBuilder var9 = new StringBuilder(100);
      if (var1 instanceof ClientHandshake) {
         var9.append("GET ");
         var9.append(((ClientHandshake)var1).a());
         var9.append(" HTTP/1.1");
      } else {
         if (!(var1 instanceof ServerHandshake)) {
            throw new RuntimeException("unknow role");
         }

         var9.append("HTTP/1.1 101 " + ((ServerHandshake)var1).a());
      }

      var9.append("\r\n");
      Iterator var7 = var1.b();

      while (var7.hasNext()) {
         String var5 = (String)var7.next();
         String var6 = var1.b(var5);
         var9.append(var5);
         var9.append(": ");
         var9.append(var6);
         var9.append("\r\n");
      }

      var9.append("\r\n");
      byte[] var10 = Charsetfunctions.b(var9.toString());
      byte[] var8;
      if (var3) {
         var8 = var1.c();
      } else {
         var8 = null;
      }

      int var4;
      if (var8 == null) {
         var4 = 0;
      } else {
         var4 = var8.length;
      }

      ByteBuffer var11 = ByteBuffer.allocate(var4 + var10.length);
      var11.put(var10);
      if (var8 != null) {
         var11.put(var8);
      }

      ((Buffer)var11).flip();
      return Collections.singletonList(var11);
   }

   public abstract void a();

   public void a(WebSocket.Role var1) {
      this.d = var1;
   }

   protected boolean a(Handshakedata var1) {
      boolean var2;
      if (var1.b("Upgrade").equalsIgnoreCase("websocket") && var1.b("Connection").toLowerCase(Locale.ENGLISH).contains("upgrade")) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   public abstract Draft.CloseHandshakeType b();

   public abstract Draft c();

   public abstract List<Framedata> c(ByteBuffer var1) throws InvalidDataException;

   public Handshakedata d(ByteBuffer var1) throws InvalidHandshakeException {
      return a(var1, this.d);
   }

   public enum CloseHandshakeType {
      NONE,
      ONEWAY,
      TWOWAY;

      private static final Draft.CloseHandshakeType[] $VALUES = new Draft.CloseHandshakeType[]{
         Draft.CloseHandshakeType.NONE, Draft.CloseHandshakeType.ONEWAY, Draft.CloseHandshakeType.TWOWAY
      };
   }

   public enum HandshakeState {
      MATCHED,
      NOT_MATCHED;

      private static final Draft.HandshakeState[] $VALUES = new Draft.HandshakeState[]{Draft.HandshakeState.MATCHED, Draft.HandshakeState.NOT_MATCHED};
   }
}
