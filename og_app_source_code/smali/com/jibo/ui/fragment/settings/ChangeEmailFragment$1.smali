.class Lcom/jibo/ui/fragment/settings/ChangeEmailFragment$1;
.super Ljava/lang/Object;
.source "ChangeEmailFragment.java"

# interfaces
.implements Lcom/amazonaws/handlers/AsyncHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/settings/ChangeEmailFragment;->a()V
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
        "Lcom/jibo/aws/integration/aws/services/account/model/ChangeEmailRequest;",
        "Lcom/jibo/aws/integration/aws/services/common/model/IdResponse;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/settings/ChangeEmailFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/settings/ChangeEmailFragment;)V
    .locals 0

    .prologue
    .line 146
    iput-object p1, p0, Lcom/jibo/ui/fragment/settings/ChangeEmailFragment$1;->a:Lcom/jibo/ui/fragment/settings/ChangeEmailFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/jibo/aws/integration/aws/services/account/model/ChangeEmailRequest;Lcom/jibo/aws/integration/aws/services/common/model/IdResponse;)V
    .locals 2

    .prologue
    .line 178
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/ChangeEmailFragment$1;->a:Lcom/jibo/ui/fragment/settings/ChangeEmailFragment;

    new-instance v1, Lcom/jibo/ui/fragment/settings/ChangeEmailFragment$1$2;

    invoke-direct {v1, p0}, Lcom/jibo/ui/fragment/settings/ChangeEmailFragment$1$2;-><init>(Lcom/jibo/ui/fragment/settings/ChangeEmailFragment$1;)V

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/settings/ChangeEmailFragment;->a(Ljava/lang/Runnable;)V

    .line 188
    return-void
.end method

.method public onError(Ljava/lang/Exception;)V
    .locals 3

    .prologue
    .line 149
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/ChangeEmailFragment$1;->a:Lcom/jibo/ui/fragment/settings/ChangeEmailFragment;

    const-string v1, "change email"

    const/4 v2, 0x0

    invoke-static {v0, p1, v1, v2}, Lcom/jibo/ui/fragment/settings/ChangeEmailFragment;->a(Lcom/jibo/ui/fragment/settings/ChangeEmailFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V

    move-object v0, p1

    .line 150
    check-cast v0, Lcom/amazonaws/AmazonServiceException;

    invoke-static {v0}, Lcom/jibo/utils/ErrorHelper;->b(Lcom/amazonaws/AmazonServiceException;)Z

    move-result v0

    if-nez v0, :cond_0

    move-object v0, p1

    check-cast v0, Lcom/amazonaws/AmazonServiceException;

    .line 151
    invoke-static {v0}, Lcom/jibo/utils/ErrorHelper;->a(Lcom/amazonaws/AmazonServiceException;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 153
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/ChangeEmailFragment$1;->a:Lcom/jibo/ui/fragment/settings/ChangeEmailFragment;

    new-instance v1, Lcom/jibo/ui/fragment/settings/ChangeEmailFragment$1$1;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/fragment/settings/ChangeEmailFragment$1$1;-><init>(Lcom/jibo/ui/fragment/settings/ChangeEmailFragment$1;Ljava/lang/Exception;)V

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/settings/ChangeEmailFragment;->a(Ljava/lang/Runnable;)V

    .line 174
    :cond_0
    return-void
.end method

.method public synthetic onSuccess(Lcom/amazonaws/AmazonWebServiceRequest;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 146
    check-cast p1, Lcom/jibo/aws/integration/aws/services/account/model/ChangeEmailRequest;

    check-cast p2, Lcom/jibo/aws/integration/aws/services/common/model/IdResponse;

    invoke-virtual {p0, p1, p2}, Lcom/jibo/ui/fragment/settings/ChangeEmailFragment$1;->a(Lcom/jibo/aws/integration/aws/services/account/model/ChangeEmailRequest;Lcom/jibo/aws/integration/aws/services/common/model/IdResponse;)V

    return-void
.end method
