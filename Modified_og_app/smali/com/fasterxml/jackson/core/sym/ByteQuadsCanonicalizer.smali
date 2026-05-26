.class public final Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;
.super Ljava/lang/Object;
.source "ByteQuadsCanonicalizer.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer$TableInfo;
    }
.end annotation


# instance fields
.field protected final a:Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;

.field protected final b:Ljava/util/concurrent/atomic/AtomicReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/atomic/AtomicReference",
            "<",
            "Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer$TableInfo;",
            ">;"
        }
    .end annotation
.end field

.field protected c:Z

.field protected final d:Z

.field protected e:[I

.field protected f:I

.field protected g:I

.field protected h:I

.field protected i:I

.field protected j:I

.field protected k:[Ljava/lang/String;

.field protected l:I

.field protected m:I

.field private final n:I

.field private transient o:Z

.field private p:Z


# direct methods
.method private constructor <init>(IZIZ)V
    .locals 2

    .prologue
    const/16 v0, 0x10

    .line 222
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 223
    const/4 v1, 0x0

    iput-object v1, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->a:Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;

    .line 224
    iput p3, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->n:I

    .line 225
    iput-boolean p2, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->c:Z

    .line 226
    iput-boolean p4, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->d:Z

    .line 228
    if-ge p1, v0, :cond_1

    move p1, v0

    .line 241
    :cond_0
    :goto_0
    new-instance v0, Ljava/util/concurrent/atomic/AtomicReference;

    invoke-static {p1}, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer$TableInfo;->a(I)Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer$TableInfo;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/util/concurrent/atomic/AtomicReference;-><init>(Ljava/lang/Object;)V

    iput-object v0, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->b:Ljava/util/concurrent/atomic/AtomicReference;

    .line 242
    return-void

    .line 233
    :cond_1
    add-int/lit8 v1, p1, -0x1

    and-int/2addr v1, p1

    if-eqz v1, :cond_0

    .line 235
    :goto_1
    if-ge v0, p1, :cond_2

    .line 236
    add-int/2addr v0, v0

    goto :goto_1

    :cond_2
    move p1, v0

    .line 238
    goto :goto_0
.end method

.method private constructor <init>(Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;ZIZLcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer$TableInfo;)V
    .locals 2

    .prologue
    .line 249
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 250
    iput-object p1, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->a:Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;

    .line 251
    iput p3, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->n:I

    .line 252
    iput-boolean p2, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->c:Z

    .line 253
    iput-boolean p4, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->d:Z

    .line 254
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->b:Ljava/util/concurrent/atomic/AtomicReference;

    .line 257
    iget v0, p5, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer$TableInfo;->b:I

    iput v0, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->j:I

    .line 258
    iget v0, p5, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer$TableInfo;->a:I

    iput v0, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->f:I

    .line 259
    iget v0, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->f:I

    shl-int/lit8 v0, v0, 0x2

    iput v0, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->g:I

    .line 260
    iget v0, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->g:I

    iget v1, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->g:I

    shr-int/lit8 v1, v1, 0x1

    add-int/2addr v0, v1

    iput v0, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->h:I

    .line 261
    iget v0, p5, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer$TableInfo;->c:I

    iput v0, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->i:I

    .line 263
    iget-object v0, p5, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer$TableInfo;->d:[I

    iput-object v0, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->e:[I

    .line 264
    iget-object v0, p5, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer$TableInfo;->e:[Ljava/lang/String;

    iput-object v0, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->k:[Ljava/lang/String;

    .line 266
    iget v0, p5, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer$TableInfo;->f:I

    iput v0, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->l:I

    .line 267
    iget v0, p5, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer$TableInfo;->g:I

    iput v0, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->m:I

    .line 270
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->o:Z

    .line 271
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->p:Z

    .line 272
    return-void
.end method

.method public static a()Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;
    .locals 4

    .prologue
    .line 288
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    .line 290
    long-to-int v2, v0

    const/16 v3, 0x20

    ushr-long/2addr v0, v3

    long-to-int v0, v0

    add-int/2addr v0, v2

    or-int/lit8 v0, v0, 0x1

    .line 291
    invoke-static {v0}, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->a(I)Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;

    move-result-object v0

    return-object v0
.end method

.method protected static a(I)Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;
    .locals 3

    .prologue
    const/4 v2, 0x1

    .line 299
    new-instance v0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;

    const/16 v1, 0x40

    invoke-direct {v0, v1, v2, p0, v2}, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;-><init>(IZIZ)V

    return-object v0
.end method

.method private a(IIII)Ljava/lang/String;
    .locals 7

    .prologue
    const/4 v1, 0x0

    const/4 v6, 0x3

    .line 674
    iget v0, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->h:I

    iget v2, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->i:I

    add-int/lit8 v2, v2, 0x2

    shr-int v2, p1, v2

    iget v3, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->i:I

    shl-int/2addr v2, v3

    add-int/2addr v0, v2

    .line 675
    iget-object v2, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->e:[I

    .line 677
    const/4 v3, 0x1

    iget v4, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->i:I

    shl-int/2addr v3, v4

    .line 678
    add-int/2addr v3, v0

    :goto_0
    if-ge v0, v3, :cond_2

    .line 679
    add-int/lit8 v4, v0, 0x3

    aget v4, v2, v4

    .line 680
    aget v5, v2, v0

    if-ne p2, v5, :cond_0

    add-int/lit8 v5, v0, 0x1

    aget v5, v2, v5

    if-ne p3, v5, :cond_0

    add-int/lit8 v5, v0, 0x2

    aget v5, v2, v5

    if-ne p4, v5, :cond_0

    if-ne v6, v4, :cond_0

    .line 681
    iget-object v1, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->k:[Ljava/lang/String;

    shr-int/lit8 v0, v0, 0x2

    aget-object v0, v1, v0

    .line 693
    :goto_1
    return-object v0

    .line 683
    :cond_0
    if-nez v4, :cond_1

    move-object v0, v1

    .line 684
    goto :goto_1

    .line 678
    :cond_1
    add-int/lit8 v0, v0, 0x4

    goto :goto_0

    .line 687
    :cond_2
    invoke-direct {p0}, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->m()I

    move-result v0

    :goto_2
    iget v3, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->l:I

    if-ge v0, v3, :cond_4

    .line 688
    aget v3, v2, v0

    if-ne p2, v3, :cond_3

    add-int/lit8 v3, v0, 0x1

    aget v3, v2, v3

    if-ne p3, v3, :cond_3

    add-int/lit8 v3, v0, 0x2

    aget v3, v2, v3

    if-ne p4, v3, :cond_3

    add-int/lit8 v3, v0, 0x3

    aget v3, v2, v3

    if-ne v6, v3, :cond_3

    .line 690
    iget-object v1, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->k:[Ljava/lang/String;

    shr-int/lit8 v0, v0, 0x2

    aget-object v0, v1, v0

    goto :goto_1

    .line 687
    :cond_3
    add-int/lit8 v0, v0, 0x4

    goto :goto_2

    :cond_4
    move-object v0, v1

    .line 693
    goto :goto_1
.end method

.method private a(II[II)Ljava/lang/String;
    .locals 6

    .prologue
    const/4 v1, 0x0

    .line 698
    iget v0, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->h:I

    iget v2, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->i:I

    add-int/lit8 v2, v2, 0x2

    shr-int v2, p1, v2

    iget v3, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->i:I

    shl-int/2addr v2, v3

    add-int/2addr v0, v2

    .line 699
    iget-object v2, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->e:[I

    .line 701
    const/4 v3, 0x1

    iget v4, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->i:I

    shl-int/2addr v3, v4

    .line 702
    add-int/2addr v3, v0

    :goto_0
    if-ge v0, v3, :cond_2

    .line 703
    add-int/lit8 v4, v0, 0x3

    aget v4, v2, v4

    .line 704
    aget v5, v2, v0

    if-ne p2, v5, :cond_0

    if-ne p4, v4, :cond_0

    .line 705
    add-int/lit8 v5, v0, 0x1

    aget v5, v2, v5

    invoke-direct {p0, p3, p4, v5}, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->a([III)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 706
    iget-object v1, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->k:[Ljava/lang/String;

    shr-int/lit8 v0, v0, 0x2

    aget-object v0, v1, v0

    .line 720
    :goto_1
    return-object v0

    .line 709
    :cond_0
    if-nez v4, :cond_1

    move-object v0, v1

    .line 710
    goto :goto_1

    .line 702
    :cond_1
    add-int/lit8 v0, v0, 0x4

    goto :goto_0

    .line 713
    :cond_2
    invoke-direct {p0}, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->m()I

    move-result v0

    :goto_2
    iget v3, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->l:I

    if-ge v0, v3, :cond_4

    .line 714
    aget v3, v2, v0

    if-ne p2, v3, :cond_3

    add-int/lit8 v3, v0, 0x3

    aget v3, v2, v3

    if-ne p4, v3, :cond_3

    .line 715
    add-int/lit8 v3, v0, 0x1

    aget v3, v2, v3

    invoke-direct {p0, p3, p4, v3}, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->a([III)Z

    move-result v3

    if-eqz v3, :cond_3

    .line 716
    iget-object v1, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->k:[Ljava/lang/String;

    shr-int/lit8 v0, v0, 0x2

    aget-object v0, v1, v0

    goto :goto_1

    .line 713
    :cond_3
    add-int/lit8 v0, v0, 0x4

    goto :goto_2

    :cond_4
    move-object v0, v1

    .line 720
    goto :goto_1
.end method

.method private a(Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer$TableInfo;)V
    .locals 3

    .prologue
    .line 335
    iget v1, p1, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer$TableInfo;->b:I

    .line 336
    iget-object v0, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->b:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer$TableInfo;

    .line 340
    iget v2, v0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer$TableInfo;->b:I

    if-ne v1, v2, :cond_0

    .line 353
    :goto_0
    return-void

    .line 348
    :cond_0
    const/16 v2, 0x1770

    if-le v1, v2, :cond_1

    .line 350
    const/16 v1, 0x40

    invoke-static {v1}, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer$TableInfo;->a(I)Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer$TableInfo;

    move-result-object p1

    .line 352
    :cond_1
    iget-object v1, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->b:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-virtual {v1, v0, p1}, Ljava/util/concurrent/atomic/AtomicReference;->compareAndSet(Ljava/lang/Object;Ljava/lang/Object;)Z

    goto :goto_0
.end method

.method private a(Z)V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 1154
    iput v1, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->j:I

    .line 1156
    invoke-direct {p0}, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->m()I

    move-result v0

    iput v0, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->l:I

    .line 1158
    iget v0, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->f:I

    shl-int/lit8 v0, v0, 0x3

    iput v0, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->m:I

    .line 1159
    if-eqz p1, :cond_0

    .line 1160
    iget-object v0, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->e:[I

    invoke-static {v0, v1}, Ljava/util/Arrays;->fill([II)V

    .line 1161
    iget-object v0, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->k:[Ljava/lang/String;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Ljava/util/Arrays;->fill([Ljava/lang/Object;Ljava/lang/Object;)V

    .line 1163
    :cond_0
    return-void
.end method

.method private a([III)Z
    .locals 7

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 725
    iget-object v4, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->e:[I

    .line 729
    packed-switch p2, :pswitch_data_0

    .line 731
    invoke-direct {p0, p1, p2, p3}, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->b([III)Z

    move-result v2

    .line 746
    :cond_0
    :goto_0
    return v2

    .line 733
    :pswitch_0
    aget v3, p1, v2

    add-int/lit8 v0, p3, 0x1

    aget v5, v4, p3

    if-ne v3, v5, :cond_0

    move p3, v0

    move v0, v1

    .line 735
    :goto_1
    add-int/lit8 v3, v0, 0x1

    aget v5, p1, v0

    add-int/lit8 v0, p3, 0x1

    aget v6, v4, p3

    if-ne v5, v6, :cond_0

    move p3, v0

    move v0, v3

    .line 737
    :goto_2
    add-int/lit8 v3, v0, 0x1

    aget v5, p1, v0

    add-int/lit8 v0, p3, 0x1

    aget v6, v4, p3

    if-ne v5, v6, :cond_0

    move p3, v0

    move v0, v3

    .line 739
    :goto_3
    add-int/lit8 v3, v0, 0x1

    aget v5, p1, v0

    add-int/lit8 v0, p3, 0x1

    aget v6, v4, p3

    if-ne v5, v6, :cond_0

    move p3, v0

    move v0, v3

    .line 741
    :goto_4
    add-int/lit8 v3, v0, 0x1

    aget v0, p1, v0

    add-int/lit8 v5, p3, 0x1

    aget v6, v4, p3

    if-ne v0, v6, :cond_0

    .line 742
    add-int/lit8 v0, v3, 0x1

    aget v3, p1, v3

    add-int/lit8 v6, v5, 0x1

    aget v5, v4, v5

    if-ne v3, v5, :cond_0

    .line 743
    add-int/lit8 v3, v0, 0x1

    aget v0, p1, v0

    add-int/lit8 v5, v6, 0x1

    aget v6, v4, v6

    if-ne v0, v6, :cond_0

    .line 744
    add-int/lit8 v0, v3, 0x1

    aget v0, p1, v3

    add-int/lit8 v3, v5, 0x1

    aget v3, v4, v5

    if-ne v0, v3, :cond_0

    move v2, v1

    .line 746
    goto :goto_0

    :pswitch_1
    move v0, v2

    goto :goto_1

    :pswitch_2
    move v0, v2

    goto :goto_2

    :pswitch_3
    move v0, v2

    goto :goto_3

    :pswitch_4
    move v0, v2

    goto :goto_4

    .line 729
    :pswitch_data_0
    .packed-switch 0x4
        :pswitch_4
        :pswitch_3
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method private b([III)Z
    .locals 5

    .prologue
    const/4 v1, 0x0

    .line 751
    move v0, v1

    .line 753
    :goto_0
    add-int/lit8 v2, v0, 0x1

    aget v3, p1, v0

    iget-object v4, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->e:[I

    add-int/lit8 v0, p3, 0x1

    aget v4, v4, p3

    if-eq v3, v4, :cond_0

    .line 757
    :goto_1
    return v1

    .line 756
    :cond_0
    if-lt v2, p2, :cond_1

    .line 757
    const/4 v1, 0x1

    goto :goto_1

    :cond_1
    move p3, v0

    move v0, v2

    goto :goto_0
.end method

.method private c([II)I
    .locals 4

    .prologue
    .line 944
    iget v0, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->m:I

    .line 947
    add-int v1, v0, p2

    iget-object v2, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->e:[I

    array-length v2, v2

    if-le v1, v2, :cond_0

    .line 949
    add-int v1, v0, p2

    iget-object v2, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->e:[I

    array-length v2, v2

    sub-int/2addr v1, v2

    .line 951
    const/16 v2, 0x1000

    iget v3, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->f:I

    invoke-static {v2, v3}, Ljava/lang/Math;->min(II)I

    move-result v2

    .line 953
    iget-object v3, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->e:[I

    array-length v3, v3

    invoke-static {v1, v2}, Ljava/lang/Math;->max(II)I

    move-result v1

    add-int/2addr v1, v3

    .line 954
    iget-object v2, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->e:[I

    invoke-static {v2, v1}, Ljava/util/Arrays;->copyOf([II)[I

    move-result-object v1

    iput-object v1, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->e:[I

    .line 956
    :cond_0
    const/4 v1, 0x0

    iget-object v2, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->e:[I

    invoke-static {p1, v1, v2, v0, p2}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 957
    iget v1, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->m:I

    add-int/2addr v1, p2

    iput v1, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->m:I

    .line 958
    return v0
.end method

.method private c(II)Ljava/lang/String;
    .locals 7

    .prologue
    const/4 v1, 0x0

    const/4 v6, 0x1

    .line 626
    iget v0, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->h:I

    iget v2, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->i:I

    add-int/lit8 v2, v2, 0x2

    shr-int v2, p1, v2

    iget v3, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->i:I

    shl-int/2addr v2, v3

    add-int/2addr v0, v2

    .line 627
    iget-object v2, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->e:[I

    .line 628
    iget v3, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->i:I

    shl-int v3, v6, v3

    .line 629
    add-int/2addr v3, v0

    :goto_0
    if-ge v0, v3, :cond_2

    .line 630
    add-int/lit8 v4, v0, 0x3

    aget v4, v2, v4

    .line 631
    aget v5, v2, v0

    if-ne p2, v5, :cond_0

    if-ne v6, v4, :cond_0

    .line 632
    iget-object v1, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->k:[Ljava/lang/String;

    shr-int/lit8 v0, v0, 0x2

    aget-object v0, v1, v0

    .line 646
    :goto_1
    return-object v0

    .line 634
    :cond_0
    if-nez v4, :cond_1

    move-object v0, v1

    .line 635
    goto :goto_1

    .line 629
    :cond_1
    add-int/lit8 v0, v0, 0x4

    goto :goto_0

    .line 641
    :cond_2
    invoke-direct {p0}, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->m()I

    move-result v0

    :goto_2
    iget v3, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->l:I

    if-ge v0, v3, :cond_4

    .line 642
    aget v3, v2, v0

    if-ne p2, v3, :cond_3

    add-int/lit8 v3, v0, 0x3

    aget v3, v2, v3

    if-ne v6, v3, :cond_3

    .line 643
    iget-object v1, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->k:[Ljava/lang/String;

    shr-int/lit8 v0, v0, 0x2

    aget-object v0, v1, v0

    goto :goto_1

    .line 641
    :cond_3
    add-int/lit8 v0, v0, 0x4

    goto :goto_2

    :cond_4
    move-object v0, v1

    .line 646
    goto :goto_1
.end method

.method private c(III)Ljava/lang/String;
    .locals 7

    .prologue
    const/4 v1, 0x0

    const/4 v6, 0x2

    .line 651
    iget v0, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->h:I

    iget v2, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->i:I

    add-int/lit8 v2, v2, 0x2

    shr-int v2, p1, v2

    iget v3, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->i:I

    shl-int/2addr v2, v3

    add-int/2addr v0, v2

    .line 652
    iget-object v2, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->e:[I

    .line 654
    const/4 v3, 0x1

    iget v4, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->i:I

    shl-int/2addr v3, v4

    .line 655
    add-int/2addr v3, v0

    :goto_0
    if-ge v0, v3, :cond_2

    .line 656
    add-int/lit8 v4, v0, 0x3

    aget v4, v2, v4

    .line 657
    aget v5, v2, v0

    if-ne p2, v5, :cond_0

    add-int/lit8 v5, v0, 0x1

    aget v5, v2, v5

    if-ne p3, v5, :cond_0

    if-ne v6, v4, :cond_0

    .line 658
    iget-object v1, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->k:[Ljava/lang/String;

    shr-int/lit8 v0, v0, 0x2

    aget-object v0, v1, v0

    .line 669
    :goto_1
    return-object v0

    .line 660
    :cond_0
    if-nez v4, :cond_1

    move-object v0, v1

    .line 661
    goto :goto_1

    .line 655
    :cond_1
    add-int/lit8 v0, v0, 0x4

    goto :goto_0

    .line 664
    :cond_2
    invoke-direct {p0}, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->m()I

    move-result v0

    :goto_2
    iget v3, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->l:I

    if-ge v0, v3, :cond_4

    .line 665
    aget v3, v2, v0

    if-ne p2, v3, :cond_3

    add-int/lit8 v3, v0, 0x1

    aget v3, v2, v3

    if-ne p3, v3, :cond_3

    add-int/lit8 v3, v0, 0x3

    aget v3, v2, v3

    if-ne v6, v3, :cond_3

    .line 666
    iget-object v1, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->k:[Ljava/lang/String;

    shr-int/lit8 v0, v0, 0x2

    aget-object v0, v1, v0

    goto :goto_1

    .line 664
    :cond_3
    add-int/lit8 v0, v0, 0x4

    goto :goto_2

    :cond_4
    move-object v0, v1

    .line 669
    goto :goto_1
.end method

.method static e(I)I
    .locals 2

    .prologue
    .line 1196
    shr-int/lit8 v0, p0, 0x2

    .line 1199
    const/16 v1, 0x40

    if-ge v0, v1, :cond_0

    .line 1200
    const/4 v0, 0x4

    .line 1209
    :goto_0
    return v0

    .line 1202
    :cond_0
    const/16 v1, 0x100

    if-gt v0, v1, :cond_1

    .line 1203
    const/4 v0, 0x5

    goto :goto_0

    .line 1205
    :cond_1
    const/16 v1, 0x400

    if-gt v0, v1, :cond_2

    .line 1206
    const/4 v0, 0x6

    goto :goto_0

    .line 1209
    :cond_2
    const/4 v0, 0x7

    goto :goto_0
.end method

.method private final f(I)I
    .locals 1

    .prologue
    .line 609
    iget v0, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->f:I

    add-int/lit8 v0, v0, -0x1

    and-int/2addr v0, p1

    .line 611
    shl-int/lit8 v0, v0, 0x2

    return v0
.end method

.method private g(I)I
    .locals 5

    .prologue
    const/4 v4, 0x1

    .line 895
    invoke-direct {p0, p1}, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->f(I)I

    move-result v0

    .line 896
    iget-object v2, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->e:[I

    .line 897
    add-int/lit8 v1, v0, 0x3

    aget v1, v2, v1

    if-nez v1, :cond_1

    .line 939
    :cond_0
    :goto_0
    return v0

    .line 902
    :cond_1
    iget v1, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->g:I

    shr-int/lit8 v3, v0, 0x3

    shl-int/lit8 v3, v3, 0x2

    add-int/2addr v1, v3

    .line 903
    add-int/lit8 v3, v1, 0x3

    aget v3, v2, v3

    if-nez v3, :cond_2

    move v0, v1

    .line 905
    goto :goto_0

    .line 909
    :cond_2
    iget v1, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->h:I

    iget v3, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->i:I

    add-int/lit8 v3, v3, 0x2

    shr-int/2addr v0, v3

    iget v3, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->i:I

    shl-int/2addr v0, v3

    add-int/2addr v0, v1

    .line 910
    iget v1, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->i:I

    shl-int v1, v4, v1

    .line 911
    add-int/2addr v1, v0

    :goto_1
    if-ge v0, v1, :cond_3

    .line 912
    add-int/lit8 v3, v0, 0x3

    aget v3, v2, v3

    if-eqz v3, :cond_0

    .line 911
    add-int/lit8 v0, v0, 0x4

    goto :goto_1

    .line 919
    :cond_3
    iget v0, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->l:I

    .line 920
    iget v1, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->l:I

    add-int/lit8 v1, v1, 0x4

    iput v1, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->l:I

    .line 930
    iget v1, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->f:I

    shl-int/lit8 v1, v1, 0x3

    .line 931
    iget v2, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->l:I

    if-lt v2, v1, :cond_0

    .line 932
    iget-boolean v1, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->d:Z

    if-eqz v1, :cond_4

    .line 933
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->i()V

    .line 937
    :cond_4
    iput-boolean v4, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->o:Z

    goto :goto_0
.end method

.method private j()V
    .locals 6

    .prologue
    .line 865
    iget v0, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->j:I

    iget v1, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->f:I

    shr-int/lit8 v1, v1, 0x1

    if-le v0, v1, :cond_1

    .line 866
    iget v0, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->l:I

    invoke-direct {p0}, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->m()I

    move-result v1

    sub-int/2addr v0, v1

    shr-int/lit8 v0, v0, 0x2

    .line 867
    iget v1, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->j:I

    add-int/lit8 v1, v1, 0x1

    shr-int/lit8 v1, v1, 0x7

    if-gt v0, v1, :cond_0

    iget v0, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->j:I

    int-to-double v0, v0

    iget v2, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->f:I

    int-to-double v2, v2

    const-wide v4, 0x3fe999999999999aL    # 0.8

    mul-double/2addr v2, v4

    cmpl-double v0, v0, v2

    if-lez v0, :cond_1

    .line 869
    :cond_0
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->o:Z

    .line 872
    :cond_1
    return-void
.end method

.method private k()V
    .locals 2

    .prologue
    .line 876
    iget-boolean v0, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->p:Z

    if-eqz v0, :cond_0

    .line 877
    iget-object v0, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->e:[I

    iget-object v1, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->e:[I

    array-length v1, v1

    invoke-static {v0, v1}, Ljava/util/Arrays;->copyOf([II)[I

    move-result-object v0

    iput-object v0, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->e:[I

    .line 878
    iget-object v0, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->k:[Ljava/lang/String;

    iget-object v1, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->k:[Ljava/lang/String;

    array-length v1, v1

    invoke-static {v0, v1}, Ljava/util/Arrays;->copyOf([Ljava/lang/Object;I)[Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Ljava/lang/String;

    iput-object v0, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->k:[Ljava/lang/String;

    .line 879
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->p:Z

    .line 882
    invoke-direct {p0}, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->j()V

    .line 884
    :cond_0
    iget-boolean v0, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->o:Z

    if-eqz v0, :cond_1

    .line 885
    invoke-direct {p0}, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->l()V

    .line 887
    :cond_1
    return-void
.end method

.method private l()V
    .locals 13

    .prologue
    const/4 v12, 0x2

    const/4 v11, 0x1

    const/4 v3, 0x0

    .line 1069
    iput-boolean v3, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->o:Z

    .line 1071
    iput-boolean v3, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->p:Z

    .line 1075
    iget-object v4, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->e:[I

    .line 1076
    iget-object v5, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->k:[Ljava/lang/String;

    .line 1077
    iget v0, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->f:I

    .line 1078
    iget v6, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->j:I

    .line 1079
    add-int v1, v0, v0

    .line 1080
    iget v7, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->l:I

    .line 1085
    const/high16 v2, 0x10000

    if-le v1, v2, :cond_1

    .line 1086
    invoke-direct {p0, v11}, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->a(Z)V

    .line 1147
    :cond_0
    return-void

    .line 1090
    :cond_1
    array-length v2, v4

    shl-int/lit8 v0, v0, 0x3

    add-int/2addr v0, v2

    new-array v0, v0, [I

    iput-object v0, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->e:[I

    .line 1091
    iput v1, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->f:I

    .line 1092
    shl-int/lit8 v0, v1, 0x2

    iput v0, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->g:I

    .line 1093
    iget v0, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->g:I

    iget v2, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->g:I

    shr-int/lit8 v2, v2, 0x1

    add-int/2addr v0, v2

    iput v0, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->h:I

    .line 1094
    invoke-static {v1}, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->e(I)I

    move-result v0

    iput v0, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->i:I

    .line 1097
    array-length v0, v5

    shl-int/lit8 v0, v0, 0x1

    new-array v0, v0, [Ljava/lang/String;

    iput-object v0, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->k:[Ljava/lang/String;

    .line 1098
    invoke-direct {p0, v3}, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->a(Z)V

    .line 1106
    const/16 v0, 0x10

    new-array v0, v0, [I

    move v2, v3

    move v1, v3

    .line 1107
    :goto_0
    if-ge v2, v7, :cond_4

    .line 1108
    add-int/lit8 v8, v2, 0x3

    aget v8, v4, v8

    .line 1109
    if-nez v8, :cond_2

    .line 1107
    :goto_1
    add-int/lit8 v2, v2, 0x4

    goto :goto_0

    .line 1112
    :cond_2
    add-int/lit8 v1, v1, 0x1

    .line 1113
    shr-int/lit8 v9, v2, 0x2

    aget-object v9, v5, v9

    .line 1114
    packed-switch v8, :pswitch_data_0

    .line 1131
    array-length v10, v0

    if-le v8, v10, :cond_3

    .line 1132
    new-array v0, v8, [I

    .line 1135
    :cond_3
    add-int/lit8 v10, v2, 0x1

    aget v10, v4, v10

    .line 1136
    invoke-static {v4, v10, v0, v3, v8}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 1137
    invoke-virtual {p0, v9, v0, v8}, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->a(Ljava/lang/String;[II)Ljava/lang/String;

    goto :goto_1

    .line 1116
    :pswitch_0
    aget v8, v4, v2

    aput v8, v0, v3

    .line 1117
    invoke-virtual {p0, v9, v0, v11}, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->a(Ljava/lang/String;[II)Ljava/lang/String;

    goto :goto_1

    .line 1120
    :pswitch_1
    aget v8, v4, v2

    aput v8, v0, v3

    .line 1121
    add-int/lit8 v8, v2, 0x1

    aget v8, v4, v8

    aput v8, v0, v11

    .line 1122
    invoke-virtual {p0, v9, v0, v12}, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->a(Ljava/lang/String;[II)Ljava/lang/String;

    goto :goto_1

    .line 1125
    :pswitch_2
    aget v8, v4, v2

    aput v8, v0, v3

    .line 1126
    add-int/lit8 v8, v2, 0x1

    aget v8, v4, v8

    aput v8, v0, v11

    .line 1127
    add-int/lit8 v8, v2, 0x2

    aget v8, v4, v8

    aput v8, v0, v12

    .line 1128
    const/4 v8, 0x3

    invoke-virtual {p0, v9, v0, v8}, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->a(Ljava/lang/String;[II)Ljava/lang/String;

    goto :goto_1

    .line 1144
    :cond_4
    if-eq v1, v6, :cond_0

    .line 1145
    new-instance v0, Ljava/lang/IllegalStateException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Failed rehash(): old count="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v6}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ", copyCount="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 1114
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method private final m()I
    .locals 2

    .prologue
    .line 1177
    iget v0, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->f:I

    .line 1178
    shl-int/lit8 v1, v0, 0x3

    sub-int v0, v1, v0

    return v0
.end method


# virtual methods
.method public a(II)Ljava/lang/String;
    .locals 6

    .prologue
    const/4 v0, 0x0

    const/4 v5, 0x2

    .line 502
    invoke-virtual {p0, p1, p2}, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->b(II)I

    move-result v1

    invoke-direct {p0, v1}, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->f(I)I

    move-result v1

    .line 504
    iget-object v2, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->e:[I

    .line 506
    add-int/lit8 v3, v1, 0x3

    aget v3, v2, v3

    .line 508
    if-ne v3, v5, :cond_1

    .line 509
    aget v3, v2, v1

    if-ne p1, v3, :cond_2

    add-int/lit8 v3, v1, 0x1

    aget v3, v2, v3

    if-ne p2, v3, :cond_2

    .line 510
    iget-object v0, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->k:[Ljava/lang/String;

    shr-int/lit8 v1, v1, 0x2

    aget-object v0, v0, v1

    .line 527
    :cond_0
    :goto_0
    return-object v0

    .line 512
    :cond_1
    if-eqz v3, :cond_0

    .line 516
    :cond_2
    iget v3, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->g:I

    shr-int/lit8 v4, v1, 0x3

    shl-int/lit8 v4, v4, 0x2

    add-int/2addr v3, v4

    .line 518
    add-int/lit8 v4, v3, 0x3

    aget v4, v2, v4

    .line 520
    if-ne v4, v5, :cond_3

    .line 521
    aget v0, v2, v3

    if-ne p1, v0, :cond_4

    add-int/lit8 v0, v3, 0x1

    aget v0, v2, v0

    if-ne p2, v0, :cond_4

    .line 522
    iget-object v0, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->k:[Ljava/lang/String;

    shr-int/lit8 v1, v3, 0x2

    aget-object v0, v0, v1

    goto :goto_0

    .line 524
    :cond_3
    if-eqz v4, :cond_0

    .line 527
    :cond_4
    invoke-direct {p0, v1, p1, p2}, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->c(III)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public a(III)Ljava/lang/String;
    .locals 6

    .prologue
    const/4 v0, 0x0

    const/4 v5, 0x3

    .line 532
    invoke-virtual {p0, p1, p2, p3}, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->b(III)I

    move-result v1

    invoke-direct {p0, v1}, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->f(I)I

    move-result v1

    .line 533
    iget-object v2, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->e:[I

    .line 534
    add-int/lit8 v3, v1, 0x3

    aget v3, v2, v3

    .line 536
    if-ne v3, v5, :cond_1

    .line 537
    aget v3, v2, v1

    if-ne p1, v3, :cond_2

    add-int/lit8 v3, v1, 0x1

    aget v3, v2, v3

    if-ne v3, p2, :cond_2

    add-int/lit8 v3, v1, 0x2

    aget v3, v2, v3

    if-ne v3, p3, :cond_2

    .line 538
    iget-object v0, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->k:[Ljava/lang/String;

    shr-int/lit8 v1, v1, 0x2

    aget-object v0, v0, v1

    .line 555
    :cond_0
    :goto_0
    return-object v0

    .line 540
    :cond_1
    if-eqz v3, :cond_0

    .line 544
    :cond_2
    iget v3, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->g:I

    shr-int/lit8 v4, v1, 0x3

    shl-int/lit8 v4, v4, 0x2

    add-int/2addr v3, v4

    .line 546
    add-int/lit8 v4, v3, 0x3

    aget v4, v2, v4

    .line 548
    if-ne v4, v5, :cond_3

    .line 549
    aget v0, v2, v3

    if-ne p1, v0, :cond_4

    add-int/lit8 v0, v3, 0x1

    aget v0, v2, v0

    if-ne v0, p2, :cond_4

    add-int/lit8 v0, v3, 0x2

    aget v0, v2, v0

    if-ne v0, p3, :cond_4

    .line 550
    iget-object v0, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->k:[Ljava/lang/String;

    shr-int/lit8 v1, v3, 0x2

    aget-object v0, v0, v1

    goto :goto_0

    .line 552
    :cond_3
    if-eqz v4, :cond_0

    .line 555
    :cond_4
    invoke-direct {p0, v1, p1, p2, p3}, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->a(IIII)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public a(Ljava/lang/String;[II)Ljava/lang/String;
    .locals 6

    .prologue
    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 814
    invoke-direct {p0}, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->k()V

    .line 815
    iget-boolean v0, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->c:Z

    if-eqz v0, :cond_0

    .line 816
    sget-object v0, Lcom/fasterxml/jackson/core/util/InternCache;->a:Lcom/fasterxml/jackson/core/util/InternCache;

    invoke-virtual {v0, p1}, Lcom/fasterxml/jackson/core/util/InternCache;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p1

    .line 820
    :cond_0
    packed-switch p3, :pswitch_data_0

    .line 846
    invoke-virtual {p0, p2, p3}, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->b([II)I

    move-result v1

    .line 847
    invoke-direct {p0, v1}, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->g(I)I

    move-result v0

    .line 849
    iget-object v2, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->e:[I

    aput v1, v2, v0

    .line 850
    invoke-direct {p0, p2, p3}, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->c([II)I

    move-result v1

    .line 851
    iget-object v2, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->e:[I

    add-int/lit8 v3, v0, 0x1

    aput v1, v2, v3

    .line 852
    iget-object v1, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->e:[I

    add-int/lit8 v2, v0, 0x3

    aput p3, v1, v2

    .line 855
    :goto_0
    iget-object v1, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->k:[Ljava/lang/String;

    shr-int/lit8 v0, v0, 0x2

    aput-object p1, v1, v0

    .line 858
    iget v0, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->j:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->j:I

    .line 859
    invoke-direct {p0}, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->j()V

    .line 860
    return-object p1

    .line 823
    :pswitch_0
    aget v0, p2, v3

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->d(I)I

    move-result v0

    invoke-direct {p0, v0}, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->g(I)I

    move-result v0

    .line 824
    iget-object v1, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->e:[I

    aget v2, p2, v3

    aput v2, v1, v0

    .line 825
    iget-object v1, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->e:[I

    add-int/lit8 v2, v0, 0x3

    aput v4, v1, v2

    goto :goto_0

    .line 830
    :pswitch_1
    aget v0, p2, v3

    aget v1, p2, v4

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->b(II)I

    move-result v0

    invoke-direct {p0, v0}, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->g(I)I

    move-result v0

    .line 831
    iget-object v1, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->e:[I

    aget v2, p2, v3

    aput v2, v1, v0

    .line 832
    iget-object v1, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->e:[I

    add-int/lit8 v2, v0, 0x1

    aget v3, p2, v4

    aput v3, v1, v2

    .line 833
    iget-object v1, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->e:[I

    add-int/lit8 v2, v0, 0x3

    aput v5, v1, v2

    goto :goto_0

    .line 838
    :pswitch_2
    aget v0, p2, v3

    aget v1, p2, v4

    aget v2, p2, v5

    invoke-virtual {p0, v0, v1, v2}, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->b(III)I

    move-result v0

    invoke-direct {p0, v0}, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->g(I)I

    move-result v0

    .line 839
    iget-object v1, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->e:[I

    aget v2, p2, v3

    aput v2, v1, v0

    .line 840
    iget-object v1, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->e:[I

    add-int/lit8 v2, v0, 0x1

    aget v3, p2, v4

    aput v3, v1, v2

    .line 841
    iget-object v1, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->e:[I

    add-int/lit8 v2, v0, 0x2

    aget v3, p2, v5

    aput v3, v1, v2

    .line 842
    iget-object v1, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->e:[I

    add-int/lit8 v2, v0, 0x3

    const/4 v3, 0x3

    aput v3, v1, v2

    goto :goto_0

    .line 820
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method public a([II)Ljava/lang/String;
    .locals 8

    .prologue
    const/4 v0, 0x0

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 564
    const/4 v1, 0x4

    if-ge p2, v1, :cond_3

    .line 565
    const/4 v0, 0x3

    if-ne p2, v0, :cond_1

    .line 566
    aget v0, p1, v2

    aget v1, p1, v3

    aget v2, p1, v4

    invoke-virtual {p0, v0, v1, v2}, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->a(III)Ljava/lang/String;

    move-result-object v0

    .line 601
    :cond_0
    :goto_0
    return-object v0

    .line 568
    :cond_1
    if-ne p2, v4, :cond_2

    .line 569
    aget v0, p1, v2

    aget v1, p1, v3

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->a(II)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 571
    :cond_2
    aget v0, p1, v2

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->c(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 573
    :cond_3
    invoke-virtual {p0, p1, p2}, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->b([II)I

    move-result v1

    .line 574
    invoke-direct {p0, v1}, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->f(I)I

    move-result v2

    .line 576
    iget-object v3, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->e:[I

    .line 578
    add-int/lit8 v4, v2, 0x3

    aget v4, v3, v4

    .line 580
    aget v5, v3, v2

    if-ne v1, v5, :cond_4

    if-ne v4, p2, :cond_4

    .line 582
    add-int/lit8 v5, v2, 0x1

    aget v5, v3, v5

    invoke-direct {p0, p1, p2, v5}, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->a([III)Z

    move-result v5

    if-eqz v5, :cond_4

    .line 583
    iget-object v0, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->k:[Ljava/lang/String;

    shr-int/lit8 v1, v2, 0x2

    aget-object v0, v0, v1

    goto :goto_0

    .line 586
    :cond_4
    if-eqz v4, :cond_0

    .line 590
    iget v5, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->g:I

    shr-int/lit8 v6, v2, 0x3

    shl-int/lit8 v6, v6, 0x2

    add-int/2addr v5, v6

    .line 592
    add-int/lit8 v6, v5, 0x3

    aget v6, v3, v6

    .line 593
    aget v7, v3, v5

    if-ne v1, v7, :cond_5

    if-ne v6, p2, :cond_5

    .line 594
    add-int/lit8 v6, v5, 0x1

    aget v3, v3, v6

    invoke-direct {p0, p1, p2, v3}, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->a([III)Z

    move-result v3

    if-eqz v3, :cond_5

    .line 595
    iget-object v0, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->k:[Ljava/lang/String;

    shr-int/lit8 v1, v5, 0x2

    aget-object v0, v0, v1

    goto :goto_0

    .line 598
    :cond_5
    if-eqz v4, :cond_0

    .line 601
    invoke-direct {p0, v2, v1, p1, p2}, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->a(II[II)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public b(II)I
    .locals 2

    .prologue
    .line 999
    .line 1001
    ushr-int/lit8 v0, p1, 0xf

    add-int/2addr v0, p1

    .line 1002
    ushr-int/lit8 v1, v0, 0x9

    xor-int/2addr v0, v1

    .line 1003
    mul-int/lit8 v1, p2, 0x21

    add-int/2addr v0, v1

    .line 1004
    iget v1, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->n:I

    xor-int/2addr v0, v1

    .line 1005
    ushr-int/lit8 v1, v0, 0x10

    add-int/2addr v0, v1

    .line 1006
    ushr-int/lit8 v1, v0, 0x4

    xor-int/2addr v0, v1

    .line 1007
    shl-int/lit8 v1, v0, 0x3

    add-int/2addr v0, v1

    .line 1009
    return v0
.end method

.method public b(III)I
    .locals 2

    .prologue
    .line 1014
    iget v0, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->n:I

    xor-int/2addr v0, p1

    .line 1015
    ushr-int/lit8 v1, v0, 0x9

    add-int/2addr v0, v1

    .line 1016
    mul-int/lit8 v0, v0, 0x1f

    .line 1017
    add-int/2addr v0, p2

    .line 1018
    mul-int/lit8 v0, v0, 0x21

    .line 1019
    ushr-int/lit8 v1, v0, 0xf

    add-int/2addr v0, v1

    .line 1020
    xor-int/2addr v0, p3

    .line 1022
    ushr-int/lit8 v1, v0, 0x4

    add-int/2addr v0, v1

    .line 1024
    ushr-int/lit8 v1, v0, 0xf

    add-int/2addr v0, v1

    .line 1025
    shl-int/lit8 v1, v0, 0x9

    xor-int/2addr v0, v1

    .line 1027
    return v0
.end method

.method public b([II)I
    .locals 4

    .prologue
    .line 1032
    const/4 v0, 0x4

    if-ge p2, v0, :cond_0

    .line 1033
    new-instance v0, Ljava/lang/IllegalArgumentException;

    invoke-direct {v0}, Ljava/lang/IllegalArgumentException;-><init>()V

    throw v0

    .line 1040
    :cond_0
    const/4 v0, 0x0

    aget v0, p1, v0

    iget v1, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->n:I

    xor-int/2addr v0, v1

    .line 1041
    ushr-int/lit8 v1, v0, 0x9

    add-int/2addr v0, v1

    .line 1042
    const/4 v1, 0x1

    aget v1, p1, v1

    add-int/2addr v0, v1

    .line 1043
    ushr-int/lit8 v1, v0, 0xf

    add-int/2addr v0, v1

    .line 1044
    mul-int/lit8 v0, v0, 0x21

    .line 1045
    const/4 v1, 0x2

    aget v1, p1, v1

    xor-int/2addr v0, v1

    .line 1046
    ushr-int/lit8 v1, v0, 0x4

    add-int/2addr v1, v0

    .line 1048
    const/4 v0, 0x3

    :goto_0
    if-ge v0, p2, :cond_1

    .line 1049
    aget v2, p1, v0

    .line 1050
    shr-int/lit8 v3, v2, 0x15

    xor-int/2addr v2, v3

    .line 1051
    add-int/2addr v1, v2

    .line 1048
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 1053
    :cond_1
    const v0, 0x1003f

    mul-int/2addr v0, v1

    .line 1056
    ushr-int/lit8 v1, v0, 0x13

    add-int/2addr v0, v1

    .line 1057
    shl-int/lit8 v1, v0, 0x5

    xor-int/2addr v0, v1

    .line 1058
    return v0
.end method

.method public b(I)Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;
    .locals 6

    .prologue
    .line 307
    new-instance v0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;

    sget-object v1, Lcom/fasterxml/jackson/core/JsonFactory$Feature;->INTERN_FIELD_NAMES:Lcom/fasterxml/jackson/core/JsonFactory$Feature;

    invoke-virtual {v1, p1}, Lcom/fasterxml/jackson/core/JsonFactory$Feature;->enabledIn(I)Z

    move-result v2

    iget v3, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->n:I

    sget-object v1, Lcom/fasterxml/jackson/core/JsonFactory$Feature;->FAIL_ON_SYMBOL_HASH_OVERFLOW:Lcom/fasterxml/jackson/core/JsonFactory$Feature;

    invoke-virtual {v1, p1}, Lcom/fasterxml/jackson/core/JsonFactory$Feature;->enabledIn(I)Z

    move-result v4

    iget-object v1, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->b:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-virtual {v1}, Ljava/util/concurrent/atomic/AtomicReference;->get()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer$TableInfo;

    move-object v1, p0

    invoke-direct/range {v0 .. v5}, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;-><init>(Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;ZIZLcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer$TableInfo;)V

    return-object v0
.end method

.method public b()V
    .locals 2

    .prologue
    .line 324
    iget-object v0, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->a:Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->c()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 325
    iget-object v0, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->a:Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;

    new-instance v1, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer$TableInfo;

    invoke-direct {v1, p0}, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer$TableInfo;-><init>(Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;)V

    invoke-direct {v0, v1}, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->a(Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer$TableInfo;)V

    .line 329
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->p:Z

    .line 331
    :cond_0
    return-void
.end method

.method public c(I)Ljava/lang/String;
    .locals 6

    .prologue
    const/4 v0, 0x0

    const/4 v5, 0x1

    .line 470
    invoke-virtual {p0, p1}, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->d(I)I

    move-result v1

    invoke-direct {p0, v1}, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->f(I)I

    move-result v1

    .line 472
    iget-object v2, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->e:[I

    .line 474
    add-int/lit8 v3, v1, 0x3

    aget v3, v2, v3

    .line 476
    if-ne v3, v5, :cond_1

    .line 477
    aget v3, v2, v1

    if-ne v3, p1, :cond_2

    .line 478
    iget-object v0, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->k:[Ljava/lang/String;

    shr-int/lit8 v1, v1, 0x2

    aget-object v0, v0, v1

    .line 497
    :cond_0
    :goto_0
    return-object v0

    .line 480
    :cond_1
    if-eqz v3, :cond_0

    .line 484
    :cond_2
    iget v3, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->g:I

    shr-int/lit8 v4, v1, 0x3

    shl-int/lit8 v4, v4, 0x2

    add-int/2addr v3, v4

    .line 486
    add-int/lit8 v4, v3, 0x3

    aget v4, v2, v4

    .line 488
    if-ne v4, v5, :cond_3

    .line 489
    aget v0, v2, v3

    if-ne v0, p1, :cond_4

    .line 490
    iget-object v0, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->k:[Ljava/lang/String;

    shr-int/lit8 v1, v3, 0x2

    aget-object v0, v0, v1

    goto :goto_0

    .line 492
    :cond_3
    if-eqz v4, :cond_0

    .line 497
    :cond_4
    invoke-direct {p0, v1, p1}, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->c(II)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public c()Z
    .locals 1

    .prologue
    .line 380
    iget-boolean v0, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->p:Z

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public d()I
    .locals 5

    .prologue
    .line 391
    const/4 v1, 0x0

    .line 392
    const/4 v0, 0x3

    iget v2, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->g:I

    move v4, v0

    move v0, v1

    move v1, v4

    :goto_0
    if-ge v1, v2, :cond_1

    .line 393
    iget-object v3, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->e:[I

    aget v3, v3, v1

    if-eqz v3, :cond_0

    .line 394
    add-int/lit8 v0, v0, 0x1

    .line 392
    :cond_0
    add-int/lit8 v1, v1, 0x4

    goto :goto_0

    .line 397
    :cond_1
    return v0
.end method

.method public d(I)I
    .locals 2

    .prologue
    .line 983
    iget v0, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->n:I

    xor-int/2addr v0, p1

    .line 989
    ushr-int/lit8 v1, v0, 0x10

    add-int/2addr v0, v1

    .line 990
    shl-int/lit8 v1, v0, 0x3

    xor-int/2addr v0, v1

    .line 991
    ushr-int/lit8 v1, v0, 0xc

    add-int/2addr v0, v1

    .line 992
    return v0
.end method

.method public e()I
    .locals 5

    .prologue
    .line 405
    const/4 v1, 0x0

    .line 406
    iget v0, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->g:I

    add-int/lit8 v0, v0, 0x3

    .line 407
    iget v2, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->h:I

    move v4, v0

    move v0, v1

    move v1, v4

    :goto_0
    if-ge v1, v2, :cond_1

    .line 408
    iget-object v3, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->e:[I

    aget v3, v3, v1

    if-eqz v3, :cond_0

    .line 409
    add-int/lit8 v0, v0, 0x1

    .line 407
    :cond_0
    add-int/lit8 v1, v1, 0x4

    goto :goto_0

    .line 412
    :cond_1
    return v0
.end method

.method public f()I
    .locals 5

    .prologue
    .line 420
    const/4 v1, 0x0

    .line 421
    iget v0, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->h:I

    add-int/lit8 v0, v0, 0x3

    .line 422
    iget v2, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->f:I

    add-int/2addr v2, v0

    move v4, v0

    move v0, v1

    move v1, v4

    :goto_0
    if-ge v1, v2, :cond_1

    .line 423
    iget-object v3, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->e:[I

    aget v3, v3, v1

    if-eqz v3, :cond_0

    .line 424
    add-int/lit8 v0, v0, 0x1

    .line 422
    :cond_0
    add-int/lit8 v1, v1, 0x4

    goto :goto_0

    .line 427
    :cond_1
    return v0
.end method

.method public g()I
    .locals 2

    .prologue
    .line 436
    iget v0, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->l:I

    invoke-direct {p0}, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->m()I

    move-result v1

    sub-int/2addr v0, v1

    shr-int/lit8 v0, v0, 0x2

    return v0
.end method

.method public h()I
    .locals 5

    .prologue
    .line 441
    const/4 v1, 0x0

    .line 442
    const/4 v0, 0x3

    iget v2, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->f:I

    shl-int/lit8 v2, v2, 0x3

    move v4, v0

    move v0, v1

    move v1, v4

    :goto_0
    if-ge v1, v2, :cond_1

    .line 443
    iget-object v3, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->e:[I

    aget v3, v3, v1

    if-eqz v3, :cond_0

    .line 444
    add-int/lit8 v0, v0, 0x1

    .line 442
    :cond_0
    add-int/lit8 v1, v1, 0x4

    goto :goto_0

    .line 447
    :cond_1
    return v0
.end method

.method protected i()V
    .locals 3

    .prologue
    .line 1184
    iget v0, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->f:I

    const/16 v1, 0x400

    if-gt v0, v1, :cond_0

    .line 1185
    return-void

    .line 1187
    :cond_0
    new-instance v0, Ljava/lang/IllegalStateException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Spill-over slots in symbol table with "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->j:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " entries, hash area of "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->f:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " slots is now full (all "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->f:I

    shr-int/lit8 v2, v2, 0x3

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " slots -- suspect a DoS attack based on hash collisions."

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " You can disable the check via `JsonFactory.Feature.FAIL_ON_SYMBOL_HASH_OVERFLOW`"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public toString()Ljava/lang/String;
    .locals 9

    .prologue
    .line 452
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->d()I

    move-result v0

    .line 453
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->e()I

    move-result v1

    .line 454
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->f()I

    move-result v2

    .line 455
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->g()I

    move-result v3

    .line 456
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->h()I

    move-result v4

    .line 457
    const-string v5, "[%s: size=%d, hashSize=%d, %d/%d/%d/%d pri/sec/ter/spill (=%s), total:%d]"

    const/16 v6, 0xa

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v8

    aput-object v8, v6, v7

    const/4 v7, 0x1

    iget v8, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->j:I

    invoke-static {v8}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    aput-object v8, v6, v7

    const/4 v7, 0x2

    iget v8, p0, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->f:I

    invoke-static {v8}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    aput-object v8, v6, v7

    const/4 v7, 0x3

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    aput-object v8, v6, v7

    const/4 v7, 0x4

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    aput-object v8, v6, v7

    const/4 v7, 0x5

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    aput-object v8, v6, v7

    const/4 v7, 0x6

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    aput-object v8, v6, v7

    const/4 v7, 0x7

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    aput-object v8, v6, v7

    const/16 v7, 0x8

    add-int/2addr v0, v1

    add-int/2addr v0, v2

    add-int/2addr v0, v3

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    aput-object v0, v6, v7

    const/16 v0, 0x9

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    aput-object v1, v6, v0

    invoke-static {v5, v6}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
