.class public final Lcom/firebase/jobdispatcher/Job$Builder;
.super Ljava/lang/Object;
.source "Job.java"

# interfaces
.implements Lcom/firebase/jobdispatcher/JobParameters;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/firebase/jobdispatcher/Job;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "Builder"
.end annotation


# instance fields
.field private final a:Lcom/firebase/jobdispatcher/ValidationEnforcer;

.field private b:Ljava/lang/String;

.field private c:Landroid/os/Bundle;

.field private d:Ljava/lang/String;

.field private e:Lcom/firebase/jobdispatcher/JobTrigger;

.field private f:I

.field private g:[I

.field private h:Lcom/firebase/jobdispatcher/RetryStrategy;

.field private i:Z

.field private j:Z


# direct methods
.method constructor <init>(Lcom/firebase/jobdispatcher/ValidationEnforcer;)V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 135
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 127
    sget-object v0, Lcom/firebase/jobdispatcher/Trigger;->a:Lcom/firebase/jobdispatcher/JobTrigger$ImmediateTrigger;

    iput-object v0, p0, Lcom/firebase/jobdispatcher/Job$Builder;->e:Lcom/firebase/jobdispatcher/JobTrigger;

    .line 128
    const/4 v0, 0x1

    iput v0, p0, Lcom/firebase/jobdispatcher/Job$Builder;->f:I

    .line 131
    sget-object v0, Lcom/firebase/jobdispatcher/RetryStrategy;->a:Lcom/firebase/jobdispatcher/RetryStrategy;

    iput-object v0, p0, Lcom/firebase/jobdispatcher/Job$Builder;->h:Lcom/firebase/jobdispatcher/RetryStrategy;

    .line 132
    iput-boolean v1, p0, Lcom/firebase/jobdispatcher/Job$Builder;->i:Z

    .line 133
    iput-boolean v1, p0, Lcom/firebase/jobdispatcher/Job$Builder;->j:Z

    .line 136
    iput-object p1, p0, Lcom/firebase/jobdispatcher/Job$Builder;->a:Lcom/firebase/jobdispatcher/ValidationEnforcer;

    .line 137
    return-void
.end method

.method constructor <init>(Lcom/firebase/jobdispatcher/ValidationEnforcer;Lcom/firebase/jobdispatcher/JobParameters;)V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 139
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 127
    sget-object v0, Lcom/firebase/jobdispatcher/Trigger;->a:Lcom/firebase/jobdispatcher/JobTrigger$ImmediateTrigger;

    iput-object v0, p0, Lcom/firebase/jobdispatcher/Job$Builder;->e:Lcom/firebase/jobdispatcher/JobTrigger;

    .line 128
    const/4 v0, 0x1

    iput v0, p0, Lcom/firebase/jobdispatcher/Job$Builder;->f:I

    .line 131
    sget-object v0, Lcom/firebase/jobdispatcher/RetryStrategy;->a:Lcom/firebase/jobdispatcher/RetryStrategy;

    iput-object v0, p0, Lcom/firebase/jobdispatcher/Job$Builder;->h:Lcom/firebase/jobdispatcher/RetryStrategy;

    .line 132
    iput-boolean v1, p0, Lcom/firebase/jobdispatcher/Job$Builder;->i:Z

    .line 133
    iput-boolean v1, p0, Lcom/firebase/jobdispatcher/Job$Builder;->j:Z

    .line 140
    iput-object p1, p0, Lcom/firebase/jobdispatcher/Job$Builder;->a:Lcom/firebase/jobdispatcher/ValidationEnforcer;

    .line 142
    invoke-interface {p2}, Lcom/firebase/jobdispatcher/JobParameters;->e()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/firebase/jobdispatcher/Job$Builder;->d:Ljava/lang/String;

    .line 143
    invoke-interface {p2}, Lcom/firebase/jobdispatcher/JobParameters;->i()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/firebase/jobdispatcher/Job$Builder;->b:Ljava/lang/String;

    .line 144
    invoke-interface {p2}, Lcom/firebase/jobdispatcher/JobParameters;->f()Lcom/firebase/jobdispatcher/JobTrigger;

    move-result-object v0

    iput-object v0, p0, Lcom/firebase/jobdispatcher/Job$Builder;->e:Lcom/firebase/jobdispatcher/JobTrigger;

    .line 145
    invoke-interface {p2}, Lcom/firebase/jobdispatcher/JobParameters;->h()Z

    move-result v0

    iput-boolean v0, p0, Lcom/firebase/jobdispatcher/Job$Builder;->j:Z

    .line 146
    invoke-interface {p2}, Lcom/firebase/jobdispatcher/JobParameters;->g()I

    move-result v0

    iput v0, p0, Lcom/firebase/jobdispatcher/Job$Builder;->f:I

    .line 147
    invoke-interface {p2}, Lcom/firebase/jobdispatcher/JobParameters;->a()[I

    move-result-object v0

    iput-object v0, p0, Lcom/firebase/jobdispatcher/Job$Builder;->g:[I

    .line 148
    invoke-interface {p2}, Lcom/firebase/jobdispatcher/JobParameters;->b()Landroid/os/Bundle;

    move-result-object v0

    iput-object v0, p0, Lcom/firebase/jobdispatcher/Job$Builder;->c:Landroid/os/Bundle;

    .line 149
    invoke-interface {p2}, Lcom/firebase/jobdispatcher/JobParameters;->c()Lcom/firebase/jobdispatcher/RetryStrategy;

    move-result-object v0

    iput-object v0, p0, Lcom/firebase/jobdispatcher/Job$Builder;->h:Lcom/firebase/jobdispatcher/RetryStrategy;

    .line 150
    return-void
.end method

.method static synthetic a(Lcom/firebase/jobdispatcher/Job$Builder;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 121
    iget-object v0, p0, Lcom/firebase/jobdispatcher/Job$Builder;->b:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic b(Lcom/firebase/jobdispatcher/Job$Builder;)Landroid/os/Bundle;
    .locals 1

    .prologue
    .line 121
    iget-object v0, p0, Lcom/firebase/jobdispatcher/Job$Builder;->c:Landroid/os/Bundle;

    return-object v0
.end method

.method static synthetic c(Lcom/firebase/jobdispatcher/Job$Builder;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 121
    iget-object v0, p0, Lcom/firebase/jobdispatcher/Job$Builder;->d:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic d(Lcom/firebase/jobdispatcher/Job$Builder;)Lcom/firebase/jobdispatcher/JobTrigger;
    .locals 1

    .prologue
    .line 121
    iget-object v0, p0, Lcom/firebase/jobdispatcher/Job$Builder;->e:Lcom/firebase/jobdispatcher/JobTrigger;

    return-object v0
.end method

.method static synthetic e(Lcom/firebase/jobdispatcher/Job$Builder;)Lcom/firebase/jobdispatcher/RetryStrategy;
    .locals 1

    .prologue
    .line 121
    iget-object v0, p0, Lcom/firebase/jobdispatcher/Job$Builder;->h:Lcom/firebase/jobdispatcher/RetryStrategy;

    return-object v0
.end method

.method static synthetic f(Lcom/firebase/jobdispatcher/Job$Builder;)I
    .locals 1

    .prologue
    .line 121
    iget v0, p0, Lcom/firebase/jobdispatcher/Job$Builder;->f:I

    return v0
.end method

.method static synthetic g(Lcom/firebase/jobdispatcher/Job$Builder;)Z
    .locals 1

    .prologue
    .line 121
    iget-boolean v0, p0, Lcom/firebase/jobdispatcher/Job$Builder;->j:Z

    return v0
.end method

.method static synthetic h(Lcom/firebase/jobdispatcher/Job$Builder;)[I
    .locals 1

    .prologue
    .line 121
    iget-object v0, p0, Lcom/firebase/jobdispatcher/Job$Builder;->g:[I

    return-object v0
.end method

.method static synthetic i(Lcom/firebase/jobdispatcher/Job$Builder;)Z
    .locals 1

    .prologue
    .line 121
    iget-boolean v0, p0, Lcom/firebase/jobdispatcher/Job$Builder;->i:Z

    return v0
.end method


# virtual methods
.method public a(I)Lcom/firebase/jobdispatcher/Job$Builder;
    .locals 0

    .prologue
    .line 250
    iput p1, p0, Lcom/firebase/jobdispatcher/Job$Builder;->f:I

    .line 252
    return-object p0
.end method

.method public a(Lcom/firebase/jobdispatcher/JobTrigger;)Lcom/firebase/jobdispatcher/Job$Builder;
    .locals 0

    .prologue
    .line 236
    iput-object p1, p0, Lcom/firebase/jobdispatcher/Job$Builder;->e:Lcom/firebase/jobdispatcher/JobTrigger;

    .line 238
    return-object p0
.end method

.method public a(Ljava/lang/Class;)Lcom/firebase/jobdispatcher/Job$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<+",
            "Lcom/firebase/jobdispatcher/JobService;",
            ">;)",
            "Lcom/firebase/jobdispatcher/Job$Builder;"
        }
    .end annotation

    .prologue
    .line 197
    if-nez p1, :cond_0

    const/4 v0, 0x0

    :goto_0
    iput-object v0, p0, Lcom/firebase/jobdispatcher/Job$Builder;->b:Ljava/lang/String;

    .line 199
    return-object p0

    .line 197
    :cond_0
    invoke-virtual {p1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public a(Ljava/lang/String;)Lcom/firebase/jobdispatcher/Job$Builder;
    .locals 0

    .prologue
    .line 222
    iput-object p1, p0, Lcom/firebase/jobdispatcher/Job$Builder;->d:Ljava/lang/String;

    .line 224
    return-object p0
.end method

.method public a(Z)Lcom/firebase/jobdispatcher/Job$Builder;
    .locals 0

    .prologue
    .line 172
    iput-boolean p1, p0, Lcom/firebase/jobdispatcher/Job$Builder;->i:Z

    .line 174
    return-object p0
.end method

.method public varargs a([I)Lcom/firebase/jobdispatcher/Job$Builder;
    .locals 0

    .prologue
    .line 277
    iput-object p1, p0, Lcom/firebase/jobdispatcher/Job$Builder;->g:[I

    .line 279
    return-object p0
.end method

.method public a()[I
    .locals 1

    .prologue
    .line 272
    iget-object v0, p0, Lcom/firebase/jobdispatcher/Job$Builder;->g:[I

    if-nez v0, :cond_0

    const/4 v0, 0x0

    new-array v0, v0, [I

    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/firebase/jobdispatcher/Job$Builder;->g:[I

    goto :goto_0
.end method

.method public b()Landroid/os/Bundle;
    .locals 1

    .prologue
    .line 286
    iget-object v0, p0, Lcom/firebase/jobdispatcher/Job$Builder;->c:Landroid/os/Bundle;

    return-object v0
.end method

.method public b(Z)Lcom/firebase/jobdispatcher/Job$Builder;
    .locals 0

    .prologue
    .line 263
    iput-boolean p1, p0, Lcom/firebase/jobdispatcher/Job$Builder;->j:Z

    .line 265
    return-object p0
.end method

.method public c()Lcom/firebase/jobdispatcher/RetryStrategy;
    .locals 1

    .prologue
    .line 300
    iget-object v0, p0, Lcom/firebase/jobdispatcher/Job$Builder;->h:Lcom/firebase/jobdispatcher/RetryStrategy;

    return-object v0
.end method

.method public d()Z
    .locals 1

    .prologue
    .line 313
    iget-boolean v0, p0, Lcom/firebase/jobdispatcher/Job$Builder;->i:Z

    return v0
.end method

.method public e()Ljava/lang/String;
    .locals 1

    .prologue
    .line 217
    iget-object v0, p0, Lcom/firebase/jobdispatcher/Job$Builder;->d:Ljava/lang/String;

    return-object v0
.end method

.method public f()Lcom/firebase/jobdispatcher/JobTrigger;
    .locals 1

    .prologue
    .line 231
    iget-object v0, p0, Lcom/firebase/jobdispatcher/Job$Builder;->e:Lcom/firebase/jobdispatcher/JobTrigger;

    return-object v0
.end method

.method public g()I
    .locals 1

    .prologue
    .line 245
    iget v0, p0, Lcom/firebase/jobdispatcher/Job$Builder;->f:I

    return v0
.end method

.method public h()Z
    .locals 1

    .prologue
    .line 258
    iget-boolean v0, p0, Lcom/firebase/jobdispatcher/Job$Builder;->j:Z

    return v0
.end method

.method public i()Ljava/lang/String;
    .locals 1

    .prologue
    .line 192
    iget-object v0, p0, Lcom/firebase/jobdispatcher/Job$Builder;->b:Ljava/lang/String;

    return-object v0
.end method

.method public j()Lcom/firebase/jobdispatcher/Job;
    .locals 2

    .prologue
    .line 183
    iget-object v0, p0, Lcom/firebase/jobdispatcher/Job$Builder;->a:Lcom/firebase/jobdispatcher/ValidationEnforcer;

    invoke-virtual {v0, p0}, Lcom/firebase/jobdispatcher/ValidationEnforcer;->b(Lcom/firebase/jobdispatcher/JobParameters;)V

    .line 185
    new-instance v0, Lcom/firebase/jobdispatcher/Job;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lcom/firebase/jobdispatcher/Job;-><init>(Lcom/firebase/jobdispatcher/Job$Builder;Lcom/firebase/jobdispatcher/Job$1;)V

    return-object v0
.end method
