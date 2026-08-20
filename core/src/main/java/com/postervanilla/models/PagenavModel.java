package com.postervanilla.models;

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
import javax.inject.Named;



/*
    //GEN[:DATA
    {
  "definitions": {
    "Pagenav": {
      "type": "object",
      "x-type": "component",
      "properties": {
        "prevtext": {
          "type": "string",
          "x-source": "inject",
          "x-form-group": "content",
          "x-form-label": "Previous label",
          "x-form-type": "text"
        },
        "prevlink": {
          "type": "string",
          "x-source": "inject",
          "x-form-group": "content",
          "x-form-label": "Previous link",
          "x-form-type": "pathbrowser",
          "x-form-browserRoot": "/content"
        },
        "uptext": {
          "type": "string",
          "x-source": "inject",
          "x-form-group": "content",
          "x-form-label": "Up label",
          "x-form-type": "text"
        },
        "uplink": {
          "type": "string",
          "x-source": "inject",
          "x-form-group": "content",
          "x-form-label": "Up link",
          "x-form-type": "pathbrowser",
          "x-form-browserRoot": "/content"
        },
        "nexttext": {
          "type": "string",
          "x-source": "inject",
          "x-form-group": "content",
          "x-form-label": "Next label",
          "x-form-type": "text"
        },
        "nextlink": {
          "type": "string",
          "x-source": "inject",
          "x-form-group": "content",
          "x-form-label": "Next link",
          "x-form-type": "pathbrowser",
          "x-form-browserRoot": "/content"
        },
        "visibility": {
          "type": "string",
          "x-source": "inject",
          "x-form-group": "content",
          "x-form-label": "Visibility",
          "x-form-type": "materialselect",
          "x-default": "all",
          "properties": {
            "all": {
              "x-form-name": "Always visible",
              "x-form-value": "all"
            },
            "desktop": {
              "x-form-name": "Desktop only (821px and up)",
              "x-form-value": "desktop"
            },
            "mobile": {
              "x-form-name": "Mobile only (up to 820px)",
              "x-form-value": "mobile"
            }
          }
        }
      }
    }
  },
  "name": "Pagenav",
  "componentPath": "postervanilla/components/pagenav",
  "package": "com.postervanilla.models",
  "modelName": "Pagenav",
  "classNameParent": "AbstractComponent"
}
//GEN]
*/

//GEN[:DEF
@Model(
        adaptables = Resource.class,
        resourceType = "postervanilla/components/pagenav",
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL,
        adapters = IComponent.class
)
@Exporter(
        name = "jackson",
        extensions = "json"
)

//GEN]
public class PagenavModel extends AbstractComponent {

    public PagenavModel(final Resource r) { super(r); }

    //GEN[:INJECT
    	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Previous label","x-form-type":"text"} */
	@Inject
	private String prevtext;

	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Previous link","x-form-type":"pathbrowser","x-form-browserRoot":"/content"} */
	@Inject
	private String prevlink;

	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Up label","x-form-type":"text"} */
	@Inject
	private String uptext;

	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Up link","x-form-type":"pathbrowser","x-form-browserRoot":"/content"} */
	@Inject
	private String uplink;

	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Next label","x-form-type":"text"} */
	@Inject
	private String nexttext;

	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Next link","x-form-type":"pathbrowser","x-form-browserRoot":"/content"} */
	@Inject
	private String nextlink;

	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Visibility","x-form-type":"materialselect","x-default":"all","properties":{"all":{"x-form-name":"Always visible","x-form-value":"all"},"desktop":{"x-form-name":"Desktop only (821px and up)","x-form-value":"desktop"},"mobile":{"x-form-name":"Mobile only (up to 820px)","x-form-value":"mobile"}}} */
	@Inject
	@Default(values ="all")
	private String visibility;


//GEN]

    //GEN[:GETTERS
    	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Previous label","x-form-type":"text"} */
	public String getPrevtext() {
		return prevtext;
	}

	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Previous link","x-form-type":"pathbrowser","x-form-browserRoot":"/content"} */
	public String getPrevlink() {
		return prevlink;
	}

	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Up label","x-form-type":"text"} */
	public String getUptext() {
		return uptext;
	}

	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Up link","x-form-type":"pathbrowser","x-form-browserRoot":"/content"} */
	public String getUplink() {
		return uplink;
	}

	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Next label","x-form-type":"text"} */
	public String getNexttext() {
		return nexttext;
	}

	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Next link","x-form-type":"pathbrowser","x-form-browserRoot":"/content"} */
	public String getNextlink() {
		return nextlink;
	}

	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Visibility","x-form-type":"materialselect","x-default":"all","properties":{"all":{"x-form-name":"Always visible","x-form-value":"all"},"desktop":{"x-form-name":"Desktop only (821px and up)","x-form-value":"desktop"},"mobile":{"x-form-name":"Mobile only (up to 820px)","x-form-value":"mobile"}}} */
	public String getVisibility() {
		return visibility;
	}


//GEN]

    //GEN[:CUSTOMGETTERS
    //GEN]

    /*
     * Automatic prev/next, the themeclean-flex pager idea: when no links are
     * authored, walk the sibling per:Page nodes of the containing page in
     * their JCR order. Authored links always win (the render function checks
     * them first), so a hand-wired chain - like the manual's - is untouched.
     * Custom getters live outside the GEN blocks and survive hatch re-runs.
     */
    private Resource containingPage() {
        Resource r = getResource();
        while (r != null && !"per:Page".equals(r.getValueMap().get("jcr:primaryType", String.class))) {
            r = r.getParent();
        }
        return r;
    }

    private java.util.List<Resource> siblingPages() {
        java.util.List<Resource> pages = new java.util.ArrayList<>();
        Resource page = containingPage();
        if (page == null || page.getParent() == null) return pages;
        for (Resource c : page.getParent().getChildren()) {
            if ("per:Page".equals(c.getValueMap().get("jcr:primaryType", String.class))
                    && c.getChild("jcr:content") != null) {
                pages.add(c);
            }
        }
        return pages;
    }

    private Resource siblingAt(int offset) {
        Resource page = containingPage();
        if (page == null) return null;
        java.util.List<Resource> pages = siblingPages();
        for (int i = 0; i < pages.size(); i++) {
            if (pages.get(i).getPath().equals(page.getPath())) {
                int at = i + offset;
                return (at >= 0 && at < pages.size()) ? pages.get(at) : null;
            }
        }
        return null;
    }

    private String pageTitle(Resource page) {
        Resource content = page.getChild("jcr:content");
        String title = content == null ? null
                : content.getValueMap().get("jcr:title", String.class);
        return title == null || title.isEmpty() ? page.getName() : title;
    }

    public String getAutoprevlink() {
        Resource p = siblingAt(-1);
        return p == null ? null : p.getPath();
    }

    public String getAutoprevtext() {
        Resource p = siblingAt(-1);
        return p == null ? null : pageTitle(p);
    }

    public String getAutonextlink() {
        Resource p = siblingAt(1);
        return p == null ? null : p.getPath();
    }

    public String getAutonexttext() {
        Resource p = siblingAt(1);
        return p == null ? null : pageTitle(p);
    }

}
