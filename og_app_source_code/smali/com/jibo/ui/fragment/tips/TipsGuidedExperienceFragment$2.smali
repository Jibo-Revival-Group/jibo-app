.class Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment$2;
.super Ljava/lang/Object;
.source "TipsGuidedExperienceFragment.java"

# interfaces
.implements Lcom/amazonaws/handlers/AsyncHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment;->r()V
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
        "Lcom/jibo/aws/integration/aws/services/robotProperties/model/GetRobotRequest;",
        "Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment;)V
    .locals 0

    .prologue
    .line 164
    iput-object p1, p0, Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment$2;->a:Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/jibo/aws/integration/aws/services/robotProperties/model/GetRobotRequest;Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)V
    .locals 2

    .prologue
    .line 172
    iget-object v0, p0, Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment$2;->a:Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment;

    invoke-static {v0, p2}, Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment;->a(Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment;Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    .line 174
    iget-object v0, p0, Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment$2;->a:Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment;

    new-instance v1, Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment$2$1;

    invoke-direct {v1, p0}, Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment$2$1;-><init>(Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment$2;)V

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment;->a(Ljava/lang/Runnable;)V

    .line 181
    return-void
.end method

.method public onError(Ljava/lang/Exception;)V
    .locals 0

    .prologue
    .line 168
    return-void
.end method

.method public synthetic onSuccess(Lcom/amazonaws/AmazonWebServiceRequest;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 164
    check-cast p1, Lcom/jibo/aws/integration/aws/services/robotProperties/model/GetRobotRequest;

    check-cast p2, Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    invoke-virtual {p0, p1, p2}, Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment$2;->a(Lcom/jibo/aws/integration/aws/services/robotProperties/model/GetRobotRequest;Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)V

    return-void
.end method
