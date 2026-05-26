.class final Lcom/firebase/jobdispatcher/GooglePlayCallbackExtractor;
.super Ljava/lang/Object;
.source "GooglePlayCallbackExtractor.java"


# static fields
.field private static a:Ljava/lang/Boolean;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 52
    const/4 v0, 0x0

    sput-object v0, Lcom/firebase/jobdispatcher/GooglePlayCallbackExtractor;->a:Ljava/lang/Boolean;

    return-void
.end method

.method constructor <init>()V
    .locals 0

    .prologue
    .line 36
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static a(Landroid/os/Parcel;)Ljava/lang/String;
    .locals 3

    .prologue
    const/4 v1, 0x0

    .line 186
    invoke-static {}, Lcom/firebase/jobdispatcher/GooglePlayCallbackExtractor;->a()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 187
    invoke-virtual {p0}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    .line 198
    :goto_0
    return-object v0

    .line 191
    :cond_0
    invoke-virtual {p0, v1}, Landroid/os/Parcel;->readValue(Ljava/lang/ClassLoader;)Ljava/lang/Object;

    move-result-object v0

    .line 192
    instance-of v2, v0, Ljava/lang/String;

    if-nez v2, :cond_1

    .line 194
    const-string v0, "FJD.GooglePlayReceiver"

    const-string v2, "Bad callback received, terminating"

    invoke-static {v0, v2}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    move-object v0, v1

    .line 195
    goto :goto_0

    .line 198
    :cond_1
    check-cast v0, Ljava/lang/String;

    goto :goto_0
.end method

.method private static a(Z)V
    .locals 1

    .prologue
    .line 242
    if-nez p0, :cond_0

    .line 243
    new-instance v0, Ljava/lang/IllegalStateException;

    invoke-direct {v0}, Ljava/lang/IllegalStateException;-><init>()V

    throw v0

    .line 245
    :cond_0
    return-void
.end method

.method private static declared-synchronized a()Z
    .locals 6

    .prologue
    const/4 v1, 0x0

    const/4 v0, 0x1

    .line 216
    const-class v3, Lcom/firebase/jobdispatcher/GooglePlayCallbackExtractor;

    monitor-enter v3

    :try_start_0
    sget-object v2, Lcom/firebase/jobdispatcher/GooglePlayCallbackExtractor;->a:Ljava/lang/Boolean;

    if-nez v2, :cond_0

    .line 217
    const-string v2, "key"

    .line 218
    new-instance v2, Landroid/os/Bundle;

    invoke-direct {v2}, Landroid/os/Bundle;-><init>()V

    .line 219
    const-string v4, "key"

    const-string v5, "value"

    invoke-virtual {v2, v4, v5}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 220
    invoke-static {v2}, Lcom/firebase/jobdispatcher/GooglePlayCallbackExtractor;->c(Landroid/os/Bundle;)Landroid/os/Parcel;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v4

    .line 223
    :try_start_1
    invoke-virtual {v4}, Landroid/os/Parcel;->readInt()I

    move-result v2

    if-lez v2, :cond_1

    move v2, v0

    :goto_0
    invoke-static {v2}, Lcom/firebase/jobdispatcher/GooglePlayCallbackExtractor;->a(Z)V

    .line 225
    invoke-virtual {v4}, Landroid/os/Parcel;->readInt()I

    move-result v2

    const v5, 0x4c444e42    # 5.146036E7f

    if-ne v2, v5, :cond_2

    move v2, v0

    :goto_1
    invoke-static {v2}, Lcom/firebase/jobdispatcher/GooglePlayCallbackExtractor;->a(Z)V

    .line 227
    invoke-virtual {v4}, Landroid/os/Parcel;->readInt()I

    move-result v2

    if-ne v2, v0, :cond_3

    :goto_2
    invoke-static {v0}, Lcom/firebase/jobdispatcher/GooglePlayCallbackExtractor;->a(Z)V

    .line 229
    const-string v0, "key"

    invoke-virtual {v4}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    sput-object v0, Lcom/firebase/jobdispatcher/GooglePlayCallbackExtractor;->a:Ljava/lang/Boolean;
    :try_end_1
    .catch Ljava/lang/RuntimeException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 233
    :try_start_2
    invoke-virtual {v4}, Landroid/os/Parcel;->recycle()V

    .line 237
    :cond_0
    :goto_3
    sget-object v0, Lcom/firebase/jobdispatcher/GooglePlayCallbackExtractor;->a:Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    move-result v0

    monitor-exit v3

    return v0

    :cond_1
    move v2, v1

    .line 223
    goto :goto_0

    :cond_2
    move v2, v1

    .line 225
    goto :goto_1

    :cond_3
    move v0, v1

    .line 227
    goto :goto_2

    .line 230
    :catch_0
    move-exception v0

    .line 231
    :try_start_3
    sget-object v0, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    sput-object v0, Lcom/firebase/jobdispatcher/GooglePlayCallbackExtractor;->a:Ljava/lang/Boolean;
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 233
    :try_start_4
    invoke-virtual {v4}, Landroid/os/Parcel;->recycle()V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    goto :goto_3

    .line 216
    :catchall_0
    move-exception v0

    monitor-exit v3

    throw v0

    .line 233
    :catchall_1
    move-exception v0

    :try_start_5
    invoke-virtual {v4}, Landroid/os/Parcel;->recycle()V

    throw v0
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0
.end method

