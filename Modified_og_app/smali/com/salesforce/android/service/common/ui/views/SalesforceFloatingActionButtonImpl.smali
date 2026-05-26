.class Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;
.super Ljava/lang/Object;
.source "SalesforceFloatingActionButtonImpl.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl$Builder;
    }
.end annotation


# instance fields
.field final a:Landroid/view/View;

.field b:Landroid/graphics/drawable/GradientDrawable;

.field c:Landroid/graphics/drawable/GradientDrawable;

.field d:Landroid/graphics/drawable/GradientDrawable;

.field e:Landroid/graphics/Path;

.field f:Landroid/graphics/drawable/Drawable;

.field g:Landroid/graphics/drawable/Drawable;

.field h:Landroid/graphics/drawable/Drawable;

.field i:I

.field j:I

.field k:I

.field l:Landroid/view/animation/Interpolator;

.field m:Landroid/animation/ValueAnimator;

.field n:Landroid/animation/ValueAnimator;

.field private o:I

.field private p:I

.field private q:I


# direct methods
.method constructor <init>(Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl$Builder;)V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 99
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 83
    new-instance v0, Landroid/graphics/Path;

    invoke-direct {v0}, Landroid/graphics/Path;-><init>()V

    iput-object v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->e:Landroid/graphics/Path;

    .line 100
    iget-object v0, p1, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl$Builder;->a:Landroid/view/View;

    iput-object v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->a:Landroid/view/View;

    .line 101
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->a:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setWillNotDraw(Z)V

    .line 102
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->a:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setBackgroundColor(I)V

    .line 104
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->a:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/salesforce/android/service/common/ui/R$dimen;->salesforce_fab_default_icon_size:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v0

    iput v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->p:I

    .line 105
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->a:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/salesforce/android/service/common/ui/R$dimen;->salesforce_fab_elevation:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v0

    iput v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->q:I

    .line 106
    new-instance v0, Landroid/support/v4/view/animation/FastOutSlowInInterpolator;

    invoke-direct {v0}, Landroid/support/v4/view/animation/FastOutSlowInInterpolator;-><init>()V

    iput-object v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->l:Landroid/view/animation/Interpolator;

    .line 108
    iget v0, p1, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl$Builder;->b:I

    invoke-direct {p0, v0}, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->a(I)Landroid/graphics/drawable/GradientDrawable;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->b:Landroid/graphics/drawable/GradientDrawable;

    .line 109
    iget v0, p1, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl$Builder;->c:I

    invoke-direct {p0, v0}, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->a(I)Landroid/graphics/drawable/GradientDrawable;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->c:Landroid/graphics/drawable/GradientDrawable;

    .line 110
    iget v0, p1, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl$Builder;->b:I

    invoke-direct {p0, v0}, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->a(I)Landroid/graphics/drawable/GradientDrawable;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->d:Landroid/graphics/drawable/GradientDrawable;

    .line 112
    iget v0, p1, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl$Builder;->d:I

    iput v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->i:I

    .line 113
    iget v0, p1, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl$Builder;->e:I

    iput v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->j:I

    .line 114
    iget-object v0, p1, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl$Builder;->f:Landroid/graphics/drawable/Drawable;

    iput-object v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->g:Landroid/graphics/drawable/Drawable;

    .line 115
    iget-object v0, p1, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl$Builder;->g:Landroid/graphics/drawable/Drawable;

    iput-object v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->h:Landroid/graphics/drawable/Drawable;

    .line 116
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->g:Landroid/graphics/drawable/Drawable;

    iget v1, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->i:I

    invoke-virtual {p0, v0, v1}, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->a(Landroid/graphics/drawable/Drawable;I)V

    .line 117
    return-void
.end method

