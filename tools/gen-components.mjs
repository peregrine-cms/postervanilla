/*
 * Generates, for every component in the SPEC below:
 *
 *   ui.apps/.../apps/peregrinevanilla/components/<name>/.content.xml   (+ sample)
 *   ui.apps/.../apps/peregrinevanilla/components/<name>/dialog.json
 *   core/src/main/java/com/peregrinevanilla/models/<Name>Model.java
 *
 * The render functions in etc/felibs/peregrinevanilla/js/components.js are hand
 * written and never touched here — same division of labour as percli-hatch3
 * in the bayviewvanilla repo, which is not available on this machine; this
 * script is the stand-in, and the SPEC is the fragments/ equivalent.
 *
 * The Sling model is the part that is not optional: PageMerge only passes a
 * component's custom properties through when a model declares them, so every
 * field the render function reads MUST appear here.
 */
import fs from 'node:fs';
import path from 'node:path';

const APPS = 'ui.apps/src/main/content/jcr_root/apps/peregrinevanilla/components';
const MODELS = 'core/src/main/java/com/peregrinevanilla/models';

const VISIBILITY = { m: 'visibility', l: 'Visibility', t: 'select', d: 'all',
  v: [['all', 'Always visible'], ['desktop', 'Desktop only (821px and up)'], ['mobile', 'Mobile only (up to 820px)']] };

