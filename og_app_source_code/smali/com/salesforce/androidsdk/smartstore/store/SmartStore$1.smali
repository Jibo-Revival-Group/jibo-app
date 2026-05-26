.class Lcom/salesforce/androidsdk/smartstore/store/SmartStore$1;
.super Ljava/lang/Object;
.source "SmartStore.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->a(Lcom/salesforce/androidsdk/smartstore/store/SoupSpec;[Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/androidsdk/smartstore/store/SoupSpec;

.field final synthetic b:[Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;

.field final synthetic c:Lcom/salesforce/androidsdk/smartstore/store/SmartStore;


# direct methods
.method constructor <init>(Lcom/salesforce/androidsdk/smartstore/store/SmartStore;Lcom/salesforce/androidsdk/smartstore/store/SoupSpec;[Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;)V
    .locals 0

    .prologue
    .line 343
    iput-object p1, p0, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$1;->c:Lcom/salesforce/androidsdk/smartstore/store/SmartStore;

    iput-object p2, p0, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$1;->a:Lcom/salesforce/androidsdk/smartstore/store/SoupSpec;

    iput-object p3, p0, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$1;->b:[Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 346
    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$1;->c:Lcom/salesforce/androidsdk/smartstore/store/SmartStore;

    iget-object v1, p0, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$1;->a:Lcom/salesforce/androidsdk/smartstore/store/SoupSpec;

    iget-object v2, p0, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$1;->b:[Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;

    invoke-static {v0, v1, v2}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->a(Lcom/salesforce/androidsdk/smartstore/store/SmartStore;Lcom/salesforce/androidsdk/smartstore/store/SoupSpec;[Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;)V

    .line 347
    return-void
.end method
