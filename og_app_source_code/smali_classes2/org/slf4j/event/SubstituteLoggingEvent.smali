.class public Lorg/slf4j/event/SubstituteLoggingEvent;
.super Ljava/lang/Object;
.source "SubstituteLoggingEvent.java"

# interfaces
.implements Lorg/slf4j/event/LoggingEvent;


# instance fields
.field a:Lorg/slf4j/event/Level;

.field b:Lorg/slf4j/Marker;

.field c:Ljava/lang/String;

.field d:Lorg/slf4j/helpers/SubstituteLogger;

.field e:Ljava/lang/String;

.field f:Ljava/lang/String;

.field g:[Ljava/lang/Object;

.field h:J

.field i:Ljava/lang/Throwable;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 6
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()Lorg/slf4j/helpers/SubstituteLogger;
    .locals 1

    .prologue
    .line 43
    iget-object v0, p0, Lorg/slf4j/event/SubstituteLoggingEvent;->d:Lorg/slf4j/helpers/SubstituteLogger;

    return-object v0
.end method

.method public a(J)V
    .locals 1

    .prologue
    .line 71
    iput-wide p1, p0, Lorg/slf4j/event/SubstituteLoggingEvent;->h:J

    .line 72
    return-void
.end method

.method public a(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 39
    iput-object p1, p0, Lorg/slf4j/event/SubstituteLoggingEvent;->c:Ljava/lang/String;

    .line 40
    return-void
.end method

.method public a(Ljava/lang/Throwable;)V
    .locals 0

    .prologue
    .line 87
    iput-object p1, p0, Lorg/slf4j/event/SubstituteLoggingEvent;->i:Ljava/lang/Throwable;

    .line 88
    return-void
.end method

.method public a(Lorg/slf4j/Marker;)V
    .locals 0

    .prologue
    .line 31
    iput-object p1, p0, Lorg/slf4j/event/SubstituteLoggingEvent;->b:Lorg/slf4j/Marker;

    .line 32
    return-void
.end method

.method public a(Lorg/slf4j/event/Level;)V
    .locals 0

    .prologue
    .line 23
    iput-object p1, p0, Lorg/slf4j/event/SubstituteLoggingEvent;->a:Lorg/slf4j/event/Level;

    .line 24
    return-void
.end method

.method public a(Lorg/slf4j/helpers/SubstituteLogger;)V
    .locals 0

    .prologue
    .line 47
    iput-object p1, p0, Lorg/slf4j/event/SubstituteLoggingEvent;->d:Lorg/slf4j/helpers/SubstituteLogger;

    .line 48
    return-void
.end method

.method public a([Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 63
    iput-object p1, p0, Lorg/slf4j/event/SubstituteLoggingEvent;->g:[Ljava/lang/Object;

    .line 64
    return-void
.end method

.method public b(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 55
    iput-object p1, p0, Lorg/slf4j/event/SubstituteLoggingEvent;->f:Ljava/lang/String;

    .line 56
    return-void
.end method

.method public c(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 79
    iput-object p1, p0, Lorg/slf4j/event/SubstituteLoggingEvent;->e:Ljava/lang/String;

    .line 80
    return-void
.end method
