import java.util.Scanner;

public class Transportadora {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Peso(Kg): ");
        double peso = sc.nextDouble();

        System.out.println("Altura(M): ");
        double altura = sc.nextDouble();

        System.out.println("Largura(M): ");
        double largura = sc.nextDouble();

        System.out.println("Distância(Km): ");
        double distancia = sc.nextDouble();


        System.out.println("1 - Caminhão");
        System.out.println("2 - Avião");
        System.out.println("3 - Porta Container");

        int escolha = sc.nextInt();

        Transporte transporte;

        switch (escolha) {
            case 1:
                transporte = new Caminhao();
                break;
            case 2:
                transporte = new Aviao();
                break;
            case 3:
                transporte = new PortaContainer();

            default:
                transporte = new PortaContainer();
        }

        double frete = valorFrete(transporte, peso, altura, largura, distancia);

        System.out.println("Frete: " + frete);
    }

    public static double valorFrete(Transporte transporte, double peso, double altura, double largura, double distancia) {
        return transporte.calcularFrete(peso, altura, largura, distancia);
    }

    public static abstract class Veiculo {

        private int anoFabrica;
        private String marca;
        private String modelo;
        private int propulsao;

        //Ano de Fabricação
        public int getAnoFabrica() {
            return anoFabrica;
        }

        public void setAnoFabrica(int anoFabrica) {
            this.anoFabrica = anoFabrica;
        }

        //Marca
        public String getMarca() {
            return marca;
        }

        public void setMarca(String marca) {
            this.marca = marca;
        }

        //Modelo
        public String getModelo() {
            return modelo;
        }

        public void setModelo(String modelo) {
            this.modelo = modelo;
        }

        //Propulsão
        public int getPropulsao() {
            return propulsao;
        }

        public void setPropulsao(int propulsao) {
            this.propulsao = propulsao;
        }
    }


    public static class VeiculoTerrestre extends Veiculo {
        private int qtdRodas;
        private int qtdPortas;
        private String placa;
        private int chassi;


        //Quantidade de rodas
        public int getQtdRodas() {
            return qtdRodas;
        }

        public void setQtdRodas(int qtdRodas) {
            this.qtdRodas = qtdRodas;
        }

        //Quantidade de portas
        public int getQtdPortas() {
            return qtdPortas;
        }

        public void setQtdPortas(int qtdPortas) {
            this.qtdPortas = qtdPortas;
        }

        //Placa
        public String getPlaca() {
            return placa;
        }

        public void setPlaca(String placa) {
            this.placa = placa;
        }

        //Chassi
        public int getChassi() {
            return chassi;
        }

        public void setChassi(int chassi) {
            this.chassi = chassi;
        }
    }

    public static class VeiculoAereo extends Veiculo {
        private String RAB;
        private int qtdMotores;

        //Registro Aeronautico Brasileiro, RAB
        public String getRAB() {
            return RAB;
        }

        public void setRAB(String RAB) {
            this.RAB = RAB;
        }

        //Quantidade de motores
        public int getQtdMotores() {
            return qtdMotores;
        }

        public void setQtdMotores(int qtdMotores) {
            this.qtdMotores = qtdMotores;
        }
    }

    public static class VeiculoFluvial extends Veiculo {
        private int regMarinha;
        private int larguraBoca;
        private int alturaCalAereo;
    }

    public static class Caminhao extends VeiculoTerrestre implements Transporte {

        @Override
        public double calcularFrete(double peso, double altura, double largura, double distancia) {
            return (peso + (altura * largura)) * (distancia * 6.99);
            //6.99 = Preço do diesel
        }

        private int qtdEixos;
        private int capacidade;
        private String carroceria;

        //Quantidade de eixos
        public int getQtdEixos() {
            return qtdEixos;
        }

        public void setQtdEixos(int qtdEixos) {
            this.qtdEixos = qtdEixos;
        }

        //Capacidade
        public int getCapacidade() {
            return capacidade;
        }

        public void setCapacidade(int capacidade) {
            this.capacidade = capacidade;
        }

        //Carroceria
        public String getCarroceria() {
            return carroceria;
        }
    }

    public static class Aviao extends VeiculoAereo implements Transporte {

        @Override
        public double calcularFrete(double peso, double altura, double largura, double distancia) {
            return ((peso * peso) * (altura * largura)) * (distancia * 9.99);
            //9.99 = Preço do querosene
        }


        private int capCarga;
        private int MTOW;

        //Capacidade de Carga
        public int getCapCarga() {
            return capCarga;
        }

        public void setCapCarga(int capCarga) {
            this.capCarga = capCarga;
        }

        // Volume e Peso Máximo de Decolagem MTOW
        public int getMTOW() {
            return MTOW;
        }

        public void setMTOW(int MTOW) {
            this.MTOW = MTOW;
        }
    }

    public static class PortaContainer extends VeiculoFluvial implements Transporte {

        @Override
        public double calcularFrete(double peso, double altura, double largura, double distancia) {
            return (peso + (altura * largura) * distancia);
        }

        private int TEU;
        private String categoria;

        //Capacidade de Carga
        public int getTEU() {
            return TEU;
        }

        public void setTEU(int TEU) {
            this.TEU = TEU;
        }

        //Categoria
        public String getCategoria() {
            return categoria;
        }

        public void setCategoria(String categoria) {
            this.categoria = categoria;
        }
    }

    public static interface Transporte {
        double calcularFrete(double peso, double altura, double largura, double distancia);
    }
}