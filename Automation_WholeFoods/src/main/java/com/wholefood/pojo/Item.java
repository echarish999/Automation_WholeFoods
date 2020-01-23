
package com.wholefood.pojo;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "ingredieidnts",
    "macroNutrients"
})
public class Item {

    @JsonProperty("name")
    private String name;
    @JsonProperty("ingredieidnts")
    private List<String> ingredieidnts = null;
    @JsonProperty("macroNutrients")
    private MacroNutrients macroNutrients;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("ingredieidnts")
    public List<String> getIngredieidnts() {
        return ingredieidnts;
    }

    @JsonProperty("ingredieidnts")
    public void setIngredieidnts(List<String> ingredieidnts) {
        this.ingredieidnts = ingredieidnts;
    }

    @JsonProperty("macroNutrients")
    public MacroNutrients getMacroNutrients() {
        return macroNutrients;
    }

    @JsonProperty("macroNutrients")
    public void setMacroNutrients(MacroNutrients macroNutrients) {
        this.macroNutrients = macroNutrients;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
