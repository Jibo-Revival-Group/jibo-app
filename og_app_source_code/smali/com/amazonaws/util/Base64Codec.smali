.class Lcom/amazonaws/util/Base64Codec;
.super Ljava/lang/Object;


# instance fields
.field private final ALPAHBETS:[B


# direct methods
.method constructor <init>()V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const-string v0, "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/"

    invoke-static {v0}, Lcom/amazonaws/util/CodecUtils;->toBytesDirect(Ljava/lang/String;)[B

    move-result-object v0

    iput-object v0, p0, Lcom/amazonaws/util/Base64Codec;->ALPAHBETS:[B

    return-void
.end method


# virtual methods
.method public encode([B)[B
    .locals 5

    const/4 v0, 0x0

    array-length v1, p1

    div-int/lit8 v1, v1, 0x3

    array-length v2, p1

    rem-int/lit8 v3, v2, 0x3

    if-nez v3, :cond_1

    mul-int/lit8 v1, v1, 0x4

    new-array v2, v1, [B

    move v1, v0

    :goto_0
    array-length v3, p1

    if-ge v1, v3, :cond_0

    invoke-virtual {p0, p1, v1, v2, v0}, Lcom/amazonaws/util/Base64Codec;->encode3bytes([BI[BI)V

    add-int/lit8 v1, v1, 0x3

    add-int/lit8 v0, v0, 0x4

    goto :goto_0

    :cond_0
    move-object v0, v2

    :goto_1
    return-object v0

    :cond_1
    add-int/lit8 v1, v1, 0x1

    mul-int/lit8 v1, v1, 0x4

    new-array v2, v1, [B

    move v1, v0

    :goto_2
    array-length v4, p1

    sub-int/2addr v4, v3

    if-ge v1, v4, :cond_2

    invoke-virtual {p0, p1, v1, v2, v0}, Lcom/amazonaws/util/Base64Codec;->encode3bytes([BI[BI)V

    add-int/lit8 v1, v1, 0x3

    add-int/lit8 v0, v0, 0x4

    goto :goto_2

    :cond_2
    packed-switch v3, :pswitch_data_0

    :goto_3
    move-object v0, v2

    goto :goto_1

    :pswitch_0
    invoke-virtual {p0, p1, v1, v2, v0}, Lcom/amazonaws/util/Base64Codec;->encode1byte([BI[BI)V

    goto :goto_3

    :pswitch_1
    invoke-virtual {p0, p1, v1, v2, v0}, Lcom/amazonaws/util/Base64Codec;->encode2bytes([BI[BI)V

    goto :goto_3

    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method encode1byte([BI[BI)V
    .locals 5

    const/16 v4, 0x3d

    add-int/lit8 v0, p4, 0x1

    iget-object v1, p0, Lcom/amazonaws/util/Base64Codec;->ALPAHBETS:[B

    aget-byte v2, p1, p2

    ushr-int/lit8 v3, v2, 0x2

    and-int/lit8 v3, v3, 0x3f

    aget-byte v1, v1, v3

    aput-byte v1, p3, p4

    add-int/lit8 v1, v0, 0x1

    iget-object v3, p0, Lcom/amazonaws/util/Base64Codec;->ALPAHBETS:[B

    and-int/lit8 v2, v2, 0x3

    shl-int/lit8 v2, v2, 0x4

    aget-byte v2, v3, v2

    aput-byte v2, p3, v0

    add-int/lit8 v0, v1, 0x1

    aput-byte v4, p3, v1

    aput-byte v4, p3, v0

    return-void
.end method

.method encode2bytes([BI[BI)V
    .locals 6

    add-int/lit8 v0, p4, 0x1

    iget-object v1, p0, Lcom/amazonaws/util/Base64Codec;->ALPAHBETS:[B

    add-int/lit8 v2, p2, 0x1

    aget-byte v3, p1, p2

    ushr-int/lit8 v4, v3, 0x2

    and-int/lit8 v4, v4, 0x3f

    aget-byte v1, v1, v4

    aput-byte v1, p3, p4

    add-int/lit8 v1, v0, 0x1

    iget-object v4, p0, Lcom/amazonaws/util/Base64Codec;->ALPAHBETS:[B

    and-int/lit8 v3, v3, 0x3

    shl-int/lit8 v3, v3, 0x4

    aget-byte v2, p1, v2

    ushr-int/lit8 v5, v2, 0x4

    and-int/lit8 v5, v5, 0xf

    or-int/2addr v3, v5

    aget-byte v3, v4, v3

    aput-byte v3, p3, v0

    add-int/lit8 v0, v1, 0x1

    iget-object v3, p0, Lcom/amazonaws/util/Base64Codec;->ALPAHBETS:[B

    and-int/lit8 v2, v2, 0xf

    shl-int/lit8 v2, v2, 0x2

    aget-byte v2, v3, v2

    aput-byte v2, p3, v1

    const/16 v1, 0x3d

    aput-byte v1, p3, v0

    return-void
.end method

.method encode3bytes([BI[BI)V
    .locals 7

    add-int/lit8 v0, p4, 0x1

    iget-object v1, p0, Lcom/amazonaws/util/Base64Codec;->ALPAHBETS:[B

    add-int/lit8 v2, p2, 0x1

    aget-byte v3, p1, p2

    ushr-int/lit8 v4, v3, 0x2

    and-int/lit8 v4, v4, 0x3f

    aget-byte v1, v1, v4

    aput-byte v1, p3, p4

    add-int/lit8 v1, v0, 0x1

    iget-object v4, p0, Lcom/amazonaws/util/Base64Codec;->ALPAHBETS:[B

    and-int/lit8 v3, v3, 0x3

    shl-int/lit8 v3, v3, 0x4

    add-int/lit8 v5, v2, 0x1

    aget-byte v2, p1, v2

    ushr-int/lit8 v6, v2, 0x4

    and-int/lit8 v6, v6, 0xf

    or-int/2addr v3, v6

    aget-byte v3, v4, v3

    aput-byte v3, p3, v0

    add-int/lit8 v0, v1, 0x1

    iget-object v3, p0, Lcom/amazonaws/util/Base64Codec;->ALPAHBETS:[B

    and-int/lit8 v2, v2, 0xf

    shl-int/lit8 v2, v2, 0x2

    aget-byte v4, p1, v5

    ushr-int/lit8 v5, v4, 0x6

    and-int/lit8 v5, v5, 0x3

    or-int/2addr v2, v5

    aget-byte v2, v3, v2

    aput-byte v2, p3, v1

    iget-object v1, p0, Lcom/amazonaws/util/Base64Codec;->ALPAHBETS:[B

    and-int/lit8 v2, v4, 0x3f

    aget-byte v1, v1, v2

    aput-byte v1, p3, v0

    return-void
.end method
