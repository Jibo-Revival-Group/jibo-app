.class public Lcom/jibo/ui/fragment/dialog/OptionsBottomSheetDialog;
.super Landroid/support/design/widget/BottomSheetDialog;
.source "OptionsBottomSheetDialog.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/jibo/ui/fragment/dialog/OptionsBottomSheetDialog$BottomSheetAdapter;
    }
.end annotation


# instance fields
.field private b:Ljava/lang/String;

.field private c:[I

.field private d:[Ljava/lang/String;

.field private e:Landroid/content/DialogInterface$OnClickListener;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 0

    .prologue
    .line 41
    invoke-direct {p0, p1}, Landroid/support/design/widget/BottomSheetDialog;-><init>(Landroid/content/Context;)V

    .line 42
    return-void
.end method

.method private a(Landroid/content/DialogInterface;I)V
    .locals 1

    .prologue
    .line 49
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/OptionsBottomSheetDialog;->e:Landroid/content/DialogInterface$OnClickListener;

    if-eqz v0, :cond_0

    .line 50
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/OptionsBottomSheetDialog;->e:Landroid/content/DialogInterface$OnClickListener;

    invoke-interface {v0, p1, p2}, Landroid/content/DialogInterface$OnClickListener;->onClick(Landroid/content/DialogInterface;I)V

    .line 52
    :cond_0
    return-void
.end method

.method private a(Landroid/view/View;)V
    .locals 2

    .prologue
    const v1, 0x7f09030d

    .line 55
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/OptionsBottomSheetDialog;->b:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 56
    invoke-virtual {p1, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iget-object v1, p0, Lcom/jibo/ui/fragment/dialog/OptionsBottomSheetDialog;->b:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 60
    :goto_0
    return-void

    .line 58
    :cond_0
    invoke-virtual {p1, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    goto :goto_0
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/dialog/OptionsBottomSheetDialog;Landroid/content/DialogInterface;I)V
    .locals 0

    .prologue
    .line 28
    invoke-direct {p0, p1, p2}, Lcom/jibo/ui/fragment/dialog/OptionsBottomSheetDialog;->a(Landroid/content/DialogInterface;I)V

    return-void
.end method

.method private b(Landroid/view/View;)V
    .locals 7

    .prologue
    .line 65
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 66
    const/4 v0, 0x0

    :goto_0
    iget-object v2, p0, Lcom/jibo/ui/fragment/dialog/OptionsBottomSheetDialog;->c:[I

    array-length v2, v2

    if-ge v0, v2, :cond_0

    .line 68
    new-instance v2, Lcom/jibo/ui/helpers/Items$IconTextItem;

    sget-object v3, Lcom/jibo/ui/helpers/Items$ItemType;->dialog_bottom_sheet_item:Lcom/jibo/ui/helpers/Items$ItemType;

    new-instance v4, Lcom/jibo/ui/fragment/dialog/OptionsBottomSheetDialog$1;

    invoke-direct {v4, p0, v0}, Lcom/jibo/ui/fragment/dialog/OptionsBottomSheetDialog$1;-><init>(Lcom/jibo/ui/fragment/dialog/OptionsBottomSheetDialog;I)V

    iget-object v5, p0, Lcom/jibo/ui/fragment/dialog/OptionsBottomSheetDialog;->c:[I

    aget v5, v5, v0

    iget-object v6, p0, Lcom/jibo/ui/fragment/dialog/OptionsBottomSheetDialog;->d:[Ljava/lang/String;

    aget-object v6, v6, v0

    invoke-direct {v2, v3, v4, v5, v6}, Lcom/jibo/ui/helpers/Items$IconTextItem;-><init>(Lcom/jibo/ui/helpers/Items$ItemType;Landroid/view/View$OnClickListener;ILjava/lang/CharSequence;)V

    invoke-interface {v1, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 66
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 81
    :cond_0
    new-instance v2, Lcom/jibo/ui/fragment/dialog/OptionsBottomSheetDialog$BottomSheetAdapter;

    invoke-direct {v2}, Lcom/jibo/ui/fragment/dialog/OptionsBottomSheetDialog$BottomSheetAdapter;-><init>()V

    .line 82
    invoke-virtual {v2, v1}, Lcom/jibo/ui/fragment/dialog/OptionsBottomSheetDialog$BottomSheetAdapter;->a(Ljava/util/List;)V

    .line 85
    const v0, 0x7f090242

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/support/v7/widget/RecyclerView;

    .line 86
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/RecyclerView;->setHasFixedSize(Z)V

    .line 87
    new-instance v1, Landroid/support/v7/widget/DefaultItemAnimator;

    invoke-direct {v1}, Landroid/support/v7/widget/DefaultItemAnimator;-><init>()V

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/RecyclerView;->setItemAnimator(Landroid/support/v7/widget/RecyclerView$ItemAnimator;)V

    .line 88
    new-instance v1, Landroid/support/v7/widget/LinearLayoutManager;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/OptionsBottomSheetDialog;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-direct {v1, v3}, Landroid/support/v7/widget/LinearLayoutManager;-><init>(Landroid/content/Context;)V

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/RecyclerView;->setLayoutManager(Landroid/support/v7/widget/RecyclerView$LayoutManager;)V

    .line 89
    invoke-virtual {v0, v2}, Landroid/support/v7/widget/RecyclerView;->setAdapter(Landroid/support/v7/widget/RecyclerView$Adapter;)V

    .line 90
    return-void
.end method


# virtual methods
.method public a(Landroid/content/DialogInterface$OnClickListener;)V
    .locals 0

    .prologue
    .line 109
    iput-object p1, p0, Lcom/jibo/ui/fragment/dialog/OptionsBottomSheetDialog;->e:Landroid/content/DialogInterface$OnClickListener;

    .line 110
    return-void
.end method

.method public a(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 97
    iput-object p1, p0, Lcom/jibo/ui/fragment/dialog/OptionsBottomSheetDialog;->b:Ljava/lang/String;

    .line 98
    return-void
.end method

.method public a([I)V
    .locals 0

    .prologue
    .line 101
    iput-object p1, p0, Lcom/jibo/ui/fragment/dialog/OptionsBottomSheetDialog;->c:[I

    .line 102
    return-void
.end method

.method public a([Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 105
    iput-object p1, p0, Lcom/jibo/ui/fragment/dialog/OptionsBottomSheetDialog;->d:[Ljava/lang/String;

    .line 106
    return-void
.end method

.method public c()V
    .locals 3

    .prologue
    .line 114
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/OptionsBottomSheetDialog;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    const v1, 0x7f0b0048

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/support/constraint/ConstraintLayout;

    .line 116
    invoke-direct {p0, v0}, Lcom/jibo/ui/fragment/dialog/OptionsBottomSheetDialog;->a(Landroid/view/View;)V

    .line 117
    invoke-direct {p0, v0}, Lcom/jibo/ui/fragment/dialog/OptionsBottomSheetDialog;->b(Landroid/view/View;)V

    .line 119
    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/dialog/OptionsBottomSheetDialog;->setContentView(Landroid/view/View;)V

    .line 121
    return-void
.end method
