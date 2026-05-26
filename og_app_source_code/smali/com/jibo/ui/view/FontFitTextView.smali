.class public Lcom/jibo/ui/view/FontFitTextView;
.super Lcom/jibo/ui/view/proxima/CustomFontTextView;
.source "FontFitTextView.java"


# instance fields
.field private a:F

.field private b:Landroid/graphics/Paint;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 0

    .prologue
    .line 22
    invoke-direct {p0, p1}, Lcom/jibo/ui/view/proxima/CustomFontTextView;-><init>(Landroid/content/Context;)V

    .line 23
    invoke-direct {p0}, Lcom/jibo/ui/view/FontFitTextView;->a()V

    .line 24
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 0

    .prologue
    .line 27
    invoke-direct {p0, p1, p2}, Lcom/jibo/ui/view/proxima/CustomFontTextView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 28
    invoke-direct {p0}, Lcom/jibo/ui/view/FontFitTextView;->a()V

    .line 29
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 0

    .prologue
    .line 32
    invoke-direct {p0, p1, p2, p3}, Lcom/jibo/ui/view/proxima/CustomFontTextView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 33
    invoke-direct {p0}, Lcom/jibo/ui/view/FontFitTextView;->a()V

    .line 34
    return-void
.end method

.method private a()V
    .locals 2

    .prologue
    .line 37
    new-instance v0, Landroid/graphics/Paint;

    invoke-direct {v0}, Landroid/graphics/Paint;-><init>()V

    iput-object v0, p0, Lcom/jibo/ui/view/FontFitTextView;->b:Landroid/graphics/Paint;

    .line 38
    iget-object v0, p0, Lcom/jibo/ui/view/FontFitTextView;->b:Landroid/graphics/Paint;

    invoke-virtual {p0}, Lcom/jibo/ui/view/FontFitTextView;->getPaint()Landroid/text/TextPaint;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->set(Landroid/graphics/Paint;)V

    .line 40
    invoke-virtual {p0}, Lcom/jibo/ui/view/FontFitTextView;->getTextSize()F

    move-result v0

    iput v0, p0, Lcom/jibo/ui/view/FontFitTextView;->a:F

    .line 41
    return-void
.end method

.method private a(Ljava/lang/String;I)V
    .locals 7

    .prologue
    const/high16 v3, 0x40000000    # 2.0f

    .line 47
    if-gtz p2, :cond_0

    .line 66
    :goto_0
    return-void

    .line 49
    :cond_0
    invoke-virtual {p0}, Lcom/jibo/ui/view/FontFitTextView;->getPaddingLeft()I

    move-result v0

    sub-int v0, p2, v0

    invoke-virtual {p0}, Lcom/jibo/ui/view/FontFitTextView;->getPaddingRight()I

    move-result v1

    sub-int v4, v0, v1

    .line 50
    iget v2, p0, Lcom/jibo/ui/view/FontFitTextView;->a:F

    .line 54
    iget-object v0, p0, Lcom/jibo/ui/view/FontFitTextView;->b:Landroid/graphics/Paint;

    invoke-virtual {p0}, Lcom/jibo/ui/view/FontFitTextView;->getPaint()Landroid/text/TextPaint;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->set(Landroid/graphics/Paint;)V

    move v0, v3

    .line 56
    :goto_1
    sub-float v1, v2, v0

    const/high16 v5, 0x3f000000    # 0.5f

    cmpl-float v1, v1, v5

    if-lez v1, :cond_2

    .line 57
    add-float v1, v2, v0

    div-float/2addr v1, v3

    .line 58
    iget-object v5, p0, Lcom/jibo/ui/view/FontFitTextView;->b:Landroid/graphics/Paint;

    invoke-virtual {v5, v1}, Landroid/graphics/Paint;->setTextSize(F)V

    .line 59
    iget-object v5, p0, Lcom/jibo/ui/view/FontFitTextView;->b:Landroid/graphics/Paint;

    invoke-virtual {v5, p1}, Landroid/graphics/Paint;->measureText(Ljava/lang/String;)F

    move-result v5

    int-to-float v6, v4

    cmpl-float v5, v5, v6

    if-ltz v5, :cond_1

    :goto_2
    move v2, v1

    .line 63
    goto :goto_1

    :cond_1
    move v0, v1

    move v1, v2

    .line 62
    goto :goto_2

    .line 65
    :cond_2
    const/4 v1, 0x0

    invoke-virtual {p0, v1, v0}, Lcom/jibo/ui/view/FontFitTextView;->setTextSize(IF)V

    goto :goto_0
.end method


# virtual methods
.method protected onMeasure(II)V
    .locals 3

    .prologue
    .line 70
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/view/proxima/CustomFontTextView;->onMeasure(II)V

    .line 71
    invoke-static {p1}, Landroid/view/View$MeasureSpec;->getSize(I)I

    move-result v0

    .line 72
    invoke-virtual {p0}, Lcom/jibo/ui/view/FontFitTextView;->getMeasuredHeight()I

    move-result v1

    .line 73
    invoke-virtual {p0}, Lcom/jibo/ui/view/FontFitTextView;->getText()Ljava/lang/CharSequence;

    move-result-object v2

    invoke-interface {v2}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {p0, v2, v0}, Lcom/jibo/ui/view/FontFitTextView;->a(Ljava/lang/String;I)V

    .line 74
    invoke-virtual {p0, v0, v1}, Lcom/jibo/ui/view/FontFitTextView;->setMeasuredDimension(II)V

    .line 75
    return-void
.end method

.method protected onSizeChanged(IIII)V
    .locals 1

    .prologue
    .line 85
    if-eq p1, p3, :cond_0

    .line 86
    invoke-virtual {p0}, Lcom/jibo/ui/view/FontFitTextView;->getText()Ljava/lang/CharSequence;

    move-result-object v0

    invoke-interface {v0}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0, p1}, Lcom/jibo/ui/view/FontFitTextView;->a(Ljava/lang/String;I)V

    .line 88
    :cond_0
    return-void
.end method

.method protected onTextChanged(Ljava/lang/CharSequence;III)V
    .locals 2

    .prologue
    .line 80
    invoke-interface {p1}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0}, Lcom/jibo/ui/view/FontFitTextView;->getWidth()I

    move-result v1

    invoke-direct {p0, v0, v1}, Lcom/jibo/ui/view/FontFitTextView;->a(Ljava/lang/String;I)V

    .line 81
    return-void
.end method
