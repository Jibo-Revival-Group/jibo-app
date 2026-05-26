/**
 * @format
 */

import React from 'react';
import ReactTestRenderer from 'react-test-renderer';
import App from '../App';
import {createJiboWifiQrData, parseJiboWifiQrData} from '../src/wifiQr';

jest.mock('react-native-qrcode-svg', () => 'QRCode');

test('renders correctly', async () => {
  await ReactTestRenderer.act(() => {
    ReactTestRenderer.create(<App />);
  });
});

test('creates Jibo compatible WiFi QR payloads', () => {
  const payload = createJiboWifiQrData({
    ssid: 'Revival Lab',
    password: 'JiboLives',
    staticSettings: {
      staticIP: '192.168.1.42',
      netmask: '255.255.255.0',
      gateway: '192.168.1.1',
      dns1: '1.1.1.1',
      dns2: '8.8.8.8',
    },
  });

  expect(payload.startsWith('1/1\n')).toBe(true);
  expect(parseJiboWifiQrData(payload)).toEqual({
    ssid: 'Revival Lab',
    pswd: 'JiboLives',
    security: 'WPA-PSK',
    hidden: 0,
    networkType: 1,
    staticSettings: {
      staticIP: '192.168.1.42',
      netmask: '255.255.255.0',
      gateway: '192.168.1.1',
      dns1: '1.1.1.1',
      dns2: '8.8.8.8',
    },
  });
});
