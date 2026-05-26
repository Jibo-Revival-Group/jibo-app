.class Lcom/jibo/ui/fragment/AvatarBaseFragment$2;
.super Ljava/lang/Object;
.source "AvatarBaseFragment.java"

# interfaces
.implements Lcom/amazonaws/handlers/AsyncHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/AvatarBaseFragment;->b()V
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
        "Lcom/jibo/aws/integration/aws/services/account/model/UpdatePhotoRequest;",
        "Lcom/jibo/aws/integration/aws/services/account/model/Account;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/AvatarBaseFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/AvatarBaseFragment;)V
    .locals 0

    .prologue
    .line 210
    iput-object p1, p0, Lcom/jibo/ui/fragment/AvatarBaseFragment$2;->a:Lcom/jibo/ui/fragment/AvatarBaseFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/jibo/aws/integration/aws/services/account/model/UpdatePhotoRequest;Lcom/jibo/aws/integration/aws/services/account/model/Account;)V
    .locals 3

    .prologue
    const/4 v2, 0x1

    .line 220
    iget-object v0, p0, Lcom/jibo/ui/fragment/AvatarBaseFragment$2;->a:Lcom/jibo/ui/fragment/AvatarBaseFragment;

    invoke-virtual {p2}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getPhotoUrl()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/jibo/ui/fragment/AvatarBaseFragment;->l:Ljava/lang/String;

    .line 222
    iget-object v0, p0, Lcom/jibo/ui/fragment/AvatarBaseFragment$2;->a:Lcom/jibo/ui/fragment/AvatarBaseFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/AvatarBaseFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/db/EntityData;->i()Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getId()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 223
    iget-object v0, p0, Lcom/jibo/ui/fragment/AvatarBaseFragment$2;->a:Lcom/jibo/ui/fragment/AvatarBaseFragment;

    iput-object p2, v0, Lcom/jibo/ui/fragment/AvatarBaseFragment;->e:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    .line 224
    iget-object v0, p0, Lcom/jibo/ui/fragment/AvatarBaseFragment$2;->a:Lcom/jibo/ui/fragment/AvatarBaseFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/AvatarBaseFragment;->d()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 225
    iget-object v0, p0, Lcom/jibo/ui/fragment/AvatarBaseFragment$2;->a:Lcom/jibo/ui/fragment/AvatarBaseFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/AvatarBaseFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, p2, v2, v1}, Lcom/jibo/db/EntityData;->a(Lcom/jibo/aws/integration/aws/services/account/model/Account;ZLcom/amazonaws/handlers/AsyncHandler;)V

    .line 232
    :cond_0
    :goto_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/AvatarBaseFragment$2;->a:Lcom/jibo/ui/fragment/AvatarBaseFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/AvatarBaseFragment;->g()V

    .line 234
    iget-object v0, p0, Lcom/jibo/ui/fragment/AvatarBaseFragment$2;->a:Lcom/jibo/ui/fragment/AvatarBaseFragment;

    new-instance v1, Lcom/jibo/ui/fragment/AvatarBaseFragment$2$1;

    invoke-direct {v1, p0, p2}, Lcom/jibo/ui/fragment/AvatarBaseFragment$2$1;-><init>(Lcom/jibo/ui/fragment/AvatarBaseFragment$2;Lcom/jibo/aws/integration/aws/services/account/model/Account;)V

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/AvatarBaseFragment;->a(Ljava/lang/Runnable;)V

    .line 257
    return-void

    .line 228
    :cond_1
    iget-object v0, p0, Lcom/jibo/ui/fragment/AvatarBaseFragment$2;->a:Lcom/jibo/ui/fragment/AvatarBaseFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/AvatarBaseFragment;->d()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 229
    iget-object v0, p0, Lcom/jibo/ui/fragment/AvatarBaseFragment$2;->a:Lcom/jibo/ui/fragment/AvatarBaseFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/AvatarBaseFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0, p2, v2}, Lcom/jibo/db/EntityData;->a(Lcom/jibo/aws/integration/aws/services/account/model/Account;Z)V

    goto :goto_0
.end method

.method public onError(Ljava/lang/Exception;)V
    .locals 3

    .prologue
    .line 214
    iget-object v0, p0, Lcom/jibo/ui/fragment/AvatarBaseFragment$2;->a:Lcom/jibo/ui/fragment/AvatarBaseFragment;

    const-string v1, "update photo"

    const/4 v2, 0x1

    invoke-virtual {v0, p1, v1, v2}, Lcom/jibo/ui/fragment/AvatarBaseFragment;->a(Ljava/lang/Throwable;Ljava/lang/String;Z)V

    .line 215
    return-void
.end method

.method public synthetic onSuccess(Lcom/amazonaws/AmazonWebServiceRequest;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 210
    check-cast p1, Lcom/jibo/aws/integration/aws/services/account/model/UpdatePhotoRequest;

    check-cast p2, Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {p0, p1, p2}, Lcom/jibo/ui/fragment/AvatarBaseFragment$2;->a(Lcom/jibo/aws/integration/aws/services/account/model/UpdatePhotoRequest;Lcom/jibo/aws/integration/aws/services/account/model/Account;)V

    return-void
.end method
