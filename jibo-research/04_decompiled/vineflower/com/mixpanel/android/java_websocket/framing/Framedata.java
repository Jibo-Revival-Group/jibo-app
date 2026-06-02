package com.mixpanel.android.java_websocket.framing;

import java.nio.ByteBuffer;

public interface Framedata {
   ByteBuffer c();

   boolean d();

   boolean e();

   Framedata.Opcode f();

   enum Opcode {
      BINARY,
      CLOSING,
      CONTINUOUS,
      PING,
      PONG,
      TEXT;

      private static final Framedata.Opcode[] $VALUES = new Framedata.Opcode[]{
         Framedata.Opcode.CONTINUOUS, Framedata.Opcode.TEXT, Framedata.Opcode.BINARY, Framedata.Opcode.PING, Framedata.Opcode.PONG, Framedata.Opcode.CLOSING
      };
   }
}
