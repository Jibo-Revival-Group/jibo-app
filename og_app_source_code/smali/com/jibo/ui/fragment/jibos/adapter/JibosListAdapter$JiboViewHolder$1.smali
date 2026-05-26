.class Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboViewHolder$1;
.super Ljava/lang/Object;
.source "JibosListAdapter.java"

# interfaces
.implements Landroid/view/View$OnLongClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboViewHolder;->a(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Lcom/jibo/aws/integration/aws/services/account/model/Account;Landroid/view/View$OnClickListener;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/aws/integration/aws/services/account/model/Account;

.field final synthetic b:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

.field final synthetic c:Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboViewHolder;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboViewHolder;Lcom/jibo/aws/integration/aws/services/account/model/Account;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V
    .locals 0

    .prologue
    .line 303
    iput-object p1, p0, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboViewHolder$1;->c:Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboViewHolder;

    iput-object p2, p0, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboViewHolder$1;->a:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    iput-object p3, p0, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboViewHolder$1;->b:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onLongClick(Landroid/view/View;)Z
    .locals 3

    .prologue
    .line 306
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboViewHolder$1;->a:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getId()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboViewHolder$1;->b:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getOwner()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 308
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboViewHolder$1;->b:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->isSuspended()Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 309
    new-instance v0, Landroid/support/v7/app/AlertDialog$Builder;

    iget-object v1, p0, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboViewHolder$1;->c:Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboViewHolder;

    iget-object v1, v1, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboViewHolder;->itemView:Landroid/view/View;

    invoke-virtual {v1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/support/v7/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    const-string v1, "Warning"

    .line 310
    invoke-virtual {v0, v1}, Landroid/support/v7/app/AlertDialog$Builder;->a(Ljava/lang/CharSequence;)Landroid/support/v7/app/AlertDialog$Builder;

    move-result-object v0

    const-string v1, "Do you want to delete this loop?"

    .line 311
    invoke-virtual {v0, v1}, Landroid/support/v7/app/AlertDialog$Builder;->b(Ljava/lang/CharSequence;)Landroid/support/v7/app/AlertDialog$Builder;

    move-result-object v0

    const/4 v1, 0x0

    .line 312
    invoke-virtual {v0, v1}, Landroid/support/v7/app/AlertDialog$Builder;->a(Z)Landroid/support/v7/app/AlertDialog$Builder;

    move-result-object v0

    const-string v1, "Cancel"

    const/4 v2, 0x0

    .line 313
    invoke-virtual {v0, v1, v2}, Landroid/support/v7/app/AlertDialog$Builder;->b(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/support/v7/app/AlertDialog$Builder;

    move-result-object v0

    const-string v1, "Ok"

    new-instance v2, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboViewHolder$1$1;

    invoke-direct {v2, p0}, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboViewHolder$1$1;-><init>(Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboViewHolder$1;)V

    .line 314
    invoke-virtual {v0, v1, v2}, Landroid/support/v7/app/AlertDialog$Builder;->a(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/support/v7/app/AlertDialog$Builder;

    move-result-object v0

    .line 332
    invoke-virtual {v0}, Landroid/support/v7/app/AlertDialog$Builder;->c()Landroid/support/v7/app/AlertDialog;

    .line 335
    :cond_0
    const/4 v0, 0x1

    return v0
.end method
