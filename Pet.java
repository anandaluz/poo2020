package tamagotchi;

class Pet {
    String nome;
    private int energia;
    private int maxEnergia;
    private int saciedade;
    private int maxSaciedade;
    private int limpeza;
    private int maxLimpeza;
    private int idade = 0;
    private int diamante = 0;
    private boolean vivo;

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        if(this.energia > maxEnergia){
            this.energia = maxEnergia;
        }
        else if(this.energia <= 0){
            this.vivo = false;
            this.energia = 0;
        }
        else 
            this.energia = energia;
    }

    public int getSaciedade() {
        return saciedade;
    }

    public void setSaciedade(int saciedade) {
        if(this.saciedade > maxSaciedade){
            this.saciedade = maxSaciedade;
        }
        else if(this.saciedade <= 0){
            this.vivo = false;
            this.saciedade = 0;
        }
        else 
            this.saciedade = saciedade;
    }

    public int getLimpeza() {
        return limpeza;
    }

    public void setLimpeza(int limpeza) {
        if(this.limpeza > maxLimpeza){
            this.limpeza = maxLimpeza;
        }
        else if(this.limpeza <= 0){
            this.vivo = false;
            this.limpeza = 0;
        }
        else
            this.limpeza = limpeza;
    }   

    public int getMaxEnergia() {
        return maxEnergia;
    }

    public int getMaxSaciedade() {
        return maxSaciedade;
    }

    public int getMaxLimpeza() {
        return maxLimpeza;
    }

    public int getIdade() {
        return idade;
    }

    public int getDiamante() {
        return diamante;
    }
    
    public void brincar(){
        if(!this.testeVivo())
            return;
        this.setEnergia(this.getEnergia() - 2);
        this.setLimpeza(this.getLimpeza() - 3);
        this.setSaciedade(this.getSaciedade() - 1);
        this.diamante += 1;
        this.idade += 1;
        
    }
    
    public void comer(){
        if(!this.testeVivo())
            return;
        this.setEnergia(this.getEnergia() - 1);
        this.setLimpeza(this.getLimpeza() - 2);
        this.setSaciedade(this.getSaciedade() + 4);
        this.idade += 1;
        
    }
    
    public void dormir(){
        if(!this.testeVivo())
            return;
        if(this.maxEnergia - this.energia < 5){
            System.out.println("Falha: pet sem sono");
            return;
        }
        this.setEnergia(this.getMaxEnergia());        
        this.idade += this.maxEnergia - this.energia;
    }
    
    public void banhar(){
        if(!this.testeVivo())
            return;
        this.setEnergia(this.getEnergia() - 3);
        this.setLimpeza(this.getMaxLimpeza());
        this.setSaciedade(this.getSaciedade() - 1);
        this.idade += 2;
    }
    
    public boolean testeVivo(){
        if(this.vivo){
            return true;
        }
        System.out.println("Falha: pet está morto.");
            return false;
    }
    
    public Pet(String nome, int energia, int saciedade, int limpeza){
        this.nome = nome;
        this.energia = energia;
        this.saciedade = saciedade;
        this.limpeza = limpeza;
        this.maxEnergia = energia;
        this.maxSaciedade = saciedade;
        this.maxLimpeza = limpeza;
        this.vivo = true;
    }

    public String toString(){
        return "["+this.nome+"] E: "+this.energia+"/"+this.maxEnergia+"  S: "+this.saciedade+"/"+this.maxSaciedade+"  L: "+this.limpeza+"/"+this.maxLimpeza
                +"  I: "+this.idade+"  D: "+this.diamante;
    }
}
