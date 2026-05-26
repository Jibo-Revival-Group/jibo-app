import React, {useLayoutEffect, useRef} from 'react';
import {Animated, Easing, StyleSheet} from 'react-native';

interface SlideContainerProps {
  step: number;
  dir: 1 | -1;
  children: React.ReactNode;
}

export function SlideContainer({step, dir, children}: SlideContainerProps) {
  const tx = useRef(new Animated.Value(dir === 1 ? 20 : -20)).current;
  const op = useRef(new Animated.Value(0)).current;

  useLayoutEffect(() => {
    tx.setValue(dir === 1 ? 20 : -20);
    op.setValue(0);
    Animated.parallel([
      Animated.timing(tx, {
        duration: 320,
        easing: Easing.out(Easing.cubic),
        toValue: 0,
        useNativeDriver: true,
      }),
      Animated.timing(op, {
        duration: 240,
        easing: Easing.out(Easing.quad),
        toValue: 1,
        useNativeDriver: true,
      }),
    ]).start();
  }, [step, dir, op, tx]);

  return (
    <Animated.View
      style={[styles.container, {transform: [{translateX: tx}], opacity: op}]}>
      {children}
    </Animated.View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
  },
});
