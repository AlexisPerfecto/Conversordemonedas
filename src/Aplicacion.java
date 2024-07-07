import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


    public class Aplicacion {

        private ArrayList<Conversion> listaConversiones;


        public Aplicacion() {
            this.listaConversiones = new ArrayList<>();
        }

        public void agregaRegistro(Conversion registro){
            if (registro.getCodigoPaisOrigen() != null && registro.getCodigoPaisDestino()!= null) {
                listaConversiones.add(registro);
            }
        }

        public void mostrarLista(){
            for (Conversion listaConversion : listaConversiones) {
                System.out.println("\n \t RESUMEN DE MOVIMIENTOS REALIZADOS A-One");
                System.out.println(" Codigo Pais Origen: " + listaConversion.getCodigoPaisOrigen() + " |\t Codigo Pais Destino: "
                        + listaConversion.getCodigoPaisDestino() + "\t Importe a Convertir: " + listaConversion.getCantidadAConvertir()
                        + " |\t Importe final convertido: "+ listaConversion.getCantidadConvertida());
                System.out.println("\n");
            }
        }

        public void listaTxt() throws IOException{
            Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                    .setPrettyPrinting()
                    .create();
            FileWriter escritura = new FileWriter("archivo.json");
            escritura.write(gson.toJson(listaConversiones));
            escritura.close();
        }

        @Override
        public String toString() {
            return "Aplicacion{" + ", lista de Conversiones= " + listaConversiones + '}';
        }
}
