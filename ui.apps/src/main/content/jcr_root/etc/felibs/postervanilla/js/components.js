/*
 * Poster theme — component render functions for the Peregrine vanilla page
 * renderer (pagerenderervanilla). Each function maps a model node to a DOM
 * element; they register on window.PV.components keyed by the trailing
 * "components-<name>" segment of the component's resource type — which is why
 * a site created FROM this theme (whose copies live under /apps/<site>/) still
 * resolves to these functions.
 *
 * Loaded via the site template's siteJS AFTER the renderer runtime.
 */
(function () {
  'use strict';
  var PV = window.PV = window.PV || {};
  PV.components = PV.components || {};
  var el = PV.el;
  var EDIT = PV.editMode;

  function pathToUrl(p) {
    if (!p) return p || '#';
    if (p.charAt(0) === '#' || /^([a-z]+:)?\/\//i.test(p)) return p;
    return /\.\w+$/.test(p) ? p : p + '.html';
  }
  function truthy(v) { return v === true || v === 'true'; }
  /*
   * Anchor attributes, with the one decision that makes cross-site links
   * work: the runtime intercepts internal-looking links and swaps the page
   * MODEL in place (fetching <path>.data.json). That is right inside this
   * site and wrong everywhere else - another site's page needs its own
   * felib, and short URLs (/first-site.html) only exist at the CDN - so any
   * link that leaves the site's own content root opts out with
   * data-per-reload and gets a real browser navigation.
   */
  function linkAttrs(node, href, cls) {
    var a = {};
    if (cls) a['class'] = cls;
    a.href = pathToUrl(href);
    // template-merged nodes (header, footer) carry RELATIVE paths, so fall
    // back to the site root the renderer publishes - without it their in-site
    // links were opting out of SPA navigation and doing full reloads
    var m = String(node.path || '').match(/^\/content\/[^/]+/);
    var root = m ? m[0]
      : (String(window.$peregrineSiteRoot || '').match(/^\/content\/[^/]+/) || [null])[0];
    if (a.href.charAt(0) === '/' && (!root || a.href.indexOf(root + '/') !== 0)) {
      a['data-per-reload'] = 'true';
    }
    return a;
  }
  function vis(node) {
    return node.visibility === 'desktop' ? ' pst--desktop'
      : node.visibility === 'mobile' ? ' pst--mobile' : '';
  }
  /* the one arrow the theme uses; stroke inherits currentColor so it follows
     the row's hover inversion for free */
  function arrow(size) {
    var s = size || 26;
    var svg = document.createElementNS('http://www.w3.org/2000/svg', 'svg');
    svg.setAttribute('class', 'pst-indexlist__arrow');
    svg.setAttribute('width', s); svg.setAttribute('height', s);
    svg.setAttribute('viewBox', '0 0 24 24'); svg.setAttribute('fill', 'none');
    var path = document.createElementNS('http://www.w3.org/2000/svg', 'path');
    path.setAttribute('d', 'M4 12h15M13 5.5 19.5 12 13 18.5');
    path.setAttribute('stroke', 'currentColor'); path.setAttribute('stroke-width', '3');
    svg.appendChild(path);
    return svg;
  }
  function editHint(node, text) {
    return EDIT ? el('div', { 'class': 'perIsEditAndEmpty' }, text) : null;
  }
  function appendAll(parent, kids) {
    kids.forEach(function (k) { if (k) parent.appendChild(k); });
    return parent;
  }

  /* ---- structure ---------------------------------------------------------- */

  PV.components['components-header'] = function (node) {
    var header = el('header', { 'class': 'pst-header' + vis(node), 'data-per-path': node.path });
    var bar = el('div', { 'class': 'pst-container pst-header__bar' });
    var brand = el('a', linkAttrs(node, node.brandlink, 'pst-header__brand'));
    if (node.logo) brand.appendChild(el('img', { 'class': 'pst-header__logo', 'src': node.logo, 'alt': node.logoalt || node.brand || '' }));
    if (node.brand) brand.appendChild(el('span', { 'class': 'pst-header__wordmark' }, node.brand));
    bar.appendChild(brand);
    var nav = el('nav', { 'class': 'pst-header__nav' });
    (node.navitems || []).forEach(function (it) {
      nav.appendChild(el('a', linkAttrs(node, it.link), it.text || ''));
    });
    if (node.boxtext) nav.appendChild(el('a', linkAttrs(node, node.boxlink, 'pst-header__box'), node.boxtext));
    bar.appendChild(nav);
    header.appendChild(bar);
    return header;
  };

  PV.components['components-footer'] = function (node) {
    var footer = el('footer', { 'class': 'pst-footer' + vis(node), 'data-per-path': node.path });
    var bar = el('div', { 'class': 'pst-container pst-footer__bar' });
    var brand = el('div', { 'class': 'pst-footer__brand' });
    if (node.logo) brand.appendChild(el('img', { 'class': 'pst-footer__logo', 'src': node.logo, 'alt': '' }));
    var left = (node.brand ? node.brand : '') + (node.brand && node.lefttext ? ' — ' : '') + (node.lefttext || '');
    brand.appendChild(el('span', {}, left));
    bar.appendChild(brand);
    if (node.righttext) bar.appendChild(el('div', EDIT ? { 'data-per-inline': 'model.righttext' } : {}, node.righttext));
    footer.appendChild(bar);
    return footer;
  };

  PV.components['components-band'] = function (node) {
    var cls = 'pst-band pst-band--' + (node.background || 'paper') +
      (truthy(node.bordered) ? ' pst-band--bordered' : '') +
      (node.padding === 'roomy' ? ' pst-band--roomy' : '') +
      (node.padding === 'compact' ? ' pst-band--compact' : '') + vis(node);
    var section = el('section', { 'class': cls, 'data-per-path': node.path });
    if (EDIT) section.setAttribute('data-per-droptarget', 'true');
    var inner = el('div', { 'class': truthy(node.contained) === false ? 'pst-band__inner' : 'pst-container' });
    (node.children || []).forEach(function (ch) { inner.appendChild(PV.renderNode(ch)); });
    if (!(node.children || []).length && EDIT) inner.appendChild(el('div', { 'class': 'perIsEditAndEmpty' }, 'Drop components into this band'));
    section.appendChild(inner);
    return section;
  };

  /* ---- content ------------------------------------------------------------- */

  PV.components['components-hero'] = function (node) {
    var section = el('section', { 'class': 'pst-hero' + vis(node), 'data-per-path': node.path });
    if (!node.title && !node.footnote) return appendAll(section, [editHint(node, 'No hero content defined')]);
    if (node.image) section.appendChild(el('img', { 'class': 'pst-hero__mark', 'src': node.image, 'alt': node.imagealt || '' }));
    var inner = el('div', { 'class': 'pst-container pst-hero__inner' });
    var titleAttrs = { 'class': 'pst-hero__title' };
    if (EDIT) titleAttrs['data-per-inline'] = 'model.title';
    var h1 = el('h1', titleAttrs, node.title || '');
    // the asterisk is drawn, not typed: the footnote explains it below
    if (node.footnote) h1.appendChild(el('span', { 'class': 'pst-hero__mmarker' }, '*'));
    inner.appendChild(h1);
    var row = el('div', { 'class': 'pst-hero__row' });
    if (node.footnote) {
      var fnAttrs = { 'class': 'pst-hero__footnote' };
      if (EDIT) fnAttrs['data-per-inline'] = 'model.footnote';
      row.appendChild(el('div', fnAttrs, node.footnote));
    }
    var ctas = el('div', { 'class': 'pst-hero__ctas' });
    if (node.ctatext) ctas.appendChild(el('a', linkAttrs(node, node.ctalink, 'pst-btn pst-btn--solid'), node.ctatext));
    if (node.cta2text) ctas.appendChild(el('a', linkAttrs(node, node.cta2link, 'pst-btn pst-btn--outline'), node.cta2text));
    if (ctas.children.length) row.appendChild(ctas);
    inner.appendChild(row);
    section.appendChild(inner);
    return section;
  };

  PV.components['components-ticker'] = function (node) {
    var speed = node.speed === 'fast' ? '22s' : node.speed === 'slow' ? '56s' : '36s';
    var wrap = el('div', { 'class': 'pst-ticker' + (EDIT ? ' pst-ticker--still' : '') + vis(node), 'data-per-path': node.path });
    var track = el('div', { 'class': 'pst-ticker__track' });
    track.style.setProperty('--pst-ticker-speed', speed);
    var text = node.text || 'SET THE TICKER TEXT · ';
    // the track holds the text twice, so the -50% keyframe loops seamlessly
    for (var i = 0; i < 2; i++) {
      var item = el('span', { 'class': 'pst-ticker__item' });
      // "**...**" marks the orange stretch, the same convention authors know
      var parts = String(text).split('**');
      for (var p = 0; p < parts.length; p++) {
        if (p % 2) item.appendChild(el('strong', {}, parts[p]));
        else item.appendChild(document.createTextNode(parts[p]));
      }
      track.appendChild(item);
    }
    wrap.appendChild(track);
    return wrap;
  };

  PV.components['components-claims'] = function (node) {
    var wrap = el('div', { 'class': 'pst-claims' + vis(node), 'data-per-path': node.path });
    var items = node.items || [];
    if (!items.length) return appendAll(el('div', { 'data-per-path': node.path }), [editHint(node, 'Add claims in the dialog')]);
    items.forEach(function (it, i) {
      var cell = el('div', { 'class': 'pst-claims__cell' });
      cell.appendChild(el('div', { 'class': 'pst-claims__num' }, (i + 1 < 10 ? '0' : '') + (i + 1)));
      cell.appendChild(el('div', { 'class': 'pst-claims__title' }, it.title || ''));
      if (it.text) cell.appendChild(el('div', { 'class': 'pst-claims__text' }, it.text));
      wrap.appendChild(cell);
    });
    return wrap;
  };

  PV.components['components-indexlist'] = function (node) {
    var wrap = el('div', { 'class': 'pst-indexlist' + vis(node), 'data-per-path': node.path });
    var items = node.items || [];
    if (!items.length) return appendAll(el('div', { 'data-per-path': node.path }), [editHint(node, 'Add index rows in the dialog')]);
    var start = parseInt(node.startat, 10) || 1;
    items.forEach(function (it, i) {
      var n = start + i;
      var row = el(it.link ? 'a' : 'div', it.link
        ? linkAttrs(node, it.link, 'pst-indexlist__row')
        : { 'class': 'pst-indexlist__row' });
      row.appendChild(el('span', { 'class': 'pst-indexlist__num' }, (n < 10 ? '0' : '') + n));
      row.appendChild(el('span', { 'class': 'pst-indexlist__title' }, it.title || ''));
      if (it.tag) row.appendChild(el('span', { 'class': 'pst-indexlist__tag' }, it.tag));
      row.appendChild(arrow());
      wrap.appendChild(row);
    });
    return wrap;
  };

  PV.components['components-command'] = function (node) {
    var wrap = el('div', { 'class': 'pst-command' + vis(node), 'data-per-path': node.path });
    var line = el('div', { 'class': 'pst-command__line' });
    line.appendChild(el('span', { 'class': 'pst-command__prompt' }, node.prompt || '$'));
    var textAttrs = {};
    if (EDIT) textAttrs['data-per-inline'] = 'model.text';
    line.appendChild(el('span', textAttrs, node.text || 'echo "set the command text"'));
    wrap.appendChild(line);
    if (node.comment) wrap.appendChild(el('div', { 'class': 'pst-command__comment' }, '# ' + node.comment));
    return wrap;
  };

  // multi-line source, verbatim. textContent, never innerHTML - the code is
  // authored text, not markup.
  PV.components['components-codeblock'] = function (node) {
    var wrap = el('figure', { 'class': 'pst-codeblock' + vis(node), 'data-per-path': node.path });
    if (node.filename) wrap.appendChild(el('figcaption', { 'class': 'pst-codeblock__file' }, node.filename));
    var pre = el('pre', { 'class': 'pst-codeblock__pre' });
    var code = document.createElement('code');
    code.textContent = node.code || (EDIT ? '// paste the code in the dialog' : '');
    pre.appendChild(code);
    wrap.appendChild(pre);
    return wrap;
  };

  PV.components['components-blkimage'] = function (node) {
    var wrap = el('figure', { 'class': 'pst-blkimage' + (truthy(node.plain) ? ' pst-blkimage--plain' : '') + vis(node), 'data-per-path': node.path });
    if (node.image) {
      wrap.appendChild(el('img', { 'class': 'pst-blkimage__img', 'src': node.image, 'alt': node.imagealt || '', 'loading': 'lazy' }));
    } else {
      var hint = editHint(node, 'No image defined');
      if (hint) wrap.appendChild(hint);
    }
    if (node.caption) wrap.appendChild(el('figcaption', { 'class': 'pst-blkimage__cap' }, node.caption));
    return wrap;
  };

  PV.components['components-splitrow'] = function (node) {
    var cls = 'pst-splitrow pst-splitrow--' + (node.ratio || '50-50') +
      (truthy(node.divided) ? ' pst-splitrow--divided' : '') + vis(node);
    var row = el('div', { 'class': cls, 'data-per-path': node.path });
    if (EDIT) row.setAttribute('data-per-droptarget', 'true');
    var kids = node.children || [];
    // first child left, everything else right - same contract as the themes
    var left = el('div', { 'class': 'pst-splitrow__cell' });
    var right = el('div', { 'class': 'pst-splitrow__cell' });
    kids.forEach(function (ch, i) { (i === 0 ? left : right).appendChild(PV.renderNode(ch)); });
    if (!kids.length && EDIT) left.appendChild(el('div', { 'class': 'perIsEditAndEmpty' }, 'Drop two components here'));
    row.appendChild(left);
    row.appendChild(right);
    return row;
  };

  PV.components['components-datatable'] = function (node) {
    var wrap = el('dl', { 'class': 'pst-datatable' + vis(node), 'data-per-path': node.path });
    (node.items || []).forEach(function (it) {
      var row = el('div', { 'class': 'pst-datatable__row' });
      row.appendChild(el('dt', { 'class': 'pst-datatable__name' }, it.name || ''));
      row.appendChild(el('dd', { 'class': 'pst-datatable__value' }, it.value || ''));
      wrap.appendChild(row);
    });
    if (!(node.items || []).length && EDIT) wrap.appendChild(el('div', { 'class': 'perIsEditAndEmpty' }, 'Add rows in the dialog'));
    return wrap;
  };

  /* ---- blocks --------------------------------------------------------------- */

  PV.components['components-blkheading'] = function (node) {
    var tag = node.level || 'h2';
    var a = { 'class': 'pst-blkheading pst-blkheading--' + (node.size || 'band') + vis(node), 'data-per-path': node.path };
    if (EDIT) a['data-per-inline'] = 'model.text';
    return el(tag, a, node.text || '');
  };

  PV.components['components-blktext'] = function (node) {
    var a = { 'class': 'pst-blktext pst-blktext--' + (node.style || 'body') + vis(node), 'data-per-path': node.path };
    if (EDIT) a['data-per-inline'] = 'model.text';
    return el('div', a, node.text || '');
  };

  PV.components['components-blkbutton'] = function (node) {
    var wrap = el('div', { 'class': 'pst-blkbutton' + vis(node), 'data-per-path': node.path });
    var s = node.style === 'outline' ? 'pst-btn pst-btn--outline'
      : node.style === 'box' ? 'pst-btn pst-btn--box'
      : 'pst-btn pst-btn--solid';
    var a = linkAttrs(node, node.link, s);
    if (EDIT) a['data-per-inline'] = 'model.text';
    wrap.appendChild(el('a', a, node.text || 'Button'));
    return wrap;
  };

  // authored links win; without them the model's automatic sibling walk
  // (themeclean-flex's pager idea) fills prev/next from the page tree
  PV.components['components-pagenav'] = function (node) {
    var wrap = el('nav', { 'class': 'pst-pagenav' + vis(node), 'data-per-path': node.path });
    var prevlink = node.prevlink || node.autoprevlink;
    var prevtext = node.prevlink ? node.prevtext : node.autoprevtext;
    var nextlink = node.nextlink || node.autonextlink;
    var nexttext = node.nextlink ? node.nexttext : node.autonexttext;
    if (prevlink) wrap.appendChild(el('a', linkAttrs(node, prevlink), '‹ ' + (prevtext || 'Previous')));
    else wrap.appendChild(el('span', {}, ''));
    if (node.uplink) wrap.appendChild(el('a', linkAttrs(node, node.uplink, 'pst-pagenav__up'), node.uptext || 'All chapters'));
    if (nextlink) wrap.appendChild(el('a', linkAttrs(node, nextlink), (nexttext || 'Next') + ' ›'));
    else wrap.appendChild(el('span', {}, ''));
    return wrap;
  };
})();
