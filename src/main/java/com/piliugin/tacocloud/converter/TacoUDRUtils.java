package com.piliugin.tacocloud.converter;

import com.piliugin.tacocloud.model.Ingredient;
import com.piliugin.tacocloud.model.Taco;
import com.piliugin.tacocloud.model.udt.IngredientUDT;
import com.piliugin.tacocloud.model.udt.TacoUDT;

import java.util.List;
import java.util.stream.Collectors;

public class TacoUDRUtils {
    public static IngredientUDT toIngredientUDT(Ingredient ingredient) {
        return new IngredientUDT(ingredient.getName(), ingredient.getType());
    }

    public static List<IngredientUDT> toIngredientUDTs(List<Ingredient> ingredients) {
        return ingredients.stream()
                .map(TacoUDRUtils::toIngredientUDT)
                .collect(Collectors.toList());
    }

    public static TacoUDT toTacoUDT(Taco taco) {
        return new TacoUDT(taco.getName(), taco.getIngredients());
    }
}
