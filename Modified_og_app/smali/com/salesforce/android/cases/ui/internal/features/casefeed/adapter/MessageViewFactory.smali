.class public Lcom/salesforce/android/cases/ui/internal/features/casefeed/adapter/MessageViewFactory;
.super Ljava/lang/Object;
.source "MessageViewFactory.java"

# interfaces
.implements Lcom/salesforce/android/service/common/ui/internal/messaging/ViewHolderFactory;


# instance fields
.field private final a:I

.field private final b:I

.field private final c:I


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 37
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 39
    const/4 v0, 0x1

    iput v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/adapter/MessageViewFactory;->a:I

    .line 40
    const/4 v0, 0x2

    iput v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/adapter/MessageViewFactory;->b:I

    .line 41
    const/4 v0, 0x3

    iput v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/adapter/MessageViewFactory;->c:I

    return-void
.end method


# virtual methods
.method public a(Ljava/lang/Object;)I
    .locals 3

    .prologue
    .line 44
    instance-of v0, p1, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/ReceivedMessageModel;

    if-eqz v0, :cond_0

    .line 45
    const/4 v0, 0x1

    .line 49
    :goto_0
    return v0

    .line 46
    :cond_0
    instance-of v0, p1, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/SentMessageModel;

    if-eqz v0, :cond_1

    .line 47
    const/4 v0, 0x2

    goto :goto_0

    .line 48
    :cond_1
    instance-of v0, p1, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/HorizontalRuleModel;

    if-eqz v0, :cond_2

    .line 49
    const/4 v0, 0x3

    goto :goto_0

    .line 52
    :cond_2
    new-instance v0, Ljava/lang/IllegalStateException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Unknown message item type: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getCanonicalName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public a(Landroid/view/ViewGroup;ILandroid/view/LayoutInflater;)Landroid/support/v7/widget/RecyclerView$ViewHolder;
    .locals 3

    .prologue
    const/4 v1, 0x0

    .line 58
    const/4 v0, 0x1

    if-ne p2, v0, :cond_0

    .line 59
    sget v0, Lcom/salesforce/android/cases/R$layout;->salesforce_message_received:I

    invoke-virtual {p3, v0, p1, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    .line 60
    new-instance v0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/adapter/ReceivedMessageViewHolder;

    invoke-direct {v0, v1}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/adapter/ReceivedMessageViewHolder;-><init>(Landroid/view/View;)V

    .line 66
    :goto_0
    return-object v0

    .line 61
    :cond_0
    const/4 v0, 0x2

    if-ne p2, v0, :cond_1

    .line 62
    sget v0, Lcom/salesforce/android/cases/R$layout;->salesforce_message_sent:I

    invoke-virtual {p3, v0, p1, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    .line 63
    new-instance v0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/adapter/SentMessageViewHolder;

    invoke-direct {v0, v1}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/adapter/SentMessageViewHolder;-><init>(Landroid/view/View;)V

    goto :goto_0

    .line 64
    :cond_1
    const/4 v0, 0x3

    if-ne p2, v0, :cond_2

    .line 65
    sget v0, Lcom/salesforce/android/cases/R$layout;->salesforce_message_horizontal_rule:I

    invoke-virtual {p3, v0, p1, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    .line 66
    new-instance v0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/adapter/HorizontalRuleViewHolder;

    invoke-direct {v0, v1}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/adapter/HorizontalRuleViewHolder;-><init>(Landroid/view/View;)V

    goto :goto_0

    .line 69
    :cond_2
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Unknown viewType: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public a(Landroid/support/v7/widget/RecyclerView$ViewHolder;ILjava/lang/Object;)V
    .locals 1

    .prologue
    .line 74
    const/4 v0, 0x1

    if-ne p2, v0, :cond_1

    .line 75
    check-cast p3, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/ReceivedMessageModel;

    .line 76
    check-cast p1, Lcom/salesforce/android/cases/ui/internal/features/casefeed/adapter/ReceivedMessageViewHolder;

    .line 77
    invoke-virtual {p1, p3}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/adapter/ReceivedMessageViewHolder;->a(Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/ReceivedMessageModel;)V

    .line 87
    :cond_0
    :goto_0
    return-void

    .line 78
    :cond_1
    const/4 v0, 0x2

    if-ne p2, v0, :cond_2

    .line 79
    check-cast p3, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/SentMessageModel;

    .line 80
    check-cast p1, Lcom/salesforce/android/cases/ui/internal/features/casefeed/adapter/SentMessageViewHolder;

    .line 81
    invoke-virtual {p1, p3}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/adapter/SentMessageViewHolder;->a(Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/SentMessageModel;)V

    goto :goto_0

    .line 82
    :cond_2
    const/4 v0, 0x3

    if-ne p2, v0, :cond_0

    .line 83
    check-cast p3, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/HorizontalRuleModel;

    .line 84
    check-cast p1, Lcom/salesforce/android/cases/ui/internal/features/casefeed/adapter/HorizontalRuleViewHolder;

    .line 85
    invoke-virtual {p1, p3}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/adapter/HorizontalRuleViewHolder;->a(Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/HorizontalRuleModel;)V

    goto :goto_0
.end method
