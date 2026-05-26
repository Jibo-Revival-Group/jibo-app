import React, {useEffect, useRef} from 'react';
import {Animated, Easing, Image, StyleSheet, Text, View} from 'react-native';
import {GhostButton} from '../components/GhostButton';
import {Header} from '../components/Header';
import {PrimaryButton} from '../components/PrimaryButton';
import {Body, Eyebrow, Title} from '../components/Typography';
import {colors} from '../theme';

const successJibo = require('../assets/media/jibo_all_set_up.png');

interface ScreenSuccessProps {
  onRestart: () => void;
  ssid: string;
}

export function ScreenSuccess({onRestart, ssid}: ScreenSuccessProps) {
  const ring = useRef(new Animated.Value(0)).current;
  const checkScale = useRef(new Animated.Value(0)).current;

  useEffect(() => {
    Animated.sequence([
      Animated.timing(checkScale, {
        delay: 150,
        duration: 380,
        easing: Easing.out(Easing.back(2.5)),
        toValue: 1,
        useNativeDriver: true,
      }),
    ]).start();

    Animated.loop(
      Animated.sequence([
        Animated.timing(ring, {
          duration: 2000,
          easing: Easing.inOut(Easing.sin),
          toValue: 1,
          useNativeDriver: true,
        }),
        Animated.timing(ring, {
          duration: 2000,
          easing: Easing.inOut(Easing.sin),
          toValue: 0,
          useNativeDriver: true,
        }),
      ]),
    ).start();
  }, []);

  const ringScale = ring.interpolate({inputRange: [0, 1], outputRange: [0.92, 1.08]});
  const ringOpacity = ring.interpolate({inputRange: [0, 1], outputRange: [0.4, 0.9]});

  return (
    <View style={styles.screen}>
      <Header />

      <View style={styles.content}>
        <View style={styles.heroArea}>
          <Animated.View
            style={[
              styles.halo,
              {transform: [{scale: ringScale}], opacity: ringOpacity},
            ]}
          />
          <Image source={successJibo} style={styles.hero} resizeMode="contain" />
          <Animated.View
            style={[styles.checkBadge, {transform: [{scale: checkScale}]}]}>
            <Text style={styles.checkGlyph}>✓</Text>
          </Animated.View>
        </View>

        <View style={styles.copy}>
          <Eyebrow>Connected</Eyebrow>
          <Title>{'Welcome back,\nJibo.'}</Title>
          <Body>
            {ssid ? (
              <>
                <Text style={styles.ssidHighlight}>{ssid}</Text>
                {' is connected. '}
              </>
            ) : null}
            Try saying{' '}
            <Text style={styles.emphasis}>"Hey Jibo, dance!"</Text>
          </Body>
        </View>
      </View>

      <View style={styles.footer}>
        <PrimaryButton onPress={onRestart}>Open Jibo home (coming soon)</PrimaryButton>
        <GhostButton onPress={onRestart}>Run setup again</GhostButton>
      </View>
    </View>
  );
}

const styles = StyleSheet.create({
  screen: {
    backgroundColor: colors.bg,
    flex: 1,
  },
  content: {
    alignItems: 'center',
    flex: 1,
    justifyContent: 'center',
    paddingHorizontal: 22,
  },
  heroArea: {
    alignItems: 'center',
    justifyContent: 'center',
    position: 'relative',
  },
  halo: {
    backgroundColor: colors.jiboCyanSoft,
    borderRadius: 999,
    height: 240,
    position: 'absolute',
    width: 240,
  },
  hero: {
    height: 220,
    width: 220,
  },
  checkBadge: {
    alignItems: 'center',
    backgroundColor: colors.jiboCyan,
    borderColor: colors.bg,
    borderRadius: 999,
    borderWidth: 5,
    bottom: -6,
    height: 52,
    justifyContent: 'center',
    position: 'absolute',
    right: -6,
    shadowColor: colors.jiboCyan,
    shadowOffset: {width: 0, height: 8},
    shadowOpacity: 0.45,
    shadowRadius: 14,
    elevation: 8,
    width: 52,
  },
  checkGlyph: {
    color: colors.ink,
    fontSize: 22,
    fontWeight: '900',
  },
  copy: {
    marginTop: 32,
    width: '100%',
  },
  ssidHighlight: {
    color: colors.ink,
    fontWeight: '700',
  },
  emphasis: {
    color: colors.ink,
    fontWeight: '700',
  },
  footer: {
    gap: 8,
    padding: 22,
    paddingBottom: 32,
  },
});
