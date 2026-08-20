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
    "Claims": {
      "type": "object",
      "x-type": "component",
      "properties": {
        "items": {
          "type": "object",
          "x-source": "inject",
          "x-form-group": "content",
          "x-form-label": "Claims",
          "x-form-type": "collection",
          "x-form-fieldLabel": [
            "title"
          ],
          "properties": {
            "title": {
              "type": "string",
              "x-source": "inject",
              "x-form-label": "Claim",
              "x-form-type": "text"
            },
            "text": {
              "type": "string",
              "x-source": "inject",
              "x-form-label": "One supporting sentence",
              "x-form-type": "text"
            }
          }
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
  "name": "Claims",
  "componentPath": "postervanilla/components/claims",
  "package": "com.postervanilla.models",
  "modelName": "Claims",
  "classNameParent": "AbstractComponent"
}
//GEN]
*/

//GEN[:DEF
@Model(
        adaptables = Resource.class,
        resourceType = "postervanilla/components/claims",
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL,
        adapters = IComponent.class
)
@Exporter(
        name = "jackson",
        extensions = "json"
)

//GEN]
public class ClaimsModel extends AbstractComponent {

    public ClaimsModel(final Resource r) { super(r); }

    //GEN[:INJECT
    	/* {"type":"object","x-source":"inject","x-form-group":"content","x-form-label":"Claims","x-form-type":"collection","x-form-fieldLabel":["title"],"properties":{"title":{"type":"string","x-source":"inject","x-form-label":"Claim","x-form-type":"text"},"text":{"type":"string","x-source":"inject","x-form-label":"One supporting sentence","x-form-type":"text"}}} */
	@Inject
	private List<IComponent> items;

	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Visibility","x-form-type":"materialselect","x-default":"all","properties":{"all":{"x-form-name":"Always visible","x-form-value":"all"},"desktop":{"x-form-name":"Desktop only (821px and up)","x-form-value":"desktop"},"mobile":{"x-form-name":"Mobile only (up to 820px)","x-form-value":"mobile"}}} */
	@Inject
	@Default(values ="all")
	private String visibility;


//GEN]

    //GEN[:GETTERS
    	/* {"type":"object","x-source":"inject","x-form-group":"content","x-form-label":"Claims","x-form-type":"collection","x-form-fieldLabel":["title"],"properties":{"title":{"type":"string","x-source":"inject","x-form-label":"Claim","x-form-type":"text"},"text":{"type":"string","x-source":"inject","x-form-label":"One supporting sentence","x-form-type":"text"}}} */
	public List<IComponent> getItems() {
		return items;
	}

	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Visibility","x-form-type":"materialselect","x-default":"all","properties":{"all":{"x-form-name":"Always visible","x-form-value":"all"},"desktop":{"x-form-name":"Desktop only (821px and up)","x-form-value":"desktop"},"mobile":{"x-form-name":"Mobile only (up to 820px)","x-form-value":"mobile"}}} */
	public String getVisibility() {
		return visibility;
	}


//GEN]

    //GEN[:CUSTOMGETTERS
    //GEN]

}
