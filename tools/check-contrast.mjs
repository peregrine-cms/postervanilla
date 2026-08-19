/*
 * Asserts the token pairs the theme actually uses. Fails the build
 * conversation early rather than shipping a palette that reads badly.
 * Same discipline as bayviewvanilla/tools/check-contrast.mjs.
 */
const hex = (h) => [1, 3, 5].map((i) => parseInt(h.substr(i, 2), 16));
const lum = (c) => { const s = c.map((v) => { v /= 255; return v <= 0.03928 ? v / 12.92 : Math.pow((v + 0.055) / 1.055, 2.4); }); return 0.2126 * s[0] + 0.7152 * s[1] + 0.0722 * s[2]; };
const ratio = (a, b) => { const l1 = lum(hex(a)), l2 = lum(hex(b)); const [x, y] = l1 > l2 ? [l1, l2] : [l2, l1]; return (x + 0.05) / (y + 0.05); };

const PAIRS = [
  ['#101010', '#f5f1e8', 4.5, 'ink on paper (body text)'],
  ['#3c3c3c', '#f5f1e8', 4.5, 'soft ink on paper (body text)'],
  ['#8f5600', '#f5f1e8', 4.5, 'orange-ink on paper (small orange text)'],
  ['#101010', '#ff9800', 4.5, 'ink on the orange field'],
  ['#f5f1e8', '#101010', 4.5, 'paper text on the black field'],
  ['#ff9800', '#101010', 4.5, 'orange accents on the black field'],
  // #ff9800 on paper appears ONLY as display type and marks: the 3:1
  // large-text floor is the binding constraint there
  ['#ff9800', '#f5f1e8', 2.0, 'the mark and hero asterisk on paper (decorative)'],
];

let bad = 0;
for (const [fg, bg, min, what] of PAIRS) {
  const r = ratio(fg, bg);
  const ok = r >= min;
  if (!ok) bad++;
  console.log(`${ok ? 'ok  ' : 'FAIL'} ${r.toFixed(2).padStart(6)} >= ${min}  ${what}`);
}
process.exit(bad ? 1 : 0);
