.class Lcom/jibo/ui/view/TouchImageView$ScaleListener;
.super Landroid/view/ScaleGestureDetector$SimpleOnScaleGestureListener;
.source "TouchImageView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/view/TouchImageView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "ScaleListener"
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/view/TouchImageView;


# direct methods
.method private constructor <init>(Lcom/jibo/ui/view/TouchImageView;)V
    .locals 0

    .prologue
    .line 899
    iput-object p1, p0, Lcom/jibo/ui/view/TouchImageView$ScaleListener;->a:Lcom/jibo/ui/view/TouchImageView;

    invoke-direct {p0}, Landroid/view/ScaleGestureDetector$SimpleOnScaleGestureListener;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/jibo/ui/view/TouchImageView;Lcom/jibo/ui/view/TouchImageView$1;)V
    .locals 0

    .prologue
    .line 899
    invoke-direct {p0, p1}, Lcom/jibo/ui/view/TouchImageView$ScaleListener;-><init>(Lcom/jibo/ui/view/TouchImageView;)V

    return-void
.end method


# virtual methods
.method public onScale(Landroid/view/ScaleGestureDetector;)Z
    .locals 7

    .prologue
    const/4 v6, 0x1

    .line 908
    iget-object v1, p0, Lcom/jibo/ui/view/TouchImageView$ScaleListener;->a:Lcom/jibo/ui/view/TouchImageView;

    invoke-virtual {p1}, Landroid/view/ScaleGestureDetector;->getScaleFactor()F

    move-result v0

    float-to-double v2, v0

    invoke-virtual {p1}, Landroid/view/ScaleGestureDetector;->getFocusX()F

    move-result v4

    invoke-virtual {p1}, Landroid/view/ScaleGestureDetector;->getFocusY()F

    move-result v5

    invoke-static/range {v1 .. v6}, Lcom/jibo/ui/view/TouchImageView;->a(Lcom/jibo/ui/view/TouchImageView;DFFZ)V

    .line 913
    iget-object v0, p0, Lcom/jibo/ui/view/TouchImageView$ScaleListener;->a:Lcom/jibo/ui/view/TouchImageView;

    invoke-static {v0}, Lcom/jibo/ui/view/TouchImageView;->p(Lcom/jibo/ui/view/TouchImageView;)Lcom/jibo/ui/view/TouchImageView$OnTouchImageViewListener;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 914
    iget-object v0, p0, Lcom/jibo/ui/view/TouchImageView$ScaleListener;->a:Lcom/jibo/ui/view/TouchImageView;

    invoke-static {v0}, Lcom/jibo/ui/view/TouchImageView;->p(Lcom/jibo/ui/view/TouchImageView;)Lcom/jibo/ui/view/TouchImageView$OnTouchImageViewListener;

    move-result-object v0

    invoke-interface {v0}, Lcom/jibo/ui/view/TouchImageView$OnTouchImageViewListener;->a()V

    .line 916
    :cond_0
    return v6
.end method

.method public onScaleBegin(Landroid/view/ScaleGestureDetector;)Z
    .locals 2

    .prologue
    .line 902
    iget-object v0, p0, Lcom/jibo/ui/view/TouchImageView$ScaleListener;->a:Lcom/jibo/ui/view/TouchImageView;

    sget-object v1, Lcom/jibo/ui/view/TouchImageView$State;->ZOOM:Lcom/jibo/ui/view/TouchImageView$State;

    invoke-static {v0, v1}, Lcom/jibo/ui/view/TouchImageView;->a(Lcom/jibo/ui/view/TouchImageView;Lcom/jibo/ui/view/TouchImageView$State;)V

    .line 903
    const/4 v0, 0x1

    return v0
.end method

