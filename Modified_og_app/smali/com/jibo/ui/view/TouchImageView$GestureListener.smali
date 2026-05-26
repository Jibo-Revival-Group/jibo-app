.class Lcom/jibo/ui/view/TouchImageView$GestureListener;
.super Landroid/view/GestureDetector$SimpleOnGestureListener;
.source "TouchImageView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/view/TouchImageView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "GestureListener"
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/view/TouchImageView;


# direct methods
.method private constructor <init>(Lcom/jibo/ui/view/TouchImageView;)V
    .locals 0

    .prologue
    .line 762
    iput-object p1, p0, Lcom/jibo/ui/view/TouchImageView$GestureListener;->a:Lcom/jibo/ui/view/TouchImageView;

    invoke-direct {p0}, Landroid/view/GestureDetector$SimpleOnGestureListener;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/jibo/ui/view/TouchImageView;Lcom/jibo/ui/view/TouchImageView$1;)V
    .locals 0

    .prologue
    .line 762
    invoke-direct {p0, p1}, Lcom/jibo/ui/view/TouchImageView$GestureListener;-><init>(Lcom/jibo/ui/view/TouchImageView;)V

    return-void
.end method


# virtual methods
.method public onDoubleTap(Landroid/view/MotionEvent;)Z
    .locals 6

    .prologue
    const/4 v5, 0x0

    .line 796
    .line 797
    iget-object v0, p0, Lcom/jibo/ui/view/TouchImageView$GestureListener;->a:Lcom/jibo/ui/view/TouchImageView;

    invoke-static {v0}, Lcom/jibo/ui/view/TouchImageView;->a(Lcom/jibo/ui/view/TouchImageView;)Landroid/view/GestureDetector$OnDoubleTapListener;

    move-result-object v0

    if-eqz v0, :cond_2

    .line 798
    iget-object v0, p0, Lcom/jibo/ui/view/TouchImageView$GestureListener;->a:Lcom/jibo/ui/view/TouchImageView;

    invoke-static {v0}, Lcom/jibo/ui/view/TouchImageView;->a(Lcom/jibo/ui/view/TouchImageView;)Landroid/view/GestureDetector$OnDoubleTapListener;

    move-result-object v0

    invoke-interface {v0, p1}, Landroid/view/GestureDetector$OnDoubleTapListener;->onDoubleTap(Landroid/view/MotionEvent;)Z

    move-result v0

    .line 800
    :goto_0
    iget-object v1, p0, Lcom/jibo/ui/view/TouchImageView$GestureListener;->a:Lcom/jibo/ui/view/TouchImageView;

    invoke-static {v1}, Lcom/jibo/ui/view/TouchImageView;->c(Lcom/jibo/ui/view/TouchImageView;)Lcom/jibo/ui/view/TouchImageView$State;

    move-result-object v1

    sget-object v2, Lcom/jibo/ui/view/TouchImageView$State;->NONE:Lcom/jibo/ui/view/TouchImageView$State;

    if-ne v1, v2, :cond_0

    .line 801
    iget-object v0, p0, Lcom/jibo/ui/view/TouchImageView$GestureListener;->a:Lcom/jibo/ui/view/TouchImageView;

    invoke-static {v0}, Lcom/jibo/ui/view/TouchImageView;->d(Lcom/jibo/ui/view/TouchImageView;)F

    move-result v0

    iget-object v1, p0, Lcom/jibo/ui/view/TouchImageView$GestureListener;->a:Lcom/jibo/ui/view/TouchImageView;

    invoke-static {v1}, Lcom/jibo/ui/view/TouchImageView;->e(Lcom/jibo/ui/view/TouchImageView;)F

    move-result v1

    cmpl-float v0, v0, v1

    if-nez v0, :cond_1

    iget-object v0, p0, Lcom/jibo/ui/view/TouchImageView$GestureListener;->a:Lcom/jibo/ui/view/TouchImageView;

    invoke-static {v0}, Lcom/jibo/ui/view/TouchImageView;->f(Lcom/jibo/ui/view/TouchImageView;)F

    move-result v2

    .line 802
    :goto_1
    new-instance v0, Lcom/jibo/ui/view/TouchImageView$DoubleTapZoom;

    iget-object v1, p0, Lcom/jibo/ui/view/TouchImageView$GestureListener;->a:Lcom/jibo/ui/view/TouchImageView;

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v3

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v4

    invoke-direct/range {v0 .. v5}, Lcom/jibo/ui/view/TouchImageView$DoubleTapZoom;-><init>(Lcom/jibo/ui/view/TouchImageView;FFFZ)V

    .line 803
    iget-object v1, p0, Lcom/jibo/ui/view/TouchImageView$GestureListener;->a:Lcom/jibo/ui/view/TouchImageView;

    invoke-static {v1, v0}, Lcom/jibo/ui/view/TouchImageView;->a(Lcom/jibo/ui/view/TouchImageView;Ljava/lang/Runnable;)V

    .line 804
    const/4 v0, 0x1

    .line 806
    :cond_0
    return v0

    .line 801
    :cond_1
    iget-object v0, p0, Lcom/jibo/ui/view/TouchImageView$GestureListener;->a:Lcom/jibo/ui/view/TouchImageView;

    invoke-static {v0}, Lcom/jibo/ui/view/TouchImageView;->e(Lcom/jibo/ui/view/TouchImageView;)F

    move-result v2

    goto :goto_1

    :cond_2
    move v0, v5

    goto :goto_0
.end method

