package be.vdab.parkingproducer;

import jakarta.validation.constraints.PositiveOrZero;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("parkings")
class ParkingController {
    private final ParkingService parkingService;

    ParkingController(ParkingService parkingService) {
        this.parkingService = parkingService;
    }
    @PatchMapping("{naam}/vrijePlaatsen")
    void updateVrijePlaatsen(@PathVariable String naam,
                             @RequestBody @PositiveOrZero int vrijePlaatsen){
        parkingService.updateVrijePlaatsen(naam, vrijePlaatsen);
    }
}
