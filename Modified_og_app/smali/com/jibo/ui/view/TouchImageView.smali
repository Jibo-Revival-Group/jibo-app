.class public Lcom/jibo/ui/view/TouchImageView;
.super Landroid/widget/ImageView;
.source "TouchImageView.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/jibo/ui/view/TouchImageView$ZoomVariables;,
        Lcom/jibo/ui/view/TouchImageView$CompatScroller;,
        Lcom/jibo/ui/view/TouchImageView$Fling;,
        Lcom/jibo/ui/view/TouchImageView$DoubleTapZoom;,
        Lcom/jibo/ui/view/TouchImageView$ScaleListener;,
        Lcom/jibo/ui/view/TouchImageView$PrivateOnTouchListener;,
        Lcom/jibo/ui/view/TouchImageView$OnTouchImageViewListener;,
        Lcom/jibo/ui/view/TouchImageView$GestureListener;,
        Lcom/jibo/ui/view/TouchImageView$State;
    }
.end annotation


# instance fields
.field private A:Landroid/view/View$OnTouchListener;

.field private B:Lcom/jibo/ui/view/TouchImageView$OnTouchImageViewListener;

.field private a:F

.field private b:Landroid/graphics/Matrix;

.field private c:Landroid/graphics/Matrix;

.field private d:Lcom/jibo/ui/view/TouchImageView$State;

.field private e:F

.field private f:F

.field private g:F

.field private h:F

.field private i:[F

.field private j:Landroid/content/Context;

.field private k:Lcom/jibo/ui/view/TouchImageView$Fling;

.field private l:Landroid/widget/ImageView$ScaleType;

.field private m:Z

.field private n:Z

.field private o:Lcom/jibo/ui/view/TouchImageView$ZoomVariables;

.field private p:I

.field private q:I

.field private r:I

.field private s:I

.field private t:F

.field private u:F

.field private v:F

.field private w:F

.field private x:Landroid/view/ScaleGestureDetector;

.field private y:Landroid/view/GestureDetector;

.field private z:Landroid/view/GestureDetector$OnDoubleTapListener;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 102
    invoke-direct {p0, p1}, Landroid/widget/ImageView;-><init>(Landroid/content/Context;)V

    .line 97
    iput-object v0, p0, Lcom/jibo/ui/view/TouchImageView;->z:Landroid/view/GestureDetector$OnDoubleTapListener;

    .line 98
    iput-object v0, p0, Lcom/jibo/ui/view/TouchImageView;->A:Landroid/view/View$OnTouchListener;

    .line 99
    iput-object v0, p0, Lcom/jibo/ui/view/TouchImageView;->B:Lcom/jibo/ui/view/TouchImageView$OnTouchImageViewListener;

    .line 103
    invoke-direct {p0, p1}, Lcom/jibo/ui/view/TouchImageView;->a(Landroid/content/Context;)V

    .line 104
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 107
    invoke-direct {p0, p1, p2}, Landroid/widget/ImageView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 97
    iput-object v0, p0, Lcom/jibo/ui/view/TouchImageView;->z:Landroid/view/GestureDetector$OnDoubleTapListener;

    .line 98
    iput-object v0, p0, Lcom/jibo/ui/view/TouchImageView;->A:Landroid/view/View$OnTouchListener;

    .line 99
    iput-object v0, p0, Lcom/jibo/ui/view/TouchImageView;->B:Lcom/jibo/ui/view/TouchImageView$OnTouchImageViewListener;

    .line 108
    invoke-direct {p0, p1}, Lcom/jibo/ui/view/TouchImageView;->a(Landroid/content/Context;)V

    .line 109
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 112
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/ImageView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 97
    iput-object v0, p0, Lcom/jibo/ui/view/TouchImageView;->z:Landroid/view/GestureDetector$OnDoubleTapListener;

    .line 98
    iput-object v0, p0, Lcom/jibo/ui/view/TouchImageView;->A:Landroid/view/View$OnTouchListener;

    .line 99
    iput-object v0, p0, Lcom/jibo/ui/view/TouchImageView;->B:Lcom/jibo/ui/view/TouchImageView$OnTouchImageViewListener;

    .line 113
    invoke-direct {p0, p1}, Lcom/jibo/ui/view/TouchImageView;->a(Landroid/content/Context;)V

    .line 114
    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/view/TouchImageView;FFF)F
    .locals 1

    .prologue
    .line 40
    invoke-direct {p0, p1, p2, p3}, Lcom/jibo/ui/view/TouchImageView;->c(FFF)F

    move-result v0

    return v0
.end method

