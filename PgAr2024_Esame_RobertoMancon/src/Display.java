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
}
