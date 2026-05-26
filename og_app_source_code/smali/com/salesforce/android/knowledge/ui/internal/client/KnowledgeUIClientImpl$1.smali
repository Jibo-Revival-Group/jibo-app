.class Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl$1;
.super Ljava/lang/Object;
.source "KnowledgeUIClientImpl.java"

# interfaces
.implements Lcom/salesforce/android/service/common/utilities/functional/Consumer;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->l()V
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
.field final synthetic a:Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;


# direct methods
.method constructor <init>(Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;)V
    .locals 0

    .prologue
    .line 252
    iput-object p1, p0, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl$1;->a:Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Landroid/support/v7/app/AppCompatActivity;)V
    .locals 0

    .prologue
    .line 254
    invoke-virtual {p1}, Landroid/support/v7/app/AppCompatActivity;->finish()V

    .line 255
    return-void
.end method

.method public bridge synthetic a(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 252
    check-cast p1, Landroid/support/v7/app/AppCompatActivity;

    invoke-virtual {p0, p1}, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl$1;->a(Landroid/support/v7/app/AppCompatActivity;)V

    return-void
.end method
