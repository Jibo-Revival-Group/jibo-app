.class Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$5;
.super Ljava/lang/Object;
.source "DevSettingsFragment.java"

# interfaces
.implements Lcom/amazonaws/handlers/AsyncHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->onBtnSendQuestion(Landroid/view/View;)V
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
        "Lcom/jibo/aws/integration/aws/services/loop/model/GetRobotRequest;",
        "Lcom/jibo/aws/integration/aws/services/loop/model/RobotAccount;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Ljava/lang/String;

.field final synthetic b:Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 287
    iput-object p1, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$5;->b:Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;

    iput-object p2, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$5;->a:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/jibo/aws/integration/aws/services/loop/model/GetRobotRequest;Lcom/jibo/aws/integration/aws/services/loop/model/RobotAccount;)V
    .locals 4

    .prologue
    .line 300
    new-instance v0, Lcom/jibo/aws/integration/aws/services/gqa/JiboGQAAsyncClient;

    new-instance v1, Lcom/amazonaws/auth/BasicAWSCredentials;

    invoke-virtual {p2}, Lcom/jibo/aws/integration/aws/services/loop/model/RobotAccount;->getAccessKeyId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p2}, Lcom/jibo/aws/integration/aws/services/loop/model/RobotAccount;->getSecretAccessKey()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v2, v3}, Lcom/amazonaws/auth/BasicAWSCredentials;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-direct {v0, v1}, Lcom/jibo/aws/integration/aws/services/gqa/JiboGQAAsyncClient;-><init>(Lcom/amazonaws/auth/AWSCredentials;)V

    .line 301
    const-string v1, "dev-entrypoint.jibo.com"

    invoke-virtual {v0, v1}, Lcom/jibo/aws/integration/aws/services/gqa/JiboGQAAsyncClient;->setEndpoint(Ljava/lang/String;)V

    .line 303
    iget-object v1, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$5;->a:Ljava/lang/String;

    new-instance v2, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$5$2;

    invoke-direct {v2, p0}, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$5$2;-><init>(Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$5;)V

    invoke-virtual {v0, v1, v2}, Lcom/jibo/aws/integration/aws/services/gqa/JiboGQAAsyncClient;->sendQuestion(Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;

    .line 326
    return-void
.end method

.method public onError(Ljava/lang/Exception;)V
    .locals 2

    .prologue
    .line 290
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$5;->b:Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;

    new-instance v1, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$5$1;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$5$1;-><init>(Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$5;Ljava/lang/Exception;)V

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->a(Ljava/lang/Runnable;)V

    .line 296
    return-void
.end method

.method public synthetic onSuccess(Lcom/amazonaws/AmazonWebServiceRequest;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 287
    check-cast p1, Lcom/jibo/aws/integration/aws/services/loop/model/GetRobotRequest;

    check-cast p2, Lcom/jibo/aws/integration/aws/services/loop/model/RobotAccount;

    invoke-virtual {p0, p1, p2}, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$5;->a(Lcom/jibo/aws/integration/aws/services/loop/model/GetRobotRequest;Lcom/jibo/aws/integration/aws/services/loop/model/RobotAccount;)V

    return-void
.end method
