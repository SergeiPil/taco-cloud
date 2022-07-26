package com.piliugin.tacocloud.converter;

import com.piliugin.tacocloud.model.Ingredient;
import com.piliugin.tacocloud.model.IngredientRef;

public class IngredientMapper {
    public static IngredientRef toIngredientRef(Ingredient ingredient) {
        return new IngredientRef(ingredient.getId());
    }
}
