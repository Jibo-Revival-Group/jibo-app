import React, {useEffect, useRef} from 'react';
import {Animated, Easing, StyleSheet, Text, View} from 'react-native';
import {colors} from '../theme';

interface ProgressBarProps {
  step: number;
  total: number;
}

export function ProgressBar({step, total}: ProgressBarProps) {
  const pct = useRef(new Animated.Value(step / total)).current;

  useEffect(() => {
    Animated.timing(pct, {
      duration: 380,
      easing: Easing.bezier(0.5, 0.1, 0.3, 1),
      toValue: step / total,
      useNativeDriver: false,
    }).start();
  }, [step, total]);

  const width = pct.interpolate({
    inputRange: [0, 1],
    outputRange: ['0%', '100%'],
  });

  return (
    <View style={styles.row}>
      <Text style={styles.label}>{String(step).padStart(2, '0')}</Text>
      <View style={styles.track}>
        <Animated.View style={[styles.fill, {width}]} />
      </View>
      <Text style={styles.total}>{String(total).padStart(2, '0')}</Text>
    </View>
  );
}

const styles = StyleSheet.create({
  row: {
    alignItems: 'center',
    flexDirection: 'row',
    gap: 10,
    paddingHorizontal: 22,
    paddingTop: 14,
  },
  label: {
    color: colors.ink4,
    fontSize: 11,
    fontWeight: '700',
    letterSpacing: 0.8,
    textTransform: 'uppercase',
  },
  track: {
    backgroundColor: colors.surface2,
    borderRadius: 99,
    flex: 1,
    height: 3,
    overflow: 'hidden',
  },
  fill: {
    backgroundColor: colors.jiboCyan,
    borderRadius: 99,
    height: '100%',
  },
  total: {
    color: colors.ink3,
    fontSize: 11,
    fontWeight: '700',
    letterSpacing: 0.8,
    textTransform: 'uppercase',
  },
});
