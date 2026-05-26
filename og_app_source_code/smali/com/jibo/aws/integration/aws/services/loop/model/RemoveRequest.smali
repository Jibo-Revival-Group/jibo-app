.class public Lcom/jibo/aws/integration/aws/services/loop/model/RemoveRequest;
.super Lcom/jibo/aws/integration/aws/services/loop/model/JiboLoopRequest;


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 0

    invoke-direct {p0, p1}, Lcom/jibo/aws/integration/aws/services/loop/model/JiboLoopRequest;-><init>(Ljava/lang/String;)V

    return-void
.end method


# virtual methods
.method public getServiceMethodName()Ljava/lang/String;
    .locals 1

    const-string v0, "RemoveLoop"

    return-object v0
.end method
