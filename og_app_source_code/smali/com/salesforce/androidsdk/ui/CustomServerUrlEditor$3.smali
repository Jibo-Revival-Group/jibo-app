.class Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor$3;
.super Ljava/lang/Object;
.source "CustomServerUrlEditor.java"

# interfaces
.implements Landroid/view/View$OnFocusChangeListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;->a(ILjava/lang/String;)V
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
    .line 145
    iput-object p1, p0, Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor$3;->a:Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onFocusChange(Landroid/view/View;Z)V
    .locals 4

    .prologue
    .line 149
    check-cast p1, Landroid/widget/EditText;

    .line 150
    invoke-virtual {p1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor$3;->a:Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;

    .line 151
    invoke-virtual {p1}, Landroid/widget/EditText;->getId()I

    move-result v2

    invoke-static {v1, v2}, Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;->b(Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;I)Ljava/lang/String;

    move-result-object v1

    .line 150
    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    .line 152
    if-eqz p2, :cond_1

    if-eqz v0, :cond_1

    .line 153
    invoke-virtual {p1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-interface {v0}, Landroid/text/Editable;->clear()V

    .line 161
    :cond_0
    :goto_0
    return-void

    .line 154
    :cond_1
    if-nez p2, :cond_0

    invoke-virtual {p1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    const-string v1, ""

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 155
    invoke-virtual {p1}, Landroid/widget/EditText;->getId()I

    move-result v0

    iget-object v1, p0, Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor$3;->a:Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;

    invoke-static {v1}, Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;->a(Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;)Lcom/salesforce/androidsdk/ui/SalesforceR;

    move-result-object v1

    invoke-virtual {v1}, Lcom/salesforce/androidsdk/ui/SalesforceR;->M()I

    move-result v1

    if-ne v0, v1, :cond_2

    .line 156
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor$3;->a:Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;

    iget-object v1, p0, Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor$3;->a:Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;

    invoke-static {v1}, Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;->a(Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;)Lcom/salesforce/androidsdk/ui/SalesforceR;

    move-result-object v1

    invoke-virtual {v1}, Lcom/salesforce/androidsdk/ui/SalesforceR;->M()I

    move-result v1

    iget-object v2, p0, Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor$3;->a:Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;

    invoke-virtual {p1}, Landroid/widget/EditText;->getId()I

    move-result v3

    invoke-static {v2, v3}, Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;->b(Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;I)Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;->a(Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;ILjava/lang/String;)V

    goto :goto_0

    .line 158
    :cond_2
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor$3;->a:Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;

    iget-object v1, p0, Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor$3;->a:Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;

    invoke-static {v1}, Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;->a(Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;)Lcom/salesforce/androidsdk/ui/SalesforceR;

    move-result-object v1

    invoke-virtual {v1}, Lcom/salesforce/androidsdk/ui/SalesforceR;->N()I

    move-result v1

    iget-object v2, p0, Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor$3;->a:Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;

    invoke-virtual {p1}, Landroid/widget/EditText;->getId()I

    move-result v3

    invoke-static {v2, v3}, Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;->b(Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;I)Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;->a(Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;ILjava/lang/String;)V

    goto :goto_0
.end method
