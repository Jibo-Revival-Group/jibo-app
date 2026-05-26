.class abstract Lcom/segment/analytics/PayloadQueue;
.super Ljava/lang/Object;
.source "PayloadQueue.java"

# interfaces
.implements Ljava/io/Closeable;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/segment/analytics/PayloadQueue$MemoryQueue;,
        Lcom/segment/analytics/PayloadQueue$PersistentQueue;,
        Lcom/segment/analytics/PayloadQueue$ElementVisitor;
    }
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 33
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method abstract add([B)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation
.end method

.method abstract forEach(Lcom/segment/analytics/PayloadQueue$ElementVisitor;)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation
.end method

.method abstract remove(I)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation
.end method

.method abstract size()I
.end method
