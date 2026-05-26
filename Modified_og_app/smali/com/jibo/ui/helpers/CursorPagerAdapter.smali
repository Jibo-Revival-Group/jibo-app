.class public abstract Lcom/jibo/ui/helpers/CursorPagerAdapter;
.super Landroid/support/v4/view/PagerAdapter;
.source "CursorPagerAdapter.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/jibo/ui/helpers/CursorPagerAdapter$MyDataSetObserver;,
        Lcom/jibo/ui/helpers/CursorPagerAdapter$ChangeObserver;
    }
.end annotation


# instance fields
.field private a:Z

.field private b:Landroid/database/Cursor;

.field private c:I

.field private d:Lcom/jibo/ui/helpers/CursorPagerAdapter$ChangeObserver;

.field private e:Landroid/database/DataSetObserver;


# direct methods
.method public constructor <init>(Landroid/database/Cursor;)V
    .locals 0

    .prologue
    .line 22
    invoke-direct {p0}, Landroid/support/v4/view/PagerAdapter;-><init>()V

    .line 23
    invoke-direct {p0, p1}, Lcom/jibo/ui/helpers/CursorPagerAdapter;->b(Landroid/database/Cursor;)V

    .line 24
    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/helpers/CursorPagerAdapter;Z)Z
    .locals 0

    .prologue
    .line 14
    iput-boolean p1, p0, Lcom/jibo/ui/helpers/CursorPagerAdapter;->a:Z

    return p1
.end method

.method private b(Landroid/database/Cursor;)V
    .locals 3

    .prologue
    .line 27
    if-eqz p1, :cond_2

    const/4 v0, 0x1

    .line 28
    :goto_0
    iput-object p1, p0, Lcom/jibo/ui/helpers/CursorPagerAdapter;->b:Landroid/database/Cursor;

    .line 29
    iput-boolean v0, p0, Lcom/jibo/ui/helpers/CursorPagerAdapter;->a:Z

    .line 30
    if-eqz v0, :cond_3

    const-string v1, "_id"

    invoke-interface {p1, v1}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v1

    :goto_1
    iput v1, p0, Lcom/jibo/ui/helpers/CursorPagerAdapter;->c:I

    .line 32
    new-instance v1, Lcom/jibo/ui/helpers/CursorPagerAdapter$ChangeObserver;

    invoke-direct {v1, p0}, Lcom/jibo/ui/helpers/CursorPagerAdapter$ChangeObserver;-><init>(Lcom/jibo/ui/helpers/CursorPagerAdapter;)V

    iput-object v1, p0, Lcom/jibo/ui/helpers/CursorPagerAdapter;->d:Lcom/jibo/ui/helpers/CursorPagerAdapter$ChangeObserver;

    .line 33
    new-instance v1, Lcom/jibo/ui/helpers/CursorPagerAdapter$MyDataSetObserver;

    const/4 v2, 0x0

    invoke-direct {v1, p0, v2}, Lcom/jibo/ui/helpers/CursorPagerAdapter$MyDataSetObserver;-><init>(Lcom/jibo/ui/helpers/CursorPagerAdapter;Lcom/jibo/ui/helpers/CursorPagerAdapter$1;)V

    iput-object v1, p0, Lcom/jibo/ui/helpers/CursorPagerAdapter;->e:Landroid/database/DataSetObserver;

    .line 35
    if-eqz v0, :cond_1

    .line 36
    iget-object v0, p0, Lcom/jibo/ui/helpers/CursorPagerAdapter;->d:Lcom/jibo/ui/helpers/CursorPagerAdapter$ChangeObserver;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/helpers/CursorPagerAdapter;->d:Lcom/jibo/ui/helpers/CursorPagerAdapter$ChangeObserver;

    invoke-interface {p1, v0}, Landroid/database/Cursor;->registerContentObserver(Landroid/database/ContentObserver;)V

    .line 37
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/helpers/CursorPagerAdapter;->e:Landroid/database/DataSetObserver;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/jibo/ui/helpers/CursorPagerAdapter;->e:Landroid/database/DataSetObserver;

    invoke-interface {p1, v0}, Landroid/database/Cursor;->registerDataSetObserver(Landroid/database/DataSetObserver;)V

    .line 39
    :cond_1
    return-void

    .line 27
    :cond_2
    const/4 v0, 0x0

    goto :goto_0

    .line 30
    :cond_3
    const/4 v1, -0x1

    goto :goto_1
