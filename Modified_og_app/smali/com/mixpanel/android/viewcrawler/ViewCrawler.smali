.class public Lcom/mixpanel/android/viewcrawler/ViewCrawler;
.super Ljava/lang/Object;
.source "ViewCrawler.java"

# interfaces
.implements Lcom/mixpanel/android/viewcrawler/TrackingDebug;
.implements Lcom/mixpanel/android/viewcrawler/UpdatesFromMixpanel;
.implements Lcom/mixpanel/android/viewcrawler/ViewVisitor$OnLayoutErrorListener;


# annotations
.annotation build Landroid/annotation/TargetApi;
    value = 0x10
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/mixpanel/android/viewcrawler/ViewCrawler$VariantTweak;,
        Lcom/mixpanel/android/viewcrawler/ViewCrawler$VariantChange;,
        Lcom/mixpanel/android/viewcrawler/ViewCrawler$Editor;,
        Lcom/mixpanel/android/viewcrawler/ViewCrawler$ViewCrawlerHandler;,
        Lcom/mixpanel/android/viewcrawler/ViewCrawler$LifecycleCallbacks;,
        Lcom/mixpanel/android/viewcrawler/ViewCrawler$EmulatorConnector;
    }
.end annotation


# instance fields
.field private final a:Lcom/mixpanel/android/mpmetrics/MPConfig;

.field private final b:Landroid/content/Context;

.field private final c:Lcom/mixpanel/android/mpmetrics/MixpanelAPI;

.field private final d:Lcom/mixpanel/android/viewcrawler/DynamicEventTracker;

.field private final e:Lcom/mixpanel/android/viewcrawler/EditState;

.field private final f:Lcom/mixpanel/android/mpmetrics/Tweaks;

.field private final g:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private final h:Lcom/mixpanel/android/viewcrawler/ViewCrawler$ViewCrawlerHandler;

.field private final i:F