.method private a()Landroid/animation/ValueAnimator;
    .locals 4

    .prologue
    .line 220
    const/4 v0, 0x2

    new-array v0, v0, [F

    fill-array-data v0, :array_0

    invoke-static {v0}, Landroid/animation/ValueAnimator;->ofFloat([F)Landroid/animation/ValueAnimator;

    move-result-object v0

    .line 221
    const-wide/16 v2, 0xfa

    invoke-virtual {v0, v2, v3}, Landroid/animation/ValueAnimator;->setDuration(J)Landroid/animation/ValueAnimator;

    move-result-object v1

    iget-object v2, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->l:Landroid/view/animation/Interpolator;

    .line 222
    invoke-virtual {v1, v2}, Landroid/animation/ValueAnimator;->setInterpolator(Landroid/animation/TimeInterpolator;)V

    .line 223
    return-object v0

    .line 220
    :array_0
    .array-data 4
        0x0
        0x3f800000    # 1.0f
    .end array-data
.end method

.method private a(I)Landroid/graphics/drawable/GradientDrawable;
    .locals 2

    .prologue
    .line 212
    new-instance v0, Landroid/graphics/drawable/GradientDrawable;

    invoke-direct {v0}, Landroid/graphics/drawable/GradientDrawable;-><init>()V

    .line 213
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/graphics/drawable/GradientDrawable;->setShape(I)V

    .line 214
    invoke-virtual {v0, p1}, Landroid/graphics/drawable/GradientDrawable;->setColor(I)V

    .line 215
    return-object v0
.end method

.method static a(Landroid/view/View;)Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl$Builder;
    .locals 1

    .prologue
    .line 284
    new-instance v0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl$Builder;

    invoke-direct {v0, p0}, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl$Builder;-><init>(Landroid/view/View;)V

    return-object v0
.end method

.method private b(II)Landroid/graphics/Rect;
    .locals 5

    .prologue
    .line 257
    div-int/lit8 v0, p1, 0x2

    div-int/lit8 v1, p2, 0x2

    sub-int/2addr v0, v1

    .line 258
    div-int/lit8 v1, p1, 0x2

    div-int/lit8 v2, p2, 0x2

    sub-int/2addr v1, v2

    .line 259
    div-int/lit8 v2, p1, 0x2

    div-int/lit8 v3, p2, 0x2

    add-int/2addr v2, v3

    .line 260
    div-int/lit8 v3, p1, 0x2

    div-int/lit8 v4, p2, 0x2

    add-int/2addr v3, v4

    .line 261
    new-instance v4, Landroid/graphics/Rect;

    invoke-direct {v4, v0, v1, v2, v3}, Landroid/graphics/Rect;-><init>(IIII)V

    return-object v4
.end method

.method private b(I)V
    .locals 2
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "NewApi"
        }
    .end annotation

    .prologue
    .line 266
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x15

    if-lt v0, v1, :cond_0

    .line 267
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->a:Landroid/view/View;

    new-instance v1, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl$5;

    invoke-direct {v1, p0, p1}, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl$5;-><init>(Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;I)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOutlineProvider(Landroid/view/ViewOutlineProvider;)V

    .line 275
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->a:Landroid/view/View;

    iget v1, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->q:I

    int-to-float v1, v1

    invoke-virtual {v0, v1}, Landroid/view/View;->setElevation(F)V

    .line 277
    :cond_0
    return-void
.end method


# virtual methods
.method a(Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;)Landroid/animation/Animator;
    .locals 2

    .prologue
    .line 157
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->m:Landroid/animation/ValueAnimator;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->m:Landroid/animation/ValueAnimator;

    invoke-virtual {v0}, Landroid/animation/ValueAnimator;->isRunning()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 158
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->m:Landroid/animation/ValueAnimator;

    invoke-virtual {v0}, Landroid/animation/ValueAnimator;->cancel()V

    .line 161
    :cond_0
    invoke-direct {p0}, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->a()Landroid/animation/ValueAnimator;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->m:Landroid/animation/ValueAnimator;

    .line 162
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->m:Landroid/animation/ValueAnimator;

    new-instance v1, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl$1;

    invoke-direct {v1, p0, p1}, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl$1;-><init>(Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;)V

    invoke-virtual {v0, v1}, Landroid/animation/ValueAnimator;->addUpdateListener(Landroid/animation/ValueAnimator$AnimatorUpdateListener;)V

    .line 171
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->m:Landroid/animation/ValueAnimator;

    new-instance v1, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl$2;

    invoke-direct {v1, p0}, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl$2;-><init>(Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;)V

    invoke-virtual {v0, v1}, Landroid/animation/ValueAnimator;->addListener(Landroid/animation/Animator$AnimatorListener;)V

    .line 177
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->m:Landroid/animation/ValueAnimator;

    return-object v0
.end method

.method a(II)V
    .locals 5

    .prologue
    const/4 v3, 0x0

    const/4 v4, 0x0

    .line 124
    invoke-static {p1, p2}, Ljava/lang/Math;->min(II)I

    move-result v0

    iput v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->o:I

    .line 125
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->b:Landroid/graphics/drawable/GradientDrawable;

    iget v1, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->o:I

    iget v2, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->o:I

    invoke-virtual {v0, v3, v3, v1, v2}, Landroid/graphics/drawable/GradientDrawable;->setBounds(IIII)V

    .line 126
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->g:Landroid/graphics/drawable/Drawable;

    iget v1, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->o:I

    iget v2, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->p:I

    invoke-direct {p0, v1, v2}, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->b(II)Landroid/graphics/Rect;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/graphics/drawable/Drawable;->setBounds(Landroid/graphics/Rect;)V

    .line 127
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->e:Landroid/graphics/Path;

    new-instance v1, Landroid/graphics/RectF;

    iget v2, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->o:I

    int-to-float v2, v2

    iget v3, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->o:I

    int-to-float v3, v3

    invoke-direct {v1, v4, v4, v2, v3}, Landroid/graphics/RectF;-><init>(FFFF)V

    sget-object v2, Landroid/graphics/Path$Direction;->CW:Landroid/graphics/Path$Direction;

    invoke-virtual {v0, v1, v2}, Landroid/graphics/Path;->addOval(Landroid/graphics/RectF;Landroid/graphics/Path$Direction;)V

    .line 128
    iget v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->o:I

    invoke-direct {p0, v0}, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->b(I)V

    .line 130
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->f:Landroid/graphics/drawable/Drawable;

    iget v1, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->k:I

    invoke-virtual {p0, v0, v1}, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->a(Landroid/graphics/drawable/Drawable;I)V

    .line 131
    return-void
.end method

.method a(Landroid/graphics/Canvas;)V
    .locals 2

    .prologue
    .line 141
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x15

    if-lt v0, v1, :cond_0

    .line 143
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->e:Landroid/graphics/Path;

    invoke-virtual {p1, v0}, Landroid/graphics/Canvas;->clipPath(Landroid/graphics/Path;)Z

    .line 146
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->b:Landroid/graphics/drawable/GradientDrawable;

    invoke-virtual {v0, p1}, Landroid/graphics/drawable/GradientDrawable;->draw(Landroid/graphics/Canvas;)V

    .line 147
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->c:Landroid/graphics/drawable/GradientDrawable;

    invoke-virtual {v0, p1}, Landroid/graphics/drawable/GradientDrawable;->draw(Landroid/graphics/Canvas;)V

    .line 148
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->d:Landroid/graphics/drawable/GradientDrawable;

    invoke-virtual {v0, p1}, Landroid/graphics/drawable/GradientDrawable;->draw(Landroid/graphics/Canvas;)V

    .line 149
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->f:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v0, p1}, Landroid/graphics/drawable/Drawable;->draw(Landroid/graphics/Canvas;)V

    .line 150
    return-void
