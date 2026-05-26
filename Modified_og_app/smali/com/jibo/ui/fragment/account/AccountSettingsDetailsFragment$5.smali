.class Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment$5;
.super Ljava/lang/Object;
.source "AccountSettingsDetailsFragment.java"

# interfaces
.implements Lcom/amazonaws/handlers/AsyncHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->u()V
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
        "Lcom/jibo/aws/integration/aws/services/account/model/UpdateRequest;",
        "Lcom/jibo/aws/integration/aws/services/account/model/Account;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;)V
    .locals 0

    .prologue
    .line 434
    iput-object p1, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment$5;->a:Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/jibo/aws/integration/aws/services/account/model/UpdateRequest;Lcom/jibo/aws/integration/aws/services/account/model/Account;)V
    .locals 2

    .prologue
    .line 450
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment$5;->a:Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->g()V

    .line 452
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment$5;->a:Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;

    new-instance v1, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment$5$2;

    invoke-direct {v1, p0, p2}, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment$5$2;-><init>(Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment$5;Lcom/jibo/aws/integration/aws/services/account/model/Account;)V

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->a(Ljava/lang/Runnable;)V

    .line 465
    return-void
.end method

.method public onError(Ljava/lang/Exception;)V
    .locals 3

    .prologue
    .line 437
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment$5;->a:Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;

    const-string v1, "update account"

    const/4 v2, 0x1

    invoke-static {v0, p1, v1, v2}, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->b(Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V

    .line 439
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment$5;->a:Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;

    new-instance v1, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment$5$1;

    invoke-direct {v1, p0}, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment$5$1;-><init>(Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment$5;)V

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->a(Ljava/lang/Runnable;)V

    .line 446
    return-void
.end method

.method public synthetic onSuccess(Lcom/amazonaws/AmazonWebServiceRequest;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 434
    check-cast p1, Lcom/jibo/aws/integration/aws/services/account/model/UpdateRequest;

    check-cast p2, Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {p0, p1, p2}, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment$5;->a(Lcom/jibo/aws/integration/aws/services/account/model/UpdateRequest;Lcom/jibo/aws/integration/aws/services/account/model/Account;)V

    return-void
.end method
