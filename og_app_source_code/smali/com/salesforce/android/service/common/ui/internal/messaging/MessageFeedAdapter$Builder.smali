.class public Lcom/salesforce/android/service/common/ui/internal/messaging/MessageFeedAdapter$Builder;
.super Ljava/lang/Object;
.source "MessageFeedAdapter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/service/common/ui/internal/messaging/MessageFeedAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation


# instance fields
.field a:Lcom/salesforce/android/service/common/ui/internal/messaging/ViewHolderFactory;

.field b:Lcom/salesforce/android/service/common/ui/internal/android/LayoutInflaterFactory;

.field c:Lcom/salesforce/android/service/common/ui/internal/android/RecyclerViewAdapterDelegate;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/salesforce/android/service/common/ui/internal/android/RecyclerViewAdapterDelegate",
            "<",
            "Landroid/support/v7/widget/RecyclerView$ViewHolder;",
            ">;"
        }
    .end annotation
.end field

.field d:Ljava/lang/Long;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 302
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/salesforce/android/service/common/ui/internal/android/LayoutInflaterFactory;)Lcom/salesforce/android/service/common/ui/internal/messaging/MessageFeedAdapter$Builder;
    .locals 0

    .prologue
    .line 315
    iput-object p1, p0, Lcom/salesforce/android/service/common/ui/internal/messaging/MessageFeedAdapter$Builder;->b:Lcom/salesforce/android/service/common/ui/internal/android/LayoutInflaterFactory;

    .line 316
    return-object p0
.end method

.method public a(Lcom/salesforce/android/service/common/ui/internal/messaging/ViewHolderFactory;)Lcom/salesforce/android/service/common/ui/internal/messaging/MessageFeedAdapter$Builder;
    .locals 0

    .prologue
    .line 310
    iput-object p1, p0, Lcom/salesforce/android/service/common/ui/internal/messaging/MessageFeedAdapter$Builder;->a:Lcom/salesforce/android/service/common/ui/internal/messaging/ViewHolderFactory;

    .line 311
    return-object p0
.end method

.method public a()Lcom/salesforce/android/service/common/ui/internal/messaging/MessageFeedAdapter;
    .locals 2

    .prologue
    .line 330
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/messaging/MessageFeedAdapter$Builder;->a:Lcom/salesforce/android/service/common/ui/internal/messaging/ViewHolderFactory;

    const-string v1, "Please provide a ViewHolderFactory instance to the MessageFeedAdapter."

    invoke-static {v0, v1}, Lcom/salesforce/android/service/common/utilities/validation/Arguments;->a(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    .line 332
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/messaging/MessageFeedAdapter$Builder;->b:Lcom/salesforce/android/service/common/ui/internal/android/LayoutInflaterFactory;

    if-nez v0, :cond_0

    .line 333
    new-instance v0, Lcom/salesforce/android/service/common/ui/internal/android/LayoutInflaterFactory;

    invoke-direct {v0}, Lcom/salesforce/android/service/common/ui/internal/android/LayoutInflaterFactory;-><init>()V

    iput-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/messaging/MessageFeedAdapter$Builder;->b:Lcom/salesforce/android/service/common/ui/internal/android/LayoutInflaterFactory;

    .line 336
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/messaging/MessageFeedAdapter$Builder;->c:Lcom/salesforce/android/service/common/ui/internal/android/RecyclerViewAdapterDelegate;

    if-nez v0, :cond_1

    .line 337
    new-instance v0, Lcom/salesforce/android/service/common/ui/internal/android/RecyclerViewAdapterDelegate;

    invoke-direct {v0}, Lcom/salesforce/android/service/common/ui/internal/android/RecyclerViewAdapterDelegate;-><init>()V

    iput-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/messaging/MessageFeedAdapter$Builder;->c:Lcom/salesforce/android/service/common/ui/internal/android/RecyclerViewAdapterDelegate;

    .line 340
    :cond_1
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/messaging/MessageFeedAdapter$Builder;->d:Ljava/lang/Long;

    if-nez v0, :cond_2

    .line 341
    const-wide/32 v0, 0xea60

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/messaging/MessageFeedAdapter$Builder;->d:Ljava/lang/Long;

    .line 344
    :cond_2
    new-instance v0, Lcom/salesforce/android/service/common/ui/internal/messaging/MessageFeedAdapter;

    invoke-direct {v0, p0}, Lcom/salesforce/android/service/common/ui/internal/messaging/MessageFeedAdapter;-><init>(Lcom/salesforce/android/service/common/ui/internal/messaging/MessageFeedAdapter$Builder;)V

    return-object v0
.end method
