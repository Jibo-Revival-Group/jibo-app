.class public final Lcom/firebase/jobdispatcher/FirebaseJobDispatcher;
.super Ljava/lang/Object;
.source "FirebaseJobDispatcher.java"


# instance fields
.field private final a:Lcom/firebase/jobdispatcher/Driver;

.field private final b:Lcom/firebase/jobdispatcher/ValidationEnforcer;

.field private final c:Lcom/firebase/jobdispatcher/RetryStrategy$Builder;


# direct methods
.method public constructor <init>(Lcom/firebase/jobdispatcher/Driver;)V
    .locals 2

    .prologue
    .line 68
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 69
    iput-object p1, p0, Lcom/firebase/jobdispatcher/FirebaseJobDispatcher;->a:Lcom/firebase/jobdispatcher/Driver;

    .line 70
    new-instance v0, Lcom/firebase/jobdispatcher/ValidationEnforcer;

    invoke-interface {p1}, Lcom/firebase/jobdispatcher/Driver;->a()Lcom/firebase/jobdispatcher/JobValidator;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/firebase/jobdispatcher/ValidationEnforcer;-><init>(Lcom/firebase/jobdispatcher/JobValidator;)V

    iput-object v0, p0, Lcom/firebase/jobdispatcher/FirebaseJobDispatcher;->b:Lcom/firebase/jobdispatcher/ValidationEnforcer;

    .line 71
    new-instance v0, Lcom/firebase/jobdispatcher/RetryStrategy$Builder;

    iget-object v1, p0, Lcom/firebase/jobdispatcher/FirebaseJobDispatcher;->b:Lcom/firebase/jobdispatcher/ValidationEnforcer;

    invoke-direct {v0, v1}, Lcom/firebase/jobdispatcher/RetryStrategy$Builder;-><init>(Lcom/firebase/jobdispatcher/ValidationEnforcer;)V

    iput-object v0, p0, Lcom/firebase/jobdispatcher/FirebaseJobDispatcher;->c:Lcom/firebase/jobdispatcher/RetryStrategy$Builder;

    .line 72
    return-void
.end method


# virtual methods
.method public a(Lcom/firebase/jobdispatcher/Job;)I
    .locals 1

    .prologue
    .line 81
    iget-object v0, p0, Lcom/firebase/jobdispatcher/FirebaseJobDispatcher;->a:Lcom/firebase/jobdispatcher/Driver;

    invoke-interface {v0}, Lcom/firebase/jobdispatcher/Driver;->b()Z

    move-result v0

    if-nez v0, :cond_0

    .line 82
    const/4 v0, 0x2

    .line 85
    :goto_0
    return v0

    :cond_0
    iget-object v0, p0, Lcom/firebase/jobdispatcher/FirebaseJobDispatcher;->a:Lcom/firebase/jobdispatcher/Driver;

    invoke-interface {v0, p1}, Lcom/firebase/jobdispatcher/Driver;->a(Lcom/firebase/jobdispatcher/Job;)I

    move-result v0

    goto :goto_0
.end method

.method public a(Ljava/lang/String;)I
    .locals 1

    .prologue
    .line 95
    iget-object v0, p0, Lcom/firebase/jobdispatcher/FirebaseJobDispatcher;->a:Lcom/firebase/jobdispatcher/Driver;

    invoke-interface {v0}, Lcom/firebase/jobdispatcher/Driver;->b()Z

    move-result v0

    if-nez v0, :cond_0

    .line 96
    const/4 v0, 0x2

    .line 99
    :goto_0
    return v0

    :cond_0
    iget-object v0, p0, Lcom/firebase/jobdispatcher/FirebaseJobDispatcher;->a:Lcom/firebase/jobdispatcher/Driver;

    invoke-interface {v0, p1}, Lcom/firebase/jobdispatcher/Driver;->a(Ljava/lang/String;)I

    move-result v0

    goto :goto_0
.end method

.method public a()Lcom/firebase/jobdispatcher/Job$Builder;
    .locals 2

    .prologue
    .line 135
    new-instance v0, Lcom/firebase/jobdispatcher/Job$Builder;

    iget-object v1, p0, Lcom/firebase/jobdispatcher/FirebaseJobDispatcher;->b:Lcom/firebase/jobdispatcher/ValidationEnforcer;

    invoke-direct {v0, v1}, Lcom/firebase/jobdispatcher/Job$Builder;-><init>(Lcom/firebase/jobdispatcher/ValidationEnforcer;)V

    return-object v0
.end method
