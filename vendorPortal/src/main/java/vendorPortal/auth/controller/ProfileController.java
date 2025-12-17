package vendorPortal.auth.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.web.bind.annotation.*;
import vendorPortal.auth.io.ProfileRequest;
import vendorPortal.auth.io.ProfileResponse;
import vendorPortal.auth.service.ProfileService;

@RestController
public class ProfileController {

    @Autowired
    ProfileService profileService;

    @PostMapping("/register")
    public ProfileResponse register(@Valid @RequestBody ProfileRequest request){
        ProfileResponse response = profileService.createProfile(request);
        return response;
    }

    @GetMapping("/profile")
    public ProfileResponse getProfile(@CurrentSecurityContext(expression = "authentication?.name") String email){

        return profileService.getProfile(email);
    }
}