/** @type {Record<string, any>} */
const SPEC = {
  header: {
    title: 'Header', group: 'Structure',
    fields: [
      { m: 'brand', l: 'Brand (wordmark text)', t: 'text' },
      { m: 'brandlink', l: 'Brand link', t: 'path' },
      { m: 'logo', l: 'Logo (mark)', t: 'path' },
      { m: 'logoalt', l: 'Logo alt text', t: 'text' },
      { m: 'navitems', l: 'Navigation items', t: 'collection', f: [
        { m: 'text', l: 'Label', t: 'text' }, { m: 'link', l: 'Link', t: 'path' }] },
      { m: 'boxtext', l: 'Boxed link label (e.g. GITHUB)', t: 'text' },
      { m: 'boxlink', l: 'Boxed link target', t: 'path' },
    ],
    sample: { brand: 'PEREGRINE', boxtext: 'GITHUB' },
  },
  hero: {
    title: 'Hero (Poster)', group: 'Content',
    fields: [
      { m: 'title', l: 'Headline (kept short - it sets at display size)', t: 'text' },
      { m: 'footnote', l: 'Footnote (the asterisk text)', t: 'text' },
      { m: 'ctatext', l: 'Primary button', t: 'text' },
      { m: 'ctalink', l: 'Primary link', t: 'path' },
      { m: 'cta2text', l: 'Secondary button', t: 'text' },
      { m: 'cta2link', l: 'Secondary link', t: 'path' },
      { m: 'image', l: 'Mark (cropped large at the right edge)', t: 'path' },
      { m: 'imagealt', l: 'Mark alt text', t: 'text' },
    ],
    sample: {
      title: 'What you edit is what you ship',
      footnote: 'literally. The editor renders your real site - the page you drag components onto is the page a visitor gets.',
      ctatext: 'Read the docs', cta2text: 'GitHub',
      image: '/content/peregrinevanilla/assets/mark.svg', imagealt: '',
    },
  },
  ticker: {
    title: 'Ticker', group: 'Blocks',
    fields: [
      { m: 'text', l: 'Ticker text (wrap a stretch in ** for orange)', t: 'text' },
      { m: 'speed', l: 'Speed', t: 'select', d: 'normal',
        v: [['slow', 'Slow'], ['normal', 'Normal'], ['fast', 'Fast']] },
    ],
    sample: { text: 'OPEN SOURCE · APACHE-2.0 · **ONE CONTAINER TO TRY IT** · CONTENT IS A REPOSITORY · ' },
  },
  band: {
    title: 'Band (Section)', group: 'Structure', container: true,
    fields: [
      { m: 'background', l: 'Background', t: 'select', d: 'paper',
        v: [['paper', 'Paper'], ['orange', 'Orange field'], ['ink', 'Black field']] },
      { m: 'bordered', l: 'Heavy rule along the bottom', t: 'switch' },
      { m: 'padding', l: 'Vertical padding', t: 'select', d: 'normal',
        v: [['normal', 'Normal'], ['compact', 'Compact'], ['roomy', 'Roomy']] },
      { m: 'contained', l: 'Contain content to the page column', t: 'switch', d: 'true' },
    ],
    sample: { background: 'paper', bordered: 'true', contained: 'true' },
  },
  blkheading: {
    title: 'Heading', group: 'Blocks',
    fields: [
      { m: 'text', l: 'Title', t: 'text' },
      { m: 'size', l: 'Size', t: 'select', d: 'band',
        v: [['display', 'Display (hero)'], ['band', 'Band (section)'], ['item', 'Item (card)']] },
      { m: 'level', l: 'Heading level', t: 'select', d: 'h2',
        v: [['h1', 'H1'], ['h2', 'H2'], ['h3', 'H3']] },
    ],
    sample: { text: 'The manual', size: 'band', level: 'h2' },
  },
  blktext: {
    title: 'Text', group: 'Blocks',
    fields: [
      { m: 'text', l: 'Text', t: 'richtext' },
      { m: 'style', l: 'Style', t: 'select', d: 'body',
        v: [['body', 'Body'], ['mono', 'Mono'], ['footnote', 'Footnote (mono, small)']] },
    ],
    sample: { text: '<p>Every screenshot in the manual comes from a passing, asserted test run against a clean install.</p>' },
  },
  blkbutton: {
    title: 'Button', group: 'Blocks',
    fields: [
      { m: 'text', l: 'Label', t: 'text' },
      { m: 'link', l: 'Link', t: 'path' },
      { m: 'style', l: 'Style', t: 'select', d: 'solid',
        v: [['solid', 'Solid (black)'], ['outline', 'Outline'], ['box', 'Orange box']] },
    ],
    sample: { text: 'Read the docs', style: 'solid' },
  },
  claims: {
    title: 'Claims (numbered)', group: 'Content',
    fields: [
      { m: 'items', l: 'Claims', t: 'collection', f: [
        { m: 'title', l: 'Claim', t: 'text' }, { m: 'text', l: 'One supporting sentence', t: 'text' }] },
    ],
    sample: {}, sampleChildren: { items: [
      { title: 'Docs that cannot lie', text: 'Every screenshot comes from a passing, asserted test run.' },
      { title: 'Everything is content', text: 'One tree, versioned, readable as JSON from anywhere.' },
      { title: 'Themes are yours', text: 'A site starts as a copy of a theme. Change what you copied.' },
    ] },
  },
  indexlist: {
    title: 'Index (giant rows)', group: 'Content',
    fields: [
      { m: 'items', l: 'Rows', t: 'collection', f: [
        { m: 'title', l: 'Title', t: 'text' }, { m: 'tag', l: 'Tag (right-hand label)', t: 'text' },
        { m: 'link', l: 'Link', t: 'path' }] },
      { m: 'startat', l: 'First number', t: 'text', d: '1' },
    ],
    sample: { startat: '1' }, sampleChildren: { items: [
      { title: 'Your first website', tag: 'START HERE' },
      { title: 'The editor', tag: 'AUTHORING' },
      { title: 'Versions and publishing', tag: 'RUNNING' },
    ] },
  },
  command: {
    title: 'Command line', group: 'Blocks',
    fields: [
      { m: 'text', l: 'The command', t: 'text' },
      { m: 'prompt', l: 'Prompt', t: 'text', d: '$' },
      { m: 'comment', l: 'Comment line under it (optional)', t: 'text' },
    ],
    sample: { text: 'docker run -p 8080:8080 peregrinecms/peregrine-cms:v2-preview', comment: 'console at /content/adminv2 once it boots' },
  },
  footer: {
    title: 'Footer', group: 'Structure',
    fields: [
      { m: 'brand', l: 'Brand', t: 'text' },
      { m: 'logo', l: 'Logo (mark)', t: 'path' },
      { m: 'lefttext', l: 'Left text (after the brand)', t: 'text' },
      { m: 'righttext', l: 'Right text', t: 'text' },
    ],
    sample: { brand: 'PEREGRINE', lefttext: 'OPEN SOURCE — APACHE-2.0', righttext: 'BUILT WITH PEREGRINE CMS' },
  },
  pagenav: {
    title: 'Page Nav (Prev/Next)', group: 'Structure',
    fields: [
      { m: 'prevtext', l: 'Previous label', t: 'text' }, { m: 'prevlink', l: 'Previous link', t: 'path' },
      { m: 'uptext', l: 'Up label', t: 'text' }, { m: 'uplink', l: 'Up link', t: 'path' },
      { m: 'nexttext', l: 'Next label', t: 'text' }, { m: 'nextlink', l: 'Next link', t: 'path' },
    ],
    sample: { uptext: 'All chapters' },
  },
};

