package com.hackerrank.sample.mapper;

import com.hackerrank.sample.dto.response.CategoryResponseDto;
import com.hackerrank.sample.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CategoryMapper {

    CategoryResponseDto toResponseDto(Category category);
}
