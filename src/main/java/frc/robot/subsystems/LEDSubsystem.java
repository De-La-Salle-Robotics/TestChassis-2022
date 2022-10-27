package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.Constants.*;

public class LEDSubsystem extends SubsystemBase{
    
    //Not 100% sure if everything here works
    
    private AddressableLED m_LED_0 = new AddressableLED(LED_0_ID);
    //Not sure why it says the default is 60, I think this is how many LEDs are in your strip
    private AddressableLEDBuffer m_LED_0_Buffer = new AddressableLEDBuffer(60);

    private int RED;
    private int GREEN;
    private int BLUE;

    public void initEndLED0(boolean init){
        if (init){
            RED = 0;
            GREEN = 0;
            BLUE = 0;
            m_LED_0.setLength(m_LED_0_Buffer.getLength());
            m_LED_0.setData(m_LED_0_Buffer);
            m_LED_0.start();
            return;
        }
        m_LED_0.stop();
    }

    //Set LEDs to specific values --- most likely to be used for status
    public void setLED0(int R, int G, int B, int H, int S, int V){
        for (var i = 0; i < m_LED_0_Buffer.getLength(); i++) {
            //Applies color to each individual LED
            //Red, Green, Blue (0-255)
            m_LED_0_Buffer.setRGB(i, R, G, B);
            //Hue, Saturation, Brightness (0-180, 0-255, 0-255)
            m_LED_0_Buffer.setHSV(i, H, S, V);
         }
         //Updates LEDs data
         m_LED_0.setData(m_LED_0_Buffer);
    }

    public void updateLED0(boolean B_Active, boolean A_Active, boolean X_Active){

        //If button is active, if R G or B is max then set to 0, else, add 1
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

        //Sets each individual LED to the appropriate color
        for (var i = 0; i < m_LED_0_Buffer.getLength(); i++) {
            m_LED_0_Buffer.setRGB(i, RED, GREEN, BLUE);
         }
    
        //Updates LEDs data
        m_LED_0.setData(m_LED_0_Buffer);

    }

}
