.class public Lcom/salesforce/android/service/common/ui/internal/text/SalesforceTextWatcher;
.super Ljava/lang/Object;
.source "SalesforceTextWatcher.java"

# interfaces
.implements Landroid/text/TextWatcher;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/service/common/ui/internal/text/SalesforceTextWatcher$OnAfterTextChangedListener;,
        Lcom/salesforce/android/service/common/ui/internal/text/SalesforceTextWatcher$OnTextChangedListener;,
        Lcom/salesforce/android/service/common/ui/internal/text/SalesforceTextWatcher$OnBeforeTextChangedListener;
    }
.end annotation


# instance fields
.field private a:Lcom/salesforce/android/service/common/ui/internal/text/SalesforceTextWatcher$OnBeforeTextChangedListener;

.field private b:Lcom/salesforce/android/service/common/ui/internal/text/SalesforceTextWatcher$OnTextChangedListener;

.field private c:Lcom/salesforce/android/service/common/ui/internal/text/SalesforceTextWatcher$OnAfterTextChangedListener;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 37
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/salesforce/android/service/common/ui/internal/text/SalesforceTextWatcher$OnAfterTextChangedListener;)V
    .locals 0

    .prologue
    .line 76
    iput-object p1, p0, Lcom/salesforce/android/service/common/ui/internal/text/SalesforceTextWatcher;->c:Lcom/salesforce/android/service/common/ui/internal/text/SalesforceTextWatcher$OnAfterTextChangedListener;

    .line 77
    return-void
.end method

.method public afterTextChanged(Landroid/text/Editable;)V
    .locals 1

    .prologue
    .line 96
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/text/SalesforceTextWatcher;->c:Lcom/salesforce/android/service/common/ui/internal/text/SalesforceTextWatcher$OnAfterTextChangedListener;

    if-eqz v0, :cond_0

    .line 97
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/text/SalesforceTextWatcher;->c:Lcom/salesforce/android/service/common/ui/internal/text/SalesforceTextWatcher$OnAfterTextChangedListener;

    invoke-interface {v0, p1}, Lcom/salesforce/android/service/common/ui/internal/text/SalesforceTextWatcher$OnAfterTextChangedListener;->a(Landroid/text/Editable;)V

    .line 99
    :cond_0
    return-void
.end method

.method public beforeTextChanged(Ljava/lang/CharSequence;III)V
    .locals 1

    .prologue
    .line 84
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/text/SalesforceTextWatcher;->a:Lcom/salesforce/android/service/common/ui/internal/text/SalesforceTextWatcher$OnBeforeTextChangedListener;

    if-eqz v0, :cond_0

    .line 85
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/text/SalesforceTextWatcher;->a:Lcom/salesforce/android/service/common/ui/internal/text/SalesforceTextWatcher$OnBeforeTextChangedListener;

    invoke-interface {v0, p1, p2, p3, p4}, Lcom/salesforce/android/service/common/ui/internal/text/SalesforceTextWatcher$OnBeforeTextChangedListener;->a(Ljava/lang/CharSequence;III)V

    .line 87
    :cond_0
    return-void
.end method

.method public onTextChanged(Ljava/lang/CharSequence;III)V
    .locals 1

    .prologue
    .line 90
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/text/SalesforceTextWatcher;->b:Lcom/salesforce/android/service/common/ui/internal/text/SalesforceTextWatcher$OnTextChangedListener;

    if-eqz v0, :cond_0

    .line 91
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/text/SalesforceTextWatcher;->b:Lcom/salesforce/android/service/common/ui/internal/text/SalesforceTextWatcher$OnTextChangedListener;

    invoke-interface {v0, p1, p2, p3, p4}, Lcom/salesforce/android/service/common/ui/internal/text/SalesforceTextWatcher$OnTextChangedListener;->a(Ljava/lang/CharSequence;III)V

    .line 93
    :cond_0
    return-void
.end method
