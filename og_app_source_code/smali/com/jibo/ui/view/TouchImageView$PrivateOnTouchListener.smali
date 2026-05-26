.class Lcom/jibo/ui/view/TouchImageView$PrivateOnTouchListener;
.super Ljava/lang/Object;
.source "TouchImageView.java"

# interfaces
.implements Landroid/view/View$OnTouchListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/view/TouchImageView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "PrivateOnTouchListener"
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/view/TouchImageView;

.field private b:Landroid/graphics/PointF;


# direct methods
.method private constructor <init>(Lcom/jibo/ui/view/TouchImageView;)V
    .locals 1

    .prologue
    .line 828
    iput-object p1, p0, Lcom/jibo/ui/view/TouchImageView$PrivateOnTouchListener;->a:Lcom/jibo/ui/view/TouchImageView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 833
    new-instance v0, Landroid/graphics/PointF;

    invoke-direct {v0}, Landroid/graphics/PointF;-><init>()V

    iput-object v0, p0, Lcom/jibo/ui/view/TouchImageView$PrivateOnTouchListener;->b:Landroid/graphics/PointF;

    return-void
.end method

.method synthetic constructor <init>(Lcom/jibo/ui/view/TouchImageView;Lcom/jibo/ui/view/TouchImageView$1;)V
    .locals 0

    .prologue
    .line 828
    invoke-direct {p0, p1}, Lcom/jibo/ui/view/TouchImageView$PrivateOnTouchListener;-><init>(Lcom/jibo/ui/view/TouchImageView;)V

    return-void
.end method


