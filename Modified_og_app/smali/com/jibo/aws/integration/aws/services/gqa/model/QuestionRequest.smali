.class public Lcom/jibo/aws/integration/aws/services/gqa/model/QuestionRequest;
.super Lcom/jibo/aws/integration/aws/services/gqa/model/GQABaseRequest;


# instance fields
.field private input:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/Expose;
    .end annotation

    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "Input"
    .end annotation
.end field


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 0

    invoke-direct {p0}, Lcom/jibo/aws/integration/aws/services/gqa/model/GQABaseRequest;-><init>()V

    iput-object p1, p0, Lcom/jibo/aws/integration/aws/services/gqa/model/QuestionRequest;->input:Ljava/lang/String;

    return-void
.end method


# virtual methods
.method public getInput()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/gqa/model/QuestionRequest;->input:Ljava/lang/String;

    return-object v0
.end method

.method public setInput(Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/jibo/aws/integration/aws/services/gqa/model/QuestionRequest;->input:Ljava/lang/String;

    return-void
.end method
