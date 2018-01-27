/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lily;

import javafx.scene.image.ImageView;

/**
 *
 * @author Jalap
 */
public class VendeBillede {
    public int id;
    public String navn;
    public ImageView imgv;
    public Boolean hasBeenFlipped = false;
    
    public VendeBillede(int id, String navn, ImageView imgv)
    {
        this.id = id;
        this.navn = navn;
        this.imgv = imgv;
        this.hasBeenFlipped = false;
    }
}
