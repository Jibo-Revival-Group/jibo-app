.class public Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;
.super Ljava/lang/Object;
.source "Coordinate.java"

# interfaces
.implements Ljava/io/Serializable;


# instance fields
.field private final a:I

.field private final b:I


# direct methods
.method private constructor <init>(II)V
    .locals 0

    .prologue
    .line 59
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 60
    iput p1, p0, Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;->a:I

    .line 61
    iput p2, p0, Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;->b:I

    .line 62
    return-void
.end method

.method public static a(II)Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;
    .locals 1

    .prologue
    .line 48
    new-instance v0, Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;

    invoke-direct {v0, p0, p1}, Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;-><init>(II)V

    return-object v0
.end method


# virtual methods
.method public a()I
    .locals 1

    .prologue
    .line 69
    iget v0, p0, Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;->a:I

    return v0
.end method

.method public b()I
    .locals 1

    .prologue
    .line 73
    iget v0, p0, Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;->b:I

    return v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 4

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    .line 102
    if-ne p0, p1, :cond_1

    .line 111
    :cond_0
    :goto_0
    return v0

    .line 106
    :cond_1
    instance-of v2, p1, Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;

    if-eqz v2, :cond_3

    .line 107
    check-cast p1, Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;

    .line 108
    iget v2, p0, Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;->a:I

    iget v3, p1, Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;->a:I

    if-ne v2, v3, :cond_2

    iget v2, p0, Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;->b:I

    iget v3, p1, Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;->b:I

    if-eq v2, v3, :cond_0

    :cond_2
    move v0, v1

    goto :goto_0

    :cond_3
    move v0, v1

    .line 111
    goto :goto_0
.end method

.method public hashCode()I
    .locals 2

    .prologue
    .line 115
    iget v0, p0, Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;->a:I

    mul-int/lit8 v0, v0, 0x1f

    iget v1, p0, Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;->b:I

    add-int/2addr v0, v1

    return v0
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 119
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "["

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;->a:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ","

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;->b:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "]"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
