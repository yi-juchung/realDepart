package realdef

import grails.converters.JSON
import org.grails.plugin.geolocation.Coordinates
import org.grails.plugin.geolocation.GeoPosition

class HomeController {

    static allowedMethods = [index: 'GET']

    private static final String HAS_ERROR_MODEL = 'hasError'
    private static final String ERROR_MODEL = 'error'
    private static final String FOOD_TRUCK_MODEL = 'foodTrucks'
    private static final String FOOD_TRUCK_NAME_MODEL = 'name'
    private static final String FOOD_TRUCK_SCHE_MODEL = 'schedule'

    def foodTruckService

    def index() {
    }

    def nearByFoodTruck() {
        GeoPosition position = session['position']
        def (GeoPosition paraPos, Double radius) = parseParams(params)

        // query from the request has higher priority
        if (paraPos) {
            position = paraPos
        }

        def model = [:]
        model[HAS_ERROR_MODEL] = false

        if (position) {
            log.info "Request position at ${position.coords.latitude}, ${position.coords.longitude}"

            try {
                List<FoodTruck> foodTrucks
                if (radius) {
                    foodTrucks = foodTruckService.getNearByFoodTrucks(position as GeoPosition, radius)
                } else {
                    foodTrucks = foodTruckService.getNearByFoodTrucks(position as GeoPosition)
                }

                model[FOOD_TRUCK_MODEL] = foodTrucks.collect {
                    def data = [:]
                    data[FOOD_TRUCK_NAME_MODEL] = it.name
                    data[FOOD_TRUCK_SCHE_MODEL] = it.schedule
                    data
                }
            } catch (Exception ex) {
                String err = "Cannot getting near by food trucks due to ${ex.getMessage()}"
                log.error err, ex
                model[HAS_ERROR_MODEL] = true
                model[ERROR_MODEL] = err
            }
        } else {
            String err = "Cannot get positions from browser"
            log.error err
            model[HAS_ERROR_MODEL] = true
            model[ERROR_MODEL] = err
        }

        render model as JSON
    }

    private def parseParams(def params) {
        GeoPosition paraPos
        Double radius
        if (params.lat && params.lnt) {
            paraPos = new GeoPosition(coords: new Coordinates(latitude: params.lat, longitude: params.lnt))
        }

        if (params.radius) {
            radius = Double.parseDouble(params.radius)
        }

        [paraPos, radius]
    }
}
