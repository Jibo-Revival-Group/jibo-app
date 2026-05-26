.class public final Lcom/firebase/jobdispatcher/Job;
.super Ljava/lang/Object;
.source "Job.java"

# interfaces
.implements Lcom/firebase/jobdispatcher/JobParameters;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/firebase/jobdispatcher/Job$Builder;
    }
.end annotation


# instance fields
.field private final a:Ljava/lang/String;

.field private final b:Ljava/lang/String;

.field private final c:Lcom/firebase/jobdispatcher/JobTrigger;

.field private final d:Lcom/firebase/jobdispatcher/RetryStrategy;

.field private final e:I

.field private final f:Z

.field private final g:[I

.field private final h:Z

.field private final i:Landroid/os/Bundle;


# direct methods
.method private constructor <init>(Lcom/firebase/jobdispatcher/Job$Builder;)V
    .locals 2

    .prologue
    .line 39
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 40
    invoke-static {p1}, Lcom/firebase/jobdispatcher/Job$Builder;->a(Lcom/firebase/jobdispatcher/Job$Builder;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/firebase/jobdispatcher/Job;->a:Ljava/lang/String;

    .line 41
    invoke-static {p1}, Lcom/firebase/jobdispatcher/Job$Builder;->b(Lcom/firebase/jobdispatcher/Job$Builder;)Landroid/os/Bundle;

    move-result-object v0

    if-nez v0, :cond_0

    const/4 v0, 0x0

    :goto_0
    iput-object v0, p0, Lcom/firebase/jobdispatcher/Job;->i:Landroid/os/Bundle;

    .line 42
    invoke-static {p1}, Lcom/firebase/jobdispatcher/Job$Builder;->c(Lcom/firebase/jobdispatcher/Job$Builder;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/firebase/jobdispatcher/Job;->b:Ljava/lang/String;

    .line 43
    invoke-static {p1}, Lcom/firebase/jobdispatcher/Job$Builder;->d(Lcom/firebase/jobdispatcher/Job$Builder;)Lcom/firebase/jobdispatcher/JobTrigger;

    move-result-object v0

    iput-object v0, p0, Lcom/firebase/jobdispatcher/Job;->c:Lcom/firebase/jobdispatcher/JobTrigger;

    .line 44
    invoke-static {p1}, Lcom/firebase/jobdispatcher/Job$Builder;->e(Lcom/firebase/jobdispatcher/Job$Builder;)Lcom/firebase/jobdispatcher/RetryStrategy;

    move-result-object v0

    iput-object v0, p0, Lcom/firebase/jobdispatcher/Job;->d:Lcom/firebase/jobdispatcher/RetryStrategy;

    .line 45
    invoke-static {p1}, Lcom/firebase/jobdispatcher/Job$Builder;->f(Lcom/firebase/jobdispatcher/Job$Builder;)I

    move-result v0

    iput v0, p0, Lcom/firebase/jobdispatcher/Job;->e:I

    .line 46
    invoke-static {p1}, Lcom/firebase/jobdispatcher/Job$Builder;->g(Lcom/firebase/jobdispatcher/Job$Builder;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/firebase/jobdispatcher/Job;->f:Z

    .line 47
    invoke-static {p1}, Lcom/firebase/jobdispatcher/Job$Builder;->h(Lcom/firebase/jobdispatcher/Job$Builder;)[I

    move-result-object v0

    if-eqz v0, :cond_1

    invoke-static {p1}, Lcom/firebase/jobdispatcher/Job$Builder;->h(Lcom/firebase/jobdispatcher/Job$Builder;)[I

    move-result-object v0

    :goto_1
    iput-object v0, p0, Lcom/firebase/jobdispatcher/Job;->g:[I

    .line 48
    invoke-static {p1}, Lcom/firebase/jobdispatcher/Job$Builder;->i(Lcom/firebase/jobdispatcher/Job$Builder;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/firebase/jobdispatcher/Job;->h:Z

    .line 49
    return-void

    .line 41
    :cond_0
    new-instance v0, Landroid/os/Bundle;

    invoke-static {p1}, Lcom/firebase/jobdispatcher/Job$Builder;->b(Lcom/firebase/jobdispatcher/Job$Builder;)Landroid/os/Bundle;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/Bundle;-><init>(Landroid/os/Bundle;)V

    goto :goto_0

    .line 47
    :cond_1
    const/4 v0, 0x0

    new-array v0, v0, [I

    goto :goto_1
.end method

.method synthetic constructor <init>(Lcom/firebase/jobdispatcher/Job$Builder;Lcom/firebase/jobdispatcher/Job$1;)V
    .locals 0

    .prologue
    .line 28
    invoke-direct {p0, p1}, Lcom/firebase/jobdispatcher/Job;-><init>(Lcom/firebase/jobdispatcher/Job$Builder;)V

    return-void
.end method


# virtual methods
.method public a()[I
    .locals 1

    .prologue
    .line 55
    iget-object v0, p0, Lcom/firebase/jobdispatcher/Job;->g:[I

    return-object v0
.end method

.method public b()Landroid/os/Bundle;
    .locals 1

    .prologue
    .line 62
    iget-object v0, p0, Lcom/firebase/jobdispatcher/Job;->i:Landroid/os/Bundle;

    return-object v0
.end method

.method public c()Lcom/firebase/jobdispatcher/RetryStrategy;
    .locals 1

    .prologue
    .line 69
    iget-object v0, p0, Lcom/firebase/jobdispatcher/Job;->d:Lcom/firebase/jobdispatcher/RetryStrategy;

    return-object v0
.end method

.method public d()Z
    .locals 1

    .prologue
    .line 75
    iget-boolean v0, p0, Lcom/firebase/jobdispatcher/Job;->h:Z

    return v0
.end method

.method public e()Ljava/lang/String;
    .locals 1

    .prologue
    .line 88
    iget-object v0, p0, Lcom/firebase/jobdispatcher/Job;->b:Ljava/lang/String;

    return-object v0
.end method

.method public f()Lcom/firebase/jobdispatcher/JobTrigger;
    .locals 1

    .prologue
    .line 95
    iget-object v0, p0, Lcom/firebase/jobdispatcher/Job;->c:Lcom/firebase/jobdispatcher/JobTrigger;

    return-object v0
.end method

.method public g()I
    .locals 1

    .prologue
    .line 101
    iget v0, p0, Lcom/firebase/jobdispatcher/Job;->e:I

    return v0
.end method

.method public h()Z
    .locals 1

    .prologue
    .line 107
    iget-boolean v0, p0, Lcom/firebase/jobdispatcher/Job;->f:Z

    return v0
.end method

.method public i()Ljava/lang/String;
    .locals 1

    .prologue
    .line 114
    iget-object v0, p0, Lcom/firebase/jobdispatcher/Job;->a:Ljava/lang/String;

    return-object v0
.end method
