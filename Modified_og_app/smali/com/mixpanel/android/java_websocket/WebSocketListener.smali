.class public interface abstract Lcom/mixpanel/android/java_websocket/WebSocketListener;
.super Ljava/lang/Object;
.source "WebSocketListener.java"


# virtual methods
.method public abstract a(Lcom/mixpanel/android/java_websocket/WebSocket;Lcom/mixpanel/android/java_websocket/drafts/Draft;Lcom/mixpanel/android/java_websocket/handshake/ClientHandshake;)Lcom/mixpanel/android/java_websocket/handshake/ServerHandshakeBuilder;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/mixpanel/android/java_websocket/exceptions/InvalidDataException;
        }
    .end annotation
.end method

.method public abstract a(Lcom/mixpanel/android/java_websocket/WebSocket;)Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/mixpanel/android/java_websocket/exceptions/InvalidDataException;
        }
    .end annotation
.end method

.method public abstract a(Lcom/mixpanel/android/java_websocket/WebSocket;ILjava/lang/String;)V
.end method

.method public abstract a(Lcom/mixpanel/android/java_websocket/WebSocket;ILjava/lang/String;Z)V
.end method

.method public abstract a(Lcom/mixpanel/android/java_websocket/WebSocket;Lcom/mixpanel/android/java_websocket/framing/Framedata;)V
.end method

.method public abstract a(Lcom/mixpanel/android/java_websocket/WebSocket;Lcom/mixpanel/android/java_websocket/handshake/ClientHandshake;)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/mixpanel/android/java_websocket/exceptions/InvalidDataException;
        }
    .end annotation
.end method

.method public abstract a(Lcom/mixpanel/android/java_websocket/WebSocket;Lcom/mixpanel/android/java_websocket/handshake/ClientHandshake;Lcom/mixpanel/android/java_websocket/handshake/ServerHandshake;)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/mixpanel/android/java_websocket/exceptions/InvalidDataException;
        }
    .end annotation
.end method

.method public abstract a(Lcom/mixpanel/android/java_websocket/WebSocket;Lcom/mixpanel/android/java_websocket/handshake/Handshakedata;)V
.end method

.method public abstract a(Lcom/mixpanel/android/java_websocket/WebSocket;Ljava/lang/Exception;)V
.end method

.method public abstract a(Lcom/mixpanel/android/java_websocket/WebSocket;Ljava/lang/String;)V
.end method

.method public abstract a(Lcom/mixpanel/android/java_websocket/WebSocket;Ljava/nio/ByteBuffer;)V
.end method

.method public abstract b(Lcom/mixpanel/android/java_websocket/WebSocket;)V
.end method

.method public abstract b(Lcom/mixpanel/android/java_websocket/WebSocket;ILjava/lang/String;Z)V
.end method

.method public abstract b(Lcom/mixpanel/android/java_websocket/WebSocket;Lcom/mixpanel/android/java_websocket/framing/Framedata;)V
.end method

.method public abstract c(Lcom/mixpanel/android/java_websocket/WebSocket;)Ljava/net/InetSocketAddress;
.end method

.method public abstract c(Lcom/mixpanel/android/java_websocket/WebSocket;Lcom/mixpanel/android/java_websocket/framing/Framedata;)V
.end method
