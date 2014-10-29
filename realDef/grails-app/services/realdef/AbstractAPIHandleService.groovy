package realdef

import grails.plugins.rest.client.RestBuilder

class AbstractAPIHandleService implements GroovyInterceptable {

    private static final int CONNECTION_TIMEOUT = 1000
    private static final int READ_TIMEOUT = 20000

    protected def readJSONRequest(String fullUrl) {
        def result = null
        if (fullUrl) {
            def rest = createRestClient()

            try {
                def res = rest.get(fullUrl)

                result = res?.getJson()
            } catch (Exception ex) {
                throw new RuntimeException("Error contacting API ${fullUrl}: ${ex.getMessage()}", ex)
            }
        } else {
            throw new IllegalStateException("Cannot determine API URL")
        }
        result
    }

    protected RestBuilder createRestClient() {
        new RestBuilder(connectTimeout:CONNECTION_TIMEOUT, readTimeout:READ_TIMEOUT)
    }
}
