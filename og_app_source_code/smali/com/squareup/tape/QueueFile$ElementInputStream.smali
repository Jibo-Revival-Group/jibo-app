.class final Lcom/squareup/tape/QueueFile$ElementInputStream;
.super Ljava/io/InputStream;
.source "QueueFile.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/squareup/tape/QueueFile;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x12
    name = "ElementInputStream"
.end annotation


# instance fields
.field final synthetic a:Lcom/squareup/tape/QueueFile;

.field private b:I

.field private c:I


# direct methods
.method private constructor <init>(Lcom/squareup/tape/QueueFile;Lcom/squareup/tape/QueueFile$Element;)V
    .locals 1

    .prologue
    .line 454
    iput-object p1, p0, Lcom/squareup/tape/QueueFile$ElementInputStream;->a:Lcom/squareup/tape/QueueFile;

    invoke-direct {p0}, Ljava/io/InputStream;-><init>()V

    .line 455
    iget v0, p2, Lcom/squareup/tape/QueueFile$Element;->b:I

    add-int/lit8 v0, v0, 0x4

    invoke-static {p1, v0}, Lcom/squareup/tape/QueueFile;->a(Lcom/squareup/tape/QueueFile;I)I

    move-result v0

    iput v0, p0, Lcom/squareup/tape/QueueFile$ElementInputStream;->b:I

    .line 456
    iget v0, p2, Lcom/squareup/tape/QueueFile$Element;->c:I

    iput v0, p0, Lcom/squareup/tape/QueueFile$ElementInputStream;->c:I

    .line 457
    return-void
.end method

.method synthetic constructor <init>(Lcom/squareup/tape/QueueFile;Lcom/squareup/tape/QueueFile$Element;Lcom/squareup/tape/QueueFile$1;)V
    .locals 0

    .prologue
    .line 450
    invoke-direct {p0, p1, p2}, Lcom/squareup/tape/QueueFile$ElementInputStream;-><init>(Lcom/squareup/tape/QueueFile;Lcom/squareup/tape/QueueFile$Element;)V

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
    .line 476
    iget v0, p0, Lcom/squareup/tape/QueueFile$ElementInputStream;->c:I

    if-nez v0, :cond_0

    const/4 v0, -0x1

    .line 481
    :goto_0
    return v0

    .line 477
    :cond_0
    iget-object v0, p0, Lcom/squareup/tape/QueueFile$ElementInputStream;->a:Lcom/squareup/tape/QueueFile;

    iget-object v0, v0, Lcom/squareup/tape/QueueFile;->a:Ljava/io/RandomAccessFile;

    iget v1, p0, Lcom/squareup/tape/QueueFile$ElementInputStream;->b:I

    int-to-long v2, v1

    invoke-virtual {v0, v2, v3}, Ljava/io/RandomAccessFile;->seek(J)V

    .line 478
    iget-object v0, p0, Lcom/squareup/tape/QueueFile$ElementInputStream;->a:Lcom/squareup/tape/QueueFile;

    iget-object v0, v0, Lcom/squareup/tape/QueueFile;->a:Ljava/io/RandomAccessFile;

    invoke-virtual {v0}, Ljava/io/RandomAccessFile;->read()I

    move-result v0

    .line 479
    iget-object v1, p0, Lcom/squareup/tape/QueueFile$ElementInputStream;->a:Lcom/squareup/tape/QueueFile;

    iget v2, p0, Lcom/squareup/tape/QueueFile$ElementInputStream;->b:I

    add-int/lit8 v2, v2, 0x1

    invoke-static {v1, v2}, Lcom/squareup/tape/QueueFile;->a(Lcom/squareup/tape/QueueFile;I)I

    move-result v1

    iput v1, p0, Lcom/squareup/tape/QueueFile$ElementInputStream;->b:I

    .line 480
    iget v1, p0, Lcom/squareup/tape/QueueFile$ElementInputStream;->c:I

    add-int/lit8 v1, v1, -0x1

    iput v1, p0, Lcom/squareup/tape/QueueFile$ElementInputStream;->c:I

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
    .line 460
    const-string v0, "buffer"

    invoke-static {p1, v0}, Lcom/squareup/tape/QueueFile;->a(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    .line 461
    or-int v0, p2, p3

    if-ltz v0, :cond_0

    array-length v0, p1

    sub-int/2addr v0, p2

    if-le p3, v0, :cond_1

    .line 462
    :cond_0
    new-instance v0, Ljava/lang/ArrayIndexOutOfBoundsException;

    invoke-direct {v0}, Ljava/lang/ArrayIndexOutOfBoundsException;-><init>()V

    throw v0

    .line 464
    :cond_1
    iget v0, p0, Lcom/squareup/tape/QueueFile$ElementInputStream;->c:I

    if-lez v0, :cond_3

    .line 465
    iget v0, p0, Lcom/squareup/tape/QueueFile$ElementInputStream;->c:I

    if-le p3, v0, :cond_2

    iget p3, p0, Lcom/squareup/tape/QueueFile$ElementInputStream;->c:I

    .line 466
    :cond_2
    iget-object v0, p0, Lcom/squareup/tape/QueueFile$ElementInputStream;->a:Lcom/squareup/tape/QueueFile;

    iget v1, p0, Lcom/squareup/tape/QueueFile$ElementInputStream;->b:I

    invoke-static {v0, v1, p1, p2, p3}, Lcom/squareup/tape/QueueFile;->a(Lcom/squareup/tape/QueueFile;I[BII)V

    .line 467
    iget-object v0, p0, Lcom/squareup/tape/QueueFile$ElementInputStream;->a:Lcom/squareup/tape/QueueFile;

    iget v1, p0, Lcom/squareup/tape/QueueFile$ElementInputStream;->b:I

    add-int/2addr v1, p3

    invoke-static {v0, v1}, Lcom/squareup/tape/QueueFile;->a(Lcom/squareup/tape/QueueFile;I)I

    move-result v0

    iput v0, p0, Lcom/squareup/tape/QueueFile$ElementInputStream;->b:I

    .line 468
    iget v0, p0, Lcom/squareup/tape/QueueFile$ElementInputStream;->c:I

    sub-int/2addr v0, p3

    iput v0, p0, Lcom/squareup/tape/QueueFile$ElementInputStream;->c:I

    .line 471
    :goto_0
    return p3

    :cond_3
    const/4 p3, -0x1

    goto :goto_0
.end method
