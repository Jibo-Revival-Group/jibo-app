.class public Lcom/squareup/tape/QueueFile;
.super Ljava/lang/Object;
.source "QueueFile.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/squareup/tape/QueueFile$ElementReader;,
        Lcom/squareup/tape/QueueFile$Element;,
        Lcom/squareup/tape/QueueFile$ElementInputStream;
    }
.end annotation


# static fields
.field private static final c:Ljava/util/logging/Logger;

.field private static final d:[B


# instance fields
.field final a:Ljava/io/RandomAccessFile;

.field b:I

.field private e:I

.field private f:Lcom/squareup/tape/QueueFile$Element;

.field private g:Lcom/squareup/tape/QueueFile$Element;

.field private final h:[B


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 55
    const-class v0, Lcom/squareup/tape/QueueFile;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/util/logging/Logger;->getLogger(Ljava/lang/String;)Ljava/util/logging/Logger;

    move-result-object v0

    sput-object v0, Lcom/squareup/tape/QueueFile;->c:Ljava/util/logging/Logger;

    .line 61
    const/16 v0, 0x1000

    new-array v0, v0, [B

    sput-object v0, Lcom/squareup/tape/QueueFile;->d:[B

    return-void
.end method

.method public constructor <init>(Ljava/io/File;)V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 114
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 108
    const/16 v0, 0x10

    new-array v0, v0, [B

    iput-object v0, p0, Lcom/squareup/tape/QueueFile;->h:[B

    .line 115
    invoke-virtual {p1}, Ljava/io/File;->exists()Z

    move-result v0

    if-nez v0, :cond_0

    invoke-static {p1}, Lcom/squareup/tape/QueueFile;->a(Ljava/io/File;)V

    .line 116
    :cond_0
    invoke-static {p1}, Lcom/squareup/tape/QueueFile;->b(Ljava/io/File;)Ljava/io/RandomAccessFile;

    move-result-object v0

    iput-object v0, p0, Lcom/squareup/tape/QueueFile;->a:Ljava/io/RandomAccessFile;

    .line 117
    invoke-direct {p0}, Lcom/squareup/tape/QueueFile;->e()V

    .line 118
    return-void
.end method

.method static synthetic a(Lcom/squareup/tape/QueueFile;I)I
    .locals 1

    .prologue
    .line 54
    invoke-direct {p0, p1}, Lcom/squareup/tape/QueueFile;->b(I)I

    move-result v0

    return v0
.end method

.method private static a([BI)I
    .locals 2

    .prologue
    .line 151
    aget-byte v0, p0, p1

    and-int/lit16 v0, v0, 0xff

    shl-int/lit8 v0, v0, 0x18

    add-int/lit8 v1, p1, 0x1

    aget-byte v1, p0, v1

    and-int/lit16 v1, v1, 0xff

    shl-int/lit8 v1, v1, 0x10

    add-int/2addr v0, v1

    add-int/lit8 v1, p1, 0x2

    aget-byte v1, p0, v1

    and-int/lit16 v1, v1, 0xff

    shl-int/lit8 v1, v1, 0x8

    add-int/2addr v0, v1

    add-int/lit8 v1, p1, 0x3

    aget-byte v1, p0, v1

    and-int/lit16 v1, v1, 0xff

    add-int/2addr v0, v1

    return v0
.end method

.method private a(I)Lcom/squareup/tape/QueueFile$Element;
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v2, 0x0

    .line 189
    if-nez p1, :cond_0

    sget-object v0, Lcom/squareup/tape/QueueFile$Element;->a:Lcom/squareup/tape/QueueFile$Element;

    .line 192
    :goto_0
    return-object v0

    .line 190
    :cond_0
    iget-object v0, p0, Lcom/squareup/tape/QueueFile;->h:[B

    const/4 v1, 0x4

    invoke-direct {p0, p1, v0, v2, v1}, Lcom/squareup/tape/QueueFile;->b(I[BII)V

    .line 191
    iget-object v0, p0, Lcom/squareup/tape/QueueFile;->h:[B

    invoke-static {v0, v2}, Lcom/squareup/tape/QueueFile;->a([BI)I

    move-result v1

    .line 192
    new-instance v0, Lcom/squareup/tape/QueueFile$Element;

    invoke-direct {v0, p1, v1}, Lcom/squareup/tape/QueueFile$Element;-><init>(II)V

    goto :goto_0
.end method

.method static synthetic a(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 54
    invoke-static {p0, p1}, Lcom/squareup/tape/QueueFile;->b(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method private a(II)V
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 250
    :goto_0
    if-lez p2, :cond_0

    .line 251
    sget-object v0, Lcom/squareup/tape/QueueFile;->d:[B

    array-length v0, v0

    invoke-static {p2, v0}, Ljava/lang/Math;->min(II)I

    move-result v0

    .line 252
    sget-object v1, Lcom/squareup/tape/QueueFile;->d:[B

    const/4 v2, 0x0

    invoke-direct {p0, p1, v1, v2, v0}, Lcom/squareup/tape/QueueFile;->a(I[BII)V

    .line 253
    sub-int/2addr p2, v0

    .line 254
    add-int/2addr p1, v0

    .line 255
    goto :goto_0

    .line 256
    :cond_0
    return-void
.end method

.method private a(IIII)V
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 182
    iget-object v0, p0, Lcom/squareup/tape/QueueFile;->h:[B

    const/4 v1, 0x4

    new-array v1, v1, [I

    const/4 v2, 0x0

    aput p1, v1, v2

    const/4 v2, 0x1

    aput p2, v1, v2

    const/4 v2, 0x2

    aput p3, v1, v2

    const/4 v2, 0x3

    aput p4, v1, v2

    invoke-static {v0, v1}, Lcom/squareup/tape/QueueFile;->a([B[I)V

    .line 183
    iget-object v0, p0, Lcom/squareup/tape/QueueFile;->a:Ljava/io/RandomAccessFile;

    const-wide/16 v2, 0x0

    invoke-virtual {v0, v2, v3}, Ljava/io/RandomAccessFile;->seek(J)V

    .line 184
    iget-object v0, p0, Lcom/squareup/tape/QueueFile;->a:Ljava/io/RandomAccessFile;

    iget-object v1, p0, Lcom/squareup/tape/QueueFile;->h:[B

    invoke-virtual {v0, v1}, Ljava/io/RandomAccessFile;->write([B)V

    .line 185
    return-void
.end method

.method private a(I[BII)V
    .locals 6
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 234
    invoke-direct {p0, p1}, Lcom/squareup/tape/QueueFile;->b(I)I

    move-result v0

    .line 235
    add-int v1, v0, p4

    iget v2, p0, Lcom/squareup/tape/QueueFile;->b:I

    if-gt v1, v2, :cond_0

    .line 236
    iget-object v1, p0, Lcom/squareup/tape/QueueFile;->a:Ljava/io/RandomAccessFile;

    int-to-long v2, v0

    invoke-virtual {v1, v2, v3}, Ljava/io/RandomAccessFile;->seek(J)V

    .line 237
    iget-object v0, p0, Lcom/squareup/tape/QueueFile;->a:Ljava/io/RandomAccessFile;

    invoke-virtual {v0, p2, p3, p4}, Ljava/io/RandomAccessFile;->write([BII)V

    .line 247
    :goto_0
    return-void

    .line 241
    :cond_0
    iget v1, p0, Lcom/squareup/tape/QueueFile;->b:I

    sub-int/2addr v1, v0

    .line 242
    iget-object v2, p0, Lcom/squareup/tape/QueueFile;->a:Ljava/io/RandomAccessFile;

    int-to-long v4, v0

    invoke-virtual {v2, v4, v5}, Ljava/io/RandomAccessFile;->seek(J)V

    .line 243
    iget-object v0, p0, Lcom/squareup/tape/QueueFile;->a:Ljava/io/RandomAccessFile;

    invoke-virtual {v0, p2, p3, v1}, Ljava/io/RandomAccessFile;->write([BII)V

    .line 244
    iget-object v0, p0, Lcom/squareup/tape/QueueFile;->a:Ljava/io/RandomAccessFile;

    const-wide/16 v2, 0x10

    invoke-virtual {v0, v2, v3}, Ljava/io/RandomAccessFile;->seek(J)V

    .line 245
    iget-object v0, p0, Lcom/squareup/tape/QueueFile;->a:Ljava/io/RandomAccessFile;

    add-int v2, p3, v1

    sub-int v1, p4, v1

    invoke-virtual {v0, p2, v2, v1}, Ljava/io/RandomAccessFile;->write([BII)V

    goto :goto_0
.end method

.method static synthetic a(Lcom/squareup/tape/QueueFile;I[BII)V
    .locals 0
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 54
    invoke-direct {p0, p1, p2, p3, p4}, Lcom/squareup/tape/QueueFile;->b(I[BII)V

    return-void
.end method

.method private static a(Ljava/io/File;)V
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 198
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Ljava/io/File;->getPath()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ".tmp"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 199
    invoke-static {v0}, Lcom/squareup/tape/QueueFile;->b(Ljava/io/File;)Ljava/io/RandomAccessFile;

    move-result-object v1

    .line 201
    const-wide/16 v2, 0x1000

    :try_start_0
    invoke-virtual {v1, v2, v3}, Ljava/io/RandomAccessFile;->setLength(J)V

    .line 202
    const-wide/16 v2, 0x0

    invoke-virtual {v1, v2, v3}, Ljava/io/RandomAccessFile;->seek(J)V

    .line 203
    const/16 v2, 0x10

    new-array v2, v2, [B

    .line 204
    const/4 v3, 0x4

    new-array v3, v3, [I

    fill-array-data v3, :array_0

    invoke-static {v2, v3}, Lcom/squareup/tape/QueueFile;->a([B[I)V

    .line 205
    invoke-virtual {v1, v2}, Ljava/io/RandomAccessFile;->write([B)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 207
    invoke-virtual {v1}, Ljava/io/RandomAccessFile;->close()V

    .line 211
    invoke-virtual {v0, p0}, Ljava/io/File;->renameTo(Ljava/io/File;)Z

    move-result v0

    if-nez v0, :cond_0

    new-instance v0, Ljava/io/IOException;

    const-string v1, "Rename failed!"

    invoke-direct {v0, v1}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 207
    :catchall_0
    move-exception v0

    invoke-virtual {v1}, Ljava/io/RandomAccessFile;->close()V

    throw v0

    .line 212
    :cond_0
    return-void

    .line 204
    nop

    :array_0
    .array-data 4
        0x1000
        0x0
        0x0
        0x0
    .end array-data
.end method

.method private static varargs a([B[I)V
    .locals 4

    .prologue
    const/4 v0, 0x0

    .line 142
    .line 143
    array-length v2, p1

    move v1, v0

    :goto_0
    if-ge v0, v2, :cond_0

    aget v3, p1, v0

    .line 144
    invoke-static {p0, v1, v3}, Lcom/squareup/tape/QueueFile;->b([BII)V

    .line 145
    add-int/lit8 v1, v1, 0x4

    .line 143
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 147
    :cond_0
    return-void
.end method

.method private b(I)I
    .locals 2

    .prologue
    .line 221
    iget v0, p0, Lcom/squareup/tape/QueueFile;->b:I

    if-ge p1, v0, :cond_0

    :goto_0
    return p1

    :cond_0
    add-int/lit8 v0, p1, 0x10

    iget v1, p0, Lcom/squareup/tape/QueueFile;->b:I

    sub-int p1, v0, v1

    goto :goto_0
.end method

.method private static b(Ljava/io/File;)Ljava/io/RandomAccessFile;
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/FileNotFoundException;
        }
    .end annotation

    .prologue
    .line 216
    new-instance v0, Ljava/io/RandomAccessFile;

    const-string v1, "rwd"

    invoke-direct {v0, p0, v1}, Ljava/io/RandomAccessFile;-><init>(Ljava/io/File;Ljava/lang/String;)V

    return-object v0
.end method

.method private static b(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(TT;",
            "Ljava/lang/String;",
            ")TT;"
        }
    .end annotation

    .prologue
    .line 445
    if-nez p0, :cond_0

    new-instance v0, Ljava/lang/NullPointerException;

    invoke-direct {v0, p1}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 446
    :cond_0
    return-object p0
.end method

.method private b(I[BII)V
    .locals 6
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 266
    invoke-direct {p0, p1}, Lcom/squareup/tape/QueueFile;->b(I)I

    move-result v0

    .line 267
    add-int v1, v0, p4

    iget v2, p0, Lcom/squareup/tape/QueueFile;->b:I

    if-gt v1, v2, :cond_0

    .line 268
    iget-object v1, p0, Lcom/squareup/tape/QueueFile;->a:Ljava/io/RandomAccessFile;

    int-to-long v2, v0

    invoke-virtual {v1, v2, v3}, Ljava/io/RandomAccessFile;->seek(J)V

    .line 269
    iget-object v0, p0, Lcom/squareup/tape/QueueFile;->a:Ljava/io/RandomAccessFile;

    invoke-virtual {v0, p2, p3, p4}, Ljava/io/RandomAccessFile;->readFully([BII)V

    .line 279
    :goto_0
    return-void

    .line 273
    :cond_0
    iget v1, p0, Lcom/squareup/tape/QueueFile;->b:I

    sub-int/2addr v1, v0

    .line 274
    iget-object v2, p0, Lcom/squareup/tape/QueueFile;->a:Ljava/io/RandomAccessFile;

    int-to-long v4, v0

    invoke-virtual {v2, v4, v5}, Ljava/io/RandomAccessFile;->seek(J)V

    .line 275
    iget-object v0, p0, Lcom/squareup/tape/QueueFile;->a:Ljava/io/RandomAccessFile;

    invoke-virtual {v0, p2, p3, v1}, Ljava/io/RandomAccessFile;->readFully([BII)V

    .line 276
    iget-object v0, p0, Lcom/squareup/tape/QueueFile;->a:Ljava/io/RandomAccessFile;

    const-wide/16 v2, 0x10

    invoke-virtual {v0, v2, v3}, Ljava/io/RandomAccessFile;->seek(J)V

    .line 277
    iget-object v0, p0, Lcom/squareup/tape/QueueFile;->a:Ljava/io/RandomAccessFile;

    add-int v2, p3, v1

    sub-int v1, p4, v1

    invoke-virtual {v0, p2, v2, v1}, Ljava/io/RandomAccessFile;->readFully([BII)V

    goto :goto_0
.end method

.method private static b([BII)V
    .locals 2

    .prologue
    .line 131
    shr-int/lit8 v0, p2, 0x18

    int-to-byte v0, v0

    aput-byte v0, p0, p1

    .line 132
    add-int/lit8 v0, p1, 0x1

    shr-int/lit8 v1, p2, 0x10

    int-to-byte v1, v1

    aput-byte v1, p0, v0

    .line 133
    add-int/lit8 v0, p1, 0x2

    shr-int/lit8 v1, p2, 0x8

    int-to-byte v1, v1

    aput-byte v1, p0, v0

    .line 134
    add-int/lit8 v0, p1, 0x3

    int-to-byte v1, p2

    aput-byte v1, p0, v0

    .line 135
    return-void
.end method

.method private c(I)V
    .locals 8
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 361
    add-int/lit8 v2, p1, 0x4

    .line 362
    invoke-direct {p0}, Lcom/squareup/tape/QueueFile;->g()I

    move-result v1

    .line 363
    if-lt v1, v2, :cond_0

    .line 401
    :goto_0
    return-void

    .line 366
    :cond_0
    iget v0, p0, Lcom/squareup/tape/QueueFile;->b:I

    .line 370
    :cond_1
    add-int/2addr v1, v0

    .line 371
    shl-int/lit8 v0, v0, 0x1

    .line 373
    if-lt v1, v2, :cond_1

    .line 375
    invoke-direct {p0, v0}, Lcom/squareup/tape/QueueFile;->d(I)V

    .line 378
    iget-object v1, p0, Lcom/squareup/tape/QueueFile;->g:Lcom/squareup/tape/QueueFile$Element;

    iget v1, v1, Lcom/squareup/tape/QueueFile$Element;->b:I

    add-int/lit8 v1, v1, 0x4

    iget-object v2, p0, Lcom/squareup/tape/QueueFile;->g:Lcom/squareup/tape/QueueFile$Element;

    iget v2, v2, Lcom/squareup/tape/QueueFile$Element;->c:I

    add-int/2addr v1, v2

    invoke-direct {p0, v1}, Lcom/squareup/tape/QueueFile;->b(I)I

    move-result v2

    .line 381
    iget-object v1, p0, Lcom/squareup/tape/QueueFile;->f:Lcom/squareup/tape/QueueFile$Element;

    iget v1, v1, Lcom/squareup/tape/QueueFile$Element;->b:I

    if-gt v2, v1, :cond_3

    .line 382
    iget-object v1, p0, Lcom/squareup/tape/QueueFile;->a:Ljava/io/RandomAccessFile;

    invoke-virtual {v1}, Ljava/io/RandomAccessFile;->getChannel()Ljava/nio/channels/FileChannel;

    move-result-object v1

    .line 383
    iget v3, p0, Lcom/squareup/tape/QueueFile;->b:I

    int-to-long v4, v3

    invoke-virtual {v1, v4, v5}, Ljava/nio/channels/FileChannel;->position(J)Ljava/nio/channels/FileChannel;

    .line 384
    add-int/lit8 v7, v2, -0x10

    .line 385
    const-wide/16 v2, 0x10

    int-to-long v4, v7

    move-object v6, v1

    invoke-virtual/range {v1 .. v6}, Ljava/nio/channels/FileChannel;->transferTo(JJLjava/nio/channels/WritableByteChannel;)J

    move-result-wide v2

    int-to-long v4, v7

    cmp-long v1, v2, v4

    if-eqz v1, :cond_2

    .line 386
    new-instance v0, Ljava/lang/AssertionError;

    const-string v1, "Copied insufficient number of bytes!"

    invoke-direct {v0, v1}, Ljava/lang/AssertionError;-><init>(Ljava/lang/Object;)V

    throw v0

    .line 388
    :cond_2
    const/16 v1, 0x10

    invoke-direct {p0, v1, v7}, Lcom/squareup/tape/QueueFile;->a(II)V

    .line 392
    :cond_3
    iget-object v1, p0, Lcom/squareup/tape/QueueFile;->g:Lcom/squareup/tape/QueueFile$Element;

    iget v1, v1, Lcom/squareup/tape/QueueFile$Element;->b:I

    iget-object v2, p0, Lcom/squareup/tape/QueueFile;->f:Lcom/squareup/tape/QueueFile$Element;

    iget v2, v2, Lcom/squareup/tape/QueueFile$Element;->b:I

    if-ge v1, v2, :cond_4

    .line 393
    iget v1, p0, Lcom/squareup/tape/QueueFile;->b:I

    iget-object v2, p0, Lcom/squareup/tape/QueueFile;->g:Lcom/squareup/tape/QueueFile$Element;

    iget v2, v2, Lcom/squareup/tape/QueueFile$Element;->b:I

    add-int/2addr v1, v2

    add-int/lit8 v1, v1, -0x10

    .line 394
    iget v2, p0, Lcom/squareup/tape/QueueFile;->e:I

    iget-object v3, p0, Lcom/squareup/tape/QueueFile;->f:Lcom/squareup/tape/QueueFile$Element;

    iget v3, v3, Lcom/squareup/tape/QueueFile$Element;->b:I

    invoke-direct {p0, v0, v2, v3, v1}, Lcom/squareup/tape/QueueFile;->a(IIII)V

    .line 395
    new-instance v2, Lcom/squareup/tape/QueueFile$Element;

    iget-object v3, p0, Lcom/squareup/tape/QueueFile;->g:Lcom/squareup/tape/QueueFile$Element;

    iget v3, v3, Lcom/squareup/tape/QueueFile$Element;->c:I

    invoke-direct {v2, v1, v3}, Lcom/squareup/tape/QueueFile$Element;-><init>(II)V

    iput-object v2, p0, Lcom/squareup/tape/QueueFile;->g:Lcom/squareup/tape/QueueFile$Element;

    .line 400
    :goto_1
    iput v0, p0, Lcom/squareup/tape/QueueFile;->b:I

    goto :goto_0

    .line 397
    :cond_4
    iget v1, p0, Lcom/squareup/tape/QueueFile;->e:I

    iget-object v2, p0, Lcom/squareup/tape/QueueFile;->f:Lcom/squareup/tape/QueueFile$Element;

    iget v2, v2, Lcom/squareup/tape/QueueFile$Element;->b:I

    iget-object v3, p0, Lcom/squareup/tape/QueueFile;->g:Lcom/squareup/tape/QueueFile$Element;

    iget v3, v3, Lcom/squareup/tape/QueueFile$Element;->b:I

    invoke-direct {p0, v0, v1, v2, v3}, Lcom/squareup/tape/QueueFile;->a(IIII)V

    goto :goto_1
.end method

.method private d(I)V
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 406
    iget-object v0, p0, Lcom/squareup/tape/QueueFile;->a:Ljava/io/RandomAccessFile;

    int-to-long v2, p1

    invoke-virtual {v0, v2, v3}, Ljava/io/RandomAccessFile;->setLength(J)V

    .line 407
    iget-object v0, p0, Lcom/squareup/tape/QueueFile;->a:Ljava/io/RandomAccessFile;

    invoke-virtual {v0}, Ljava/io/RandomAccessFile;->getChannel()Ljava/nio/channels/FileChannel;

    move-result-object v0

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Ljava/nio/channels/FileChannel;->force(Z)V

    .line 408
    return-void
.end method

.method private e()V
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 159
    iget-object v0, p0, Lcom/squareup/tape/QueueFile;->a:Ljava/io/RandomAccessFile;

    const-wide/16 v2, 0x0

    invoke-virtual {v0, v2, v3}, Ljava/io/RandomAccessFile;->seek(J)V

    .line 160
    iget-object v0, p0, Lcom/squareup/tape/QueueFile;->a:Ljava/io/RandomAccessFile;

    iget-object v1, p0, Lcom/squareup/tape/QueueFile;->h:[B

    invoke-virtual {v0, v1}, Ljava/io/RandomAccessFile;->readFully([B)V

    .line 161
    iget-object v0, p0, Lcom/squareup/tape/QueueFile;->h:[B

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/squareup/tape/QueueFile;->a([BI)I

    move-result v0

    iput v0, p0, Lcom/squareup/tape/QueueFile;->b:I

    .line 162
    iget v0, p0, Lcom/squareup/tape/QueueFile;->b:I

    int-to-long v0, v0

    iget-object v2, p0, Lcom/squareup/tape/QueueFile;->a:Ljava/io/RandomAccessFile;

    invoke-virtual {v2}, Ljava/io/RandomAccessFile;->length()J

    move-result-wide v2

    cmp-long v0, v0, v2

    if-lez v0, :cond_0

    .line 163
    new-instance v0, Ljava/io/IOException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "File is truncated. Expected length: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lcom/squareup/tape/QueueFile;->b:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ", Actual length: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/squareup/tape/QueueFile;->a:Ljava/io/RandomAccessFile;

    invoke-virtual {v2}, Ljava/io/RandomAccessFile;->length()J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 164
    :cond_0
    iget v0, p0, Lcom/squareup/tape/QueueFile;->b:I

    if-nez v0, :cond_1

    .line 165
    new-instance v0, Ljava/io/IOException;

    const-string v1, "File is corrupt; length stored in header is 0."

    invoke-direct {v0, v1}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 167
    :cond_1
    iget-object v0, p0, Lcom/squareup/tape/QueueFile;->h:[B

    const/4 v1, 0x4

    invoke-static {v0, v1}, Lcom/squareup/tape/QueueFile;->a([BI)I

    move-result v0

    iput v0, p0, Lcom/squareup/tape/QueueFile;->e:I

    .line 168
    iget-object v0, p0, Lcom/squareup/tape/QueueFile;->h:[B

    const/16 v1, 0x8

    invoke-static {v0, v1}, Lcom/squareup/tape/QueueFile;->a([BI)I

    move-result v0

    .line 169
    iget-object v1, p0, Lcom/squareup/tape/QueueFile;->h:[B

    const/16 v2, 0xc

    invoke-static {v1, v2}, Lcom/squareup/tape/QueueFile;->a([BI)I

    move-result v1

    .line 170
    invoke-direct {p0, v0}, Lcom/squareup/tape/QueueFile;->a(I)Lcom/squareup/tape/QueueFile$Element;

    move-result-object v0

    iput-object v0, p0, Lcom/squareup/tape/QueueFile;->f:Lcom/squareup/tape/QueueFile$Element;

    .line 171
    invoke-direct {p0, v1}, Lcom/squareup/tape/QueueFile;->a(I)Lcom/squareup/tape/QueueFile$Element;

    move-result-object v0

    iput-object v0, p0, Lcom/squareup/tape/QueueFile;->g:Lcom/squareup/tape/QueueFile$Element;

    .line 172
    return-void
.end method

.method private f()I
    .locals 2

    .prologue
    .line 329
    iget v0, p0, Lcom/squareup/tape/QueueFile;->e:I

    if-nez v0, :cond_0

    const/16 v0, 0x10

    .line 338
    :goto_0
    return v0

    .line 331
    :cond_0
    iget-object v0, p0, Lcom/squareup/tape/QueueFile;->g:Lcom/squareup/tape/QueueFile$Element;

    iget v0, v0, Lcom/squareup/tape/QueueFile$Element;->b:I

    iget-object v1, p0, Lcom/squareup/tape/QueueFile;->f:Lcom/squareup/tape/QueueFile$Element;

    iget v1, v1, Lcom/squareup/tape/QueueFile$Element;->b:I

    if-lt v0, v1, :cond_1

    .line 333
    iget-object v0, p0, Lcom/squareup/tape/QueueFile;->g:Lcom/squareup/tape/QueueFile$Element;

    iget v0, v0, Lcom/squareup/tape/QueueFile$Element;->b:I

    iget-object v1, p0, Lcom/squareup/tape/QueueFile;->f:Lcom/squareup/tape/QueueFile$Element;

    iget v1, v1, Lcom/squareup/tape/QueueFile$Element;->b:I

    sub-int/2addr v0, v1

    add-int/lit8 v0, v0, 0x4

    iget-object v1, p0, Lcom/squareup/tape/QueueFile;->g:Lcom/squareup/tape/QueueFile$Element;

    iget v1, v1, Lcom/squareup/tape/QueueFile$Element;->c:I

    add-int/2addr v0, v1

    add-int/lit8 v0, v0, 0x10

    goto :goto_0

    .line 338
    :cond_1
    iget-object v0, p0, Lcom/squareup/tape/QueueFile;->g:Lcom/squareup/tape/QueueFile$Element;

    iget v0, v0, Lcom/squareup/tape/QueueFile$Element;->b:I

    add-int/lit8 v0, v0, 0x4

    iget-object v1, p0, Lcom/squareup/tape/QueueFile;->g:Lcom/squareup/tape/QueueFile$Element;

    iget v1, v1, Lcom/squareup/tape/QueueFile$Element;->c:I

    add-int/2addr v0, v1

    iget v1, p0, Lcom/squareup/tape/QueueFile;->b:I

    add-int/2addr v0, v1

    iget-object v1, p0, Lcom/squareup/tape/QueueFile;->f:Lcom/squareup/tape/QueueFile$Element;

    iget v1, v1, Lcom/squareup/tape/QueueFile$Element;->b:I

    sub-int/2addr v0, v1

    goto :goto_0
.end method

.method private g()I
    .locals 2

    .prologue
    .line 346
    iget v0, p0, Lcom/squareup/tape/QueueFile;->b:I

    invoke-direct {p0}, Lcom/squareup/tape/QueueFile;->f()I

    move-result v1

    sub-int/2addr v0, v1

    return v0
.end method


# virtual methods
.method public declared-synchronized a(Lcom/squareup/tape/QueueFile$ElementReader;)V
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 431
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/squareup/tape/QueueFile;->f:Lcom/squareup/tape/QueueFile$Element;

    iget v1, v0, Lcom/squareup/tape/QueueFile$Element;->b:I

    .line 432
    const/4 v0, 0x0

    :goto_0
    iget v2, p0, Lcom/squareup/tape/QueueFile;->e:I

    if-ge v0, v2, :cond_0

    .line 433
    invoke-direct {p0, v1}, Lcom/squareup/tape/QueueFile;->a(I)Lcom/squareup/tape/QueueFile$Element;

    move-result-object v1

    .line 434
    new-instance v2, Lcom/squareup/tape/QueueFile$ElementInputStream;

    const/4 v3, 0x0

    invoke-direct {v2, p0, v1, v3}, Lcom/squareup/tape/QueueFile$ElementInputStream;-><init>(Lcom/squareup/tape/QueueFile;Lcom/squareup/tape/QueueFile$Element;Lcom/squareup/tape/QueueFile$1;)V

    iget v3, v1, Lcom/squareup/tape/QueueFile$Element;->c:I

    invoke-interface {p1, v2, v3}, Lcom/squareup/tape/QueueFile$ElementReader;->a(Ljava/io/InputStream;I)V

    .line 435
    iget v2, v1, Lcom/squareup/tape/QueueFile$Element;->b:I

    add-int/lit8 v2, v2, 0x4

    iget v1, v1, Lcom/squareup/tape/QueueFile$Element;->c:I

    add-int/2addr v1, v2

    invoke-direct {p0, v1}, Lcom/squareup/tape/QueueFile;->b(I)I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v1

    .line 432
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 437
    :cond_0
    monitor-exit p0

    return-void

    .line 431
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public a([B)V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 287
    const/4 v0, 0x0

    array-length v1, p1

    invoke-virtual {p0, p1, v0, v1}, Lcom/squareup/tape/QueueFile;->a([BII)V

    .line 288
    return-void
.end method

.method public declared-synchronized a([BII)V
    .locals 6
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 300
    monitor-enter p0

    :try_start_0
    const-string v0, "buffer"

    invoke-static {p1, v0}, Lcom/squareup/tape/QueueFile;->b(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    .line 301
    or-int v0, p2, p3

    if-ltz v0, :cond_0

    array-length v0, p1

    sub-int/2addr v0, p2

    if-le p3, v0, :cond_1

    .line 302
    :cond_0
    new-instance v0, Ljava/lang/IndexOutOfBoundsException;

    invoke-direct {v0}, Ljava/lang/IndexOutOfBoundsException;-><init>()V

    throw v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 300
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0

    .line 305
    :cond_1
    :try_start_1
    invoke-direct {p0, p3}, Lcom/squareup/tape/QueueFile;->c(I)V

    .line 308
    invoke-virtual {p0}, Lcom/squareup/tape/QueueFile;->a()Z

    move-result v1

    .line 309
    if-eqz v1, :cond_3

    const/16 v0, 0x10

    .line 310
    :goto_0
    new-instance v2, Lcom/squareup/tape/QueueFile$Element;

    invoke-direct {v2, v0, p3}, Lcom/squareup/tape/QueueFile$Element;-><init>(II)V

    .line 313
    iget-object v0, p0, Lcom/squareup/tape/QueueFile;->h:[B

    const/4 v3, 0x0

    invoke-static {v0, v3, p3}, Lcom/squareup/tape/QueueFile;->b([BII)V

    .line 314
    iget v0, v2, Lcom/squareup/tape/QueueFile$Element;->b:I

    iget-object v3, p0, Lcom/squareup/tape/QueueFile;->h:[B

    const/4 v4, 0x0

    const/4 v5, 0x4

    invoke-direct {p0, v0, v3, v4, v5}, Lcom/squareup/tape/QueueFile;->a(I[BII)V

    .line 317
    iget v0, v2, Lcom/squareup/tape/QueueFile$Element;->b:I

    add-int/lit8 v0, v0, 0x4

    invoke-direct {p0, v0, p1, p2, p3}, Lcom/squareup/tape/QueueFile;->a(I[BII)V

    .line 320
    if-eqz v1, :cond_4

    iget v0, v2, Lcom/squareup/tape/QueueFile$Element;->b:I

    .line 321
    :goto_1
    iget v3, p0, Lcom/squareup/tape/QueueFile;->b:I

    iget v4, p0, Lcom/squareup/tape/QueueFile;->e:I

    add-int/lit8 v4, v4, 0x1

    iget v5, v2, Lcom/squareup/tape/QueueFile$Element;->b:I

    invoke-direct {p0, v3, v4, v0, v5}, Lcom/squareup/tape/QueueFile;->a(IIII)V

    .line 322
    iput-object v2, p0, Lcom/squareup/tape/QueueFile;->g:Lcom/squareup/tape/QueueFile$Element;

    .line 323
    iget v0, p0, Lcom/squareup/tape/QueueFile;->e:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/squareup/tape/QueueFile;->e:I

    .line 324
    if-eqz v1, :cond_2

    iget-object v0, p0, Lcom/squareup/tape/QueueFile;->g:Lcom/squareup/tape/QueueFile$Element;

    iput-object v0, p0, Lcom/squareup/tape/QueueFile;->f:Lcom/squareup/tape/QueueFile$Element;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 325
    :cond_2
    monitor-exit p0

    return-void

    .line 309
    :cond_3
    :try_start_2
    iget-object v0, p0, Lcom/squareup/tape/QueueFile;->g:Lcom/squareup/tape/QueueFile$Element;

    iget v0, v0, Lcom/squareup/tape/QueueFile$Element;->b:I

    add-int/lit8 v0, v0, 0x4

    iget-object v2, p0, Lcom/squareup/tape/QueueFile;->g:Lcom/squareup/tape/QueueFile$Element;

    iget v2, v2, Lcom/squareup/tape/QueueFile$Element;->c:I

    add-int/2addr v0, v2

    invoke-direct {p0, v0}, Lcom/squareup/tape/QueueFile;->b(I)I

    move-result v0

    goto :goto_0

    .line 320
    :cond_4
    iget-object v0, p0, Lcom/squareup/tape/QueueFile;->f:Lcom/squareup/tape/QueueFile$Element;

    iget v0, v0, Lcom/squareup/tape/QueueFile$Element;->b:I
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_1
.end method

.method public declared-synchronized a()Z
    .locals 1

    .prologue
    .line 351
    monitor-enter p0

    :try_start_0
    iget v0, p0, Lcom/squareup/tape/QueueFile;->e:I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    monitor-exit p0

    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized b()I
    .locals 1

    .prologue
    .line 487
    monitor-enter p0

    :try_start_0
    iget v0, p0, Lcom/squareup/tape/QueueFile;->e:I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized c()V
    .locals 5
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 496
    monitor-enter p0

    :try_start_0
    invoke-virtual {p0}, Lcom/squareup/tape/QueueFile;->a()Z

    move-result v0

    if-eqz v0, :cond_0

    new-instance v0, Ljava/util/NoSuchElementException;

    invoke-direct {v0}, Ljava/util/NoSuchElementException;-><init>()V

    throw v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0

    .line 497
    :cond_0
    :try_start_1
    iget v0, p0, Lcom/squareup/tape/QueueFile;->e:I

    const/4 v1, 0x1

    if-ne v0, v1, :cond_1

    .line 498
    invoke-virtual {p0}, Lcom/squareup/tape/QueueFile;->d()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 512
    :goto_0
    monitor-exit p0

    return-void

    .line 501
    :cond_1
    :try_start_2
    iget-object v0, p0, Lcom/squareup/tape/QueueFile;->f:Lcom/squareup/tape/QueueFile$Element;

    iget v0, v0, Lcom/squareup/tape/QueueFile$Element;->c:I

    add-int/lit8 v0, v0, 0x4

    .line 503
    iget-object v1, p0, Lcom/squareup/tape/QueueFile;->f:Lcom/squareup/tape/QueueFile$Element;

    iget v1, v1, Lcom/squareup/tape/QueueFile$Element;->b:I

    invoke-direct {p0, v1, v0}, Lcom/squareup/tape/QueueFile;->a(II)V

    .line 505
    iget-object v1, p0, Lcom/squareup/tape/QueueFile;->f:Lcom/squareup/tape/QueueFile$Element;

    iget v1, v1, Lcom/squareup/tape/QueueFile$Element;->b:I

    add-int/2addr v0, v1

    invoke-direct {p0, v0}, Lcom/squareup/tape/QueueFile;->b(I)I

    move-result v0

    .line 506
    iget-object v1, p0, Lcom/squareup/tape/QueueFile;->h:[B

    const/4 v2, 0x0

    const/4 v3, 0x4

    invoke-direct {p0, v0, v1, v2, v3}, Lcom/squareup/tape/QueueFile;->b(I[BII)V

    .line 507
    iget-object v1, p0, Lcom/squareup/tape/QueueFile;->h:[B

    const/4 v2, 0x0

    invoke-static {v1, v2}, Lcom/squareup/tape/QueueFile;->a([BI)I

    move-result v1

    .line 508
    iget v2, p0, Lcom/squareup/tape/QueueFile;->b:I

    iget v3, p0, Lcom/squareup/tape/QueueFile;->e:I

    add-int/lit8 v3, v3, -0x1

    iget-object v4, p0, Lcom/squareup/tape/QueueFile;->g:Lcom/squareup/tape/QueueFile$Element;

    iget v4, v4, Lcom/squareup/tape/QueueFile$Element;->b:I

    invoke-direct {p0, v2, v3, v0, v4}, Lcom/squareup/tape/QueueFile;->a(IIII)V

    .line 509
    iget v2, p0, Lcom/squareup/tape/QueueFile;->e:I

    add-int/lit8 v2, v2, -0x1

    iput v2, p0, Lcom/squareup/tape/QueueFile;->e:I

    .line 510
    new-instance v2, Lcom/squareup/tape/QueueFile$Element;

    invoke-direct {v2, v0, v1}, Lcom/squareup/tape/QueueFile$Element;-><init>(II)V

    iput-object v2, p0, Lcom/squareup/tape/QueueFile;->f:Lcom/squareup/tape/QueueFile$Element;
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_0
.end method

.method public declared-synchronized d()V
    .locals 5
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/16 v4, 0x1000

    .line 516
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/squareup/tape/QueueFile;->a:Ljava/io/RandomAccessFile;

    const-wide/16 v2, 0x0

    invoke-virtual {v0, v2, v3}, Ljava/io/RandomAccessFile;->seek(J)V

    .line 517
    iget-object v0, p0, Lcom/squareup/tape/QueueFile;->a:Ljava/io/RandomAccessFile;

    sget-object v1, Lcom/squareup/tape/QueueFile;->d:[B

    invoke-virtual {v0, v1}, Ljava/io/RandomAccessFile;->write([B)V

    .line 518
    const/16 v0, 0x1000

    const/4 v1, 0x0

    const/4 v2, 0x0

    const/4 v3, 0x0

    invoke-direct {p0, v0, v1, v2, v3}, Lcom/squareup/tape/QueueFile;->a(IIII)V

    .line 519
    const/4 v0, 0x0

    iput v0, p0, Lcom/squareup/tape/QueueFile;->e:I

    .line 520
    sget-object v0, Lcom/squareup/tape/QueueFile$Element;->a:Lcom/squareup/tape/QueueFile$Element;

    iput-object v0, p0, Lcom/squareup/tape/QueueFile;->f:Lcom/squareup/tape/QueueFile$Element;

    .line 521
    sget-object v0, Lcom/squareup/tape/QueueFile$Element;->a:Lcom/squareup/tape/QueueFile$Element;

    iput-object v0, p0, Lcom/squareup/tape/QueueFile;->g:Lcom/squareup/tape/QueueFile$Element;

    .line 522
    iget v0, p0, Lcom/squareup/tape/QueueFile;->b:I

    if-le v0, v4, :cond_0

    const/16 v0, 0x1000

    invoke-direct {p0, v0}, Lcom/squareup/tape/QueueFile;->d(I)V

    .line 523
    :cond_0
    const/16 v0, 0x1000

    iput v0, p0, Lcom/squareup/tape/QueueFile;->b:I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 524
    monitor-exit p0

    return-void

    .line 516
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public toString()Ljava/lang/String;
    .locals 5

    .prologue
    .line 532
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    .line 533
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const/16 v2, 0x5b

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 534
    const-string v0, "fileLength="

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v2, p0, Lcom/squareup/tape/QueueFile;->b:I

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 535
    const-string v0, ", size="

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v2, p0, Lcom/squareup/tape/QueueFile;->e:I

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 536
    const-string v0, ", first="

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v2, p0, Lcom/squareup/tape/QueueFile;->f:Lcom/squareup/tape/QueueFile$Element;

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 537
    const-string v0, ", last="

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v2, p0, Lcom/squareup/tape/QueueFile;->g:Lcom/squareup/tape/QueueFile$Element;

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 538
    const-string v0, ", element lengths=["

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 540
    :try_start_0
    new-instance v0, Lcom/squareup/tape/QueueFile$1;

    invoke-direct {v0, p0, v1}, Lcom/squareup/tape/QueueFile$1;-><init>(Lcom/squareup/tape/QueueFile;Ljava/lang/StringBuilder;)V

    invoke-virtual {p0, v0}, Lcom/squareup/tape/QueueFile;->a(Lcom/squareup/tape/QueueFile$ElementReader;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 555
    :goto_0
    const-string v0, "]]"

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 556
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0

    .line 552
    :catch_0
    move-exception v0

    .line 553
    sget-object v2, Lcom/squareup/tape/QueueFile;->c:Ljava/util/logging/Logger;

    sget-object v3, Ljava/util/logging/Level;->WARNING:Ljava/util/logging/Level;

    const-string v4, "read error"

    invoke-virtual {v2, v3, v4, v0}, Ljava/util/logging/Logger;->log(Ljava/util/logging/Level;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method
