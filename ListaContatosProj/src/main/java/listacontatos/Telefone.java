package listacontatos;


public class Telefone {
    
    private TipoTelefone telTipo;
    private String DDI;
    private String DDD;
    private String numero;
    
    public Telefone(TipoTelefone tipo) {
        this.telTipo = tipo;
    }
    
    public boolean setDDI(String ddi) {
        if(ddi.matches("[0-9]{3}"))
        {
            this.DDI = DDI;
            return true;
        }
        
        return false;
    }
    
    public boolean setDDD(String ddd) {
        if(ddd.matches("[0-9]{2}"))
        {
            this.DDD = DDD;
            return true;
        }
        
        return false;
    }
    
    public boolean setNUM(String num) {
        if(num.matches("[0-9]{4}\\-[0-9]{4}"))
        {
            this.numero = num;
            return true;
        }
        
        return false;
    }
}
