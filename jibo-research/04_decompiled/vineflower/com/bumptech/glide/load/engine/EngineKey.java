package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

class EngineKey implements Key {
   private final ResourceDecoder cacheDecoder;
   private final ResourceDecoder decoder;
   private final ResourceEncoder encoder;
   private int hashCode;
   private final int height;
   private final String id;
   private Key originalKey;
   private final Key signature;
   private final Encoder sourceEncoder;
   private String stringKey;
   private final ResourceTranscoder transcoder;
   private final Transformation transformation;
   private final int width;

   public EngineKey(
      String var1,
      Key var2,
      int var3,
      int var4,
      ResourceDecoder var5,
      ResourceDecoder var6,
      Transformation var7,
      ResourceEncoder var8,
      ResourceTranscoder var9,
      Encoder var10
   ) {
      this.id = var1;
      this.signature = var2;
      this.width = var3;
      this.height = var4;
      this.cacheDecoder = var5;
      this.decoder = var6;
      this.transformation = var7;
      this.encoder = var8;
      this.transcoder = var9;
      this.sourceEncoder = var10;
   }

   @Override
   public boolean equals(Object var1) {
      boolean var5 = false;
      boolean var4;
      if (this == var1) {
         var4 = true;
      } else {
         var4 = var5;
         if (var1 != null) {
            var4 = var5;
            if (this.getClass() == var1.getClass()) {
               var1 = var1;
               var4 = var5;
               if (this.id.equals(var1.id)) {
                  var4 = var5;
                  if (this.signature.equals(var1.signature)) {
                     var4 = var5;
                     if (this.height == var1.height) {
                        var4 = var5;
                        if (this.width == var1.width) {
                           boolean var2;
                           if (this.transformation == null) {
                              var2 = true;
                           } else {
                              var2 = false;
                           }

                           boolean var3;
                           if (var1.transformation == null) {
                              var3 = true;
                           } else {
                              var3 = false;
                           }

                           var4 = var5;
                           if (!(var2 ^ var3)) {
                              if (this.transformation != null) {
                                 var4 = var5;
                                 if (!this.transformation.getId().equals(var1.transformation.getId())) {
                                    return var4;
                                 }
                              }

                              if (this.decoder == null) {
                                 var2 = true;
                              } else {
                                 var2 = false;
                              }

                              if (var1.decoder == null) {
                                 var3 = true;
                              } else {
                                 var3 = false;
                              }

                              var4 = var5;
                              if (!(var2 ^ var3)) {
                                 if (this.decoder != null) {
                                    var4 = var5;
                                    if (!this.decoder.getId().equals(var1.decoder.getId())) {
                                       return var4;
                                    }
                                 }

                                 if (this.cacheDecoder == null) {
                                    var2 = true;
                                 } else {
                                    var2 = false;
                                 }

                                 if (var1.cacheDecoder == null) {
                                    var3 = true;
                                 } else {
                                    var3 = false;
                                 }

                                 var4 = var5;
                                 if (!(var2 ^ var3)) {
                                    if (this.cacheDecoder != null) {
                                       var4 = var5;
                                       if (!this.cacheDecoder.getId().equals(var1.cacheDecoder.getId())) {
                                          return var4;
                                       }
                                    }

                                    if (this.encoder == null) {
                                       var2 = true;
                                    } else {
                                       var2 = false;
                                    }

                                    if (var1.encoder == null) {
                                       var3 = true;
                                    } else {
                                       var3 = false;
                                    }

                                    var4 = var5;
                                    if (!(var2 ^ var3)) {
                                       if (this.encoder != null) {
                                          var4 = var5;
                                          if (!this.encoder.getId().equals(var1.encoder.getId())) {
                                             return var4;
                                          }
                                       }

                                       if (this.transcoder == null) {
                                          var2 = true;
                                       } else {
                                          var2 = false;
                                       }

                                       if (var1.transcoder == null) {
                                          var3 = true;
                                       } else {
                                          var3 = false;
                                       }

                                       var4 = var5;
                                       if (!(var2 ^ var3)) {
                                          if (this.transcoder != null) {
                                             var4 = var5;
                                             if (!this.transcoder.getId().equals(var1.transcoder.getId())) {
                                                return var4;
                                             }
                                          }

                                          if (this.sourceEncoder == null) {
                                             var2 = true;
                                          } else {
                                             var2 = false;
                                          }

                                          if (var1.sourceEncoder == null) {
                                             var3 = true;
                                          } else {
                                             var3 = false;
                                          }

                                          var4 = var5;
                                          if (!(var2 ^ var3)) {
                                             if (this.sourceEncoder != null) {
                                                var4 = var5;
                                                if (!this.sourceEncoder.getId().equals(var1.sourceEncoder.getId())) {
                                                   return var4;
                                                }
                                             }

                                             var4 = true;
                                          }
                                       }
                                    }
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
      }

      return var4;
   }

   public Key getOriginalKey() {
      if (this.originalKey == null) {
         this.originalKey = new OriginalKey(this.id, this.signature);
      }

      return this.originalKey;
   }

   @Override
   public int hashCode() {
      byte var2 = 0;
      if (this.hashCode == 0) {
         this.hashCode = this.id.hashCode();
         this.hashCode = this.hashCode * 31 + this.signature.hashCode();
         this.hashCode = this.hashCode * 31 + this.width;
         this.hashCode = this.hashCode * 31 + this.height;
         int var3 = this.hashCode;
         int var1;
         if (this.cacheDecoder != null) {
            var1 = this.cacheDecoder.getId().hashCode();
         } else {
            var1 = 0;
         }

         this.hashCode = var1 + var3 * 31;
         var3 = this.hashCode;
         if (this.decoder != null) {
            var1 = this.decoder.getId().hashCode();
         } else {
            var1 = 0;
         }

         this.hashCode = var1 + var3 * 31;
         var3 = this.hashCode;
         if (this.transformation != null) {
            var1 = this.transformation.getId().hashCode();
         } else {
            var1 = 0;
         }

         this.hashCode = var1 + var3 * 31;
         var3 = this.hashCode;
         if (this.encoder != null) {
            var1 = this.encoder.getId().hashCode();
         } else {
            var1 = 0;
         }

         this.hashCode = var1 + var3 * 31;
         var3 = this.hashCode;
         if (this.transcoder != null) {
            var1 = this.transcoder.getId().hashCode();
         } else {
            var1 = 0;
         }

         this.hashCode = var1 + var3 * 31;
         var3 = this.hashCode;
         var1 = var2;
         if (this.sourceEncoder != null) {
            var1 = this.sourceEncoder.getId().hashCode();
         }

         this.hashCode = var3 * 31 + var1;
      }

      return this.hashCode;
   }

   @Override
   public String toString() {
      if (this.stringKey == null) {
         StringBuilder var2 = new StringBuilder()
            .append("EngineKey{")
            .append(this.id)
            .append('+')
            .append(this.signature)
            .append("+[")
            .append(this.width)
            .append('x')
            .append(this.height)
            .append("]+")
            .append('\'');
         String var1;
         if (this.cacheDecoder != null) {
            var1 = this.cacheDecoder.getId();
         } else {
            var1 = "";
         }

         var2 = var2.append(var1).append('\'').append('+').append('\'');
         if (this.decoder != null) {
            var1 = this.decoder.getId();
         } else {
            var1 = "";
         }

         var2 = var2.append(var1).append('\'').append('+').append('\'');
         if (this.transformation != null) {
            var1 = this.transformation.getId();
         } else {
            var1 = "";
         }

         var2 = var2.append(var1).append('\'').append('+').append('\'');
         if (this.encoder != null) {
            var1 = this.encoder.getId();
         } else {
            var1 = "";
         }

         var2 = var2.append(var1).append('\'').append('+').append('\'');
         if (this.transcoder != null) {
            var1 = this.transcoder.getId();
         } else {
            var1 = "";
         }

         var2 = var2.append(var1).append('\'').append('+').append('\'');
         if (this.sourceEncoder != null) {
            var1 = this.sourceEncoder.getId();
         } else {
            var1 = "";
         }

         this.stringKey = var2.append(var1).append('\'').append('}').toString();
      }

      return this.stringKey;
   }

   @Override
   public void updateDiskCacheKey(MessageDigest var1) throws UnsupportedEncodingException {
      byte[] var2 = ByteBuffer.allocate(8).putInt(this.width).putInt(this.height).array();
      this.signature.updateDiskCacheKey(var1);
      var1.update(this.id.getBytes("UTF-8"));
      var1.update(var2);
      String var3;
      if (this.cacheDecoder != null) {
         var3 = this.cacheDecoder.getId();
      } else {
         var3 = "";
      }

      var1.update(var3.getBytes("UTF-8"));
      String var4;
      if (this.decoder != null) {
         var4 = this.decoder.getId();
      } else {
         var4 = "";
      }

      var1.update(var4.getBytes("UTF-8"));
      String var5;
      if (this.transformation != null) {
         var5 = this.transformation.getId();
      } else {
         var5 = "";
      }

      var1.update(var5.getBytes("UTF-8"));
      String var6;
      if (this.encoder != null) {
         var6 = this.encoder.getId();
      } else {
         var6 = "";
      }

      var1.update(var6.getBytes("UTF-8"));
      String var7;
      if (this.sourceEncoder != null) {
         var7 = this.sourceEncoder.getId();
      } else {
         var7 = "";
      }

      var1.update(var7.getBytes("UTF-8"));
   }
}
