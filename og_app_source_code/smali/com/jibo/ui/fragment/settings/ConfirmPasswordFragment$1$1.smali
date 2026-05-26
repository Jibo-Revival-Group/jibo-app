.class Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment$1$1;
.super Ljava/lang/Object;
.source "ConfirmPasswordFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment$1;->a(Lcom/jibo/aws/integration/aws/services/account/model/SendPasswordResetRequest;Lcom/jibo/aws/integration/aws/services/account/model/Account;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment$1;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment$1;)V
    .locals 0

    .prologue
    .line 142
    iput-object p1, p0, Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment$1$1;->a:Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment$1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 145
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment$1$1;->a:Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment$1;->b:Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment;->g()V

    .line 147
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 148
    const-string v0, "email"

    iget-object v2, p0, Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment$1$1;->a:Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment$1;

    iget-object v2, v2, Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment$1;->a:Ljava/lang/String;

    invoke-virtual {v1, v0, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 149
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment$1$1;->a:Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment$1;->b:Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/BaseActivity;

    const-class v2, Lcom/jibo/ui/fragment/onboarding/ResetPasswordSentFragment;

    invoke-virtual {v0, v2, v1}, Lcom/jibo/ui/activity/BaseActivity;->a(Ljava/lang/Class;Landroid/os/Bundle;)V

    .line 150
    return-void
.end method
