package com.segment.analytics;

import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;

abstract class PayloadQueue implements Closeable {
   abstract void add(byte[] var1) throws IOException;

   abstract void forEach(PayloadQueue.ElementVisitor var1) throws IOException;

   abstract void remove(int var1) throws IOException;

   abstract int size();

   interface ElementVisitor {
      boolean read(InputStream var1, int var2) throws IOException;
   }

   static class MemoryQueue extends PayloadQueue {
      final LinkedList<byte[]> queue = new LinkedList<>();

      @Override
      void add(byte[] var1) throws IOException {
         this.queue.add(var1);
      }

      @Override
      public void close() throws IOException {
      }

      @Override
      void forEach(PayloadQueue.ElementVisitor var1) throws IOException {
         for (int var2 = 0; var2 < this.queue.size(); var2++) {
            byte[] var3 = this.queue.get(var2);
            if (!var1.read(new ByteArrayInputStream(var3), var3.length)) {
               break;
            }
         }
      }

      @Override
      void remove(int var1) throws IOException {
         for (int var2 = 0; var2 < var1; var2++) {
            this.queue.remove();
         }
      }

      @Override
      int size() {
         return this.queue.size();
      }
   }

   static class PersistentQueue extends PayloadQueue {
      final QueueFile queueFile;

      PersistentQueue(QueueFile var1) {
         this.queueFile = var1;
      }

      @Override
      void add(byte[] var1) throws IOException {
         this.queueFile.add(var1);
      }

      @Override
      public void close() throws IOException {
         this.queueFile.close();
      }

      @Override
      void forEach(PayloadQueue.ElementVisitor var1) throws IOException {
         this.queueFile.forEach(var1);
      }

      @Override
      void remove(int var1) throws IOException {
         try {
            this.queueFile.remove(var1);
         } catch (ArrayIndexOutOfBoundsException var3) {
            throw new IOException(var3);
         }
      }

      @Override
      int size() {
         return this.queueFile.size();
      }
   }
}
