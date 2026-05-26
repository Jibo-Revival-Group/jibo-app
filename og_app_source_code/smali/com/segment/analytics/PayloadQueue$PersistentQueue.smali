.class Lcom/segment/analytics/PayloadQueue$PersistentQueue;
.super Lcom/segment/analytics/PayloadQueue;
.source "PayloadQueue.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/segment/analytics/PayloadQueue;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "PersistentQueue"
.end annotation


# instance fields
.field final queueFile:Lcom/segment/analytics/QueueFile;


# direct methods
.method constructor <init>(Lcom/segment/analytics/QueueFile;)V
    .locals 0

    .prologue
    .line 59
    invoke-direct {p0}, Lcom/segment/analytics/PayloadQueue;-><init>()V

    .line 60
    iput-object p1, p0, Lcom/segment/analytics/PayloadQueue$PersistentQueue;->queueFile:Lcom/segment/analytics/QueueFile;

    .line 61
    return-void
.end method


# virtual methods
.method add([B)V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 81
    iget-object v0, p0, Lcom/segment/analytics/PayloadQueue$PersistentQueue;->queueFile:Lcom/segment/analytics/QueueFile;

    invoke-virtual {v0, p1}, Lcom/segment/analytics/QueueFile;->add([B)V

    .line 82
    return-void
.end method

.method public close()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 91
    iget-object v0, p0, Lcom/segment/analytics/PayloadQueue$PersistentQueue;->queueFile:Lcom/segment/analytics/QueueFile;

    invoke-virtual {v0}, Lcom/segment/analytics/QueueFile;->close()V

    .line 92
    return-void
.end method

.method forEach(Lcom/segment/analytics/PayloadQueue$ElementVisitor;)V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 86
    iget-object v0, p0, Lcom/segment/analytics/PayloadQueue$PersistentQueue;->queueFile:Lcom/segment/analytics/QueueFile;

    invoke-virtual {v0, p1}, Lcom/segment/analytics/QueueFile;->forEach(Lcom/segment/analytics/PayloadQueue$ElementVisitor;)I

    .line 87
    return-void
.end method

.method remove(I)V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 71
    :try_start_0
    iget-object v0, p0, Lcom/segment/analytics/PayloadQueue$PersistentQueue;->queueFile:Lcom/segment/analytics/QueueFile;

    invoke-virtual {v0, p1}, Lcom/segment/analytics/QueueFile;->remove(I)V
    :try_end_0
    .catch Ljava/lang/ArrayIndexOutOfBoundsException; {:try_start_0 .. :try_end_0} :catch_0

    .line 77
    return-void

    .line 72
    :catch_0
    move-exception v0

    .line 75
    new-instance v1, Ljava/io/IOException;

    invoke-direct {v1, v0}, Ljava/io/IOException;-><init>(Ljava/lang/Throwable;)V

    throw v1
.end method

.method size()I
    .locals 1

    .prologue
    .line 65
    iget-object v0, p0, Lcom/segment/analytics/PayloadQueue$PersistentQueue;->queueFile:Lcom/segment/analytics/QueueFile;

    invoke-virtual {v0}, Lcom/segment/analytics/QueueFile;->size()I

    move-result v0

    return v0
.end method
