.class public Lcom/jibo/aws/integration/aws/services/binary/model/GetBinaryRequest;
.super Lcom/jibo/aws/integration/aws/services/binary/model/PathRequest;


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 0

    invoke-direct {p0, p1}, Lcom/jibo/aws/integration/aws/services/binary/model/PathRequest;-><init>(Ljava/lang/String;)V

    return-void
.end method


# virtual methods
.method public getServicePrefix()Ljava/lang/String;
    .locals 1

    const-string v0, "$TARGET$."

    return-object v0
.end method
