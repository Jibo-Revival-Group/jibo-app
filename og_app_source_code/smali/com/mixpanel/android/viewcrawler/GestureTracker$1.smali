.class Lcom/mixpanel/android/viewcrawler/GestureTracker$1;
.super Ljava/lang/Object;
.source "GestureTracker.java"

# interfaces
.implements Landroid/view/View$OnTouchListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/mixpanel/android/viewcrawler/GestureTracker;->a(Lcom/mixpanel/android/mpmetrics/MixpanelAPI;)Landroid/view/View$OnTouchListener;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/mixpanel/android/mpmetrics/MixpanelAPI;

.field final synthetic b:Lcom/mixpanel/android/viewcrawler/GestureTracker;

.field private c:J

.field private d:J

.field private e:I

.field private f:J

.field private g:Z

.field private final h:I

.field private final i:I

.field private final j:I


# direct methods
.method constructor <init>(Lcom/mixpanel/android/viewcrawler/GestureTracker;Lcom/mixpanel/android/mpmetrics/MixpanelAPI;)V
    .locals 3

    .prologue
    const/4 v2, 0x0

    const-wide/16 v0, -0x1

    .line 26
    iput-object p1, p0, Lcom/mixpanel/android/viewcrawler/GestureTracker$1;->b:Lcom/mixpanel/android/viewcrawler/GestureTracker;

    iput-object p2, p0, Lcom/mixpanel/android/viewcrawler/GestureTracker$1;->a:Lcom/mixpanel/android/mpmetrics/MixpanelAPI;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 92
    iput-wide v0, p0, Lcom/mixpanel/android/viewcrawler/GestureTracker$1;->c:J

    .line 93
    iput-wide v0, p0, Lcom/mixpanel/android/viewcrawler/GestureTracker$1;->d:J

    .line 94
    iput v2, p0, Lcom/mixpanel/android/viewcrawler/GestureTracker$1;->e:I

    .line 95
    iput-wide v0, p0, Lcom/mixpanel/android/viewcrawler/GestureTracker$1;->f:J

    .line 96
    iput-boolean v2, p0, Lcom/mixpanel/android/viewcrawler/GestureTracker$1;->g:Z

    .line 97
    const/16 v0, 0x64

    iput v0, p0, Lcom/mixpanel/android/viewcrawler/GestureTracker$1;->h:I

    .line 98
    const/16 v0, 0x3e8

    iput v0, p0, Lcom/mixpanel/android/viewcrawler/GestureTracker$1;->i:I

    .line 99
    const/16 v0, 0x9c4

    iput v0, p0, Lcom/mixpanel/android/viewcrawler/GestureTracker$1;->j:I

    return-void
.end method

.method private a()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    const-wide/16 v0, -0x1

    .line 85
    iput-wide v0, p0, Lcom/mixpanel/android/viewcrawler/GestureTracker$1;->d:J

    .line 86
    iput-wide v0, p0, Lcom/mixpanel/android/viewcrawler/GestureTracker$1;->c:J

    .line 87
    iput v2, p0, Lcom/mixpanel/android/viewcrawler/GestureTracker$1;->e:I

    .line 88
    iput-wide v0, p0, Lcom/mixpanel/android/viewcrawler/GestureTracker$1;->f:J

    .line 89
    iput-boolean v2, p0, Lcom/mixpanel/android/viewcrawler/GestureTracker$1;->g:Z

    .line 90
    return-void
.end method


