public class Banco {

    //Atributos
    public int numConta;
    protected String tipoConta, dono;
    private float saldo;
    private boolean status;


    //Método Construtor

    public Banco()
    {
        this.saldo = 0;
        this.status = false;
    }

    //Métodos:

    //Métodos Getters e Setters

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }
    public int getNumConta() {
        return numConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }
    public String getTipoConta() {
        return tipoConta;
    }
    public void setDono(String dono) {
        this.dono = dono;
    }
    public String getDono() {
        return dono;
    }
    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
    public float getSaldo() {
        return saldo;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
    public boolean getStatus() {
        return status;
    }

    //Métodos Adicionais : 

    public void abrirConta(String t)
    {
        setTipoConta(t);
        setStatus(true);
        if (t == "cc") {
            saldo = 50;
        }
        else if (t == "cp") {
            saldo = 150;
        }
    }
    public void fecharConta()
    {
      if (saldo > 0) {
        System.out.println("Conta com dinheiro.");
      }
      else if (saldo < 0) {
        System.out.println("Conta em débito.");
      }
      else
      {
        setStatus(false);
      }
    }
    public void depositar(float v) {
       if (status == true) {
           setSaldo(getSaldo()+ v);
       }
       else if (status == false) {
            System.out.println("Impossível depositar.");
       }
    }
    public void sacar(float saque) {
        if (status == true) {
            if (saldo > saque) {
                this.saldo = saldo - saque;
            }
            else{
                System.out.println("Saldo Insuficiente.");
            }
        }
        else
        {
            System.out.println("Impossível Sacar.");
        }
    }
    public void PagarMensal()
    {
        float pagamento;
        if (tipoConta == "cc") {
            pagamento = 12f;
            if (status == true) {
                if(saldo > pagamento){
                    saldo = saldo - pagamento;
                }
                else if(saldo < 0)
                {
                    System.out.println("Saldo Insuficiente.");
                }
                else
                {
                    System.out.println("Impossivel Pagar.");
                }
            }
        }
        else if(tipoConta == "cp")
        {
            pagamento = 20f;
            if (status == true) {
                if(saldo > pagamento){
                    saldo = saldo - pagamento;
                }
                else if(saldo < 0)
                {
                    System.out.println("Saldo Insuficiente.");
                }
                else
                {
                    System.out.println("Impossivel Pagar.");
                }
             }
        }
    }

}
