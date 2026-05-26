.class public Lcom/jibo/aws/integration/aws/services/media/model/a/a;
.super Lcom/jibo/aws/integration/aws/services/binary/model/a/c;


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Lcom/jibo/aws/integration/aws/services/binary/model/a/c;-><init>()V

    return-void
.end method


# virtual methods
.method protected a(Lcom/amazonaws/Request;Lcom/jibo/aws/integration/aws/services/binary/model/CreateBinaryRequest;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazonaws/Request",
            "<",
            "Lcom/jibo/aws/integration/aws/services/common/model/JiboRequestAbstract;",
            ">;",
            "Lcom/jibo/aws/integration/aws/services/binary/model/CreateBinaryRequest;",
            ")V"
        }
    .end annotation

    invoke-virtual {p2}, Lcom/jibo/aws/integration/aws/services/binary/model/CreateBinaryRequest;->getPath()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string v0, "x-path"

    invoke-virtual {p2}, Lcom/jibo/aws/integration/aws/services/binary/model/CreateBinaryRequest;->getPath()Ljava/lang/String;

    move-result-object v1

    invoke-interface {p1, v0, v1}, Lcom/amazonaws/Request;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    :cond_0
    const-string v1, "x-loop-id"

    move-object v0, p2

    check-cast v0, Lcom/jibo/aws/integration/aws/services/media/model/CreateRequest;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/media/model/CreateRequest;->getLoopId()Ljava/lang/String;

    move-result-object v0

    invoke-interface {p1, v1, v0}, Lcom/amazonaws/Request;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    const-string v1, "x-type"

    move-object v0, p2

    check-cast v0, Lcom/jibo/aws/integration/aws/services/media/model/CreateRequest;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/media/model/CreateRequest;->getType()Ljava/lang/String;

    move-result-object v0

    invoke-interface {p1, v1, v0}, Lcom/amazonaws/Request;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    move-object v0, p2

    check-cast v0, Lcom/jibo/aws/integration/aws/services/media/model/CreateRequest;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/media/model/CreateRequest;->isEncrypted()Ljava/lang/Boolean;

    move-result-object v0

    if-eqz v0, :cond_2

    move-object v0, p2

    check-cast v0, Lcom/jibo/aws/integration/aws/services/media/model/CreateRequest;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/media/model/CreateRequest;->isEncrypted()Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    :goto_0
    const-string v1, "x-encrypted"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, ""

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-interface {p1, v1, v0}, Lcom/amazonaws/Request;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    move-object v0, p2

    check-cast v0, Lcom/jibo/aws/integration/aws/services/media/model/CreateRequest;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/media/model/CreateRequest;->getReference()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_1

    const-string v0, "x-reference"

    check-cast p2, Lcom/jibo/aws/integration/aws/services/media/model/CreateRequest;

    invoke-virtual {p2}, Lcom/jibo/aws/integration/aws/services/media/model/CreateRequest;->getReference()Ljava/lang/String;

    move-result-object v1

    invoke-interface {p1, v0, v1}, Lcom/amazonaws/Request;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    :cond_1
    return-void

    :cond_2
    const/4 v0, 0x0

    goto :goto_0
.end method
