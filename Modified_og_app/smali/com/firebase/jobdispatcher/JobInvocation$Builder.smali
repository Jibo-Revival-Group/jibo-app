.class final Lcom/firebase/jobdispatcher/JobInvocation$Builder;
.super Ljava/lang/Object;
.source "JobInvocation.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/firebase/jobdispatcher/JobInvocation;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = "Builder"
.end annotation


# instance fields
.field private a:Ljava/lang/String;

.field private b:Ljava/lang/String;

.field private c:Lcom/firebase/jobdispatcher/JobTrigger;

.field private d:Z

.field private e:I

.field private f:[I

.field private final g:Landroid/os/Bundle;

.field private h:Lcom/firebase/jobdispatcher/RetryStrategy;

.field private i:Z

.field private j:Lcom/firebase/jobdispatcher/TriggerReason;


# direct methods
.method constructor <init>()V
    .locals 1

    .prologue
    .line 117
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 131
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    iput-object v0, p0, Lcom/firebase/jobdispatcher/JobInvocation$Builder;->g:Landroid/os/Bundle;

    return-void
.end method

.method static synthetic a(Lcom/firebase/jobdispatcher/JobInvocation$Builder;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 117
    iget-object v0, p0, Lcom/firebase/jobdispatcher/JobInvocation$Builder;->a:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic b(Lcom/firebase/jobdispatcher/JobInvocation$Builder;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 117
    iget-object v0, p0, Lcom/firebase/jobdispatcher/JobInvocation$Builder;->b:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic c(Lcom/firebase/jobdispatcher/JobInvocation$Builder;)Lcom/firebase/jobdispatcher/JobTrigger;
    .locals 1

    .prologue
    .line 117
    iget-object v0, p0, Lcom/firebase/jobdispatcher/JobInvocation$Builder;->c:Lcom/firebase/jobdispatcher/JobTrigger;

    return-object v0
.end method

.method static synthetic d(Lcom/firebase/jobdispatcher/JobInvocation$Builder;)Lcom/firebase/jobdispatcher/RetryStrategy;
    .locals 1

    .prologue
    .line 117
    iget-object v0, p0, Lcom/firebase/jobdispatcher/JobInvocation$Builder;->h:Lcom/firebase/jobdispatcher/RetryStrategy;

    return-object v0
.end method

.method static synthetic e(Lcom/firebase/jobdispatcher/JobInvocation$Builder;)Z
    .locals 1

    .prologue
    .line 117
    iget-boolean v0, p0, Lcom/firebase/jobdispatcher/JobInvocation$Builder;->d:Z

    return v0
.end method

.method static synthetic f(Lcom/firebase/jobdispatcher/JobInvocation$Builder;)I
    .locals 1

    .prologue
    .line 117
    iget v0, p0, Lcom/firebase/jobdispatcher/JobInvocation$Builder;->e:I

    return v0
.end method

.method static synthetic g(Lcom/firebase/jobdispatcher/JobInvocation$Builder;)[I
    .locals 1

    .prologue
    .line 117
    iget-object v0, p0, Lcom/firebase/jobdispatcher/JobInvocation$Builder;->f:[I

    return-object v0
.end method

.method static synthetic h(Lcom/firebase/jobdispatcher/JobInvocation$Builder;)Landroid/os/Bundle;
    .locals 1

    .prologue
    .line 117
    iget-object v0, p0, Lcom/firebase/jobdispatcher/JobInvocation$Builder;->g:Landroid/os/Bundle;

    return-object v0
.end method

.method static synthetic i(Lcom/firebase/jobdispatcher/JobInvocation$Builder;)Z
    .locals 1

    .prologue
    .line 117
    iget-boolean v0, p0, Lcom/firebase/jobdispatcher/JobInvocation$Builder;->i:Z

    return v0
.end method

.method static synthetic j(Lcom/firebase/jobdispatcher/JobInvocation$Builder;)Lcom/firebase/jobdispatcher/TriggerReason;
    .locals 1

    .prologue
    .line 117
    iget-object v0, p0, Lcom/firebase/jobdispatcher/JobInvocation$Builder;->j:Lcom/firebase/jobdispatcher/TriggerReason;

    return-object v0
.end method


# virtual methods
.method public a(I)Lcom/firebase/jobdispatcher/JobInvocation$Builder;
    .locals 0

    .prologue
    .line 167
    iput p1, p0, Lcom/firebase/jobdispatcher/JobInvocation$Builder;->e:I

    .line 168
    return-object p0
.end method

.method public a(Landroid/os/Bundle;)Lcom/firebase/jobdispatcher/JobInvocation$Builder;
    .locals 1

    .prologue
    .line 177
    if-eqz p1, :cond_0

    .line 178
    iget-object v0, p0, Lcom/firebase/jobdispatcher/JobInvocation$Builder;->g:Landroid/os/Bundle;

    invoke-virtual {v0, p1}, Landroid/os/Bundle;->putAll(Landroid/os/Bundle;)V

    .line 180
    :cond_0
    return-object p0
.end method

.method public a(Lcom/firebase/jobdispatcher/JobTrigger;)Lcom/firebase/jobdispatcher/JobInvocation$Builder;
    .locals 0

    .prologue
    .line 157
    iput-object p1, p0, Lcom/firebase/jobdispatcher/JobInvocation$Builder;->c:Lcom/firebase/jobdispatcher/JobTrigger;

    .line 158
    return-object p0
.end method

.method public a(Lcom/firebase/jobdispatcher/RetryStrategy;)Lcom/firebase/jobdispatcher/JobInvocation$Builder;
    .locals 0

    .prologue
    .line 184
    iput-object p1, p0, Lcom/firebase/jobdispatcher/JobInvocation$Builder;->h:Lcom/firebase/jobdispatcher/RetryStrategy;

    .line 185
    return-object p0
.end method

.method public a(Lcom/firebase/jobdispatcher/TriggerReason;)Lcom/firebase/jobdispatcher/JobInvocation$Builder;
    .locals 0

    .prologue
    .line 194
    iput-object p1, p0, Lcom/firebase/jobdispatcher/JobInvocation$Builder;->j:Lcom/firebase/jobdispatcher/TriggerReason;

    .line 195
    return-object p0
.end method

.method public a(Ljava/lang/String;)Lcom/firebase/jobdispatcher/JobInvocation$Builder;
    .locals 0

    .prologue
    .line 147
    iput-object p1, p0, Lcom/firebase/jobdispatcher/JobInvocation$Builder;->a:Ljava/lang/String;

    .line 148
    return-object p0
.end method

.method public a(Z)Lcom/firebase/jobdispatcher/JobInvocation$Builder;
    .locals 0

    .prologue
    .line 162
    iput-boolean p1, p0, Lcom/firebase/jobdispatcher/JobInvocation$Builder;->d:Z

    .line 163
    return-object p0
.end method

.method public a([I)Lcom/firebase/jobdispatcher/JobInvocation$Builder;
    .locals 0

    .prologue
    .line 172
    iput-object p1, p0, Lcom/firebase/jobdispatcher/JobInvocation$Builder;->f:[I

    .line 173
    return-object p0
.end method

.method a()Lcom/firebase/jobdispatcher/JobInvocation;
    .locals 2

    .prologue
    .line 140
    iget-object v0, p0, Lcom/firebase/jobdispatcher/JobInvocation$Builder;->a:Ljava/lang/String;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/firebase/jobdispatcher/JobInvocation$Builder;->b:Ljava/lang/String;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/firebase/jobdispatcher/JobInvocation$Builder;->c:Lcom/firebase/jobdispatcher/JobTrigger;

    if-nez v0, :cond_1

    .line 141
    :cond_0
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Required fields were not populated."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 143
    :cond_1
    new-instance v0, Lcom/firebase/jobdispatcher/JobInvocation;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lcom/firebase/jobdispatcher/JobInvocation;-><init>(Lcom/firebase/jobdispatcher/JobInvocation$Builder;Lcom/firebase/jobdispatcher/JobInvocation$1;)V

    return-object v0
.end method

.method public b(Ljava/lang/String;)Lcom/firebase/jobdispatcher/JobInvocation$Builder;
    .locals 0

    .prologue
    .line 152
    iput-object p1, p0, Lcom/firebase/jobdispatcher/JobInvocation$Builder;->b:Ljava/lang/String;

    .line 153
    return-object p0
.end method

.method public b(Z)Lcom/firebase/jobdispatcher/JobInvocation$Builder;
    .locals 0

    .prologue
    .line 189
    iput-boolean p1, p0, Lcom/firebase/jobdispatcher/JobInvocation$Builder;->i:Z

    .line 190
    return-object p0
.end method
