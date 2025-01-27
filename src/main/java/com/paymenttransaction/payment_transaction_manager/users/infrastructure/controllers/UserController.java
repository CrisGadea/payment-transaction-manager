package com.paymenttransaction.payment_transaction_manager.users.infrastructure.controllers;

import com.paymenttransaction.payment_transaction_manager.users.application.dtos.user.UserCreateRequestDTO;
import com.paymenttransaction.payment_transaction_manager.users.application.dtos.user.UserResponseDTO;
import com.paymenttransaction.payment_transaction_manager.users.domain.models.User;
import com.paymenttransaction.payment_transaction_manager.users.domain.services.UserService;
import com.paymenttransaction.payment_transaction_manager.users.infrastructure.mappers.UserMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@Tag(name = "Users", description = "Endpoints for managing users")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    private final UserService service;

    private final UserMapper mapper;

    public UserController(UserMapper mapper, UserService service){
        this.mapper = mapper;
        this.service = service;
    }

    @Operation(summary = "Create a new user", description = "This endpoint allows you to register a new user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User created successfully",
                    content = @Content(schema = @Schema(implementation = UserResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid request", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content)
    })
    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(
            @Valid @RequestBody UserCreateRequestDTO user
            ) {
        log.info("User created with data: {}", user);
        User userCreated = service.execute(mapper.toModel(user));
        UserResponseDTO responseDto = mapper.toResponseDto(userCreated);
        log.info("User created successfully: {}", responseDto);

        return ResponseEntity.status(201).body(responseDto);
    }


}
