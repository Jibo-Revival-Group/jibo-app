.class public Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment$JiboPreparationsStartFragment;
.super Landroid/support/v4/app/Fragment;
.source "JiboPreparationsFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "JiboPreparationsStartFragment"
.end annotation


# instance fields
.field private final a:[I

.field title:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 204
    invoke-direct {p0}, Landroid/support/v4/app/Fragment;-><init>()V

    .line 199
    const/4 v0, 0x3

    new-array v0, v0, [I

    fill-array-data v0, :array_0

    iput-object v0, p0, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment$JiboPreparationsStartFragment;->a:[I

    .line 205
    return-void

    .line 199
    :array_0
    .array-data 4
        0x7f0900c8
        0x7f0900c9
        0x7f0900ca
    .end array-data
.end method


# virtual methods
.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .prologue
    .line 210
    const v0, 0x7f0b00fc

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 9

    .prologue
    const/4 v0, 0x0

    .line 215
    invoke-super {p0, p1, p2}, Landroid/support/v4/app/Fragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V

    .line 216
    invoke-static {p0, p1}, Lbutterknife/ButterKnife;->a(Ljava/lang/Object;Landroid/view/View;)Lbutterknife/Unbinder;

    .line 218
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment$JiboPreparationsStartFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;

    move-result-object v1

    iget v2, v1, Landroid/content/res/Configuration;->fontScale:F

    .line 219
    iget-object v1, p0, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment$JiboPreparationsStartFragment;->title:Landroid/widget/TextView;

    iget-object v3, p0, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment$JiboPreparationsStartFragment;->title:Landroid/widget/TextView;

    invoke-virtual {v3}, Landroid/widget/TextView;->getTextSize()F

    move-result v3

    div-float/2addr v3, v2

    invoke-virtual {v1, v0, v3}, Landroid/widget/TextView;->setTextSize(IF)V

    .line 221
    iget-object v3, p0, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment$JiboPreparationsStartFragment;->a:[I

    array-length v4, v3

    move v1, v0

    :goto_0
    if-ge v1, v4, :cond_0

    aget v0, v3, v1

    .line 222
    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    .line 223
    invoke-virtual {v0}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout$LayoutParams;

    .line 224
    iget v5, v0, Landroid/widget/LinearLayout$LayoutParams;->topMargin:I

    .line 225
    iget v6, v0, Landroid/widget/LinearLayout$LayoutParams;->leftMargin:I

    int-to-float v5, v5

    mul-float v7, v2, v2

    div-float/2addr v5, v7

    float-to-int v5, v5

    iget v7, v0, Landroid/widget/LinearLayout$LayoutParams;->rightMargin:I

    iget v8, v0, Landroid/widget/LinearLayout$LayoutParams;->bottomMargin:I

    invoke-virtual {v0, v6, v5, v7, v8}, Landroid/widget/LinearLayout$LayoutParams;->setMargins(IIII)V

    .line 221
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_0

    .line 229
    :cond_0
    return-void
.end method
