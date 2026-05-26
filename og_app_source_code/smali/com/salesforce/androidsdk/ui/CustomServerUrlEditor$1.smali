.class Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor$1;
.super Ljava/lang/Object;
.source "CustomServerUrlEditor.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;


# direct methods
.method constructor <init>(Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;)V
    .locals 0

    .prologue
    .line 90
    iput-object p1, p0, Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor$1;->a:Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3

    .prologue
    .line 94
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor$1;->a:Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;

    iget-object v1, p0, Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor$1;->a:Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;

    invoke-static {v1}, Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;->a(Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;)Lcom/salesforce/androidsdk/ui/SalesforceR;

    move-result-object v1

    invoke-virtual {v1}, Lcom/salesforce/androidsdk/ui/SalesforceR;->M()I

    move-result v1

    invoke-static {v0, v1}, Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;->a(Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;I)Ljava/lang/String;

    move-result-object v0

    .line 95
    if-nez v0, :cond_1

    .line 106
    :cond_0
    :goto_0
    return-void

    .line 98
    :cond_1
    iget-object v1, p0, Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor$1;->a:Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;

    iget-object v2, p0, Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor$1;->a:Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;

    invoke-static {v2}, Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;->a(Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;)Lcom/salesforce/androidsdk/ui/SalesforceR;

    move-result-object v2

    invoke-virtual {v2}, Lcom/salesforce/androidsdk/ui/SalesforceR;->N()I

    move-result v2

    invoke-static {v1, v2}, Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;->a(Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;I)Ljava/lang/String;

    move-result-object v1

    .line 99
    if-eqz v1, :cond_0

    .line 104
    iget-object v2, p0, Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor$1;->a:Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;

    invoke-static {v2}, Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;->b(Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;)Lcom/salesforce/androidsdk/config/LoginServerManager;

    move-result-object v2

    invoke-virtual {v2, v0, v1}, Lcom/salesforce/androidsdk/config/LoginServerManager;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 105
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor$1;->a:Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;->dismiss()V

    goto :goto_0
.end method
