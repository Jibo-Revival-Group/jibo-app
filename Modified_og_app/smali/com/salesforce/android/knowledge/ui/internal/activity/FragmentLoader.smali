.class public Lcom/salesforce/android/knowledge/ui/internal/activity/FragmentLoader;
.super Ljava/lang/Object;
.source "FragmentLoader.java"

# interfaces
.implements Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator$Listener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/knowledge/ui/internal/activity/FragmentLoader$Builder;
    }
.end annotation


# instance fields
.field private final a:Lcom/salesforce/android/knowledge/ui/internal/activity/KnowledgeFragment$Factory;

.field private b:Lcom/salesforce/android/service/common/utilities/activity/ActivityReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/salesforce/android/service/common/utilities/activity/ActivityReference",
            "<",
            "Landroid/support/v7/app/AppCompatActivity;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method constructor <init>(Lcom/salesforce/android/knowledge/ui/internal/activity/FragmentLoader$Builder;)V
    .locals 1

    .prologue
    .line 63
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 57
    invoke-static {}, Lcom/salesforce/android/service/common/utilities/activity/ActivityReference;->a()Lcom/salesforce/android/service/common/utilities/activity/ActivityReference;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/activity/FragmentLoader;->b:Lcom/salesforce/android/service/common/utilities/activity/ActivityReference;

    .line 64
    iget-object v0, p1, Lcom/salesforce/android/knowledge/ui/internal/activity/FragmentLoader$Builder;->a:Lcom/salesforce/android/knowledge/ui/internal/activity/KnowledgeFragment$Factory;

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/activity/FragmentLoader;->a:Lcom/salesforce/android/knowledge/ui/internal/activity/KnowledgeFragment$Factory;

    .line 65
    return-void
.end method

.method public static a()Lcom/salesforce/android/knowledge/ui/internal/activity/FragmentLoader$Builder;
    .locals 1

    .prologue
    .line 68
    new-instance v0, Lcom/salesforce/android/knowledge/ui/internal/activity/FragmentLoader$Builder;

    invoke-direct {v0}, Lcom/salesforce/android/knowledge/ui/internal/activity/FragmentLoader$Builder;-><init>()V

    return-object v0
.end method

