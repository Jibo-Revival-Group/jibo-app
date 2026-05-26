.class public Landroid/support/v4/view/ViewCompat;
.super Ljava/lang/Object;
.source "ViewCompat.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/support/v4/view/ViewCompat$ViewCompatApi26Impl;,
        Landroid/support/v4/view/ViewCompat$ViewCompatApi24Impl;,
        Landroid/support/v4/view/ViewCompat$ViewCompatApi23Impl;,
        Landroid/support/v4/view/ViewCompat$ViewCompatApi21Impl;,
        Landroid/support/v4/view/ViewCompat$ViewCompatApi19Impl;,
        Landroid/support/v4/view/ViewCompat$ViewCompatApi18Impl;,
        Landroid/support/v4/view/ViewCompat$ViewCompatApi17Impl;,
        Landroid/support/v4/view/ViewCompat$ViewCompatApi16Impl;,
        Landroid/support/v4/view/ViewCompat$ViewCompatApi15Impl;,
        Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;
    }
.end annotation


# static fields
.field static final a:Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 1658
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x1a

    if-lt v0, v1, :cond_0

    .line 1659
    new-instance v0, Landroid/support/v4/view/ViewCompat$ViewCompatApi26Impl;

    invoke-direct {v0}, Landroid/support/v4/view/ViewCompat$ViewCompatApi26Impl;-><init>()V

    sput-object v0, Landroid/support/v4/view/ViewCompat;->a:Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;

    .line 1679
    :goto_0
    return-void

    .line 1660
    :cond_0
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x18

    if-lt v0, v1, :cond_1

    .line 1661
    new-instance v0, Landroid/support/v4/view/ViewCompat$ViewCompatApi24Impl;

    invoke-direct {v0}, Landroid/support/v4/view/ViewCompat$ViewCompatApi24Impl;-><init>()V

    sput-object v0, Landroid/support/v4/view/ViewCompat;->a:Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;

    goto :goto_0

    .line 1662
    :cond_1
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x17

    if-lt v0, v1, :cond_2

    .line 1663
    new-instance v0, Landroid/support/v4/view/ViewCompat$ViewCompatApi23Impl;

    invoke-direct {v0}, Landroid/support/v4/view/ViewCompat$ViewCompatApi23Impl;-><init>()V

    sput-object v0, Landroid/support/v4/view/ViewCompat;->a:Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;

    goto :goto_0

    .line 1664
    :cond_2
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x15

    if-lt v0, v1, :cond_3

    .line 1665
    new-instance v0, Landroid/support/v4/view/ViewCompat$ViewCompatApi21Impl;

    invoke-direct {v0}, Landroid/support/v4/view/ViewCompat$ViewCompatApi21Impl;-><init>()V

    sput-object v0, Landroid/support/v4/view/ViewCompat;->a:Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;

    goto :goto_0

    .line 1666
    :cond_3
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x13

    if-lt v0, v1, :cond_4

    .line 1667
    new-instance v0, Landroid/support/v4/view/ViewCompat$ViewCompatApi19Impl;

    invoke-direct {v0}, Landroid/support/v4/view/ViewCompat$ViewCompatApi19Impl;-><init>()V

    sput-object v0, Landroid/support/v4/view/ViewCompat;->a:Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;

    goto :goto_0

    .line 1668
    :cond_4
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x12

    if-lt v0, v1, :cond_5

    .line 1669
    new-instance v0, Landroid/support/v4/view/ViewCompat$ViewCompatApi18Impl;

    invoke-direct {v0}, Landroid/support/v4/view/ViewCompat$ViewCompatApi18Impl;-><init>()V

    sput-object v0, Landroid/support/v4/view/ViewCompat;->a:Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;

    goto :goto_0

    .line 1670
    :cond_5
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x11

    if-lt v0, v1, :cond_6

    .line 1671
    new-instance v0, Landroid/support/v4/view/ViewCompat$ViewCompatApi17Impl;

    invoke-direct {v0}, Landroid/support/v4/view/ViewCompat$ViewCompatApi17Impl;-><init>()V

    sput-object v0, Landroid/support/v4/view/ViewCompat;->a:Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;

    goto :goto_0

    .line 1672
    :cond_6
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x10

    if-lt v0, v1, :cond_7

    .line 1673
    new-instance v0, Landroid/support/v4/view/ViewCompat$ViewCompatApi16Impl;

    invoke-direct {v0}, Landroid/support/v4/view/ViewCompat$ViewCompatApi16Impl;-><init>()V

    sput-object v0, Landroid/support/v4/view/ViewCompat;->a:Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;

    goto :goto_0

    .line 1674
    :cond_7
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0xf

    if-lt v0, v1, :cond_8

    .line 1675
    new-instance v0, Landroid/support/v4/view/ViewCompat$ViewCompatApi15Impl;

    invoke-direct {v0}, Landroid/support/v4/view/ViewCompat$ViewCompatApi15Impl;-><init>()V

    sput-object v0, Landroid/support/v4/view/ViewCompat;->a:Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;

    goto :goto_0

    .line 1677
    :cond_8
    new-instance v0, Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;

    invoke-direct {v0}, Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;-><init>()V

    sput-object v0, Landroid/support/v4/view/ViewCompat;->a:Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;

    goto :goto_0
