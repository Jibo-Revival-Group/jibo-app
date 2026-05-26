.class Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment$2;
.super Ljava/lang/Object;
.source "ResetPasswordNewPasswordFragment.java"

# interfaces
.implements Lcom/amazonaws/handlers/AsyncHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment;->a()V
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
        "Lcom/jibo/aws/integration/aws/services/account/model/PasswordResetByCodeRequest;",
        "Lcom/jibo/aws/integration/aws/services/account/model/Account;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment;)V
    .locals 0

    .prologue
    .line 159
    iput-object p1, p0, Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment$2;->a:Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/jibo/aws/integration/aws/services/account/model/PasswordResetByCodeRequest;Lcom/jibo/aws/integration/aws/services/account/model/Account;)V
    .locals 3

    .prologue
    .line 179
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment$2;->a:Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment;->d()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 180
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment$2;->a:Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    const/4 v1, 0x1

    const/4 v2, 0x0

    invoke-virtual {v0, p2, v1, v2}, Lcom/jibo/db/EntityData;->a(Lcom/jibo/aws/integration/aws/services/account/model/Account;ZLcom/amazonaws/handlers/AsyncHandler;)V

    .line 183
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment$2;->a:Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment;->c(Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment;)V

    .line 184
    return-void
.end method

.method public onError(Ljava/lang/Exception;)V
    .locals 3

    .prologue
    .line 163
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment$2;->a:Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment;

    const-string v1, "password reset by code"

    const/4 v2, 0x1

    invoke-static {v0, p1, v1, v2}, Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment;->a(Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V

    move-object v0, p1

    .line 164
    check-cast v0, Lcom/amazonaws/AmazonServiceException;

    invoke-static {v0}, Lcom/jibo/utils/ErrorHelper;->b(Lcom/amazonaws/AmazonServiceException;)Z

    move-result v0

    if-nez v0, :cond_0

    check-cast p1, Lcom/amazonaws/AmazonServiceException;

    .line 165
    invoke-static {p1}, Lcom/jibo/utils/ErrorHelper;->a(Lcom/amazonaws/AmazonServiceException;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 167
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment$2;->a:Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment;

    new-instance v1, Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment$2$1;

    invoke-direct {v1, p0}, Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment$2$1;-><init>(Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment$2;)V

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment;->a(Ljava/lang/Runnable;)V

    .line 174
    :cond_0
    return-void
.end method

.method public synthetic onSuccess(Lcom/amazonaws/AmazonWebServiceRequest;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 159
    check-cast p1, Lcom/jibo/aws/integration/aws/services/account/model/PasswordResetByCodeRequest;

    check-cast p2, Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {p0, p1, p2}, Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment$2;->a(Lcom/jibo/aws/integration/aws/services/account/model/PasswordResetByCodeRequest;Lcom/jibo/aws/integration/aws/services/account/model/Account;)V

    return-void
.end method
