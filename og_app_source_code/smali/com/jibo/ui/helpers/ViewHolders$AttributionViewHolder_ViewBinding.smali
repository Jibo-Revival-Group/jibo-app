.class public Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder_ViewBinding;
.super Ljava/lang/Object;
.source "ViewHolders$AttributionViewHolder_ViewBinding.java"

# interfaces
.implements Lbutterknife/Unbinder;


# instance fields
.field private b:Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;


# direct methods
.method public constructor <init>(Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;Landroid/view/View;)V
    .locals 3

    .prologue
    .line 23
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 24
    iput-object p1, p0, Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder_ViewBinding;->b:Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;

    .line 26
    const v0, 0x7f09014c

    const-string v1, "field \'serviceIcon\'"

    const-class v2, Landroid/widget/ImageView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p1, Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;->serviceIcon:Landroid/widget/ImageView;

    .line 27
    const v0, 0x7f0902fb

    const-string v1, "field \'titleText\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;->titleText:Landroid/widget/TextView;

    .line 28
    const v0, 0x7f090320

    const-string v1, "field \'urlText\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;->urlText:Landroid/widget/TextView;

    .line 29
    const v0, 0x7f090101

    const-string v1, "field \'dateText\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;->dateText:Landroid/widget/TextView;

    .line 30
    const v0, 0x7f090154

    const-string v1, "field \'image\'"

    const-class v2, Landroid/widget/ImageView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p1, Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;->image:Landroid/widget/ImageView;

    .line 31
    const v0, 0x7f09015a

    const-string v1, "field \'imageDivider\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    iput-object v0, p1, Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;->imageDivider:Landroid/view/View;

    .line 32
    const v0, 0x7f090332

    const-string v1, "field \'wasItCorrectButton\'"

    const-class v2, Lcom/jibo/ui/view/proxima/CustomFontTextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/view/proxima/CustomFontTextView;

    iput-object v0, p1, Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;->wasItCorrectButton:Lcom/jibo/ui/view/proxima/CustomFontTextView;

    .line 33
    const v0, 0x7f09016b

    const-string v1, "field \'jiboImage\'"

    const-class v2, Landroid/widget/ImageView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p1, Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;->jiboImage:Landroid/widget/ImageView;

    .line 34
    const v0, 0x7f090046

    const-string v1, "field \'attributionRadioGroup\'"

    const-class v2, Landroid/widget/RadioGroup;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/RadioGroup;

    iput-object v0, p1, Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;->attributionRadioGroup:Landroid/widget/RadioGroup;

    .line 35
    const v0, 0x7f090136

    const-string v1, "field \'firstCard\'"

    const-class v2, Landroid/support/v7/widget/CardView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/support/v7/widget/CardView;

    iput-object v0, p1, Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;->firstCard:Landroid/support/v7/widget/CardView;

    .line 36
    const v0, 0x7f09004c

    const-string v1, "field \'backCard\'"

    const-class v2, Landroid/support/v7/widget/CardView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/support/v7/widget/CardView;

    iput-object v0, p1, Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;->backCard:Landroid/support/v7/widget/CardView;

    .line 37
    const v0, 0x7f0902c7

    const-string v1, "field \'submit\'"

    const-class v2, Lcom/jibo/ui/view/proxima/CustomFontTextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/view/proxima/CustomFontTextView;

    iput-object v0, p1, Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;->submit:Lcom/jibo/ui/view/proxima/CustomFontTextView;

    .line 38
    return-void
.end method


# virtual methods
.method public unbind()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 43
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder_ViewBinding;->b:Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;

    .line 44
    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Bindings already cleared."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 45
    :cond_0
    iput-object v1, p0, Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder_ViewBinding;->b:Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;

    .line 47
    iput-object v1, v0, Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;->serviceIcon:Landroid/widget/ImageView;

    .line 48
    iput-object v1, v0, Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;->titleText:Landroid/widget/TextView;

    .line 49
    iput-object v1, v0, Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;->urlText:Landroid/widget/TextView;

    .line 50
    iput-object v1, v0, Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;->dateText:Landroid/widget/TextView;

    .line 51
    iput-object v1, v0, Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;->image:Landroid/widget/ImageView;

    .line 52
    iput-object v1, v0, Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;->imageDivider:Landroid/view/View;

    .line 53
    iput-object v1, v0, Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;->wasItCorrectButton:Lcom/jibo/ui/view/proxima/CustomFontTextView;

    .line 54
    iput-object v1, v0, Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;->jiboImage:Landroid/widget/ImageView;

    .line 55
    iput-object v1, v0, Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;->attributionRadioGroup:Landroid/widget/RadioGroup;

    .line 56
    iput-object v1, v0, Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;->firstCard:Landroid/support/v7/widget/CardView;

    .line 57
    iput-object v1, v0, Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;->backCard:Landroid/support/v7/widget/CardView;

    .line 58
    iput-object v1, v0, Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;->submit:Lcom/jibo/ui/view/proxima/CustomFontTextView;

    .line 59
    return-void
.end method
