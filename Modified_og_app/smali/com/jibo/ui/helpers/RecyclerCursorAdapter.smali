.class public abstract Lcom/jibo/ui/helpers/RecyclerCursorAdapter;
.super Landroid/support/v7/widget/RecyclerView$Adapter;
.source "RecyclerCursorAdapter.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/jibo/ui/helpers/RecyclerCursorAdapter$MyDataSetObserver;,
        Lcom/jibo/ui/helpers/RecyclerCursorAdapter$ChangeObserver;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<VH:",
        "Landroid/support/v7/widget/RecyclerView$ViewHolder;",
        ">",
        "Landroid/support/v7/widget/RecyclerView$Adapter",
        "<TVH;>;"
    }
.end annotation


# instance fields
.field private a:Z

.field b:Z

.field c:Z

.field private d:I

.field private e:Landroid/database/Cursor;

.field private f:Lcom/jibo/ui/helpers/RecyclerCursorAdapter$ChangeObserver;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/jibo/ui/helpers/RecyclerCursorAdapter",
            "<TVH;>.ChangeObserver;"
        }
    .end annotation
.end field

.field private g:Landroid/database/DataSetObserver;


# direct methods
.method public constructor <init>(Landroid/database/Cursor;)V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 67
    invoke-direct {p0}, Landroid/support/v7/widget/RecyclerView$Adapter;-><init>()V

    .line 64
    iput-boolean v0, p0, Lcom/jibo/ui/helpers/RecyclerCursorAdapter;->b:Z

    .line 65
    iput-boolean v0, p0, Lcom/jibo/ui/helpers/RecyclerCursorAdapter;->c:Z

    .line 68
    invoke-virtual {p0, p1}, Lcom/jibo/ui/helpers/RecyclerCursorAdapter;->a(Landroid/database/Cursor;)V

    .line 69
    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/helpers/RecyclerCursorAdapter;Z)Z
    .locals 0

    .prologue
    .line 55
    iput-boolean p1, p0, Lcom/jibo/ui/helpers/RecyclerCursorAdapter;->a:Z

    return p1
.end method


# virtual methods
.method public a()Landroid/database/Cursor;
    .locals 1

    .prologue
    .line 167
    iget-object v0, p0, Lcom/jibo/ui/helpers/RecyclerCursorAdapter;->e:Landroid/database/Cursor;

    return-object v0
.end method

.method a(Landroid/database/Cursor;)V
    .locals 3

    .prologue
    .line 72
    if-eqz p1, :cond_2

    const/4 v0, 0x1

    .line 73
    :goto_0
    iput-object p1, p0, Lcom/jibo/ui/helpers/RecyclerCursorAdapter;->e:Landroid/database/Cursor;

    .line 74
    iput-boolean v0, p0, Lcom/jibo/ui/helpers/RecyclerCursorAdapter;->a:Z

    .line 75
    if-eqz v0, :cond_3

    const-string v1, "_id"

    invoke-interface {p1, v1}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v1

    :goto_1
    iput v1, p0, Lcom/jibo/ui/helpers/RecyclerCursorAdapter;->d:I

    .line 77
    new-instance v1, Lcom/jibo/ui/helpers/RecyclerCursorAdapter$ChangeObserver;

    invoke-direct {v1, p0}, Lcom/jibo/ui/helpers/RecyclerCursorAdapter$ChangeObserver;-><init>(Lcom/jibo/ui/helpers/RecyclerCursorAdapter;)V

    iput-object v1, p0, Lcom/jibo/ui/helpers/RecyclerCursorAdapter;->f:Lcom/jibo/ui/helpers/RecyclerCursorAdapter$ChangeObserver;

    .line 78
    new-instance v1, Lcom/jibo/ui/helpers/RecyclerCursorAdapter$MyDataSetObserver;

    const/4 v2, 0x0

    invoke-direct {v1, p0, v2}, Lcom/jibo/ui/helpers/RecyclerCursorAdapter$MyDataSetObserver;-><init>(Lcom/jibo/ui/helpers/RecyclerCursorAdapter;Lcom/jibo/ui/helpers/RecyclerCursorAdapter$1;)V

    iput-object v1, p0, Lcom/jibo/ui/helpers/RecyclerCursorAdapter;->g:Landroid/database/DataSetObserver;

    .line 80
    if-eqz v0, :cond_1

    .line 81
    iget-object v0, p0, Lcom/jibo/ui/helpers/RecyclerCursorAdapter;->f:Lcom/jibo/ui/helpers/RecyclerCursorAdapter$ChangeObserver;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/helpers/RecyclerCursorAdapter;->f:Lcom/jibo/ui/helpers/RecyclerCursorAdapter$ChangeObserver;

    invoke-interface {p1, v0}, Landroid/database/Cursor;->registerContentObserver(Landroid/database/ContentObserver;)V

    .line 82
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/helpers/RecyclerCursorAdapter;->g:Landroid/database/DataSetObserver;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/jibo/ui/helpers/RecyclerCursorAdapter;->g:Landroid/database/DataSetObserver;

    invoke-interface {p1, v0}, Landroid/database/Cursor;->registerDataSetObserver(Landroid/database/DataSetObserver;)V

    .line 84
    :cond_1
    return-void

    .line 72
    :cond_2
    const/4 v0, 0x0

    goto :goto_0

    .line 75
    :cond_3
    const/4 v1, -0x1

    goto :goto_1
