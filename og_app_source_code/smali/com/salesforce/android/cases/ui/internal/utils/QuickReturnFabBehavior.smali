.class public Lcom/salesforce/android/cases/ui/internal/utils/QuickReturnFabBehavior;
.super Landroid/support/design/widget/CoordinatorLayout$Behavior;
.source "QuickReturnFabBehavior.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/support/design/widget/CoordinatorLayout$Behavior",
        "<",
        "Landroid/view/View;",
        ">;"
    }
.end annotation


# static fields
.field private static final a:Landroid/view/animation/Interpolator;


# instance fields
.field private b:I

.field private c:Z

.field private d:Z

.field private e:Z

.field private f:F


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 42
    new-instance v0, Landroid/support/v4/view/animation/FastOutSlowInInterpolator;

    invoke-direct {v0}, Landroid/support/v4/view/animation/FastOutSlowInInterpolator;-><init>()V

    sput-object v0, Lcom/salesforce/android/cases/ui/internal/utils/QuickReturnFabBehavior;->a:Landroid/view/animation/Interpolator;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 0

    .prologue
    .line 51
    invoke-direct {p0, p1, p2}, Landroid/support/design/widget/CoordinatorLayout$Behavior;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 52
    return-void
.end method

.method private a(Landroid/view/View;)V
    .locals 4

    .prologue
    const/4 v0, 0x1

    .line 116
    iput-boolean v0, p0, Lcom/salesforce/android/cases/ui/internal/utils/QuickReturnFabBehavior;->d:Z

    .line 117
    iput-boolean v0, p0, Lcom/salesforce/android/cases/ui/internal/utils/QuickReturnFabBehavior;->e:Z

    .line 118
    invoke-virtual {p1}, Landroid/view/View;->animate()Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    .line 119
    invoke-virtual {p1}, Landroid/view/View;->getHeight()I

    move-result v1

    mul-int/lit8 v1, v1, 0x2

    int-to-float v1, v1

    invoke-virtual {v0, v1}, Landroid/view/ViewPropertyAnimator;->translationY(F)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    sget-object v1, Lcom/salesforce/android/cases/ui/internal/utils/QuickReturnFabBehavior;->a:Landroid/view/animation/Interpolator;

    .line 120
    invoke-virtual {v0, v1}, Landroid/view/ViewPropertyAnimator;->setInterpolator(Landroid/animation/TimeInterpolator;)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    const-wide/16 v2, 0xc8

    .line 121
    invoke-virtual {v0, v2, v3}, Landroid/view/ViewPropertyAnimator;->setDuration(J)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    .line 123
    new-instance v1, Lcom/salesforce/android/cases/ui/internal/utils/QuickReturnFabBehavior$1;

    invoke-direct {v1, p0, p1}, Lcom/salesforce/android/cases/ui/internal/utils/QuickReturnFabBehavior$1;-><init>(Lcom/salesforce/android/cases/ui/internal/utils/QuickReturnFabBehavior;Landroid/view/View;)V

    invoke-virtual {v0, v1}, Landroid/view/ViewPropertyAnimator;->setListener(Landroid/animation/Animator$AnimatorListener;)Landroid/view/ViewPropertyAnimator;

    .line 144
    invoke-virtual {v0}, Landroid/view/ViewPropertyAnimator;->start()V

    .line 145
    return-void
.end method

.method static synthetic a(Lcom/salesforce/android/cases/ui/internal/utils/QuickReturnFabBehavior;Landroid/view/View;)V
    .locals 0

    .prologue
    .line 40
    invoke-direct {p0, p1}, Lcom/salesforce/android/cases/ui/internal/utils/QuickReturnFabBehavior;->b(Landroid/view/View;)V

    return-void
.end method

.method static synthetic a(Lcom/salesforce/android/cases/ui/internal/utils/QuickReturnFabBehavior;)Z
    .locals 1

    .prologue
    .line 40
    iget-boolean v0, p0, Lcom/salesforce/android/cases/ui/internal/utils/QuickReturnFabBehavior;->c:Z

    return v0
.end method

.method static synthetic a(Lcom/salesforce/android/cases/ui/internal/utils/QuickReturnFabBehavior;Z)Z
    .locals 0

    .prologue
    .line 40
    iput-boolean p1, p0, Lcom/salesforce/android/cases/ui/internal/utils/QuickReturnFabBehavior;->d:Z

    return p1
.end method

