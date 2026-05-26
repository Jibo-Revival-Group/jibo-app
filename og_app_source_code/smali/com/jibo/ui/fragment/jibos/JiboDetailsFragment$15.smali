.class Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$15;
.super Ljava/lang/Object;
.source "JiboDetailsFragment.java"

# interfaces
.implements Lcom/amazonaws/handlers/AsyncHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
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
        "Lcom/jibo/aws/integration/aws/services/loop/model/RemoveMemberRequest;",
        "Lcom/jibo/aws/integration/aws/services/loop/model/Loop;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;)V
    .locals 0

    .prologue
    .line 914
    iput-object p1, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$15;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/jibo/aws/integration/aws/services/loop/model/RemoveMemberRequest;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V
    .locals 3

    .prologue
    .line 938
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$15;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    const/4 v1, 0x1

    invoke-virtual {v0, p2, v1}, Lcom/jibo/db/EntityData;->a(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Z)V

    .line 939
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$15;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->b:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    iget-object v1, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$15;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    iget-object v1, v1, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->b:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    const v2, 0x7f10026e

    invoke-virtual {v1, v2}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->a(Ljava/lang/String;)V

    .line 940
    return-void
.end method

.method public onError(Ljava/lang/Exception;)V
    .locals 3

    .prologue
    .line 917
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$15;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->d()Z

    move-result v0

    if-nez v0, :cond_1

    .line 918
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$15;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->b:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    iget-object v1, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$15;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    const v2, 0x7f10026a

    invoke-virtual {v1, v2}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->b(Ljava/lang/String;)V

    .line 933
    :cond_0
    :goto_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$15;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    const-string v1, "remove member"

    const/4 v2, 0x0

    invoke-static {v0, p1, v1, v2}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->d(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V

    .line 934
    return-void

    :cond_1
    move-object v0, p1

    .line 920
    check-cast v0, Lcom/amazonaws/AmazonServiceException;

    invoke-static {v0}, Lcom/jibo/utils/ErrorHelper;->b(Lcom/amazonaws/AmazonServiceException;)Z

    move-result v0

    if-nez v0, :cond_0

    move-object v0, p1

    check-cast v0, Lcom/amazonaws/AmazonServiceException;

    .line 921
    invoke-static {v0}, Lcom/jibo/utils/ErrorHelper;->a(Lcom/amazonaws/AmazonServiceException;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 923
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$15;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    new-instance v1, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$15$1;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$15$1;-><init>(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$15;Ljava/lang/Exception;)V

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->a(Ljava/lang/Runnable;)V

    goto :goto_0
.end method

.method public synthetic onSuccess(Lcom/amazonaws/AmazonWebServiceRequest;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 914
    check-cast p1, Lcom/jibo/aws/integration/aws/services/loop/model/RemoveMemberRequest;

    check-cast p2, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {p0, p1, p2}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$15;->a(Lcom/jibo/aws/integration/aws/services/loop/model/RemoveMemberRequest;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V

    return-void
.end method
