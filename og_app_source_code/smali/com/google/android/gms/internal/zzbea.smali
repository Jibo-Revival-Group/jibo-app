.class public final Lcom/google/android/gms/internal/zzbea;
.super Ljava/lang/Object;


# instance fields
.field private a:I

.field private b:Ljava/lang/String;

.field private c:Ljava/lang/String;

.field private d:Ljava/lang/String;

.field private e:I

.field private final f:Lcom/google/android/gms/internal/zzbec;

.field private g:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field private h:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private i:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field private j:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/google/android/gms/internal/zzctx;",
            ">;"
        }
    .end annotation
.end field

.field private k:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<[B>;"
        }
    .end annotation
.end field

.field private l:Z

.field private final m:Lcom/google/android/gms/internal/zzfkq;

.field private n:Z

.field private synthetic o:Lcom/google/android/gms/internal/zzbdy;


# direct methods
.method private constructor <init>(Lcom/google/android/gms/internal/zzbdy;[B)V
    .locals 1

    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Lcom/google/android/gms/internal/zzbea;-><init>(Lcom/google/android/gms/internal/zzbdy;[BLcom/google/android/gms/internal/zzbec;)V

    return-void
.end method

.method synthetic constructor <init>(Lcom/google/android/gms/internal/zzbdy;[BLcom/google/android/gms/internal/zzbdz;)V
    .locals 0

    invoke-direct {p0, p1, p2}, Lcom/google/android/gms/internal/zzbea;-><init>(Lcom/google/android/gms/internal/zzbdy;[B)V

    return-void
.end method

.method private constructor <init>(Lcom/google/android/gms/internal/zzbdy;[BLcom/google/android/gms/internal/zzbec;)V
    .locals 5

    const/4 v1, 0x0

    const/4 v4, 0x0

    iput-object p1, p0, Lcom/google/android/gms/internal/zzbea;->o:Lcom/google/android/gms/internal/zzbdy;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iget-object v0, p0, Lcom/google/android/gms/internal/zzbea;->o:Lcom/google/android/gms/internal/zzbdy;

    invoke-static {v0}, Lcom/google/android/gms/internal/zzbdy;->a(Lcom/google/android/gms/internal/zzbdy;)I

    move-result v0

    iput v0, p0, Lcom/google/android/gms/internal/zzbea;->a:I

    iget-object v0, p0, Lcom/google/android/gms/internal/zzbea;->o:Lcom/google/android/gms/internal/zzbdy;

    invoke-static {v0}, Lcom/google/android/gms/internal/zzbdy;->b(Lcom/google/android/gms/internal/zzbdy;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gms/internal/zzbea;->b:Ljava/lang/String;

    iget-object v0, p0, Lcom/google/android/gms/internal/zzbea;->o:Lcom/google/android/gms/internal/zzbdy;

    iput-object v4, p0, Lcom/google/android/gms/internal/zzbea;->c:Ljava/lang/String;

    iget-object v0, p0, Lcom/google/android/gms/internal/zzbea;->o:Lcom/google/android/gms/internal/zzbdy;

    iput-object v4, p0, Lcom/google/android/gms/internal/zzbea;->d:Ljava/lang/String;

    iput v1, p0, Lcom/google/android/gms/internal/zzbea;->e:I

    iput-object v4, p0, Lcom/google/android/gms/internal/zzbea;->g:Ljava/util/ArrayList;

    iput-object v4, p0, Lcom/google/android/gms/internal/zzbea;->h:Ljava/util/ArrayList;

    iput-object v4, p0, Lcom/google/android/gms/internal/zzbea;->i:Ljava/util/ArrayList;

    iput-object v4, p0, Lcom/google/android/gms/internal/zzbea;->j:Ljava/util/ArrayList;

    iput-object v4, p0, Lcom/google/android/gms/internal/zzbea;->k:Ljava/util/ArrayList;

    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/google/android/gms/internal/zzbea;->l:Z

    new-instance v0, Lcom/google/android/gms/internal/zzfkq;

    invoke-direct {v0}, Lcom/google/android/gms/internal/zzfkq;-><init>()V

    iput-object v0, p0, Lcom/google/android/gms/internal/zzbea;->m:Lcom/google/android/gms/internal/zzfkq;

    iput-boolean v1, p0, Lcom/google/android/gms/internal/zzbea;->n:Z

    iput-object v4, p0, Lcom/google/android/gms/internal/zzbea;->c:Ljava/lang/String;

    iput-object v4, p0, Lcom/google/android/gms/internal/zzbea;->d:Ljava/lang/String;

    iget-object v0, p0, Lcom/google/android/gms/internal/zzbea;->m:Lcom/google/android/gms/internal/zzfkq;

    invoke-static {p1}, Lcom/google/android/gms/internal/zzbdy;->c(Lcom/google/android/gms/internal/zzbdy;)Lcom/google/android/gms/common/util/zzd;

    move-result-object v1

    invoke-interface {v1}, Lcom/google/android/gms/common/util/zzd;->a()J

    move-result-wide v2

    iput-wide v2, v0, Lcom/google/android/gms/internal/zzfkq;->a:J

    iget-object v0, p0, Lcom/google/android/gms/internal/zzbea;->m:Lcom/google/android/gms/internal/zzfkq;

    invoke-static {p1}, Lcom/google/android/gms/internal/zzbdy;->c(Lcom/google/android/gms/internal/zzbdy;)Lcom/google/android/gms/common/util/zzd;

    move-result-object v1

    invoke-interface {v1}, Lcom/google/android/gms/common/util/zzd;->b()J

    move-result-wide v2

    iput-wide v2, v0, Lcom/google/android/gms/internal/zzfkq;->b:J

    iget-object v0, p0, Lcom/google/android/gms/internal/zzbea;->m:Lcom/google/android/gms/internal/zzfkq;

    invoke-static {p1}, Lcom/google/android/gms/internal/zzbdy;->d(Lcom/google/android/gms/internal/zzbdy;)Lcom/google/android/gms/internal/zzbed;

    iget-object v1, p0, Lcom/google/android/gms/internal/zzbea;->m:Lcom/google/android/gms/internal/zzfkq;

    iget-wide v2, v1, Lcom/google/android/gms/internal/zzfkq;->a:J

    invoke-static {}, Ljava/util/TimeZone;->getDefault()Ljava/util/TimeZone;

    move-result-object v1

    invoke-virtual {v1, v2, v3}, Ljava/util/TimeZone;->getOffset(J)I

    move-result v1

    div-int/lit16 v1, v1, 0x3e8

    int-to-long v2, v1

    iput-wide v2, v0, Lcom/google/android/gms/internal/zzfkq;->d:J

    if-eqz p2, :cond_0

    iget-object v0, p0, Lcom/google/android/gms/internal/zzbea;->m:Lcom/google/android/gms/internal/zzfkq;

    iput-object p2, v0, Lcom/google/android/gms/internal/zzfkq;->c:[B

    :cond_0
    iput-object v4, p0, Lcom/google/android/gms/internal/zzbea;->f:Lcom/google/android/gms/internal/zzbec;

    return-void
.end method


# virtual methods
.method public final a()V
    .locals 14

    const/4 v13, 0x0

    iget-boolean v0, p0, Lcom/google/android/gms/internal/zzbea;->n:Z

    if-eqz v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "do not reuse LogEventBuilder"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/google/android/gms/internal/zzbea;->n:Z

    new-instance v12, Lcom/google/android/gms/internal/zzbeh;

    new-instance v0, Lcom/google/android/gms/internal/zzbew;

    iget-object v1, p0, Lcom/google/android/gms/internal/zzbea;->o:Lcom/google/android/gms/internal/zzbdy;

    invoke-static {v1}, Lcom/google/android/gms/internal/zzbdy;->f(Lcom/google/android/gms/internal/zzbdy;)Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/google/android/gms/internal/zzbea;->o:Lcom/google/android/gms/internal/zzbdy;

    invoke-static {v2}, Lcom/google/android/gms/internal/zzbdy;->g(Lcom/google/android/gms/internal/zzbdy;)I

    move-result v2

    iget v3, p0, Lcom/google/android/gms/internal/zzbea;->a:I

    iget-object v4, p0, Lcom/google/android/gms/internal/zzbea;->b:Ljava/lang/String;

    iget-object v5, p0, Lcom/google/android/gms/internal/zzbea;->c:Ljava/lang/String;

    iget-object v6, p0, Lcom/google/android/gms/internal/zzbea;->d:Ljava/lang/String;

    iget-object v7, p0, Lcom/google/android/gms/internal/zzbea;->o:Lcom/google/android/gms/internal/zzbdy;

    invoke-static {v7}, Lcom/google/android/gms/internal/zzbdy;->e(Lcom/google/android/gms/internal/zzbdy;)Z

    move-result v7

    const/4 v8, 0x0

    invoke-direct/range {v0 .. v8}, Lcom/google/android/gms/internal/zzbew;-><init>(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZI)V

    iget-object v3, p0, Lcom/google/android/gms/internal/zzbea;->m:Lcom/google/android/gms/internal/zzfkq;

    invoke-static {v13}, Lcom/google/android/gms/internal/zzbdy;->a(Ljava/util/ArrayList;)[I

    move-result-object v6

    invoke-static {v13}, Lcom/google/android/gms/internal/zzbdy;->a(Ljava/util/ArrayList;)[I

    move-result-object v8

    iget-boolean v11, p0, Lcom/google/android/gms/internal/zzbea;->l:Z

    move-object v1, v12

    move-object v2, v0

    move-object v4, v13

    move-object v5, v13

    move-object v7, v13

    move-object v9, v13

    move-object v10, v13

    invoke-direct/range {v1 .. v11}, Lcom/google/android/gms/internal/zzbeh;-><init>(Lcom/google/android/gms/internal/zzbew;Lcom/google/android/gms/internal/zzfkq;Lcom/google/android/gms/internal/zzbec;Lcom/google/android/gms/internal/zzbec;[I[Ljava/lang/String;[I[[B[Lcom/google/android/gms/internal/zzctx;Z)V

    iget-object v0, v12, Lcom/google/android/gms/internal/zzbeh;->a:Lcom/google/android/gms/internal/zzbew;

    iget-object v1, p0, Lcom/google/android/gms/internal/zzbea;->o:Lcom/google/android/gms/internal/zzbdy;

    invoke-static {v1}, Lcom/google/android/gms/internal/zzbdy;->h(Lcom/google/android/gms/internal/zzbdy;)Lcom/google/android/gms/internal/zzbeb;

    move-result-object v1

    iget-object v2, v0, Lcom/google/android/gms/internal/zzbew;->b:Ljava/lang/String;

    iget v0, v0, Lcom/google/android/gms/internal/zzbew;->a:I

    invoke-interface {v1, v2, v0}, Lcom/google/android/gms/internal/zzbeb;->a(Ljava/lang/String;I)Z

    move-result v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/google/android/gms/internal/zzbea;->o:Lcom/google/android/gms/internal/zzbdy;

    invoke-static {v0}, Lcom/google/android/gms/internal/zzbdy;->i(Lcom/google/android/gms/internal/zzbdy;)Lcom/google/android/gms/internal/zzbee;

    move-result-object v0

    invoke-interface {v0, v12}, Lcom/google/android/gms/internal/zzbee;->a(Lcom/google/android/gms/internal/zzbeh;)Lcom/google/android/gms/common/api/PendingResult;

    :goto_0
    return-void

    :cond_1
    sget-object v0, Lcom/google/android/gms/common/api/Status;->a:Lcom/google/android/gms/common/api/Status;

    invoke-static {v0}, Lcom/google/android/gms/common/api/PendingResults;->a(Lcom/google/android/gms/common/api/Status;)Lcom/google/android/gms/common/api/PendingResult;

    goto :goto_0
.end method
