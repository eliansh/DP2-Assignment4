/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  it.polito.dp2.WF.ActionReader
 *  it.polito.dp2.WF.ActionStatusReader
 *  it.polito.dp2.WF.ProcessReader
 *  it.polito.dp2.WF.WorkflowReader
 */
package it.polito.dp2.WF.lab4.tests;

import it.polito.dp2.WF.ActionReader;
import it.polito.dp2.WF.ActionStatusReader;
import it.polito.dp2.WF.ProcessReader;
import it.polito.dp2.WF.WorkflowReader;
import it.polito.dp2.WF.lab4.tests.ActionStatusReaderImpl;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;

class ProcessReaderImpl
implements ProcessReader {
    private WorkflowReader wfr;
    private GregorianCalendar startTime;
    private List<ActionStatusReader> actions;

    ProcessReaderImpl(WorkflowReader wfr) {
        this.wfr = wfr;
        this.startTime = new GregorianCalendar();
        this.actions = new ArrayList<ActionStatusReader>();
        if (wfr != null) {
            for (ActionReader ar : wfr.getActions()) {
                if (!ar.isAutomaticallyInstantiated()) continue;
                this.actions.add(new ActionStatusReaderImpl(ar.getName()));
            }
        }
    }

    public Calendar getStartTime() {
        return this.startTime;
    }

    public List<ActionStatusReader> getStatus() {
        return null;
    }

    public WorkflowReader getWorkflow() {
        return this.wfr;
    }
}

