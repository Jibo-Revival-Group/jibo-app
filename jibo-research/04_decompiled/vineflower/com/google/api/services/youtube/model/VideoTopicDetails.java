package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import java.util.List;

public final class VideoTopicDetails extends GenericJson {
   @Key
   private List<String> relevantTopicIds;
   @Key
   private List<String> topicCategories;
   @Key
   private List<String> topicIds;

   public VideoTopicDetails clone() {
      return (VideoTopicDetails)super.clone();
   }

   public List<String> getRelevantTopicIds() {
      return this.relevantTopicIds;
   }

   public List<String> getTopicCategories() {
      return this.topicCategories;
   }

   public List<String> getTopicIds() {
      return this.topicIds;
   }

   public VideoTopicDetails set(String var1, Object var2) {
      return (VideoTopicDetails)super.set(var1, var2);
   }

   public VideoTopicDetails setRelevantTopicIds(List<String> var1) {
      this.relevantTopicIds = var1;
      return this;
   }

   public VideoTopicDetails setTopicCategories(List<String> var1) {
      this.topicCategories = var1;
      return this;
   }

   public VideoTopicDetails setTopicIds(List<String> var1) {
      this.topicIds = var1;
      return this;
   }
}
