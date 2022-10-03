import java.util.Scanner;

//Método Main

public class CaixaEletrônico {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        System.out.println("Você deseja começar a Operação? (sim ou não)");
        String comecar = leitor.next();
        if (comecar.equals("sim")) {
                ProcedimentoInicial();
            } else {
                System.out.println("Programa Encerrado.");
            }
            leitor.close();
        }

    //Método de Registro do Usuário : 

    public static void ProcedimentoInicial()
    {
        //Atributos : 
        Banco banco = new Banco();
        String username;
        boolean status = true;
        Scanner leitor = new Scanner(System.in);
        float saldo;

        //Executando o código:
        System.out.println("Digite seu nome : ");
        username = leitor.next();
        banco.setDono(username);
        System.out.println("Digite o tipo de conta : (cc para conta corrente ou cp para conta poupança)");
        String tipoConta = leitor.next();
        banco.setTipoConta(tipoConta);
        System.out.println("Diga se está aberta ou fechada");
        String situacaodaconta = leitor.next();
        if (situacaodaconta.equals("aberta")) {
           status = true;
           banco.setStatus(status);
            banco.abrirConta(tipoConta);
        }
        else if (situacaodaconta.equals("fechada")) {
            status = false;
            banco.setStatus(status);
        }
        System.out.println("Digite seu saldo atual : ");
        saldo = leitor.nextFloat();
        ProcedimentoPadrao(saldo,tipoConta,status,username);
        leitor.close(); 
        }

        //Método para Chamada de Cálculos :

        public static void ProcedimentoPadrao(float saldo,String tipoConta,boolean status,String user)
        {
            int contador = 1;
            Banco banco = new Banco();
            Scanner leitor = new Scanner(System.in);
            banco.setSaldo(saldo);
            banco.setTipoConta(tipoConta);
            banco.setStatus(status);
            banco.setDono(user);
            float deposito,saque;
            System.out.println("Qual Operação você deseja? (sacar ou depositar)");
            String acao = leitor.next(); 
            if (acao.equals("depositar")) {
                System.out.println("Digite o valor do depósito : ");
                deposito = leitor.nextFloat();
                banco.depositar(deposito);
            } else if(acao.equals("sacar")) {
                System.out.println("Digite o valor do Saque : ");
                saque = leitor.nextFloat();
                banco.sacar(saque);
            }       
            System.out.println("Seu Saldo atual é de : " + banco.getSaldo() +" reais.");

            //Parte de Reinicio do Programa

            System.out.println("Você deseja Realizar outra operação, "+banco.getDono()+" ?");
            String resposta = leitor.next();
            if (resposta.equals("nao") || resposta.equals("não")) {
                contador = 0;
                System.out.println("Deseja Encerrar o Programa ou apenas mudar de usuário? (digite encerrar ou mduser)");
                String decidir = leitor.next();
                if (decidir.equals("encerrar")) {
                    System.out.println("Programa Finalizado com sucesso, até a próxima.");
                } else if(decidir.equals("mduser")){
                    ProcedimentoInicial();
                }
            }
            while (contador != 0) {
                ProcedimentoPadrao(banco.getSaldo(),banco.getTipoConta(),banco.getStatus(),banco.getDono());
            }
            leitor.close();
        }
    }
    
