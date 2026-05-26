.class public final Lcom/segment/analytics/integrations/Logger;
.super Ljava/lang/Object;
.source "Logger.java"


# static fields
.field private static final DEFAULT_TAG:Ljava/lang/String; = "Analytics"


# instance fields
.field public final logLevel:Lcom/segment/analytics/Analytics$LogLevel;

.field private final tag:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Lcom/segment/analytics/Analytics$LogLevel;)V
    .locals 0

    .prologue
    .line 16
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 17
    iput-object p1, p0, Lcom/segment/analytics/integrations/Logger;->tag:Ljava/lang/String;

    .line 18
    iput-object p2, p0, Lcom/segment/analytics/integrations/Logger;->logLevel:Lcom/segment/analytics/Analytics$LogLevel;

    .line 19
    return-void
.end method

.method private shouldLog(Lcom/segment/analytics/Analytics$LogLevel;)Z
    .locals 2

    .prologue
    .line 62
    iget-object v0, p0, Lcom/segment/analytics/integrations/Logger;->logLevel:Lcom/segment/analytics/Analytics$LogLevel;

    invoke-virtual {v0}, Lcom/segment/analytics/Analytics$LogLevel;->ordinal()I

    move-result v0

    invoke-virtual {p1}, Lcom/segment/analytics/Analytics$LogLevel;->ordinal()I

    move-result v1

    if-lt v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static with(Lcom/segment/analytics/Analytics$LogLevel;)Lcom/segment/analytics/integrations/Logger;
    .locals 2

    .prologue
    .line 58
    new-instance v0, Lcom/segment/analytics/integrations/Logger;

    const-string v1, "Analytics"

    invoke-direct {v0, v1, p0}, Lcom/segment/analytics/integrations/Logger;-><init>(Ljava/lang/String;Lcom/segment/analytics/Analytics$LogLevel;)V

    return-object v0
.end method


# virtual methods
.method public varargs debug(Ljava/lang/String;[Ljava/lang/Object;)V
    .locals 2

    .prologue
    .line 37
    sget-object v0, Lcom/segment/analytics/Analytics$LogLevel;->DEBUG:Lcom/segment/analytics/Analytics$LogLevel;

    invoke-direct {p0, v0}, Lcom/segment/analytics/integrations/Logger;->shouldLog(Lcom/segment/analytics/Analytics$LogLevel;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 38
    iget-object v0, p0, Lcom/segment/analytics/integrations/Logger;->tag:Ljava/lang/String;

    invoke-static {p1, p2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 40
    :cond_0
    return-void
.end method

.method public varargs error(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    .locals 2

    .prologue
    .line 44
    sget-object v0, Lcom/segment/analytics/Analytics$LogLevel;->INFO:Lcom/segment/analytics/Analytics$LogLevel;

    invoke-direct {p0, v0}, Lcom/segment/analytics/integrations/Logger;->shouldLog(Lcom/segment/analytics/Analytics$LogLevel;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 45
    iget-object v0, p0, Lcom/segment/analytics/integrations/Logger;->tag:Ljava/lang/String;

    invoke-static {p2, p3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1, p1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 47
    :cond_0
    return-void
.end method

.method public varargs info(Ljava/lang/String;[Ljava/lang/Object;)V
    .locals 2

    .prologue
    .line 30
    sget-object v0, Lcom/segment/analytics/Analytics$LogLevel;->INFO:Lcom/segment/analytics/Analytics$LogLevel;

    invoke-direct {p0, v0}, Lcom/segment/analytics/integrations/Logger;->shouldLog(Lcom/segment/analytics/Analytics$LogLevel;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 31
    iget-object v0, p0, Lcom/segment/analytics/integrations/Logger;->tag:Ljava/lang/String;

    invoke-static {p1, p2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 33
    :cond_0
    return-void
.end method

.method public subLog(Ljava/lang/String;)Lcom/segment/analytics/integrations/Logger;
    .locals 3

    .prologue
    .line 53
    new-instance v0, Lcom/segment/analytics/integrations/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Analytics-"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/segment/analytics/integrations/Logger;->logLevel:Lcom/segment/analytics/Analytics$LogLevel;

    invoke-direct {v0, v1, v2}, Lcom/segment/analytics/integrations/Logger;-><init>(Ljava/lang/String;Lcom/segment/analytics/Analytics$LogLevel;)V

    return-object v0
.end method

.method public varargs verbose(Ljava/lang/String;[Ljava/lang/Object;)V
    .locals 2

    .prologue
    .line 23
    sget-object v0, Lcom/segment/analytics/Analytics$LogLevel;->VERBOSE:Lcom/segment/analytics/Analytics$LogLevel;

    invoke-direct {p0, v0}, Lcom/segment/analytics/integrations/Logger;->shouldLog(Lcom/segment/analytics/Analytics$LogLevel;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 24
    iget-object v0, p0, Lcom/segment/analytics/integrations/Logger;->tag:Ljava/lang/String;

    invoke-static {p1, p2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 26
    :cond_0
    return-void
.end method
