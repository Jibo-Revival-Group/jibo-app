.class public interface abstract Lcom/mixpanel/android/java_websocket/framing/FrameBuilder;
.super Ljava/lang/Object;
.source "FrameBuilder.java"

# interfaces
.implements Lcom/mixpanel/android/java_websocket/framing/Framedata;


# virtual methods
.method public abstract a(Lcom/mixpanel/android/java_websocket/framing/Framedata$Opcode;)V
.end method

.method public abstract a(Ljava/nio/ByteBuffer;)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/mixpanel/android/java_websocket/exceptions/InvalidDataException;
        }
    .end annotation
.end method

.method public abstract a(Z)V
.end method
