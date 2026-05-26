.class public abstract Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment;
.super Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;
.source "BaseSuggestionFragment.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment$EmailSuggestionsListAdapter;,
        Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment$EmailSuggestion;
    }
.end annotation


# instance fields
.field a:Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment$EmailSuggestionsListAdapter;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 37
    invoke-direct {p0}, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;-><init>()V

    return-void
.end method

.method private r()V
    .locals 3

    .prologue
    .line 51
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    const-string v1, "android.permission.READ_CONTACTS"

    invoke-static {v0, v1}, Landroid/support/v4/content/PermissionChecker;->a(Landroid/content/Context;Ljava/lang/String;)I

    move-result v0

    if-eqz v0, :cond_0

    .line 53
    const/4 v0, 0x1

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    const-string v2, "android.permission.READ_CONTACTS"

    aput-object v2, v0, v1

    const/16 v1, 0x60

    invoke-virtual {p0, v0, v1}, Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment;->requestPermissions([Ljava/lang/String;I)V

    .line 55
    :cond_0
    return-void
.end method


# virtual methods
.method public onCreate(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 45
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->onCreate(Landroid/os/Bundle;)V

    .line 47
    invoke-direct {p0}, Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment;->r()V

    .line 48
    return-void
.end method

.method public onPause()V
    .locals 2

    .prologue
    .line 65
    invoke-super {p0}, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->onPause()V

    .line 66
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment;->a:Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment$EmailSuggestionsListAdapter;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment;->a:Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment$EmailSuggestionsListAdapter;

    .line 67
    invoke-virtual {v0}, Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment$EmailSuggestionsListAdapter;->getCursor()Landroid/database/Cursor;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 68
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment;->a:Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment$EmailSuggestionsListAdapter;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment$EmailSuggestionsListAdapter;->getCursor()Landroid/database/Cursor;

    move-result-object v0

    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    .line 69
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment;->a:Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment$EmailSuggestionsListAdapter;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment$EmailSuggestionsListAdapter;->swapCursor(Landroid/database/Cursor;)Landroid/database/Cursor;

    .line 71
    :cond_0
    return-void
.end method

.method public onResume()V
    .locals 4

    .prologue
    .line 59
    invoke-super {p0}, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->onResume()V

    .line 60
    new-instance v0, Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment$EmailSuggestionsListAdapter;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const/4 v2, 0x0

    const/4 v3, 0x1

    invoke-direct {v0, p0, v1, v2, v3}, Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment$EmailSuggestionsListAdapter;-><init>(Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment;Landroid/content/Context;Landroid/database/Cursor;Z)V

    iput-object v0, p0, Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment;->a:Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment$EmailSuggestionsListAdapter;

    .line 61
    return-void
.end method