.method public onDoubleTapEvent(Landroid/view/MotionEvent;)Z
    .locals 1

    .prologue
    .line 811
    iget-object v0, p0, Lcom/jibo/ui/view/TouchImageView$GestureListener;->a:Lcom/jibo/ui/view/TouchImageView;

    invoke-static {v0}, Lcom/jibo/ui/view/TouchImageView;->a(Lcom/jibo/ui/view/TouchImageView;)Landroid/view/GestureDetector$OnDoubleTapListener;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 812
    iget-object v0, p0, Lcom/jibo/ui/view/TouchImageView$GestureListener;->a:Lcom/jibo/ui/view/TouchImageView;

    invoke-static {v0}, Lcom/jibo/ui/view/TouchImageView;->a(Lcom/jibo/ui/view/TouchImageView;)Landroid/view/GestureDetector$OnDoubleTapListener;

    move-result-object v0

    invoke-interface {v0, p1}, Landroid/view/GestureDetector$OnDoubleTapListener;->onDoubleTapEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    .line 814
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public onFling(Landroid/view/MotionEvent;Landroid/view/MotionEvent;FF)Z
    .locals 5

    .prologue
    .line 782
    iget-object v0, p0, Lcom/jibo/ui/view/TouchImageView$GestureListener;->a:Lcom/jibo/ui/view/TouchImageView;

    invoke-static {v0}, Lcom/jibo/ui/view/TouchImageView;->b(Lcom/jibo/ui/view/TouchImageView;)Lcom/jibo/ui/view/TouchImageView$Fling;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 787
    iget-object v0, p0, Lcom/jibo/ui/view/TouchImageView$GestureListener;->a:Lcom/jibo/ui/view/TouchImageView;

    invoke-static {v0}, Lcom/jibo/ui/view/TouchImageView;->b(Lcom/jibo/ui/view/TouchImageView;)Lcom/jibo/ui/view/TouchImageView$Fling;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/ui/view/TouchImageView$Fling;->a()V

    .line 789
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/view/TouchImageView$GestureListener;->a:Lcom/jibo/ui/view/TouchImageView;

    new-instance v1, Lcom/jibo/ui/view/TouchImageView$Fling;

    iget-object v2, p0, Lcom/jibo/ui/view/TouchImageView$GestureListener;->a:Lcom/jibo/ui/view/TouchImageView;

    float-to-int v3, p3

    float-to-int v4, p4

    invoke-direct {v1, v2, v3, v4}, Lcom/jibo/ui/view/TouchImageView$Fling;-><init>(Lcom/jibo/ui/view/TouchImageView;II)V

    invoke-static {v0, v1}, Lcom/jibo/ui/view/TouchImageView;->a(Lcom/jibo/ui/view/TouchImageView;Lcom/jibo/ui/view/TouchImageView$Fling;)Lcom/jibo/ui/view/TouchImageView$Fling;

    .line 790
    iget-object v0, p0, Lcom/jibo/ui/view/TouchImageView$GestureListener;->a:Lcom/jibo/ui/view/TouchImageView;

    iget-object v1, p0, Lcom/jibo/ui/view/TouchImageView$GestureListener;->a:Lcom/jibo/ui/view/TouchImageView;

    invoke-static {v1}, Lcom/jibo/ui/view/TouchImageView;->b(Lcom/jibo/ui/view/TouchImageView;)Lcom/jibo/ui/view/TouchImageView$Fling;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/jibo/ui/view/TouchImageView;->a(Lcom/jibo/ui/view/TouchImageView;Ljava/lang/Runnable;)V

    .line 791
    invoke-super {p0, p1, p2, p3, p4}, Landroid/view/GestureDetector$SimpleOnGestureListener;->onFling(Landroid/view/MotionEvent;Landroid/view/MotionEvent;FF)Z

    move-result v0

    return v0
.end method

.method public onLongPress(Landroid/view/MotionEvent;)V
    .locals 1

    .prologue
    .line 776
    iget-object v0, p0, Lcom/jibo/ui/view/TouchImageView$GestureListener;->a:Lcom/jibo/ui/view/TouchImageView;

    invoke-virtual {v0}, Lcom/jibo/ui/view/TouchImageView;->performLongClick()Z

    .line 777
    return-void
.end method

.method public onSingleTapConfirmed(Landroid/view/MotionEvent;)Z
    .locals 1

    .prologue
    .line 767
    iget-object v0, p0, Lcom/jibo/ui/view/TouchImageView$GestureListener;->a:Lcom/jibo/ui/view/TouchImageView;

    invoke-static {v0}, Lcom/jibo/ui/view/TouchImageView;->a(Lcom/jibo/ui/view/TouchImageView;)Landroid/view/GestureDetector$OnDoubleTapListener;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 768
    iget-object v0, p0, Lcom/jibo/ui/view/TouchImageView$GestureListener;->a:Lcom/jibo/ui/view/TouchImageView;

    invoke-static {v0}, Lcom/jibo/ui/view/TouchImageView;->a(Lcom/jibo/ui/view/TouchImageView;)Landroid/view/GestureDetector$OnDoubleTapListener;

    move-result-object v0

    invoke-interface {v0, p1}, Landroid/view/GestureDetector$OnDoubleTapListener;->onSingleTapConfirmed(Landroid/view/MotionEvent;)Z

    move-result v0

    .line 770
    :goto_0
    return v0

    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/view/TouchImageView$GestureListener;->a:Lcom/jibo/ui/view/TouchImageView;

    invoke-virtual {v0}, Lcom/jibo/ui/view/TouchImageView;->performClick()Z

    move-result v0

    goto :goto_0
.end method
