import React, {useEffect, useRef} from 'react';
import {
  Animated,
  Easing,
  ScrollView,
  StyleSheet,
  Text,
  View,
} from 'react-native';
import QRCode from 'react-native-qrcode-svg';
import {activateKeepAwake, deactivateKeepAwake} from 'expo-keep-awake';
import * as Brightness from 'expo-brightness';

import {Header} from '../components/Header';
import {PrimaryButton} from '../components/PrimaryButton';
import {ProgressBar} from '../components/ProgressBar';
import {Body, Eyebrow, Title} from '../components/Typography';
import {colors, radius} from '../theme';

const imgAvatar = require('../assets/media/img_loop_jiboavatar.png');

interface ScreenQRProps {
  onBack: () => void;
  onNext: () => void;
  qrData: string;
  ssid: string;
  step: number;
  total: number;
}

export function ScreenQR({
  onBack,
  onNext,
  qrData,
  ssid,
  step,
  total,
}: ScreenQRProps) {
  const pulse = useRef(new Animated.Value(0.5)).current;

  useEffect(() => {
    let originalBrightness = 0.5;

    try {
      activateKeepAwake();
    } catch {}

    Brightness.getBrightnessAsync()
      .then(current => {
        originalBrightness = current;
        return Brightness.setBrightnessAsync(1.0);
      })
      .catch(() => {});

    const loop = Animated.loop(
      Animated.sequence([
        Animated.timing(pulse, {
          toValue: 1.0,
          duration: 1500,
          easing: Easing.inOut(Easing.sin),
          useNativeDriver: true,
        }),
        Animated.timing(pulse, {
          toValue: 0.5,
          duration: 1500,
          easing: Easing.inOut(Easing.sin),
          useNativeDriver: true,
        }),
      ]),
    );
    loop.start();

    return () => {
      try {
        deactivateKeepAwake();
      } catch {}
      Brightness.setBrightnessAsync(originalBrightness).catch(() => {});
      loop.stop();
    };
  }, [pulse]);

  return (
    <View style={styles.screen}>
      <Header onBack={onBack} />
      <ProgressBar step={step} total={total} />

      <ScrollView
        contentContainerStyle={styles.content}
        showsVerticalScrollIndicator={false}>
        <Eyebrow>WiFi Hand-off</Eyebrow>
        <Title>{"Show this code\nto Jibo."}</Title>
        <Body>
          {"Hold the QR code flat in front of Jibo's camera so Jibo can join your WiFi network."}
        </Body>

        <View style={styles.card}>
          <View style={styles.qrWrap}>
            <Animated.View style={[styles.qrFrame, {opacity: pulse}]}>
              <CornerBrackets />
            </Animated.View>
            <View style={styles.qrContainer}>
              <QRCode
                backgroundColor={colors.surface}
                color={colors.ink}
                ecl="H"
                logo={imgAvatar}
                logoBackgroundColor={colors.white}
                logoBorderRadius={19}
                logoMargin={3}
                logoSize={38}
                size={180}
                value={qrData || 'placeholder'}
              />
            </View>
          </View>

          <View style={styles.networkRow}>
            <View style={styles.networkInfo}>
              <Text style={styles.networkLabel}>Network name</Text>
              <Text style={styles.networkName} numberOfLines={1}>
                {ssid || 'JiboNet'}
              </Text>
            </View>
          </View>
        </View>
      </ScrollView>

      <View style={styles.footer}>
        <PrimaryButton onPress={onNext}>Got it</PrimaryButton>
      </View>
    </View>
  );
}

function CornerBrackets() {
  const corners = [
    {
      key: 'topLeft',
      style: styles.cornerTopLeft,
      horizontal: styles.cornerHTop,
      vertical: styles.cornerVLeft,
    },
    {
      key: 'topRight',
      style: styles.cornerTopRight,
      horizontal: styles.cornerHTop,
      vertical: styles.cornerVRight,
    },
    {
      key: 'bottomLeft',
      style: styles.cornerBottomLeft,
      horizontal: styles.cornerHBottom,
      vertical: styles.cornerVLeft,
    },
    {
      key: 'bottomRight',
      style: styles.cornerBottomRight,
      horizontal: styles.cornerHBottom,
      vertical: styles.cornerVRight,
    },
  ] as const;

  return (
    <>
      {corners.map(corner => (
        <View key={corner.key} style={[styles.corner, corner.style]}>
          <View
            style={[
              styles.cornerBar,
              styles.cornerHorizontal,
              corner.horizontal,
            ]}
          />
          <View
            style={[styles.cornerBar, styles.cornerVertical, corner.vertical]}
          />
        </View>
      ))}
    </>
  );
}

const styles = StyleSheet.create({
  screen: {
    backgroundColor: colors.bg,
    flex: 1,
  },
  content: {
    paddingBottom: 24,
    paddingHorizontal: 22,
    paddingTop: 20,
  },
  card: {
    backgroundColor: colors.surface,
    borderRadius: radius.card,
    elevation: 4,
    marginTop: 24,
    padding: 20,
    shadowColor: colors.ink,
    shadowOffset: {width: 0, height: 10},
    shadowOpacity: 0.05,
    shadowRadius: 16,
  },
  qrWrap: {
    alignItems: 'center',
    justifyContent: 'center',
    paddingVertical: 18,
    position: 'relative',
  },
  qrFrame: {
    height: 204,
    justifyContent: 'center',
    position: 'absolute',
    width: 204,
  },
  qrContainer: {
    borderRadius: 16,
    overflow: 'hidden',
    padding: 8,
  },
  corner: {
    height: 28,
    position: 'absolute',
    width: 28,
    zIndex: 1,
  },
  cornerTopLeft: {
    left: -6,
    top: -6,
  },
  cornerTopRight: {
    right: -6,
    top: -6,
  },
  cornerBottomLeft: {
    bottom: -6,
    left: -6,
  },
  cornerBottomRight: {
    bottom: -6,
    right: -6,
  },
  cornerBar: {
    backgroundColor: colors.jiboCyan,
    borderRadius: 99,
    position: 'absolute',
  },
  cornerHorizontal: {
    height: 4,
    width: 28,
  },
  cornerVertical: {
    height: 28,
    width: 4,
  },
  cornerHTop: {
    top: 0,
  },
  cornerHBottom: {
    bottom: 0,
  },
  cornerVLeft: {
    left: 0,
  },
  cornerVRight: {
    right: 0,
  },
  networkRow: {
    borderTopColor: colors.line2,
    borderTopWidth: 1,
    marginTop: 14,
    paddingTop: 14,
  },
  networkInfo: {
    alignItems: 'center',
  },
  networkLabel: {
    color: colors.ink4,
    fontSize: 10,
    fontWeight: '700',
    letterSpacing: 0.8,
    textTransform: 'uppercase',
  },
  networkName: {
    color: colors.ink,
    fontSize: 15,
    fontWeight: '700',
    marginTop: 2,
  },
  footer: {
    padding: 22,
    paddingBottom: 32,
  },
});
