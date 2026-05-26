.class public Lcom/salesforce/android/knowledge/ui/internal/activity/KnowledgeActivity;
.super Landroid/support/v7/app/AppCompatActivity;
.source "KnowledgeActivity.java"


# instance fields
.field private a:Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 37
    invoke-direct {p0}, Landroid/support/v7/app/AppCompatActivity;-><init>()V

    return-void
.end method

.method public static a(Landroid/content/Context;)V
    .locals 2

    .prologue
    .line 44
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/salesforce/android/knowledge/ui/internal/activity/KnowledgeActivity;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 45
    const/high16 v1, 0x10000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 46
    invoke-virtual {p0, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 47
    return-void
.end method


# virtual methods
.method public a()Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;
    .locals 1

    .prologue
    .line 82
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/activity/KnowledgeActivity;->a:Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;

    return-object v0
.end method

.method public a(Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;)V
    .locals 0

    .prologue
    .line 78
    iput-object p1, p0, Lcom/salesforce/android/knowledge/ui/internal/activity/KnowledgeActivity;->a:Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;

    .line 79
    return-void
.end method

.method public onBackPressed()V
    .locals 1

    .prologue
    .line 66
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/activity/KnowledgeActivity;->a:Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;

    if-eqz v0, :cond_0

    .line 67
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/activity/KnowledgeActivity;->a:Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->m()V

    .line 71
    :goto_0
    return-void

    .line 69
    :cond_0
    invoke-super {p0}, Landroid/support/v7/app/AppCompatActivity;->onBackPressed()V

    goto :goto_0
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 1

    .prologue
    const-string v0, "com.salesforce.android.knowledge.ui.internal.activity.KnowledgeActivity"

    invoke-static {v0}, Lcom/google/firebase/perf/metrics/AppStartTrace;->setLauncherActivityOnCreateTime(Ljava/lang/String;)V

    .line 61
    invoke-super {p0, p1}, Landroid/support/v7/app/AppCompatActivity;->onCreate(Landroid/os/Bundle;)V

    .line 62
    sget v0, Lcom/salesforce/android/knowledge/ui/R$layout;->knowledge_activity:I

    invoke-virtual {p0, v0}, Lcom/salesforce/android/knowledge/ui/internal/activity/KnowledgeActivity;->setContentView(I)V

    .line 63
    return-void
.end method

.method protected onResume()V
    .locals 1

    const-string v0, "com.salesforce.android.knowledge.ui.internal.activity.KnowledgeActivity"

    invoke-static {v0}, Lcom/google/firebase/perf/metrics/AppStartTrace;->setLauncherActivityOnResumeTime(Ljava/lang/String;)V

    invoke-super {p0}, Landroid/support/v7/app/AppCompatActivity;->onResume()V

    return-void
.end method

.method protected onStart()V
    .locals 1

    const-string v0, "com.salesforce.android.knowledge.ui.internal.activity.KnowledgeActivity"

    invoke-static {v0}, Lcom/google/firebase/perf/metrics/AppStartTrace;->setLauncherActivityOnStartTime(Ljava/lang/String;)V

    invoke-super {p0}, Landroid/support/v7/app/AppCompatActivity;->onStart()V

    return-void
.end method
