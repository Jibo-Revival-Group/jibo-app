.class Lcom/salesforce/android/knowledge/ui/internal/activity/FragmentLoader$2;
.super Ljava/lang/Object;
.source "FragmentLoader.java"

# interfaces
.implements Lcom/salesforce/android/service/common/utilities/functional/Consumer;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/salesforce/android/knowledge/ui/internal/activity/FragmentLoader;->b(Lcom/salesforce/android/knowledge/ui/KnowledgeScene;Lcom/salesforce/android/knowledge/ui/KnowledgeScene;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/salesforce/android/service/common/utilities/functional/Consumer",
        "<",
        "Landroid/support/v7/app/AppCompatActivity;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/android/knowledge/ui/internal/activity/FragmentLoader;


# direct methods
.method constructor <init>(Lcom/salesforce/android/knowledge/ui/internal/activity/FragmentLoader;)V
    .locals 0

    .prologue
    .line 100
    iput-object p1, p0, Lcom/salesforce/android/knowledge/ui/internal/activity/FragmentLoader$2;->a:Lcom/salesforce/android/knowledge/ui/internal/activity/FragmentLoader;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Landroid/support/v7/app/AppCompatActivity;)V
    .locals 1

    .prologue
    .line 102
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/activity/FragmentLoader$2;->a:Lcom/salesforce/android/knowledge/ui/internal/activity/FragmentLoader;

    invoke-virtual {v0, p1}, Lcom/salesforce/android/knowledge/ui/internal/activity/FragmentLoader;->c(Landroid/support/v7/app/AppCompatActivity;)V

    .line 103
    return-void
.end method

.method public bridge synthetic a(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 100
    check-cast p1, Landroid/support/v7/app/AppCompatActivity;

    invoke-virtual {p0, p1}, Lcom/salesforce/android/knowledge/ui/internal/activity/FragmentLoader$2;->a(Landroid/support/v7/app/AppCompatActivity;)V

    return-void
.end method
