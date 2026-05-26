.class public Lcom/jibo/aws/integration/aws/services/oobe/model/SetupRobotRequest;
.super Lcom/jibo/aws/integration/aws/services/oobe/model/JiboOobeRequest;


# instance fields
.field private id:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/Expose;
    .end annotation
.end field

.field private token:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/Expose;
    .end annotation
.end field


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    invoke-direct {p0}, Lcom/jibo/aws/integration/aws/services/oobe/model/JiboOobeRequest;-><init>()V

    iput-object p1, p0, Lcom/jibo/aws/integration/aws/services/oobe/model/SetupRobotRequest;->id:Ljava/lang/String;

    iput-object p2, p0, Lcom/jibo/aws/integration/aws/services/oobe/model/SetupRobotRequest;->token:Ljava/lang/String;

    return-void
.end method


# virtual methods
.method public getId()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/oobe/model/SetupRobotRequest;->id:Ljava/lang/String;

    return-object v0
.end method

.method public getToken()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/oobe/model/SetupRobotRequest;->token:Ljava/lang/String;

    return-object v0
.end method

.method public hashCode()I
    .locals 3

    const/4 v1, 0x0

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/oobe/model/SetupRobotRequest;->getId()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_0

    move v0, v1

    :goto_0
    add-int/lit8 v0, v0, 0x1f

    mul-int/lit8 v0, v0, 0x1f

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/oobe/model/SetupRobotRequest;->getToken()Ljava/lang/String;

    move-result-object v2

    if-nez v2, :cond_1

    :goto_1
    add-int/2addr v0, v1

    return v0

    :cond_0
    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/oobe/model/SetupRobotRequest;->getId()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v0

    goto :goto_0

    :cond_1
    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/oobe/model/SetupRobotRequest;->getToken()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->hashCode()I

    move-result v1

    goto :goto_1
.end method

.method public setId(Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/jibo/aws/integration/aws/services/oobe/model/SetupRobotRequest;->id:Ljava/lang/String;

    return-void
.end method

.method public setToken(Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/jibo/aws/integration/aws/services/oobe/model/SetupRobotRequest;->token:Ljava/lang/String;

    return-void
.end method
