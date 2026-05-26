.class public Lcom/jibo/aws/integration/aws/services/media/model/CreateRequest;
.super Lcom/jibo/aws/integration/aws/services/binary/model/CreateBinaryRequest;


# instance fields
.field private isEncrypted:Ljava/lang/Boolean;
    .annotation runtime Lcom/google/gson/annotations/Expose;
    .end annotation
.end field

.field private loopId:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/Expose;
    .end annotation
.end field

.field private reference:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/Expose;
    .end annotation
.end field

.field private type:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/Expose;
    .end annotation
.end field


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/io/File;Ljava/lang/Boolean;)V
    .locals 1

    const/4 v0, 0x0

    invoke-direct {p0, p4, p5, v0}, Lcom/jibo/aws/integration/aws/services/binary/model/CreateBinaryRequest;-><init>(Ljava/lang/String;Ljava/io/File;Ljava/util/Map;)V

    iput-object p1, p0, Lcom/jibo/aws/integration/aws/services/media/model/CreateRequest;->loopId:Ljava/lang/String;

    iput-object p2, p0, Lcom/jibo/aws/integration/aws/services/media/model/CreateRequest;->type:Ljava/lang/String;

    iput-object p3, p0, Lcom/jibo/aws/integration/aws/services/media/model/CreateRequest;->reference:Ljava/lang/String;

    iput-object p6, p0, Lcom/jibo/aws/integration/aws/services/media/model/CreateRequest;->isEncrypted:Ljava/lang/Boolean;

    return-void
.end method


# virtual methods
.method public getLoopId()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/media/model/CreateRequest;->loopId:Ljava/lang/String;

    return-object v0
.end method

.method public getReference()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/media/model/CreateRequest;->reference:Ljava/lang/String;

    return-object v0
.end method

.method public getServiceAbbr()Ljava/lang/String;
    .locals 1

    const-string v0, "media"

    return-object v0
.end method

.method public getServicePrefix()Ljava/lang/String;
    .locals 1

    const-string v0, "Media_20160725."

    return-object v0
.end method

.method public getType()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/media/model/CreateRequest;->type:Ljava/lang/String;

    return-object v0
.end method

.method public hashCode()I
    .locals 3

    const/4 v1, 0x0

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/media/model/CreateRequest;->getLoopId()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_0

    move v0, v1

    :goto_0
    add-int/lit8 v0, v0, 0x1f

    mul-int/lit8 v2, v0, 0x1f

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/media/model/CreateRequest;->getType()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_1

    move v0, v1

    :goto_1
    add-int/2addr v0, v2

    mul-int/lit8 v2, v0, 0x1f

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/media/model/CreateRequest;->getReference()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_2

    move v0, v1

    :goto_2
    add-int/2addr v0, v2

    mul-int/lit8 v0, v0, 0x1f

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/media/model/CreateRequest;->isEncrypted()Ljava/lang/Boolean;

    move-result-object v2

    if-nez v2, :cond_3

    :goto_3
    add-int/2addr v0, v1

    return v0

    :cond_0
    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/media/model/CreateRequest;->getLoopId()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v0

    goto :goto_0

    :cond_1
    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/media/model/CreateRequest;->getType()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v0

    goto :goto_1

    :cond_2
    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/media/model/CreateRequest;->getReference()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v0

    goto :goto_2

    :cond_3
    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/media/model/CreateRequest;->isEncrypted()Ljava/lang/Boolean;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Boolean;->hashCode()I

    move-result v1

    goto :goto_3
.end method

.method public isEncrypted()Ljava/lang/Boolean;
    .locals 1

    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/media/model/CreateRequest;->isEncrypted:Ljava/lang/Boolean;

    return-object v0
.end method

.method public setEncrypted(Ljava/lang/Boolean;)V
    .locals 0

    iput-object p1, p0, Lcom/jibo/aws/integration/aws/services/media/model/CreateRequest;->isEncrypted:Ljava/lang/Boolean;

    return-void
.end method

.method public setLoopId(Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/jibo/aws/integration/aws/services/media/model/CreateRequest;->loopId:Ljava/lang/String;

    return-void
.end method

.method public setReference(Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/jibo/aws/integration/aws/services/media/model/CreateRequest;->reference:Ljava/lang/String;

    return-void
.end method

.method public setType(Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/jibo/aws/integration/aws/services/media/model/CreateRequest;->type:Ljava/lang/String;

    return-void
.end method
