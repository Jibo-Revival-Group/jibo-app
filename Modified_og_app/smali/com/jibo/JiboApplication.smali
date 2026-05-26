.class public Lcom/jibo/JiboApplication;
.super Lcom/jibo/BasicJiboApplication;
.source "JiboApplication.java"


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 63
    const-string v0, "utils-jni"

    invoke-static {v0}, Ljava/lang/System;->loadLibrary(Ljava/lang/String;)V

    .line 64
    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Lcom/jibo/BasicJiboApplication;-><init>()V

    return-void
.end method

.method private c()V
    .locals 1

    .prologue
    .line 23
    invoke-virtual {p0}, Lcom/jibo/JiboApplication;->getThirPartyKey1()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/facebook/FacebookSdk;->setApplicationId(Ljava/lang/String;)V

    .line 24
    invoke-virtual {p0}, Lcom/jibo/JiboApplication;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/facebook/FacebookSdk;->sdkInitialize(Landroid/content/Context;)V

    .line 25
    invoke-static {p0}, Lcom/facebook/appevents/AppEventsLogger;->activateApp(Landroid/app/Application;)V

    .line 26
    return-void
.end method

.method private d()V
    .locals 2

    .prologue
    .line 29
    invoke-virtual {p0}, Lcom/jibo/JiboApplication;->getThirPartyKey4()Ljava/lang/String;

    move-result-object v0

    .line 35
    new-instance v1, Lcom/segment/analytics/Analytics$Builder;

    invoke-direct {v1, p0, v0}, Lcom/segment/analytics/Analytics$Builder;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 36
    invoke-virtual {v1}, Lcom/segment/analytics/Analytics$Builder;->trackApplicationLifecycleEvents()Lcom/segment/analytics/Analytics$Builder;

    move-result-object v0

    .line 37
    invoke-virtual {v0}, Lcom/segment/analytics/Analytics$Builder;->build()Lcom/segment/analytics/Analytics;

    move-result-object v0

    .line 40
    invoke-static {v0}, Lcom/segment/analytics/Analytics;->setSingletonInstance(Lcom/segment/analytics/Analytics;)V

    .line 41
    return-void
.end method

.method private e()V
    .locals 0

    .prologue
    .line 44
    invoke-static {p0}, Lcom/jibo/JiboSupport;->a(Landroid/content/Context;)V

    .line 45
    return-void
.end method


# virtual methods
.method protected a()V
    .locals 0

    .prologue
    .line 15
    invoke-direct {p0}, Lcom/jibo/JiboApplication;->c()V

    .line 17
    invoke-direct {p0}, Lcom/jibo/JiboApplication;->d()V

    .line 19
    invoke-direct {p0}, Lcom/jibo/JiboApplication;->e()V

    .line 20
    return-void
.end method

.method public b()V
    .locals 1

    .prologue
    .line 49
    invoke-static {}, Lcom/facebook/login/LoginManager;->getInstance()Lcom/facebook/login/LoginManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/facebook/login/LoginManager;->logOut()V

    .line 51
    invoke-super {p0}, Lcom/jibo/BasicJiboApplication;->b()V

    .line 52
    return-void
.end method

.method public native getThirPartyKey1()Ljava/lang/String;
.end method

.method public native getThirPartyKey4()Ljava/lang/String;
.end method
