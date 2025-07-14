package com.vietsoftware.demo_ai.mapper;

import com.vietsoftware.demo_ai.model.EmployeeEntity;
import com.vietsoftware.demo_ai.request.EmployeeRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    @Mapping(target = "id", ignore = true)
    EmployeeEntity toEntity(EmployeeRequest request);
}
