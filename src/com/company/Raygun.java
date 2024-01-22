/*
* Classname: Raygun.java
*
* Version information: 1.0
*
* Date: 21/01/2021
*
* Description: The class implements a ray gun for a game
*
* Author: Dr. Shane Wilson
*
*/

package com.company;

public class Raygun {
    //Data members
    private int mChrg; //The maximum charge the Raygun can hold
    private int cChrg; //The current level of charge the Raygun has

    //Class constructors
    public Raygun(int mChrg, int cChrg) {
        this.mChrg = mChrg;
        if (cChrg <0)
            this.cChrg = 0;
        else
            this.cChrg = Math.min(mChrg, cChrg);
    }

    //Getters and Setters
    public int getMaximumCharge() {
        return mChrg;
    }

    public void setMaximumCharge(int mChrg) {
        this.mChrg = mChrg;
    }

    public int getCurrentCharge() {
        return cChrg;
    }

    public void setCurrentCharge(int cChrg) {
        this.cChrg = cChrg;
    }

    // Methods
    public void fireAt(Alien a) {
        /*The gun should only fire if it is charged. Firing the gun will reduce the charge by 1. If the alien isDodging
        * alien.miss() should be called, otherwise alien.hit */
        if (isCharged()) {
            cChrg--; // Opposite of ++
            if (a.isDodging()) {
                a.miss();
            } else {
                a.hit();
            }
        }
    }

    public void recharge() {
        /*Increases the current charge by 1*/
        if (cChrg < mChrg) {
            cChrg++;
        }
    }

    public boolean isCharged() {
        /*Returns true if the gun has a charge*/
        return cChrg > 0;
    }

    public boolean isFullyCharged() {
        /*Returns true if the gun is fully charged*/
        return cChrg == mChrg;
    }
}
