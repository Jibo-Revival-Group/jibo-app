.class Lio/fabric/sdk/android/services/events/EventsFilesManager$1;
.super Ljava/lang/Object;
.source "EventsFilesManager.java"

# interfaces
.implements Ljava/util/Comparator;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lio/fabric/sdk/android/services/events/EventsFilesManager;->g()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/util/Comparator",
        "<",
        "Lio/fabric/sdk/android/services/events/EventsFilesManager$FileWithTimestamp;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Lio/fabric/sdk/android/services/events/EventsFilesManager;


# direct methods
.method constructor <init>(Lio/fabric/sdk/android/services/events/EventsFilesManager;)V
    .locals 0

    .prologue
    .line 208
    iput-object p1, p0, Lio/fabric/sdk/android/services/events/EventsFilesManager$1;->a:Lio/fabric/sdk/android/services/events/EventsFilesManager;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lio/fabric/sdk/android/services/events/EventsFilesManager$FileWithTimestamp;Lio/fabric/sdk/android/services/events/EventsFilesManager$FileWithTimestamp;)I
    .locals 4

    .prologue
    .line 211
    iget-wide v0, p1, Lio/fabric/sdk/android/services/events/EventsFilesManager$FileWithTimestamp;->b:J

    iget-wide v2, p2, Lio/fabric/sdk/android/services/events/EventsFilesManager$FileWithTimestamp;->b:J

    sub-long/2addr v0, v2

    long-to-int v0, v0

    return v0
.end method

.method public synthetic compare(Ljava/lang/Object;Ljava/lang/Object;)I
    .locals 1

    .prologue
    .line 208
    check-cast p1, Lio/fabric/sdk/android/services/events/EventsFilesManager$FileWithTimestamp;

    check-cast p2, Lio/fabric/sdk/android/services/events/EventsFilesManager$FileWithTimestamp;

    invoke-virtual {p0, p1, p2}, Lio/fabric/sdk/android/services/events/EventsFilesManager$1;->a(Lio/fabric/sdk/android/services/events/EventsFilesManager$FileWithTimestamp;Lio/fabric/sdk/android/services/events/EventsFilesManager$FileWithTimestamp;)I

    move-result v0

    return v0
.end method
