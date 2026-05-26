.class public Lcom/jibo/ui/view/EditTextWithSuffix;
.super Lcom/jibo/ui/view/proxima/CustomFontEditText;
.source "EditTextWithSuffix.java"


# instance fields
.field a:Landroid/text/TextPaint;

.field private b:Ljava/lang/String;

.field private c:F


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1

    .prologue
    .line 23
    invoke-direct {p0, p1}, Lcom/jibo/ui/view/proxima/CustomFontEditText;-><init>(Landroid/content/Context;)V

    .line 18
    new-instance v0, Landroid/text/TextPaint;

    invoke-direct {v0}, Landroid/text/TextPaint;-><init>()V

    iput-object v0, p0, Lcom/jibo/ui/view/EditTextWithSuffix;->a:Landroid/text/TextPaint;

    .line 19
    const-string v0, ""

    iput-object v0, p0, Lcom/jibo/ui/view/EditTextWithSuffix;->b:Ljava/lang/String;

    .line 24
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1

    .prologue
    .line 27
    invoke-direct {p0, p1, p2}, Lcom/jibo/ui/view/proxima/CustomFontEditText;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 18
    new-instance v0, Landroid/text/TextPaint;

    invoke-direct {v0}, Landroid/text/TextPaint;-><init>()V

    iput-object v0, p0, Lcom/jibo/ui/view/EditTextWithSuffix;->a:Landroid/text/TextPaint;

    .line 19
    const-string v0, ""

    iput-object v0, p0, Lcom/jibo/ui/view/EditTextWithSuffix;->b:Ljava/lang/String;

    .line 28
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Lcom/jibo/ui/view/EditTextWithSuffix;->a(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 29
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 1

    .prologue
    .line 32
    invoke-direct {p0, p1, p2, p3}, Lcom/jibo/ui/view/proxima/CustomFontEditText;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 18
    new-instance v0, Landroid/text/TextPaint;

    invoke-direct {v0}, Landroid/text/TextPaint;-><init>()V

    iput-object v0, p0, Lcom/jibo/ui/view/EditTextWithSuffix;->a:Landroid/text/TextPaint;

    .line 19
    const-string v0, ""

    iput-object v0, p0, Lcom/jibo/ui/view/EditTextWithSuffix;->b:Ljava/lang/String;

    .line 33
    invoke-direct {p0, p1, p2, p3}, Lcom/jibo/ui/view/EditTextWithSuffix;->a(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 34
    return-void
.end method

.method private a(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 3

    .prologue
    const/4 v1, 0x0

    .line 52
    sget-object v0, Lcom/jibo/R$styleable;->EditTextWithSuffix:[I

    invoke-virtual {p1, p2, v0, p3, v1}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 53
    if-eqz v0, :cond_1

    .line 54
    invoke-virtual {v0, v1}, Landroid/content/res/TypedArray;->getString(I)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/jibo/ui/view/EditTextWithSuffix;->b:Ljava/lang/String;

    .line 55
    iget-object v1, p0, Lcom/jibo/ui/view/EditTextWithSuffix;->b:Ljava/lang/String;

    if-nez v1, :cond_0

    .line 56
    const-string v1, ""

    iput-object v1, p0, Lcom/jibo/ui/view/EditTextWithSuffix;->b:Ljava/lang/String;

    .line 58
    :cond_0
    const/4 v1, 0x1

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/content/res/TypedArray;->getDimension(IF)F

    move-result v1

    iput v1, p0, Lcom/jibo/ui/view/EditTextWithSuffix;->c:F

    .line 60
    :cond_1
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    .line 61
    return-void
.end method


# virtual methods
.method public onDraw(Landroid/graphics/Canvas;)V
    .locals 4

    .prologue
    .line 38
    invoke-super {p0, p1}, Lcom/jibo/ui/view/proxima/CustomFontEditText;->onDraw(Landroid/graphics/Canvas;)V

    .line 39
    invoke-virtual {p0}, Lcom/jibo/ui/view/EditTextWithSuffix;->getPaint()Landroid/text/TextPaint;

    move-result-object v0

    invoke-virtual {p0}, Lcom/jibo/ui/view/EditTextWithSuffix;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/text/TextPaint;->measureText(Ljava/lang/String;)F

    move-result v0

    float-to-int v0, v0

    invoke-virtual {p0}, Lcom/jibo/ui/view/EditTextWithSuffix;->getPaddingLeft()I

    move-result v1

    add-int/2addr v0, v1

    .line 40
    iget-object v1, p0, Lcom/jibo/ui/view/EditTextWithSuffix;->b:Ljava/lang/String;

    int-to-float v0, v0

    iget v2, p0, Lcom/jibo/ui/view/EditTextWithSuffix;->c:F

    invoke-static {v0, v2}, Ljava/lang/Math;->max(FF)F

    move-result v0

    invoke-virtual {p0}, Lcom/jibo/ui/view/EditTextWithSuffix;->getBaseline()I

    move-result v2

    int-to-float v2, v2

    iget-object v3, p0, Lcom/jibo/ui/view/EditTextWithSuffix;->a:Landroid/text/TextPaint;

    invoke-virtual {p1, v1, v0, v2, v3}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 41
    return-void
.end method

.method protected onFinishInflate()V
    .locals 2

    .prologue
    .line 45
    invoke-super {p0}, Lcom/jibo/ui/view/proxima/CustomFontEditText;->onFinishInflate()V

    .line 46
    iget-object v0, p0, Lcom/jibo/ui/view/EditTextWithSuffix;->a:Landroid/text/TextPaint;

    invoke-virtual {p0}, Lcom/jibo/ui/view/EditTextWithSuffix;->getCurrentTextColor()I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/text/TextPaint;->setColor(I)V

    .line 47
    iget-object v0, p0, Lcom/jibo/ui/view/EditTextWithSuffix;->a:Landroid/text/TextPaint;

    invoke-virtual {p0}, Lcom/jibo/ui/view/EditTextWithSuffix;->getTextSize()F

    move-result v1

    invoke-virtual {v0, v1}, Landroid/text/TextPaint;->setTextSize(F)V

    .line 48
    iget-object v0, p0, Lcom/jibo/ui/view/EditTextWithSuffix;->a:Landroid/text/TextPaint;

    sget-object v1, Landroid/graphics/Paint$Align;->LEFT:Landroid/graphics/Paint$Align;

    invoke-virtual {v0, v1}, Landroid/text/TextPaint;->setTextAlign(Landroid/graphics/Paint$Align;)V

    .line 49
    return-void
.end method
