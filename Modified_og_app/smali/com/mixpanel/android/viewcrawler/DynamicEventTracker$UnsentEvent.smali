.class Lcom/mixpanel/android/viewcrawler/DynamicEventTracker$UnsentEvent;
.super Ljava/lang/Object;
.source "DynamicEventTracker.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/mixpanel/android/viewcrawler/DynamicEventTracker;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "UnsentEvent"
.end annotation


# instance fields
.field public final a:J

.field public final b:Ljava/lang/String;

.field public final c:Lorg/json/JSONObject;


# direct methods
.method public constructor <init>(Ljava/lang/String;Lorg/json/JSONObject;J)V
    .locals 1

    .prologue
    .line 163
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 164
    iput-object p1, p0, Lcom/mixpanel/android/viewcrawler/DynamicEventTracker$UnsentEvent;->b:Ljava/lang/String;

    .line 165
    iput-object p2, p0, Lcom/mixpanel/android/viewcrawler/DynamicEventTracker$UnsentEvent;->c:Lorg/json/JSONObject;

    .line 166
    iput-wide p3, p0, Lcom/mixpanel/android/viewcrawler/DynamicEventTracker$UnsentEvent;->a:J

    .line 167
    return-void
.end method
