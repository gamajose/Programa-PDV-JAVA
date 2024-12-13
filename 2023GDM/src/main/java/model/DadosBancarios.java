/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Embeddable;

@Embeddable
public class DadosBancarios implements Serializable {

    private static final long serialVersionUID = 1468442634753400293L;

    private boolean poupanca;
    private int conta;
    private int agencia;
    private int digitoConta;
    private int digitoAgencia;
    private String banco;
    private int poupancaVariacao;

    public boolean isPoupanca() {
        return poupanca;
    }

    public void setPoupanca(boolean poupanca) {
        this.poupanca = poupanca;
    }

    public int getConta() {
        return conta;
    }

    public void setConta(int conta) {
        this.conta = conta;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public int getDigitoConta() {
        return digitoConta;
    }

    public void setDigitoConta(int digitoConta) {
        this.digitoConta = digitoConta;
    }

    public int getDigitoAgencia() {
        return digitoAgencia;
    }

    public void setDigitoAgencia(int digitoAgencia) {
        this.digitoAgencia = digitoAgencia;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public int getPoupancaVariacao() {
        return poupancaVariacao;
    }

    public void setPoupancaVariacao(int poupancaVariacao) {
        this.poupancaVariacao = poupancaVariacao;
    }

}
