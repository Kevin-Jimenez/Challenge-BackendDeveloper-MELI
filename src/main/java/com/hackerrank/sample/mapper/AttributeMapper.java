package com.hackerrank.sample.mapper;

import com.hackerrank.sample.dto.request.AttributeRequestDto;
import com.hackerrank.sample.dto.response.AttributeResponseDto;
import com.hackerrank.sample.model.Attribute;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AttributeMapper {
    @Mapping(source = "id", target = "AttributeId")
    @Mapping(source = "attributeName", target = "attributeName")
    @Mapping(source = "attributeValue", target = "attributeValue")
    AttributeResponseDto toResponseDto(Attribute attribute);

    List<AttributeResponseDto> toResponseDtoList(List<Attribute> attributes);
    @Mapping(source = "attributeName", target = "attributeName")
    @Mapping(source = "attributeValue", target = "attributeValue")
    Attribute toEntity(AttributeRequestDto attributeRequestDto);
}
