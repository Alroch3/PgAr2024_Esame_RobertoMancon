public class Display {

    public static void mostraSaloon(String[][] saloon){
        for(int i = 0; i < 6; ++i){
            for(int j = 0; j < 6; ++j){
                System.out.print(mostraElementoSaloon(saloon[i][j]) + " | ");
            }
            System.out.print("\n-----------------------------\n");
        }
    }
    

    public static String mostraElementoSaloon(String e){
        if(e.equals("OST")){
            return String.format("%-2s", "X");
        }
        if(e.equals("")){
            return String.format("%-2s", " ");
        }    
        return String.format("%-2s", e);    
    }


    public static void mostraIntroduzione() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mostraIntroduzione'");
    }


    public static void msgMostraCarteDaPescare(String nome, int numCarte) {
        System.out.printf("Giocatore %s devi pescare %d carte\n", nome, numCarte);
    }

    public static void msgNonPuoiEquipaggiare() {
        System.out.println("Non puoi equipaggiare questa carta.\n Puoi equipaggiare solo un'arma alla volta e una sola carta con lo stesso nome");
    }


    public static void msgCartaEquipaggiata(String nomeCarta) {
        System.out.printf("La carta %s è stata equipaggiata!", nomeCarta);
    }


}
