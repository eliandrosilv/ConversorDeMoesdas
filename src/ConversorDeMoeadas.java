public class ConversorDeMoeadas {
    private final ConsultarMoeadas apiClient;

    public ConversorDeMoeadas(ConsultarMoeadas apiClient) {
        this.apiClient = apiClient;
    }

    public ConversionResult convert(double amount, String fromCurrency, String toCurrency) throws Exception {
        ConversionRate rate = apiClient.getConversionRate(fromCurrency, toCurrency);
        double convertedAmount = amount * rate.rate();
        return new ConversionResult(amount, fromCurrency, convertedAmount, toCurrency);
    }
}
