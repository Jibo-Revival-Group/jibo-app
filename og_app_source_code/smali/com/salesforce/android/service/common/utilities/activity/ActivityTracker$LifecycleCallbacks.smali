.class Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker$LifecycleCallbacks;
.super Ljava/lang/Object;
.source "ActivityTracker.java"

# interfaces
.implements Landroid/app/Application$ActivityLifecycleCallbacks;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "LifecycleCallbacks"
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;


# direct methods
.method constructor <init>(Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;)V
    .locals 0

    .prologue
    .line 151
    iput-object p1, p0, Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker$LifecycleCallbacks;->a:Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 152
    return-void
.end method


# virtual methods
.method public onActivityCreated(Landroid/app/Activity;Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 155
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker$LifecycleCallbacks;->a:Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;

    iget-object v0, v0, Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;->c:Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker$OnCreateListener;

    .line 156
    invoke-interface {v0, p1}, Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker$OnCreateListener;->c(Landroid/app/Activity;)V

    goto :goto_0

    .line 158
    :cond_0
    return-void
.end method

.method public onActivityDestroyed(Landroid/app/Activity;)V
    .locals 2

    .prologue
    .line 198
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker$LifecycleCallbacks;->a:Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;

    iget-object v0, v0, Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;->g:Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker$OnDestroyListener;

    .line 199
    invoke-interface {v0, p1}, Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker$OnDestroyListener;->d(Landroid/app/Activity;)V

    goto :goto_0

    .line 201
    :cond_0
    return-void
.end method

.method public onActivityPaused(Landroid/app/Activity;)V
    .locals 2

    .prologue
    .line 181
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker$LifecycleCallbacks;->a:Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;

    iget-object v0, v0, Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;->a:Lcom/salesforce/android/service/common/utilities/activity/ActivityReference;

    invoke-virtual {v0, p1}, Lcom/salesforce/android/service/common/utilities/activity/ActivityReference;->b(Ljava/lang/Object;)V

    .line 182
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker$LifecycleCallbacks;->a:Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;

    iget-object v0, v0, Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;->f:Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker$OnPauseListener;

    .line 183
    invoke-interface {v0, p1}, Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker$OnPauseListener;->c(Landroid/app/Activity;)V

    goto :goto_0

    .line 185
    :cond_0
    return-void
.end method

.method public onActivityResumed(Landroid/app/Activity;)V
    .locals 4

    .prologue
    .line 170
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker$LifecycleCallbacks;->a:Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;

    iget-object v0, v0, Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;->a:Lcom/salesforce/android/service/common/utilities/activity/ActivityReference;

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/utilities/activity/ActivityReference;->b()Z

    move-result v0

    if-nez v0, :cond_0

    .line 171
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker$LifecycleCallbacks;->a:Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;

    invoke-static {p1}, Lcom/salesforce/android/service/common/utilities/activity/ActivityReference;->a(Landroid/app/Activity;)Lcom/salesforce/android/service/common/utilities/activity/ActivityReference;

    move-result-object v1

    iput-object v1, v0, Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;->a:Lcom/salesforce/android/service/common/utilities/activity/ActivityReference;

    .line 172
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker$LifecycleCallbacks;->a:Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;

    iget-object v0, v0, Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;->e:Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker$OnResumeListener;

    .line 173
    invoke-interface {v0, p1}, Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker$OnResumeListener;->b(Landroid/app/Activity;)V

    goto :goto_0

    .line 176
    :cond_0
    invoke-static {}, Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;->c()Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    move-result-object v0

    const-string v1, "Ignoring onActivityResume on {}. It is behind another activity."

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    aput-object p1, v2, v3

    invoke-interface {v0, v1, v2}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->c(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 178
    :cond_1
    return-void
.end method

.method public onActivitySaveInstanceState(Landroid/app/Activity;Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 195
    return-void
.end method

.method public onActivityStarted(Landroid/app/Activity;)V
    .locals 2

    .prologue
    .line 161
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker$LifecycleCallbacks;->a:Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;

    iget-object v0, v0, Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;->d:Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker$OnStartListener;

    .line 162
    invoke-interface {v0, p1}, Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker$OnStartListener;->a(Landroid/app/Activity;)V

    goto :goto_0

    .line 164
    :cond_0
    return-void
.end method

.method public onActivityStopped(Landroid/app/Activity;)V
    .locals 2

    .prologue
    .line 188
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker$LifecycleCallbacks;->a:Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;

    iget-object v0, v0, Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;->h:Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker$OnStopListener;

    .line 189
    invoke-interface {v0, p1}, Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker$OnStopListener;->a(Landroid/app/Activity;)V

    goto :goto_0

    .line 191
    :cond_0
    return-void
.end method
