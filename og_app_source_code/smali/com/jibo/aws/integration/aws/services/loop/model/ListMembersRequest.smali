.class public Lcom/jibo/aws/integration/aws/services/loop/model/ListMembersRequest;
.super Lcom/jibo/aws/integration/aws/services/common/model/JiboRequestAbstract;


# instance fields
.field private statusList:Ljava/util/List;
    .annotation runtime Lcom/google/gson/annotations/Expose;
    .end annotation

    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private typeList:Ljava/util/List;
    .annotation runtime Lcom/google/gson/annotations/Expose;
    .end annotation

    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Ljava/util/List;Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    invoke-direct {p0}, Lcom/jibo/aws/integration/aws/services/common/model/JiboRequestAbstract;-><init>()V

    iput-object p1, p0, Lcom/jibo/aws/integration/aws/services/loop/model/ListMembersRequest;->statusList:Ljava/util/List;

    iput-object p2, p0, Lcom/jibo/aws/integration/aws/services/loop/model/ListMembersRequest;->typeList:Ljava/util/List;

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

    const-string v0, "ListLoopMembers"

    return-object v0
.end method

.method public getServicePrefix()Ljava/lang/String;
    .locals 1

    const-string v0, "Loop_20160324."

    return-object v0
.end method

.method public getStatusList()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/loop/model/ListMembersRequest;->statusList:Ljava/util/List;

    return-object v0
.end method

.method public getTypeList()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/loop/model/ListMembersRequest;->typeList:Ljava/util/List;

    return-object v0
.end method

.method public setStatusList(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    iput-object p1, p0, Lcom/jibo/aws/integration/aws/services/loop/model/ListMembersRequest;->statusList:Ljava/util/List;

    return-void
.end method

.method public setTypeList(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    iput-object p1, p0, Lcom/jibo/aws/integration/aws/services/loop/model/ListMembersRequest;->typeList:Ljava/util/List;

    return-void
.end method
