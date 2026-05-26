.class public Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository$Builder;
.super Ljava/lang/Object;
.source "RemoteRepository.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation


# instance fields
.field private final a:Landroid/content/Context;

.field private final b:Lcom/salesforce/android/cases/core/CaseConfiguration;

.field private c:Lcom/salesforce/android/cases/core/internal/http/HttpService;


# direct methods
.method constructor <init>(Landroid/content/Context;Lcom/salesforce/android/cases/core/CaseConfiguration;)V
    .locals 0

    .prologue
    .line 136
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 137
    iput-object p1, p0, Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository$Builder;->a:Landroid/content/Context;

    .line 138
    iput-object p2, p0, Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository$Builder;->b:Lcom/salesforce/android/cases/core/CaseConfiguration;

    .line 139
    return-void
.end method

.method static synthetic a(Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository$Builder;)Landroid/content/Context;
    .locals 1

    .prologue
    .line 130
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository$Builder;->a:Landroid/content/Context;

    return-object v0
.end method


# virtual methods
.method a()Lcom/salesforce/android/cases/core/internal/http/HttpService;
    .locals 1

    .prologue
    .line 142
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository$Builder;->c:Lcom/salesforce/android/cases/core/internal/http/HttpService;

    return-object v0
.end method

.method public b()Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/security/NoSuchAlgorithmException;,
            Ljava/security/KeyManagementException;
        }
    .end annotation

    .prologue
    .line 146
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository$Builder;->c:Lcom/salesforce/android/cases/core/internal/http/HttpService;

    if-nez v0, :cond_0

    .line 147
    new-instance v0, Lcom/salesforce/android/cases/core/internal/http/HttpService$Builder;

    iget-object v1, p0, Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository$Builder;->a:Landroid/content/Context;

    iget-object v2, p0, Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository$Builder;->b:Lcom/salesforce/android/cases/core/CaseConfiguration;

    invoke-direct {v0, v1, v2}, Lcom/salesforce/android/cases/core/internal/http/HttpService$Builder;-><init>(Landroid/content/Context;Lcom/salesforce/android/cases/core/CaseConfiguration;)V

    invoke-virtual {v0}, Lcom/salesforce/android/cases/core/internal/http/HttpService$Builder;->a()Lcom/salesforce/android/cases/core/internal/http/HttpService;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository$Builder;->c:Lcom/salesforce/android/cases/core/internal/http/HttpService;

    .line 150
    :cond_0
    new-instance v0, Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;

    invoke-direct {v0, p0}, Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;-><init>(Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository$Builder;)V

    return-object v0
.end method
