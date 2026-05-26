.class Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment$1$1;
.super Ljava/lang/Object;
.source "AccountDeleteConfirmFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment$1;->a(Lcom/jibo/aws/integration/aws/services/account/model/RemoveRequest;Lcom/jibo/aws/integration/aws/services/account/model/Account;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment$1;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment$1;)V
    .locals 0

    .prologue
    .line 152
    iput-object p1, p0, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment$1$1;->a:Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment$1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 155
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment$1$1;->a:Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment$1;->a:Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment$1$1;->a:Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment$1;

    iget-object v1, v1, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment$1;->a:Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;

    invoke-virtual {v1}, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-static {v1}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v1

    invoke-virtual {v1}, Lcom/jibo/db/EntityData;->i()Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v1

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getId()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/jibo/aws/integration/util/KeyManager;->getInstance(Landroid/content/Context;Ljava/lang/String;)Lcom/jibo/aws/integration/util/KeyManager;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment$1$1;->a:Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment$1;

    iget-object v1, v1, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment$1;->a:Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;

    .line 156
    invoke-virtual {v1}, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/jibo/aws/integration/util/KeyManager;->deleteAccountData(Landroid/content/Context;)V

    .line 158
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment$1$1;->a:Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment$1;->a:Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment$1$1;->a:Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment$1;->a:Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    sget-object v1, Lcom/jibo/JiboAnalytics;->ak:Ljava/lang/String;

    const-string v2, ""

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 159
    :goto_0
    iget-object v1, p0, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment$1$1;->a:Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment$1;

    iget-object v1, v1, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment$1;->a:Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;

    invoke-virtual {v1}, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-static {v1}, Lcom/jibo/JiboAnalytics;->b(Landroid/content/Context;)V

    .line 160
    iget-object v1, p0, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment$1$1;->a:Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment$1;

    iget-object v1, v1, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment$1;->a:Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;

    invoke-virtual {v1}, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-static {v1, v0}, Lcom/jibo/JiboAnalytics;->d(Landroid/content/Context;Ljava/lang/String;)V

    .line 161
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment$1$1;->a:Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment$1;->a:Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;

    iget-object v1, p0, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment$1$1;->a:Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment$1;

    iget-object v1, v1, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment$1;->a:Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;

    const v2, 0x7f100213

    invoke-virtual {v1, v2}, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x1

    invoke-static {v0, v1, v2}, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;->a(Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;Ljava/lang/String;Z)V

    .line 162
    return-void

    .line 158
    :cond_0
    const-string v0, ""

    goto :goto_0
.end method
