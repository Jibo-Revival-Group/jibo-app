.class public Lcom/jibo/aws/integration/aws/services/oobe/model/GetStatusRequest;
.super Lcom/jibo/aws/integration/aws/services/oobe/model/JiboOobeRequest;


# instance fields
.field private token:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/Expose;
    .end annotation
.end field


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 0

    invoke-direct {p0}, Lcom/jibo/aws/integration/aws/services/oobe/model/JiboOobeRequest;-><init>()V

    iput-object p1, p0, Lcom/jibo/aws/integration/aws/services/oobe/model/GetStatusRequest;->token:Ljava/lang/String;

    return-void
.end method


# virtual methods
.method public getToken()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/oobe/model/GetStatusRequest;->token:Ljava/lang/String;

    return-object v0
.end method

.method public hashCode()I
    .locals 1

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/oobe/model/GetStatusRequest;->getToken()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_0

    const/4 v0, 0x0

    :goto_0
    add-int/lit8 v0, v0, 0x1f

    return v0

    :cond_0
    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/oobe/model/GetStatusRequest;->getToken()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v0

    goto :goto_0
.end method

.method public setToken(Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/jibo/aws/integration/aws/services/oobe/model/GetStatusRequest;->token:Ljava/lang/String;

    return-void
.end method
