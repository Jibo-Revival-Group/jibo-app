.class public Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/ReceivedMessageModel;
.super Ljava/lang/Object;
.source "ReceivedMessageModel.java"

# interfaces
.implements Lcom/salesforce/android/service/common/ui/internal/messaging/MultiActorMessage;


# instance fields
.field private final a:Ljava/lang/String;

.field private final b:Ljava/lang/String;

.field private final c:Ljava/lang/String;

.field private final d:Ljava/util/Date;


# direct methods
.method constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;)V
    .locals 0

    .prologue
    .line 37
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 38
    iput-object p1, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/ReceivedMessageModel;->a:Ljava/lang/String;

    .line 39
    iput-object p2, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/ReceivedMessageModel;->b:Ljava/lang/String;

    .line 40
    iput-object p3, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/ReceivedMessageModel;->c:Ljava/lang/String;

    .line 41
    iput-object p4, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/ReceivedMessageModel;->d:Ljava/util/Date;

    .line 42
    return-void
.end method


# virtual methods
.method public a()Ljava/lang/String;
    .locals 1

    .prologue
    .line 45
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/ReceivedMessageModel;->a:Ljava/lang/String;

    return-object v0
.end method

.method public b()Ljava/lang/String;
    .locals 1

    .prologue
    .line 49
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/ReceivedMessageModel;->b:Ljava/lang/String;

    return-object v0
.end method

.method public c()Ljava/lang/String;
    .locals 1

    .prologue
    .line 53
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/ReceivedMessageModel;->c:Ljava/lang/String;

    return-object v0
.end method

.method public d()Ljava/util/Date;
    .locals 1

    .prologue
    .line 57
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/ReceivedMessageModel;->d:Ljava/util/Date;

    return-object v0
.end method

.method public e()Ljava/lang/String;
    .locals 1

    .prologue
    .line 61
    invoke-virtual {p0}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/ReceivedMessageModel;->c()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
