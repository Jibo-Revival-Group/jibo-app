.class Lcom/jibo/ui/fragment/home/MediaFragment$CustomGridLayoutManager;
.super Landroid/support/v7/widget/GridLayoutManager;
.source "MediaFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/fragment/home/MediaFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "CustomGridLayoutManager"
.end annotation


# instance fields
.field private z:Z


# direct methods
.method public constructor <init>(Landroid/content/Context;IIZ)V
    .locals 1

    .prologue
    .line 636
    invoke-direct {p0, p1, p2, p3, p4}, Landroid/support/v7/widget/GridLayoutManager;-><init>(Landroid/content/Context;IIZ)V

    .line 625
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$CustomGridLayoutManager;->z:Z

    .line 637
    return-void
.end method


# virtual methods
.method public f()Z
    .locals 1

    .prologue
    .line 646
    iget-boolean v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$CustomGridLayoutManager;->z:Z

    if-eqz v0, :cond_0

    invoke-super {p0}, Landroid/support/v7/widget/GridLayoutManager;->f()Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
