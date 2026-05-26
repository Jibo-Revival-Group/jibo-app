.class public Lcom/salesforce/android/knowledge/ui/internal/activity/KnowledgeFragment;
.super Landroid/support/v4/app/Fragment;
.source "KnowledgeFragment.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/knowledge/ui/internal/activity/KnowledgeFragment$Factory;
    }
.end annotation


# instance fields
.field private a:Lcom/salesforce/android/knowledge/ui/internal/navigation/ViewState;

.field private b:Lcom/salesforce/android/knowledge/ui/internal/ViewBinder;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 47
    invoke-direct {p0}, Landroid/support/v4/app/Fragment;-><init>()V

    return-void
.end method

.method private a(Lcom/salesforce/android/knowledge/ui/internal/activity/KnowledgeActivity;)Lcom/salesforce/android/knowledge/ui/internal/navigation/ViewState;
    .locals 2

    .prologue
    .line 61
    invoke-virtual {p1}, Lcom/salesforce/android/knowledge/ui/internal/activity/KnowledgeActivity;->a()Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;

    move-result-object v0

    .line 63
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->i()Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator;

    move-result-object v1

    if-nez v1, :cond_1

    .line 64
    :cond_0
    const/4 v0, 0x0

    .line 68
    :goto_0
    return-object v0

    .line 67
    :cond_1
    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->i()Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator;

    move-result-object v0

    .line 68
    invoke-virtual {v0, p1}, Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator;->a(Landroid/content/Context;)Lcom/salesforce/android/knowledge/ui/internal/navigation/ViewState;

    move-result-object v0

    goto :goto_0
.end method


# virtual methods
.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 112
    invoke-super {p0, p1}, Landroid/support/v4/app/Fragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 114
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/activity/KnowledgeFragment;->b:Lcom/salesforce/android/knowledge/ui/internal/ViewBinder;

    if-eqz v0, :cond_0

    .line 115
    invoke-virtual {p0}, Lcom/salesforce/android/knowledge/ui/internal/activity/KnowledgeFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    sget v1, Lcom/salesforce/android/knowledge/ui/R$id;->knowledge_fragment_container:I

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/activity/KnowledgeFragment;->b:Lcom/salesforce/android/knowledge/ui/internal/ViewBinder;

    invoke-virtual {v1}, Lcom/salesforce/android/knowledge/ui/internal/ViewBinder;->e()I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/view/View;->setBackgroundResource(I)V

    .line 117
    :cond_0
    return-void
.end method

