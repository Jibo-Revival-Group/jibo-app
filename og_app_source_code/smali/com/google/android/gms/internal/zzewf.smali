.class final Lcom/google/android/gms/internal/zzewf;
.super Lcom/google/android/gms/internal/zzewg;


# instance fields
.field private a:Lcom/google/android/gms/internal/zzewy;


# direct methods
.method constructor <init>(Lcom/google/android/gms/internal/zzewy;)V
    .locals 0

    invoke-direct {p0}, Lcom/google/android/gms/internal/zzewg;-><init>()V

    iput-object p1, p0, Lcom/google/android/gms/internal/zzewf;->a:Lcom/google/android/gms/internal/zzewy;

    return-void
.end method

.method private static a(Lcom/google/android/gms/internal/zzewy;)Z
    .locals 6

    const/4 v0, 0x1

    const/4 v1, 0x0

    iget-object v2, p0, Lcom/google/android/gms/internal/zzewy;->d:[Lcom/google/android/gms/internal/zzewz;

    array-length v2, v2

    if-lez v2, :cond_1

    move v2, v0

    :goto_0
    if-eqz v2, :cond_2

    :cond_0
    :goto_1
    return v0

    :cond_1
    move v2, v1

    goto :goto_0

    :cond_2
    iget-object v4, p0, Lcom/google/android/gms/internal/zzewy;->e:[Lcom/google/android/gms/internal/zzewy;

    array-length v5, v4

    move v3, v1

    :goto_2
    if-ge v3, v5, :cond_4

    aget-object v2, v4, v3

    iget-object v2, v2, Lcom/google/android/gms/internal/zzewy;->d:[Lcom/google/android/gms/internal/zzewz;

    array-length v2, v2

    if-lez v2, :cond_3

    move v2, v0

    :goto_3
    if-nez v2, :cond_0

    add-int/lit8 v2, v3, 0x1

    move v3, v2

    goto :goto_2

    :cond_3
    move v2, v1

    goto :goto_3

    :cond_4
    move v0, v1

    goto :goto_1
.end method

.method private final a(Lcom/google/android/gms/internal/zzewy;I)Z
    .locals 7

    const/4 v0, 0x1

    const/4 v1, 0x0

    if-nez p1, :cond_1

    const-string v0, "FirebasePerformance"

    const-string v2, "TraceMetric is null"

    invoke-static {v0, v2}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    move v0, v1

    :cond_0
    :goto_0
    return v0

    :cond_1
    if-le p2, v0, :cond_2

    const-string v0, "FirebasePerformance"

    const-string v2, "Exceed MAX_SUBTRACE_DEEP:1"

    invoke-static {v0, v2}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    move v0, v1

    goto :goto_0

    :cond_2
    iget-object v2, p1, Lcom/google/android/gms/internal/zzewy;->a:Ljava/lang/String;

    if-eqz v2, :cond_3

    invoke-virtual {v2}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/String;->isEmpty()Z

    move-result v3

    if-nez v3, :cond_3

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v2

    const/16 v3, 0x64

    if-gt v2, v3, :cond_3

    move v2, v0

    :goto_1
    if-nez v2, :cond_5

    const-string v2, "FirebasePerformance"

    const-string v3, "invalid TraceId:"

    iget-object v0, p1, Lcom/google/android/gms/internal/zzewy;->a:Ljava/lang/String;

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v4

    if-eqz v4, :cond_4

    invoke-virtual {v3, v0}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    :goto_2
    invoke-static {v2, v0}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    move v0, v1

    goto :goto_0

    :cond_3
    move v2, v1

    goto :goto_1

    :cond_4
    new-instance v0, Ljava/lang/String;

    invoke-direct {v0, v3}, Ljava/lang/String;-><init>(Ljava/lang/String;)V

    goto :goto_2

    :cond_5
    if-eqz p1, :cond_6

    iget-object v2, p1, Lcom/google/android/gms/internal/zzewy;->c:Ljava/lang/Long;

    if-eqz v2, :cond_6

    iget-object v2, p1, Lcom/google/android/gms/internal/zzewy;->c:Ljava/lang/Long;

    invoke-virtual {v2}, Ljava/lang/Long;->longValue()J

    move-result-wide v2

    const-wide/16 v4, 0x0

    cmp-long v2, v2, v4

    if-lez v2, :cond_6

    move v2, v0

    :goto_3
    if-nez v2, :cond_7

    const-string v0, "FirebasePerformance"

    iget-object v2, p1, Lcom/google/android/gms/internal/zzewy;->c:Ljava/lang/Long;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    add-int/lit8 v3, v3, 0x16

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4, v3}, Ljava/lang/StringBuilder;-><init>(I)V

    const-string v3, "invalid TraceDuration:"

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v2}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    move v0, v1

    goto/16 :goto_0

    :cond_6
    move v2, v1

    goto :goto_3

    :cond_7
    iget-object v2, p1, Lcom/google/android/gms/internal/zzewy;->b:Ljava/lang/Long;

    if-nez v2, :cond_8

    const-string v0, "FirebasePerformance"

    const-string v2, "clientStartTimeUs is null."

    invoke-static {v0, v2}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    move v0, v1

    goto/16 :goto_0

    :cond_8
    iget-object v3, p1, Lcom/google/android/gms/internal/zzewy;->e:[Lcom/google/android/gms/internal/zzewy;

    array-length v4, v3

    move v2, v1

    :goto_4
    if-ge v2, v4, :cond_a

    aget-object v5, v3, v2

    add-int/lit8 v6, p2, 0x1

    invoke-direct {p0, v5, v6}, Lcom/google/android/gms/internal/zzewf;->a(Lcom/google/android/gms/internal/zzewy;I)Z

    move-result v5

    if-nez v5, :cond_9

    move v0, v1

    goto/16 :goto_0

    :cond_9
    add-int/lit8 v2, v2, 0x1

    goto :goto_4

    :cond_a
    iget-object v2, p1, Lcom/google/android/gms/internal/zzewy;->f:[Lcom/google/android/gms/internal/zzexa;

    if-eqz v2, :cond_0

    iget-object v2, p1, Lcom/google/android/gms/internal/zzewy;->f:[Lcom/google/android/gms/internal/zzexa;

    invoke-static {v2}, Lcom/google/android/gms/internal/zzewf;->a([Lcom/google/android/gms/internal/zzexa;)Z

    move-result v2

    if-nez v2, :cond_0

    move v0, v1

    goto/16 :goto_0
.end method

.method private static a([Lcom/google/android/gms/internal/zzexa;)Z
    .locals 6

    const/4 v0, 0x0

    array-length v2, p0

    move v1, v0

    :goto_0
    if-ge v1, v2, :cond_1

    aget-object v3, p0, v1

    new-instance v4, Ljava/util/AbstractMap$SimpleEntry;

    iget-object v5, v3, Lcom/google/android/gms/internal/zzexa;->a:Ljava/lang/String;

    iget-object v3, v3, Lcom/google/android/gms/internal/zzexa;->b:Ljava/lang/String;

    invoke-direct {v4, v5, v3}, Ljava/util/AbstractMap$SimpleEntry;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    invoke-static {v4}, Lcom/google/android/gms/internal/zzewg;->a(Ljava/util/AbstractMap$SimpleEntry;)Ljava/lang/String;

    move-result-object v3

    if-eqz v3, :cond_0

    const-string v1, "FirebasePerformance"

    invoke-static {v1, v3}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    :goto_1
    return v0

    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    :cond_1
    const/4 v0, 0x1

    goto :goto_1
.end method

.method private final b(Lcom/google/android/gms/internal/zzewy;I)Z
    .locals 12

    const/4 v0, 0x1

    const/4 v1, 0x0

    if-nez p1, :cond_1

    move v0, v1

    :cond_0
    :goto_0
    return v0

    :cond_1
    if-le p2, v0, :cond_2

    const-string v0, "FirebasePerformance"

    const-string v2, "Exceed MAX_SUBTRACE_DEEP:1"

    invoke-static {v0, v2}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    move v0, v1

    goto :goto_0

    :cond_2
    iget-object v4, p1, Lcom/google/android/gms/internal/zzewy;->d:[Lcom/google/android/gms/internal/zzewz;

    array-length v5, v4

    move v3, v1

    :goto_1
    if-ge v3, v5, :cond_a

    aget-object v6, v4, v3

    iget-object v2, v6, Lcom/google/android/gms/internal/zzewz;->a:Ljava/lang/String;

    if-nez v2, :cond_3

    move v2, v1

    :goto_2
    if-nez v2, :cond_7

    const-string v2, "FirebasePerformance"

    const-string v3, "invalid CounterId:"

    iget-object v0, v6, Lcom/google/android/gms/internal/zzewz;->a:Ljava/lang/String;

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v4

    if-eqz v4, :cond_6

    invoke-virtual {v3, v0}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    :goto_3
    invoke-static {v2, v0}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    move v0, v1

    goto :goto_0

    :cond_3
    invoke-virtual {v2}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/String;->isEmpty()Z

    move-result v7

    if-eqz v7, :cond_4

    const-string v2, "FirebasePerformance"

    const-string v7, "counterId is empty"

    invoke-static {v2, v7}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    move v2, v1

    goto :goto_2

    :cond_4
    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v2

    const/16 v7, 0x64

    if-le v2, v7, :cond_5

    const-string v2, "FirebasePerformance"

    const-string v7, "counterId exceeded max length 100"

    invoke-static {v2, v7}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    move v2, v1

    goto :goto_2

    :cond_5
    move v2, v0

    goto :goto_2

    :cond_6
    new-instance v0, Ljava/lang/String;

    invoke-direct {v0, v3}, Ljava/lang/String;-><init>(Ljava/lang/String;)V

    goto :goto_3

    :cond_7
    iget-object v2, v6, Lcom/google/android/gms/internal/zzewz;->b:Ljava/lang/Long;

    if-eqz v2, :cond_8

    invoke-virtual {v2}, Ljava/lang/Long;->longValue()J

    move-result-wide v8

    const-wide/16 v10, 0x0

    cmp-long v2, v8, v10

    if-ltz v2, :cond_8

    move v2, v0

    :goto_4
    if-nez v2, :cond_9

    const-string v0, "FirebasePerformance"

    iget-object v2, v6, Lcom/google/android/gms/internal/zzewz;->b:Ljava/lang/Long;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    add-int/lit8 v3, v3, 0x15

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4, v3}, Ljava/lang/StringBuilder;-><init>(I)V

    const-string v3, "invalid CounterValue:"

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v2}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    move v0, v1

    goto/16 :goto_0

    :cond_8
    move v2, v1

    goto :goto_4

    :cond_9
    add-int/lit8 v2, v3, 0x1

    move v3, v2

    goto/16 :goto_1

    :cond_a
    iget-object v3, p1, Lcom/google/android/gms/internal/zzewy;->e:[Lcom/google/android/gms/internal/zzewy;

    array-length v4, v3

    move v2, v1

    :goto_5
    if-ge v2, v4, :cond_0

    aget-object v5, v3, v2

    add-int/lit8 v6, p2, 0x1

    invoke-direct {p0, v5, v6}, Lcom/google/android/gms/internal/zzewf;->b(Lcom/google/android/gms/internal/zzewy;I)Z

    move-result v5

    if-nez v5, :cond_b

    move v0, v1

    goto/16 :goto_0

    :cond_b
    add-int/lit8 v2, v2, 0x1

    goto :goto_5
.end method


# virtual methods
.method public final a()Z
    .locals 5

    const/4 v1, 0x0

    iget-object v0, p0, Lcom/google/android/gms/internal/zzewf;->a:Lcom/google/android/gms/internal/zzewy;

    invoke-direct {p0, v0, v1}, Lcom/google/android/gms/internal/zzewf;->a(Lcom/google/android/gms/internal/zzewy;I)Z

    move-result v0

    if-nez v0, :cond_1

    const-string v2, "FirebasePerformance"

    const-string v3, "Invalid Trace:"

    iget-object v0, p0, Lcom/google/android/gms/internal/zzewf;->a:Lcom/google/android/gms/internal/zzewy;

    iget-object v0, v0, Lcom/google/android/gms/internal/zzewy;->a:Ljava/lang/String;

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v4

    if-eqz v4, :cond_0

    invoke-virtual {v3, v0}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    :goto_0
    invoke-static {v2, v0}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    move v0, v1

    :goto_1
    return v0

    :cond_0
    new-instance v0, Ljava/lang/String;

    invoke-direct {v0, v3}, Ljava/lang/String;-><init>(Ljava/lang/String;)V

    goto :goto_0

    :cond_1
    iget-object v0, p0, Lcom/google/android/gms/internal/zzewf;->a:Lcom/google/android/gms/internal/zzewy;

    invoke-static {v0}, Lcom/google/android/gms/internal/zzewf;->a(Lcom/google/android/gms/internal/zzewy;)Z

    move-result v0

    if-eqz v0, :cond_3

    iget-object v0, p0, Lcom/google/android/gms/internal/zzewf;->a:Lcom/google/android/gms/internal/zzewy;

    invoke-direct {p0, v0, v1}, Lcom/google/android/gms/internal/zzewf;->b(Lcom/google/android/gms/internal/zzewy;I)Z

    move-result v0

    if-nez v0, :cond_3

    const-string v2, "FirebasePerformance"

    const-string v3, "Invalid Counters for Trace:"

    iget-object v0, p0, Lcom/google/android/gms/internal/zzewf;->a:Lcom/google/android/gms/internal/zzewy;

    iget-object v0, v0, Lcom/google/android/gms/internal/zzewy;->a:Ljava/lang/String;

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v4

    if-eqz v4, :cond_2

    invoke-virtual {v3, v0}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    :goto_2
    invoke-static {v2, v0}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    move v0, v1

    goto :goto_1

    :cond_2
    new-instance v0, Ljava/lang/String;

    invoke-direct {v0, v3}, Ljava/lang/String;-><init>(Ljava/lang/String;)V

    goto :goto_2

    :cond_3
    const/4 v0, 0x1

    goto :goto_1
.end method