.method private a(FF)Landroid/graphics/PointF;
    .locals 4

    .prologue
    .line 1102
    iget-object v0, p0, Lcom/jibo/ui/view/TouchImageView;->b:Landroid/graphics/Matrix;

    iget-object v1, p0, Lcom/jibo/ui/view/TouchImageView;->i:[F

    invoke-virtual {v0, v1}, Landroid/graphics/Matrix;->getValues([F)V

    .line 1103
    invoke-virtual {p0}, Lcom/jibo/ui/view/TouchImageView;->getDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    move-result v0

    int-to-float v0, v0

    .line 1104
    invoke-virtual {p0}, Lcom/jibo/ui/view/TouchImageView;->getDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v1

    invoke-virtual {v1}, Landroid/graphics/drawable/Drawable;->getIntrinsicHeight()I

    move-result v1

    int-to-float v1, v1

    .line 1105
    div-float v0, p1, v0

    .line 1106
    div-float v1, p2, v1

    .line 1107
    iget-object v2, p0, Lcom/jibo/ui/view/TouchImageView;->i:[F

    const/4 v3, 0x2

    aget v2, v2, v3

    invoke-direct {p0}, Lcom/jibo/ui/view/TouchImageView;->getImageWidth()F

    move-result v3

    mul-float/2addr v0, v3

    add-float/2addr v0, v2

    .line 1108
    iget-object v2, p0, Lcom/jibo/ui/view/TouchImageView;->i:[F

    const/4 v3, 0x5

    aget v2, v2, v3

    invoke-direct {p0}, Lcom/jibo/ui/view/TouchImageView;->getImageHeight()F

    move-result v3

    mul-float/2addr v1, v3

    add-float/2addr v1, v2

    .line 1109
    new-instance v2, Landroid/graphics/PointF;

    invoke-direct {v2, v0, v1}, Landroid/graphics/PointF;-><init>(FF)V

    return-object v2
.end method

.method private a(FFZ)Landroid/graphics/PointF;
    .locals 6

    .prologue
    const/4 v5, 0x0

    .line 1078
    iget-object v0, p0, Lcom/jibo/ui/view/TouchImageView;->b:Landroid/graphics/Matrix;

    iget-object v1, p0, Lcom/jibo/ui/view/TouchImageView;->i:[F

    invoke-virtual {v0, v1}, Landroid/graphics/Matrix;->getValues([F)V

    .line 1079
    invoke-virtual {p0}, Lcom/jibo/ui/view/TouchImageView;->getDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    move-result v0

    int-to-float v2, v0

    .line 1080
    invoke-virtual {p0}, Lcom/jibo/ui/view/TouchImageView;->getDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->getIntrinsicHeight()I

    move-result v0

    int-to-float v3, v0

    .line 1081
    iget-object v0, p0, Lcom/jibo/ui/view/TouchImageView;->i:[F

    const/4 v1, 0x2

    aget v0, v0, v1

    .line 1082
    iget-object v1, p0, Lcom/jibo/ui/view/TouchImageView;->i:[F

    const/4 v4, 0x5

    aget v4, v1, v4

    .line 1083
    sub-float v0, p1, v0

    mul-float/2addr v0, v2

    invoke-direct {p0}, Lcom/jibo/ui/view/TouchImageView;->getImageWidth()F

    move-result v1

    div-float v1, v0, v1

    .line 1084
    sub-float v0, p2, v4

    mul-float/2addr v0, v3

    invoke-direct {p0}, Lcom/jibo/ui/view/TouchImageView;->getImageHeight()F

    move-result v4

    div-float/2addr v0, v4

    .line 1086
    if-eqz p3, :cond_0

    .line 1087
    invoke-static {v1, v5}, Ljava/lang/Math;->max(FF)F

    move-result v1

    invoke-static {v1, v2}, Ljava/lang/Math;->min(FF)F

    move-result v1

    .line 1088
    invoke-static {v0, v5}, Ljava/lang/Math;->max(FF)F

    move-result v0

    invoke-static {v0, v3}, Ljava/lang/Math;->min(FF)F

    move-result v0

    .line 1091
    :cond_0
    new-instance v2, Landroid/graphics/PointF;

    invoke-direct {v2, v1, v0}, Landroid/graphics/PointF;-><init>(FF)V

    return-object v2
.end method

.method static synthetic a(Lcom/jibo/ui/view/TouchImageView;FF)Landroid/graphics/PointF;
    .locals 1

    .prologue
    .line 40
    invoke-direct {p0, p1, p2}, Lcom/jibo/ui/view/TouchImageView;->a(FF)Landroid/graphics/PointF;

    move-result-object v0

    return-object v0
.end method

.method static synthetic a(Lcom/jibo/ui/view/TouchImageView;FFZ)Landroid/graphics/PointF;
    .locals 1

    .prologue
    .line 40
    invoke-direct {p0, p1, p2, p3}, Lcom/jibo/ui/view/TouchImageView;->a(FFZ)Landroid/graphics/PointF;

    move-result-object v0

    return-object v0
.end method

.method static synthetic a(Lcom/jibo/ui/view/TouchImageView;)Landroid/view/GestureDetector$OnDoubleTapListener;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/jibo/ui/view/TouchImageView;->z:Landroid/view/GestureDetector$OnDoubleTapListener;

    return-object v0
.end method

.method static synthetic a(Lcom/jibo/ui/view/TouchImageView;Lcom/jibo/ui/view/TouchImageView$Fling;)Lcom/jibo/ui/view/TouchImageView$Fling;
    .locals 0

    .prologue
    .line 40
    iput-object p1, p0, Lcom/jibo/ui/view/TouchImageView;->k:Lcom/jibo/ui/view/TouchImageView$Fling;

    return-object p1
.end method

.method private a(DFFZ)V
    .locals 7

    .prologue
    .line 944
    if-eqz p5, :cond_1

    .line 945
    iget v1, p0, Lcom/jibo/ui/view/TouchImageView;->g:F

    .line 946
    iget v0, p0, Lcom/jibo/ui/view/TouchImageView;->h:F

    .line 953
    :goto_0
    iget v2, p0, Lcom/jibo/ui/view/TouchImageView;->a:F

    .line 954
    iget v3, p0, Lcom/jibo/ui/view/TouchImageView;->a:F

    float-to-double v4, v3

    mul-double/2addr v4, p1

    double-to-float v3, v4

    iput v3, p0, Lcom/jibo/ui/view/TouchImageView;->a:F

    .line 955
    iget v3, p0, Lcom/jibo/ui/view/TouchImageView;->a:F

    cmpl-float v3, v3, v0

    if-lez v3, :cond_2

    .line 956
    iput v0, p0, Lcom/jibo/ui/view/TouchImageView;->a:F

    .line 957
    div-float/2addr v0, v2

    float-to-double p1, v0

    .line 963
    :cond_0
    :goto_1
    iget-object v0, p0, Lcom/jibo/ui/view/TouchImageView;->b:Landroid/graphics/Matrix;

    double-to-float v1, p1

    double-to-float v2, p1

    invoke-virtual {v0, v1, v2, p3, p4}, Landroid/graphics/Matrix;->postScale(FFFF)Z

    .line 964
    invoke-direct {p0}, Lcom/jibo/ui/view/TouchImageView;->e()V

    .line 965
    return-void

    .line 949
    :cond_1
    iget v1, p0, Lcom/jibo/ui/view/TouchImageView;->e:F

    .line 950
    iget v0, p0, Lcom/jibo/ui/view/TouchImageView;->f:F

    goto :goto_0

    .line 958
    :cond_2
    iget v0, p0, Lcom/jibo/ui/view/TouchImageView;->a:F

    cmpg-float v0, v0, v1

    if-gez v0, :cond_0

    .line 959
    iput v1, p0, Lcom/jibo/ui/view/TouchImageView;->a:F

    .line 960
    div-float v0, v1, v2

    float-to-double p1, v0

    goto :goto_1
.end method

.method private a(IFFFIII)V
    .locals 6

    .prologue
    const/high16 v5, 0x3f000000    # 0.5f

    .line 707
    int-to-float v0, p6

    cmpg-float v0, p4, v0

    if-gez v0, :cond_0

    .line 711
    iget-object v0, p0, Lcom/jibo/ui/view/TouchImageView;->i:[F

    int-to-float v1, p6

    int-to-float v2, p7

    iget-object v3, p0, Lcom/jibo/ui/view/TouchImageView;->i:[F

    const/4 v4, 0x0

    aget v3, v3, v4

    mul-float/2addr v2, v3

    sub-float/2addr v1, v2

    mul-float/2addr v1, v5

    aput v1, v0, p1

    .line 728
    :goto_0
    return-void

    .line 713
    :cond_0
    const/4 v0, 0x0

    cmpl-float v0, p2, v0

    if-lez v0, :cond_1

    .line 717
    iget-object v0, p0, Lcom/jibo/ui/view/TouchImageView;->i:[F

    int-to-float v1, p6

    sub-float v1, p4, v1

    mul-float/2addr v1, v5

    neg-float v1, v1

    aput v1, v0, p1

    goto :goto_0

    .line 725
    :cond_1
    invoke-static {p2}, Ljava/lang/Math;->abs(F)F

    move-result v0

    int-to-float v1, p5

    mul-float/2addr v1, v5

    add-float/2addr v0, v1

    div-float/2addr v0, p3

    .line 726
    iget-object v1, p0, Lcom/jibo/ui/view/TouchImageView;->i:[F

    mul-float/2addr v0, p4

    int-to-float v2, p6

    mul-float/2addr v2, v5

    sub-float/2addr v0, v2

    neg-float v0, v0

    aput v0, v1, p1

    goto :goto_0
.end method

.method private a(Landroid/content/Context;)V
    .locals 4

    .prologue
    const/high16 v3, 0x3f800000    # 1.0f

    const/4 v2, 0x0

    .line 117
    const/4 v0, 0x1

    invoke-super {p0, v0}, Landroid/widget/ImageView;->setClickable(Z)V

    .line 118
    iput-object p1, p0, Lcom/jibo/ui/view/TouchImageView;->j:Landroid/content/Context;

    .line 119
    new-instance v0, Landroid/view/ScaleGestureDetector;

    new-instance v1, Lcom/jibo/ui/view/TouchImageView$ScaleListener;

    invoke-direct {v1, p0, v2}, Lcom/jibo/ui/view/TouchImageView$ScaleListener;-><init>(Lcom/jibo/ui/view/TouchImageView;Lcom/jibo/ui/view/TouchImageView$1;)V

    invoke-direct {v0, p1, v1}, Landroid/view/ScaleGestureDetector;-><init>(Landroid/content/Context;Landroid/view/ScaleGestureDetector$OnScaleGestureListener;)V

    iput-object v0, p0, Lcom/jibo/ui/view/TouchImageView;->x:Landroid/view/ScaleGestureDetector;

    .line 120
    new-instance v0, Landroid/view/GestureDetector;

    new-instance v1, Lcom/jibo/ui/view/TouchImageView$GestureListener;

    invoke-direct {v1, p0, v2}, Lcom/jibo/ui/view/TouchImageView$GestureListener;-><init>(Lcom/jibo/ui/view/TouchImageView;Lcom/jibo/ui/view/TouchImageView$1;)V

    invoke-direct {v0, p1, v1}, Landroid/view/GestureDetector;-><init>(Landroid/content/Context;Landroid/view/GestureDetector$OnGestureListener;)V

    iput-object v0, p0, Lcom/jibo/ui/view/TouchImageView;->y:Landroid/view/GestureDetector;

    .line 121
    new-instance v0, Landroid/graphics/Matrix;

    invoke-direct {v0}, Landroid/graphics/Matrix;-><init>()V

    iput-object v0, p0, Lcom/jibo/ui/view/TouchImageView;->b:Landroid/graphics/Matrix;

    .line 122
    new-instance v0, Landroid/graphics/Matrix;

    invoke-direct {v0}, Landroid/graphics/Matrix;-><init>()V

    iput-object v0, p0, Lcom/jibo/ui/view/TouchImageView;->c:Landroid/graphics/Matrix;

    .line 123
    const/16 v0, 0x9

    new-array v0, v0, [F

    iput-object v0, p0, Lcom/jibo/ui/view/TouchImageView;->i:[F

    .line 124
    iput v3, p0, Lcom/jibo/ui/view/TouchImageView;->a:F

    .line 125
    iget-object v0, p0, Lcom/jibo/ui/view/TouchImageView;->l:Landroid/widget/ImageView$ScaleType;

    if-nez v0, :cond_0

    .line 126
    sget-object v0, Landroid/widget/ImageView$ScaleType;->FIT_CENTER:Landroid/widget/ImageView$ScaleType;

    iput-object v0, p0, Lcom/jibo/ui/view/TouchImageView;->l:Landroid/widget/ImageView$ScaleType;

    .line 128
    :cond_0
    iput v3, p0, Lcom/jibo/ui/view/TouchImageView;->e:F

    .line 129
    const/high16 v0, 0x40400000    # 3.0f

    iput v0, p0, Lcom/jibo/ui/view/TouchImageView;->f:F

    .line 130
    const/high16 v0, 0x3f400000    # 0.75f

    iget v1, p0, Lcom/jibo/ui/view/TouchImageView;->e:F

    mul-float/2addr v0, v1

    iput v0, p0, Lcom/jibo/ui/view/TouchImageView;->g:F

    .line 131
    const/high16 v0, 0x3fa00000    # 1.25f

    iget v1, p0, Lcom/jibo/ui/view/TouchImageView;->f:F

    mul-float/2addr v0, v1

    iput v0, p0, Lcom/jibo/ui/view/TouchImageView;->h:F

    .line 132
    iget-object v0, p0, Lcom/jibo/ui/view/TouchImageView;->b:Landroid/graphics/Matrix;

    invoke-virtual {p0, v0}, Lcom/jibo/ui/view/TouchImageView;->setImageMatrix(Landroid/graphics/Matrix;)V

    .line 133
    sget-object v0, Landroid/widget/ImageView$ScaleType;->MATRIX:Landroid/widget/ImageView$ScaleType;

    invoke-virtual {p0, v0}, Lcom/jibo/ui/view/TouchImageView;->setScaleType(Landroid/widget/ImageView$ScaleType;)V

    .line 134
    sget-object v0, Lcom/jibo/ui/view/TouchImageView$State;->NONE:Lcom/jibo/ui/view/TouchImageView$State;

    invoke-direct {p0, v0}, Lcom/jibo/ui/view/TouchImageView;->setState(Lcom/jibo/ui/view/TouchImageView$State;)V

    .line 135
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/jibo/ui/view/TouchImageView;->n:Z

    .line 136
    new-instance v0, Lcom/jibo/ui/view/TouchImageView$PrivateOnTouchListener;

    invoke-direct {v0, p0, v2}, Lcom/jibo/ui/view/TouchImageView$PrivateOnTouchListener;-><init>(Lcom/jibo/ui/view/TouchImageView;Lcom/jibo/ui/view/TouchImageView$1;)V

    invoke-super {p0, v0}, Landroid/widget/ImageView;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 137
    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/view/TouchImageView;DFFZ)V
    .locals 1

    .prologue
    .line 40
    invoke-direct/range {p0 .. p5}, Lcom/jibo/ui/view/TouchImageView;->a(DFFZ)V

    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/view/TouchImageView;Lcom/jibo/ui/view/TouchImageView$State;)V
    .locals 0

    .prologue
    .line 40
    invoke-direct {p0, p1}, Lcom/jibo/ui/view/TouchImageView;->setState(Lcom/jibo/ui/view/TouchImageView$State;)V

    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/view/TouchImageView;Ljava/lang/Runnable;)V
    .locals 0

    .prologue
    .line 40
    invoke-direct {p0, p1}, Lcom/jibo/ui/view/TouchImageView;->a(Ljava/lang/Runnable;)V

    return-void
.end method

.method private a(Ljava/lang/Runnable;)V
    .locals 2
    .annotation build Landroid/annotation/TargetApi;
        value = 0x10
    .end annotation

    .prologue
    .line 1262
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x10

    if-lt v0, v1, :cond_0

    .line 1263
    invoke-virtual {p0, p1}, Lcom/jibo/ui/view/TouchImageView;->postOnAnimation(Ljava/lang/Runnable;)V

    .line 1268
    :goto_0
    return-void

    .line 1266
    :cond_0
    const-wide/16 v0, 0x10

    invoke-virtual {p0, p1, v0, v1}, Lcom/jibo/ui/view/TouchImageView;->postDelayed(Ljava/lang/Runnable;J)Z

    goto :goto_0
.end method

.method private b(FFF)F
    .locals 4

    .prologue
    const/4 v0, 0x0

    .line 483
    cmpg-float v1, p3, p2

    if-gtz v1, :cond_1

    .line 485
    sub-float v1, p2, p3

    move v2, v0

    .line 492
    :goto_0
    cmpg-float v3, p1, v2

    if-gez v3, :cond_2

    .line 493
    neg-float v0, p1

    add-float/2addr v0, v2

    .line 496
    :cond_0
    :goto_1
    return v0

    .line 488
    :cond_1
    sub-float v1, p2, p3

    move v2, v1

    move v1, v0

    .line 489
    goto :goto_0

    .line 494
    :cond_2
    cmpl-float v2, p1, v1

    if-lez v2, :cond_0

    .line 495
    neg-float v0, p1

    add-float/2addr v0, v1

    goto :goto_1
.end method

.method static synthetic b(Lcom/jibo/ui/view/TouchImageView;)Lcom/jibo/ui/view/TouchImageView$Fling;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/jibo/ui/view/TouchImageView;->k:Lcom/jibo/ui/view/TouchImageView$Fling;

    return-object v0
.end method

.method private c(FFF)F
    .locals 1

    .prologue
    .line 500
    cmpg-float v0, p3, p2

    if-gtz v0, :cond_0

    .line 501
    const/4 p1, 0x0

    .line 503
    :cond_0
    return p1
.end method

.method static synthetic c(Lcom/jibo/ui/view/TouchImageView;)Lcom/jibo/ui/view/TouchImageView$State;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/jibo/ui/view/TouchImageView;->d:Lcom/jibo/ui/view/TouchImageView$State;

    return-object v0
.end method

.method private c()V
    .locals 2

    .prologue
    .line 235
    iget-object v0, p0, Lcom/jibo/ui/view/TouchImageView;->b:Landroid/graphics/Matrix;

    if-eqz v0, :cond_0

    iget v0, p0, Lcom/jibo/ui/view/TouchImageView;->q:I

    if-eqz v0, :cond_0

    iget v0, p0, Lcom/jibo/ui/view/TouchImageView;->p:I

    if-eqz v0, :cond_0

    .line 236
    iget-object v0, p0, Lcom/jibo/ui/view/TouchImageView;->b:Landroid/graphics/Matrix;

    iget-object v1, p0, Lcom/jibo/ui/view/TouchImageView;->i:[F

    invoke-virtual {v0, v1}, Landroid/graphics/Matrix;->getValues([F)V

    .line 237
    iget-object v0, p0, Lcom/jibo/ui/view/TouchImageView;->c:Landroid/graphics/Matrix;

    iget-object v1, p0, Lcom/jibo/ui/view/TouchImageView;->i:[F

    invoke-virtual {v0, v1}, Landroid/graphics/Matrix;->setValues([F)V

    .line 238
    iget v0, p0, Lcom/jibo/ui/view/TouchImageView;->u:F

    iput v0, p0, Lcom/jibo/ui/view/TouchImageView;->w:F

    .line 239
    iget v0, p0, Lcom/jibo/ui/view/TouchImageView;->t:F

    iput v0, p0, Lcom/jibo/ui/view/TouchImageView;->v:F

    .line 240
    iget v0, p0, Lcom/jibo/ui/view/TouchImageView;->q:I

    iput v0, p0, Lcom/jibo/ui/view/TouchImageView;->s:I

    .line 241
    iget v0, p0, Lcom/jibo/ui/view/TouchImageView;->p:I

    iput v0, p0, Lcom/jibo/ui/view/TouchImageView;->r:I

    .line 243
    :cond_0
    return-void
.end method

.method static synthetic d(Lcom/jibo/ui/view/TouchImageView;)F
    .locals 1

    .prologue
    .line 40
    iget v0, p0, Lcom/jibo/ui/view/TouchImageView;->a:F

    return v0
.end method

.method private d()V
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 448
    iget-object v0, p0, Lcom/jibo/ui/view/TouchImageView;->b:Landroid/graphics/Matrix;

    iget-object v1, p0, Lcom/jibo/ui/view/TouchImageView;->i:[F

    invoke-virtual {v0, v1}, Landroid/graphics/Matrix;->getValues([F)V

    .line 449
    iget-object v0, p0, Lcom/jibo/ui/view/TouchImageView;->i:[F

    const/4 v1, 0x2

    aget v0, v0, v1

    .line 450
    iget-object v1, p0, Lcom/jibo/ui/view/TouchImageView;->i:[F

    const/4 v2, 0x5

    aget v1, v1, v2

    .line 452
    iget v2, p0, Lcom/jibo/ui/view/TouchImageView;->p:I

    int-to-float v2, v2

    invoke-direct {p0}, Lcom/jibo/ui/view/TouchImageView;->getImageWidth()F

    move-result v3

    invoke-direct {p0, v0, v2, v3}, Lcom/jibo/ui/view/TouchImageView;->b(FFF)F

    move-result v0

    .line 453
    iget v2, p0, Lcom/jibo/ui/view/TouchImageView;->q:I

    int-to-float v2, v2

    invoke-direct {p0}, Lcom/jibo/ui/view/TouchImageView;->getImageHeight()F

    move-result v3

    invoke-direct {p0, v1, v2, v3}, Lcom/jibo/ui/view/TouchImageView;->b(FFF)F

    move-result v1

    .line 455
    cmpl-float v2, v0, v4

    if-nez v2, :cond_0

    cmpl-float v2, v1, v4

    if-eqz v2, :cond_1

    .line 456
    :cond_0
    iget-object v2, p0, Lcom/jibo/ui/view/TouchImageView;->b:Landroid/graphics/Matrix;

    invoke-virtual {v2, v0, v1}, Landroid/graphics/Matrix;->postTranslate(FF)Z

    .line 458
    :cond_1
    return-void
.end method

.method static synthetic e(Lcom/jibo/ui/view/TouchImageView;)F
    .locals 1

    .prologue
    .line 40
    iget v0, p0, Lcom/jibo/ui/view/TouchImageView;->e:F

    return v0
.end method

.method private e()V
    .locals 5

    .prologue
    const/high16 v4, 0x40000000    # 2.0f

    .line 468
    invoke-direct {p0}, Lcom/jibo/ui/view/TouchImageView;->d()V

    .line 469
    iget-object v0, p0, Lcom/jibo/ui/view/TouchImageView;->b:Landroid/graphics/Matrix;

    iget-object v1, p0, Lcom/jibo/ui/view/TouchImageView;->i:[F

    invoke-virtual {v0, v1}, Landroid/graphics/Matrix;->getValues([F)V

    .line 470
    invoke-direct {p0}, Lcom/jibo/ui/view/TouchImageView;->getImageWidth()F

    move-result v0

    iget v1, p0, Lcom/jibo/ui/view/TouchImageView;->p:I

    int-to-float v1, v1

    cmpg-float v0, v0, v1

    if-gez v0, :cond_0

    .line 471
    iget-object v0, p0, Lcom/jibo/ui/view/TouchImageView;->i:[F

    const/4 v1, 0x2

    iget v2, p0, Lcom/jibo/ui/view/TouchImageView;->p:I

    int-to-float v2, v2

    invoke-direct {p0}, Lcom/jibo/ui/view/TouchImageView;->getImageWidth()F

    move-result v3

    sub-float/2addr v2, v3

    div-float/2addr v2, v4

    aput v2, v0, v1

    .line 474
    :cond_0
    invoke-direct {p0}, Lcom/jibo/ui/view/TouchImageView;->getImageHeight()F

    move-result v0

    iget v1, p0, Lcom/jibo/ui/view/TouchImageView;->q:I

    int-to-float v1, v1

    cmpg-float v0, v0, v1

    if-gez v0, :cond_1

    .line 475
    iget-object v0, p0, Lcom/jibo/ui/view/TouchImageView;->i:[F

    const/4 v1, 0x5

    iget v2, p0, Lcom/jibo/ui/view/TouchImageView;->q:I

    int-to-float v2, v2

    invoke-direct {p0}, Lcom/jibo/ui/view/TouchImageView;->getImageHeight()F

    move-result v3

    sub-float/2addr v2, v3

    div-float/2addr v2, v4

    aput v2, v0, v1

    .line 477
    :cond_1
    iget-object v0, p0, Lcom/jibo/ui/view/TouchImageView;->b:Landroid/graphics/Matrix;

    iget-object v1, p0, Lcom/jibo/ui/view/TouchImageView;->i:[F

    invoke-virtual {v0, v1}, Landroid/graphics/Matrix;->setValues([F)V

    .line 478
    return-void
.end method

.method static synthetic f(Lcom/jibo/ui/view/TouchImageView;)F
    .locals 1

    .prologue
    .line 40
    iget v0, p0, Lcom/jibo/ui/view/TouchImageView;->f:F

    return v0
.end method

.method private f()V
    .locals 11

    .prologue
    const/4 v1, 0x2

    const/high16 v6, 0x40400000    # 3.0f

    const/high16 v10, 0x40000000    # 2.0f

    const/4 v9, 0x0

    const/high16 v3, 0x3f800000    # 1.0f

    .line 548
    invoke-virtual {p0}, Lcom/jibo/ui/view/TouchImageView;->getDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    .line 549
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    move-result v2

    if-eqz v2, :cond_0

    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->getIntrinsicHeight()I

    move-result v2

    if-nez v2, :cond_1

    .line 662
    :cond_0
    :goto_0
    return-void

    .line 552
    :cond_1
    iget-object v2, p0, Lcom/jibo/ui/view/TouchImageView;->b:Landroid/graphics/Matrix;

    if-eqz v2, :cond_0

    iget-object v2, p0, Lcom/jibo/ui/view/TouchImageView;->c:Landroid/graphics/Matrix;

    if-eqz v2, :cond_0

    .line 556
    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    move-result v7

    .line 557
    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->getIntrinsicHeight()I

    move-result v8

    .line 562
    iget v0, p0, Lcom/jibo/ui/view/TouchImageView;->p:I

    int-to-float v0, v0

    int-to-float v2, v7

    div-float v2, v0, v2

    .line 563
    iget v0, p0, Lcom/jibo/ui/view/TouchImageView;->q:I

    int-to-float v0, v0

    int-to-float v4, v8

    div-float/2addr v0, v4

    .line 566
    iget v4, p0, Lcom/jibo/ui/view/TouchImageView;->p:I

    iget v5, p0, Lcom/jibo/ui/view/TouchImageView;->q:I

    mul-int/2addr v4, v5

    int-to-float v4, v4

    mul-int v5, v7, v8

    int-to-float v5, v5

    div-float/2addr v4, v5

    .line 568
    cmpl-float v5, v4, v3

    if-lez v5, :cond_2

    .line 569
    invoke-virtual {p0, v6}, Lcom/jibo/ui/view/TouchImageView;->setMaxZoom(F)V

    .line 575
    :goto_1
    sget-object v4, Lcom/jibo/ui/view/TouchImageView$1;->a:[I

    iget-object v5, p0, Lcom/jibo/ui/view/TouchImageView;->l:Landroid/widget/ImageView$ScaleType;

    invoke-virtual {v5}, Landroid/widget/ImageView$ScaleType;->ordinal()I

    move-result v5

    aget v4, v4, v5

    packed-switch v4, :pswitch_data_0

    .line 598
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string v1, "TouchImageView does not support FIT_START or FIT_END"

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 572
    :cond_2
    div-float v4, v3, v4

    add-float/2addr v4, v6

    invoke-virtual {p0, v4}, Lcom/jibo/ui/view/TouchImageView;->setMaxZoom(F)V

    goto :goto_1

    :pswitch_0
    move v0, v3

    move v2, v3

    .line 605
    :goto_2
    :pswitch_1
    iget v4, p0, Lcom/jibo/ui/view/TouchImageView;->p:I

    int-to-float v4, v4

    int-to-float v5, v7

    mul-float/2addr v5, v2

    sub-float/2addr v4, v5

    .line 606
    iget v5, p0, Lcom/jibo/ui/view/TouchImageView;->q:I

    int-to-float v5, v5

    int-to-float v6, v8

    mul-float/2addr v6, v0

    sub-float/2addr v5, v6

    .line 607
    iget v6, p0, Lcom/jibo/ui/view/TouchImageView;->p:I

    int-to-float v6, v6

    sub-float/2addr v6, v4

    iput v6, p0, Lcom/jibo/ui/view/TouchImageView;->t:F

    .line 608
    iget v6, p0, Lcom/jibo/ui/view/TouchImageView;->q:I

    int-to-float v6, v6

    sub-float/2addr v6, v5

    iput v6, p0, Lcom/jibo/ui/view/TouchImageView;->u:F

    .line 609
    invoke-virtual {p0}, Lcom/jibo/ui/view/TouchImageView;->a()Z

    move-result v6

    if-nez v6, :cond_3

    iget-boolean v6, p0, Lcom/jibo/ui/view/TouchImageView;->m:Z

    if-nez v6, :cond_3

    .line 613
    iget-object v1, p0, Lcom/jibo/ui/view/TouchImageView;->b:Landroid/graphics/Matrix;

    invoke-virtual {v1, v2, v0}, Landroid/graphics/Matrix;->setScale(FF)V

    .line 614
    iget-object v0, p0, Lcom/jibo/ui/view/TouchImageView;->b:Landroid/graphics/Matrix;

    div-float v1, v4, v10

    div-float v2, v5, v10

    invoke-virtual {v0, v1, v2}, Landroid/graphics/Matrix;->postTranslate(FF)Z

    .line 615
    iput v3, p0, Lcom/jibo/ui/view/TouchImageView;->a:F

    .line 660
    :goto_3
    invoke-direct {p0}, Lcom/jibo/ui/view/TouchImageView;->d()V

    .line 661
    iget-object v0, p0, Lcom/jibo/ui/view/TouchImageView;->b:Landroid/graphics/Matrix;

    invoke-virtual {p0, v0}, Lcom/jibo/ui/view/TouchImageView;->setImageMatrix(Landroid/graphics/Matrix;)V

    goto/16 :goto_0

    .line 581
    :pswitch_2
    invoke-static {v2, v0}, Ljava/lang/Math;->max(FF)F

    move-result v0

    move v2, v0

    .line 582
    goto :goto_2

    .line 585
    :pswitch_3
    invoke-static {v2, v0}, Ljava/lang/Math;->min(FF)F

    move-result v0

    invoke-static {v3, v0}, Ljava/lang/Math;->min(FF)F

    move-result v0

    move v2, v0

    .line 588
    :pswitch_4
    invoke-static {v2, v0}, Ljava/lang/Math;->min(FF)F

    move-result v0

    move v2, v0

    .line 589
    goto :goto_2

    .line 623
    :cond_3
    iget v0, p0, Lcom/jibo/ui/view/TouchImageView;->v:F

    cmpl-float v0, v0, v9

    if-eqz v0, :cond_4

    iget v0, p0, Lcom/jibo/ui/view/TouchImageView;->w:F

    cmpl-float v0, v0, v9

    if-nez v0, :cond_5

    .line 624
    :cond_4
    invoke-direct {p0}, Lcom/jibo/ui/view/TouchImageView;->c()V

    .line 627
    :cond_5
    iget-object v0, p0, Lcom/jibo/ui/view/TouchImageView;->c:Landroid/graphics/Matrix;

    iget-object v2, p0, Lcom/jibo/ui/view/TouchImageView;->i:[F

    invoke-virtual {v0, v2}, Landroid/graphics/Matrix;->getValues([F)V

    .line 632
    iget-object v0, p0, Lcom/jibo/ui/view/TouchImageView;->i:[F

    const/4 v2, 0x0

    iget v3, p0, Lcom/jibo/ui/view/TouchImageView;->t:F

    int-to-float v4, v7

    div-float/2addr v3, v4

    iget v4, p0, Lcom/jibo/ui/view/TouchImageView;->a:F

    mul-float/2addr v3, v4

    aput v3, v0, v2

    .line 633
    iget-object v0, p0, Lcom/jibo/ui/view/TouchImageView;->i:[F

    const/4 v2, 0x4

    iget v3, p0, Lcom/jibo/ui/view/TouchImageView;->u:F

    int-to-float v4, v8

    div-float/2addr v3, v4

    iget v4, p0, Lcom/jibo/ui/view/TouchImageView;->a:F

    mul-float/2addr v3, v4

    aput v3, v0, v2

    .line 638
    iget-object v0, p0, Lcom/jibo/ui/view/TouchImageView;->i:[F

    aget v2, v0, v1

    .line 639
    iget-object v0, p0, Lcom/jibo/ui/view/TouchImageView;->i:[F

    const/4 v3, 0x5

    aget v9, v0, v3

    .line 644
    iget v0, p0, Lcom/jibo/ui/view/TouchImageView;->v:F

    iget v3, p0, Lcom/jibo/ui/view/TouchImageView;->a:F

    mul-float/2addr v3, v0

    .line 645
    invoke-direct {p0}, Lcom/jibo/ui/view/TouchImageView;->getImageWidth()F

    move-result v4

    .line 646
    iget v5, p0, Lcom/jibo/ui/view/TouchImageView;->r:I

    iget v6, p0, Lcom/jibo/ui/view/TouchImageView;->p:I

    move-object v0, p0

    invoke-direct/range {v0 .. v7}, Lcom/jibo/ui/view/TouchImageView;->a(IFFFIII)V

    .line 651
    iget v0, p0, Lcom/jibo/ui/view/TouchImageView;->w:F

    iget v1, p0, Lcom/jibo/ui/view/TouchImageView;->a:F

    mul-float v3, v0, v1

    .line 652
    invoke-direct {p0}, Lcom/jibo/ui/view/TouchImageView;->getImageHeight()F

    move-result v4

    .line 653
    const/4 v1, 0x5

    iget v5, p0, Lcom/jibo/ui/view/TouchImageView;->s:I

    iget v6, p0, Lcom/jibo/ui/view/TouchImageView;->q:I

    move-object v0, p0

    move v2, v9

    move v7, v8

    invoke-direct/range {v0 .. v7}, Lcom/jibo/ui/view/TouchImageView;->a(IFFFIII)V

    .line 658
    iget-object v0, p0, Lcom/jibo/ui/view/TouchImageView;->b:Landroid/graphics/Matrix;

    iget-object v1, p0, Lcom/jibo/ui/view/TouchImageView;->i:[F

    invoke-virtual {v0, v1}, Landroid/graphics/Matrix;->setValues([F)V

    goto/16 :goto_3

    .line 575
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_1
    .end packed-switch
.end method

.method static synthetic g(Lcom/jibo/ui/view/TouchImageView;)Landroid/view/ScaleGestureDetector;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/jibo/ui/view/TouchImageView;->x:Landroid/view/ScaleGestureDetector;

    return-object v0
.end method

.method private getImageHeight()F
    .locals 2

    .prologue
    .line 511
    iget v0, p0, Lcom/jibo/ui/view/TouchImageView;->u:F

    iget v1, p0, Lcom/jibo/ui/view/TouchImageView;->a:F

    mul-float/2addr v0, v1

    return v0
.end method

.method private getImageWidth()F
    .locals 2

    .prologue
    .line 507
    iget v0, p0, Lcom/jibo/ui/view/TouchImageView;->t:F

    iget v1, p0, Lcom/jibo/ui/view/TouchImageView;->a:F

    mul-float/2addr v0, v1

    return v0
.end method

.method static synthetic h(Lcom/jibo/ui/view/TouchImageView;)Landroid/view/GestureDetector;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/jibo/ui/view/TouchImageView;->y:Landroid/view/GestureDetector;

    return-object v0
.end method

.method static synthetic i(Lcom/jibo/ui/view/TouchImageView;)I
    .locals 1

    .prologue
    .line 40
    iget v0, p0, Lcom/jibo/ui/view/TouchImageView;->p:I

    return v0
.end method

.method static synthetic j(Lcom/jibo/ui/view/TouchImageView;)F
    .locals 1

    .prologue
    .line 40
    invoke-direct {p0}, Lcom/jibo/ui/view/TouchImageView;->getImageWidth()F

    move-result v0

    return v0
.end method

.method static synthetic k(Lcom/jibo/ui/view/TouchImageView;)I
    .locals 1

    .prologue
    .line 40
    iget v0, p0, Lcom/jibo/ui/view/TouchImageView;->q:I

    return v0
.end method

.method static synthetic l(Lcom/jibo/ui/view/TouchImageView;)F
    .locals 1

    .prologue
    .line 40
    invoke-direct {p0}, Lcom/jibo/ui/view/TouchImageView;->getImageHeight()F

    move-result v0

    return v0
.end method

.method static synthetic m(Lcom/jibo/ui/view/TouchImageView;)Landroid/graphics/Matrix;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/jibo/ui/view/TouchImageView;->b:Landroid/graphics/Matrix;

    return-object v0
.end method

.method static synthetic n(Lcom/jibo/ui/view/TouchImageView;)V
    .locals 0

    .prologue
    .line 40
    invoke-direct {p0}, Lcom/jibo/ui/view/TouchImageView;->d()V

    return-void
.end method

.method static synthetic o(Lcom/jibo/ui/view/TouchImageView;)Landroid/view/View$OnTouchListener;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/jibo/ui/view/TouchImageView;->A:Landroid/view/View$OnTouchListener;

    return-object v0
.end method

.method static synthetic p(Lcom/jibo/ui/view/TouchImageView;)Lcom/jibo/ui/view/TouchImageView$OnTouchImageViewListener;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/jibo/ui/view/TouchImageView;->B:Lcom/jibo/ui/view/TouchImageView$OnTouchImageViewListener;

    return-object v0
.end method

.method static synthetic q(Lcom/jibo/ui/view/TouchImageView;)V
    .locals 0

    .prologue
    .line 40
    invoke-direct {p0}, Lcom/jibo/ui/view/TouchImageView;->e()V

    return-void
.end method

.method static synthetic r(Lcom/jibo/ui/view/TouchImageView;)Landroid/content/Context;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/jibo/ui/view/TouchImageView;->j:Landroid/content/Context;

    return-object v0
.end method

.method static synthetic s(Lcom/jibo/ui/view/TouchImageView;)[F
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/jibo/ui/view/TouchImageView;->i:[F

    return-object v0
.end method

.method private setState(Lcom/jibo/ui/view/TouchImageView$State;)V
    .locals 0

    .prologue
    .line 731
    iput-object p1, p0, Lcom/jibo/ui/view/TouchImageView;->d:Lcom/jibo/ui/view/TouchImageView$State;

    .line 732
    return-void
.end method


# virtual methods
.method public a(FFF)V
    .locals 1

    .prologue
    .line 365
    iget-object v0, p0, Lcom/jibo/ui/view/TouchImageView;->l:Landroid/widget/ImageView$ScaleType;

    invoke-virtual {p0, p1, p2, p3, v0}, Lcom/jibo/ui/view/TouchImageView;->a(FFFLandroid/widget/ImageView$ScaleType;)V

    .line 366
    return-void
.end method

.method public a(FFFLandroid/widget/ImageView$ScaleType;)V
    .locals 8

    .prologue
    const/high16 v7, 0x3f000000    # 0.5f

    .line 384
    iget-boolean v0, p0, Lcom/jibo/ui/view/TouchImageView;->n:Z

    if-nez v0, :cond_0

    .line 385
    new-instance v0, Lcom/jibo/ui/view/TouchImageView$ZoomVariables;

    move-object v1, p0

    move v2, p1

    move v3, p2

    move v4, p3

    move-object v5, p4

    invoke-direct/range {v0 .. v5}, Lcom/jibo/ui/view/TouchImageView$ZoomVariables;-><init>(Lcom/jibo/ui/view/TouchImageView;FFFLandroid/widget/ImageView$ScaleType;)V

    iput-object v0, p0, Lcom/jibo/ui/view/TouchImageView;->o:Lcom/jibo/ui/view/TouchImageView$ZoomVariables;

    .line 400
    :goto_0
    return-void

    .line 389
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/view/TouchImageView;->l:Landroid/widget/ImageView$ScaleType;

    if-eq p4, v0, :cond_1

    .line 390
    invoke-virtual {p0, p4}, Lcom/jibo/ui/view/TouchImageView;->setScaleType(Landroid/widget/ImageView$ScaleType;)V

    .line 392
    :cond_1
    invoke-virtual {p0}, Lcom/jibo/ui/view/TouchImageView;->b()V

    .line 393
    float-to-double v2, p1

    iget v0, p0, Lcom/jibo/ui/view/TouchImageView;->p:I

    div-int/lit8 v0, v0, 0x2

    int-to-float v4, v0

    iget v0, p0, Lcom/jibo/ui/view/TouchImageView;->q:I

    div-int/lit8 v0, v0, 0x2

    int-to-float v5, v0

    const/4 v6, 0x1

    move-object v1, p0

    invoke-direct/range {v1 .. v6}, Lcom/jibo/ui/view/TouchImageView;->a(DFFZ)V

    .line 394
    iget-object v0, p0, Lcom/jibo/ui/view/TouchImageView;->b:Landroid/graphics/Matrix;

    iget-object v1, p0, Lcom/jibo/ui/view/TouchImageView;->i:[F

    invoke-virtual {v0, v1}, Landroid/graphics/Matrix;->getValues([F)V

    .line 395
    iget-object v0, p0, Lcom/jibo/ui/view/TouchImageView;->i:[F

    const/4 v1, 0x2

    invoke-direct {p0}, Lcom/jibo/ui/view/TouchImageView;->getImageWidth()F

    move-result v2

    mul-float/2addr v2, p2

    iget v3, p0, Lcom/jibo/ui/view/TouchImageView;->p:I

    int-to-float v3, v3

    mul-float/2addr v3, v7

    sub-float/2addr v2, v3

    neg-float v2, v2

    aput v2, v0, v1

    .line 396
    iget-object v0, p0, Lcom/jibo/ui/view/TouchImageView;->i:[F

    const/4 v1, 0x5

    invoke-direct {p0}, Lcom/jibo/ui/view/TouchImageView;->getImageHeight()F

    move-result v2

    mul-float/2addr v2, p3

    iget v3, p0, Lcom/jibo/ui/view/TouchImageView;->q:I

    int-to-float v3, v3

    mul-float/2addr v3, v7

    sub-float/2addr v2, v3

    neg-float v2, v2

    aput v2, v0, v1

    .line 397
    iget-object v0, p0, Lcom/jibo/ui/view/TouchImageView;->b:Landroid/graphics/Matrix;

    iget-object v1, p0, Lcom/jibo/ui/view/TouchImageView;->i:[F

    invoke-virtual {v0, v1}, Landroid/graphics/Matrix;->setValues([F)V

    .line 398
    invoke-direct {p0}, Lcom/jibo/ui/view/TouchImageView;->d()V

    .line 399
    iget-object v0, p0, Lcom/jibo/ui/view/TouchImageView;->b:Landroid/graphics/Matrix;

    invoke-virtual {p0, v0}, Lcom/jibo/ui/view/TouchImageView;->setImageMatrix(Landroid/graphics/Matrix;)V

    goto :goto_0
.end method

.method public a()Z
    .locals 2

    .prologue
    .line 211
    iget v0, p0, Lcom/jibo/ui/view/TouchImageView;->a:F

    const/high16 v1, 0x3f800000    # 1.0f

    cmpl-float v0, v0, v1

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public a(I)Z
    .locals 1

    .prologue
    .line 735
    invoke-virtual {p0, p1}, Lcom/jibo/ui/view/TouchImageView;->canScrollHorizontally(I)Z

    move-result v0

    return v0
.end method

.method public b()V
    .locals 1

    .prologue
    .line 343
    const/high16 v0, 0x3f800000    # 1.0f

    iput v0, p0, Lcom/jibo/ui/view/TouchImageView;->a:F

    .line 344
    invoke-direct {p0}, Lcom/jibo/ui/view/TouchImageView;->f()V

    .line 345
    return-void
.end method

.method public canScrollHorizontally(I)Z
    .locals 4

    .prologue
    const/4 v0, 0x0

    .line 740
    iget-object v1, p0, Lcom/jibo/ui/view/TouchImageView;->b:Landroid/graphics/Matrix;

    iget-object v2, p0, Lcom/jibo/ui/view/TouchImageView;->i:[F

    invoke-virtual {v1, v2}, Landroid/graphics/Matrix;->getValues([F)V

    .line 741
    iget-object v1, p0, Lcom/jibo/ui/view/TouchImageView;->i:[F

    const/4 v2, 0x2

    aget v1, v1, v2

    .line 743
    invoke-direct {p0}, Lcom/jibo/ui/view/TouchImageView;->getImageWidth()F

    move-result v2

    iget v3, p0, Lcom/jibo/ui/view/TouchImageView;->p:I

    int-to-float v3, v3

    cmpg-float v2, v2, v3

    if-gez v2, :cond_1

    .line 753
    :cond_0
    :goto_0
    return v0

    .line 746
    :cond_1
    const/high16 v2, -0x40800000    # -1.0f

    cmpl-float v2, v1, v2

    if-ltz v2, :cond_2

    if-ltz p1, :cond_0

    .line 749
    :cond_2
    invoke-static {v1}, Ljava/lang/Math;->abs(F)F

    move-result v1

    iget v2, p0, Lcom/jibo/ui/view/TouchImageView;->p:I

    int-to-float v2, v2

    add-float/2addr v1, v2

    const/high16 v2, 0x3f800000    # 1.0f

    add-float/2addr v1, v2

    invoke-direct {p0}, Lcom/jibo/ui/view/TouchImageView;->getImageWidth()F

    move-result v2

    cmpl-float v1, v1, v2

    if-ltz v1, :cond_3

    if-gtz p1, :cond_0

    .line 753
    :cond_3
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public getCurrentZoom()F
    .locals 1

    .prologue
    .line 327
    iget v0, p0, Lcom/jibo/ui/view/TouchImageView;->a:F

    return v0
.end method

.method public getMaxZoom()F
    .locals 1

    .prologue
    .line 301
    iget v0, p0, Lcom/jibo/ui/view/TouchImageView;->f:F

    return v0
.end method

.method public getMinZoom()F
    .locals 1

    .prologue
    .line 318
    iget v0, p0, Lcom/jibo/ui/view/TouchImageView;->e:F

    return v0
.end method

.method public getScaleType()Landroid/widget/ImageView$ScaleType;
    .locals 1

    .prologue
    .line 203
    iget-object v0, p0, Lcom/jibo/ui/view/TouchImageView;->l:Landroid/widget/ImageView$ScaleType;

    return-object v0
.end method

.method public getScrollPosition()Landroid/graphics/PointF;
    .locals 5

    .prologue
    .line 420
    invoke-virtual {p0}, Lcom/jibo/ui/view/TouchImageView;->getDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    .line 421
    if-nez v0, :cond_0

    .line 422
    const/4 v0, 0x0

    .line 430
    :goto_0
    return-object v0

    .line 424
    :cond_0
    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    move-result v1

    .line 425
    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->getIntrinsicHeight()I

    move-result v2

    .line 427
    iget v0, p0, Lcom/jibo/ui/view/TouchImageView;->p:I

    div-int/lit8 v0, v0, 0x2

    int-to-float v0, v0

    iget v3, p0, Lcom/jibo/ui/view/TouchImageView;->q:I

    div-int/lit8 v3, v3, 0x2

    int-to-float v3, v3

    const/4 v4, 0x1

    invoke-direct {p0, v0, v3, v4}, Lcom/jibo/ui/view/TouchImageView;->a(FFZ)Landroid/graphics/PointF;

    move-result-object v0

    .line 428
    iget v3, v0, Landroid/graphics/PointF;->x:F

    int-to-float v1, v1

    div-float v1, v3, v1

    iput v1, v0, Landroid/graphics/PointF;->x:F

    .line 429
    iget v1, v0, Landroid/graphics/PointF;->y:F

    int-to-float v2, v2

    div-float/2addr v1, v2

    iput v1, v0, Landroid/graphics/PointF;->y:F

    goto :goto_0
.end method

.method public getZoomedRect()Landroid/graphics/RectF;
    .locals 7

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 219
    iget-object v0, p0, Lcom/jibo/ui/view/TouchImageView;->l:Landroid/widget/ImageView$ScaleType;

    sget-object v1, Landroid/widget/ImageView$ScaleType;->FIT_XY:Landroid/widget/ImageView$ScaleType;

    if-ne v0, v1, :cond_0

    .line 220
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string v1, "getZoomedRect() not supported with FIT_XY"

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 222
    :cond_0
    invoke-direct {p0, v2, v2, v3}, Lcom/jibo/ui/view/TouchImageView;->a(FFZ)Landroid/graphics/PointF;

    move-result-object v0

    .line 223
    iget v1, p0, Lcom/jibo/ui/view/TouchImageView;->p:I

    int-to-float v1, v1

    iget v2, p0, Lcom/jibo/ui/view/TouchImageView;->q:I

    int-to-float v2, v2

    invoke-direct {p0, v1, v2, v3}, Lcom/jibo/ui/view/TouchImageView;->a(FFZ)Landroid/graphics/PointF;

    move-result-object v1

    .line 225
    invoke-virtual {p0}, Lcom/jibo/ui/view/TouchImageView;->getDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v2

    invoke-virtual {v2}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    move-result v2

    int-to-float v2, v2

    .line 226
    invoke-virtual {p0}, Lcom/jibo/ui/view/TouchImageView;->getDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v3

    invoke-virtual {v3}, Landroid/graphics/drawable/Drawable;->getIntrinsicHeight()I

    move-result v3

    int-to-float v3, v3

    .line 227
    new-instance v4, Landroid/graphics/RectF;

    iget v5, v0, Landroid/graphics/PointF;->x:F

    div-float/2addr v5, v2

    iget v0, v0, Landroid/graphics/PointF;->y:F

    div-float/2addr v0, v3

    iget v6, v1, Landroid/graphics/PointF;->x:F

    div-float v2, v6, v2

    iget v1, v1, Landroid/graphics/PointF;->y:F

    div-float/2addr v1, v3

    invoke-direct {v4, v5, v0, v2, v1}, Landroid/graphics/RectF;-><init>(FFFF)V

    return-object v4
.end method

.method public onConfigurationChanged(Landroid/content/res/Configuration;)V
    .locals 0

    .prologue
    .line 292
    invoke-super {p0, p1}, Landroid/widget/ImageView;->onConfigurationChanged(Landroid/content/res/Configuration;)V

    .line 293
    invoke-direct {p0}, Lcom/jibo/ui/view/TouchImageView;->c()V

    .line 294
    return-void
.end method

.method protected onDraw(Landroid/graphics/Canvas;)V
    .locals 4

    .prologue
    const/4 v0, 0x1

    .line 281
    iput-boolean v0, p0, Lcom/jibo/ui/view/TouchImageView;->n:Z

    .line 282
    iput-boolean v0, p0, Lcom/jibo/ui/view/TouchImageView;->m:Z

    .line 283
    iget-object v0, p0, Lcom/jibo/ui/view/TouchImageView;->o:Lcom/jibo/ui/view/TouchImageView$ZoomVariables;

    if-eqz v0, :cond_0

    .line 284
    iget-object v0, p0, Lcom/jibo/ui/view/TouchImageView;->o:Lcom/jibo/ui/view/TouchImageView$ZoomVariables;

    iget v0, v0, Lcom/jibo/ui/view/TouchImageView$ZoomVariables;->a:F

    iget-object v1, p0, Lcom/jibo/ui/view/TouchImageView;->o:Lcom/jibo/ui/view/TouchImageView$ZoomVariables;

    iget v1, v1, Lcom/jibo/ui/view/TouchImageView$ZoomVariables;->b:F

    iget-object v2, p0, Lcom/jibo/ui/view/TouchImageView;->o:Lcom/jibo/ui/view/TouchImageView$ZoomVariables;

    iget v2, v2, Lcom/jibo/ui/view/TouchImageView$ZoomVariables;->c:F

    iget-object v3, p0, Lcom/jibo/ui/view/TouchImageView;->o:Lcom/jibo/ui/view/TouchImageView$ZoomVariables;

    iget-object v3, v3, Lcom/jibo/ui/view/TouchImageView$ZoomVariables;->d:Landroid/widget/ImageView$ScaleType;

    invoke-virtual {p0, v0, v1, v2, v3}, Lcom/jibo/ui/view/TouchImageView;->a(FFFLandroid/widget/ImageView$ScaleType;)V

    .line 285
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/jibo/ui/view/TouchImageView;->o:Lcom/jibo/ui/view/TouchImageView$ZoomVariables;

    .line 287
    :cond_0
    invoke-super {p0, p1}, Landroid/widget/ImageView;->onDraw(Landroid/graphics/Canvas;)V

    .line 288
    return-void
.end method

.method protected onMeasure(II)V
    .locals 4

    .prologue
    .line 516
    invoke-virtual {p0}, Lcom/jibo/ui/view/TouchImageView;->getDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    .line 517
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    move-result v1

    if-eqz v1, :cond_0

    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->getIntrinsicHeight()I

    move-result v0

    if-nez v0, :cond_3

    .line 518
    :cond_0
    invoke-static {p1}, Landroid/view/View$MeasureSpec;->getSize(I)I

    move-result v0

    iput v0, p0, Lcom/jibo/ui/view/TouchImageView;->p:I

    .line 519
    invoke-static {p2}, Landroid/view/View$MeasureSpec;->getSize(I)I

    move-result v0

    iput v0, p0, Lcom/jibo/ui/view/TouchImageView;->q:I

    .line 520
    iget v0, p0, Lcom/jibo/ui/view/TouchImageView;->q:I

    invoke-virtual {p0}, Lcom/jibo/ui/view/TouchImageView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v1

    iget v1, v1, Landroid/view/ViewGroup$LayoutParams;->height:I

    if-ge v0, v1, :cond_2

    invoke-virtual {p0}, Lcom/jibo/ui/view/TouchImageView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    iget v0, v0, Landroid/view/ViewGroup$LayoutParams;->height:I

    :goto_0
    iput v0, p0, Lcom/jibo/ui/view/TouchImageView;->q:I

    .line 521
    iget v0, p0, Lcom/jibo/ui/view/TouchImageView;->p:I

    iget v1, p0, Lcom/jibo/ui/view/TouchImageView;->q:I

    invoke-virtual {p0, v0, v1}, Lcom/jibo/ui/view/TouchImageView;->setMeasuredDimension(II)V

    .line 540
    :cond_1
    :goto_1
    return-void

    .line 520
    :cond_2
    iget v0, p0, Lcom/jibo/ui/view/TouchImageView;->q:I

    goto :goto_0

    .line 525
    :cond_3
    iget v1, p0, Lcom/jibo/ui/view/TouchImageView;->p:I

    .line 526
    iget v2, p0, Lcom/jibo/ui/view/TouchImageView;->q:I

    .line 527
    invoke-static {p1}, Landroid/view/View$MeasureSpec;->getSize(I)I

    move-result v0

    iput v0, p0, Lcom/jibo/ui/view/TouchImageView;->p:I

    .line 528
    invoke-static {p2}, Landroid/view/View$MeasureSpec;->getSize(I)I

    move-result v0

    iput v0, p0, Lcom/jibo/ui/view/TouchImageView;->q:I

    .line 529
    iget v0, p0, Lcom/jibo/ui/view/TouchImageView;->q:I

    invoke-virtual {p0}, Lcom/jibo/ui/view/TouchImageView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v3

    iget v3, v3, Landroid/view/ViewGroup$LayoutParams;->height:I

    if-ge v0, v3, :cond_5

    invoke-virtual {p0}, Lcom/jibo/ui/view/TouchImageView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    iget v0, v0, Landroid/view/ViewGroup$LayoutParams;->height:I

    :goto_2
    iput v0, p0, Lcom/jibo/ui/view/TouchImageView;->q:I

    .line 534
    iget v0, p0, Lcom/jibo/ui/view/TouchImageView;->p:I

    iget v3, p0, Lcom/jibo/ui/view/TouchImageView;->q:I

    invoke-virtual {p0, v0, v3}, Lcom/jibo/ui/view/TouchImageView;->setMeasuredDimension(II)V

    .line 539
    iget v0, p0, Lcom/jibo/ui/view/TouchImageView;->p:I

    if-ne v1, v0, :cond_4

    iget v0, p0, Lcom/jibo/ui/view/TouchImageView;->q:I

    if-eq v2, v0, :cond_1

    :cond_4
    invoke-direct {p0}, Lcom/jibo/ui/view/TouchImageView;->f()V

    goto :goto_1

    .line 529
    :cond_5
    iget v0, p0, Lcom/jibo/ui/view/TouchImageView;->q:I

    goto :goto_2
.end method

.method public onRestoreInstanceState(Landroid/os/Parcelable;)V
    .locals 2

    .prologue
    .line 262
    instance-of v0, p1, Landroid/os/Bundle;

    if-eqz v0, :cond_0

    .line 263
    check-cast p1, Landroid/os/Bundle;

    .line 264
    const-string v0, "saveScale"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getFloat(Ljava/lang/String;)F

    move-result v0

    iput v0, p0, Lcom/jibo/ui/view/TouchImageView;->a:F

    .line 265
    const-string v0, "matrix"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getFloatArray(Ljava/lang/String;)[F

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/view/TouchImageView;->i:[F

    .line 266
    iget-object v0, p0, Lcom/jibo/ui/view/TouchImageView;->c:Landroid/graphics/Matrix;

    iget-object v1, p0, Lcom/jibo/ui/view/TouchImageView;->i:[F

    invoke-virtual {v0, v1}, Landroid/graphics/Matrix;->setValues([F)V

    .line 267
    const-string v0, "matchViewHeight"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getFloat(Ljava/lang/String;)F

    move-result v0

    iput v0, p0, Lcom/jibo/ui/view/TouchImageView;->w:F

    .line 268
    const-string v0, "matchViewWidth"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getFloat(Ljava/lang/String;)F

    move-result v0

    iput v0, p0, Lcom/jibo/ui/view/TouchImageView;->v:F

    .line 269
    const-string v0, "viewHeight"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/jibo/ui/view/TouchImageView;->s:I

    .line 270
    const-string v0, "viewWidth"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/jibo/ui/view/TouchImageView;->r:I

    .line 271
    const-string v0, "imageRendered"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/jibo/ui/view/TouchImageView;->m:Z

    .line 272
    const-string v0, "instanceState"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    invoke-super {p0, v0}, Landroid/widget/ImageView;->onRestoreInstanceState(Landroid/os/Parcelable;)V

    .line 277
    :goto_0
    return-void

    .line 276
    :cond_0
    invoke-super {p0, p1}, Landroid/widget/ImageView;->onRestoreInstanceState(Landroid/os/Parcelable;)V

    goto :goto_0
.end method

.method public onSaveInstanceState()Landroid/os/Parcelable;
    .locals 3

    .prologue
    .line 247
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 248
    const-string v1, "instanceState"

    invoke-super {p0}, Landroid/widget/ImageView;->onSaveInstanceState()Landroid/os/Parcelable;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 249
    const-string v1, "saveScale"

    iget v2, p0, Lcom/jibo/ui/view/TouchImageView;->a:F

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putFloat(Ljava/lang/String;F)V

    .line 250
    const-string v1, "matchViewHeight"

    iget v2, p0, Lcom/jibo/ui/view/TouchImageView;->u:F

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putFloat(Ljava/lang/String;F)V

    .line 251
    const-string v1, "matchViewWidth"

    iget v2, p0, Lcom/jibo/ui/view/TouchImageView;->t:F

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putFloat(Ljava/lang/String;F)V

    .line 252
    const-string v1, "viewWidth"

    iget v2, p0, Lcom/jibo/ui/view/TouchImageView;->p:I

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 253
    const-string v1, "viewHeight"

    iget v2, p0, Lcom/jibo/ui/view/TouchImageView;->q:I

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 254
    iget-object v1, p0, Lcom/jibo/ui/view/TouchImageView;->b:Landroid/graphics/Matrix;

    iget-object v2, p0, Lcom/jibo/ui/view/TouchImageView;->i:[F

    invoke-virtual {v1, v2}, Landroid/graphics/Matrix;->getValues([F)V

    .line 255
    const-string v1, "matrix"

    iget-object v2, p0, Lcom/jibo/ui/view/TouchImageView;->i:[F

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putFloatArray(Ljava/lang/String;[F)V

    .line 256
    const-string v1, "imageRendered"

    iget-boolean v2, p0, Lcom/jibo/ui/view/TouchImageView;->m:Z

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 257
    return-object v0
.end method

.method public setImageBitmap(Landroid/graphics/Bitmap;)V
    .locals 0

    .prologue
    .line 161
    invoke-super {p0, p1}, Landroid/widget/ImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V

    .line 162
    invoke-direct {p0}, Lcom/jibo/ui/view/TouchImageView;->c()V

    .line 163
    invoke-direct {p0}, Lcom/jibo/ui/view/TouchImageView;->f()V

    .line 164
    return-void
.end method

.method public setImageDrawable(Landroid/graphics/drawable/Drawable;)V
    .locals 0

    .prologue
    .line 168
    invoke-super {p0, p1}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 169
    invoke-direct {p0}, Lcom/jibo/ui/view/TouchImageView;->c()V

    .line 170
    invoke-direct {p0}, Lcom/jibo/ui/view/TouchImageView;->f()V

    .line 171
    return-void
.end method

.method public setImageResource(I)V
    .locals 0

    .prologue
    .line 154
    invoke-super {p0, p1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 155
    invoke-direct {p0}, Lcom/jibo/ui/view/TouchImageView;->c()V

    .line 156
    invoke-direct {p0}, Lcom/jibo/ui/view/TouchImageView;->f()V

    .line 157
    return-void
.end method

.method public setImageURI(Landroid/net/Uri;)V
    .locals 0

    .prologue
    .line 175
    invoke-super {p0, p1}, Landroid/widget/ImageView;->setImageURI(Landroid/net/Uri;)V

    .line 176
    invoke-direct {p0}, Lcom/jibo/ui/view/TouchImageView;->c()V

    .line 177
    invoke-direct {p0}, Lcom/jibo/ui/view/TouchImageView;->f()V

    .line 178
    return-void
.end method

.method public setMaxZoom(F)V
    .locals 2

    .prologue
    .line 309
    iput p1, p0, Lcom/jibo/ui/view/TouchImageView;->f:F

    .line 310
    const/high16 v0, 0x3fa00000    # 1.25f

    iget v1, p0, Lcom/jibo/ui/view/TouchImageView;->f:F

    mul-float/2addr v0, v1

    iput v0, p0, Lcom/jibo/ui/view/TouchImageView;->h:F

    .line 311
    return-void
.end method

.method public setMinZoom(F)V
    .locals 2

    .prologue
    .line 335
    iput p1, p0, Lcom/jibo/ui/view/TouchImageView;->e:F

    .line 336
    const/high16 v0, 0x3f400000    # 0.75f

    iget v1, p0, Lcom/jibo/ui/view/TouchImageView;->e:F

    mul-float/2addr v0, v1

    iput v0, p0, Lcom/jibo/ui/view/TouchImageView;->g:F

    .line 337
    return-void
.end method

.method public setOnDoubleTapListener(Landroid/view/GestureDetector$OnDoubleTapListener;)V
    .locals 0

    .prologue
    .line 149
    iput-object p1, p0, Lcom/jibo/ui/view/TouchImageView;->z:Landroid/view/GestureDetector$OnDoubleTapListener;

    .line 150
    return-void
.end method

.method public setOnTouchImageViewListener(Lcom/jibo/ui/view/TouchImageView$OnTouchImageViewListener;)V
    .locals 0

    .prologue
    .line 145
    iput-object p1, p0, Lcom/jibo/ui/view/TouchImageView;->B:Lcom/jibo/ui/view/TouchImageView$OnTouchImageViewListener;

    .line 146
    return-void
.end method

.method public setOnTouchListener(Landroid/view/View$OnTouchListener;)V
    .locals 0

    .prologue
    .line 141
    iput-object p1, p0, Lcom/jibo/ui/view/TouchImageView;->A:Landroid/view/View$OnTouchListener;

    .line 142
    return-void
.end method

.method public setScaleType(Landroid/widget/ImageView$ScaleType;)V
    .locals 3

    .prologue
    const/high16 v2, 0x3f000000    # 0.5f

    .line 182
    sget-object v0, Landroid/widget/ImageView$ScaleType;->FIT_START:Landroid/widget/ImageView$ScaleType;

    if-eq p1, v0, :cond_0

    sget-object v0, Landroid/widget/ImageView$ScaleType;->FIT_END:Landroid/widget/ImageView$ScaleType;

    if-ne p1, v0, :cond_1

    .line 183
    :cond_0
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string v1, "TouchImageView does not support FIT_START or FIT_END"

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 185
    :cond_1
    sget-object v0, Landroid/widget/ImageView$ScaleType;->MATRIX:Landroid/widget/ImageView$ScaleType;

    if-ne p1, v0, :cond_3

    .line 186
    sget-object v0, Landroid/widget/ImageView$ScaleType;->MATRIX:Landroid/widget/ImageView$ScaleType;

    invoke-super {p0, v0}, Landroid/widget/ImageView;->setScaleType(Landroid/widget/ImageView$ScaleType;)V

    .line 199
    :cond_2
    :goto_0
    return-void

    .line 189
    :cond_3
    iput-object p1, p0, Lcom/jibo/ui/view/TouchImageView;->l:Landroid/widget/ImageView$ScaleType;

    .line 190
    iget-boolean v0, p0, Lcom/jibo/ui/view/TouchImageView;->n:Z

    if-eqz v0, :cond_2

    .line 195
    const/high16 v0, 0x3f800000    # 1.0f

    invoke-virtual {p0}, Lcom/jibo/ui/view/TouchImageView;->getScaleType()Landroid/widget/ImageView$ScaleType;

    move-result-object v1

    invoke-virtual {p0, v0, v2, v2, v1}, Lcom/jibo/ui/view/TouchImageView;->a(FFFLandroid/widget/ImageView$ScaleType;)V

    goto :goto_0
.end method

.method public setZoom(F)V
    .locals 1

    .prologue
    const/high16 v0, 0x3f000000    # 0.5f

    .line 352
    invoke-virtual {p0, p1, v0, v0}, Lcom/jibo/ui/view/TouchImageView;->a(FFF)V

    .line 353
    return-void
.end method

.method public setZoom(Lcom/jibo/ui/view/TouchImageView;)V
    .locals 4

    .prologue
    .line 408
    invoke-virtual {p1}, Lcom/jibo/ui/view/TouchImageView;->getScrollPosition()Landroid/graphics/PointF;

    move-result-object v0

    .line 409
    invoke-virtual {p1}, Lcom/jibo/ui/view/TouchImageView;->getCurrentZoom()F

    move-result v1

    iget v2, v0, Landroid/graphics/PointF;->x:F

    iget v0, v0, Landroid/graphics/PointF;->y:F

    invoke-virtual {p1}, Lcom/jibo/ui/view/TouchImageView;->getScaleType()Landroid/widget/ImageView$ScaleType;

    move-result-object v3

    invoke-virtual {p0, v1, v2, v0, v3}, Lcom/jibo/ui/view/TouchImageView;->a(FFFLandroid/widget/ImageView$ScaleType;)V

    .line 410
    return-void
.end method