.field private final j:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Lcom/mixpanel/android/mpmetrics/OnMixpanelTweaksUpdatedListener;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/content/Context;Ljava/lang/String;Lcom/mixpanel/android/mpmetrics/MixpanelAPI;Lcom/mixpanel/android/mpmetrics/Tweaks;)V
    .locals 6

    .prologue
    .line 63
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 64
    invoke-static {p1}, Lcom/mixpanel/android/mpmetrics/MPConfig;->a(Landroid/content/Context;)Lcom/mixpanel/android/mpmetrics/MPConfig;

    move-result-object v0

    iput-object v0, p0, Lcom/mixpanel/android/viewcrawler/ViewCrawler;->a:Lcom/mixpanel/android/mpmetrics/MPConfig;

    .line 66
    iput-object p1, p0, Lcom/mixpanel/android/viewcrawler/ViewCrawler;->b:Landroid/content/Context;

    .line 67
    new-instance v0, Lcom/mixpanel/android/viewcrawler/EditState;

    invoke-direct {v0}, Lcom/mixpanel/android/viewcrawler/EditState;-><init>()V

    iput-object v0, p0, Lcom/mixpanel/android/viewcrawler/ViewCrawler;->e:Lcom/mixpanel/android/viewcrawler/EditState;

    .line 68
    iput-object p4, p0, Lcom/mixpanel/android/viewcrawler/ViewCrawler;->f:Lcom/mixpanel/android/mpmetrics/Tweaks;

    .line 69
    invoke-virtual {p3}, Lcom/mixpanel/android/mpmetrics/MixpanelAPI;->e()Ljava/util/Map;

    move-result-object v0

    iput-object v0, p0, Lcom/mixpanel/android/viewcrawler/ViewCrawler;->g:Ljava/util/Map;

    .line 70
    invoke-static {}, Landroid/content/res/Resources;->getSystem()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v0

    iget v0, v0, Landroid/util/DisplayMetrics;->scaledDensity:F

    iput v0, p0, Lcom/mixpanel/android/viewcrawler/ViewCrawler;->i:F

    .line 71
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;

    invoke-direct {v0}, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V

    invoke-static {v0}, Ljava/util/Collections;->newSetFromMap(Ljava/util/Map;)Ljava/util/Set;

    move-result-object v0

    iput-object v0, p0, Lcom/mixpanel/android/viewcrawler/ViewCrawler;->j:Ljava/util/Set;

    .line 73
    new-instance v1, Landroid/os/HandlerThread;

    const-class v0, Lcom/mixpanel/android/viewcrawler/ViewCrawler;

    invoke-virtual {v0}, Ljava/lang/Class;->getCanonicalName()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v1, v0}, Landroid/os/HandlerThread;-><init>(Ljava/lang/String;)V

    .line 74
    const/16 v0, 0xa

    invoke-virtual {v1, v0}, Landroid/os/HandlerThread;->setPriority(I)V

    .line 75
    invoke-virtual {v1}, Landroid/os/HandlerThread;->start()V

    .line 76
    new-instance v0, Lcom/mixpanel/android/viewcrawler/ViewCrawler$ViewCrawlerHandler;

    invoke-virtual {v1}, Landroid/os/HandlerThread;->getLooper()Landroid/os/Looper;

    move-result-object v4

    move-object v1, p0

    move-object v2, p1

    move-object v3, p2

    move-object v5, p0

    invoke-direct/range {v0 .. v5}, Lcom/mixpanel/android/viewcrawler/ViewCrawler$ViewCrawlerHandler;-><init>(Lcom/mixpanel/android/viewcrawler/ViewCrawler;Landroid/content/Context;Ljava/lang/String;Landroid/os/Looper;Lcom/mixpanel/android/viewcrawler/ViewVisitor$OnLayoutErrorListener;)V

    iput-object v0, p0, Lcom/mixpanel/android/viewcrawler/ViewCrawler;->h:Lcom/mixpanel/android/viewcrawler/ViewCrawler$ViewCrawlerHandler;

    .line 78
    new-instance v0, Lcom/mixpanel/android/viewcrawler/DynamicEventTracker;

    iget-object v1, p0, Lcom/mixpanel/android/viewcrawler/ViewCrawler;->h:Lcom/mixpanel/android/viewcrawler/ViewCrawler$ViewCrawlerHandler;

    invoke-direct {v0, p3, v1}, Lcom/mixpanel/android/viewcrawler/DynamicEventTracker;-><init>(Lcom/mixpanel/android/mpmetrics/MixpanelAPI;Landroid/os/Handler;)V

    iput-object v0, p0, Lcom/mixpanel/android/viewcrawler/ViewCrawler;->d:Lcom/mixpanel/android/viewcrawler/DynamicEventTracker;

    .line 79
    iput-object p3, p0, Lcom/mixpanel/android/viewcrawler/ViewCrawler;->c:Lcom/mixpanel/android/mpmetrics/MixpanelAPI;

    .line 81
    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    check-cast v0, Landroid/app/Application;

    .line 82
    new-instance v1, Lcom/mixpanel/android/viewcrawler/ViewCrawler$LifecycleCallbacks;

    invoke-direct {v1, p0}, Lcom/mixpanel/android/viewcrawler/ViewCrawler$LifecycleCallbacks;-><init>(Lcom/mixpanel/android/viewcrawler/ViewCrawler;)V

    invoke-virtual {v0, v1}, Landroid/app/Application;->registerActivityLifecycleCallbacks(Landroid/app/Application$ActivityLifecycleCallbacks;)V

    .line 84
    iget-object v0, p0, Lcom/mixpanel/android/viewcrawler/ViewCrawler;->f:Lcom/mixpanel/android/mpmetrics/Tweaks;

    new-instance v1, Lcom/mixpanel/android/viewcrawler/ViewCrawler$1;

    invoke-direct {v1, p0}, Lcom/mixpanel/android/viewcrawler/ViewCrawler$1;-><init>(Lcom/mixpanel/android/viewcrawler/ViewCrawler;)V

    invoke-virtual {v0, v1}, Lcom/mixpanel/android/mpmetrics/Tweaks;->a(Lcom/mixpanel/android/mpmetrics/Tweaks$OnTweakDeclaredListener;)V

    .line 91
    return-void
