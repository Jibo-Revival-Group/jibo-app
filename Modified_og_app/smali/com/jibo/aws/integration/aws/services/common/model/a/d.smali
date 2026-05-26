.class public Lcom/jibo/aws/integration/aws/services/common/model/a/d;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/amazonaws/transform/Unmarshaller;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/amazonaws/transform/Unmarshaller",
        "<",
        "Lcom/jibo/aws/integration/aws/services/common/model/IdResponse;",
        "Lcom/amazonaws/transform/JsonUnmarshallerContext;",
        ">;"
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/amazonaws/transform/JsonUnmarshallerContext;)Lcom/jibo/aws/integration/aws/services/common/model/IdResponse;
    .locals 3

    new-instance v0, Lcom/google/gson/Gson;

    invoke-direct {v0}, Lcom/google/gson/Gson;-><init>()V

    invoke-virtual {p1}, Lcom/amazonaws/transform/JsonUnmarshallerContext;->getReader()Lcom/amazonaws/util/json/AwsJsonReader;

    move-result-object v1

    invoke-interface {v1}, Lcom/amazonaws/util/json/AwsJsonReader;->getReader()Ljava/io/Reader;

    move-result-object v1

    const-class v2, Lcom/jibo/aws/integration/aws/services/common/model/IdResponse;

    invoke-virtual {v0, v1, v2}, Lcom/google/gson/Gson;->a(Ljava/io/Reader;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/common/model/IdResponse;

    return-object v0
.end method

.method public synthetic unmarshall(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    check-cast p1, Lcom/amazonaws/transform/JsonUnmarshallerContext;

    invoke-virtual {p0, p1}, Lcom/jibo/aws/integration/aws/services/common/model/a/d;->a(Lcom/amazonaws/transform/JsonUnmarshallerContext;)Lcom/jibo/aws/integration/aws/services/common/model/IdResponse;

    move-result-object v0

    return-object v0
.end method
