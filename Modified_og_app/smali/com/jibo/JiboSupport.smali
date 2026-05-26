.class public Lcom/jibo/JiboSupport;
.super Ljava/lang/Object;
.source "JiboSupport.java"


# static fields
.field private static a:Lcom/salesforce/android/knowledge/ui/KnowledgeUIClient;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 99
    const/4 v0, 0x0

    sput-object v0, Lcom/jibo/JiboSupport;->a:Lcom/salesforce/android/knowledge/ui/KnowledgeUIClient;

    return-void
.end method

.method static synthetic a(Lcom/salesforce/android/knowledge/ui/KnowledgeUIClient;)Lcom/salesforce/android/knowledge/ui/KnowledgeUIClient;
    .locals 0

    .prologue
    .line 32
    sput-object p0, Lcom/jibo/JiboSupport;->a:Lcom/salesforce/android/knowledge/ui/KnowledgeUIClient;

    return-object p0
.end method

.method public static a(Landroid/app/Activity;)V
    .locals 3

    .prologue
    .line 105
    sget-object v0, Lcom/jibo/JiboSupport;->a:Lcom/salesforce/android/knowledge/ui/KnowledgeUIClient;

    if-eqz v0, :cond_0

    .line 106
    sget-object v0, Lcom/jibo/JiboSupport;->a:Lcom/salesforce/android/knowledge/ui/KnowledgeUIClient;

    invoke-interface {v0}, Lcom/salesforce/android/knowledge/ui/KnowledgeUIClient;->b()V

    .line 107
    const/4 v0, 0x0

    sput-object v0, Lcom/jibo/JiboSupport;->a:Lcom/salesforce/android/knowledge/ui/KnowledgeUIClient;

    .line 110
    :cond_0
    sget-object v0, Lcom/jibo/JiboSupport;->a:Lcom/salesforce/android/knowledge/ui/KnowledgeUIClient;

    if-nez v0, :cond_1

    .line 111
    invoke-static {p0}, Lcom/jibo/JiboAnalytics;->h(Landroid/content/Context;)V

    .line 112
    const-string v0, "https://jibo.force.com/jibo"

    .line 113
    invoke-static {v0}, Lcom/salesforce/android/knowledge/core/KnowledgeConfiguration;->a(Ljava/lang/String;)Lcom/salesforce/android/knowledge/core/KnowledgeConfiguration;

    move-result-object v0

    .line 116
    const-string v1, "Robot"

    const-string v2, "All"

    .line 117
    invoke-static {v0, v1, v2}, Lcom/salesforce/android/knowledge/ui/KnowledgeUIConfiguration;->a(Lcom/salesforce/android/knowledge/core/KnowledgeConfiguration;Ljava/lang/String;Ljava/lang/String;)Lcom/salesforce/android/knowledge/ui/KnowledgeUIConfiguration;

    move-result-object v0

    .line 120
    invoke-static {v0}, Lcom/salesforce/android/knowledge/ui/KnowledgeUI;->a(Lcom/salesforce/android/knowledge/ui/KnowledgeUIConfiguration;)Lcom/salesforce/android/knowledge/ui/KnowledgeUI;

    move-result-object v0

    new-instance v1, Lcom/jibo/JiboViewAddition;

    invoke-direct {v1}, Lcom/jibo/JiboViewAddition;-><init>()V

    invoke-virtual {v0, v1}, Lcom/salesforce/android/knowledge/ui/KnowledgeUI;->a(Lcom/salesforce/android/knowledge/ui/KnowledgeViewAddition;)Lcom/salesforce/android/knowledge/ui/KnowledgeUI;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/salesforce/android/knowledge/ui/KnowledgeUI;->a(Landroid/content/Context;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    new-instance v1, Lcom/jibo/JiboSupport$4;

    invoke-direct {v1, p0}, Lcom/jibo/JiboSupport$4;-><init>(Landroid/app/Activity;)V

    .line 121
    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/control/Async;->a(Lcom/salesforce/android/service/common/utilities/control/Async$ResultHandler;)Lcom/salesforce/android/service/common/utilities/control/Async;

    .line 144
    :cond_1
    return-void
.end method

.method public static a(Landroid/content/Context;)V
    .locals 2

    .prologue
    .line 43
    new-instance v0, Lcom/jibo/JiboSupport$1;

    invoke-direct {v0}, Lcom/jibo/JiboSupport$1;-><init>()V

    const-class v1, Lcom/jibo/ui/activity/OnBoardingActivity;

    invoke-static {p0, v0, v1}, Lcom/salesforce/androidsdk/smartstore/app/SmartStoreSDKManager;->a(Landroid/content/Context;Lcom/salesforce/androidsdk/app/SalesforceSDKManager$KeyInterface;Ljava/lang/Class;)V

    .line 51
    return-void
.end method

.method public static b(Landroid/content/Context;)V
    .locals 4

    .prologue
    .line 55
    new-instance v0, Lcom/jibo/JiboSupport$2;

    invoke-direct {v0, p0}, Lcom/jibo/JiboSupport$2;-><init>(Landroid/content/Context;)V

    .line 79
    new-instance v1, Lcom/salesforce/android/cases/core/CaseConfiguration$Builder;

    const-string v2, "https://jibo.force.com/jibo"

    const-string v3, "NewCase"

    invoke-direct {v1, v2, v3}, Lcom/salesforce/android/cases/core/CaseConfiguration$Builder;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 82
    invoke-virtual {v1, v0}, Lcom/salesforce/android/cases/core/CaseConfiguration$Builder;->a(Lcom/salesforce/android/cases/core/CaseClientCallbacks;)Lcom/salesforce/android/cases/core/CaseConfiguration$Builder;

    move-result-object v0

    .line 83
    invoke-virtual {v0}, Lcom/salesforce/android/cases/core/CaseConfiguration$Builder;->a()Lcom/salesforce/android/cases/core/CaseConfiguration;

    move-result-object v0

    .line 86
    invoke-static {p0}, Lcom/salesforce/android/cases/ui/CaseUI;->a(Landroid/content/Context;)Lcom/salesforce/android/cases/ui/CaseUI;

    move-result-object v1

    invoke-static {v0}, Lcom/salesforce/android/cases/ui/CaseUIConfiguration;->a(Lcom/salesforce/android/cases/core/CaseConfiguration;)Lcom/salesforce/android/cases/ui/CaseUIConfiguration;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/salesforce/android/cases/ui/CaseUI;->a(Lcom/salesforce/android/cases/ui/CaseUIConfiguration;)Lcom/salesforce/android/cases/ui/CaseUI;

    .line 89
    invoke-static {p0}, Lcom/salesforce/android/cases/ui/CaseUI;->a(Landroid/content/Context;)Lcom/salesforce/android/cases/ui/CaseUI;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/android/cases/ui/CaseUI;->a()Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    new-instance v1, Lcom/jibo/JiboSupport$3;

    invoke-direct {v1, p0}, Lcom/jibo/JiboSupport$3;-><init>(Landroid/content/Context;)V

    .line 90
    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/control/Async;->a(Lcom/salesforce/android/service/common/utilities/control/Async$ResultHandler;)Lcom/salesforce/android/service/common/utilities/control/Async;

    .line 97
    return-void
.end method
