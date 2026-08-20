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
    "Footer": {
      "type": "object",
      "x-type": "component",
      "properties": {
        "brand": {
          "type": "string",
          "x-source": "inject",
          "x-form-group": "content",
          "x-form-label": "Brand",
          "x-form-type": "text"
        },
        "logo": {
          "type": "string",
          "x-source": "inject",
          "x-form-group": "content",
          "x-form-label": "Logo (mark)",
          "x-form-type": "pathbrowser",
          "x-form-browserRoot": "/content"
        },
        "lefttext": {
          "type": "string",
          "x-source": "inject",
          "x-form-group": "content",
          "x-form-label": "Left text (after the brand)",
          "x-form-type": "text"
        },
        "righttext": {
          "type": "string",
          "x-source": "inject",
          "x-form-group": "content",
          "x-form-label": "Right text",
          "x-form-type": "text"
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
  "name": "Footer",
  "componentPath": "postervanilla/components/footer",
  "package": "com.postervanilla.models",
  "modelName": "Footer",
  "classNameParent": "AbstractComponent"
}
//GEN]
*/

//GEN[:DEF
@Model(
        adaptables = Resource.class,
        resourceType = "postervanilla/components/footer",
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL,
        adapters = IComponent.class
)
@Exporter(
        name = "jackson",
        extensions = "json"
)

//GEN]
public class FooterModel extends AbstractComponent {

    public FooterModel(final Resource r) { super(r); }

    //GEN[:INJECT
    	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Brand","x-form-type":"text"} */
	@Inject
	private String brand;

	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Logo (mark)","x-form-type":"pathbrowser","x-form-browserRoot":"/content"} */
	@Inject
	private String logo;

	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Left text (after the brand)","x-form-type":"text"} */
	@Inject
	private String lefttext;

	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Right text","x-form-type":"text"} */
	@Inject
	private String righttext;

	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Visibility","x-form-type":"materialselect","x-default":"all","properties":{"all":{"x-form-name":"Always visible","x-form-value":"all"},"desktop":{"x-form-name":"Desktop only (821px and up)","x-form-value":"desktop"},"mobile":{"x-form-name":"Mobile only (up to 820px)","x-form-value":"mobile"}}} */
	@Inject
	@Default(values ="all")
	private String visibility;


//GEN]

    //GEN[:GETTERS
    	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Brand","x-form-type":"text"} */
	public String getBrand() {
		return brand;
	}

	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Logo (mark)","x-form-type":"pathbrowser","x-form-browserRoot":"/content"} */
	public String getLogo() {
		return logo;
	}

	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Left text (after the brand)","x-form-type":"text"} */
	public String getLefttext() {
		return lefttext;
	}

	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Right text","x-form-type":"text"} */
	public String getRighttext() {
		return righttext;
	}

	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Visibility","x-form-type":"materialselect","x-default":"all","properties":{"all":{"x-form-name":"Always visible","x-form-value":"all"},"desktop":{"x-form-name":"Desktop only (821px and up)","x-form-value":"desktop"},"mobile":{"x-form-name":"Mobile only (up to 820px)","x-form-value":"mobile"}}} */
	public String getVisibility() {
		return visibility;
	}


//GEN]

    //GEN[:CUSTOMGETTERS
    //GEN]

}
