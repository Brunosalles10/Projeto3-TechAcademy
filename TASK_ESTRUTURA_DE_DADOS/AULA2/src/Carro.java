public class Carro {
    public  String modelo;
    public String marca;
    public  String cor;
    public int ano;

    public boolean ehIsentoIPVA (int anoAtual){
        int idadeCarro = anoAtual - this.ano;
        return idadeCarro >= 20;

    }


}
