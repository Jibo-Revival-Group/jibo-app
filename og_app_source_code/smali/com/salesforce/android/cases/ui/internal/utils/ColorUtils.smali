.class public Lcom/salesforce/android/cases/ui/internal/utils/ColorUtils;
.super Ljava/lang/Object;
.source "ColorUtils.java"


# direct methods
.method public static a(IF)I
    .locals 8

    .prologue
    const/4 v7, 0x4

    const/16 v6, 0x10

    const/4 v3, 0x2

    const/high16 v5, 0x3f800000    # 1.0f

    const/high16 v4, 0x437f0000    # 255.0f

    .line 41
    invoke-static {p0}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v0

    .line 42
    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v1

    const/16 v2, 0x8

    if-ne v1, v2, :cond_0

    .line 43
    const/16 v1, 0x8

    invoke-virtual {v0, v3, v1}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v0

    .line 45
    :cond_0
    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v1

    const/4 v2, 0x6

    if-ge v1, v2, :cond_1

    .line 56
    :goto_0
    return p0

    .line 48
    :cond_1
    const/4 v1, 0x0

    invoke-virtual {v0, v1, v3}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1, v6}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;I)I

    move-result v1

    .line 49
    invoke-virtual {v0, v3, v7}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2, v6}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;I)I

    move-result v2

    .line 50
    const/4 v3, 0x6

    invoke-virtual {v0, v7, v3}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0, v6}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;I)I

    move-result v0

    .line 52
    int-to-float v1, v1

    sub-float v3, v5, p1

    mul-float/2addr v1, v3

    div-float/2addr v1, v4

    mul-float/2addr v1, v4

    float-to-int v1, v1

    .line 53
    int-to-float v2, v2

    sub-float v3, v5, p1

    mul-float/2addr v2, v3

    div-float/2addr v2, v4

    mul-float/2addr v2, v4

    float-to-int v2, v2

    .line 54
    int-to-float v0, v0

    sub-float v3, v5, p1

    mul-float/2addr v0, v3

    div-float/2addr v0, v4

    mul-float/2addr v0, v4

    float-to-int v0, v0

    .line 56
    invoke-static {v1, v2, v0}, Landroid/graphics/Color;->rgb(III)I

    move-result p0

    goto :goto_0
.end method
