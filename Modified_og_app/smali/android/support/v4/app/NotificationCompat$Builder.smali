.class public Landroid/support/v4/app/NotificationCompat$Builder;
.super Ljava/lang/Object;
.source "NotificationCompat.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/support/v4/app/NotificationCompat;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation


# instance fields
.field A:Landroid/os/Bundle;

.field B:I

.field C:I

.field D:Landroid/app/Notification;

.field E:Landroid/widget/RemoteViews;

.field F:Landroid/widget/RemoteViews;

.field G:Landroid/widget/RemoteViews;

.field H:Ljava/lang/String;

.field I:I

.field J:Ljava/lang/String;

.field K:J

.field L:I

.field M:Landroid/app/Notification;

.field public N:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field

.field public a:Landroid/content/Context;

.field public b:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Landroid/support/v4/app/NotificationCompat$Action;",
            ">;"
        }
    .end annotation
.end field

.field c:Ljava/lang/CharSequence;

.field d:Ljava/lang/CharSequence;

.field e:Landroid/app/PendingIntent;

.field f:Landroid/app/PendingIntent;

.field g:Landroid/widget/RemoteViews;

.field h:Landroid/graphics/Bitmap;

.field i:Ljava/lang/CharSequence;

.field j:I

.field k:I

.field l:Z

.field m:Z

.field n:Landroid/support/v4/app/NotificationCompat$Style;

.field o:Ljava/lang/CharSequence;

.field p:[Ljava/lang/CharSequence;

.field q:I

.field r:I

.field s:Z

.field t:Ljava/lang/String;

.field u:Z

.field v:Ljava/lang/String;

.field w:Z

.field x:Z

.field y:Z

.field z:Ljava/lang/String;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 728
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Landroid/support/v4/app/NotificationCompat$Builder;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 729
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Ljava/lang/String;)V
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 711
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 651
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Landroid/support/v4/app/NotificationCompat$Builder;->b:Ljava/util/ArrayList;

    .line 663
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/support/v4/app/NotificationCompat$Builder;->l:Z

    .line 674
    iput-boolean v4, p0, Landroid/support/v4/app/NotificationCompat$Builder;->w:Z

    .line 679
    iput v4, p0, Landroid/support/v4/app/NotificationCompat$Builder;->B:I

    .line 680
    iput v4, p0, Landroid/support/v4/app/NotificationCompat$Builder;->C:I

    .line 686
    iput v4, p0, Landroid/support/v4/app/NotificationCompat$Builder;->I:I

    .line 689
    iput v4, p0, Landroid/support/v4/app/NotificationCompat$Builder;->L:I

    .line 690
    new-instance v0, Landroid/app/Notification;

    invoke-direct {v0}, Landroid/app/Notification;-><init>()V

    iput-object v0, p0, Landroid/support/v4/app/NotificationCompat$Builder;->M:Landroid/app/Notification;

    .line 712
    iput-object p1, p0, Landroid/support/v4/app/NotificationCompat$Builder;->a:Landroid/content/Context;

    .line 713
    iput-object p2, p0, Landroid/support/v4/app/NotificationCompat$Builder;->H:Ljava/lang/String;

    .line 716
    iget-object v0, p0, Landroid/support/v4/app/NotificationCompat$Builder;->M:Landroid/app/Notification;

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    iput-wide v2, v0, Landroid/app/Notification;->when:J

    .line 717
    iget-object v0, p0, Landroid/support/v4/app/NotificationCompat$Builder;->M:Landroid/app/Notification;

    const/4 v1, -0x1

    iput v1, v0, Landroid/app/Notification;->audioStreamType:I

    .line 718
    iput v4, p0, Landroid/support/v4/app/NotificationCompat$Builder;->k:I

    .line 719
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Landroid/support/v4/app/NotificationCompat$Builder;->N:Ljava/util/ArrayList;

    .line 720
    return-void
.end method

.method private a(IZ)V
    .locals 3

    .prologue
    .line 1134
    if-eqz p2, :cond_0

    .line 1135
    iget-object v0, p0, Landroid/support/v4/app/NotificationCompat$Builder;->M:Landroid/app/Notification;

    iget v1, v0, Landroid/app/Notification;->flags:I

    or-int/2addr v1, p1

    iput v1, v0, Landroid/app/Notification;->flags:I

    .line 1139
    :goto_0
    return-void

    .line 1137
    :cond_0
    iget-object v0, p0, Landroid/support/v4/app/NotificationCompat$Builder;->M:Landroid/app/Notification;

    iget v1, v0, Landroid/app/Notification;->flags:I

    xor-int/lit8 v2, p1, -0x1

    and-int/2addr v1, v2

    iput v1, v0, Landroid/app/Notification;->flags:I

    goto :goto_0
.end method