.method private b(Landroid/view/View;)V
    .locals 4

    .prologue
    .line 156
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/salesforce/android/cases/ui/internal/utils/QuickReturnFabBehavior;->c:Z

    .line 157
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/salesforce/android/cases/ui/internal/utils/QuickReturnFabBehavior;->e:Z

    .line 158
    invoke-virtual {p1}, Landroid/view/View;->animate()Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    iget v1, p0, Lcom/salesforce/android/cases/ui/internal/utils/QuickReturnFabBehavior;->f:F

    .line 159
    invoke-virtual {v0, v1}, Landroid/view/ViewPropertyAnimator;->translationY(F)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    sget-object v1, Lcom/salesforce/android/cases/ui/internal/utils/QuickReturnFabBehavior;->a:Landroid/view/animation/Interpolator;

    .line 160
    invoke-virtual {v0, v1}, Landroid/view/ViewPropertyAnimator;->setInterpolator(Landroid/animation/TimeInterpolator;)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    const-wide/16 v2, 0xc8

    .line 161
    invoke-virtual {v0, v2, v3}, Landroid/view/ViewPropertyAnimator;->setDuration(J)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    .line 163
    new-instance v1, Lcom/salesforce/android/cases/ui/internal/utils/QuickReturnFabBehavior$2;

    invoke-direct {v1, p0, p1}, Lcom/salesforce/android/cases/ui/internal/utils/QuickReturnFabBehavior$2;-><init>(Lcom/salesforce/android/cases/ui/internal/utils/QuickReturnFabBehavior;Landroid/view/View;)V

    invoke-virtual {v0, v1}, Landroid/view/ViewPropertyAnimator;->setListener(Landroid/animation/Animator$AnimatorListener;)Landroid/view/ViewPropertyAnimator;

    .line 183
    invoke-virtual {v0}, Landroid/view/ViewPropertyAnimator;->start()V

    .line 184
    return-void
.end method

.method static synthetic b(Lcom/salesforce/android/cases/ui/internal/utils/QuickReturnFabBehavior;Landroid/view/View;)V
    .locals 0

    .prologue
    .line 40
    invoke-direct {p0, p1}, Lcom/salesforce/android/cases/ui/internal/utils/QuickReturnFabBehavior;->a(Landroid/view/View;)V

    return-void
.end method

.method static synthetic b(Lcom/salesforce/android/cases/ui/internal/utils/QuickReturnFabBehavior;)Z
    .locals 1

    .prologue
    .line 40
    iget-boolean v0, p0, Lcom/salesforce/android/cases/ui/internal/utils/QuickReturnFabBehavior;->d:Z

    return v0
.end method

.method static synthetic b(Lcom/salesforce/android/cases/ui/internal/utils/QuickReturnFabBehavior;Z)Z
    .locals 0

    .prologue
    .line 40
    iput-boolean p1, p0, Lcom/salesforce/android/cases/ui/internal/utils/QuickReturnFabBehavior;->c:Z

    return p1
.end method


