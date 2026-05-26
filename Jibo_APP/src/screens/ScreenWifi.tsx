import React, {useState} from 'react';
import {
  KeyboardAvoidingView,
  Platform,
  Pressable,
  ScrollView,
  StyleSheet,
  Switch,
  Text,
  TextInput,
  View,
} from 'react-native';
import {Header} from '../components/Header';
import {PrimaryButton} from '../components/PrimaryButton';
import {ProgressBar} from '../components/ProgressBar';
import {Body, Eyebrow, Title} from '../components/Typography';
import {colors, radius, spacing} from '../theme';

interface ScreenWifiProps {
  canContinue: boolean;
  dns1: string;
  dns2: string;
  gateway: string;
  netmask: string;
  onBack: () => void;
  onNext: () => void;
  password: string;
  setDns1: (v: string) => void;
  setDns2: (v: string) => void;
  setGateway: (v: string) => void;
  setNetmask: (v: string) => void;
  setPassword: (v: string) => void;
  setShowPassword: (v: boolean) => void;
  setSsid: (v: string) => void;
  setStaticIP: (v: string) => void;
  setUseStaticIp: (v: boolean) => void;
  showPassword: boolean;
  ssid: string;
  staticIP: string;
  step: number;
  total: number;
  useStaticIp: boolean;
}

export function ScreenWifi({
  canContinue,
  dns1,
  dns2,
  gateway,
  netmask,
  onBack,
  onNext,
  password,
  setDns1,
  setDns2,
  setGateway,
  setNetmask,
  setPassword,
  setShowPassword,
  setSsid,
  setStaticIP,
  setUseStaticIp,
  showPassword,
  ssid,
  staticIP,
  step,
  total,
  useStaticIp,
}: ScreenWifiProps) {
  const [focusedField, setFocusedField] = useState<string | null>(null);

  return (
    <KeyboardAvoidingView
      behavior={Platform.OS === 'ios' ? 'padding' : undefined}
      style={styles.kav}>
      <View style={styles.screen}>
        <Header onBack={onBack} />
        <ProgressBar step={step} total={total} />

        <ScrollView
          contentContainerStyle={styles.content}
          keyboardShouldPersistTaps="handled"
          showsVerticalScrollIndicator={false}>
          <Eyebrow>WiFi setup</Eyebrow>
          <Title>{"Tell us about\nyour network."}</Title>
          <Body>
            {"Type the network name and password Jibo should use. Leave the password empty for open networks."}
          </Body>

          <View style={styles.fields}>
            <Field
              focusKey="ssid"
              focusedField={focusedField}
              label="Network name (SSID)"
              onBlur={() => setFocusedField(null)}
              onChangeText={setSsid}
              onFocus={() => setFocusedField('ssid')}
              placeholder="JiboNet"
              value={ssid}
            />

            {/5g(hz)?/i.test(ssid) && (
              <View style={styles.warningBox}>
                <View style={styles.warningIcon}>
                  <Text style={styles.warningIconText}>⚠️</Text>
                </View>
                <View style={styles.warningBody}>
                  <Text style={styles.warningTitle}>5 GHz Network Detected</Text>
                  <Text style={styles.warningText}>
                    Jibo only connects to 2.4 GHz networks. If this SSID is dual-band, make sure it broadcasts on 2.4 GHz, or select a different network.
                  </Text>
                </View>
              </View>
            )}

            <Field
              focusKey="pw"
              focusedField={focusedField}
              label="Password"
              hint="Leave empty for open networks."
              onBlur={() => setFocusedField(null)}
              onChangeText={setPassword}
              onFocus={() => setFocusedField('pw')}
              placeholder="••••••••"
              secureTextEntry={!showPassword}
              value={password}
              error={
                password.length > 0 && password.length < 8
                  ? 'Password must be at least 8 characters for WPA security.'
                  : undefined
              }
              rightAction={
                <Pressable
                  accessibilityRole="button"
                  onPress={() => setShowPassword(!showPassword)}
                  style={styles.showHide}>
                  <Text style={styles.showHideText}>
                    {showPassword ? 'Hide' : 'Show'}
                  </Text>
                </Pressable>
              }
            />

            <View style={styles.staticRow}>
              <View style={styles.staticCopy}>
                <Text style={styles.staticTitle}>Static IP</Text>
                <Text style={styles.staticSub}>Use manual gateway, netmask &amp; DNS</Text>
              </View>
              <Switch
                ios_backgroundColor={colors.line}
                onValueChange={setUseStaticIp}
                thumbColor={colors.white}
                trackColor={{false: colors.line, true: colors.jiboCyan}}
                value={useStaticIp}
              />
            </View>

            {useStaticIp && (
              <View style={styles.staticGrid}>
                {[
                  {label: 'IP address', value: staticIP, onChangeText: setStaticIP, placeholder: '192.168.1.100', focusKey: 'ip'},
                  {label: 'Netmask', value: netmask, onChangeText: setNetmask, placeholder: '255.255.255.0', focusKey: 'mask'},
                  {label: 'Gateway', value: gateway, onChangeText: setGateway, placeholder: '192.168.1.1', focusKey: 'gw'},
                  {label: 'DNS 1', value: dns1, onChangeText: setDns1, placeholder: '8.8.8.8', focusKey: 'dns1'},
                  {label: 'DNS 2', value: dns2, onChangeText: setDns2, placeholder: '8.8.4.4', focusKey: 'dns2'},
                ].map(f => (
                  <Field
                    key={f.focusKey}
                    focusKey={f.focusKey}
                    focusedField={focusedField}
                    label={f.label}
                    onBlur={() => setFocusedField(null)}
                    onChangeText={f.onChangeText}
                    onFocus={() => setFocusedField(f.focusKey)}
                    placeholder={f.placeholder}
                    value={f.value}
                  />
                ))}
              </View>
            )}
          </View>
        </ScrollView>

        <View style={styles.footer}>
          <PrimaryButton
            disabled={!canContinue}
            onPress={canContinue ? onNext : undefined}>
            Generate QR code  ›
          </PrimaryButton>
        </View>
      </View>
    </KeyboardAvoidingView>
  );
}

