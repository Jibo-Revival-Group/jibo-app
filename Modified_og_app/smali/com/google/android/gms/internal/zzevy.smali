.class public final Lcom/google/android/gms/internal/zzevy;
.super Lcom/google/android/gms/internal/zzewg;


# instance fields
.field private final a:Lcom/google/android/gms/internal/zzews;


# direct methods
.method constructor <init>(Lcom/google/android/gms/internal/zzews;)V
    .locals 0

    invoke-direct {p0}, Lcom/google/android/gms/internal/zzewg;-><init>()V

    iput-object p1, p0, Lcom/google/android/gms/internal/zzevy;->a:Lcom/google/android/gms/internal/zzews;

    return-void
.end method


# virtual methods
.method public final a()Z
    .locals 4

    const/4 v1, 0x1

    const/4 v0, 0x0

    iget-object v2, p0, Lcom/google/android/gms/internal/zzevy;->a:Lcom/google/android/gms/internal/zzews;

    if-nez v2, :cond_0

    const-string v2, "FirebasePerformance"

    const-string v3, "ApplicationInfo is null"

    invoke-static {v2, v3}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    move v2, v0

    :goto_0
    if-nez v2, :cond_6

    const-string v1, "FirebasePerformance"

    const-string v2, "ApplicationInfo is invalid"

    invoke-static {v1, v2}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    :goto_1
    return v0

    :cond_0
    iget-object v2, p0, Lcom/google/android/gms/internal/zzevy;->a:Lcom/google/android/gms/internal/zzews;

    iget-object v2, v2, Lcom/google/android/gms/internal/zzews;->a:Ljava/lang/String;

    if-nez v2, :cond_1

    const-string v2, "FirebasePerformance"

    const-string v3, "GoogleAppId is null"

    invoke-static {v2, v3}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    move v2, v0

    goto :goto_0

    :cond_1
    iget-object v2, p0, Lcom/google/android/gms/internal/zzevy;->a:Lcom/google/android/gms/internal/zzews;

    iget-object v2, v2, Lcom/google/android/gms/internal/zzews;->b:Ljava/lang/String;

    if-nez v2, :cond_2

    const-string v2, "FirebasePerformance"

    const-string v3, "AppInstanceId is null"

    invoke-static {v2, v3}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    move v2, v0

    goto :goto_0

    :cond_2
    iget-object v2, p0, Lcom/google/android/gms/internal/zzevy;->a:Lcom/google/android/gms/internal/zzews;

    iget-object v2, v2, Lcom/google/android/gms/internal/zzews;->d:Ljava/lang/Integer;

    if-nez v2, :cond_3

    const-string v2, "FirebasePerformance"

    const-string v3, "ApplicationProcessState is null"

    invoke-static {v2, v3}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    move v2, v0

    goto :goto_0

    :cond_3
    iget-object v2, p0, Lcom/google/android/gms/internal/zzevy;->a:Lcom/google/android/gms/internal/zzews;

    iget-object v2, v2, Lcom/google/android/gms/internal/zzews;->c:Lcom/google/android/gms/internal/zzewr;

    if-eqz v2, :cond_5

    iget-object v2, p0, Lcom/google/android/gms/internal/zzevy;->a:Lcom/google/android/gms/internal/zzews;

    iget-object v2, v2, Lcom/google/android/gms/internal/zzews;->c:Lcom/google/android/gms/internal/zzewr;

    iget-object v2, v2, Lcom/google/android/gms/internal/zzewr;->a:Ljava/lang/String;

    if-nez v2, :cond_4

    const-string v2, "FirebasePerformance"

    const-string v3, "AndroidAppInfo.packageName is null"

    invoke-static {v2, v3}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    move v2, v0

    goto :goto_0

    :cond_4
    iget-object v2, p0, Lcom/google/android/gms/internal/zzevy;->a:Lcom/google/android/gms/internal/zzews;

    iget-object v2, v2, Lcom/google/android/gms/internal/zzews;->c:Lcom/google/android/gms/internal/zzewr;

    iget-object v2, v2, Lcom/google/android/gms/internal/zzewr;->b:Ljava/lang/String;

    if-nez v2, :cond_5

    const-string v2, "FirebasePerformance"

    const-string v3, "AndroidAppInfo.sdkVersion is null"

    invoke-static {v2, v3}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    move v2, v0

    goto :goto_0

    :cond_5
    move v2, v1

    goto :goto_0

    :cond_6
    move v0, v1

    goto :goto_1
.end method
