package com.facebook.appevents;

enum FlushReason {
   EAGER_FLUSHING_EVENT,
   EVENT_THRESHOLD,
   EXPLICIT,
   PERSISTED_EVENTS,
   SESSION_CHANGE,
   TIMER;

   private static final FlushReason[] $VALUES = new FlushReason[]{
      FlushReason.EXPLICIT,
      FlushReason.TIMER,
      FlushReason.SESSION_CHANGE,
      FlushReason.PERSISTED_EVENTS,
      FlushReason.EVENT_THRESHOLD,
      FlushReason.EAGER_FLUSHING_EVENT
   };
}
