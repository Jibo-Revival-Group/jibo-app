.class Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment$1;
.super Ljava/lang/Object;
.source "AccountDeleteConfirmFragment.java"

# interfaces
.implements Lcom/amazonaws/handlers/AsyncHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;->onBtnDelete()V
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
        "Lcom/jibo/aws/integration/aws/services/account/model/RemoveRequest;",
        "Lcom/jibo/aws/integration/aws/services/account/model/Account;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;)V
    .locals 0

    .prologue
    .line 143
    iput-object p1, p0, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment$1;->a:Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/jibo/aws/integration/aws/services/account/model/RemoveRequest;Lcom/jibo/aws/integration/aws/services/account/model/Account;)V
    .locals 2

    .prologue
    .line 152
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment$1;->a:Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;

    new-instance v1, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment$1$1;

    invoke-direct {v1, p0}, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment$1$1;-><init>(Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment$1;)V

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;->a(Ljava/lang/Runnable;)V

    .line 165
    return-void
.end method

.method public onError(Ljava/lang/Exception;)V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 146
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment$1;->a:Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;

    const-string v1, "account remove"

    invoke-static {v0, p1, v1, v3}, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;->a(Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V

    .line 147
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment$1;->a:Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;

    iget-object v1, p0, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment$1;->a:Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;

    const v2, 0x7f10020f

    invoke-virtual {v1, v2}, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1, v3}, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;->a(Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;Ljava/lang/String;Z)V

    .line 148
    return-void
.end method

.method public synthetic onSuccess(Lcom/amazonaws/AmazonWebServiceRequest;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 143
    check-cast p1, Lcom/jibo/aws/integration/aws/services/account/model/RemoveRequest;

    check-cast p2, Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {p0, p1, p2}, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment$1;->a(Lcom/jibo/aws/integration/aws/services/account/model/RemoveRequest;Lcom/jibo/aws/integration/aws/services/account/model/Account;)V

    return-void
.end method
