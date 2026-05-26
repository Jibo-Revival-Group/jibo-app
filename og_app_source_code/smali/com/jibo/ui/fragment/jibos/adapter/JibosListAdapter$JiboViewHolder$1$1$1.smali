.class Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboViewHolder$1$1$1;
.super Ljava/lang/Object;
.source "JibosListAdapter.java"

# interfaces
.implements Lcom/amazonaws/handlers/AsyncHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboViewHolder$1$1;->onClick(Landroid/content/DialogInterface;I)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/amazonaws/handlers/AsyncHandler",
        "<",
        "Lcom/jibo/aws/integration/aws/services/loop/model/RemoveRequest;",
        "Lcom/jibo/aws/integration/aws/services/loop/model/Loop;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboViewHolder$1$1;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboViewHolder$1$1;)V
    .locals 0

    .prologue
    .line 319
    iput-object p1, p0, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboViewHolder$1$1$1;->a:Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboViewHolder$1$1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/jibo/aws/integration/aws/services/loop/model/RemoveRequest;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V
    .locals 2

    .prologue
    .line 327
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboViewHolder$1$1$1;->a:Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboViewHolder$1$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboViewHolder$1$1;->a:Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboViewHolder$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboViewHolder$1;->c:Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboViewHolder;

    iget-object v0, v0, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboViewHolder;->itemView:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {p2}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/jibo/db/EntityData;->b(Ljava/lang/String;)V

    .line 328
    return-void
.end method

.method public onError(Ljava/lang/Exception;)V
    .locals 0

    .prologue
    .line 323
    return-void
.end method

.method public synthetic onSuccess(Lcom/amazonaws/AmazonWebServiceRequest;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 319
    check-cast p1, Lcom/jibo/aws/integration/aws/services/loop/model/RemoveRequest;

    check-cast p2, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {p0, p1, p2}, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboViewHolder$1$1$1;->a(Lcom/jibo/aws/integration/aws/services/loop/model/RemoveRequest;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V

    return-void
.end method
