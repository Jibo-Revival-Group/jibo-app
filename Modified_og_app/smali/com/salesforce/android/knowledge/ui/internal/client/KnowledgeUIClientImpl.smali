.class public Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;
.super Ljava/lang/Object;
.source "KnowledgeUIClientImpl.java"

# interfaces
.implements Lcom/salesforce/android/knowledge/core/LogoutListener;
.implements Lcom/salesforce/android/knowledge/ui/KnowledgeUIClient;
.implements Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker$OnCreateListener;
.implements Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker$OnDestroyListener;
.implements Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker$OnStartListener;


# static fields
.field private static final n:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;


# instance fields
.field a:Lcom/salesforce/android/service/common/utilities/activity/ActivityReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/salesforce/android/service/common/utilities/activity/ActivityReference",
            "<",
            "Lcom/salesforce/android/knowledge/ui/internal/activity/KnowledgeActivity;",
            ">;"
        }
    .end annotation
.end field

.field private final b:Lcom/salesforce/android/knowledge/ui/KnowledgeUIConfiguration;

.field private final c:Lcom/salesforce/android/knowledge/core/KnowledgeClient;

.field private final d:Lcom/salesforce/android/knowledge/ui/KnowledgeImageProvider;

.field private final e:Lcom/salesforce/android/knowledge/ui/KnowledgeCssProvider;

.field private final f:Lcom/salesforce/android/knowledge/ui/KnowledgeJsProvider;

.field private final g:Lcom/salesforce/android/knowledge/ui/internal/presenter/PresenterFactory;

.field private final h:Lcom/salesforce/android/knowledge/ui/internal/activity/FragmentLoader;

.field private final i:Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator;

.field private final j:Lcom/salesforce/android/knowledge/ui/internal/minimize/MinimizeControl;

.field private final k:Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;

.field private final l:Lcom/salesforce/android/knowledge/ui/internal/logging/LiveAgentKnowledgeLogger;

.field private final m:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Lcom/salesforce/android/knowledge/ui/internal/client/ViewAdditionController;",
            ">;"
        }
    .end annotation
.end field

.field private final o:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Lcom/salesforce/android/knowledge/ui/KnowledgeUIClient$OnCloseListener;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 88
    const-class v0, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogging;->a(Ljava/lang/Class;)Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    move-result-object v0

    sput-object v0, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->n:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    return-void
.end method

