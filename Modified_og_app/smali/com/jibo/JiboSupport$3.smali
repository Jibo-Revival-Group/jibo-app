.class final Lcom/jibo/JiboSupport$3;
.super Ljava/lang/Object;
.source "JiboSupport.java"

# interfaces
.implements Lcom/salesforce/android/service/common/utilities/control/Async$ResultHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/JiboSupport;->b(Landroid/content/Context;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/salesforce/android/service/common/utilities/control/Async$ResultHandler",
        "<",
        "Lcom/salesforce/android/cases/ui/CaseUIClient;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Landroid/content/Context;


# direct methods
.method constructor <init>(Landroid/content/Context;)V
    .locals 0

    .prologue
    .line 90
    iput-object p1, p0, Lcom/jibo/JiboSupport$3;->a:Landroid/content/Context;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/salesforce/android/service/common/utilities/control/Async;Lcom/salesforce/android/cases/ui/CaseUIClient;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<*>;",
            "Lcom/salesforce/android/cases/ui/CaseUIClient;",
            ")V"
        }
    .end annotation

    .prologue
    .line 93
    iget-object v0, p0, Lcom/jibo/JiboSupport$3;->a:Landroid/content/Context;

    invoke-interface {p2, v0}, Lcom/salesforce/android/cases/ui/CaseUIClient;->a(Landroid/content/Context;)V

    .line 94
    return-void
.end method

.method public bridge synthetic a(Lcom/salesforce/android/service/common/utilities/control/Async;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 90
    check-cast p2, Lcom/salesforce/android/cases/ui/CaseUIClient;

    invoke-virtual {p0, p1, p2}, Lcom/jibo/JiboSupport$3;->a(Lcom/salesforce/android/service/common/utilities/control/Async;Lcom/salesforce/android/cases/ui/CaseUIClient;)V

    return-void
.end method
