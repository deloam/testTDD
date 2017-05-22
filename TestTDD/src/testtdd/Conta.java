
package testtdd;
/**
 *
 * @author Deloam 
 */
public class Conta {
    private double saldo;
    private String nome;
    private int idade;
    private int numConta;
    private boolean ativa;
    
    public Conta(){
        setAtiva(true);
        setSaldo(0);
    }
    
    public void criarConta(String nome, int idade, int numConta) {
        setNome(nome);
        setIdade(idade);
        setNumConta(numConta);
        setAtiva(true);
        setSaldo(0);
    }
    public void deposito(double deposito) {
        if(getAtiva()) {
            setSaldo(getSaldo()+deposito);
        } else {
            System.out.println("conta inativa");
        }
    }
    public void saque(double saque){
        if(getAtiva()){
            if(saque > getSaldo()){
                System.out.println("saldo insuficiente");
            } else {
                setSaldo(getSaldo()-saque);
            }
        } else {
            System.out.println("conta inativa");
        }
    }
    public void encerrarConta(){
        setAtiva(false);
    }
    public double consultarSaldo() {
        if(getAtiva()){
            return getSaldo();
        }else {
            return Double.NaN;
        }
    }
    public void transferencia (Conta conta, double valor) {
        if(conta.getAtiva()){
            if (getSaldo()<valor) {
                System.out.println("saldo insuficiente");
            } else {
                setSaldo(getSaldo()-valor);
                conta.setSaldo(conta.getSaldo()+valor);
            }
        } else {
            System.out.println("conta inativa");
        }
    }
    
    public double getSaldo() {
        return saldo;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public int getNumConta() {
        return numConta;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public boolean getAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }
    
}
