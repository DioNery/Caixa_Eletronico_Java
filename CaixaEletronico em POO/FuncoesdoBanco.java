public interface FuncoesdoBanco
{
    public abstract void abrirConta(String t);
    public abstract void fecharConta();
    public abstract void sacar(float saque);
    public abstract void depositar(float v);
    public abstract void PagarMensal();
    
}