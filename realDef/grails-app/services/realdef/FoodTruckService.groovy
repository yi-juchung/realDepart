package realdef

import grails.transaction.Transactional
import org.grails.plugin.geolocation.Coordinates
import org.grails.plugin.geolocation.GeoPosition

class FoodTruckService {

    private static final double DEFAULT_RADIUS = 1

    def geolocationService

    @Transactional
    FoodTruck upsertFoodTruck(String objectId, String name, String address, Double latitude, Double longitude, String schedule, boolean enabled) {
        FoodTruck res = FoodTruck.findByObjectId(objectId)

        if (res) {
            if (res.enabled != enabled || !res.name.equals(name) || !res.addr.equals(address) || res.latitude != latitude || res.longitude != longitude || !res.schedule.equals(schedule)) {
                res.name = name
                res.addr = address
                res.latitude = latitude
                res.longitude = longitude
                res.schedule = schedule
                res.enabled = enabled
                res.save()
            }
        } else {
            res = new FoodTruck(objectId: objectId, name: name, addr: address, latitude: latitude, longitude: longitude, schedule: schedule, enabled: enabled).save()
        }

        log.info "Food truck: ${res.name} - ${res.objectId} upserted"

        res
    }

    @Transactional(readOnly = true)
    List<FoodTruck> getNearByFoodTrucks(GeoPosition ori, double radius = DEFAULT_RADIUS) {
        List<FoodTruck> foodTrucks = FoodTruck.findAllByEnabled(true)

        foodTrucks.removeAll {
            GeoPosition tar = new GeoPosition(coords: new Coordinates(latitude: it.latitude, longitude: it.longitude))
            !geolocationService.isInRange(ori, tar, radius)
        }

        foodTrucks
    }
}
