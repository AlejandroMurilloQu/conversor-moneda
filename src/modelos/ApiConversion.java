package modelos;

import com.google.gson.annotations.SerializedName;

public record ApiConversion(String result, String base_code, String target_code, double conversion_result, @SerializedName("error-type") String errorType) {}


