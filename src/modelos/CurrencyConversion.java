package modelos;

public class CurrencyConversion {
    private String baseName;
    private String targetName;
    private String baseCode;
    private String targetCode;

    public CurrencyConversion(String baseName, String targetName, String baseCode, String targetCode) {
        this.baseName = baseName;
        this.targetName = targetName;
        this.baseCode = baseCode;
        this.targetCode = targetCode;
    }

    public String getBaseName() {
        return baseName;
    }

    public String getTargetName() {
        return targetName;
    }

    public String getBaseCode() {
        return baseCode;
    }

    public String getTargetCode() {
        return targetCode;
    }
}
