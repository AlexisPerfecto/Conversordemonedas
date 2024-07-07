import com.google.gson.Gson;

public class Conversion {

    private String codigoPaisOrigen;
    private String codigoPaisDestino;
    private double cantidadConvertida;
    private double cantidadAConvertir;
    private ConexionApi conexionApi;

    public Conversion() {
        this.conexionApi = new ConexionApi();
    }

    private Conversion(TituloOmbd tituloOmbd) {
        this.codigoPaisOrigen = tituloOmbd.base_code();
        this.codigoPaisDestino = tituloOmbd.target_code();
        this.cantidadConvertida = tituloOmbd.conversion_result();
    }

    public void setCantidadAConvertir(double cantidadAConvertir) {
        this.cantidadAConvertir = cantidadAConvertir;
    }

    public String getCodigoPaisOrigen() {
        return codigoPaisOrigen;
    }

    public String getCodigoPaisDestino() {
        return codigoPaisDestino;
    }

    public double getCantidadConvertida() {
        return cantidadConvertida;
    }

    public double getCantidadAConvertir() {
        return cantidadAConvertir;
    }

    public Conversion convertirMoneda(String codigoPaisOrigen, String codigoPaisDestino,
                                      double cantidadAConvertir) throws Exception
    {
        String key = "b721c67ef3fdd9223cb91c3b";
        String url = "https://v6.exchangerate-api.com/v6/" + key +"/pair/" + codigoPaisOrigen +
                "/"+ codigoPaisDestino + "/"+ cantidadAConvertir;

        String jsonRespuesta = conexionApi.getApiResponse(url);
        Gson gson = new Gson();

        TituloOmbd tituloOmbd = gson.fromJson(jsonRespuesta, TituloOmbd.class);
        Conversion miConversion = new Conversion(tituloOmbd);

        if (validarRespuesta( miConversion )) {
            miConversion.setCantidadAConvertir(cantidadAConvertir);
            mostrarValor(miConversion, cantidadAConvertir);
        } else {
            System.out.println(" El codigo del Pais Origen o codigo del Pais Destino son incorrectos " +
                    "/n Favor de revisarlos");
        }
        return miConversion;
    }

    private void mostrarValor(Conversion convertido, double  cantidad){
        System.out.println("El monto de: " + cantidad + "| De la moneda Origen: "+ convertido.codigoPaisOrigen +
                " a la moneda Destino: " + convertido.codigoPaisDestino);
        System.out.println("es igual a: " + convertido.cantidadConvertida);
    }

    @Override
    public String toString() {
        return "Convertidor{" + "El codigo de Pais Origen " + codigoPaisOrigen + ", al codigo de Pais Destino " +
                codigoPaisDestino + ", da una cantidad Convertida igual a:" + cantidadConvertida +  '}';
    }

    private boolean validarRespuesta(Conversion miConversion) {
        boolean esVerdadero = false;
        if (miConversion.getCodigoPaisOrigen() != null &&   miConversion.getCodigoPaisDestino()!= null) {
            esVerdadero = true ;
        }
        return esVerdadero;
    }
}