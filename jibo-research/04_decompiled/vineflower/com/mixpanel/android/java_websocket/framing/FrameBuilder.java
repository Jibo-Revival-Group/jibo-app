package com.mixpanel.android.java_websocket.framing;

import com.mixpanel.android.java_websocket.exceptions.InvalidDataException;
import java.nio.ByteBuffer;

public interface FrameBuilder extends Framedata {
   void a(Framedata.Opcode var1);

   void a(ByteBuffer var1) throws InvalidDataException;

   void a(boolean var1);
}
