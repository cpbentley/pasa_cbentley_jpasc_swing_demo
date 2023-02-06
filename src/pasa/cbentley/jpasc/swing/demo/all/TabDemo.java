package pasa.cbentley.jpasc.swing.demo.all;

import pasa.cbentley.jpasc.swing.demo.ctx.IPascDemo;
import pasa.cbentley.jpasc.swing.demo.ctx.PascDemoCtx;
import pasa.cbentley.swing.ctx.SwingCtx;
import pasa.cbentley.swing.imytab.AbstractMyTab;

public class TabDemo extends AbstractMyTab {

   private IPascDemo demo;

   public TabDemo(PascDemoCtx pdc, String internalID, IPascDemo demo) {
      super(pdc.getSwingCtx(), internalID);
      this.demo = demo;
   }

   public void disposeTab() {
      // TODO Auto-generated method stub

   }

   public void tabGainFocus() {
      // TODO Auto-generated method stub

   }

   public void tabLostFocus() {
      // TODO Auto-generated method stub

   }

   protected void initTab() {
      demo.initTab(this);
   }

}
