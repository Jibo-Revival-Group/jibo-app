.class public Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment$EmailSuggestionsListAdapter;
.super Landroid/widget/CursorAdapter;
.source "BaseSuggestionFragment.java"

# interfaces
.implements Landroid/widget/Filterable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "EmailSuggestionsListAdapter"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment$EmailSuggestionsListAdapter$EmailSuggestionViewHolder;
    }
.end annotation


# instance fields
.field public a:Z

.field final synthetic b:Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment;

.field private c:Landroid/content/ContentResolver;


# direct methods
.method public constructor <init>(Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment;Landroid/content/Context;Landroid/database/Cursor;Z)V
    .locals 1

    .prologue
    .line 113
    iput-object p1, p0, Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment$EmailSuggestionsListAdapter;->b:Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment;

    .line 114
    invoke-direct {p0, p2, p3, p4}, Landroid/widget/CursorAdapter;-><init>(Landroid/content/Context;Landroid/database/Cursor;Z)V

    .line 110
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment$EmailSuggestionsListAdapter;->a:Z

    .line 115
    invoke-virtual {p2}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment$EmailSuggestionsListAdapter;->c:Landroid/content/ContentResolver;

    .line 116
    return-void
.end method


# virtual methods
.method public a(I)Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment$EmailSuggestion;
    .locals 5

    .prologue
    .line 119
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment$EmailSuggestionsListAdapter;->getCursor()Landroid/database/Cursor;

    move-result-object v0

    .line 120
    invoke-interface {v0, p1}, Landroid/database/Cursor;->moveToPosition(I)Z

    .line 121
    const-string v1, "display_name"

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    .line 122
    const-string v2, "data1"

    invoke-interface {v0, v2}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v2

    .line 123
    const-string v3, "photo_thumb_uri"

    invoke-interface {v0, v3}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v3

    .line 124
    new-instance v4, Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment$EmailSuggestion;

    invoke-interface {v0, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 125
    invoke-interface {v0, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v3}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment$EmailSuggestionsListAdapter;->a(Landroid/database/Cursor;)Ljava/lang/String;

    move-result-object v0

    invoke-direct {v4, v2, v1, v3, v0}, Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment$EmailSuggestion;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    return-object v4
.end method

.method public a(Landroid/database/Cursor;)Ljava/lang/String;
    .locals 7

    .prologue
    const/4 v4, 0x0

    .line 177
    .line 178
    const-string v0, "display_name"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v6

    .line 180
    const/4 v0, 0x4

    new-array v2, v0, [Ljava/lang/String;

    const/4 v0, 0x0

    const-string v1, "display_name"

    aput-object v1, v2, v0

    const/4 v0, 0x1

    const-string v1, "data1"

    aput-object v1, v2, v0

    const/4 v0, 0x2

    const-string v1, "data2"

    aput-object v1, v2, v0

    const/4 v0, 0x3

    const-string v1, "mimetype"

    aput-object v1, v2, v0

    .line 187
    const-string v3, "data2=3 and mimetype = \'vnd.android.cursor.item/contact_event\'"

    .line 191
    const-string v5, "display_name"

    .line 193
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment$EmailSuggestionsListAdapter;->c:Landroid/content/ContentResolver;

    sget-object v1, Landroid/provider/ContactsContract$Data;->CONTENT_URI:Landroid/net/Uri;

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v1

    .line 194
    invoke-interface {v1}, Landroid/database/Cursor;->getCount()I

    move-result v0

    if-lez v0, :cond_1

    move-object v0, v4

    .line 195
    :cond_0
    :goto_0
    invoke-interface {v1}, Landroid/database/Cursor;->moveToNext()Z

    move-result v2

    if-eqz v2, :cond_2

    .line 196
    const-string v2, "display_name"

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v2

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 198
    invoke-virtual {v6, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 199
    const-string v0, "data1"

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    :cond_1
    move-object v0, v4

    .line 203
    :cond_2
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 204
    return-object v0
.end method

.method public bindView(Landroid/view/View;Landroid/content/Context;Landroid/database/Cursor;)V
    .locals 5

    .prologue
    .line 136
    const-string v0, "display_name"

    invoke-interface {p3, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    .line 137
    const-string v1, "data1"

    invoke-interface {p3, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    .line 138
    const-string v2, "photo_thumb_uri"

    invoke-interface {p3, v2}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v2

    .line 139
    new-instance v3, Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment$EmailSuggestion;

    invoke-interface {p3, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 140
    invoke-interface {p3, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-interface {p3, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    const/4 v4, 0x0

    invoke-direct {v3, v1, v0, v2, v4}, Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment$EmailSuggestion;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 142
    new-instance v0, Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment$EmailSuggestionsListAdapter$EmailSuggestionViewHolder;

    invoke-direct {v0, p0, p1}, Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment$EmailSuggestionsListAdapter$EmailSuggestionViewHolder;-><init>(Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment$EmailSuggestionsListAdapter;Landroid/view/View;)V

    .line 144
    invoke-virtual {v0, v3}, Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment$EmailSuggestionsListAdapter$EmailSuggestionViewHolder;->a(Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment$EmailSuggestion;)V

    .line 145
    return-void
.end method

.method public convertToString(Landroid/database/Cursor;)Ljava/lang/CharSequence;
    .locals 1

    .prologue
    .line 149
    iget-boolean v0, p0, Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment$EmailSuggestionsListAdapter;->a:Z

    if-eqz v0, :cond_0

    .line 150
    const-string v0, "data1"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    .line 151
    invoke-interface {p1, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 154
    :goto_0
    return-object v0

    .line 153
    :cond_0
    const-string v0, "display_name"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    .line 154
    invoke-interface {p1, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public newView(Landroid/content/Context;Landroid/database/Cursor;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 3

    .prologue
    .line 130
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment$EmailSuggestionsListAdapter;->b:Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    const v1, 0x7f0b00bb

    const/4 v2, 0x0

    invoke-virtual {v0, v1, p3, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public runQueryOnBackgroundThread(Ljava/lang/CharSequence;)Landroid/database/Cursor;
    .locals 6

    .prologue
    const/4 v3, 0x0

    .line 160
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment$EmailSuggestionsListAdapter;->getFilterQueryProvider()Landroid/widget/FilterQueryProvider;

    move-result-object v0

    .line 161
    if-eqz v0, :cond_0

    .line 162
    invoke-interface {v0, p1}, Landroid/widget/FilterQueryProvider;->runQuery(Ljava/lang/CharSequence;)Landroid/database/Cursor;

    move-result-object v0

    .line 168
    :goto_0
    return-object v0

    .line 165
    :cond_0
    sget-object v0, Landroid/provider/ContactsContract$CommonDataKinds$Email;->CONTENT_FILTER_URI:Landroid/net/Uri;

    .line 167
    invoke-interface {p1}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/net/Uri;->encode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 165
    invoke-static {v0, v1}, Landroid/net/Uri;->withAppendedPath(Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    .line 168
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment$EmailSuggestionsListAdapter;->c:Landroid/content/ContentResolver;

    const/4 v2, 0x5

    new-array v2, v2, [Ljava/lang/String;

    const/4 v4, 0x0

    const-string v5, "_id"

    aput-object v5, v2, v4

    const/4 v4, 0x1

    const-string v5, "lookup"

    aput-object v5, v2, v4

    const/4 v4, 0x2

    const-string v5, "display_name"

    aput-object v5, v2, v4

    const/4 v4, 0x3

    const-string v5, "data1"

    aput-object v5, v2, v4

    const/4 v4, 0x4

    const-string v5, "photo_thumb_uri"

    aput-object v5, v2, v4

    move-object v4, v3

    move-object v5, v3

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    goto :goto_0
.end method