.end method

.method public static A(Landroid/view/View;)Landroid/graphics/Rect;
    .locals 1

    .prologue
    .line 3711
    sget-object v0, Landroid/support/v4/view/ViewCompat;->a:Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;

    invoke-virtual {v0, p0}, Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;->q(Landroid/view/View;)Landroid/graphics/Rect;

    move-result-object v0

    return-object v0
.end method

.method public static B(Landroid/view/View;)Z
    .locals 1

    .prologue
    .line 3718
    sget-object v0, Landroid/support/v4/view/ViewCompat;->a:Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;

    invoke-virtual {v0, p0}, Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;->s(Landroid/view/View;)Z

    move-result v0

    return v0
.end method

.method public static C(Landroid/view/View;)Z
    .locals 1

    .prologue
    .line 3727
    sget-object v0, Landroid/support/v4/view/ViewCompat;->a:Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;

    invoke-virtual {v0, p0}, Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;->a(Landroid/view/View;)Z

    move-result v0

    return v0
.end method

.method public static D(Landroid/view/View;)Landroid/view/Display;
    .locals 1

    .prologue
    .line 3812
    sget-object v0, Landroid/support/v4/view/ViewCompat;->a:Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;

    invoke-virtual {v0, p0}, Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;->p(Landroid/view/View;)Landroid/view/Display;

    move-result-object v0

    return-object v0
.end method

.method public static a(Landroid/view/View;Landroid/support/v4/view/WindowInsetsCompat;)Landroid/support/v4/view/WindowInsetsCompat;
    .locals 1

    .prologue
    .line 3143
    sget-object v0, Landroid/support/v4/view/ViewCompat;->a:Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;

    invoke-virtual {v0, p0, p1}, Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;->a(Landroid/view/View;Landroid/support/v4/view/WindowInsetsCompat;)Landroid/support/v4/view/WindowInsetsCompat;

    move-result-object v0

    return-object v0
.end method

.method public static a(Landroid/view/View;F)V
    .locals 1

    .prologue
    .line 3002
    sget-object v0, Landroid/support/v4/view/ViewCompat;->a:Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;

    invoke-virtual {v0, p0, p1}, Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;->a(Landroid/view/View;F)V

    .line 3003
    return-void
.end method

.method public static a(Landroid/view/View;I)V
    .locals 1

    .prologue
    .line 2167
    sget-object v0, Landroid/support/v4/view/ViewCompat;->a:Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;

    invoke-virtual {v0, p0, p1}, Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;->a(Landroid/view/View;I)V

    .line 2168
    return-void
.end method

