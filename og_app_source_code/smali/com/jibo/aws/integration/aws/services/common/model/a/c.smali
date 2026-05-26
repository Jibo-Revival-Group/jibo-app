.class public Lcom/jibo/aws/integration/aws/services/common/model/a/c;
.super Lcom/jibo/aws/integration/aws/services/common/model/a/e;


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Lcom/jibo/aws/integration/aws/services/common/model/a/e;-><init>()V

    return-void
.end method


# virtual methods
.method protected b(Lcom/jibo/aws/integration/aws/services/common/model/JiboRequestAbstract;)Ljava/lang/String;
    .locals 1

    move-object v0, p1

    check-cast v0, Lcom/jibo/aws/integration/aws/services/common/model/IdRequestAbstract;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/common/model/IdRequestAbstract;->getId()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    invoke-super {p0, p1}, Lcom/jibo/aws/integration/aws/services/common/model/a/e;->b(Lcom/jibo/aws/integration/aws/services/common/model/JiboRequestAbstract;)Ljava/lang/String;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    const-string v0, "{}"

    goto :goto_0
.end method
