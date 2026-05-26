import React from 'react';
import {Image, ImageSourcePropType, StyleSheet, View} from 'react-native';
import {colors, radius} from '../theme';

function heroImageKey(source: ImageSourcePropType): string {
  const resolved = Image.resolveAssetSource(source);
  return resolved?.uri ?? JSON.stringify(source);
}

export type HeroKind =
  | 'wash'
  | 'plain'
  | 'photo'
  | 'photoContain'
  | 'dark'
  | 'transparent';

interface HeroCardProps {
  source: ImageSourcePropType;
  kind?: HeroKind;
}

export function HeroCard({source, kind = 'wash'}: HeroCardProps) {
  const bg = {
    wash: colors.jiboCyanWash,
    plain: colors.surface2,
    photo: colors.ink,
    photoContain: colors.surface,
    dark: '#0E1116',
    transparent: 'transparent',
  }[kind];

  const isPhoto = kind === 'photo' || kind === 'photoContain';

  return (
    <View style={[styles.card, {backgroundColor: bg}]}>
      {kind === 'wash' && <View style={styles.halo} />}
      <Image
        key={heroImageKey(source)}
        fadeDuration={0}
        source={source}
        style={
          kind === 'photoContain'
            ? styles.photoContain
            : isPhoto
              ? styles.photo
              : styles.illust
        }
        resizeMode={kind === 'photo' ? 'cover' : 'contain'}
      />
    </View>
  );
}

const styles = StyleSheet.create({
  card: {
    alignItems: 'center',
    aspectRatio: 1.15,
    borderRadius: radius.card,
    justifyContent: 'center',
    overflow: 'hidden',
    width: '100%',
  },
  halo: {
    backgroundColor: colors.jiboCyanSoft,
    borderRadius: 999,
    bottom: '-10%',
    left: '10%',
    opacity: 0.6,
    position: 'absolute',
    right: '10%',
    top: '10%',
  },
  illust: {
    height: '78%',
    width: '78%',
  },
  photo: {
    height: '100%',
    width: '100%',
  },
  photoContain: {
    height: '88%',
    width: '88%',
  },
});
