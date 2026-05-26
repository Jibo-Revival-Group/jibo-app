.class public abstract Lcom/jibo/aws/integration/aws/services/common/model/IdRequestAbstract;
.super Lcom/jibo/aws/integration/aws/services/common/model/JiboRequestAbstract;


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 0

    invoke-direct {p0}, Lcom/jibo/aws/integration/aws/services/common/model/JiboRequestAbstract;-><init>()V

    invoke-virtual {p0, p1}, Lcom/jibo/aws/integration/aws/services/common/model/IdRequestAbstract;->setId(Ljava/lang/String;)V

    return-void
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 4

    const/4 v1, 0x1

    const/4 v2, 0x0

    if-ne p0, p1, :cond_1

    move v2, v1

    :cond_0
    :goto_0
    return v2

    :cond_1
    if-eqz p1, :cond_0

    instance-of v0, p1, Lcom/jibo/aws/integration/aws/services/common/model/IdRequestAbstract;

    if-eqz v0, :cond_0

    check-cast p1, Lcom/jibo/aws/integration/aws/services/common/model/IdRequestAbstract;

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/common/model/IdRequestAbstract;->getId()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_3

    move v0, v1

    :goto_1
    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/common/model/IdRequestAbstract;->getId()Ljava/lang/String;

    move-result-object v3

    if-nez v3, :cond_4

    move v3, v1

    :goto_2
    xor-int/2addr v0, v3

    if-nez v0, :cond_0

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/common/model/IdRequestAbstract;->getId()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_2

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/common/model/IdRequestAbstract;->getId()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/common/model/IdRequestAbstract;->getId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    :cond_2
    move v2, v1

    goto :goto_0

    :cond_3
    move v0, v2

    goto :goto_1

    :cond_4
    move v3, v2

    goto :goto_2
.end method

.method public abstract getId()Ljava/lang/String;
.end method

.method public hashCode()I
    .locals 1

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/common/model/IdRequestAbstract;->getId()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_0

    const/4 v0, 0x0

    :goto_0
    add-int/lit8 v0, v0, 0x1f

    return v0

    :cond_0
    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/common/model/IdRequestAbstract;->getId()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v0

    goto :goto_0
.end method

.method public abstract setId(Ljava/lang/String;)V
.end method

.method public abstract toString()Ljava/lang/String;
.end method
