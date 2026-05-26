export type StaticWifiSettings = {
  staticIP: string;
  netmask: string;
  gateway: string;
  dns1: string;
  dns2: string;
};

export type WifiForm = {
  ssid: string;
  password: string;
  staticSettings?: StaticWifiSettings | null;
};

export type JiboWifiConfig = {
  ssid: string;
  pswd: string;
  security: 'WPA-PSK' | 'NONE';
  hidden: 0;
  networkType: 0 | 1;
  staticSettings: StaticWifiSettings | null;
};

const ACCESS_TOKEN = 'JiboLivesSo';
const QR_KEY =
  'Wow, you cracked our secret code. Impressive. Maybe you should check out jibo.com/jobs.';

function xorString(value: string, key: string) {
  let result = '';

  for (let index = 0; index < value.length; index += 1) {
    result += String.fromCharCode(
      // Jibo's original QR payload uses character-wise XOR with this key.
      // eslint-disable-next-line no-bitwise
      key.charCodeAt(index % key.length) ^ value.charCodeAt(index),
    );
  }

  return result;
}

export function createJiboWifiQrData(form: WifiForm) {
  const staticSettings = form.staticSettings;
  const barcodeData = [
    form.ssid.trim(),
    form.password,
    staticSettings?.staticIP.trim() ?? '',
    staticSettings?.netmask.trim() ?? '',
    staticSettings?.gateway.trim() ?? '',
    staticSettings?.dns1.trim() ?? '',
    staticSettings?.dns2.trim() ?? '',
    ACCESS_TOKEN,
  ].join('\n');

  return `1/1\n${xorString(barcodeData, QR_KEY)}`;
}

export function parseJiboWifiQrData(barcode: string): JiboWifiConfig {
  const metaEnd = barcode.indexOf('\n');

  if (metaEnd < 0) {
    throw new Error('Invalid Jibo QR payload');
  }

  const [codeId, totalCodes] = barcode
    .substring(0, metaEnd)
    .split('/')
    .map(part => Number.parseInt(part, 10));

  if (codeId <= 0 || totalCodes <= 0) {
    throw new Error('Invalid Jibo QR metadata');
  }

  const decoded = xorString(barcode.substring(metaEnd + 1), QR_KEY);
  const barcodeData = decoded.split('\n');
  barcodeData.pop();

  const [ssid, password, staticIP, netmask, gateway, dns1, dns2] = barcodeData;
  const staticSettings = staticIP
    ? {
        staticIP,
        gateway,
        netmask,
        dns1: dns1 || '8.8.8.8',
        dns2: dns2 || '8.8.4.4',
      }
    : null;

  return {
    ssid,
    pswd: password,
    security: password && password.length > 0 ? 'WPA-PSK' : 'NONE',
    hidden: 0,
    networkType: staticSettings ? 1 : 0,
    staticSettings,
  };
}
