.class public Lcom/mixpanel/android/mpmetrics/GCMReceiver;
.super Landroid/content/BroadcastReceiver;
.source "GCMReceiver.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/mixpanel/android/mpmetrics/GCMReceiver$NotificationData;
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 97
    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method

.method private a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    .locals 3

    .prologue
    .line 213
    const/4 v0, 0x0

    .line 214
    if-eqz p2, :cond_4

    .line 215
    invoke-static {p2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    move-object v1, v0

    .line 219
    :goto_0
    if-nez v1, :cond_3

    .line 220
    invoke-virtual {p0, p1}, Lcom/mixpanel/android/mpmetrics/GCMReceiver;->a(Landroid/content/Context;)Landroid/content/Intent;

    move-result-object v0

    .line 225
    :goto_1
    if-eqz p3, :cond_0

    .line 226
    const-string v1, "mp_campaign_id"

    invoke-virtual {v0, v1, p3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 229
    :cond_0
    if-eqz p4, :cond_1

    .line 230
    const-string v1, "mp_message_id"

    invoke-virtual {v0, v1, p4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 233
    :cond_1
    if-eqz p5, :cond_2

    .line 234
    const-string v1, "mp"

    invoke-virtual {v0, v1, p5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 237
    :cond_2
    return-object v0

    .line 222
    :cond_3
    new-instance v0, Landroid/content/Intent;

    const-string v2, "android.intent.action.VIEW"

    invoke-direct {v0, v2, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    goto :goto_1

    :cond_4
    move-object v1, v0

    goto :goto_0
.end method

.method private a(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 3

    .prologue
    .line 294
    invoke-static {p1}, Lcom/mixpanel/android/mpmetrics/MPConfig;->a(Landroid/content/Context;)Lcom/mixpanel/android/mpmetrics/MPConfig;

    move-result-object v0

    .line 295
    invoke-virtual {v0}, Lcom/mixpanel/android/mpmetrics/MPConfig;->x()Ljava/lang/String;

    move-result-object v0

    .line 296
    if-nez v0, :cond_0

    .line 297
    invoke-virtual {p1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v0

    .line 300
    :cond_0
    new-instance v1, Lcom/mixpanel/android/mpmetrics/ResourceReader$Drawables;

    invoke-direct {v1, v0, p1}, Lcom/mixpanel/android/mpmetrics/ResourceReader$Drawables;-><init>(Ljava/lang/String;Landroid/content/Context;)V

    .line 301
    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    .line 302
    invoke-direct {p0, v0, p2, v1}, Lcom/mixpanel/android/mpmetrics/GCMReceiver;->b(Landroid/content/Context;Landroid/content/Intent;Lcom/mixpanel/android/mpmetrics/ResourceIds;)Landroid/app/Notification;

    move-result-object v1

    .line 304
    if-eqz v1, :cond_1

    .line 305
    const-string v0, "notification"

    invoke-virtual {p1, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/NotificationManager;

    .line 306
    const/4 v2, 0x0

    invoke-virtual {v0, v2, v1}, Landroid/app/NotificationManager;->notify(ILandroid/app/Notification;)V

    .line 308
    :cond_1
    return-void
.end method

.method private a(Landroid/content/Intent;)V
    .locals 4

    .prologue
    .line 271
    const-string v0, "registration_id"

    invoke-virtual {p1, v0}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 272
    const-string v1, "error"

    invoke-virtual {p1, v1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_1

    .line 273
    const-string v0, "MixpanelAPI.GCMReceiver"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Error when registering for GCM: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "error"

    invoke-virtual {p1, v2}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/mixpanel/android/util/MPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 291
    :cond_0
    :goto_0
    return-void

    .line 274
    :cond_1
    if-eqz v0, :cond_2

    .line 275
    const-string v1, "MixpanelAPI.GCMReceiver"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Registering GCM ID: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/mixpanel/android/util/MPLog;->b(Ljava/lang/String;Ljava/lang/String;)V

    .line 276
    new-instance v1, Lcom/mixpanel/android/mpmetrics/GCMReceiver$1;

    invoke-direct {v1, p0, v0}, Lcom/mixpanel/android/mpmetrics/GCMReceiver$1;-><init>(Lcom/mixpanel/android/mpmetrics/GCMReceiver;Ljava/lang/String;)V

    invoke-static {v1}, Lcom/mixpanel/android/mpmetrics/MixpanelAPI;->a(Lcom/mixpanel/android/mpmetrics/MixpanelAPI$InstanceProcessor;)V

    goto :goto_0

    .line 282
    :cond_2
    const-string v0, "unregistered"

    invoke-virtual {p1, v0}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 283
    const-string v0, "MixpanelAPI.GCMReceiver"

    const-string v1, "Unregistering from GCM"

    invoke-static {v0, v1}, Lcom/mixpanel/android/util/MPLog;->b(Ljava/lang/String;Ljava/lang/String;)V

    .line 284
    new-instance v0, Lcom/mixpanel/android/mpmetrics/GCMReceiver$2;

    invoke-direct {v0, p0}, Lcom/mixpanel/android/mpmetrics/GCMReceiver$2;-><init>(Lcom/mixpanel/android/mpmetrics/GCMReceiver;)V

    invoke-static {v0}, Lcom/mixpanel/android/mpmetrics/MixpanelAPI;->a(Lcom/mixpanel/android/mpmetrics/MixpanelAPI$InstanceProcessor;)V

    goto :goto_0
.end method

.method private a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 455
    if-eqz p1, :cond_0

    if-eqz p2, :cond_0

    .line 456
    new-instance v0, Lcom/mixpanel/android/mpmetrics/GCMReceiver$3;

    invoke-direct {v0, p0, p3, p1, p2}, Lcom/mixpanel/android/mpmetrics/GCMReceiver$3;-><init>(Lcom/mixpanel/android/mpmetrics/GCMReceiver;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    invoke-static {v0}, Lcom/mixpanel/android/mpmetrics/MixpanelAPI;->a(Lcom/mixpanel/android/mpmetrics/MixpanelAPI$InstanceProcessor;)V

    .line 477
    :cond_0
    return-void
.end method

.method private b(Landroid/content/Context;Landroid/content/Intent;Lcom/mixpanel/android/mpmetrics/ResourceIds;)Landroid/app/Notification;
    .locals 4

    .prologue
    .line 241
    invoke-virtual {p0, p1, p2, p3}, Lcom/mixpanel/android/mpmetrics/GCMReceiver;->a(Landroid/content/Context;Landroid/content/Intent;Lcom/mixpanel/android/mpmetrics/ResourceIds;)Lcom/mixpanel/android/mpmetrics/GCMReceiver$NotificationData;

    move-result-object v0

    .line 242
    if-nez v0, :cond_0

    .line 243
    const/4 v0, 0x0

    .line 267
    :goto_0
    return-object v0

    .line 246
    :cond_0
    const-string v1, "MixpanelAPI.GCMReceiver"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "MP GCM notification received: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, v0, Lcom/mixpanel/android/mpmetrics/GCMReceiver$NotificationData;->e:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/mixpanel/android/util/MPLog;->b(Ljava/lang/String;Ljava/lang/String;)V

    .line 247
    const/4 v1, 0x0

    iget-object v2, v0, Lcom/mixpanel/android/mpmetrics/GCMReceiver$NotificationData;->f:Landroid/content/Intent;

    const/high16 v3, 0x8000000

    invoke-static {p1, v1, v2, v3}, Landroid/app/PendingIntent;->getActivity(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v1

    .line 255
    sget v2, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v3, 0x1a

    if-lt v2, v3, :cond_1

    .line 256
    invoke-virtual {p0, p1, v1, v0}, Lcom/mixpanel/android/mpmetrics/GCMReceiver;->e(Landroid/content/Context;Landroid/app/PendingIntent;Lcom/mixpanel/android/mpmetrics/GCMReceiver$NotificationData;)Landroid/app/Notification;

    move-result-object v0

    goto :goto_0

    .line 257
    :cond_1
    sget v2, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v3, 0x15

    if-lt v2, v3, :cond_2

    .line 258
    invoke-virtual {p0, p1, v1, v0}, Lcom/mixpanel/android/mpmetrics/GCMReceiver;->d(Landroid/content/Context;Landroid/app/PendingIntent;Lcom/mixpanel/android/mpmetrics/GCMReceiver$NotificationData;)Landroid/app/Notification;

    move-result-object v0

    goto :goto_0

    .line 259
    :cond_2
    sget v2, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v3, 0x10

    if-lt v2, v3, :cond_3

    .line 260
    invoke-virtual {p0, p1, v1, v0}, Lcom/mixpanel/android/mpmetrics/GCMReceiver;->c(Landroid/content/Context;Landroid/app/PendingIntent;Lcom/mixpanel/android/mpmetrics/GCMReceiver$NotificationData;)Landroid/app/Notification;

    move-result-object v0

    goto :goto_0

    .line 261
    :cond_3
    sget v2, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v3, 0xb

    if-lt v2, v3, :cond_4

    .line 262
    invoke-virtual {p0, p1, v1, v0}, Lcom/mixpanel/android/mpmetrics/GCMReceiver;->b(Landroid/content/Context;Landroid/app/PendingIntent;Lcom/mixpanel/android/mpmetrics/GCMReceiver$NotificationData;)Landroid/app/Notification;

    move-result-object v0

    goto :goto_0

    .line 264
    :cond_4
    invoke-virtual {p0, p1, v1, v0}, Lcom/mixpanel/android/mpmetrics/GCMReceiver;->a(Landroid/content/Context;Landroid/app/PendingIntent;Lcom/mixpanel/android/mpmetrics/GCMReceiver$NotificationData;)Landroid/app/Notification;

    move-result-object v0

    goto :goto_0
.end method


# virtual methods
.method protected a(Landroid/content/Context;Landroid/app/PendingIntent;Lcom/mixpanel/android/mpmetrics/GCMReceiver$NotificationData;)Landroid/app/Notification;
    .locals 4
    .annotation build Landroid/annotation/TargetApi;
        value = 0x9
    .end annotation

    .prologue
    .line 313
    new-instance v0, Landroid/support/v4/app/NotificationCompat$Builder;

    invoke-direct {v0, p1}, Landroid/support/v4/app/NotificationCompat$Builder;-><init>(Landroid/content/Context;)V

    iget v1, p3, Lcom/mixpanel/android/mpmetrics/GCMReceiver$NotificationData;->a:I

    .line 314
    invoke-virtual {v0, v1}, Landroid/support/v4/app/NotificationCompat$Builder;->a(I)Landroid/support/v4/app/NotificationCompat$Builder;

    move-result-object v0

    iget-object v1, p3, Lcom/mixpanel/android/mpmetrics/GCMReceiver$NotificationData;->e:Ljava/lang/String;

    .line 315
    invoke-virtual {v0, v1}, Landroid/support/v4/app/NotificationCompat$Builder;->c(Ljava/lang/CharSequence;)Landroid/support/v4/app/NotificationCompat$Builder;

    move-result-object v0

    .line 316
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    invoke-virtual {v0, v2, v3}, Landroid/support/v4/app/NotificationCompat$Builder;->a(J)Landroid/support/v4/app/NotificationCompat$Builder;

    move-result-object v0

    iget-object v1, p3, Lcom/mixpanel/android/mpmetrics/GCMReceiver$NotificationData;->d:Ljava/lang/CharSequence;

    .line 317
    invoke-virtual {v0, v1}, Landroid/support/v4/app/NotificationCompat$Builder;->a(Ljava/lang/CharSequence;)Landroid/support/v4/app/NotificationCompat$Builder;

    move-result-object v0

    iget-object v1, p3, Lcom/mixpanel/android/mpmetrics/GCMReceiver$NotificationData;->e:Ljava/lang/String;

    .line 318
    invoke-virtual {v0, v1}, Landroid/support/v4/app/NotificationCompat$Builder;->b(Ljava/lang/CharSequence;)Landroid/support/v4/app/NotificationCompat$Builder;

    move-result-object v0

    .line 319
    invoke-virtual {v0, p2}, Landroid/support/v4/app/NotificationCompat$Builder;->a(Landroid/app/PendingIntent;)Landroid/support/v4/app/NotificationCompat$Builder;

    move-result-object v0

    .line 320
    invoke-static {p1}, Lcom/mixpanel/android/mpmetrics/MPConfig;->a(Landroid/content/Context;)Lcom/mixpanel/android/mpmetrics/MPConfig;

    move-result-object v1

    invoke-virtual {v1}, Lcom/mixpanel/android/mpmetrics/MPConfig;->r()I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/support/v4/app/NotificationCompat$Builder;->b(I)Landroid/support/v4/app/NotificationCompat$Builder;

    move-result-object v0

    .line 322
    iget v1, p3, Lcom/mixpanel/android/mpmetrics/GCMReceiver$NotificationData;->b:I

    const/4 v2, -0x1

    if-eq v1, v2, :cond_0

    .line 323
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    iget v2, p3, Lcom/mixpanel/android/mpmetrics/GCMReceiver$NotificationData;->b:I

    invoke-static {v1, v2}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/support/v4/app/NotificationCompat$Builder;->a(Landroid/graphics/Bitmap;)Landroid/support/v4/app/NotificationCompat$Builder;

    .line 326
    :cond_0
    invoke-virtual {v0}, Landroid/support/v4/app/NotificationCompat$Builder;->a()Landroid/app/Notification;

    move-result-object v0

    .line 327
    iget v1, v0, Landroid/app/Notification;->flags:I

    or-int/lit8 v1, v1, 0x10

    iput v1, v0, Landroid/app/Notification;->flags:I

    .line 328
    return-object v0
.end method

.method a(Landroid/content/Context;)Landroid/content/Intent;
    .locals 2

    .prologue
    .line 132
    invoke-virtual {p1}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v0

    .line 133
    invoke-virtual {p1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/content/pm/PackageManager;->getLaunchIntentForPackage(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v0

    return-object v0
.end method

.method a(Landroid/content/Context;Landroid/content/Intent;Lcom/mixpanel/android/mpmetrics/ResourceIds;)Lcom/mixpanel/android/mpmetrics/GCMReceiver$NotificationData;
    .locals 15

    .prologue
    .line 137
    invoke-virtual/range {p1 .. p1}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v9

    .line 139
    const-string v1, "mp_message"

    move-object/from16 v0, p2

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v14

    .line 140
    const-string v1, "mp_icnm"

    move-object/from16 v0, p2

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    .line 141
    const-string v1, "mp_icnm_l"

    move-object/from16 v0, p2

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    .line 142
    const-string v1, "mp_icnm_w"

    move-object/from16 v0, p2

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v11

    .line 143
    const-string v1, "mp_cta"

    move-object/from16 v0, p2

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 144
    const-string v1, "mp_title"

    move-object/from16 v0, p2

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 145
    const-string v2, "mp_color"

    move-object/from16 v0, p2

    invoke-virtual {v0, v2}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 146
    const-string v4, "mp_campaign_id"

    move-object/from16 v0, p2

    invoke-virtual {v0, v4}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 147
    const-string v5, "mp_message_id"

    move-object/from16 v0, p2

    invoke-virtual {v0, v5}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 148
    const-string v6, "mp"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 149
    const/4 v8, -0x1

    .line 151
    invoke-direct {p0, v4, v5, v6}, Lcom/mixpanel/android/mpmetrics/GCMReceiver;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 153
    if-eqz v2, :cond_0

    .line 155
    :try_start_0
    invoke-static {v2}, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_1

    move-result v8

    .line 159
    :cond_0
    :goto_0
    if-nez v14, :cond_1

    .line 160
    const/4 v1, 0x0

    .line 209
    :goto_1
    return-object v1

    .line 163
    :cond_1
    const/4 v2, -0x1

    .line 164
    if-eqz v7, :cond_2

    .line 165
    move-object/from16 v0, p3

    invoke-interface {v0, v7}, Lcom/mixpanel/android/mpmetrics/ResourceIds;->a(Ljava/lang/String;)Z

    move-result v12

    if-eqz v12, :cond_2

    .line 166
    move-object/from16 v0, p3

    invoke-interface {v0, v7}, Lcom/mixpanel/android/mpmetrics/ResourceIds;->b(Ljava/lang/String;)I

    move-result v2

    .line 170
    :cond_2
    const/4 v7, -0x1

    .line 171
    if-eqz v10, :cond_8

    .line 172
    move-object/from16 v0, p3

    invoke-interface {v0, v10}, Lcom/mixpanel/android/mpmetrics/ResourceIds;->a(Ljava/lang/String;)Z

    move-result v12

    if-eqz v12, :cond_8

    .line 173
    move-object/from16 v0, p3

    invoke-interface {v0, v10}, Lcom/mixpanel/android/mpmetrics/ResourceIds;->b(Ljava/lang/String;)I

    move-result v7

    move v13, v7

    .line 177
    :goto_2
    const/4 v7, -0x1

    .line 178
    if-eqz v11, :cond_7

    .line 179
    move-object/from16 v0, p3

    invoke-interface {v0, v11}, Lcom/mixpanel/android/mpmetrics/ResourceIds;->a(Ljava/lang/String;)Z

    move-result v10

    if-eqz v10, :cond_7

    .line 180
    move-object/from16 v0, p3

    invoke-interface {v0, v11}, Lcom/mixpanel/android/mpmetrics/ResourceIds;->b(Ljava/lang/String;)I

    move-result v7

    move v12, v7

    .line 186
    :goto_3
    :try_start_1
    invoke-virtual/range {p1 .. p1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v7

    const/4 v10, 0x0

    invoke-virtual {v9, v7, v10}, Landroid/content/pm/PackageManager;->getApplicationInfo(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    :try_end_1
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_1 .. :try_end_1} :catch_0

    move-result-object v7

    .line 191
    :goto_4
    const/4 v10, -0x1

    if-ne v2, v10, :cond_3

    if-eqz v7, :cond_3

    .line 192
    iget v2, v7, Landroid/content/pm/ApplicationInfo;->icon:I

    .line 195
    :cond_3
    const/4 v10, -0x1

    if-ne v2, v10, :cond_6

    .line 196
    const v2, 0x1080093

    move v11, v2

    .line 199
    :goto_5
    if-nez v1, :cond_4

    if-eqz v7, :cond_4

    .line 200
    invoke-virtual {v9, v7}, Landroid/content/pm/PackageManager;->getApplicationLabel(Landroid/content/pm/ApplicationInfo;)Ljava/lang/CharSequence;

    move-result-object v1

    .line 203
    :cond_4
    if-nez v1, :cond_5

    .line 204
    const-string v1, "A message for you"

    move-object v10, v1

    :goto_6
    move-object v1, p0

    move-object/from16 v2, p1

    .line 207
    invoke-direct/range {v1 .. v6}, Lcom/mixpanel/android/mpmetrics/GCMReceiver;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v7

    .line 209
    new-instance v1, Lcom/mixpanel/android/mpmetrics/GCMReceiver$NotificationData;

    const/4 v9, 0x0

    move v2, v11

    move v3, v13

    move v4, v12

    move-object v5, v10

    move-object v6, v14

    invoke-direct/range {v1 .. v9}, Lcom/mixpanel/android/mpmetrics/GCMReceiver$NotificationData;-><init>(IIILjava/lang/CharSequence;Ljava/lang/String;Landroid/content/Intent;ILcom/mixpanel/android/mpmetrics/GCMReceiver$1;)V

    goto :goto_1

    .line 187
    :catch_0
    move-exception v7

    .line 188
    const/4 v7, 0x0

    goto :goto_4

    .line 156
    :catch_1
    move-exception v2

    goto :goto_0

    :cond_5
    move-object v10, v1

    goto :goto_6

    :cond_6
    move v11, v2

    goto :goto_5

    :cond_7
    move v12, v7

    goto :goto_3

    :cond_8
    move v13, v7

    goto :goto_2
.end method

.method protected b(Landroid/content/Context;Landroid/app/PendingIntent;Lcom/mixpanel/android/mpmetrics/GCMReceiver$NotificationData;)Landroid/app/Notification;
    .locals 4
    .annotation build Landroid/annotation/TargetApi;
        value = 0xb
    .end annotation

    .prologue
    .line 334
    new-instance v0, Landroid/app/Notification$Builder;

    invoke-direct {v0, p1}, Landroid/app/Notification$Builder;-><init>(Landroid/content/Context;)V

    iget v1, p3, Lcom/mixpanel/android/mpmetrics/GCMReceiver$NotificationData;->a:I

    .line 335
    invoke-virtual {v0, v1}, Landroid/app/Notification$Builder;->setSmallIcon(I)Landroid/app/Notification$Builder;

    move-result-object v0

    iget-object v1, p3, Lcom/mixpanel/android/mpmetrics/GCMReceiver$NotificationData;->e:Ljava/lang/String;

    .line 336
    invoke-virtual {v0, v1}, Landroid/app/Notification$Builder;->setTicker(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;

    move-result-object v0

    .line 337
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    invoke-virtual {v0, v2, v3}, Landroid/app/Notification$Builder;->setWhen(J)Landroid/app/Notification$Builder;

    move-result-object v0

    iget-object v1, p3, Lcom/mixpanel/android/mpmetrics/GCMReceiver$NotificationData;->d:Ljava/lang/CharSequence;

    .line 338
    invoke-virtual {v0, v1}, Landroid/app/Notification$Builder;->setContentTitle(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;

    move-result-object v0

    iget-object v1, p3, Lcom/mixpanel/android/mpmetrics/GCMReceiver$NotificationData;->e:Ljava/lang/String;

    .line 339
    invoke-virtual {v0, v1}, Landroid/app/Notification$Builder;->setContentText(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;

    move-result-object v0

    .line 340
    invoke-virtual {v0, p2}, Landroid/app/Notification$Builder;->setContentIntent(Landroid/app/PendingIntent;)Landroid/app/Notification$Builder;

    move-result-object v0

    .line 341
    invoke-static {p1}, Lcom/mixpanel/android/mpmetrics/MPConfig;->a(Landroid/content/Context;)Lcom/mixpanel/android/mpmetrics/MPConfig;

    move-result-object v1

    invoke-virtual {v1}, Lcom/mixpanel/android/mpmetrics/MPConfig;->r()I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/app/Notification$Builder;->setDefaults(I)Landroid/app/Notification$Builder;

    move-result-object v0

    .line 343
    iget v1, p3, Lcom/mixpanel/android/mpmetrics/GCMReceiver$NotificationData;->b:I

    const/4 v2, -0x1

    if-eq v1, v2, :cond_0

    .line 344
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    iget v2, p3, Lcom/mixpanel/android/mpmetrics/GCMReceiver$NotificationData;->b:I

    invoke-static {v1, v2}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/app/Notification$Builder;->setLargeIcon(Landroid/graphics/Bitmap;)Landroid/app/Notification$Builder;

    .line 347
    :cond_0
    invoke-virtual {v0}, Landroid/app/Notification$Builder;->getNotification()Landroid/app/Notification;

    move-result-object v0

    .line 348
    iget v1, v0, Landroid/app/Notification;->flags:I

    or-int/lit8 v1, v1, 0x10

    iput v1, v0, Landroid/app/Notification;->flags:I

    .line 349
    return-object v0
.end method

.method protected c(Landroid/content/Context;Landroid/app/PendingIntent;Lcom/mixpanel/android/mpmetrics/GCMReceiver$NotificationData;)Landroid/app/Notification;
    .locals 4
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "NewApi"
        }
    .end annotation

    .annotation build Landroid/annotation/TargetApi;
        value = 0x10
    .end annotation

    .prologue
    .line 355
    new-instance v0, Landroid/app/Notification$Builder;

    invoke-direct {v0, p1}, Landroid/app/Notification$Builder;-><init>(Landroid/content/Context;)V

    iget v1, p3, Lcom/mixpanel/android/mpmetrics/GCMReceiver$NotificationData;->a:I

    .line 356
    invoke-virtual {v0, v1}, Landroid/app/Notification$Builder;->setSmallIcon(I)Landroid/app/Notification$Builder;

    move-result-object v0

    iget-object v1, p3, Lcom/mixpanel/android/mpmetrics/GCMReceiver$NotificationData;->e:Ljava/lang/String;

    .line 357
    invoke-virtual {v0, v1}, Landroid/app/Notification$Builder;->setTicker(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;

    move-result-object v0

    .line 358
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    invoke-virtual {v0, v2, v3}, Landroid/app/Notification$Builder;->setWhen(J)Landroid/app/Notification$Builder;

    move-result-object v0

    iget-object v1, p3, Lcom/mixpanel/android/mpmetrics/GCMReceiver$NotificationData;->d:Ljava/lang/CharSequence;

    .line 359
    invoke-virtual {v0, v1}, Landroid/app/Notification$Builder;->setContentTitle(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;

    move-result-object v0

    iget-object v1, p3, Lcom/mixpanel/android/mpmetrics/GCMReceiver$NotificationData;->e:Ljava/lang/String;

    .line 360
    invoke-virtual {v0, v1}, Landroid/app/Notification$Builder;->setContentText(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;

    move-result-object v0

    .line 361
    invoke-virtual {v0, p2}, Landroid/app/Notification$Builder;->setContentIntent(Landroid/app/PendingIntent;)Landroid/app/Notification$Builder;

    move-result-object v0

    new-instance v1, Landroid/app/Notification$BigTextStyle;

    invoke-direct {v1}, Landroid/app/Notification$BigTextStyle;-><init>()V

    iget-object v2, p3, Lcom/mixpanel/android/mpmetrics/GCMReceiver$NotificationData;->e:Ljava/lang/String;

    .line 362
    invoke-virtual {v1, v2}, Landroid/app/Notification$BigTextStyle;->bigText(Ljava/lang/CharSequence;)Landroid/app/Notification$BigTextStyle;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/app/Notification$Builder;->setStyle(Landroid/app/Notification$Style;)Landroid/app/Notification$Builder;

    move-result-object v0

    .line 363
    invoke-static {p1}, Lcom/mixpanel/android/mpmetrics/MPConfig;->a(Landroid/content/Context;)Lcom/mixpanel/android/mpmetrics/MPConfig;

    move-result-object v1

    invoke-virtual {v1}, Lcom/mixpanel/android/mpmetrics/MPConfig;->r()I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/app/Notification$Builder;->setDefaults(I)Landroid/app/Notification$Builder;

    move-result-object v0

    .line 365
    iget v1, p3, Lcom/mixpanel/android/mpmetrics/GCMReceiver$NotificationData;->b:I

    const/4 v2, -0x1

    if-eq v1, v2, :cond_0

    .line 366
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    iget v2, p3, Lcom/mixpanel/android/mpmetrics/GCMReceiver$NotificationData;->b:I

    invoke-static {v1, v2}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/app/Notification$Builder;->setLargeIcon(Landroid/graphics/Bitmap;)Landroid/app/Notification$Builder;

    .line 369
    :cond_0
    invoke-virtual {v0}, Landroid/app/Notification$Builder;->build()Landroid/app/Notification;

    move-result-object v0

    .line 370
    iget v1, v0, Landroid/app/Notification;->flags:I

    or-int/lit8 v1, v1, 0x10

    iput v1, v0, Landroid/app/Notification;->flags:I

    .line 371
    return-object v0
.end method

.method protected d(Landroid/content/Context;Landroid/app/PendingIntent;Lcom/mixpanel/android/mpmetrics/GCMReceiver$NotificationData;)Landroid/app/Notification;
    .locals 5
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "NewApi"
        }
    .end annotation

    .annotation build Landroid/annotation/TargetApi;
        value = 0x15
    .end annotation

    .prologue
    const/4 v4, -0x1

    .line 377
    new-instance v0, Landroid/app/Notification$Builder;

    invoke-direct {v0, p1}, Landroid/app/Notification$Builder;-><init>(Landroid/content/Context;)V

    iget-object v1, p3, Lcom/mixpanel/android/mpmetrics/GCMReceiver$NotificationData;->e:Ljava/lang/String;

    .line 378
    invoke-virtual {v0, v1}, Landroid/app/Notification$Builder;->setTicker(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;

    move-result-object v0

    .line 379
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    invoke-virtual {v0, v2, v3}, Landroid/app/Notification$Builder;->setWhen(J)Landroid/app/Notification$Builder;

    move-result-object v0

    iget-object v1, p3, Lcom/mixpanel/android/mpmetrics/GCMReceiver$NotificationData;->d:Ljava/lang/CharSequence;

    .line 380
    invoke-virtual {v0, v1}, Landroid/app/Notification$Builder;->setContentTitle(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;

    move-result-object v0

    iget-object v1, p3, Lcom/mixpanel/android/mpmetrics/GCMReceiver$NotificationData;->e:Ljava/lang/String;

    .line 381
    invoke-virtual {v0, v1}, Landroid/app/Notification$Builder;->setContentText(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;

    move-result-object v0

    .line 382
    invoke-virtual {v0, p2}, Landroid/app/Notification$Builder;->setContentIntent(Landroid/app/PendingIntent;)Landroid/app/Notification$Builder;

    move-result-object v0

    new-instance v1, Landroid/app/Notification$BigTextStyle;

    invoke-direct {v1}, Landroid/app/Notification$BigTextStyle;-><init>()V

    iget-object v2, p3, Lcom/mixpanel/android/mpmetrics/GCMReceiver$NotificationData;->e:Ljava/lang/String;

    .line 383
    invoke-virtual {v1, v2}, Landroid/app/Notification$BigTextStyle;->bigText(Ljava/lang/CharSequence;)Landroid/app/Notification$BigTextStyle;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/app/Notification$Builder;->setStyle(Landroid/app/Notification$Style;)Landroid/app/Notification$Builder;

    move-result-object v0

    .line 384
    invoke-static {p1}, Lcom/mixpanel/android/mpmetrics/MPConfig;->a(Landroid/content/Context;)Lcom/mixpanel/android/mpmetrics/MPConfig;

    move-result-object v1

    invoke-virtual {v1}, Lcom/mixpanel/android/mpmetrics/MPConfig;->r()I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/app/Notification$Builder;->setDefaults(I)Landroid/app/Notification$Builder;

    move-result-object v0

    .line 386
    iget v1, p3, Lcom/mixpanel/android/mpmetrics/GCMReceiver$NotificationData;->c:I

    if-eq v1, v4, :cond_2

    .line 387
    iget v1, p3, Lcom/mixpanel/android/mpmetrics/GCMReceiver$NotificationData;->c:I

    invoke-virtual {v0, v1}, Landroid/app/Notification$Builder;->setSmallIcon(I)Landroid/app/Notification$Builder;

    .line 392
    :goto_0
    iget v1, p3, Lcom/mixpanel/android/mpmetrics/GCMReceiver$NotificationData;->b:I

    if-eq v1, v4, :cond_0

    .line 393
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    iget v2, p3, Lcom/mixpanel/android/mpmetrics/GCMReceiver$NotificationData;->b:I

    invoke-static {v1, v2}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/app/Notification$Builder;->setLargeIcon(Landroid/graphics/Bitmap;)Landroid/app/Notification$Builder;

    .line 396
    :cond_0
    iget v1, p3, Lcom/mixpanel/android/mpmetrics/GCMReceiver$NotificationData;->g:I

    if-eq v1, v4, :cond_1

    .line 397
    iget v1, p3, Lcom/mixpanel/android/mpmetrics/GCMReceiver$NotificationData;->g:I

    invoke-virtual {v0, v1}, Landroid/app/Notification$Builder;->setColor(I)Landroid/app/Notification$Builder;

    .line 400
    :cond_1
    invoke-virtual {v0}, Landroid/app/Notification$Builder;->build()Landroid/app/Notification;

    move-result-object v0

    .line 401
    iget v1, v0, Landroid/app/Notification;->flags:I

    or-int/lit8 v1, v1, 0x10

    iput v1, v0, Landroid/app/Notification;->flags:I

    .line 402
    return-object v0

    .line 389
    :cond_2
    iget v1, p3, Lcom/mixpanel/android/mpmetrics/GCMReceiver$NotificationData;->a:I

    invoke-virtual {v0, v1}, Landroid/app/Notification$Builder;->setSmallIcon(I)Landroid/app/Notification$Builder;

    goto :goto_0
.end method

.method protected e(Landroid/content/Context;Landroid/app/PendingIntent;Lcom/mixpanel/android/mpmetrics/GCMReceiver$NotificationData;)Landroid/app/Notification;
    .locals 7
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "NewApi"
        }
    .end annotation

    .annotation build Landroid/annotation/TargetApi;
        value = 0x1a
    .end annotation

    .prologue
    const/4 v6, 0x1

    const/4 v5, -0x1

    .line 408
    const-string v0, "notification"

    .line 409
    invoke-virtual {p1, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/NotificationManager;

    .line 411
    invoke-static {p1}, Lcom/mixpanel/android/mpmetrics/MPConfig;->a(Landroid/content/Context;)Lcom/mixpanel/android/mpmetrics/MPConfig;

    move-result-object v1

    invoke-virtual {v1}, Lcom/mixpanel/android/mpmetrics/MPConfig;->u()Ljava/lang/String;

    move-result-object v1

    .line 412
    invoke-static {p1}, Lcom/mixpanel/android/mpmetrics/MPConfig;->a(Landroid/content/Context;)Lcom/mixpanel/android/mpmetrics/MPConfig;

    move-result-object v2

    invoke-virtual {v2}, Lcom/mixpanel/android/mpmetrics/MPConfig;->v()Ljava/lang/String;

    move-result-object v2

    .line 413
    invoke-static {p1}, Lcom/mixpanel/android/mpmetrics/MPConfig;->a(Landroid/content/Context;)Lcom/mixpanel/android/mpmetrics/MPConfig;

    move-result-object v3

    invoke-virtual {v3}, Lcom/mixpanel/android/mpmetrics/MPConfig;->w()I

    move-result v3

    .line 415
    new-instance v4, Landroid/app/NotificationChannel;

    invoke-direct {v4, v1, v2, v3}, Landroid/app/NotificationChannel;-><init>(Ljava/lang/String;Ljava/lang/CharSequence;I)V

    .line 416
    invoke-static {p1}, Lcom/mixpanel/android/mpmetrics/MPConfig;->a(Landroid/content/Context;)Lcom/mixpanel/android/mpmetrics/MPConfig;

    move-result-object v2

    invoke-virtual {v2}, Lcom/mixpanel/android/mpmetrics/MPConfig;->r()I

    move-result v2

    .line 417
    const/4 v3, 0x2

    if-eq v2, v3, :cond_0

    if-ne v2, v5, :cond_1

    .line 418
    :cond_0
    invoke-virtual {v4, v6}, Landroid/app/NotificationChannel;->enableVibration(Z)V

    .line 420
    :cond_1
    const/4 v3, 0x4

    if-eq v2, v3, :cond_2

    if-ne v2, v5, :cond_3

    .line 421
    :cond_2
    invoke-virtual {v4, v6}, Landroid/app/NotificationChannel;->enableLights(Z)V

    .line 422
    invoke-virtual {v4, v5}, Landroid/app/NotificationChannel;->setLightColor(I)V

    .line 424
    :cond_3
    invoke-virtual {v0, v4}, Landroid/app/NotificationManager;->createNotificationChannel(Landroid/app/NotificationChannel;)V

    .line 426
    new-instance v0, Landroid/app/Notification$Builder;

    invoke-direct {v0, p1}, Landroid/app/Notification$Builder;-><init>(Landroid/content/Context;)V

    iget-object v2, p3, Lcom/mixpanel/android/mpmetrics/GCMReceiver$NotificationData;->e:Ljava/lang/String;

    .line 427
    invoke-virtual {v0, v2}, Landroid/app/Notification$Builder;->setTicker(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;

    move-result-object v0

    .line 428
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    invoke-virtual {v0, v2, v3}, Landroid/app/Notification$Builder;->setWhen(J)Landroid/app/Notification$Builder;

    move-result-object v0

    iget-object v2, p3, Lcom/mixpanel/android/mpmetrics/GCMReceiver$NotificationData;->d:Ljava/lang/CharSequence;

    .line 429
    invoke-virtual {v0, v2}, Landroid/app/Notification$Builder;->setContentTitle(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;

    move-result-object v0

    iget-object v2, p3, Lcom/mixpanel/android/mpmetrics/GCMReceiver$NotificationData;->e:Ljava/lang/String;

    .line 430
    invoke-virtual {v0, v2}, Landroid/app/Notification$Builder;->setContentText(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;

    move-result-object v0

    .line 431
    invoke-virtual {v0, p2}, Landroid/app/Notification$Builder;->setContentIntent(Landroid/app/PendingIntent;)Landroid/app/Notification$Builder;

    move-result-object v0

    new-instance v2, Landroid/app/Notification$BigTextStyle;

    invoke-direct {v2}, Landroid/app/Notification$BigTextStyle;-><init>()V

    iget-object v3, p3, Lcom/mixpanel/android/mpmetrics/GCMReceiver$NotificationData;->e:Ljava/lang/String;

    .line 432
    invoke-virtual {v2, v3}, Landroid/app/Notification$BigTextStyle;->bigText(Ljava/lang/CharSequence;)Landroid/app/Notification$BigTextStyle;

    move-result-object v2

    invoke-virtual {v0, v2}, Landroid/app/Notification$Builder;->setStyle(Landroid/app/Notification$Style;)Landroid/app/Notification$Builder;

    move-result-object v0

    .line 433
    invoke-virtual {v0, v1}, Landroid/app/Notification$Builder;->setChannelId(Ljava/lang/String;)Landroid/app/Notification$Builder;

    move-result-object v0

    .line 435
    iget v1, p3, Lcom/mixpanel/android/mpmetrics/GCMReceiver$NotificationData;->c:I

    if-eq v1, v5, :cond_6

    .line 436
    iget v1, p3, Lcom/mixpanel/android/mpmetrics/GCMReceiver$NotificationData;->c:I

    invoke-virtual {v0, v1}, Landroid/app/Notification$Builder;->setSmallIcon(I)Landroid/app/Notification$Builder;

    .line 441
    :goto_0
    iget v1, p3, Lcom/mixpanel/android/mpmetrics/GCMReceiver$NotificationData;->b:I

    if-eq v1, v5, :cond_4

    .line 442
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    iget v2, p3, Lcom/mixpanel/android/mpmetrics/GCMReceiver$NotificationData;->b:I

    invoke-static {v1, v2}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/app/Notification$Builder;->setLargeIcon(Landroid/graphics/Bitmap;)Landroid/app/Notification$Builder;

    .line 445
    :cond_4
    iget v1, p3, Lcom/mixpanel/android/mpmetrics/GCMReceiver$NotificationData;->g:I

    if-eq v1, v5, :cond_5

    .line 446
    iget v1, p3, Lcom/mixpanel/android/mpmetrics/GCMReceiver$NotificationData;->g:I

    invoke-virtual {v0, v1}, Landroid/app/Notification$Builder;->setColor(I)Landroid/app/Notification$Builder;

    .line 449
    :cond_5
    invoke-virtual {v0}, Landroid/app/Notification$Builder;->build()Landroid/app/Notification;

    move-result-object v0

    .line 450
    iget v1, v0, Landroid/app/Notification;->flags:I

    or-int/lit8 v1, v1, 0x10

    iput v1, v0, Landroid/app/Notification;->flags:I

    .line 451
    return-object v0

    .line 438
    :cond_6
    iget v1, p3, Lcom/mixpanel/android/mpmetrics/GCMReceiver$NotificationData;->a:I

    invoke-virtual {v0, v1}, Landroid/app/Notification$Builder;->setSmallIcon(I)Landroid/app/Notification$Builder;

    goto :goto_0
.end method

.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 2

    .prologue
    .line 101
    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    .line 102
    const-string v1, "com.google.android.c2dm.intent.REGISTRATION"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 103
    invoke-direct {p0, p2}, Lcom/mixpanel/android/mpmetrics/GCMReceiver;->a(Landroid/content/Intent;)V

    .line 107
    :cond_0
    :goto_0
    return-void

    .line 104
    :cond_1
    const-string v1, "com.google.android.c2dm.intent.RECEIVE"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 105
    invoke-direct {p0, p1, p2}, Lcom/mixpanel/android/mpmetrics/GCMReceiver;->a(Landroid/content/Context;Landroid/content/Intent;)V

    goto :goto_0
.end method
