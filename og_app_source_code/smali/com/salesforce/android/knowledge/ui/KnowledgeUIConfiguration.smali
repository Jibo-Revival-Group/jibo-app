.class public Lcom/salesforce/android/knowledge/ui/KnowledgeUIConfiguration;
.super Ljava/lang/Object;
.source "KnowledgeUIConfiguration.java"


# instance fields
.field private final a:Lcom/salesforce/android/knowledge/core/KnowledgeConfiguration;

.field private final b:Ljava/lang/String;

.field private c:Lcom/salesforce/android/knowledge/ui/KnowledgeImageProvider;

.field private d:Lcom/salesforce/android/knowledge/ui/KnowledgeCssProvider;

.field private e:Lcom/salesforce/android/knowledge/ui/KnowledgeJsProvider;

.field private f:Ljava/lang/String;


# direct methods
.method private constructor <init>(Lcom/salesforce/android/knowledge/core/KnowledgeConfiguration;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 67
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 68
    iput-object p1, p0, Lcom/salesforce/android/knowledge/ui/KnowledgeUIConfiguration;->a:Lcom/salesforce/android/knowledge/core/KnowledgeConfiguration;

    .line 69
    iput-object p2, p0, Lcom/salesforce/android/knowledge/ui/KnowledgeUIConfiguration;->f:Ljava/lang/String;

    .line 70
    iput-object p3, p0, Lcom/salesforce/android/knowledge/ui/KnowledgeUIConfiguration;->b:Ljava/lang/String;

    .line 71
    return-void
.end method

.method public static a(Lcom/salesforce/android/knowledge/core/KnowledgeConfiguration;Ljava/lang/String;Ljava/lang/String;)Lcom/salesforce/android/knowledge/ui/KnowledgeUIConfiguration;
    .locals 1

    .prologue
    .line 64
    new-instance v0, Lcom/salesforce/android/knowledge/ui/KnowledgeUIConfiguration;

    invoke-direct {v0, p0, p1, p2}, Lcom/salesforce/android/knowledge/ui/KnowledgeUIConfiguration;-><init>(Lcom/salesforce/android/knowledge/core/KnowledgeConfiguration;Ljava/lang/String;Ljava/lang/String;)V

    return-object v0
.end method


# virtual methods
.method public a()Lcom/salesforce/android/knowledge/core/KnowledgeConfiguration;
    .locals 1
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 115
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/KnowledgeUIConfiguration;->a:Lcom/salesforce/android/knowledge/core/KnowledgeConfiguration;

    return-object v0
.end method

.method public b()Ljava/lang/String;
    .locals 1

    .prologue
    .line 126
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/KnowledgeUIConfiguration;->b:Ljava/lang/String;

    return-object v0
.end method

.method public c()Lcom/salesforce/android/knowledge/ui/KnowledgeImageProvider;
    .locals 1

    .prologue
    .line 136
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/KnowledgeUIConfiguration;->c:Lcom/salesforce/android/knowledge/ui/KnowledgeImageProvider;

    return-object v0
.end method

.method public d()Lcom/salesforce/android/knowledge/ui/KnowledgeCssProvider;
    .locals 1

    .prologue
    .line 146
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/KnowledgeUIConfiguration;->d:Lcom/salesforce/android/knowledge/ui/KnowledgeCssProvider;

    return-object v0
.end method

.method public e()Lcom/salesforce/android/knowledge/ui/KnowledgeJsProvider;
    .locals 1

    .prologue
    .line 156
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/KnowledgeUIConfiguration;->e:Lcom/salesforce/android/knowledge/ui/KnowledgeJsProvider;

    return-object v0
.end method

.method public f()Ljava/lang/String;
    .locals 1

    .prologue
    .line 166
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/KnowledgeUIConfiguration;->f:Ljava/lang/String;

    return-object v0
.end method
