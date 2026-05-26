.class public Lcom/jibo/aws/integration/aws/services/loop/model/a/g;
.super Lcom/jibo/aws/integration/aws/services/binary/model/a/c;


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Lcom/jibo/aws/integration/aws/services/binary/model/a/c;-><init>()V

    return-void
.end method


# virtual methods
.method protected a(Lcom/amazonaws/Request;Lcom/jibo/aws/integration/aws/services/binary/model/CreateBinaryRequest;)V
    .locals 6
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

    move-object v0, p2

    check-cast v0, Lcom/jibo/aws/integration/aws/services/loop/model/UpdateMemberPhotoRequest;

    const-string v2, "x-loop-id"

    move-object v1, p2

    check-cast v1, Lcom/jibo/aws/integration/aws/services/loop/model/UpdateMemberPhotoRequest;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/UpdateMemberPhotoRequest;->getLoopId()Ljava/lang/String;

    move-result-object v1

    invoke-interface {p1, v2, v1}, Lcom/amazonaws/Request;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    const-string v1, "x-id"

    check-cast p2, Lcom/jibo/aws/integration/aws/services/loop/model/UpdateMemberPhotoRequest;

    invoke-virtual {p2}, Lcom/jibo/aws/integration/aws/services/loop/model/UpdateMemberPhotoRequest;->getId()Ljava/lang/String;

    move-result-object v2

    invoke-interface {p1, v1, v2}, Lcom/amazonaws/Request;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/UpdateMemberPhotoRequest;->getMeta()Ljava/util/Map;

    move-result-object v1

    if-nez v1, :cond_0

    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    invoke-virtual {v0, v1}, Lcom/jibo/aws/integration/aws/services/loop/model/UpdateMemberPhotoRequest;->setMeta(Ljava/util/Map;)V

    :cond_0
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/UpdateMemberPhotoRequest;->getMeta()Ljava/util/Map;

    move-result-object v1

    const-string v2, "size"

    invoke-interface {v1, v2}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_1

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/UpdateMemberPhotoRequest;->getMeta()Ljava/util/Map;

    move-result-object v1

    const-string v2, "size"

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/UpdateMemberPhotoRequest;->getBody()Ljava/io/File;

    move-result-object v0

    invoke-virtual {v0}, Ljava/io/File;->length()J

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v0

    invoke-interface {v1, v2, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_1
    return-void
.end method
