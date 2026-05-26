import React from 'react';
import {ImageSourcePropType, ScrollView, StyleSheet, View} from 'react-native';
import {Header} from '../components/Header';
import {HeroCard, HeroKind} from '../components/HeroCard';
import {PrimaryButton} from '../components/PrimaryButton';
import {ProgressBar} from '../components/ProgressBar';
import {Body, Eyebrow, Title} from '../components/Typography';
import {colors} from '../theme';

export type TipData = {
  idx: number;
  eyebrow: string;
  title: string;
  body: string;
  image: ImageSourcePropType;
  heroKind: HeroKind;
};

interface ScreenTipProps {
  data: TipData;
  step: number;
  total: number;
  onNext: () => void;
  onBack: () => void;
  onSkip?: () => void;
}

export function ScreenTip({data, step, total, onNext, onBack, onSkip}: ScreenTipProps) {
  return (
    <View style={styles.screen}>
      <Header onBack={onBack} onSkip={onSkip} />
      <ProgressBar step={step} total={total} />

      <ScrollView
        contentContainerStyle={styles.content}
        keyboardShouldPersistTaps="handled"
        showsVerticalScrollIndicator={false}>
        <HeroCard source={data.image} kind={data.heroKind} />
        <View style={styles.copy}>
          <Eyebrow>{`Tip ${String(data.idx).padStart(2, '0')} · ${data.eyebrow}`}</Eyebrow>
          <Title>{data.title}</Title>
          <Body>{data.body}</Body>
        </View>
      </ScrollView>

      <View style={styles.footer}>
        <PrimaryButton onPress={onNext}>Continue  ›</PrimaryButton>
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
    paddingHorizontal: 22,
    paddingTop: 20,
    paddingBottom: 16,
  },
  copy: {
    marginTop: 22,
  },
  footer: {
    padding: 22,
    paddingBottom: 32,
  },
});
