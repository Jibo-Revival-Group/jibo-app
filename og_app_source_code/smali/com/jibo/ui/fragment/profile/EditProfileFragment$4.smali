.class Lcom/jibo/ui/fragment/profile/EditProfileFragment$4;
.super Ljava/lang/Object;
.source "EditProfileFragment.java"

# interfaces
.implements Lcom/amazonaws/handlers/AsyncHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/profile/EditProfileFragment;->d(Ljava/lang/String;)V
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
        "Lcom/jibo/aws/integration/aws/services/loop/model/UpdateMemberRequest;",
        "Lcom/jibo/aws/integration/aws/services/loop/model/Loop;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Ljava/lang/String;

.field final synthetic b:Lcom/jibo/ui/fragment/profile/EditProfileFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/profile/EditProfileFragment;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 503
    iput-object p1, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment$4;->b:Lcom/jibo/ui/fragment/profile/EditProfileFragment;

    iput-object p2, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment$4;->a:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/jibo/aws/integration/aws/services/loop/model/UpdateMemberRequest;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V
    .locals 2

    .prologue
    .line 511
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment$4;->b:Lcom/jibo/ui/fragment/profile/EditProfileFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->g()V

    .line 512
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment$4;->b:Lcom/jibo/ui/fragment/profile/EditProfileFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->a(Lcom/jibo/ui/fragment/profile/EditProfileFragment;)Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment$4;->a:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->setEmail(Ljava/lang/String;)V

    .line 513
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment$4;->b:Lcom/jibo/ui/fragment/profile/EditProfileFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->a(Lcom/jibo/ui/fragment/profile/EditProfileFragment;)Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    move-result-object v0

    sget-object v1, Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;->invited:Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;

    invoke-virtual {v0, v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->setStatus(Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;)V

    .line 515
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment$4;->b:Lcom/jibo/ui/fragment/profile/EditProfileFragment;

    new-instance v1, Lcom/jibo/ui/fragment/profile/EditProfileFragment$4$1;

    invoke-direct {v1, p0}, Lcom/jibo/ui/fragment/profile/EditProfileFragment$4$1;-><init>(Lcom/jibo/ui/fragment/profile/EditProfileFragment$4;)V

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->a(Ljava/lang/Runnable;)V

    .line 526
    return-void
.end method

.method public onError(Ljava/lang/Exception;)V
    .locals 3

    .prologue
    .line 506
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment$4;->b:Lcom/jibo/ui/fragment/profile/EditProfileFragment;

    const-string v1, "update member account"

    const/4 v2, 0x1

    invoke-static {v0, p1, v1, v2}, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->d(Lcom/jibo/ui/fragment/profile/EditProfileFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V

    .line 507
    return-void
.end method

.method public synthetic onSuccess(Lcom/amazonaws/AmazonWebServiceRequest;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 503
    check-cast p1, Lcom/jibo/aws/integration/aws/services/loop/model/UpdateMemberRequest;

    check-cast p2, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {p0, p1, p2}, Lcom/jibo/ui/fragment/profile/EditProfileFragment$4;->a(Lcom/jibo/aws/integration/aws/services/loop/model/UpdateMemberRequest;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V

    return-void
.end method
