.class public Lcom/salesforce/android/service/common/http/ResponseException;
.super Ljava/lang/Exception;
.source "ResponseException.java"


# instance fields
.field final a:I

.field final b:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;ILjava/lang/String;)V
    .locals 0

    .prologue
    .line 39
    invoke-direct {p0, p1}, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V

    .line 40
    iput p2, p0, Lcom/salesforce/android/service/common/http/ResponseException;->a:I

    .line 41
    iput-object p3, p0, Lcom/salesforce/android/service/common/http/ResponseException;->b:Ljava/lang/String;

    .line 42
    return-void
.end method


# virtual methods
.method public a()I
    .locals 1

    .prologue
    .line 45
    iget v0, p0, Lcom/salesforce/android/service/common/http/ResponseException;->a:I

    return v0
.end method

.method public b()Ljava/lang/String;
    .locals 1

    .prologue
    .line 49
    iget-object v0, p0, Lcom/salesforce/android/service/common/http/ResponseException;->b:Ljava/lang/String;

    return-object v0
.end method
