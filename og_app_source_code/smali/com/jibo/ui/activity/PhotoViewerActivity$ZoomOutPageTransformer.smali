.class public Lcom/jibo/ui/activity/PhotoViewerActivity$ZoomOutPageTransformer;
.super Ljava/lang/Object;
.source "PhotoViewerActivity.java"

# interfaces
.implements Landroid/support/v4/view/ViewPager$PageTransformer;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/activity/PhotoViewerActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "ZoomOutPageTransformer"
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/activity/PhotoViewerActivity;


# direct methods
.method public constructor <init>(Lcom/jibo/ui/activity/PhotoViewerActivity;)V
    .locals 0

    .prologue
    .line 708
    iput-object p1, p0, Lcom/jibo/ui/activity/PhotoViewerActivity$ZoomOutPageTransformer;->a:Lcom/jibo/ui/activity/PhotoViewerActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Landroid/view/View;F)V
    .locals 9

    .prologue
    const v8, 0x3d4cccd0    # 0.050000012f

    const v7, 0x3f733333    # 0.95f

    const/4 v6, 0x0

    const/high16 v5, 0x40000000    # 2.0f

    const/high16 v4, 0x3f800000    # 1.0f

    .line 713
    invoke-virtual {p1}, Landroid/view/View;->getWidth()I

    move-result v0

    .line 714
    invoke-virtual {p1}, Landroid/view/View;->getHeight()I

    move-result v1

    .line 716
    const/high16 v2, -0x40800000    # -1.0f

    cmpg-float v2, p2, v2

    if-gez v2, :cond_0

    .line 718
    invoke-virtual {p1, v6}, Landroid/view/View;->setAlpha(F)V

    .line 742
    :goto_0
    return-void

    .line 720
    :cond_0
    cmpg-float v2, p2, v4

    if-gtz v2, :cond_2

    .line 722
    invoke-static {p2}, Ljava/lang/Math;->abs(F)F

    move-result v2

    sub-float v2, v4, v2

    invoke-static {v7, v2}, Ljava/lang/Math;->max(FF)F

    move-result v2

    .line 723
    int-to-float v1, v1

    sub-float v3, v4, v2

    mul-float/2addr v1, v3

    div-float/2addr v1, v5

    .line 724
    int-to-float v0, v0

    sub-float v3, v4, v2

    mul-float/2addr v0, v3

    div-float/2addr v0, v5

    .line 725
    cmpg-float v3, p2, v6

    if-gez v3, :cond_1

    .line 726
    div-float/2addr v1, v5

    sub-float/2addr v0, v1

    invoke-virtual {p1, v0}, Landroid/view/View;->setTranslationX(F)V

    .line 732
    :goto_1
    invoke-virtual {p1, v2}, Landroid/view/View;->setScaleX(F)V

    .line 733
    invoke-virtual {p1, v2}, Landroid/view/View;->setScaleY(F)V

    .line 736
    sub-float v0, v2, v7

    div-float/2addr v0, v8

    mul-float/2addr v0, v8

    add-float/2addr v0, v7

    invoke-virtual {p1, v0}, Landroid/view/View;->setAlpha(F)V

    goto :goto_0

    .line 728
    :cond_1
    neg-float v0, v0

    div-float/2addr v1, v5

    add-float/2addr v0, v1

    invoke-virtual {p1, v0}, Landroid/view/View;->setTranslationX(F)V

    goto :goto_1

    .line 740
    :cond_2
    invoke-virtual {p1, v6}, Landroid/view/View;->setAlpha(F)V

    goto :goto_0
.end method
