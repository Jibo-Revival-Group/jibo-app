.class public Lcom/jibo/ui/view/PhotoViewerViewPager;
.super Landroid/support/v4/view/ViewPager;
.source "PhotoViewerViewPager.java"


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 0

    .prologue
    .line 12
    invoke-direct {p0, p1}, Landroid/support/v4/view/ViewPager;-><init>(Landroid/content/Context;)V

    .line 13
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 0

    .prologue
    .line 16
    invoke-direct {p0, p1, p2}, Landroid/support/v4/view/ViewPager;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 17
    return-void
.end method


# virtual methods
.method protected a(Landroid/view/View;ZIII)Z
    .locals 1

    .prologue
    .line 21
    instance-of v0, p1, Lcom/jibo/ui/view/TouchImageView;

    if-eqz v0, :cond_0

    .line 27
    check-cast p1, Lcom/jibo/ui/view/TouchImageView;

    neg-int v0, p3

    invoke-virtual {p1, v0}, Lcom/jibo/ui/view/TouchImageView;->a(I)Z

    move-result v0

    .line 30
    :goto_0
    return v0

    :cond_0
    invoke-super/range {p0 .. p5}, Landroid/support/v4/view/ViewPager;->a(Landroid/view/View;ZIII)Z

    move-result v0

    goto :goto_0
.end method
