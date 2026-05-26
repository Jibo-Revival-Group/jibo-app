.class Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment$2;
.super Ljava/lang/Object;
.source "AccountDeleteConfirmFragment.java"

# interfaces
.implements Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$OnDismissListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;->a()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;)V
    .locals 0

    .prologue
    .line 191
    iput-object p1, p0, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment$2;->a:Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$Status;)V
    .locals 3

    .prologue
    .line 194
    sget-object v0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$Status;->Success:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$Status;

    if-ne p1, v0, :cond_0

    .line 195
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment$2;->a:Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment$2;->a:Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    sget-object v1, Lcom/jibo/JiboAnalytics;->ak:Ljava/lang/String;

    const-string v2, ""

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 196
    :goto_0
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 197
    sget-object v2, Lcom/jibo/JiboAnalytics;->ak:Ljava/lang/String;

    invoke-virtual {v1, v2, v0}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 198
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment$2;->a:Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/BaseActivity;

    const-class v2, Lcom/jibo/ui/fragment/account/AccountDeletedFragment;

    invoke-virtual {v0, v2, v1}, Lcom/jibo/ui/activity/BaseActivity;->a(Ljava/lang/Class;Landroid/os/Bundle;)V

    .line 200
    :cond_0
    return-void

    .line 195
    :cond_1
    const-string v0, ""

    goto :goto_0
.end method
