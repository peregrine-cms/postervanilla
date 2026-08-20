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
    "Splitrow": {
      "type": "object",
      "x-type": "container",
      "properties": {
        "ratio": {
          "type": "string",
          "x-source": "inject",
          "x-form-group": "content",
          "x-form-label": "Column ratio",
          "x-form-type": "materialselect",
          "x-default": "50-50",
          "properties": {
            "50-50": {
              "x-form-name": "50 / 50",
              "x-form-value": "50-50"
            },
            "58-42": {
              "x-form-name": "58 / 42",
              "x-form-value": "58-42"
            },
            "42-58": {
              "x-form-name": "42 / 58",
              "x-form-value": "42-58"
            }
          }
        },
        "divided": {
          "type": "string",
          "x-source": "inject",
          "x-form-group": "content",
          "x-form-label": "Rule between the columns",
          "x-form-type": "materialswitch"
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
  "name": "Splitrow",
  "componentPath": "postervanilla/components/splitrow",
  "package": "com.postervanilla.models",
  "modelName": "Splitrow",
  "classNameParent": "Container"
}
//GEN]
*/

//GEN[:DEF
@Model(
        adaptables = Resource.class,
        resourceType = "postervanilla/components/splitrow",
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL,
        adapters = IComponent.class
)
@Exporter(
        name = "jackson",
        extensions = "json"
)

//GEN]
public class SplitrowModel extends Container {

    public SplitrowModel(final Resource r) { super(r); }

    //GEN[:INJECT
    	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Column ratio","x-form-type":"materialselect","x-default":"50-50","properties":{"50-50":{"x-form-name":"50 / 50","x-form-value":"50-50"},"58-42":{"x-form-name":"58 / 42","x-form-value":"58-42"},"42-58":{"x-form-name":"42 / 58","x-form-value":"42-58"}}} */
	@Inject
	@Default(values ="50-50")
	private String ratio;

	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Rule between the columns","x-form-type":"materialswitch"} */
	@Inject
	private String divided;

	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Visibility","x-form-type":"materialselect","x-default":"all","properties":{"all":{"x-form-name":"Always visible","x-form-value":"all"},"desktop":{"x-form-name":"Desktop only (821px and up)","x-form-value":"desktop"},"mobile":{"x-form-name":"Mobile only (up to 820px)","x-form-value":"mobile"}}} */
	@Inject
	@Default(values ="all")
	private String visibility;


//GEN]

    //GEN[:GETTERS
    	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Column ratio","x-form-type":"materialselect","x-default":"50-50","properties":{"50-50":{"x-form-name":"50 / 50","x-form-value":"50-50"},"58-42":{"x-form-name":"58 / 42","x-form-value":"58-42"},"42-58":{"x-form-name":"42 / 58","x-form-value":"42-58"}}} */
	public String getRatio() {
		return ratio;
	}

	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Rule between the columns","x-form-type":"materialswitch"} */
	public String getDivided() {
		return divided;
	}

	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Visibility","x-form-type":"materialselect","x-default":"all","properties":{"all":{"x-form-name":"Always visible","x-form-value":"all"},"desktop":{"x-form-name":"Desktop only (821px and up)","x-form-value":"desktop"},"mobile":{"x-form-name":"Mobile only (up to 820px)","x-form-value":"mobile"}}} */
	public String getVisibility() {
		return visibility;
	}


//GEN]

    //GEN[:CUSTOMGETTERS
    //GEN]

}
