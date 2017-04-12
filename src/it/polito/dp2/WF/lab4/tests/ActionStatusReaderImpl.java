/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  it.polito.dp2.WF.ActionStatusReader
 *  it.polito.dp2.WF.Actor
 */
package it.polito.dp2.WF.lab4.tests;

import it.polito.dp2.WF.ActionStatusReader;
import it.polito.dp2.WF.Actor;
import java.util.Calendar;

class ActionStatusReaderImpl
implements ActionStatusReader {
    private String name;

    ActionStatusReaderImpl(String name) {
        this.name = name;
    }

    public String getActionName() {
        return this.name;
    }

    public Actor getActor() {
        return null;
    }

    public Calendar getTerminationTime() {
        return null;
    }

    public boolean isTakenInCharge() {
        return false;
    }

    public boolean isTerminated() {
        return false;
    }
}

