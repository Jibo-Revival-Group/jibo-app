.class Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboViewHolder$1$1;
.super Ljava/lang/Object;
.source "JibosListAdapter.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboViewHolder$1;->onLongClick(Landroid/view/View;)Z
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboViewHolder$1;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboViewHolder$1;)V
    .locals 0

    .prologue
    .line 314
    iput-object p1, p0, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboViewHolder$1$1;->a:Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboViewHolder$1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 3

    .prologue
    .line 317
    const/4 v0, -0x1

    if-ne p2, v0, :cond_0

    .line 318
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboViewHolder$1$1;->a:Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboViewHolder$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboViewHolder$1;->c:Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboViewHolder;

    iget-object v0, v0, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboViewHolder;->itemView:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/db/EntityData;->b()Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboViewHolder$1$1;->a:Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboViewHolder$1;

    iget-object v1, v1, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboViewHolder$1;->b:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getId()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboViewHolder$1$1$1;

    invoke-direct {v2, p0}, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboViewHolder$1$1$1;-><init>(Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboViewHolder$1$1;)V

    invoke-virtual {v0, v1, v2}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;->removeLoop(Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;

    .line 331
    :cond_0
    return-void
.end method
