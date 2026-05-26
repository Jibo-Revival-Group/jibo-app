.class Lcom/salesforce/android/knowledge/ui/internal/views/KnowledgeRecyclerView$1;
.super Ljava/lang/Object;
.source "KnowledgeRecyclerView.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/salesforce/android/knowledge/ui/internal/views/KnowledgeRecyclerView;->onAttachedToWindow()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/android/knowledge/ui/internal/views/KnowledgeRecyclerView;


# direct methods
.method constructor <init>(Lcom/salesforce/android/knowledge/ui/internal/views/KnowledgeRecyclerView;)V
    .locals 0

    .prologue
    .line 54
    iput-object p1, p0, Lcom/salesforce/android/knowledge/ui/internal/views/KnowledgeRecyclerView$1;->a:Lcom/salesforce/android/knowledge/ui/internal/views/KnowledgeRecyclerView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 56
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/views/KnowledgeRecyclerView$1;->a:Lcom/salesforce/android/knowledge/ui/internal/views/KnowledgeRecyclerView;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/views/KnowledgeRecyclerView;->requestLayout()V

    .line 57
    return-void
.end method