.end method

.method static synthetic a(Lcom/mixpanel/android/viewcrawler/ViewCrawler;)Lcom/mixpanel/android/viewcrawler/ViewCrawler$ViewCrawlerHandler;
    .locals 1

    .prologue
    .line 61
    iget-object v0, p0, Lcom/mixpanel/android/viewcrawler/ViewCrawler;->h:Lcom/mixpanel/android/viewcrawler/ViewCrawler$ViewCrawlerHandler;

    return-object v0
.end method

.method static synthetic b(Lcom/mixpanel/android/viewcrawler/ViewCrawler;)Lcom/mixpanel/android/mpmetrics/MixpanelAPI;
    .locals 1

    .prologue
    .line 61
    iget-object v0, p0, Lcom/mixpanel/android/viewcrawler/ViewCrawler;->c:Lcom/mixpanel/android/mpmetrics/MixpanelAPI;

    return-object v0
.end method

.method static synthetic c(Lcom/mixpanel/android/viewcrawler/ViewCrawler;)Lcom/mixpanel/android/viewcrawler/EditState;
    .locals 1

    .prologue
    .line 61
    iget-object v0, p0, Lcom/mixpanel/android/viewcrawler/ViewCrawler;->e:Lcom/mixpanel/android/viewcrawler/EditState;

    return-object v0
.end method

.method static synthetic d(Lcom/mixpanel/android/viewcrawler/ViewCrawler;)Lcom/mixpanel/android/mpmetrics/MPConfig;
    .locals 1

    .prologue
    .line 61
    iget-object v0, p0, Lcom/mixpanel/android/viewcrawler/ViewCrawler;->a:Lcom/mixpanel/android/mpmetrics/MPConfig;

    return-object v0
.end method

.method static synthetic e(Lcom/mixpanel/android/viewcrawler/ViewCrawler;)Landroid/content/Context;
    .locals 1

    .prologue
    .line 61
    iget-object v0, p0, Lcom/mixpanel/android/viewcrawler/ViewCrawler;->b:Landroid/content/Context;

    return-object v0
.end method

.method static synthetic f(Lcom/mixpanel/android/viewcrawler/ViewCrawler;)F
    .locals 1

    .prologue
    .line 61
    iget v0, p0, Lcom/mixpanel/android/viewcrawler/ViewCrawler;->i:F

    return v0
.end method

.method static synthetic g(Lcom/mixpanel/android/viewcrawler/ViewCrawler;)Ljava/util/Map;
    .locals 1

    .prologue
    .line 61
    iget-object v0, p0, Lcom/mixpanel/android/viewcrawler/ViewCrawler;->g:Ljava/util/Map;

    return-object v0
.end method

.method static synthetic h(Lcom/mixpanel/android/viewcrawler/ViewCrawler;)Lcom/mixpanel/android/mpmetrics/Tweaks;
    .locals 1

    .prologue
    .line 61
    iget-object v0, p0, Lcom/mixpanel/android/viewcrawler/ViewCrawler;->f:Lcom/mixpanel/android/mpmetrics/Tweaks;

    return-object v0
.end method

.method static synthetic i(Lcom/mixpanel/android/viewcrawler/ViewCrawler;)Lcom/mixpanel/android/viewcrawler/DynamicEventTracker;
    .locals 1

    .prologue
    .line 61
    iget-object v0, p0, Lcom/mixpanel/android/viewcrawler/ViewCrawler;->d:Lcom/mixpanel/android/viewcrawler/DynamicEventTracker;

    return-object v0
