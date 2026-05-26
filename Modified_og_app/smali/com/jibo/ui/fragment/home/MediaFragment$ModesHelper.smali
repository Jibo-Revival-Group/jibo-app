.class public Lcom/jibo/ui/fragment/home/MediaFragment$ModesHelper;
.super Ljava/lang/Object;
.source "MediaFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/fragment/home/MediaFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ModesHelper"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/jibo/ui/fragment/home/MediaFragment$ModesHelper$Mode;
    }
.end annotation


# static fields
.field private static final a:[I

.field private static final b:[F

.field private static c:Lcom/jibo/ui/fragment/home/MediaFragment$ModesHelper$Mode;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    const/4 v1, 0x2

    .line 1648
    new-array v0, v1, [I

    fill-array-data v0, :array_0

    sput-object v0, Lcom/jibo/ui/fragment/home/MediaFragment$ModesHelper;->a:[I

    .line 1649
    new-array v0, v1, [F

    fill-array-data v0, :array_1

    sput-object v0, Lcom/jibo/ui/fragment/home/MediaFragment$ModesHelper;->b:[F

    .line 1651
    sget-object v0, Lcom/jibo/ui/fragment/home/MediaFragment$ModesHelper$Mode;->Timeline:Lcom/jibo/ui/fragment/home/MediaFragment$ModesHelper$Mode;

    sput-object v0, Lcom/jibo/ui/fragment/home/MediaFragment$ModesHelper;->c:Lcom/jibo/ui/fragment/home/MediaFragment$ModesHelper$Mode;

    return-void

    .line 1648
    :array_0
    .array-data 4
        0x6
        0x4
    .end array-data

    .line 1649
    :array_1
    .array-data 4
        0x3fe38e38
        0x3f800000    # 1.0f
    .end array-data
.end method

.method public static a(Landroid/content/Context;)Landroid/support/v7/widget/RecyclerView$ItemDecoration;
    .locals 2

    .prologue
    .line 1688
    new-instance v0, Lcom/jibo/ui/fragment/home/MediaFragment$SpacesItemDecoration;

    const v1, 0x7f0700e3

    invoke-direct {v0, p0, v1}, Lcom/jibo/ui/fragment/home/MediaFragment$SpacesItemDecoration;-><init>(Landroid/content/Context;I)V

    return-object v0
.end method

.method public static a(Landroid/content/Context;Lcom/jibo/ui/fragment/home/MediaFragment$ModesHelper$Mode;)V
    .locals 3

    .prologue
    .line 1660
    invoke-static {}, Lcom/jibo/ui/fragment/home/MediaFragment$ModesHelper$Mode;->values()[Lcom/jibo/ui/fragment/home/MediaFragment$ModesHelper$Mode;

    move-result-object v0

    invoke-virtual {p1}, Lcom/jibo/ui/fragment/home/MediaFragment$ModesHelper$Mode;->ordinal()I

    move-result v1

    aget-object v0, v0, v1

    sput-object v0, Lcom/jibo/ui/fragment/home/MediaFragment$ModesHelper;->c:Lcom/jibo/ui/fragment/home/MediaFragment$ModesHelper$Mode;

    .line 1661
    const v0, 0x7f100037

    .line 1662
    invoke-virtual {p0, v0}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x0

    .line 1661
    invoke-virtual {p0, v0, v1}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 1663
    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "PREF_MEDIA_TAB_MODE"

    invoke-virtual {p1}, Lcom/jibo/ui/fragment/home/MediaFragment$ModesHelper$Mode;->ordinal()I

    move-result v2

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->apply()V

    .line 1664
    return-void
.end method

.method public static a()Z
    .locals 2

    .prologue
    .line 1667
    sget-object v0, Lcom/jibo/ui/fragment/home/MediaFragment$ModesHelper;->c:Lcom/jibo/ui/fragment/home/MediaFragment$ModesHelper$Mode;

    sget-object v1, Lcom/jibo/ui/fragment/home/MediaFragment$ModesHelper$Mode;->Timeline:Lcom/jibo/ui/fragment/home/MediaFragment$ModesHelper$Mode;

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static b()I
    .locals 2

    .prologue
    .line 1671
    sget-object v0, Lcom/jibo/ui/fragment/home/MediaFragment$ModesHelper;->a:[I

    sget-object v1, Lcom/jibo/ui/fragment/home/MediaFragment$ModesHelper;->c:Lcom/jibo/ui/fragment/home/MediaFragment$ModesHelper$Mode;

    invoke-virtual {v1}, Lcom/jibo/ui/fragment/home/MediaFragment$ModesHelper$Mode;->ordinal()I

    move-result v1

    aget v0, v0, v1

    return v0
.end method

.method public static c()F
    .locals 2

    .prologue
    .line 1675
    sget-object v0, Lcom/jibo/ui/fragment/home/MediaFragment$ModesHelper;->b:[F

    sget-object v1, Lcom/jibo/ui/fragment/home/MediaFragment$ModesHelper;->c:Lcom/jibo/ui/fragment/home/MediaFragment$ModesHelper$Mode;

    invoke-virtual {v1}, Lcom/jibo/ui/fragment/home/MediaFragment$ModesHelper$Mode;->ordinal()I

    move-result v1

    aget v0, v0, v1

    return v0
.end method
