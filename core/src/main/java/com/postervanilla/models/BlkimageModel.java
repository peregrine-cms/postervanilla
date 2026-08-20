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
    "Blkimage": {
      "type": "object",
      "x-type": "component",
      "properties": {
        "image": {
          "type": "string",
          "x-source": "inject",
          "x-form-group": "content",
          "x-form-label": "Image",
          "x-form-type": "pathbrowser",
          "x-form-browserRoot": "/content"
        },
        "imagealt": {
          "type": "string",
          "x-source": "inject",
          "x-form-group": "content",
          "x-form-label": "Alt text",
          "x-form-type": "text"
        },
        "caption": {
          "type": "string",
          "x-source": "inject",
          "x-form-group": "content",
          "x-form-label": "Caption (under the figure)",
          "x-form-type": "text"
        },
        "videourl": {
          "type": "string",
          "x-source": "inject",
          "x-form-group": "content",
          "x-form-label": "Video (mp4) - used by subtypes",
          "x-form-type": "text"
        },
        "plain": {
          "type": "string",
          "x-source": "inject",
          "x-form-group": "content",
          "x-form-label": "Plain (no border or shadow)",
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
  "name": "Blkimage",
  "componentPath": "postervanilla/components/blkimage",
  "package": "com.postervanilla.models",
  "modelName": "Blkimage",
  "classNameParent": "AbstractComponent"
}
//GEN]
*/

//GEN[:DEF
@Model(
        adaptables = Resource.class,
        resourceType = "postervanilla/components/blkimage",
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL,
        adapters = IComponent.class
)
@Exporter(
        name = "jackson",
        extensions = "json"
)

//GEN]
public class BlkimageModel extends AbstractComponent {

    public BlkimageModel(final Resource r) { super(r); }

    //GEN[:INJECT
    	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Image","x-form-type":"pathbrowser","x-form-browserRoot":"/content"} */
	@Inject
	private String image;

	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Alt text","x-form-type":"text"} */
	@Inject
	private String imagealt;

	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Caption (under the figure)","x-form-type":"text"} */
	@Inject
	private String caption;

	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Video (mp4) - used by subtypes","x-form-type":"text"} */
	@Inject
	private String videourl;

	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Plain (no border or shadow)","x-form-type":"materialswitch"} */
	@Inject
	private String plain;

	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Visibility","x-form-type":"materialselect","x-default":"all","properties":{"all":{"x-form-name":"Always visible","x-form-value":"all"},"desktop":{"x-form-name":"Desktop only (821px and up)","x-form-value":"desktop"},"mobile":{"x-form-name":"Mobile only (up to 820px)","x-form-value":"mobile"}}} */
	@Inject
	@Default(values ="all")
	private String visibility;


//GEN]

    //GEN[:GETTERS
    	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Image","x-form-type":"pathbrowser","x-form-browserRoot":"/content"} */
	public String getImage() {
		return image;
	}

	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Alt text","x-form-type":"text"} */
	public String getImagealt() {
		return imagealt;
	}

	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Caption (under the figure)","x-form-type":"text"} */
	public String getCaption() {
		return caption;
	}

	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Video (mp4) - used by subtypes","x-form-type":"text"} */
	public String getVideourl() {
		return videourl;
	}

	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Plain (no border or shadow)","x-form-type":"materialswitch"} */
	public String getPlain() {
		return plain;
	}

	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Visibility","x-form-type":"materialselect","x-default":"all","properties":{"all":{"x-form-name":"Always visible","x-form-value":"all"},"desktop":{"x-form-name":"Desktop only (821px and up)","x-form-value":"desktop"},"mobile":{"x-form-name":"Mobile only (up to 820px)","x-form-value":"mobile"}}} */
	public String getVisibility() {
		return visibility;
	}


//GEN]

    //GEN[:CUSTOMGETTERS
    //GEN]

}
