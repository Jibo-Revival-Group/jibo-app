.class Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListAdapter$ViewHolder;
.super Landroid/support/v7/widget/RecyclerView$ViewHolder;
.source "CaseListAdapter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "ViewHolder"
.end annotation


# instance fields
.field a:Landroid/widget/TextView;

.field b:Landroid/widget/TextView;

.field c:Landroid/widget/TextView;

.field d:Landroid/widget/ImageView;

.field final synthetic e:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListAdapter;


# direct methods
.method constructor <init>(Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListAdapter;Landroid/view/View;)V
    .locals 1

    .prologue
    .line 121
    iput-object p1, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListAdapter$ViewHolder;->e:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListAdapter;

    .line 122
    invoke-direct {p0, p2}, Landroid/support/v7/widget/RecyclerView$ViewHolder;-><init>(Landroid/view/View;)V

    .line 123
    sget v0, Lcom/salesforce/android/cases/R$id;->case_time:I

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListAdapter$ViewHolder;->a:Landroid/widget/TextView;

    .line 124
    sget v0, Lcom/salesforce/android/cases/R$id;->case_subject:I

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListAdapter$ViewHolder;->b:Landroid/widget/TextView;

    .line 125
    sget v0, Lcom/salesforce/android/cases/R$id;->case_message:I

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListAdapter$ViewHolder;->c:Landroid/widget/TextView;

    .line 126
    sget v0, Lcom/salesforce/android/cases/R$id;->unread_indicator:I

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListAdapter$ViewHolder;->d:Landroid/widget/ImageView;

    .line 127
    return-void
.end method


# virtual methods
.method a(Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;)V
    .locals 3

    .prologue
    const/4 v0, 0x0

    .line 130
    iget-object v1, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListAdapter$ViewHolder;->a:Landroid/widget/TextView;

    invoke-virtual {p1}, Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;->d()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 131
    iget-object v1, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListAdapter$ViewHolder;->b:Landroid/widget/TextView;

    invoke-virtual {p1}, Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;->e()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 132
    invoke-virtual {p1}, Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;->f()Ljava/lang/String;

    move-result-object v1

    .line 133
    invoke-static {v1}, Lcom/salesforce/android/cases/core/internal/util/StringUtils;->b(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 134
    iget-object v1, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListAdapter$ViewHolder;->c:Landroid/widget/TextView;

    invoke-virtual {p1}, Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;->f()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/salesforce/android/cases/core/internal/util/StringUtils;->d(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 135
    iget-object v1, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListAdapter$ViewHolder;->c:Landroid/widget/TextView;

    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setVisibility(I)V

    .line 139
    :goto_0
    iget-object v1, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListAdapter$ViewHolder;->d:Landroid/widget/ImageView;

    invoke-virtual {p1}, Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;->b()Z

    move-result v2

    if-eqz v2, :cond_1

    :goto_1
    invoke-virtual {v1, v0}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 140
    return-void

    .line 137
    :cond_0
    iget-object v1, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListAdapter$ViewHolder;->c:Landroid/widget/TextView;

    const/16 v2, 0x8

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_0

    .line 139
    :cond_1
    const/4 v0, 0x4

    goto :goto_1
.end method
