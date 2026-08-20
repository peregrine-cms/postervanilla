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
    "Blktext": {
      "type": "object",
      "x-type": "component",
      "properties": {
        "text": {
          "type": "string",
          "x-source": "inject",
          "x-form-group": "content",
          "x-form-label": "Text",
          "x-form-type": "texteditor"
        },
        "style": {
          "type": "string",
          "x-source": "inject",
          "x-form-group": "content",
          "x-form-label": "Style",
          "x-form-type": "materialselect",
          "x-default": "body",
          "properties": {
            "body": {
              "x-form-name": "Body",
              "x-form-value": "body"
            },
            "mono": {
              "x-form-name": "Mono",
              "x-form-value": "mono"
            },
            "footnote": {
              "x-form-name": "Footnote (mono, small)",
              "x-form-value": "footnote"
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
  "name": "Blktext",
  "componentPath": "postervanilla/components/blktext",
  "package": "com.postervanilla.models",
  "modelName": "Blktext",
  "classNameParent": "AbstractComponent"
}
//GEN]
*/

//GEN[:DEF
@Model(
        adaptables = Resource.class,
        resourceType = "postervanilla/components/blktext",
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL,
        adapters = IComponent.class
)
@Exporter(
        name = "jackson",
        extensions = "json"
)

//GEN]
public class BlktextModel extends AbstractComponent {

    public BlktextModel(final Resource r) { super(r); }

    //GEN[:INJECT
    	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Text","x-form-type":"texteditor"} */
	@Inject
	private String text;

	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Style","x-form-type":"materialselect","x-default":"body","properties":{"body":{"x-form-name":"Body","x-form-value":"body"},"mono":{"x-form-name":"Mono","x-form-value":"mono"},"footnote":{"x-form-name":"Footnote (mono, small)","x-form-value":"footnote"}}} */
	@Inject
	@Default(values ="body")
	private String style;

	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Visibility","x-form-type":"materialselect","x-default":"all","properties":{"all":{"x-form-name":"Always visible","x-form-value":"all"},"desktop":{"x-form-name":"Desktop only (821px and up)","x-form-value":"desktop"},"mobile":{"x-form-name":"Mobile only (up to 820px)","x-form-value":"mobile"}}} */
	@Inject
	@Default(values ="all")
	private String visibility;


//GEN]

    //GEN[:GETTERS
    	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Text","x-form-type":"texteditor"} */
	public String getText() {
		return text;
	}

	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Style","x-form-type":"materialselect","x-default":"body","properties":{"body":{"x-form-name":"Body","x-form-value":"body"},"mono":{"x-form-name":"Mono","x-form-value":"mono"},"footnote":{"x-form-name":"Footnote (mono, small)","x-form-value":"footnote"}}} */
	public String getStyle() {
		return style;
	}

	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Visibility","x-form-type":"materialselect","x-default":"all","properties":{"all":{"x-form-name":"Always visible","x-form-value":"all"},"desktop":{"x-form-name":"Desktop only (821px and up)","x-form-value":"desktop"},"mobile":{"x-form-name":"Mobile only (up to 820px)","x-form-value":"mobile"}}} */
	public String getVisibility() {
		return visibility;
	}


//GEN]

    //GEN[:CUSTOMGETTERS
    //GEN]

}
