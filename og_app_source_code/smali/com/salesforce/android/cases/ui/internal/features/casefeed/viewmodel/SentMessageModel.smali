.class public Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/SentMessageModel;
.super Ljava/lang/Object;
.source "SentMessageModel.java"

# interfaces
.implements Lcom/salesforce/android/service/common/ui/internal/messaging/Message;


# instance fields
.field private final a:Ljava/lang/String;

.field private final b:Ljava/util/Date;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/util/Date;)V
    .locals 0

    .prologue
    .line 35
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 36
    iput-object p1, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/SentMessageModel;->a:Ljava/lang/String;

    .line 37
    iput-object p2, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/SentMessageModel;->b:Ljava/util/Date;

    .line 38
    return-void
.end method


# virtual methods
.method public a()Ljava/lang/String;
    .locals 1

    .prologue
    .line 41
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/SentMessageModel;->a:Ljava/lang/String;

    return-object v0
.end method

.method public d()Ljava/util/Date;
    .locals 1

    .prologue
    .line 45
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/SentMessageModel;->b:Ljava/util/Date;

    return-object v0
.end method
