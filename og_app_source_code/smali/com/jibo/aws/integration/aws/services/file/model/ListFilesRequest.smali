.class public Lcom/jibo/aws/integration/aws/services/file/model/ListFilesRequest;
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

    const-string v0, "photo"

    return-object v0
.end method

.method public getServicePrefix()Ljava/lang/String;
    .locals 1

    const-string v0, "$TARGET$."

    return-object v0
.end method