.end method

.method public abstract a(Landroid/support/v7/widget/RecyclerView$ViewHolder;Landroid/database/Cursor;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TVH;",
            "Landroid/database/Cursor;",
            ")V"
        }
    .end annotation
.end method

.method public b(Landroid/database/Cursor;)Landroid/database/Cursor;
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 194
    iget-object v0, p0, Lcom/jibo/ui/helpers/RecyclerCursorAdapter;->e:Landroid/database/Cursor;

    if-ne p1, v0, :cond_0

    .line 195
    const/4 v0, 0x0

    .line 217
    :goto_0
    return-object v0

    .line 197
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/helpers/RecyclerCursorAdapter;->e:Landroid/database/Cursor;

    .line 198
    if-eqz v0, :cond_2

    .line 199
    iget-object v1, p0, Lcom/jibo/ui/helpers/RecyclerCursorAdapter;->f:Lcom/jibo/ui/helpers/RecyclerCursorAdapter$ChangeObserver;

    if-eqz v1, :cond_1

    iget-object v1, p0, Lcom/jibo/ui/helpers/RecyclerCursorAdapter;->f:Lcom/jibo/ui/helpers/RecyclerCursorAdapter$ChangeObserver;

    invoke-interface {v0, v1}, Landroid/database/Cursor;->unregisterContentObserver(Landroid/database/ContentObserver;)V

    .line 200
    :cond_1
    iget-object v1, p0, Lcom/jibo/ui/helpers/RecyclerCursorAdapter;->g:Landroid/database/DataSetObserver;

    if-eqz v1, :cond_2

    iget-object v1, p0, Lcom/jibo/ui/helpers/RecyclerCursorAdapter;->g:Landroid/database/DataSetObserver;

    invoke-interface {v0, v1}, Landroid/database/Cursor;->unregisterDataSetObserver(Landroid/database/DataSetObserver;)V

    .line 202
    :cond_2
    iput-object p1, p0, Lcom/jibo/ui/helpers/RecyclerCursorAdapter;->e:Landroid/database/Cursor;

    .line 203
    if-eqz p1, :cond_5

    .line 204
    iget-object v1, p0, Lcom/jibo/ui/helpers/RecyclerCursorAdapter;->f:Lcom/jibo/ui/helpers/RecyclerCursorAdapter$ChangeObserver;

    if-eqz v1, :cond_3

    iget-object v1, p0, Lcom/jibo/ui/helpers/RecyclerCursorAdapter;->f:Lcom/jibo/ui/helpers/RecyclerCursorAdapter$ChangeObserver;

    invoke-interface {p1, v1}, Landroid/database/Cursor;->registerContentObserver(Landroid/database/ContentObserver;)V

    .line 205
    :cond_3
    iget-object v1, p0, Lcom/jibo/ui/helpers/RecyclerCursorAdapter;->g:Landroid/database/DataSetObserver;

    if-eqz v1, :cond_4

    iget-object v1, p0, Lcom/jibo/ui/helpers/RecyclerCursorAdapter;->g:Landroid/database/DataSetObserver;

    invoke-interface {p1, v1}, Landroid/database/Cursor;->registerDataSetObserver(Landroid/database/DataSetObserver;)V

    .line 206
    :cond_4
    const-string v1, "_id"

    invoke-interface {p1, v1}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v1

    iput v1, p0, Lcom/jibo/ui/helpers/RecyclerCursorAdapter;->d:I

    .line 207
    const/4 v1, 0x1

    iput-boolean v1, p0, Lcom/jibo/ui/helpers/RecyclerCursorAdapter;->a:Z

    .line 209
    invoke-virtual {p0}, Lcom/jibo/ui/helpers/RecyclerCursorAdapter;->notifyDataSetChanged()V

    goto :goto_0

    .line 211
    :cond_5
    const/4 v1, -0x1

    iput v1, p0, Lcom/jibo/ui/helpers/RecyclerCursorAdapter;->d:I

    .line 212
    iput-boolean v2, p0, Lcom/jibo/ui/helpers/RecyclerCursorAdapter;->a:Z

    .line 215
    invoke-virtual {p0}, Lcom/jibo/ui/helpers/RecyclerCursorAdapter;->getItemCount()I

    move-result v1

    invoke-virtual {p0, v2, v1}, Lcom/jibo/ui/helpers/RecyclerCursorAdapter;->notifyItemRangeRemoved(II)V

    goto :goto_0