.end method

.method static synthetic j(Lcom/mixpanel/android/viewcrawler/ViewCrawler;)Ljava/util/Set;
    .locals 1

    .prologue
    .line 61
    iget-object v0, p0, Lcom/mixpanel/android/viewcrawler/ViewCrawler;->j:Ljava/util/Set;

    return-object v0
.end method


# virtual methods
.method public a()V
    .locals 1

    .prologue
    .line 95
    iget-object v0, p0, Lcom/mixpanel/android/viewcrawler/ViewCrawler;->h:Lcom/mixpanel/android/viewcrawler/ViewCrawler$ViewCrawlerHandler;

    invoke-virtual {v0}, Lcom/mixpanel/android/viewcrawler/ViewCrawler$ViewCrawlerHandler;->a()V

    .line 96
    invoke-virtual {p0}, Lcom/mixpanel/android/viewcrawler/ViewCrawler;->b()V

    .line 97
    return-void
.end method

.method public a(Lcom/mixpanel/android/viewcrawler/ViewVisitor$LayoutErrorMessage;)V
    .locals 2

    .prologue
    .line 161
    iget-object v0, p0, Lcom/mixpanel/android/viewcrawler/ViewCrawler;->h:Lcom/mixpanel/android/viewcrawler/ViewCrawler$ViewCrawlerHandler;

    invoke-virtual {v0}, Lcom/mixpanel/android/viewcrawler/ViewCrawler$ViewCrawlerHandler;->obtainMessage()Landroid/os/Message;

    move-result-object v0

    .line 162
    const/16 v1, 0xc

    iput v1, v0, Landroid/os/Message;->what:I

    .line 163
    iput-object p1, v0, Landroid/os/Message;->obj:Ljava/lang/Object;

    .line 164
    iget-object v1, p0, Lcom/mixpanel/android/viewcrawler/ViewCrawler;->h:Lcom/mixpanel/android/viewcrawler/ViewCrawler$ViewCrawlerHandler;

    invoke-virtual {v1, v0}, Lcom/mixpanel/android/viewcrawler/ViewCrawler$ViewCrawlerHandler;->sendMessage(Landroid/os/Message;)Z

    .line 165
    return-void
.end method

