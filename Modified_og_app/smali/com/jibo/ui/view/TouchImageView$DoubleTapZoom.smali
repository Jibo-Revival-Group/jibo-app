.class Lcom/jibo/ui/view/TouchImageView$DoubleTapZoom;
.super Ljava/lang/Object;
.source "TouchImageView.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/view/TouchImageView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "DoubleTapZoom"
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/view/TouchImageView;

.field private b:J

.field private c:F

.field private d:F

.field private e:F

.field private f:F

.field private g:Z

.field private h:Landroid/view/animation/AccelerateDecelerateInterpolator;

.field private i:Landroid/graphics/PointF;

.field private j:Landroid/graphics/PointF;


# direct methods
.method constructor <init>(Lcom/jibo/ui/view/TouchImageView;FFFZ)V
    .locals 3

    .prologue
    .line 984
    iput-object p1, p0, Lcom/jibo/ui/view/TouchImageView$DoubleTapZoom;->a:Lcom/jibo/ui/view/TouchImageView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 980
    new-instance v0, Landroid/view/animation/AccelerateDecelerateInterpolator;

    invoke-direct {v0}, Landroid/view/animation/AccelerateDecelerateInterpolator;-><init>()V

    iput-object v0, p0, Lcom/jibo/ui/view/TouchImageView$DoubleTapZoom;->h:Landroid/view/animation/AccelerateDecelerateInterpolator;

    .line 985
    sget-object v0, Lcom/jibo/ui/view/TouchImageView$State;->ANIMATE_ZOOM:Lcom/jibo/ui/view/TouchImageView$State;

    invoke-static {p1, v0}, Lcom/jibo/ui/view/TouchImageView;->a(Lcom/jibo/ui/view/TouchImageView;Lcom/jibo/ui/view/TouchImageView$State;)V

    .line 986
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/jibo/ui/view/TouchImageView$DoubleTapZoom;->b:J

    .line 987
    invoke-static {p1}, Lcom/jibo/ui/view/TouchImageView;->d(Lcom/jibo/ui/view/TouchImageView;)F

    move-result v0

    iput v0, p0, Lcom/jibo/ui/view/TouchImageView$DoubleTapZoom;->c:F

    .line 988
    iput p2, p0, Lcom/jibo/ui/view/TouchImageView$DoubleTapZoom;->d:F

    .line 989
    iput-boolean p5, p0, Lcom/jibo/ui/view/TouchImageView$DoubleTapZoom;->g:Z

    .line 990
    const/4 v0, 0x0

    invoke-static {p1, p3, p4, v0}, Lcom/jibo/ui/view/TouchImageView;->a(Lcom/jibo/ui/view/TouchImageView;FFZ)Landroid/graphics/PointF;

    move-result-object v0

    .line 991
    iget v1, v0, Landroid/graphics/PointF;->x:F

    iput v1, p0, Lcom/jibo/ui/view/TouchImageView$DoubleTapZoom;->e:F

    .line 992
    iget v0, v0, Landroid/graphics/PointF;->y:F

    iput v0, p0, Lcom/jibo/ui/view/TouchImageView$DoubleTapZoom;->f:F

    .line 997
    iget v0, p0, Lcom/jibo/ui/view/TouchImageView$DoubleTapZoom;->e:F

    iget v1, p0, Lcom/jibo/ui/view/TouchImageView$DoubleTapZoom;->f:F

    invoke-static {p1, v0, v1}, Lcom/jibo/ui/view/TouchImageView;->a(Lcom/jibo/ui/view/TouchImageView;FF)Landroid/graphics/PointF;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/view/TouchImageView$DoubleTapZoom;->i:Landroid/graphics/PointF;

    .line 998
    new-instance v0, Landroid/graphics/PointF;

    invoke-static {p1}, Lcom/jibo/ui/view/TouchImageView;->i(Lcom/jibo/ui/view/TouchImageView;)I

    move-result v1

    div-int/lit8 v1, v1, 0x2

    int-to-float v1, v1

    invoke-static {p1}, Lcom/jibo/ui/view/TouchImageView;->k(Lcom/jibo/ui/view/TouchImageView;)I

    move-result v2

    div-int/lit8 v2, v2, 0x2

    int-to-float v2, v2

    invoke-direct {v0, v1, v2}, Landroid/graphics/PointF;-><init>(FF)V

    iput-object v0, p0, Lcom/jibo/ui/view/TouchImageView$DoubleTapZoom;->j:Landroid/graphics/PointF;

    .line 999
    return-void
.end method