.end method

.method protected b()V
    .locals 0

    .prologue
    .line 228
    return-void
.end method

.method public c()Z
    .locals 1

    .prologue
    .line 231
    iget-boolean v0, p0, Lcom/jibo/ui/helpers/RecyclerCursorAdapter;->a:Z

    return v0
.end method

.method public getItemCount()I
    .locals 3

    .prologue
    const/4 v1, 0x0

    .line 133
    .line 134
    iget-boolean v0, p0, Lcom/jibo/ui/helpers/RecyclerCursorAdapter;->b:Z

    if-eqz v0, :cond_2

    .line 135
    const/4 v0, 0x1

    .line 137
    :goto_0
    iget-boolean v2, p0, Lcom/jibo/ui/helpers/RecyclerCursorAdapter;->c:Z

    if-eqz v2, :cond_0

    .line 138
    add-int/lit8 v0, v0, 0x1

    .line 140
    :cond_0
    iget-boolean v2, p0, Lcom/jibo/ui/helpers/RecyclerCursorAdapter;->a:Z

    if-eqz v2, :cond_1

    iget-object v2, p0, Lcom/jibo/ui/helpers/RecyclerCursorAdapter;->e:Landroid/database/Cursor;

    if-eqz v2, :cond_1

    .line 141
    iget-object v1, p0, Lcom/jibo/ui/helpers/RecyclerCursorAdapter;->e:Landroid/database/Cursor;

    invoke-interface {v1}, Landroid/database/Cursor;->getCount()I

    move-result v1

    add-int/2addr v1, v0

    .line 143
    :cond_1
    return v1

    :cond_2
    move v0, v1

    goto :goto_0
.end method

