.class public Lcom/jibo/aws/integration/aws/services/gqa/model/GQAAttribution;
.super Ljava/lang/Object;

# interfaces
.implements Landroid/os/Parcelable;
.implements Ljava/io/Serializable;


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Lcom/jibo/aws/integration/aws/services/gqa/model/GQAAttribution;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private answer:Ljava/lang/String;

.field private source:Ljava/lang/String;

.field private success:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    new-instance v0, Lcom/jibo/aws/integration/aws/services/gqa/model/GQAAttribution$1;

    invoke-direct {v0}, Lcom/jibo/aws/integration/aws/services/gqa/model/GQAAttribution$1;-><init>()V

    sput-object v0, Lcom/jibo/aws/integration/aws/services/gqa/model/GQAAttribution;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method protected constructor <init>(Landroid/os/Parcel;)V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    invoke-virtual {p1}, Landroid/os/Parcel;->readByte()B

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    iput-boolean v0, p0, Lcom/jibo/aws/integration/aws/services/gqa/model/GQAAttribution;->success:Z

    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/aws/integration/aws/services/gqa/model/GQAAttribution;->source:Ljava/lang/String;

    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/aws/integration/aws/services/gqa/model/GQAAttribution;->answer:Ljava/lang/String;

    return-void

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public describeContents()I
    .locals 1

    const/4 v0, 0x0

    return v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 4

    const/4 v0, 0x1

    const/4 v1, 0x0

    if-ne p0, p1, :cond_1

    move v1, v0

    :cond_0
    :goto_0
    return v1

    :cond_1
    instance-of v2, p1, Lcom/jibo/aws/integration/aws/services/gqa/model/GQAAttribution;

    if-eqz v2, :cond_0

    check-cast p1, Lcom/jibo/aws/integration/aws/services/gqa/model/GQAAttribution;

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/gqa/model/GQAAttribution;->isSuccess()Z

    move-result v2

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/gqa/model/GQAAttribution;->isSuccess()Z

    move-result v3

    if-ne v2, v3, :cond_0

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/gqa/model/GQAAttribution;->getSource()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_4

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/gqa/model/GQAAttribution;->getSource()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/gqa/model/GQAAttribution;->getSource()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    :cond_2
    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/gqa/model/GQAAttribution;->getAnswer()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_5

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/gqa/model/GQAAttribution;->getAnswer()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/gqa/model/GQAAttribution;->getAnswer()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    :cond_3
    :goto_1
    move v1, v0

    goto :goto_0

    :cond_4
    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/gqa/model/GQAAttribution;->getSource()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_2

    goto :goto_0

    :cond_5
    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/gqa/model/GQAAttribution;->getAnswer()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_3

    move v0, v1

    goto :goto_1
.end method

.method public getAnswer()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/gqa/model/GQAAttribution;->answer:Ljava/lang/String;

    return-object v0
.end method

.method public getSource()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/gqa/model/GQAAttribution;->source:Ljava/lang/String;

    return-object v0
.end method

.method public hashCode()I
    .locals 3

    const/4 v1, 0x0

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/gqa/model/GQAAttribution;->isSuccess()Z

    move-result v0

    if-eqz v0, :cond_1

    const/4 v0, 0x1

    :goto_0
    mul-int/lit8 v2, v0, 0x1f

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/gqa/model/GQAAttribution;->getSource()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_2

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/gqa/model/GQAAttribution;->getSource()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v0

    :goto_1
    add-int/2addr v0, v2

    mul-int/lit8 v0, v0, 0x1f

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/gqa/model/GQAAttribution;->getAnswer()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_0

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/gqa/model/GQAAttribution;->getAnswer()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->hashCode()I

    move-result v1

    :cond_0
    add-int/2addr v0, v1

    return v0

    :cond_1
    move v0, v1

    goto :goto_0

    :cond_2
    move v0, v1

    goto :goto_1
.end method

.method public isSuccess()Z
    .locals 1

    iget-boolean v0, p0, Lcom/jibo/aws/integration/aws/services/gqa/model/GQAAttribution;->success:Z

    return v0
.end method

.method public setAnswer(Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/jibo/aws/integration/aws/services/gqa/model/GQAAttribution;->answer:Ljava/lang/String;

    return-void
.end method

.method public setSource(Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/jibo/aws/integration/aws/services/gqa/model/GQAAttribution;->source:Ljava/lang/String;

    return-void
.end method

.method public setSuccess(Z)V
    .locals 0

    iput-boolean p1, p0, Lcom/jibo/aws/integration/aws/services/gqa/model/GQAAttribution;->success:Z

    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 3

    const/16 v2, 0x27

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "GQAAttribution{success="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-boolean v1, p0, Lcom/jibo/aws/integration/aws/services/gqa/model/GQAAttribution;->success:Z

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", source=\'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/aws/integration/aws/services/gqa/model/GQAAttribution;->source:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", answer=\'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/aws/integration/aws/services/gqa/model/GQAAttribution;->answer:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    const/16 v1, 0x7d

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 1

    iget-boolean v0, p0, Lcom/jibo/aws/integration/aws/services/gqa/model/GQAAttribution;->success:Z

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    int-to-byte v0, v0

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeByte(B)V

    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/gqa/model/GQAAttribution;->source:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/gqa/model/GQAAttribution;->answer:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    return-void

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
