.class Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment$2$2;
.super Ljava/lang/Object;
.source "ResetPasswordFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment$2;->a(Lcom/jibo/aws/integration/aws/services/account/model/SendPasswordResetRequest;Lcom/jibo/aws/integration/aws/services/account/model/Account;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/aws/integration/aws/services/account/model/Account;

.field final synthetic b:Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment$2;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment$2;Lcom/jibo/aws/integration/aws/services/account/model/Account;)V
    .locals 0

    .prologue
    .line 158
    iput-object p1, p0, Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment$2$2;->b:Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment$2;

    iput-object p2, p0, Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment$2$2;->a:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 161
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment$2$2;->b:Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment$2;

    iget-object v0, v0, Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment$2;->a:Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment;->a(Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment;)Landroid/view/MenuItem;

    move-result-object v0

    const/4 v1, 0x1

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setEnabled(Z)Landroid/view/MenuItem;

    .line 163
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment$2$2;->b:Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment$2;

    iget-object v0, v0, Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment$2;->a:Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment;->g()V

    .line 166
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment$2$2;->b:Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment$2;

    iget-object v0, v0, Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment$2;->a:Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/OnBoardingActivity;

    iget-object v1, p0, Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment$2$2;->a:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getEmail()Ljava/lang/String;

    move-result-object v1

    const-string v2, ""

    invoke-virtual {v0, v1, v2}, Lcom/jibo/ui/activity/OnBoardingActivity;->c(Ljava/lang/String;Ljava/lang/String;)V

    .line 167
    return-void
.end method
