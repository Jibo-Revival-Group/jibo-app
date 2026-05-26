.class Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2;
.super Ljava/lang/Object;
.source "PreferredNameFragment.java"

# interfaces
.implements Lcom/amazonaws/handlers/AsyncHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->b()V
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
        "Lcom/jibo/aws/integration/aws/services/collision/model/MatchRequest;",
        "Lcom/jibo/aws/integration/aws/services/collision/model/CollisionCheckContainer;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/invite/PreferredNameFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/invite/PreferredNameFragment;)V
    .locals 0

    .prologue
    .line 245
    iput-object p1, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2;->a:Lcom/jibo/ui/fragment/invite/PreferredNameFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/jibo/aws/integration/aws/services/collision/model/MatchRequest;Lcom/jibo/aws/integration/aws/services/collision/model/CollisionCheckContainer;)V
    .locals 2

    .prologue
    .line 253
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2;->a:Lcom/jibo/ui/fragment/invite/PreferredNameFragment;

    new-instance v1, Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2$1;

    invoke-direct {v1, p0, p2}, Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2$1;-><init>(Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2;Lcom/jibo/aws/integration/aws/services/collision/model/CollisionCheckContainer;)V

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->a(Ljava/lang/Runnable;)V

    .line 296
    return-void
.end method

.method public onError(Ljava/lang/Exception;)V
    .locals 3

    .prologue
    .line 248
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2;->a:Lcom/jibo/ui/fragment/invite/PreferredNameFragment;

    const-string v1, "collision match"

    const/4 v2, 0x0

    invoke-static {v0, p1, v1, v2}, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->a(Lcom/jibo/ui/fragment/invite/PreferredNameFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V

    .line 249
    return-void
.end method

.method public synthetic onSuccess(Lcom/amazonaws/AmazonWebServiceRequest;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 245
    check-cast p1, Lcom/jibo/aws/integration/aws/services/collision/model/MatchRequest;

    check-cast p2, Lcom/jibo/aws/integration/aws/services/collision/model/CollisionCheckContainer;

    invoke-virtual {p0, p1, p2}, Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2;->a(Lcom/jibo/aws/integration/aws/services/collision/model/MatchRequest;Lcom/jibo/aws/integration/aws/services/collision/model/CollisionCheckContainer;)V

    return-void
.end method
