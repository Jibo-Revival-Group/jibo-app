.class Lcom/jibo/ui/activity/GuidedExperienceActivity$1;
.super Ljava/lang/Object;
.source "GuidedExperienceActivity.java"

# interfaces
.implements Lcom/amazonaws/handlers/AsyncHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/activity/GuidedExperienceActivity;->s()V
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
.field final synthetic a:Lcom/jibo/ui/activity/GuidedExperienceActivity;


# direct methods
.method constructor <init>(Lcom/jibo/ui/activity/GuidedExperienceActivity;)V
    .locals 0

    .prologue
    .line 278
    iput-object p1, p0, Lcom/jibo/ui/activity/GuidedExperienceActivity$1;->a:Lcom/jibo/ui/activity/GuidedExperienceActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/jibo/aws/integration/aws/services/robotProperties/model/GetRobotRequest;Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)V
    .locals 1

    .prologue
    .line 287
    iget-object v0, p0, Lcom/jibo/ui/activity/GuidedExperienceActivity$1;->a:Lcom/jibo/ui/activity/GuidedExperienceActivity;

    invoke-static {v0, p2}, Lcom/jibo/ui/activity/GuidedExperienceActivity;->a(Lcom/jibo/ui/activity/GuidedExperienceActivity;Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    .line 288
    return-void
.end method

.method public onError(Ljava/lang/Exception;)V
    .locals 2

    .prologue
    .line 281
    iget-object v0, p0, Lcom/jibo/ui/activity/GuidedExperienceActivity$1;->a:Lcom/jibo/ui/activity/GuidedExperienceActivity;

    const-string v1, "get robot"

    invoke-virtual {v0, p1, v1}, Lcom/jibo/ui/activity/GuidedExperienceActivity;->a(Ljava/lang/Exception;Ljava/lang/String;)V

    .line 283
    return-void
.end method

.method public synthetic onSuccess(Lcom/amazonaws/AmazonWebServiceRequest;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 278
    check-cast p1, Lcom/jibo/aws/integration/aws/services/robotProperties/model/GetRobotRequest;

    check-cast p2, Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    invoke-virtual {p0, p1, p2}, Lcom/jibo/ui/activity/GuidedExperienceActivity$1;->a(Lcom/jibo/aws/integration/aws/services/robotProperties/model/GetRobotRequest;Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)V

    return-void
.end method
