.class final Lcom/jibo/ui/fragment/tips/TipsContent$8;
.super Ljava/util/HashMap;
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
        "Ljava/util/HashMap",
        "<",
        "Ljava/lang/String;",
        "Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .locals 7

    .prologue
    const/4 v4, -0x1

    .line 176
    invoke-direct {p0}, Ljava/util/HashMap;-><init>()V

    .line 178
    const-string v0, "TAG_TIP1"

    new-instance v1, Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;

    const v2, 0x7f100384

    const v3, 0x7f0801f2

    const v5, 0x7f1003f1

    invoke-direct {v1, v2, v3, v5, v4}, Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;-><init>(IIII)V

    invoke-virtual {p0, v0, v1}, Lcom/jibo/ui/fragment/tips/TipsContent$8;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 179
    const-string v0, "TAG_TIP2"

    new-instance v1, Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;

    const v2, 0x7f1003d7

    const v3, 0x7f080201

    const v5, 0x7f1003f4

    invoke-direct {v1, v2, v3, v5, v4}, Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;-><init>(IIII)V

    invoke-virtual {p0, v0, v1}, Lcom/jibo/ui/fragment/tips/TipsContent$8;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 180
    const-string v0, "TAG_TIP3"

    new-instance v1, Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;

    const v2, 0x7f1003d1

    const v3, 0x7f0801fb

    const v5, 0x7f1003f3

    invoke-direct {v1, v2, v3, v5, v4}, Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;-><init>(IIII)V

    invoke-virtual {p0, v0, v1}, Lcom/jibo/ui/fragment/tips/TipsContent$8;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 181
    const-string v0, "TAG_TIP4"

    new-instance v1, Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;

    const v2, 0x7f10038a

    const v3, 0x7f0801f9

    const v5, 0x7f1003f2

    invoke-direct {v1, v2, v3, v5, v4}, Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;-><init>(IIII)V

    invoke-virtual {p0, v0, v1}, Lcom/jibo/ui/fragment/tips/TipsContent$8;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 182
    const-string v6, "TAG_TIP5"

    new-instance v0, Lcom/jibo/ui/fragment/tips/TipsFragment$VideoTip;

    const v1, 0x7f1003df

    const v2, 0x7f080208

    const v3, 0x7f1003f5

    const v5, 0x7f1003e0

    invoke-direct/range {v0 .. v5}, Lcom/jibo/ui/fragment/tips/TipsFragment$VideoTip;-><init>(IIIII)V

    invoke-virtual {p0, v6, v0}, Lcom/jibo/ui/fragment/tips/TipsContent$8;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 183
    return-void
.end method