.end method


# virtual methods
.method public a(Landroid/database/Cursor;)Landroid/database/Cursor;
    .locals 2

    .prologue
    .line 108
    iget-object v0, p0, Lcom/jibo/ui/helpers/CursorPagerAdapter;->b:Landroid/database/Cursor;

    if-ne p1, v0, :cond_0

    .line 109
    const/4 v0, 0x0

    .line 138
    :goto_0
    return-object v0

    .line 111
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/helpers/CursorPagerAdapter;->b:Landroid/database/Cursor;

    .line 112
    if-eqz v0, :cond_2

    .line 113
    iget-object v1, p0, Lcom/jibo/ui/helpers/CursorPagerAdapter;->d:Lcom/jibo/ui/helpers/CursorPagerAdapter$ChangeObserver;

    if-eqz v1, :cond_1

    .line 114
    iget-object v1, p0, Lcom/jibo/ui/helpers/CursorPagerAdapter;->d:Lcom/jibo/ui/helpers/CursorPagerAdapter$ChangeObserver;

    invoke-interface {v0, v1}, Landroid/database/Cursor;->unregisterContentObserver(Landroid/database/ContentObserver;)V

    .line 116
    :cond_1
    iget-object v1, p0, Lcom/jibo/ui/helpers/CursorPagerAdapter;->e:Landroid/database/DataSetObserver;

    if-eqz v1, :cond_2

    .line 117
    iget-object v1, p0, Lcom/jibo/ui/helpers/CursorPagerAdapter;->e:Landroid/database/DataSetObserver;

    invoke-interface {v0, v1}, Landroid/database/Cursor;->unregisterDataSetObserver(Landroid/database/DataSetObserver;)V

    .line 120
    :cond_2
    iput-object p1, p0, Lcom/jibo/ui/helpers/CursorPagerAdapter;->b:Landroid/database/Cursor;

    .line 121
    if-eqz p1, :cond_5

    invoke-interface {p1}, Landroid/database/Cursor;->isClosed()Z

    move-result v1

    if-nez v1, :cond_5

    .line 122
    iget-object v1, p0, Lcom/jibo/ui/helpers/CursorPagerAdapter;->d:Lcom/jibo/ui/helpers/CursorPagerAdapter$ChangeObserver;

    if-eqz v1, :cond_3

    .line 123
    iget-object v1, p0, Lcom/jibo/ui/helpers/CursorPagerAdapter;->d:Lcom/jibo/ui/helpers/CursorPagerAdapter$ChangeObserver;

    invoke-interface {p1, v1}, Landroid/database/Cursor;->registerContentObserver(Landroid/database/ContentObserver;)V

    .line 125
    :cond_3
    iget-object v1, p0, Lcom/jibo/ui/helpers/CursorPagerAdapter;->e:Landroid/database/DataSetObserver;

    if-eqz v1, :cond_4

    .line 126
    iget-object v1, p0, Lcom/jibo/ui/helpers/CursorPagerAdapter;->e:Landroid/database/DataSetObserver;

    invoke-interface {p1, v1}, Landroid/database/Cursor;->registerDataSetObserver(Landroid/database/DataSetObserver;)V

    .line 128
    :cond_4
    const-string v1, "_id"

    invoke-interface {p1, v1}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v1

    iput v1, p0, Lcom/jibo/ui/helpers/CursorPagerAdapter;->c:I

    .line 129
    const/4 v1, 0x1

    iput-boolean v1, p0, Lcom/jibo/ui/helpers/CursorPagerAdapter;->a:Z

    .line 131
    invoke-virtual {p0}, Lcom/jibo/ui/helpers/CursorPagerAdapter;->c()V

    goto :goto_0

    .line 133
    :cond_5
    const/4 v1, -0x1

    iput v1, p0, Lcom/jibo/ui/helpers/CursorPagerAdapter;->c:I

    .line 134
    const/4 v1, 0x0

    iput-boolean v1, p0, Lcom/jibo/ui/helpers/CursorPagerAdapter;->a:Z

    .line 136
    invoke-virtual {p0}, Lcom/jibo/ui/helpers/CursorPagerAdapter;->c()V

    goto :goto_0