.end method

.method a(Landroid/graphics/drawable/Drawable;I)V
    .locals 3

    .prologue
    .line 134
    iput-object p1, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->f:Landroid/graphics/drawable/Drawable;

    .line 135
    iput p2, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->k:I

    .line 136
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->f:Landroid/graphics/drawable/Drawable;

    iget v1, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->o:I

    iget v2, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->p:I

    invoke-direct {p0, v1, v2}, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->b(II)Landroid/graphics/Rect;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/graphics/drawable/Drawable;->setBounds(Landroid/graphics/Rect;)V

    .line 137
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->f:Landroid/graphics/drawable/Drawable;

    iget v1, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->k:I

    invoke-static {v0, v1}, Lcom/salesforce/android/service/common/ui/internal/utils/DrawableUtils;->a(Landroid/graphics/drawable/Drawable;I)Landroid/graphics/drawable/Drawable;

    .line 138
    return-void
.end method

.method a(Landroid/graphics/drawable/Drawable;Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;F)V
    .locals 5

    .prologue
    .line 229
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x15

    if-lt v0, v1, :cond_0

    .line 232
    invoke-virtual {p2}, Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;->a()I

    move-result v0

    invoke-virtual {p2}, Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;->b()I

    move-result v1

    invoke-static {v0, v1}, Ljava/lang/Math;->max(II)I

    move-result v0

    iget v1, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->o:I

    int-to-float v1, v1

    const v2, 0x3f99999a    # 1.2f

    mul-float/2addr v1, v2

    invoke-static {v1}, Ljava/lang/Math;->round(F)I

    move-result v1

    add-int/2addr v0, v1

    .line 239
    :goto_0
    int-to-float v1, v0

    mul-float/2addr v1, p3

    invoke-static {v1}, Ljava/lang/Math;->round(F)I

    move-result v1

    .line 240
    int-to-float v0, v0

    mul-float/2addr v0, p3

    invoke-static {v0}, Ljava/lang/Math;->round(F)I

    move-result v0

    .line 241
    invoke-virtual {p2}, Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;->a()I

    move-result v2

    div-int/lit8 v3, v1, 0x2

    sub-int/2addr v2, v3

    .line 242
    invoke-virtual {p2}, Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;->b()I

    move-result v3

    div-int/lit8 v4, v0, 0x2

    sub-int/2addr v3, v4

    .line 243
    invoke-virtual {p1, v2, v3, v1, v0}, Landroid/graphics/drawable/Drawable;->setBounds(IIII)V

    .line 244
    return-void

    .line 236
    :cond_0
    iget v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->o:I

    goto :goto_0
