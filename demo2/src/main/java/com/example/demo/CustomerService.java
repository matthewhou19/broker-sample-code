package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;

@Service
public class CustomerService {

    private final CustomerResponseRepository repository;


    public CustomerService(CustomerResponseRepository repository) {
        this.repository = repository;
    }


    // This method validates the pickup&dropoff data provided by the user.
    public boolean validateInput(String pickupZip, String pickupState, String dropoffZip, String dropoffState, String pickupRadius, String dropoffRadius, CustomerRequest request) {
        if (!validatePickupLocation(pickupZip, pickupState)) return false;
        if (!validateDropoffLocation(dropoffZip, dropoffState)) return false;
        if (!validateRadius(pickupZip, dropoffZip, pickupRadius, dropoffRadius)) return false;
        return  true;
    }

    public List<CustomerRespondEntity> filterResponseData(String pickupZip, String pickupState, String dropoffZip, String dropoffState) {
        if (pickupZip != null && dropoffZip != null) {
            // Case 1: Zip for both pickup and dropoff
            return repository.findByOriginZipCodeAndDestinationZipCode(pickupZip, dropoffZip);
        } else if (pickupZip != null && dropoffState != null) {
            // Case 2: Zip for pickup and State for dropoff
            return repository.findByOriginZipCodeAndDestinationState(pickupZip, dropoffState);
        } else if (pickupState != null && dropoffState != null) {
            // Case 3: State for both pickup and dropoff
            return repository.findByOriginStateAndDestinationState(pickupState, dropoffState);
        } else if (pickupState != null && dropoffZip != null) {
            // Case 4: State for pickup and Zip for dropoff
            return repository.findByOriginStateAndDestinationZipCode(pickupState, dropoffZip);
        }

        return List.of();
    }




    private boolean validatePickupLocation(String pickupZip, String pickupState) {
        if (pickupZip != null) {
            return pickupState == null || pickupState.isEmpty();
        } else {
            return pickupState != null && !pickupState.isEmpty();
        }
    }

    private boolean validateDropoffLocation(String dropoffZip, String dropoffState) {
        if (dropoffZip != null) {
            return dropoffState == null || dropoffState.isEmpty();
        } else {
            return dropoffState != null && !dropoffState.isEmpty();
        }
    }

    private boolean validateRadius(String pickupZip, String dropoffZip, String pickupRadius, String dropoffRadius) {
        if (pickupZip != null && (pickupRadius == null || pickupRadius.isEmpty())) {
            return false;
        }
        if (dropoffZip != null && (dropoffRadius == null || dropoffRadius.isEmpty())) {
            return false;
        }
        return true;
    }
}
