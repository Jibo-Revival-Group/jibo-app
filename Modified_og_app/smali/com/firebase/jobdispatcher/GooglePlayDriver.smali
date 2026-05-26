.class public final Lcom/firebase/jobdispatcher/GooglePlayDriver;
.super Ljava/lang/Object;
.source "GooglePlayDriver.java"

# interfaces
.implements Lcom/firebase/jobdispatcher/Driver;


# instance fields
.field private final a:Lcom/firebase/jobdispatcher/JobValidator;

.field private final b:Landroid/content/Context;

.field private final c:Landroid/app/PendingIntent;

.field private final d:Lcom/firebase/jobdispatcher/GooglePlayJobWriter;

.field private final e:Z


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 70
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 67
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/firebase/jobdispatcher/GooglePlayDriver;->e:Z

    .line 71
    iput-object p1, p0, Lcom/firebase/jobdispatcher/GooglePlayDriver;->b:Landroid/content/Context;

    .line 72
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    invoke-static {p1, v1, v0, v1}, Landroid/app/PendingIntent;->getBroadcast(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v0

    iput-object v0, p0, Lcom/firebase/jobdispatcher/GooglePlayDriver;->c:Landroid/app/PendingIntent;

    .line 73
    new-instance v0, Lcom/firebase/jobdispatcher/GooglePlayJobWriter;

    invoke-direct {v0}, Lcom/firebase/jobdispatcher/GooglePlayJobWriter;-><init>()V

    iput-object v0, p0, Lcom/firebase/jobdispatcher/GooglePlayDriver;->d:Lcom/firebase/jobdispatcher/GooglePlayJobWriter;

    .line 74
    new-instance v0, Lcom/firebase/jobdispatcher/DefaultJobValidator;

    invoke-direct {v0, p1}, Lcom/firebase/jobdispatcher/DefaultJobValidator;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/firebase/jobdispatcher/GooglePlayDriver;->a:Lcom/firebase/jobdispatcher/JobValidator;

    .line 75
    return-void
.end method

.method private a(Lcom/firebase/jobdispatcher/JobParameters;)Landroid/content/Intent;
    .locals 3

    .prologue
    .line 136
    const-string v0, "SCHEDULE_TASK"

    invoke-direct {p0, v0}, Lcom/firebase/jobdispatcher/GooglePlayDriver;->c(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v0

    .line 137
    iget-object v1, p0, Lcom/firebase/jobdispatcher/GooglePlayDriver;->d:Lcom/firebase/jobdispatcher/GooglePlayJobWriter;

    invoke-virtual {v0}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v2

    invoke-virtual {v1, p1, v2}, Lcom/firebase/jobdispatcher/GooglePlayJobWriter;->a(Lcom/firebase/jobdispatcher/JobParameters;Landroid/os/Bundle;)Landroid/os/Bundle;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    .line 138
    return-object v0
.end method

.method private c(Ljava/lang/String;)Landroid/content/Intent;
    .locals 3

    .prologue
    .line 143
    new-instance v0, Landroid/content/Intent;

    const-string v1, "com.google.android.gms.gcm.ACTION_SCHEDULE"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 145
    const-string v1, "com.google.android.gms"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setPackage(Ljava/lang/String;)Landroid/content/Intent;

    .line 146
    const-string v1, "scheduler_action"

    invoke-virtual {v0, v1, p1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 147
    const-string v1, "app"

    iget-object v2, p0, Lcom/firebase/jobdispatcher/GooglePlayDriver;->c:Landroid/app/PendingIntent;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    .line 148
    const-string v1, "source"

    const/16 v2, 0x8

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 149
    const-string v1, "source_version"

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 151
    return-object v0
.end method


# virtual methods
.method public a(Lcom/firebase/jobdispatcher/Job;)I
    .locals 2

    .prologue
    .line 87
    invoke-static {p1}, Lcom/firebase/jobdispatcher/GooglePlayReceiver;->a(Lcom/firebase/jobdispatcher/Job;)V

    .line 89
    iget-object v0, p0, Lcom/firebase/jobdispatcher/GooglePlayDriver;->b:Landroid/content/Context;

    invoke-direct {p0, p1}, Lcom/firebase/jobdispatcher/GooglePlayDriver;->a(Lcom/firebase/jobdispatcher/JobParameters;)Landroid/content/Intent;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V

    .line 91
    const/4 v0, 0x0

    return v0
.end method

.method public a(Ljava/lang/String;)I
    .locals 2

    .prologue
    .line 96
    iget-object v0, p0, Lcom/firebase/jobdispatcher/GooglePlayDriver;->b:Landroid/content/Context;

    invoke-virtual {p0, p1}, Lcom/firebase/jobdispatcher/GooglePlayDriver;->b(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V

    .line 98
    const/4 v0, 0x0

    return v0
.end method

.method public a()Lcom/firebase/jobdispatcher/JobValidator;
    .locals 1

    .prologue
    .line 131
    iget-object v0, p0, Lcom/firebase/jobdispatcher/GooglePlayDriver;->a:Lcom/firebase/jobdispatcher/JobValidator;

    return-object v0
.end method

.method protected b(Ljava/lang/String;)Landroid/content/Intent;
    .locals 5

    .prologue
    .line 110
    const-string v0, "CANCEL_TASK"

    invoke-direct {p0, v0}, Lcom/firebase/jobdispatcher/GooglePlayDriver;->c(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v0

    .line 111
    const-string v1, "tag"

    invoke-virtual {v0, v1, p1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 112
    const-string v1, "component"

    new-instance v2, Landroid/content/ComponentName;

    iget-object v3, p0, Lcom/firebase/jobdispatcher/GooglePlayDriver;->b:Landroid/content/Context;

    invoke-virtual {p0}, Lcom/firebase/jobdispatcher/GooglePlayDriver;->c()Ljava/lang/Class;

    move-result-object v4

    invoke-direct {v2, v3, v4}, Landroid/content/ComponentName;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    .line 113
    return-object v0
.end method

.method public b()Z
    .locals 1

    .prologue
    .line 79
    const/4 v0, 0x1

    return v0
.end method

.method protected c()Ljava/lang/Class;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/lang/Class",
            "<",
            "Lcom/firebase/jobdispatcher/GooglePlayReceiver;",
            ">;"
        }
    .end annotation

    .prologue
    .line 125
    const-class v0, Lcom/firebase/jobdispatcher/GooglePlayReceiver;

    return-object v0
.end method
