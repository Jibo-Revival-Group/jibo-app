package com.facebook;

public enum LoggingBehavior {
   APP_EVENTS,
   CACHE,
   DEVELOPER_ERRORS,
   GRAPH_API_DEBUG_INFO,
   GRAPH_API_DEBUG_WARNING,
   INCLUDE_ACCESS_TOKENS,
   INCLUDE_RAW_RESPONSES,
   REQUESTS;

   private static final LoggingBehavior[] $VALUES = new LoggingBehavior[]{
      LoggingBehavior.REQUESTS,
      LoggingBehavior.INCLUDE_ACCESS_TOKENS,
      LoggingBehavior.INCLUDE_RAW_RESPONSES,
      LoggingBehavior.CACHE,
      LoggingBehavior.APP_EVENTS,
      LoggingBehavior.DEVELOPER_ERRORS,
      LoggingBehavior.GRAPH_API_DEBUG_WARNING,
      LoggingBehavior.GRAPH_API_DEBUG_INFO
   };
}