.method public a(Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 152
    iget-object v0, p0, Lcom/mixpanel/android/viewcrawler/ViewCrawler;->h:Lcom/mixpanel/android/viewcrawler/ViewCrawler$ViewCrawlerHandler;

    invoke-virtual {v0}, Lcom/mixpanel/android/viewcrawler/ViewCrawler$ViewCrawlerHandler;->obtainMessage()Landroid/os/Message;

    move-result-object v0

    .line 153
    const/4 v1, 0x7

    iput v1, v0, Landroid/os/Message;->what:I

    .line 154
    iput-object p1, v0, Landroid/os/Message;->obj:Ljava/lang/Object;

    .line 156
    iget-object v1, p0, Lcom/mixpanel/android/viewcrawler/ViewCrawler;->h:Lcom/mixpanel/android/viewcrawler/ViewCrawler$ViewCrawlerHandler;

    invoke-virtual {v1, v0}, Lcom/mixpanel/android/viewcrawler/ViewCrawler$ViewCrawlerHandler;->sendMessage(Landroid/os/Message;)Z

    .line 157
    return-void
.end method

.method public a(Lorg/json/JSONArray;)V
    .locals 2

    .prologue
    .line 106
    if-eqz p1, :cond_0

    .line 107
    iget-object v0, p0, Lcom/mixpanel/android/viewcrawler/ViewCrawler;->h:Lcom/mixpanel/android/viewcrawler/ViewCrawler$ViewCrawlerHandler;

    const/16 v1, 0xd

    invoke-virtual {v0, v1}, Lcom/mixpanel/android/viewcrawler/ViewCrawler$ViewCrawlerHandler;->obtainMessage(I)Landroid/os/Message;

    move-result-object v0

    .line 108
    iput-object p1, v0, Landroid/os/Message;->obj:Ljava/lang/Object;

    .line 109
    iget-object v1, p0, Lcom/mixpanel/android/viewcrawler/ViewCrawler;->h:Lcom/mixpanel/android/viewcrawler/ViewCrawler$ViewCrawlerHandler;

    invoke-virtual {v1, v0}, Lcom/mixpanel/android/viewcrawler/ViewCrawler$ViewCrawlerHandler;->sendMessage(Landroid/os/Message;)Z

    .line 111
    :cond_0
    return-void
.end method

.method public b()V
    .locals 3

    .prologue
    .line 101
    iget-object v0, p0, Lcom/mixpanel/android/viewcrawler/ViewCrawler;->h:Lcom/mixpanel/android/viewcrawler/ViewCrawler$ViewCrawlerHandler;

    iget-object v1, p0, Lcom/mixpanel/android/viewcrawler/ViewCrawler;->h:Lcom/mixpanel/android/viewcrawler/ViewCrawler$ViewCrawlerHandler;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Lcom/mixpanel/android/viewcrawler/ViewCrawler$ViewCrawlerHandler;->obtainMessage(I)Landroid/os/Message;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/mixpanel/android/viewcrawler/ViewCrawler$ViewCrawlerHandler;->sendMessage(Landroid/os/Message;)Z

    .line 102
    return-void
.end method

.method public b(Lorg/json/JSONArray;)V
    .locals 2

    .prologue
    .line 120
    if-eqz p1, :cond_0

    .line 121
    iget-object v0, p0, Lcom/mixpanel/android/viewcrawler/ViewCrawler;->h:Lcom/mixpanel/android/viewcrawler/ViewCrawler$ViewCrawlerHandler;

    const/4 v1, 0x5

    invoke-virtual {v0, v1}, Lcom/mixpanel/android/viewcrawler/ViewCrawler$ViewCrawlerHandler;->obtainMessage(I)Landroid/os/Message;

    move-result-object v0

    .line 122
    iput-object p1, v0, Landroid/os/Message;->obj:Ljava/lang/Object;

    .line 123
    iget-object v1, p0, Lcom/mixpanel/android/viewcrawler/ViewCrawler;->h:Lcom/mixpanel/android/viewcrawler/ViewCrawler$ViewCrawlerHandler;

    invoke-virtual {v1, v0}, Lcom/mixpanel/android/viewcrawler/ViewCrawler$ViewCrawlerHandler;->sendMessage(Landroid/os/Message;)Z

    .line 125
    :cond_0
    return-void
.end method

.method public c(Lorg/json/JSONArray;)V
    .locals 2

    .prologue
    .line 129
    if-eqz p1, :cond_0

    .line 130
    iget-object v0, p0, Lcom/mixpanel/android/viewcrawler/ViewCrawler;->h:Lcom/mixpanel/android/viewcrawler/ViewCrawler$ViewCrawlerHandler;

    const/16 v1, 0x9

    invoke-virtual {v0, v1}, Lcom/mixpanel/android/viewcrawler/ViewCrawler$ViewCrawlerHandler;->obtainMessage(I)Landroid/os/Message;

    move-result-object v0

    .line 131
    iput-object p1, v0, Landroid/os/Message;->obj:Ljava/lang/Object;

    .line 132
    iget-object v1, p0, Lcom/mixpanel/android/viewcrawler/ViewCrawler;->h:Lcom/mixpanel/android/viewcrawler/ViewCrawler$ViewCrawlerHandler;

    invoke-virtual {v1, v0}, Lcom/mixpanel/android/viewcrawler/ViewCrawler$ViewCrawlerHandler;->sendMessage(Landroid/os/Message;)Z

    .line 134
    :cond_0
    return-void
.end method
