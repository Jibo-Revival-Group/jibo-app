.class Lcom/jibo/ui/helpers/RecyclerCursorAdapter$MyDataSetObserver;
.super Landroid/database/DataSetObserver;
.source "RecyclerCursorAdapter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/helpers/RecyclerCursorAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "MyDataSetObserver"
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/helpers/RecyclerCursorAdapter;


# direct methods
.method private constructor <init>(Lcom/jibo/ui/helpers/RecyclerCursorAdapter;)V
    .locals 0

    .prologue
    .line 250
    iput-object p1, p0, Lcom/jibo/ui/helpers/RecyclerCursorAdapter$MyDataSetObserver;->a:Lcom/jibo/ui/helpers/RecyclerCursorAdapter;

    invoke-direct {p0}, Landroid/database/DataSetObserver;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/jibo/ui/helpers/RecyclerCursorAdapter;Lcom/jibo/ui/helpers/RecyclerCursorAdapter$1;)V
    .locals 0

    .prologue
    .line 250
    invoke-direct {p0, p1}, Lcom/jibo/ui/helpers/RecyclerCursorAdapter$MyDataSetObserver;-><init>(Lcom/jibo/ui/helpers/RecyclerCursorAdapter;)V

    return-void
.end method


# virtual methods
.method public onChanged()V
    .locals 2

    .prologue
    .line 253
    iget-object v0, p0, Lcom/jibo/ui/helpers/RecyclerCursorAdapter$MyDataSetObserver;->a:Lcom/jibo/ui/helpers/RecyclerCursorAdapter;

    const/4 v1, 0x1

    invoke-static {v0, v1}, Lcom/jibo/ui/helpers/RecyclerCursorAdapter;->a(Lcom/jibo/ui/helpers/RecyclerCursorAdapter;Z)Z

    .line 254
    iget-object v0, p0, Lcom/jibo/ui/helpers/RecyclerCursorAdapter$MyDataSetObserver;->a:Lcom/jibo/ui/helpers/RecyclerCursorAdapter;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/RecyclerCursorAdapter;->notifyDataSetChanged()V

    .line 255
    return-void
.end method

.method public onInvalidated()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 259
    iget-object v0, p0, Lcom/jibo/ui/helpers/RecyclerCursorAdapter$MyDataSetObserver;->a:Lcom/jibo/ui/helpers/RecyclerCursorAdapter;

    invoke-static {v0, v2}, Lcom/jibo/ui/helpers/RecyclerCursorAdapter;->a(Lcom/jibo/ui/helpers/RecyclerCursorAdapter;Z)Z

    .line 261
    iget-object v0, p0, Lcom/jibo/ui/helpers/RecyclerCursorAdapter$MyDataSetObserver;->a:Lcom/jibo/ui/helpers/RecyclerCursorAdapter;

    iget-object v1, p0, Lcom/jibo/ui/helpers/RecyclerCursorAdapter$MyDataSetObserver;->a:Lcom/jibo/ui/helpers/RecyclerCursorAdapter;

    invoke-virtual {v1}, Lcom/jibo/ui/helpers/RecyclerCursorAdapter;->getItemCount()I

    move-result v1

    invoke-virtual {v0, v2, v1}, Lcom/jibo/ui/helpers/RecyclerCursorAdapter;->notifyItemRangeRemoved(II)V

    .line 262
    return-void
.end method
