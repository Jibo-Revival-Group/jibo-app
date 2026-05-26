.class public Lcom/salesforce/android/knowledge/ui/internal/activity/FragmentLoader$Builder;
.super Ljava/lang/Object;
.source "FragmentLoader.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/knowledge/ui/internal/activity/FragmentLoader;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation


# instance fields
.field a:Lcom/salesforce/android/knowledge/ui/internal/activity/KnowledgeFragment$Factory;


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 155
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 156
    return-void
.end method


# virtual methods
.method public a()Lcom/salesforce/android/knowledge/ui/internal/activity/FragmentLoader;
    .locals 1

    .prologue
    .line 164
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/activity/FragmentLoader$Builder;->a:Lcom/salesforce/android/knowledge/ui/internal/activity/KnowledgeFragment$Factory;

    if-nez v0, :cond_0

    .line 165
    new-instance v0, Lcom/salesforce/android/knowledge/ui/internal/activity/KnowledgeFragment$Factory;

    invoke-direct {v0}, Lcom/salesforce/android/knowledge/ui/internal/activity/KnowledgeFragment$Factory;-><init>()V

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/activity/FragmentLoader$Builder;->a:Lcom/salesforce/android/knowledge/ui/internal/activity/KnowledgeFragment$Factory;

    .line 168
    :cond_0
    new-instance v0, Lcom/salesforce/android/knowledge/ui/internal/activity/FragmentLoader;

    invoke-direct {v0, p0}, Lcom/salesforce/android/knowledge/ui/internal/activity/FragmentLoader;-><init>(Lcom/salesforce/android/knowledge/ui/internal/activity/FragmentLoader$Builder;)V

    return-object v0
.end method
