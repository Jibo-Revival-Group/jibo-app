.class Lcom/jibo/ui/fragment/tips/TipsContent$3$4;
.super Ljava/util/ArrayList;
.source "TipsContent.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/fragment/tips/TipsContent$3;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/util/ArrayList",
        "<",
        "Ljava/lang/Integer;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/tips/TipsContent$3;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/tips/TipsContent$3;)V
    .locals 1

    .prologue
    .line 64
    iput-object p1, p0, Lcom/jibo/ui/fragment/tips/TipsContent$3$4;->a:Lcom/jibo/ui/fragment/tips/TipsContent$3;

    invoke-direct {p0}, Ljava/util/ArrayList;-><init>()V

    .line 65
    const v0, 0x7f1003bd

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/tips/TipsContent$3$4;->add(Ljava/lang/Object;)Z

    .line 66
    const v0, 0x7f1003be

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/tips/TipsContent$3$4;->add(Ljava/lang/Object;)Z

    .line 67
    return-void
.end method
