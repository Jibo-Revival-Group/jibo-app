.class public Lcom/jibo/aws/integration/aws/services/account/model/IdsRequestOptional;
.super Lcom/jibo/aws/integration/aws/services/account/model/JiboAccountRequest;


# instance fields
.field private ids:Ljava/util/List;
    .annotation runtime Lcom/google/gson/annotations/Expose;
    .end annotation

    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    invoke-direct {p0}, Lcom/jibo/aws/integration/aws/services/account/model/JiboAccountRequest;-><init>()V

    iput-object p1, p0, Lcom/jibo/aws/integration/aws/services/account/model/IdsRequestOptional;->ids:Ljava/util/List;

    return-void
.end method