.method private constructor <init>(Lcom/salesforce/android/knowledge/ui/KnowledgeUIConfiguration;Lcom/salesforce/android/knowledge/core/KnowledgeClient;Ljava/util/Set;Lcom/salesforce/android/knowledge/ui/internal/client/ModuleProvider;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/knowledge/ui/KnowledgeUIConfiguration;",
            "Lcom/salesforce/android/knowledge/core/KnowledgeClient;",
            "Ljava/util/Set",
            "<",
            "Lcom/salesforce/android/knowledge/ui/KnowledgeViewAddition;",
            ">;",
            "Lcom/salesforce/android/knowledge/ui/internal/client/ModuleProvider;",
            ")V"
        }
    .end annotation

    .prologue
    .line 117
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 87
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->m:Ljava/util/Set;

    .line 94
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;

    invoke-direct {v0}, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V

    invoke-static {v0}, Ljava/util/Collections;->newSetFromMap(Ljava/util/Map;)Ljava/util/Set;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->o:Ljava/util/Set;

    .line 95
    invoke-static {}, Lcom/salesforce/android/service/common/utilities/activity/ActivityReference;->a()Lcom/salesforce/android/service/common/utilities/activity/ActivityReference;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->a:Lcom/salesforce/android/service/common/utilities/activity/ActivityReference;

    .line 118
    iput-object p1, p0, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->b:Lcom/salesforce/android/knowledge/ui/KnowledgeUIConfiguration;

    .line 119
    iput-object p2, p0, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->c:Lcom/salesforce/android/knowledge/core/KnowledgeClient;

    .line 122
    invoke-interface {p3}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/knowledge/ui/KnowledgeViewAddition;

    .line 123
    iget-object v2, p0, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->m:Ljava/util/Set;

    new-instance v3, Lcom/salesforce/android/knowledge/ui/internal/client/ViewAdditionController;

    invoke-direct {v3, v0}, Lcom/salesforce/android/knowledge/ui/internal/client/ViewAdditionController;-><init>(Lcom/salesforce/android/knowledge/ui/KnowledgeViewAddition;)V

    invoke-interface {v2, v3}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 126
    :cond_0
    invoke-interface {p4}, Lcom/salesforce/android/knowledge/ui/internal/client/ModuleProvider;->a()Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;->a(Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker$OnCreateListener;)Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;->a(Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker$OnStartListener;)Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;->a(Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker$OnDestroyListener;)Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->k:Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;

    .line 127
    invoke-interface {p4}, Lcom/salesforce/android/knowledge/ui/internal/client/ModuleProvider;->b()Lcom/salesforce/android/knowledge/ui/internal/activity/FragmentLoader;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->h:Lcom/salesforce/android/knowledge/ui/internal/activity/FragmentLoader;

    .line 128
    invoke-interface {p4, p0}, Lcom/salesforce/android/knowledge/ui/internal/client/ModuleProvider;->b(Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;)Lcom/salesforce/android/knowledge/ui/internal/minimize/MinimizeControl;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->j:Lcom/salesforce/android/knowledge/ui/internal/minimize/MinimizeControl;

    .line 129
    invoke-interface {p4, p0}, Lcom/salesforce/android/knowledge/ui/internal/client/ModuleProvider;->a(Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;)Lcom/salesforce/android/knowledge/ui/internal/presenter/PresenterFactory;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->g:Lcom/salesforce/android/knowledge/ui/internal/presenter/PresenterFactory;

    .line 130
    invoke-interface {p4, p0}, Lcom/salesforce/android/knowledge/ui/internal/client/ModuleProvider;->c(Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;)Lcom/salesforce/android/knowledge/ui/internal/logging/LiveAgentKnowledgeLogger;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->l:Lcom/salesforce/android/knowledge/ui/internal/logging/LiveAgentKnowledgeLogger;

    .line 132
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    .line 133
    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->m:Ljava/util/Set;

    invoke-interface {v0, v1}, Ljava/util/Set;->addAll(Ljava/util/Collection;)Z

    .line 134
    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->h:Lcom/salesforce/android/knowledge/ui/internal/activity/FragmentLoader;

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 135
    invoke-interface {v0}, Ljava/util/Set;->size()I

    move-result v1

    new-array v1, v1, [Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator$Listener;

    invoke-interface {v0, v1}, Ljava/util/Set;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator$Listener;

    invoke-interface {p4, p0, v0}, Lcom/salesforce/android/knowledge/ui/internal/client/ModuleProvider;->a(Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;[Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator$Listener;)Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->i:Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator;

    .line 137
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->b:Lcom/salesforce/android/knowledge/ui/KnowledgeUIConfiguration;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/KnowledgeUIConfiguration;->c()Lcom/salesforce/android/knowledge/ui/KnowledgeImageProvider;

    move-result-object v0

    invoke-static {v0}, Lcom/salesforce/android/knowledge/ui/internal/ImageProviderWrapper;->a(Lcom/salesforce/android/knowledge/ui/KnowledgeImageProvider;)Lcom/salesforce/android/knowledge/ui/internal/ImageProviderWrapper;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->d:Lcom/salesforce/android/knowledge/ui/KnowledgeImageProvider;

    .line 138
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->b:Lcom/salesforce/android/knowledge/ui/KnowledgeUIConfiguration;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/KnowledgeUIConfiguration;->d()Lcom/salesforce/android/knowledge/ui/KnowledgeCssProvider;

    move-result-object v0

    invoke-static {v0}, Lcom/salesforce/android/knowledge/ui/internal/CssProviderWrapper;->a(Lcom/salesforce/android/knowledge/ui/KnowledgeCssProvider;)Lcom/salesforce/android/knowledge/ui/internal/CssProviderWrapper;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->e:Lcom/salesforce/android/knowledge/ui/KnowledgeCssProvider;

    .line 139
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->b:Lcom/salesforce/android/knowledge/ui/KnowledgeUIConfiguration;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/KnowledgeUIConfiguration;->e()Lcom/salesforce/android/knowledge/ui/KnowledgeJsProvider;

    move-result-object v0

    invoke-static {v0}, Lcom/salesforce/android/knowledge/ui/internal/JsProviderWrapper;->a(Lcom/salesforce/android/knowledge/ui/KnowledgeJsProvider;)Lcom/salesforce/android/knowledge/ui/internal/JsProviderWrapper;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->f:Lcom/salesforce/android/knowledge/ui/KnowledgeJsProvider;

    .line 140
    return-void
.end method

.method public static a(Lcom/salesforce/android/knowledge/ui/KnowledgeUIConfiguration;Lcom/salesforce/android/knowledge/core/KnowledgeClient;Ljava/util/Set;)Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/knowledge/ui/KnowledgeUIConfiguration;",
            "Lcom/salesforce/android/knowledge/core/KnowledgeClient;",
            "Ljava/util/Set",
            "<",
            "Lcom/salesforce/android/knowledge/ui/KnowledgeViewAddition;",
            ">;)",
            "Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;"
        }
    .end annotation

    .prologue
    .line 104
    new-instance v0, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;

    new-instance v1, Lcom/salesforce/android/knowledge/ui/internal/client/RuntimeModuleProvider;

    invoke-direct {v1}, Lcom/salesforce/android/knowledge/ui/internal/client/RuntimeModuleProvider;-><init>()V

    invoke-direct {v0, p0, p1, p2, v1}, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;-><init>(Lcom/salesforce/android/knowledge/ui/KnowledgeUIConfiguration;Lcom/salesforce/android/knowledge/core/KnowledgeClient;Ljava/util/Set;Lcom/salesforce/android/knowledge/ui/internal/client/ModuleProvider;)V

    return-object v0
.end method


# virtual methods
.method public a()V
    .locals 2

    .prologue
    .line 301
    sget-object v0, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->n:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v1, "Terminating KB UI due to Auth user logout."

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->c(Ljava/lang/String;)V

    .line 302
    invoke-virtual {p0}, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->n()V

    .line 303
    return-void
.end method

.method public a(Landroid/app/Activity;)V
    .locals 4

    .prologue
    .line 211
    instance-of v0, p1, Lcom/salesforce/android/knowledge/ui/internal/activity/KnowledgeActivity;

    if-eqz v0, :cond_1

    move-object v0, p1

    .line 212
    check-cast v0, Lcom/salesforce/android/knowledge/ui/internal/activity/KnowledgeActivity;

    .line 213
    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->m:Ljava/util/Set;

    invoke-interface {v1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/salesforce/android/knowledge/ui/internal/client/ViewAdditionController;

    .line 214
    iget-object v3, p0, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->i:Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator;

    invoke-virtual {v3}, Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator;->e()Lcom/salesforce/android/knowledge/ui/KnowledgeScene;

    move-result-object v3

    invoke-virtual {v1, v0, v3}, Lcom/salesforce/android/knowledge/ui/internal/client/ViewAdditionController;->a(Lcom/salesforce/android/knowledge/ui/internal/activity/KnowledgeActivity;Lcom/salesforce/android/knowledge/ui/KnowledgeScene;)V

    goto :goto_0

    .line 216
    :cond_0
    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->i:Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator;

    iget-object v2, p0, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->b:Lcom/salesforce/android/knowledge/ui/KnowledgeUIConfiguration;

    invoke-virtual {v2}, Lcom/salesforce/android/knowledge/ui/KnowledgeUIConfiguration;->b()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, p1, v2}, Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator;->a(Landroid/content/Context;Ljava/lang/String;)V

    .line 217
    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->h:Lcom/salesforce/android/knowledge/ui/internal/activity/FragmentLoader;

    invoke-virtual {v1, v0}, Lcom/salesforce/android/knowledge/ui/internal/activity/FragmentLoader;->a(Landroid/support/v7/app/AppCompatActivity;)V

    .line 219
    :cond_1
    return-void
.end method

.method public a(Landroid/content/Context;)V
    .locals 0

    .prologue
    .line 248
    invoke-static {p1}, Lcom/salesforce/android/knowledge/ui/internal/activity/KnowledgeActivity;->a(Landroid/content/Context;)V

    .line 249
    return-void
.end method

.method public a(Lcom/salesforce/android/knowledge/ui/KnowledgeUIClient$OnCloseListener;)V
    .locals 1

    .prologue
    .line 187
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->o:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 188
    return-void
.end method

.method public b()V
    .locals 0

    .prologue
    .line 147
    invoke-virtual {p0}, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->n()V

    .line 148
    return-void
.end method

.method public b(Landroid/app/Activity;)V
    .locals 2

    .prologue
    .line 151
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->a:Lcom/salesforce/android/service/common/utilities/activity/ActivityReference;

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/utilities/activity/ActivityReference;->b()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 164
    :goto_0
    return-void

    .line 154
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->j:Lcom/salesforce/android/knowledge/ui/internal/minimize/MinimizeControl;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/minimize/MinimizeControl;->a()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 156
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->j:Lcom/salesforce/android/knowledge/ui/internal/minimize/MinimizeControl;

    invoke-virtual {v0, p1}, Lcom/salesforce/android/knowledge/ui/internal/minimize/MinimizeControl;->a(Landroid/content/Context;)V

    goto :goto_0

    .line 160
    :cond_1
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->k:Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;

    invoke-virtual {v0, p1}, Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;->a(Landroid/app/Activity;)V

    .line 161
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->k:Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;

    invoke-virtual {p1}, Landroid/app/Activity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;->a(Landroid/content/Context;)V

    .line 162
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->l:Lcom/salesforce/android/knowledge/ui/internal/logging/LiveAgentKnowledgeLogger;

    invoke-virtual {p1}, Landroid/app/Activity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/salesforce/android/knowledge/ui/internal/logging/LiveAgentKnowledgeLogger;->a(Landroid/content/Context;)V

    .line 163
    invoke-virtual {p0, p1}, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->a(Landroid/content/Context;)V

    goto :goto_0
.end method

.method public b(Landroid/content/Context;)Z
    .locals 1

    .prologue
    .line 294
    const-string v0, "connectivity"

    .line 295
    invoke-virtual {p1, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/net/ConnectivityManager;

    .line 296
    invoke-virtual {v0}, Landroid/net/ConnectivityManager;->getActiveNetworkInfo()Landroid/net/NetworkInfo;

    move-result-object v0

    .line 297
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Landroid/net/NetworkInfo;->isConnected()Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public c()Lcom/salesforce/android/knowledge/core/KnowledgeClient;
    .locals 1

    .prologue
    .line 167
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->c:Lcom/salesforce/android/knowledge/core/KnowledgeClient;

    return-object v0
.end method

.method public c(Landroid/app/Activity;)V
    .locals 1

    .prologue
    .line 200
    instance-of v0, p1, Lcom/salesforce/android/knowledge/ui/internal/activity/KnowledgeActivity;

    if-eqz v0, :cond_0

    .line 201
    check-cast p1, Lcom/salesforce/android/knowledge/ui/internal/activity/KnowledgeActivity;

    .line 202
    invoke-virtual {p1, p0}, Lcom/salesforce/android/knowledge/ui/internal/activity/KnowledgeActivity;->a(Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;)V

    .line 203
    invoke-static {p1}, Lcom/salesforce/android/service/common/utilities/activity/ActivityReference;->a(Landroid/app/Activity;)Lcom/salesforce/android/service/common/utilities/activity/ActivityReference;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->a:Lcom/salesforce/android/service/common/utilities/activity/ActivityReference;

    .line 205
    :cond_0
    return-void
.end method

.method public d()Lcom/salesforce/android/knowledge/ui/KnowledgeCssProvider;
    .locals 1

    .prologue
    .line 179
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->e:Lcom/salesforce/android/knowledge/ui/KnowledgeCssProvider;

    return-object v0
.end method

.method public d(Landroid/app/Activity;)V
    .locals 1

    .prologue
    .line 222
    instance-of v0, p1, Lcom/salesforce/android/knowledge/ui/internal/activity/KnowledgeActivity;

    if-eqz v0, :cond_0

    .line 223
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->a:Lcom/salesforce/android/service/common/utilities/activity/ActivityReference;

    check-cast p1, Lcom/salesforce/android/knowledge/ui/internal/activity/KnowledgeActivity;

    invoke-virtual {v0, p1}, Lcom/salesforce/android/service/common/utilities/activity/ActivityReference;->b(Ljava/lang/Object;)V

    .line 225
    :cond_0
    return-void
.end method

.method public e()Lcom/salesforce/android/knowledge/ui/KnowledgeJsProvider;
    .locals 1

    .prologue
    .line 183
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->f:Lcom/salesforce/android/knowledge/ui/KnowledgeJsProvider;

    return-object v0
.end method

.method public f()Lcom/salesforce/android/knowledge/ui/KnowledgeUIConfiguration;
    .locals 1

    .prologue
    .line 171
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->b:Lcom/salesforce/android/knowledge/ui/KnowledgeUIConfiguration;

    return-object v0
.end method

.method public g()Lcom/salesforce/android/knowledge/ui/KnowledgeImageProvider;
    .locals 1

    .prologue
    .line 175
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->d:Lcom/salesforce/android/knowledge/ui/KnowledgeImageProvider;

    return-object v0
.end method

.method public h()Lcom/salesforce/android/knowledge/ui/internal/presenter/PresenterFactory;
    .locals 1

    .prologue
    .line 232
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->g:Lcom/salesforce/android/knowledge/ui/internal/presenter/PresenterFactory;

    return-object v0
.end method

.method public i()Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator;
    .locals 1

    .prologue
    .line 236
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->i:Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator;

    return-object v0
.end method

.method public j()Lcom/salesforce/android/knowledge/ui/internal/minimize/MinimizeControl;
    .locals 1

    .prologue
    .line 240
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->j:Lcom/salesforce/android/knowledge/ui/internal/minimize/MinimizeControl;

    return-object v0
.end method

.method public k()Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;
    .locals 1

    .prologue
    .line 244
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->k:Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;

    return-object v0
.end method

.method public l()V
    .locals 2

    .prologue
    .line 252
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->a:Lcom/salesforce/android/service/common/utilities/activity/ActivityReference;

    new-instance v1, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl$1;

    invoke-direct {v1, p0}, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl$1;-><init>(Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;)V

    invoke-virtual {v0, v1}, Lcom/salesforce/android/service/common/utilities/activity/ActivityReference;->a(Lcom/salesforce/android/service/common/utilities/functional/Consumer;)V

    .line 257
    return-void
.end method

.method public m()V
    .locals 1

    .prologue
    .line 260
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->i:Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator;->d()V

    .line 261
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->i:Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator;->c()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 262
    invoke-virtual {p0}, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->n()V

    .line 264
    :cond_0
    return-void
.end method

.method public n()V
    .locals 2

    .prologue
    .line 267
    invoke-static {}, Lcom/salesforce/android/knowledge/ui/KnowledgeUIAnalyticsEmit;->i()V

    .line 270
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->j:Lcom/salesforce/android/knowledge/ui/internal/minimize/MinimizeControl;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/minimize/MinimizeControl;->b()V

    .line 274
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->i:Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator;->f()V

    .line 276
    invoke-virtual {p0}, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->l()V

    .line 279
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->o:Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/knowledge/ui/KnowledgeUIClient$OnCloseListener;

    .line 280
    invoke-interface {v0}, Lcom/salesforce/android/knowledge/ui/KnowledgeUIClient$OnCloseListener;->a()V

    goto :goto_0

    .line 284
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->l:Lcom/salesforce/android/knowledge/ui/internal/logging/LiveAgentKnowledgeLogger;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/logging/LiveAgentKnowledgeLogger;->a()V

    .line 287
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->k:Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;

    invoke-virtual {v0, p0}, Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;->b(Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker$OnCreateListener;)Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;->b(Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker$OnStartListener;)Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;->b(Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker$OnDestroyListener;)Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;->a()V

    .line 288
    invoke-static {}, Lcom/salesforce/android/knowledge/ui/KnowledgeUIAnalyticsEmit;->a()V

    .line 290
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->c:Lcom/salesforce/android/knowledge/core/KnowledgeClient;

    invoke-interface {v0}, Lcom/salesforce/android/knowledge/core/KnowledgeClient;->c()V

    .line 291
    return-void
.end method
