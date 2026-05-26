.class Lcom/salesforce/android/cases/ui/internal/features/casefeed/adapter/ReceivedMessageViewHolder;
.super Landroid/support/v7/widget/RecyclerView$ViewHolder;
.source "ReceivedMessageViewHolder.java"

# interfaces
.implements Lcom/salesforce/android/service/common/ui/internal/messaging/GroupableView;


# instance fields
.field private a:Landroid/widget/TextView;

.field private b:Landroid/widget/TextView;

.field private c:Landroid/widget/TextView;

.field private d:Landroid/view/View;

.field private e:Landroid/view/View;


# direct methods
.method constructor <init>(Landroid/view/View;)V
    .locals 1

    .prologue
    .line 44
    invoke-direct {p0, p1}, Landroid/support/v7/widget/RecyclerView$ViewHolder;-><init>(Landroid/view/View;)V

    .line 45
    sget v0, Lcom/salesforce/android/cases/R$id;->salesforce_received_message_text:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/adapter/ReceivedMessageViewHolder;->a:Landroid/widget/TextView;

    .line 46
    sget v0, Lcom/salesforce/android/cases/R$id;->salesforce_received_message_agent_name:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/adapter/ReceivedMessageViewHolder;->b:Landroid/widget/TextView;

    .line 47
    sget v0, Lcom/salesforce/android/cases/R$id;->salesforce_received_message_timestamp:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/adapter/ReceivedMessageViewHolder;->c:Landroid/widget/TextView;

    .line 48
    sget v0, Lcom/salesforce/android/cases/R$id;->salesforce_agent_avatar_container:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/adapter/ReceivedMessageViewHolder;->d:Landroid/view/View;

    .line 49
    sget v0, Lcom/salesforce/android/cases/R$id;->salesforce_received_message_footer:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/adapter/ReceivedMessageViewHolder;->e:Landroid/view/View;

    .line 50
    return-void
.end method


# virtual methods
.method public a()V
    .locals 2

    .prologue
    .line 62
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/adapter/ReceivedMessageViewHolder;->e:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 63
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/adapter/ReceivedMessageViewHolder;->d:Landroid/view/View;

    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 64
    return-void
.end method

.method public a(Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/ReceivedMessageModel;)V
    .locals 3

    .prologue
    .line 53
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/adapter/ReceivedMessageViewHolder;->a:Landroid/widget/TextView;

    invoke-virtual {p1}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/ReceivedMessageModel;->a()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 54
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/adapter/ReceivedMessageViewHolder;->b:Landroid/widget/TextView;

    invoke-virtual {p1}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/ReceivedMessageModel;->b()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 55
    invoke-virtual {p1}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/ReceivedMessageModel;->d()Ljava/util/Date;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 56
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/adapter/ReceivedMessageViewHolder;->c:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/adapter/ReceivedMessageViewHolder;->itemView:Landroid/view/View;

    .line 57
    invoke-virtual {v1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-static {v1}, Landroid/text/format/DateFormat;->getTimeFormat(Landroid/content/Context;)Ljava/text/DateFormat;

    move-result-object v1

    invoke-virtual {p1}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/ReceivedMessageModel;->d()Ljava/util/Date;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/text/DateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v1

    .line 56
    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 59
    :cond_0
    return-void
.end method

.method public b()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 67
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/adapter/ReceivedMessageViewHolder;->e:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 68
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/adapter/ReceivedMessageViewHolder;->d:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 69
    return-void
.end method
