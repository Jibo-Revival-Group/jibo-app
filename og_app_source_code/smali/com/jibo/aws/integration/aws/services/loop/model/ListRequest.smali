.class public Lcom/jibo/aws/integration/aws/services/loop/model/ListRequest;
.super Lcom/jibo/aws/integration/aws/services/common/model/JiboRequestAbstract;


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Lcom/jibo/aws/integration/aws/services/common/model/JiboRequestAbstract;-><init>()V

    return-void
.end method


# virtual methods
.method public getServiceAbbr()Ljava/lang/String;
    .locals 1

    const-string v0, "loop"

    return-object v0
.end method

.method public getServiceMethodName()Ljava/lang/String;
    .locals 1

    const-string v0, "ListLoops"

    return-object v0
.end method

.method public getServicePrefix()Ljava/lang/String;
    .locals 1

    const-string v0, "Loop_20160324."

    return-object v0
.end method
