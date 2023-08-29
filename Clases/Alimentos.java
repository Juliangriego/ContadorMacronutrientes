package Clases;

public class Alimentos {
    private String nombreAlimento;
    private double proteinas, hidratos, lipidos;

    /*Constructores */
    public Alimentos() {
    }

    public Alimentos(String FnombreAlimento) {
        this.nombreAlimento = FnombreAlimento;
    }

    public Alimentos(String FnombreAlimento, double Fhidratos, double Fproteinas, double Flipidos) {
        this.nombreAlimento = FnombreAlimento;
        this.proteinas = Fproteinas;
        this.hidratos = Fhidratos;
        this.lipidos = Flipidos;
    }

    public void setProteina(double FnuevaProteinas) {
        this.proteinas = FnuevaProteinas;
    }

    // Getters
    public String getNombreAlimento() {
        return this.nombreAlimento;
    }

    /* Setters */
    public void setNombreAlimento(String FnuevoNombre) {
        this.nombreAlimento = FnuevoNombre;
    }

    public Double getProteinas() {
        return this.proteinas;
    }

    public Double getHidratos() {
        return hidratos;
    }

    public void setHidratos(double FnuevosHidratos) {
        this.hidratos = FnuevosHidratos;
    }

    public Double getLipidos() {
        return lipidos;
    }

    public void setLipidos(double FnuevosLipidos) {
        this.lipidos = FnuevosLipidos;
    }

}