.method protected static d(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    .locals 2

    .prologue
    const/16 v1, 0x1400

    .line 1509
    if-nez p0, :cond_1

    .line 1513
    :cond_0
    :goto_0
    return-object p0

    .line 1510
    :cond_1
    invoke-interface {p0}, Ljava/lang/CharSequence;->length()I

    move-result v0

    if-le v0, v1, :cond_0

    .line 1511
    const/4 v0, 0x0

    invoke-interface {p0, v0, v1}, Ljava/lang/CharSequence;->subSequence(II)Ljava/lang/CharSequence;

    move-result-object p0

    goto :goto_0
.end method


# virtual methods
.method public a()Landroid/app/Notification;
    .locals 1
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 1497
    invoke-virtual {p0}, Landroid/support/v4/app/NotificationCompat$Builder;->b()Landroid/app/Notification;

    move-result-object v0

    return-object v0
.end method

.method public a(I)Landroid/support/v4/app/NotificationCompat$Builder;
    .locals 1

    .prologue
    .line 773
    iget-object v0, p0, Landroid/support/v4/app/NotificationCompat$Builder;->M:Landroid/app/Notification;

    iput p1, v0, Landroid/app/Notification;->icon:I

    .line 774
    return-object p0
.end method

.method public a(J)Landroid/support/v4/app/NotificationCompat$Builder;
    .locals 1

    .prologue
    .line 736
    iget-object v0, p0, Landroid/support/v4/app/NotificationCompat$Builder;->M:Landroid/app/Notification;

    iput-wide p1, v0, Landroid/app/Notification;->when:J

    .line 737
    return-object p0
.end method

.method public a(Landroid/app/PendingIntent;)Landroid/support/v4/app/NotificationCompat$Builder;
    .locals 0

    .prologue
    .line 888
    iput-object p1, p0, Landroid/support/v4/app/NotificationCompat$Builder;->e:Landroid/app/PendingIntent;

    .line 889
    return-object p0
.end method

.method public a(Landroid/graphics/Bitmap;)Landroid/support/v4/app/NotificationCompat$Builder;
    .locals 0

    .prologue
    .line 954
    iput-object p1, p0, Landroid/support/v4/app/NotificationCompat$Builder;->h:Landroid/graphics/Bitmap;

    .line 955
    return-object p0
.end method

.method public a(Landroid/net/Uri;)Landroid/support/v4/app/NotificationCompat$Builder;
    .locals 3

    .prologue
    .line 967
    iget-object v0, p0, Landroid/support/v4/app/NotificationCompat$Builder;->M:Landroid/app/Notification;

    iput-object p1, v0, Landroid/app/Notification;->sound:Landroid/net/Uri;

    .line 968
    iget-object v0, p0, Landroid/support/v4/app/NotificationCompat$Builder;->M:Landroid/app/Notification;

    const/4 v1, -0x1

    iput v1, v0, Landroid/app/Notification;->audioStreamType:I

    .line 969
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x15

    if-lt v0, v1, :cond_0

    .line 970
    iget-object v0, p0, Landroid/support/v4/app/NotificationCompat$Builder;->M:Landroid/app/Notification;

    new-instance v1, Landroid/media/AudioAttributes$Builder;

    invoke-direct {v1}, Landroid/media/AudioAttributes$Builder;-><init>()V

    const/4 v2, 0x4

    .line 971
    invoke-virtual {v1, v2}, Landroid/media/AudioAttributes$Builder;->setContentType(I)Landroid/media/AudioAttributes$Builder;

    move-result-object v1

    const/4 v2, 0x5

    .line 972
    invoke-virtual {v1, v2}, Landroid/media/AudioAttributes$Builder;->setUsage(I)Landroid/media/AudioAttributes$Builder;

    move-result-object v1

    .line 973
    invoke-virtual {v1}, Landroid/media/AudioAttributes$Builder;->build()Landroid/media/AudioAttributes;

    move-result-object v1

    iput-object v1, v0, Landroid/app/Notification;->audioAttributes:Landroid/media/AudioAttributes;

    .line 975
    :cond_0
    return-object p0
.end method

.method public a(Landroid/support/v4/app/NotificationCompat$Style;)Landroid/support/v4/app/NotificationCompat$Builder;
    .locals 1

    .prologue
    .line 1336
    iget-object v0, p0, Landroid/support/v4/app/NotificationCompat$Builder;->n:Landroid/support/v4/app/NotificationCompat$Style;

    if-eq v0, p1, :cond_0

    .line 1337
    iput-object p1, p0, Landroid/support/v4/app/NotificationCompat$Builder;->n:Landroid/support/v4/app/NotificationCompat$Style;

    .line 1338
    iget-object v0, p0, Landroid/support/v4/app/NotificationCompat$Builder;->n:Landroid/support/v4/app/NotificationCompat$Style;

    if-eqz v0, :cond_0

    .line 1339
    iget-object v0, p0, Landroid/support/v4/app/NotificationCompat$Builder;->n:Landroid/support/v4/app/NotificationCompat$Style;

    invoke-virtual {v0, p0}, Landroid/support/v4/app/NotificationCompat$Style;->a(Landroid/support/v4/app/NotificationCompat$Builder;)V

    .line 1342
    :cond_0
    return-object p0
.end method

.method public a(Ljava/lang/CharSequence;)Landroid/support/v4/app/NotificationCompat$Builder;
    .locals 1

    .prologue
    .line 797
    invoke-static {p1}, Landroid/support/v4/app/NotificationCompat$Builder;->d(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;

    move-result-object v0

    iput-object v0, p0, Landroid/support/v4/app/NotificationCompat$Builder;->c:Ljava/lang/CharSequence;

    .line 798
    return-object p0
.end method

.method public a(Ljava/lang/String;)Landroid/support/v4/app/NotificationCompat$Builder;
    .locals 0

    .prologue
    .line 1425
    iput-object p1, p0, Landroid/support/v4/app/NotificationCompat$Builder;->H:Ljava/lang/String;

    .line 1426
    return-object p0
.end method

.method public a(Z)Landroid/support/v4/app/NotificationCompat$Builder;
    .locals 1

    .prologue
    .line 1088
    const/16 v0, 0x10

    invoke-direct {p0, v0, p1}, Landroid/support/v4/app/NotificationCompat$Builder;->a(IZ)V

    .line 1089
    return-object p0
.end method

.method public b()Landroid/app/Notification;
    .locals 1

    .prologue
    .line 1505
    new-instance v0, Landroid/support/v4/app/NotificationCompatBuilder;

    invoke-direct {v0, p0}, Landroid/support/v4/app/NotificationCompatBuilder;-><init>(Landroid/support/v4/app/NotificationCompat$Builder;)V

    invoke-virtual {v0}, Landroid/support/v4/app/NotificationCompatBuilder;->b()Landroid/app/Notification;

    move-result-object v0

    return-object v0
.end method

.method public b(I)Landroid/support/v4/app/NotificationCompat$Builder;
    .locals 2

    .prologue
    .line 1126
    iget-object v0, p0, Landroid/support/v4/app/NotificationCompat$Builder;->M:Landroid/app/Notification;

    iput p1, v0, Landroid/app/Notification;->defaults:I

    .line 1127
    and-int/lit8 v0, p1, 0x4

    if-eqz v0, :cond_0

    .line 1128
    iget-object v0, p0, Landroid/support/v4/app/NotificationCompat$Builder;->M:Landroid/app/Notification;

    iget v1, v0, Landroid/app/Notification;->flags:I

    or-int/lit8 v1, v1, 0x1

    iput v1, v0, Landroid/app/Notification;->flags:I

    .line 1130
    :cond_0
    return-object p0
.end method

.method public b(Landroid/app/PendingIntent;)Landroid/support/v4/app/NotificationCompat$Builder;
    .locals 1

    .prologue
    .line 900
    iget-object v0, p0, Landroid/support/v4/app/NotificationCompat$Builder;->M:Landroid/app/Notification;

    iput-object p1, v0, Landroid/app/Notification;->deleteIntent:Landroid/app/PendingIntent;

    .line 901
    return-object p0
.end method

.method public b(Ljava/lang/CharSequence;)Landroid/support/v4/app/NotificationCompat$Builder;
    .locals 1

    .prologue
    .line 805
    invoke-static {p1}, Landroid/support/v4/app/NotificationCompat$Builder;->d(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;

    move-result-object v0

    iput-object v0, p0, Landroid/support/v4/app/NotificationCompat$Builder;->d:Ljava/lang/CharSequence;

    .line 806
    return-object p0
.end method

.method public b(Z)Landroid/support/v4/app/NotificationCompat$Builder;
    .locals 0

    .prologue
    .line 1099
    iput-boolean p1, p0, Landroid/support/v4/app/NotificationCompat$Builder;->w:Z

    .line 1100
    return-object p0
.end method

.method public c(I)Landroid/support/v4/app/NotificationCompat$Builder;
    .locals 0

    .prologue
    .line 1159
    iput p1, p0, Landroid/support/v4/app/NotificationCompat$Builder;->k:I

    .line 1160
    return-object p0
.end method

.method public c(Ljava/lang/CharSequence;)Landroid/support/v4/app/NotificationCompat$Builder;
    .locals 2

    .prologue
    .line 934
    iget-object v0, p0, Landroid/support/v4/app/NotificationCompat$Builder;->M:Landroid/app/Notification;

    invoke-static {p1}, Landroid/support/v4/app/NotificationCompat$Builder;->d(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;

    move-result-object v1

    iput-object v1, v0, Landroid/app/Notification;->tickerText:Ljava/lang/CharSequence;

    .line 935
    return-object p0
.end method

.method public d(I)Landroid/support/v4/app/NotificationCompat$Builder;
    .locals 0

    .prologue
    .line 1353
    iput p1, p0, Landroid/support/v4/app/NotificationCompat$Builder;->B:I

    .line 1354
    return-object p0
.end method
