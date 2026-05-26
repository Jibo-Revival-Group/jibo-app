.class public final Lcom/firebase/jobdispatcher/JobTrigger$ExecutionWindowTrigger;
.super Lcom/firebase/jobdispatcher/JobTrigger;
.source "JobTrigger.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/firebase/jobdispatcher/JobTrigger;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "ExecutionWindowTrigger"
.end annotation


# instance fields
.field private final a:I

.field private final b:I


# direct methods
.method constructor <init>(II)V
    .locals 0

    .prologue
    .line 42
    invoke-direct {p0}, Lcom/firebase/jobdispatcher/JobTrigger;-><init>()V

    .line 43
    iput p1, p0, Lcom/firebase/jobdispatcher/JobTrigger$ExecutionWindowTrigger;->a:I

    .line 44
    iput p2, p0, Lcom/firebase/jobdispatcher/JobTrigger$ExecutionWindowTrigger;->b:I

    .line 45
    return-void
.end method


# virtual methods
.method public a()I
    .locals 1

    .prologue
    .line 48
    iget v0, p0, Lcom/firebase/jobdispatcher/JobTrigger$ExecutionWindowTrigger;->a:I

    return v0
.end method

.method public b()I
    .locals 1

    .prologue
    .line 52
    iget v0, p0, Lcom/firebase/jobdispatcher/JobTrigger$ExecutionWindowTrigger;->b:I

    return v0
.end method