function Field({
  focusKey,
  focusedField,
  hint,
  label,
  onBlur,
  onChangeText,
  onFocus,
  placeholder,
  rightAction,
  secureTextEntry,
  value,
  error,
}: {
  focusKey: string;
  focusedField: string | null;
  hint?: string;
  label: string;
  onBlur: () => void;
  onChangeText: (v: string) => void;
  onFocus: () => void;
  placeholder: string;
  rightAction?: React.ReactNode;
  secureTextEntry?: boolean;
  value: string;
  error?: string;
}) {
  const focused = focusedField === focusKey;
  return (
    <View style={styles.fieldWrap}>
      <Text style={styles.fieldLabel}>{label}</Text>
      <View
        style={[
          styles.inputShell,
          focused && styles.inputShellFocused,
          error ? styles.inputShellError : null,
        ]}>
        <TextInput
          autoCapitalize="none"
          autoCorrect={false}
          onBlur={onBlur}
          onChangeText={onChangeText}
          onFocus={onFocus}
          placeholder={placeholder}
          placeholderTextColor={colors.ink4}
          secureTextEntry={secureTextEntry}
          style={styles.input}
          value={value}
        />
        {rightAction}
      </View>
      {error ? (
        <Text style={styles.fieldError}>{error}</Text>
      ) : hint ? (
        <Text style={styles.fieldHint}>{hint}</Text>
      ) : null}
    </View>
  );
}

const styles = StyleSheet.create({
  kav: {
    flex: 1,
  },
  screen: {
    backgroundColor: colors.bg,
    flex: 1,
  },
  content: {
    paddingBottom: 16,
    paddingHorizontal: 22,
    paddingTop: 20,
  },
  fields: {
    gap: spacing.lg,
    marginTop: spacing.xl,
  },
  fieldWrap: {
    gap: 6,
  },
  fieldLabel: {
    color: colors.ink2,
    fontSize: 12,
    fontWeight: '700',
    letterSpacing: 0.2,
  },
  inputShell: {
    alignItems: 'center',
    backgroundColor: colors.surface,
    borderColor: colors.line,
    borderRadius: 14,
    borderWidth: 1.5,
    flexDirection: 'row',
    height: 50,
    paddingHorizontal: 14,
  },
  inputShellFocused: {
    borderColor: colors.jiboCyan,
  },
  inputShellError: {
    borderColor: colors.danger,
  },
  input: {
    color: colors.ink,
    flex: 1,
    fontSize: 15,
    fontWeight: '500',
  },
  fieldHint: {
    color: colors.ink4,
    fontSize: 11.5,
  },
  fieldError: {
    color: colors.danger,
    fontSize: 11.5,
    fontWeight: '600',
  },
  warningBox: {
    alignItems: 'flex-start',
    backgroundColor: '#FFFBEB',
    borderColor: '#FEF3C7',
    borderRadius: 16,
    borderWidth: 1,
    flexDirection: 'row',
    gap: 12,
    marginTop: 4,
    padding: 14,
  },
  warningIcon: {
    alignItems: 'center',
    backgroundColor: '#FEF3C7',
    borderRadius: 8,
    height: 28,
    justifyContent: 'center',
    width: 28,
  },
  warningIconText: {
    fontSize: 14,
  },
  warningBody: {
    flex: 1,
  },
  warningTitle: {
    color: '#92400E',
    fontSize: 13,
    fontWeight: '700',
  },
  warningText: {
    color: '#B45309',
    fontSize: 12,
    lineHeight: 18,
    marginTop: 2,
  },
  showHide: {
    paddingHorizontal: 8,
    paddingVertical: 8,
  },
  showHideText: {
    color: colors.jiboCyanDeep,
    fontSize: 12,
    fontWeight: '700',
  },
  staticRow: {
    alignItems: 'center',
    backgroundColor: colors.surface2,
    borderRadius: 16,
    flexDirection: 'row',
    gap: 12,
    padding: 14,
  },
  staticCopy: {
    flex: 1,
  },
  staticTitle: {
    color: colors.ink,
    fontSize: 14,
    fontWeight: '700',
  },
  staticSub: {
    color: colors.ink3,
    fontSize: 12,
    marginTop: 2,
  },
  staticGrid: {
    gap: spacing.lg,
  },
  footer: {
    padding: 22,
    paddingBottom: 32,
  },
});