.method private a()F
    .locals 4

    .prologue
    .line 1050
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    .line 1051
    iget-wide v2, p0, Lcom/jibo/ui/view/TouchImageView$DoubleTapZoom;->b:J

    sub-long/2addr v0, v2

    long-to-float v0, v0

    const/high16 v1, 0x43fa0000    # 500.0f

    div-float/2addr v0, v1

    .line 1052
    const/high16 v1, 0x3f800000    # 1.0f

    invoke-static {v1, v0}, Ljava/lang/Math;->min(FF)F

    move-result v0

    .line 1053
    iget-object v1, p0, Lcom/jibo/ui/view/TouchImageView$DoubleTapZoom;->h:Landroid/view/animation/AccelerateDecelerateInterpolator;

    invoke-virtual {v1, v0}, Landroid/view/animation/AccelerateDecelerateInterpolator;->getInterpolation(F)F

    move-result v0

    return v0
.end method

.method private a(F)V
    .locals 5

    .prologue
    .line 1039
    iget-object v0, p0, Lcom/jibo/ui/view/TouchImageView$DoubleTapZoom;->i:Landroid/graphics/PointF;

    iget v0, v0, Landroid/graphics/PointF;->x:F

    iget-object v1, p0, Lcom/jibo/ui/view/TouchImageView$DoubleTapZoom;->j:Landroid/graphics/PointF;

    iget v1, v1, Landroid/graphics/PointF;->x:F

    iget-object v2, p0, Lcom/jibo/ui/view/TouchImageView$DoubleTapZoom;->i:Landroid/graphics/PointF;

    iget v2, v2, Landroid/graphics/PointF;->x:F

    sub-float/2addr v1, v2

    mul-float/2addr v1, p1

    add-float/2addr v0, v1

    .line 1040
    iget-object v1, p0, Lcom/jibo/ui/view/TouchImageView$DoubleTapZoom;->i:Landroid/graphics/PointF;

    iget v1, v1, Landroid/graphics/PointF;->y:F

    iget-object v2, p0, Lcom/jibo/ui/view/TouchImageView$DoubleTapZoom;->j:Landroid/graphics/PointF;

    iget v2, v2, Landroid/graphics/PointF;->y:F

    iget-object v3, p0, Lcom/jibo/ui/view/TouchImageView$DoubleTapZoom;->i:Landroid/graphics/PointF;

    iget v3, v3, Landroid/graphics/PointF;->y:F

    sub-float/2addr v2, v3

    mul-float/2addr v2, p1

    add-float/2addr v1, v2

    .line 1041
    iget-object v2, p0, Lcom/jibo/ui/view/TouchImageView$DoubleTapZoom;->a:Lcom/jibo/ui/view/TouchImageView;

    iget v3, p0, Lcom/jibo/ui/view/TouchImageView$DoubleTapZoom;->e:F

    iget v4, p0, Lcom/jibo/ui/view/TouchImageView$DoubleTapZoom;->f:F

    invoke-static {v2, v3, v4}, Lcom/jibo/ui/view/TouchImageView;->a(Lcom/jibo/ui/view/TouchImageView;FF)Landroid/graphics/PointF;

    move-result-object v2

    .line 1042
    iget-object v3, p0, Lcom/jibo/ui/view/TouchImageView$DoubleTapZoom;->a:Lcom/jibo/ui/view/TouchImageView;

    invoke-static {v3}, Lcom/jibo/ui/view/TouchImageView;->m(Lcom/jibo/ui/view/TouchImageView;)Landroid/graphics/Matrix;

    move-result-object v3

    iget v4, v2, Landroid/graphics/PointF;->x:F

    sub-float/2addr v0, v4

    iget v2, v2, Landroid/graphics/PointF;->y:F

    sub-float/2addr v1, v2

    invoke-virtual {v3, v0, v1}, Landroid/graphics/Matrix;->postTranslate(FF)Z

    .line 1043
    return-void
.end method

.method private b(F)D
    .locals 4

    .prologue
    .line 1063
    iget v0, p0, Lcom/jibo/ui/view/TouchImageView$DoubleTapZoom;->c:F

    iget v1, p0, Lcom/jibo/ui/view/TouchImageView$DoubleTapZoom;->d:F

    iget v2, p0, Lcom/jibo/ui/view/TouchImageView$DoubleTapZoom;->c:F

    sub-float/2addr v1, v2

    mul-float/2addr v1, p1

    add-float/2addr v0, v1

    float-to-double v0, v0

    .line 1064
    iget-object v2, p0, Lcom/jibo/ui/view/TouchImageView$DoubleTapZoom;->a:Lcom/jibo/ui/view/TouchImageView;

    invoke-static {v2}, Lcom/jibo/ui/view/TouchImageView;->d(Lcom/jibo/ui/view/TouchImageView;)F

    move-result v2

    float-to-double v2, v2

    div-double/2addr v0, v2

    return-wide v0
