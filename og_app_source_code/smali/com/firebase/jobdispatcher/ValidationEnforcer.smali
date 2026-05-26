.class public Lcom/firebase/jobdispatcher/ValidationEnforcer;
.super Ljava/lang/Object;
.source "ValidationEnforcer.java"

# interfaces
.implements Lcom/firebase/jobdispatcher/JobValidator;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/firebase/jobdispatcher/ValidationEnforcer$ValidationException;
    }
.end annotation


# instance fields
.field private final a:Lcom/firebase/jobdispatcher/JobValidator;


# direct methods
.method public constructor <init>(Lcom/firebase/jobdispatcher/JobValidator;)V
    .locals 0

    .prologue
    .line 28
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 29
    iput-object p1, p0, Lcom/firebase/jobdispatcher/ValidationEnforcer;->a:Lcom/firebase/jobdispatcher/JobValidator;

    .line 30
    return-void
.end method

.method private static a(Ljava/util/List;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 100
    if-eqz p0, :cond_0

    .line 101
    new-instance v0, Lcom/firebase/jobdispatcher/ValidationEnforcer$ValidationException;

    const-string v1, "JobParameters is invalid"

    invoke-direct {v0, v1, p0}, Lcom/firebase/jobdispatcher/ValidationEnforcer$ValidationException;-><init>(Ljava/lang/String;Ljava/util/List;)V

    throw v0

    .line 103
    :cond_0
    return-void
.end method


# virtual methods
.method public a(Lcom/firebase/jobdispatcher/JobParameters;)Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/firebase/jobdispatcher/JobParameters;",
            ")",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 36
    iget-object v0, p0, Lcom/firebase/jobdispatcher/ValidationEnforcer;->a:Lcom/firebase/jobdispatcher/JobValidator;

    invoke-interface {v0, p1}, Lcom/firebase/jobdispatcher/JobValidator;->a(Lcom/firebase/jobdispatcher/JobParameters;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public final b(Lcom/firebase/jobdispatcher/JobParameters;)V
    .locals 1

    .prologue
    .line 78
    invoke-virtual {p0, p1}, Lcom/firebase/jobdispatcher/ValidationEnforcer;->a(Lcom/firebase/jobdispatcher/JobParameters;)Ljava/util/List;

    move-result-object v0

    invoke-static {v0}, Lcom/firebase/jobdispatcher/ValidationEnforcer;->a(Ljava/util/List;)V

    .line 79
    return-void
.end method
