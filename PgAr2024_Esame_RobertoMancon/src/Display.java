public class Display {

    public static void mostraSaloon(Giocatore[][] saloon){
        for(int i = 0; i < 6; ++i){
            for(int j = 0; j < 6; ++j){
                System.out.print(mostraElementoSaloon(saloon[i][j]) + " | ");
            }
            System.out.print("\n------------------------\n");
        }
    }

    public static String mostraElementoSaloon(Giocatore g){
        if(g == null){
            return " ";
        }
        return g.toString();            //da modificare
    }
}
