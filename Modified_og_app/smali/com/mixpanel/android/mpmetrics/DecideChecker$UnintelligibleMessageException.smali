.class Lcom/mixpanel/android/mpmetrics/DecideChecker$UnintelligibleMessageException;
.super Ljava/lang/Exception;
.source "DecideChecker.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/mixpanel/android/mpmetrics/DecideChecker;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "UnintelligibleMessageException"
.end annotation


# direct methods
.method public constructor <init>(Ljava/lang/String;Lorg/json/JSONException;)V
    .locals 0

    .prologue
    .line 99
    invoke-direct {p0, p1, p2}, Ljava/lang/Exception;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 100
    return-void
.end method
