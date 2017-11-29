package signage.digital.com.digitalsignage.model;



/**
 * Created by fung.lam on 02/09/2015.
 * for openweathermap webservice call
 */
public class WundergroundError {

    UndergroundResponse response;

    public UndergroundResponse getResponse() {
        return response;
    }

    public class UndergroundResponse{
        String version;

        String termsofService;

        ErrorWunderground error;

        public String getVersion() {
            return version;
        }

        public String getTermsofService() {
            return termsofService;
        }

        public ErrorWunderground getError() {
            return error;
        }

        public class ErrorWunderground{
            String type;

            String description;

            public String getType() {
                return type;
            }

            public String getDescription() {
                return description;
            }
        }
    }
}

