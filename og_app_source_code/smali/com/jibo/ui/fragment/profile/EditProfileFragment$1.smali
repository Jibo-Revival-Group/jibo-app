.class Lcom/jibo/ui/fragment/profile/EditProfileFragment$1;
.super Ljava/lang/Object;
.source "EditProfileFragment.java"

# interfaces
.implements Lcom/amazonaws/handlers/AsyncHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/profile/EditProfileFragment;->b()V
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
        "Lcom/jibo/aws/integration/aws/services/loop/model/UpdateMemberPhotoRequest;",
        "Lcom/jibo/aws/integration/aws/services/loop/model/Loop;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/profile/EditProfileFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/profile/EditProfileFragment;)V
    .locals 0

    .prologue
    .line 217
    iput-object p1, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment$1;->a:Lcom/jibo/ui/fragment/profile/EditProfileFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/jibo/aws/integration/aws/services/loop/model/UpdateMemberPhotoRequest;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V
    .locals 2

    .prologue
    .line 225
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment$1;->a:Lcom/jibo/ui/fragment/profile/EditProfileFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->g()V

    .line 228
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment$1;->a:Lcom/jibo/ui/fragment/profile/EditProfileFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->d()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment$1;->a:Lcom/jibo/ui/fragment/profile/EditProfileFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    const/4 v1, 0x1

    invoke-virtual {v0, p2, v1}, Lcom/jibo/db/EntityData;->a(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Z)V

    .line 230
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment$1;->a:Lcom/jibo/ui/fragment/profile/EditProfileFragment;

    iget-object v1, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment$1;->a:Lcom/jibo/ui/fragment/profile/EditProfileFragment;

    invoke-static {v1}, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->a(Lcom/jibo/ui/fragment/profile/EditProfileFragment;)Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    move-result-object v1

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getId()Ljava/lang/String;

    move-result-object v1

    invoke-static {p2, v1}, Lcom/jibo/aws/integration/helpers/LoopHelper;->getMemberByIdOrEmail(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->a(Lcom/jibo/ui/fragment/profile/EditProfileFragment;Lcom/jibo/aws/integration/aws/services/loop/model/Member;)Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    .line 231
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment$1;->a:Lcom/jibo/ui/fragment/profile/EditProfileFragment;

    iget-object v1, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment$1;->a:Lcom/jibo/ui/fragment/profile/EditProfileFragment;

    invoke-static {v1}, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->a(Lcom/jibo/ui/fragment/profile/EditProfileFragment;)Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    move-result-object v1

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v1

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getPhotoUrl()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->a(Lcom/jibo/ui/fragment/profile/EditProfileFragment;Ljava/lang/String;)Ljava/lang/String;

    .line 233
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment$1;->a:Lcom/jibo/ui/fragment/profile/EditProfileFragment;

    new-instance v1, Lcom/jibo/ui/fragment/profile/EditProfileFragment$1$1;

    invoke-direct {v1, p0}, Lcom/jibo/ui/fragment/profile/EditProfileFragment$1$1;-><init>(Lcom/jibo/ui/fragment/profile/EditProfileFragment$1;)V

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->a(Ljava/lang/Runnable;)V

    .line 240
    return-void
.end method

.method public onError(Ljava/lang/Exception;)V
    .locals 3

    .prologue
    .line 220
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment$1;->a:Lcom/jibo/ui/fragment/profile/EditProfileFragment;

    const-string v1, "update photo"

    const/4 v2, 0x1

    invoke-static {v0, p1, v1, v2}, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->a(Lcom/jibo/ui/fragment/profile/EditProfileFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V

    .line 221
    return-void
.end method

.method public synthetic onSuccess(Lcom/amazonaws/AmazonWebServiceRequest;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 217
    check-cast p1, Lcom/jibo/aws/integration/aws/services/loop/model/UpdateMemberPhotoRequest;

    check-cast p2, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {p0, p1, p2}, Lcom/jibo/ui/fragment/profile/EditProfileFragment$1;->a(Lcom/jibo/aws/integration/aws/services/loop/model/UpdateMemberPhotoRequest;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V

    return-void
.end method
