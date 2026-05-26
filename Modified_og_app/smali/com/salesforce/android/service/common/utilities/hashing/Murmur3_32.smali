.class public Lcom/salesforce/android/service/common/utilities/hashing/Murmur3_32;
.super Ljava/lang/Object;
.source "Murmur3_32.java"


# direct methods
.method public static a(Ljava/lang/CharSequence;I)I
    .locals 2

    .prologue
    .line 37
    const/4 v0, 0x0

    invoke-interface {p0}, Ljava/lang/CharSequence;->length()I

    move-result v1

    invoke-static {p0, v0, v1, p1}, Lcom/salesforce/android/service/common/utilities/hashing/Murmur3_32;->a(Ljava/lang/CharSequence;III)I

    move-result v0

    return v0
.end method

.method public static a(Ljava/lang/CharSequence;III)I
    .locals 11

    .prologue
    .line 45
    .line 51
    add-int v9, p1, p2

    .line 52
    const/4 v2, 0x0

    .line 54
    const/4 v0, 0x0

    .line 56
    const/4 v1, 0x0

    move v7, v0

    move v8, v2

    move v3, p3

    .line 59
    :goto_0
    if-ge p1, v9, :cond_5

    .line 60
    add-int/lit8 v4, p1, 0x1

    invoke-interface {p0, p1}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v2

    .line 61
    const/16 v0, 0x80

    if-ge v2, v0, :cond_0

    .line 63
    const/16 v0, 0x8

    move v5, v2

    move v6, v4

    move v4, v0

    .line 87
    :goto_1
    shl-int v0, v5, v7

    or-int v2, v8, v0

    .line 92
    add-int v0, v7, v4

    .line 93
    const/16 v7, 0x20

    if-lt v0, v7, :cond_7

    .line 96
    const v7, -0x3361d2af    # -8.2930312E7f

    mul-int/2addr v2, v7

    .line 97
    shl-int/lit8 v7, v2, 0xf

    ushr-int/lit8 v2, v2, 0x11

    or-int/2addr v2, v7

    .line 98
    const v7, 0x1b873593

    mul-int/2addr v2, v7

    .line 100
    xor-int/2addr v2, v3

    .line 101
    shl-int/lit8 v3, v2, 0xd

    ushr-int/lit8 v2, v2, 0x13

    or-int/2addr v2, v3

    .line 102
    mul-int/lit8 v2, v2, 0x5

    const v3, -0x19ab949c

    add-int/2addr v3, v2

    .line 104
    add-int/lit8 v2, v0, -0x20

    .line 106
    if-eqz v2, :cond_4

    .line 107
    sub-int v0, v4, v2

    ushr-int v0, v5, v0

    .line 111
    :goto_2
    add-int/lit8 v1, v1, 0x4

    move v10, v1

    move v1, v2

    move v2, v0

    move v0, v10

    :goto_3
    move v7, v1

    move v8, v2

    move p1, v6

    move v1, v0

    .line 114
    goto :goto_0

    .line 64
    :cond_0
    const/16 v0, 0x800

    if-ge v2, v0, :cond_1

    .line 65
    shr-int/lit8 v0, v2, 0x6

    or-int/lit16 v0, v0, 0xc0

    and-int/lit8 v2, v2, 0x3f

    or-int/lit16 v2, v2, 0x80

    shl-int/lit8 v2, v2, 0x8

    or-int/2addr v2, v0

    .line 67
    const/16 v0, 0x10

    move v5, v2

    move v6, v4

    move v4, v0

    goto :goto_1

    .line 68
    :cond_1
    const v0, 0xd800

    if-lt v2, v0, :cond_2

    const v0, 0xdfff

    if-gt v2, v0, :cond_2

    if-lt v4, v9, :cond_3

    .line 70
    :cond_2
    shr-int/lit8 v0, v2, 0xc

    or-int/lit16 v0, v0, 0xe0

    shr-int/lit8 v5, v2, 0x6

    and-int/lit8 v5, v5, 0x3f

    or-int/lit16 v5, v5, 0x80

    shl-int/lit8 v5, v5, 0x8

    or-int/2addr v0, v5

    and-int/lit8 v2, v2, 0x3f

    or-int/lit16 v2, v2, 0x80

    shl-int/lit8 v2, v2, 0x10

    or-int/2addr v2, v0

    .line 73
    const/16 v0, 0x18

    move v5, v2

    move v6, v4

    move v4, v0

    goto :goto_1

    .line 77
    :cond_3
    add-int/lit8 v5, v4, 0x1

    invoke-interface {p0, v4}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v0

    .line 78
    const v4, 0xd7c0

    sub-int/2addr v2, v4

    shl-int/lit8 v2, v2, 0xa

    and-int/lit16 v0, v0, 0x3ff

    add-int/2addr v0, v2

    .line 79
    shr-int/lit8 v2, v0, 0x12

    or-int/lit16 v2, v2, 0xf0

    and-int/lit16 v2, v2, 0xff

    shr-int/lit8 v4, v0, 0xc

    and-int/lit8 v4, v4, 0x3f

    or-int/lit16 v4, v4, 0x80

    shl-int/lit8 v4, v4, 0x8

    or-int/2addr v2, v4

    shr-int/lit8 v4, v0, 0x6

    and-int/lit8 v4, v4, 0x3f

    or-int/lit16 v4, v4, 0x80

    shl-int/lit8 v4, v4, 0x10

    or-int/2addr v2, v4

    and-int/lit8 v0, v0, 0x3f

    or-int/lit16 v0, v0, 0x80

    shl-int/lit8 v0, v0, 0x18

    or-int/2addr v2, v0

    .line 83
    const/16 v0, 0x20

    move v4, v0

    move v6, v5

    move v5, v2

    goto/16 :goto_1

    .line 109
    :cond_4
    const/4 v0, 0x0

    goto :goto_2

    .line 117
    :cond_5
    if-lez v7, :cond_6

    .line 118
    shr-int/lit8 v0, v7, 0x3

    add-int/2addr v1, v0

    .line 119
    const v0, -0x3361d2af    # -8.2930312E7f

    mul-int/2addr v0, v8

    .line 120
    shl-int/lit8 v2, v0, 0xf

    ushr-int/lit8 v0, v0, 0x11

    or-int/2addr v0, v2

    .line 121
    const v2, 0x1b873593

    mul-int/2addr v0, v2

    .line 122
    xor-int/2addr v3, v0

    .line 126
    :cond_6
    xor-int v0, v3, v1

    .line 129
    ushr-int/lit8 v1, v0, 0x10

    xor-int/2addr v0, v1

    .line 130
    const v1, -0x7a143595

    mul-int/2addr v0, v1

    .line 131
    ushr-int/lit8 v1, v0, 0xd

    xor-int/2addr v0, v1

    .line 132
    const v1, -0x3d4d51cb

    mul-int/2addr v0, v1

    .line 133
    ushr-int/lit8 v1, v0, 0x10

    xor-int/2addr v0, v1

    .line 135
    return v0

    :cond_7
    move v10, v1

    move v1, v0

    move v0, v10

    goto/16 :goto_3
.end method
