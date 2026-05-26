.class public Lcom/jibo/aws/integration/helpers/AccountHelper;
.super Ljava/lang/Object;


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getName(Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;)Ljava/lang/String;
    .locals 1

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getNickName()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_0

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getFirstName()Ljava/lang/String;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getNickName()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method
