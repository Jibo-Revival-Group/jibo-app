.class final Lcom/jibo/ui/fragment/tips/TipsContent$2;
.super Ljava/util/ArrayList;
.source "TipsContent.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/fragment/tips/TipsContent;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/util/ArrayList",
        "<",
        "Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .locals 3

    .prologue
    .line 27
    invoke-direct {p0}, Ljava/util/ArrayList;-><init>()V

    .line 29
    new-instance v0, Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;

    const v1, 0x7f100383

    const v2, 0x7f0801f4

    invoke-direct {v0, v1, v2}, Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;-><init>(II)V

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/tips/TipsContent$2;->add(Ljava/lang/Object;)Z

    .line 30
    new-instance v0, Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;

    const v1, 0x7f100385

    const v2, 0x7f0801f3

    invoke-direct {v0, v1, v2}, Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;-><init>(II)V

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/tips/TipsContent$2;->add(Ljava/lang/Object;)Z

    .line 31
    new-instance v0, Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;

    const v1, 0x7f100386

    const v2, 0x7f0801f5

    invoke-direct {v0, v1, v2}, Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;-><init>(II)V

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/tips/TipsContent$2;->add(Ljava/lang/Object;)Z

    .line 32
    new-instance v0, Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;

    const v1, 0x7f100387

    const v2, 0x7f0801f6

    invoke-direct {v0, v1, v2}, Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;-><init>(II)V

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/tips/TipsContent$2;->add(Ljava/lang/Object;)Z

    .line 33
    new-instance v0, Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;

    const v1, 0x7f100389

    const v2, 0x7f0801f8

    invoke-direct {v0, v1, v2}, Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;-><init>(II)V

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/tips/TipsContent$2;->add(Ljava/lang/Object;)Z

    .line 34
    new-instance v0, Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;

    const v1, 0x7f100388

    const v2, 0x7f0801f7

    invoke-direct {v0, v1, v2}, Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;-><init>(II)V

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/tips/TipsContent$2;->add(Ljava/lang/Object;)Z

    .line 35
    return-void
.end method
