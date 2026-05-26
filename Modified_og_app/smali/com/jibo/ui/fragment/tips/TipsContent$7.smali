.class final Lcom/jibo/ui/fragment/tips/TipsContent$7;
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
        "Ljava/util/List",
        "<",
        "Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;",
        ">;>;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .locals 2

    .prologue
    .line 166
    invoke-direct {p0}, Ljava/util/HashMap;-><init>()V

    .line 168
    const-string v0, "TAG_TIP1"

    invoke-static {}, Lcom/jibo/ui/fragment/tips/TipsContent;->a()Ljava/util/List;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/jibo/ui/fragment/tips/TipsContent$7;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 169
    const-string v0, "TAG_TIP2"

    invoke-static {}, Lcom/jibo/ui/fragment/tips/TipsContent;->b()Ljava/util/List;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/jibo/ui/fragment/tips/TipsContent$7;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 170
    const-string v0, "TAG_TIP3"

    invoke-static {}, Lcom/jibo/ui/fragment/tips/TipsContent;->c()Ljava/util/List;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/jibo/ui/fragment/tips/TipsContent$7;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 171
    const-string v0, "TAG_TIP4"

    invoke-static {}, Lcom/jibo/ui/fragment/tips/TipsContent;->d()Ljava/util/List;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/jibo/ui/fragment/tips/TipsContent$7;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 172
    const-string v0, "TAG_TIP5"

    invoke-static {}, Lcom/jibo/ui/fragment/tips/TipsContent;->e()Ljava/util/List;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/jibo/ui/fragment/tips/TipsContent$7;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 173
    return-void
.end method
