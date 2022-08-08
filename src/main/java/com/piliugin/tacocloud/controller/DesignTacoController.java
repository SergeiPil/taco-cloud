package com.piliugin.tacocloud.controller;

import com.piliugin.tacocloud.model.Ingredient;
import com.piliugin.tacocloud.model.Ingredient.Type;
import com.piliugin.tacocloud.model.Taco;
import com.piliugin.tacocloud.model.order.TacoOrder;
import com.piliugin.tacocloud.model.security.User;
import com.piliugin.tacocloud.repository.IngredientRepository;
import com.piliugin.tacocloud.repository.TacoRepository;
import com.piliugin.tacocloud.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
public class DesignTacoController {

    private final IngredientRepository ingredientRepository;

    private final UserRepository userRepository;

    private final TacoRepository tacoRepository;

    public DesignTacoController(IngredientRepository ingredientRepository, UserRepository userRepository, TacoRepository tacoRepository) {
        this.ingredientRepository = ingredientRepository;
        this.userRepository = userRepository;
        this.tacoRepository = tacoRepository;
    }

    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredientRepository.findAll().forEach(ingredients::add);

        Type[] types = Ingredient.Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type));
        }
    }

    @ModelAttribute(name = "tacoOrder")
    public TacoOrder order() {
        return new TacoOrder();
    }

    @ModelAttribute(name = "taco")
    public Taco taco() {
        return new Taco();
    }

    @GetMapping
    public String showDesignForm() {
        return "design";
    }

    @ModelAttribute(name = "user")
    public User user(Principal principal) {
        String username = principal.getName();
        return userRepository.findByUsername(username);
    }

    @PostMapping
    public String processTaco(@Valid Taco taco, Errors errors, @ModelAttribute TacoOrder tacoOrder) {
        if (errors.hasErrors()) {
            log.info("errors -> {}", errors);
            return "design";
        }
        Taco saved = tacoRepository.save(taco);
        tacoOrder.addTaco(saved);
        log.info("Processing taco: {}", taco);

        return "redirect:/orders/current";
    }

    private Iterable<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
        return ingredients.stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }
}
