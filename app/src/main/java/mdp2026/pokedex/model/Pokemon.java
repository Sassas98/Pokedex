package mdp2026.pokedex.model;

import java.io.Serializable;

public class Pokemon  implements Serializable {
    private int numero;
    private String nome;
    private String tipo1;
    private String tipo2;
    private float altezza;
    private float peso;

    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getTipo1() {
        return tipo1;
    }
    public void setTipo1(String tipo1) {
        this.tipo1 = tipo1;
    }
    public String getTipo2() {
        return tipo2;
    }
    public void setTipo2(String tipo2) {
        this.tipo2 = tipo2;
    }
    public float getAltezza() {
        return altezza;
    }
    public void setAltezza(float altezza) {
        this.altezza = altezza;
    }
    public float getPeso() {
        return peso;
    }
    public void setPeso(float peso) {
        this.peso = peso;
    }
    
}