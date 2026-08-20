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

}
