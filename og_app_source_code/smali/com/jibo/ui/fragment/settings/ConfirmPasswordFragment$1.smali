.class Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment$1;
.super Ljava/lang/Object;
.source "ConfirmPasswordFragment.java"

# interfaces
.implements Lcom/amazonaws/handlers/AsyncHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment;->onForgotPasswordClick(Landroid/view/View;)V
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
.field final synthetic a:Ljava/lang/String;

.field final synthetic b:Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 133
    iput-object p1, p0, Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment$1;->b:Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment;

    iput-object p2, p0, Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment$1;->a:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/jibo/aws/integration/aws/services/account/model/SendPasswordResetRequest;Lcom/jibo/aws/integration/aws/services/account/model/Account;)V
    .locals 2

    .prologue
    .line 142
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment$1;->b:Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment;

    new-instance v1, Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment$1$1;

    invoke-direct {v1, p0}, Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment$1$1;-><init>(Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment$1;)V

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment;->a(Ljava/lang/Runnable;)V

    .line 152
    return-void
.end method

.method public onError(Ljava/lang/Exception;)V
    .locals 3

    .prologue
    .line 136
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment$1;->b:Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment;

    const-string v1, "send password reset"

    const/4 v2, 0x1

    invoke-static {v0, p1, v1, v2}, Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment;->a(Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V

    .line 137
    return-void
.end method

.method public synthetic onSuccess(Lcom/amazonaws/AmazonWebServiceRequest;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 133
    check-cast p1, Lcom/jibo/aws/integration/aws/services/account/model/SendPasswordResetRequest;

    check-cast p2, Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {p0, p1, p2}, Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment$1;->a(Lcom/jibo/aws/integration/aws/services/account/model/SendPasswordResetRequest;Lcom/jibo/aws/integration/aws/services/account/model/Account;)V

    return-void
.end method
