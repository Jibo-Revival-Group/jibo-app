.class final Lcom/jibo/ui/fragment/tips/TipsContent$6;
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
    .locals 4

    .prologue
    .line 155
    invoke-direct {p0}, Ljava/util/ArrayList;-><init>()V

    .line 157
    new-instance v0, Lcom/jibo/ui/fragment/tips/TipsFragment$VideoTip;

    const v1, 0x7f1003df

    const v2, 0x7f080208

    const v3, 0x7f1003e0

    invoke-direct {v0, v1, v2, v3}, Lcom/jibo/ui/fragment/tips/TipsFragment$VideoTip;-><init>(III)V

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/tips/TipsContent$6;->add(Ljava/lang/Object;)Z

    .line 158
    new-instance v0, Lcom/jibo/ui/fragment/tips/TipsFragment$VideoTip;

    const v1, 0x7f1003e1

    const v2, 0x7f080209

    const v3, 0x7f1003e2

    invoke-direct {v0, v1, v2, v3}, Lcom/jibo/ui/fragment/tips/TipsFragment$VideoTip;-><init>(III)V

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/tips/TipsContent$6;->add(Ljava/lang/Object;)Z

    .line 159
    new-instance v0, Lcom/jibo/ui/fragment/tips/TipsFragment$VideoTip;

    const v1, 0x7f1003e3

    const v2, 0x7f08020a

    const v3, 0x7f1003e4

    invoke-direct {v0, v1, v2, v3}, Lcom/jibo/ui/fragment/tips/TipsFragment$VideoTip;-><init>(III)V

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/tips/TipsContent$6;->add(Ljava/lang/Object;)Z

    .line 160
    new-instance v0, Lcom/jibo/ui/fragment/tips/TipsFragment$VideoTip;

    const v1, 0x7f1003e5

    const v2, 0x7f08020b

    const v3, 0x7f1003e6

    invoke-direct {v0, v1, v2, v3}, Lcom/jibo/ui/fragment/tips/TipsFragment$VideoTip;-><init>(III)V

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/tips/TipsContent$6;->add(Ljava/lang/Object;)Z

    .line 163
    return-void
.end method
