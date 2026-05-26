.class Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$5$2;
.super Ljava/lang/Object;
.source "DevSettingsFragment.java"

# interfaces
.implements Lcom/amazonaws/handlers/AsyncHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$5;->a(Lcom/jibo/aws/integration/aws/services/loop/model/GetRobotRequest;Lcom/jibo/aws/integration/aws/services/loop/model/RobotAccount;)V
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
        "Lcom/jibo/aws/integration/aws/services/gqa/model/QuestionRequest;",
        "Lcom/jibo/aws/integration/aws/services/gqa/model/GQAAttribution;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$5;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$5;)V
    .locals 0

    .prologue
    .line 303
    iput-object p1, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$5$2;->a:Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$5;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/jibo/aws/integration/aws/services/gqa/model/QuestionRequest;Lcom/jibo/aws/integration/aws/services/gqa/model/GQAAttribution;)V
    .locals 2

    .prologue
    .line 316
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$5$2;->a:Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$5;

    iget-object v0, v0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$5;->b:Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;

    new-instance v1, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$5$2$2;

    invoke-direct {v1, p0, p2}, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$5$2$2;-><init>(Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$5$2;Lcom/jibo/aws/integration/aws/services/gqa/model/GQAAttribution;)V

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->a(Ljava/lang/Runnable;)V

    .line 324
    return-void
.end method

.method public onError(Ljava/lang/Exception;)V
    .locals 2

    .prologue
    .line 306
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$5$2;->a:Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$5;

    iget-object v0, v0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$5;->b:Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;

    new-instance v1, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$5$2$1;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$5$2$1;-><init>(Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$5$2;Ljava/lang/Exception;)V

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->a(Ljava/lang/Runnable;)V

    .line 312
    return-void
.end method

.method public synthetic onSuccess(Lcom/amazonaws/AmazonWebServiceRequest;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 303
    check-cast p1, Lcom/jibo/aws/integration/aws/services/gqa/model/QuestionRequest;

    check-cast p2, Lcom/jibo/aws/integration/aws/services/gqa/model/GQAAttribution;

    invoke-virtual {p0, p1, p2}, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$5$2;->a(Lcom/jibo/aws/integration/aws/services/gqa/model/QuestionRequest;Lcom/jibo/aws/integration/aws/services/gqa/model/GQAAttribution;)V

    return-void
.end method
