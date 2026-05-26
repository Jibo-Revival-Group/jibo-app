.class public Lcom/jibo/aws/integration/aws/services/account/model/RemovePhotoRequest;
.super Lcom/jibo/aws/integration/aws/services/common/model/EmptyRequest;


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Lcom/jibo/aws/integration/aws/services/common/model/EmptyRequest;-><init>()V

    return-void
.end method


# virtual methods
.method public getServiceAbbr()Ljava/lang/String;
    .locals 1

    const-string v0, "account"

    return-object v0
.end method

.method public getServicePrefix()Ljava/lang/String;
    .locals 1

    const-string v0, "Account_20151111."

    return-object v0
.end method
