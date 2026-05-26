.class public Lcom/jibo/aws/integration/aws/services/jot/model/MarkReadRequest;
.super Lcom/jibo/aws/integration/aws/services/common/model/IdsRequestAbstract;


# direct methods
.method public constructor <init>(Ljava/util/List;)V
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

    invoke-direct {p0, p1}, Lcom/jibo/aws/integration/aws/services/common/model/IdsRequestAbstract;-><init>(Ljava/util/List;)V

    return-void
.end method


# virtual methods
.method public getServiceAbbr()Ljava/lang/String;
    .locals 1

    const-string v0, "jot"

    return-object v0
.end method

.method public getServicePrefix()Ljava/lang/String;
    .locals 1

    const-string v0, "Jot_20160126."

    return-object v0
.end method
