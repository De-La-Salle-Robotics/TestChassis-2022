package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.Constants.*;

public class LEDSubsystem extends SubsystemBase{
    
    private AddressableLED m_LED_0 = new AddressableLED(LED_0_ID);
    private AddressableLEDBuffer m_LED_0_Buffer = new AddressableLEDBuffer(60);

    private int RED;
    private int GREEN;
    private int BLUE;

    public void initializeLED0(){
        RED = 0;
        GREEN = 0;
        BLUE = 0;
        m_LED_0.setLength(m_LED_0_Buffer.getLength());
        m_LED_0.setData(m_LED_0_Buffer);
        m_LED_0.start();
    }

    public void updateLED0(boolean B_Active, boolean A_Active, boolean X_Active){

        System.out.println(RED);
        System.out.println(GREEN);
        System.out.println(BLUE);

        if (B_Active){
            if (RED >= 255){
                RED = 0;
            }
            else{
                RED++;
            }
        }
        if (A_Active){
            if (GREEN >= 255){
                GREEN = 0;
            }
            else{
                GREEN++;
            }
        }
        if (X_Active){
            if (BLUE >= 255){
                BLUE = 0;
            }
            else{
                BLUE++;
            }
        }

        for (var i = 0; i < m_LED_0_Buffer.getLength(); i++) {
            // Sets the specified LED to the RGB values for red
            m_LED_0_Buffer.setRGB(i, RED, GREEN, BLUE);
         }
    
        m_LED_0.setData(m_LED_0_Buffer);

    }

}
