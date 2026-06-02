package com.mixpanel.android.viewcrawler;

import com.mixpanel.android.java_websocket.client.WebSocketClient;
import com.mixpanel.android.java_websocket.drafts.Draft_17;
import com.mixpanel.android.java_websocket.exceptions.NotSendableException;
import com.mixpanel.android.java_websocket.exceptions.WebsocketNotConnectedException;
import com.mixpanel.android.java_websocket.framing.Framedata;
import com.mixpanel.android.java_websocket.handshake.ServerHandshake;
import com.mixpanel.android.util.MPLog;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.URI;
import java.nio.ByteBuffer;
import org.json.JSONException;
import org.json.JSONObject;

class EditorConnection {
   private static final ByteBuffer d = ByteBuffer.allocate(0);
   private final EditorConnection.Editor a;
   private final EditorConnection.EditorClient b;
   private final URI c;

   public EditorConnection(URI var1, EditorConnection.Editor var2, Socket var3) throws EditorConnection.EditorConnectionException {
      this.a = var2;
      this.c = var1;

      try {
         EditorConnection.EditorClient var5 = new EditorConnection.EditorClient(this, var1, 5000, var3);
         this.b = var5;
         this.b.c();
      } catch (InterruptedException var4) {
         throw new EditorConnection.EditorConnectionException(this, var4);
      }
   }

   public boolean a() {
      boolean var1;
      if (!this.b.f() && !this.b.g() && !this.b.e()) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public boolean b() {
      return this.b.d();
   }

   public BufferedOutputStream c() {
      return new BufferedOutputStream(new EditorConnection.WebSocketOutputStream(this));
   }

   public interface Editor {
      void a();

      void a(JSONObject var1);

      void b();

      void b(JSONObject var1);

      void c(JSONObject var1);

      void d(JSONObject var1);

      void e(JSONObject var1);
   }

   private class EditorClient extends WebSocketClient {
      final EditorConnection c;

      public EditorClient(EditorConnection var1, URI var2, int var3, Socket var4) throws InterruptedException {
         super(var2, new Draft_17(), null, var3);
         this.c = var1;
         this.a(var4);
      }

      @Override
      public void a(ServerHandshake var1) {
         MPLog.a("MixpanelAPI.EditorCnctn", "Websocket connected");
      }

      @Override
      public void a(Exception var1) {
         if (var1 != null && var1.getMessage() != null) {
            MPLog.e("MixpanelAPI.EditorCnctn", "Websocket Error: " + var1.getMessage());
         } else {
            MPLog.e("MixpanelAPI.EditorCnctn", "Unknown websocket error occurred");
         }
      }

      @Override
      public void a(String var1) {
         MPLog.a("MixpanelAPI.EditorCnctn", "Received message from editor:\n" + var1);

         try {
            JSONObject var3 = new JSONObject(var1);
            String var2 = var3.getString("type");
            if (var2.equals("device_info_request")) {
               this.c.a.a();
            } else if (var2.equals("snapshot_request")) {
               this.c.a.a(var3);
            } else if (var2.equals("change_request")) {
               this.c.a.b(var3);
            } else if (var2.equals("event_binding_request")) {
               this.c.a.d(var3);
            } else if (var2.equals("clear_request")) {
               this.c.a.c(var3);
            } else if (var2.equals("tweak_request")) {
               this.c.a.e(var3);
            }
         } catch (JSONException var4) {
            MPLog.e("MixpanelAPI.EditorCnctn", "Bad JSON received:" + var1, var4);
         }
      }

      @Override
      public void b(int var1, String var2, boolean var3) {
         MPLog.a("MixpanelAPI.EditorCnctn", "WebSocket closed. Code: " + var1 + ", reason: " + var2 + "\nURI: " + this.c.c);
         this.c.a.b();
      }
   }

   public class EditorConnectionException extends IOException {
      final EditorConnection a;

      public EditorConnectionException(EditorConnection var1, Throwable var2) {
         super(var2.getMessage());
         this.a = var1;
      }
   }

   private class WebSocketOutputStream extends OutputStream {
      final EditorConnection a;

      private WebSocketOutputStream(EditorConnection var1) {
         this.a = var1;
      }

      @Override
      public void close() throws EditorConnection.EditorConnectionException {
         try {
            this.a.b.a(Framedata.Opcode.TEXT, EditorConnection.d, true);
         } catch (WebsocketNotConnectedException var2) {
            throw this.a.new EditorConnectionException(this.a, var2);
         } catch (NotSendableException var3) {
            throw this.a.new EditorConnectionException(this.a, var3);
         }
      }

      @Override
      public void write(int var1) throws EditorConnection.EditorConnectionException {
         this.write(new byte[]{(byte)var1}, 0, 1);
      }

      @Override
      public void write(byte[] var1) throws EditorConnection.EditorConnectionException {
         this.write(var1, 0, var1.length);
      }

      @Override
      public void write(byte[] var1, int var2, int var3) throws EditorConnection.EditorConnectionException {
         ByteBuffer var6 = ByteBuffer.wrap(var1, var2, var3);

         try {
            this.a.b.a(Framedata.Opcode.TEXT, var6, false);
         } catch (WebsocketNotConnectedException var4) {
            throw this.a.new EditorConnectionException(this.a, var4);
         } catch (NotSendableException var5) {
            throw this.a.new EditorConnectionException(this.a, var5);
         }
      }
   }
}
