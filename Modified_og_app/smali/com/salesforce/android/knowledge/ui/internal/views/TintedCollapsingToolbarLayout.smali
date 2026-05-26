.class public Lcom/salesforce/android/knowledge/ui/internal/views/TintedCollapsingToolbarLayout;
.super Landroid/support/design/widget/CollapsingToolbarLayout;
.source "TintedCollapsingToolbarLayout.java"


# instance fields
.field private e:Landroid/support/v7/widget/Toolbar;

.field private f:Landroid/animation/ValueAnimator;

.field private g:I


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1

    .prologue
    .line 66
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Lcom/salesforce/android/knowledge/ui/internal/views/TintedCollapsingToolbarLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 67
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 2

    .prologue
    .line 70
    invoke-direct {p0, p1, p2, p3}, Landroid/support/design/widget/CollapsingToolbarLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 59
    const v0, 0xffffff

    iput v0, p0, Lcom/salesforce/android/knowledge/ui/internal/views/TintedCollapsingToolbarLayout;->g:I

    .line 71
    invoke-static {p1, p2}, Lcom/salesforce/android/service/common/ui/internal/text/SalesforceStyleHelper;->a(Landroid/content/Context;Landroid/util/AttributeSet;)Lcom/salesforce/android/service/common/ui/internal/text/SalesforceStyleHelper;

    move-result-object v0

    .line 74
    invoke-virtual {v0}, Lcom/salesforce/android/service/common/ui/internal/text/SalesforceStyleHelper;->b()Landroid/graphics/Typeface;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/salesforce/android/knowledge/ui/internal/views/TintedCollapsingToolbarLayout;->setExpandedTitleTypeface(Landroid/graphics/Typeface;)V

    .line 75
    invoke-virtual {v0}, Lcom/salesforce/android/service/common/ui/internal/text/SalesforceStyleHelper;->b()Landroid/graphics/Typeface;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/salesforce/android/knowledge/ui/internal/views/TintedCollapsingToolbarLayout;->setCollapsedTitleTypeface(Landroid/graphics/Typeface;)V

    .line 78
    invoke-virtual {p0}, Lcom/salesforce/android/knowledge/ui/internal/views/TintedCollapsingToolbarLayout;->getTitle()Ljava/lang/CharSequence;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/salesforce/android/service/common/ui/internal/text/SalesforceStyleHelper;->a(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/salesforce/android/knowledge/ui/internal/views/TintedCollapsingToolbarLayout;->setTitle(Ljava/lang/CharSequence;)V

    .line 79
    return-void
.end method

.method private a(I)V
    .locals 7

    .prologue
    const/4 v6, 0x2

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 117
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/views/TintedCollapsingToolbarLayout;->f:Landroid/animation/ValueAnimator;

    if-nez v0, :cond_1

    .line 118
    new-instance v0, Landroid/animation/ArgbEvaluator;

    invoke-direct {v0}, Landroid/animation/ArgbEvaluator;-><init>()V

    new-array v1, v6, [Ljava/lang/Object;

    iget v2, p0, Lcom/salesforce/android/knowledge/ui/internal/views/TintedCollapsingToolbarLayout;->g:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    aput-object v2, v1, v4

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    aput-object v2, v1, v5

    invoke-static {v0, v1}, Landroid/animation/ValueAnimator;->ofObject(Landroid/animation/TypeEvaluator;[Ljava/lang/Object;)Landroid/animation/ValueAnimator;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/views/TintedCollapsingToolbarLayout;->f:Landroid/animation/ValueAnimator;

    .line 119
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/views/TintedCollapsingToolbarLayout;->f:Landroid/animation/ValueAnimator;

    const-wide/16 v2, 0x258

    invoke-virtual {v0, v2, v3}, Landroid/animation/ValueAnimator;->setDuration(J)Landroid/animation/ValueAnimator;

    .line 120
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/views/TintedCollapsingToolbarLayout;->f:Landroid/animation/ValueAnimator;

    new-instance v1, Lcom/salesforce/android/knowledge/ui/internal/views/TintedCollapsingToolbarLayout$1;

    invoke-direct {v1, p0}, Lcom/salesforce/android/knowledge/ui/internal/views/TintedCollapsingToolbarLayout$1;-><init>(Lcom/salesforce/android/knowledge/ui/internal/views/TintedCollapsingToolbarLayout;)V

    invoke-virtual {v0, v1}, Landroid/animation/ValueAnimator;->addUpdateListener(Landroid/animation/ValueAnimator$AnimatorUpdateListener;)V

    .line 129
    :cond_0
    :goto_0
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/views/TintedCollapsingToolbarLayout;->f:Landroid/animation/ValueAnimator;

    new-array v1, v6, [I

    iget v2, p0, Lcom/salesforce/android/knowledge/ui/internal/views/TintedCollapsingToolbarLayout;->g:I

    aput v2, v1, v4

    aput p1, v1, v5

    invoke-virtual {v0, v1}, Landroid/animation/ValueAnimator;->setIntValues([I)V

    .line 130
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/views/TintedCollapsingToolbarLayout;->f:Landroid/animation/ValueAnimator;

    invoke-virtual {v0}, Landroid/animation/ValueAnimator;->start()V

    .line 131
    return-void

    .line 125
    :cond_1
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/views/TintedCollapsingToolbarLayout;->f:Landroid/animation/ValueAnimator;

    invoke-virtual {v0}, Landroid/animation/ValueAnimator;->isRunning()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 126
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/views/TintedCollapsingToolbarLayout;->f:Landroid/animation/ValueAnimator;

    invoke-virtual {v0}, Landroid/animation/ValueAnimator;->cancel()V

    goto :goto_0
.end method

.method private c()V
    .locals 5

    .prologue
    .line 143
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/views/TintedCollapsingToolbarLayout;->e:Landroid/support/v7/widget/Toolbar;

    if-nez v0, :cond_0

    .line 144
    const/4 v1, 0x0

    .line 145
    const/4 v0, 0x0

    invoke-virtual {p0}, Lcom/salesforce/android/knowledge/ui/internal/views/TintedCollapsingToolbarLayout;->getChildCount()I

    move-result v3

    move v2, v0

    :goto_0
    if-ge v2, v3, :cond_2

    .line 146
    invoke-virtual {p0, v2}, Lcom/salesforce/android/knowledge/ui/internal/views/TintedCollapsingToolbarLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 147
    instance-of v4, v0, Landroid/support/v7/widget/Toolbar;

    if-eqz v4, :cond_1

    .line 148
    check-cast v0, Landroid/support/v7/widget/Toolbar;

    .line 152
    :goto_1
    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/views/TintedCollapsingToolbarLayout;->e:Landroid/support/v7/widget/Toolbar;

    .line 154
    :cond_0
    return-void

    .line 145
    :cond_1
    add-int/lit8 v0, v2, 0x1

    move v2, v0

    goto :goto_0

    :cond_2
    move-object v0, v1

    goto :goto_1
.end method


# virtual methods
.method public a(ZZ)V
    .locals 2

    .prologue
    .line 89
    invoke-super {p0, p1, p2}, Landroid/support/design/widget/CollapsingToolbarLayout;->a(ZZ)V

    .line 93
    invoke-virtual {p0}, Lcom/salesforce/android/knowledge/ui/internal/views/TintedCollapsingToolbarLayout;->getContext()Landroid/content/Context;

    move-result-object v1

    if-eqz p1, :cond_0

    sget v0, Lcom/salesforce/android/knowledge/ui/R$color;->salesforce_toolbar_inverted:I

    :goto_0
    invoke-static {v1, v0}, Landroid/support/v4/content/ContextCompat;->c(Landroid/content/Context;I)I

    move-result v0

    .line 95
    if-eqz p2, :cond_1

    .line 96
    invoke-direct {p0, v0}, Lcom/salesforce/android/knowledge/ui/internal/views/TintedCollapsingToolbarLayout;->a(I)V

    .line 100
    :goto_1
    return-void

    .line 93
    :cond_0
    sget v0, Lcom/salesforce/android/knowledge/ui/R$color;->salesforce_brand_primary_inverted:I

    goto :goto_0

    .line 98
    :cond_1
    invoke-virtual {p0, v0}, Lcom/salesforce/android/knowledge/ui/internal/views/TintedCollapsingToolbarLayout;->setToolbarTint(I)V

    goto :goto_1
.end method

.method protected onDraw(Landroid/graphics/Canvas;)V
    .locals 0

    .prologue
    .line 103
    invoke-direct {p0}, Lcom/salesforce/android/knowledge/ui/internal/views/TintedCollapsingToolbarLayout;->c()V

    .line 104
    invoke-super {p0, p1}, Landroid/support/design/widget/CollapsingToolbarLayout;->onDraw(Landroid/graphics/Canvas;)V

    .line 105
    return-void
.end method

.method protected onMeasure(II)V
    .locals 0

    .prologue
    .line 108
    invoke-direct {p0}, Lcom/salesforce/android/knowledge/ui/internal/views/TintedCollapsingToolbarLayout;->c()V

    .line 109
    invoke-super {p0, p1, p2}, Landroid/support/design/widget/CollapsingToolbarLayout;->onMeasure(II)V

    .line 110
    return-void
.end method

.method setToolbarTint(I)V
    .locals 1

    .prologue
    .line 134
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/views/TintedCollapsingToolbarLayout;->e:Landroid/support/v7/widget/Toolbar;

    if-eqz v0, :cond_0

    .line 135
    iput p1, p0, Lcom/salesforce/android/knowledge/ui/internal/views/TintedCollapsingToolbarLayout;->g:I

    .line 136
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/views/TintedCollapsingToolbarLayout;->e:Landroid/support/v7/widget/Toolbar;

    invoke-static {v0, p1}, Lcom/salesforce/android/knowledge/ui/internal/views/ViewUtil;->a(Landroid/support/v7/widget/Toolbar;I)V

    .line 138
    :cond_0
    return-void
.end method
