.class public Lcom/salesforce/android/knowledge/ui/internal/util/AnimatedOnClickListener;
.super Ljava/lang/Object;
.source "AnimatedOnClickListener.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field private a:Landroid/animation/ValueAnimator;

.field private final b:I

.field private final c:I

.field private final d:I

.field private final e:Landroid/view/View$OnClickListener;


# direct methods
.method private constructor <init>(Landroid/content/Context;Landroid/view/View$OnClickListener;)V
    .locals 4

    .prologue
    .line 55
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 57
    sget v0, Lcom/salesforce/android/knowledge/ui/R$color;->salesforce_brand_secondary:I

    invoke-static {p1, v0}, Landroid/support/v4/content/ContextCompat;->c(Landroid/content/Context;I)I

    move-result v0

    .line 58
    const/16 v1, 0x3f

    invoke-static {v0}, Landroid/graphics/Color;->red(I)I

    move-result v2

    invoke-static {v0}, Landroid/graphics/Color;->green(I)I

    move-result v3

    invoke-static {v0}, Landroid/graphics/Color;->blue(I)I

    move-result v0

    invoke-static {v1, v2, v3, v0}, Landroid/graphics/Color;->argb(IIII)I

    move-result v0

    .line 61
    const/4 v1, 0x0

    iput v1, p0, Lcom/salesforce/android/knowledge/ui/internal/util/AnimatedOnClickListener;->b:I

    .line 62
    iput v0, p0, Lcom/salesforce/android/knowledge/ui/internal/util/AnimatedOnClickListener;->c:I

    .line 63
    const/16 v0, 0x12c

    iput v0, p0, Lcom/salesforce/android/knowledge/ui/internal/util/AnimatedOnClickListener;->d:I

    .line 64
    iput-object p2, p0, Lcom/salesforce/android/knowledge/ui/internal/util/AnimatedOnClickListener;->e:Landroid/view/View$OnClickListener;

    .line 65
    return-void
.end method

.method public static a(Landroid/content/Context;Landroid/view/View$OnClickListener;)Lcom/salesforce/android/knowledge/ui/internal/util/AnimatedOnClickListener;
    .locals 1

    .prologue
    .line 68
    new-instance v0, Lcom/salesforce/android/knowledge/ui/internal/util/AnimatedOnClickListener;

    invoke-direct {v0, p0, p1}, Lcom/salesforce/android/knowledge/ui/internal/util/AnimatedOnClickListener;-><init>(Landroid/content/Context;Landroid/view/View$OnClickListener;)V

    return-object v0
.end method


# virtual methods
.method public final onClick(Landroid/view/View;)V
    .locals 4

    .prologue
    .line 77
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/util/AnimatedOnClickListener;->a:Landroid/animation/ValueAnimator;

    if-eqz v0, :cond_0

    .line 78
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/util/AnimatedOnClickListener;->a:Landroid/animation/ValueAnimator;

    invoke-virtual {v0}, Landroid/animation/ValueAnimator;->cancel()V

    .line 81
    :cond_0
    new-instance v0, Landroid/animation/ArgbEvaluator;

    invoke-direct {v0}, Landroid/animation/ArgbEvaluator;-><init>()V

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    iget v3, p0, Lcom/salesforce/android/knowledge/ui/internal/util/AnimatedOnClickListener;->c:I

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v1, v2

    const/4 v2, 0x1

    iget v3, p0, Lcom/salesforce/android/knowledge/ui/internal/util/AnimatedOnClickListener;->b:I

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Landroid/animation/ValueAnimator;->ofObject(Landroid/animation/TypeEvaluator;[Ljava/lang/Object;)Landroid/animation/ValueAnimator;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/util/AnimatedOnClickListener;->a:Landroid/animation/ValueAnimator;

    .line 82
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/util/AnimatedOnClickListener;->a:Landroid/animation/ValueAnimator;

    iget v1, p0, Lcom/salesforce/android/knowledge/ui/internal/util/AnimatedOnClickListener;->d:I

    int-to-long v2, v1

    invoke-virtual {v0, v2, v3}, Landroid/animation/ValueAnimator;->setDuration(J)Landroid/animation/ValueAnimator;

    .line 85
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/util/AnimatedOnClickListener;->a:Landroid/animation/ValueAnimator;

    new-instance v1, Lcom/salesforce/android/knowledge/ui/internal/util/AnimatedOnClickListener$1;

    invoke-direct {v1, p0, p1}, Lcom/salesforce/android/knowledge/ui/internal/util/AnimatedOnClickListener$1;-><init>(Lcom/salesforce/android/knowledge/ui/internal/util/AnimatedOnClickListener;Landroid/view/View;)V

    invoke-virtual {v0, v1}, Landroid/animation/ValueAnimator;->addUpdateListener(Landroid/animation/ValueAnimator$AnimatorUpdateListener;)V

    .line 91
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/util/AnimatedOnClickListener;->a:Landroid/animation/ValueAnimator;

    invoke-virtual {v0}, Landroid/animation/ValueAnimator;->start()V

    .line 94
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/util/AnimatedOnClickListener;->e:Landroid/view/View$OnClickListener;

    if-eqz v0, :cond_1

    .line 95
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/util/AnimatedOnClickListener;->e:Landroid/view/View$OnClickListener;

    invoke-interface {v0, p1}, Landroid/view/View$OnClickListener;->onClick(Landroid/view/View;)V

    .line 97
    :cond_1
    return-void
.end method
