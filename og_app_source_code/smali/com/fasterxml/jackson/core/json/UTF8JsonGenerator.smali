.class public Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;
.super Lcom/fasterxml/jackson/core/json/JsonGeneratorImpl;
.source "UTF8JsonGenerator.java"


# static fields
.field private static final D:[B

.field private static final E:[B

.field private static final F:[B

.field static final t:[B


# instance fields
.field protected final A:I

.field protected B:Z

.field protected C:Z

.field protected final u:Ljava/io/OutputStream;

.field protected v:[B

.field protected w:I

.field protected final x:I

.field protected final y:I

.field protected z:[C


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    const/4 v1, 0x4

    .line 30
    invoke-static {}, Lcom/fasterxml/jackson/core/io/CharTypes;->h()[B

    move-result-object v0

    sput-object v0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->t:[B

    .line 32
    new-array v0, v1, [B

    fill-array-data v0, :array_0

    sput-object v0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->D:[B

    .line 33
    new-array v0, v1, [B

    fill-array-data v0, :array_1

    sput-object v0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->E:[B

    .line 34
    const/4 v0, 0x5

    new-array v0, v0, [B

    fill-array-data v0, :array_2

    sput-object v0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->F:[B

    return-void

    .line 32
    :array_0
    .array-data 1
        0x6et
        0x75t
        0x6ct
        0x6ct
    .end array-data

    .line 33
    :array_1
    .array-data 1
        0x74t
        0x72t
        0x75t
        0x65t
    .end array-data

    .line 34
    :array_2
    .array-data 1
        0x66t
        0x61t
        0x6ct
        0x73t
        0x65t
    .end array-data
.end method

.method public constructor <init>(Lcom/fasterxml/jackson/core/io/IOContext;ILcom/fasterxml/jackson/core/ObjectCodec;Ljava/io/OutputStream;)V
    .locals 3

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    .line 115
    invoke-direct {p0, p1, p2, p3}, Lcom/fasterxml/jackson/core/json/JsonGeneratorImpl;-><init>(Lcom/fasterxml/jackson/core/io/IOContext;ILcom/fasterxml/jackson/core/ObjectCodec;)V

    .line 57
    iput v1, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    .line 116
    iput-object p4, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->u:Ljava/io/OutputStream;

    .line 117
    iput-boolean v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->B:Z

    .line 118
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/io/IOContext;->f()[B

    move-result-object v2

    iput-object v2, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->v:[B

    .line 119
    iget-object v2, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->v:[B

    array-length v2, v2

    iput v2, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->x:I

    .line 125
    iget v2, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->x:I

    shr-int/lit8 v2, v2, 0x3

    iput v2, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->y:I

    .line 126
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/io/IOContext;->h()[C

    move-result-object v2

    iput-object v2, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->z:[C

    .line 127
    iget-object v2, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->z:[C

    array-length v2, v2

    iput v2, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->A:I

    .line 130
    sget-object v2, Lcom/fasterxml/jackson/core/JsonGenerator$Feature;->ESCAPE_NON_ASCII:Lcom/fasterxml/jackson/core/JsonGenerator$Feature;

    invoke-virtual {p0, v2}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->a(Lcom/fasterxml/jackson/core/JsonGenerator$Feature;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 131
    const/16 v2, 0x7f

    invoke-virtual {p0, v2}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->a(I)Lcom/fasterxml/jackson/core/JsonGenerator;

    .line 133
    :cond_0
    sget-object v2, Lcom/fasterxml/jackson/core/JsonGenerator$Feature;->QUOTE_FIELD_NAMES:Lcom/fasterxml/jackson/core/JsonGenerator$Feature;

    invoke-virtual {v2, p2}, Lcom/fasterxml/jackson/core/JsonGenerator$Feature;->enabledIn(I)Z

    move-result v2

    if-nez v2, :cond_1

    :goto_0
    iput-boolean v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->C:Z

    .line 134
    return-void

    :cond_1
    move v0, v1

    .line 133
    goto :goto_0
.end method

.method private final a(I[CII)I
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1904
    const v0, 0xd800

    if-lt p1, v0, :cond_2

    .line 1905
    const v0, 0xdfff

    if-gt p1, v0, :cond_2

    .line 1907
    if-ge p3, p4, :cond_0

    if-nez p2, :cond_1

    .line 1908
    :cond_0
    const-string v0, "Split surrogate on writeRaw() input (last character)"

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->e(Ljava/lang/String;)V

    .line 1910
    :cond_1
    aget-char v0, p2, p3

    invoke-virtual {p0, p1, v0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->b(II)V

    .line 1911
    add-int/lit8 p3, p3, 0x1

    .line 1918
    :goto_0
    return p3

    .line 1914
    :cond_2
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->v:[B

    .line 1915
    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    add-int/lit8 v2, v1, 0x1

    iput v2, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    shr-int/lit8 v2, p1, 0xc

    or-int/lit16 v2, v2, 0xe0

    int-to-byte v2, v2

    aput-byte v2, v0, v1

    .line 1916
    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    add-int/lit8 v2, v1, 0x1

    iput v2, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    shr-int/lit8 v2, p1, 0x6

    and-int/lit8 v2, v2, 0x3f

    or-int/lit16 v2, v2, 0x80

    int-to-byte v2, v2

    aput-byte v2, v0, v1

    .line 1917
    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    add-int/lit8 v2, v1, 0x1

    iput v2, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    and-int/lit8 v2, p1, 0x3f

    or-int/lit16 v2, v2, 0x80

    int-to-byte v2, v2

    aput-byte v2, v0, v1

    goto :goto_0
.end method

.method private final a([BII[BI)I
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonGenerationException;
        }
    .end annotation

    .prologue
    const/4 v3, 0x0

    .line 1598
    array-length v1, p4

    .line 1599
    add-int v0, p2, v1

    if-le v0, p3, :cond_2

    .line 1600
    iput p2, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    .line 1601
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->l()V

    .line 1602
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    .line 1603
    array-length v2, p1

    if-le v1, v2, :cond_1

    .line 1604
    iget-object v2, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->u:Ljava/io/OutputStream;

    invoke-virtual {v2, p4, v3, v1}, Ljava/io/OutputStream;->write([BII)V

    .line 1615
    :cond_0
    :goto_0
    return v0

    .line 1607
    :cond_1
    invoke-static {p4, v3, p1, v0, v1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 1608
    add-int/2addr v0, v1

    .line 1611
    :goto_1
    mul-int/lit8 v1, p5, 0x6

    add-int/2addr v1, v0

    if-le v1, p3, :cond_0

    .line 1612
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->l()V

    .line 1613
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    goto :goto_0

    :cond_2
    move v0, p2

    goto :goto_1
.end method

.method private final a([BILcom/fasterxml/jackson/core/SerializableString;I)I
    .locals 6
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonGenerationException;
        }
    .end annotation

    .prologue
    .line 1584
    invoke-interface {p3}, Lcom/fasterxml/jackson/core/SerializableString;->b()[B

    move-result-object v4

    .line 1585
    array-length v0, v4

    .line 1586
    const/4 v1, 0x6

    if-le v0, v1, :cond_0

    .line 1587
    iget v3, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->x:I

    move-object v0, p0

    move-object v1, p1

    move v2, p2

    move v5, p4

    invoke-direct/range {v0 .. v5}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->a([BII[BI)I

    move-result v0

    .line 1591
    :goto_0
    return v0

    .line 1590
    :cond_0
    const/4 v1, 0x0

    invoke-static {v4, v1, p1, p2, v0}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 1591
    add-int/2addr v0, p2

    goto :goto_0
.end method

.method private final a(Ljava/lang/String;II)V
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1185
    :cond_0
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->y:I

    invoke-static {v0, p3}, Ljava/lang/Math;->min(II)I

    move-result v0

    .line 1186
    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    add-int/2addr v1, v0

    iget v2, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->x:I

    if-le v1, v2, :cond_1

    .line 1187
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->l()V

    .line 1189
    :cond_1
    invoke-direct {p0, p1, p2, v0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->b(Ljava/lang/String;II)V

    .line 1190
    add-int/2addr p2, v0

    .line 1191
    sub-int/2addr p3, v0

    .line 1192
    if-gtz p3, :cond_0

    .line 1193
    return-void
.end method

.method private final a(Ljava/lang/String;Z)V
    .locals 6
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/16 v5, 0x22

    .line 1135
    if-eqz p2, :cond_1

    .line 1136
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->x:I

    if-lt v0, v1, :cond_0

    .line 1137
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->l()V

    .line 1139
    :cond_0
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->v:[B

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    add-int/lit8 v2, v1, 0x1

    iput v2, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    aput-byte v5, v0, v1

    .line 1142
    :cond_1
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v1

    .line 1143
    const/4 v0, 0x0

    .line 1145
    :goto_0
    if-lez v1, :cond_3

    .line 1146
    iget v2, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->y:I

    invoke-static {v2, v1}, Ljava/lang/Math;->min(II)I

    move-result v2

    .line 1147
    iget v3, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    add-int/2addr v3, v2

    iget v4, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->x:I

    if-le v3, v4, :cond_2

    .line 1148
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->l()V

    .line 1150
    :cond_2
    invoke-direct {p0, p1, v0, v2}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->b(Ljava/lang/String;II)V

    .line 1151
    add-int/2addr v0, v2

    .line 1152
    sub-int/2addr v1, v2

    .line 1153
    goto :goto_0

    .line 1155
    :cond_3
    if-eqz p2, :cond_5

    .line 1156
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->x:I

    if-lt v0, v1, :cond_4

    .line 1157
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->l()V

    .line 1159
    :cond_4
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->v:[B

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    add-int/lit8 v2, v1, 0x1

    iput v2, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    aput-byte v5, v0, v1

    .line 1161
    :cond_5
    return-void
.end method

.method private final a([B)V
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v3, 0x0

    .line 1093
    array-length v0, p1

    .line 1094
    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    add-int/2addr v1, v0

    iget v2, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->x:I

    if-le v1, v2, :cond_0

    .line 1095
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->l()V

    .line 1097
    const/16 v1, 0x200

    if-le v0, v1, :cond_0

    .line 1098
    iget-object v1, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->u:Ljava/io/OutputStream;

    invoke-virtual {v1, p1, v3, v0}, Ljava/io/OutputStream;->write([BII)V

    .line 1104
    :goto_0
    return-void

    .line 1102
    :cond_0
    iget-object v1, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->v:[B

    iget v2, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    invoke-static {p1, v3, v1, v2, v0}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 1103
    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    add-int/2addr v0, v1

    iput v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    goto :goto_0
.end method

.method private final b(J)V
    .locals 5
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/16 v3, 0x22

    .line 818
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    add-int/lit8 v0, v0, 0x17

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->x:I

    if-lt v0, v1, :cond_0

    .line 819
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->l()V

    .line 821
    :cond_0
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->v:[B

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    add-int/lit8 v2, v1, 0x1

    iput v2, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    aput-byte v3, v0, v1

    .line 822
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->v:[B

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    invoke-static {p1, p2, v0, v1}, Lcom/fasterxml/jackson/core/io/NumberOutput;->a(J[BI)I

    move-result v0

    iput v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    .line 823
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->v:[B

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    add-int/lit8 v2, v1, 0x1

    iput v2, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    aput-byte v3, v0, v1

    .line 824
    return-void
.end method

.method private final b(Ljava/lang/String;II)V
    .locals 6
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1249
    add-int v2, p3, p2

    .line 1251
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    .line 1252
    iget-object v3, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->v:[B

    .line 1253
    iget-object v4, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->p:[I

    .line 1255
    :goto_0
    if-ge p2, v2, :cond_0

    .line 1256
    invoke-virtual {p1, p2}, Ljava/lang/String;->charAt(I)C

    move-result v5

    .line 1258
    const/16 v1, 0x7f

    if-gt v5, v1, :cond_0

    aget v1, v4, v5

    if-eqz v1, :cond_2

    .line 1264
    :cond_0
    iput v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    .line 1265
    if-ge p2, v2, :cond_1

    .line 1266
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->r:Lcom/fasterxml/jackson/core/io/CharacterEscapes;

    if-eqz v0, :cond_3

    .line 1267
    invoke-direct {p0, p1, p2, v2}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->e(Ljava/lang/String;II)V

    .line 1274
    :cond_1
    :goto_1
    return-void

    .line 1261
    :cond_2
    add-int/lit8 v1, v0, 0x1

    int-to-byte v5, v5

    aput-byte v5, v3, v0

    .line 1262
    add-int/lit8 p2, p2, 0x1

    move v0, v1

    .line 1263
    goto :goto_0

    .line 1268
    :cond_3
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->q:I

    if-nez v0, :cond_4

    .line 1269
    invoke-direct {p0, p1, p2, v2}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->c(Ljava/lang/String;II)V

    goto :goto_1

    .line 1271
    :cond_4
    invoke-direct {p0, p1, p2, v2}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->d(Ljava/lang/String;II)V

    goto :goto_1
.end method

.method private final b([CII)V
    .locals 6
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonGenerationException;
        }
    .end annotation

    .prologue
    .line 651
    iget v2, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->x:I

    .line 652
    iget-object v3, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->v:[B

    move v0, p2

    .line 655
    :goto_0
    if-ge v0, p3, :cond_4

    .line 658
    :cond_0
    aget-char v1, p1, v0

    .line 659
    const/16 v4, 0x80

    if-lt v1, v4, :cond_2

    .line 671
    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    add-int/lit8 v1, v1, 0x3

    iget v4, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->x:I

    if-lt v1, v4, :cond_1

    .line 672
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->l()V

    .line 674
    :cond_1
    add-int/lit8 v1, v0, 0x1

    aget-char v0, p1, v0

    .line 675
    const/16 v4, 0x800

    if-ge v0, v4, :cond_5

    .line 676
    iget v4, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    add-int/lit8 v5, v4, 0x1

    iput v5, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    shr-int/lit8 v5, v0, 0x6

    or-int/lit16 v5, v5, 0xc0

    int-to-byte v5, v5

    aput-byte v5, v3, v4

    .line 677
    iget v4, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    add-int/lit8 v5, v4, 0x1

    iput v5, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    and-int/lit8 v0, v0, 0x3f

    or-int/lit16 v0, v0, 0x80

    int-to-byte v0, v0

    aput-byte v0, v3, v4

    move v0, v1

    goto :goto_0

    .line 663
    :cond_2
    iget v4, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    if-lt v4, v2, :cond_3

    .line 664
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->l()V

    .line 666
    :cond_3
    iget v4, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    add-int/lit8 v5, v4, 0x1

    iput v5, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    int-to-byte v1, v1

    aput-byte v1, v3, v4

    .line 667
    add-int/lit8 v0, v0, 0x1

    if-lt v0, p3, :cond_0

    .line 682
    :cond_4
    return-void

    .line 679
    :cond_5
    invoke-direct {p0, v0, p1, v1, p3}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->a(I[CII)I

    move-result v0

    goto :goto_0
.end method

.method private final c(II)I
    .locals 5
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1946
    iget-object v1, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->v:[B

    .line 1947
    const v0, 0xd800

    if-lt p1, v0, :cond_0

    const v0, 0xdfff

    if-gt p1, v0, :cond_0

    .line 1948
    add-int/lit8 v0, p2, 0x1

    const/16 v2, 0x5c

    aput-byte v2, v1, p2

    .line 1949
    add-int/lit8 v2, v0, 0x1

    const/16 v3, 0x75

    aput-byte v3, v1, v0

    .line 1951
    add-int/lit8 v0, v2, 0x1

    sget-object v3, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->t:[B

    shr-int/lit8 v4, p1, 0xc

    and-int/lit8 v4, v4, 0xf

    aget-byte v3, v3, v4

    aput-byte v3, v1, v2

    .line 1952
    add-int/lit8 v2, v0, 0x1

    sget-object v3, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->t:[B

    shr-int/lit8 v4, p1, 0x8

    and-int/lit8 v4, v4, 0xf

    aget-byte v3, v3, v4

    aput-byte v3, v1, v0

    .line 1953
    add-int/lit8 v3, v2, 0x1

    sget-object v0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->t:[B

    shr-int/lit8 v4, p1, 0x4

    and-int/lit8 v4, v4, 0xf

    aget-byte v0, v0, v4

    aput-byte v0, v1, v2

    .line 1954
    add-int/lit8 v0, v3, 0x1

    sget-object v2, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->t:[B

    and-int/lit8 v4, p1, 0xf

    aget-byte v2, v2, v4

    aput-byte v2, v1, v3

    .line 1960
    :goto_0
    return v0

    .line 1956
    :cond_0
    add-int/lit8 v0, p2, 0x1

    shr-int/lit8 v2, p1, 0xc

    or-int/lit16 v2, v2, 0xe0

    int-to-byte v2, v2

    aput-byte v2, v1, p2

    .line 1957
    add-int/lit8 v2, v0, 0x1

    shr-int/lit8 v3, p1, 0x6

    and-int/lit8 v3, v3, 0x3f

    or-int/lit16 v3, v3, 0x80

    int-to-byte v3, v3

    aput-byte v3, v1, v0

    .line 1958
    add-int/lit8 v0, v2, 0x1

    and-int/lit8 v3, p1, 0x3f

    or-int/lit16 v3, v3, 0x80

    int-to-byte v3, v3

    aput-byte v3, v1, v2

    goto :goto_0
.end method

.method private final c(I)V
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/16 v3, 0x22

    .line 792
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    add-int/lit8 v0, v0, 0xd

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->x:I

    if-lt v0, v1, :cond_0

    .line 793
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->l()V

    .line 795
    :cond_0
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->v:[B

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    add-int/lit8 v2, v1, 0x1

    iput v2, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    aput-byte v3, v0, v1

    .line 796
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->v:[B

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    invoke-static {p1, v0, v1}, Lcom/fasterxml/jackson/core/io/NumberOutput;->a(I[BI)I

    move-result v0

    iput v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    .line 797
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->v:[B

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    add-int/lit8 v2, v1, 0x1

    iput v2, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    aput-byte v3, v0, v1

    .line 798
    return-void
.end method

.method private final c(Ljava/lang/String;II)V
    .locals 7
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1321
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    sub-int v1, p3, p2

    mul-int/lit8 v1, v1, 0x6

    add-int/2addr v0, v1

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->x:I

    if-le v0, v1, :cond_0

    .line 1322
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->l()V

    .line 1325
    :cond_0
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    .line 1327
    iget-object v3, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->v:[B

    .line 1328
    iget-object v4, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->p:[I

    .line 1330
    :goto_0
    if-ge p2, p3, :cond_5

    .line 1331
    add-int/lit8 v2, p2, 0x1

    invoke-virtual {p1, p2}, Ljava/lang/String;->charAt(I)C

    move-result v5

    .line 1332
    const/16 v1, 0x7f

    if-gt v5, v1, :cond_3

    .line 1333
    aget v1, v4, v5

    if-nez v1, :cond_1

    .line 1334
    add-int/lit8 v1, v0, 0x1

    int-to-byte v5, v5

    aput-byte v5, v3, v0

    move v0, v1

    move p2, v2

    .line 1335
    goto :goto_0

    .line 1337
    :cond_1
    aget v1, v4, v5

    .line 1338
    if-lez v1, :cond_2

    .line 1339
    add-int/lit8 v5, v0, 0x1

    const/16 v6, 0x5c

    aput-byte v6, v3, v0

    .line 1340
    add-int/lit8 v0, v5, 0x1

    int-to-byte v1, v1

    aput-byte v1, v3, v5

    move p2, v2

    goto :goto_0

    .line 1343
    :cond_2
    invoke-direct {p0, v5, v0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->d(II)I

    move-result v0

    move p2, v2

    .line 1345
    goto :goto_0

    .line 1347
    :cond_3
    const/16 v1, 0x7ff

    if-gt v5, v1, :cond_4

    .line 1348
    add-int/lit8 v1, v0, 0x1

    shr-int/lit8 v6, v5, 0x6

    or-int/lit16 v6, v6, 0xc0

    int-to-byte v6, v6

    aput-byte v6, v3, v0

    .line 1349
    add-int/lit8 v0, v1, 0x1

    and-int/lit8 v5, v5, 0x3f

    or-int/lit16 v5, v5, 0x80

    int-to-byte v5, v5

    aput-byte v5, v3, v1

    :goto_1
    move p2, v2

    .line 1353
    goto :goto_0

    .line 1351
    :cond_4
    invoke-direct {p0, v5, v0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->c(II)I

    move-result v0

    goto :goto_1

    .line 1354
    :cond_5
    iput v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    .line 1355
    return-void
.end method

.method private final c([CII)V
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1172
    :cond_0
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->y:I

    invoke-static {v0, p3}, Ljava/lang/Math;->min(II)I

    move-result v0

    .line 1173
    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    add-int/2addr v1, v0

    iget v2, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->x:I

    if-le v1, v2, :cond_1

    .line 1174
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->l()V

    .line 1176
    :cond_1
    invoke-direct {p0, p1, p2, v0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->d([CII)V

    .line 1177
    add-int/2addr p2, v0

    .line 1178
    sub-int/2addr p3, v0

    .line 1179
    if-gtz p3, :cond_0

    .line 1180
    return-void
.end method

.method private d(II)I
    .locals 6
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/16 v4, 0x30

    .line 1980
    iget-object v1, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->v:[B

    .line 1981
    add-int/lit8 v0, p2, 0x1

    const/16 v2, 0x5c

    aput-byte v2, v1, p2

    .line 1982
    add-int/lit8 v2, v0, 0x1

    const/16 v3, 0x75

    aput-byte v3, v1, v0

    .line 1983
    const/16 v0, 0xff

    if-le p1, v0, :cond_0

    .line 1984
    shr-int/lit8 v0, p1, 0x8

    and-int/lit16 v3, v0, 0xff

    .line 1985
    add-int/lit8 v4, v2, 0x1

    sget-object v0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->t:[B

    shr-int/lit8 v5, v3, 0x4

    aget-byte v0, v0, v5

    aput-byte v0, v1, v2

    .line 1986
    add-int/lit8 v0, v4, 0x1

    sget-object v2, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->t:[B

    and-int/lit8 v3, v3, 0xf

    aget-byte v2, v2, v3

    aput-byte v2, v1, v4

    .line 1987
    and-int/lit16 p1, p1, 0xff

    .line 1993
    :goto_0
    add-int/lit8 v2, v0, 0x1

    sget-object v3, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->t:[B

    shr-int/lit8 v4, p1, 0x4

    aget-byte v3, v3, v4

    aput-byte v3, v1, v0

    .line 1994
    add-int/lit8 v0, v2, 0x1

    sget-object v3, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->t:[B

    and-int/lit8 v4, p1, 0xf

    aget-byte v3, v3, v4

    aput-byte v3, v1, v2

    .line 1995
    return v0

    .line 1989
    :cond_0
    add-int/lit8 v3, v2, 0x1

    aput-byte v4, v1, v2

    .line 1990
    add-int/lit8 v0, v3, 0x1

    aput-byte v4, v1, v3

    goto :goto_0
.end method

.method private final d(Ljava/lang/String;II)V
    .locals 8
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1415
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    sub-int v1, p3, p2

    mul-int/lit8 v1, v1, 0x6

    add-int/2addr v0, v1

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->x:I

    if-le v0, v1, :cond_0

    .line 1416
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->l()V

    .line 1419
    :cond_0
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    .line 1421
    iget-object v3, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->v:[B

    .line 1422
    iget-object v4, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->p:[I

    .line 1423
    iget v5, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->q:I

    .line 1425
    :goto_0
    if-ge p2, p3, :cond_6

    .line 1426
    add-int/lit8 v2, p2, 0x1

    invoke-virtual {p1, p2}, Ljava/lang/String;->charAt(I)C

    move-result v6

    .line 1427
    const/16 v1, 0x7f

    if-gt v6, v1, :cond_3

    .line 1428
    aget v1, v4, v6

    if-nez v1, :cond_1

    .line 1429
    add-int/lit8 v1, v0, 0x1

    int-to-byte v6, v6

    aput-byte v6, v3, v0

    move v0, v1

    move p2, v2

    .line 1430
    goto :goto_0

    .line 1432
    :cond_1
    aget v1, v4, v6

    .line 1433
    if-lez v1, :cond_2

    .line 1434
    add-int/lit8 v6, v0, 0x1

    const/16 v7, 0x5c

    aput-byte v7, v3, v0

    .line 1435
    add-int/lit8 v0, v6, 0x1

    int-to-byte v1, v1

    aput-byte v1, v3, v6

    move p2, v2

    goto :goto_0

    .line 1438
    :cond_2
    invoke-direct {p0, v6, v0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->d(II)I

    move-result v0

    move p2, v2

    .line 1440
    goto :goto_0

    .line 1442
    :cond_3
    if-le v6, v5, :cond_4

    .line 1443
    invoke-direct {p0, v6, v0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->d(II)I

    move-result v0

    move p2, v2

    .line 1444
    goto :goto_0

    .line 1446
    :cond_4
    const/16 v1, 0x7ff

    if-gt v6, v1, :cond_5

    .line 1447
    add-int/lit8 v1, v0, 0x1

    shr-int/lit8 v7, v6, 0x6

    or-int/lit16 v7, v7, 0xc0

    int-to-byte v7, v7

    aput-byte v7, v3, v0

    .line 1448
    add-int/lit8 v0, v1, 0x1

    and-int/lit8 v6, v6, 0x3f

    or-int/lit16 v6, v6, 0x80

    int-to-byte v6, v6

    aput-byte v6, v3, v1

    :goto_1
    move p2, v2

    .line 1452
    goto :goto_0

    .line 1450
    :cond_5
    invoke-direct {p0, v6, v0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->c(II)I

    move-result v0

    goto :goto_1

    .line 1453
    :cond_6
    iput v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    .line 1454
    return-void
.end method

.method private final d([CII)V
    .locals 6
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1215
    add-int v2, p3, p2

    .line 1217
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    .line 1218
    iget-object v3, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->v:[B

    .line 1219
    iget-object v4, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->p:[I

    .line 1221
    :goto_0
    if-ge p2, v2, :cond_0

    .line 1222
    aget-char v5, p1, p2

    .line 1224
    const/16 v1, 0x7f

    if-gt v5, v1, :cond_0

    aget v1, v4, v5

    if-eqz v1, :cond_2

    .line 1230
    :cond_0
    iput v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    .line 1231
    if-ge p2, v2, :cond_1

    .line 1233
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->r:Lcom/fasterxml/jackson/core/io/CharacterEscapes;

    if-eqz v0, :cond_3

    .line 1234
    invoke-direct {p0, p1, p2, v2}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->g([CII)V

    .line 1243
    :cond_1
    :goto_1
    return-void

    .line 1227
    :cond_2
    add-int/lit8 v1, v0, 0x1

    int-to-byte v5, v5

    aput-byte v5, v3, v0

    .line 1228
    add-int/lit8 p2, p2, 0x1

    move v0, v1

    .line 1229
    goto :goto_0

    .line 1236
    :cond_3
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->q:I

    if-nez v0, :cond_4

    .line 1237
    invoke-direct {p0, p1, p2, v2}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->e([CII)V

    goto :goto_1

    .line 1239
    :cond_4
    invoke-direct {p0, p1, p2, v2}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->f([CII)V

    goto :goto_1
.end method

.method private final e(Ljava/lang/String;II)V
    .locals 10
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1527
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    sub-int v1, p3, p2

    mul-int/lit8 v1, v1, 0x6

    add-int/2addr v0, v1

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->x:I

    if-le v0, v1, :cond_0

    .line 1528
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->l()V

    .line 1530
    :cond_0
    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    .line 1532
    iget-object v4, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->v:[B

    .line 1533
    iget-object v5, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->p:[I

    .line 1535
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->q:I

    if-gtz v0, :cond_1

    const v0, 0xffff

    .line 1536
    :goto_0
    iget-object v6, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->r:Lcom/fasterxml/jackson/core/io/CharacterEscapes;

    .line 1538
    :goto_1
    if-ge p2, p3, :cond_a

    .line 1539
    add-int/lit8 v3, p2, 0x1

    invoke-virtual {p1, p2}, Ljava/lang/String;->charAt(I)C

    move-result v7

    .line 1540
    const/16 v2, 0x7f

    if-gt v7, v2, :cond_6

    .line 1541
    aget v2, v5, v7

    if-nez v2, :cond_2

    .line 1542
    add-int/lit8 v2, v1, 0x1

    int-to-byte v7, v7

    aput-byte v7, v4, v1

    move v1, v2

    move p2, v3

    .line 1543
    goto :goto_1

    .line 1535
    :cond_1
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->q:I

    goto :goto_0

    .line 1545
    :cond_2
    aget v2, v5, v7

    .line 1546
    if-lez v2, :cond_3

    .line 1547
    add-int/lit8 v7, v1, 0x1

    const/16 v8, 0x5c

    aput-byte v8, v4, v1

    .line 1548
    add-int/lit8 v1, v7, 0x1

    int-to-byte v2, v2

    aput-byte v2, v4, v7

    move p2, v3

    goto :goto_1

    .line 1549
    :cond_3
    const/4 v8, -0x2

    if-ne v2, v8, :cond_5

    .line 1550
    invoke-virtual {v6, v7}, Lcom/fasterxml/jackson/core/io/CharacterEscapes;->a(I)Lcom/fasterxml/jackson/core/SerializableString;

    move-result-object v2

    .line 1551
    if-nez v2, :cond_4

    .line 1552
    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "Invalid custom escape definitions; custom escape not found for character code 0x"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-static {v7}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v8, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, ", although was supposed to have one"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {p0, v7}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->e(Ljava/lang/String;)V

    .line 1555
    :cond_4
    sub-int v7, p3, v3

    invoke-direct {p0, v4, v1, v2, v7}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->a([BILcom/fasterxml/jackson/core/SerializableString;I)I

    move-result v1

    move p2, v3

    .line 1556
    goto :goto_1

    .line 1558
    :cond_5
    invoke-direct {p0, v7, v1}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->d(II)I

    move-result v1

    move p2, v3

    .line 1560
    goto :goto_1

    .line 1562
    :cond_6
    if-le v7, v0, :cond_7

    .line 1563
    invoke-direct {p0, v7, v1}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->d(II)I

    move-result v1

    move p2, v3

    .line 1564
    goto :goto_1

    .line 1566
    :cond_7
    invoke-virtual {v6, v7}, Lcom/fasterxml/jackson/core/io/CharacterEscapes;->a(I)Lcom/fasterxml/jackson/core/SerializableString;

    move-result-object v2

    .line 1567
    if-eqz v2, :cond_8

    .line 1568
    sub-int v7, p3, v3

    invoke-direct {p0, v4, v1, v2, v7}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->a([BILcom/fasterxml/jackson/core/SerializableString;I)I

    move-result v1

    move p2, v3

    .line 1569
    goto :goto_1

    .line 1571
    :cond_8
    const/16 v2, 0x7ff

    if-gt v7, v2, :cond_9

    .line 1572
    add-int/lit8 v2, v1, 0x1

    shr-int/lit8 v8, v7, 0x6

    or-int/lit16 v8, v8, 0xc0

    int-to-byte v8, v8

    aput-byte v8, v4, v1

    .line 1573
    add-int/lit8 v1, v2, 0x1

    and-int/lit8 v7, v7, 0x3f

    or-int/lit16 v7, v7, 0x80

    int-to-byte v7, v7

    aput-byte v7, v4, v2

    :goto_2
    move p2, v3

    .line 1577
    goto/16 :goto_1

    .line 1575
    :cond_9
    invoke-direct {p0, v7, v1}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->c(II)I

    move-result v1

    goto :goto_2

    .line 1578
    :cond_a
    iput v1, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    .line 1579
    return-void
.end method

.method private final e([CII)V
    .locals 7
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1283
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    sub-int v1, p3, p2

    mul-int/lit8 v1, v1, 0x6

    add-int/2addr v0, v1

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->x:I

    if-le v0, v1, :cond_0

    .line 1284
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->l()V

    .line 1287
    :cond_0
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    .line 1289
    iget-object v3, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->v:[B

    .line 1290
    iget-object v4, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->p:[I

    .line 1292
    :goto_0
    if-ge p2, p3, :cond_5

    .line 1293
    add-int/lit8 v2, p2, 0x1

    aget-char v5, p1, p2

    .line 1294
    const/16 v1, 0x7f

    if-gt v5, v1, :cond_3

    .line 1295
    aget v1, v4, v5

    if-nez v1, :cond_1

    .line 1296
    add-int/lit8 v1, v0, 0x1

    int-to-byte v5, v5

    aput-byte v5, v3, v0

    move v0, v1

    move p2, v2

    .line 1297
    goto :goto_0

    .line 1299
    :cond_1
    aget v1, v4, v5

    .line 1300
    if-lez v1, :cond_2

    .line 1301
    add-int/lit8 v5, v0, 0x1

    const/16 v6, 0x5c

    aput-byte v6, v3, v0

    .line 1302
    add-int/lit8 v0, v5, 0x1

    int-to-byte v1, v1

    aput-byte v1, v3, v5

    move p2, v2

    goto :goto_0

    .line 1305
    :cond_2
    invoke-direct {p0, v5, v0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->d(II)I

    move-result v0

    move p2, v2

    .line 1307
    goto :goto_0

    .line 1309
    :cond_3
    const/16 v1, 0x7ff

    if-gt v5, v1, :cond_4

    .line 1310
    add-int/lit8 v1, v0, 0x1

    shr-int/lit8 v6, v5, 0x6

    or-int/lit16 v6, v6, 0xc0

    int-to-byte v6, v6

    aput-byte v6, v3, v0

    .line 1311
    add-int/lit8 v0, v1, 0x1

    and-int/lit8 v5, v5, 0x3f

    or-int/lit16 v5, v5, 0x80

    int-to-byte v5, v5

    aput-byte v5, v3, v1

    :goto_1
    move p2, v2

    .line 1315
    goto :goto_0

    .line 1313
    :cond_4
    invoke-direct {p0, v5, v0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->c(II)I

    move-result v0

    goto :goto_1

    .line 1316
    :cond_5
    iput v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    .line 1317
    return-void
.end method

.method private final f([CII)V
    .locals 8
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1371
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    sub-int v1, p3, p2

    mul-int/lit8 v1, v1, 0x6

    add-int/2addr v0, v1

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->x:I

    if-le v0, v1, :cond_0

    .line 1372
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->l()V

    .line 1375
    :cond_0
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    .line 1377
    iget-object v3, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->v:[B

    .line 1378
    iget-object v4, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->p:[I

    .line 1379
    iget v5, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->q:I

    .line 1381
    :goto_0
    if-ge p2, p3, :cond_6

    .line 1382
    add-int/lit8 v2, p2, 0x1

    aget-char v6, p1, p2

    .line 1383
    const/16 v1, 0x7f

    if-gt v6, v1, :cond_3

    .line 1384
    aget v1, v4, v6

    if-nez v1, :cond_1

    .line 1385
    add-int/lit8 v1, v0, 0x1

    int-to-byte v6, v6

    aput-byte v6, v3, v0

    move v0, v1

    move p2, v2

    .line 1386
    goto :goto_0

    .line 1388
    :cond_1
    aget v1, v4, v6

    .line 1389
    if-lez v1, :cond_2

    .line 1390
    add-int/lit8 v6, v0, 0x1

    const/16 v7, 0x5c

    aput-byte v7, v3, v0

    .line 1391
    add-int/lit8 v0, v6, 0x1

    int-to-byte v1, v1

    aput-byte v1, v3, v6

    move p2, v2

    goto :goto_0

    .line 1394
    :cond_2
    invoke-direct {p0, v6, v0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->d(II)I

    move-result v0

    move p2, v2

    .line 1396
    goto :goto_0

    .line 1398
    :cond_3
    if-le v6, v5, :cond_4

    .line 1399
    invoke-direct {p0, v6, v0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->d(II)I

    move-result v0

    move p2, v2

    .line 1400
    goto :goto_0

    .line 1402
    :cond_4
    const/16 v1, 0x7ff

    if-gt v6, v1, :cond_5

    .line 1403
    add-int/lit8 v1, v0, 0x1

    shr-int/lit8 v7, v6, 0x6

    or-int/lit16 v7, v7, 0xc0

    int-to-byte v7, v7

    aput-byte v7, v3, v0

    .line 1404
    add-int/lit8 v0, v1, 0x1

    and-int/lit8 v6, v6, 0x3f

    or-int/lit16 v6, v6, 0x80

    int-to-byte v6, v6

    aput-byte v6, v3, v1

    :goto_1
    move p2, v2

    .line 1408
    goto :goto_0

    .line 1406
    :cond_5
    invoke-direct {p0, v6, v0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->c(II)I

    move-result v0

    goto :goto_1

    .line 1409
    :cond_6
    iput v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    .line 1410
    return-void
.end method

.method private final g([CII)V
    .locals 10
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1470
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    sub-int v1, p3, p2

    mul-int/lit8 v1, v1, 0x6

    add-int/2addr v0, v1

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->x:I

    if-le v0, v1, :cond_0

    .line 1471
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->l()V

    .line 1473
    :cond_0
    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    .line 1475
    iget-object v4, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->v:[B

    .line 1476
    iget-object v5, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->p:[I

    .line 1478
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->q:I

    if-gtz v0, :cond_1

    const v0, 0xffff

    .line 1479
    :goto_0
    iget-object v6, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->r:Lcom/fasterxml/jackson/core/io/CharacterEscapes;

    .line 1481
    :goto_1
    if-ge p2, p3, :cond_a

    .line 1482
    add-int/lit8 v3, p2, 0x1

    aget-char v7, p1, p2

    .line 1483
    const/16 v2, 0x7f

    if-gt v7, v2, :cond_6

    .line 1484
    aget v2, v5, v7

    if-nez v2, :cond_2

    .line 1485
    add-int/lit8 v2, v1, 0x1

    int-to-byte v7, v7

    aput-byte v7, v4, v1

    move v1, v2

    move p2, v3

    .line 1486
    goto :goto_1

    .line 1478
    :cond_1
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->q:I

    goto :goto_0

    .line 1488
    :cond_2
    aget v2, v5, v7

    .line 1489
    if-lez v2, :cond_3

    .line 1490
    add-int/lit8 v7, v1, 0x1

    const/16 v8, 0x5c

    aput-byte v8, v4, v1

    .line 1491
    add-int/lit8 v1, v7, 0x1

    int-to-byte v2, v2

    aput-byte v2, v4, v7

    move p2, v3

    goto :goto_1

    .line 1492
    :cond_3
    const/4 v8, -0x2

    if-ne v2, v8, :cond_5

    .line 1493
    invoke-virtual {v6, v7}, Lcom/fasterxml/jackson/core/io/CharacterEscapes;->a(I)Lcom/fasterxml/jackson/core/SerializableString;

    move-result-object v2

    .line 1494
    if-nez v2, :cond_4

    .line 1495
    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "Invalid custom escape definitions; custom escape not found for character code 0x"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-static {v7}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v8, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, ", although was supposed to have one"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {p0, v7}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->e(Ljava/lang/String;)V

    .line 1498
    :cond_4
    sub-int v7, p3, v3

    invoke-direct {p0, v4, v1, v2, v7}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->a([BILcom/fasterxml/jackson/core/SerializableString;I)I

    move-result v1

    move p2, v3

    .line 1499
    goto :goto_1

    .line 1501
    :cond_5
    invoke-direct {p0, v7, v1}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->d(II)I

    move-result v1

    move p2, v3

    .line 1503
    goto :goto_1

    .line 1505
    :cond_6
    if-le v7, v0, :cond_7

    .line 1506
    invoke-direct {p0, v7, v1}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->d(II)I

    move-result v1

    move p2, v3

    .line 1507
    goto :goto_1

    .line 1509
    :cond_7
    invoke-virtual {v6, v7}, Lcom/fasterxml/jackson/core/io/CharacterEscapes;->a(I)Lcom/fasterxml/jackson/core/SerializableString;

    move-result-object v2

    .line 1510
    if-eqz v2, :cond_8

    .line 1511
    sub-int v7, p3, v3

    invoke-direct {p0, v4, v1, v2, v7}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->a([BILcom/fasterxml/jackson/core/SerializableString;I)I

    move-result v1

    move p2, v3

    .line 1512
    goto :goto_1

    .line 1514
    :cond_8
    const/16 v2, 0x7ff

    if-gt v7, v2, :cond_9

    .line 1515
    add-int/lit8 v2, v1, 0x1

    shr-int/lit8 v8, v7, 0x6

    or-int/lit16 v8, v8, 0xc0

    int-to-byte v8, v8

    aput-byte v8, v4, v1

    .line 1516
    add-int/lit8 v1, v2, 0x1

    and-int/lit8 v7, v7, 0x3f

    or-int/lit16 v7, v7, 0x80

    int-to-byte v7, v7

    aput-byte v7, v4, v2

    :goto_2
    move p2, v3

    .line 1520
    goto/16 :goto_1

    .line 1518
    :cond_9
    invoke-direct {p0, v7, v1}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->c(II)I

    move-result v1

    goto :goto_2

    .line 1521
    :cond_a
    iput v1, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    .line 1522
    return-void
.end method

.method private final h(Ljava/lang/String;)V
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/16 v3, 0x22

    .line 905
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->x:I

    if-lt v0, v1, :cond_0

    .line 906
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->l()V

    .line 908
    :cond_0
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->v:[B

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    add-int/lit8 v2, v1, 0x1

    iput v2, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    aput-byte v3, v0, v1

    .line 909
    invoke-virtual {p0, p1}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->c(Ljava/lang/String;)V

    .line 910
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->x:I

    if-lt v0, v1, :cond_1

    .line 911
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->l()V

    .line 913
    :cond_1
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->v:[B

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    add-int/lit8 v2, v1, 0x1

    iput v2, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    aput-byte v3, v0, v1

    .line 914
    return-void
.end method

.method private final m()V
    .locals 5
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1965
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    add-int/lit8 v0, v0, 0x4

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->x:I

    if-lt v0, v1, :cond_0

    .line 1966
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->l()V

    .line 1968
    :cond_0
    sget-object v0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->D:[B

    const/4 v1, 0x0

    iget-object v2, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->v:[B

    iget v3, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    const/4 v4, 0x4

    invoke-static {v0, v1, v2, v3, v4}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 1969
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    add-int/lit8 v0, v0, 0x4

    iput v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    .line 1970
    return-void
.end method


# virtual methods
.method public a(C)V
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonGenerationException;
        }
    .end annotation

    .prologue
    const/4 v2, 0x0

    .line 630
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    add-int/lit8 v0, v0, 0x3

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->x:I

    if-lt v0, v1, :cond_0

    .line 631
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->l()V

    .line 633
    :cond_0
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->v:[B

    .line 634
    const/16 v1, 0x7f

    if-gt p1, v1, :cond_1

    .line 635
    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    add-int/lit8 v2, v1, 0x1

    iput v2, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    int-to-byte v2, p1

    aput-byte v2, v0, v1

    .line 642
    :goto_0
    return-void

    .line 636
    :cond_1
    const/16 v1, 0x800

    if-ge p1, v1, :cond_2

    .line 637
    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    add-int/lit8 v2, v1, 0x1

    iput v2, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    shr-int/lit8 v2, p1, 0x6

    or-int/lit16 v2, v2, 0xc0

    int-to-byte v2, v2

    aput-byte v2, v0, v1

    .line 638
    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    add-int/lit8 v2, v1, 0x1

    iput v2, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    and-int/lit8 v2, p1, 0x3f

    or-int/lit16 v2, v2, 0x80

    int-to-byte v2, v2

    aput-byte v2, v0, v1

    goto :goto_0

    .line 640
    :cond_2
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0, v2, v2}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->a(I[CII)I

    goto :goto_0
.end method

.method public a(D)V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonGenerationException;
        }
    .end annotation

    .prologue
    .line 845
    iget-boolean v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->k:Z

    if-nez v0, :cond_1

    invoke-static {p1, p2}, Ljava/lang/Double;->isNaN(D)Z

    move-result v0

    if-nez v0, :cond_0

    invoke-static {p1, p2}, Ljava/lang/Double;->isInfinite(D)Z

    move-result v0

    if-eqz v0, :cond_2

    :cond_0
    sget-object v0, Lcom/fasterxml/jackson/core/JsonGenerator$Feature;->QUOTE_NON_NUMERIC_NUMBERS:Lcom/fasterxml/jackson/core/JsonGenerator$Feature;

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->a(Lcom/fasterxml/jackson/core/JsonGenerator$Feature;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 849
    :cond_1
    invoke-static {p1, p2}, Ljava/lang/String;->valueOf(D)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->b(Ljava/lang/String;)V

    .line 855
    :goto_0
    return-void

    .line 853
    :cond_2
    const-string v0, "write a number"

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->f(Ljava/lang/String;)V

    .line 854
    invoke-static {p1, p2}, Ljava/lang/String;->valueOf(D)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->c(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public a(F)V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonGenerationException;
        }
    .end annotation

    .prologue
    .line 861
    iget-boolean v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->k:Z

    if-nez v0, :cond_1

    invoke-static {p1}, Ljava/lang/Float;->isNaN(F)Z

    move-result v0

    if-nez v0, :cond_0

    invoke-static {p1}, Ljava/lang/Float;->isInfinite(F)Z

    move-result v0

    if-eqz v0, :cond_2

    :cond_0
    sget-object v0, Lcom/fasterxml/jackson/core/JsonGenerator$Feature;->QUOTE_NON_NUMERIC_NUMBERS:Lcom/fasterxml/jackson/core/JsonGenerator$Feature;

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->a(Lcom/fasterxml/jackson/core/JsonGenerator$Feature;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 865
    :cond_1
    invoke-static {p1}, Ljava/lang/String;->valueOf(F)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->b(Ljava/lang/String;)V

    .line 871
    :goto_0
    return-void

    .line 869
    :cond_2
    const-string v0, "write a number"

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->f(Ljava/lang/String;)V

    .line 870
    invoke-static {p1}, Ljava/lang/String;->valueOf(F)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->c(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public a(J)V
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonGenerationException;
        }
    .end annotation

    .prologue
    .line 804
    const-string v0, "write a number"

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->f(Ljava/lang/String;)V

    .line 805
    iget-boolean v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->k:Z

    if-eqz v0, :cond_0

    .line 806
    invoke-direct {p0, p1, p2}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->b(J)V

    .line 814
    :goto_0
    return-void

    .line 809
    :cond_0
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    add-int/lit8 v0, v0, 0x15

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->x:I

    if-lt v0, v1, :cond_1

    .line 811
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->l()V

    .line 813
    :cond_1
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->v:[B

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    invoke-static {p1, p2, v0, v1}, Lcom/fasterxml/jackson/core/io/NumberOutput;->a(J[BI)I

    move-result v0

    iput v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    goto :goto_0
.end method

.method public a(Ljava/lang/String;)V
    .locals 6
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/16 v5, 0x22

    const/4 v3, 0x1

    const/4 v4, 0x0

    .line 180
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->a:Lcom/fasterxml/jackson/core/PrettyPrinter;

    if-eqz v0, :cond_0

    .line 181
    invoke-virtual {p0, p1}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->g(Ljava/lang/String;)V

    .line 225
    :goto_0
    return-void

    .line 184
    :cond_0
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->l:Lcom/fasterxml/jackson/core/json/JsonWriteContext;

    invoke-virtual {v0, p1}, Lcom/fasterxml/jackson/core/json/JsonWriteContext;->a(Ljava/lang/String;)I

    move-result v0

    .line 185
    const/4 v1, 0x4

    if-ne v0, v1, :cond_1

    .line 186
    const-string v1, "Can not write a field name, expecting a value"

    invoke-virtual {p0, v1}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->e(Ljava/lang/String;)V

    .line 188
    :cond_1
    if-ne v0, v3, :cond_3

    .line 189
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->x:I

    if-lt v0, v1, :cond_2

    .line 190
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->l()V

    .line 192
    :cond_2
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->v:[B

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    add-int/lit8 v2, v1, 0x1

    iput v2, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    const/16 v2, 0x2c

    aput-byte v2, v0, v1

    .line 197
    :cond_3
    iget-boolean v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->C:Z

    if-eqz v0, :cond_4

    .line 198
    invoke-direct {p0, p1, v4}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->a(Ljava/lang/String;Z)V

    goto :goto_0

    .line 201
    :cond_4
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v0

    .line 203
    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->A:I

    if-le v0, v1, :cond_5

    .line 204
    invoke-direct {p0, p1, v3}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->a(Ljava/lang/String;Z)V

    goto :goto_0

    .line 207
    :cond_5
    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    iget v2, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->x:I

    if-lt v1, v2, :cond_6

    .line 208
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->l()V

    .line 210
    :cond_6
    iget-object v1, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->v:[B

    iget v2, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    add-int/lit8 v3, v2, 0x1

    iput v3, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    aput-byte v5, v1, v2

    .line 212
    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->y:I

    if-gt v0, v1, :cond_9

    .line 213
    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    add-int/2addr v1, v0

    iget v2, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->x:I

    if-le v1, v2, :cond_7

    .line 214
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->l()V

    .line 216
    :cond_7
    invoke-direct {p0, p1, v4, v0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->b(Ljava/lang/String;II)V

    .line 221
    :goto_1
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->x:I

    if-lt v0, v1, :cond_8

    .line 222
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->l()V

    .line 224
    :cond_8
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->v:[B

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    add-int/lit8 v2, v1, 0x1

    iput v2, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    aput-byte v5, v0, v1

    goto :goto_0

    .line 218
    :cond_9
    invoke-direct {p0, p1, v4, v0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->a(Ljava/lang/String;II)V

    goto :goto_1
.end method

.method protected final a(Ljava/lang/String;I)V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 986
    packed-switch p2, :pswitch_data_0

    .line 1005
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->h()V

    .line 1008
    :cond_0
    :goto_0
    return-void

    .line 988
    :pswitch_0
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->a:Lcom/fasterxml/jackson/core/PrettyPrinter;

    invoke-interface {v0, p0}, Lcom/fasterxml/jackson/core/PrettyPrinter;->f(Lcom/fasterxml/jackson/core/JsonGenerator;)V

    goto :goto_0

    .line 991
    :pswitch_1
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->a:Lcom/fasterxml/jackson/core/PrettyPrinter;

    invoke-interface {v0, p0}, Lcom/fasterxml/jackson/core/PrettyPrinter;->d(Lcom/fasterxml/jackson/core/JsonGenerator;)V

    goto :goto_0

    .line 994
    :pswitch_2
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->a:Lcom/fasterxml/jackson/core/PrettyPrinter;

    invoke-interface {v0, p0}, Lcom/fasterxml/jackson/core/PrettyPrinter;->a(Lcom/fasterxml/jackson/core/JsonGenerator;)V

    goto :goto_0

    .line 998
    :pswitch_3
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->l:Lcom/fasterxml/jackson/core/json/JsonWriteContext;

    invoke-virtual {v0}, Lcom/fasterxml/jackson/core/json/JsonWriteContext;->a()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 999
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->a:Lcom/fasterxml/jackson/core/PrettyPrinter;

    invoke-interface {v0, p0}, Lcom/fasterxml/jackson/core/PrettyPrinter;->g(Lcom/fasterxml/jackson/core/JsonGenerator;)V

    goto :goto_0

    .line 1000
    :cond_1
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->l:Lcom/fasterxml/jackson/core/json/JsonWriteContext;

    invoke-virtual {v0}, Lcom/fasterxml/jackson/core/json/JsonWriteContext;->c()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1001
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->a:Lcom/fasterxml/jackson/core/PrettyPrinter;

    invoke-interface {v0, p0}, Lcom/fasterxml/jackson/core/PrettyPrinter;->h(Lcom/fasterxml/jackson/core/JsonGenerator;)V

    goto :goto_0

    .line 986
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_3
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method public a(Ljava/math/BigDecimal;)V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonGenerationException;
        }
    .end annotation

    .prologue
    .line 878
    const-string v0, "write a number"

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->f(Ljava/lang/String;)V

    .line 879
    if-nez p1, :cond_0

    .line 880
    invoke-direct {p0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->m()V

    .line 889
    :goto_0
    return-void

    .line 881
    :cond_0
    iget-boolean v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->k:Z

    if-eqz v0, :cond_2

    .line 882
    sget-object v0, Lcom/fasterxml/jackson/core/JsonGenerator$Feature;->WRITE_BIGDECIMAL_AS_PLAIN:Lcom/fasterxml/jackson/core/JsonGenerator$Feature;

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->a(Lcom/fasterxml/jackson/core/JsonGenerator$Feature;)Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-virtual {p1}, Ljava/math/BigDecimal;->toPlainString()Ljava/lang/String;

    move-result-object v0

    .line 883
    :goto_1
    invoke-direct {p0, v0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->h(Ljava/lang/String;)V

    goto :goto_0

    .line 882
    :cond_1
    invoke-virtual {p1}, Ljava/math/BigDecimal;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_1

    .line 884
    :cond_2
    sget-object v0, Lcom/fasterxml/jackson/core/JsonGenerator$Feature;->WRITE_BIGDECIMAL_AS_PLAIN:Lcom/fasterxml/jackson/core/JsonGenerator$Feature;

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->a(Lcom/fasterxml/jackson/core/JsonGenerator$Feature;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 885
    invoke-virtual {p1}, Ljava/math/BigDecimal;->toPlainString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->c(Ljava/lang/String;)V

    goto :goto_0

    .line 887
    :cond_3
    invoke-virtual {p1}, Ljava/math/BigDecimal;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->c(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public a(Ljava/math/BigInteger;)V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonGenerationException;
        }
    .end annotation

    .prologue
    .line 830
    const-string v0, "write a number"

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->f(Ljava/lang/String;)V

    .line 831
    if-nez p1, :cond_0

    .line 832
    invoke-direct {p0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->m()V

    .line 838
    :goto_0
    return-void

    .line 833
    :cond_0
    iget-boolean v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->k:Z

    if-eqz v0, :cond_1

    .line 834
    invoke-virtual {p1}, Ljava/math/BigInteger;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->h(Ljava/lang/String;)V

    goto :goto_0

    .line 836
    :cond_1
    invoke-virtual {p1}, Ljava/math/BigInteger;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->c(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public a(Z)V
    .locals 5
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonGenerationException;
        }
    .end annotation

    .prologue
    .line 920
    const-string v0, "write a boolean value"

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->f(Ljava/lang/String;)V

    .line 921
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    add-int/lit8 v0, v0, 0x5

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->x:I

    if-lt v0, v1, :cond_0

    .line 922
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->l()V

    .line 924
    :cond_0
    if-eqz p1, :cond_1

    sget-object v0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->E:[B

    .line 925
    :goto_0
    array-length v1, v0

    .line 926
    const/4 v2, 0x0

    iget-object v3, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->v:[B

    iget v4, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    invoke-static {v0, v2, v3, v4, v1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 927
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    add-int/2addr v0, v1

    iput v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    .line 928
    return-void

    .line 924
    :cond_1
    sget-object v0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->F:[B

    goto :goto_0
.end method

.method public final a([CII)V
    .locals 6
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonGenerationException;
        }
    .end annotation

    .prologue
    .line 589
    add-int v0, p3, p3

    add-int/2addr v0, p3

    .line 590
    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    add-int/2addr v1, v0

    iget v2, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->x:I

    if-le v1, v2, :cond_2

    .line 592
    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->x:I

    if-ge v1, v0, :cond_1

    .line 593
    invoke-direct {p0, p1, p2, p3}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->b([CII)V

    .line 624
    :cond_0
    :goto_0
    return-void

    .line 597
    :cond_1
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->l()V

    .line 600
    :cond_2
    add-int v2, p3, p2

    move v0, p2

    .line 604
    :goto_1
    if-ge v0, v2, :cond_0

    .line 607
    :cond_3
    aget-char v1, p1, v0

    .line 608
    const/16 v3, 0x7f

    if-le v1, v3, :cond_4

    .line 616
    add-int/lit8 v1, v0, 0x1

    aget-char v0, p1, v0

    .line 617
    const/16 v3, 0x800

    if-ge v0, v3, :cond_5

    .line 618
    iget-object v3, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->v:[B

    iget v4, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    add-int/lit8 v5, v4, 0x1

    iput v5, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    shr-int/lit8 v5, v0, 0x6

    or-int/lit16 v5, v5, 0xc0

    int-to-byte v5, v5

    aput-byte v5, v3, v4

    .line 619
    iget-object v3, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->v:[B

    iget v4, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    add-int/lit8 v5, v4, 0x1

    iput v5, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    and-int/lit8 v0, v0, 0x3f

    or-int/lit16 v0, v0, 0x80

    int-to-byte v0, v0

    aput-byte v0, v3, v4

    move v0, v1

    goto :goto_1

    .line 611
    :cond_4
    iget-object v3, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->v:[B

    iget v4, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    add-int/lit8 v5, v4, 0x1

    iput v5, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    int-to-byte v1, v1

    aput-byte v1, v3, v4

    .line 612
    add-int/lit8 v0, v0, 0x1

    if-lt v0, v2, :cond_3

    goto :goto_0

    .line 621
    :cond_5
    invoke-direct {p0, v0, p1, v1, v2}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->a(I[CII)I

    move-result v0

    goto :goto_1
.end method

.method public b(I)V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonGenerationException;
        }
    .end annotation

    .prologue
    .line 778
    const-string v0, "write a number"

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->f(Ljava/lang/String;)V

    .line 780
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    add-int/lit8 v0, v0, 0xb

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->x:I

    if-lt v0, v1, :cond_0

    .line 781
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->l()V

    .line 783
    :cond_0
    iget-boolean v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->k:Z

    if-eqz v0, :cond_1

    .line 784
    invoke-direct {p0, p1}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->c(I)V

    .line 788
    :goto_0
    return-void

    .line 787
    :cond_1
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->v:[B

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    invoke-static {p1, v0, v1}, Lcom/fasterxml/jackson/core/io/NumberOutput;->a(I[BI)I

    move-result v0

    iput v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    goto :goto_0
.end method

.method protected final b(II)V
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1924
    invoke-virtual {p0, p1, p2}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->a(II)I

    move-result v0

    .line 1925
    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    add-int/lit8 v1, v1, 0x4

    iget v2, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->x:I

    if-le v1, v2, :cond_0

    .line 1926
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->l()V

    .line 1928
    :cond_0
    iget-object v1, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->v:[B

    .line 1929
    iget v2, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    add-int/lit8 v3, v2, 0x1

    iput v3, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    shr-int/lit8 v3, v0, 0x12

    or-int/lit16 v3, v3, 0xf0

    int-to-byte v3, v3

    aput-byte v3, v1, v2

    .line 1930
    iget v2, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    add-int/lit8 v3, v2, 0x1

    iput v3, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    shr-int/lit8 v3, v0, 0xc

    and-int/lit8 v3, v3, 0x3f

    or-int/lit16 v3, v3, 0x80

    int-to-byte v3, v3

    aput-byte v3, v1, v2

    .line 1931
    iget v2, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    add-int/lit8 v3, v2, 0x1

    iput v3, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    shr-int/lit8 v3, v0, 0x6

    and-int/lit8 v3, v3, 0x3f

    or-int/lit16 v3, v3, 0x80

    int-to-byte v3, v3

    aput-byte v3, v1, v2

    .line 1932
    iget v2, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    add-int/lit8 v3, v2, 0x1

    iput v3, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    and-int/lit8 v0, v0, 0x3f

    or-int/lit16 v0, v0, 0x80

    int-to-byte v0, v0

    aput-byte v0, v1, v2

    .line 1933
    return-void
.end method

.method public b(Lcom/fasterxml/jackson/core/SerializableString;)V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonGenerationException;
        }
    .end annotation

    .prologue
    .line 566
    invoke-interface {p1}, Lcom/fasterxml/jackson/core/SerializableString;->b()[B

    move-result-object v0

    .line 567
    array-length v1, v0

    if-lez v1, :cond_0

    .line 568
    invoke-direct {p0, v0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->a([B)V

    .line 570
    :cond_0
    return-void
.end method

.method public b(Ljava/lang/String;)V
    .locals 5
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/16 v4, 0x22

    .line 424
    const-string v0, "write a string"

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->f(Ljava/lang/String;)V

    .line 425
    if-nez p1, :cond_0

    .line 426
    invoke-direct {p0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->m()V

    .line 444
    :goto_0
    return-void

    .line 430
    :cond_0
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v0

    .line 431
    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->y:I

    if-le v0, v1, :cond_1

    .line 432
    const/4 v0, 0x1

    invoke-direct {p0, p1, v0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->a(Ljava/lang/String;Z)V

    goto :goto_0

    .line 435
    :cond_1
    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    add-int/2addr v1, v0

    iget v2, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->x:I

    if-lt v1, v2, :cond_2

    .line 436
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->l()V

    .line 438
    :cond_2
    iget-object v1, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->v:[B

    iget v2, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    add-int/lit8 v3, v2, 0x1

    iput v3, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    aput-byte v4, v1, v2

    .line 439
    const/4 v1, 0x0

    invoke-direct {p0, p1, v1, v0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->b(Ljava/lang/String;II)V

    .line 440
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->x:I

    if-lt v0, v1, :cond_3

    .line 441
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->l()V

    .line 443
    :cond_3
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->v:[B

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    add-int/lit8 v2, v1, 0x1

    iput v2, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    aput-byte v4, v0, v1

    goto :goto_0
.end method

.method public final c()V
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 282
    const-string v0, "start an array"

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->f(Ljava/lang/String;)V

    .line 283
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->l:Lcom/fasterxml/jackson/core/json/JsonWriteContext;

    invoke-virtual {v0}, Lcom/fasterxml/jackson/core/json/JsonWriteContext;->g()Lcom/fasterxml/jackson/core/json/JsonWriteContext;

    move-result-object v0

    iput-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->l:Lcom/fasterxml/jackson/core/json/JsonWriteContext;

    .line 284
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->a:Lcom/fasterxml/jackson/core/PrettyPrinter;

    if-eqz v0, :cond_0

    .line 285
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->a:Lcom/fasterxml/jackson/core/PrettyPrinter;

    invoke-interface {v0, p0}, Lcom/fasterxml/jackson/core/PrettyPrinter;->e(Lcom/fasterxml/jackson/core/JsonGenerator;)V

    .line 292
    :goto_0
    return-void

    .line 287
    :cond_0
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->x:I

    if-lt v0, v1, :cond_1

    .line 288
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->l()V

    .line 290
    :cond_1
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->v:[B

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    add-int/lit8 v2, v1, 0x1

    iput v2, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    const/16 v2, 0x5b

    aput-byte v2, v0, v1

    goto :goto_0
.end method

.method public c(Ljava/lang/String;)V
    .locals 6
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonGenerationException;
        }
    .end annotation

    .prologue
    const/4 v3, 0x0

    .line 535
    .line 536
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v1

    move v2, v3

    .line 537
    :goto_0
    if-lez v1, :cond_1

    .line 538
    iget-object v4, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->z:[C

    .line 539
    array-length v0, v4

    .line 540
    if-ge v1, v0, :cond_0

    move v0, v1

    .line 541
    :cond_0
    add-int v5, v2, v0

    invoke-virtual {p1, v2, v5, v4, v3}, Ljava/lang/String;->getChars(II[CI)V

    .line 542
    invoke-virtual {p0, v4, v3, v0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->a([CII)V

    .line 543
    add-int/2addr v2, v0

    .line 544
    sub-int/2addr v1, v0

    .line 545
    goto :goto_0

    .line 546
    :cond_1
    return-void
.end method

.method public close()V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1030
    invoke-super {p0}, Lcom/fasterxml/jackson/core/json/JsonGeneratorImpl;->close()V

    .line 1036
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->v:[B

    if-eqz v0, :cond_1

    sget-object v0, Lcom/fasterxml/jackson/core/JsonGenerator$Feature;->AUTO_CLOSE_JSON_CONTENT:Lcom/fasterxml/jackson/core/JsonGenerator$Feature;

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->a(Lcom/fasterxml/jackson/core/JsonGenerator$Feature;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 1039
    :goto_0
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->i()Lcom/fasterxml/jackson/core/json/JsonWriteContext;

    move-result-object v0

    .line 1040
    invoke-virtual {v0}, Lcom/fasterxml/jackson/core/JsonStreamContext;->a()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 1041
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->d()V

    goto :goto_0

    .line 1042
    :cond_0
    invoke-virtual {v0}, Lcom/fasterxml/jackson/core/JsonStreamContext;->c()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 1043
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->f()V

    goto :goto_0

    .line 1049
    :cond_1
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->l()V

    .line 1050
    const/4 v0, 0x0

    iput v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    .line 1058
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->u:Ljava/io/OutputStream;

    if-eqz v0, :cond_3

    .line 1059
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->o:Lcom/fasterxml/jackson/core/io/IOContext;

    invoke-virtual {v0}, Lcom/fasterxml/jackson/core/io/IOContext;->c()Z

    move-result v0

    if-nez v0, :cond_2

    sget-object v0, Lcom/fasterxml/jackson/core/JsonGenerator$Feature;->AUTO_CLOSE_TARGET:Lcom/fasterxml/jackson/core/JsonGenerator$Feature;

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->a(Lcom/fasterxml/jackson/core/JsonGenerator$Feature;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 1060
    :cond_2
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->u:Ljava/io/OutputStream;

    invoke-virtual {v0}, Ljava/io/OutputStream;->close()V

    .line 1067
    :cond_3
    :goto_1
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->j()V

    .line 1068
    return-void

    .line 1061
    :cond_4
    sget-object v0, Lcom/fasterxml/jackson/core/JsonGenerator$Feature;->FLUSH_PASSED_TO_STREAM:Lcom/fasterxml/jackson/core/JsonGenerator$Feature;

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->a(Lcom/fasterxml/jackson/core/JsonGenerator$Feature;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 1063
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->u:Ljava/io/OutputStream;

    invoke-virtual {v0}, Ljava/io/OutputStream;->flush()V

    goto :goto_1
.end method

.method public final d()V
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 297
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->l:Lcom/fasterxml/jackson/core/json/JsonWriteContext;

    invoke-virtual {v0}, Lcom/fasterxml/jackson/core/json/JsonWriteContext;->a()Z

    move-result v0

    if-nez v0, :cond_0

    .line 298
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Current context not an ARRAY but "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->l:Lcom/fasterxml/jackson/core/json/JsonWriteContext;

    invoke-virtual {v1}, Lcom/fasterxml/jackson/core/json/JsonWriteContext;->d()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->e(Ljava/lang/String;)V

    .line 300
    :cond_0
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->a:Lcom/fasterxml/jackson/core/PrettyPrinter;

    if-eqz v0, :cond_1

    .line 301
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->a:Lcom/fasterxml/jackson/core/PrettyPrinter;

    iget-object v1, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->l:Lcom/fasterxml/jackson/core/json/JsonWriteContext;

    invoke-virtual {v1}, Lcom/fasterxml/jackson/core/json/JsonWriteContext;->e()I

    move-result v1

    invoke-interface {v0, p0, v1}, Lcom/fasterxml/jackson/core/PrettyPrinter;->b(Lcom/fasterxml/jackson/core/JsonGenerator;I)V

    .line 308
    :goto_0
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->l:Lcom/fasterxml/jackson/core/json/JsonWriteContext;

    invoke-virtual {v0}, Lcom/fasterxml/jackson/core/json/JsonWriteContext;->i()Lcom/fasterxml/jackson/core/json/JsonWriteContext;

    move-result-object v0

    iput-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->l:Lcom/fasterxml/jackson/core/json/JsonWriteContext;

    .line 309
    return-void

    .line 303
    :cond_1
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->x:I

    if-lt v0, v1, :cond_2

    .line 304
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->l()V

    .line 306
    :cond_2
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->v:[B

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    add-int/lit8 v2, v1, 0x1

    iput v2, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    const/16 v2, 0x5d

    aput-byte v2, v0, v1

    goto :goto_0
.end method

.method public d(Ljava/lang/String;)V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonGenerationException;
        }
    .end annotation

    .prologue
    .line 895
    const-string v0, "write a number"

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->f(Ljava/lang/String;)V

    .line 896
    iget-boolean v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->k:Z

    if-eqz v0, :cond_0

    .line 897
    invoke-direct {p0, p1}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->h(Ljava/lang/String;)V

    .line 901
    :goto_0
    return-void

    .line 899
    :cond_0
    invoke-virtual {p0, p1}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->c(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public final e()V
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 314
    const-string v0, "start an object"

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->f(Ljava/lang/String;)V

    .line 315
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->l:Lcom/fasterxml/jackson/core/json/JsonWriteContext;

    invoke-virtual {v0}, Lcom/fasterxml/jackson/core/json/JsonWriteContext;->h()Lcom/fasterxml/jackson/core/json/JsonWriteContext;

    move-result-object v0

    iput-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->l:Lcom/fasterxml/jackson/core/json/JsonWriteContext;

    .line 316
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->a:Lcom/fasterxml/jackson/core/PrettyPrinter;

    if-eqz v0, :cond_0

    .line 317
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->a:Lcom/fasterxml/jackson/core/PrettyPrinter;

    invoke-interface {v0, p0}, Lcom/fasterxml/jackson/core/PrettyPrinter;->b(Lcom/fasterxml/jackson/core/JsonGenerator;)V

    .line 324
    :goto_0
    return-void

    .line 319
    :cond_0
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->x:I

    if-lt v0, v1, :cond_1

    .line 320
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->l()V

    .line 322
    :cond_1
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->v:[B

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    add-int/lit8 v2, v1, 0x1

    iput v2, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    const/16 v2, 0x7b

    aput-byte v2, v0, v1

    goto :goto_0
.end method

.method public final f()V
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 329
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->l:Lcom/fasterxml/jackson/core/json/JsonWriteContext;

    invoke-virtual {v0}, Lcom/fasterxml/jackson/core/json/JsonWriteContext;->c()Z

    move-result v0

    if-nez v0, :cond_0

    .line 330
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Current context not an object but "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->l:Lcom/fasterxml/jackson/core/json/JsonWriteContext;

    invoke-virtual {v1}, Lcom/fasterxml/jackson/core/json/JsonWriteContext;->d()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->e(Ljava/lang/String;)V

    .line 332
    :cond_0
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->a:Lcom/fasterxml/jackson/core/PrettyPrinter;

    if-eqz v0, :cond_1

    .line 333
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->a:Lcom/fasterxml/jackson/core/PrettyPrinter;

    iget-object v1, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->l:Lcom/fasterxml/jackson/core/json/JsonWriteContext;

    invoke-virtual {v1}, Lcom/fasterxml/jackson/core/json/JsonWriteContext;->e()I

    move-result v1

    invoke-interface {v0, p0, v1}, Lcom/fasterxml/jackson/core/PrettyPrinter;->a(Lcom/fasterxml/jackson/core/JsonGenerator;I)V

    .line 340
    :goto_0
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->l:Lcom/fasterxml/jackson/core/json/JsonWriteContext;

    invoke-virtual {v0}, Lcom/fasterxml/jackson/core/json/JsonWriteContext;->i()Lcom/fasterxml/jackson/core/json/JsonWriteContext;

    move-result-object v0

    iput-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->l:Lcom/fasterxml/jackson/core/json/JsonWriteContext;

    .line 341
    return-void

    .line 335
    :cond_1
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->x:I

    if-lt v0, v1, :cond_2

    .line 336
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->l()V

    .line 338
    :cond_2
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->v:[B

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    add-int/lit8 v2, v1, 0x1

    iput v2, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    const/16 v2, 0x7d

    aput-byte v2, v0, v1

    goto :goto_0
.end method

.method protected final f(Ljava/lang/String;)V
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 947
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->l:Lcom/fasterxml/jackson/core/json/JsonWriteContext;

    invoke-virtual {v0}, Lcom/fasterxml/jackson/core/json/JsonWriteContext;->j()I

    move-result v0

    .line 948
    const/4 v1, 0x5

    if-ne v0, v1, :cond_0

    .line 949
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Can not "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ", expecting field name"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->e(Ljava/lang/String;)V

    .line 951
    :cond_0
    iget-object v1, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->a:Lcom/fasterxml/jackson/core/PrettyPrinter;

    if-nez v1, :cond_3

    .line 953
    packed-switch v0, :pswitch_data_0

    .line 981
    :cond_1
    :goto_0
    return-void

    .line 955
    :pswitch_0
    const/16 v0, 0x2c

    .line 972
    :goto_1
    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    iget v2, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->x:I

    if-lt v1, v2, :cond_2

    .line 973
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->l()V

    .line 975
    :cond_2
    iget-object v1, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->v:[B

    iget v2, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    aput-byte v0, v1, v2

    .line 976
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    goto :goto_0

    .line 958
    :pswitch_1
    const/16 v0, 0x3a

    .line 959
    goto :goto_1

    .line 961
    :pswitch_2
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->s:Lcom/fasterxml/jackson/core/SerializableString;

    if-eqz v0, :cond_1

    .line 962
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->s:Lcom/fasterxml/jackson/core/SerializableString;

    invoke-interface {v0}, Lcom/fasterxml/jackson/core/SerializableString;->b()[B

    move-result-object v0

    .line 963
    array-length v1, v0

    if-lez v1, :cond_1

    .line 964
    invoke-direct {p0, v0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->a([B)V

    goto :goto_0

    .line 980
    :cond_3
    invoke-virtual {p0, p1, v0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->a(Ljava/lang/String;I)V

    goto :goto_0

    .line 953
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method public flush()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1019
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->l()V

    .line 1020
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->u:Ljava/io/OutputStream;

    if-eqz v0, :cond_0

    .line 1021
    sget-object v0, Lcom/fasterxml/jackson/core/JsonGenerator$Feature;->FLUSH_PASSED_TO_STREAM:Lcom/fasterxml/jackson/core/JsonGenerator$Feature;

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->a(Lcom/fasterxml/jackson/core/JsonGenerator$Feature;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1022
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->u:Ljava/io/OutputStream;

    invoke-virtual {v0}, Ljava/io/OutputStream;->flush()V

    .line 1025
    :cond_0
    return-void
.end method

.method public g()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonGenerationException;
        }
    .end annotation

    .prologue
    .line 934
    const-string v0, "write a null"

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->f(Ljava/lang/String;)V

    .line 935
    invoke-direct {p0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->m()V

    .line 936
    return-void
.end method

.method protected final g(Ljava/lang/String;)V
    .locals 6
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/16 v5, 0x22

    const/4 v2, 0x1

    const/4 v4, 0x0

    .line 349
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->l:Lcom/fasterxml/jackson/core/json/JsonWriteContext;

    invoke-virtual {v0, p1}, Lcom/fasterxml/jackson/core/json/JsonWriteContext;->a(Ljava/lang/String;)I

    move-result v0

    .line 350
    const/4 v1, 0x4

    if-ne v0, v1, :cond_0

    .line 351
    const-string v1, "Can not write a field name, expecting a value"

    invoke-virtual {p0, v1}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->e(Ljava/lang/String;)V

    .line 353
    :cond_0
    if-ne v0, v2, :cond_1

    .line 354
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->a:Lcom/fasterxml/jackson/core/PrettyPrinter;

    invoke-interface {v0, p0}, Lcom/fasterxml/jackson/core/PrettyPrinter;->c(Lcom/fasterxml/jackson/core/JsonGenerator;)V

    .line 358
    :goto_0
    iget-boolean v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->C:Z

    if-eqz v0, :cond_2

    .line 359
    invoke-direct {p0, p1, v4}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->a(Ljava/lang/String;Z)V

    .line 385
    :goto_1
    return-void

    .line 356
    :cond_1
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->a:Lcom/fasterxml/jackson/core/PrettyPrinter;

    invoke-interface {v0, p0}, Lcom/fasterxml/jackson/core/PrettyPrinter;->h(Lcom/fasterxml/jackson/core/JsonGenerator;)V

    goto :goto_0

    .line 362
    :cond_2
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v0

    .line 363
    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->A:I

    if-le v0, v1, :cond_3

    .line 364
    invoke-direct {p0, p1, v2}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->a(Ljava/lang/String;Z)V

    goto :goto_1

    .line 367
    :cond_3
    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    iget v2, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->x:I

    if-lt v1, v2, :cond_4

    .line 368
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->l()V

    .line 370
    :cond_4
    iget-object v1, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->v:[B

    iget v2, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    add-int/lit8 v3, v2, 0x1

    iput v3, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    aput-byte v5, v1, v2

    .line 371
    iget-object v1, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->z:[C

    invoke-virtual {p1, v4, v0, v1, v4}, Ljava/lang/String;->getChars(II[CI)V

    .line 373
    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->y:I

    if-gt v0, v1, :cond_7

    .line 374
    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    add-int/2addr v1, v0

    iget v2, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->x:I

    if-le v1, v2, :cond_5

    .line 375
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->l()V

    .line 377
    :cond_5
    iget-object v1, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->z:[C

    invoke-direct {p0, v1, v4, v0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->d([CII)V

    .line 381
    :goto_2
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->x:I

    if-lt v0, v1, :cond_6

    .line 382
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->l()V

    .line 384
    :cond_6
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->v:[B

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    add-int/lit8 v2, v1, 0x1

    iput v2, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    aput-byte v5, v0, v1

    goto :goto_1

    .line 379
    :cond_7
    iget-object v1, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->z:[C

    invoke-direct {p0, v1, v4, v0}, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->c([CII)V

    goto :goto_2
.end method

.method protected j()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 1073
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->v:[B

    .line 1074
    if-eqz v0, :cond_0

    iget-boolean v1, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->B:Z

    if-eqz v1, :cond_0

    .line 1075
    iput-object v2, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->v:[B

    .line 1076
    iget-object v1, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->o:Lcom/fasterxml/jackson/core/io/IOContext;

    invoke-virtual {v1, v0}, Lcom/fasterxml/jackson/core/io/IOContext;->b([B)V

    .line 1078
    :cond_0
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->z:[C

    .line 1079
    if-eqz v0, :cond_1

    .line 1080
    iput-object v2, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->z:[C

    .line 1081
    iget-object v1, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->o:Lcom/fasterxml/jackson/core/io/IOContext;

    invoke-virtual {v1, v0}, Lcom/fasterxml/jackson/core/io/IOContext;->b([C)V

    .line 1083
    :cond_1
    return-void
.end method

.method protected final l()V
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v3, 0x0

    .line 2000
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    .line 2001
    if-lez v0, :cond_0

    .line 2002
    iput v3, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->w:I

    .line 2003
    iget-object v1, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->u:Ljava/io/OutputStream;

    iget-object v2, p0, Lcom/fasterxml/jackson/core/json/UTF8JsonGenerator;->v:[B

    invoke-virtual {v1, v2, v3, v0}, Ljava/io/OutputStream;->write([BII)V

    .line 2005
    :cond_0
    return-void
.end method
