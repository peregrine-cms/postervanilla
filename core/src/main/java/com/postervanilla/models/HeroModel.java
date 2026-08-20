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
    "Hero": {
      "type": "object",
      "x-type": "component",
      "properties": {
        "title": {
          "type": "string",
          "x-source": "inject",
          "x-form-group": "content",
          "x-form-label": "Headline (kept short - it sets at display size)",
          "x-form-type": "text"
        },
        "footnote": {
          "type": "string",
          "x-source": "inject",
          "x-form-group": "content",
          "x-form-label": "Footnote (the asterisk text)",
          "x-form-type": "text"
        },
        "ctatext": {
          "type": "string",
          "x-source": "inject",
          "x-form-group": "content",
          "x-form-label": "Primary button",
          "x-form-type": "text"
        },
        "ctalink": {
          "type": "string",
          "x-source": "inject",
          "x-form-group": "content",
          "x-form-label": "Primary link",
          "x-form-type": "pathbrowser",
          "x-form-browserRoot": "/content"
        },
        "cta2text": {
          "type": "string",
          "x-source": "inject",
          "x-form-group": "content",
          "x-form-label": "Secondary button",
          "x-form-type": "text"
        },
        "cta2link": {
          "type": "string",
          "x-source": "inject",
          "x-form-group": "content",
          "x-form-label": "Secondary link",
          "x-form-type": "pathbrowser",
          "x-form-browserRoot": "/content"
        },
        "image": {
          "type": "string",
          "x-source": "inject",
          "x-form-group": "content",
          "x-form-label": "Mark (cropped large at the right edge)",
          "x-form-type": "pathbrowser",
          "x-form-browserRoot": "/content"
        },
        "imagealt": {
          "type": "string",
          "x-source": "inject",
          "x-form-group": "content",
          "x-form-label": "Mark alt text",
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
  "name": "Hero",
  "componentPath": "postervanilla/components/hero",
  "package": "com.postervanilla.models",
  "modelName": "Hero",
  "classNameParent": "AbstractComponent"
}
//GEN]
*/

//GEN[:DEF
@Model(
        adaptables = Resource.class,
        resourceType = "postervanilla/components/hero",
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL,
        adapters = IComponent.class
)
@Exporter(
        name = "jackson",
        extensions = "json"
)

//GEN]
public class HeroModel extends AbstractComponent {

    public HeroModel(final Resource r) { super(r); }

    //GEN[:INJECT
    	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Headline (kept short - it sets at display size)","x-form-type":"text"} */
	@Inject
	private String title;

	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Footnote (the asterisk text)","x-form-type":"text"} */
	@Inject
	private String footnote;

	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Primary button","x-form-type":"text"} */
	@Inject
	private String ctatext;

	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Primary link","x-form-type":"pathbrowser","x-form-browserRoot":"/content"} */
	@Inject
	private String ctalink;

	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Secondary button","x-form-type":"text"} */
	@Inject
	private String cta2text;

	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Secondary link","x-form-type":"pathbrowser","x-form-browserRoot":"/content"} */
	@Inject
	private String cta2link;

	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Mark (cropped large at the right edge)","x-form-type":"pathbrowser","x-form-browserRoot":"/content"} */
	@Inject
	private String image;

	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Mark alt text","x-form-type":"text"} */
	@Inject
	private String imagealt;

	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Visibility","x-form-type":"materialselect","x-default":"all","properties":{"all":{"x-form-name":"Always visible","x-form-value":"all"},"desktop":{"x-form-name":"Desktop only (821px and up)","x-form-value":"desktop"},"mobile":{"x-form-name":"Mobile only (up to 820px)","x-form-value":"mobile"}}} */
	@Inject
	@Default(values ="all")
	private String visibility;


//GEN]

    //GEN[:GETTERS
    	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Headline (kept short - it sets at display size)","x-form-type":"text"} */
	public String getTitle() {
		return title;
	}

	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Footnote (the asterisk text)","x-form-type":"text"} */
	public String getFootnote() {
		return footnote;
	}

	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Primary button","x-form-type":"text"} */
	public String getCtatext() {
		return ctatext;
	}

	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Primary link","x-form-type":"pathbrowser","x-form-browserRoot":"/content"} */
	public String getCtalink() {
		return ctalink;
	}

	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Secondary button","x-form-type":"text"} */
	public String getCta2text() {
		return cta2text;
	}

	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Secondary link","x-form-type":"pathbrowser","x-form-browserRoot":"/content"} */
	public String getCta2link() {
		return cta2link;
	}

	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Mark (cropped large at the right edge)","x-form-type":"pathbrowser","x-form-browserRoot":"/content"} */
	public String getImage() {
		return image;
	}

	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Mark alt text","x-form-type":"text"} */
	public String getImagealt() {
		return imagealt;
	}

	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Visibility","x-form-type":"materialselect","x-default":"all","properties":{"all":{"x-form-name":"Always visible","x-form-value":"all"},"desktop":{"x-form-name":"Desktop only (821px and up)","x-form-value":"desktop"},"mobile":{"x-form-name":"Mobile only (up to 820px)","x-form-value":"mobile"}}} */
	public String getVisibility() {
		return visibility;
	}


//GEN]

    //GEN[:CUSTOMGETTERS
    //GEN]

}
