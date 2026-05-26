.class public Lcom/fasterxml/jackson/core/io/IOContext;
.super Ljava/lang/Object;
.source "IOContext.java"


# instance fields
.field protected final a:Ljava/lang/Object;

.field protected b:Lcom/fasterxml/jackson/core/JsonEncoding;

.field protected final c:Z

.field protected final d:Lcom/fasterxml/jackson/core/util/BufferRecycler;

.field protected e:[B

.field protected f:[B

.field protected g:[B

.field protected h:[C

.field protected i:[C

.field protected j:[C


# direct methods
.method public constructor <init>(Lcom/fasterxml/jackson/core/util/BufferRecycler;Ljava/lang/Object;Z)V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 102
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 59
    iput-object v0, p0, Lcom/fasterxml/jackson/core/io/IOContext;->e:[B

    .line 65
    iput-object v0, p0, Lcom/fasterxml/jackson/core/io/IOContext;->f:[B

    .line 71
    iput-object v0, p0, Lcom/fasterxml/jackson/core/io/IOContext;->g:[B

    .line 78
    iput-object v0, p0, Lcom/fasterxml/jackson/core/io/IOContext;->h:[C

    .line 85
    iput-object v0, p0, Lcom/fasterxml/jackson/core/io/IOContext;->i:[C

    .line 93
    iput-object v0, p0, Lcom/fasterxml/jackson/core/io/IOContext;->j:[C

    .line 103
    iput-object p1, p0, Lcom/fasterxml/jackson/core/io/IOContext;->d:Lcom/fasterxml/jackson/core/util/BufferRecycler;

    .line 104
    iput-object p2, p0, Lcom/fasterxml/jackson/core/io/IOContext;->a:Ljava/lang/Object;

    .line 105
    iput-boolean p3, p0, Lcom/fasterxml/jackson/core/io/IOContext;->c:Z

    .line 106
    return-void
.end method

.method private i()Ljava/lang/IllegalArgumentException;
    .locals 2

    .prologue
    .line 280
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Trying to release buffer not owned by the context"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    return-object v0
.end method


# virtual methods
.method public a()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 126
    iget-object v0, p0, Lcom/fasterxml/jackson/core/io/IOContext;->a:Ljava/lang/Object;

    return-object v0
.end method

.method public a(Lcom/fasterxml/jackson/core/JsonEncoding;)V
    .locals 0

    .prologue
    .line 109
    iput-object p1, p0, Lcom/fasterxml/jackson/core/io/IOContext;->b:Lcom/fasterxml/jackson/core/JsonEncoding;

    .line 110
    return-void
.end method

.method protected final a(Ljava/lang/Object;)V
    .locals 2

    .prologue
    .line 269
    if-eqz p1, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Trying to call same allocXxx() method second time"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 270
    :cond_0
    return-void
.end method

.method public a([B)V
    .locals 2

    .prologue
    .line 207
    if-eqz p1, :cond_0

    .line 211
    iget-object v0, p0, Lcom/fasterxml/jackson/core/io/IOContext;->e:[B

    invoke-virtual {p0, p1, v0}, Lcom/fasterxml/jackson/core/io/IOContext;->a([B[B)V

    .line 212
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/fasterxml/jackson/core/io/IOContext;->e:[B

    .line 213
    iget-object v0, p0, Lcom/fasterxml/jackson/core/io/IOContext;->d:Lcom/fasterxml/jackson/core/util/BufferRecycler;

    const/4 v1, 0x0

    invoke-virtual {v0, v1, p1}, Lcom/fasterxml/jackson/core/util/BufferRecycler;->a(I[B)V

    .line 215
    :cond_0
    return-void
.end method

.method protected final a([B[B)V
    .locals 2

    .prologue
    .line 273
    if-eq p1, p2, :cond_0

    array-length v0, p1

    array-length v1, p2

    if-gt v0, v1, :cond_0

    invoke-direct {p0}, Lcom/fasterxml/jackson/core/io/IOContext;->i()Ljava/lang/IllegalArgumentException;

    move-result-object v0

    throw v0

    .line 274
    :cond_0
    return-void
.end method

.method public a([C)V
    .locals 2

    .prologue
    .line 237
    if-eqz p1, :cond_0

    .line 238
    iget-object v0, p0, Lcom/fasterxml/jackson/core/io/IOContext;->h:[C

    invoke-virtual {p0, p1, v0}, Lcom/fasterxml/jackson/core/io/IOContext;->a([C[C)V

    .line 239
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/fasterxml/jackson/core/io/IOContext;->h:[C

    .line 240
    iget-object v0, p0, Lcom/fasterxml/jackson/core/io/IOContext;->d:Lcom/fasterxml/jackson/core/util/BufferRecycler;

    const/4 v1, 0x0

    invoke-virtual {v0, v1, p1}, Lcom/fasterxml/jackson/core/util/BufferRecycler;->a(I[C)V

    .line 242
    :cond_0
    return-void
.end method

.method protected final a([C[C)V
    .locals 2

    .prologue
    .line 277
    if-eq p1, p2, :cond_0

    array-length v0, p1

    array-length v1, p2

    if-gt v0, v1, :cond_0

    invoke-direct {p0}, Lcom/fasterxml/jackson/core/io/IOContext;->i()Ljava/lang/IllegalArgumentException;

    move-result-object v0

    throw v0

    .line 278
    :cond_0
    return-void
.end method

.method public a(I)[C
    .locals 2

    .prologue
    .line 188
    iget-object v0, p0, Lcom/fasterxml/jackson/core/io/IOContext;->h:[C

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/io/IOContext;->a(Ljava/lang/Object;)V

    .line 189
    iget-object v0, p0, Lcom/fasterxml/jackson/core/io/IOContext;->d:Lcom/fasterxml/jackson/core/util/BufferRecycler;

    const/4 v1, 0x0

    invoke-virtual {v0, v1, p1}, Lcom/fasterxml/jackson/core/util/BufferRecycler;->b(II)[C

    move-result-object v0

    iput-object v0, p0, Lcom/fasterxml/jackson/core/io/IOContext;->h:[C

    return-object v0
.end method

.method public b()Lcom/fasterxml/jackson/core/JsonEncoding;
    .locals 1

    .prologue
    .line 127
    iget-object v0, p0, Lcom/fasterxml/jackson/core/io/IOContext;->b:Lcom/fasterxml/jackson/core/JsonEncoding;

    return-object v0
.end method

.method public b([B)V
    .locals 2

    .prologue
    .line 218
    if-eqz p1, :cond_0

    .line 222
    iget-object v0, p0, Lcom/fasterxml/jackson/core/io/IOContext;->f:[B

    invoke-virtual {p0, p1, v0}, Lcom/fasterxml/jackson/core/io/IOContext;->a([B[B)V

    .line 223
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/fasterxml/jackson/core/io/IOContext;->f:[B

    .line 224
    iget-object v0, p0, Lcom/fasterxml/jackson/core/io/IOContext;->d:Lcom/fasterxml/jackson/core/util/BufferRecycler;

    const/4 v1, 0x1

    invoke-virtual {v0, v1, p1}, Lcom/fasterxml/jackson/core/util/BufferRecycler;->a(I[B)V

    .line 226
    :cond_0
    return-void
.end method

.method public b([C)V
    .locals 2

    .prologue
    .line 245
    if-eqz p1, :cond_0

    .line 247
    iget-object v0, p0, Lcom/fasterxml/jackson/core/io/IOContext;->i:[C

    invoke-virtual {p0, p1, v0}, Lcom/fasterxml/jackson/core/io/IOContext;->a([C[C)V

    .line 248
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/fasterxml/jackson/core/io/IOContext;->i:[C

    .line 249
    iget-object v0, p0, Lcom/fasterxml/jackson/core/io/IOContext;->d:Lcom/fasterxml/jackson/core/util/BufferRecycler;

    const/4 v1, 0x1

    invoke-virtual {v0, v1, p1}, Lcom/fasterxml/jackson/core/util/BufferRecycler;->a(I[C)V

    .line 251
    :cond_0
    return-void
.end method

.method public c([C)V
    .locals 2

    .prologue
    .line 254
    if-eqz p1, :cond_0

    .line 256
    iget-object v0, p0, Lcom/fasterxml/jackson/core/io/IOContext;->j:[C

    invoke-virtual {p0, p1, v0}, Lcom/fasterxml/jackson/core/io/IOContext;->a([C[C)V

    .line 257
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/fasterxml/jackson/core/io/IOContext;->j:[C

    .line 258
    iget-object v0, p0, Lcom/fasterxml/jackson/core/io/IOContext;->d:Lcom/fasterxml/jackson/core/util/BufferRecycler;

    const/4 v1, 0x3

    invoke-virtual {v0, v1, p1}, Lcom/fasterxml/jackson/core/util/BufferRecycler;->a(I[C)V

    .line 260
    :cond_0
    return-void
.end method

.method public c()Z
    .locals 1

    .prologue
    .line 128
    iget-boolean v0, p0, Lcom/fasterxml/jackson/core/io/IOContext;->c:Z

    return v0
.end method

.method public d()Lcom/fasterxml/jackson/core/util/TextBuffer;
    .locals 2

    .prologue
    .line 137
    new-instance v0, Lcom/fasterxml/jackson/core/util/TextBuffer;

    iget-object v1, p0, Lcom/fasterxml/jackson/core/io/IOContext;->d:Lcom/fasterxml/jackson/core/util/BufferRecycler;

    invoke-direct {v0, v1}, Lcom/fasterxml/jackson/core/util/TextBuffer;-><init>(Lcom/fasterxml/jackson/core/util/BufferRecycler;)V

    return-object v0
.end method

.method public e()[B
    .locals 2

    .prologue
    .line 146
    iget-object v0, p0, Lcom/fasterxml/jackson/core/io/IOContext;->e:[B

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/io/IOContext;->a(Ljava/lang/Object;)V

    .line 147
    iget-object v0, p0, Lcom/fasterxml/jackson/core/io/IOContext;->d:Lcom/fasterxml/jackson/core/util/BufferRecycler;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/fasterxml/jackson/core/util/BufferRecycler;->a(I)[B

    move-result-object v0

    iput-object v0, p0, Lcom/fasterxml/jackson/core/io/IOContext;->e:[B

    return-object v0
.end method

.method public f()[B
    .locals 2

    .prologue
    .line 159
    iget-object v0, p0, Lcom/fasterxml/jackson/core/io/IOContext;->f:[B

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/io/IOContext;->a(Ljava/lang/Object;)V

    .line 160
    iget-object v0, p0, Lcom/fasterxml/jackson/core/io/IOContext;->d:Lcom/fasterxml/jackson/core/util/BufferRecycler;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/fasterxml/jackson/core/util/BufferRecycler;->a(I)[B

    move-result-object v0

    iput-object v0, p0, Lcom/fasterxml/jackson/core/io/IOContext;->f:[B

    return-object v0
.end method

.method public g()[C
    .locals 2

    .prologue
    .line 180
    iget-object v0, p0, Lcom/fasterxml/jackson/core/io/IOContext;->h:[C

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/io/IOContext;->a(Ljava/lang/Object;)V

    .line 181
    iget-object v0, p0, Lcom/fasterxml/jackson/core/io/IOContext;->d:Lcom/fasterxml/jackson/core/util/BufferRecycler;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/fasterxml/jackson/core/util/BufferRecycler;->b(I)[C

    move-result-object v0

    iput-object v0, p0, Lcom/fasterxml/jackson/core/io/IOContext;->h:[C

    return-object v0
.end method

.method public h()[C
    .locals 2

    .prologue
    .line 193
    iget-object v0, p0, Lcom/fasterxml/jackson/core/io/IOContext;->i:[C

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/io/IOContext;->a(Ljava/lang/Object;)V

    .line 194
    iget-object v0, p0, Lcom/fasterxml/jackson/core/io/IOContext;->d:Lcom/fasterxml/jackson/core/util/BufferRecycler;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/fasterxml/jackson/core/util/BufferRecycler;->b(I)[C

    move-result-object v0

    iput-object v0, p0, Lcom/fasterxml/jackson/core/io/IOContext;->i:[C

    return-object v0
.end method
