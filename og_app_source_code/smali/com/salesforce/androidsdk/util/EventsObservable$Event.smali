.class public Lcom/salesforce/androidsdk/util/EventsObservable$Event;
.super Ljava/lang/Object;
.source "EventsObservable.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/androidsdk/util/EventsObservable;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Event"
.end annotation


# instance fields
.field private a:Lcom/salesforce/androidsdk/util/EventsObservable$EventType;

.field private b:Ljava/lang/Object;


# direct methods
.method public constructor <init>(Lcom/salesforce/androidsdk/util/EventsObservable$EventType;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 61
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 62
    iput-object p1, p0, Lcom/salesforce/androidsdk/util/EventsObservable$Event;->a:Lcom/salesforce/androidsdk/util/EventsObservable$EventType;

    .line 63
    iput-object p2, p0, Lcom/salesforce/androidsdk/util/EventsObservable$Event;->b:Ljava/lang/Object;

    .line 64
    return-void
.end method
