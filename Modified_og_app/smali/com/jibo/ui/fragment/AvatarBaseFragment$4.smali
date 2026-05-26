.class Lcom/jibo/ui/fragment/AvatarBaseFragment$4;
.super Ljava/lang/Object;
.source "AvatarBaseFragment.java"

# interfaces
.implements Lcom/amazonaws/handlers/AsyncHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/AvatarBaseFragment;->b(Lcom/jibo/aws/integration/aws/services/account/model/Account;)V
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
.field final synthetic a:Lcom/jibo/ui/fragment/AvatarBaseFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/AvatarBaseFragment;)V
    .locals 0

    .prologue
    .line 322
    iput-object p1, p0, Lcom/jibo/ui/fragment/AvatarBaseFragment$4;->a:Lcom/jibo/ui/fragment/AvatarBaseFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/jibo/aws/integration/aws/services/account/model/UpdateRequest;Lcom/jibo/aws/integration/aws/services/account/model/Account;)V
    .locals 2

    .prologue
    .line 331
    const/4 v0, 0x0

    .line 332
    iget-object v1, p0, Lcom/jibo/ui/fragment/AvatarBaseFragment$4;->a:Lcom/jibo/ui/fragment/AvatarBaseFragment;

    iget-object v1, v1, Lcom/jibo/ui/fragment/AvatarBaseFragment;->l:Ljava/lang/String;

    if-eqz v1, :cond_0

    .line 333
    new-instance v0, Ljava/io/File;

    iget-object v1, p0, Lcom/jibo/ui/fragment/AvatarBaseFragment$4;->a:Lcom/jibo/ui/fragment/AvatarBaseFragment;

    iget-object v1, v1, Lcom/jibo/ui/fragment/AvatarBaseFragment;->l:Ljava/lang/String;

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 335
    :cond_0
    if-eqz v0, :cond_1

    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/jibo/ui/fragment/AvatarBaseFragment$4;->a:Lcom/jibo/ui/fragment/AvatarBaseFragment;

    iget-boolean v0, v0, Lcom/jibo/ui/fragment/AvatarBaseFragment;->d:Z

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/jibo/ui/fragment/AvatarBaseFragment$4;->a:Lcom/jibo/ui/fragment/AvatarBaseFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/AvatarBaseFragment;->d()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 337
    iget-object v0, p0, Lcom/jibo/ui/fragment/AvatarBaseFragment$4;->a:Lcom/jibo/ui/fragment/AvatarBaseFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/AvatarBaseFragment;->b()V

    .line 356
    :goto_0
    return-void

    .line 340
    :cond_1
    iget-object v0, p0, Lcom/jibo/ui/fragment/AvatarBaseFragment$4;->a:Lcom/jibo/ui/fragment/AvatarBaseFragment;

    new-instance v1, Lcom/jibo/ui/fragment/AvatarBaseFragment$4$1;

    invoke-direct {v1, p0}, Lcom/jibo/ui/fragment/AvatarBaseFragment$4$1;-><init>(Lcom/jibo/ui/fragment/AvatarBaseFragment$4;)V

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/AvatarBaseFragment;->a(Ljava/lang/Runnable;)V

    goto :goto_0
.end method

.method public onError(Ljava/lang/Exception;)V
    .locals 3

    .prologue
    .line 325
    iget-object v0, p0, Lcom/jibo/ui/fragment/AvatarBaseFragment$4;->a:Lcom/jibo/ui/fragment/AvatarBaseFragment;

    const-string v1, "save account"

    const/4 v2, 0x1

    invoke-virtual {v0, p1, v1, v2}, Lcom/jibo/ui/fragment/AvatarBaseFragment;->a(Ljava/lang/Throwable;Ljava/lang/String;Z)V

    .line 326
    return-void
.end method

.method public synthetic onSuccess(Lcom/amazonaws/AmazonWebServiceRequest;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 322
    check-cast p1, Lcom/jibo/aws/integration/aws/services/account/model/UpdateRequest;

    check-cast p2, Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {p0, p1, p2}, Lcom/jibo/ui/fragment/AvatarBaseFragment$4;->a(Lcom/jibo/aws/integration/aws/services/account/model/UpdateRequest;Lcom/jibo/aws/integration/aws/services/account/model/Account;)V

    return-void
.end method
