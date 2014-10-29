package realdef

class FoodTruckUpdateService extends AbstractAPIHandleService {

    static final String GET_FOOD_TRUCK_API_PATH = 'rqzj-sfat.json'
    static final String GET_LOCATION_API_PATH = 'geocode/json?'
    static final String APPROVED_STATUS_CODE = 'APPROVED'

    def grailsApplication
    def dataSFConfig
    def googleConfig
    String baseDataSFFoodTruckEndPoint
    String baseGoogleLocationEndPoint

    def foodTruckService

    def initialize () {
        dataSFConfig = grailsApplication.config.datasf.api
        googleConfig = grailsApplication.config.google.api

        baseDataSFFoodTruckEndPoint = "${dataSFConfig.endPoint}${GET_FOOD_TRUCK_API_PATH}"
        baseGoogleLocationEndPoint = "${googleConfig.endPoint}${GET_LOCATION_API_PATH}key=${googleConfig.key}&address="
        log.info "FoodTruckUpdateService is initialized."
    }

    void updateFoodTrucks () {
        try {
            def json = readJSONRequest(baseDataSFFoodTruckEndPoint)

            json?.each {
                String addr = it.address as String
                Double lat = (it.latitude)?Double.parseDouble(it.latitude):null
                Double lnt = (it.longitude)?Double.parseDouble(it.longitude):null
                boolean enabled = (it.status as String).equals(APPROVED_STATUS_CODE)

                if (!lat) {
                    def loc = readJSONRequest(baseGoogleLocationEndPoint+URLEncoder.encode(addr,"UTF-8"))?.results
                    if (loc && loc.size() > 0) {
                        String jsonLat = loc[0].geometry.location.lat as String
                        String jsonLnt = loc[0].geometry.location.lnt as String
                        lat = (jsonLat)?Double.parseDouble(jsonLat):null
                        lnt = (jsonLnt)?Double.parseDouble(jsonLnt):null
                    }
                }

                if (!addr && !lat) {
                    enabled = false
                }

                foodTruckService.upsertFoodTruck(it.objectid as String, it.applicant as String, addr, lat, lnt, it.schedule as String, enabled)
            }
        } catch (Exception ex) {
            log.warn "Fail updating food truck due to ${ex.getMessage()}", ex
        }
    }
}
