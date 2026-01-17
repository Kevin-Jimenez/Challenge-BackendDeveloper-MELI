package com.hackerrank.sample.mapper;

import com.hackerrank.sample.dto.response.VendorResponseDto;
import com.hackerrank.sample.model.Vendor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface VendorMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "vendorName", target = "vendorName")
    @Mapping(source = "vendorLocation", target = "vendorLocation")
    @Mapping(source = "vendorCategory.id", target = "vendorCategory")
    VendorResponseDto toResponseDto(Vendor vendor);
}
