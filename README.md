# postervanilla

A bold graphic theme for Peregrine CMS: display type as image, flat colour
fields, one heavy rule weight everywhere. Rendered by the framework-free
vanilla renderer (`pagerenderervanilla`), structured exactly like
`bayviewvanilla`.

## Build & install

```
mvn -o -DskipTests clean install          # JDK 25 (base.core in .m2 is built with it)
```

Then upload/install `ui.apps/target/postervanilla-ui.apps-1.0-SNAPSHOT.zip`
through Composum (`/bin/cpm/package.upload.json` + `package.install.json`).
The Sling-model bundle rides inside the package at
`/apps/postervanilla/install` and jcrinstall picks it up.

The theme appears on the dashboard as **Poster (Vanilla)**; create a website
from it and every component, dialog and stylesheet is copied into the new
site's own namespace.

## The parts

| | |
|---|---|
| `tools/gen-components.mjs` | THE SOURCE OF TRUTH for components: one SPEC entry per component generates its `.content.xml`, `dialog.json` and Sling model. percli-hatch3 is not on this machine; this is the stand-in. Edit the SPEC, re-run, rebuild. |
| `etc/felibs/postervanilla/js/components.js` | hand-written render functions, `PV.components['components-<name>']` |
| `etc/felibs/postervanilla/css/` | `variables` (tokens) / `fonts` / `base` / `components` |
| `content/postervanilla/pages/index` | the reference page: every component once. If it looks wrong, the theme is wrong. |
| `tools/check-contrast.mjs` | asserts the token pairs; the palette was settled against WCAG before anything was built |

## Rules this repo already paid for

- **Every property a render function reads must be in the Sling model** —
  PageMerge strips the rest silently. That is why the generator writes the
  model and the dialog from one spec.
- `#ff9800` is the mark's orange and it is 1.91:1 on paper: decorative use
  only — the falcon, the hero asterisk. Small orange text is `#8f5600` on
  paper and full `#ff9800` on the black field (8.8:1).
- The ticker never animates in the editor (`pst-ticker--still`) and respects
  `prefers-reduced-motion`.
