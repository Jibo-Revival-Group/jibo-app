.class public Lcom/salesforce/android/knowledge/core/offline/OfflineResourceConfig;
.super Ljava/lang/Object;
.source "OfflineResourceConfig.java"


# instance fields
.field private final a:Z

.field private final b:I

.field private final c:Ljava/io/File;

.field private final d:I


# direct methods
.method private constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 69
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 70
    iput-boolean v0, p0, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceConfig;->a:Z

    .line 71
    iput v0, p0, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceConfig;->b:I

    .line 72
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceConfig;->c:Ljava/io/File;

    .line 73
    const/4 v0, 0x1

    iput v0, p0, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceConfig;->d:I

    .line 74
    return-void
.end method

.method public static a()Lcom/salesforce/android/knowledge/core/offline/OfflineResourceConfig;
    .locals 1

    .prologue
    .line 112
    new-instance v0, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceConfig;

    invoke-direct {v0}, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceConfig;-><init>()V

    return-object v0
.end method


# virtual methods
.method public b()Z
    .locals 1

    .prologue
    .line 127
    iget-boolean v0, p0, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceConfig;->a:Z

    return v0
.end method

.method public c()I
    .locals 1

    .prologue
    .line 137
    iget v0, p0, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceConfig;->b:I

    return v0
.end method

.method public d()Ljava/io/File;
    .locals 1

    .prologue
    .line 147
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceConfig;->c:Ljava/io/File;

    return-object v0
.end method

.method public e()I
    .locals 1

    .prologue
    .line 159
    iget v0, p0, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceConfig;->d:I

    return v0
.end method
