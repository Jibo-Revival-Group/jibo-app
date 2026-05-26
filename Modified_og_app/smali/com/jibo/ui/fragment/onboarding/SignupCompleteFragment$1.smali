.class Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment$1;
.super Ljava/lang/Object;
.source "SignupCompleteFragment.java"

# interfaces
.implements Lcom/amazonaws/handlers/AsyncHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment;->onResendVerificationEmailClick(Landroid/view/View;)V
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
        "Lcom/jibo/aws/integration/aws/services/account/model/EmailRequest;",
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
    .line 92
    iput-object p1, p0, Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment$1;->a:Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/jibo/aws/integration/aws/services/account/model/EmailRequest;Lcom/jibo/aws/integration/aws/services/account/model/Account;)V
    .locals 2

    .prologue
    .line 101
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment$1;->a:Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment;

    new-instance v1, Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment$1$1;

    invoke-direct {v1, p0}, Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment$1$1;-><init>(Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment$1;)V

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment;->a(Ljava/lang/Runnable;)V

    .line 107
    return-void
.end method

.method public onError(Ljava/lang/Exception;)V
    .locals 3

    .prologue
    .line 95
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment$1;->a:Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment;

    const-string v1, "resend activation code"

    const/4 v2, 0x1

    invoke-static {v0, p1, v1, v2}, Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment;->a(Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V

    .line 96
    return-void
.end method

.method public synthetic onSuccess(Lcom/amazonaws/AmazonWebServiceRequest;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 92
    check-cast p1, Lcom/jibo/aws/integration/aws/services/account/model/EmailRequest;

    check-cast p2, Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {p0, p1, p2}, Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment$1;->a(Lcom/jibo/aws/integration/aws/services/account/model/EmailRequest;Lcom/jibo/aws/integration/aws/services/account/model/Account;)V

    return-void
.end method
