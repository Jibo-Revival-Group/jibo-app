.class public Lcom/jibo/aws/integration/aws/services/push/model/CreateDeviceRequest;
.super Lcom/jibo/aws/integration/aws/services/push/model/JiboPushRequest;


# instance fields
.field private name:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/Expose;
    .end annotation
.end field

.field private pushToken:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/Expose;
    .end annotation
.end field

.field private type:Lcom/jibo/aws/integration/aws/services/common/model/Device$Type;
    .annotation runtime Lcom/google/gson/annotations/Expose;
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/jibo/aws/integration/aws/services/common/model/Device;)V
    .locals 1

    invoke-direct {p0}, Lcom/jibo/aws/integration/aws/services/push/model/JiboPushRequest;-><init>()V

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/common/model/Device;->getName()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/aws/integration/aws/services/push/model/CreateDeviceRequest;->name:Ljava/lang/String;

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/common/model/Device;->getPushToken()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/aws/integration/aws/services/push/model/CreateDeviceRequest;->pushToken:Ljava/lang/String;

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/common/model/Device;->getType()Lcom/jibo/aws/integration/aws/services/common/model/Device$Type;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/aws/integration/aws/services/push/model/CreateDeviceRequest;->type:Lcom/jibo/aws/integration/aws/services/common/model/Device$Type;

    return-void
.end method


# virtual methods
.method public getName()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/push/model/CreateDeviceRequest;->name:Ljava/lang/String;

    return-object v0
.end method

.method public getPushToken()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/push/model/CreateDeviceRequest;->pushToken:Ljava/lang/String;

    return-object v0
.end method

.method public getType()Lcom/jibo/aws/integration/aws/services/common/model/Device$Type;
    .locals 1

    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/push/model/CreateDeviceRequest;->type:Lcom/jibo/aws/integration/aws/services/common/model/Device$Type;

    return-object v0
.end method

.method public setName(Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/jibo/aws/integration/aws/services/push/model/CreateDeviceRequest;->name:Ljava/lang/String;

    return-void
.end method

.method public setPushToken(Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/jibo/aws/integration/aws/services/push/model/CreateDeviceRequest;->pushToken:Ljava/lang/String;

    return-void
.end method

.method public setType(Lcom/jibo/aws/integration/aws/services/common/model/Device$Type;)V
    .locals 0

    iput-object p1, p0, Lcom/jibo/aws/integration/aws/services/push/model/CreateDeviceRequest;->type:Lcom/jibo/aws/integration/aws/services/common/model/Device$Type;

    return-void
.end method
