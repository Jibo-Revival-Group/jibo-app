.class public Lcom/jibo/ui/view/LoopSelectionListView;
.super Landroid/widget/ListView;
.source "LoopSelectionListView.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/jibo/ui/view/LoopSelectionListView$OnLoopSelectedListener;,
        Lcom/jibo/ui/view/LoopSelectionListView$MessagesLoopViewHolder;
    }
.end annotation


# instance fields
.field private a:Landroid/widget/ListAdapter;

.field private b:Lcom/jibo/ui/view/LoopSelectionListView$OnLoopSelectedListener;

.field private c:Landroid/widget/AdapterView$OnItemClickListener;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1

    .prologue
    .line 48
    invoke-direct {p0, p1}, Landroid/widget/ListView;-><init>(Landroid/content/Context;)V

    .line 192
    new-instance v0, Lcom/jibo/ui/view/LoopSelectionListView$1;

    invoke-direct {v0, p0}, Lcom/jibo/ui/view/LoopSelectionListView$1;-><init>(Lcom/jibo/ui/view/LoopSelectionListView;)V

    iput-object v0, p0, Lcom/jibo/ui/view/LoopSelectionListView;->c:Landroid/widget/AdapterView$OnItemClickListener;

    .line 49
    invoke-direct {p0}, Lcom/jibo/ui/view/LoopSelectionListView;->a()V

    .line 50
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1

    .prologue
    .line 53
    invoke-direct {p0, p1, p2}, Landroid/widget/ListView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 192
    new-instance v0, Lcom/jibo/ui/view/LoopSelectionListView$1;

    invoke-direct {v0, p0}, Lcom/jibo/ui/view/LoopSelectionListView$1;-><init>(Lcom/jibo/ui/view/LoopSelectionListView;)V

    iput-object v0, p0, Lcom/jibo/ui/view/LoopSelectionListView;->c:Landroid/widget/AdapterView$OnItemClickListener;

    .line 54
    invoke-direct {p0}, Lcom/jibo/ui/view/LoopSelectionListView;->a()V

    .line 55
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 1

    .prologue
    .line 58
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/ListView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 192
    new-instance v0, Lcom/jibo/ui/view/LoopSelectionListView$1;

    invoke-direct {v0, p0}, Lcom/jibo/ui/view/LoopSelectionListView$1;-><init>(Lcom/jibo/ui/view/LoopSelectionListView;)V

    iput-object v0, p0, Lcom/jibo/ui/view/LoopSelectionListView;->c:Landroid/widget/AdapterView$OnItemClickListener;

    .line 59
    invoke-direct {p0}, Lcom/jibo/ui/view/LoopSelectionListView;->a()V

    .line 60
    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/view/LoopSelectionListView;)Landroid/widget/ListAdapter;
    .locals 1

    .prologue
    .line 41
    iget-object v0, p0, Lcom/jibo/ui/view/LoopSelectionListView;->a:Landroid/widget/ListAdapter;

    return-object v0
.end method

.method private a()V
    .locals 1

    .prologue
    .line 63
    iget-object v0, p0, Lcom/jibo/ui/view/LoopSelectionListView;->c:Landroid/widget/AdapterView$OnItemClickListener;

    invoke-virtual {p0, v0}, Lcom/jibo/ui/view/LoopSelectionListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 64
    return-void
.end method

.method static synthetic b(Lcom/jibo/ui/view/LoopSelectionListView;)Lcom/jibo/ui/view/LoopSelectionListView$OnLoopSelectedListener;
    .locals 1

    .prologue
    .line 41
    iget-object v0, p0, Lcom/jibo/ui/view/LoopSelectionListView;->b:Lcom/jibo/ui/view/LoopSelectionListView$OnLoopSelectedListener;

    return-object v0
.end method


# virtual methods
.method public bridge synthetic setAdapter(Landroid/widget/Adapter;)V
    .locals 0

    .prologue
    .line 41
    check-cast p1, Landroid/widget/ListAdapter;

    invoke-virtual {p0, p1}, Lcom/jibo/ui/view/LoopSelectionListView;->setAdapter(Landroid/widget/ListAdapter;)V

    return-void
.end method

.method public setAdapter(Landroid/widget/ListAdapter;)V
    .locals 0

    .prologue
    .line 68
    invoke-super {p0, p1}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 69
    iput-object p1, p0, Lcom/jibo/ui/view/LoopSelectionListView;->a:Landroid/widget/ListAdapter;

    .line 70
    return-void
.end method

.method public setOnLoopSelectedListener(Lcom/jibo/ui/view/LoopSelectionListView$OnLoopSelectedListener;)V
    .locals 0

    .prologue
    .line 203
    iput-object p1, p0, Lcom/jibo/ui/view/LoopSelectionListView;->b:Lcom/jibo/ui/view/LoopSelectionListView$OnLoopSelectedListener;

    .line 204
    return-void
.end method
