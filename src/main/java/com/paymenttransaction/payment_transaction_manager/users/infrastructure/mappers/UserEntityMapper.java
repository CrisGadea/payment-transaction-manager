package com.paymenttransaction.payment_transaction_manager.users.infrastructure.mappers;

import com.paymenttransaction.payment_transaction_manager.users.domain.models.User;
import com.paymenttransaction.payment_transaction_manager.users.infrastructure.entities.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserEntityMapper {

    UserEntityMapper INSTANCE = Mappers.getMapper(UserEntityMapper.class);

    User toModel(UserEntity entity);

    UserEntity toEntity(User user);
}
