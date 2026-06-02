package com.mixpanel.android.java_websocket;

import com.mixpanel.android.java_websocket.drafts.Draft;
import com.mixpanel.android.java_websocket.exceptions.InvalidDataException;
import com.mixpanel.android.java_websocket.framing.Framedata;
import com.mixpanel.android.java_websocket.handshake.ClientHandshake;
import com.mixpanel.android.java_websocket.handshake.Handshakedata;
import com.mixpanel.android.java_websocket.handshake.ServerHandshake;
import com.mixpanel.android.java_websocket.handshake.ServerHandshakeBuilder;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;

public interface WebSocketListener {
   ServerHandshakeBuilder a(WebSocket var1, Draft var2, ClientHandshake var3) throws InvalidDataException;

   String a(WebSocket var1) throws InvalidDataException;

   void a(WebSocket var1, int var2, String var3);

   void a(WebSocket var1, int var2, String var3, boolean var4);

   void a(WebSocket var1, Framedata var2);

   void a(WebSocket var1, ClientHandshake var2) throws InvalidDataException;

   void a(WebSocket var1, ClientHandshake var2, ServerHandshake var3) throws InvalidDataException;

   void a(WebSocket var1, Handshakedata var2);

   void a(WebSocket var1, Exception var2);

   void a(WebSocket var1, String var2);

   void a(WebSocket var1, ByteBuffer var2);

   void b(WebSocket var1);

   void b(WebSocket var1, int var2, String var3, boolean var4);

   void b(WebSocket var1, Framedata var2);

   InetSocketAddress c(WebSocket var1);

   void c(WebSocket var1, Framedata var2);
}
