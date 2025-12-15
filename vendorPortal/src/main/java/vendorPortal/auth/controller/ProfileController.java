package vendorPortal.auth.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vendorPortal.auth.io.ProfileRequest;
import vendorPortal.auth.io.ProfileResponse;
import vendorPortal.auth.service.ProfileService;

@RestController
@RequestMapping("/api/v1.0")
public class ProfileController {

    @Autowired
    ProfileService profileService;

    @PostMapping("/register")
    public ProfileResponse register(@Valid @RequestBody ProfileRequest request){
        ProfileResponse response = profileService.createProfile(request);
        return response;
    }
}
