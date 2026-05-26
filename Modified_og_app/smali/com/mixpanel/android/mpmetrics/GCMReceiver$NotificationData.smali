.class public Lcom/mixpanel/android/mpmetrics/GCMReceiver$NotificationData;
.super Ljava/lang/Object;
.source "GCMReceiver.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/mixpanel/android/mpmetrics/GCMReceiver;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xc
    name = "NotificationData"
.end annotation


# instance fields
.field public final a:I

.field public final b:I

.field public final c:I

.field public final d:Ljava/lang/CharSequence;

.field public final e:Ljava/lang/String;

.field public final f:Landroid/content/Intent;

.field public final g:I


# direct methods
.method private constructor <init>(IIILjava/lang/CharSequence;Ljava/lang/String;Landroid/content/Intent;I)V
    .locals 0

    .prologue
    .line 110
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 111
    iput p1, p0, Lcom/mixpanel/android/mpmetrics/GCMReceiver$NotificationData;->a:I

    .line 112
    iput p2, p0, Lcom/mixpanel/android/mpmetrics/GCMReceiver$NotificationData;->b:I

    .line 113
    iput p3, p0, Lcom/mixpanel/android/mpmetrics/GCMReceiver$NotificationData;->c:I

    .line 114
    iput-object p4, p0, Lcom/mixpanel/android/mpmetrics/GCMReceiver$NotificationData;->d:Ljava/lang/CharSequence;

    .line 115
    iput-object p5, p0, Lcom/mixpanel/android/mpmetrics/GCMReceiver$NotificationData;->e:Ljava/lang/String;

    .line 116
    iput-object p6, p0, Lcom/mixpanel/android/mpmetrics/GCMReceiver$NotificationData;->f:Landroid/content/Intent;

    .line 117
    iput p7, p0, Lcom/mixpanel/android/mpmetrics/GCMReceiver$NotificationData;->g:I

    .line 118
    return-void
.end method

.method synthetic constructor <init>(IIILjava/lang/CharSequence;Ljava/lang/String;Landroid/content/Intent;ILcom/mixpanel/android/mpmetrics/GCMReceiver$1;)V
    .locals 0

    .prologue
    .line 109
    invoke-direct/range {p0 .. p7}, Lcom/mixpanel/android/mpmetrics/GCMReceiver$NotificationData;-><init>(IIILjava/lang/CharSequence;Ljava/lang/String;Landroid/content/Intent;I)V

    return-void
.end method