.end method

.method b(Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;)Landroid/animation/Animator;
    .locals 2

    .prologue
    .line 181
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->n:Landroid/animation/ValueAnimator;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->n:Landroid/animation/ValueAnimator;

    invoke-virtual {v0}, Landroid/animation/ValueAnimator;->isRunning()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 182
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->n:Landroid/animation/ValueAnimator;

    invoke-virtual {v0}, Landroid/animation/ValueAnimator;->cancel()V

    .line 185
    :cond_0
    invoke-direct {p0}, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->a()Landroid/animation/ValueAnimator;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->n:Landroid/animation/ValueAnimator;

    .line 186
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->n:Landroid/animation/ValueAnimator;

    new-instance v1, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl$3;

    invoke-direct {v1, p0, p1}, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl$3;-><init>(Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;)V

    invoke-virtual {v0, v1}, Landroid/animation/ValueAnimator;->addUpdateListener(Landroid/animation/ValueAnimator$AnimatorUpdateListener;)V

    .line 195
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->n:Landroid/animation/ValueAnimator;

    new-instance v1, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl$4;

    invoke-direct {v1, p0}, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl$4;-><init>(Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;)V

    invoke-virtual {v0, v1}, Landroid/animation/ValueAnimator;->addListener(Landroid/animation/Animator$AnimatorListener;)V

    .line 204
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->n:Landroid/animation/ValueAnimator;

    return-object v0
.end method

.method c(Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;)Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;
    .locals 2

    .prologue
    .line 247
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x15

    if-lt v0, v1, :cond_0

    .line 253
    :goto_0
    return-object p1

    :cond_0
    iget v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->o:I

    div-int/lit8 v0, v0, 0x2

    iget v1, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->o:I

    div-int/lit8 v1, v1, 0x2

    invoke-static {v0, v1}, Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;->a(II)Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;

    move-result-object p1

    goto :goto_0
.end method
