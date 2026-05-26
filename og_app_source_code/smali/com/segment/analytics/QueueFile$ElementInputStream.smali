.class final Lcom/segment/analytics/QueueFile$ElementInputStream;
.super Ljava/io/InputStream;
.source "QueueFile.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/segment/analytics/QueueFile;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x10
    name = "ElementInputStream"
.end annotation


# instance fields
.field private position:I

.field private remaining:I

.field final synthetic this$0:Lcom/segment/analytics/QueueFile;


# direct methods
.method constructor <init>(Lcom/segment/analytics/QueueFile;Lcom/segment/analytics/QueueFile$Element;)V
    .locals 1

    .prologue
    .line 446
    iput-object p1, p0, Lcom/segment/analytics/QueueFile$ElementInputStream;->this$0:Lcom/segment/analytics/QueueFile;

    invoke-direct {p0}, Ljava/io/InputStream;-><init>()V

    .line 447
    iget v0, p2, Lcom/segment/analytics/QueueFile$Element;->position:I

    add-int/lit8 v0, v0, 0x4

    invoke-virtual {p1, v0}, Lcom/segment/analytics/QueueFile;->wrapPosition(I)I

    move-result v0

    iput v0, p0, Lcom/segment/analytics/QueueFile$ElementInputStream;->position:I

    .line 448
    iget v0, p2, Lcom/segment/analytics/QueueFile$Element;->length:I

    iput v0, p0, Lcom/segment/analytics/QueueFile$ElementInputStream;->remaining:I

    .line 449
    return-void
.end method


# virtual methods
.method public read()I
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 468
    iget v0, p0, Lcom/segment/analytics/QueueFile$ElementInputStream;->remaining:I

    if-nez v0, :cond_0

    const/4 v0, -0x1

    .line 473
    :goto_0
    return v0

    .line 469
    :cond_0
    iget-object v0, p0, Lcom/segment/analytics/QueueFile$ElementInputStream;->this$0:Lcom/segment/analytics/QueueFile;

    iget-object v0, v0, Lcom/segment/analytics/QueueFile;->raf:Ljava/io/RandomAccessFile;

    iget v1, p0, Lcom/segment/analytics/QueueFile$ElementInputStream;->position:I

    int-to-long v2, v1

    invoke-virtual {v0, v2, v3}, Ljava/io/RandomAccessFile;->seek(J)V

    .line 470
    iget-object v0, p0, Lcom/segment/analytics/QueueFile$ElementInputStream;->this$0:Lcom/segment/analytics/QueueFile;

    iget-object v0, v0, Lcom/segment/analytics/QueueFile;->raf:Ljava/io/RandomAccessFile;

    invoke-virtual {v0}, Ljava/io/RandomAccessFile;->read()I

    move-result v0

    .line 471
    iget-object v1, p0, Lcom/segment/analytics/QueueFile$ElementInputStream;->this$0:Lcom/segment/analytics/QueueFile;

    iget v2, p0, Lcom/segment/analytics/QueueFile$ElementInputStream;->position:I

    add-int/lit8 v2, v2, 0x1

    invoke-virtual {v1, v2}, Lcom/segment/analytics/QueueFile;->wrapPosition(I)I

    move-result v1

    iput v1, p0, Lcom/segment/analytics/QueueFile$ElementInputStream;->position:I

    .line 472
    iget v1, p0, Lcom/segment/analytics/QueueFile$ElementInputStream;->remaining:I

    add-int/lit8 v1, v1, -0x1

    iput v1, p0, Lcom/segment/analytics/QueueFile$ElementInputStream;->remaining:I

    goto :goto_0
.end method

.method public read([BII)I
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 453
    or-int v0, p2, p3

    if-ltz v0, :cond_0

    array-length v0, p1

    sub-int/2addr v0, p2

    if-le p3, v0, :cond_1

    .line 454
    :cond_0
    new-instance v0, Ljava/lang/ArrayIndexOutOfBoundsException;

    invoke-direct {v0}, Ljava/lang/ArrayIndexOutOfBoundsException;-><init>()V

    throw v0

    .line 456
    :cond_1
    iget v0, p0, Lcom/segment/analytics/QueueFile$ElementInputStream;->remaining:I

    if-nez v0, :cond_2

    .line 457
    const/4 p3, -0x1

    .line 463
    :goto_0
    return p3

    .line 459
    :cond_2
    iget v0, p0, Lcom/segment/analytics/QueueFile$ElementInputStream;->remaining:I

    if-le p3, v0, :cond_3

    iget p3, p0, Lcom/segment/analytics/QueueFile$ElementInputStream;->remaining:I

    .line 460
    :cond_3
    iget-object v0, p0, Lcom/segment/analytics/QueueFile$ElementInputStream;->this$0:Lcom/segment/analytics/QueueFile;

    iget v1, p0, Lcom/segment/analytics/QueueFile$ElementInputStream;->position:I

    invoke-virtual {v0, v1, p1, p2, p3}, Lcom/segment/analytics/QueueFile;->ringRead(I[BII)V

    .line 461
    iget-object v0, p0, Lcom/segment/analytics/QueueFile$ElementInputStream;->this$0:Lcom/segment/analytics/QueueFile;

    iget v1, p0, Lcom/segment/analytics/QueueFile$ElementInputStream;->position:I

    add-int/2addr v1, p3

    invoke-virtual {v0, v1}, Lcom/segment/analytics/QueueFile;->wrapPosition(I)I

    move-result v0

    iput v0, p0, Lcom/segment/analytics/QueueFile$ElementInputStream;->position:I

    .line 462
    iget v0, p0, Lcom/segment/analytics/QueueFile$ElementInputStream;->remaining:I

    sub-int/2addr v0, p3

    iput v0, p0, Lcom/segment/analytics/QueueFile$ElementInputStream;->remaining:I

    goto :goto_0
.end method
