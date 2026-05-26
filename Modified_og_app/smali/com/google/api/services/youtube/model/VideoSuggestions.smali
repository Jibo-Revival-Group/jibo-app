.class public final Lcom/google/api/services/youtube/model/VideoSuggestions;
.super Lcom/google/api/client/json/GenericJson;
.source "VideoSuggestions.java"


# instance fields
.field private editorSuggestions:Ljava/util/List;
    .annotation runtime Lcom/google/api/client/util/Key;
    .end annotation

    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private processingErrors:Ljava/util/List;
    .annotation runtime Lcom/google/api/client/util/Key;
    .end annotation

    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private processingHints:Ljava/util/List;
    .annotation runtime Lcom/google/api/client/util/Key;
    .end annotation

    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private processingWarnings:Ljava/util/List;
    .annotation runtime Lcom/google/api/client/util/Key;
    .end annotation

    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private tagSuggestions:Ljava/util/List;
    .annotation runtime Lcom/google/api/client/util/Key;
    .end annotation

    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/google/api/services/youtube/model/VideoSuggestionsTagSuggestion;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 35
    invoke-direct {p0}, Lcom/google/api/client/json/GenericJson;-><init>()V

    return-void
.end method


# virtual methods
.method public bridge synthetic clone()Lcom/google/api/client/json/GenericJson;
    .locals 1

    .prologue
    .line 34
    invoke-virtual {p0}, Lcom/google/api/services/youtube/model/VideoSuggestions;->clone()Lcom/google/api/services/youtube/model/VideoSuggestions;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic clone()Lcom/google/api/client/util/GenericData;
    .locals 1

    .prologue
    .line 34
    invoke-virtual {p0}, Lcom/google/api/services/youtube/model/VideoSuggestions;->clone()Lcom/google/api/services/youtube/model/VideoSuggestions;

    move-result-object v0

    return-object v0
.end method

.method public clone()Lcom/google/api/services/youtube/model/VideoSuggestions;
    .locals 1

    .prologue
    .line 188
    invoke-super {p0}, Lcom/google/api/client/json/GenericJson;->clone()Lcom/google/api/client/json/GenericJson;

    move-result-object v0

    check-cast v0, Lcom/google/api/services/youtube/model/VideoSuggestions;

    return-object v0
.end method

.method public bridge synthetic clone()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/CloneNotSupportedException;
        }
    .end annotation

    .prologue
    .line 34
    invoke-virtual {p0}, Lcom/google/api/services/youtube/model/VideoSuggestions;->clone()Lcom/google/api/services/youtube/model/VideoSuggestions;

    move-result-object v0

    return-object v0
.end method

.method public getEditorSuggestions()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 86
    iget-object v0, p0, Lcom/google/api/services/youtube/model/VideoSuggestions;->editorSuggestions:Ljava/util/List;

    return-object v0
.end method

.method public getProcessingErrors()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 106
    iget-object v0, p0, Lcom/google/api/services/youtube/model/VideoSuggestions;->processingErrors:Ljava/util/List;

    return-object v0
.end method

.method public getProcessingHints()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 125
    iget-object v0, p0, Lcom/google/api/services/youtube/model/VideoSuggestions;->processingHints:Ljava/util/List;

    return-object v0
.end method

.method public getProcessingWarnings()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 146
    iget-object v0, p0, Lcom/google/api/services/youtube/model/VideoSuggestions;->processingWarnings:Ljava/util/List;

    return-object v0
.end method

.method public getTagSuggestions()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/google/api/services/youtube/model/VideoSuggestionsTagSuggestion;",
            ">;"
        }
    .end annotation

    .prologue
    .line 168
    iget-object v0, p0, Lcom/google/api/services/youtube/model/VideoSuggestions;->tagSuggestions:Ljava/util/List;

    return-object v0
.end method

.method public bridge synthetic set(Ljava/lang/String;Ljava/lang/Object;)Lcom/google/api/client/json/GenericJson;
    .locals 1

    .prologue
    .line 34
    invoke-virtual {p0, p1, p2}, Lcom/google/api/services/youtube/model/VideoSuggestions;->set(Ljava/lang/String;Ljava/lang/Object;)Lcom/google/api/services/youtube/model/VideoSuggestions;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic set(Ljava/lang/String;Ljava/lang/Object;)Lcom/google/api/client/util/GenericData;
    .locals 1

    .prologue
    .line 34
    invoke-virtual {p0, p1, p2}, Lcom/google/api/services/youtube/model/VideoSuggestions;->set(Ljava/lang/String;Ljava/lang/Object;)Lcom/google/api/services/youtube/model/VideoSuggestions;

    move-result-object v0

    return-object v0
.end method

.method public set(Ljava/lang/String;Ljava/lang/Object;)Lcom/google/api/services/youtube/model/VideoSuggestions;
    .locals 1

    .prologue
    .line 183
    invoke-super {p0, p1, p2}, Lcom/google/api/client/json/GenericJson;->set(Ljava/lang/String;Ljava/lang/Object;)Lcom/google/api/client/json/GenericJson;

    move-result-object v0

    check-cast v0, Lcom/google/api/services/youtube/model/VideoSuggestions;

    return-object v0
.end method

.method public setEditorSuggestions(Ljava/util/List;)Lcom/google/api/services/youtube/model/VideoSuggestions;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)",
            "Lcom/google/api/services/youtube/model/VideoSuggestions;"
        }
    .end annotation

    .prologue
    .line 95
    iput-object p1, p0, Lcom/google/api/services/youtube/model/VideoSuggestions;->editorSuggestions:Ljava/util/List;

    .line 96
    return-object p0
.end method

.method public setProcessingErrors(Ljava/util/List;)Lcom/google/api/services/youtube/model/VideoSuggestions;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)",
            "Lcom/google/api/services/youtube/model/VideoSuggestions;"
        }
    .end annotation

    .prologue
    .line 116
    iput-object p1, p0, Lcom/google/api/services/youtube/model/VideoSuggestions;->processingErrors:Ljava/util/List;

    .line 117
    return-object p0
.end method

.method public setProcessingHints(Ljava/util/List;)Lcom/google/api/services/youtube/model/VideoSuggestions;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)",
            "Lcom/google/api/services/youtube/model/VideoSuggestions;"
        }
    .end annotation

    .prologue
    .line 133
    iput-object p1, p0, Lcom/google/api/services/youtube/model/VideoSuggestions;->processingHints:Ljava/util/List;

    .line 134
    return-object p0
.end method

.method public setProcessingWarnings(Ljava/util/List;)Lcom/google/api/services/youtube/model/VideoSuggestions;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)",
            "Lcom/google/api/services/youtube/model/VideoSuggestions;"
        }
    .end annotation

    .prologue
    .line 158
    iput-object p1, p0, Lcom/google/api/services/youtube/model/VideoSuggestions;->processingWarnings:Ljava/util/List;

    .line 159
    return-object p0
.end method

.method public setTagSuggestions(Ljava/util/List;)Lcom/google/api/services/youtube/model/VideoSuggestions;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/google/api/services/youtube/model/VideoSuggestionsTagSuggestion;",
            ">;)",
            "Lcom/google/api/services/youtube/model/VideoSuggestions;"
        }
    .end annotation

    .prologue
    .line 177
    iput-object p1, p0, Lcom/google/api/services/youtube/model/VideoSuggestions;->tagSuggestions:Ljava/util/List;

    .line 178
    return-object p0
.end method