# virtual methods
.method public a(Landroid/support/design/widget/CoordinatorLayout;Landroid/view/View;Landroid/view/View;II[I)V
    .locals 2

    .prologue
    .line 92
    if-lez p5, :cond_0

    iget v0, p0, Lcom/salesforce/android/cases/ui/internal/utils/QuickReturnFabBehavior;->b:I

    if-ltz v0, :cond_1

    :cond_0
    if-gez p5, :cond_2

    iget v0, p0, Lcom/salesforce/android/cases/ui/internal/utils/QuickReturnFabBehavior;->b:I

    if-lez v0, :cond_2

    .line 94
    :cond_1
    invoke-virtual {p2}, Landroid/view/View;->animate()Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/ViewPropertyAnimator;->cancel()V

    .line 95
    const/4 v0, 0x0

    iput v0, p0, Lcom/salesforce/android/cases/ui/internal/utils/QuickReturnFabBehavior;->b:I

    .line 98
    :cond_2
    iget v0, p0, Lcom/salesforce/android/cases/ui/internal/utils/QuickReturnFabBehavior;->b:I

    add-int/2addr v0, p5

    iput v0, p0, Lcom/salesforce/android/cases/ui/internal/utils/QuickReturnFabBehavior;->b:I

    .line 100
    iget v0, p0, Lcom/salesforce/android/cases/ui/internal/utils/QuickReturnFabBehavior;->b:I

    const/16 v1, 0xc8

    if-lt v0, v1, :cond_4

    iget-boolean v0, p0, Lcom/salesforce/android/cases/ui/internal/utils/QuickReturnFabBehavior;->e:Z

    if-nez v0, :cond_4

    iget-boolean v0, p0, Lcom/salesforce/android/cases/ui/internal/utils/QuickReturnFabBehavior;->d:Z

    if-nez v0, :cond_4

    iget v0, p0, Lcom/salesforce/android/cases/ui/internal/utils/QuickReturnFabBehavior;->f:F

    const/4 v1, 0x0

    cmpl-float v0, v0, v1

    if-nez v0, :cond_4

    .line 101
    invoke-direct {p0, p2}, Lcom/salesforce/android/cases/ui/internal/utils/QuickReturnFabBehavior;->a(Landroid/view/View;)V

    .line 105
    :cond_3
    :goto_0
    return-void

    .line 102
    :cond_4
    iget v0, p0, Lcom/salesforce/android/cases/ui/internal/utils/QuickReturnFabBehavior;->b:I

    if-gez v0, :cond_3

    iget-boolean v0, p0, Lcom/salesforce/android/cases/ui/internal/utils/QuickReturnFabBehavior;->e:Z

    if-eqz v0, :cond_3

    iget-boolean v0, p0, Lcom/salesforce/android/cases/ui/internal/utils/QuickReturnFabBehavior;->c:Z

    if-nez v0, :cond_3

    .line 103
    invoke-direct {p0, p2}, Lcom/salesforce/android/cases/ui/internal/utils/QuickReturnFabBehavior;->b(Landroid/view/View;)V

    goto :goto_0
.end method

.method public a(Landroid/support/design/widget/CoordinatorLayout;Landroid/view/View;Landroid/view/View;)Z
    .locals 1

    .prologue
    .line 55
    invoke-super {p0, p1, p2, p3}, Landroid/support/design/widget/CoordinatorLayout$Behavior;->a(Landroid/support/design/widget/CoordinatorLayout;Landroid/view/View;Landroid/view/View;)Z

    move-result v0

    if-nez v0, :cond_0

    instance-of v0, p3, Landroid/support/design/widget/Snackbar$SnackbarLayout;

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public a(Landroid/support/design/widget/CoordinatorLayout;Landroid/view/View;Landroid/view/View;Landroid/view/View;I)Z
    .locals 1

    .prologue
    .line 86
    and-int/lit8 v0, p5, 0x2

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public b(Landroid/support/design/widget/CoordinatorLayout;Landroid/view/View;Landroid/view/View;)Z
    .locals 3

    .prologue
    .line 73
    instance-of v0, p3, Landroid/support/design/widget/Snackbar$SnackbarLayout;

    if-eqz v0, :cond_1

    .line 74
    const/4 v0, 0x0

    invoke-virtual {p3}, Landroid/view/View;->getTranslationY()F

    move-result v1

    invoke-virtual {p3}, Landroid/view/View;->getHeight()I

    move-result v2

    int-to-float v2, v2

    sub-float/2addr v1, v2

    invoke-static {v0, v1}, Ljava/lang/Math;->min(FF)F

    move-result v0

    .line 75
    iput v0, p0, Lcom/salesforce/android/cases/ui/internal/utils/QuickReturnFabBehavior;->f:F

    .line 76
    iget-boolean v1, p0, Lcom/salesforce/android/cases/ui/internal/utils/QuickReturnFabBehavior;->e:Z

    if-nez v1, :cond_0

    .line 77
    invoke-virtual {p2, v0}, Landroid/view/View;->setTranslationY(F)V

    .line 79
    :cond_0
    const/4 v0, 0x1

    .line 81
    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public d(Landroid/support/design/widget/CoordinatorLayout;Landroid/view/View;Landroid/view/View;)V
    .locals 3

    .prologue
    .line 61
    invoke-super {p0, p1, p2, p3}, Landroid/support/design/widget/CoordinatorLayout$Behavior;->d(Landroid/support/design/widget/CoordinatorLayout;Landroid/view/View;Landroid/view/View;)V

    .line 62
    instance-of v0, p3, Landroid/support/design/widget/Snackbar$SnackbarLayout;

    if-eqz v0, :cond_0

    .line 63
    const/4 v0, 0x0

    invoke-virtual {p1}, Landroid/support/design/widget/CoordinatorLayout;->getBottom()I

    move-result v1

    invoke-virtual {p2}, Landroid/view/View;->getBottom()I

    move-result v2

    sub-int/2addr v1, v2

    invoke-static {v0, v1}, Ljava/lang/Math;->min(II)I

    move-result v0

    int-to-float v0, v0

    .line 64
    iput v0, p0, Lcom/salesforce/android/cases/ui/internal/utils/QuickReturnFabBehavior;->f:F

    .line 65
    iget-boolean v1, p0, Lcom/salesforce/android/cases/ui/internal/utils/QuickReturnFabBehavior;->e:Z

    if-nez v1, :cond_0

    .line 66
    invoke-virtual {p2}, Landroid/view/View;->animate()Landroid/view/ViewPropertyAnimator;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/view/ViewPropertyAnimator;->translationY(F)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/ViewPropertyAnimator;->start()V

    .line 69
    :cond_0
    return-void
.end method
