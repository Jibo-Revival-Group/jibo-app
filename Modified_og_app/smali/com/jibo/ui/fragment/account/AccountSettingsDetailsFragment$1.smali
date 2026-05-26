.class Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment$1;
.super Ljava/lang/Object;
.source "AccountSettingsDetailsFragment.java"

# interfaces
.implements Lcom/amazonaws/handlers/AsyncHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;
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
        "Lcom/jibo/aws/integration/aws/services/account/model/FacebookMobileConnectRequest;",
        "Lcom/jibo/aws/integration/aws/services/account/model/TokenContainer;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;)V
    .locals 0

    .prologue
    .line 109
    iput-object p1, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment$1;->a:Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/jibo/aws/integration/aws/services/account/model/FacebookMobileConnectRequest;Lcom/jibo/aws/integration/aws/services/account/model/TokenContainer;)V
    .locals 0

    .prologue
    .line 118
    return-void
.end method

.method public onError(Ljava/lang/Exception;)V
    .locals 3

    .prologue
    .line 112
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment$1;->a:Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;

    const-string v1, "facebook mobile connect"

    const/4 v2, 0x1

    invoke-static {v0, p1, v1, v2}, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->a(Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V

    .line 113
    return-void
.end method

.method public synthetic onSuccess(Lcom/amazonaws/AmazonWebServiceRequest;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 109
    check-cast p1, Lcom/jibo/aws/integration/aws/services/account/model/FacebookMobileConnectRequest;

    check-cast p2, Lcom/jibo/aws/integration/aws/services/account/model/TokenContainer;

    invoke-virtual {p0, p1, p2}, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment$1;->a(Lcom/jibo/aws/integration/aws/services/account/model/FacebookMobileConnectRequest;Lcom/jibo/aws/integration/aws/services/account/model/TokenContainer;)V

    return-void
.end method
