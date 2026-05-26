import React from 'react';
import {Pressable, StyleSheet, Text} from 'react-native';
import {colors, radius} from '../theme';

interface PrimaryButtonProps {
  children: React.ReactNode;
  onPress?: () => void;
  disabled?: boolean;
}

export function PrimaryButton({children, onPress, disabled}: PrimaryButtonProps) {
  return (
    <Pressable
      accessibilityRole="button"
      onPress={disabled ? undefined : onPress}
      style={({pressed}) => [
        styles.btn,
        disabled && styles.btnDisabled,
        pressed && !disabled && styles.btnPressed,
      ]}>
      <Text style={[styles.label, disabled && styles.labelDisabled]}>{children}</Text>
    </Pressable>
  );
}

const styles = StyleSheet.create({
  btn: {
    alignItems: 'center',
    backgroundColor: colors.jiboCyan,
    borderRadius: radius.btn,
    height: 56,
    justifyContent: 'center',
    shadowColor: colors.jiboCyan,
    shadowOffset: {width: 0, height: 8},
    shadowOpacity: 0.32,
    shadowRadius: 16,
    elevation: 6,
  },
  btnDisabled: {
    backgroundColor: colors.jiboCyanSoft,
    shadowOpacity: 0,
    elevation: 0,
  },
  btnPressed: {
    opacity: 0.82,
    shadowOpacity: 0.18,
    transform: [{translateY: 1}],
  },
  label: {
    color: colors.ink,
    fontSize: 16,
    fontWeight: '700',
    letterSpacing: -0.1,
  },
  labelDisabled: {
    color: colors.ink4,
  },
});
