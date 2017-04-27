package signage.digital.com.digitalsignage.model;

import com.google.gson.annotations.SerializedName;


/**
 * Created by fung.lam on 02/09/2015.
 * for openweathermap webservice call
 */
public class WundergroundError {

    @SerializedName("response")
    UndergroundResponse response;

    public UndergroundResponse getResponse() {
        return response;
    }

    public class UndergroundResponse{
        @SerializedName("version")
        String version;

        @SerializedName("termsofService")
        String termsofService;

        @SerializedName("error")
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
            @SerializedName("type")
            String type;

            @SerializedName("description")
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

