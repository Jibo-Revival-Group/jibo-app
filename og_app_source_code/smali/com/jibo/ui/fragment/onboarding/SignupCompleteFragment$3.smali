.class Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment$3;
.super Ljava/lang/Object;
.source "SignupCompleteFragment.java"

# interfaces
.implements Lcom/amazonaws/handlers/AsyncHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment;->a()V
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
        "Lcom/jibo/aws/integration/aws/services/account/model/ActivateByCodeRequest;",
        "Lcom/jibo/aws/integration/aws/services/account/model/Account;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment;)V
    .locals 0

    .prologue
    .line 148
    iput-object p1, p0, Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment$3;->a:Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/jibo/aws/integration/aws/services/account/model/ActivateByCodeRequest;Lcom/jibo/aws/integration/aws/services/account/model/Account;)V
    .locals 3

    .prologue
    .line 164
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment$3;->a:Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment;->d()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 165
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment$3;->a:Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    const/4 v1, 0x1

    const/4 v2, 0x0

    invoke-virtual {v0, p2, v1, v2}, Lcom/jibo/db/EntityData;->a(Lcom/jibo/aws/integration/aws/services/account/model/Account;ZLcom/amazonaws/handlers/AsyncHandler;)V

    .line 168
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment$3;->a:Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment;->c(Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment;)Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment$3;->a:Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment;

    const v2, 0x7f100021

    invoke-virtual {v1, v2}, Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->a(Ljava/lang/String;)V

    .line 169
    return-void
.end method

.method public onError(Ljava/lang/Exception;)V
    .locals 3

    .prologue
    .line 151
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment$3;->a:Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment;

    const-string v1, "activate by code"

    const/4 v2, 0x0

    invoke-static {v0, p1, v1, v2}, Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment;->b(Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V

    move-object v0, p1

    .line 153
    check-cast v0, Lcom/amazonaws/AmazonServiceException;

    invoke-static {v0}, Lcom/jibo/utils/ErrorHelper;->b(Lcom/amazonaws/AmazonServiceException;)Z

    move-result v0

    if-nez v0, :cond_0

    move-object v0, p1

    check-cast v0, Lcom/amazonaws/AmazonServiceException;

    .line 154
    invoke-static {v0}, Lcom/jibo/utils/ErrorHelper;->a(Lcom/amazonaws/AmazonServiceException;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 156
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment$3;->a:Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment;->b(Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment;)Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    move-result-object v0

    check-cast p1, Lcom/amazonaws/AmazonServiceException;

    invoke-virtual {p1}, Lcom/amazonaws/AmazonServiceException;->getErrorMessage()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->b(Ljava/lang/String;)V

    .line 158
    :cond_0
    return-void
.end method

.method public synthetic onSuccess(Lcom/amazonaws/AmazonWebServiceRequest;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 148
    check-cast p1, Lcom/jibo/aws/integration/aws/services/account/model/ActivateByCodeRequest;

    check-cast p2, Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {p0, p1, p2}, Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment$3;->a(Lcom/jibo/aws/integration/aws/services/account/model/ActivateByCodeRequest;Lcom/jibo/aws/integration/aws/services/account/model/Account;)V

    return-void
.end method
