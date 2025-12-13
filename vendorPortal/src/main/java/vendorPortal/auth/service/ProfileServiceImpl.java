package vendorPortal.auth.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vendorPortal.auth.Repository.UserRepository;
import vendorPortal.auth.entity.UserEntity;
import vendorPortal.auth.io.ProfileRequest;
import vendorPortal.auth.io.ProfileResponse;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService{

    private  UserRepository userRespository;


    @Override
    public ProfileResponse createProfile(ProfileRequest request) {
         UserEntity newProfile = convertToUserEntity(request);

         userRespository.save(newProfile);
        return convertToProfileResponse(newProfile);
    }

    private ProfileResponse convertToProfileResponse(UserEntity newProfile) {
    }

    private UserEntity convertToUserEntity(ProfileRequest request) {
//        UserEntity.
        return  null;
    }
}