.method public static a(Landroid/view/View;II)V
    .locals 1

    .prologue
    .line 3774
    sget-object v0, Landroid/support/v4/view/ViewCompat;->a:Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;

    invoke-virtual {v0, p0, p1, p2}, Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;->a(Landroid/view/View;II)V

    .line 3775
    return-void
.end method

.method public static a(Landroid/view/View;IIII)V
    .locals 6

    .prologue
    .line 2093
    sget-object v0, Landroid/support/v4/view/ViewCompat;->a:Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;

    move-object v1, p0

    move v2, p1

    move v3, p2

    move v4, p3

    move v5, p4

    invoke-virtual/range {v0 .. v5}, Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;->a(Landroid/view/View;IIII)V

    .line 2094
    return-void
.end method

.method public static a(Landroid/view/View;Landroid/content/res/ColorStateList;)V
    .locals 1

    .prologue
    .line 3249
    sget-object v0, Landroid/support/v4/view/ViewCompat;->a:Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;

    invoke-virtual {v0, p0, p1}, Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;->a(Landroid/view/View;Landroid/content/res/ColorStateList;)V

    .line 3250
    return-void
.end method

.method public static a(Landroid/view/View;Landroid/graphics/Paint;)V
    .locals 1

    .prologue
    .line 2386
    sget-object v0, Landroid/support/v4/view/ViewCompat;->a:Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;

    invoke-virtual {v0, p0, p1}, Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;->a(Landroid/view/View;Landroid/graphics/Paint;)V

    .line 2387
    return-void
.end method

.method public static a(Landroid/view/View;Landroid/graphics/PorterDuff$Mode;)V
    .locals 1

    .prologue
    .line 3273
    sget-object v0, Landroid/support/v4/view/ViewCompat;->a:Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;

    invoke-virtual {v0, p0, p1}, Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;->a(Landroid/view/View;Landroid/graphics/PorterDuff$Mode;)V

    .line 3274
    return-void
.end method

.method public static a(Landroid/view/View;Landroid/graphics/Rect;)V
    .locals 1

    .prologue
    .line 3699
    sget-object v0, Landroid/support/v4/view/ViewCompat;->a:Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;

    invoke-virtual {v0, p0, p1}, Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;->a(Landroid/view/View;Landroid/graphics/Rect;)V

    .line 3700
    return-void
.end method

.method public static a(Landroid/view/View;Landroid/graphics/drawable/Drawable;)V
    .locals 1

    .prologue
    .line 3228
    sget-object v0, Landroid/support/v4/view/ViewCompat;->a:Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;

    invoke-virtual {v0, p0, p1}, Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;->a(Landroid/view/View;Landroid/graphics/drawable/Drawable;)V

    .line 3229
    return-void
.end method

.method public static a(Landroid/view/View;Landroid/support/v4/view/AccessibilityDelegateCompat;)V
    .locals 1

    .prologue
    .line 1870
    sget-object v0, Landroid/support/v4/view/ViewCompat;->a:Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;

    invoke-virtual {v0, p0, p1}, Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;->a(Landroid/view/View;Landroid/support/v4/view/AccessibilityDelegateCompat;)V

    .line 1871
    return-void
.end method

.method public static a(Landroid/view/View;Landroid/support/v4/view/OnApplyWindowInsetsListener;)V
    .locals 1

    .prologue
    .line 3127
    sget-object v0, Landroid/support/v4/view/ViewCompat;->a:Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;

    invoke-virtual {v0, p0, p1}, Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;->a(Landroid/view/View;Landroid/support/v4/view/OnApplyWindowInsetsListener;)V

    .line 3128
    return-void
.end method

.method public static a(Landroid/view/View;Landroid/support/v4/view/PointerIconCompat;)V
    .locals 1

    .prologue
    .line 3798
    sget-object v0, Landroid/support/v4/view/ViewCompat;->a:Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;

    invoke-virtual {v0, p0, p1}, Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;->a(Landroid/view/View;Landroid/support/v4/view/PointerIconCompat;)V

    .line 3799
    return-void
.end method

