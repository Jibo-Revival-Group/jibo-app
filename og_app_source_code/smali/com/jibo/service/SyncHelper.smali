.class public Lcom/jibo/service/SyncHelper;
.super Ljava/lang/Object;
.source "SyncHelper.java"


# static fields
.field public static final a:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 30
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-class v1, Lcom/jibo/service/SyncHelper;

    invoke-virtual {v1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ".ARG_SYNC_FLAGS"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/jibo/service/SyncHelper;->a:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 25
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static a(Landroid/content/Context;)V
    .locals 4

    .prologue
    const/4 v3, 0x1

    .line 129
    invoke-static {p0}, Lcom/jibo/service/KeyRequestingSharingService;->a(Landroid/content/Context;)V

    .line 131
    sget-object v0, Lcom/jibo/JiboApplication;->a:Lcom/firebase/jobdispatcher/FirebaseJobDispatcher;

    invoke-virtual {v0}, Lcom/firebase/jobdispatcher/FirebaseJobDispatcher;->a()Lcom/firebase/jobdispatcher/Job$Builder;

    move-result-object v0

    const-class v1, Lcom/jibo/service/KeysCheckerJobService;

    .line 132
    invoke-virtual {v0, v1}, Lcom/firebase/jobdispatcher/Job$Builder;->a(Ljava/lang/Class;)Lcom/firebase/jobdispatcher/Job$Builder;

    move-result-object v0

    const-string v1, "scheduleKeysChecker"

    .line 133
    invoke-virtual {v0, v1}, Lcom/firebase/jobdispatcher/Job$Builder;->a(Ljava/lang/String;)Lcom/firebase/jobdispatcher/Job$Builder;

    move-result-object v0

    new-array v1, v3, [I

    const/4 v2, 0x0

    aput v3, v1, v2

    .line 134
    invoke-virtual {v0, v1}, Lcom/firebase/jobdispatcher/Job$Builder;->a([I)Lcom/firebase/jobdispatcher/Job$Builder;

    move-result-object v0

    const/16 v1, 0x78

    const/16 v2, 0xb4

    .line 135
    invoke-static {v1, v2}, Lcom/firebase/jobdispatcher/Trigger;->a(II)Lcom/firebase/jobdispatcher/JobTrigger$ExecutionWindowTrigger;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/firebase/jobdispatcher/Job$Builder;->a(Lcom/firebase/jobdispatcher/JobTrigger;)Lcom/firebase/jobdispatcher/Job$Builder;

    move-result-object v0

    .line 136
    invoke-virtual {v0, v3}, Lcom/firebase/jobdispatcher/Job$Builder;->a(I)Lcom/firebase/jobdispatcher/Job$Builder;

    move-result-object v0

    .line 137
    invoke-virtual {v0, v3}, Lcom/firebase/jobdispatcher/Job$Builder;->b(Z)Lcom/firebase/jobdispatcher/Job$Builder;

    move-result-object v0

    .line 138
    invoke-virtual {v0}, Lcom/firebase/jobdispatcher/Job$Builder;->j()Lcom/firebase/jobdispatcher/Job;

    move-result-object v0

    .line 140
    sget-object v1, Lcom/jibo/JiboApplication;->a:Lcom/firebase/jobdispatcher/FirebaseJobDispatcher;

    const-string v2, "scheduleKeysChecker"

    invoke-virtual {v1, v2}, Lcom/firebase/jobdispatcher/FirebaseJobDispatcher;->a(Ljava/lang/String;)I

    .line 141
    sget-object v1, Lcom/jibo/JiboApplication;->a:Lcom/firebase/jobdispatcher/FirebaseJobDispatcher;

    invoke-virtual {v1, v0}, Lcom/firebase/jobdispatcher/FirebaseJobDispatcher;->a(Lcom/firebase/jobdispatcher/Job;)I

    move-result v0

    .line 142
    if-eqz v0, :cond_0

    .line 145
    :cond_0
    return-void
.end method

.method public static a(Landroid/content/Context;Ljava/lang/String;)V
    .locals 3

    .prologue
    .line 170
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/jibo/service/SyncTaskService;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 171
    const-class v1, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1, p1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 172
    sget-object v1, Lcom/jibo/service/SyncHelper;->a:Ljava/lang/String;

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 173
    invoke-static {p0, v0}, Lcom/jibo/utils/ServiceUtils;->a(Landroid/content/Context;Landroid/content/Intent;)V

    .line 174
    return-void
.end method

.method public static a(Landroid/content/Context;Ljava/lang/String;Z)V
    .locals 3

    .prologue
    .line 197
    new-instance v1, Landroid/content/Intent;

    const-class v0, Lcom/jibo/service/SyncTaskService;

    invoke-direct {v1, p0, v0}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 198
    const-class v0, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0, p1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 199
    sget-object v2, Lcom/jibo/service/SyncHelper;->a:Ljava/lang/String;

    if-eqz p2, :cond_0

    const/16 v0, 0x10

    :goto_0
    or-int/lit8 v0, v0, 0x8

    invoke-virtual {v1, v2, v0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 200
    invoke-static {p0, v1}, Lcom/jibo/utils/ServiceUtils;->a(Landroid/content/Context;Landroid/content/Intent;)V

    .line 201
    return-void

    .line 199
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static b(Landroid/content/Context;)V
    .locals 3

    .prologue
    .line 158
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/jibo/service/SyncTaskService;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 159
    sget-object v1, Lcom/jibo/service/SyncHelper;->a:Ljava/lang/String;

    const/4 v2, 0x2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 160
    invoke-static {p0, v0}, Lcom/jibo/utils/ServiceUtils;->a(Landroid/content/Context;Landroid/content/Intent;)V

    .line 161
    return-void
.end method

.method public static b(Landroid/content/Context;Ljava/lang/String;)V
    .locals 3

    .prologue
    .line 177
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/jibo/service/SyncTaskService;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 178
    const-class v1, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1, p1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 179
    sget-object v1, Lcom/jibo/service/SyncHelper;->a:Ljava/lang/String;

    const/16 v2, 0xd

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 180
    invoke-static {p0, v0}, Lcom/jibo/utils/ServiceUtils;->a(Landroid/content/Context;Landroid/content/Intent;)V

    .line 181
    return-void
.end method

.method public static c(Landroid/content/Context;)V
    .locals 3

    .prologue
    .line 164
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/jibo/service/SyncTaskService;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 165
    sget-object v1, Lcom/jibo/service/SyncHelper;->a:Ljava/lang/String;

    const/16 v2, 0x1c

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 166
    invoke-static {p0, v0}, Lcom/jibo/utils/ServiceUtils;->a(Landroid/content/Context;Landroid/content/Intent;)V

    .line 167
    return-void
.end method

.method public static c(Landroid/content/Context;Ljava/lang/String;)V
    .locals 3

    .prologue
    .line 190
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/jibo/service/SyncTaskService;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 191
    const-class v1, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1, p1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 192
    sget-object v1, Lcom/jibo/service/SyncHelper;->a:Ljava/lang/String;

    const/4 v2, 0x4

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 193
    invoke-static {p0, v0}, Lcom/jibo/utils/ServiceUtils;->a(Landroid/content/Context;Landroid/content/Intent;)V

    .line 194
    return-void
.end method
