.class public final Lcom/google/android/gms/internal/zzewh;
.super Ljava/lang/Object;


# instance fields
.field private final a:I

.field private final b:I

.field private final c:Z

.field private d:Z

.field private e:Lcom/google/android/gms/internal/zzewj;

.field private f:Lcom/google/android/gms/internal/zzewj;


# direct methods
.method private constructor <init>(JJLcom/google/android/gms/internal/zzewk;ILjava/util/List;)V
    .locals 12
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(JJ",
            "Lcom/google/android/gms/internal/zzewk;",
            "I",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v2, 0x0

    iput-boolean v2, p0, Lcom/google/android/gms/internal/zzewh;->d:Z

    const/4 v2, 0x0

    iput-object v2, p0, Lcom/google/android/gms/internal/zzewh;->e:Lcom/google/android/gms/internal/zzewj;

    const/4 v2, 0x0

    iput-object v2, p0, Lcom/google/android/gms/internal/zzewh;->f:Lcom/google/android/gms/internal/zzewj;

    move/from16 v0, p6

    iput v0, p0, Lcom/google/android/gms/internal/zzewh;->a:I

    invoke-static/range {p7 .. p7}, Lcom/google/android/gms/internal/zzewh;->a(Ljava/util/List;)Ljava/util/Map;

    move-result-object v9

    const-string v2, "sampling"

    invoke-interface {v9, v2}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    const-string v2, "sampling"

    invoke-interface {v9, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Long;

    invoke-virtual {v2}, Ljava/lang/Long;->intValue()I

    move-result v2

    iput v2, p0, Lcom/google/android/gms/internal/zzewh;->b:I

    :goto_0
    iget v2, p0, Lcom/google/android/gms/internal/zzewh;->b:I

    const/16 v3, 0x64

    if-eq v2, v3, :cond_0

    const-string v2, "FirebasePerformance"

    iget v3, p0, Lcom/google/android/gms/internal/zzewh;->b:I

    iget v4, p0, Lcom/google/android/gms/internal/zzewh;->a:I

    const/16 v5, 0x3b

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6, v5}, Ljava/lang/StringBuilder;-><init>(I)V

    const-string v5, "RateLimiter sampling rate:"

    invoke-virtual {v6, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v5, " bucketId: "

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    :cond_0
    iget v2, p0, Lcom/google/android/gms/internal/zzewh;->a:I

    iget v3, p0, Lcom/google/android/gms/internal/zzewh;->b:I

    if-gt v2, v3, :cond_2

    const/4 v2, 0x1

    :goto_1
    iput-boolean v2, p0, Lcom/google/android/gms/internal/zzewh;->c:Z

    iget-boolean v2, p0, Lcom/google/android/gms/internal/zzewh;->c:Z

    if-nez v2, :cond_3

    const-string v2, "FirebasePerformance"

    const-string v3, "logging is disabled because device sampling"

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    :goto_2
    return-void

    :cond_1
    const/16 v2, 0x64

    iput v2, p0, Lcom/google/android/gms/internal/zzewh;->b:I

    goto :goto_0

    :cond_2
    const/4 v2, 0x0

    goto :goto_1

    :cond_3
    new-instance v3, Lcom/google/android/gms/internal/zzewj;

    const-wide/16 v4, 0x64

    const-wide/16 v6, 0x1f4

    sget-object v10, Lcom/google/android/gms/internal/zzewi;->zzocp:Lcom/google/android/gms/internal/zzewi;

    iget-boolean v11, p0, Lcom/google/android/gms/internal/zzewh;->d:Z

    move-object/from16 v8, p5

    invoke-direct/range {v3 .. v11}, Lcom/google/android/gms/internal/zzewj;-><init>(JJLcom/google/android/gms/internal/zzewk;Ljava/util/Map;Lcom/google/android/gms/internal/zzewi;Z)V

    iput-object v3, p0, Lcom/google/android/gms/internal/zzewh;->e:Lcom/google/android/gms/internal/zzewj;

    new-instance v3, Lcom/google/android/gms/internal/zzewj;

    const-wide/16 v4, 0x64

    const-wide/16 v6, 0x1f4

    sget-object v10, Lcom/google/android/gms/internal/zzewi;->zzoco:Lcom/google/android/gms/internal/zzewi;

    iget-boolean v11, p0, Lcom/google/android/gms/internal/zzewh;->d:Z

    move-object/from16 v8, p5

    invoke-direct/range {v3 .. v11}, Lcom/google/android/gms/internal/zzewj;-><init>(JJLcom/google/android/gms/internal/zzewk;Ljava/util/Map;Lcom/google/android/gms/internal/zzewi;Z)V

    iput-object v3, p0, Lcom/google/android/gms/internal/zzewh;->f:Lcom/google/android/gms/internal/zzewj;

    goto :goto_2
.end method

.method public constructor <init>(Landroid/content/Context;Ljava/lang/String;JJ)V
    .locals 9

    const-wide/16 v2, 0x64

    const-wide/16 v4, 0x1f4

    new-instance v6, Lcom/google/android/gms/internal/zzewk;

    invoke-direct {v6}, Lcom/google/android/gms/internal/zzewk;-><init>()V

    invoke-virtual {p1}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    const-string v1, "android_id"

    invoke-static {v0, v1}, Landroid/provider/Settings$Secure;->getString(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/google/android/gms/internal/zzewh;->a(Ljava/lang/String;)I

    move-result v7

    invoke-static {p1, p2}, Lcom/google/android/gms/internal/zzewh;->a(Landroid/content/Context;Ljava/lang/String;)Ljava/util/List;

    move-result-object v8

    move-object v1, p0

    invoke-direct/range {v1 .. v8}, Lcom/google/android/gms/internal/zzewh;-><init>(JJLcom/google/android/gms/internal/zzewk;ILjava/util/List;)V

    invoke-static {p1}, Lcom/google/android/gms/internal/zzewq;->a(Landroid/content/Context;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/google/android/gms/internal/zzewh;->d:Z

    return-void
.end method

.method private static a(Landroid/content/Context;)I
    .locals 4

    const/4 v0, 0x0

    :try_start_0
    invoke-virtual {p0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v1

    invoke-virtual {p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v1

    iget v0, v1, Landroid/content/pm/PackageInfo;->versionCode:I
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    :goto_0
    return v0

    :catch_0
    move-exception v1

    goto :goto_0
.end method

.method private static a(Ljava/lang/String;)I
    .locals 2

    :try_start_0
    const-string v0, "SHA-1"

    invoke-static {v0}, Ljava/security/MessageDigest;->getInstance(Ljava/lang/String;)Ljava/security/MessageDigest;

    move-result-object v0

    invoke-virtual {p0}, Ljava/lang/String;->getBytes()[B

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/security/MessageDigest;->digest([B)[B

    move-result-object v0

    invoke-static {v0}, Lcom/google/android/gms/internal/zzewq;->a([B)I
    :try_end_0
    .catch Ljava/security/NoSuchAlgorithmException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v0

    :goto_0
    rem-int/lit8 v0, v0, 0x64

    add-int/lit8 v0, v0, 0x64

    rem-int/lit8 v0, v0, 0x64

    add-int/lit8 v0, v0, 0x1

    return v0

    :catch_0
    move-exception v0

    invoke-virtual {p0}, Ljava/lang/String;->getBytes()[B

    move-result-object v0

    invoke-static {v0}, Lcom/google/android/gms/internal/zzewq;->a([B)I

    move-result v0

    goto :goto_0
.end method

.method private static a(Landroid/content/Context;Ljava/lang/String;)Ljava/util/List;
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    const/4 v6, 0x3

    const/4 v0, 0x0

    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    new-array v3, v6, [Ljava/lang/String;

    invoke-static {p0}, Lcom/google/android/gms/internal/zzewh;->a(Landroid/content/Context;)I

    move-result v1

    invoke-static {p1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v4

    add-int/lit8 v4, v4, 0xc

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5, v4}, Ljava/lang/StringBuilder;-><init>(I)V

    invoke-virtual {v5, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, ":"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    aput-object v1, v3, v0

    const/4 v1, 0x1

    aput-object p1, v3, v1

    const/4 v1, 0x2

    const-string v4, "1.0.0.178131943"

    aput-object v4, v3, v1

    move v1, v0

    :goto_0
    if-ge v1, v6, :cond_2

    aget-object v0, v3, v1

    const-string v4, "_fireperf1:"

    invoke-static {v4}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v5

    if-eqz v5, :cond_1

    invoke-virtual {v4, v0}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    :goto_1
    invoke-static {v0}, Lcom/google/android/gms/internal/zzewh;->b(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v4

    add-int/lit8 v4, v4, 0x10

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5, v4}, Ljava/lang/StringBuilder;-><init>(I)V

    const-string v4, "fireperf:"

    invoke-virtual {v5, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v4, "_limits"

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v4

    const/4 v5, 0x0

    invoke-static {v4, v0, v5}, Lcom/google/android/gms/internal/zzdmf;->a(Landroid/content/ContentResolver;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-interface {v2, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    :cond_0
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_0

    :cond_1
    new-instance v0, Ljava/lang/String;

    invoke-direct {v0, v4}, Ljava/lang/String;-><init>(Ljava/lang/String;)V

    goto :goto_1

    :cond_2
    return-object v2
.end method

.method private static a(Ljava/util/List;)Ljava/util/Map;
    .locals 12
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Long;",
            ">;"
        }
    .end annotation

    const/4 v2, 0x0

    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    if-nez p0, :cond_0

    move-object v0, v1

    :goto_0
    return-object v0

    :cond_0
    invoke-interface {p0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_1
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_3

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    const-string v4, ","

    invoke-virtual {v0, v4}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v4

    array-length v5, v4

    move v0, v2

    :goto_1
    if-ge v0, v5, :cond_1

    aget-object v6, v4, v0

    const-string v7, ":"

    invoke-virtual {v6, v7}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v6

    array-length v7, v6

    const/4 v8, 0x2

    if-lt v7, v8, :cond_2

    aget-object v7, v6, v2

    invoke-virtual {v7}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/String;->isEmpty()Z

    move-result v8

    if-nez v8, :cond_2

    invoke-interface {v1, v7}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v8

    if-nez v8, :cond_2

    const/4 v8, 0x1

    :try_start_0
    aget-object v6, v6, v8

    invoke-virtual {v6}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-wide v8

    const-wide/16 v10, 0x0

    cmp-long v6, v8, v10

    if-ltz v6, :cond_2

    invoke-static {v8, v9}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    invoke-interface {v1, v7, v6}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_2
    :goto_2
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    :cond_3
    move-object v0, v1

    goto :goto_0

    :catch_0
    move-exception v6

    goto :goto_2
.end method

.method private static b(Ljava/lang/String;)Ljava/lang/String;
    .locals 9

    const/4 v0, 0x0

    const/4 v1, 0x0

    if-nez p0, :cond_0

    :goto_0
    return-object v0

    :cond_0
    :try_start_0
    const-string v2, "SHA-1"

    invoke-static {v2}, Ljava/security/MessageDigest;->getInstance(Ljava/lang/String;)Ljava/security/MessageDigest;

    move-result-object v2

    invoke-virtual {p0}, Ljava/lang/String;->getBytes()[B

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/security/MessageDigest;->digest([B)[B

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    array-length v4, v2

    :goto_1
    if-ge v1, v4, :cond_1

    aget-byte v5, v2, v1

    const-string v6, "%02x"

    const/4 v7, 0x1

    new-array v7, v7, [Ljava/lang/Object;

    const/4 v8, 0x0

    invoke-static {v5}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object v5

    aput-object v5, v7, v8

    invoke-static {v6, v7}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    :cond_1
    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    :try_end_0
    .catch Ljava/security/NoSuchAlgorithmException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    goto :goto_0

    :catch_0
    move-exception v1

    goto :goto_0
.end method


# virtual methods
.method final a(Z)V
    .locals 1

    iget-boolean v0, p0, Lcom/google/android/gms/internal/zzewh;->c:Z

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/google/android/gms/internal/zzewh;->e:Lcom/google/android/gms/internal/zzewj;

    invoke-virtual {v0, p1}, Lcom/google/android/gms/internal/zzewj;->a(Z)V

    iget-object v0, p0, Lcom/google/android/gms/internal/zzewh;->f:Lcom/google/android/gms/internal/zzewj;

    invoke-virtual {v0, p1}, Lcom/google/android/gms/internal/zzewj;->a(Z)V

    :cond_0
    return-void
.end method

.method final a(Lcom/google/android/gms/internal/zzewx;)Z
    .locals 4

    const/4 v1, 0x1

    const/4 v0, 0x0

    iget-boolean v2, p0, Lcom/google/android/gms/internal/zzewh;->c:Z

    if-nez v2, :cond_1

    :cond_0
    :goto_0
    return v0

    :cond_1
    iget-object v2, p1, Lcom/google/android/gms/internal/zzewx;->b:Lcom/google/android/gms/internal/zzewy;

    if-eqz v2, :cond_3

    iget-object v2, p1, Lcom/google/android/gms/internal/zzewx;->b:Lcom/google/android/gms/internal/zzewy;

    iget-object v2, v2, Lcom/google/android/gms/internal/zzewy;->a:Ljava/lang/String;

    if-eqz v2, :cond_3

    iget-object v2, p1, Lcom/google/android/gms/internal/zzewx;->b:Lcom/google/android/gms/internal/zzewy;

    iget-object v2, v2, Lcom/google/android/gms/internal/zzewy;->a:Ljava/lang/String;

    sget-object v3, Lcom/google/android/gms/internal/zzewm;->zzoev:Lcom/google/android/gms/internal/zzewm;

    invoke-virtual {v3}, Lcom/google/android/gms/internal/zzewm;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_2

    iget-object v2, p1, Lcom/google/android/gms/internal/zzewx;->b:Lcom/google/android/gms/internal/zzewy;

    iget-object v2, v2, Lcom/google/android/gms/internal/zzewy;->a:Ljava/lang/String;

    sget-object v3, Lcom/google/android/gms/internal/zzewm;->zzoew:Lcom/google/android/gms/internal/zzewm;

    invoke-virtual {v3}, Lcom/google/android/gms/internal/zzewm;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_3

    :cond_2
    iget-object v2, p1, Lcom/google/android/gms/internal/zzewx;->b:Lcom/google/android/gms/internal/zzewy;

    iget-object v2, v2, Lcom/google/android/gms/internal/zzewy;->d:[Lcom/google/android/gms/internal/zzewz;

    if-eqz v2, :cond_3

    iget-object v2, p1, Lcom/google/android/gms/internal/zzewx;->b:Lcom/google/android/gms/internal/zzewy;

    iget-object v2, v2, Lcom/google/android/gms/internal/zzewy;->d:[Lcom/google/android/gms/internal/zzewz;

    array-length v2, v2

    if-lez v2, :cond_3

    move v2, v0

    :goto_1
    if-nez v2, :cond_4

    move v0, v1

    goto :goto_0

    :cond_3
    move v2, v1

    goto :goto_1

    :cond_4
    iget-object v1, p1, Lcom/google/android/gms/internal/zzewx;->c:Lcom/google/android/gms/internal/zzewv;

    if-eqz v1, :cond_5

    iget-object v0, p0, Lcom/google/android/gms/internal/zzewh;->f:Lcom/google/android/gms/internal/zzewj;

    invoke-virtual {v0, p1}, Lcom/google/android/gms/internal/zzewj;->a(Lcom/google/android/gms/internal/zzewx;)Z

    move-result v0

    goto :goto_0

    :cond_5
    iget-object v1, p1, Lcom/google/android/gms/internal/zzewx;->b:Lcom/google/android/gms/internal/zzewy;

    if-eqz v1, :cond_0

    iget-object v0, p0, Lcom/google/android/gms/internal/zzewh;->e:Lcom/google/android/gms/internal/zzewj;

    invoke-virtual {v0, p1}, Lcom/google/android/gms/internal/zzewj;->a(Lcom/google/android/gms/internal/zzewx;)Z

    move-result v0

    goto :goto_0
.end method
