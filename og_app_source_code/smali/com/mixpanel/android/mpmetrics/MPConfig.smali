.class public Lcom/mixpanel/android/mpmetrics/MPConfig;
.super Ljava/lang/Object;
.source "MPConfig.java"


# static fields
.field private static D:Lcom/mixpanel/android/mpmetrics/MPConfig;

.field private static final E:Ljava/lang/Object;

.field public static a:Z


# instance fields
.field private final A:Ljava/lang/String;

.field private B:Ljavax/net/ssl/SSLSocketFactory;

.field private C:Lcom/mixpanel/android/util/OfflineMode;

.field private final b:I

.field private final c:I

.field private final d:I

.field private final e:I

.field private final f:Z

.field private final g:Z

.field private final h:Z

.field private final i:Z

.field private final j:Z

.field private final k:[Ljava/lang/String;

.field private final l:Ljava/lang/String;

.field private final m:Ljava/lang/String;

.field private final n:Ljava/lang/String;

.field private final o:Z

.field private final p:Ljava/lang/String;

.field private final q:Ljava/lang/String;

.field private final r:Z

.field private final s:I

.field private final t:Z

.field private final u:I

.field private final v:I

.field private final w:I

.field private final x:Z

.field private final y:I

.field private final z:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 120
    const/4 v0, 0x0

    sput-boolean v0, Lcom/mixpanel/android/mpmetrics/MPConfig;->a:Z

    .line 491
    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    sput-object v0, Lcom/mixpanel/android/mpmetrics/MPConfig;->E:Ljava/lang/Object;

    return-void
.end method

.method constructor <init>(Landroid/os/Bundle;Landroid/content/Context;)V
    .locals 8

    .prologue
    const/4 v7, -0x1

    const/4 v6, 0x1

    const/4 v0, 0x0

    const/4 v5, 0x0

    .line 199
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 205
    :try_start_0
    const-string v1, "TLS"

    invoke-static {v1}, Ljavax/net/ssl/SSLContext;->getInstance(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;

    move-result-object v1

    .line 206
    const/4 v2, 0x0

    const/4 v3, 0x0

    const/4 v4, 0x0

    invoke-virtual {v1, v2, v3, v4}, Ljavax/net/ssl/SSLContext;->init([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V

    .line 207
    invoke-virtual {v1}, Ljavax/net/ssl/SSLContext;->getSocketFactory()Ljavax/net/ssl/SSLSocketFactory;
    :try_end_0
    .catch Ljava/security/GeneralSecurityException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 212
    :goto_0
    iput-object v0, p0, Lcom/mixpanel/android/mpmetrics/MPConfig;->B:Ljavax/net/ssl/SSLSocketFactory;

    .line 214
    const-string v0, "com.mixpanel.android.MPConfig.EnableDebugLogging"

    invoke-virtual {p1, v0, v5}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    sput-boolean v0, Lcom/mixpanel/android/mpmetrics/MPConfig;->a:Z

    .line 215
    sget-boolean v0, Lcom/mixpanel/android/mpmetrics/MPConfig;->a:Z

    if-eqz v0, :cond_0

    .line 216
    const/4 v0, 0x2

    invoke-static {v0}, Lcom/mixpanel/android/util/MPLog;->a(I)V

    .line 219
    :cond_0
    const-string v0, "com.mixpanel.android.MPConfig.DebugFlushInterval"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 220
    const-string v0, "MixpanelAPI.Conf"

    const-string v1, "We do not support com.mixpanel.android.MPConfig.DebugFlushInterval anymore. There will only be one flush interval. Please, update your AndroidManifest.xml."

    invoke-static {v0, v1}, Lcom/mixpanel/android/util/MPLog;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 223
    :cond_1
    const-string v0, "com.mixpanel.android.MPConfig.BulkUploadLimit"

    const/16 v1, 0x28

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v0

    iput v0, p0, Lcom/mixpanel/android/mpmetrics/MPConfig;->b:I

    .line 224
    const-string v0, "com.mixpanel.android.MPConfig.FlushInterval"

    const v1, 0xea60

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v0

    iput v0, p0, Lcom/mixpanel/android/mpmetrics/MPConfig;->c:I

    .line 225
    const-string v0, "com.mixpanel.android.MPConfig.DataExpiration"

    const v1, 0x19bfcc00

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v0

    iput v0, p0, Lcom/mixpanel/android/mpmetrics/MPConfig;->d:I

    .line 226
    const-string v0, "com.mixpanel.android.MPConfig.MinimumDatabaseLimit"

    const/high16 v1, 0x1400000

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v0

    iput v0, p0, Lcom/mixpanel/android/mpmetrics/MPConfig;->e:I

    .line 227
    const-string v0, "com.mixpanel.android.MPConfig.ResourcePackageName"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/mixpanel/android/mpmetrics/MPConfig;->q:Ljava/lang/String;

    .line 228
    const-string v0, "com.mixpanel.android.MPConfig.DisableGestureBindingUI"

    invoke-virtual {p1, v0, v5}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    iput-boolean v0, p0, Lcom/mixpanel/android/mpmetrics/MPConfig;->g:Z

    .line 229
    const-string v0, "com.mixpanel.android.MPConfig.DisableEmulatorBindingUI"

    invoke-virtual {p1, v0, v5}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    iput-boolean v0, p0, Lcom/mixpanel/android/mpmetrics/MPConfig;->h:Z

    .line 230
    const-string v0, "com.mixpanel.android.MPConfig.DisableAppOpenEvent"

    invoke-virtual {p1, v0, v6}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    iput-boolean v0, p0, Lcom/mixpanel/android/mpmetrics/MPConfig;->i:Z

    .line 231
    const-string v0, "com.mixpanel.android.MPConfig.DisableViewCrawler"

    invoke-virtual {p1, v0, v5}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    iput-boolean v0, p0, Lcom/mixpanel/android/mpmetrics/MPConfig;->j:Z

    .line 232
    const-string v0, "com.mixpanel.android.MPConfig.DisableDecideChecker"

    invoke-virtual {p1, v0, v5}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    iput-boolean v0, p0, Lcom/mixpanel/android/mpmetrics/MPConfig;->r:Z

    .line 233
    const-string v0, "com.mixpanel.android.MPConfig.ImageCacheMaxMemoryFactor"

    const/16 v1, 0xa

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v0

    iput v0, p0, Lcom/mixpanel/android/mpmetrics/MPConfig;->s:I

    .line 234
    const-string v0, "com.mixpanel.android.MPConfig.IgnoreInvisibleViewsVisualEditor"

    invoke-virtual {p1, v0, v5}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    iput-boolean v0, p0, Lcom/mixpanel/android/mpmetrics/MPConfig;->t:Z

    .line 235
    const-string v0, "com.mixpanel.android.MPConfig.AutoShowMixpanelUpdates"

    invoke-virtual {p1, v0, v6}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    iput-boolean v0, p0, Lcom/mixpanel/android/mpmetrics/MPConfig;->o:Z

    .line 236
    const-string v0, "com.mixpanel.android.MPConfig.NotificationDefaults"

    invoke-virtual {p1, v0, v5}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v0

    iput v0, p0, Lcom/mixpanel/android/mpmetrics/MPConfig;->u:I

    .line 237
    const-string v0, "com.mixpanel.android.MPConfig.MinimumSessionDuration"

    const/16 v1, 0x2710

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v0

    iput v0, p0, Lcom/mixpanel/android/mpmetrics/MPConfig;->v:I

    .line 238
    const-string v0, "com.mixpanel.android.MPConfig.SessionTimeoutDuration"

    const v1, 0x7fffffff

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v0

    iput v0, p0, Lcom/mixpanel/android/mpmetrics/MPConfig;->w:I

    .line 239
    const-string v0, "com.mixpanel.android.MPConfig.UseIpAddressForGeolocation"

    invoke-virtual {p1, v0, v6}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    iput-boolean v0, p0, Lcom/mixpanel/android/mpmetrics/MPConfig;->x:Z

    .line 240
    const-string v0, "com.mixpanel.android.MPConfig.TestMode"

    invoke-virtual {p1, v0, v5}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    iput-boolean v0, p0, Lcom/mixpanel/android/mpmetrics/MPConfig;->f:Z

    .line 241
    const-string v0, "com.mixpanel.android.MPConfig.NotificationChannelImportance"

    const/4 v1, 0x3

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v0

    iput v0, p0, Lcom/mixpanel/android/mpmetrics/MPConfig;->y:I

    .line 243
    const-string v0, "com.mixpanel.android.MPConfig.NotificationChannelId"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 244
    if-nez v0, :cond_2

    .line 245
    const-string v0, "mp"

    .line 247
    :cond_2
    iput-object v0, p0, Lcom/mixpanel/android/mpmetrics/MPConfig;->z:Ljava/lang/String;

    .line 249
    const-string v0, "com.mixpanel.android.MPConfig.NotificationChannelName"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 250
    if-nez v0, :cond_3

    .line 251
    invoke-static {p2}, Lcom/mixpanel/android/mpmetrics/SystemInformation;->a(Landroid/content/Context;)Lcom/mixpanel/android/mpmetrics/SystemInformation;

    move-result-object v0

    invoke-virtual {v0}, Lcom/mixpanel/android/mpmetrics/SystemInformation;->c()Ljava/lang/String;

    move-result-object v0

    .line 253
    :cond_3
    iput-object v0, p0, Lcom/mixpanel/android/mpmetrics/MPConfig;->A:Ljava/lang/String;

    .line 255
    const-string v0, "com.mixpanel.android.MPConfig.EventsEndpoint"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 256
    if-nez v0, :cond_4

    .line 257
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "https://api.mixpanel.com/track?ip="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-boolean v0, p0, Lcom/mixpanel/android/mpmetrics/MPConfig;->x:Z

    if-eqz v0, :cond_8

    const-string v0, "1"

    :goto_1
    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 259
    :cond_4
    iput-object v0, p0, Lcom/mixpanel/android/mpmetrics/MPConfig;->l:Ljava/lang/String;

    .line 261
    const-string v0, "com.mixpanel.android.MPConfig.PeopleEndpoint"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 262
    if-nez v0, :cond_5

    .line 263
    const-string v0, "https://api.mixpanel.com/engage"

    .line 265
    :cond_5
    iput-object v0, p0, Lcom/mixpanel/android/mpmetrics/MPConfig;->m:Ljava/lang/String;

    .line 267
    const-string v0, "com.mixpanel.android.MPConfig.DecideEndpoint"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 268
    if-nez v0, :cond_6

    .line 269
    const-string v0, "https://decide.mixpanel.com/decide"

    .line 271
    :cond_6
    iput-object v0, p0, Lcom/mixpanel/android/mpmetrics/MPConfig;->n:Ljava/lang/String;

    .line 273
    const-string v0, "com.mixpanel.android.MPConfig.EditorUrl"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 274
    if-nez v0, :cond_7

    .line 275
    const-string v0, "wss://switchboard.mixpanel.com/connect/"

    .line 277
    :cond_7
    iput-object v0, p0, Lcom/mixpanel/android/mpmetrics/MPConfig;->p:Ljava/lang/String;

    .line 279
    const-string v0, "com.mixpanel.android.MPConfig.DisableViewCrawlerForProjects"

    invoke-virtual {p1, v0, v7}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v0

    .line 280
    if-eq v0, v7, :cond_9

    .line 281
    invoke-virtual {p2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/content/res/Resources;->getStringArray(I)[Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/mixpanel/android/mpmetrics/MPConfig;->k:[Ljava/lang/String;

    .line 286
    :goto_2
    const-string v0, "MixpanelAPI.Conf"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Mixpanel (5.2.1) configured with:\n    AutoShowMixpanelUpdates "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 288
    invoke-virtual {p0}, Lcom/mixpanel/android/mpmetrics/MPConfig;->n()Z

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\n    BulkUploadLimit "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 289
    invoke-virtual {p0}, Lcom/mixpanel/android/mpmetrics/MPConfig;->a()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\n    FlushInterval "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 290
    invoke-virtual {p0}, Lcom/mixpanel/android/mpmetrics/MPConfig;->b()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\n    DataExpiration "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 291
    invoke-virtual {p0}, Lcom/mixpanel/android/mpmetrics/MPConfig;->c()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\n    MinimumDatabaseLimit "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 292
    invoke-virtual {p0}, Lcom/mixpanel/android/mpmetrics/MPConfig;->d()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\n    DisableAppOpenEvent "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 293
    invoke-virtual {p0}, Lcom/mixpanel/android/mpmetrics/MPConfig;->g()Z

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\n    DisableViewCrawler "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 294
    invoke-virtual {p0}, Lcom/mixpanel/android/mpmetrics/MPConfig;->h()Z

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\n    DisableGestureBindingUI "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 295
    invoke-virtual {p0}, Lcom/mixpanel/android/mpmetrics/MPConfig;->e()Z

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\n    DisableEmulatorBindingUI "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 296
    invoke-virtual {p0}, Lcom/mixpanel/android/mpmetrics/MPConfig;->f()Z

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\n    EnableDebugLogging "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    sget-boolean v2, Lcom/mixpanel/android/mpmetrics/MPConfig;->a:Z

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\n    TestMode "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 298
    invoke-virtual {p0}, Lcom/mixpanel/android/mpmetrics/MPConfig;->j()Z

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\n    EventsEndpoint "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 299
    invoke-virtual {p0}, Lcom/mixpanel/android/mpmetrics/MPConfig;->k()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\n    PeopleEndpoint "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 300
    invoke-virtual {p0}, Lcom/mixpanel/android/mpmetrics/MPConfig;->l()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\n    DecideEndpoint "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 301
    invoke-virtual {p0}, Lcom/mixpanel/android/mpmetrics/MPConfig;->m()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\n    EditorUrl "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 302
    invoke-virtual {p0}, Lcom/mixpanel/android/mpmetrics/MPConfig;->o()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\n    ImageCacheMaxMemoryFactor "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 303
    invoke-virtual {p0}, Lcom/mixpanel/android/mpmetrics/MPConfig;->A()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\n    DisableDecideChecker "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 304
    invoke-virtual {p0}, Lcom/mixpanel/android/mpmetrics/MPConfig;->p()Z

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\n    IgnoreInvisibleViewsEditor "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 305
    invoke-virtual {p0}, Lcom/mixpanel/android/mpmetrics/MPConfig;->q()Z

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\n    NotificationDefaults "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 306
    invoke-virtual {p0}, Lcom/mixpanel/android/mpmetrics/MPConfig;->r()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\n    MinimumSessionDuration: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 307
    invoke-virtual {p0}, Lcom/mixpanel/android/mpmetrics/MPConfig;->s()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\n    SessionTimeoutDuration: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 308
    invoke-virtual {p0}, Lcom/mixpanel/android/mpmetrics/MPConfig;->t()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\n    NotificationChannelId: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 309
    invoke-virtual {p0}, Lcom/mixpanel/android/mpmetrics/MPConfig;->u()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\n    NotificationChannelName: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 310
    invoke-virtual {p0}, Lcom/mixpanel/android/mpmetrics/MPConfig;->v()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\n    NotificationChannelImportance: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 311
    invoke-virtual {p0}, Lcom/mixpanel/android/mpmetrics/MPConfig;->w()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 286
    invoke-static {v0, v1}, Lcom/mixpanel/android/util/MPLog;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 313
    return-void

    .line 208
    :catch_0
    move-exception v1

    .line 209
    const-string v2, "MixpanelAPI.Conf"

    const-string v3, "System has no SSL support. Built-in events editor will not be available"

    invoke-static {v2, v3, v1}, Lcom/mixpanel/android/util/MPLog;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto/16 :goto_0

    .line 257
    :cond_8
    const-string v0, "0"

    goto/16 :goto_1

    .line 283
    :cond_9
    new-array v0, v5, [Ljava/lang/String;

    iput-object v0, p0, Lcom/mixpanel/android/mpmetrics/MPConfig;->k:[Ljava/lang/String;

    goto/16 :goto_2
.end method

.method public static a(Landroid/content/Context;)Lcom/mixpanel/android/mpmetrics/MPConfig;
    .locals 2

    .prologue
    .line 137
    sget-object v1, Lcom/mixpanel/android/mpmetrics/MPConfig;->E:Ljava/lang/Object;

    monitor-enter v1

    .line 138
    :try_start_0
    sget-object v0, Lcom/mixpanel/android/mpmetrics/MPConfig;->D:Lcom/mixpanel/android/mpmetrics/MPConfig;

    if-nez v0, :cond_0

    .line 139
    invoke-virtual {p0}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    .line 140
    invoke-static {v0}, Lcom/mixpanel/android/mpmetrics/MPConfig;->b(Landroid/content/Context;)Lcom/mixpanel/android/mpmetrics/MPConfig;

    move-result-object v0

    sput-object v0, Lcom/mixpanel/android/mpmetrics/MPConfig;->D:Lcom/mixpanel/android/mpmetrics/MPConfig;

    .line 142
    :cond_0
    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 144
    sget-object v0, Lcom/mixpanel/android/mpmetrics/MPConfig;->D:Lcom/mixpanel/android/mpmetrics/MPConfig;

    return-object v0

    .line 142
    :catchall_0
    move-exception v0

    :try_start_1
    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0
.end method

.method static b(Landroid/content/Context;)Lcom/mixpanel/android/mpmetrics/MPConfig;
    .locals 5

    .prologue
    .line 446
    invoke-virtual {p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v1

    .line 448
    :try_start_0
    invoke-virtual {p0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v0

    const/16 v2, 0x80

    invoke-virtual {v0, v1, v2}, Landroid/content/pm/PackageManager;->getApplicationInfo(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;

    move-result-object v0

    .line 449
    iget-object v0, v0, Landroid/content/pm/ApplicationInfo;->metaData:Landroid/os/Bundle;

    .line 450
    if-nez v0, :cond_0

    .line 451
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 453
    :cond_0
    new-instance v2, Lcom/mixpanel/android/mpmetrics/MPConfig;

    invoke-direct {v2, v0, p0}, Lcom/mixpanel/android/mpmetrics/MPConfig;-><init>(Landroid/os/Bundle;Landroid/content/Context;)V
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    return-object v2

    .line 454
    :catch_0
    move-exception v0

    .line 455
    new-instance v2, Ljava/lang/RuntimeException;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Can\'t configure Mixpanel with package name "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v2, v1, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v2
.end method


# virtual methods
.method public A()I
    .locals 1

    .prologue
    .line 439
    iget v0, p0, Lcom/mixpanel/android/mpmetrics/MPConfig;->s:I

    return v0
.end method

.method public a()I
    .locals 1

    .prologue
    .line 317
    iget v0, p0, Lcom/mixpanel/android/mpmetrics/MPConfig;->b:I

    return v0
.end method

.method public b()I
    .locals 1

    .prologue
    .line 322
    iget v0, p0, Lcom/mixpanel/android/mpmetrics/MPConfig;->c:I

    return v0
.end method

.method public c()I
    .locals 1

    .prologue
    .line 327
    iget v0, p0, Lcom/mixpanel/android/mpmetrics/MPConfig;->d:I

    return v0
.end method

.method public d()I
    .locals 1

    .prologue
    .line 330
    iget v0, p0, Lcom/mixpanel/android/mpmetrics/MPConfig;->e:I

    return v0
.end method

.method public e()Z
    .locals 1

    .prologue
    .line 333
    iget-boolean v0, p0, Lcom/mixpanel/android/mpmetrics/MPConfig;->g:Z

    return v0
.end method

.method public f()Z
    .locals 1

    .prologue
    .line 337
    iget-boolean v0, p0, Lcom/mixpanel/android/mpmetrics/MPConfig;->h:Z

    return v0
.end method

.method public g()Z
    .locals 1

    .prologue
    .line 341
    iget-boolean v0, p0, Lcom/mixpanel/android/mpmetrics/MPConfig;->i:Z

    return v0
.end method

.method public h()Z
    .locals 1

    .prologue
    .line 345
    iget-boolean v0, p0, Lcom/mixpanel/android/mpmetrics/MPConfig;->j:Z

    return v0
.end method

.method public i()[Ljava/lang/String;
    .locals 1

    .prologue
    .line 348
    iget-object v0, p0, Lcom/mixpanel/android/mpmetrics/MPConfig;->k:[Ljava/lang/String;

    return-object v0
.end method

.method public j()Z
    .locals 1

    .prologue
    .line 351
    iget-boolean v0, p0, Lcom/mixpanel/android/mpmetrics/MPConfig;->f:Z

    return v0
.end method

.method public k()Ljava/lang/String;
    .locals 1

    .prologue
    .line 356
    iget-object v0, p0, Lcom/mixpanel/android/mpmetrics/MPConfig;->l:Ljava/lang/String;

    return-object v0
.end method

.method public l()Ljava/lang/String;
    .locals 1

    .prologue
    .line 361
    iget-object v0, p0, Lcom/mixpanel/android/mpmetrics/MPConfig;->m:Ljava/lang/String;

    return-object v0
.end method

.method public m()Ljava/lang/String;
    .locals 1

    .prologue
    .line 366
    iget-object v0, p0, Lcom/mixpanel/android/mpmetrics/MPConfig;->n:Ljava/lang/String;

    return-object v0
.end method

.method public n()Z
    .locals 1

    .prologue
    .line 371
    iget-boolean v0, p0, Lcom/mixpanel/android/mpmetrics/MPConfig;->o:Z

    return v0
.end method

.method public o()Ljava/lang/String;
    .locals 1

    .prologue
    .line 376
    iget-object v0, p0, Lcom/mixpanel/android/mpmetrics/MPConfig;->p:Ljava/lang/String;

    return-object v0
.end method

.method public p()Z
    .locals 1

    .prologue
    .line 380
    iget-boolean v0, p0, Lcom/mixpanel/android/mpmetrics/MPConfig;->r:Z

    return v0
.end method

.method public q()Z
    .locals 1

    .prologue
    .line 384
    iget-boolean v0, p0, Lcom/mixpanel/android/mpmetrics/MPConfig;->t:Z

    return v0
.end method

.method public r()I
    .locals 1

    .prologue
    .line 388
    iget v0, p0, Lcom/mixpanel/android/mpmetrics/MPConfig;->u:I

    return v0
.end method

.method public s()I
    .locals 1

    .prologue
    .line 392
    iget v0, p0, Lcom/mixpanel/android/mpmetrics/MPConfig;->v:I

    return v0
.end method

.method public t()I
    .locals 1

    .prologue
    .line 396
    iget v0, p0, Lcom/mixpanel/android/mpmetrics/MPConfig;->w:I

    return v0
.end method

.method public u()Ljava/lang/String;
    .locals 1

    .prologue
    .line 400
    iget-object v0, p0, Lcom/mixpanel/android/mpmetrics/MPConfig;->z:Ljava/lang/String;

    return-object v0
.end method

.method public v()Ljava/lang/String;
    .locals 1

    .prologue
    .line 404
    iget-object v0, p0, Lcom/mixpanel/android/mpmetrics/MPConfig;->A:Ljava/lang/String;

    return-object v0
.end method

.method public w()I
    .locals 1

    .prologue
    .line 408
    iget v0, p0, Lcom/mixpanel/android/mpmetrics/MPConfig;->y:I

    return v0
.end method

.method public x()Ljava/lang/String;
    .locals 1

    .prologue
    .line 422
    iget-object v0, p0, Lcom/mixpanel/android/mpmetrics/MPConfig;->q:Ljava/lang/String;

    return-object v0
.end method

.method public declared-synchronized y()Ljavax/net/ssl/SSLSocketFactory;
    .locals 1

    .prologue
    .line 429
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/mixpanel/android/mpmetrics/MPConfig;->B:Ljavax/net/ssl/SSLSocketFactory;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized z()Lcom/mixpanel/android/util/OfflineMode;
    .locals 1

    .prologue
    .line 434
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/mixpanel/android/mpmetrics/MPConfig;->C:Lcom/mixpanel/android/util/OfflineMode;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method