.method private a(Landroid/support/v7/app/AppCompatActivity;Z)V
    .locals 4

    .prologue
    const/4 v0, 0x0

    .line 135
    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/activity/FragmentLoader;->a:Lcom/salesforce/android/knowledge/ui/internal/activity/KnowledgeFragment$Factory;

    invoke-virtual {v1}, Lcom/salesforce/android/knowledge/ui/internal/activity/KnowledgeFragment$Factory;->a()Lcom/salesforce/android/knowledge/ui/internal/activity/KnowledgeFragment;

    move-result-object v2

    .line 137
    if-eqz p2, :cond_1

    move v1, v0

    .line 138
    :goto_0
    if-eqz p2, :cond_0

    sget v0, Lcom/salesforce/android/knowledge/ui/R$anim;->knowledge_fragment_out:I

    .line 140
    :cond_0
    invoke-virtual {p1}, Landroid/support/v7/app/AppCompatActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v3

    .line 141
    invoke-virtual {v3}, Landroid/support/v4/app/FragmentManager;->a()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v3

    .line 142
    invoke-virtual {v3, v1, v0}, Landroid/support/v4/app/FragmentTransaction;->a(II)Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    sget v1, Lcom/salesforce/android/knowledge/ui/R$id;->knowledge_fragment_container:I

    const-string v3, "KnowledgeFragment"

    .line 143
    invoke-virtual {v0, v1, v2, v3}, Landroid/support/v4/app/FragmentTransaction;->b(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    .line 144
    invoke-virtual {v0}, Landroid/support/v4/app/FragmentTransaction;->d()I

    .line 145
    return-void

    .line 137
    :cond_1
    sget v1, Lcom/salesforce/android/knowledge/ui/R$anim;->knowledge_fragment_in:I

    goto :goto_0
.end method

.method private d(Landroid/support/v7/app/AppCompatActivity;)Z
    .locals 2

    .prologue
    .line 130
    invoke-virtual {p1}, Landroid/support/v7/app/AppCompatActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    const-string v1, "KnowledgeFragment"

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentManager;->a(Ljava/lang/String;)Landroid/support/v4/app/Fragment;

    move-result-object v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public a(Landroid/support/v7/app/AppCompatActivity;)V
    .locals 1

    .prologue
    .line 76
    invoke-static {p1}, Lcom/salesforce/android/service/common/utilities/activity/ActivityReference;->a(Landroid/app/Activity;)Lcom/salesforce/android/service/common/utilities/activity/ActivityReference;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/activity/FragmentLoader;->b:Lcom/salesforce/android/service/common/utilities/activity/ActivityReference;

    .line 79
    invoke-direct {p0, p1}, Lcom/salesforce/android/knowledge/ui/internal/activity/FragmentLoader;->d(Landroid/support/v7/app/AppCompatActivity;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 80
    invoke-virtual {p0, p1}, Lcom/salesforce/android/knowledge/ui/internal/activity/FragmentLoader;->b(Landroid/support/v7/app/AppCompatActivity;)V

    .line 82
    :cond_0
    return-void
.end method

.method public a(Lcom/salesforce/android/knowledge/ui/KnowledgeScene;Lcom/salesforce/android/knowledge/ui/KnowledgeScene;)V
    .locals 2

    .prologue
    .line 90
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/activity/FragmentLoader;->b:Lcom/salesforce/android/service/common/utilities/activity/ActivityReference;

    new-instance v1, Lcom/salesforce/android/knowledge/ui/internal/activity/FragmentLoader$1;

    invoke-direct {v1, p0}, Lcom/salesforce/android/knowledge/ui/internal/activity/FragmentLoader$1;-><init>(Lcom/salesforce/android/knowledge/ui/internal/activity/FragmentLoader;)V

    invoke-virtual {v0, v1}, Lcom/salesforce/android/service/common/utilities/activity/ActivityReference;->a(Lcom/salesforce/android/service/common/utilities/functional/Consumer;)V

    .line 95
    return-void
.end method

.method b(Landroid/support/v7/app/AppCompatActivity;)V
    .locals 1

    .prologue
    .line 116
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/salesforce/android/knowledge/ui/internal/activity/FragmentLoader;->a(Landroid/support/v7/app/AppCompatActivity;Z)V

    .line 117
    return-void
.end method

.method public b(Lcom/salesforce/android/knowledge/ui/KnowledgeScene;Lcom/salesforce/android/knowledge/ui/KnowledgeScene;)V
    .locals 2

    .prologue
    .line 99
    sget-object v0, Lcom/salesforce/android/knowledge/ui/KnowledgeScene;->SCENE_NONE:Lcom/salesforce/android/knowledge/ui/KnowledgeScene;

    if-eq p2, v0, :cond_0

    .line 100
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/activity/FragmentLoader;->b:Lcom/salesforce/android/service/common/utilities/activity/ActivityReference;

    new-instance v1, Lcom/salesforce/android/knowledge/ui/internal/activity/FragmentLoader$2;

    invoke-direct {v1, p0}, Lcom/salesforce/android/knowledge/ui/internal/activity/FragmentLoader$2;-><init>(Lcom/salesforce/android/knowledge/ui/internal/activity/FragmentLoader;)V

    invoke-virtual {v0, v1}, Lcom/salesforce/android/service/common/utilities/activity/ActivityReference;->a(Lcom/salesforce/android/service/common/utilities/functional/Consumer;)V

    .line 106
    :cond_0
    return-void
.end method

.method c(Landroid/support/v7/app/AppCompatActivity;)V
    .locals 1

    .prologue
    .line 123
    const/4 v0, 0x1

    invoke-direct {p0, p1, v0}, Lcom/salesforce/android/knowledge/ui/internal/activity/FragmentLoader;->a(Landroid/support/v7/app/AppCompatActivity;Z)V

    .line 124
    return-void
.end method
