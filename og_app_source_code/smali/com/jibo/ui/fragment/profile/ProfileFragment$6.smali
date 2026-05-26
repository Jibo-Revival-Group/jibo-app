.class Lcom/jibo/ui/fragment/profile/ProfileFragment$6;
.super Ljava/lang/Object;
.source "ProfileFragment.java"

# interfaces
.implements Lcom/amazonaws/handlers/AsyncHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/profile/ProfileFragment;->u()V
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
.field final synthetic a:Lcom/jibo/ui/fragment/profile/ProfileFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/profile/ProfileFragment;)V
    .locals 0

    .prologue
    .line 416
    iput-object p1, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment$6;->a:Lcom/jibo/ui/fragment/profile/ProfileFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/jibo/aws/integration/aws/services/loop/model/RemoveMemberRequest;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V
    .locals 2

    .prologue
    .line 424
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment$6;->a:Lcom/jibo/ui/fragment/profile/ProfileFragment;

    new-instance v1, Lcom/jibo/ui/fragment/profile/ProfileFragment$6$1;

    invoke-direct {v1, p0, p2}, Lcom/jibo/ui/fragment/profile/ProfileFragment$6$1;-><init>(Lcom/jibo/ui/fragment/profile/ProfileFragment$6;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/profile/ProfileFragment;->a(Ljava/lang/Runnable;)V

    .line 433
    return-void
.end method

.method public onError(Ljava/lang/Exception;)V
    .locals 3

    .prologue
    .line 419
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment$6;->a:Lcom/jibo/ui/fragment/profile/ProfileFragment;

    const-string v1, "remove member"

    const/4 v2, 0x1

    invoke-static {v0, p1, v1, v2}, Lcom/jibo/ui/fragment/profile/ProfileFragment;->b(Lcom/jibo/ui/fragment/profile/ProfileFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V

    .line 420
    return-void
.end method

.method public synthetic onSuccess(Lcom/amazonaws/AmazonWebServiceRequest;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 416
    check-cast p1, Lcom/jibo/aws/integration/aws/services/loop/model/RemoveMemberRequest;

    check-cast p2, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {p0, p1, p2}, Lcom/jibo/ui/fragment/profile/ProfileFragment$6;->a(Lcom/jibo/aws/integration/aws/services/loop/model/RemoveMemberRequest;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V

    return-void
.end method
