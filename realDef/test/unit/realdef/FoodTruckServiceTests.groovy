package realdef

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import org.grails.plugin.geolocation.Coordinates
import org.grails.plugin.geolocation.GeoPosition
import org.grails.plugin.geolocation.GeolocationService
import org.junit.Test

@TestFor(FoodTruckService)
@Mock([FoodTruck])
class FoodTruckServiceTests {

    @Test
    public void testUpsertFoodTruck() {
        FoodTruck ft1 = service.upsertFoodTruck("foodTruck1","Burger", "2323 East Rd", 12.34567, 45.6789, "http://www.aaa.ccc",true)
        String newName = "Burger King"
        service.upsertFoodTruck("foodTruck1",newName , "2324 East Rd", 12.34567, 45.6789, "http://www.aaa.ccc/kkk",true)

        assertEquals("should be updated", newName, ft1.name)
    }

    @Test
    public void testGetNearByFoodTrucks() {
        defineBeans {
            geolocationService(GeolocationService)
        }
        grailsApplication.config.geolocation.length.unit = "MILE"
        service.geolocationService.grailsApplication = grailsApplication

        FoodTruck ft1 = service.upsertFoodTruck("foodTruck1","Burger", "2323 East Rd", 10, 10, "http://www.aaa.ccc",false)
        FoodTruck ft2 = service.upsertFoodTruck("foodTruck2","Burger", "2323 East Rd", 20, 20, "http://www.aaa.ccc",true)
        FoodTruck ft3 = service.upsertFoodTruck("foodTruck3","Burger", "2323 East Rd", 22, 22, "http://www.aaa.ccc",true)
        FoodTruck ft4 = service.upsertFoodTruck("foodTruck4","Burger", "2323 East Rd", 24, 24, "http://www.aaa.ccc",true)
        FoodTruck ft5 = service.upsertFoodTruck("foodTruck5","Burger", "2323 East Rd", 26, 26, "http://www.aaa.ccc",true)

        GeoPosition geoPosition = new GeoPosition(coords: new Coordinates(latitude: 20, longitude: 20))
        List<FoodTruck> foodTrucks = service.getNearByFoodTrucks(geoPosition, 200)

        assertEquals("should only 2 of them are returned", 2, foodTrucks.size())
        assertEquals("include ft2",ft2,foodTrucks.get(0))
        assertEquals("include ft3",ft3,foodTrucks.get(1))
    }
}
