.class Lcom/jibo/ui/fragment/jibos/JibosListFragment$1;
.super Ljava/lang/Object;
.source "JibosListFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/jibos/JibosListFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/jibos/JibosListFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/jibos/JibosListFragment;)V
    .locals 0

    .prologue
    .line 104
    iput-object p1, p0, Lcom/jibo/ui/fragment/jibos/JibosListFragment$1;->a:Lcom/jibo/ui/fragment/jibos/JibosListFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 5

    .prologue
    .line 107
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JibosListFragment$1;->a:Lcom/jibo/ui/fragment/jibos/JibosListFragment;

    const/4 v1, 0x1

    iget-object v2, p0, Lcom/jibo/ui/fragment/jibos/JibosListFragment$1;->a:Lcom/jibo/ui/fragment/jibos/JibosListFragment;

    const v3, 0x7f10021a

    .line 108
    invoke-virtual {v2, v3}, Lcom/jibo/ui/fragment/jibos/JibosListFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/jibo/ui/fragment/jibos/JibosListFragment$1;->a:Lcom/jibo/ui/fragment/jibos/JibosListFragment;

    .line 109
    invoke-virtual {v3}, Lcom/jibo/ui/fragment/jibos/JibosListFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v3

    const-string v4, "ARG_MESSAGE"

    invoke-virtual {v3, v4}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 107
    invoke-static {v0, v1, v2, v3}, Lcom/jibo/ui/fragment/dialog/DialogUtils;->d(Landroid/support/v4/app/Fragment;ILjava/lang/String;Ljava/lang/String;)V

    .line 110
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JibosListFragment$1;->a:Lcom/jibo/ui/fragment/jibos/JibosListFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/jibos/JibosListFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "ARG_MESSAGE"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->remove(Ljava/lang/String;)V

    .line 111
    return-void
.end method
