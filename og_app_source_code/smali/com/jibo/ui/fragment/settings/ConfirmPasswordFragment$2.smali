.class Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment$2;
.super Ljava/lang/Object;
.source "ConfirmPasswordFragment.java"

# interfaces
.implements Lcom/amazonaws/handlers/AsyncHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment;->q()V
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
        "Lcom/jibo/aws/integration/aws/services/account/model/ChangePasswordRequest;",
        "Lcom/jibo/aws/integration/aws/services/account/model/Account;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment;)V
    .locals 0

    .prologue
    .line 175
    iput-object p1, p0, Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment$2;->a:Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/jibo/aws/integration/aws/services/account/model/ChangePasswordRequest;Lcom/jibo/aws/integration/aws/services/account/model/Account;)V
    .locals 2

    .prologue
    .line 194
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment$2;->a:Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment;

    new-instance v1, Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment$2$2;

    invoke-direct {v1, p0}, Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment$2$2;-><init>(Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment$2;)V

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment;->a(Ljava/lang/Runnable;)V

    .line 204
    return-void
.end method

.method public onError(Ljava/lang/Exception;)V
    .locals 3

    .prologue
    .line 178
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment$2;->a:Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment;

    const-string v1, "change password"

    const/4 v2, 0x0

    invoke-static {v0, p1, v1, v2}, Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment;->b(Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V

    move-object v0, p1

    .line 179
    check-cast v0, Lcom/amazonaws/AmazonServiceException;

    invoke-static {v0}, Lcom/jibo/utils/ErrorHelper;->b(Lcom/amazonaws/AmazonServiceException;)Z

    move-result v0

    if-nez v0, :cond_0

    check-cast p1, Lcom/amazonaws/AmazonServiceException;

    .line 180
    invoke-static {p1}, Lcom/jibo/utils/ErrorHelper;->a(Lcom/amazonaws/AmazonServiceException;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 182
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment$2;->a:Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment;

    new-instance v1, Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment$2$1;

    invoke-direct {v1, p0}, Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment$2$1;-><init>(Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment$2;)V

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment;->a(Ljava/lang/Runnable;)V

    .line 190
    :cond_0
    return-void
.end method

.method public synthetic onSuccess(Lcom/amazonaws/AmazonWebServiceRequest;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 175
    check-cast p1, Lcom/jibo/aws/integration/aws/services/account/model/ChangePasswordRequest;

    check-cast p2, Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {p0, p1, p2}, Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment$2;->a(Lcom/jibo/aws/integration/aws/services/account/model/ChangePasswordRequest;Lcom/jibo/aws/integration/aws/services/account/model/Account;)V

    return-void
.end method
