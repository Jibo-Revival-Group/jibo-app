.class final Lcom/firebase/jobdispatcher/JobInvocation;
.super Ljava/lang/Object;
.source "JobInvocation.java"

# interfaces
.implements Lcom/firebase/jobdispatcher/JobParameters;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/firebase/jobdispatcher/JobInvocation$Builder;
    }
.end annotation


# instance fields
.field private final a:Ljava/lang/String;

.field private final b:Ljava/lang/String;

.field private final c:Lcom/firebase/jobdispatcher/JobTrigger;

.field private final d:Z

.field private final e:I

.field private final f:[I

.field private final g:Landroid/os/Bundle;

.field private final h:Lcom/firebase/jobdispatcher/RetryStrategy;

.field private final i:Z

.field private final j:Lcom/firebase/jobdispatcher/TriggerReason;


# direct methods
.method private constructor <init>(Lcom/firebase/jobdispatcher/JobInvocation$Builder;)V
    .locals 1

    .prologue
    .line 48
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 49
    invoke-static {p1}, Lcom/firebase/jobdispatcher/JobInvocation$Builder;->a(Lcom/firebase/jobdispatcher/JobInvocation$Builder;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/firebase/jobdispatcher/JobInvocation;->a:Ljava/lang/String;

    .line 50
    invoke-static {p1}, Lcom/firebase/jobdispatcher/JobInvocation$Builder;->b(Lcom/firebase/jobdispatcher/JobInvocation$Builder;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/firebase/jobdispatcher/JobInvocation;->b:Ljava/lang/String;

    .line 51
    invoke-static {p1}, Lcom/firebase/jobdispatcher/JobInvocation$Builder;->c(Lcom/firebase/jobdispatcher/JobInvocation$Builder;)Lcom/firebase/jobdispatcher/JobTrigger;

    move-result-object v0

    iput-object v0, p0, Lcom/firebase/jobdispatcher/JobInvocation;->c:Lcom/firebase/jobdispatcher/JobTrigger;

    .line 52
    invoke-static {p1}, Lcom/firebase/jobdispatcher/JobInvocation$Builder;->d(Lcom/firebase/jobdispatcher/JobInvocation$Builder;)Lcom/firebase/jobdispatcher/RetryStrategy;

    move-result-object v0

    iput-object v0, p0, Lcom/firebase/jobdispatcher/JobInvocation;->h:Lcom/firebase/jobdispatcher/RetryStrategy;

    .line 53
    invoke-static {p1}, Lcom/firebase/jobdispatcher/JobInvocation$Builder;->e(Lcom/firebase/jobdispatcher/JobInvocation$Builder;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/firebase/jobdispatcher/JobInvocation;->d:Z

    .line 54
    invoke-static {p1}, Lcom/firebase/jobdispatcher/JobInvocation$Builder;->f(Lcom/firebase/jobdispatcher/JobInvocation$Builder;)I

    move-result v0

    iput v0, p0, Lcom/firebase/jobdispatcher/JobInvocation;->e:I

    .line 55
    invoke-static {p1}, Lcom/firebase/jobdispatcher/JobInvocation$Builder;->g(Lcom/firebase/jobdispatcher/JobInvocation$Builder;)[I

    move-result-object v0

    iput-object v0, p0, Lcom/firebase/jobdispatcher/JobInvocation;->f:[I

    .line 56
    invoke-static {p1}, Lcom/firebase/jobdispatcher/JobInvocation$Builder;->h(Lcom/firebase/jobdispatcher/JobInvocation$Builder;)Landroid/os/Bundle;

    move-result-object v0

    iput-object v0, p0, Lcom/firebase/jobdispatcher/JobInvocation;->g:Landroid/os/Bundle;

    .line 57
    invoke-static {p1}, Lcom/firebase/jobdispatcher/JobInvocation$Builder;->i(Lcom/firebase/jobdispatcher/JobInvocation$Builder;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/firebase/jobdispatcher/JobInvocation;->i:Z

    .line 58
    invoke-static {p1}, Lcom/firebase/jobdispatcher/JobInvocation$Builder;->j(Lcom/firebase/jobdispatcher/JobInvocation$Builder;)Lcom/firebase/jobdispatcher/TriggerReason;

    move-result-object v0

    iput-object v0, p0, Lcom/firebase/jobdispatcher/JobInvocation;->j:Lcom/firebase/jobdispatcher/TriggerReason;

    .line 59
    return-void
.end method

.method synthetic constructor <init>(Lcom/firebase/jobdispatcher/JobInvocation$Builder;Lcom/firebase/jobdispatcher/JobInvocation$1;)V
    .locals 0

    .prologue
    .line 26
    invoke-direct {p0, p1}, Lcom/firebase/jobdispatcher/JobInvocation;-><init>(Lcom/firebase/jobdispatcher/JobInvocation$Builder;)V

    return-void
.end method


# virtual methods
.method public a()[I
    .locals 1

    .prologue
    .line 92
    iget-object v0, p0, Lcom/firebase/jobdispatcher/JobInvocation;->f:[I

    return-object v0
.end method

.method public b()Landroid/os/Bundle;
    .locals 1

    .prologue
    .line 98
    iget-object v0, p0, Lcom/firebase/jobdispatcher/JobInvocation;->g:Landroid/os/Bundle;

    return-object v0
.end method

.method public c()Lcom/firebase/jobdispatcher/RetryStrategy;
    .locals 1

    .prologue
    .line 104
    iget-object v0, p0, Lcom/firebase/jobdispatcher/JobInvocation;->h:Lcom/firebase/jobdispatcher/RetryStrategy;

    return-object v0
.end method

.method public d()Z
    .locals 1

    .prologue
    .line 109
    iget-boolean v0, p0, Lcom/firebase/jobdispatcher/JobInvocation;->i:Z

    return v0
.end method

.method public e()Ljava/lang/String;
    .locals 1

    .prologue
    .line 70
    iget-object v0, p0, Lcom/firebase/jobdispatcher/JobInvocation;->a:Ljava/lang/String;

    return-object v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 4

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    .line 204
    if-ne p0, p1, :cond_1

    .line 213
    :cond_0
    :goto_0
    return v0

    .line 207
    :cond_1
    if-eqz p1, :cond_2

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_3

    :cond_2
    move v0, v1

    .line 208
    goto :goto_0

    .line 211
    :cond_3
    check-cast p1, Lcom/firebase/jobdispatcher/JobInvocation;

    .line 213
    iget-object v2, p0, Lcom/firebase/jobdispatcher/JobInvocation;->a:Ljava/lang/String;

    iget-object v3, p1, Lcom/firebase/jobdispatcher/JobInvocation;->a:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_4

    iget-object v2, p0, Lcom/firebase/jobdispatcher/JobInvocation;->b:Ljava/lang/String;

    iget-object v3, p1, Lcom/firebase/jobdispatcher/JobInvocation;->b:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    :cond_4
    move v0, v1

    goto :goto_0
.end method

.method public f()Lcom/firebase/jobdispatcher/JobTrigger;
    .locals 1

    .prologue
    .line 76
    iget-object v0, p0, Lcom/firebase/jobdispatcher/JobInvocation;->c:Lcom/firebase/jobdispatcher/JobTrigger;

    return-object v0
.end method

.method public g()I
    .locals 1

    .prologue
    .line 81
    iget v0, p0, Lcom/firebase/jobdispatcher/JobInvocation;->e:I

    return v0
.end method

.method public h()Z
    .locals 1

    .prologue
    .line 86
    iget-boolean v0, p0, Lcom/firebase/jobdispatcher/JobInvocation;->d:Z

    return v0
.end method

.method public hashCode()I
    .locals 2

    .prologue
    .line 218
    iget-object v0, p0, Lcom/firebase/jobdispatcher/JobInvocation;->a:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v0

    .line 219
    mul-int/lit8 v0, v0, 0x1f

    iget-object v1, p0, Lcom/firebase/jobdispatcher/JobInvocation;->b:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->hashCode()I

    move-result v1

    add-int/2addr v0, v1

    .line 220
    return v0
.end method

.method public i()Ljava/lang/String;
    .locals 1

    .prologue
    .line 64
    iget-object v0, p0, Lcom/firebase/jobdispatcher/JobInvocation;->b:Ljava/lang/String;

    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .locals 3

    .prologue
    const/16 v2, 0x27

    .line 225
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "JobInvocation{tag=\'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/firebase/jobdispatcher/JobInvocation;->a:Ljava/lang/String;

    .line 227
    invoke-static {v1}, Lorg/json/JSONObject;->quote(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", service=\'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/firebase/jobdispatcher/JobInvocation;->b:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", trigger="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/firebase/jobdispatcher/JobInvocation;->c:Lcom/firebase/jobdispatcher/JobTrigger;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", recurring="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-boolean v1, p0, Lcom/firebase/jobdispatcher/JobInvocation;->d:Z

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", lifetime="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Lcom/firebase/jobdispatcher/JobInvocation;->e:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", constraints="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/firebase/jobdispatcher/JobInvocation;->f:[I

    .line 239
    invoke-static {v1}, Ljava/util/Arrays;->toString([I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", extras="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/firebase/jobdispatcher/JobInvocation;->g:Landroid/os/Bundle;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", retryStrategy="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/firebase/jobdispatcher/JobInvocation;->h:Lcom/firebase/jobdispatcher/RetryStrategy;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", replaceCurrent="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-boolean v1, p0, Lcom/firebase/jobdispatcher/JobInvocation;->i:Z

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", triggerReason="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/firebase/jobdispatcher/JobInvocation;->j:Lcom/firebase/jobdispatcher/TriggerReason;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const/16 v1, 0x7d

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 225
    return-object v0
.end method
