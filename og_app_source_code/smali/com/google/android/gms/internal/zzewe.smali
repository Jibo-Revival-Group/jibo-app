.class final Lcom/google/android/gms/internal/zzewe;
.super Lcom/google/android/gms/internal/zzewg;


# instance fields
.field private final a:Lcom/google/android/gms/internal/zzewv;


# direct methods
.method constructor <init>(Lcom/google/android/gms/internal/zzewv;)V
    .locals 0

    invoke-direct {p0}, Lcom/google/android/gms/internal/zzewg;-><init>()V

    iput-object p1, p0, Lcom/google/android/gms/internal/zzewe;->a:Lcom/google/android/gms/internal/zzewv;

    return-void
.end method

.method private static a(Ljava/lang/String;)Ljava/net/URI;
    .locals 4

    const/4 v1, 0x0

    if-nez p0, :cond_0

    move-object v0, v1

    :goto_0
    return-object v0

    :cond_0
    :try_start_0
    invoke-static {p0}, Ljava/net/URI;->create(Ljava/lang/String;)Ljava/net/URI;
    :try_end_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/IllegalStateException; {:try_start_0 .. :try_end_0} :catch_1

    move-result-object v0

    goto :goto_0

    :catch_0
    move-exception v0

    :goto_1
    const-string v2, "FirebasePerformance"

    const-string v3, "getResultUrl throws exception"

    invoke-static {v2, v3, v0}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    move-object v0, v1

    goto :goto_0

    :catch_1
    move-exception v0

    goto :goto_1
.end method

