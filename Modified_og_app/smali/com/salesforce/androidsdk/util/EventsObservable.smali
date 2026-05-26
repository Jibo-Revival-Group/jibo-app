.class public Lcom/salesforce/androidsdk/util/EventsObservable;
.super Landroid/database/Observable;
.source "EventsObservable.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/androidsdk/util/EventsObservable$Event;,
        Lcom/salesforce/androidsdk/util/EventsObservable$EventType;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/database/Observable",
        "<",
        "Lcom/salesforce/androidsdk/util/test/EventsObserver;",
        ">;"
    }
.end annotation


# static fields
.field private static final a:Lcom/salesforce/androidsdk/util/EventsObservable;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 76
    new-instance v0, Lcom/salesforce/androidsdk/util/EventsObservable;

    invoke-direct {v0}, Lcom/salesforce/androidsdk/util/EventsObservable;-><init>()V

    sput-object v0, Lcom/salesforce/androidsdk/util/EventsObservable;->a:Lcom/salesforce/androidsdk/util/EventsObservable;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 36
    invoke-direct {p0}, Landroid/database/Observable;-><init>()V

    return-void
.end method

.method public static a()Lcom/salesforce/androidsdk/util/EventsObservable;
    .locals 1

    .prologue
    .line 79
    sget-object v0, Lcom/salesforce/androidsdk/util/EventsObservable;->a:Lcom/salesforce/androidsdk/util/EventsObservable;

    return-object v0
.end method

.method private a(Lcom/salesforce/androidsdk/util/EventsObservable$Event;)V
    .locals 3

    .prologue
    .line 91
    iget-object v1, p0, Lcom/salesforce/androidsdk/util/EventsObservable;->mObservers:Ljava/util/ArrayList;

    monitor-enter v1

    .line 92
    :try_start_0
    iget-object v0, p0, Lcom/salesforce/androidsdk/util/EventsObservable;->mObservers:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/androidsdk/util/test/EventsObserver;

    .line 93
    invoke-interface {v0, p1}, Lcom/salesforce/androidsdk/util/test/EventsObserver;->a(Lcom/salesforce/androidsdk/util/EventsObservable$Event;)V

    goto :goto_0

    .line 94
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0

    :cond_0
    :try_start_1
    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 95
    return-void
.end method


# virtual methods
.method public a(Lcom/salesforce/androidsdk/util/EventsObservable$EventType;)V
    .locals 1

    .prologue
    .line 83
    const/4 v0, 0x0

    invoke-virtual {p0, p1, v0}, Lcom/salesforce/androidsdk/util/EventsObservable;->a(Lcom/salesforce/androidsdk/util/EventsObservable$EventType;Ljava/lang/Object;)V

    .line 84
    return-void
.end method

.method public a(Lcom/salesforce/androidsdk/util/EventsObservable$EventType;Ljava/lang/Object;)V
    .locals 1

    .prologue
    .line 87
    new-instance v0, Lcom/salesforce/androidsdk/util/EventsObservable$Event;

    invoke-direct {v0, p1, p2}, Lcom/salesforce/androidsdk/util/EventsObservable$Event;-><init>(Lcom/salesforce/androidsdk/util/EventsObservable$EventType;Ljava/lang/Object;)V

    invoke-direct {p0, v0}, Lcom/salesforce/androidsdk/util/EventsObservable;->a(Lcom/salesforce/androidsdk/util/EventsObservable$Event;)V

    .line 88
    return-void
.end method
