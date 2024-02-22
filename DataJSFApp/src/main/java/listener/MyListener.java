/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listener;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

/**
 *
 * @author root
 */
public class MyListener implements PhaseListener {

    @Override
    public void afterPhase(PhaseEvent event) {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
    if(event.getPhaseId()==PhaseId.RESTORE_VIEW)
    {
     System.out.println(" View Restored");
    }
    if(event.getPhaseId()==PhaseId.APPLY_REQUEST_VALUES)
    {
        System.out.println(" Request Values Applied");
    }
    if(event.getPhaseId()==PhaseId.PROCESS_VALIDATIONS)
    {
        System.out.println(" Validations Applied");
    }
     if(event.getPhaseId()==PhaseId.RENDER_RESPONSE)
    {
        System.out.println(" Response Rendered");
    }
    
    }

    @Override
    public void beforePhase(PhaseEvent event) {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
     if(this.getPhaseId()==PhaseId.RESTORE_VIEW)
    {
     System.out.println(" View Restored");
    }
    if(event.getPhaseId()==PhaseId.APPLY_REQUEST_VALUES)
    {
        System.out.println(" Request Values Applied");
    }
    if(event.getPhaseId()==PhaseId.PROCESS_VALIDATIONS)
    {
        System.out.println(" Validations Applied");
    }
     if(event.getPhaseId()==PhaseId.RENDER_RESPONSE)
    {
        System.out.println(" Response Rendered");
    }
    
    }

    @Override
    public PhaseId getPhaseId() {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    return PhaseId.ANY_PHASE;
    }
    
}
