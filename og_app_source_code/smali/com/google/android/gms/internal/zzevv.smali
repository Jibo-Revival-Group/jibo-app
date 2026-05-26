.class public final Lcom/google/android/gms/internal/zzevv;
.super Lcom/google/android/gms/internal/zzevx;


# instance fields
.field private a:Lcom/google/android/gms/internal/zzevz;

.field private b:Z

.field private c:J

.field private d:Z

.field private e:Ljava/lang/String;

.field private f:Ljava/lang/Integer;

.field private g:Ljava/lang/Long;

.field private h:Ljava/lang/Long;

.field private i:Ljava/lang/Integer;

.field private j:Ljava/lang/Integer;

.field private k:Ljava/lang/String;

.field private l:Ljava/lang/Long;

.field private m:Ljava/lang/Long;

.field private n:Ljava/lang/Long;

.field private o:Ljava/lang/Long;

.field private p:[Lcom/google/android/gms/internal/zzeww;


# direct methods
.method private constructor <init>(Lcom/google/android/gms/internal/zzevz;)V
    .locals 1

    invoke-static {}, Lcom/google/android/gms/internal/zzevw;->a()Lcom/google/android/gms/internal/zzevw;

    move-result-object v0

    invoke-direct {p0, p1, v0}, Lcom/google/android/gms/internal/zzevv;-><init>(Lcom/google/android/gms/internal/zzevz;Lcom/google/android/gms/internal/zzevw;)V

    return-void
.end method

.method private constructor <init>(Lcom/google/android/gms/internal/zzevz;Lcom/google/android/gms/internal/zzevw;)V
    .locals 3

    const/4 v2, 0x0

    invoke-direct {p0, p2}, Lcom/google/android/gms/internal/zzevx;-><init>(Lcom/google/android/gms/internal/zzevw;)V

    iput-boolean v2, p0, Lcom/google/android/gms/internal/zzevv;->b:Z

    const-wide/16 v0, -0x1

    iput-wide v0, p0, Lcom/google/android/gms/internal/zzevv;->c:J

    iput-boolean v2, p0, Lcom/google/android/gms/internal/zzevv;->d:Z

    iput-object p1, p0, Lcom/google/android/gms/internal/zzevv;->a:Lcom/google/android/gms/internal/zzevz;

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzevx;->e()V

    return-void
.end method

.method public static a(Lcom/google/android/gms/internal/zzevz;)Lcom/google/android/gms/internal/zzevv;
    .locals 1

    new-instance v0, Lcom/google/android/gms/internal/zzevv;

    invoke-direct {v0, p0}, Lcom/google/android/gms/internal/zzevv;-><init>(Lcom/google/android/gms/internal/zzevz;)V

    return-object v0
.end method


# virtual methods
.method public final a(I)Lcom/google/android/gms/internal/zzevv;
    .locals 1

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gms/internal/zzevv;->j:Ljava/lang/Integer;

    return-object p0
.end method

.method public final a(J)Lcom/google/android/gms/internal/zzevv;
    .locals 1

    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gms/internal/zzevv;->g:Ljava/lang/Long;

    return-object p0
.end method

.method public final a(Ljava/lang/String;)Lcom/google/android/gms/internal/zzevv;
    .locals 2

    if-eqz p1, :cond_0

    invoke-static {p1}, Lcom/google/android/gms/internal/zzewq;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const/16 v1, 0x7d0

    invoke-static {v0, v1}, Lcom/google/android/gms/internal/zzewq;->a(Ljava/lang/String;I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gms/internal/zzevv;->e:Ljava/lang/String;

    :cond_0
    return-object p0
.end method

.method public final a()Ljava/lang/Integer;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/zzevv;->j:Ljava/lang/Integer;

    return-object v0
.end method

.method public final b()Lcom/google/android/gms/internal/zzevv;
    .locals 1

    const/4 v0, 0x1

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gms/internal/zzevv;->i:Ljava/lang/Integer;

    return-object p0
.end method

.method public final b(J)Lcom/google/android/gms/internal/zzevv;
    .locals 1

    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gms/internal/zzevv;->h:Ljava/lang/Long;

    return-object p0
.end method

.method public final b(Ljava/lang/String;)Lcom/google/android/gms/internal/zzevv;
    .locals 8

    const/4 v5, 0x4

    const/4 v4, 0x3

    const/4 v3, 0x2

    const/4 v2, 0x1

    const/4 v1, 0x0

    if-eqz p1, :cond_1

    invoke-virtual {p1}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object v6

    const/4 v0, -0x1

    invoke-virtual {v6}, Ljava/lang/String;->hashCode()I

    move-result v7

    sparse-switch v7, :sswitch_data_0

    :cond_0
    :goto_0
    packed-switch v0, :pswitch_data_0

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gms/internal/zzevv;->f:Ljava/lang/Integer;

    :cond_1
    :goto_1
    return-object p0

    :sswitch_0
    const-string v7, "GET"

    invoke-virtual {v6, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_0

    move v0, v1

    goto :goto_0

    :sswitch_1
    const-string v7, "PUT"

    invoke-virtual {v6, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_0

    move v0, v2

    goto :goto_0

    :sswitch_2
    const-string v7, "POST"

    invoke-virtual {v6, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_0

    move v0, v3

    goto :goto_0

    :sswitch_3
    const-string v7, "DELETE"

    invoke-virtual {v6, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_0

    move v0, v4

    goto :goto_0

    :sswitch_4
    const-string v7, "HEAD"

    invoke-virtual {v6, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_0

    move v0, v5

    goto :goto_0

    :sswitch_5
    const-string v7, "PATCH"

    invoke-virtual {v6, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_0

    const/4 v0, 0x5

    goto :goto_0

    :sswitch_6
    const-string v7, "OPTIONS"

    invoke-virtual {v6, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_0

    const/4 v0, 0x6

    goto :goto_0

    :sswitch_7
    const-string v7, "TRACE"

    invoke-virtual {v6, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_0

    const/4 v0, 0x7

    goto :goto_0

    :sswitch_8
    const-string v7, "CONNECT"

    invoke-virtual {v6, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_0

    const/16 v0, 0x8

    goto :goto_0

    :pswitch_0
    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gms/internal/zzevv;->f:Ljava/lang/Integer;

    goto :goto_1

    :pswitch_1
    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gms/internal/zzevv;->f:Ljava/lang/Integer;

    goto :goto_1

    :pswitch_2
    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gms/internal/zzevv;->f:Ljava/lang/Integer;

    goto :goto_1

    :pswitch_3
    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gms/internal/zzevv;->f:Ljava/lang/Integer;

    goto :goto_1

    :pswitch_4
    const/4 v0, 0x5

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gms/internal/zzevv;->f:Ljava/lang/Integer;

    goto :goto_1

    :pswitch_5
    const/4 v0, 0x6

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gms/internal/zzevv;->f:Ljava/lang/Integer;

    goto/16 :goto_1

    :pswitch_6
    const/4 v0, 0x7

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gms/internal/zzevv;->f:Ljava/lang/Integer;

    goto/16 :goto_1

    :pswitch_7
    const/16 v0, 0x8

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gms/internal/zzevv;->f:Ljava/lang/Integer;

    goto/16 :goto_1

    :pswitch_8
    const/16 v0, 0x9

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gms/internal/zzevv;->f:Ljava/lang/Integer;

    goto/16 :goto_1

    :sswitch_data_0
    .sparse-switch
        -0x1faded82 -> :sswitch_6
        0x11336 -> :sswitch_0
        0x136ef -> :sswitch_1
        0x21c5e0 -> :sswitch_4
        0x2590a0 -> :sswitch_2
        0x4862828 -> :sswitch_5
        0x4c5f925 -> :sswitch_7
        0x638004ca -> :sswitch_8
        0x77f979ab -> :sswitch_3
    .end sparse-switch

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_6
        :pswitch_7
        :pswitch_8
    .end packed-switch
.end method

.method public final c()J
    .locals 2

    iget-wide v0, p0, Lcom/google/android/gms/internal/zzevv;->c:J

    return-wide v0
.end method

.method public final c(J)Lcom/google/android/gms/internal/zzevv;
    .locals 1

    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gms/internal/zzevv;->l:Ljava/lang/Long;

    return-object p0
.end method

.method public final c(Ljava/lang/String;)Lcom/google/android/gms/internal/zzevv;
    .locals 0

    if-eqz p1, :cond_0

    iput-object p1, p0, Lcom/google/android/gms/internal/zzevv;->k:Ljava/lang/String;

    :cond_0
    return-object p0
.end method

.method public final d(J)Lcom/google/android/gms/internal/zzevv;
    .locals 1

    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gms/internal/zzevv;->m:Ljava/lang/Long;

    return-object p0
.end method

.method public final d()Lcom/google/android/gms/internal/zzewv;
    .locals 3

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzevx;->f()V

    new-instance v0, Lcom/google/android/gms/internal/zzewv;

    invoke-direct {v0}, Lcom/google/android/gms/internal/zzewv;-><init>()V

    iget-object v1, p0, Lcom/google/android/gms/internal/zzevv;->e:Ljava/lang/String;

    iput-object v1, v0, Lcom/google/android/gms/internal/zzewv;->a:Ljava/lang/String;

    iget-object v1, p0, Lcom/google/android/gms/internal/zzevv;->f:Ljava/lang/Integer;

    iput-object v1, v0, Lcom/google/android/gms/internal/zzewv;->b:Ljava/lang/Integer;

    iget-object v1, p0, Lcom/google/android/gms/internal/zzevv;->g:Ljava/lang/Long;

    iput-object v1, v0, Lcom/google/android/gms/internal/zzewv;->c:Ljava/lang/Long;

    iget-object v1, p0, Lcom/google/android/gms/internal/zzevv;->h:Ljava/lang/Long;

    iput-object v1, v0, Lcom/google/android/gms/internal/zzewv;->d:Ljava/lang/Long;

    iget-object v1, p0, Lcom/google/android/gms/internal/zzevv;->i:Ljava/lang/Integer;

    iput-object v1, v0, Lcom/google/android/gms/internal/zzewv;->e:Ljava/lang/Integer;

    iget-object v1, p0, Lcom/google/android/gms/internal/zzevv;->j:Ljava/lang/Integer;

    iput-object v1, v0, Lcom/google/android/gms/internal/zzewv;->f:Ljava/lang/Integer;

    iget-object v1, p0, Lcom/google/android/gms/internal/zzevv;->k:Ljava/lang/String;

    iput-object v1, v0, Lcom/google/android/gms/internal/zzewv;->g:Ljava/lang/String;

    iget-object v1, p0, Lcom/google/android/gms/internal/zzevv;->l:Ljava/lang/Long;

    iput-object v1, v0, Lcom/google/android/gms/internal/zzewv;->h:Ljava/lang/Long;

    iget-object v1, p0, Lcom/google/android/gms/internal/zzevv;->m:Ljava/lang/Long;

    iput-object v1, v0, Lcom/google/android/gms/internal/zzewv;->i:Ljava/lang/Long;

    iget-object v1, p0, Lcom/google/android/gms/internal/zzevv;->n:Ljava/lang/Long;

    iput-object v1, v0, Lcom/google/android/gms/internal/zzewv;->j:Ljava/lang/Long;

    iget-object v1, p0, Lcom/google/android/gms/internal/zzevv;->o:Ljava/lang/Long;

    iput-object v1, v0, Lcom/google/android/gms/internal/zzewv;->k:Ljava/lang/Long;

    iget-object v1, p0, Lcom/google/android/gms/internal/zzevv;->p:[Lcom/google/android/gms/internal/zzeww;

    iput-object v1, v0, Lcom/google/android/gms/internal/zzewv;->l:[Lcom/google/android/gms/internal/zzeww;

    iget-boolean v1, p0, Lcom/google/android/gms/internal/zzevv;->b:Z

    if-nez v1, :cond_2

    iget-object v1, p0, Lcom/google/android/gms/internal/zzevv;->a:Lcom/google/android/gms/internal/zzevz;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/google/android/gms/internal/zzevv;->a:Lcom/google/android/gms/internal/zzevz;

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzevx;->g()I

    move-result v2

    invoke-virtual {v1, v0, v2}, Lcom/google/android/gms/internal/zzevz;->a(Lcom/google/android/gms/internal/zzewv;I)V

    :cond_0
    const/4 v1, 0x1

    iput-boolean v1, p0, Lcom/google/android/gms/internal/zzevv;->b:Z

    :cond_1
    :goto_0
    return-object v0

    :cond_2
    iget-boolean v1, p0, Lcom/google/android/gms/internal/zzevv;->d:Z

    if-eqz v1, :cond_1

    const-string v1, "FirebasePerformance"

    const-string v2, "This metric has already been queued for transmission.  Please create a new HttpMetric for each request/response"

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method

.method public final e(J)Lcom/google/android/gms/internal/zzevv;
    .locals 1

    iput-wide p1, p0, Lcom/google/android/gms/internal/zzevv;->c:J

    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gms/internal/zzevv;->n:Ljava/lang/Long;

    return-object p0
.end method

.method public final f(J)Lcom/google/android/gms/internal/zzevv;
    .locals 1

    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gms/internal/zzevv;->o:Ljava/lang/Long;

    return-object p0
.end method
