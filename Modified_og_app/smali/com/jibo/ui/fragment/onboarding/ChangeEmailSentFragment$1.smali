.class Lcom/jibo/ui/fragment/onboarding/ChangeEmailSentFragment$1;
.super Ljava/lang/Object;
.source "ChangeEmailSentFragment.java"

# interfaces
.implements Lcom/amazonaws/handlers/AsyncHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/onboarding/ChangeEmailSentFragment;->a(IILjava/lang/Object;)V
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
        "Lcom/jibo/aws/integration/aws/services/account/model/ChangeEmailRequest;",
        "Lcom/jibo/aws/integration/aws/services/common/model/IdResponse;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/onboarding/ChangeEmailSentFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/onboarding/ChangeEmailSentFragment;)V
    .locals 0

    .prologue
    .line 121
    iput-object p1, p0, Lcom/jibo/ui/fragment/onboarding/ChangeEmailSentFragment$1;->a:Lcom/jibo/ui/fragment/onboarding/ChangeEmailSentFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/jibo/aws/integration/aws/services/account/model/ChangeEmailRequest;Lcom/jibo/aws/integration/aws/services/common/model/IdResponse;)V
    .locals 2

    .prologue
    .line 137
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/ChangeEmailSentFragment$1;->a:Lcom/jibo/ui/fragment/onboarding/ChangeEmailSentFragment;

    new-instance v1, Lcom/jibo/ui/fragment/onboarding/ChangeEmailSentFragment$1$2;

    invoke-direct {v1, p0}, Lcom/jibo/ui/fragment/onboarding/ChangeEmailSentFragment$1$2;-><init>(Lcom/jibo/ui/fragment/onboarding/ChangeEmailSentFragment$1;)V

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/onboarding/ChangeEmailSentFragment;->a(Ljava/lang/Runnable;)V

    .line 143
    return-void
.end method

.method public onError(Ljava/lang/Exception;)V
    .locals 3

    .prologue
    .line 124
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/ChangeEmailSentFragment$1;->a:Lcom/jibo/ui/fragment/onboarding/ChangeEmailSentFragment;

    const-string v1, "change email"

    const/4 v2, 0x0

    invoke-static {v0, p1, v1, v2}, Lcom/jibo/ui/fragment/onboarding/ChangeEmailSentFragment;->a(Lcom/jibo/ui/fragment/onboarding/ChangeEmailSentFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V

    .line 125
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/ChangeEmailSentFragment$1;->a:Lcom/jibo/ui/fragment/onboarding/ChangeEmailSentFragment;

    new-instance v1, Lcom/jibo/ui/fragment/onboarding/ChangeEmailSentFragment$1$1;

    invoke-direct {v1, p0}, Lcom/jibo/ui/fragment/onboarding/ChangeEmailSentFragment$1$1;-><init>(Lcom/jibo/ui/fragment/onboarding/ChangeEmailSentFragment$1;)V

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/onboarding/ChangeEmailSentFragment;->a(Ljava/lang/Runnable;)V

    .line 133
    return-void
.end method

.method public synthetic onSuccess(Lcom/amazonaws/AmazonWebServiceRequest;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 121
    check-cast p1, Lcom/jibo/aws/integration/aws/services/account/model/ChangeEmailRequest;

    check-cast p2, Lcom/jibo/aws/integration/aws/services/common/model/IdResponse;

    invoke-virtual {p0, p1, p2}, Lcom/jibo/ui/fragment/onboarding/ChangeEmailSentFragment$1;->a(Lcom/jibo/aws/integration/aws/services/account/model/ChangeEmailRequest;Lcom/jibo/aws/integration/aws/services/common/model/IdResponse;)V

    return-void
.end method
