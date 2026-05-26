.class Lcom/jibo/ui/fragment/settings/ChangePasswordFragment$2;
.super Ljava/lang/Object;
.source "ChangePasswordFragment.java"

# interfaces
.implements Lcom/amazonaws/handlers/AsyncHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/settings/ChangePasswordFragment;->a()V
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
.field final synthetic a:Lcom/jibo/ui/fragment/settings/ChangePasswordFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/settings/ChangePasswordFragment;)V
    .locals 0

    .prologue
    .line 162
    iput-object p1, p0, Lcom/jibo/ui/fragment/settings/ChangePasswordFragment$2;->a:Lcom/jibo/ui/fragment/settings/ChangePasswordFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/jibo/aws/integration/aws/services/account/model/ChangePasswordRequest;Lcom/jibo/aws/integration/aws/services/account/model/Account;)V
    .locals 2

    .prologue
    .line 170
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/ChangePasswordFragment$2;->a:Lcom/jibo/ui/fragment/settings/ChangePasswordFragment;

    new-instance v1, Lcom/jibo/ui/fragment/settings/ChangePasswordFragment$2$1;

    invoke-direct {v1, p0}, Lcom/jibo/ui/fragment/settings/ChangePasswordFragment$2$1;-><init>(Lcom/jibo/ui/fragment/settings/ChangePasswordFragment$2;)V

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/settings/ChangePasswordFragment;->a(Ljava/lang/Runnable;)V

    .line 180
    return-void
.end method

.method public onError(Ljava/lang/Exception;)V
    .locals 3

    .prologue
    .line 165
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/ChangePasswordFragment$2;->a:Lcom/jibo/ui/fragment/settings/ChangePasswordFragment;

    const-string v1, "change password"

    const/4 v2, 0x0

    invoke-static {v0, p1, v1, v2}, Lcom/jibo/ui/fragment/settings/ChangePasswordFragment;->a(Lcom/jibo/ui/fragment/settings/ChangePasswordFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V

    .line 166
    return-void
.end method

.method public synthetic onSuccess(Lcom/amazonaws/AmazonWebServiceRequest;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 162
    check-cast p1, Lcom/jibo/aws/integration/aws/services/account/model/ChangePasswordRequest;

    check-cast p2, Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {p0, p1, p2}, Lcom/jibo/ui/fragment/settings/ChangePasswordFragment$2;->a(Lcom/jibo/aws/integration/aws/services/account/model/ChangePasswordRequest;Lcom/jibo/aws/integration/aws/services/account/model/Account;)V

    return-void
.end method
