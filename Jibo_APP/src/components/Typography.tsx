import React from 'react';
import {StyleSheet, Text} from 'react-native';
import {colors} from '../theme';

export function Eyebrow({children}: {children: React.ReactNode}) {
  return <Text style={styles.eyebrow}>{children}</Text>;
}

export function Title({children}: {children: React.ReactNode}) {
  return <Text style={styles.title}>{children}</Text>;
}

export function Body({children}: {children: React.ReactNode}) {
  return <Text style={styles.body}>{children}</Text>;
}

const styles = StyleSheet.create({
  eyebrow: {
    color: colors.jiboCyanDeep,
    fontSize: 11,
    fontWeight: '700',
    letterSpacing: 1.4,
    marginBottom: 8,
    textTransform: 'uppercase',
  },
  title: {
    color: colors.ink,
    fontSize: 34,
    fontWeight: '800',
    letterSpacing: -0.5,
    lineHeight: 40,
  },
  body: {
    color: colors.ink3,
    fontSize: 15,
    lineHeight: 23,
    marginTop: 12,
  },
});
