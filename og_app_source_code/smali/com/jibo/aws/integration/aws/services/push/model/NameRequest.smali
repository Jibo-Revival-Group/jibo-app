.class public Lcom/jibo/aws/integration/aws/services/push/model/NameRequest;
.super Lcom/jibo/aws/integration/aws/services/common/model/NameRequestAbstract;


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 0

    invoke-direct {p0, p1}, Lcom/jibo/aws/integration/aws/services/common/model/NameRequestAbstract;-><init>(Ljava/lang/String;)V

    return-void
.end method


# virtual methods
.method public getServiceAbbr()Ljava/lang/String;
    .locals 1

    const-string v0, "push"

    return-object v0
.end method

.method public getServicePrefix()Ljava/lang/String;
    .locals 1

    const-string v0, "Push_20160729."

    return-object v0
.end method