# virtual methods
.method public onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z
    .locals 8

    .prologue
    const-wide/16 v6, 0x64

    const/4 v5, 0x4

    const/4 v4, 0x0

    .line 30
    invoke-virtual {p2}, Landroid/view/MotionEvent;->getPointerCount()I

    move-result v0

    const/4 v1, 0x2

    if-le v0, v1, :cond_1

    .line 31
    invoke-direct {p0}, Lcom/mixpanel/android/viewcrawler/GestureTracker$1;->a()V

    .line 81
    :cond_0
    :goto_0
    return v4

    .line 35
    :cond_1
    invoke-virtual {p2}, Landroid/view/MotionEvent;->getActionMasked()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    :pswitch_0
    goto :goto_0

    .line 37
    :pswitch_1
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/mixpanel/android/viewcrawler/GestureTracker$1;->d:J

    goto :goto_0

    .line 40
    :pswitch_2
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    iget-wide v2, p0, Lcom/mixpanel/android/viewcrawler/GestureTracker$1;->d:J

    sub-long/2addr v0, v2

    cmp-long v0, v0, v6

    if-gez v0, :cond_3

    .line 41
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    iget-wide v2, p0, Lcom/mixpanel/android/viewcrawler/GestureTracker$1;->f:J

    sub-long/2addr v0, v2

    const-wide/16 v2, 0x3e8

    cmp-long v0, v0, v2

    if-lez v0, :cond_2

    .line 42
    invoke-direct {p0}, Lcom/mixpanel/android/viewcrawler/GestureTracker$1;->a()V

    .line 44
    :cond_2
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/mixpanel/android/viewcrawler/GestureTracker$1;->c:J

    .line 45
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/mixpanel/android/viewcrawler/GestureTracker$1;->g:Z

    goto :goto_0

    .line 47
    :cond_3
    invoke-direct {p0}, Lcom/mixpanel/android/viewcrawler/GestureTracker$1;->a()V

    goto :goto_0

    .line 51
    :pswitch_3
    iget-boolean v0, p0, Lcom/mixpanel/android/viewcrawler/GestureTracker$1;->g:Z

    if-eqz v0, :cond_4

    .line 52
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/mixpanel/android/viewcrawler/GestureTracker$1;->d:J

    goto :goto_0

    .line 54
    :cond_4
    invoke-direct {p0}, Lcom/mixpanel/android/viewcrawler/GestureTracker$1;->a()V

    goto :goto_0

    .line 58
    :pswitch_4
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    iget-wide v2, p0, Lcom/mixpanel/android/viewcrawler/GestureTracker$1;->d:J

    sub-long/2addr v0, v2

    cmp-long v0, v0, v6

    if-gez v0, :cond_0

    .line 59
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    iget-wide v2, p0, Lcom/mixpanel/android/viewcrawler/GestureTracker$1;->c:J

    sub-long/2addr v0, v2

    const-wide/16 v2, 0x9c4

    cmp-long v0, v0, v2

    if-ltz v0, :cond_6

    .line 61
    iget v0, p0, Lcom/mixpanel/android/viewcrawler/GestureTracker$1;->e:I

    const/4 v1, 0x3

    if-ne v0, v1, :cond_5

    .line 62
    iget-object v0, p0, Lcom/mixpanel/android/viewcrawler/GestureTracker$1;->a:Lcom/mixpanel/android/mpmetrics/MixpanelAPI;

    const-string v1, "$ab_gesture1"

    invoke-virtual {v0, v1}, Lcom/mixpanel/android/mpmetrics/MixpanelAPI;->b(Ljava/lang/String;)V

    .line 63
    invoke-direct {p0}, Lcom/mixpanel/android/viewcrawler/GestureTracker$1;->a()V

    .line 65
    :cond_5
    iput v4, p0, Lcom/mixpanel/android/viewcrawler/GestureTracker$1;->e:I

    goto :goto_0

    .line 68
    :cond_6
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/mixpanel/android/viewcrawler/GestureTracker$1;->f:J

    .line 69
    iget v0, p0, Lcom/mixpanel/android/viewcrawler/GestureTracker$1;->e:I

    if-ge v0, v5, :cond_7

    .line 70
    iget v0, p0, Lcom/mixpanel/android/viewcrawler/GestureTracker$1;->e:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/mixpanel/android/viewcrawler/GestureTracker$1;->e:I

    goto/16 :goto_0

    .line 71
    :cond_7
    iget v0, p0, Lcom/mixpanel/android/viewcrawler/GestureTracker$1;->e:I

    if-ne v0, v5, :cond_8

    .line 72
    iget-object v0, p0, Lcom/mixpanel/android/viewcrawler/GestureTracker$1;->a:Lcom/mixpanel/android/mpmetrics/MixpanelAPI;

    const-string v1, "$ab_gesture2"

    invoke-virtual {v0, v1}, Lcom/mixpanel/android/mpmetrics/MixpanelAPI;->b(Ljava/lang/String;)V

    .line 73
    invoke-direct {p0}, Lcom/mixpanel/android/viewcrawler/GestureTracker$1;->a()V

    goto/16 :goto_0

    .line 75
    :cond_8
    invoke-direct {p0}, Lcom/mixpanel/android/viewcrawler/GestureTracker$1;->a()V

    goto/16 :goto_0

    .line 35
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1
        :pswitch_4
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method