.method public onScaleEnd(Landroid/view/ScaleGestureDetector;)V
    .locals 6

    .prologue
    const/4 v5, 0x1

    .line 921
    invoke-super {p0, p1}, Landroid/view/ScaleGestureDetector$SimpleOnScaleGestureListener;->onScaleEnd(Landroid/view/ScaleGestureDetector;)V

    .line 922
    iget-object v0, p0, Lcom/jibo/ui/view/TouchImageView$ScaleListener;->a:Lcom/jibo/ui/view/TouchImageView;

    sget-object v1, Lcom/jibo/ui/view/TouchImageView$State;->NONE:Lcom/jibo/ui/view/TouchImageView$State;

    invoke-static {v0, v1}, Lcom/jibo/ui/view/TouchImageView;->a(Lcom/jibo/ui/view/TouchImageView;Lcom/jibo/ui/view/TouchImageView$State;)V

    .line 923
    const/4 v0, 0x0

    .line 924
    iget-object v1, p0, Lcom/jibo/ui/view/TouchImageView$ScaleListener;->a:Lcom/jibo/ui/view/TouchImageView;

    invoke-static {v1}, Lcom/jibo/ui/view/TouchImageView;->d(Lcom/jibo/ui/view/TouchImageView;)F

    move-result v2

    .line 925
    iget-object v1, p0, Lcom/jibo/ui/view/TouchImageView$ScaleListener;->a:Lcom/jibo/ui/view/TouchImageView;

    invoke-static {v1}, Lcom/jibo/ui/view/TouchImageView;->d(Lcom/jibo/ui/view/TouchImageView;)F

    move-result v1

    iget-object v3, p0, Lcom/jibo/ui/view/TouchImageView$ScaleListener;->a:Lcom/jibo/ui/view/TouchImageView;

    invoke-static {v3}, Lcom/jibo/ui/view/TouchImageView;->f(Lcom/jibo/ui/view/TouchImageView;)F

    move-result v3

    cmpl-float v1, v1, v3

    if-lez v1, :cond_2

    .line 926
    iget-object v0, p0, Lcom/jibo/ui/view/TouchImageView$ScaleListener;->a:Lcom/jibo/ui/view/TouchImageView;

    invoke-static {v0}, Lcom/jibo/ui/view/TouchImageView;->f(Lcom/jibo/ui/view/TouchImageView;)F

    move-result v2

    move v0, v5

    .line 934
    :cond_0
    :goto_0
    if-eqz v0, :cond_1

    .line 935
    new-instance v0, Lcom/jibo/ui/view/TouchImageView$DoubleTapZoom;

    iget-object v1, p0, Lcom/jibo/ui/view/TouchImageView$ScaleListener;->a:Lcom/jibo/ui/view/TouchImageView;

    iget-object v3, p0, Lcom/jibo/ui/view/TouchImageView$ScaleListener;->a:Lcom/jibo/ui/view/TouchImageView;

    invoke-static {v3}, Lcom/jibo/ui/view/TouchImageView;->i(Lcom/jibo/ui/view/TouchImageView;)I

    move-result v3

    div-int/lit8 v3, v3, 0x2

    int-to-float v3, v3

    iget-object v4, p0, Lcom/jibo/ui/view/TouchImageView$ScaleListener;->a:Lcom/jibo/ui/view/TouchImageView;

    invoke-static {v4}, Lcom/jibo/ui/view/TouchImageView;->k(Lcom/jibo/ui/view/TouchImageView;)I

    move-result v4

    div-int/lit8 v4, v4, 0x2

    int-to-float v4, v4

    invoke-direct/range {v0 .. v5}, Lcom/jibo/ui/view/TouchImageView$DoubleTapZoom;-><init>(Lcom/jibo/ui/view/TouchImageView;FFFZ)V

    .line 936
    iget-object v1, p0, Lcom/jibo/ui/view/TouchImageView$ScaleListener;->a:Lcom/jibo/ui/view/TouchImageView;

    invoke-static {v1, v0}, Lcom/jibo/ui/view/TouchImageView;->a(Lcom/jibo/ui/view/TouchImageView;Ljava/lang/Runnable;)V

    .line 938
    :cond_1
    return-void

    .line 929
    :cond_2
    iget-object v1, p0, Lcom/jibo/ui/view/TouchImageView$ScaleListener;->a:Lcom/jibo/ui/view/TouchImageView;

    invoke-static {v1}, Lcom/jibo/ui/view/TouchImageView;->d(Lcom/jibo/ui/view/TouchImageView;)F

    move-result v1

    iget-object v3, p0, Lcom/jibo/ui/view/TouchImageView$ScaleListener;->a:Lcom/jibo/ui/view/TouchImageView;

    invoke-static {v3}, Lcom/jibo/ui/view/TouchImageView;->e(Lcom/jibo/ui/view/TouchImageView;)F

    move-result v3

    cmpg-float v1, v1, v3

    if-gez v1, :cond_0

    .line 930
    iget-object v0, p0, Lcom/jibo/ui/view/TouchImageView$ScaleListener;->a:Lcom/jibo/ui/view/TouchImageView;

    invoke-static {v0}, Lcom/jibo/ui/view/TouchImageView;->e(Lcom/jibo/ui/view/TouchImageView;)F

    move-result v2

    move v0, v5

    .line 931
    goto :goto_0
.end method
