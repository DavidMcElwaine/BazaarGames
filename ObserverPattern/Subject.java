/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bazaar;

/**
 *
 * @author EoinH
 */
public interface Subject {
    void makeObserver(Observer o);
    void updateObserver(double change);
}