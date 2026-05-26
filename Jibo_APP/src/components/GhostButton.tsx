import React from 'react';
import {Pressable, StyleSheet, Text} from 'react-native';
import {colors} from '../theme';

interface GhostButtonProps {
  children: React.ReactNode;
  onPress?: () => void;
}

export function GhostButton({children, onPress}: GhostButtonProps) {
  return (
    <Pressable
      accessibilityRole="button"
      onPress={onPress}
      style={({pressed}) => [styles.btn, pressed && styles.btnPressed]}>
      <Text style={styles.label}>{children}</Text>
    </Pressable>
  );
}

const styles = StyleSheet.create({
  btn: {
    alignItems: 'center',
    paddingVertical: 10,
  },
  btnPressed: {
    opacity: 0.6,
  },
  label: {
    color: colors.ink3,
    fontSize: 13,
    fontWeight: '600',
  },
});
