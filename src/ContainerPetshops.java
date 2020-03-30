import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.ArrayList;

public class ContainerPetshops {

    private ArrayList<Petshop> containerPetshops = new ArrayList();

    public boolean validaData(String data) {

        String dateFormat = "dd/MM/uuuu";

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter
                .ofPattern(dateFormat)
                .withResolverStyle(ResolverStyle.STRICT);
        try {

            LocalDate.parse(data, dateTimeFormatter);

            return true;

        } catch (DateTimeParseException e) {

            return false;

        }
    }

    public boolean validaNumero(String num) {
        try {

            Integer.parseInt(num);

            return true;

        } catch (NumberFormatException ex) {

            return false;

        }
    }

    public Petshop melhorPetshop(String data, int quantidadeCaesGrandes, int quantidadeCaesPequenos) {

        Petshop petshopIdeal = containerPetshops.get(0);

        double menorPreco = Double.POSITIVE_INFINITY;

        for (Petshop petShop : containerPetshops) {

            petShop.calculaPrecoTotal(data, quantidadeCaesGrandes, quantidadeCaesPequenos);

            if (petShop.getPrecoTotal() < menorPreco) {

                petshopIdeal = petShop;

                menorPreco = petshopIdeal.getPrecoTotal();

            } else if (petShop.getPrecoTotal() == menorPreco) {

                if (petShop.getDistanciaCanil() < petshopIdeal.getDistanciaCanil()){

                    petshopIdeal = petShop;

                    menorPreco = petshopIdeal.getPrecoTotal();

                }
            }

        }
        return petshopIdeal;
    }

    public ArrayList<Petshop> getContainerPetshops() {
        return containerPetshops;
    }

    public void setContainerPetshops(ArrayList<Petshop> containerPetshops) {
        this.containerPetshops = containerPetshops;
    }
}
