import React from 'react';
import {Image, StyleSheet, Text, View} from 'react-native';
import {Header} from '../components/Header';
import {PrimaryButton} from '../components/PrimaryButton';
import {Body, Eyebrow, Title} from '../components/Typography';
import {colors} from '../theme';

const welcomeJibo = require('../assets/media/welcome_jibo.png');

interface ScreenWelcomeProps {
  onNext: () => void;
}

export function ScreenWelcome({onNext}: ScreenWelcomeProps) {
  return (
    <View style={styles.screen}>
      <Header />

      <View style={styles.heroArea}>
        <View style={styles.halo} />
        <Image
          source={welcomeJibo}
          style={styles.hero}
          resizeMode="contain"
        />
      </View>

      <View style={styles.copy}>
        <Eyebrow>Hello again</Eyebrow>
        <Title>{"Let's wake\nJibo up."}</Title>
        <Body>
          {"We'll walk you through five quick steps and generate the WiFi QR code Jibo needs to come back online."}
        </Body>

        <View style={styles.meta}>
          <View style={styles.metaDot} />
          <Text style={styles.metaText}>About 2 minutes · Power + WiFi</Text>
        </View>
      </View>

      <View style={styles.footer}>
        <PrimaryButton onPress={onNext}>Begin setup  ›</PrimaryButton>
      </View>
    </View>
  );
}

const styles = StyleSheet.create({
  screen: {
    backgroundColor: colors.bg,
    flex: 1,
  },
  heroArea: {
    alignItems: 'center',
    flex: 1,
    justifyContent: 'center',
    position: 'relative',
  },
  halo: {
    backgroundColor: colors.jiboCyanSoft,
    borderRadius: 999,
    height: 260,
    position: 'absolute',
    width: 260,
  },
  hero: {
    height: 260,
    width: 260,
  },
  copy: {
    paddingBottom: 8,
    paddingHorizontal: 22,
  },
  meta: {
    alignItems: 'center',
    flexDirection: 'row',
    gap: 6,
    marginTop: 14,
  },
  metaDot: {
    backgroundColor: colors.jiboCyan,
    borderRadius: 99,
    height: 6,
    width: 6,
  },
  metaText: {
    color: colors.ink3,
    fontSize: 15,
    lineHeight: 23,
  },
  footer: {
    padding: 22,
    paddingBottom: 32,
  },
});
