.class Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment$2;
.super Ljava/lang/Object;
.source "ResetPasswordFragment.java"

# interfaces
.implements Lcom/amazonaws/handlers/AsyncHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment;->a()V
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
        "Lcom/jibo/aws/integration/aws/services/account/model/SendPasswordResetRequest;",
        "Lcom/jibo/aws/integration/aws/services/account/model/Account;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment;)V
    .locals 0

    .prologue
    .line 139
    iput-object p1, p0, Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment$2;->a:Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/jibo/aws/integration/aws/services/account/model/SendPasswordResetRequest;Lcom/jibo/aws/integration/aws/services/account/model/Account;)V
    .locals 2

    .prologue
    .line 158
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment$2;->a:Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment;

    new-instance v1, Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment$2$2;

    invoke-direct {v1, p0, p2}, Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment$2$2;-><init>(Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment$2;Lcom/jibo/aws/integration/aws/services/account/model/Account;)V

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment;->a(Ljava/lang/Runnable;)V

    .line 169
    return-void
.end method

.method public onError(Ljava/lang/Exception;)V
    .locals 3

    .prologue
    .line 142
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment$2;->a:Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment;

    const-string v1, "send password reset"

    const/4 v2, 0x1

    invoke-static {v0, p1, v1, v2}, Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment;->a(Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V

    move-object v0, p1

    .line 144
    check-cast v0, Lcom/amazonaws/AmazonServiceException;

    invoke-static {v0}, Lcom/jibo/utils/ErrorHelper;->b(Lcom/amazonaws/AmazonServiceException;)Z

    move-result v0

    if-nez v0, :cond_0

    check-cast p1, Lcom/amazonaws/AmazonServiceException;

    .line 145
    invoke-static {p1}, Lcom/jibo/utils/ErrorHelper;->a(Lcom/amazonaws/AmazonServiceException;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 146
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment$2;->a:Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment;

    new-instance v1, Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment$2$1;

    invoke-direct {v1, p0}, Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment$2$1;-><init>(Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment$2;)V

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment;->a(Ljava/lang/Runnable;)V

    .line 154
    :cond_0
    return-void
.end method

.method public synthetic onSuccess(Lcom/amazonaws/AmazonWebServiceRequest;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 139
    check-cast p1, Lcom/jibo/aws/integration/aws/services/account/model/SendPasswordResetRequest;

    check-cast p2, Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {p0, p1, p2}, Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment$2;->a(Lcom/jibo/aws/integration/aws/services/account/model/SendPasswordResetRequest;Lcom/jibo/aws/integration/aws/services/account/model/Account;)V

    return-void
.end method
