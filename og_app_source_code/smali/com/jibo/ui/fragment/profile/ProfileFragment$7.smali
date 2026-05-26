.class Lcom/jibo/ui/fragment/profile/ProfileFragment$7;
.super Ljava/lang/Object;
.source "ProfileFragment.java"

# interfaces
.implements Lcom/amazonaws/handlers/AsyncHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/profile/ProfileFragment;->c(Ljava/lang/String;)V
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
        "Lcom/jibo/aws/integration/aws/services/loop/model/UpdateNicknameRequest;",
        "Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Ljava/lang/String;

.field final synthetic b:Lcom/jibo/ui/fragment/profile/ProfileFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/profile/ProfileFragment;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 440
    iput-object p1, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment$7;->b:Lcom/jibo/ui/fragment/profile/ProfileFragment;

    iput-object p2, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment$7;->a:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/jibo/aws/integration/aws/services/loop/model/UpdateNicknameRequest;Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;)V
    .locals 2

    .prologue
    .line 448
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment$7;->b:Lcom/jibo/ui/fragment/profile/ProfileFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/profile/ProfileFragment;->c(Lcom/jibo/ui/fragment/profile/ProfileFragment;)Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment$7;->a:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->setNickname(Ljava/lang/String;)V

    .line 450
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment$7;->b:Lcom/jibo/ui/fragment/profile/ProfileFragment;

    new-instance v1, Lcom/jibo/ui/fragment/profile/ProfileFragment$7$1;

    invoke-direct {v1, p0}, Lcom/jibo/ui/fragment/profile/ProfileFragment$7$1;-><init>(Lcom/jibo/ui/fragment/profile/ProfileFragment$7;)V

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/profile/ProfileFragment;->a(Ljava/lang/Runnable;)V

    .line 460
    return-void
.end method

.method public onError(Ljava/lang/Exception;)V
    .locals 3

    .prologue
    .line 443
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment$7;->b:Lcom/jibo/ui/fragment/profile/ProfileFragment;

    const-string v1, "update nickname"

    const/4 v2, 0x1

    invoke-static {v0, p1, v1, v2}, Lcom/jibo/ui/fragment/profile/ProfileFragment;->c(Lcom/jibo/ui/fragment/profile/ProfileFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V

    .line 444
    return-void
.end method

.method public synthetic onSuccess(Lcom/amazonaws/AmazonWebServiceRequest;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 440
    check-cast p1, Lcom/jibo/aws/integration/aws/services/loop/model/UpdateNicknameRequest;

    check-cast p2, Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;

    invoke-virtual {p0, p1, p2}, Lcom/jibo/ui/fragment/profile/ProfileFragment$7;->a(Lcom/jibo/aws/integration/aws/services/loop/model/UpdateNicknameRequest;Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;)V

    return-void
.end method
