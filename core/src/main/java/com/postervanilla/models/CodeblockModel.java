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
    "Codeblock": {
      "type": "object",
      "x-type": "component",
      "properties": {
        "filename": {
          "type": "string",
          "x-source": "inject",
          "x-form-group": "content",
          "x-form-label": "Filename tab (optional)",
          "x-form-type": "text"
        },
        "code": {
          "type": "string",
          "x-source": "inject",
          "x-form-group": "content",
          "x-form-label": "The code, verbatim",
          "x-form-type": "textarea",
          "x-form-rows": 14
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
  "name": "Codeblock",
  "componentPath": "postervanilla/components/codeblock",
  "package": "com.postervanilla.models",
  "modelName": "Codeblock",
  "classNameParent": "AbstractComponent"
}
//GEN]
*/

//GEN[:DEF
@Model(
        adaptables = Resource.class,
        resourceType = "postervanilla/components/codeblock",
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL,
        adapters = IComponent.class
)
@Exporter(
        name = "jackson",
        extensions = "json"
)

//GEN]
public class CodeblockModel extends AbstractComponent {

    public CodeblockModel(final Resource r) { super(r); }

    //GEN[:INJECT
    	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Filename tab (optional)","x-form-type":"text"} */
	@Inject
	private String filename;

	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"The code, verbatim","x-form-type":"textarea","x-form-rows":14} */
	@Inject
	private String code;

	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Visibility","x-form-type":"materialselect","x-default":"all","properties":{"all":{"x-form-name":"Always visible","x-form-value":"all"},"desktop":{"x-form-name":"Desktop only (821px and up)","x-form-value":"desktop"},"mobile":{"x-form-name":"Mobile only (up to 820px)","x-form-value":"mobile"}}} */
	@Inject
	@Default(values ="all")
	private String visibility;


//GEN]

    //GEN[:GETTERS
    	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Filename tab (optional)","x-form-type":"text"} */
	public String getFilename() {
		return filename;
	}

	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"The code, verbatim","x-form-type":"textarea","x-form-rows":14} */
	public String getCode() {
		return code;
	}

	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Visibility","x-form-type":"materialselect","x-default":"all","properties":{"all":{"x-form-name":"Always visible","x-form-value":"all"},"desktop":{"x-form-name":"Desktop only (821px and up)","x-form-value":"desktop"},"mobile":{"x-form-name":"Mobile only (up to 820px)","x-form-value":"mobile"}}} */
	public String getVisibility() {
		return visibility;
	}


//GEN]

    //GEN[:CUSTOMGETTERS
    //GEN]

}
