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
    "Header": {
      "type": "object",
      "x-type": "component",
      "properties": {
        "brand": {
          "type": "string",
          "x-source": "inject",
          "x-form-group": "content",
          "x-form-label": "Brand (wordmark text)",
          "x-form-type": "text"
        },
        "brandlink": {
          "type": "string",
          "x-source": "inject",
          "x-form-group": "content",
          "x-form-label": "Brand link",
          "x-form-type": "pathbrowser",
          "x-form-browserRoot": "/content"
        },
        "logo": {
          "type": "string",
          "x-source": "inject",
          "x-form-group": "content",
          "x-form-label": "Logo (mark)",
          "x-form-type": "pathbrowser",
          "x-form-browserRoot": "/content"
        },
        "logoalt": {
          "type": "string",
          "x-source": "inject",
          "x-form-group": "content",
          "x-form-label": "Logo alt text",
          "x-form-type": "text"
        },
        "navitems": {
          "type": "object",
          "x-source": "inject",
          "x-form-group": "content",
          "x-form-label": "Navigation items",
          "x-form-type": "collection",
          "x-form-fieldLabel": [
            "text"
          ],
          "properties": {
            "text": {
              "type": "string",
              "x-source": "inject",
              "x-form-label": "Label",
              "x-form-type": "text"
            },
            "link": {
              "type": "string",
              "x-source": "inject",
              "x-form-label": "Link",
              "x-form-type": "pathbrowser",
              "x-form-browserRoot": "/content"
            }
          }
        },
        "boxtext": {
          "type": "string",
          "x-source": "inject",
          "x-form-group": "content",
          "x-form-label": "Boxed link label (e.g. GITHUB)",
          "x-form-type": "text"
        },
        "boxlink": {
          "type": "string",
          "x-source": "inject",
          "x-form-group": "content",
          "x-form-label": "Boxed link target",
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
  "name": "Header",
  "componentPath": "postervanilla/components/header",
  "package": "com.postervanilla.models",
  "modelName": "Header",
  "classNameParent": "AbstractComponent"
}
//GEN]
*/

//GEN[:DEF
@Model(
        adaptables = Resource.class,
        resourceType = "postervanilla/components/header",
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL,
        adapters = IComponent.class
)
@Exporter(
        name = "jackson",
        extensions = "json"
)

//GEN]
public class HeaderModel extends AbstractComponent {

    public HeaderModel(final Resource r) { super(r); }

    //GEN[:INJECT
    	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Brand (wordmark text)","x-form-type":"text"} */
	@Inject
	private String brand;

	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Brand link","x-form-type":"pathbrowser","x-form-browserRoot":"/content"} */
	@Inject
	private String brandlink;

	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Logo (mark)","x-form-type":"pathbrowser","x-form-browserRoot":"/content"} */
	@Inject
	private String logo;

	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Logo alt text","x-form-type":"text"} */
	@Inject
	private String logoalt;

	/* {"type":"object","x-source":"inject","x-form-group":"content","x-form-label":"Navigation items","x-form-type":"collection","x-form-fieldLabel":["text"],"properties":{"text":{"type":"string","x-source":"inject","x-form-label":"Label","x-form-type":"text"},"link":{"type":"string","x-source":"inject","x-form-label":"Link","x-form-type":"pathbrowser","x-form-browserRoot":"/content"}}} */
	@Inject
	private List<IComponent> navitems;

	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Boxed link label (e.g. GITHUB)","x-form-type":"text"} */
	@Inject
	private String boxtext;

	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Boxed link target","x-form-type":"pathbrowser","x-form-browserRoot":"/content"} */
	@Inject
	private String boxlink;

	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Visibility","x-form-type":"materialselect","x-default":"all","properties":{"all":{"x-form-name":"Always visible","x-form-value":"all"},"desktop":{"x-form-name":"Desktop only (821px and up)","x-form-value":"desktop"},"mobile":{"x-form-name":"Mobile only (up to 820px)","x-form-value":"mobile"}}} */
	@Inject
	@Default(values ="all")
	private String visibility;


//GEN]

    //GEN[:GETTERS
    	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Brand (wordmark text)","x-form-type":"text"} */
	public String getBrand() {
		return brand;
	}

	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Brand link","x-form-type":"pathbrowser","x-form-browserRoot":"/content"} */
	public String getBrandlink() {
		return brandlink;
	}

	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Logo (mark)","x-form-type":"pathbrowser","x-form-browserRoot":"/content"} */
	public String getLogo() {
		return logo;
	}

	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Logo alt text","x-form-type":"text"} */
	public String getLogoalt() {
		return logoalt;
	}

	/* {"type":"object","x-source":"inject","x-form-group":"content","x-form-label":"Navigation items","x-form-type":"collection","x-form-fieldLabel":["text"],"properties":{"text":{"type":"string","x-source":"inject","x-form-label":"Label","x-form-type":"text"},"link":{"type":"string","x-source":"inject","x-form-label":"Link","x-form-type":"pathbrowser","x-form-browserRoot":"/content"}}} */
	public List<IComponent> getNavitems() {
		return navitems;
	}

	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Boxed link label (e.g. GITHUB)","x-form-type":"text"} */
	public String getBoxtext() {
		return boxtext;
	}

	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Boxed link target","x-form-type":"pathbrowser","x-form-browserRoot":"/content"} */
	public String getBoxlink() {
		return boxlink;
	}

	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Visibility","x-form-type":"materialselect","x-default":"all","properties":{"all":{"x-form-name":"Always visible","x-form-value":"all"},"desktop":{"x-form-name":"Desktop only (821px and up)","x-form-value":"desktop"},"mobile":{"x-form-name":"Mobile only (up to 820px)","x-form-value":"mobile"}}} */
	public String getVisibility() {
		return visibility;
	}


//GEN]

    //GEN[:CUSTOMGETTERS
    //GEN]

}