.method private static a(J)Z
    .locals 2

    const-wide/16 v0, 0x0

    cmp-long v0, p0, v0

    if-ltz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private static b(J)Z
    .locals 2

    const-wide/16 v0, 0x0

    cmp-long v0, p0, v0

    if-ltz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private static b(Ljava/lang/String;)Z
    .locals 1

    if-nez p0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    invoke-virtual {p0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    goto :goto_0
.end method

.method private static c(Ljava/lang/String;)Z
    .locals 4

    const/4 v1, 0x0

    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v0

    const/16 v2, 0x80

    if-le v0, v2, :cond_1

    :cond_0
    :goto_0
    return v1

    :cond_1
    move v0, v1

    :goto_1
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v2

    if-ge v0, v2, :cond_2

    invoke-virtual {p0, v0}, Ljava/lang/String;->charAt(I)C

    move-result v2

    const/16 v3, 0x1f

    if-le v2, v3, :cond_0

    const/16 v3, 0x7f

    if-gt v2, v3, :cond_0

    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    :cond_2
    const/4 v1, 0x1

    goto :goto_0
.end method


# virtual methods
.method public final a()Z
    .locals 8

    const-wide/16 v6, 0x0

    const/4 v2, 0x1

    const/4 v1, 0x0

    iget-object v0, p0, Lcom/google/android/gms/internal/zzewe;->a:Lcom/google/android/gms/internal/zzewv;

    iget-object v0, v0, Lcom/google/android/gms/internal/zzewv;->a:Ljava/lang/String;

    invoke-static {v0}, Lcom/google/android/gms/internal/zzewe;->b(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    const-string v2, "FirebasePerformance"

    const-string v3, "URL is missing:"

    iget-object v0, p0, Lcom/google/android/gms/internal/zzewe;->a:Lcom/google/android/gms/internal/zzewv;

    iget-object v0, v0, Lcom/google/android/gms/internal/zzewv;->a:Ljava/lang/String;

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v4

    if-eqz v4, :cond_0

    invoke-virtual {v3, v0}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    :goto_0
    invoke-static {v2, v0}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    move v0, v1

    :goto_1
    return v0

    :cond_0
    new-instance v0, Ljava/lang/String;

    invoke-direct {v0, v3}, Ljava/lang/String;-><init>(Ljava/lang/String;)V

    goto :goto_0

    :cond_1
    iget-object v0, p0, Lcom/google/android/gms/internal/zzewe;->a:Lcom/google/android/gms/internal/zzewv;

    iget-object v0, v0, Lcom/google/android/gms/internal/zzewv;->a:Ljava/lang/String;

    invoke-static {v0}, Lcom/google/android/gms/internal/zzewe;->a(Ljava/lang/String;)Ljava/net/URI;

    move-result-object v3

    if-nez v3, :cond_2

    const-string v0, "FirebasePerformance"

    const-string v2, "URL cannot be parsed"

    invoke-static {v0, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    move v0, v1

    goto :goto_1

    :cond_2
    invoke-virtual {v3}, Ljava/net/URI;->getHost()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_3

    invoke-static {v0}, Lcom/google/android/gms/internal/zzewe;->b(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_3

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    const/16 v4, 0xff

    if-gt v0, v4, :cond_3

    move v0, v2

    :goto_2
    if-nez v0, :cond_4

    const-string v0, "FirebasePerformance"

    const-string v2, "URL host is null or invalid"

    invoke-static {v0, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    move v0, v1

    goto :goto_1

    :cond_3
    move v0, v1

    goto :goto_2

    :cond_4
    invoke-virtual {v3}, Ljava/net/URI;->getScheme()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_6

    const-string v4, "http"

    invoke-virtual {v4, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_5

    const-string v4, "https"

    invoke-virtual {v4, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_6

    :cond_5
    move v0, v2

    :goto_3
    if-nez v0, :cond_7

    const-string v0, "FirebasePerformance"

    const-string v2, "URL scheme is null or invalid"

    invoke-static {v0, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    move v0, v1

    goto :goto_1

    :cond_6
    move v0, v1

    goto :goto_3

    :cond_7
    invoke-virtual {v3}, Ljava/net/URI;->getUserInfo()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_8

    move v0, v2

    :goto_4
    if-nez v0, :cond_9

    const-string v0, "FirebasePerformance"

    const-string v2, "URL user info is null"

    invoke-static {v0, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    move v0, v1

    goto :goto_1

    :cond_8
    move v0, v1

    goto :goto_4

    :cond_9
    invoke-virtual {v3}, Ljava/net/URI;->getPort()I

    move-result v0

    const/4 v3, -0x1

    if-eq v0, v3, :cond_a

    if-lez v0, :cond_b

    :cond_a
    move v0, v2

    :goto_5
    if-nez v0, :cond_c

    const-string v0, "FirebasePerformance"

    const-string v2, "URL port is less than or equal to 0"

    invoke-static {v0, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    move v0, v1

    goto/16 :goto_1

    :cond_b
    move v0, v1

    goto :goto_5

    :cond_c
    iget-object v0, p0, Lcom/google/android/gms/internal/zzewe;->a:Lcom/google/android/gms/internal/zzewv;

    iget-object v0, v0, Lcom/google/android/gms/internal/zzewv;->b:Ljava/lang/Integer;

    if-eqz v0, :cond_d

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    if-eqz v0, :cond_d

    move v0, v2

    :goto_6
    if-nez v0, :cond_e

    const-string v0, "FirebasePerformance"

    iget-object v2, p0, Lcom/google/android/gms/internal/zzewe;->a:Lcom/google/android/gms/internal/zzewv;

    iget-object v2, v2, Lcom/google/android/gms/internal/zzewv;->b:Ljava/lang/Integer;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    add-int/lit8 v3, v3, 0x20

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4, v3}, Ljava/lang/StringBuilder;-><init>(I)V

    const-string v3, "HTTP Method is null or invalid: "

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    move v0, v1

    goto/16 :goto_1

    :cond_d
    move v0, v1

    goto :goto_6

    :cond_e
    iget-object v0, p0, Lcom/google/android/gms/internal/zzewe;->a:Lcom/google/android/gms/internal/zzewv;

    iget-object v0, v0, Lcom/google/android/gms/internal/zzewv;->f:Ljava/lang/Integer;

    if-eqz v0, :cond_10

    iget-object v0, p0, Lcom/google/android/gms/internal/zzewe;->a:Lcom/google/android/gms/internal/zzewv;

    iget-object v0, v0, Lcom/google/android/gms/internal/zzewv;->f:Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    if-lez v0, :cond_f

    move v0, v2

    :goto_7
    if-nez v0, :cond_10

    const-string v0, "FirebasePerformance"

    iget-object v2, p0, Lcom/google/android/gms/internal/zzewe;->a:Lcom/google/android/gms/internal/zzewv;

    iget-object v2, v2, Lcom/google/android/gms/internal/zzewv;->f:Ljava/lang/Integer;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    add-int/lit8 v3, v3, 0x26

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4, v3}, Ljava/lang/StringBuilder;-><init>(I)V

    const-string v3, "HTTP ResponseCode is a negative value:"

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    move v0, v1

    goto/16 :goto_1

    :cond_f
    move v0, v1

    goto :goto_7

    :cond_10
    iget-object v0, p0, Lcom/google/android/gms/internal/zzewe;->a:Lcom/google/android/gms/internal/zzewv;

    iget-object v0, v0, Lcom/google/android/gms/internal/zzewv;->c:Ljava/lang/Long;

    if-eqz v0, :cond_11

    iget-object v0, p0, Lcom/google/android/gms/internal/zzewe;->a:Lcom/google/android/gms/internal/zzewv;

    iget-object v0, v0, Lcom/google/android/gms/internal/zzewv;->c:Ljava/lang/Long;

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    invoke-static {v4, v5}, Lcom/google/android/gms/internal/zzewe;->b(J)Z

    move-result v0

    if-nez v0, :cond_11

    const-string v0, "FirebasePerformance"

    iget-object v2, p0, Lcom/google/android/gms/internal/zzewe;->a:Lcom/google/android/gms/internal/zzewv;

    iget-object v2, v2, Lcom/google/android/gms/internal/zzewv;->c:Ljava/lang/Long;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    add-int/lit8 v3, v3, 0x24

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4, v3}, Ljava/lang/StringBuilder;-><init>(I)V

    const-string v3, "Request Payload is a negative value:"

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    move v0, v1

    goto/16 :goto_1

    :cond_11
    iget-object v0, p0, Lcom/google/android/gms/internal/zzewe;->a:Lcom/google/android/gms/internal/zzewv;

    iget-object v0, v0, Lcom/google/android/gms/internal/zzewv;->d:Ljava/lang/Long;

    if-eqz v0, :cond_12

    iget-object v0, p0, Lcom/google/android/gms/internal/zzewe;->a:Lcom/google/android/gms/internal/zzewv;

    iget-object v0, v0, Lcom/google/android/gms/internal/zzewv;->d:Ljava/lang/Long;

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    invoke-static {v4, v5}, Lcom/google/android/gms/internal/zzewe;->b(J)Z

    move-result v0

    if-nez v0, :cond_12

    const-string v0, "FirebasePerformance"

    iget-object v2, p0, Lcom/google/android/gms/internal/zzewe;->a:Lcom/google/android/gms/internal/zzewv;

    iget-object v2, v2, Lcom/google/android/gms/internal/zzewv;->d:Ljava/lang/Long;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    add-int/lit8 v3, v3, 0x25

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4, v3}, Ljava/lang/StringBuilder;-><init>(I)V

    const-string v3, "Response Payload is a negative value:"

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    move v0, v1

    goto/16 :goto_1

    :cond_12
    iget-object v0, p0, Lcom/google/android/gms/internal/zzewe;->a:Lcom/google/android/gms/internal/zzewv;

    iget-object v0, v0, Lcom/google/android/gms/internal/zzewv;->h:Ljava/lang/Long;

    if-eqz v0, :cond_13

    iget-object v0, p0, Lcom/google/android/gms/internal/zzewe;->a:Lcom/google/android/gms/internal/zzewv;

    iget-object v0, v0, Lcom/google/android/gms/internal/zzewv;->h:Ljava/lang/Long;

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    cmp-long v0, v4, v6

    if-gtz v0, :cond_14

    :cond_13
    const-string v0, "FirebasePerformance"

    iget-object v2, p0, Lcom/google/android/gms/internal/zzewe;->a:Lcom/google/android/gms/internal/zzewv;

    iget-object v2, v2, Lcom/google/android/gms/internal/zzewv;->h:Ljava/lang/Long;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    add-int/lit8 v3, v3, 0x40

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4, v3}, Ljava/lang/StringBuilder;-><init>(I)V

    const-string v3, "Start time of the request is null, or zero, or a negative value:"

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    move v0, v1

    goto/16 :goto_1

    :cond_14
    iget-object v0, p0, Lcom/google/android/gms/internal/zzewe;->a:Lcom/google/android/gms/internal/zzewv;

    iget-object v0, v0, Lcom/google/android/gms/internal/zzewv;->i:Ljava/lang/Long;

    if-eqz v0, :cond_15

    iget-object v0, p0, Lcom/google/android/gms/internal/zzewe;->a:Lcom/google/android/gms/internal/zzewv;

    iget-object v0, v0, Lcom/google/android/gms/internal/zzewv;->i:Ljava/lang/Long;

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    invoke-static {v4, v5}, Lcom/google/android/gms/internal/zzewe;->a(J)Z

    move-result v0

    if-nez v0, :cond_15

    const-string v0, "FirebasePerformance"

    iget-object v2, p0, Lcom/google/android/gms/internal/zzewe;->a:Lcom/google/android/gms/internal/zzewv;

    iget-object v2, v2, Lcom/google/android/gms/internal/zzewv;->i:Ljava/lang/Long;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    add-int/lit8 v3, v3, 0x31

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4, v3}, Ljava/lang/StringBuilder;-><init>(I)V

    const-string v3, "Time to complete the request is a negative value:"

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    move v0, v1

    goto/16 :goto_1

    :cond_15
    iget-object v0, p0, Lcom/google/android/gms/internal/zzewe;->a:Lcom/google/android/gms/internal/zzewv;

    iget-object v0, v0, Lcom/google/android/gms/internal/zzewv;->j:Ljava/lang/Long;

    if-eqz v0, :cond_16

    iget-object v0, p0, Lcom/google/android/gms/internal/zzewe;->a:Lcom/google/android/gms/internal/zzewv;

    iget-object v0, v0, Lcom/google/android/gms/internal/zzewv;->j:Ljava/lang/Long;

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    invoke-static {v4, v5}, Lcom/google/android/gms/internal/zzewe;->a(J)Z

    move-result v0

    if-nez v0, :cond_16

    const-string v0, "FirebasePerformance"

    iget-object v2, p0, Lcom/google/android/gms/internal/zzewe;->a:Lcom/google/android/gms/internal/zzewv;

    iget-object v2, v2, Lcom/google/android/gms/internal/zzewv;->j:Ljava/lang/Long;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    add-int/lit8 v3, v3, 0x5c

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4, v3}, Ljava/lang/StringBuilder;-><init>(I)V

    const-string v3, "Time from the start of the request to the start of the response is null or a negative value:"

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    move v0, v1

    goto/16 :goto_1

    :cond_16
    iget-object v0, p0, Lcom/google/android/gms/internal/zzewe;->a:Lcom/google/android/gms/internal/zzewv;

    iget-object v0, v0, Lcom/google/android/gms/internal/zzewv;->k:Ljava/lang/Long;

    if-eqz v0, :cond_17

    iget-object v0, p0, Lcom/google/android/gms/internal/zzewe;->a:Lcom/google/android/gms/internal/zzewv;

    iget-object v0, v0, Lcom/google/android/gms/internal/zzewv;->k:Ljava/lang/Long;

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    cmp-long v0, v4, v6

    if-gtz v0, :cond_18

    :cond_17
    const-string v0, "FirebasePerformance"

    iget-object v2, p0, Lcom/google/android/gms/internal/zzewe;->a:Lcom/google/android/gms/internal/zzewv;

    iget-object v2, v2, Lcom/google/android/gms/internal/zzewv;->k:Ljava/lang/Long;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    add-int/lit8 v3, v3, 0x58

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4, v3}, Ljava/lang/StringBuilder;-><init>(I)V

    const-string v3, "Time from the start of the request to the end of the response is null, negative or zero:"

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    move v0, v1

    goto/16 :goto_1

    :cond_18
    iget-object v0, p0, Lcom/google/android/gms/internal/zzewe;->a:Lcom/google/android/gms/internal/zzewv;

    iget-object v0, v0, Lcom/google/android/gms/internal/zzewv;->f:Ljava/lang/Integer;

    if-nez v0, :cond_19

    const-string v0, "FirebasePerformance"

    const-string v2, "Did not receive a HTTP Response Code"

    invoke-static {v0, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    move v0, v1

    goto/16 :goto_1

    :cond_19
    iget-object v0, p0, Lcom/google/android/gms/internal/zzewe;->a:Lcom/google/android/gms/internal/zzewv;

    iget-object v0, v0, Lcom/google/android/gms/internal/zzewv;->g:Ljava/lang/String;

    if-eqz v0, :cond_1a

    iget-object v0, p0, Lcom/google/android/gms/internal/zzewe;->a:Lcom/google/android/gms/internal/zzewv;

    iget-object v0, v0, Lcom/google/android/gms/internal/zzewv;->g:Ljava/lang/String;

    invoke-static {v0}, Lcom/google/android/gms/internal/zzewe;->c(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_1a

    const-string v1, "FirebasePerformance"

    const-string v3, "The content type of the response is not a valid content-type:"

    iget-object v0, p0, Lcom/google/android/gms/internal/zzewe;->a:Lcom/google/android/gms/internal/zzewv;

    iget-object v0, v0, Lcom/google/android/gms/internal/zzewv;->g:Ljava/lang/String;

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v4

    if-eqz v4, :cond_1b

    invoke-virtual {v3, v0}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    :goto_8
    invoke-static {v1, v0}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    iget-object v0, p0, Lcom/google/android/gms/internal/zzewe;->a:Lcom/google/android/gms/internal/zzewv;

    const/4 v1, 0x0

    iput-object v1, v0, Lcom/google/android/gms/internal/zzewv;->g:Ljava/lang/String;

    :cond_1a
    move v0, v2

    goto/16 :goto_1

    :cond_1b
    new-instance v0, Ljava/lang/String;

    invoke-direct {v0, v3}, Ljava/lang/String;-><init>(Ljava/lang/String;)V

    goto :goto_8
.end method