.end method


# virtual methods
.method public run()V
    .locals 7

    .prologue
    .line 1003
    invoke-direct {p0}, Lcom/jibo/ui/view/TouchImageView$DoubleTapZoom;->a()F

    move-result v0

    .line 1004
    invoke-direct {p0, v0}, Lcom/jibo/ui/view/TouchImageView$DoubleTapZoom;->b(F)D

    move-result-wide v2

    .line 1005
    iget-object v1, p0, Lcom/jibo/ui/view/TouchImageView$DoubleTapZoom;->a:Lcom/jibo/ui/view/TouchImageView;

    iget v4, p0, Lcom/jibo/ui/view/TouchImageView$DoubleTapZoom;->e:F

    iget v5, p0, Lcom/jibo/ui/view/TouchImageView$DoubleTapZoom;->f:F

    iget-boolean v6, p0, Lcom/jibo/ui/view/TouchImageView$DoubleTapZoom;->g:Z

    invoke-static/range {v1 .. v6}, Lcom/jibo/ui/view/TouchImageView;->a(Lcom/jibo/ui/view/TouchImageView;DFFZ)V

    .line 1006
    invoke-direct {p0, v0}, Lcom/jibo/ui/view/TouchImageView$DoubleTapZoom;->a(F)V

    .line 1007
    iget-object v1, p0, Lcom/jibo/ui/view/TouchImageView$DoubleTapZoom;->a:Lcom/jibo/ui/view/TouchImageView;

    invoke-static {v1}, Lcom/jibo/ui/view/TouchImageView;->q(Lcom/jibo/ui/view/TouchImageView;)V

    .line 1008
    iget-object v1, p0, Lcom/jibo/ui/view/TouchImageView$DoubleTapZoom;->a:Lcom/jibo/ui/view/TouchImageView;

    iget-object v2, p0, Lcom/jibo/ui/view/TouchImageView$DoubleTapZoom;->a:Lcom/jibo/ui/view/TouchImageView;

    invoke-static {v2}, Lcom/jibo/ui/view/TouchImageView;->m(Lcom/jibo/ui/view/TouchImageView;)Landroid/graphics/Matrix;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/jibo/ui/view/TouchImageView;->setImageMatrix(Landroid/graphics/Matrix;)V

    .line 1014
    iget-object v1, p0, Lcom/jibo/ui/view/TouchImageView$DoubleTapZoom;->a:Lcom/jibo/ui/view/TouchImageView;

    invoke-static {v1}, Lcom/jibo/ui/view/TouchImageView;->p(Lcom/jibo/ui/view/TouchImageView;)Lcom/jibo/ui/view/TouchImageView$OnTouchImageViewListener;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 1015
    iget-object v1, p0, Lcom/jibo/ui/view/TouchImageView$DoubleTapZoom;->a:Lcom/jibo/ui/view/TouchImageView;

    invoke-static {v1}, Lcom/jibo/ui/view/TouchImageView;->p(Lcom/jibo/ui/view/TouchImageView;)Lcom/jibo/ui/view/TouchImageView$OnTouchImageViewListener;

    move-result-object v1

    invoke-interface {v1}, Lcom/jibo/ui/view/TouchImageView$OnTouchImageViewListener;->a()V

    .line 1018
    :cond_0
    const/high16 v1, 0x3f800000    # 1.0f

    cmpg-float v0, v0, v1

    if-gez v0, :cond_1

    .line 1022
    iget-object v0, p0, Lcom/jibo/ui/view/TouchImageView$DoubleTapZoom;->a:Lcom/jibo/ui/view/TouchImageView;

    invoke-static {v0, p0}, Lcom/jibo/ui/view/TouchImageView;->a(Lcom/jibo/ui/view/TouchImageView;Ljava/lang/Runnable;)V

    .line 1030
    :goto_0
    return-void

    .line 1028
    :cond_1
    iget-object v0, p0, Lcom/jibo/ui/view/TouchImageView$DoubleTapZoom;->a:Lcom/jibo/ui/view/TouchImageView;

    sget-object v1, Lcom/jibo/ui/view/TouchImageView$State;->NONE:Lcom/jibo/ui/view/TouchImageView$State;

    invoke-static {v0, v1}, Lcom/jibo/ui/view/TouchImageView;->a(Lcom/jibo/ui/view/TouchImageView;Lcom/jibo/ui/view/TouchImageView$State;)V

    goto :goto_0
.end method
