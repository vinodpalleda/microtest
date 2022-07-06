package com.spice.smsotpms.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.Mapping;

import com.spice.smsotpms.dto.UserDto;
import com.spice.smsotpms.entity.User;

@Mapper
public interface UserMapper {

	@Mappings({
		@Mapping(target = "username" , source="mobileNo"),
		@Mapping(target = "password", source = "otp")
	})
	UserDto toDto(User user);
	
	Iterable<UserDto> toDto(Iterable<User> user);
}
