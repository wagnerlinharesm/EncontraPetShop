import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Petshop {

    private String nome;

    private double distanciaCanil;

    private double precoCaesPequenos;

    private double precoCaesGrandes;

    private double precoCaesPequenosFDS;

    private double precoCaesGrandesFDS;

    private double precoTotal;

    public Petshop(
            String nome,
            double distanciaCanil,
            double precoCaesPequenos,
            double precoCaesGrandes,
            double precoCaesPequenosFDS,
            double precoCaesGrandesFDS
    ) {
        this.nome = nome;
        this.distanciaCanil = distanciaCanil;
        this.precoCaesPequenos = precoCaesPequenos;
        this.precoCaesGrandes = precoCaesGrandes;
        this.precoCaesPequenosFDS = precoCaesPequenosFDS;
        this.precoCaesGrandesFDS = precoCaesGrandesFDS;
    }

    public Petshop(
            String nome,
            double distanciaCanil,
            double precoCaesPequenos,
            double precoCaesGrandes,
            double porcentagemDeAcrescimoFDS
    ) {
        this.nome = nome;
        this.distanciaCanil = distanciaCanil;
        this.precoCaesPequenos = precoCaesPequenos;
        this.precoCaesGrandes = precoCaesGrandes;
        this.precoCaesPequenosFDS = precoCaesPequenos * porcentagemDeAcrescimoFDS;
        this.precoCaesGrandesFDS = precoCaesGrandes * porcentagemDeAcrescimoFDS;
    }
    
    public double calculaPrecoCaesPequenos(String data, int quantidade) {

        double precoTotal = 0.0;

        if (diaSemana(data)) {

            precoTotal = getPrecoCaesPequenos() * quantidade;

        } else {

            precoTotal = getPrecoCaesPequenosFDS() * quantidade;

        }

        return precoTotal;

    }

    public double calculaPrecoCaesGrandes(String data, int quantidade) {

        double precoTotal = 0.0;

        if (diaSemana(data)) {

            precoTotal = getPrecoCaesGrandes() * quantidade;

        } else {

            precoTotal = getPrecoCaesGrandesFDS() * quantidade;

        }

        return precoTotal;

    }

    public void calculaPrecoTotal(String data, int quantidadeCaesGrandes, int quantidadeCaesPequenos) {

        double precoTotal = calculaPrecoCaesPequenos(data, quantidadeCaesPequenos);

        precoTotal += calculaPrecoCaesGrandes(data, quantidadeCaesGrandes);

        setPrecoTotal(precoTotal);

    }

    public boolean diaSemana(String data) {

        try {

            Calendar calendar = Calendar.getInstance();

            SimpleDateFormat simpleFormat = new SimpleDateFormat("dd/MM/yyyy");

            calendar.setTime(simpleFormat.parse(data));

            return calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY
                    && calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY;
        } catch (ParseException e) {

            e.printStackTrace();

        }
        return false;
    }

    @Override
    public String toString() {
        return "Petshop{" +
                "nome='" + nome + '\'' +
                ", distanciaCanil=" + distanciaCanil +
                ", precoCaesPequenos=" + precoCaesPequenos +
                ", precoCaesGrandes=" + precoCaesGrandes +
                ", precoCaesPequenosFDS=" + precoCaesPequenosFDS +
                ", precoCaesGrandesFDS=" + precoCaesGrandesFDS +
                ", precoTotal=" + precoTotal +
                '}';
    }

    public double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;
    }

    public double getPrecoCaesPequenosFDS() {
        return precoCaesPequenosFDS;
    }

    public void setPrecoCaesPequenosFDS(double precoCaesPequenosFDS) {
        this.precoCaesPequenosFDS = precoCaesPequenosFDS;
    }

    public double getPrecoCaesGrandesFDS() {
        return precoCaesGrandesFDS;
    }

    public void setPrecoCaesGrandesFDS(double precoCaesGrandesFDS) {
        this.precoCaesGrandesFDS = precoCaesGrandesFDS;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getDistanciaCanil() {
        return distanciaCanil;
    }

    public void setDistanciaCanil(double distanciaCanil) {
        this.distanciaCanil = distanciaCanil;
    }

    public double getPrecoCaesPequenos() {
        return precoCaesPequenos;
    }

    public void setPrecoCaesPequenos(double precoCaesPequenos) {
        this.precoCaesPequenos = precoCaesPequenos;
    }

    public double getPrecoCaesGrandes() {
        return precoCaesGrandes;
    }

    public void setPrecoCaesGrandes(double precoCaesGrandes) {
        this.precoCaesGrandes = precoCaesGrandes;
    }
}
