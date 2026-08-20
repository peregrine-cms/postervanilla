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
    "Ticker": {
      "type": "object",
      "x-type": "component",
      "properties": {
        "text": {
          "type": "string",
          "x-source": "inject",
          "x-form-group": "content",
          "x-form-label": "Ticker text (wrap a stretch in ** for orange)",
          "x-form-type": "text"
        },
        "speed": {
          "type": "string",
          "x-source": "inject",
          "x-form-group": "content",
          "x-form-label": "Speed",
          "x-form-type": "materialselect",
          "x-default": "normal",
          "properties": {
            "slow": {
              "x-form-name": "Slow",
              "x-form-value": "slow"
            },
            "normal": {
              "x-form-name": "Normal",
              "x-form-value": "normal"
            },
            "fast": {
              "x-form-name": "Fast",
              "x-form-value": "fast"
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
  "name": "Ticker",
  "componentPath": "postervanilla/components/ticker",
  "package": "com.postervanilla.models",
  "modelName": "Ticker",
  "classNameParent": "AbstractComponent"
}
//GEN]
*/

//GEN[:DEF
@Model(
        adaptables = Resource.class,
        resourceType = "postervanilla/components/ticker",
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL,
        adapters = IComponent.class
)
@Exporter(
        name = "jackson",
        extensions = "json"
)

//GEN]
public class TickerModel extends AbstractComponent {

    public TickerModel(final Resource r) { super(r); }

    //GEN[:INJECT
    	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Ticker text (wrap a stretch in ** for orange)","x-form-type":"text"} */
	@Inject
	private String text;

	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Speed","x-form-type":"materialselect","x-default":"normal","properties":{"slow":{"x-form-name":"Slow","x-form-value":"slow"},"normal":{"x-form-name":"Normal","x-form-value":"normal"},"fast":{"x-form-name":"Fast","x-form-value":"fast"}}} */
	@Inject
	@Default(values ="normal")
	private String speed;

	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Visibility","x-form-type":"materialselect","x-default":"all","properties":{"all":{"x-form-name":"Always visible","x-form-value":"all"},"desktop":{"x-form-name":"Desktop only (821px and up)","x-form-value":"desktop"},"mobile":{"x-form-name":"Mobile only (up to 820px)","x-form-value":"mobile"}}} */
	@Inject
	@Default(values ="all")
	private String visibility;


//GEN]

    //GEN[:GETTERS
    	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Ticker text (wrap a stretch in ** for orange)","x-form-type":"text"} */
	public String getText() {
		return text;
	}

	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Speed","x-form-type":"materialselect","x-default":"normal","properties":{"slow":{"x-form-name":"Slow","x-form-value":"slow"},"normal":{"x-form-name":"Normal","x-form-value":"normal"},"fast":{"x-form-name":"Fast","x-form-value":"fast"}}} */
	public String getSpeed() {
		return speed;
	}

	/* {"type":"string","x-source":"inject","x-form-group":"content","x-form-label":"Visibility","x-form-type":"materialselect","x-default":"all","properties":{"all":{"x-form-name":"Always visible","x-form-value":"all"},"desktop":{"x-form-name":"Desktop only (821px and up)","x-form-value":"desktop"},"mobile":{"x-form-name":"Mobile only (up to 820px)","x-form-value":"mobile"}}} */
	public String getVisibility() {
		return visibility;
	}


//GEN]

    //GEN[:CUSTOMGETTERS
    //GEN]

}
