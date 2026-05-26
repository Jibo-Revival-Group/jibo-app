import React from 'react';
import {Image, Pressable, StyleSheet, Text, View} from 'react-native';
import {colors} from '../theme';

const logo = require('../assets/media/jibo_logo.png');

interface HeaderProps {
  onBack?: () => void;
  onSkip?: () => void;
}

export function Header({onBack, onSkip}: HeaderProps) {
  return (
    <View style={styles.row}>
      <View style={styles.slot}>
        {onBack ? (
          <Pressable
            onPress={onBack}
            style={({pressed}) => [styles.backBtn, pressed && styles.backBtnPressed]}
            accessibilityLabel="Back"
            accessibilityRole="button"
            hitSlop={8}>
            <Text style={styles.backGlyph}>‹</Text>
          </Pressable>
        ) : null}
      </View>

      <Image source={logo} style={styles.logo} resizeMode="contain" />

      <View style={[styles.slot, styles.slotRight]}>
        {onSkip ? (
          <Pressable onPress={onSkip} hitSlop={8} accessibilityRole="button">
            <Text style={styles.skip}>Skip</Text>
          </Pressable>
        ) : null}
      </View>
    </View>
  );
}

const styles = StyleSheet.create({
  row: {
    alignItems: 'center',
    flexDirection: 'row',
    height: 44,
    justifyContent: 'space-between',
    paddingHorizontal: 18,
  },
  slot: {
    width: 44,
  },
  slotRight: {
    alignItems: 'flex-end',
  },
  logo: {
    height: 22,
    width: 56,
  },
  backBtn: {
    alignItems: 'center',
    backgroundColor: colors.surface2,
    borderRadius: 12,
    height: 38,
    justifyContent: 'center',
    width: 38,
  },
  backBtnPressed: {
    opacity: 0.6,
  },
  backGlyph: {
    color: colors.ink2,
    fontSize: 26,
    lineHeight: 30,
    marginTop: -2,
  },
  skip: {
    color: colors.ink3,
    fontSize: 13,
    fontWeight: '600',
  },
});
