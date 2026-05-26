.class final Lcom/google/api/client/repackaged/com/google/common/base/Converter$FunctionBasedConverter;
.super Lcom/google/api/client/repackaged/com/google/common/base/Converter;
.source "Converter.java"

# interfaces
.implements Ljava/io/Serializable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/api/client/repackaged/com/google/common/base/Converter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1a
    name = "FunctionBasedConverter"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<A:",
        "Ljava/lang/Object;",
        "B:",
        "Ljava/lang/Object;",
        ">",
        "Lcom/google/api/client/repackaged/com/google/common/base/Converter",
        "<TA;TB;>;",
        "Ljava/io/Serializable;"
    }
.end annotation


# instance fields
.field private final backwardFunction:Lcom/google/api/client/repackaged/com/google/common/base/Function;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/google/api/client/repackaged/com/google/common/base/Function",
            "<-TB;+TA;>;"
        }
    .end annotation
.end field

.field private final forwardFunction:Lcom/google/api/client/repackaged/com/google/common/base/Function;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/google/api/client/repackaged/com/google/common/base/Function",
            "<-TA;+TB;>;"
        }
    .end annotation
.end field


# direct methods
.method private constructor <init>(Lcom/google/api/client/repackaged/com/google/common/base/Function;Lcom/google/api/client/repackaged/com/google/common/base/Function;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/api/client/repackaged/com/google/common/base/Function",
            "<-TA;+TB;>;",
            "Lcom/google/api/client/repackaged/com/google/common/base/Function",
            "<-TB;+TA;>;)V"
        }
    .end annotation

    .prologue
    .line 408
    invoke-direct {p0}, Lcom/google/api/client/repackaged/com/google/common/base/Converter;-><init>()V

    .line 409
    invoke-static {p1}, Lcom/google/api/client/repackaged/com/google/common/base/Preconditions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/api/client/repackaged/com/google/common/base/Function;

    iput-object v0, p0, Lcom/google/api/client/repackaged/com/google/common/base/Converter$FunctionBasedConverter;->forwardFunction:Lcom/google/api/client/repackaged/com/google/common/base/Function;

    .line 410
    invoke-static {p2}, Lcom/google/api/client/repackaged/com/google/common/base/Preconditions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/api/client/repackaged/com/google/common/base/Function;

    iput-object v0, p0, Lcom/google/api/client/repackaged/com/google/common/base/Converter$FunctionBasedConverter;->backwardFunction:Lcom/google/api/client/repackaged/com/google/common/base/Function;

    .line 411
    return-void
.end method

.method synthetic constructor <init>(Lcom/google/api/client/repackaged/com/google/common/base/Function;Lcom/google/api/client/repackaged/com/google/common/base/Function;Lcom/google/api/client/repackaged/com/google/common/base/Converter$1;)V
    .locals 0

    .prologue
    .line 401
    invoke-direct {p0, p1, p2}, Lcom/google/api/client/repackaged/com/google/common/base/Converter$FunctionBasedConverter;-><init>(Lcom/google/api/client/repackaged/com/google/common/base/Function;Lcom/google/api/client/repackaged/com/google/common/base/Function;)V

    return-void
.end method


# virtual methods
.method protected doBackward(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TB;)TA;"
        }
    .end annotation

    .prologue
    .line 420
    iget-object v0, p0, Lcom/google/api/client/repackaged/com/google/common/base/Converter$FunctionBasedConverter;->backwardFunction:Lcom/google/api/client/repackaged/com/google/common/base/Function;

    invoke-interface {v0, p1}, Lcom/google/api/client/repackaged/com/google/common/base/Function;->apply(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method protected doForward(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TA;)TB;"
        }
    .end annotation

    .prologue
    .line 415
    iget-object v0, p0, Lcom/google/api/client/repackaged/com/google/common/base/Converter$FunctionBasedConverter;->forwardFunction:Lcom/google/api/client/repackaged/com/google/common/base/Function;

    invoke-interface {v0, p1}, Lcom/google/api/client/repackaged/com/google/common/base/Function;->apply(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 3

    .prologue
    const/4 v0, 0x0

    .line 425
    instance-of v1, p1, Lcom/google/api/client/repackaged/com/google/common/base/Converter$FunctionBasedConverter;

    if-eqz v1, :cond_0

    .line 426
    check-cast p1, Lcom/google/api/client/repackaged/com/google/common/base/Converter$FunctionBasedConverter;

    .line 427
    iget-object v1, p0, Lcom/google/api/client/repackaged/com/google/common/base/Converter$FunctionBasedConverter;->forwardFunction:Lcom/google/api/client/repackaged/com/google/common/base/Function;

    iget-object v2, p1, Lcom/google/api/client/repackaged/com/google/common/base/Converter$FunctionBasedConverter;->forwardFunction:Lcom/google/api/client/repackaged/com/google/common/base/Function;

    invoke-interface {v1, v2}, Lcom/google/api/client/repackaged/com/google/common/base/Function;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/google/api/client/repackaged/com/google/common/base/Converter$FunctionBasedConverter;->backwardFunction:Lcom/google/api/client/repackaged/com/google/common/base/Function;

    iget-object v2, p1, Lcom/google/api/client/repackaged/com/google/common/base/Converter$FunctionBasedConverter;->backwardFunction:Lcom/google/api/client/repackaged/com/google/common/base/Function;

    invoke-interface {v1, v2}, Lcom/google/api/client/repackaged/com/google/common/base/Function;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    const/4 v0, 0x1

    .line 430
    :cond_0
    return v0
.end method

.method public hashCode()I
    .locals 2

    .prologue
    .line 435
    iget-object v0, p0, Lcom/google/api/client/repackaged/com/google/common/base/Converter$FunctionBasedConverter;->forwardFunction:Lcom/google/api/client/repackaged/com/google/common/base/Function;

    invoke-virtual {v0}, Ljava/lang/Object;->hashCode()I

    move-result v0

    mul-int/lit8 v0, v0, 0x1f

    iget-object v1, p0, Lcom/google/api/client/repackaged/com/google/common/base/Converter$FunctionBasedConverter;->backwardFunction:Lcom/google/api/client/repackaged/com/google/common/base/Function;

    invoke-virtual {v1}, Ljava/lang/Object;->hashCode()I

    move-result v1

    add-int/2addr v0, v1

    return v0
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 440
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Converter.from("

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/google/api/client/repackaged/com/google/common/base/Converter$FunctionBasedConverter;->forwardFunction:Lcom/google/api/client/repackaged/com/google/common/base/Function;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/google/api/client/repackaged/com/google/common/base/Converter$FunctionBasedConverter;->backwardFunction:Lcom/google/api/client/repackaged/com/google/common/base/Function;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ")"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