.method public static a(Landroid/view/View;Ljava/lang/Runnable;)V
    .locals 1

    .prologue
    .line 2107
    sget-object v0, Landroid/support/v4/view/ViewCompat;->a:Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;

    invoke-virtual {v0, p0, p1}, Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;->a(Landroid/view/View;Ljava/lang/Runnable;)V

    .line 2108
    return-void
.end method

.method public static a(Landroid/view/View;Ljava/lang/Runnable;J)V
    .locals 2

    .prologue
    .line 2124
    sget-object v0, Landroid/support/v4/view/ViewCompat;->a:Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;

    invoke-virtual {v0, p0, p1, p2, p3}, Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;->a(Landroid/view/View;Ljava/lang/Runnable;J)V

    .line 2125
    return-void
.end method

.method public static a(Landroid/view/View;Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 3038
    sget-object v0, Landroid/support/v4/view/ViewCompat;->a:Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;

    invoke-virtual {v0, p0, p1}, Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;->a(Landroid/view/View;Ljava/lang/String;)V

    .line 3039
    return-void
.end method

.method public static a(Landroid/view/View;Z)V
    .locals 1

    .prologue
    .line 2062
    sget-object v0, Landroid/support/v4/view/ViewCompat;->a:Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;

    invoke-virtual {v0, p0, p1}, Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;->a(Landroid/view/View;Z)V

    .line 2063
    return-void
.end method

.method public static a(Landroid/view/View;)Z
    .locals 1

    .prologue
    .line 2039
    sget-object v0, Landroid/support/v4/view/ViewCompat;->a:Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;

    invoke-virtual {v0, p0}, Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;->B(Landroid/view/View;)Z

    move-result v0

    return v0
.end method

.method public static b(Landroid/view/View;Landroid/support/v4/view/WindowInsetsCompat;)Landroid/support/v4/view/WindowInsetsCompat;
    .locals 1

    .prologue
    .line 3160
    sget-object v0, Landroid/support/v4/view/ViewCompat;->a:Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;

    invoke-virtual {v0, p0, p1}, Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;->b(Landroid/view/View;Landroid/support/v4/view/WindowInsetsCompat;)Landroid/support/v4/view/WindowInsetsCompat;

    move-result-object v0

    return-object v0
.end method

.method public static b(Landroid/view/View;F)V
    .locals 1

    .prologue
    .line 3018
    sget-object v0, Landroid/support/v4/view/ViewCompat;->a:Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;

    invoke-virtual {v0, p0, p1}, Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;->b(Landroid/view/View;F)V

    .line 3019
    return-void
.end method

.method public static b(Landroid/view/View;I)V
    .locals 1

    .prologue
    .line 2600
    sget-object v0, Landroid/support/v4/view/ViewCompat;->a:Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;

    invoke-virtual {v0, p0, p1}, Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;->b(Landroid/view/View;I)V

    .line 2601
    return-void
.end method

.method public static b(Landroid/view/View;IIII)V
    .locals 6

    .prologue
    .line 2641
    sget-object v0, Landroid/support/v4/view/ViewCompat;->a:Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;

    move-object v1, p0

    move v2, p1

    move v3, p2

    move v4, p3

    move v5, p4

    invoke-virtual/range {v0 .. v5}, Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;->b(Landroid/view/View;IIII)V

    .line 2642
    return-void
.end method

.method public static b(Landroid/view/View;Z)V
    .locals 0
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 3104
    invoke-virtual {p0, p1}, Landroid/view/View;->setFitsSystemWindows(Z)V

    .line 3105
    return-void
.end method

.method public static b(Landroid/view/View;)Z
    .locals 1

    .prologue
    .line 2051
    sget-object v0, Landroid/support/v4/view/ViewCompat;->a:Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;

    invoke-virtual {v0, p0}, Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;->b(Landroid/view/View;)Z

    move-result v0

    return v0
.end method

.method public static c(Landroid/view/View;)V
    .locals 1

    .prologue
    .line 2075
    sget-object v0, Landroid/support/v4/view/ViewCompat;->a:Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;

    invoke-virtual {v0, p0}, Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;->c(Landroid/view/View;)V

    .line 2076
    return-void
.end method

.method public static c(Landroid/view/View;I)V
    .locals 1

    .prologue
    .line 3675
    sget-object v0, Landroid/support/v4/view/ViewCompat;->a:Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;

    invoke-virtual {v0, p0, p1}, Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;->d(Landroid/view/View;I)V

    .line 3676
    return-void
.end method

.method public static d(Landroid/view/View;)I
    .locals 1

    .prologue
    .line 2143
    sget-object v0, Landroid/support/v4/view/ViewCompat;->a:Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;

    invoke-virtual {v0, p0}, Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;->d(Landroid/view/View;)I

    move-result v0

    return v0
.end method

.method public static d(Landroid/view/View;I)V
    .locals 1

    .prologue
    .line 3684
    sget-object v0, Landroid/support/v4/view/ViewCompat;->a:Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;

    invoke-virtual {v0, p0, p1}, Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;->c(Landroid/view/View;I)V

    .line 3685
    return-void
.end method

.method public static e(Landroid/view/View;)I
    .locals 1

    .prologue
    .line 2402
    sget-object v0, Landroid/support/v4/view/ViewCompat;->a:Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;

    invoke-virtual {v0, p0}, Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;->k(Landroid/view/View;)I

    move-result v0

    return v0
.end method

.method public static f(Landroid/view/View;)Landroid/view/ViewParent;
    .locals 1

    .prologue
    .line 2434
    sget-object v0, Landroid/support/v4/view/ViewCompat;->a:Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;

    invoke-virtual {v0, p0}, Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;->e(Landroid/view/View;)Landroid/view/ViewParent;

    move-result-object v0

    return-object v0
.end method

.method public static g(Landroid/view/View;)I
    .locals 1

    .prologue
    .line 2612
    sget-object v0, Landroid/support/v4/view/ViewCompat;->a:Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;

    invoke-virtual {v0, p0}, Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;->l(Landroid/view/View;)I

    move-result v0

    return v0
.end method

.method public static h(Landroid/view/View;)I
    .locals 1

    .prologue
    .line 2624
    sget-object v0, Landroid/support/v4/view/ViewCompat;->a:Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;

    invoke-virtual {v0, p0}, Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;->m(Landroid/view/View;)I

    move-result v0

    return v0
.end method

.method public static i(Landroid/view/View;)F
    .locals 1
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 2683
    invoke-virtual {p0}, Landroid/view/View;->getTranslationY()F

    move-result v0

    return v0
.end method

.method public static j(Landroid/view/View;)I
    .locals 1

    .prologue
    .line 2716
    sget-object v0, Landroid/support/v4/view/ViewCompat;->a:Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;

    invoke-virtual {v0, p0}, Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;->f(Landroid/view/View;)I

    move-result v0

    return v0
.end method

.method public static k(Landroid/view/View;)I
    .locals 1

    .prologue
    .line 2727
    sget-object v0, Landroid/support/v4/view/ViewCompat;->a:Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;

    invoke-virtual {v0, p0}, Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;->g(Landroid/view/View;)I

    move-result v0

    return v0
.end method

.method public static l(Landroid/view/View;)Landroid/support/v4/view/ViewPropertyAnimatorCompat;
    .locals 1

    .prologue
    .line 2737
    sget-object v0, Landroid/support/v4/view/ViewCompat;->a:Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;

    invoke-virtual {v0, p0}, Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;->C(Landroid/view/View;)Landroid/support/v4/view/ViewPropertyAnimatorCompat;

    move-result-object v0

    return-object v0
.end method

.method public static m(Landroid/view/View;)F
    .locals 1

    .prologue
    .line 3011
    sget-object v0, Landroid/support/v4/view/ViewCompat;->a:Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;

    invoke-virtual {v0, p0}, Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;->u(Landroid/view/View;)F

    move-result v0

    return v0
.end method

.method public static n(Landroid/view/View;)F
    .locals 1

    .prologue
    .line 3027
    sget-object v0, Landroid/support/v4/view/ViewCompat;->a:Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;

    invoke-virtual {v0, p0}, Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;->v(Landroid/view/View;)F

    move-result v0

    return v0
.end method

.method public static o(Landroid/view/View;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 3052
    sget-object v0, Landroid/support/v4/view/ViewCompat;->a:Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;

    invoke-virtual {v0, p0}, Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;->t(Landroid/view/View;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static p(Landroid/view/View;)I
    .locals 1

    .prologue
    .line 3059
    sget-object v0, Landroid/support/v4/view/ViewCompat;->a:Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;

    invoke-virtual {v0, p0}, Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;->n(Landroid/view/View;)I

    move-result v0

    return v0
.end method

.method public static q(Landroid/view/View;)V
    .locals 1

    .prologue
    .line 3067
    sget-object v0, Landroid/support/v4/view/ViewCompat;->a:Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;

    invoke-virtual {v0, p0}, Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;->h(Landroid/view/View;)V

    .line 3068
    return-void
.end method

.method public static r(Landroid/view/View;)Z
    .locals 1

    .prologue
    .line 3091
    sget-object v0, Landroid/support/v4/view/ViewCompat;->a:Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;

    invoke-virtual {v0, p0}, Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;->i(Landroid/view/View;)Z

    move-result v0

    return v0
.end method

.method public static s(Landroid/view/View;)Z
    .locals 1

    .prologue
    .line 3208
    sget-object v0, Landroid/support/v4/view/ViewCompat;->a:Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;

    invoke-virtual {v0, p0}, Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;->j(Landroid/view/View;)Z

    move-result v0

    return v0
.end method

.method public static t(Landroid/view/View;)Z
    .locals 1

    .prologue
    .line 3218
    sget-object v0, Landroid/support/v4/view/ViewCompat;->a:Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;

    invoke-virtual {v0, p0}, Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;->o(Landroid/view/View;)Z

    move-result v0

    return v0
.end method

.method public static u(Landroid/view/View;)Landroid/content/res/ColorStateList;
    .locals 1

    .prologue
    .line 3238
    sget-object v0, Landroid/support/v4/view/ViewCompat;->a:Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;

    invoke-virtual {v0, p0}, Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;->y(Landroid/view/View;)Landroid/content/res/ColorStateList;

    move-result-object v0

    return-object v0
.end method

.method public static v(Landroid/view/View;)Landroid/graphics/PorterDuff$Mode;
    .locals 1

    .prologue
    .line 3260
    sget-object v0, Landroid/support/v4/view/ViewCompat;->a:Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;

    invoke-virtual {v0, p0}, Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;->z(Landroid/view/View;)Landroid/graphics/PorterDuff$Mode;

    move-result-object v0

    return-object v0
.end method

.method public static w(Landroid/view/View;)Z
    .locals 1

    .prologue
    .line 3308
    sget-object v0, Landroid/support/v4/view/ViewCompat;->a:Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;

    invoke-virtual {v0, p0}, Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;->w(Landroid/view/View;)Z

    move-result v0

    return v0
.end method

.method public static x(Landroid/view/View;)V
    .locals 1

    .prologue
    .line 3335
    sget-object v0, Landroid/support/v4/view/ViewCompat;->a:Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;

    invoke-virtual {v0, p0}, Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;->x(Landroid/view/View;)V

    .line 3336
    return-void
.end method

.method public static y(Landroid/view/View;)Z
    .locals 1

    .prologue
    .line 3625
    sget-object v0, Landroid/support/v4/view/ViewCompat;->a:Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;

    invoke-virtual {v0, p0}, Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;->r(Landroid/view/View;)Z

    move-result v0

    return v0
.end method

.method public static z(Landroid/view/View;)F
    .locals 1

    .prologue
    .line 3650
    sget-object v0, Landroid/support/v4/view/ViewCompat;->a:Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;

    invoke-virtual {v0, p0}, Landroid/support/v4/view/ViewCompat$ViewCompatBaseImpl;->A(Landroid/view/View;)F

    move-result v0

    return v0
.end method
