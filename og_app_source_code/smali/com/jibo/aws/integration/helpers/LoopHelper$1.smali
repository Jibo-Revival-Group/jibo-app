.class final Lcom/jibo/aws/integration/helpers/LoopHelper$1;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/amazonaws/handlers/AsyncHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/aws/integration/helpers/LoopHelper;->suspendLoop(Ljava/lang/String;Lcom/jibo/aws/integration/util/Commons$AsyncCallback;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/amazonaws/handlers/AsyncHandler",
        "<",
        "Lcom/jibo/aws/integration/aws/services/loop/model/SuspendLoopRequest;",
        "Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/aws/integration/util/Commons$AsyncCallback;


# direct methods
.method constructor <init>(Lcom/jibo/aws/integration/util/Commons$AsyncCallback;)V
    .locals 0

    iput-object p1, p0, Lcom/jibo/aws/integration/helpers/LoopHelper$1;->a:Lcom/jibo/aws/integration/util/Commons$AsyncCallback;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onError(Ljava/lang/Exception;)V
    .locals 1

    iget-object v0, p0, Lcom/jibo/aws/integration/helpers/LoopHelper$1;->a:Lcom/jibo/aws/integration/util/Commons$AsyncCallback;

    invoke-interface {v0, p1}, Lcom/jibo/aws/integration/util/Commons$AsyncCallback;->onError(Ljava/lang/Exception;)V

    return-void
.end method

.method public bridge synthetic onSuccess(Lcom/amazonaws/AmazonWebServiceRequest;Ljava/lang/Object;)V
    .locals 0

    check-cast p1, Lcom/jibo/aws/integration/aws/services/loop/model/SuspendLoopRequest;

    check-cast p2, Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;

    invoke-virtual {p0, p1, p2}, Lcom/jibo/aws/integration/helpers/LoopHelper$1;->onSuccess(Lcom/jibo/aws/integration/aws/services/loop/model/SuspendLoopRequest;Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;)V

    return-void
.end method

.method public onSuccess(Lcom/jibo/aws/integration/aws/services/loop/model/SuspendLoopRequest;Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;)V
    .locals 1

    iget-object v0, p0, Lcom/jibo/aws/integration/helpers/LoopHelper$1;->a:Lcom/jibo/aws/integration/util/Commons$AsyncCallback;

    invoke-interface {v0, p1}, Lcom/jibo/aws/integration/util/Commons$AsyncCallback;->onSuccess(Ljava/lang/Object;)V

    return-void
.end method