const xml = (s) => String(s).replace(/&/g, '&amp;').replace(/</g, '&lt;').replace(/>/g, '&gt;').replace(/"/g, '&quot;');
const cap = (s) => s[0].toUpperCase() + s.slice(1);

function dialogField(f) {
  if (f.t === 'collection') {
    return { type: 'collection', multifield: true, fieldLabel: [[f.f[0].m], 'value'],
      fields: f.f.map(dialogField), placeholder: f.m, label: f.l, model: f.m };
  }
  if (f.t === 'select') {
    return { type: 'material-select', values: f.v.map(([value, name]) => ({ name, value })),
      placeholder: f.m, label: f.l, model: f.m };
  }
  if (f.t === 'switch') return { type: 'materialswitch', label: f.l, model: f.m, valueOn: 'true', valueOff: 'false' };
  if (f.t === 'richtext') return { type: 'texteditor', label: f.l, model: f.m, placeholder: f.m };
  if (f.t === 'path') return { type: 'pathbrowser', browserRoot: '/content', placeholder: f.m, label: f.l, model: f.m };
  return { type: 'input', inputType: 'text', placeholder: f.m, label: f.l, model: f.m };
}

function modelJava(name, spec) {
  const cls = cap(name) + 'Model';
  const parent = spec.container ? 'Container' : 'AbstractComponent';
  const fields = [...spec.fields, VISIBILITY];
  const decls = fields.map((f) => f.t === 'collection'
    ? `\t@Inject\n\tprivate List<IComponent> ${f.m};`
    : `\t@Inject${f.d !== undefined ? `\n\t@Default(values = "${f.d}")` : ''}\n\tprivate String ${f.m};`).join('\n\n');
  const getters = fields.map((f) => f.t === 'collection'
    ? `\tpublic List<IComponent> get${cap(f.m)}() {\n\t\treturn ${f.m};\n\t}`
    : `\tpublic String get${cap(f.m)}() {\n\t\treturn ${f.m};\n\t}`).join('\n\n');
  return `package com.peregrinevanilla.models;

/* GENERATED by tools/gen-components.mjs - edit the SPEC there, not this file.
   The model exists because PageMerge only passes properties a Sling model
   declares; every field the render function reads must be listed. */

import com.peregrine.nodetypes.models.AbstractComponent;
import com.peregrine.nodetypes.models.IComponent;
import com.peregrine.nodetypes.models.Container;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import java.util.List;

import javax.inject.Inject;

@Model(
        adaptables = Resource.class,
        resourceType = "peregrinevanilla/components/${name}",
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL,
        adapters = IComponent.class
)
@Exporter(
        name = "jackson",
        extensions = "json"
)
public class ${cls} extends ${parent} {

    public ${cls}(final Resource r) { super(r); }

${decls}

${getters}

}
`;
}

function contentXml(name, spec) {
  const props = Object.entries(spec.sample || {})
    .map(([k, v]) => `${k}="${xml(v)}"`).join(' ');
  let children = '';
  for (const [coll, rows] of Object.entries(spec.sampleChildren || {})) {
    children += `\n    <${coll} jcr:primaryType="nt:unstructured">\n`
      + rows.map((row, i) => `      <i${i} jcr:primaryType="nt:unstructured" `
        + Object.entries(row).map(([k, v]) => `${k}="${xml(v)}"`).join(' ') + '/>').join('\n')
      + `\n    </${coll}>`;
  }
  const inner = children
    ? `  <jcr:content jcr:primaryType="nt:unstructured" ${props}>${children}\n  </jcr:content>`
    : `  <jcr:content jcr:primaryType="nt:unstructured" ${props}/>`;
  return `<?xml version="1.0" encoding="utf-8"?>
<jcr:root xmlns:sling="http://sling.apache.org/jcr/sling/1.0" xmlns:jcr="http://www.jcp.org/jcr/1.0" xmlns:nt="http://www.jcp.org/jcr/nt/1.0" jcr:primaryType="per:Component" jcr:title="${xml(spec.title)}" group="${xml(spec.group)}">
${inner}
</jcr:root>
`;
}

let n = 0;
for (const [name, spec] of Object.entries(SPEC)) {
  const dir = path.join(APPS, name);
  fs.mkdirSync(dir, { recursive: true });
  fs.writeFileSync(path.join(dir, '.content.xml'), contentXml(name, spec));
  fs.writeFileSync(path.join(dir, 'dialog.json'), JSON.stringify(
    { groups: [{ legend: 'content', fields: [...spec.fields, VISIBILITY].map(dialogField) }] }, null, 1));
  fs.mkdirSync(MODELS, { recursive: true });
  fs.writeFileSync(path.join(MODELS, cap(name) + 'Model.java'), modelJava(name, spec));
  n++;
}
console.log(`generated ${n} components (content.xml + dialog.json + Model.java)`);
