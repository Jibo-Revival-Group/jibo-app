.class Lcom/salesforce/android/cases/ui/internal/features/casefeed/adapter/HorizontalRuleViewHolder;
.super Landroid/support/v7/widget/RecyclerView$ViewHolder;
.source "HorizontalRuleViewHolder.java"


# instance fields
.field private a:Landroid/widget/TextView;


# direct methods
.method constructor <init>(Landroid/view/View;)V
    .locals 1

    .prologue
    .line 38
    invoke-direct {p0, p1}, Landroid/support/v7/widget/RecyclerView$ViewHolder;-><init>(Landroid/view/View;)V

    .line 39
    sget v0, Lcom/salesforce/android/cases/R$id;->salesforce_horizontal_rule_text:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/adapter/HorizontalRuleViewHolder;->a:Landroid/widget/TextView;

    .line 40
    return-void
.end method


# virtual methods
.method public a(Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/HorizontalRuleModel;)V
    .locals 2

    .prologue
    .line 43
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/adapter/HorizontalRuleViewHolder;->a:Landroid/widget/TextView;

    invoke-virtual {p1}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/HorizontalRuleModel;->a()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 44
    return-void
.end method
