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
    "Indexlist": {
      "type": "object",
      "x-type": "component",
      "properties": {
        "items": {
          "type": "object",
          "x-source": "inject",
          "x-form-group": "content",
          "x-form-label": "Rows",
          "x-form-type": "collection",
          "x-form-fieldLabel": [
            "title"
          ],
          "properties": {
            "title": {
              "type": "string",
              "x-source": "inject",
              "x-form-label": "Title",
              "x-form-type": "text"
            },
            "tag": {
              "type": "string",
              "x-source": "inject",
              "x-form-label": "Tag (right-hand label)",
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
        "startat": {
          "type": "string",
          "x-source": "inject",
          "x-form-group": "content",
          "x-form-label": "First number",
          "x-form-type": "text",
          "x-default": "1"
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
  "name": "Indexlist",
  "componentPath": "postervanilla/components/indexlist",
  "package": "com.postervanilla.models",
  "modelName": "Indexlist",
  "classNameParent": "AbstractComponent"
}
//GEN]
*/

//GEN[:DEF
@Model(
        adaptables = Resource.class,
        resourceType = "postervanilla/components/indexlist",
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL,
        adapters = IComponent.class
)
@Exporter(
        name = "jackson",
        extensions = "json"
)

//GEN]
public class IndexlistModel extends AbstractComponent {

    public IndexlistModel(final Resource r) { super(r); }

    //GEN[:INJECT
    	/* {"type":"object","x-source":"inject","x-form-group":"content","x-form-label":"Rows","x-form-type":"collection","x-form-fieldLabel":["title"],"properties":{"title":{"type":"string","x-source":"inject","x-form-label":"Title","x-form-type":"text"},"tag":{"type":"string","x-source":"inject","x-form-label":"Tag (right-hand label)","x-form-type":"text"},"link":{"type":"string","x-source":"inject","x-form-label":"Link","x-form-type":"pathbrowser","x-form-browserRoot":"/content"}}} */
	@Inject
	private List<IComponent> items;

	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"First number","x-form-type":"text","x-default":"1"} */
	@Inject
	@Default(values ="1")
	private String startat;

	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Visibility","x-form-type":"materialselect","x-default":"all","properties":{"all":{"x-form-name":"Always visible","x-form-value":"all"},"desktop":{"x-form-name":"Desktop only (821px and up)","x-form-value":"desktop"},"mobile":{"x-form-name":"Mobile only (up to 820px)","x-form-value":"mobile"}}} */
	@Inject
	@Default(values ="all")
	private String visibility;


//GEN]

    //GEN[:GETTERS
    	/* {"type":"object","x-source":"inject","x-form-group":"content","x-form-label":"Rows","x-form-type":"collection","x-form-fieldLabel":["title"],"properties":{"title":{"type":"string","x-source":"inject","x-form-label":"Title","x-form-type":"text"},"tag":{"type":"string","x-source":"inject","x-form-label":"Tag (right-hand label)","x-form-type":"text"},"link":{"type":"string","x-source":"inject","x-form-label":"Link","x-form-type":"pathbrowser","x-form-browserRoot":"/content"}}} */
	public List<IComponent> getItems() {
		return items;
	}

	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"First number","x-form-type":"text","x-default":"1"} */
	public String getStartat() {
		return startat;
	}

	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Visibility","x-form-type":"materialselect","x-default":"all","properties":{"all":{"x-form-name":"Always visible","x-form-value":"all"},"desktop":{"x-form-name":"Desktop only (821px and up)","x-form-value":"desktop"},"mobile":{"x-form-name":"Mobile only (up to 820px)","x-form-value":"mobile"}}} */
	public String getVisibility() {
		return visibility;
	}


//GEN]

    //GEN[:CUSTOMGETTERS
    //GEN]

}
