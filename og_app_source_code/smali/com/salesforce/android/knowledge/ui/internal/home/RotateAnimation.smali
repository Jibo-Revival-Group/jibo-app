.class public Lcom/salesforce/android/knowledge/ui/internal/home/RotateAnimation;
.super Ljava/lang/Object;
.source "RotateAnimation.java"


# direct methods
.method public static a(Landroid/view/View;F)V
    .locals 4

    .prologue
    .line 31
    invoke-virtual {p0}, Landroid/view/View;->getHeight()I

    move-result v0

    div-int/lit8 v0, v0, 0x2

    int-to-float v0, v0

    invoke-virtual {p0, v0}, Landroid/view/View;->setPivotY(F)V

    .line 32
    invoke-virtual {p0}, Landroid/view/View;->getWidth()I

    move-result v0

    div-int/lit8 v0, v0, 0x2

    int-to-float v0, v0

    invoke-virtual {p0, v0}, Landroid/view/View;->setPivotX(F)V

    .line 34
    const-string v0, "rotation"

    const/4 v1, 0x1

    new-array v1, v1, [F

    const/4 v2, 0x0

    aput p1, v1, v2

    invoke-static {p0, v0, v1}, Landroid/animation/ObjectAnimator;->ofFloat(Ljava/lang/Object;Ljava/lang/String;[F)Landroid/animation/ObjectAnimator;

    move-result-object v0

    .line 35
    const-wide/16 v2, 0x190

    invoke-virtual {v0, v2, v3}, Landroid/animation/Animator;->setDuration(J)Landroid/animation/Animator;

    .line 36
    invoke-virtual {v0}, Landroid/animation/Animator;->start()V

    .line 37
    return-void
.end method
