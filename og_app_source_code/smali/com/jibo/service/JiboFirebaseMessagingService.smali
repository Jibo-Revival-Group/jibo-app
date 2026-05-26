.class public Lcom/jibo/service/JiboFirebaseMessagingService;
.super Lcom/google/firebase/messaging/FirebaseMessagingService;
.source "JiboFirebaseMessagingService.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;
    }
.end annotation


# static fields
.field private static final b:Ljava/lang/String;

.field private static final c:Ljava/lang/CharSequence;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 35
    const-class v0, Lcom/jibo/service/JiboFirebaseMessagingService;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/jibo/service/JiboFirebaseMessagingService;->b:Ljava/lang/String;

    .line 49
    const-string v0, "channel_name"

    sput-object v0, Lcom/jibo/service/JiboFirebaseMessagingService;->c:Ljava/lang/CharSequence;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 33
    invoke-direct {p0}, Lcom/google/firebase/messaging/FirebaseMessagingService;-><init>()V

    return-void
.end method

.method static synthetic a(Lcom/jibo/service/JiboFirebaseMessagingService;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 33
    invoke-direct/range {p0 .. p6}, Lcom/jibo/service/JiboFirebaseMessagingService;->a(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Landroid/os/Bundle;)V

    return-void
.end method

.method private a(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;ILandroid/os/Bundle;)V
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "I",
            "Landroid/os/Bundle;",
            ")V"
        }
    .end annotation

    .prologue
    .line 141
    const/4 v5, 0x0

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move v4, p4

    move-object v6, p5

    invoke-direct/range {v0 .. v6}, Lcom/jibo/service/JiboFirebaseMessagingService;->a(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Landroid/os/Bundle;)V

    .line 142
    return-void
.end method

