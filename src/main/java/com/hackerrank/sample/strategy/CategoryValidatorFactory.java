package com.hackerrank.sample.strategy;

import com.hackerrank.sample.constants.Constants;
import com.hackerrank.sample.strategy.impl.DefaultCategoryValidator;
import com.hackerrank.sample.strategy.impl.DeportsFitnessCategoryValidator;
import com.hackerrank.sample.strategy.impl.FurnitureCategoryValidator;
import com.hackerrank.sample.strategy.impl.TechnologieCategoryValidator;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CategoryValidatorFactory {

    private static final Map<String, CategoryValidatorStrategy> strategyMap = new HashMap<>();

    static {
        strategyMap.put(Constants.TECNOLOGI_CATEGORY, new TechnologieCategoryValidator());
        strategyMap.put(Constants.FURNITURE_CATEGORY, new FurnitureCategoryValidator());
        strategyMap.put(Constants.DEPORTS_FITNESS_CATEGORY, new DeportsFitnessCategoryValidator());
    }

    public CategoryValidatorStrategy getCategoryValidatorStrategy(String categoryName){
        return strategyMap.getOrDefault(categoryName.toUpperCase(), new DefaultCategoryValidator());
    }
}
