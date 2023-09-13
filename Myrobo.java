package myRoboCode;
import robocode.*;
import java.awt.Color;

/**
 * Myrobo - uma classe por (Gustavo de Sousa Lima)
 */
public class Myrobo extends Robot {
    // Método principal que controla o comportamento do robô
    public void run() {
        // Define as cores do robô
        setColors(Color.darkGray, Color.black, Color.lightGray, Color.white, Color.green);

        // Loop infinito para mover o robô continuamente
        while (true) {
            ahead(100);      // Move para a frente por 100 pixels
            turnRight(90);   // Gira o robô 90 graus para a direita
        }
    }

    // Método chamado quando o robô detecta um inimigo
    public void onScannedRobot(ScannedRobotEvent e) {
        String robotName = e.getName();       // Obtém o nome do robô inimigo
        double distance = e.getDistance();     // Obtém a distância para o robô inimigo

        // Imprime informações sobre o robô inimigo
        System.out.println(robotName + " está a uma distância de " + distance + " unidades.");

        // Verifica se a distância é menor que 135 unidades e decide se deve atirar com mais potência
        if (distance < 135) {
            fire(3);  // Atira com potência 3
        } else {
            fire(1);  // Atira com potência 1
        }
    }

    // Método chamado quando o robô colide com a parede
    public void onHitWall(HitWallEvent e) {
        back(50);         // Move para trás por 50 pixels
        turnRight(90);    // Gira o robô 90 graus para a direita após a colisão com a parede
    }
}
