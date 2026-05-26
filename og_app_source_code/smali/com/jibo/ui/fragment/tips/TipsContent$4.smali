.class final Lcom/jibo/ui/fragment/tips/TipsContent$4;
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
    .line 132
    invoke-direct {p0}, Ljava/util/ArrayList;-><init>()V

    .line 134
    new-instance v0, Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;

    const v1, 0x7f1003d2

    const v2, 0x7f0801fc

    invoke-direct {v0, v1, v2}, Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;-><init>(II)V

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/tips/TipsContent$4;->add(Ljava/lang/Object;)Z

    .line 135
    new-instance v0, Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;

    const v1, 0x7f1003d3

    const v2, 0x7f0801fd

    invoke-direct {v0, v1, v2}, Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;-><init>(II)V

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/tips/TipsContent$4;->add(Ljava/lang/Object;)Z

    .line 136
    new-instance v0, Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;

    const v1, 0x7f1003d4

    const v2, 0x7f0801fe

    invoke-direct {v0, v1, v2}, Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;-><init>(II)V

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/tips/TipsContent$4;->add(Ljava/lang/Object;)Z

    .line 137
    new-instance v0, Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;

    const v1, 0x7f1003d5

    const v2, 0x7f0801ff

    invoke-direct {v0, v1, v2}, Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;-><init>(II)V

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/tips/TipsContent$4;->add(Ljava/lang/Object;)Z

    .line 138
    new-instance v0, Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;

    const v1, 0x7f1003d6

    const v2, 0x7f080200

    invoke-direct {v0, v1, v2}, Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;-><init>(II)V

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/tips/TipsContent$4;->add(Ljava/lang/Object;)Z

    .line 139
    return-void
.end method
