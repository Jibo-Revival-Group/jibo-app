.class public abstract Lcom/jibo/aws/integration/aws/services/robotProperties/model/JiboRobotPropertiesRequest;
.super Lcom/jibo/aws/integration/aws/services/common/model/JiboRequestAbstract;


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Lcom/jibo/aws/integration/aws/services/common/model/JiboRequestAbstract;-><init>()V

    return-void
.end method


# virtual methods
.method public getServiceAbbr()Ljava/lang/String;
    .locals 1

    const-string v0, "robotproperties"

    return-object v0
.end method

.method public getServicePrefix()Ljava/lang/String;
    .locals 1

    const-string v0, "RobotProperties_20160225."

    return-object v0
.end method
