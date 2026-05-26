.class public Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstoreFactory;
.super Ljava/lang/Object;
.source "KeyValueSmartstoreFactory.java"


# instance fields
.field private final a:Lcom/salesforce/androidsdk/accounts/UserAccount;


# direct methods
.method public constructor <init>(Lcom/salesforce/androidsdk/accounts/UserAccount;)V
    .locals 0

    .prologue
    .line 28
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 29
    iput-object p1, p0, Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstoreFactory;->a:Lcom/salesforce/androidsdk/accounts/UserAccount;

    .line 30
    return-void
.end method


# virtual methods
.method public a(Ljava/lang/String;)Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstore;
    .locals 2

    .prologue
    .line 33
    new-instance v0, Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstore;

    iget-object v1, p0, Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstoreFactory;->a:Lcom/salesforce/androidsdk/accounts/UserAccount;

    invoke-direct {v0, p1, v1}, Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstore;-><init>(Ljava/lang/String;Lcom/salesforce/androidsdk/accounts/UserAccount;)V

    return-object v0
.end method