.method private static b(Landroid/os/Bundle;)Landroid/util/Pair;
    .locals 9
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "ParcelClassLoader"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/os/Bundle;",
            ")",
            "Landroid/util/Pair",
            "<",
            "Lcom/firebase/jobdispatcher/JobCallback;",
            "Landroid/os/Bundle;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v2, 0x0

    .line 89
    new-instance v4, Landroid/os/Bundle;

    invoke-direct {v4}, Landroid/os/Bundle;-><init>()V

    .line 90
    invoke-static {p0}, Lcom/firebase/jobdispatcher/GooglePlayCallbackExtractor;->c(Landroid/os/Bundle;)Landroid/os/Parcel;

    move-result-object v5

    .line 94
    :try_start_0
    invoke-virtual {v5}, Landroid/os/Parcel;->readInt()I

    move-result v0

    .line 95
    if-gtz v0, :cond_0

    .line 97
    const-string v0, "FJD.GooglePlayReceiver"

    const-string v1, "No callback received, terminating"

    invoke-static {v0, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 168
    invoke-virtual {v5}, Landroid/os/Parcel;->recycle()V

    move-object v0, v2

    .line 166
    :goto_0
    return-object v0

    .line 101
    :cond_0
    :try_start_1
    invoke-virtual {v5}, Landroid/os/Parcel;->readInt()I

    move-result v0

    .line 102
    const v1, 0x4c444e42    # 5.146036E7f

    if-eq v0, v1, :cond_1

    .line 104
    const-string v0, "FJD.GooglePlayReceiver"

    const-string v1, "No callback received, terminating"

    invoke-static {v0, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 168
    invoke-virtual {v5}, Landroid/os/Parcel;->recycle()V

    move-object v0, v2

    .line 105
    goto :goto_0

    .line 108
    :cond_1
    :try_start_2
    invoke-virtual {v5}, Landroid/os/Parcel;->readInt()I

    move-result v6

    .line 109
    const/4 v0, 0x0

    move v3, v0

    move-object v1, v2

    :goto_1
    if-ge v3, v6, :cond_c

    .line 110
    invoke-static {v5}, Lcom/firebase/jobdispatcher/GooglePlayCallbackExtractor;->a(Landroid/os/Parcel;)Ljava/lang/String;

    move-result-object v7

    .line 111
    if-nez v7, :cond_2

    move-object v0, v1

    .line 109
    :goto_2
    add-int/lit8 v1, v3, 0x1

    move v3, v1

    move-object v1, v0

    goto :goto_1

    .line 115
    :cond_2
    if-nez v1, :cond_3

    const-string v0, "callback"

    invoke-virtual {v0, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_9

    .line 118
    :cond_3
    const/4 v0, 0x0

    invoke-virtual {v5, v0}, Landroid/os/Parcel;->readValue(Ljava/lang/ClassLoader;)Ljava/lang/Object;

    move-result-object v0

    .line 119
    instance-of v8, v0, Ljava/lang/String;

    if-eqz v8, :cond_4

    .line 120
    check-cast v0, Ljava/lang/String;

    invoke-virtual {v4, v7, v0}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    move-object v0, v1

    goto :goto_2

    .line 121
    :cond_4
    instance-of v8, v0, Ljava/lang/Boolean;

    if-eqz v8, :cond_5

    .line 122
    check-cast v0, Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    invoke-virtual {v4, v7, v0}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    move-object v0, v1

    goto :goto_2

    .line 123
    :cond_5
    instance-of v8, v0, Ljava/lang/Integer;

    if-eqz v8, :cond_6

    .line 124
    check-cast v0, Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    invoke-virtual {v4, v7, v0}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    move-object v0, v1

    goto :goto_2

    .line 125
    :cond_6
    instance-of v8, v0, Ljava/util/ArrayList;

    if-eqz v8, :cond_7

    .line 129
    check-cast v0, Ljava/util/ArrayList;

    .line 130
    invoke-virtual {v4, v7, v0}, Landroid/os/Bundle;->putParcelableArrayList(Ljava/lang/String;Ljava/util/ArrayList;)V

    move-object v0, v1

    .line 131
    goto :goto_2

    :cond_7
    instance-of v8, v0, Landroid/os/Bundle;

    if-eqz v8, :cond_8

    .line 132
    check-cast v0, Landroid/os/Bundle;

    invoke-virtual {v4, v7, v0}, Landroid/os/Bundle;->putBundle(Ljava/lang/String;Landroid/os/Bundle;)V

    move-object v0, v1

    goto :goto_2

    .line 133
    :cond_8
    instance-of v8, v0, Landroid/os/Parcelable;

    if-eqz v8, :cond_e

    .line 134
    check-cast v0, Landroid/os/Parcelable;

    invoke-virtual {v4, v7, v0}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    move-object v0, v1

    goto :goto_2

    .line 141
    :cond_9
    invoke-virtual {v5}, Landroid/os/Parcel;->readInt()I

    move-result v0

    .line 142
    const/4 v1, 0x4

    if-eq v0, v1, :cond_a

    .line 145
    const-string v0, "FJD.GooglePlayReceiver"

    const-string v1, "Bad callback received, terminating"

    invoke-static {v0, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 168
    invoke-virtual {v5}, Landroid/os/Parcel;->recycle()V

    move-object v0, v2

    .line 146
    goto/16 :goto_0

    .line 149
    :cond_a
    :try_start_3
    invoke-virtual {v5}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    .line 150
    const-string v1, "com.google.android.gms.gcm.PendingCallback"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_b

    .line 153
    const-string v0, "FJD.GooglePlayReceiver"

    const-string v1, "Bad callback received, terminating"

    invoke-static {v0, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 168
    invoke-virtual {v5}, Landroid/os/Parcel;->recycle()V

    move-object v0, v2

    .line 154
    goto/16 :goto_0

    .line 158
    :cond_b
    :try_start_4
    invoke-virtual {v5}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v1

    .line 159
    new-instance v0, Lcom/firebase/jobdispatcher/GooglePlayJobCallback;

    invoke-direct {v0, v1}, Lcom/firebase/jobdispatcher/GooglePlayJobCallback;-><init>(Landroid/os/IBinder;)V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    goto/16 :goto_2

    .line 168
    :catchall_0
    move-exception v0

    invoke-virtual {v5}, Landroid/os/Parcel;->recycle()V

    throw v0

    .line 162
    :cond_c
    if-nez v1, :cond_d

    .line 163
    :try_start_5
    const-string v0, "FJD.GooglePlayReceiver"

    const-string v1, "No callback received, terminating"

    invoke-static {v0, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    .line 168
    invoke-virtual {v5}, Landroid/os/Parcel;->recycle()V

    move-object v0, v2

    .line 164
    goto/16 :goto_0

    .line 166
    :cond_d
    :try_start_6
    invoke-static {v1, v4}, Landroid/util/Pair;->create(Ljava/lang/Object;Ljava/lang/Object;)Landroid/util/Pair;
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_0

    move-result-object v0

    .line 168
    invoke-virtual {v5}, Landroid/os/Parcel;->recycle()V

    goto/16 :goto_0

    :cond_e
    move-object v0, v1

    goto/16 :goto_2
.end method

.method private static c(Landroid/os/Bundle;)Landroid/os/Parcel;
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 173
    invoke-static {}, Landroid/os/Parcel;->obtain()Landroid/os/Parcel;

    move-result-object v0

    .line 174
    invoke-virtual {p0, v0, v1}, Landroid/os/Bundle;->writeToParcel(Landroid/os/Parcel;I)V

    .line 175
    invoke-virtual {v0, v1}, Landroid/os/Parcel;->setDataPosition(I)V

    .line 176
    return-object v0
.end method


# virtual methods
.method public a(Landroid/os/Bundle;)Landroid/util/Pair;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/os/Bundle;",
            ")",
            "Landroid/util/Pair",
            "<",
            "Lcom/firebase/jobdispatcher/JobCallback;",
            "Landroid/os/Bundle;",
            ">;"
        }
    .end annotation

    .prologue
    .line 55
    if-nez p1, :cond_0

    .line 56
    const-string v0, "FJD.GooglePlayReceiver"

    const-string v1, "No callback received, terminating"

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 57
    const/4 v0, 0x0

    .line 60
    :goto_0
    return-object v0

    :cond_0
    invoke-static {p1}, Lcom/firebase/jobdispatcher/GooglePlayCallbackExtractor;->b(Landroid/os/Bundle;)Landroid/util/Pair;

    move-result-object v0

    goto :goto_0
.end method
