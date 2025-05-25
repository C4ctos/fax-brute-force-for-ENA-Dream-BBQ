import java.awt.AWTException;
import java.awt.Color;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

//import javax.xml.crypto.dsig.keyinfo.KeyValue;


public class pin {

    public int[] t_numero = {0,0,0,0,0,0,0};


    public void set_t_numero(int[] qualquer){

        t_numero = qualquer;
    }

    
    public void delay(int milis){

        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void novi_mais(){
    
        for(int i = 0; i <= t_numero.length - 1; i++){
    
            if (t_numero[i] >= 10){

                t_numero[i] = 0;
                    
                t_numero[i-1] ++;

                novi_mais();
            }
        }
    }


    public void n_mais(int a_somar){


        for(int i = 0; i < a_somar; i++){

            t_numero[6] += 1;

            novi_mais();
        }
    }


    public void print_numero(){

        for(int i = 0; i < t_numero.length; i++){
            System.out.print(t_numero[i]+",");
        }
        System.out.println(" ");
        
    }


    public void File_create(){
        try {
            File myObj = new File("mem.txt");
            if (myObj.createNewFile()) {
              System.out.println("File created: " + myObj.getName());
            } else {
              System.out.println("File already exists.");
            }
        }catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


    public String File_reader(){

        String data = "";

        try {
            File myObj = new File("mem.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                data = myReader.nextLine();
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return(data);
    }


    public String array_to_string(int[] array){

        String abstoni = "";

        for(int i = 0; i < array.length; i++){
            abstoni += array[i];
        }

        return abstoni;
    }


    public void File_writ(String write){
        try {
            FileWriter myWriter = new FileWriter("mem.txt");
            myWriter.write(write);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


    public void digitas(int dalay){

        boolean dg = false;

        Robot telef = null;
        try{
            telef = new Robot();
        } catch (AWTException e){
            e.printStackTrace();
        }

        for(int i = 0; i < t_numero.length; i++){

            delay(dalay);

            switch (t_numero[i]) {
                case 0:
                telef.keyPress(KeyEvent.VK_0);
                telef.keyRelease(KeyEvent.VK_0);
                    break;
                
                case 1:
                telef.keyPress(KeyEvent.VK_1);
                telef.keyRelease(KeyEvent.VK_1);
                    break;

                case 2:
                telef.keyPress(KeyEvent.VK_2);
                telef.keyRelease(KeyEvent.VK_2);
                    break;

                case 3:
                telef.keyPress(KeyEvent.VK_3);
                telef.keyRelease(KeyEvent.VK_3);
                    break;
                
                case 4:
                telef.keyPress(KeyEvent.VK_4);
                telef.keyRelease(KeyEvent.VK_4);
                    break;

                case 5:
                telef.keyPress(KeyEvent.VK_5);
                telef.keyRelease(KeyEvent.VK_5);
                    break;

                case 6:
                telef.keyPress(KeyEvent.VK_6);
                telef.keyRelease(KeyEvent.VK_6);
                    break;

                case 7:
                telef.keyPress(KeyEvent.VK_7);
                telef.keyRelease(KeyEvent.VK_7);
                    break;

                case 8:
                telef.keyPress(KeyEvent.VK_8);
                telef.keyRelease(KeyEvent.VK_8);
                    break;
                
                case 9:
                telef.keyPress(KeyEvent.VK_9);
                telef.keyRelease(KeyEvent.VK_9);
                    break;

                default:
    
                if(dg == false){
                    System.out.println("digitas não ta de digitas");
                    System.out.println("verifique mim.txt");
                }
                dg = true;
                    break;
            }
        }
    }


    public void File_reader_reader(){

        String to_read = File_reader();

        Integer bs = 0;

        for(int i = 0; i < to_read.length(); i++){

            bs = Integer.valueOf(to_read.charAt(i));

            t_numero[i] = bs - 48;
        }
    }

/*
    public double in_usas(){

        Scanner tempo = new Scanner(System.in);
        Scanner respostas = new Scanner(System.in);

        double tempo_d = 0;
        int resposta_c = 0;

        System.out.println("em sgundos? y/n");
        resposta_c = respostas.nextInt();

        if (resposta_c == 1){
            System.out.println("quantos sgundos?");
            tempo_d = tempo.nextDouble();
            tempo_d = tempo_d * 14;
        }else{

            System.out.println("minutos? y/n");
            resposta_c = respostas.nextInt();

            if (resposta_c == 1){
                System.out.println("quantos minutos?");
                tempo_d = tempo.nextDouble();
                tempo_d = tempo_d * 852;
            }else{

                System.out.println("haras!? y/n");
                resposta_c = respostas.nextInt();

                if (resposta_c == 1){
                    System.out.println("quantas haras?");
                    tempo_d = tempo.nextDouble();
                    tempo_d = tempo_d * 51120;
                }else{
                    System.out.println("eu não vo perguntar quandos dias");
                    delay(900);
                    tempo_d = 0 / 0;
                }
            }
        }

        System.out.println("aguarde...");

        delay(300);

        return tempo_d;
    }
*/

    public int enchergas(int posx, int posy){

        Robot olho = null;
        try{
            olho = new Robot();
        } catch (AWTException e){
            e.printStackTrace();
        }

        Color olhas = olho.getPixelColor(posx, posy);

        return (olhas.getRed());
    }


    public void paras(){

        File_create();
        File_writ(array_to_string(t_numero));

        //System.out.println("---------------------------------");

        Runtime.getRuntime().halt(0);
    }


    public void check_paras(){

        if(enchergas(230, 0) == 0 || enchergas(690, 800) == 225){
            paras();
        }
    }


    public void chack_r_0(int x){

        while (true) {

            System.out.println(": " + x + " :: " + enchergas(690, x));
            x++;

            //System.out.println(": " + x + " :: " + enchergas(x, 0));
            //x++;
        }
    }


    public void m_loop(){

        n_mais(4);
        //print_numero();
        digitas(10);
        check_paras();
    }


    public static void main(String[] args){
     
        pin pin = new pin();

        //pin.delay(3000);
        
        pin.File_reader_reader();


        while (true) {

            pin.m_loop();
            
        }
    }
}