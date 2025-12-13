package vendorPortal.auth.service;

import vendorPortal.auth.io.ProfileRequest;
import vendorPortal.auth.io.ProfileResponse;

public interface ProfileService {

   ProfileResponse createProfile(ProfileRequest request);
}
