# Jibo Revival

React Native app for the Jibo Revival Group setup flow. The app guides users through quick setup tips and generates the Jibo-compatible WiFi QR payload from a manually entered SSID and password.

## Stack

- Expo SDK 55
- React Native 0.83
- React 19
- TypeScript
- `react-native-qrcode-svg` for QR rendering
- Jest + Expo preset for tests
- ESLint with Expo config

## Install

```sh
npm install
```

## Start With Expo Go

Expo Go is the default development path for UI work, onboarding, layout, QR rendering, and general app iteration:

```sh
npm start
```

Then scan the QR code with Expo Go.

If you want to use the iOS Simulator, start Expo first and press `i` from the terminal. If Xcode has a stale simulator selected, open Simulator manually and choose any available iPhone device before pressing `i`.

## Development Build Fallback

If Expo Go fails because of SDK or native dependency compatibility, use a development build instead. This creates a local app binary with the native runtime this project expects:

```sh
npx expo install expo-dev-client
npx expo run:ios
```

For Android:

```sh
npx expo install expo-dev-client
npx expo run:android
```

After the development build is installed on the simulator or device, start Metro for that build:

```sh
npx expo start --dev-client
```

Then open the installed Jibo Revival development app, not Expo Go.

## Scripts

```sh
npm start        # Start Expo dev server
npm run ios      # Start Expo Go mode; press i to open iOS Simulator
npm run android  # Start Expo and open Android target
npm run web      # Start Expo web
npm run typecheck
npm run lint
npm test -- --runInBand
```

## Validation

Before handing off changes, run:

```sh
npm run typecheck
npm run lint
npm test -- --runInBand
npx expo-doctor
```

## Notes

- WiFi details are entered manually: SSID first, password second.
- The app does not scan nearby networks or verify WiFi passwords.
- The QR payload logic lives in `src/wifiQr.ts`.