# virtual methods
.method public onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z
    .locals 6

    .prologue
    .line 837
    iget-object v0, p0, Lcom/jibo/ui/view/TouchImageView$PrivateOnTouchListener;->a:Lcom/jibo/ui/view/TouchImageView;

    invoke-static {v0}, Lcom/jibo/ui/view/TouchImageView;->g(Lcom/jibo/ui/view/TouchImageView;)Landroid/view/ScaleGestureDetector;

    move-result-object v0

    invoke-virtual {v0, p2}, Landroid/view/ScaleGestureDetector;->onTouchEvent(Landroid/view/MotionEvent;)Z

    .line 838
    iget-object v0, p0, Lcom/jibo/ui/view/TouchImageView$PrivateOnTouchListener;->a:Lcom/jibo/ui/view/TouchImageView;

    invoke-static {v0}, Lcom/jibo/ui/view/TouchImageView;->h(Lcom/jibo/ui/view/TouchImageView;)Landroid/view/GestureDetector;

    move-result-object v0

    invoke-virtual {v0, p2}, Landroid/view/GestureDetector;->onTouchEvent(Landroid/view/MotionEvent;)Z

    .line 839
    new-instance v0, Landroid/graphics/PointF;

    invoke-virtual {p2}, Landroid/view/MotionEvent;->getX()F

    move-result v1

    invoke-virtual {p2}, Landroid/view/MotionEvent;->getY()F

    move-result v2

    invoke-direct {v0, v1, v2}, Landroid/graphics/PointF;-><init>(FF)V

    .line 841
    iget-object v1, p0, Lcom/jibo/ui/view/TouchImageView$PrivateOnTouchListener;->a:Lcom/jibo/ui/view/TouchImageView;

    invoke-static {v1}, Lcom/jibo/ui/view/TouchImageView;->c(Lcom/jibo/ui/view/TouchImageView;)Lcom/jibo/ui/view/TouchImageView$State;

    move-result-object v1

    sget-object v2, Lcom/jibo/ui/view/TouchImageView$State;->NONE:Lcom/jibo/ui/view/TouchImageView$State;

    if-eq v1, v2, :cond_0

    iget-object v1, p0, Lcom/jibo/ui/view/TouchImageView$PrivateOnTouchListener;->a:Lcom/jibo/ui/view/TouchImageView;

    invoke-static {v1}, Lcom/jibo/ui/view/TouchImageView;->c(Lcom/jibo/ui/view/TouchImageView;)Lcom/jibo/ui/view/TouchImageView$State;

    move-result-object v1

    sget-object v2, Lcom/jibo/ui/view/TouchImageView$State;->DRAG:Lcom/jibo/ui/view/TouchImageView$State;

    if-eq v1, v2, :cond_0

    iget-object v1, p0, Lcom/jibo/ui/view/TouchImageView$PrivateOnTouchListener;->a:Lcom/jibo/ui/view/TouchImageView;

    invoke-static {v1}, Lcom/jibo/ui/view/TouchImageView;->c(Lcom/jibo/ui/view/TouchImageView;)Lcom/jibo/ui/view/TouchImageView$State;

    move-result-object v1

    sget-object v2, Lcom/jibo/ui/view/TouchImageView$State;->FLING:Lcom/jibo/ui/view/TouchImageView$State;

    if-ne v1, v2, :cond_1

    .line 842
    :cond_0
    invoke-virtual {p2}, Landroid/view/MotionEvent;->getAction()I

    move-result v1

    packed-switch v1, :pswitch_data_0

    .line 871
    :cond_1
    :goto_0
    :pswitch_0
    iget-object v0, p0, Lcom/jibo/ui/view/TouchImageView$PrivateOnTouchListener;->a:Lcom/jibo/ui/view/TouchImageView;

    iget-object v1, p0, Lcom/jibo/ui/view/TouchImageView$PrivateOnTouchListener;->a:Lcom/jibo/ui/view/TouchImageView;

    invoke-static {v1}, Lcom/jibo/ui/view/TouchImageView;->m(Lcom/jibo/ui/view/TouchImageView;)Landroid/graphics/Matrix;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/jibo/ui/view/TouchImageView;->setImageMatrix(Landroid/graphics/Matrix;)V

    .line 876
    iget-object v0, p0, Lcom/jibo/ui/view/TouchImageView$PrivateOnTouchListener;->a:Lcom/jibo/ui/view/TouchImageView;

    invoke-static {v0}, Lcom/jibo/ui/view/TouchImageView;->o(Lcom/jibo/ui/view/TouchImageView;)Landroid/view/View$OnTouchListener;

    move-result-object v0

    if-eqz v0, :cond_2

    .line 877
    iget-object v0, p0, Lcom/jibo/ui/view/TouchImageView$PrivateOnTouchListener;->a:Lcom/jibo/ui/view/TouchImageView;

    invoke-static {v0}, Lcom/jibo/ui/view/TouchImageView;->o(Lcom/jibo/ui/view/TouchImageView;)Landroid/view/View$OnTouchListener;

    move-result-object v0

    invoke-interface {v0, p1, p2}, Landroid/view/View$OnTouchListener;->onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z

    .line 883
    :cond_2
    iget-object v0, p0, Lcom/jibo/ui/view/TouchImageView$PrivateOnTouchListener;->a:Lcom/jibo/ui/view/TouchImageView;

    invoke-static {v0}, Lcom/jibo/ui/view/TouchImageView;->p(Lcom/jibo/ui/view/TouchImageView;)Lcom/jibo/ui/view/TouchImageView$OnTouchImageViewListener;

    move-result-object v0

    if-eqz v0, :cond_3

    .line 884
    iget-object v0, p0, Lcom/jibo/ui/view/TouchImageView$PrivateOnTouchListener;->a:Lcom/jibo/ui/view/TouchImageView;

    invoke-static {v0}, Lcom/jibo/ui/view/TouchImageView;->p(Lcom/jibo/ui/view/TouchImageView;)Lcom/jibo/ui/view/TouchImageView$OnTouchImageViewListener;

    move-result-object v0

    invoke-interface {v0}, Lcom/jibo/ui/view/TouchImageView$OnTouchImageViewListener;->a()V

    .line 890
    :cond_3
    const/4 v0, 0x1

    return v0

    .line 845
    :pswitch_1
    iget-object v1, p0, Lcom/jibo/ui/view/TouchImageView$PrivateOnTouchListener;->b:Landroid/graphics/PointF;

    invoke-virtual {v1, v0}, Landroid/graphics/PointF;->set(Landroid/graphics/PointF;)V

    .line 846
    iget-object v0, p0, Lcom/jibo/ui/view/TouchImageView$PrivateOnTouchListener;->a:Lcom/jibo/ui/view/TouchImageView;

    invoke-static {v0}, Lcom/jibo/ui/view/TouchImageView;->b(Lcom/jibo/ui/view/TouchImageView;)Lcom/jibo/ui/view/TouchImageView$Fling;

    move-result-object v0

    if-eqz v0, :cond_4

    .line 847
    iget-object v0, p0, Lcom/jibo/ui/view/TouchImageView$PrivateOnTouchListener;->a:Lcom/jibo/ui/view/TouchImageView;

    invoke-static {v0}, Lcom/jibo/ui/view/TouchImageView;->b(Lcom/jibo/ui/view/TouchImageView;)Lcom/jibo/ui/view/TouchImageView$Fling;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/ui/view/TouchImageView$Fling;->a()V

    .line 848
    :cond_4
    iget-object v0, p0, Lcom/jibo/ui/view/TouchImageView$PrivateOnTouchListener;->a:Lcom/jibo/ui/view/TouchImageView;

    sget-object v1, Lcom/jibo/ui/view/TouchImageView$State;->DRAG:Lcom/jibo/ui/view/TouchImageView$State;

    invoke-static {v0, v1}, Lcom/jibo/ui/view/TouchImageView;->a(Lcom/jibo/ui/view/TouchImageView;Lcom/jibo/ui/view/TouchImageView$State;)V

    goto :goto_0

    .line 852
    :pswitch_2
    iget-object v1, p0, Lcom/jibo/ui/view/TouchImageView$PrivateOnTouchListener;->a:Lcom/jibo/ui/view/TouchImageView;

    invoke-static {v1}, Lcom/jibo/ui/view/TouchImageView;->c(Lcom/jibo/ui/view/TouchImageView;)Lcom/jibo/ui/view/TouchImageView$State;

    move-result-object v1

    sget-object v2, Lcom/jibo/ui/view/TouchImageView$State;->DRAG:Lcom/jibo/ui/view/TouchImageView$State;

    if-ne v1, v2, :cond_1

    .line 853
    iget v1, v0, Landroid/graphics/PointF;->x:F

    iget-object v2, p0, Lcom/jibo/ui/view/TouchImageView$PrivateOnTouchListener;->b:Landroid/graphics/PointF;

    iget v2, v2, Landroid/graphics/PointF;->x:F

    sub-float/2addr v1, v2

    .line 854
    iget v2, v0, Landroid/graphics/PointF;->y:F

    iget-object v3, p0, Lcom/jibo/ui/view/TouchImageView$PrivateOnTouchListener;->b:Landroid/graphics/PointF;

    iget v3, v3, Landroid/graphics/PointF;->y:F

    sub-float/2addr v2, v3

    .line 855
    iget-object v3, p0, Lcom/jibo/ui/view/TouchImageView$PrivateOnTouchListener;->a:Lcom/jibo/ui/view/TouchImageView;

    iget-object v4, p0, Lcom/jibo/ui/view/TouchImageView$PrivateOnTouchListener;->a:Lcom/jibo/ui/view/TouchImageView;

    invoke-static {v4}, Lcom/jibo/ui/view/TouchImageView;->i(Lcom/jibo/ui/view/TouchImageView;)I

    move-result v4

    int-to-float v4, v4

    iget-object v5, p0, Lcom/jibo/ui/view/TouchImageView$PrivateOnTouchListener;->a:Lcom/jibo/ui/view/TouchImageView;

    invoke-static {v5}, Lcom/jibo/ui/view/TouchImageView;->j(Lcom/jibo/ui/view/TouchImageView;)F

    move-result v5

    invoke-static {v3, v1, v4, v5}, Lcom/jibo/ui/view/TouchImageView;->a(Lcom/jibo/ui/view/TouchImageView;FFF)F

    move-result v1

    .line 856
    iget-object v3, p0, Lcom/jibo/ui/view/TouchImageView$PrivateOnTouchListener;->a:Lcom/jibo/ui/view/TouchImageView;

    iget-object v4, p0, Lcom/jibo/ui/view/TouchImageView$PrivateOnTouchListener;->a:Lcom/jibo/ui/view/TouchImageView;

    invoke-static {v4}, Lcom/jibo/ui/view/TouchImageView;->k(Lcom/jibo/ui/view/TouchImageView;)I

    move-result v4

    int-to-float v4, v4

    iget-object v5, p0, Lcom/jibo/ui/view/TouchImageView$PrivateOnTouchListener;->a:Lcom/jibo/ui/view/TouchImageView;

    invoke-static {v5}, Lcom/jibo/ui/view/TouchImageView;->l(Lcom/jibo/ui/view/TouchImageView;)F

    move-result v5

    invoke-static {v3, v2, v4, v5}, Lcom/jibo/ui/view/TouchImageView;->a(Lcom/jibo/ui/view/TouchImageView;FFF)F

    move-result v2

    .line 857
    iget-object v3, p0, Lcom/jibo/ui/view/TouchImageView$PrivateOnTouchListener;->a:Lcom/jibo/ui/view/TouchImageView;

    invoke-static {v3}, Lcom/jibo/ui/view/TouchImageView;->m(Lcom/jibo/ui/view/TouchImageView;)Landroid/graphics/Matrix;

    move-result-object v3

    invoke-virtual {v3, v1, v2}, Landroid/graphics/Matrix;->postTranslate(FF)Z

    .line 858
    iget-object v1, p0, Lcom/jibo/ui/view/TouchImageView$PrivateOnTouchListener;->a:Lcom/jibo/ui/view/TouchImageView;

    invoke-static {v1}, Lcom/jibo/ui/view/TouchImageView;->n(Lcom/jibo/ui/view/TouchImageView;)V

    .line 859
    iget-object v1, p0, Lcom/jibo/ui/view/TouchImageView$PrivateOnTouchListener;->b:Landroid/graphics/PointF;

    iget v2, v0, Landroid/graphics/PointF;->x:F

    iget v0, v0, Landroid/graphics/PointF;->y:F

    invoke-virtual {v1, v2, v0}, Landroid/graphics/PointF;->set(FF)V

    goto/16 :goto_0

    .line 865
    :pswitch_3
    iget-object v0, p0, Lcom/jibo/ui/view/TouchImageView$PrivateOnTouchListener;->a:Lcom/jibo/ui/view/TouchImageView;

    sget-object v1, Lcom/jibo/ui/view/TouchImageView$State;->NONE:Lcom/jibo/ui/view/TouchImageView$State;

    invoke-static {v0, v1}, Lcom/jibo/ui/view/TouchImageView;->a(Lcom/jibo/ui/view/TouchImageView;Lcom/jibo/ui/view/TouchImageView$State;)V

    goto/16 :goto_0

    .line 842
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1
        :pswitch_3
        :pswitch_2
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_3
    .end packed-switch
.end method