.method public onAttach(Landroid/content/Context;)V
    .locals 1

    .prologue
    .line 77
    invoke-super {p0, p1}, Landroid/support/v4/app/Fragment;->onAttach(Landroid/content/Context;)V

    .line 78
    instance-of v0, p1, Lcom/salesforce/android/knowledge/ui/internal/activity/KnowledgeActivity;

    if-eqz v0, :cond_0

    .line 79
    check-cast p1, Lcom/salesforce/android/knowledge/ui/internal/activity/KnowledgeActivity;

    invoke-direct {p0, p1}, Lcom/salesforce/android/knowledge/ui/internal/activity/KnowledgeFragment;->a(Lcom/salesforce/android/knowledge/ui/internal/activity/KnowledgeActivity;)Lcom/salesforce/android/knowledge/ui/internal/navigation/ViewState;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/activity/KnowledgeFragment;->a:Lcom/salesforce/android/knowledge/ui/internal/navigation/ViewState;

    .line 80
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/activity/KnowledgeFragment;->a:Lcom/salesforce/android/knowledge/ui/internal/navigation/ViewState;

    if-eqz v0, :cond_0

    .line 81
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/activity/KnowledgeFragment;->a:Lcom/salesforce/android/knowledge/ui/internal/navigation/ViewState;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/navigation/ViewState;->a()Lcom/salesforce/android/knowledge/ui/internal/ViewBinder;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/activity/KnowledgeFragment;->b:Lcom/salesforce/android/knowledge/ui/internal/ViewBinder;

    .line 84
    :cond_0
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 1

    .prologue
    .line 87
    invoke-super {p0, p1}, Landroid/support/v4/app/Fragment;->onCreate(Landroid/os/Bundle;)V

    .line 89
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/activity/KnowledgeFragment;->b:Lcom/salesforce/android/knowledge/ui/internal/ViewBinder;

    if-eqz v0, :cond_0

    .line 90
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/activity/KnowledgeFragment;->b:Lcom/salesforce/android/knowledge/ui/internal/ViewBinder;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/ViewBinder;->t_()Z

    move-result v0

    invoke-virtual {p0, v0}, Lcom/salesforce/android/knowledge/ui/internal/activity/KnowledgeFragment;->setHasOptionsMenu(Z)V

    .line 92
    :cond_0
    return-void
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V
    .locals 1

    .prologue
    .line 142
    invoke-super {p0, p1, p2}, Landroid/support/v4/app/Fragment;->onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V

    .line 144
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/activity/KnowledgeFragment;->b:Lcom/salesforce/android/knowledge/ui/internal/ViewBinder;

    if-eqz v0, :cond_0

    .line 145
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/activity/KnowledgeFragment;->b:Lcom/salesforce/android/knowledge/ui/internal/ViewBinder;

    invoke-virtual {v0, p1, p2}, Lcom/salesforce/android/knowledge/ui/internal/ViewBinder;->a(Landroid/view/Menu;Landroid/view/MenuInflater;)V

    .line 147
    :cond_0
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 3

    .prologue
    .line 96
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/activity/KnowledgeFragment;->b:Lcom/salesforce/android/knowledge/ui/internal/ViewBinder;

    if-nez v0, :cond_0

    .line 97
    const/4 v0, 0x0

    .line 108
    :goto_0
    return-object v0

    .line 100
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/activity/KnowledgeFragment;->b:Lcom/salesforce/android/knowledge/ui/internal/ViewBinder;

    invoke-virtual {v0, p1, p2, p3}, Lcom/salesforce/android/knowledge/ui/internal/ViewBinder;->a(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    move-result-object v1

    .line 102
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/activity/KnowledgeFragment;->b:Lcom/salesforce/android/knowledge/ui/internal/ViewBinder;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/ViewBinder;->t_()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 103
    invoke-virtual {p0}, Lcom/salesforce/android/knowledge/ui/internal/activity/KnowledgeFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Landroid/support/v7/app/AppCompatActivity;

    .line 104
    iget-object v2, p0, Lcom/salesforce/android/knowledge/ui/internal/activity/KnowledgeFragment;->b:Lcom/salesforce/android/knowledge/ui/internal/ViewBinder;

    invoke-virtual {v2}, Lcom/salesforce/android/knowledge/ui/internal/ViewBinder;->d()Landroid/support/v7/widget/Toolbar;

    move-result-object v2

    .line 105
    invoke-virtual {v0, v2}, Landroid/support/v7/app/AppCompatActivity;->setSupportActionBar(Landroid/support/v7/widget/Toolbar;)V

    :cond_1
    move-object v0, v1

    .line 108
    goto :goto_0
.end method

.method public onDestroyView()V
    .locals 1

    .prologue
    .line 127
    invoke-super {p0}, Landroid/support/v4/app/Fragment;->onDestroyView()V

    .line 132
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/activity/KnowledgeFragment;->a:Lcom/salesforce/android/knowledge/ui/internal/navigation/ViewState;

    if-eqz v0, :cond_0

    .line 133
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/activity/KnowledgeFragment;->a:Lcom/salesforce/android/knowledge/ui/internal/navigation/ViewState;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/navigation/ViewState;->b()V

    .line 136
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/activity/KnowledgeFragment;->b:Lcom/salesforce/android/knowledge/ui/internal/ViewBinder;

    if-eqz v0, :cond_1

    .line 137
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/activity/KnowledgeFragment;->b:Lcom/salesforce/android/knowledge/ui/internal/ViewBinder;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/ViewBinder;->b()V

    .line 139
    :cond_1
    return-void
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 1

    .prologue
    .line 150
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/activity/KnowledgeFragment;->b:Lcom/salesforce/android/knowledge/ui/internal/ViewBinder;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/activity/KnowledgeFragment;->b:Lcom/salesforce/android/knowledge/ui/internal/ViewBinder;

    invoke-virtual {v0, p1}, Lcom/salesforce/android/knowledge/ui/internal/ViewBinder;->a(Landroid/view/MenuItem;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public onViewStateRestored(Landroid/os/Bundle;)V
    .locals 1

    .prologue
    .line 120
    invoke-super {p0, p1}, Landroid/support/v4/app/Fragment;->onViewStateRestored(Landroid/os/Bundle;)V

    .line 121
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/activity/KnowledgeFragment;->a:Lcom/salesforce/android/knowledge/ui/internal/navigation/ViewState;

    if-eqz v0, :cond_0

    .line 122
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/activity/KnowledgeFragment;->a:Lcom/salesforce/android/knowledge/ui/internal/navigation/ViewState;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/navigation/ViewState;->c()V

    .line 124
    :cond_0
    return-void
.end method