.end method

.method public a(Landroid/view/View;I)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 78
    invoke-virtual {p0, p2}, Lcom/jibo/ui/helpers/CursorPagerAdapter;->b(I)V

    .line 80
    check-cast p1, Landroid/view/ViewGroup;

    iget-object v0, p0, Lcom/jibo/ui/helpers/CursorPagerAdapter;->b:Landroid/database/Cursor;

    invoke-virtual {p0, p1, v0, p2}, Lcom/jibo/ui/helpers/CursorPagerAdapter;->a(Landroid/view/ViewGroup;Landroid/database/Cursor;I)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public abstract a(Landroid/view/ViewGroup;Landroid/database/Cursor;I)Ljava/lang/Object;
.end method

.method public a(Landroid/view/View;ILjava/lang/Object;)V
    .locals 0

    .prologue
    .line 85
    return-void
.end method

.method public b()I
    .locals 1

    .prologue
    .line 54
    iget-boolean v0, p0, Lcom/jibo/ui/helpers/CursorPagerAdapter;->a:Z

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/helpers/CursorPagerAdapter;->b:Landroid/database/Cursor;

    if-eqz v0, :cond_0

    .line 55
    iget-object v0, p0, Lcom/jibo/ui/helpers/CursorPagerAdapter;->b:Landroid/database/Cursor;

    invoke-interface {v0}, Landroid/database/Cursor;->getCount()I

    move-result v0

    .line 57
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method protected b(I)V
    .locals 3

    .prologue
    .line 62
    iget-boolean v0, p0, Lcom/jibo/ui/helpers/CursorPagerAdapter;->a:Z

    if-nez v0, :cond_0

    .line 63
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "this should only be called when the cursor is valid"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 65
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/helpers/CursorPagerAdapter;->b:Landroid/database/Cursor;

    invoke-interface {v0, p1}, Landroid/database/Cursor;->moveToPosition(I)Z

    move-result v0

    if-nez v0, :cond_1

    .line 66
    new-instance v0, Ljava/lang/IllegalStateException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "couldn\'t move cursor to position "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 68
    :cond_1
    return-void
.end method

.method public d()Landroid/database/Cursor;
    .locals 1

    .prologue
    .line 47
    iget-object v0, p0, Lcom/jibo/ui/helpers/CursorPagerAdapter;->b:Landroid/database/Cursor;

    return-object v0
.end method

.method protected e()V
    .locals 1

    .prologue
    .line 149
    iget-object v0, p0, Lcom/jibo/ui/helpers/CursorPagerAdapter;->b:Landroid/database/Cursor;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/helpers/CursorPagerAdapter;->b:Landroid/database/Cursor;

    invoke-interface {v0}, Landroid/database/Cursor;->isClosed()Z

    move-result v0

    if-nez v0, :cond_0

    .line 150
    iget-object v0, p0, Lcom/jibo/ui/helpers/CursorPagerAdapter;->b:Landroid/database/Cursor;

    invoke-interface {v0}, Landroid/database/Cursor;->requery()Z

    move-result v0

    iput-boolean v0, p0, Lcom/jibo/ui/helpers/CursorPagerAdapter;->a:Z

    .line 152
    :cond_0
    return-void
.end method

.method public f()Z
    .locals 1

    .prologue
    .line 155
    iget-boolean v0, p0, Lcom/jibo/ui/helpers/CursorPagerAdapter;->a:Z

    return v0
.end method
