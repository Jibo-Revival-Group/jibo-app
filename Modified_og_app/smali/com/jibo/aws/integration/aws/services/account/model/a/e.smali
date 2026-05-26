.class public Lcom/jibo/aws/integration/aws/services/account/model/a/e;
.super Lcom/jibo/aws/integration/aws/services/binary/model/a/c;


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Lcom/jibo/aws/integration/aws/services/binary/model/a/c;-><init>()V

    return-void
.end method


# virtual methods
.method protected a(Lcom/amazonaws/Request;Lcom/jibo/aws/integration/aws/services/binary/model/CreateBinaryRequest;)V
    .locals 4
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

    check-cast p2, Lcom/jibo/aws/integration/aws/services/account/model/UpdatePhotoRequest;

    invoke-virtual {p2}, Lcom/jibo/aws/integration/aws/services/account/model/UpdatePhotoRequest;->getMeta()Ljava/util/Map;

    move-result-object v0

    if-nez v0, :cond_0

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    invoke-virtual {p2, v0}, Lcom/jibo/aws/integration/aws/services/account/model/UpdatePhotoRequest;->setMeta(Ljava/util/Map;)V

    :cond_0
    invoke-virtual {p2}, Lcom/jibo/aws/integration/aws/services/account/model/UpdatePhotoRequest;->getMeta()Ljava/util/Map;

    move-result-object v0

    const-string v1, "size"

    invoke-interface {v0, v1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    invoke-virtual {p2}, Lcom/jibo/aws/integration/aws/services/account/model/UpdatePhotoRequest;->getMeta()Ljava/util/Map;

    move-result-object v0

    const-string v1, "size"

    invoke-virtual {p2}, Lcom/jibo/aws/integration/aws/services/account/model/UpdatePhotoRequest;->getBody()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->length()J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_1
    return-void
.end method