.method public getItemId(I)J
    .locals 3

    .prologue
    const-wide/16 v0, 0x0

    .line 152
    iget-boolean v2, p0, Lcom/jibo/ui/helpers/RecyclerCursorAdapter;->b:Z

    if-eqz v2, :cond_0

    .line 153
    add-int/lit8 p1, p1, -0x1

    .line 155
    :cond_0
    iget-boolean v2, p0, Lcom/jibo/ui/helpers/RecyclerCursorAdapter;->a:Z

    if-eqz v2, :cond_1

    iget-object v2, p0, Lcom/jibo/ui/helpers/RecyclerCursorAdapter;->e:Landroid/database/Cursor;

    if-eqz v2, :cond_1

    .line 156
    iget-object v2, p0, Lcom/jibo/ui/helpers/RecyclerCursorAdapter;->e:Landroid/database/Cursor;

    invoke-interface {v2, p1}, Landroid/database/Cursor;->moveToPosition(I)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 157
    iget-object v0, p0, Lcom/jibo/ui/helpers/RecyclerCursorAdapter;->e:Landroid/database/Cursor;

    iget v1, p0, Lcom/jibo/ui/helpers/RecyclerCursorAdapter;->d:I

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v0

    .line 162
    :cond_1
    return-wide v0
.end method

.method public onBindViewHolder(Landroid/support/v7/widget/RecyclerView$ViewHolder;I)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TVH;I)V"
        }
    .end annotation

    .prologue
    .line 96
    iget-object v0, p0, Lcom/jibo/ui/helpers/RecyclerCursorAdapter;->e:Landroid/database/Cursor;

    invoke-interface {v0}, Landroid/database/Cursor;->isClosed()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 118
    :cond_0
    :goto_0
    return-void

    .line 99
    :cond_1
    iget-boolean v0, p0, Lcom/jibo/ui/helpers/RecyclerCursorAdapter;->b:Z

    if-eqz v0, :cond_3

    .line 100
    if-nez p2, :cond_2

    .line 101
    iget-object v0, p0, Lcom/jibo/ui/helpers/RecyclerCursorAdapter;->e:Landroid/database/Cursor;

    invoke-virtual {p0, p1, v0}, Lcom/jibo/ui/helpers/RecyclerCursorAdapter;->a(Landroid/support/v7/widget/RecyclerView$ViewHolder;Landroid/database/Cursor;)V

    goto :goto_0

    .line 104
    :cond_2
    add-int/lit8 p2, p2, -0x1

    .line 107
    :cond_3
    iget-boolean v0, p0, Lcom/jibo/ui/helpers/RecyclerCursorAdapter;->a:Z

    if-nez v0, :cond_4

    .line 108
    invoke-virtual {p0}, Lcom/jibo/ui/helpers/RecyclerCursorAdapter;->getItemCount()I

    move-result v0

    if-nez v0, :cond_4

    .line 113
    :cond_4
    iget-object v0, p0, Lcom/jibo/ui/helpers/RecyclerCursorAdapter;->e:Landroid/database/Cursor;

    if-eqz v0, :cond_5

    invoke-virtual {p0}, Lcom/jibo/ui/helpers/RecyclerCursorAdapter;->getItemCount()I

    move-result v0

    if-lez v0, :cond_5

    iget-object v0, p0, Lcom/jibo/ui/helpers/RecyclerCursorAdapter;->e:Landroid/database/Cursor;

    invoke-interface {v0, p2}, Landroid/database/Cursor;->moveToPosition(I)Z

    move-result v0

    if-nez v0, :cond_5

    iget-boolean v0, p0, Lcom/jibo/ui/helpers/RecyclerCursorAdapter;->b:Z

    if-nez v0, :cond_5

    iget-boolean v0, p0, Lcom/jibo/ui/helpers/RecyclerCursorAdapter;->c:Z

    if-eqz v0, :cond_0

    .line 116
    :cond_5
    iget-object v0, p0, Lcom/jibo/ui/helpers/RecyclerCursorAdapter;->e:Landroid/database/Cursor;

    invoke-virtual {p0, p1, v0}, Lcom/jibo/ui/helpers/RecyclerCursorAdapter;->a(Landroid/support/v7/widget/RecyclerView$ViewHolder;Landroid/database/Cursor;)V

    goto :goto_0
.end method
