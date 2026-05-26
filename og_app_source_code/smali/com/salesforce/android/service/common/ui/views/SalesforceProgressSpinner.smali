.class public Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner;
.super Landroid/view/View;
.source "SalesforceProgressSpinner.java"

# interfaces
.implements Landroid/animation/ValueAnimator$AnimatorUpdateListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner$ProgressSpinner;,
        Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner$ProgressSpinnerProperties;
    }
.end annotation


# instance fields
.field private final a:Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner$ProgressSpinner;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1

    .prologue
    .line 68
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 69
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1

    .prologue
    .line 72
    sget v0, Lcom/salesforce/android/service/common/ui/R$attr;->salesforceProgressSpinnerStyle:I

    invoke-direct {p0, p1, p2, v0}, Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 73
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 4

    .prologue
    .line 76
    invoke-direct {p0, p1, p2, p3}, Landroid/view/View;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 78
    invoke-virtual {p1}, Landroid/content/Context;->getTheme()Landroid/content/res/Resources$Theme;

    move-result-object v0

    sget-object v1, Lcom/salesforce/android/service/common/ui/R$styleable;->SalesforceProgressSpinner:[I

    const/4 v2, 0x0

    invoke-virtual {v0, p2, v1, p3, v2}, Landroid/content/res/Resources$Theme;->obtainStyledAttributes(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;

    move-result-object v1

    .line 84
    new-instance v0, Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner$ProgressSpinnerProperties;

    invoke-direct {v0}, Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner$ProgressSpinnerProperties;-><init>()V

    .line 86
    :try_start_0
    sget v2, Lcom/salesforce/android/service/common/ui/R$styleable;->SalesforceProgressSpinner_salesforce_highlight_color:I

    sget v3, Lcom/salesforce/android/service/common/ui/R$color;->salesforce_brand_secondary:I

    invoke-direct {p0, v1, v2, v3}, Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner;->a(Landroid/content/res/TypedArray;II)I

    move-result v2

    iput v2, v0, Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner$ProgressSpinnerProperties;->d:I

    .line 87
    sget v2, Lcom/salesforce/android/service/common/ui/R$styleable;->SalesforceProgressSpinner_salesforce_shadow_color:I

    sget v3, Lcom/salesforce/android/service/common/ui/R$color;->salesforce_contrast_tertiary:I

    invoke-direct {p0, v1, v2, v3}, Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner;->a(Landroid/content/res/TypedArray;II)I

    move-result v2

    iput v2, v0, Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner$ProgressSpinnerProperties;->c:I

    .line 88
    sget v2, Lcom/salesforce/android/service/common/ui/R$styleable;->SalesforceProgressSpinner_salesforce_highlight_arc_degrees:I

    invoke-direct {p0, v1, v2}, Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner;->a(Landroid/content/res/TypedArray;I)Ljava/lang/String;

    move-result-object v2

    invoke-direct {p0, v2}, Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner;->a(Ljava/lang/String;)I

    move-result v2

    iput v2, v0, Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner$ProgressSpinnerProperties;->b:I

    .line 89
    sget v2, Lcom/salesforce/android/service/common/ui/R$styleable;->SalesforceProgressSpinner_salesforce_thickness:I

    invoke-direct {p0, v1, v2}, Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner;->c(Landroid/content/res/TypedArray;I)I

    move-result v2

    iput v2, v0, Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner$ProgressSpinnerProperties;->a:I

    .line 90
    sget v2, Lcom/salesforce/android/service/common/ui/R$styleable;->SalesforceProgressSpinner_salesforce_rotations_per_second:I

    invoke-direct {p0, v1, v2}, Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner;->b(Landroid/content/res/TypedArray;I)F

    move-result v2

    iput v2, v0, Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner$ProgressSpinnerProperties;->e:F
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 92
    invoke-virtual {v1}, Landroid/content/res/TypedArray;->recycle()V

    .line 96
    new-instance v1, Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner$ProgressSpinner;

    invoke-direct {v1, v0}, Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner$ProgressSpinner;-><init>(Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner$ProgressSpinnerProperties;)V

    iput-object v1, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner;->a:Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner$ProgressSpinner;

    .line 97
    return-void

    .line 92
    :catchall_0
    move-exception v0

    invoke-virtual {v1}, Landroid/content/res/TypedArray;->recycle()V

    throw v0
.end method

.method private a(Landroid/content/res/TypedArray;II)I
    .locals 1

    .prologue
    .line 105
    invoke-virtual {p0}, Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0, p3}, Landroid/support/v4/content/ContextCompat;->c(Landroid/content/Context;I)I

    move-result v0

    invoke-virtual {p1, p2, v0}, Landroid/content/res/TypedArray;->getColor(II)I

    move-result v0

    return v0
.end method

.method private a(Ljava/lang/String;)I
    .locals 1

    .prologue
    .line 114
    :try_start_0
    invoke-static {p1}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v0

    .line 116
    :goto_0
    return v0

    .line 115
    :catch_0
    move-exception v0

    .line 116
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private a(Landroid/content/res/TypedArray;I)Ljava/lang/String;
    .locals 1

    .prologue
    .line 109
    invoke-virtual {p1, p2}, Landroid/content/res/TypedArray;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private b(Landroid/content/res/TypedArray;I)F
    .locals 1

    .prologue
    .line 121
    const/4 v0, 0x0

    invoke-virtual {p1, p2, v0}, Landroid/content/res/TypedArray;->getFloat(IF)F

    move-result v0

    return v0
.end method

.method private c(Landroid/content/res/TypedArray;I)I
    .locals 1

    .prologue
    .line 125
    const/4 v0, 0x0

    invoke-virtual {p1, p2, v0}, Landroid/content/res/TypedArray;->getDimensionPixelSize(II)I

    move-result v0

    return v0
.end method


# virtual methods
.method public onAnimationUpdate(Landroid/animation/ValueAnimator;)V
    .locals 1

    .prologue
    .line 133
    invoke-virtual {p1}, Landroid/animation/ValueAnimator;->getAnimatedValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Float;

    invoke-virtual {v0}, Ljava/lang/Float;->floatValue()F

    move-result v0

    invoke-virtual {p0, v0}, Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner;->setRotation(F)V

    .line 134
    return-void
.end method

.method protected onAttachedToWindow()V
    .locals 1

    .prologue
    .line 145
    invoke-super {p0}, Landroid/view/View;->onAttachedToWindow()V

    .line 146
    invoke-virtual {p0}, Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner;->getVisibility()I

    move-result v0

    if-nez v0, :cond_0

    .line 147
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner;->a:Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner$ProgressSpinner;

    invoke-virtual {v0, p0}, Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner$ProgressSpinner;->a(Landroid/animation/ValueAnimator$AnimatorUpdateListener;)V

    .line 148
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner;->a:Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner$ProgressSpinner;

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner$ProgressSpinner;->a()V

    .line 150
    :cond_0
    return-void
.end method

.method protected onDetachedFromWindow()V
    .locals 1

    .prologue
    .line 163
    invoke-super {p0}, Landroid/view/View;->onDetachedFromWindow()V

    .line 164
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner;->a:Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner$ProgressSpinner;

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner$ProgressSpinner;->b()V

    .line 165
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner;->a:Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner$ProgressSpinner;

    invoke-virtual {v0, p0}, Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner$ProgressSpinner;->b(Landroid/animation/ValueAnimator$AnimatorUpdateListener;)V

    .line 166
    return-void
.end method

.method protected onDraw(Landroid/graphics/Canvas;)V
    .locals 1

    .prologue
    .line 169
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner;->a:Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner$ProgressSpinner;

    invoke-virtual {v0, p1}, Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner$ProgressSpinner;->a(Landroid/graphics/Canvas;)V

    .line 170
    return-void
.end method

.method protected onSizeChanged(IIII)V
    .locals 1

    .prologue
    .line 141
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner;->a:Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner$ProgressSpinner;

    invoke-virtual {v0, p1, p2}, Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner$ProgressSpinner;->a(II)V

    .line 142
    return-void
.end method

.method public setVisibility(I)V
    .locals 1

    .prologue
    .line 153
    invoke-super {p0, p1}, Landroid/view/View;->setVisibility(I)V

    .line 154
    if-nez p1, :cond_0

    .line 155
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner;->a:Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner$ProgressSpinner;

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner$ProgressSpinner;->b()V

    .line 156
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner;->a:Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner$ProgressSpinner;

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner$ProgressSpinner;->a()V

    .line 160
    :goto_0
    return-void

    .line 158
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner;->a:Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner$ProgressSpinner;

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner$ProgressSpinner;->b()V

    goto :goto_0
.end method
