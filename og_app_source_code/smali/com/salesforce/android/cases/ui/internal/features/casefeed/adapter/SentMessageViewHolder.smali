.class Lcom/salesforce/android/cases/ui/internal/features/casefeed/adapter/SentMessageViewHolder;
.super Landroid/support/v7/widget/RecyclerView$ViewHolder;
.source "SentMessageViewHolder.java"

# interfaces
.implements Lcom/salesforce/android/service/common/ui/internal/messaging/GroupableView;


# instance fields
.field private a:Landroid/widget/TextView;

.field private b:Landroid/widget/TextView;


# direct methods
.method constructor <init>(Landroid/view/View;)V
    .locals 1

    .prologue
    .line 41
    invoke-direct {p0, p1}, Landroid/support/v7/widget/RecyclerView$ViewHolder;-><init>(Landroid/view/View;)V

    .line 42
    sget v0, Lcom/salesforce/android/cases/R$id;->salesforce_sent_message_text:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/adapter/SentMessageViewHolder;->a:Landroid/widget/TextView;

    .line 43
    sget v0, Lcom/salesforce/android/cases/R$id;->salesforce_sent_message_timestamp:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/adapter/SentMessageViewHolder;->b:Landroid/widget/TextView;

    .line 44
    return-void
.end method


# virtual methods
.method public a()V
    .locals 2

    .prologue
    .line 55
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/adapter/SentMessageViewHolder;->b:Landroid/widget/TextView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 56
    return-void
.end method

.method public a(Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/SentMessageModel;)V
    .locals 3

    .prologue
    .line 47
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/adapter/SentMessageViewHolder;->a:Landroid/widget/TextView;

    invoke-virtual {p1}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/SentMessageModel;->a()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 48
    invoke-virtual {p1}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/SentMessageModel;->d()Ljava/util/Date;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 49
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/adapter/SentMessageViewHolder;->b:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/adapter/SentMessageViewHolder;->itemView:Landroid/view/View;

    .line 50
    invoke-virtual {v1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-static {v1}, Landroid/text/format/DateFormat;->getTimeFormat(Landroid/content/Context;)Ljava/text/DateFormat;

    move-result-object v1

    invoke-virtual {p1}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/SentMessageModel;->d()Ljava/util/Date;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/text/DateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v1

    .line 49
    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 52
    :cond_0
    return-void
.end method

.method public b()V
    .locals 2

    .prologue
    .line 59
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/adapter/SentMessageViewHolder;->b:Landroid/widget/TextView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 60
    return-void
.end method
