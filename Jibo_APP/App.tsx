import React, {useMemo, useState} from 'react';
import {SafeAreaProvider, SafeAreaView} from 'react-native-safe-area-context';
import {StatusBar} from 'expo-status-bar';
import {StyleSheet, View} from 'react-native';

import {SlideContainer} from './src/components/SlideContainer';
import {ScreenWelcome} from './src/screens/ScreenWelcome';
import {ScreenTip, TipData} from './src/screens/ScreenTip';
import {ScreenWifi} from './src/screens/ScreenWifi';
import {ScreenQR} from './src/screens/ScreenQR';
import {ScreenSuccess} from './src/screens/ScreenSuccess';
import {createJiboWifiQrData} from './src/wifiQr';
import {colors} from './src/theme';
import {HeroKind} from './src/components/HeroCard';

const TIPS: TipData[] = [
  {
    idx: 1,
    eyebrow: 'Power',
    title: 'Plug Jibo into a steady outlet.',
    body: "Use the included power cable and place him on a flat, dry surface.",
    image: require('./src/assets/media/img_setup_plugin.png'),
    heroKind: 'transparent' as HeroKind,
  },
  {
    idx: 2,
    eyebrow: 'Battery',
    title: 'He has a battery — but plug him in for setup.',
    body: "You can move him later, but the setup is much smoother while he's tethered to power.",
    image: require('./src/assets/media/new_tips_4_5.png'),
    heroKind: 'plain' as HeroKind,
  },
  {
    idx: 3,
    eyebrow: 'Hand-off',
    title: "Next, you'll show Jibo a WiFi QR code.",
    body: "You'll enter your network details, the app generates a code, and Jibo reads it from the screen.",
    image: require('./src/assets/media/new_tips_4_6.jpg'),
    heroKind: 'photoContain' as HeroKind,
  },
];

// Steps: 0=welcome, then tips, WiFi, QR, success.
const TIP_STEPS = TIPS.length;
const WIFI_STEP = TIP_STEPS + 1;
const QR_STEP = WIFI_STEP + 1;
const MAX_STEP = QR_STEP + 1;
const TOTAL_STEPS = TIP_STEPS + 2;

export default function App() {
  return (
    <SafeAreaProvider>
      <StatusBar style="dark" />
      <SafeAreaView style={styles.safeArea}>
        <JiboFlow />
      </SafeAreaView>
    </SafeAreaProvider>
  );
}

function JiboFlow() {
  const [step, setStep] = useState(0);
  const [dir, setDir] = useState<1 | -1>(1);

  // WiFi form state
  const [ssid, setSsid] = useState('');
  const [password, setPassword] = useState('');
  const [showPassword, setShowPassword] = useState(false);
  const [useStaticIp, setUseStaticIp] = useState(false);
  const [staticIP, setStaticIP] = useState('');
  const [netmask, setNetmask] = useState('');
  const [gateway, setGateway] = useState('');
  const [dns1, setDns1] = useState('');
  const [dns2, setDns2] = useState('');

  const qrData = useMemo(
    () =>
      ssid.trim()
        ? createJiboWifiQrData({
            ssid,
            password,
            staticSettings: useStaticIp
              ? {staticIP, netmask, gateway, dns1, dns2}
              : null,
          })
        : '',
    [ssid, password, useStaticIp, staticIP, netmask, gateway, dns1, dns2],
  );

  const go = (delta: number) => {
    setDir(delta > 0 ? 1 : -1);
    setStep(s => Math.max(0, Math.min(MAX_STEP, s + delta)));
  };

  const jumpTo = (n: number) => {
    setDir(n > step ? 1 : -1);
    setStep(n);
  };

  const renderScreen = () => {
    if (step === 0) {
      return <ScreenWelcome onNext={() => go(1)} />;
    }

    if (step >= 1 && step <= TIP_STEPS) {
      const tip = TIPS[step - 1];
      return (
        <ScreenTip
          key={`tip-${tip.idx}`}
          data={tip}
          onBack={() => go(-1)}
          onNext={() => go(1)}
          onSkip={step < TIP_STEPS ? () => jumpTo(WIFI_STEP) : undefined}
          step={step}
          total={TOTAL_STEPS}
        />
      );
    }

    if (step === WIFI_STEP) {
      return (
        <ScreenWifi
          canContinue={Boolean(ssid.trim()) && !(password.length > 0 && password.length < 8)}
          dns1={dns1}
          dns2={dns2}
          gateway={gateway}
          netmask={netmask}
          onBack={() => go(-1)}
          onNext={() => go(1)}
          password={password}
          setDns1={setDns1}
          setDns2={setDns2}
          setGateway={setGateway}
          setNetmask={setNetmask}
          setPassword={setPassword}
          setShowPassword={setShowPassword}
          setSsid={setSsid}
          setStaticIP={setStaticIP}
          setUseStaticIp={setUseStaticIp}
          showPassword={showPassword}
          ssid={ssid}
          staticIP={staticIP}
          step={WIFI_STEP}
          total={TOTAL_STEPS}
          useStaticIp={useStaticIp}
        />
      );
    }

    if (step === QR_STEP) {
      return (
        <ScreenQR
          onBack={() => go(-1)}
          onNext={() => go(1)}
          qrData={qrData}
          ssid={ssid}
          step={QR_STEP}
          total={TOTAL_STEPS}
        />
      );
    }

    return <ScreenSuccess onRestart={() => jumpTo(0)} ssid={ssid} />;
  };

  return (
    <SlideContainer dir={dir} step={step}>
      <View key={step} style={styles.step}>
        {renderScreen()}
      </View>
    </SlideContainer>
  );
}

const styles = StyleSheet.create({
  safeArea: {
    backgroundColor: colors.bg,
    flex: 1,
  },
  step: {
    flex: 1,
  },
});
