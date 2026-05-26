.class Lcom/jibo/JiboSupport$4$1;
.super Ljava/lang/Object;
.source "JiboSupport.java"

# interfaces
.implements Lcom/salesforce/android/knowledge/ui/KnowledgeUIClient$OnCloseListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/JiboSupport$4;->a(Lcom/salesforce/android/service/common/utilities/control/Async;Lcom/salesforce/android/knowledge/ui/KnowledgeUIClient;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/JiboSupport$4;


# direct methods
.method constructor <init>(Lcom/jibo/JiboSupport$4;)V
    .locals 0

    .prologue
    .line 130
    iput-object p1, p0, Lcom/jibo/JiboSupport$4$1;->a:Lcom/jibo/JiboSupport$4;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()V
    .locals 1

    .prologue
    .line 135
    const/4 v0, 0x0

    invoke-static {v0}, Lcom/jibo/JiboSupport;->a(Lcom/salesforce/android/knowledge/ui/KnowledgeUIClient;)Lcom/salesforce/android/knowledge/ui/KnowledgeUIClient;

    .line 136
    return-void
.end method
