.class Lcom/jibo/ui/fragment/account/skills/StationsFragment$1$1;
.super Ljava/lang/Object;
.source "StationsFragment.java"

# interfaces
.implements Lcom/amazonaws/handlers/AsyncHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/account/skills/StationsFragment$1;->onClick(Landroid/view/View;)V
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
        "Lcom/jibo/aws/integration/aws/services/person/model/SetLoopPropertyRequest;",
        "Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Ljava/lang/String;

.field final synthetic b:Lcom/jibo/ui/fragment/account/skills/StationsFragment$1;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/account/skills/StationsFragment$1;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 102
    iput-object p1, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment$1$1;->b:Lcom/jibo/ui/fragment/account/skills/StationsFragment$1;

    iput-object p2, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment$1$1;->a:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/jibo/aws/integration/aws/services/person/model/SetLoopPropertyRequest;Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;)V
    .locals 1

    .prologue
    .line 122
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment$1$1;->b:Lcom/jibo/ui/fragment/account/skills/StationsFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/account/skills/StationsFragment$1;->a:Lcom/jibo/ui/fragment/account/skills/StationsFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->d(Lcom/jibo/ui/fragment/account/skills/StationsFragment;)V

    .line 123
    return-void
.end method

.method public onError(Ljava/lang/Exception;)V
    .locals 3

    .prologue
    .line 105
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment$1$1;->b:Lcom/jibo/ui/fragment/account/skills/StationsFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/account/skills/StationsFragment$1;->a:Lcom/jibo/ui/fragment/account/skills/StationsFragment;

    const-string v1, "set account properties"

    const/4 v2, 0x0

    invoke-static {v0, p1, v1, v2}, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->a(Lcom/jibo/ui/fragment/account/skills/StationsFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V

    move-object v0, p1

    .line 107
    check-cast v0, Lcom/amazonaws/AmazonServiceException;

    invoke-static {v0}, Lcom/jibo/utils/ErrorHelper;->b(Lcom/amazonaws/AmazonServiceException;)Z

    move-result v0

    if-nez v0, :cond_0

    check-cast p1, Lcom/amazonaws/AmazonServiceException;

    .line 108
    invoke-static {p1}, Lcom/jibo/utils/ErrorHelper;->a(Lcom/amazonaws/AmazonServiceException;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 111
    :try_start_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment$1$1;->b:Lcom/jibo/ui/fragment/account/skills/StationsFragment$1;

    iget-object v1, v0, Lcom/jibo/ui/fragment/account/skills/StationsFragment$1;->a:Lcom/jibo/ui/fragment/account/skills/StationsFragment;

    new-instance v0, Lcom/google/gson/JsonParser;

    invoke-direct {v0}, Lcom/google/gson/JsonParser;-><init>()V

    iget-object v2, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment$1$1;->a:Ljava/lang/String;

    invoke-virtual {v0, v2}, Lcom/google/gson/JsonParser;->a(Ljava/lang/String;)Lcom/google/gson/JsonElement;

    move-result-object v0

    check-cast v0, Lcom/google/gson/JsonObject;

    invoke-static {v1, v0}, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->a(Lcom/jibo/ui/fragment/account/skills/StationsFragment;Lcom/google/gson/JsonObject;)Lcom/google/gson/JsonObject;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 116
    :goto_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment$1$1;->b:Lcom/jibo/ui/fragment/account/skills/StationsFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/account/skills/StationsFragment$1;->a:Lcom/jibo/ui/fragment/account/skills/StationsFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->d(Lcom/jibo/ui/fragment/account/skills/StationsFragment;)V

    .line 118
    :cond_0
    return-void

    .line 112
    :catch_0
    move-exception v0

    .line 113
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment$1$1;->b:Lcom/jibo/ui/fragment/account/skills/StationsFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/account/skills/StationsFragment$1;->a:Lcom/jibo/ui/fragment/account/skills/StationsFragment;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->a(Lcom/jibo/ui/fragment/account/skills/StationsFragment;Lcom/google/gson/JsonObject;)Lcom/google/gson/JsonObject;

    goto :goto_0
.end method

.method public synthetic onSuccess(Lcom/amazonaws/AmazonWebServiceRequest;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 102
    check-cast p1, Lcom/jibo/aws/integration/aws/services/person/model/SetLoopPropertyRequest;

    check-cast p2, Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;

    invoke-virtual {p0, p1, p2}, Lcom/jibo/ui/fragment/account/skills/StationsFragment$1$1;->a(Lcom/jibo/aws/integration/aws/services/person/model/SetLoopPropertyRequest;Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;)V

    return-void
.end method
