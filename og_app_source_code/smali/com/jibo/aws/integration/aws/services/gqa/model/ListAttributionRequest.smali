.class public Lcom/jibo/aws/integration/aws/services/gqa/model/ListAttributionRequest;
.super Lcom/jibo/aws/integration/aws/services/gqa/model/GQABaseRequest;


# instance fields
.field private after:J
    .annotation runtime Lcom/google/gson/annotations/Expose;
    .end annotation
.end field

.field private before:J
    .annotation runtime Lcom/google/gson/annotations/Expose;
    .end annotation
.end field

.field private id:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/Expose;
    .end annotation

    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "ID"
    .end annotation
.end field

.field private service:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/Expose;
    .end annotation

    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "Service"
    .end annotation
.end field


# direct methods
.method public constructor <init>(Ljava/lang/String;J)V
    .locals 2

    invoke-direct {p0}, Lcom/jibo/aws/integration/aws/services/gqa/model/GQABaseRequest;-><init>()V

    const-string v0, ""

    iput-object v0, p0, Lcom/jibo/aws/integration/aws/services/gqa/model/ListAttributionRequest;->service:Ljava/lang/String;

    iput-object p1, p0, Lcom/jibo/aws/integration/aws/services/gqa/model/ListAttributionRequest;->id:Ljava/lang/String;

    iput-wide p2, p0, Lcom/jibo/aws/integration/aws/services/gqa/model/ListAttributionRequest;->before:J

    return-void
.end method


# virtual methods
.method public getAfter()J
    .locals 2

    iget-wide v0, p0, Lcom/jibo/aws/integration/aws/services/gqa/model/ListAttributionRequest;->after:J

    return-wide v0
.end method

.method public getBefore()J
    .locals 2

    iget-wide v0, p0, Lcom/jibo/aws/integration/aws/services/gqa/model/ListAttributionRequest;->before:J

    return-wide v0
.end method

.method public getId()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/gqa/model/ListAttributionRequest;->id:Ljava/lang/String;

    return-object v0
.end method

.method public getService()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/gqa/model/ListAttributionRequest;->service:Ljava/lang/String;

    return-object v0
.end method

.method public setAfter(J)V
    .locals 1

    iput-wide p1, p0, Lcom/jibo/aws/integration/aws/services/gqa/model/ListAttributionRequest;->after:J

    return-void
.end method

.method public setBefore(J)V
    .locals 1

    iput-wide p1, p0, Lcom/jibo/aws/integration/aws/services/gqa/model/ListAttributionRequest;->before:J

    return-void
.end method

.method public setId(Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/jibo/aws/integration/aws/services/gqa/model/ListAttributionRequest;->id:Ljava/lang/String;

    return-void
.end method

.method public setService(Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/jibo/aws/integration/aws/services/gqa/model/ListAttributionRequest;->service:Ljava/lang/String;

    return-void
.end method
