
package com.wholefood.pojo;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "protein",
    "fat",
    "carb"
})
public class MacroNutrients {

    @JsonProperty("protein")
    private Integer protein;
    @JsonProperty("fat")
    private Integer fat;
    @JsonProperty("carb")
    private Integer carb;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("protein")
    public Integer getProtein() {
        return protein;
    }

    @JsonProperty("protein")
    public void setProtein(Integer protein) {
        this.protein = protein;
    }

    @JsonProperty("fat")
    public Integer getFat() {
        return fat;
    }

    @JsonProperty("fat")
    public void setFat(Integer fat) {
        this.fat = fat;
    }

    @JsonProperty("carb")
    public Integer getCarb() {
        return carb;
    }

    @JsonProperty("carb")
    public void setCarb(Integer carb) {
        this.carb = carb;
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
