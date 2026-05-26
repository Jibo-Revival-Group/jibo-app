.class Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment$EmailSuggestionsListAdapter$EmailSuggestionViewHolder;
.super Ljava/lang/Object;
.source "BaseSuggestionFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment$EmailSuggestionsListAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "EmailSuggestionViewHolder"
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment$EmailSuggestionsListAdapter;

.field contactPhoto:Landroid/widget/ImageView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field selectedCheck:Landroid/widget/ImageView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field textDisplayName:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field textEmail:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment$EmailSuggestionsListAdapter;Landroid/view/View;)V
    .locals 0

    .prologue
    .line 220
    iput-object p1, p0, Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment$EmailSuggestionsListAdapter$EmailSuggestionViewHolder;->a:Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment$EmailSuggestionsListAdapter;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 221
    invoke-static {p0, p2}, Lbutterknife/ButterKnife;->a(Ljava/lang/Object;Landroid/view/View;)Lbutterknife/Unbinder;

    .line 222
    return-void
.end method


# virtual methods
.method public a(Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment$EmailSuggestion;)V
    .locals 4

    .prologue
    const/16 v3, 0x8

    const v2, 0x7f080167

    .line 225
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment$EmailSuggestionsListAdapter$EmailSuggestionViewHolder;->a:Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment$EmailSuggestionsListAdapter;

    iget-boolean v0, v0, Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment$EmailSuggestionsListAdapter;->a:Z

    if-eqz v0, :cond_0

    .line 226
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment$EmailSuggestionsListAdapter$EmailSuggestionViewHolder;->textDisplayName:Landroid/widget/TextView;

    invoke-virtual {p1}, Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment$EmailSuggestion;->a()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 227
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment$EmailSuggestionsListAdapter$EmailSuggestionViewHolder;->textEmail:Landroid/widget/TextView;

    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setVisibility(I)V

    .line 234
    :goto_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment$EmailSuggestionsListAdapter$EmailSuggestionViewHolder;->selectedCheck:Landroid/widget/ImageView;

    invoke-virtual {v0, v3}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 235
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment$EmailSuggestionsListAdapter$EmailSuggestionViewHolder;->a:Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment$EmailSuggestionsListAdapter;

    iget-object v0, v0, Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment$EmailSuggestionsListAdapter;->b:Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/bumptech/glide/Glide;->b(Landroid/content/Context;)Lcom/bumptech/glide/RequestManager;

    move-result-object v0

    invoke-virtual {p1}, Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment$EmailSuggestion;->c()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bumptech/glide/RequestManager;->a(Ljava/lang/String;)Lcom/bumptech/glide/DrawableTypeRequest;

    move-result-object v0

    invoke-virtual {v0, v2}, Lcom/bumptech/glide/DrawableTypeRequest;->a(I)Lcom/bumptech/glide/DrawableRequestBuilder;

    move-result-object v0

    .line 237
    invoke-virtual {v0, v2}, Lcom/bumptech/glide/DrawableRequestBuilder;->b(I)Lcom/bumptech/glide/DrawableRequestBuilder;

    move-result-object v0

    invoke-virtual {v0, v2}, Lcom/bumptech/glide/DrawableRequestBuilder;->c(I)Lcom/bumptech/glide/DrawableRequestBuilder;

    move-result-object v0

    sget-object v1, Lcom/bumptech/glide/load/engine/DiskCacheStrategy;->ALL:Lcom/bumptech/glide/load/engine/DiskCacheStrategy;

    .line 238
    invoke-virtual {v0, v1}, Lcom/bumptech/glide/DrawableRequestBuilder;->a(Lcom/bumptech/glide/load/engine/DiskCacheStrategy;)Lcom/bumptech/glide/DrawableRequestBuilder;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bumptech/glide/DrawableRequestBuilder;->d()Lcom/bumptech/glide/DrawableRequestBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment$EmailSuggestionsListAdapter$EmailSuggestionViewHolder;->contactPhoto:Landroid/widget/ImageView;

    invoke-virtual {v0, v1}, Lcom/bumptech/glide/DrawableRequestBuilder;->a(Landroid/widget/ImageView;)Lcom/bumptech/glide/request/target/Target;

    .line 239
    return-void

    .line 229
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment$EmailSuggestionsListAdapter$EmailSuggestionViewHolder;->textDisplayName:Landroid/widget/TextView;

    invoke-virtual {p1}, Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment$EmailSuggestion;->b()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 230
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment$EmailSuggestionsListAdapter$EmailSuggestionViewHolder;->textEmail:Landroid/widget/TextView;

    invoke-virtual {p1}, Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment$EmailSuggestion;->a()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 231
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment$EmailSuggestionsListAdapter$EmailSuggestionViewHolder;->textEmail:Landroid/widget/TextView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_0
.end method
