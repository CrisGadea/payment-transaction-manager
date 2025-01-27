package com.paymenttransaction.payment_transaction_manager.users.infrastructure.mappers;

import com.paymenttransaction.payment_transaction_manager.users.application.dtos.user.UserCreateRequestDTO;
import com.paymenttransaction.payment_transaction_manager.users.application.dtos.user.UserResponseDTO;
import com.paymenttransaction.payment_transaction_manager.users.domain.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    User toModel(UserCreateRequestDTO dto);


    UserResponseDTO toResponseDto(User user);
}
