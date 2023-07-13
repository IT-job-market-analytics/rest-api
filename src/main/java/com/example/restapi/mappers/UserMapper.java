package com.example.restapi.mappers;

import com.example.restapi.dto.user.GetUserDto;
import com.example.restapi.dto.user.UserCreateDto;
import com.example.restapi.models.User;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import static org.modelmapper.config.Configuration.AccessLevel.PRIVATE;

@Component
public class UserMapper {
    private final ModelMapper modelMapper;

    public UserMapper() {
        this.modelMapper = new ModelMapper();

        this.modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STANDARD)
                .setFieldMatchingEnabled(true)
                .setSkipNullEnabled(true)
                .setFieldAccessLevel(PRIVATE);
    }

    public User toEntity(UserCreateDto userCreateDto){
        return modelMapper.map(userCreateDto, User.class);
    }

    public GetUserDto toGetUserDto(User  user){
        return modelMapper.map(user, GetUserDto.class);
    }
}
