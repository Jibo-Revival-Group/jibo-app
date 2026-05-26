.class final Lcom/firebase/jobdispatcher/GooglePlayJobWriter;
.super Ljava/lang/Object;
.source "GooglePlayJobWriter.java"


# instance fields
.field private final a:Lcom/firebase/jobdispatcher/JobCoder;


# direct methods
.method constructor <init>()V
    .locals 2

    .prologue
    .line 28
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 58
    new-instance v0, Lcom/firebase/jobdispatcher/JobCoder;

    const-string v1, "com.firebase.jobdispatcher."

    invoke-direct {v0, v1}, Lcom/firebase/jobdispatcher/JobCoder;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/firebase/jobdispatcher/GooglePlayJobWriter;->a:Lcom/firebase/jobdispatcher/JobCoder;

    return-void
.end method

.method private static a(I)I
    .locals 1

    .prologue
    .line 132
    packed-switch p0, :pswitch_data_0

    .line 139
    const/4 v0, 0x0

    :goto_0
    return v0

    .line 134
    :pswitch_0
    const/4 v0, 0x1

    goto :goto_0

    .line 132
    nop

    :pswitch_data_0
    .packed-switch 0x2
        :pswitch_0
    .end packed-switch
.end method

.method private static a(Landroid/os/Bundle;)V
    .locals 4

    .prologue
    .line 76
    const-string v0, "trigger_type"

    const/4 v1, 0x2

    invoke-virtual {p0, v0, v1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 77
    const-string v0, "window_start"

    const-wide/16 v2, 0x0

    invoke-virtual {p0, v0, v2, v3}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 78
    const-string v0, "window_end"

    const-wide/16 v2, 0x1

    invoke-virtual {p0, v0, v2, v3}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 79
    return-void
.end method

.method private static a(Landroid/os/Bundle;Lcom/firebase/jobdispatcher/JobTrigger$ContentUriTrigger;)V
    .locals 6

    .prologue
    .line 82
    const-string v0, "trigger_type"

    const/4 v1, 0x3

    invoke-virtual {p0, v0, v1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 84
    invoke-virtual {p1}, Lcom/firebase/jobdispatcher/JobTrigger$ContentUriTrigger;->a()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v2

    .line 85
    new-array v3, v2, [I

    .line 86
    new-array v4, v2, [Landroid/net/Uri;

    .line 87
    const/4 v0, 0x0

    move v1, v0

    :goto_0
    if-ge v1, v2, :cond_0

    .line 88
    invoke-virtual {p1}, Lcom/firebase/jobdispatcher/JobTrigger$ContentUriTrigger;->a()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/firebase/jobdispatcher/ObservedUri;

    .line 89
    invoke-virtual {v0}, Lcom/firebase/jobdispatcher/ObservedUri;->b()I

    move-result v5

    aput v5, v3, v1

    .line 90
    invoke-virtual {v0}, Lcom/firebase/jobdispatcher/ObservedUri;->a()Landroid/net/Uri;

    move-result-object v0

    aput-object v0, v4, v1

    .line 87
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_0

    .line 92
    :cond_0
    const-string v0, "content_uri_flags_array"

    invoke-virtual {p0, v0, v3}, Landroid/os/Bundle;->putIntArray(Ljava/lang/String;[I)V

    .line 93
    const-string v0, "content_uri_array"

    invoke-virtual {p0, v0, v4}, Landroid/os/Bundle;->putParcelableArray(Ljava/lang/String;[Landroid/os/Parcelable;)V

    .line 94
    return-void
.end method

.method private static a(Lcom/firebase/jobdispatcher/JobParameters;Landroid/os/Bundle;Lcom/firebase/jobdispatcher/JobTrigger$ExecutionWindowTrigger;)V
    .locals 4

    .prologue
    .line 63
    const-string v0, "trigger_type"

    const/4 v1, 0x1

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 65
    invoke-interface {p0}, Lcom/firebase/jobdispatcher/JobParameters;->h()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 66
    const-string v0, "period"

    invoke-virtual {p2}, Lcom/firebase/jobdispatcher/JobTrigger$ExecutionWindowTrigger;->b()I

    move-result v1

    int-to-long v2, v1

    invoke-virtual {p1, v0, v2, v3}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 67
    const-string v0, "period_flex"

    .line 68
    invoke-virtual {p2}, Lcom/firebase/jobdispatcher/JobTrigger$ExecutionWindowTrigger;->b()I

    move-result v1

    invoke-virtual {p2}, Lcom/firebase/jobdispatcher/JobTrigger$ExecutionWindowTrigger;->a()I

    move-result v2

    sub-int/2addr v1, v2

    int-to-long v2, v1

    .line 67
    invoke-virtual {p1, v0, v2, v3}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 73
    :goto_0
    return-void

    .line 70
    :cond_0
    const-string v0, "window_start"

    invoke-virtual {p2}, Lcom/firebase/jobdispatcher/JobTrigger$ExecutionWindowTrigger;->a()I

    move-result v1

    int-to-long v2, v1

    invoke-virtual {p1, v0, v2, v3}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 71
    const-string v0, "window_end"

    invoke-virtual {p2}, Lcom/firebase/jobdispatcher/JobTrigger$ExecutionWindowTrigger;->b()I

    move-result v1

    int-to-long v2, v1

    invoke-virtual {p1, v0, v2, v3}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    goto :goto_0
.end method

.method private static b(I)I
    .locals 3

    .prologue
    const/4 v1, 0x2

    const/4 v0, 0x1

    .line 171
    .line 173
    and-int/lit8 v2, p0, 0x2

    if-ne v2, v1, :cond_0

    const/4 v1, 0x0

    .line 178
    :cond_0
    and-int/lit8 v2, p0, 0x1

    if-ne v2, v0, :cond_1

    .line 183
    :goto_0
    return v0

    :cond_1
    move v0, v1

    .line 178
    goto :goto_0
.end method

.method private static b(Lcom/firebase/jobdispatcher/JobParameters;Landroid/os/Bundle;)V
    .locals 4

    .prologue
    .line 119
    invoke-interface {p0}, Lcom/firebase/jobdispatcher/JobParameters;->c()Lcom/firebase/jobdispatcher/RetryStrategy;

    move-result-object v0

    .line 121
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 122
    const-string v2, "retry_policy"

    .line 124
    invoke-virtual {v0}, Lcom/firebase/jobdispatcher/RetryStrategy;->a()I

    move-result v3

    invoke-static {v3}, Lcom/firebase/jobdispatcher/GooglePlayJobWriter;->a(I)I

    move-result v3

    .line 122
    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 125
    const-string v2, "initial_backoff_seconds"

    invoke-virtual {v0}, Lcom/firebase/jobdispatcher/RetryStrategy;->b()I

    move-result v3

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 126
    const-string v2, "maximum_backoff_seconds"

    invoke-virtual {v0}, Lcom/firebase/jobdispatcher/RetryStrategy;->c()I

    move-result v0

    invoke-virtual {v1, v2, v0}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 128
    const-string v0, "retryStrategy"

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putBundle(Ljava/lang/String;Landroid/os/Bundle;)V

    .line 129
    return-void
.end method

.method private static c(Lcom/firebase/jobdispatcher/JobParameters;Landroid/os/Bundle;)V
    .locals 4

    .prologue
    .line 144
    invoke-interface {p0}, Lcom/firebase/jobdispatcher/JobParameters;->f()Lcom/firebase/jobdispatcher/JobTrigger;

    move-result-object v0

    .line 146
    sget-object v1, Lcom/firebase/jobdispatcher/Trigger;->a:Lcom/firebase/jobdispatcher/JobTrigger$ImmediateTrigger;

    if-ne v0, v1, :cond_0

    .line 147
    invoke-static {p1}, Lcom/firebase/jobdispatcher/GooglePlayJobWriter;->a(Landroid/os/Bundle;)V

    .line 155
    :goto_0
    return-void

    .line 148
    :cond_0
    instance-of v1, v0, Lcom/firebase/jobdispatcher/JobTrigger$ExecutionWindowTrigger;

    if-eqz v1, :cond_1

    .line 149
    check-cast v0, Lcom/firebase/jobdispatcher/JobTrigger$ExecutionWindowTrigger;

    invoke-static {p0, p1, v0}, Lcom/firebase/jobdispatcher/GooglePlayJobWriter;->a(Lcom/firebase/jobdispatcher/JobParameters;Landroid/os/Bundle;Lcom/firebase/jobdispatcher/JobTrigger$ExecutionWindowTrigger;)V

    goto :goto_0

    .line 150
    :cond_1
    instance-of v1, v0, Lcom/firebase/jobdispatcher/JobTrigger$ContentUriTrigger;

    if-eqz v1, :cond_2

    .line 151
    check-cast v0, Lcom/firebase/jobdispatcher/JobTrigger$ContentUriTrigger;

    invoke-static {p1, v0}, Lcom/firebase/jobdispatcher/GooglePlayJobWriter;->a(Landroid/os/Bundle;Lcom/firebase/jobdispatcher/JobTrigger$ContentUriTrigger;)V

    goto :goto_0

    .line 153
    :cond_2
    new-instance v1, Ljava/lang/IllegalArgumentException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Unknown trigger: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v1, v0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1
.end method

.method private static d(Lcom/firebase/jobdispatcher/JobParameters;Landroid/os/Bundle;)V
    .locals 6

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 158
    invoke-interface {p0}, Lcom/firebase/jobdispatcher/JobParameters;->a()[I

    move-result-object v0

    invoke-static {v0}, Lcom/firebase/jobdispatcher/Constraint;->a([I)I

    move-result v3

    .line 160
    const-string v4, "requiresCharging"

    and-int/lit8 v0, v3, 0x4

    const/4 v5, 0x4

    if-ne v0, v5, :cond_0

    move v0, v1

    :goto_0
    invoke-virtual {p1, v4, v0}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 163
    const-string v0, "requiresIdle"

    and-int/lit8 v4, v3, 0x8

    const/16 v5, 0x8

    if-ne v4, v5, :cond_1

    :goto_1
    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 165
    const-string v0, "requiredNetwork"

    invoke-static {v3}, Lcom/firebase/jobdispatcher/GooglePlayJobWriter;->b(I)I

    move-result v1

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 166
    return-void

    :cond_0
    move v0, v2

    .line 160
    goto :goto_0

    :cond_1
    move v1, v2

    .line 163
    goto :goto_1
.end method


# virtual methods
.method public a(Lcom/firebase/jobdispatcher/JobParameters;Landroid/os/Bundle;)Landroid/os/Bundle;
    .locals 3

    .prologue
    .line 97
    const-string v0, "tag"

    invoke-interface {p1}, Lcom/firebase/jobdispatcher/JobParameters;->e()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p2, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 98
    const-string v0, "update_current"

    invoke-interface {p1}, Lcom/firebase/jobdispatcher/JobParameters;->d()Z

    move-result v1

    invoke-virtual {p2, v0, v1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 100
    invoke-interface {p1}, Lcom/firebase/jobdispatcher/JobParameters;->g()I

    move-result v0

    const/4 v1, 0x2

    if-ne v0, v1, :cond_1

    const/4 v0, 0x1

    .line 101
    :goto_0
    const-string v1, "persisted"

    invoke-virtual {p2, v1, v0}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 102
    const-string v0, "service"

    const-class v1, Lcom/firebase/jobdispatcher/GooglePlayReceiver;

    invoke-virtual {v1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p2, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 104
    invoke-static {p1, p2}, Lcom/firebase/jobdispatcher/GooglePlayJobWriter;->c(Lcom/firebase/jobdispatcher/JobParameters;Landroid/os/Bundle;)V

    .line 105
    invoke-static {p1, p2}, Lcom/firebase/jobdispatcher/GooglePlayJobWriter;->d(Lcom/firebase/jobdispatcher/JobParameters;Landroid/os/Bundle;)V

    .line 106
    invoke-static {p1, p2}, Lcom/firebase/jobdispatcher/GooglePlayJobWriter;->b(Lcom/firebase/jobdispatcher/JobParameters;Landroid/os/Bundle;)V

    .line 109
    invoke-interface {p1}, Lcom/firebase/jobdispatcher/JobParameters;->b()Landroid/os/Bundle;

    move-result-object v0

    .line 110
    if-nez v0, :cond_0

    .line 111
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 113
    :cond_0
    const-string v1, "extras"

    iget-object v2, p0, Lcom/firebase/jobdispatcher/GooglePlayJobWriter;->a:Lcom/firebase/jobdispatcher/JobCoder;

    invoke-virtual {v2, p1, v0}, Lcom/firebase/jobdispatcher/JobCoder;->a(Lcom/firebase/jobdispatcher/JobParameters;Landroid/os/Bundle;)Landroid/os/Bundle;

    move-result-object v0

    invoke-virtual {p2, v1, v0}, Landroid/os/Bundle;->putBundle(Ljava/lang/String;Landroid/os/Bundle;)V

    .line 115
    return-object p2

    .line 100
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method
