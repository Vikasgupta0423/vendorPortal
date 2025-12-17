package vendorPortal.auth.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.authentication.PasswordEncoderParser;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import vendorPortal.auth.Repository.UserRepository;
import vendorPortal.auth.entity.UserEntity;
import vendorPortal.auth.io.ProfileRequest;
import vendorPortal.auth.io.ProfileResponse;

import java.util.UUID;

@Service
@RequiredArgsConstructor

public class ProfileServiceImpl implements ProfileService{

    private final UserRepository userRespository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public ProfileResponse createProfile(ProfileRequest request) {
         UserEntity newProfile = convertToUserEntity(request);

         if(!userRespository.existsByEmail(request.getEmail())) {
            newProfile = userRespository.save(newProfile);
             return convertToProfileResponse(newProfile);
         }
       throw new ResponseStatusException(HttpStatus.CONFLICT, "Email already exists");

    }

    private ProfileResponse convertToProfileResponse(UserEntity newProfile) {
        return ProfileResponse.builder()
                .name(newProfile.getName())
                .email(newProfile.getEmail())
                .userId(newProfile.getUserId())
                .isAccountVerified(newProfile.getIsAccountVerified())
                .build();
    }

    private UserEntity convertToUserEntity(ProfileRequest request) {
      return UserEntity.builder()
                .email(request.getEmail())
                .userId(UUID.randomUUID().toString())
                .name(request.getName())
                .password(passwordEncoder.encode(request.getPassword()))
                .isAccountVerified(false)
                .resetOtpExpireAt(0L)
                .verifyOtp(null)
                .verifyOtpExpireAt(0L)
                .resetOtp(null)
                .build();

    }


    @Override
    public ProfileResponse getProfile(String email) {
        UserEntity existingUser = userRespository.findByEmail(email)
                .orElseThrow(()-> new UsernameNotFoundException("User not found: " + email));
        return convertToProfileResponse(existingUser);
    }
}
