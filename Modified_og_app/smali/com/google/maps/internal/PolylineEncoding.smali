.class public Lcom/google/maps/internal/PolylineEncoding;
.super Ljava/lang/Object;
.source "PolylineEncoding.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 29
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static decode(Ljava/lang/String;)Ljava/util/List;
    .locals 14
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/google/maps/model/LatLng;",
            ">;"
        }
    .end annotation

    .prologue
    .line 33
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v6

    .line 35
    new-instance v7, Ljava/util/ArrayList;

    div-int/lit8 v0, v6, 0x2

    invoke-direct {v7, v0}, Ljava/util/ArrayList;-><init>(I)V

    .line 36
    const/4 v2, 0x0

    .line 37
    const/4 v1, 0x0

    .line 38
    const/4 v0, 0x0

    move v4, v0

    move v5, v1

    .line 40
    :goto_0
    if-ge v2, v6, :cond_2

    .line 41
    const/4 v1, 0x1

    .line 42
    const/4 v0, 0x0

    .line 45
    :goto_1
    add-int/lit8 v3, v2, 0x1

    invoke-virtual {p0, v2}, Ljava/lang/String;->charAt(I)C

    move-result v2

    add-int/lit8 v2, v2, -0x3f

    add-int/lit8 v2, v2, -0x1

    .line 46
    shl-int v8, v2, v0

    add-int/2addr v1, v8

    .line 47
    add-int/lit8 v0, v0, 0x5

    .line 48
    const/16 v8, 0x1f

    if-ge v2, v8, :cond_4

    .line 49
    and-int/lit8 v0, v1, 0x1

    if-eqz v0, :cond_0

    shr-int/lit8 v0, v1, 0x1

    xor-int/lit8 v0, v0, -0x1

    :goto_2
    add-int/2addr v5, v0

    .line 51
    const/4 v1, 0x1

    .line 52
    const/4 v0, 0x0

    .line 54
    :goto_3
    add-int/lit8 v2, v3, 0x1

    invoke-virtual {p0, v3}, Ljava/lang/String;->charAt(I)C

    move-result v3

    add-int/lit8 v3, v3, -0x3f

    add-int/lit8 v3, v3, -0x1

    .line 55
    shl-int v8, v3, v0

    add-int/2addr v1, v8

    .line 56
    add-int/lit8 v0, v0, 0x5

    .line 57
    const/16 v8, 0x1f

    if-ge v3, v8, :cond_3

    .line 58
    and-int/lit8 v0, v1, 0x1

    if-eqz v0, :cond_1

    shr-int/lit8 v0, v1, 0x1

    xor-int/lit8 v0, v0, -0x1

    :goto_4
    add-int/2addr v0, v4

    .line 60
    new-instance v1, Lcom/google/maps/model/LatLng;

    int-to-double v8, v5

    const-wide v10, 0x3ee4f8b588e368f1L    # 1.0E-5

    mul-double/2addr v8, v10

    int-to-double v10, v0

    const-wide v12, 0x3ee4f8b588e368f1L    # 1.0E-5

    mul-double/2addr v10, v12

    invoke-direct {v1, v8, v9, v10, v11}, Lcom/google/maps/model/LatLng;-><init>(DD)V

    invoke-interface {v7, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    move v4, v0

    .line 61
    goto :goto_0

    .line 49
    :cond_0
    shr-int/lit8 v0, v1, 0x1

    goto :goto_2

    .line 58
    :cond_1
    shr-int/lit8 v0, v1, 0x1

    goto :goto_4

    .line 63
    :cond_2
    return-object v7

    :cond_3
    move v3, v2

    goto :goto_3

    :cond_4
    move v2, v3

    goto :goto_1
.end method

.method public static encode(Ljava/util/List;)Ljava/lang/String;
    .locals 12
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/google/maps/model/LatLng;",
            ">;)",
            "Ljava/lang/String;"
        }
    .end annotation

    .prologue
    const-wide/16 v0, 0x0

    const-wide v10, 0x40f86a0000000000L    # 100000.0

    .line 68
    .line 71
    new-instance v8, Ljava/lang/StringBuffer;

    invoke-direct {v8}, Ljava/lang/StringBuffer;-><init>()V

    .line 73
    invoke-interface {p0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v9

    move-wide v2, v0

    move-wide v4, v0

    :goto_0
    invoke-interface {v9}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v9}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/maps/model/LatLng;

    .line 74
    iget-wide v6, v0, Lcom/google/maps/model/LatLng;->lat:D

    mul-double/2addr v6, v10

    invoke-static {v6, v7}, Ljava/lang/Math;->round(D)J

    move-result-wide v6

    .line 75
    iget-wide v0, v0, Lcom/google/maps/model/LatLng;->lng:D

    mul-double/2addr v0, v10

    invoke-static {v0, v1}, Ljava/lang/Math;->round(D)J

    move-result-wide v0

    .line 77
    sub-long v4, v6, v4

    .line 78
    sub-long v2, v0, v2

    .line 80
    invoke-static {v4, v5, v8}, Lcom/google/maps/internal/PolylineEncoding;->encode(JLjava/lang/StringBuffer;)V

    .line 81
    invoke-static {v2, v3, v8}, Lcom/google/maps/internal/PolylineEncoding;->encode(JLjava/lang/StringBuffer;)V

    move-wide v2, v0

    move-wide v4, v6

    .line 85
    goto :goto_0

    .line 86
    :cond_0
    invoke-virtual {v8}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static encode([Lcom/google/maps/model/LatLng;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 100
    invoke-static {p0}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v0

    invoke-static {v0}, Lcom/google/maps/internal/PolylineEncoding;->encode(Ljava/util/List;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private static encode(JLjava/lang/StringBuffer;)V
    .locals 8

    .prologue
    const-wide/16 v6, 0x3f

    const-wide/16 v4, 0x20

    const/4 v2, 0x1

    .line 90
    const-wide/16 v0, 0x0

    cmp-long v0, p0, v0

    if-gez v0, :cond_0

    shl-long v0, p0, v2

    const-wide/16 v2, -0x1

    xor-long/2addr v0, v2

    .line 91
    :goto_0
    cmp-long v2, v0, v4

    if-ltz v2, :cond_1

    .line 92
    const-wide/16 v2, 0x1f

    and-long/2addr v2, v0

    or-long/2addr v2, v4

    add-long/2addr v2, v6

    long-to-int v2, v2

    invoke-static {v2}, Ljava/lang/Character;->toChars(I)[C

    move-result-object v2

    invoke-virtual {p2, v2}, Ljava/lang/StringBuffer;->append([C)Ljava/lang/StringBuffer;

    .line 93
    const/4 v2, 0x5

    shr-long/2addr v0, v2

    goto :goto_0

    .line 90
    :cond_0
    shl-long v0, p0, v2

    goto :goto_0

    .line 95
    :cond_1
    add-long/2addr v0, v6

    long-to-int v0, v0

    invoke-static {v0}, Ljava/lang/Character;->toChars(I)[C

    move-result-object v0

    invoke-virtual {p2, v0}, Ljava/lang/StringBuffer;->append([C)Ljava/lang/StringBuffer;

    .line 96
    return-void
.end method