.method private a(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Landroid/os/Bundle;)V
    .locals 9
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "I",
            "Ljava/lang/String;",
            "Landroid/os/Bundle;",
            ")V"
        }
    .end annotation

    .prologue
    .line 152
    const-string v0, "android.intent.action.VIEW"

    invoke-virtual {p6, v0}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_5

    .line 153
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/jibo/ui/activity/OnBoardingActivity;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 154
    const/high16 v1, 0x4000000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 157
    if-eqz p6, :cond_0

    .line 158
    const-string v1, "ARG_EXTRAS"

    invoke-virtual {v0, v1, p6}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Bundle;)Landroid/content/Intent;

    .line 163
    :cond_0
    :goto_0
    const/4 v1, 0x0

    const/high16 v2, 0x8000000

    invoke-static {p0, v1, v0, v2}, Landroid/app/PendingIntent;->getActivity(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v2

    .line 166
    const-string v1, ""

    .line 167
    const/4 v0, 0x0

    .line 168
    sget v3, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v4, 0x1a

    if-lt v3, v4, :cond_9

    .line 169
    const-string v1, "my_channel_01"

    .line 170
    new-instance v0, Landroid/app/NotificationChannel;

    sget-object v3, Lcom/jibo/service/JiboFirebaseMessagingService;->c:Ljava/lang/CharSequence;

    const/4 v4, 0x3

    invoke-direct {v0, v1, v3, v4}, Landroid/app/NotificationChannel;-><init>(Ljava/lang/String;Ljava/lang/CharSequence;I)V

    move-object v8, v0

    move-object v0, v1

    move-object v1, v8

    .line 174
    :goto_1
    new-instance v3, Landroid/support/v4/app/NotificationCompat$Builder;

    invoke-direct {v3, p0, v0}, Landroid/support/v4/app/NotificationCompat$Builder;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 175
    invoke-static {}, Lcom/jibo/utils/UIUtils;->a()I

    move-result v0

    invoke-virtual {v3, v0}, Landroid/support/v4/app/NotificationCompat$Builder;->a(I)Landroid/support/v4/app/NotificationCompat$Builder;

    move-result-object v3

    .line 176
    invoke-static {p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_6

    const v0, 0x7f100037

    invoke-virtual {p0, v0}, Lcom/jibo/service/JiboFirebaseMessagingService;->getString(I)Ljava/lang/String;

    move-result-object v0

    :goto_2
    invoke-virtual {v3, v0}, Landroid/support/v4/app/NotificationCompat$Builder;->a(Ljava/lang/CharSequence;)Landroid/support/v4/app/NotificationCompat$Builder;

    move-result-object v3

    const/4 v0, 0x1

    new-array v4, v0, [Ljava/lang/Object;

    const/4 v5, 0x0

    const-string v0, "loc-args"

    .line 177
    invoke-interface {p1, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    if-nez v0, :cond_7

    const-string v0, ""

    .line 178
    :goto_3
    aput-object v0, v4, v5

    .line 177
    invoke-static {p3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v3, v0}, Landroid/support/v4/app/NotificationCompat$Builder;->b(Ljava/lang/CharSequence;)Landroid/support/v4/app/NotificationCompat$Builder;

    move-result-object v0

    const/4 v3, 0x1

    .line 179
    invoke-virtual {v0, v3}, Landroid/support/v4/app/NotificationCompat$Builder;->a(Z)Landroid/support/v4/app/NotificationCompat$Builder;

    move-result-object v0

    const/4 v3, 0x2

    .line 180
    invoke-static {v3}, Landroid/media/RingtoneManager;->getDefaultUri(I)Landroid/net/Uri;

    move-result-object v3

    invoke-virtual {v0, v3}, Landroid/support/v4/app/NotificationCompat$Builder;->a(Landroid/net/Uri;)Landroid/support/v4/app/NotificationCompat$Builder;

    move-result-object v0

    .line 181
    invoke-virtual {v0, v2}, Landroid/support/v4/app/NotificationCompat$Builder;->a(Landroid/app/PendingIntent;)Landroid/support/v4/app/NotificationCompat$Builder;

    move-result-object v2

    .line 183
    new-instance v3, Landroid/support/v4/app/NotificationCompat$BigTextStyle;

    invoke-direct {v3, v2}, Landroid/support/v4/app/NotificationCompat$BigTextStyle;-><init>(Landroid/support/v4/app/NotificationCompat$Builder;)V

    .line 185
    const/4 v0, 0x1

    new-array v4, v0, [Ljava/lang/Object;

    const/4 v5, 0x0

    const-string v0, "loc-args"

    invoke-interface {p1, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    if-nez v0, :cond_8

    const-string v0, ""

    .line 186
    :goto_4
    aput-object v0, v4, v5

    .line 185
    invoke-static {p3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v3, v0}, Landroid/support/v4/app/NotificationCompat$BigTextStyle;->b(Ljava/lang/CharSequence;)Landroid/support/v4/app/NotificationCompat$BigTextStyle;

    .line 187
    invoke-static {p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_1

    const v0, 0x7f100037

    invoke-virtual {p0, v0}, Lcom/jibo/service/JiboFirebaseMessagingService;->getString(I)Ljava/lang/String;

    move-result-object p2

    :cond_1
    invoke-virtual {v3, p2}, Landroid/support/v4/app/NotificationCompat$BigTextStyle;->a(Ljava/lang/CharSequence;)Landroid/support/v4/app/NotificationCompat$BigTextStyle;

    .line 188
    invoke-virtual {v2, v3}, Landroid/support/v4/app/NotificationCompat$Builder;->a(Landroid/support/v4/app/NotificationCompat$Style;)Landroid/support/v4/app/NotificationCompat$Builder;

    .line 190
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v3, 0x15

    if-lt v0, v3, :cond_2

    .line 191
    invoke-virtual {p0}, Lcom/jibo/service/JiboFirebaseMessagingService;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v3, 0x7f06007b

    invoke-virtual {v0, v3}, Landroid/content/res/Resources;->getColor(I)I

    move-result v0

    invoke-virtual {v2, v0}, Landroid/support/v4/app/NotificationCompat$Builder;->d(I)Landroid/support/v4/app/NotificationCompat$Builder;

    .line 194
    :cond_2
    const-string v0, "notification"

    invoke-virtual {p0, v0}, Lcom/jibo/service/JiboFirebaseMessagingService;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/NotificationManager;

    .line 195
    if-eqz v0, :cond_4

    .line 196
    sget v3, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v4, 0x1a

    if-lt v3, v4, :cond_3

    .line 197
    invoke-virtual {v0, v1}, Landroid/app/NotificationManager;->createNotificationChannel(Landroid/app/NotificationChannel;)V

    .line 199
    :cond_3
    invoke-virtual {v2}, Landroid/support/v4/app/NotificationCompat$Builder;->b()Landroid/app/Notification;

    move-result-object v1

    invoke-virtual {v0, p5, p4, v1}, Landroid/app/NotificationManager;->notify(Ljava/lang/String;ILandroid/app/Notification;)V

    .line 201
    :cond_4
    return-void

    .line 161
    :cond_5
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.VIEW"

    const-string v2, "android.intent.action.VIEW"

    invoke-virtual {p6, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    goto/16 :goto_0

    :cond_6
    move-object v0, p2

    .line 176
    goto/16 :goto_2

    .line 177
    :cond_7
    const-string v0, "loc-args"

    .line 178
    invoke-interface {p1, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    const-string v6, "[\""

    const-string v7, ""

    invoke-virtual {v0, v6, v7}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v0

    const-string v6, "\"]"

    const-string v7, ""

    invoke-virtual {v0, v6, v7}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_3

    .line 185
    :cond_8
    const-string v0, "loc-args"

    .line 186
    invoke-interface {p1, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    const-string v6, "[\""

    const-string v7, ""

    invoke-virtual {v0, v6, v7}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v0

    const-string v6, "\"]"

    const-string v7, ""

    invoke-virtual {v0, v6, v7}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_4

    :cond_9
    move-object v8, v0

    move-object v0, v1

    move-object v1, v8

    goto/16 :goto_1
.end method


# virtual methods
.method public a(Lcom/google/firebase/messaging/RemoteMessage;)V
    .locals 9

    .prologue
    const v8, 0x7f100262

    const/4 v4, 0x5

    const/4 v6, 0x1

    const/4 v7, 0x0

    const/4 v2, 0x0

    .line 62
    invoke-super {p0, p1}, Lcom/google/firebase/messaging/FirebaseMessagingService;->a(Lcom/google/firebase/messaging/RemoteMessage;)V

    .line 64
    invoke-virtual {p1}, Lcom/google/firebase/messaging/RemoteMessage;->a()Ljava/util/Map;

    move-result-object v1

    .line 65
    const-string v0, "type"

    invoke-interface {v1, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 67
    const-string v0, "type"

    invoke-interface {v1, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    const-string v3, "-"

    const-string v5, "_"

    invoke-virtual {v0, v3, v5}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v0

    const-string v3, "."

    const-string v5, "_"

    invoke-virtual {v0, v3, v5}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v0

    .line 68
    sget-object v3, Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;->loop_changed_silent:Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;

    invoke-virtual {v3}, Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 69
    invoke-virtual {p0}, Lcom/jibo/service/JiboFirebaseMessagingService;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    const-string v0, "loopId"

    invoke-interface {v1, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-static {v2, v0}, Lcom/jibo/service/SyncHelper;->a(Landroid/content/Context;Ljava/lang/String;)V

    .line 133
    :cond_0
    :goto_0
    return-void

    .line 70
    :cond_1
    sget-object v3, Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;->loop_invited:Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;

    invoke-virtual {v3}, Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 71
    invoke-virtual {p0}, Lcom/jibo/service/JiboFirebaseMessagingService;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    const-string v0, "loopId"

    invoke-interface {v1, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-static {v3, v0}, Lcom/jibo/service/SyncHelper;->a(Landroid/content/Context;Ljava/lang/String;)V

    .line 72
    new-instance v6, Landroid/os/Bundle;

    invoke-direct {v6}, Landroid/os/Bundle;-><init>()V

    .line 73
    const-string v0, "ARG_TAB_SELECTED"

    invoke-virtual {v6, v0, v7}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 74
    const-string v3, "ARG_ENTITY_SELECTED"

    const-string v0, "loopId"

    invoke-interface {v1, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-virtual {v6, v3, v0}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 75
    const v0, 0x7f100226

    invoke-virtual {p0, v0}, Lcom/jibo/service/JiboFirebaseMessagingService;->getString(I)Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x2

    const-string v0, "loopId"

    .line 76
    invoke-interface {v1, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    move-object v0, p0

    .line 75
    invoke-direct/range {v0 .. v6}, Lcom/jibo/service/JiboFirebaseMessagingService;->a(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Landroid/os/Bundle;)V

    goto :goto_0

    .line 77
    :cond_2
    sget-object v3, Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;->loop_accepted:Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;

    invoke-virtual {v3}, Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_3

    .line 78
    invoke-virtual {p0}, Lcom/jibo/service/JiboFirebaseMessagingService;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    const-string v0, "loopId"

    invoke-interface {v1, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-static {v3, v0}, Lcom/jibo/service/SyncHelper;->a(Landroid/content/Context;Ljava/lang/String;)V

    .line 79
    new-instance v5, Landroid/os/Bundle;

    invoke-direct {v5}, Landroid/os/Bundle;-><init>()V

    .line 80
    const-string v0, "ARG_TAB_SELECTED"

    invoke-virtual {v5, v0, v7}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 81
    const-string v3, "ARG_ENTITY_SELECTED"

    const-string v0, "loopId"

    invoke-interface {v1, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-virtual {v5, v3, v0}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 82
    const v0, 0x7f100227

    invoke-virtual {p0, v0}, Lcom/jibo/service/JiboFirebaseMessagingService;->getString(I)Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x3

    move-object v0, p0

    invoke-direct/range {v0 .. v5}, Lcom/jibo/service/JiboFirebaseMessagingService;->a(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;ILandroid/os/Bundle;)V

    goto/16 :goto_0

    .line 84
    :cond_3
    sget-object v3, Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;->jot_created_silent:Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;

    invoke-virtual {v3}, Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_4

    .line 85
    invoke-virtual {p0}, Lcom/jibo/service/JiboFirebaseMessagingService;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    const-string v0, "loopId"

    invoke-interface {v1, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-static {v2, v0}, Lcom/jibo/service/SyncHelper;->c(Landroid/content/Context;Ljava/lang/String;)V

    goto/16 :goto_0

    .line 86
    :cond_4
    sget-object v3, Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;->media_created_silent:Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;

    invoke-virtual {v3}, Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_5

    .line 87
    new-instance v0, Ljava/util/Timer;

    invoke-direct {v0}, Ljava/util/Timer;-><init>()V

    new-instance v2, Lcom/jibo/service/JiboFirebaseMessagingService$1;

    invoke-direct {v2, p0, v1}, Lcom/jibo/service/JiboFirebaseMessagingService$1;-><init>(Lcom/jibo/service/JiboFirebaseMessagingService;Ljava/util/Map;)V

    const-wide/16 v4, 0xfa0

    invoke-virtual {v0, v2, v4, v5}, Ljava/util/Timer;->schedule(Ljava/util/TimerTask;J)V

    goto/16 :goto_0

    .line 102
    :cond_5
    sget-object v3, Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;->media_deleted_silent:Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;

    invoke-virtual {v3}, Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_6

    .line 103
    new-array v2, v6, [Ljava/lang/String;

    .line 104
    const-string v0, "path"

    invoke-interface {v1, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    aput-object v0, v2, v7

    .line 105
    invoke-virtual {p0}, Lcom/jibo/service/JiboFirebaseMessagingService;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0, v2, v6}, Lcom/jibo/service/MediaDeletingService;->a(Landroid/content/Context;[Ljava/lang/String;Z)V

    goto/16 :goto_0

    .line 106
    :cond_6
    sget-object v3, Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;->key_needed_silent:Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;

    invoke-virtual {v3}, Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_7

    .line 107
    invoke-static {p0, v1}, Lcom/jibo/service/KeyRequestingSharingService;->a(Landroid/content/Context;Ljava/util/Map;)V

    goto/16 :goto_0

    .line 108
    :cond_7
    sget-object v3, Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;->key_shared_silent:Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;

    invoke-virtual {v3}, Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_8

    .line 109
    invoke-static {p0, v1}, Lcom/jibo/service/KeyRequestingSharingService;->b(Landroid/content/Context;Ljava/util/Map;)V

    goto/16 :goto_0

    .line 110
    :cond_8
    sget-object v3, Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;->key_timeout_silent:Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;

    invoke-virtual {v3}, Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_9

    .line 111
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 112
    invoke-static {p0}, Lcom/jibo/utils/SharedPreferencesUtil;->n(Landroid/content/Context;)[Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v2}, Ljava/util/Collections;->addAll(Ljava/util/Collection;[Ljava/lang/Object;)Z

    .line 114
    const-string v2, "loopId"

    invoke-interface {v1, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->indexOf(Ljava/lang/Object;)I

    move-result v0

    const/4 v2, -0x1

    if-ne v0, v2, :cond_0

    .line 115
    const-string v0, "loopId"

    invoke-interface {v1, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-static {p0, v0}, Lcom/jibo/utils/SharedPreferencesUtil;->c(Landroid/content/Context;Ljava/lang/String;)V

    goto/16 :goto_0

    .line 117
    :cond_9
    sget-object v3, Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;->version_installed:Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;

    invoke-virtual {v3}, Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_a

    .line 119
    new-instance v5, Landroid/os/Bundle;

    invoke-direct {v5}, Landroid/os/Bundle;-><init>()V

    .line 120
    const-string v0, "android.intent.action.VIEW"

    invoke-virtual {p0, v8}, Lcom/jibo/service/JiboFirebaseMessagingService;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v5, v0, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 121
    const v0, 0x7f10022d

    .line 122
    invoke-virtual {p0, v0}, Lcom/jibo/service/JiboFirebaseMessagingService;->getString(I)Ljava/lang/String;

    move-result-object v3

    move-object v0, p0

    .line 121
    invoke-direct/range {v0 .. v5}, Lcom/jibo/service/JiboFirebaseMessagingService;->a(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;ILandroid/os/Bundle;)V

    goto/16 :goto_0

    .line 124
    :cond_a
    sget-object v3, Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;->version_updated:Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;

    invoke-virtual {v3}, Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 126
    new-instance v5, Landroid/os/Bundle;

    invoke-direct {v5}, Landroid/os/Bundle;-><init>()V

    .line 127
    const-string v0, "android.intent.action.VIEW"

    invoke-virtual {p0, v8}, Lcom/jibo/service/JiboFirebaseMessagingService;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v5, v0, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 128
    const v0, 0x7f10022e

    .line 129
    invoke-virtual {p0, v0}, Lcom/jibo/service/JiboFirebaseMessagingService;->getString(I)Ljava/lang/String;

    move-result-object v3

    move-object v0, p0

    .line 128
    invoke-direct/range {v0 .. v5}, Lcom/jibo/service/JiboFirebaseMessagingService;->a(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;ILandroid/os/Bundle;)V

    goto/16 :goto_0
.end method
