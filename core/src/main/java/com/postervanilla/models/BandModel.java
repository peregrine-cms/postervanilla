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
    "Band": {
      "type": "object",
      "x-type": "container",
      "properties": {
        "background": {
          "type": "string",
          "x-source": "inject",
          "x-form-group": "content",
          "x-form-label": "Background",
          "x-form-type": "materialselect",
          "x-default": "paper",
          "properties": {
            "paper": {
              "x-form-name": "Paper",
              "x-form-value": "paper"
            },
            "orange": {
              "x-form-name": "Orange field",
              "x-form-value": "orange"
            },
            "ink": {
              "x-form-name": "Black field",
              "x-form-value": "ink"
            }
          }
        },
        "bordered": {
          "type": "string",
          "x-source": "inject",
          "x-form-group": "content",
          "x-form-label": "Heavy rule along the bottom",
          "x-form-type": "materialswitch"
        },
        "padding": {
          "type": "string",
          "x-source": "inject",
          "x-form-group": "content",
          "x-form-label": "Vertical padding",
          "x-form-type": "materialselect",
          "x-default": "normal",
          "properties": {
            "normal": {
              "x-form-name": "Normal",
              "x-form-value": "normal"
            },
            "compact": {
              "x-form-name": "Compact",
              "x-form-value": "compact"
            },
            "roomy": {
              "x-form-name": "Roomy",
              "x-form-value": "roomy"
            }
          }
        },
        "contained": {
          "type": "string",
          "x-source": "inject",
          "x-form-group": "content",
          "x-form-label": "Contain content to the page column",
          "x-form-type": "materialswitch",
          "x-default": "true"
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
  "name": "Band",
  "componentPath": "postervanilla/components/band",
  "package": "com.postervanilla.models",
  "modelName": "Band",
  "classNameParent": "Container"
}
//GEN]
*/

//GEN[:DEF
@Model(
        adaptables = Resource.class,
        resourceType = "postervanilla/components/band",
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL,
        adapters = IComponent.class
)
@Exporter(
        name = "jackson",
        extensions = "json"
)

//GEN]
public class BandModel extends Container {

    public BandModel(final Resource r) { super(r); }

    //GEN[:INJECT
    	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Background","x-form-type":"materialselect","x-default":"paper","properties":{"paper":{"x-form-name":"Paper","x-form-value":"paper"},"orange":{"x-form-name":"Orange field","x-form-value":"orange"},"ink":{"x-form-name":"Black field","x-form-value":"ink"}}} */
	@Inject
	@Default(values ="paper")
	private String background;

	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Heavy rule along the bottom","x-form-type":"materialswitch"} */
	@Inject
	private String bordered;

	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Vertical padding","x-form-type":"materialselect","x-default":"normal","properties":{"normal":{"x-form-name":"Normal","x-form-value":"normal"},"compact":{"x-form-name":"Compact","x-form-value":"compact"},"roomy":{"x-form-name":"Roomy","x-form-value":"roomy"}}} */
	@Inject
	@Default(values ="normal")
	private String padding;

	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Contain content to the page column","x-form-type":"materialswitch","x-default":"true"} */
	@Inject
	@Default(values ="true")
	private String contained;

	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Visibility","x-form-type":"materialselect","x-default":"all","properties":{"all":{"x-form-name":"Always visible","x-form-value":"all"},"desktop":{"x-form-name":"Desktop only (821px and up)","x-form-value":"desktop"},"mobile":{"x-form-name":"Mobile only (up to 820px)","x-form-value":"mobile"}}} */
	@Inject
	@Default(values ="all")
	private String visibility;


//GEN]

    //GEN[:GETTERS
    	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Background","x-form-type":"materialselect","x-default":"paper","properties":{"paper":{"x-form-name":"Paper","x-form-value":"paper"},"orange":{"x-form-name":"Orange field","x-form-value":"orange"},"ink":{"x-form-name":"Black field","x-form-value":"ink"}}} */
	public String getBackground() {
		return background;
	}

	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Heavy rule along the bottom","x-form-type":"materialswitch"} */
	public String getBordered() {
		return bordered;
	}

	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Vertical padding","x-form-type":"materialselect","x-default":"normal","properties":{"normal":{"x-form-name":"Normal","x-form-value":"normal"},"compact":{"x-form-name":"Compact","x-form-value":"compact"},"roomy":{"x-form-name":"Roomy","x-form-value":"roomy"}}} */
	public String getPadding() {
		return padding;
	}

	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Contain content to the page column","x-form-type":"materialswitch","x-default":"true"} */
	public String getContained() {
		return contained;
	}

	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Visibility","x-form-type":"materialselect","x-default":"all","properties":{"all":{"x-form-name":"Always visible","x-form-value":"all"},"desktop":{"x-form-name":"Desktop only (821px and up)","x-form-value":"desktop"},"mobile":{"x-form-name":"Mobile only (up to 820px)","x-form-value":"mobile"}}} */
	public String getVisibility() {
		return visibility;
	}


//GEN]

    //GEN[:CUSTOMGETTERS
    //GEN]

}
