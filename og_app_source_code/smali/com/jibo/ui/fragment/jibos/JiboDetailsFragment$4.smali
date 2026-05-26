.class Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$4;
.super Ljava/lang/Object;
.source "JiboDetailsFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Landroid/os/Bundle;

.field final synthetic b:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 254
    iput-object p1, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$4;->b:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    iput-object p2, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$4;->a:Landroid/os/Bundle;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 5

    .prologue
    .line 257
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$4;->b:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    const/16 v1, 0x67

    iget-object v2, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$4;->a:Landroid/os/Bundle;

    const-string v3, "ARG_TITLE"

    .line 258
    invoke-virtual {v2, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$4;->a:Landroid/os/Bundle;

    const-string v4, "ARG_MESSAGE"

    .line 259
    invoke-virtual {v3, v4}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 257
    invoke-static {v0, v1, v2, v3}, Lcom/jibo/ui/fragment/dialog/DialogUtils;->d(Landroid/support/v4/app/Fragment;ILjava/lang/String;Ljava/lang/String;)V

    .line 260
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$4;->a:Landroid/os/Bundle;

    const-string v1, "ARG_MESSAGE"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->remove(Ljava/lang/String;)V

    .line 261
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$4;->a:Landroid/os/Bundle;

    const-string v1, "ARG_TITLE"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->remove(Ljava/lang/String;)V

    .line 262
    return-void
.end method
