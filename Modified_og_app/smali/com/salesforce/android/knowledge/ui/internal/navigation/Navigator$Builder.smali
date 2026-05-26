.class public Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator$Builder;
.super Ljava/lang/Object;
.source "Navigator.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation


# instance fields
.field final a:Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;

.field b:Lcom/salesforce/android/knowledge/ui/internal/navigation/NavigationStack;

.field c:Lcom/salesforce/android/knowledge/ui/internal/navigation/ViewBinderFactory;

.field final d:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator$Listener;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;)V
    .locals 1

    .prologue
    .line 196
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 194
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator$Builder;->d:Ljava/util/Set;

    .line 197
    iput-object p1, p0, Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator$Builder;->a:Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;

    .line 198
    return-void
.end method


# virtual methods
.method public a(Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator$Listener;)Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator$Builder;
    .locals 1

    .prologue
    .line 211
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator$Builder;->d:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 212
    return-object p0
.end method

.method public a()Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator;
    .locals 1

    .prologue
    .line 216
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator$Builder;->b:Lcom/salesforce/android/knowledge/ui/internal/navigation/NavigationStack;

    if-nez v0, :cond_0

    .line 217
    new-instance v0, Lcom/salesforce/android/knowledge/ui/internal/navigation/NavigationStack;

    invoke-direct {v0}, Lcom/salesforce/android/knowledge/ui/internal/navigation/NavigationStack;-><init>()V

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator$Builder;->b:Lcom/salesforce/android/knowledge/ui/internal/navigation/NavigationStack;

    .line 219
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator$Builder;->c:Lcom/salesforce/android/knowledge/ui/internal/navigation/ViewBinderFactory;

    if-nez v0, :cond_1

    .line 220
    new-instance v0, Lcom/salesforce/android/knowledge/ui/internal/navigation/ViewBinderFactory;

    invoke-direct {v0}, Lcom/salesforce/android/knowledge/ui/internal/navigation/ViewBinderFactory;-><init>()V

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator$Builder;->c:Lcom/salesforce/android/knowledge/ui/internal/navigation/ViewBinderFactory;

    .line 223
    :cond_1
    new-instance v0, Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator;

    invoke-direct {v0, p0}, Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator;-><init>(Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator$Builder;)V

    return-object v0
.end method
