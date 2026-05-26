.class Lcom/salesforce/android/knowledge/ui/internal/home/ColorCalculator;
.super Ljava/lang/Object;
.source "ColorCalculator.java"

# interfaces
.implements Lcom/salesforce/android/knowledge/ui/internal/models/ColorSelector;


# instance fields
.field private final a:I

.field private final b:I

.field private final c:I


# direct methods
.method constructor <init>(III)V
    .locals 2

    .prologue
    .line 46
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 49
    if-le p3, p2, :cond_0

    .line 50
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Gradient range cannot be greater than gradient size"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 52
    :cond_0
    if-ltz p3, :cond_1

    if-gez p2, :cond_2

    .line 53
    :cond_1
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Gradient range/size cannot be negative"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 56
    :cond_2
    iput p1, p0, Lcom/salesforce/android/knowledge/ui/internal/home/ColorCalculator;->a:I

    .line 57
    iput p2, p0, Lcom/salesforce/android/knowledge/ui/internal/home/ColorCalculator;->b:I

    .line 58
    iput p3, p0, Lcom/salesforce/android/knowledge/ui/internal/home/ColorCalculator;->c:I

    .line 59
    return-void
.end method


# virtual methods
.method public a(Lcom/salesforce/android/knowledge/core/model/DataCategorySummary;I)I
    .locals 5

    .prologue
    const/4 v4, 0x2

    .line 67
    iget v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/ColorCalculator;->c:I

    if-eqz v0, :cond_0

    iget v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/ColorCalculator;->b:I

    if-nez v0, :cond_1

    .line 68
    :cond_0
    iget v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/ColorCalculator;->a:I

    .line 84
    :goto_0
    return v0

    .line 72
    :cond_1
    const/4 v0, 0x3

    new-array v0, v0, [F

    .line 73
    iget v1, p0, Lcom/salesforce/android/knowledge/ui/internal/home/ColorCalculator;->a:I

    invoke-static {v1, v0}, Landroid/graphics/Color;->colorToHSV(I[F)V

    .line 76
    aget v1, v0, v4

    iget v2, p0, Lcom/salesforce/android/knowledge/ui/internal/home/ColorCalculator;->b:I

    int-to-float v2, v2

    div-float/2addr v1, v2

    .line 79
    iget v2, p0, Lcom/salesforce/android/knowledge/ui/internal/home/ColorCalculator;->c:I

    add-int/2addr v2, p2

    iget v3, p0, Lcom/salesforce/android/knowledge/ui/internal/home/ColorCalculator;->c:I

    mul-int/lit8 v3, v3, 0x2

    rem-int/2addr v2, v3

    iget v3, p0, Lcom/salesforce/android/knowledge/ui/internal/home/ColorCalculator;->c:I

    sub-int/2addr v2, v3

    invoke-static {v2}, Ljava/lang/Math;->abs(I)I

    move-result v2

    .line 81
    aget v3, v0, v4

    int-to-float v2, v2

    mul-float/2addr v1, v2

    sub-float v1, v3, v1

    aput v1, v0, v4

    .line 84
    invoke-static {v0}, Landroid/graphics/Color;->HSVToColor([F)I

    move-result v0

    goto :goto_0
.end method
