.class public interface abstract Lcom/mixpanel/android/java_websocket/framing/CloseFrame;
.super Ljava/lang/Object;
.source "CloseFrame.java"

# interfaces
.implements Lcom/mixpanel/android/java_websocket/framing/Framedata;


# virtual methods
.method public abstract a()I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/mixpanel/android/java_websocket/exceptions/InvalidFrameException;
        }
    .end annotation
.end method

.method public abstract b()Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/mixpanel/android/java_websocket/exceptions/InvalidDataException;
        }
    .end annotation
.end method
